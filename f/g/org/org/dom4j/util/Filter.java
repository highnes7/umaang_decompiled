package f.g.org.org.dom4j.util;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature.Base64;
import f.g.org.org.util.StringUtils;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@h
public final class Filter
  implements ACRALog
{
  public String token;
  public String value;
  
  public Filter() {}
  
  public String computeSignature(String paramString)
    throws GeneralSecurityException
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = token;
    if (localObject2 != null) {
      ((StringBuilder)localObject1).append(Namespace.toString((String)localObject2));
    }
    ((StringBuilder)localObject1).append('&');
    localObject2 = value;
    if (localObject2 != null) {
      ((StringBuilder)localObject1).append(Namespace.toString((String)localObject2));
    }
    localObject1 = new SecretKeySpec(StringUtils.getBytesUtf8(((StringBuilder)localObject1).toString()), "HmacSHA1");
    localObject2 = Mac.getInstance("HmacSHA1");
    ((Mac)localObject2).init((Key)localObject1);
    return Base64.encodeBase64String(((Mac)localObject2).doFinal(StringUtils.getBytesUtf8(paramString)));
  }
  
  public String getSignatureMethod()
  {
    return "HMAC-SHA1";
  }
}
