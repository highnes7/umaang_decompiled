package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class ByteVector
  extends f.g.org.org.stream.Object
{
  @z
  public String datasetId;
  @z
  public String projectId;
  @z
  public String tableId;
  
  public ByteVector() {}
  
  public ByteVector a(String paramString)
  {
    datasetId = paramString;
    return this;
  }
  
  public ByteVector clone()
  {
    return (ByteVector)super.clone();
  }
  
  public ByteVector clone(String paramString, Object paramObject)
  {
    return (ByteVector)super.clone(paramString, paramObject);
  }
  
  public String getProjectId()
  {
    return projectId;
  }
  
  public String put()
  {
    return datasetId;
  }
  
  public ByteVector putByte(String paramString)
  {
    tableId = paramString;
    return this;
  }
  
  public ByteVector putUTF8(String paramString)
  {
    projectId = paramString;
    return this;
  }
  
  public String read()
  {
    return tableId;
  }
}
