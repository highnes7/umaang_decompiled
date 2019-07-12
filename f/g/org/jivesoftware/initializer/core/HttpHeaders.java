package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.d.j;
import f.g.b.a.g.z;
import f.g.b.b.a.a.b.a;
import f.g.org.org.util.Data;
import java.util.List;

public final class HttpHeaders
  extends f.g.org.org.stream.Object
{
  @z
  public List<b.a> access;
  @j
  @z
  public Long creationTime;
  @z
  public Address datasetReference;
  @j
  @z
  public Long defaultTableExpirationMs;
  @z
  public String description;
  @z
  public String etag;
  @z
  public String friendlyName;
  @z
  public String kind;
  @j
  @z
  public Long lastModifiedTime;
  @z
  public String location;
  @z
  public String selfLink;
  @z
  public String val;
  
  static
  {
    Data.nullOf(b.a.class);
  }
  
  public HttpHeaders() {}
  
  public HttpHeaders clone()
  {
    return (HttpHeaders)super.clone();
  }
  
  public HttpHeaders clone(String paramString, Object paramObject)
  {
    return (HttpHeaders)super.clone(paramString, paramObject);
  }
  
  public List get()
  {
    return access;
  }
  
  public String getAccept()
  {
    return kind;
  }
  
  public String getAcceptEncoding()
  {
    return friendlyName;
  }
  
  public Long getAge()
  {
    return defaultTableExpirationMs;
  }
  
  public Address getCookie()
  {
    return datasetReference;
  }
  
  public String getETag()
  {
    return etag;
  }
  
  public String getFirst()
  {
    return val;
  }
  
  public String getIfModifiedSince()
  {
    return description;
  }
  
  public String getIfNoneMatch()
  {
    return selfLink;
  }
  
  public Long getLastModified()
  {
    return creationTime;
  }
  
  public String getLocation()
  {
    return location;
  }
  
  public HttpHeaders set(Long paramLong)
  {
    creationTime = paramLong;
    return this;
  }
  
  public Long set()
  {
    return lastModifiedTime;
  }
  
  public HttpHeaders setAccept(String paramString)
  {
    val = paramString;
    return this;
  }
  
  public HttpHeaders setAccept(List paramList)
  {
    access = paramList;
    return this;
  }
  
  public HttpHeaders setAcceptEncoding(String paramString)
  {
    selfLink = paramString;
    return this;
  }
  
  public HttpHeaders setAuthorization(Address paramAddress)
  {
    datasetReference = paramAddress;
    return this;
  }
  
  public HttpHeaders setCacheControl(String paramString)
  {
    description = paramString;
    return this;
  }
  
  public HttpHeaders setContentLength(Long paramLong)
  {
    lastModifiedTime = paramLong;
    return this;
  }
  
  public HttpHeaders setDate(Long paramLong)
  {
    defaultTableExpirationMs = paramLong;
    return this;
  }
  
  public HttpHeaders setETag(String paramString)
  {
    etag = paramString;
    return this;
  }
  
  public HttpHeaders setIfNoneMatch(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public HttpHeaders setIfUnmodifiedSince(String paramString)
  {
    friendlyName = paramString;
    return this;
  }
  
  public HttpHeaders setLocation(String paramString)
  {
    location = paramString;
    return this;
  }
}
