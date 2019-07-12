package f.g.org.org.util;

import f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public final class SecurityUtils
{
  public SecurityUtils() {}
  
  public static KeyStore getDefaultKeyStore()
    throws KeyStoreException
  {
    return KeyStore.getInstance(KeyStore.getDefaultType());
  }
  
  public static KeyStore getJavaKeyStore()
    throws KeyStoreException
  {
    return KeyStore.getInstance("JKS");
  }
  
  public static KeyStore getPkcs12KeyStore()
    throws KeyStoreException
  {
    return KeyStore.getInstance("PKCS12");
  }
  
  public static PrivateKey getPrivateKey(KeyStore paramKeyStore, String paramString1, String paramString2)
    throws GeneralSecurityException
  {
    return (PrivateKey)paramKeyStore.getKey(paramString1, paramString2.toCharArray());
  }
  
  public static KeyFactory getRsaKeyFactory()
    throws NoSuchAlgorithmException
  {
    return KeyFactory.getInstance("RSA");
  }
  
  public static Signature getSha1WithRsaSignatureAlgorithm()
    throws NoSuchAlgorithmException
  {
    return Signature.getInstance("SHA1withRSA");
  }
  
  public static Signature getSha256WithRsaSignatureAlgorithm()
    throws NoSuchAlgorithmException
  {
    return Signature.getInstance("SHA256withRSA");
  }
  
  public static CertificateFactory getX509CertificateFactory()
    throws CertificateException
  {
    return CertificateFactory.getInstance("X.509");
  }
  
  public static void loadKeyStore(KeyStore paramKeyStore, InputStream paramInputStream, String paramString)
    throws IOException, GeneralSecurityException
  {
    try
    {
      paramKeyStore.load(paramInputStream, paramString.toCharArray());
      paramInputStream.close();
      return;
    }
    catch (Throwable paramKeyStore)
    {
      paramInputStream.close();
      throw paramKeyStore;
    }
  }
  
  public static void loadKeyStoreFromCertificates(KeyStore paramKeyStore, CertificateFactory paramCertificateFactory, InputStream paramInputStream)
    throws GeneralSecurityException
  {
    paramCertificateFactory = paramCertificateFactory.generateCertificates(paramInputStream).iterator();
    int i = 0;
    while (paramCertificateFactory.hasNext())
    {
      paramKeyStore.setCertificateEntry(String.valueOf(i), (Certificate)paramCertificateFactory.next());
      i += 1;
    }
  }
  
  public static PrivateKey loadPrivateKeyFromKeyStore(KeyStore paramKeyStore, InputStream paramInputStream, String paramString1, String paramString2, String paramString3)
    throws IOException, GeneralSecurityException
  {
    loadKeyStore(paramKeyStore, paramInputStream, paramString1);
    return (PrivateKey)paramKeyStore.getKey(paramString2, paramString3.toCharArray());
  }
  
  public static byte[] sign(Signature paramSignature, PrivateKey paramPrivateKey, byte[] paramArrayOfByte)
    throws InvalidKeyException, SignatureException
  {
    paramSignature.initSign(paramPrivateKey);
    paramSignature.update(paramArrayOfByte);
    return paramSignature.sign();
  }
  
  public static X509Certificate verify(Signature paramSignature, X509TrustManager paramX509TrustManager, List paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws InvalidKeyException, SignatureException
  {
    try
    {
      localCertificateFactory = getX509CertificateFactory();
      arrayOfX509Certificate = new X509Certificate[paramList.size()];
      paramList = paramList.iterator();
      i = 0;
    }
    catch (CertificateException paramSignature)
    {
      for (;;)
      {
        try
        {
          CertificateFactory localCertificateFactory;
          int i;
          Object localObject = localCertificateFactory.generateCertificate((InputStream)localObject);
          if (!(localObject instanceof X509Certificate)) {
            return null;
          }
          arrayOfX509Certificate[i] = ((X509Certificate)localObject);
          i += 1;
        }
        catch (CertificateException paramSignature)
        {
          X509Certificate[] arrayOfX509Certificate;
          return null;
        }
        try
        {
          paramX509TrustManager.checkServerTrusted(arrayOfX509Certificate, "RSA");
          paramSignature.initVerify(arrayOfX509Certificate[0].getPublicKey());
          paramSignature.update(paramArrayOfByte2);
          if (paramSignature.verify(paramArrayOfByte1)) {
            return arrayOfX509Certificate[0];
          }
          return null;
        }
        catch (CertificateException paramSignature) {}
      }
      paramSignature = paramSignature;
      return null;
    }
    if (paramList.hasNext()) {
      localObject = new ByteArrayInputStream(Base64.decodeBase64((String)paramList.next()));
    }
    return null;
  }
  
  public static boolean verify(Signature paramSignature, PublicKey paramPublicKey, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws InvalidKeyException, SignatureException
  {
    paramSignature.initVerify(paramPublicKey);
    paramSignature.update(paramArrayOfByte2);
    return paramSignature.verify(paramArrayOfByte1);
  }
}
