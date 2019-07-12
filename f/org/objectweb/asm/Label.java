package f.org.objectweb.asm;

import f.q.a.c.a;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Bios", propOrder={"bio"})
public class Label
{
  @XmlElement(name="Bio")
  public List<a> f;
  
  public Label() {}
  
  public List a()
  {
    if (f == null) {
      f = new ArrayList();
    }
    return f;
  }
}
