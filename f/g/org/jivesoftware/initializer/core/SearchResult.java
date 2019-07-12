package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class SearchResult
  extends f.g.org.org.stream.Object
{
  @z
  public String friendlyName;
  @z
  public String kind;
  @z
  public String name;
  @z
  public ByteVector tableReference;
  @z
  public String type;
  
  public SearchResult() {}
  
  public SearchResult clone()
  {
    return (SearchResult)super.clone();
  }
  
  public SearchResult clone(String paramString, Object paramObject)
  {
    return (SearchResult)super.clone(paramString, paramObject);
  }
  
  public String getId()
  {
    return friendlyName;
  }
  
  public String getKind()
  {
    return kind;
  }
  
  public ByteVector getMark()
  {
    return tableReference;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getType()
  {
    return type;
  }
  
  public SearchResult setEtag(String paramString)
  {
    type = paramString;
    return this;
  }
  
  public SearchResult setId(ByteVector paramByteVector)
  {
    tableReference = paramByteVector;
    return this;
  }
  
  public SearchResult setId(String paramString)
  {
    friendlyName = paramString;
    return this;
  }
  
  public SearchResult setKind(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public SearchResult setSnippet(String paramString)
  {
    name = paramString;
    return this;
  }
}
