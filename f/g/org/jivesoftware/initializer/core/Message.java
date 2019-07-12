package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class Message
  extends f.g.org.org.stream.Object
{
  @z
  public String debugInfo;
  @z
  public String location;
  @z
  public String message;
  @z
  public String reason;
  
  public Message() {}
  
  public Message clone()
  {
    return (Message)super.clone();
  }
  
  public Message clone(String paramString, Object paramObject)
  {
    return (Message)super.clone(paramString, paramObject);
  }
  
  public Message copy(String paramString)
  {
    location = paramString;
    return this;
  }
  
  public String getContent()
  {
    return location;
  }
  
  public Message getInstance(String paramString)
  {
    message = paramString;
    return this;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public Message parse(String paramString)
  {
    reason = paramString;
    return this;
  }
  
  public String readStr()
  {
    return debugInfo;
  }
  
  public Message send(String paramString)
  {
    debugInfo = paramString;
    return this;
  }
  
  public String toXML()
  {
    return reason;
  }
}
