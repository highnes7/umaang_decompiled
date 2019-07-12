package f.g.org.org.dom4j.util;

import f.g.b.a.g.h;
import f.g.b.a.g.z;
import f.g.org.org.http.GenericUrl;

@h
public class User
  extends GenericUrl
{
  @z("oauth_token")
  public String token;
  @z("oauth_verifier")
  public String verifier;
  
  public User(String paramString)
  {
    super(paramString);
  }
}
