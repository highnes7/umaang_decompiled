package f.g.org.org.dom4j.tree;

import f.g.b.a.g.h;
import f.g.b.a.g.z;
import f.g.org.org.stream.digests.JsonWebToken.Payload;
import java.util.List;

@h
public class Element
  extends JsonWebToken.Payload
{
  @z("at_hash")
  public String accessTokenHash;
  @z("auth_time")
  public Long authorizationTimeSeconds;
  @z("azp")
  public String authorizedParty;
  @z("acr")
  public String classReference;
  @z("amr")
  public List<String> methodsReferences;
  @z
  public String nonce;
  
  public Element() {}
  
  public Element clone()
  {
    return (Element)super.clone();
  }
  
  public Element clone(String paramString)
  {
    issuer = paramString;
    return this;
  }
  
  public Element clone(String paramString, Object paramObject)
  {
    return (Element)super.clone(paramString, paramObject);
  }
  
  public Element from(String paramString)
  {
    authorizedParty = paramString;
    return this;
  }
  
  public Element get(Long paramLong)
  {
    expirationTimeSeconds = paramLong;
    return this;
  }
  
  public Element get(String paramString)
  {
    subject = paramString;
    return this;
  }
  
  public final String getAttributeValue()
  {
    return authorizedParty;
  }
  
  public final List getChildren()
  {
    return methodsReferences;
  }
  
  public final String getContentEnd()
  {
    return nonce;
  }
  
  public final String getNamespace()
  {
    return accessTokenHash;
  }
  
  public final String getRoot()
  {
    return classReference;
  }
  
  public final Long hasAttributes()
  {
    return authorizationTimeSeconds;
  }
  
  public Element plus(Long paramLong)
  {
    authorizationTimeSeconds = paramLong;
    return this;
  }
  
  public Element plus(String paramString)
  {
    accessTokenHash = paramString;
    return this;
  }
  
  public Element set(Long paramLong)
  {
    issuedAtTimeSeconds = paramLong;
    return this;
  }
  
  public Element set(Object paramObject)
  {
    audience = paramObject;
    return this;
  }
  
  public Element set(String paramString)
  {
    type = paramString;
    return this;
  }
  
  public Element setAttributes(List paramList)
  {
    methodsReferences = paramList;
    return this;
  }
  
  public Element setJwtId(String paramString)
  {
    jwtId = paramString;
    return this;
  }
  
  public Element setName(String paramString)
  {
    nonce = paramString;
    return this;
  }
  
  public Element setNamespace(String paramString)
  {
    classReference = paramString;
    return this;
  }
  
  public Element setNotBeforeTimeSeconds(Long paramLong)
  {
    notBeforeTimeSeconds = paramLong;
    return this;
  }
}
