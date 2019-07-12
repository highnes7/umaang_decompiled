package f.g.org.org.dom4j.asm;

import f.g.b.a.a.b.j;
import f.g.b.a.a.b.k;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Objects;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.FormatedText;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.HttpUnsuccessfulResponseHandler;
import f.g.org.org.stream.JsonFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassWriter
  implements f.g.org.org.http.Object, AnnotationVisitor, HttpUnsuccessfulResponseHandler
{
  public static final Logger log = Logger.getLogger(j.class.getName());
  public Long a;
  public final f.g.org.org.http.Object buffer;
  public final Collection<k> c;
  public final String data;
  public String file;
  public final f.g.org.org.util.Item g;
  public final ResponseHandler handler;
  public final AnnotationVisitor index;
  public final HttpTransport key;
  public String name;
  public final Lock this$0 = new ReentrantLock();
  public final JsonFactory value;
  
  public ClassWriter(ByteVector paramByteVector)
  {
    Object localObject = a;
    f.g.org.org.util.Preconditions.append(localObject);
    handler = ((ResponseHandler)localObject);
    key = b;
    value = Q;
    localObject = data;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((GenericUrl)localObject).build();
    }
    data = ((String)localObject);
    buffer = buffer;
    index = array;
    c = Collections.unmodifiableCollection(c);
    paramByteVector = g;
    f.g.org.org.util.Preconditions.append(paramByteVector);
    g = ((f.g.org.org.util.Item)paramByteVector);
  }
  
  public ClassWriter(ResponseHandler paramResponseHandler)
  {
    this(new ByteVector(paramResponseHandler));
  }
  
  public ClassWriter a(Plot paramPlot)
  {
    a(paramPlot.b());
    if (paramPlot.getTitle() != null) {
      put(paramPlot.getTitle());
    }
    add(paramPlot.a());
    return this;
  }
  
  public ClassWriter a(Long paramLong)
  {
    this$0.lock();
    try
    {
      a = paramLong;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramLong)
    {
      this$0.unlock();
      throw paramLong;
    }
  }
  
  public ClassWriter a(String paramString)
  {
    this$0.lock();
    try
    {
      name = paramString;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramString)
    {
      this$0.unlock();
      throw paramString;
    }
  }
  
  public final f.g.org.org.util.Item a()
  {
    return g;
  }
  
  public ClassWriter add(Long paramLong)
  {
    if (paramLong == null)
    {
      paramLong = null;
    }
    else
    {
      long l = g.currentTimeMillis();
      paramLong = Long.valueOf(paramLong.longValue() * 1000L + l);
    }
    return a(paramLong);
  }
  
  public final boolean add()
    throws IOException
  {
    this$0.lock();
    int i = 1;
    try
    {
      Plot localPlot = execute();
      if (localPlot != null)
      {
        a(localPlot);
        localObject1 = c;
        localObject1 = ((Collection)localObject1).iterator();
        for (;;)
        {
          bool = ((Iterator)localObject1).hasNext();
          if (!bool) {
            break;
          }
          Object localObject2 = ((Iterator)localObject1).next();
          localObject2 = (e)localObject2;
          ((e)localObject2).a(this, localPlot);
        }
        this$0.unlock();
        return true;
      }
    }
    catch (Throwable localThrowable) {}catch (GeneralRange localGeneralRange)
    {
      boolean bool;
      int j = localGeneralRange.isBold();
      if (400 <= j)
      {
        j = localGeneralRange.isBold();
        if (j < 500) {}
      }
      else
      {
        i = 0;
      }
      Object localObject1 = localGeneralRange.getOrdinal();
      if ((localObject1 != null) && (i != 0))
      {
        a(null);
        add(null);
      }
      localObject1 = c.iterator();
      for (;;)
      {
        bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        ((e)((Iterator)localObject1).next()).clear(this, localGeneralRange.getOrdinal());
      }
      if (i == 0)
      {
        this$0.unlock();
        return false;
      }
      throw localGeneralRange;
    }
    this$0.unlock();
    throw localGeneralRange;
  }
  
  public final Collection c()
  {
    return c;
  }
  
  public Plot execute()
    throws IOException
  {
    if (file == null) {
      return null;
    }
    return new Item(key, value, new GenericUrl(data), file).setTitle(buffer).setTitle(index).execute();
  }
  
  public final Long get()
  {
    this$0.lock();
    try
    {
      Long localLong = a;
      this$0.unlock();
      return localLong;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public final String getFile()
  {
    this$0.lock();
    try
    {
      String str = file;
      this$0.unlock();
      return str;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public final String getKey()
  {
    this$0.lock();
    try
    {
      String str = name;
      this$0.unlock();
      return str;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public final HttpTransport getValue()
  {
    return key;
  }
  
  public boolean handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, boolean paramBoolean)
  {
    Object localObject = paramHttpResponse.getHeaders().getAuthenticateAsList();
    boolean bool1 = true;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (str.startsWith("Bearer "))
        {
          paramBoolean = Settings.ACCEPTED_URI_SCHEMA.matcher(str).find();
          i = 1;
          break label82;
        }
      }
    }
    int i = 0;
    paramBoolean = false;
    label82:
    if (i == 0) {
      if (paramHttpResponse.getStatusCode() == 401) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    if (paramBoolean)
    {
      paramHttpResponse = this$0;
      try
      {
        paramHttpResponse.lock();
        try
        {
          boolean bool2 = Objects.equals(name, handler.handleResponse(paramHttpRequest));
          paramBoolean = bool1;
          if (bool2)
          {
            paramBoolean = add();
            if (paramBoolean) {
              paramBoolean = bool1;
            } else {
              paramBoolean = false;
            }
          }
          paramHttpRequest = this$0;
          paramHttpRequest.unlock();
          return paramBoolean;
        }
        catch (Throwable paramHttpRequest)
        {
          paramHttpResponse = this$0;
          paramHttpResponse.unlock();
          throw paramHttpRequest;
        }
        return false;
      }
      catch (IOException paramHttpRequest)
      {
        log.log(Level.SEVERE, "unable to refresh token", paramHttpRequest);
      }
    }
  }
  
  public final JsonFactory intValue()
  {
    return value;
  }
  
  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    this$0.lock();
    try
    {
      Object localObject = read();
      String str = name;
      if (str != null)
      {
        if (localObject != null)
        {
          long l = ((Long)localObject).longValue();
          if (l > 60L) {}
        }
      }
      else
      {
        add();
        localObject = name;
        if (localObject == null)
        {
          this$0.unlock();
          return;
        }
      }
      handler.intercept(paramHttpRequest, name);
      this$0.unlock();
      return;
    }
    catch (Throwable paramHttpRequest)
    {
      this$0.unlock();
      throw paramHttpRequest;
    }
  }
  
  public final AnnotationVisitor newUTF8()
  {
    return index;
  }
  
  public final String pop()
  {
    return data;
  }
  
  public ClassWriter put(String paramString)
  {
    this$0.lock();
    if (paramString != null) {}
    try
    {
      Object localObject = value;
      if (localObject != null)
      {
        localObject = key;
        if (localObject != null)
        {
          localObject = buffer;
          if (localObject != null)
          {
            localObject = data;
            if (localObject != null)
            {
              bool = true;
              break label56;
            }
          }
        }
      }
      boolean bool = false;
      label56:
      f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkArgument(bool, "Please use the Builder and call setJsonFactory, setTransport, setClientAuthentication and setTokenServerUrl/setTokenServerEncodedUrl");
      file = paramString;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramString)
    {
      this$0.unlock();
      throw paramString;
    }
  }
  
  public final f.g.org.org.http.Object put()
  {
    return buffer;
  }
  
  /* Error */
  public final Long read()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	f/g/org/org/dom4j/asm/ClassWriter:this$0	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 152 1 0
    //   9: aload_0
    //   10: getfield 154	f/g/org/org/dom4j/asm/ClassWriter:a	Ljava/lang/Long;
    //   13: astore 5
    //   15: aload 5
    //   17: ifnonnull +18 -> 35
    //   20: aconst_null
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 67	f/g/org/org/dom4j/asm/ClassWriter:this$0	Ljava/util/concurrent/locks/Lock;
    //   27: invokeinterface 157 1 0
    //   32: aload 5
    //   34: areturn
    //   35: aload_0
    //   36: getfield 154	f/g/org/org/dom4j/asm/ClassWriter:a	Ljava/lang/Long;
    //   39: invokevirtual 169	java/lang/Long:longValue	()J
    //   42: lstore_1
    //   43: aload_0
    //   44: getfield 119	f/g/org/org/dom4j/asm/ClassWriter:g	Lf/g/org/org/util/Item;
    //   47: invokeinterface 164 1 0
    //   52: lstore_3
    //   53: lload_1
    //   54: lload_3
    //   55: lsub
    //   56: ldc2_w 170
    //   59: ldiv
    //   60: lstore_1
    //   61: lload_1
    //   62: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   65: astore 5
    //   67: goto -44 -> 23
    //   70: astore 5
    //   72: aload_0
    //   73: getfield 67	f/g/org/org/dom4j/asm/ClassWriter:this$0	Ljava/util/concurrent/locks/Lock;
    //   76: invokeinterface 157 1 0
    //   81: goto +3 -> 84
    //   84: aload 5
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	ClassWriter
    //   42	20	1	l1	long
    //   52	3	3	l2	long
    //   13	53	5	localLong	Long
    //   70	15	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	15	70	java/lang/Throwable
    //   35	53	70	java/lang/Throwable
    //   61	67	70	java/lang/Throwable
  }
  
  public void visit(HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpRequest.setInterceptor(this);
    paramHttpRequest.setUnsuccessfulResponseHandler(this);
  }
  
  public final ResponseHandler visitInnerClass()
  {
    return handler;
  }
}
