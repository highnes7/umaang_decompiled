package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.org.org.util.Data;

public final class Vector
  extends f.g.org.org.stream.Object
{
  @z
  public Address defaultDataset;
  @z
  public Boolean dryRun;
  @z
  public String kind;
  @z
  public Long maxResults;
  @z
  public Boolean preserveNulls;
  @z
  public String query;
  @z
  public Long timeoutMs;
  @z
  public Boolean useQueryCache;
  
  public Vector() {}
  
  public Vector add(Boolean paramBoolean)
  {
    dryRun = paramBoolean;
    return this;
  }
  
  public Vector add(Long paramLong)
  {
    maxResults = paramLong;
    return this;
  }
  
  public Vector add(String paramString)
  {
    query = paramString;
    return this;
  }
  
  public Vector clone()
  {
    return (Vector)super.clone();
  }
  
  public Vector clone(String paramString, Object paramObject)
  {
    return (Vector)super.clone(paramString, paramObject);
  }
  
  public String dirty()
  {
    return kind;
  }
  
  public Boolean equals()
  {
    return dryRun;
  }
  
  public String get()
  {
    return query;
  }
  
  public Address getAngle()
  {
    return defaultDataset;
  }
  
  public Boolean getAzimuth()
  {
    return preserveNulls;
  }
  
  public Long getMaxResults()
  {
    return maxResults;
  }
  
  public boolean last()
  {
    Boolean localBoolean = useQueryCache;
    if ((localBoolean != null) && (localBoolean != Data.NULL_BOOLEAN)) {
      return localBoolean.booleanValue();
    }
    return true;
  }
  
  public Vector mul(Address paramAddress)
  {
    defaultDataset = paramAddress;
    return this;
  }
  
  public Vector mul(Boolean paramBoolean)
  {
    preserveNulls = paramBoolean;
    return this;
  }
  
  public Vector mul(Long paramLong)
  {
    timeoutMs = paramLong;
    return this;
  }
  
  public Boolean negate()
  {
    return useQueryCache;
  }
  
  public Vector normalize(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public Long set()
  {
    return timeoutMs;
  }
  
  public Vector sub(Boolean paramBoolean)
  {
    useQueryCache = paramBoolean;
    return this;
  }
}
