package f.g.org.org.dom4j.asm;

import f.g.b.a.g.z;

public class Plot
  extends f.g.org.org.stream.Object
{
  @z("access_token")
  public String accessToken;
  @z("expires_in")
  public Long expiresInSeconds;
  @z("refresh_token")
  public String refreshToken;
  @z
  public String scope;
  @z("token_type")
  public String tokenType;
  
  public Plot() {}
  
  public Plot a(Long paramLong)
  {
    expiresInSeconds = paramLong;
    return this;
  }
  
  public Plot a(String paramString)
  {
    if (paramString != null)
    {
      tokenType = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final Long a()
  {
    return expiresInSeconds;
  }
  
  public Plot b(String paramString)
  {
    if (paramString != null)
    {
      accessToken = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String b()
  {
    return accessToken;
  }
  
  public Plot clone()
  {
    return (Plot)super.clone();
  }
  
  public Plot clone(String paramString, Object paramObject)
  {
    return (Plot)super.clone(paramString, paramObject);
  }
  
  public final String getParent()
  {
    return scope;
  }
  
  public final String getTitle()
  {
    return refreshToken;
  }
  
  public final String position()
  {
    return tokenType;
  }
  
  public Plot putByte(String paramString)
  {
    scope = paramString;
    return this;
  }
  
  public Plot putLong(String paramString)
  {
    refreshToken = paramString;
    return this;
  }
}
