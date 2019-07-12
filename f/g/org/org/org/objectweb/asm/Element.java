package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.z;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.dom4j.asm.Content;
import java.util.Collection;
import java.util.Iterator;

public class Element
  extends Content
{
  @z("access_type")
  public String accessType;
  @z("approval_prompt")
  public String approvalPrompt;
  
  public Element(Token paramToken, String paramString, Collection paramCollection)
  {
    this(paramToken.getDetails().location(), paramString, paramCollection);
  }
  
  public Element(String paramString1, String paramString2, String paramString3, Collection paramCollection)
  {
    super(paramString1, paramString2);
    setNamespace(paramString3);
    set(paramCollection);
  }
  
  public Element(String paramString1, String paramString2, Collection paramCollection)
  {
    super("https://accounts.google.com/o/oauth2/auth", paramString1);
    setNamespace(paramString2);
    set(paramCollection);
  }
  
  public Element append(String paramString)
  {
    approvalPrompt = paramString;
    return this;
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
    return (Element)super.clone(paramCollection);
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
  
  public final String getAttributeName()
  {
    return accessType;
  }
  
  public final String getRoot()
  {
    return approvalPrompt;
  }
  
  public Element set(Collection paramCollection)
  {
    Preconditions.append(paramCollection.iterator().hasNext());
    return (Element)super.set(paramCollection);
  }
  
  public Element setNamespace(String paramString)
  {
    if (paramString != null)
    {
      redirectUri = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Element setText(String paramString)
  {
    accessType = paramString;
    return this;
  }
}
