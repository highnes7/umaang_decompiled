package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.x.a;
import f.g.org.org.util.Data;
import java.util.List;

public final class Comment
  extends f.g.org.org.stream.Object
{
  @z
  public String etag;
  @z
  public String kind;
  @z
  public String nextPageToken;
  @z
  public List<x.a> projects;
  @z
  public Integer totalItems;
  
  static
  {
    Data.nullOf(x.a.class);
  }
  
  public Comment() {}
  
  public Comment clear(List paramList)
  {
    projects = paramList;
    return this;
  }
  
  public Comment clone()
  {
    return (Comment)super.clone();
  }
  
  public Comment clone(String paramString, Object paramObject)
  {
    return (Comment)super.clone(paramString, paramObject);
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public String getKind()
  {
    return kind;
  }
  
  public List getText()
  {
    return projects;
  }
  
  public String getUsername()
  {
    return nextPageToken;
  }
  
  public Integer getValue()
  {
    return totalItems;
  }
  
  public Comment setEtag(String paramString)
  {
    etag = paramString;
    return this;
  }
  
  public Comment setId(Integer paramInteger)
  {
    totalItems = paramInteger;
    return this;
  }
  
  public Comment setKind(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public Comment setUpdatedAt(String paramString)
  {
    nextPageToken = paramString;
    return this;
  }
}
