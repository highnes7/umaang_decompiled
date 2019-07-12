package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.M;
import f.g.org.org.util.Data;
import java.util.List;

public final class Buffer
  extends f.g.org.org.stream.Object
{
  @z
  public String query;
  @z
  public List<M> userDefinedFunctionResources;
  
  static
  {
    Data.nullOf(M.class);
  }
  
  public Buffer() {}
  
  public Buffer clone()
  {
    return (Buffer)super.clone();
  }
  
  public Buffer clone(String paramString, Object paramObject)
  {
    return (Buffer)super.clone(paramString, paramObject);
  }
  
  public String get()
  {
    return query;
  }
  
  public List getBacklog()
  {
    return userDefinedFunctionResources;
  }
  
  public Buffer write(List paramList)
  {
    userDefinedFunctionResources = paramList;
    return this;
  }
  
  public Buffer writeUtf8(String paramString)
  {
    query = paramString;
    return this;
  }
}
