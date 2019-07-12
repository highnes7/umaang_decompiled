package f.g.org.org.dom4j.asm;

import java.util.Collection;
import java.util.Collections;

public class Content
  extends Attribute
{
  public Content(String paramString1, String paramString2)
  {
    super(paramString1, paramString2, Collections.singleton("code"));
  }
  
  public Content clone()
  {
    return (Content)super.clone();
  }
  
  public Content clone(String paramString)
  {
    state = paramString;
    return this;
  }
  
  public Content clone(String paramString, Object paramObject)
  {
    return (Content)super.clone(paramString, paramObject);
  }
  
  public Content clone(Collection paramCollection)
  {
    super.clone(paramCollection);
    return (Content)this;
  }
  
  public Content detach(String paramString)
  {
    if (paramString != null)
    {
      clientId = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Content set(Collection paramCollection)
  {
    super.set(paramCollection);
    return (Content)this;
  }
  
  public Content setNamespace(String paramString)
  {
    redirectUri = paramString;
    return this;
  }
}
