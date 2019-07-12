package f.g.org.org.apache.util.event;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature.Base64;
import f.g.org.org.util.PemReader;
import f.g.org.org.util.PemReader.Section;
import f.g.org.org.util.SecurityUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

@h
public class Project
{
  public String baseDir;
  
  public Project(String paramString)
  {
    baseDir = paramString;
  }
  
  public byte[] getBaseDir()
    throws IOException
  {
    return PemReader.readFirstSectionAndClose(new StringReader(baseDir), "CERTIFICATE").getBase64DecodedBytes();
  }
  
  public String getName()
    throws IOException
  {
    return Base64.encodeBase64String(getBaseDir());
  }
  
  public X509TrustManager getTrustManager()
    throws IOException, GeneralSecurityException
  {
    KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    localKeyStore.load(null, null);
    localKeyStore.setCertificateEntry("ca", init());
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    localTrustManagerFactory.init(localKeyStore);
    return (X509TrustManager)localTrustManagerFactory.getTrustManagers()[0];
  }
  
  public Certificate init()
    throws IOException, CertificateException
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(getBaseDir());
    return SecurityUtils.getX509CertificateFactory().generateCertificate(localByteArrayInputStream);
  }
}
