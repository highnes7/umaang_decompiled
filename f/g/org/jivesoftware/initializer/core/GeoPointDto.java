package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.e;
import f.g.org.org.util.Data;
import java.util.List;

public final class GeoPointDto
  extends f.g.org.org.stream.Object
{
  @z
  public Message errorResult;
  @z
  public List<e> errors;
  @z
  public String state;
  
  static
  {
    Data.nullOf(e.class);
  }
  
  public GeoPointDto() {}
  
  public GeoPointDto clear(String paramString)
  {
    state = paramString;
    return this;
  }
  
  public GeoPointDto clone()
  {
    return (GeoPointDto)super.clone();
  }
  
  public GeoPointDto clone(String paramString, Object paramObject)
  {
    return (GeoPointDto)super.clone(paramString, paramObject);
  }
  
  public List getErrors()
  {
    return errors;
  }
  
  public String getLink()
  {
    return state;
  }
  
  public Message getSymbol()
  {
    return errorResult;
  }
  
  public GeoPointDto setDescription(List paramList)
  {
    errors = paramList;
    return this;
  }
  
  public GeoPointDto setLink(Message paramMessage)
  {
    errorResult = paramMessage;
    return this;
  }
}
