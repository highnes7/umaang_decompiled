package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import java.util.List;

public final class Attribute
  extends f.g.org.org.stream.Object
{
  @z
  public Boolean allowJaggedRows;
  @z
  public Boolean allowQuotedNewlines;
  @z
  public String createDisposition;
  @z
  public ByteVector destinationTable;
  @z
  public String encoding;
  @z
  public String fieldDelimiter;
  @z
  public Boolean ignoreUnknownValues;
  @z
  public Integer maxBadRecords;
  @z
  public List<String> projectionFields;
  @z
  public String quote;
  @z
  public Schema schema;
  @z
  public String schemaInline;
  @z
  public String schemaInlineFormat;
  @z
  public Integer skipLeadingRows;
  @z
  public String sourceFormat;
  @z
  public List<String> sourceUris;
  @z
  public String writeDisposition;
  
  public Attribute() {}
  
  public Attribute a(ByteVector paramByteVector)
  {
    destinationTable = paramByteVector;
    return this;
  }
  
  public Attribute a(Boolean paramBoolean)
  {
    ignoreUnknownValues = paramBoolean;
    return this;
  }
  
  public Attribute a(Integer paramInteger)
  {
    maxBadRecords = paramInteger;
    return this;
  }
  
  public Attribute a(String paramString)
  {
    fieldDelimiter = paramString;
    return this;
  }
  
  public Attribute a(List paramList)
  {
    projectionFields = paramList;
    return this;
  }
  
  public Attribute attribute(String paramString)
  {
    encoding = paramString;
    return this;
  }
  
  public Attribute clone()
  {
    return (Attribute)super.clone();
  }
  
  public Attribute clone(String paramString, Object paramObject)
  {
    return (Attribute)super.clone(paramString, paramObject);
  }
  
  public String encode()
  {
    return schemaInline;
  }
  
  public String getAttributeType()
  {
    return schemaInlineFormat;
  }
  
  public Boolean getBooleanValue()
  {
    return allowQuotedNewlines;
  }
  
  public List getChoices()
  {
    return sourceUris;
  }
  
  public String getLocalizedString()
  {
    return sourceFormat;
  }
  
  public String getNamespace()
  {
    return fieldDelimiter;
  }
  
  public String getNamespacePrefix()
  {
    return createDisposition;
  }
  
  public String getNamespaceURI()
  {
    return writeDisposition;
  }
  
  public List getOptions()
  {
    return projectionFields;
  }
  
  public Integer getParent()
  {
    return maxBadRecords;
  }
  
  public String getQuote()
  {
    return quote;
  }
  
  public Schema getSchema()
  {
    return schema;
  }
  
  public Boolean getState()
  {
    return allowJaggedRows;
  }
  
  public String getString()
  {
    return encoding;
  }
  
  public Boolean getValueAsBoolean()
  {
    return ignoreUnknownValues;
  }
  
  public Attribute read(Schema paramSchema)
  {
    schema = paramSchema;
    return this;
  }
  
  public Attribute read(String paramString)
  {
    sourceFormat = paramString;
    return this;
  }
  
  public Integer read()
  {
    return skipLeadingRows;
  }
  
  public Attribute readFrom(String paramString)
  {
    writeDisposition = paramString;
    return this;
  }
  
  public Attribute setName(String paramString)
  {
    quote = paramString;
    return this;
  }
  
  public Attribute setNamespace(Boolean paramBoolean)
  {
    allowQuotedNewlines = paramBoolean;
    return this;
  }
  
  public Attribute setNamespace(String paramString)
  {
    schemaInline = paramString;
    return this;
  }
  
  public Attribute setNamespace(List paramList)
  {
    sourceUris = paramList;
    return this;
  }
  
  public Attribute setParent(Integer paramInteger)
  {
    skipLeadingRows = paramInteger;
    return this;
  }
  
  public Attribute setParent(String paramString)
  {
    schemaInlineFormat = paramString;
    return this;
  }
  
  public Attribute setValue(Boolean paramBoolean)
  {
    allowJaggedRows = paramBoolean;
    return this;
  }
  
  public Attribute setValue(String paramString)
  {
    createDisposition = paramString;
    return this;
  }
  
  public ByteVector write()
  {
    return destinationTable;
  }
}
