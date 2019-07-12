package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class XMLElement
  extends f.g.org.org.stream.Object
{
  @z
  public Boolean allowJaggedRows;
  @z
  public Boolean allowQuotedNewlines;
  @z
  public String encoding;
  @z
  public String fieldDelimiter;
  @z
  public String quote;
  @z
  public Integer skipLeadingRows;
  
  public XMLElement() {}
  
  public XMLElement clone()
  {
    return (XMLElement)super.clone();
  }
  
  public XMLElement clone(String paramString, Object paramObject)
  {
    return (XMLElement)super.clone(paramString, paramObject);
  }
  
  public XMLElement getChild(Boolean paramBoolean)
  {
    allowQuotedNewlines = paramBoolean;
    return this;
  }
  
  public XMLElement getChild(String paramString)
  {
    fieldDelimiter = paramString;
    return this;
  }
  
  public Integer getChildCount()
  {
    return skipLeadingRows;
  }
  
  public String getLocalName()
  {
    return fieldDelimiter;
  }
  
  public String getNamespace()
  {
    return quote;
  }
  
  public String getSystemID()
  {
    return encoding;
  }
  
  public Boolean hasChildren()
  {
    return allowJaggedRows;
  }
  
  public XMLElement init(Integer paramInteger)
  {
    skipLeadingRows = paramInteger;
    return this;
  }
  
  public XMLElement init(String paramString)
  {
    encoding = paramString;
    return this;
  }
  
  public Boolean remove()
  {
    return allowQuotedNewlines;
  }
  
  public XMLElement save(Boolean paramBoolean)
  {
    allowJaggedRows = paramBoolean;
    return this;
  }
  
  public XMLElement setName(String paramString)
  {
    quote = paramString;
    return this;
  }
}
