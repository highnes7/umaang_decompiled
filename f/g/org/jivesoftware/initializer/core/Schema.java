package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.H;
import f.g.org.org.util.Data;
import java.util.List;

public final class Schema
  extends f.g.org.org.stream.Object
{
  @z
  public List<H> fields;
  
  static
  {
    Data.nullOf(H.class);
  }
  
  public Schema() {}
  
  public Schema clone()
  {
    return (Schema)super.clone();
  }
  
  public Schema clone(String paramString, Object paramObject)
  {
    return (Schema)super.clone(paramString, paramObject);
  }
  
  public List getFields()
  {
    return fields;
  }
  
  public Schema setPrefix(List paramList)
  {
    fields = paramList;
    return this;
  }
}
