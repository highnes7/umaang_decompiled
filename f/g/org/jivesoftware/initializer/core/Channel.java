package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class Channel
  extends f.g.org.org.stream.Object
{
  @z
  public CSVParserBuilder configuration;
  @z
  public String etag;
  @z
  public String id;
  @z
  public ExtensionData jobReference;
  @z
  public String kind;
  @z
  public String selfLink;
  @z
  public Node statistics;
  @z
  public GeoPointDto status;
  @z("user_email")
  public String userEmail;
  
  public Channel() {}
  
  public Channel clone()
  {
    return (Channel)super.clone();
  }
  
  public Channel clone(String paramString, Object paramObject)
  {
    return (Channel)super.clone(paramString, paramObject);
  }
  
  public Channel close(String paramString)
  {
    selfLink = paramString;
    return this;
  }
  
  public CSVParserBuilder connect()
  {
    return configuration;
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getKind()
  {
    return kind;
  }
  
  public String getLastBuildDate()
  {
    return userEmail;
  }
  
  public String getProvider()
  {
    return selfLink;
  }
  
  public Node getStatistics()
  {
    return statistics;
  }
  
  public ExtensionData isEOF()
  {
    return jobReference;
  }
  
  public Channel setId(String paramString)
  {
    id = paramString;
    return this;
  }
  
  public Channel setSnippet(CSVParserBuilder paramCSVParserBuilder)
  {
    configuration = paramCSVParserBuilder;
    return this;
  }
  
  public Channel setSnippet(ExtensionData paramExtensionData)
  {
    jobReference = paramExtensionData;
    return this;
  }
  
  public Channel setSnippet(Node paramNode)
  {
    statistics = paramNode;
    return this;
  }
  
  public Channel setSnippet(String paramString)
  {
    userEmail = paramString;
    return this;
  }
  
  public Channel setStatus(GeoPointDto paramGeoPointDto)
  {
    status = paramGeoPointDto;
    return this;
  }
  
  public Channel setStatus(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public Channel start(String paramString)
  {
    etag = paramString;
    return this;
  }
  
  public GeoPointDto start()
  {
    return status;
  }
}
