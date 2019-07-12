package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class GZIPHeader
  extends f.g.org.org.stream.Object
{
  @z
  public String domain;
  @z
  public String groupByEmail;
  @z
  public String role;
  @z
  public String specialGroup;
  @z
  public String userByEmail;
  @z
  public ByteVector view;
  
  public GZIPHeader() {}
  
  public GZIPHeader clone()
  {
    return (GZIPHeader)super.clone();
  }
  
  public GZIPHeader clone(String paramString, Object paramObject)
  {
    return (GZIPHeader)super.clone(paramString, paramObject);
  }
  
  public String getComment()
  {
    return specialGroup;
  }
  
  public String getName()
  {
    return domain;
  }
  
  public String getOS()
  {
    return userByEmail;
  }
  
  public String getRole()
  {
    return role;
  }
  
  public GZIPHeader init(String paramString)
  {
    role = paramString;
    return this;
  }
  
  public GZIPHeader put(String paramString)
  {
    specialGroup = paramString;
    return this;
  }
  
  public String put()
  {
    return groupByEmail;
  }
  
  public ByteVector setComment()
  {
    return view;
  }
  
  public GZIPHeader setComment(ByteVector paramByteVector)
  {
    view = paramByteVector;
    return this;
  }
  
  public GZIPHeader setComment(String paramString)
  {
    groupByEmail = paramString;
    return this;
  }
  
  public GZIPHeader setName(String paramString)
  {
    domain = paramString;
    return this;
  }
  
  public GZIPHeader writeLong(String paramString)
  {
    userByEmail = paramString;
    return this;
  }
}
