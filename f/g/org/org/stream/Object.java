package f.g.org.org.stream;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Throwables;
import f.g.org.org.util.GenericData;
import java.io.IOException;
import java.util.AbstractMap;

public class Object
  extends GenericData
  implements Cloneable
{
  public JsonFactory jsonFactory;
  
  public Object() {}
  
  public Object clone()
  {
    return (Object)super.clone();
  }
  
  public Object clone(String paramString, java.lang.Object paramObject)
  {
    super.clone(paramString, paramObject);
    return (Object)this;
  }
  
  public final JsonFactory getFactory()
  {
    return jsonFactory;
  }
  
  public final void put(JsonFactory paramJsonFactory)
  {
    jsonFactory = paramJsonFactory;
  }
  
  public String toPrettyString()
    throws IOException
  {
    JsonFactory localJsonFactory = jsonFactory;
    if (localJsonFactory != null) {
      return localJsonFactory.toPrettyString(this);
    }
    return super.toString();
  }
  
  public String toString()
  {
    java.lang.Object localObject = jsonFactory;
    if (localObject != null) {
      try
      {
        localObject = ((JsonFactory)localObject).toString(this);
        return localObject;
      }
      catch (IOException localIOException)
      {
        Throwables.propagate(localIOException);
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
    }
    return super.toString();
  }
}
