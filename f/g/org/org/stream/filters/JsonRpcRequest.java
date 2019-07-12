package f.g.org.org.stream.filters;

import f.g.b.a.g.h;
import f.g.b.a.g.z;
import f.g.org.org.util.GenericData;

@h
public class JsonRpcRequest
  extends GenericData
{
  @z
  public Object id;
  @z
  public final String jsonrpc = "2.0";
  @z
  public String method;
  @z
  public Object params;
  
  public JsonRpcRequest() {}
  
  public JsonRpcRequest clone()
  {
    return (JsonRpcRequest)super.clone();
  }
  
  public JsonRpcRequest clone(String paramString, Object paramObject)
  {
    super.clone(paramString, paramObject);
    return (JsonRpcRequest)this;
  }
  
  public Object getId()
  {
    return id;
  }
  
  public String getMethod()
  {
    return method;
  }
  
  public Object getParameters()
  {
    return params;
  }
  
  public String getVersion()
  {
    return "2.0";
  }
  
  public void setId(Object paramObject)
  {
    id = paramObject;
  }
  
  public void setMethod(String paramString)
  {
    method = paramString;
  }
  
  public void setParameters(Object paramObject)
  {
    params = paramObject;
  }
}
