package f.org.objectweb.asm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Pid")
@XmlType(name="", propOrder={"demo", "bios", "pv"})
public class l
{
  @XmlElement(name="Bios")
  public Label a;
  @XmlElement(name="Demo")
  public ClassWriter b;
  @XmlAttribute(required=true)
  @XmlSchemaType(name="dateTime")
  public String color;
  @XmlAttribute
  public String f;
  @XmlAttribute
  public String g;
  @XmlElement(name="Pv")
  public i l;
  
  public l() {}
  
  public i a()
  {
    return l;
  }
  
  public void a(i paramI)
  {
    l = paramI;
  }
  
  public void a(String paramString)
  {
    g = paramString;
  }
  
  public void b(ClassWriter paramClassWriter)
  {
    b = paramClassWriter;
  }
  
  public void b(Label paramLabel)
  {
    a = paramLabel;
  }
  
  public void b(String paramString)
  {
    f = paramString;
  }
  
  public String draw()
  {
    String str = g;
    if (str == null) {
      return "1.0";
    }
    return str;
  }
  
  public String getColor()
  {
    return color;
  }
  
  public String getField()
  {
    return f;
  }
  
  public Label getFirst()
  {
    return a;
  }
  
  public ClassWriter setAlpha()
  {
    return b;
  }
  
  public void setAlpha(String paramString)
  {
    color = paramString;
  }
}
