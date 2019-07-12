package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import java.util.List;

public final class LinkedList
  extends f.g.org.org.stream.Object
{
  @z
  public String createDisposition;
  @z
  public ByteVector destinationTable;
  @z
  public List<String> sourceUri;
  @z
  public String writeDisposition;
  
  public LinkedList() {}
  
  public LinkedList clone()
  {
    return (LinkedList)super.clone();
  }
  
  public LinkedList clone(String paramString, Object paramObject)
  {
    return (LinkedList)super.clone(paramString, paramObject);
  }
  
  public LinkedList contains(String paramString)
  {
    writeDisposition = paramString;
    return this;
  }
  
  public String getFirst()
  {
    return writeDisposition;
  }
  
  public String getLast()
  {
    return createDisposition;
  }
  
  public ByteVector peekLast()
  {
    return destinationTable;
  }
  
  public LinkedList remove(ByteVector paramByteVector)
  {
    destinationTable = paramByteVector;
    return this;
  }
  
  public LinkedList remove(String paramString)
  {
    createDisposition = paramString;
    return this;
  }
  
  public LinkedList remove(List paramList)
  {
    sourceUri = paramList;
    return this;
  }
  
  public List toArray()
  {
    return sourceUri;
  }
}
