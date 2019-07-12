package f.org.objectweb.asm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Pv")
public class i
{
  @XmlAttribute
  public String j;
  @XmlAttribute
  public String w;
  
  public i() {}
  
  public String b()
  {
    return j;
  }
  
  public String h()
  {
    return w;
  }
  
  public void h(String paramString)
  {
    j = paramString;
  }
  
  public void i(String paramString)
  {
    w = paramString;
  }
}
