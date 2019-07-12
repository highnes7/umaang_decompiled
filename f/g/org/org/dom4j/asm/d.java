package f.g.org.org.dom4j.asm;

import f.g.b.a.a.b.k;
import f.g.b.a.a.b.q;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.Item;
import f.g.org.org.util.store.DataStore;
import f.g.org.org.util.store.DataStoreFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class d
{
  public ResponseHandler a;
  public String b;
  public HttpTransport c;
  public f.g.org.org.http.Object e;
  public GenericUrl f;
  public String h;
  @f.g.b.a.g.h
  public f.g.b.a.g.b.d<q> i;
  @Deprecated
  @f.g.b.a.g.h
  public f j;
  public JsonFactory k;
  public AnnotationVisitor l;
  public Collection<k> m = new ArrayList();
  public AnnotationWriter n;
  public Item p = Item.g;
  public Collection<String> s = new ArrayList();
  
  public d(ResponseHandler paramResponseHandler, HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, GenericUrl paramGenericUrl, f.g.org.org.http.Object paramObject, String paramString1, String paramString2)
  {
    a(paramResponseHandler);
    a(paramHttpTransport);
    a(paramJsonFactory);
    a(paramGenericUrl);
    a(paramObject);
    a(paramString1);
    b(paramString2);
  }
  
  public d a(AnnotationWriter paramAnnotationWriter)
  {
    n = paramAnnotationWriter;
    return this;
  }
  
  public d a(ResponseHandler paramResponseHandler)
  {
    if (paramResponseHandler != null)
    {
      a = paramResponseHandler;
      return this;
    }
    throw new NullPointerException();
  }
  
  public d a(e paramE)
  {
    Collection localCollection = m;
    if (paramE != null)
    {
      localCollection.add(paramE);
      return this;
    }
    throw new NullPointerException();
  }
  
  public d a(f paramF)
  {
    boolean bool;
    if (i == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    j = paramF;
    return this;
  }
  
  public d a(AnnotationVisitor paramAnnotationVisitor)
  {
    l = paramAnnotationVisitor;
    return this;
  }
  
  public d a(GenericUrl paramGenericUrl)
  {
    if (paramGenericUrl != null)
    {
      f = paramGenericUrl;
      return this;
    }
    throw new NullPointerException();
  }
  
  public d a(HttpTransport paramHttpTransport)
  {
    if (paramHttpTransport != null)
    {
      c = paramHttpTransport;
      return this;
    }
    throw new NullPointerException();
  }
  
  public d a(f.g.org.org.http.Object paramObject)
  {
    e = paramObject;
    return this;
  }
  
  public d a(JsonFactory paramJsonFactory)
  {
    if (paramJsonFactory != null)
    {
      k = paramJsonFactory;
      return this;
    }
    throw new NullPointerException();
  }
  
  public d a(Item paramItem)
  {
    if (paramItem != null)
    {
      p = paramItem;
      return this;
    }
    throw new NullPointerException();
  }
  
  public d a(DataStore paramDataStore)
  {
    boolean bool;
    if (j == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    i = paramDataStore;
    return this;
  }
  
  public d a(DataStoreFactory paramDataStoreFactory)
    throws IOException
  {
    return a(Range.set(paramDataStoreFactory));
  }
  
  public d a(String paramString)
  {
    if (paramString != null)
    {
      h = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public d a(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      s = paramCollection;
      return this;
    }
    throw new NullPointerException();
  }
  
  public h a()
  {
    return new h(this);
  }
  
  public d b(String paramString)
  {
    if (paramString != null)
    {
      b = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final f.g.org.org.http.Object b()
  {
    return e;
  }
  
  public d c(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      m = paramCollection;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String c()
  {
    return b;
  }
  
  public final AnnotationVisitor d()
  {
    return l;
  }
  
  public final f e()
  {
    return j;
  }
  
  public final String f()
  {
    return h;
  }
  
  public final JsonFactory g()
  {
    return k;
  }
  
  public final HttpTransport getMenuView()
  {
    return c;
  }
  
  public final ResponseHandler h()
  {
    return a;
  }
  
  public final DataStore i()
  {
    return i;
  }
  
  public final AnnotationWriter j()
  {
    return n;
  }
  
  public final Item k()
  {
    return p;
  }
  
  public final Collection l()
  {
    return m;
  }
  
  public final GenericUrl onPageSelected()
  {
    return f;
  }
  
  public final Collection read()
  {
    return s;
  }
}
