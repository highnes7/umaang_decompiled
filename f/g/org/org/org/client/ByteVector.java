package f.g.org.org.org.client;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.util.GenericData;
import f.g.org.org.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;

public final class ByteVector
{
  public static final int FLAG_REQUEST_VERSION = 33554432;
  public e a;
  public boolean b = false;
  public XHTML.ELEMENT data = XHTML.ELEMENT.a;
  public int i = 33554432;
  public long n = -1L;
  public final HttpRequestFactory requestFactory;
  public long size;
  public final HttpTransport transport;
  public long value;
  
  public ByteVector(HttpTransport paramHttpTransport, AnnotationVisitor paramAnnotationVisitor)
  {
    if (paramHttpTransport != null)
    {
      transport = paramHttpTransport;
      if (paramAnnotationVisitor == null) {
        paramHttpTransport = paramHttpTransport.createRequestFactory();
      } else {
        paramHttpTransport = paramHttpTransport.createRequestFactory(paramAnnotationVisitor);
      }
      requestFactory = paramHttpTransport;
      return;
    }
    throw new NullPointerException();
  }
  
  private long add(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    return Long.parseLong(paramString.substring(paramString.indexOf('-') + 1, paramString.indexOf('/'))) + 1L;
  }
  
  private void add(XHTML.ELEMENT paramELEMENT)
    throws IOException
  {
    data = paramELEMENT;
    paramELEMENT = a;
    if (paramELEMENT != null) {
      paramELEMENT.a(this);
    }
  }
  
  private HttpResponse execute(long paramLong, GenericUrl paramGenericUrl, HttpHeaders paramHttpHeaders, OutputStream paramOutputStream)
    throws IOException
  {
    paramGenericUrl = requestFactory.buildRequest(paramGenericUrl);
    if (paramHttpHeaders != null) {
      paramGenericUrl.getHeaders().putAll(paramHttpHeaders);
    }
    if ((value != 0L) || (paramLong != -1L))
    {
      paramHttpHeaders = f.sufficientlysecure.rootcommands.util.StringBuilder.append("bytes=");
      paramHttpHeaders.append(value);
      paramHttpHeaders.append("-");
      if (paramLong != -1L) {
        paramHttpHeaders.append(paramLong);
      }
      paramGenericUrl.getHeaders().setRange(paramHttpHeaders.toString());
    }
    paramGenericUrl = paramGenericUrl.execute();
    try
    {
      IOUtils.copy(paramGenericUrl.getContent(), paramOutputStream, true);
      paramGenericUrl.disconnect();
      return paramGenericUrl;
    }
    catch (Throwable paramHttpHeaders)
    {
      paramGenericUrl.disconnect();
      throw paramHttpHeaders;
    }
  }
  
  private void put(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (size == 0L) {
      size = Long.parseLong(paramString.substring(paramString.indexOf('/') + 1));
    }
  }
  
  public ByteVector a(int paramInt)
  {
    boolean bool;
    if ((paramInt > 0) && (paramInt <= 33554432)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    i = paramInt;
    return this;
  }
  
  public ByteVector a(e paramE)
  {
    a = paramE;
    return this;
  }
  
  public e a()
  {
    return a;
  }
  
  public int add()
  {
    return i;
  }
  
  public ByteVector b(boolean paramBoolean)
  {
    b = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return b;
  }
  
  public long get()
  {
    return value;
  }
  
  public double getSize()
  {
    long l = size;
    if (l == 0L) {
      return 0.0D;
    }
    double d1 = value;
    double d2 = l;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public HttpTransport getTransport()
  {
    return transport;
  }
  
  public long length()
  {
    return n;
  }
  
  public XHTML.ELEMENT read()
  {
    return data;
  }
  
  public void read(GenericUrl paramGenericUrl, HttpHeaders paramHttpHeaders, OutputStream paramOutputStream)
    throws IOException
  {
    boolean bool;
    if (data == XHTML.ELEMENT.a) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    paramGenericUrl.put("alt", "media");
    if (b)
    {
      add(XHTML.ELEMENT.p);
      size = execute(n, paramGenericUrl, paramHttpHeaders, paramOutputStream).getHeaders().getContentLength().longValue();
      value = size;
      add(XHTML.ELEMENT.object);
      return;
    }
    for (;;)
    {
      long l2 = value + i - 1L;
      long l3 = n;
      long l1 = l2;
      if (l3 != -1L) {
        l1 = Math.min(l3, l2);
      }
      String str = execute(l1, paramGenericUrl, paramHttpHeaders, paramOutputStream).getHeaders().get();
      l1 = add(str);
      put(str);
      l2 = size;
      if (l2 <= l1)
      {
        value = l2;
        add(XHTML.ELEMENT.object);
        return;
      }
      value = l1;
      add(XHTML.ELEMENT.p);
    }
  }
  
  public ByteVector write(long paramLong)
  {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    value = paramLong;
    return this;
  }
  
  public ByteVector write(long paramLong, int paramInt)
  {
    long l = paramInt;
    boolean bool;
    if (l >= paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    write(paramLong);
    n = l;
    return this;
  }
  
  public void write(GenericUrl paramGenericUrl, OutputStream paramOutputStream)
    throws IOException
  {
    read(paramGenericUrl, null, paramOutputStream);
  }
}
