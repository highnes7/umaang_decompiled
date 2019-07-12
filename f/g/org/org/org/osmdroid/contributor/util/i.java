package f.g.org.org.org.osmdroid.contributor.util;

import f.g.b.a.g.h;
import f.g.org.org.apache.http.MockHttpTransport.Builder;
import f.g.org.org.dom4j.asm.ByteVector;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.Object;

@h
public class i
  extends f.g.org.org.org.objectweb.asm.Item
{
  public i() {}
  
  public Item a()
  {
    if (putByte() == null) {
      a(new MockHttpTransport.Builder().build());
    }
    if (read() == null) {
      a(new FieldVisitor(null));
    }
    if (visitIntInsn() == null) {
      a(new f.g.org.org.stream.util.JsonFactory());
    }
    return new Item(this);
  }
  
  public i a(HttpTransport paramHttpTransport)
  {
    b = paramHttpTransport;
    return this;
  }
  
  public i a(Object paramObject)
  {
    buffer = paramObject;
    return this;
  }
  
  public i a(f.g.org.org.stream.JsonFactory paramJsonFactory)
  {
    Q = paramJsonFactory;
    return this;
  }
  
  public i a(f.g.org.org.util.Item paramItem)
  {
    if (paramItem != null)
    {
      g = paramItem;
      return this;
    }
    throw new NullPointerException();
  }
}
