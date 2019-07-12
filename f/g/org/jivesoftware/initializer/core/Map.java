package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.J;
import java.util.List;

public final class Map
  extends f.g.org.org.stream.Object
{
  @z
  public String createDisposition;
  @z
  public ByteVector destinationTable;
  @z
  public ByteVector sourceTable;
  @z
  public List<J> sourceTables;
  @z
  public String writeDisposition;
  
  public Map() {}
  
  public Map clone()
  {
    return (Map)super.clone();
  }
  
  public Map clone(String paramString, Object paramObject)
  {
    return (Map)super.clone(paramString, paramObject);
  }
  
  public String getGoal()
  {
    return writeDisposition;
  }
  
  public ByteVector getGoals()
  {
    return sourceTable;
  }
  
  public String getIndex()
  {
    return createDisposition;
  }
  
  public List getOverlays()
  {
    return sourceTables;
  }
  
  public ByteVector getViewBox()
  {
    return destinationTable;
  }
  
  public Map setLocation(String paramString)
  {
    createDisposition = paramString;
    return this;
  }
  
  public Map setViewBox(ByteVector paramByteVector)
  {
    sourceTable = paramByteVector;
    return this;
  }
  
  public Map updateProfile(ByteVector paramByteVector)
  {
    destinationTable = paramByteVector;
    return this;
  }
  
  public Map updateProfile(String paramString)
  {
    writeDisposition = paramString;
    return this;
  }
  
  public Map updateProfile(List paramList)
  {
    sourceTables = paramList;
    return this;
  }
}
