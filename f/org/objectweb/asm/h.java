package f.org.objectweb.asm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Pfa")
public class h
{
  @XmlAttribute
  public String a;
  @XmlAttribute
  public String b;
  @XmlAttribute
  public c f;
  @XmlAttribute
  public String g;
  @XmlAttribute
  public String j;
  
  public h() {}
  
  public String a()
  {
    return a;
  }
  
  public void a(c paramC)
  {
    f = paramC;
  }
  
  public String b()
  {
    return g;
  }
  
  public void b(String paramString)
  {
    a = paramString;
  }
  
  public String c()
  {
    return b;
  }
  
  public void c(String paramString)
  {
    g = paramString;
  }
  
  public c d()
  {
    c localC2 = f;
    c localC1 = localC2;
    if (localC2 == null) {
      localC1 = c.f;
    }
    return localC1;
  }
  
  public void d(String paramString)
  {
    j = paramString;
  }
  
  public void e(String paramString)
  {
    b = paramString;
  }
  
  public String h()
  {
    return j;
  }
}
