package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.d.j;
import f.g.b.a.g.z;
import f.g.b.b.a.a.K;
import f.g.b.b.a.a.e;
import f.g.org.org.util.Data;
import java.math.BigInteger;
import java.util.List;

public final class Document
  extends f.g.org.org.stream.Object
{
  @z
  public Boolean cacheHit;
  @z
  public List<e> errors;
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
  
  static
  {
    Data.nullOf(e.class);
    Data.nullOf(K.class);
  }
  
  public Document() {}
  
  public Document addContent(String paramString)
  {
    pageToken = paramString;
    return this;
  }
  
  public String cleanUp()
  {
    return pageToken;
  }
  
  public Document clone()
  {
    return (Document)super.clone();
  }
  
  public Document clone(String paramString, Object paramObject)
  {
    return (Document)super.clone(paramString, paramObject);
  }
  
  public String getBaseURI()
  {
    return kind;
  }
  
  public ExtensionData getPageNumber()
  {
    return jobReference;
  }
  
  public BigInteger getRootElement()
  {
    return totalRows;
  }
  
  public List getRow()
  {
    return rows;
  }
  
  public Schema getSchema()
  {
    return schema;
  }
  
  public Boolean getStandalone()
  {
    return jobComplete;
  }
  
  public Document init(List paramList)
  {
    errors = paramList;
    return this;
  }
  
  public Boolean isOpen()
  {
    return cacheHit;
  }
  
  public Document outputSettings(ExtensionData paramExtensionData)
  {
    jobReference = paramExtensionData;
    return this;
  }
  
  public Document outputSettings(Schema paramSchema)
  {
    schema = paramSchema;
    return this;
  }
  
  public Document outputSettings(Boolean paramBoolean)
  {
    cacheHit = paramBoolean;
    return this;
  }
  
  public Document outputSettings(Long paramLong)
  {
    totalBytesProcessed = paramLong;
    return this;
  }
  
  public Document outputSettings(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public Document outputSettings(BigInteger paramBigInteger)
  {
    totalRows = paramBigInteger;
    return this;
  }
  
  public Document quirksMode(Boolean paramBoolean)
  {
    jobComplete = paramBoolean;
    return this;
  }
  
  public Document setContent(List paramList)
  {
    rows = paramList;
    return this;
  }
  
  public List setProperty()
  {
    return errors;
  }
  
  public Long top()
  {
    return totalBytesProcessed;
  }
}
