package f.g.org.org.org.internal;

import f.g.b.a.b.i.a;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Cache;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.util.ObjectParser;
import java.io.IOException;
import java.util.logging.Logger;

public abstract class f
{
  public static final Logger log = Logger.getLogger(a.class.getName());
  public final String a;
  public final String b;
  public final c c;
  public final String e;
  public final ObjectParser j;
  public boolean l;
  public final HttpRequestFactory n;
  public boolean z;
  
  public f(h paramH)
  {
    c = c;
    a = append(j);
    b = valueOf(d);
    if (Cache.isEmpty(e)) {
      log.warning("Application name is not set. Call Builder#setApplicationName.");
    }
    e = e;
    Object localObject = f;
    if (localObject == null) {
      localObject = transport.createRequestFactory();
    } else {
      localObject = transport.createRequestFactory((AnnotationVisitor)localObject);
    }
    n = ((HttpRequestFactory)localObject);
    j = objectParser;
    l = l;
    z = h;
  }
  
  public static String append(String paramString)
  {
    Preconditions.checkNotNull(paramString, "root URL cannot be null.");
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString.concat("/");
    }
    return str;
  }
  
  public static String valueOf(String paramString)
  {
    Preconditions.checkNotNull(paramString, "service path cannot be null");
    if (paramString.length() == 1)
    {
      Preconditions.checkArgument("/".equals(paramString), "service path must equal \"/\" if it is of length 1.");
      return "";
    }
    Object localObject = paramString;
    if (paramString.length() > 0)
    {
      String str = paramString;
      if (!paramString.endsWith("/")) {
        str = paramString.concat("/");
      }
      localObject = str;
      if (str.startsWith("/")) {
        localObject = str.substring(1);
      }
    }
    return localObject;
  }
  
  public final f.g.org.org.org.network.f a(AnnotationVisitor paramAnnotationVisitor)
  {
    paramAnnotationVisitor = new f.g.org.org.org.network.f(size().getTransport(), paramAnnotationVisitor);
    paramAnnotationVisitor.a(new GenericUrl(String.valueOf(n()).concat("batch")));
    return paramAnnotationVisitor;
  }
  
  public void a(Element paramElement)
    throws IOException
  {
    if (c() != null) {
      c().a(paramElement);
    }
  }
  
  public final boolean add()
  {
    return z;
  }
  
  public final String b()
  {
    return b;
  }
  
  public final c c()
  {
    return c;
  }
  
  public final boolean d()
  {
    return l;
  }
  
  public ObjectParser e()
  {
    return j;
  }
  
  public final String getItem()
  {
    return e;
  }
  
  public final String getText()
  {
    String str1 = String.valueOf(a);
    String str2 = String.valueOf(b);
    if (str2.length() != 0) {
      return str1.concat(str2);
    }
    return new String(str1);
  }
  
  public final String n()
  {
    return a;
  }
  
  public final HttpRequestFactory size()
  {
    return n;
  }
  
  public final f.g.org.org.org.network.f startSupportActionMode()
  {
    return a(null);
  }
}
