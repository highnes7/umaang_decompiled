package f.g.org.org.http.parse;

import f.g.org.org.http.HttpTransport;
import f.g.org.org.util.Preconditions;
import f.g.org.org.util.SecurityUtils;
import f.g.org.org.util.SslUtils;
import f.g.org.org.util.SslUtils.2;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class NetHttpTransport
  extends HttpTransport
{
  public static final String[] SUPPORTED_METHODS = { "DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE" };
  public final ConnectionFactory connectionFactory;
  public final HostnameVerifier hostnameVerifier;
  public final SSLSocketFactory sslSocketFactory;
  
  static
  {
    Arrays.sort(SUPPORTED_METHODS);
  }
  
  public NetHttpTransport()
  {
    this(null, null, null);
  }
  
  public NetHttpTransport(ConnectionFactory paramConnectionFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier) {}
  
  public NetHttpTransport(Proxy paramProxy, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier)
  {
    this(new HurlStack(paramProxy), paramSSLSocketFactory, paramHostnameVerifier);
  }
  
  public NetHttpRequest buildRequest(String paramString1, String paramString2)
    throws IOException
  {
    Preconditions.checkArgument(supportsMethod(paramString1), "HTTP method %s not supported", new Object[] { paramString1 });
    paramString2 = new URL(paramString2);
    paramString2 = connectionFactory.openConnection(paramString2);
    paramString2.setRequestMethod(paramString1);
    if ((paramString2 instanceof HttpsURLConnection))
    {
      paramString1 = (HttpsURLConnection)paramString2;
      Object localObject = hostnameVerifier;
      if (localObject != null) {
        paramString1.setHostnameVerifier((HostnameVerifier)localObject);
      }
      localObject = sslSocketFactory;
      if (localObject != null) {
        paramString1.setSSLSocketFactory((SSLSocketFactory)localObject);
      }
    }
    return new NetHttpRequest(paramString2);
  }
  
  public boolean supportsMethod(String paramString)
  {
    return Arrays.binarySearch(SUPPORTED_METHODS, paramString) >= 0;
  }
  
  public final class Builder
  {
    public ConnectionFactory connectionFactory;
    public HostnameVerifier hostnameVerifier;
    public Proxy proxy;
    public SSLSocketFactory sslSocketFactory;
    
    public Builder() {}
    
    public NetHttpTransport build()
    {
      Proxy localProxy = proxy;
      if (localProxy == null) {
        return new NetHttpTransport(connectionFactory, sslSocketFactory, hostnameVerifier);
      }
      return new NetHttpTransport(localProxy, sslSocketFactory, hostnameVerifier);
    }
    
    public Builder doNotValidateCertificate()
      throws GeneralSecurityException
    {
      hostnameVerifier = new SslUtils.2();
      sslSocketFactory = SslUtils.trustAllSSLContext().getSocketFactory();
      return this;
    }
    
    public HostnameVerifier getHostnameVerifier()
    {
      return hostnameVerifier;
    }
    
    public SSLSocketFactory getSslSocketFactory()
    {
      return sslSocketFactory;
    }
    
    public Builder setConnectionFactory(ConnectionFactory paramConnectionFactory)
    {
      connectionFactory = paramConnectionFactory;
      return this;
    }
    
    public Builder setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
    {
      hostnameVerifier = paramHostnameVerifier;
      return this;
    }
    
    public Builder setProxy(Proxy paramProxy)
    {
      proxy = paramProxy;
      return this;
    }
    
    public Builder setSslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
    {
      sslSocketFactory = paramSSLSocketFactory;
      return this;
    }
    
    public Builder trustCertificates(KeyStore paramKeyStore)
      throws GeneralSecurityException
    {
      SSLContext localSSLContext = SslUtils.getTlsSslContext();
      SslUtils.initSslContext(localSSLContext, paramKeyStore, SslUtils.getPkixTrustManagerFactory());
      return setSslSocketFactory(localSSLContext.getSocketFactory());
    }
    
    public Builder trustCertificatesFromJavaKeyStore(InputStream paramInputStream, String paramString)
      throws GeneralSecurityException, IOException
    {
      KeyStore localKeyStore = SecurityUtils.getJavaKeyStore();
      SecurityUtils.loadKeyStore(localKeyStore, paramInputStream, paramString);
      return trustCertificates(localKeyStore);
    }
    
    public Builder trustCertificatesFromStream(InputStream paramInputStream)
      throws GeneralSecurityException, IOException
    {
      KeyStore localKeyStore = SecurityUtils.getJavaKeyStore();
      localKeyStore.load(null, null);
      SecurityUtils.loadKeyStoreFromCertificates(localKeyStore, SecurityUtils.getX509CertificateFactory(), paramInputStream);
      return trustCertificates(localKeyStore);
    }
  }
}
