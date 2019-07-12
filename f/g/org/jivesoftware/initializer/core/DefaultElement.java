package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class DefaultElement
  extends f.g.org.org.stream.Object
{
  @z
  public Channel children;
  @z
  public String kind;
  
  public DefaultElement() {}
  
  public DefaultElement clone()
  {
    return (DefaultElement)super.clone();
  }
  
  public DefaultElement clone(String paramString, Object paramObject)
  {
    return (DefaultElement)super.clone(paramString, paramObject);
  }
  
  public Channel getChildren()
  {
    return children;
  }
  
  public String getText()
  {
    return kind;
  }
  
  public DefaultElement remove(Channel paramChannel)
  {
    children = paramChannel;
    return this;
  }
  
  public DefaultElement removeNode(String paramString)
  {
    kind = paramString;
    return this;
  }
}
