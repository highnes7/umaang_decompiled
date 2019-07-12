package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class Address
  extends f.g.org.org.stream.Object
{
  @z
  public String datasetId;
  @z
  public String projectId;
  
  public Address() {}
  
  public Address clone()
  {
    return (Address)super.clone();
  }
  
  public Address clone(String paramString, Object paramObject)
  {
    return (Address)super.clone(paramString, paramObject);
  }
  
  public Address copy(String paramString)
  {
    projectId = paramString;
    return this;
  }
  
  public Address fromString(String paramString)
  {
    datasetId = paramString;
    return this;
  }
  
  public String getExtendedAddress()
  {
    return projectId;
  }
  
  public String getHostname()
  {
    return datasetId;
  }
}
