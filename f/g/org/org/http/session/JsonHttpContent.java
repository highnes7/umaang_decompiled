package f.g.org.org.http.session;

import f.g.org.org.http.AbstractHttpContent;
import f.g.org.org.http.HttpMediaType;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonGenerator;
import java.io.IOException;
import java.io.OutputStream;

public class JsonHttpContent
  extends AbstractHttpContent
{
  public final Object data;
  public final JsonFactory jsonFactory;
  public String wrapperKey;
  
  public JsonHttpContent(JsonFactory paramJsonFactory, Object paramObject)
  {
    super("application/json; charset=UTF-8");
    if (paramJsonFactory != null)
    {
      jsonFactory = paramJsonFactory;
      if (paramObject != null)
      {
        data = paramObject;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public final Object getData()
  {
    return data;
  }
  
  public final JsonFactory getJsonFactory()
  {
    return jsonFactory;
  }
  
  public final String getWrapperKey()
  {
    return wrapperKey;
  }
  
  public JsonHttpContent setMediaType(HttpMediaType paramHttpMediaType)
  {
    mediaType = paramHttpMediaType;
    return this;
  }
  
  public JsonHttpContent setWrapperKey(String paramString)
  {
    wrapperKey = paramString;
    return this;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = jsonFactory.createJsonGenerator(paramOutputStream, getCharset());
    if (wrapperKey != null)
    {
      paramOutputStream.writeStartObject();
      paramOutputStream.writeFieldName(wrapperKey);
    }
    paramOutputStream.serialize(data);
    if (wrapperKey != null) {
      paramOutputStream.writeEndObject();
    }
    paramOutputStream.flush();
  }
}
