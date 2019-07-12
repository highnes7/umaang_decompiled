package f.g.org.org.util;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class SslUtils
{
  public SslUtils() {}
  
  public static KeyManagerFactory getDefaultKeyManagerFactory()
    throws NoSuchAlgorithmException
  {
    return KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
  }
  
  public static TrustManagerFactory getDefaultTrustManagerFactory()
    throws NoSuchAlgorithmException
  {
    return TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
  }
  
  public static KeyManagerFactory getPkixKeyManagerFactory()
    throws NoSuchAlgorithmException
  {
    return KeyManagerFactory.getInstance("PKIX");
  }
  
  public static TrustManagerFactory getPkixTrustManagerFactory()
    throws NoSuchAlgorithmException
  {
    return TrustManagerFactory.getInstance("PKIX");
  }
  
  public static SSLContext getSslContext()
    throws NoSuchAlgorithmException
  {
    return SSLContext.getInstance("SSL");
  }
  
  public static SSLContext getTlsSslContext()
    throws NoSuchAlgorithmException
  {
    return SSLContext.getInstance("TLS");
  }
  
  public static SSLContext initSslContext(SSLContext paramSSLContext, KeyStore paramKeyStore, TrustManagerFactory paramTrustManagerFactory)
    throws GeneralSecurityException
  {
    paramTrustManagerFactory.init(paramKeyStore);
    paramSSLContext.init(null, paramTrustManagerFactory.getTrustManagers(), null);
    return paramSSLContext;
  }
  
  public static HostnameVerifier trustAllHostnameVerifier()
  {
    return new SslUtils.2();
  }
  
  public static SSLContext trustAllSSLContext()
    throws GeneralSecurityException
  {
    SslUtils.1 local1 = new SslUtils.1();
    SSLContext localSSLContext = getTlsSslContext();
    localSSLContext.init(null, (TrustManager[])new TrustManager[] { local1 }, null);
    return localSSLContext;
  }
}
