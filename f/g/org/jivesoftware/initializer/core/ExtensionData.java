package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class ExtensionData
  extends f.g.org.org.stream.Object
{
  @z
  public String jobId;
  @z
  public String projectId;
  
  public ExtensionData() {}
  
  public ExtensionData a(String paramString)
  {
    jobId = paramString;
    return this;
  }
  
  public String clean()
  {
    return jobId;
  }
  
  public ExtensionData clone()
  {
    return (ExtensionData)super.clone();
  }
  
  public ExtensionData clone(String paramString, Object paramObject)
  {
    return (ExtensionData)super.clone(paramString, paramObject);
  }
  
  public ExtensionData expandedTitle(String paramString)
  {
    projectId = paramString;
    return this;
  }
  
  public String expandedTitle()
  {
    return projectId;
  }
}
