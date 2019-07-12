package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.I.a;
import f.g.org.org.util.Data;
import java.util.List;

public final class Subscription
  extends f.g.org.org.stream.Object
{
  @z
  public String etag;
  @z
  public String kind;
  @z
  public String nextPageToken;
  @z
  public List<I.a> tables;
  @z
  public Integer totalItems;
  
  static
  {
    Data.nullOf(I.a.class);
  }
  
  public Subscription() {}
  
  public Subscription clone()
  {
    return (Subscription)super.clone();
  }
  
  public Subscription clone(String paramString, Object paramObject)
  {
    return (Subscription)super.clone(paramString, paramObject);
  }
  
  public List getAttributes()
  {
    return tables;
  }
  
  public String getEngine()
  {
    return nextPageToken;
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public Integer getIcon()
  {
    return totalItems;
  }
  
  public String getKind()
  {
    return kind;
  }
  
  public Subscription init(List paramList)
  {
    tables = paramList;
    return this;
  }
  
  public Subscription setEtag(String paramString)
  {
    etag = paramString;
    return this;
  }
  
  public Subscription setId(Integer paramInteger)
  {
    totalItems = paramInteger;
    return this;
  }
  
  public Subscription setKind(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public Subscription setSnippet(String paramString)
  {
    nextPageToken = paramString;
    return this;
  }
}
