package f.g.org.jivesoftware.initializer;

import f.g.b.a.b.i.a.b;
import f.g.b.a.g.z;
import f.g.org.org.http.HttpHeaders;

public abstract class Element<T>
  extends b<T>
{
  @z
  public String contentEnd;
  @z
  public String fields;
  @z("oauth_token")
  public String oauthToken;
  @z
  public Boolean prettyPrint;
  @z
  public String quotaUser;
  @z
  public String startTag;
  @z
  public String userIp;
  
  public Element(f paramF, String paramString1, String paramString2, Object paramObject, Class paramClass)
  {
    super(paramF, paramString1, paramString2, paramObject, paramClass);
  }
  
  public Element addAttributes(Boolean paramBoolean)
  {
    prettyPrint = paramBoolean;
    return this;
  }
  
  public Element addAttributes(String paramString)
  {
    fields = paramString;
    return this;
  }
  
  public Element addSuffix(String paramString)
  {
    quotaUser = paramString;
    return this;
  }
  
  public Element addUrls(String paramString)
  {
    startTag = paramString;
    return this;
  }
  
  public Element clone(String paramString, Object paramObject)
  {
    return (Element)super.clone(paramString, paramObject);
  }
  
  public final f equals()
  {
    return (f)this$0;
  }
  
  public String getAttributeName()
  {
    return userIp;
  }
  
  public String getContentEnd()
  {
    return contentEnd;
  }
  
  public Element getItemForId(String paramString)
  {
    contentEnd = paramString;
    return this;
  }
  
  public String getNamespace()
  {
    return quotaUser;
  }
  
  public String getNamespaceUri()
  {
    return oauthToken;
  }
  
  public String getStartTag()
  {
    return startTag;
  }
  
  public Boolean isBlock()
  {
    return prettyPrint;
  }
  
  public Element removePlaylist(String paramString)
  {
    oauthToken = paramString;
    return this;
  }
  
  public Element setAttribute(HttpHeaders paramHttpHeaders)
  {
    attributes = paramHttpHeaders;
    return this;
  }
  
  public Element setAttributes(boolean paramBoolean)
  {
    value = paramBoolean;
    return this;
  }
  
  public String write()
  {
    return fields;
  }
  
  public Element xor(String paramString)
  {
    userIp = paramString;
    return this;
  }
}
