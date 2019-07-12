package f.org.objectweb.asm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Demo", propOrder={"pi", "pa", "pfa"})
public class ClassWriter
{
  @XmlElement(name="Pfa")
  public h b;
  @XmlElement(name="Pi")
  public ByteVector d;
  @XmlElement(name="Pa")
  public Frame t;
  @XmlAttribute
  public String value;
  
  public ClassWriter() {}
  
  public void a(ByteVector paramByteVector)
  {
    d = paramByteVector;
  }
  
  public void a(Frame paramFrame)
  {
    t = paramFrame;
  }
  
  public ByteVector b()
  {
    return d;
  }
  
  public void b(h paramH)
  {
    b = paramH;
  }
  
  public h c()
  {
    return b;
  }
  
  public Frame get()
  {
    return t;
  }
  
  public String put()
  {
    String str = value;
    if (str == null) {
      return "23";
    }
    return str;
  }
  
  public void put(String paramString)
  {
    value = paramString;
  }
}
