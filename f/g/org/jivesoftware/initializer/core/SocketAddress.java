package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.org.org.util.Data;
import java.util.List;

public final class SocketAddress
  extends f.g.org.org.stream.Object
{
  @z
  public String compression;
  @z
  public String destinationFormat;
  @z
  public String destinationUri;
  @z
  public List<String> destinationUris;
  @z
  public String fieldDelimiter;
  @z
  public Boolean printHeader;
  @z
  public ByteVector sourceTable;
  
  public SocketAddress() {}
  
  public List balls()
  {
    return destinationUris;
  }
  
  public SocketAddress clone()
  {
    return (SocketAddress)super.clone();
  }
  
  public SocketAddress clone(String paramString, Object paramObject)
  {
    return (SocketAddress)super.clone(paramString, paramObject);
  }
  
  public SocketAddress connect(String paramString)
  {
    fieldDelimiter = paramString;
    return this;
  }
  
  public Boolean equals()
  {
    return printHeader;
  }
  
  public SocketAddress getAddress(String paramString)
  {
    destinationFormat = paramString;
    return this;
  }
  
  public String getAddress()
  {
    return destinationUri;
  }
  
  public String getCompression()
  {
    return compression;
  }
  
  public SocketAddress getPort(String paramString)
  {
    destinationUri = paramString;
    return this;
  }
  
  public String getPort()
  {
    return destinationFormat;
  }
  
  public String getSoundPath()
  {
    return fieldDelimiter;
  }
  
  public SocketAddress init(ByteVector paramByteVector)
  {
    sourceTable = paramByteVector;
    return this;
  }
  
  public SocketAddress init(Boolean paramBoolean)
  {
    printHeader = paramBoolean;
    return this;
  }
  
  public SocketAddress init(String paramString)
  {
    compression = paramString;
    return this;
  }
  
  public SocketAddress init(List paramList)
  {
    destinationUris = paramList;
    return this;
  }
  
  public boolean isNull()
  {
    Boolean localBoolean = printHeader;
    if ((localBoolean != null) && (localBoolean != Data.NULL_BOOLEAN)) {
      return localBoolean.booleanValue();
    }
    return true;
  }
  
  public ByteVector putShort()
  {
    return sourceTable;
  }
}
