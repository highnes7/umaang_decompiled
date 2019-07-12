package f.g.org.org.org.parser;

import f.g.b.a.g.z;

public class Document
  extends f.g.org.org.stream.Object
{
  @z
  public String domain;
  @z
  public String location;
  @z
  public String locationType;
  @z
  public String message;
  @z
  public String reason;
  
  public Document() {}
  
  public Document clone()
  {
    return (Document)super.clone();
  }
  
  public Document clone(String paramString, Object paramObject)
  {
    return (Document)super.clone(paramString, paramObject);
  }
  
  public final String getBaseURI()
  {
    return reason;
  }
  
  public final String getDomain()
  {
    return domain;
  }
  
  public final String getLocationType()
  {
    return locationType;
  }
  
  public final String getProperty()
  {
    return location;
  }
  
  public final void init(String paramString)
  {
    domain = paramString;
  }
  
  public final void parse(String paramString)
  {
    message = paramString;
  }
  
  public final void release(String paramString)
  {
    reason = paramString;
  }
  
  public final void setProperty(String paramString)
  {
    location = paramString;
  }
  
  public final void setStandalone(String paramString)
  {
    locationType = paramString;
  }
  
  public final String write()
  {
    return message;
  }
}
