package f.g.org.org.dom4j.asm;

import java.util.Collection;
import java.util.Collections;

public class Element
  extends Attribute
{
  public Element(String paramString1, String paramString2)
  {
    super(paramString1, paramString2, Collections.singleton("token"));
  }
  
  public Element clone()
  {
    return (Element)super.clone();
  }
  
  public Element clone(String paramString)
  {
    state = paramString;
    return this;
  }
  
  public Element clone(String paramString, Object paramObject)
  {
    return (Element)super.clone(paramString, paramObject);
  }
  
  public Element clone(Collection paramCollection)
  {
    super.clone(paramCollection);
    return (Element)this;
  }
  
  public Element detach(String paramString)
  {
    if (paramString != null)
    {
      clientId = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Element set(Collection paramCollection)
  {
    super.set(paramCollection);
    return (Element)this;
  }
  
  public Element setNamespace(String paramString)
  {
    redirectUri = paramString;
    return this;
  }
}
