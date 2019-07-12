package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.h;
import f.g.b.a.g.z;
import f.g.org.org.dom4j.tree.Element;
import f.g.org.org.stream.digests.JsonWebToken.Payload;
import java.util.List;

@h
public class Property
  extends Element
{
  @z("email")
  public String email;
  @z("email_verified")
  public Object emailVerified;
  @z("hd")
  public String hostedDomain;
  
  public Property() {}
  
  public Property clone()
  {
    return (Property)super.clone();
  }
  
  public Property clone(String paramString)
  {
    issuer = paramString;
    return this;
  }
  
  public Property clone(String paramString, Object paramObject)
  {
    return (Property)super.clone(paramString, paramObject);
  }
  
  public Property copy(Boolean paramBoolean)
  {
    emailVerified = paramBoolean;
    return this;
  }
  
  public Property copy(String paramString)
  {
    return get(paramString);
  }
  
  public Boolean copy()
  {
    Object localObject = emailVerified;
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Boolean)) {
      return (Boolean)localObject;
    }
    return Boolean.valueOf((String)localObject);
  }
  
  public Property from(String paramString)
  {
    authorizedParty = paramString;
    return this;
  }
  
  public Property get(Long paramLong)
  {
    expirationTimeSeconds = paramLong;
    return this;
  }
  
  public Property get(String paramString)
  {
    subject = paramString;
    return this;
  }
  
  public String get()
  {
    return getAttributeValue();
  }
  
  public String getColumnDefinition()
  {
    return email;
  }
  
  public String getEnvironment()
  {
    return hostedDomain;
  }
  
  public String getUserId()
  {
    return getSubject();
  }
  
  public Property of(String paramString)
  {
    return from(paramString);
  }
  
  public Property plus(Long paramLong)
  {
    authorizationTimeSeconds = paramLong;
    return this;
  }
  
  public Property plus(String paramString)
  {
    accessTokenHash = paramString;
    return this;
  }
  
  public Property set(Long paramLong)
  {
    issuedAtTimeSeconds = paramLong;
    return this;
  }
  
  public Property set(Object paramObject)
  {
    audience = paramObject;
    return this;
  }
  
  public Property set(String paramString)
  {
    type = paramString;
    return this;
  }
  
  public Property setAttributes(List paramList)
  {
    methodsReferences = paramList;
    return this;
  }
  
  public Property setFile(String paramString)
  {
    email = paramString;
    return this;
  }
  
  public Property setJwtId(String paramString)
  {
    jwtId = paramString;
    return this;
  }
  
  public Property setName(String paramString)
  {
    nonce = paramString;
    return this;
  }
  
  public Property setNamespace(String paramString)
  {
    classReference = paramString;
    return this;
  }
  
  public Property setNotBeforeTimeSeconds(Long paramLong)
  {
    notBeforeTimeSeconds = paramLong;
    return this;
  }
  
  public Property setPrefix(String paramString)
  {
    hostedDomain = paramString;
    return this;
  }
}
