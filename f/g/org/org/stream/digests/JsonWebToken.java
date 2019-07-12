package f.g.org.org.stream.digests;

import f.g.b.a.g.z;
import f.g.org.org.util.Objects;
import f.g.org.org.util.Objects.ToStringHelper;
import java.util.Collections;
import java.util.List;

public class JsonWebToken
{
  public final Header header;
  public final Payload payload;
  
  public JsonWebToken(Header paramHeader, Payload paramPayload)
  {
    if (paramHeader != null)
    {
      header = paramHeader;
      if (paramPayload != null)
      {
        payload = paramPayload;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public Payload get()
  {
    return payload;
  }
  
  public Header getHeader()
  {
    return header;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("header", header).add("payload", payload).toString();
  }
  
  public class Header
    extends f.g.org.org.stream.Object
  {
    @z("cty")
    public String contentType;
    @z("typ")
    public String type;
    
    public Header() {}
    
    public Header clone()
    {
      return (Header)super.clone();
    }
    
    public Header clone(String paramString, Object paramObject)
    {
      return (Header)super.clone(paramString, paramObject);
    }
    
    public final String getContentType()
    {
      return contentType;
    }
    
    public final String getType()
    {
      return type;
    }
    
    public Header setContentType(String paramString)
    {
      contentType = paramString;
      return this;
    }
    
    public Header setType(String paramString)
    {
      type = paramString;
      return this;
    }
  }
  
  public class Payload
    extends f.g.org.org.stream.Object
  {
    @z("aud")
    public Object audience;
    @z("exp")
    public Long expirationTimeSeconds;
    @z("iat")
    public Long issuedAtTimeSeconds;
    @z("iss")
    public String issuer;
    @z("jti")
    public String jwtId;
    @z("nbf")
    public Long notBeforeTimeSeconds;
    @z("sub")
    public String subject;
    @z("typ")
    public String type;
    
    public Payload() {}
    
    public Payload clone()
    {
      return (Payload)super.clone();
    }
    
    public Payload clone(String paramString)
    {
      issuer = paramString;
      return this;
    }
    
    public Payload clone(String paramString, Object paramObject)
    {
      return (Payload)super.clone(paramString, paramObject);
    }
    
    public Payload get(Long paramLong)
    {
      expirationTimeSeconds = paramLong;
      return this;
    }
    
    public Payload get(String paramString)
    {
      subject = paramString;
      return this;
    }
    
    public final Object getAudience()
    {
      return audience;
    }
    
    public final List getAudienceAsList()
    {
      Object localObject = audience;
      if (localObject == null) {
        return Collections.emptyList();
      }
      if ((localObject instanceof String)) {
        return Collections.singletonList((String)localObject);
      }
      return (List)localObject;
    }
    
    public final Long getExpirationTimeSeconds()
    {
      return expirationTimeSeconds;
    }
    
    public final Long getIssuedAtTimeSeconds()
    {
      return issuedAtTimeSeconds;
    }
    
    public final String getIssuer()
    {
      return issuer;
    }
    
    public final String getJwtId()
    {
      return jwtId;
    }
    
    public final Long getNotBeforeTimeSeconds()
    {
      return notBeforeTimeSeconds;
    }
    
    public final String getSubject()
    {
      return subject;
    }
    
    public final String getType()
    {
      return type;
    }
    
    public Payload set(Long paramLong)
    {
      issuedAtTimeSeconds = paramLong;
      return this;
    }
    
    public Payload set(Object paramObject)
    {
      audience = paramObject;
      return this;
    }
    
    public Payload set(String paramString)
    {
      type = paramString;
      return this;
    }
    
    public Payload setJwtId(String paramString)
    {
      jwtId = paramString;
      return this;
    }
    
    public Payload setNotBeforeTimeSeconds(Long paramLong)
    {
      notBeforeTimeSeconds = paramLong;
      return this;
    }
  }
}
