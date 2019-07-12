package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.M;
import f.g.b.b.a.a.f;
import f.g.org.org.util.Data;
import java.util.List;
import java.util.Map;

public final class Query
  extends f.g.org.org.stream.Object
{
  @z
  public Boolean allowLargeResults;
  @z
  public String createDisposition;
  @z
  public Address defaultDataset;
  @z
  public ByteVector destinationTable;
  @z
  public Boolean flattenResults;
  @z
  public Boolean preserveNulls;
  @z
  public String priority;
  @z
  public String query;
  @z
  public Map<String, f> tableDefinitions;
  @z
  public Boolean useQueryCache;
  @z
  public List<M> userDefinedFunctionResources;
  @z
  public String writeDisposition;
  
  static
  {
    Data.nullOf(f.class);
    Data.nullOf(M.class);
  }
  
  public Query() {}
  
  public Query clone()
  {
    return (Query)super.clone();
  }
  
  public Query clone(String paramString, Object paramObject)
  {
    return (Query)super.clone(paramString, paramObject);
  }
  
  public Boolean equals()
  {
    return preserveNulls;
  }
  
  public Query fork(Boolean paramBoolean)
  {
    preserveNulls = paramBoolean;
    return this;
  }
  
  public Query freeze(Boolean paramBoolean)
  {
    flattenResults = paramBoolean;
    return this;
  }
  
  public Address from()
  {
    return defaultDataset;
  }
  
  public Boolean get()
  {
    return flattenResults;
  }
  
  public boolean getBoolean()
  {
    Boolean localBoolean = flattenResults;
    if ((localBoolean != null) && (localBoolean != Data.NULL_BOOLEAN)) {
      return localBoolean.booleanValue();
    }
    return true;
  }
  
  public Map getFields()
  {
    return tableDefinitions;
  }
  
  public String getLocale()
  {
    return writeDisposition;
  }
  
  public String getMap()
  {
    return createDisposition;
  }
  
  public List getNames()
  {
    return userDefinedFunctionResources;
  }
  
  public String getQuery()
  {
    return query;
  }
  
  public Boolean getTable()
  {
    return useQueryCache;
  }
  
  public Query groupBy(String paramString)
  {
    createDisposition = paramString;
    return this;
  }
  
  public Query having(Boolean paramBoolean)
  {
    useQueryCache = paramBoolean;
    return this;
  }
  
  public boolean isNull()
  {
    Boolean localBoolean = useQueryCache;
    if ((localBoolean != null) && (localBoolean != Data.NULL_BOOLEAN)) {
      return localBoolean.booleanValue();
    }
    return true;
  }
  
  public Query join(Address paramAddress)
  {
    defaultDataset = paramAddress;
    return this;
  }
  
  public Query join(ByteVector paramByteVector)
  {
    destinationTable = paramByteVector;
    return this;
  }
  
  public Query join(Boolean paramBoolean)
  {
    allowLargeResults = paramBoolean;
    return this;
  }
  
  public Query join(String paramString)
  {
    writeDisposition = paramString;
    return this;
  }
  
  public Query join(List paramList)
  {
    userDefinedFunctionResources = paramList;
    return this;
  }
  
  public Query join(Map paramMap)
  {
    tableDefinitions = paramMap;
    return this;
  }
  
  public String join()
  {
    return priority;
  }
  
  public Query limit(String paramString)
  {
    priority = paramString;
    return this;
  }
  
  public Query select(String paramString)
  {
    query = paramString;
    return this;
  }
  
  public Boolean set()
  {
    return allowLargeResults;
  }
  
  public ByteVector union()
  {
    return destinationTable;
  }
}
