package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.z;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.dom4j.asm.Element;
import java.util.Collection;
import java.util.Iterator;

public class Attribute
  extends Element
{
  @z("approval_prompt")
  public String approvalPrompt;
  
  public Attribute(Token paramToken, String paramString, Collection paramCollection)
  {
    this(paramToken.getDetails().location(), paramString, paramCollection);
  }
  
  public Attribute(String paramString1, String paramString2, Collection paramCollection)
  {
    super("https://accounts.google.com/o/oauth2/auth", paramString1);
    setNamespace(paramString2);
    set(paramCollection);
  }
  
  public Attribute a(String paramString)
  {
    approvalPrompt = paramString;
    return this;
  }
  
  public Attribute clone()
  {
    return (Attribute)super.clone();
  }
  
  public Attribute clone(String paramString)
  {
    state = paramString;
    return this;
  }
  
  public Attribute clone(String paramString, Object paramObject)
  {
    return (Attribute)super.clone(paramString, paramObject);
  }
  
  public Attribute clone(Collection paramCollection)
  {
    return (Attribute)super.clone(paramCollection);
  }
  
  public Attribute detach(String paramString)
  {
    if (paramString != null)
    {
      clientId = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String getAttributeType()
  {
    return approvalPrompt;
  }
  
  public Attribute set(Collection paramCollection)
  {
    Preconditions.append(paramCollection.iterator().hasNext());
    return (Attribute)super.set(paramCollection);
  }
  
  public Attribute setNamespace(String paramString)
  {
    redirectUri = paramString;
    return this;
  }
}
