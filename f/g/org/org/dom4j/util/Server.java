package f.g.org.org.dom4j.util;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature.Base64;
import f.g.org.org.util.SecurityUtils;
import f.g.org.org.util.StringUtils;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;

@h
public final class Server
  implements ACRALog
{
  public PrivateKey privateKey;
  
  public Server() {}
  
  public String computeSignature(String paramString)
    throws GeneralSecurityException
  {
    Signature localSignature = SecurityUtils.getSha1WithRsaSignatureAlgorithm();
    paramString = StringUtils.getBytesUtf8(paramString);
    return Base64.encodeBase64String(SecurityUtils.sign(localSignature, privateKey, paramString));
  }
  
  public String getSignatureMethod()
  {
    return "RSA-SHA1";
  }
}
