package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.d.j;
import f.g.b.a.g.z;
import java.math.BigInteger;

public final class ArrayList4
  extends f.g.org.org.stream.Object
{
  @z
  public String first;
  @z
  public String friendlyName;
  @z
  public String kind;
  @j
  @z
  public BigInteger numericId;
  @z
  public Size projectReference;
  
  public ArrayList4() {}
  
  public ArrayList4 bind(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public BigInteger capacity()
  {
    return numericId;
  }
  
  public ArrayList4 clone()
  {
    return (ArrayList4)super.clone();
  }
  
  public ArrayList4 clone(String paramString, Object paramObject)
  {
    return (ArrayList4)super.clone(paramString, paramObject);
  }
  
  public String get()
  {
    return first;
  }
  
  public String getFriendlyName()
  {
    return friendlyName;
  }
  
  public String getKind()
  {
    return kind;
  }
  
  public Size remove()
  {
    return projectReference;
  }
  
  public ArrayList4 resize(Size paramSize)
  {
    projectReference = paramSize;
    return this;
  }
  
  public ArrayList4 resize(String paramString)
  {
    first = paramString;
    return this;
  }
  
  public ArrayList4 resize(BigInteger paramBigInteger)
  {
    numericId = paramBigInteger;
    return this;
  }
  
  public ArrayList4 setSize(String paramString)
  {
    friendlyName = paramString;
    return this;
  }
}
