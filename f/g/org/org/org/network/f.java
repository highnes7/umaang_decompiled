package f.g.org.org.org.network;

import f.g.b.a.b.c.b.b;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.AbstractHttpContent;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.BackOffPolicy;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpContent;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpMediaType;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.MultipartContent.Part;
import f.g.org.org.util.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public GenericUrl b = new GenericUrl("https://www.googleapis.com/batch");
  public List<b.b<?, ?>> c = new ArrayList();
  public final HttpRequestFactory h;
  public Context p = Context.c;
  
  public f(HttpTransport paramHttpTransport, AnnotationVisitor paramAnnotationVisitor)
  {
    if (paramAnnotationVisitor == null) {
      paramHttpTransport = paramHttpTransport.createRequestFactory();
    } else {
      paramHttpTransport = paramHttpTransport.createRequestFactory(paramAnnotationVisitor);
    }
    h = paramHttpTransport;
  }
  
  public f a(GenericUrl paramGenericUrl)
  {
    b = paramGenericUrl;
    return this;
  }
  
  public f a(Context paramContext)
  {
    if (paramContext != null)
    {
      p = paramContext;
      return this;
    }
    throw new NullPointerException();
  }
  
  public f add(HttpRequest paramHttpRequest, Class paramClass1, Class paramClass2, Request paramRequest)
    throws IOException
  {
    if (paramHttpRequest != null)
    {
      if (paramRequest != null)
      {
        if (paramClass1 != null)
        {
          if (paramClass2 != null)
          {
            c.add(new Item(paramRequest, paramClass1, paramClass2, paramHttpRequest));
            return this;
          }
          throw new NullPointerException();
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void execute()
    throws IOException
  {
    Preconditions.set(c.isEmpty() ^ true);
    HttpRequest localHttpRequest = h.buildPostRequest(b, null);
    localHttpRequest.setInterceptor(new Token(this, localHttpRequest.getInterceptor()));
    int j = localHttpRequest.getNumberOfRetries();
    BackOffPolicy localBackOffPolicy = localHttpRequest.getBackOffPolicy();
    int i = j;
    if (localBackOffPolicy != null)
    {
      localBackOffPolicy.reset();
      i = j;
    }
    boolean bool1;
    do
    {
      if (i > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Object localObject1 = new f.g.org.org.http.MultipartContent();
      ((AbstractHttpContent)localObject1).getMediaType().setSubType("mixed");
      localObject2 = c.iterator();
      j = 1;
      while (((Iterator)localObject2).hasNext())
      {
        Item localItem = (Item)((Iterator)localObject2).next();
        ((f.g.org.org.http.MultipartContent)localObject1).addPart(new MultipartContent.Part(new HttpHeaders().setAcceptEncoding(null).clone("Content-ID", Integer.valueOf(j)), new MultipartContent(request)));
        j += 1;
      }
      localHttpRequest.setContent((HttpContent)localObject1);
      localObject2 = localHttpRequest.execute();
      for (;;)
      {
        try
        {
          localObject1 = String.valueOf(((HttpResponse)localObject2).getMediaType().getParameter("boundary"));
          j = ((String)localObject1).length();
          if (j != 0) {
            localObject1 = "--".concat((String)localObject1);
          } else {
            localObject1 = new String("--");
          }
          localObject1 = new ClassWriter(((HttpResponse)localObject2).getContent(), (String)localObject1, c, bool1);
          boolean bool2 = p;
          if (bool2)
          {
            ((ClassWriter)localObject1).parse();
            continue;
          }
          ((HttpResponse)localObject2).disconnect();
          localObject2 = c;
          if (!((List)localObject2).isEmpty())
          {
            c = ((List)localObject2);
            if ((k) && (localBackOffPolicy != null))
            {
              l = localBackOffPolicy.getNextBackOffMillis();
              if (l != -1L) {
                localObject1 = p;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          long l;
          ((HttpResponse)localObject2).disconnect();
          throw localThrowable;
        }
        try
        {
          ((Context)localObject1).report(l);
        }
        catch (InterruptedException localInterruptedException) {}
      }
      i -= 1;
    } while (bool1);
    c.clear();
  }
  
  public Context k()
  {
    return p;
  }
  
  public GenericUrl o()
  {
    return b;
  }
  
  public int size()
  {
    return c.size();
  }
}
