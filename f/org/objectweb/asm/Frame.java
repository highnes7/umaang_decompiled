package f.org.objectweb.asm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Pa")
public class Frame
{
  @XmlAttribute
  public c a;
  @XmlAttribute
  public String b;
  @XmlAttribute
  public String c;
  @XmlAttribute
  public String f;
  @XmlAttribute
  public String g;
  @XmlAttribute
  public String h;
  @XmlAttribute
  public String i;
  @XmlAttribute
  public String opcode;
  @XmlAttribute
  public String resolved;
  @XmlAttribute
  public String stack;
  @XmlAttribute
  public String startTag;
  @XmlAttribute
  public String values;
  
  public Frame() {}
  
  public String a()
  {
    return g;
  }
  
  public void a(c paramC)
  {
    a = paramC;
  }
  
  public void a(String paramString)
  {
    f = paramString;
  }
  
  public String b()
  {
    return b;
  }
  
  public void b(String paramString)
  {
    b = paramString;
  }
  
  public c c()
  {
    c localC2 = a;
    c localC1 = localC2;
    if (localC2 == null) {
      localC1 = c.f;
    }
    return localC1;
  }
  
  public void c(String paramString)
  {
    c = paramString;
  }
  
  public String copy()
  {
    return i;
  }
  
  public void copy(String paramString)
  {
    stack = paramString;
  }
  
  public String d()
  {
    return f;
  }
  
  public void d(String paramString)
  {
    h = paramString;
  }
  
  public void decodeFirstByte(String paramString)
  {
    opcode = paramString;
  }
  
  public void e(String paramString)
  {
    i = paramString;
  }
  
  public String encodeFirstByte()
  {
    return opcode;
  }
  
  public String get()
  {
    return c;
  }
  
  public String getLocal()
  {
    return values;
  }
  
  public String init()
  {
    return h;
  }
  
  public void init(String paramString)
  {
    values = paramString;
  }
  
  public String merge()
  {
    return resolved;
  }
  
  public void merge(String paramString)
  {
    resolved = paramString;
  }
  
  public String pop()
  {
    return stack;
  }
  
  public void pop(String paramString)
  {
    startTag = paramString;
  }
  
  public String push()
  {
    return startTag;
  }
  
  public void set(String paramString)
  {
    g = paramString;
  }
}
