package f.g.org.org.http;

import f.g.org.org.util.Data;
import f.g.org.org.util.FieldInfo;
import f.g.org.org.util.Types;
import f.g.org.org.util.xml.CharEscapers;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UrlEncodedContent
  extends AbstractHttpContent
{
  public Object data;
  
  public UrlEncodedContent(Object paramObject)
  {
    super(UrlEncodedParser.MEDIA_TYPE);
    setData(paramObject);
  }
  
  public static boolean appendParam(boolean paramBoolean, Writer paramWriter, String paramString, Object paramObject)
    throws IOException
  {
    boolean bool = paramBoolean;
    if (paramObject != null)
    {
      if (Data.isNull(paramObject)) {
        return paramBoolean;
      }
      if (paramBoolean) {
        paramBoolean = false;
      } else {
        paramWriter.write("&");
      }
      paramWriter.write(paramString);
      if ((paramObject instanceof Enum)) {
        paramString = FieldInfo.of((Enum)paramObject).getName();
      } else {
        paramString = paramObject.toString();
      }
      paramString = CharEscapers.escapeUri(paramString);
      bool = paramBoolean;
      if (paramString.length() != 0)
      {
        paramWriter.write("=");
        paramWriter.write(paramString);
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  public static UrlEncodedContent getContent(HttpRequest paramHttpRequest)
  {
    Object localObject = paramHttpRequest.getContent();
    if (localObject != null) {
      return (UrlEncodedContent)localObject;
    }
    localObject = new UrlEncodedContent(new HashMap());
    paramHttpRequest.setContent((HttpContent)localObject);
    return localObject;
  }
  
  public final Object getData()
  {
    return data;
  }
  
  public UrlEncodedContent setData(Object paramObject)
  {
    if (paramObject != null)
    {
      data = paramObject;
      return this;
    }
    throw new NullPointerException();
  }
  
  public UrlEncodedContent setMediaType(HttpMediaType paramHttpMediaType)
  {
    mediaType = paramHttpMediaType;
    return this;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = new BufferedWriter(new OutputStreamWriter(paramOutputStream, getCharset()));
    Iterator localIterator = Data.mapOf(data).entrySet().iterator();
    boolean bool1 = true;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      if (localObject1 != null)
      {
        localObject2 = CharEscapers.escapeUri((String)((Map.Entry)localObject2).getKey());
        Class localClass = localObject1.getClass();
        if ((!(localObject1 instanceof Iterable)) && (!localClass.isArray()))
        {
          bool1 = appendParam(bool1, paramOutputStream, (String)localObject2, localObject1);
        }
        else
        {
          localObject1 = Types.iterableOf(localObject1).iterator();
          for (boolean bool2 = bool1;; bool2 = appendParam(bool2, paramOutputStream, (String)localObject2, ((Iterator)localObject1).next()))
          {
            bool1 = bool2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
          }
        }
      }
    }
    paramOutputStream.flush();
  }
}
