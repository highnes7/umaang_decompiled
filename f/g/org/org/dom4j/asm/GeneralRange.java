package f.g.org.org.dom4j.asm;

import f.g.b.a.a.b.r;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Cache;
import f.g.org.org.http.FormatedText;
import f.g.org.org.http.HttpMediaType;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.Item;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonObjectParser;
import f.g.org.org.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;

public class GeneralRange
  extends FormatedText
{
  public static final long MASK_TOKEN_FULL_LEN = 4020689092957439244L;
  public final transient Set _ordinal;
  
  public GeneralRange(Item paramItem, Set paramSet)
  {
    super(paramItem);
    _ordinal = paramSet;
  }
  
  public static GeneralRange from(JsonFactory paramJsonFactory, HttpResponse paramHttpResponse)
  {
    Item localItem = new Item(paramHttpResponse.getStatusCode(), paramHttpResponse.getStatusMessage(), paramHttpResponse.getHeaders());
    if (paramJsonFactory != null)
    {
      Object localObject1 = paramHttpResponse.getContentType();
      Object localObject2 = null;
      label126:
      JsonFactory localJsonFactory;
      try
      {
        boolean bool = paramHttpResponse.isSuccessStatusCode();
        if ((!bool) && (localObject1 != null))
        {
          InputStream localInputStream = paramHttpResponse.getContent();
          if (localInputStream != null)
          {
            bool = HttpMediaType.equalsIgnoreParameters("application/json; charset=UTF-8", (String)localObject1);
            if (bool)
            {
              paramJsonFactory = new JsonObjectParser(paramJsonFactory).parseAndClose(paramHttpResponse.getContent(), paramHttpResponse.getContentCharset(), r.class);
              localObject1 = (Set)paramJsonFactory;
              try
              {
                paramJsonFactory = ((f.g.org.org.stream.Object)localObject1).toPrettyString();
              }
              catch (IOException localIOException2)
              {
                paramJsonFactory = (JsonFactory)localObject1;
                localObject1 = localIOException2;
                break label126;
              }
            }
          }
        }
        paramJsonFactory = paramHttpResponse.parseAsString();
        localObject1 = null;
      }
      catch (IOException localIOException1)
      {
        paramJsonFactory = null;
        ((IOException)localIOException1).printStackTrace();
        localJsonFactory = paramJsonFactory;
        paramJsonFactory = localObject2;
      }
      paramHttpResponse = FormatedText.computeMessageBuffer(paramHttpResponse);
      if (!Cache.isEmpty(paramJsonFactory))
      {
        paramHttpResponse.append(StringUtils.LINE_SEPARATOR);
        paramHttpResponse.append(paramJsonFactory);
        localItem.setContent(paramJsonFactory);
      }
      localItem.put(paramHttpResponse.toString());
      return new GeneralRange(localItem, localJsonFactory);
    }
    throw new NullPointerException();
  }
  
  public final Set getOrdinal()
  {
    return _ordinal;
  }
}
