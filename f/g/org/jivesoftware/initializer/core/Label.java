package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import java.util.List;

public final class Label
  extends f.g.org.org.stream.Object
{
  @z
  public String compression;
  @z
  public XMLElement csvOptions;
  @z
  public Boolean ignoreUnknownValues;
  @z
  public Integer maxBadRecords;
  @z
  public Schema schema;
  @z
  public String sourceFormat;
  @z
  public List<String> sourceUris;
  
  public Label() {}
  
  public Label a(XMLElement paramXMLElement)
  {
    csvOptions = paramXMLElement;
    return this;
  }
  
  public Label a(Boolean paramBoolean)
  {
    ignoreUnknownValues = paramBoolean;
    return this;
  }
  
  public Label a(Integer paramInteger)
  {
    maxBadRecords = paramInteger;
    return this;
  }
  
  public Label a(List paramList)
  {
    sourceUris = paramList;
    return this;
  }
  
  public Label clone()
  {
    return (Label)super.clone();
  }
  
  public Label clone(String paramString, Object paramObject)
  {
    return (Label)super.clone(paramString, paramObject);
  }
  
  public XMLElement getFirst()
  {
    return csvOptions;
  }
  
  public Boolean getMbid()
  {
    return ignoreUnknownValues;
  }
  
  public String getName()
  {
    return compression;
  }
  
  public List getNames()
  {
    return sourceUris;
  }
  
  public String getSourceString()
  {
    return sourceFormat;
  }
  
  public Integer getStart()
  {
    return maxBadRecords;
  }
  
  public Schema isNull()
  {
    return schema;
  }
  
  public Label setName(String paramString)
  {
    sourceFormat = paramString;
    return this;
  }
  
  public Label setUrl(Schema paramSchema)
  {
    schema = paramSchema;
    return this;
  }
  
  public Label setUrl(String paramString)
  {
    compression = paramString;
    return this;
  }
}
