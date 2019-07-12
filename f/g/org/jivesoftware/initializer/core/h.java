package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class h
  extends f.g.org.org.stream.Object
{
  @z
  public String a;
  @z
  public Address datasetReference;
  @z
  public String friendlyName;
  @z
  public String kind;
  
  public h() {}
  
  public h a(Address paramAddress)
  {
    datasetReference = paramAddress;
    return this;
  }
  
  public h a(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public h b(String paramString)
  {
    a = paramString;
    return this;
  }
  
  public h c(String paramString)
  {
    friendlyName = paramString;
    return this;
  }
  
  public String c()
  {
    return a;
  }
  
  public h clone()
  {
    return (h)super.clone();
  }
  
  public h clone(String paramString, Object paramObject)
  {
    return (h)super.clone(paramString, paramObject);
  }
  
  public Address f()
  {
    return datasetReference;
  }
  
  public String getFriendlyName()
  {
    return friendlyName;
  }
  
  public String getGroupId()
  {
    return kind;
  }
}
