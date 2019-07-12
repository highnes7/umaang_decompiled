package f.g.org.org.http.gzip;

import f.g.org.org.http.HttpTransport;
import f.g.org.org.util.SecurityUtils;
import f.g.org.org.util.SslUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class ApacheHttpTransport
  extends HttpTransport
{
  public final HttpClient httpClient;
  
  public ApacheHttpTransport()
  {
    this(newDefaultHttpClient());
  }
  
  public ApacheHttpTransport(HttpClient paramHttpClient)
  {
    httpClient = paramHttpClient;
    paramHttpClient = paramHttpClient.getParams();
    HttpProtocolParams.setVersion(paramHttpClient, HttpVersion.HTTP_1_1);
    paramHttpClient.setBooleanParameter("http.protocol.handle-redirects", false);
  }
  
  public static DefaultHttpClient newDefaultHttpClient()
  {
    return newDefaultHttpClient(SSLSocketFactory.getSocketFactory(), newDefaultHttpParams(), ProxySelector.getDefault());
  }
  
  public static DefaultHttpClient newDefaultHttpClient(SSLSocketFactory paramSSLSocketFactory, HttpParams paramHttpParams, ProxySelector paramProxySelector)
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", new PlainSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", paramSSLSocketFactory, 443));
    paramSSLSocketFactory = new DefaultHttpClient(new ThreadSafeClientConnManager(paramHttpParams, localSchemeRegistry), paramHttpParams);
    paramSSLSocketFactory.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
    if (paramProxySelector != null) {
      paramSSLSocketFactory.setRoutePlanner(new ProxySelectorRoutePlanner(localSchemeRegistry, paramProxySelector));
    }
    return paramSSLSocketFactory;
  }
  
  public static HttpParams newDefaultHttpParams()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 200);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(20));
    return localBasicHttpParams;
  }
  
  public ApacheHttpRequest buildRequest(String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public HttpClient getHttpClient()
  {
    return httpClient;
  }
  
  public void shutdown()
  {
    httpClient.getConnectionManager().shutdown();
  }
  
  public boolean supportsMethod(String paramString)
  {
    return true;
  }
  
  public final class Builder
  {
    public HttpParams params = ApacheHttpTransport.newDefaultHttpParams();
    public ProxySelector proxySelector = ProxySelector.getDefault();
    public SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
    
    public Builder() {}
    
    public ApacheHttpTransport build()
    {
      return new ApacheHttpTransport(ApacheHttpTransport.newDefaultHttpClient(socketFactory, params, proxySelector));
    }
    
    public Builder doNotValidateCertificate()
      throws GeneralSecurityException
    {
      socketFactory = new SSLSocketFactoryExtension(SslUtils.trustAllSSLContext());
      socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      return this;
    }
    
    public HttpParams getHttpParams()
    {
      return params;
    }
    
    public SSLSocketFactory getSSLSocketFactory()
    {
      return socketFactory;
    }
    
    public Builder setProxy(HttpHost paramHttpHost)
    {
      ConnRouteParams.setDefaultProxy(params, paramHttpHost);
      if (paramHttpHost != null) {
        proxySelector = null;
      }
      return this;
    }
    
    public Builder setProxySelector(ProxySelector paramProxySelector)
    {
      proxySelector = paramProxySelector;
      if (paramProxySelector != null) {
        ConnRouteParams.setDefaultProxy(params, null);
      }
      return this;
    }
    
    public Builder setSocketFactory(SSLSocketFactory paramSSLSocketFactory)
    {
      if (paramSSLSocketFactory != null)
      {
        socketFactory = paramSSLSocketFactory;
        return this;
      }
      throw new NullPointerException();
    }
    
    public Builder trustCertificates(KeyStore paramKeyStore)
      throws GeneralSecurityException
    {
      SSLContext localSSLContext = SslUtils.getTlsSslContext();
      SslUtils.initSslContext(localSSLContext, paramKeyStore, SslUtils.getPkixTrustManagerFactory());
      return setSocketFactory(new SSLSocketFactoryExtension(localSSLContext));
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
