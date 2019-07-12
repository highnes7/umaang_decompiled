package f.g.org.org.org.objectweb.asm;

import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.util.GenericData;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;

public class ClassWriter
{
  public static final Charset UTF8 = Charset.forName("UTF-8");
  public static final String threshold = "http://metadata.google.internal";
  
  public ClassWriter() {}
  
  public static boolean execute(HttpTransport paramHttpTransport)
  {
    try
    {
      GenericUrl localGenericUrl = new GenericUrl("http://metadata.google.internal");
      boolean bool = put(paramHttpTransport.createRequestFactory().buildRequest(localGenericUrl).execute().getHeaders(), "Metadata-Flavor", "Google");
      if (bool) {
        return true;
      }
    }
    catch (IOException paramHttpTransport)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static Throwable get(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    paramThrowable1.initCause(paramThrowable2);
    return paramThrowable1;
  }
  
  public static boolean put(HttpHeaders paramHttpHeaders, String paramString1, String paramString2)
  {
    paramHttpHeaders = paramHttpHeaders.get(paramString1);
    if ((paramHttpHeaders instanceof Collection))
    {
      paramHttpHeaders = ((Collection)paramHttpHeaders).iterator();
      while (paramHttpHeaders.hasNext())
      {
        paramString1 = paramHttpHeaders.next();
        if (((paramString1 instanceof String)) && (((String)paramString1).equals(paramString2))) {
          return true;
        }
      }
    }
    return false;
  }
}
