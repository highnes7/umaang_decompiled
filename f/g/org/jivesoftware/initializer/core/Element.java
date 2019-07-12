package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.d.j;
import f.g.b.a.g.z;
import java.math.BigInteger;

public final class Element
  extends f.g.org.org.stream.Object
{
  @j
  @z
  public Long creationTime;
  @z
  public String description;
  @z
  public String etag;
  @j
  @z
  public Long expirationTime;
  @z
  public Label externalDataConfiguration;
  @z
  public String friendlyName;
  @z
  public String kind;
  @j
  @z
  public BigInteger lastModifiedTime;
  @z
  public String location;
  @j
  @z
  public Long numBytes;
  @j
  @z
  public BigInteger numRows;
  @z
  public Schema schema;
  @z
  public String selfLink;
  @z
  public NodeList streamingBuffer;
  @z
  public ByteVector tableReference;
  @z
  public String tag;
  @z
  public String type;
  @z
  public Buffer view;
  
  public Element() {}
  
  public Element clone()
  {
    return (Element)super.clone();
  }
  
  public Element clone(String paramString, Object paramObject)
  {
    return (Element)super.clone(paramString, paramObject);
  }
  
  public Element element(String paramString)
  {
    location = paramString;
    return this;
  }
  
  public BigInteger equals()
  {
    return lastModifiedTime;
  }
  
  public Buffer getChild()
  {
    return view;
  }
  
  public NodeList getChildren()
  {
    return streamingBuffer;
  }
  
  public Element getContent(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public Long getContent()
  {
    return creationTime;
  }
  
  public String getContentEnd()
  {
    return friendlyName;
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public String getName()
  {
    return location;
  }
  
  public String getNamespacePrefix()
  {
    return kind;
  }
  
  public String getRoot()
  {
    return selfLink;
  }
  
  public String getText()
  {
    return description;
  }
  
  public Label hasAttributes()
  {
    return externalDataConfiguration;
  }
  
  public Long isBlock()
  {
    return numBytes;
  }
  
  public BigInteger next()
  {
    return numRows;
  }
  
  public Long removeNamespaceDeclaration()
  {
    return expirationTime;
  }
  
  public Element setAttribute(String paramString)
  {
    etag = paramString;
    return this;
  }
  
  public Schema setAttribute()
  {
    return schema;
  }
  
  public Element setAttributes(String paramString)
  {
    type = paramString;
    return this;
  }
  
  public Element setName(Long paramLong)
  {
    numBytes = paramLong;
    return this;
  }
  
  public Element setName(String paramString)
  {
    selfLink = paramString;
    return this;
  }
  
  public Element setNamespace(ByteVector paramByteVector)
  {
    tableReference = paramByteVector;
    return this;
  }
  
  public Element setNamespace(NodeList paramNodeList)
  {
    streamingBuffer = paramNodeList;
    return this;
  }
  
  public Element setNamespace(Long paramLong)
  {
    expirationTime = paramLong;
    return this;
  }
  
  public Element setNamespace(String paramString)
  {
    description = paramString;
    return this;
  }
  
  public Element setNamespace(BigInteger paramBigInteger)
  {
    numRows = paramBigInteger;
    return this;
  }
  
  public Element setText(Buffer paramBuffer)
  {
    view = paramBuffer;
    return this;
  }
  
  public Element setText(Label paramLabel)
  {
    externalDataConfiguration = paramLabel;
    return this;
  }
  
  public Element setText(Schema paramSchema)
  {
    schema = paramSchema;
    return this;
  }
  
  public Element setText(Long paramLong)
  {
    creationTime = paramLong;
    return this;
  }
  
  public Element setText(String paramString)
  {
    friendlyName = paramString;
    return this;
  }
  
  public Element setText(BigInteger paramBigInteger)
  {
    lastModifiedTime = paramBigInteger;
    return this;
  }
  
  public String tag()
  {
    return tag;
  }
  
  public Element tagName(String paramString)
  {
    tag = paramString;
    return this;
  }
  
  public String type()
  {
    return type;
  }
  
  public ByteVector write()
  {
    return tableReference;
  }
}
