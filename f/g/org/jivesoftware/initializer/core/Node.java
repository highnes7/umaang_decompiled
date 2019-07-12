package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.d.j;
import f.g.b.a.g.z;

public final class Node
  extends f.g.org.org.stream.Object
{
  @j
  @z
  public Long creationTime;
  @j
  @z
  public Long endTime;
  @z
  public Elements extract;
  @z
  public JsonWebToken.Payload load;
  @z
  public JsonWebSignature.Header query;
  @j
  @z
  public Long startTime;
  @j
  @z
  public Long totalBytesProcessed;
  
  public Node() {}
  
  public Node clone()
  {
    return (Node)super.clone();
  }
  
  public Node clone(String paramString, Object paramObject)
  {
    return (Node)super.clone(paramString, paramObject);
  }
  
  public Long createTime()
  {
    return creationTime;
  }
  
  public Node doClone(Long paramLong)
  {
    totalBytesProcessed = paramLong;
    return this;
  }
  
  public Long dump()
  {
    return startTime;
  }
  
  public Long getValue()
  {
    return endTime;
  }
  
  public JsonWebToken.Payload load()
  {
    return load;
  }
  
  public JsonWebSignature.Header remove()
  {
    return query;
  }
  
  public Node remove(Elements paramElements)
  {
    extract = paramElements;
    return this;
  }
  
  public Node remove(JsonWebSignature.Header paramHeader)
  {
    query = paramHeader;
    return this;
  }
  
  public Node remove(JsonWebToken.Payload paramPayload)
  {
    load = paramPayload;
    return this;
  }
  
  public Node remove(Long paramLong)
  {
    startTime = paramLong;
    return this;
  }
  
  public Long replaceChild()
  {
    return totalBytesProcessed;
  }
  
  public Node set(Long paramLong)
  {
    creationTime = paramLong;
    return this;
  }
  
  public Node setType(Long paramLong)
  {
    endTime = paramLong;
    return this;
  }
  
  public Elements unwrap()
  {
    return extract;
  }
}
