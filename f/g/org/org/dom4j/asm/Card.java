package f.g.org.org.dom4j.asm;

import f.g.b.a.g.z;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.GenericUrl;

public class Card
  extends GenericUrl
{
  @z
  public String code;
  @z
  public String error;
  @z("error_description")
  public String errorDescription;
  @z("error_uri")
  public String errorUri;
  @z
  public String state;
  
  public Card(String paramString)
  {
    super(paramString);
    paramString = code;
    boolean bool = true;
    int i;
    if (paramString == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (error == null) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == j) {
      bool = false;
    }
    Preconditions.append(bool);
  }
  
  public Card clone()
  {
    return (Card)super.clone();
  }
  
  public Card clone(String paramString, Object paramObject)
  {
    return (Card)super.clone(paramString, paramObject);
  }
  
  public final String getDid()
  {
    return errorUri;
  }
  
  public final String getFlavor()
  {
    return errorDescription;
  }
  
  public final String getTitle()
  {
    return code;
  }
  
  public final String getValue()
  {
    return state;
  }
  
  public Card load(String paramString)
  {
    state = paramString;
    return this;
  }
  
  public Card setArtist(String paramString)
  {
    errorUri = paramString;
    return this;
  }
  
  public Card setId(String paramString)
  {
    error = paramString;
    return this;
  }
  
  public Card setOnClickListener(String paramString)
  {
    errorDescription = paramString;
    return this;
  }
  
  public Card setText(String paramString)
  {
    code = paramString;
    return this;
  }
  
  public final String toXML()
  {
    return error;
  }
}
