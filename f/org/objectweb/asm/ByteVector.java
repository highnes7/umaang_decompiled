package f.org.objectweb.asm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Pi")
public class ByteVector
{
  @XmlAttribute
  public String _hint;
  @XmlAttribute
  public String a;
  @XmlAttribute
  public MapViewMode array;
  @XmlAttribute
  public String b;
  @XmlAttribute
  public String data;
  @XmlAttribute
  public c f;
  @XmlAttribute
  public String g;
  @XmlAttribute
  public String length;
  @XmlAttribute
  public String n;
  @XmlAttribute
  public String size;
  @XmlAttribute
  public String utf8;
  
  public ByteVector() {}
  
  public c a()
  {
    c localC2 = f;
    c localC1 = localC2;
    if (localC2 == null) {
      localC1 = c.f;
    }
    return localC1;
  }
  
  public void a(c paramC)
  {
    f = paramC;
  }
  
  public void a(String paramString)
  {
    g = paramString;
  }
  
  public void add(String paramString)
  {
    n = paramString;
  }
  
  public void alloc(MapViewMode paramMapViewMode)
  {
    array = paramMapViewMode;
  }
  
  public String b()
  {
    return g;
  }
  
  public void b(String paramString)
  {
    a = paramString;
  }
  
  public String copy()
  {
    return _hint;
  }
  
  public void copy(String paramString)
  {
    _hint = paramString;
  }
  
  public String get()
  {
    return data;
  }
  
  public MapViewMode getArray()
  {
    return array;
  }
  
  public String getSize()
  {
    return length;
  }
  
  public String length()
  {
    return n;
  }
  
  public String put()
  {
    return b;
  }
  
  public void putByte(String paramString)
  {
    b = paramString;
  }
  
  public void putInt(String paramString)
  {
    utf8 = paramString;
  }
  
  public void putLong(String paramString)
  {
    length = paramString;
  }
  
  public String read()
  {
    return size;
  }
  
  public void trimToSize(String paramString)
  {
    size = paramString;
  }
  
  public String utf8()
  {
    return utf8;
  }
  
  public String write()
  {
    return a;
  }
  
  public void write(String paramString)
  {
    data = paramString;
  }
}
