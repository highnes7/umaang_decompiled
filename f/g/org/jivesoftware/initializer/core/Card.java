package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class Card
  extends f.g.org.org.stream.Object
{
  @z
  public CSVParserBuilder configuration;
  @z
  public Message errorResult;
  @z
  public ExtensionData jobReference;
  @z
  public String kind;
  @z
  public String mArtist;
  @z
  public String state;
  @z
  public Node statistics;
  @z
  public GeoPointDto status;
  @z("user_email")
  public String userEmail;
  
  public Card() {}
  
  public Card clone()
  {
    return (Card)super.clone();
  }
  
  public Card clone(String paramString, Object paramObject)
  {
    return (Card)super.clone(paramString, paramObject);
  }
  
  public String getArtist()
  {
    return mArtist;
  }
  
  public Message getDid()
  {
    return errorResult;
  }
  
  public String getFactor()
  {
    return userEmail;
  }
  
  public String getFlavor()
  {
    return kind;
  }
  
  public Node getLeft()
  {
    return statistics;
  }
  
  public String getValue()
  {
    return state;
  }
  
  public CSVParserBuilder isMultiChoiceEnabled()
  {
    return configuration;
  }
  
  public ExtensionData isSwipeable()
  {
    return jobReference;
  }
  
  public Card load(GeoPointDto paramGeoPointDto)
  {
    status = paramGeoPointDto;
    return this;
  }
  
  public Card load(String paramString)
  {
    state = paramString;
    return this;
  }
  
  public Card setArtist(String paramString)
  {
    mArtist = paramString;
    return this;
  }
  
  public Card setCheckable(CSVParserBuilder paramCSVParserBuilder)
  {
    configuration = paramCSVParserBuilder;
    return this;
  }
  
  public Card setCheckable(ExtensionData paramExtensionData)
  {
    jobReference = paramExtensionData;
    return this;
  }
  
  public Card setCheckable(Message paramMessage)
  {
    errorResult = paramMessage;
    return this;
  }
  
  public Card setId(String paramString)
  {
    userEmail = paramString;
    return this;
  }
  
  public Card setText(Node paramNode)
  {
    statistics = paramNode;
    return this;
  }
  
  public Card setText(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public GeoPointDto toXML()
  {
    return status;
  }
}
