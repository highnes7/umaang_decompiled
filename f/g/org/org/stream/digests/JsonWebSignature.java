package f.g.org.org.stream.digests;

import f.g.b.a.g.z;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature.Base64;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.SecurityUtils;
import f.g.org.org.util.StringUtils;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class JsonWebSignature
  extends JsonWebToken
{
  public final byte[] signatureBytes;
  public final byte[] signedContentBytes;
  
  public JsonWebSignature(Header paramHeader, JsonWebToken.Payload paramPayload, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(paramHeader, paramPayload);
    if (paramArrayOfByte1 != null)
    {
      signatureBytes = paramArrayOfByte1;
      if (paramArrayOfByte2 != null)
      {
        signedContentBytes = paramArrayOfByte2;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static X509TrustManager getTrustManager()
  {
    try
    {
      Object localObject1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject1).init(null);
      localObject1 = ((TrustManagerFactory)localObject1).getTrustManagers();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 instanceof X509TrustManager)) {
          return (X509TrustManager)localObject2;
        }
        i += 1;
      }
      return null;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return null;
    }
    catch (KeyStoreException localKeyStoreException) {}
    return null;
  }
  
  public static JsonWebSignature parse(JsonFactory paramJsonFactory, String paramString)
    throws IOException
  {
    return new f(paramJsonFactory).parse(paramString);
  }
  
  public static f parser(JsonFactory paramJsonFactory)
  {
    return new f(paramJsonFactory);
  }
  
  public static String signUsingRsaSha256(PrivateKey paramPrivateKey, JsonFactory paramJsonFactory, Header paramHeader, JsonWebToken.Payload paramPayload)
    throws GeneralSecurityException, IOException
  {
    paramHeader = String.valueOf(Base64.encodeBase64URLSafeString(paramJsonFactory.toByteArray(paramHeader)));
    paramJsonFactory = String.valueOf(Base64.encodeBase64URLSafeString(paramJsonFactory.toByteArray(paramPayload)));
    int i = paramHeader.length();
    paramJsonFactory = f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramJsonFactory.length() + (i + 1)), paramHeader, ".", paramJsonFactory);
    paramHeader = StringUtils.getBytesUtf8(paramJsonFactory);
    paramPrivateKey = SecurityUtils.sign(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), paramPrivateKey, paramHeader);
    paramJsonFactory = String.valueOf(paramJsonFactory);
    paramPrivateKey = String.valueOf(Base64.encodeBase64URLSafeString(paramPrivateKey));
    i = paramJsonFactory.length();
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramPrivateKey.length() + (i + 1)), paramJsonFactory, ".", paramPrivateKey);
  }
  
  public Header getHeader()
  {
    return (Header)header;
  }
  
  public final byte[] getSignatureBytes()
  {
    return signatureBytes;
  }
  
  public final byte[] getSignedContentBytes()
  {
    return signedContentBytes;
  }
  
  public final X509Certificate verifySignature()
    throws GeneralSecurityException
  {
    X509TrustManager localX509TrustManager = getTrustManager();
    if (localX509TrustManager == null) {
      return null;
    }
    return verifySignature(localX509TrustManager);
  }
  
  public final X509Certificate verifySignature(X509TrustManager paramX509TrustManager)
    throws GeneralSecurityException
  {
    List localList = getHeader().getX509Certificates();
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return null;
      }
      if ("RS256".equals(getHeader().getAlgorithm())) {
        return SecurityUtils.verify(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), paramX509TrustManager, localList, signatureBytes, signedContentBytes);
      }
    }
    return null;
  }
  
  public final boolean verifySignature(PublicKey paramPublicKey)
    throws GeneralSecurityException
  {
    if ("RS256".equals(getHeader().getAlgorithm())) {
      return SecurityUtils.verify(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), paramPublicKey, signatureBytes, signedContentBytes);
    }
    return false;
  }
  
  public class Header
    extends JsonWebToken.Header
  {
    @z("alg")
    public String algorithm;
    @z("crit")
    public List<String> critical;
    @z("jwk")
    public String jwk;
    @z("jku")
    public String jwkUrl;
    @z("kid")
    public String keyId;
    @z("x5c")
    public List<String> x509Certificates;
    @z("x5t")
    public String x509Thumbprint;
    @z("x5u")
    public String x509Url;
    
    public Header() {}
    
    public Header clone()
    {
      return (Header)super.clone();
    }
    
    public Header clone(String paramString, Object paramObject)
    {
      return (Header)super.clone(paramString, paramObject);
    }
    
    public final String getAlgorithm()
    {
      return algorithm;
    }
    
    public final List getCritical()
    {
      return critical;
    }
    
    public final String getJwk()
    {
      return jwk;
    }
    
    public final String getJwkUrl()
    {
      return jwkUrl;
    }
    
    public final String getKeyId()
    {
      return keyId;
    }
    
    public final String getX509Certificate()
    {
      List localList = x509Certificates;
      if ((localList != null) && (!localList.isEmpty())) {
        return (String)x509Certificates.get(0);
      }
      return null;
    }
    
    public final List getX509Certificates()
    {
      return x509Certificates;
    }
    
    public final String getX509Thumbprint()
    {
      return x509Thumbprint;
    }
    
    public final String getX509Url()
    {
      return x509Url;
    }
    
    public Header setAlgorithm(String paramString)
    {
      algorithm = paramString;
      return this;
    }
    
    public Header setCritical(List paramList)
    {
      critical = paramList;
      return this;
    }
    
    public Header setJwk(String paramString)
    {
      jwk = paramString;
      return this;
    }
    
    public Header setJwkUrl(String paramString)
    {
      jwkUrl = paramString;
      return this;
    }
    
    public Header setKeyId(String paramString)
    {
      keyId = paramString;
      return this;
    }
    
    public Header setType(String paramString)
    {
      type = paramString;
      return this;
    }
    
    public Header setX509Certificate(String paramString)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      x509Certificates = localArrayList;
      return this;
    }
    
    public Header setX509Certificate(List paramList)
    {
      x509Certificates = paramList;
      return this;
    }
    
    public Header setX509Thumbprint(String paramString)
    {
      x509Thumbprint = paramString;
      return this;
    }
    
    public Header setX509Url(String paramString)
    {
      x509Url = paramString;
      return this;
    }
  }
}
