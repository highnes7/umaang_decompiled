package f.g.org.org.http.gzip;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public final class SSLSocketFactoryExtension
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  public final javax.net.ssl.SSLSocketFactory socketFactory;
  
  public SSLSocketFactoryExtension(SSLContext paramSSLContext)
    throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException
  {
    super(null);
    socketFactory = paramSSLContext.getSocketFactory();
  }
  
  public Socket createSocket()
    throws IOException
  {
    return socketFactory.createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    paramSocket = (SSLSocket)socketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    getHostnameVerifier().verify(paramString, paramSocket);
    return paramSocket;
  }
}
