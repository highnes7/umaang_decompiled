package f.g.org.org.org.parser;

import f.g.b.a.b.f.a;
import f.g.b.a.b.f.a.a;
import f.g.b.a.g.z;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonObjectParser;
import f.g.org.org.stream.JsonObjectParser.Builder;
import f.g.org.org.util.Data;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Element
  extends f.g.org.org.stream.Object
{
  @z
  public int code;
  @z
  public List<a.a> errors;
  @z
  public String message;
  
  static
  {
    Data.nullOf(a.a.class);
  }
  
  public Element() {}
  
  public static Element parse(JsonFactory paramJsonFactory, HttpResponse paramHttpResponse)
    throws IOException
  {
    return (Element)new JsonObjectParser.Builder(paramJsonFactory).setWrapperKeys(Collections.singleton("error")).build().parseAndClose(paramHttpResponse.getContent(), paramHttpResponse.getContentCharset(), a.class);
  }
  
  public final List clean()
  {
    return errors;
  }
  
  public final void clear(String paramString)
  {
    message = paramString;
  }
  
  public Element clone()
  {
    return (Element)super.clone();
  }
  
  public Element clone(String paramString, Object paramObject)
  {
    return (Element)super.clone(paramString, paramObject);
  }
  
  public final int getTitle()
  {
    return code;
  }
  
  public final void setChildren(List paramList)
  {
    errors = paramList;
  }
  
  public final void setText(int paramInt)
  {
    code = paramInt;
  }
  
  public final String write()
  {
    return message;
  }
}
