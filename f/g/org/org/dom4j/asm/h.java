package f.g.org.org.dom4j.asm;

import f.g.b.a.a.b.k;
import f.g.b.a.a.b.q;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.Element;
import f.g.org.org.util.Item;
import f.g.org.org.util.Preconditions;
import f.g.org.org.util.store.DataStore;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class h
{
  public final AnnotationVisitor a;
  public final String b;
  public final JsonFactory c;
  public final String d;
  public final f.g.org.org.http.Object e;
  public final Collection<k> f;
  public final String g;
  @f.g.b.a.g.h
  public final f.g.b.a.g.b.d<q> i;
  @Deprecated
  @f.g.b.a.g.h
  public final f j;
  public final Item k;
  public final HttpTransport l;
  public final Collection<String> m;
  public final AnnotationWriter n;
  public final ResponseHandler o;
  
  public h(ResponseHandler paramResponseHandler, HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, GenericUrl paramGenericUrl, f.g.org.org.http.Object paramObject, String paramString1, String paramString2)
  {
    this(new d(paramResponseHandler, paramHttpTransport, paramJsonFactory, paramGenericUrl, paramObject, paramString1, paramString2));
  }
  
  public h(d paramD)
  {
    Object localObject = a;
    Preconditions.append(localObject);
    o = ((ResponseHandler)localObject);
    localObject = c;
    Preconditions.append(localObject);
    l = ((HttpTransport)localObject);
    localObject = k;
    Preconditions.append(localObject);
    c = ((JsonFactory)localObject);
    localObject = f;
    Preconditions.append(localObject);
    d = ((GenericUrl)localObject).build();
    e = e;
    localObject = h;
    Preconditions.append(localObject);
    b = ((String)localObject);
    localObject = b;
    Preconditions.append(localObject);
    g = ((String)localObject);
    a = l;
    j = j;
    i = i;
    m = Collections.unmodifiableCollection(s);
    localObject = p;
    Preconditions.append(localObject);
    k = ((Item)localObject);
    n = n;
    f = Collections.unmodifiableCollection(m);
  }
  
  private ClassWriter b(String paramString)
  {
    ByteVector localByteVector = new ByteVector(o).a(l).a(c).a(d).a(e).a(a).a(k);
    Object localObject = i;
    if (localObject != null)
    {
      localByteVector.a(new HashCrossContextPsuedoSession(paramString, (DataStore)localObject));
    }
    else
    {
      localObject = j;
      if (localObject != null) {
        localByteVector.a(new i(paramString, (f)localObject));
      }
    }
    localByteVector.get().addAll(f);
    return localByteVector.a();
  }
  
  public ClassWriter a(Plot paramPlot, String paramString)
    throws IOException
  {
    ClassWriter localClassWriter = b(paramString).a(paramPlot);
    Object localObject = j;
    if (localObject != null) {
      ((f)localObject).b(paramString, localClassWriter);
    }
    localObject = i;
    if (localObject != null) {
      ((DataStore)localObject).set(paramString, new Range(localClassWriter));
    }
    paramString = n;
    if (paramString != null) {
      paramString.a(localClassWriter, paramPlot);
    }
    return localClassWriter;
  }
  
  public ClassWriter a(String paramString)
    throws IOException
  {
    if ((i == null) && (j == null)) {
      return null;
    }
    ClassWriter localClassWriter = b(paramString);
    DataStore localDataStore = i;
    if (localDataStore != null)
    {
      paramString = (Range)localDataStore.get(paramString);
      if (paramString == null) {
        return null;
      }
      localClassWriter.a(paramString.get());
      localClassWriter.put(paramString.getName());
      localClassWriter.a(paramString.start());
      return localClassWriter;
    }
    if (!j.a(paramString, localClassWriter)) {
      return null;
    }
    return localClassWriter;
  }
  
  public final f.g.org.org.http.Object a()
  {
    return e;
  }
  
  public Content add()
  {
    return new Content(g, b).set(m);
  }
  
  public final HttpTransport b()
  {
    return l;
  }
  
  public final Item c()
  {
    return k;
  }
  
  public final Collection d()
  {
    return m;
  }
  
  public final String e()
  {
    return d;
  }
  
  public final Collection f()
  {
    return f;
  }
  
  public final String getIcon()
  {
    return Element.append(' ').toString(m);
  }
  
  public final String getIntent()
  {
    return g;
  }
  
  public final String getOrder()
  {
    return b;
  }
  
  public final JsonFactory getTitle()
  {
    return c;
  }
  
  public final f h()
  {
    return j;
  }
  
  public final DataStore i()
  {
    return i;
  }
  
  public final ResponseHandler j()
  {
    return o;
  }
  
  public final AnnotationVisitor n()
  {
    return a;
  }
  
  public DialogBuilder setTitle(String paramString)
  {
    return new DialogBuilder(l, c, new GenericUrl(d), paramString).setTitle(e).setTitle(a).setTitle(m);
  }
}
