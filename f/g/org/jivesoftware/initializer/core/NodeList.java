package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.d.j;
import f.g.b.a.g.z;
import java.math.BigInteger;

public final class NodeList
  extends f.g.org.org.stream.Object
{
  @j
  @z
  public BigInteger estimatedBytes;
  @j
  @z
  public BigInteger estimatedRows;
  @j
  @z
  public BigInteger oldestEntryTime;
  
  public NodeList() {}
  
  public NodeList add(BigInteger paramBigInteger)
  {
    estimatedBytes = paramBigInteger;
    return this;
  }
  
  public BigInteger asString()
  {
    return estimatedRows;
  }
  
  public NodeList clone()
  {
    return (NodeList)super.clone();
  }
  
  public NodeList clone(String paramString, Object paramObject)
  {
    return (NodeList)super.clone(paramString, paramObject);
  }
  
  public BigInteger elementAt()
  {
    return estimatedBytes;
  }
  
  public NodeList prepend(BigInteger paramBigInteger)
  {
    oldestEntryTime = paramBigInteger;
    return this;
  }
  
  public BigInteger prepend()
  {
    return oldestEntryTime;
  }
  
  public NodeList removeAll(BigInteger paramBigInteger)
  {
    estimatedRows = paramBigInteger;
    return this;
  }
}
