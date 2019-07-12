package f.g.org.org.dom4j.asm;

import f.g.b.a.g.z;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.util.Element;
import java.util.Collection;
import java.util.Iterator;

public class Attribute
  extends GenericUrl
{
  @z("client_id")
  public String clientId;
  @z("redirect_uri")
  public String redirectUri;
  @z("response_type")
  public String responseTypes;
  @z("scope")
  public String scopes;
  @z
  public String state;
  
  public Attribute(String paramString1, String paramString2, Collection paramCollection)
  {
    super(paramString1);
    boolean bool;
    if (getFragment() == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    detach(paramString2);
    clone(paramCollection);
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
    responseTypes = Element.append(' ').toString(paramCollection);
    return this;
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
  
  public final String encode()
  {
    return responseTypes;
  }
  
  public final String getNamespace()
  {
    return redirectUri;
  }
  
  public final String getNamespacePrefix()
  {
    return clientId;
  }
  
  public final String getState()
  {
    return state;
  }
  
  public final String getString()
  {
    return scopes;
  }
  
  public Attribute set(Collection paramCollection)
  {
    if ((paramCollection != null) && (paramCollection.iterator().hasNext())) {
      paramCollection = Element.append(' ').toString(paramCollection);
    } else {
      paramCollection = null;
    }
    scopes = paramCollection;
    return this;
  }
  
  public Attribute setNamespace(String paramString)
  {
    redirectUri = paramString;
    return this;
  }
}
