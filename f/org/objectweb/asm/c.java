package f.org.objectweb.asm;

import f.q.a.c.g;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name="matchingStrategy")
public enum c
{
  public static c a(String paramString)
  {
    return valueOf(paramString);
  }
  
  public String doBackward()
  {
    return name();
  }
}
