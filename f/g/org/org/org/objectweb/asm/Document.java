package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.z;
import java.util.List;

public final class Document
  extends f.g.org.org.stream.Object
{
  @z("auth_uri")
  public String authUri;
  @z("client_id")
  public String clientId;
  @z("client_secret")
  public String clientSecret;
  @z("redirect_uris")
  public List<String> redirectUris;
  @z("token_uri")
  public String tokenUri;
  
  public Document() {}
  
  public Document addComment(String paramString)
  {
    authUri = paramString;
    return this;
  }
  
  public Document addContent(String paramString)
  {
    clientSecret = paramString;
    return this;
  }
  
  public Document clone()
  {
    return (Document)super.clone();
  }
  
  public Document clone(String paramString, Object paramObject)
  {
    return (Document)super.clone(paramString, paramObject);
  }
  
  public String getJavaScript_onUnLoad()
  {
    return tokenUri;
  }
  
  public String getPageNumber()
  {
    return authUri;
  }
  
  public String getProperty()
  {
    return clientSecret;
  }
  
  public List getRow()
  {
    return redirectUris;
  }
  
  public String location()
  {
    return clientId;
  }
  
  public Document outputSettings(String paramString)
  {
    clientId = paramString;
    return this;
  }
  
  public Document setProperty(String paramString)
  {
    tokenUri = paramString;
    return this;
  }
  
  public Document setProperty(List paramList)
  {
    redirectUris = paramList;
    return this;
  }
}
