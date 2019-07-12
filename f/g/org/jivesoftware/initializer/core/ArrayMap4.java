package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.d.j;
import f.g.b.a.g.z;
import f.g.b.b.a.a.K;
import java.util.List;

public final class ArrayMap4
  extends f.g.org.org.stream.Object
{
  @z
  public String etag;
  @z
  public String kind;
  @z
  public String pageToken;
  @z
  public List<K> rows;
  @j
  @z
  public Long totalRows;
  
  public ArrayMap4() {}
  
  public ArrayMap4 bind(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public ArrayMap4 clear(List paramList)
  {
    rows = paramList;
    return this;
  }
  
  public ArrayMap4 clone()
  {
    return (ArrayMap4)super.clone();
  }
  
  public ArrayMap4 clone(String paramString, Object paramObject)
  {
    return (ArrayMap4)super.clone(paramString, paramObject);
  }
  
  public ArrayMap4 delete(String paramString)
  {
    etag = paramString;
    return this;
  }
  
  public String delete()
  {
    return etag;
  }
  
  public String getKind()
  {
    return kind;
  }
  
  public List getRows()
  {
    return rows;
  }
  
  public ArrayMap4 insert(Long paramLong)
  {
    totalRows = paramLong;
    return this;
  }
  
  public ArrayMap4 insert(String paramString)
  {
    pageToken = paramString;
    return this;
  }
  
  public Long insert()
  {
    return totalRows;
  }
  
  public String replace()
  {
    return pageToken;
  }
}
