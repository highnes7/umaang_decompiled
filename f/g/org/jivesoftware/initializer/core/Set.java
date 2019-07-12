package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.d.j;
import f.g.b.a.g.z;
import f.g.b.b.a.a.K;
import f.g.b.b.a.a.e;
import java.math.BigInteger;
import java.util.List;

public final class Set
  extends f.g.org.org.stream.Object
{
  @z
  public Boolean cacheHit;
  @z
  public List<e> errors;
  @z
  public String etag;
  @z
  public Boolean jobComplete;
  @z
  public ExtensionData jobReference;
  @z
  public String kind;
  @z
  public String pageToken;
  @z
  public List<K> rows;
  @z
  public Schema schema;
  @j
  @z
  public Long totalBytesProcessed;
  @j
  @z
  public BigInteger totalRows;
  
  public Set() {}
  
  public Set clone()
  {
    return (Set)super.clone();
  }
  
  public Set clone(String paramString, Object paramObject)
  {
    return (Set)super.clone(paramString, paramObject);
  }
  
  public Long count()
  {
    return totalBytesProcessed;
  }
  
  public String getAfter()
  {
    return kind;
  }
  
  public List getArguments()
  {
    return errors;
  }
  
  public String getBefore()
  {
    return pageToken;
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public Boolean getFirst()
  {
    return jobComplete;
  }
  
  public Boolean getFirstIndex()
  {
    return cacheHit;
  }
  
  public Schema getSchema()
  {
    return schema;
  }
  
  public ExtensionData getTable()
  {
    return jobReference;
  }
  
  public List query()
  {
    return rows;
  }
  
  public Set setAfter(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public Set setBefore(String paramString)
  {
    pageToken = paramString;
    return this;
  }
  
  public Set setCount(Boolean paramBoolean)
  {
    jobComplete = paramBoolean;
    return this;
  }
  
  public Set setCount(List paramList)
  {
    errors = paramList;
    return this;
  }
  
  public BigInteger toSql()
  {
    return totalRows;
  }
  
  public Set where(ExtensionData paramExtensionData)
  {
    jobReference = paramExtensionData;
    return this;
  }
  
  public Set where(Schema paramSchema)
  {
    schema = paramSchema;
    return this;
  }
  
  public Set where(Boolean paramBoolean)
  {
    cacheHit = paramBoolean;
    return this;
  }
  
  public Set where(Long paramLong)
  {
    totalBytesProcessed = paramLong;
    return this;
  }
  
  public Set where(String paramString)
  {
    etag = paramString;
    return this;
  }
  
  public Set where(BigInteger paramBigInteger)
  {
    totalRows = paramBigInteger;
    return this;
  }
  
  public Set where(List paramList)
  {
    rows = paramList;
    return this;
  }
}
