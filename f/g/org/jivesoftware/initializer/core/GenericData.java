package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import java.util.Map;

public final class GenericData
  extends f.g.org.org.stream.Object
{
  @z
  public String insertId;
  @z
  public Map<String, Object> json;
  
  public GenericData() {}
  
  public GenericData clone()
  {
    return (GenericData)super.clone();
  }
  
  public GenericData clone(String paramString, Object paramObject)
  {
    return (GenericData)super.clone(paramString, paramObject);
  }
  
  public Map get()
  {
    return json;
  }
  
  public String remove()
  {
    return insertId;
  }
  
  public GenericData set(String paramString)
  {
    insertId = paramString;
    return this;
  }
  
  public GenericData set(Map paramMap)
  {
    json = paramMap;
    return this;
  }
}
