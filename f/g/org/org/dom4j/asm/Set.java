package f.g.org.org.dom4j.asm;

import f.g.b.a.g.z;

public class Set
  extends f.g.org.org.stream.Object
{
  @z
  public String error;
  @z("error_description")
  public String errorDescription;
  @z("error_uri")
  public String errorUri;
  
  public Set() {}
  
  public Set clone()
  {
    return (Set)super.clone();
  }
  
  public Set clone(String paramString, Object paramObject)
  {
    return (Set)super.clone(paramString, paramObject);
  }
  
  public final String getAfter()
  {
    return error;
  }
  
  public final String getArguments()
  {
    return errorUri;
  }
  
  public final String getBefore()
  {
    return errorDescription;
  }
  
  public Set groupBy(String paramString)
  {
    if (paramString != null)
    {
      error = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Set setAfter(String paramString)
  {
    errorDescription = paramString;
    return this;
  }
  
  public Set where(String paramString)
  {
    errorUri = paramString;
    return this;
  }
}
