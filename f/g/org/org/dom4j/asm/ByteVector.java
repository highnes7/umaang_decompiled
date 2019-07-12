package f.g.org.org.dom4j.asm;

import f.g.b.a.a.b.k;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.Item;
import java.util.ArrayList;
import java.util.Collection;

public class ByteVector
{
  public JsonFactory Q;
  public final ResponseHandler a;
  public AnnotationVisitor array;
  public HttpTransport b;
  public f.g.org.org.http.Object buffer;
  public Collection<k> c = new ArrayList();
  public GenericUrl data;
  public Item g = Item.g;
  
  public ByteVector(ResponseHandler paramResponseHandler)
  {
    if (paramResponseHandler != null)
    {
      a = paramResponseHandler;
      return;
    }
    throw new NullPointerException();
  }
  
  public ByteVector a(e paramE)
  {
    Collection localCollection = c;
    if (paramE != null)
    {
      localCollection.add(paramE);
      return this;
    }
    throw new NullPointerException();
  }
  
  public ByteVector a(AnnotationVisitor paramAnnotationVisitor)
  {
    array = paramAnnotationVisitor;
    return this;
  }
  
  public ByteVector a(GenericUrl paramGenericUrl)
  {
    data = paramGenericUrl;
    return this;
  }
  
  public ByteVector a(HttpTransport paramHttpTransport)
  {
    b = paramHttpTransport;
    return this;
  }
  
  public ByteVector a(f.g.org.org.http.Object paramObject)
  {
    buffer = paramObject;
    return this;
  }
  
  public ByteVector a(JsonFactory paramJsonFactory)
  {
    Q = paramJsonFactory;
    return this;
  }
  
  public ByteVector a(Item paramItem)
  {
    if (paramItem != null)
    {
      g = paramItem;
      return this;
    }
    throw new NullPointerException();
  }
  
  public ByteVector a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = new GenericUrl(paramString);
    }
    data = paramString;
    return this;
  }
  
  public ClassWriter a()
  {
    return new ClassWriter(this);
  }
  
  public ByteVector b(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      c = paramCollection;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final Item b()
  {
    return g;
  }
  
  public final Collection get()
  {
    return c;
  }
  
  public final AnnotationVisitor getArray()
  {
    return array;
  }
  
  public final HttpTransport putByte()
  {
    return b;
  }
  
  public final GenericUrl putByteArray()
  {
    return data;
  }
  
  public final ResponseHandler putUTF8()
  {
    return a;
  }
  
  public final f.g.org.org.http.Object read()
  {
    return buffer;
  }
  
  public final JsonFactory visitIntInsn()
  {
    return Q;
  }
}
