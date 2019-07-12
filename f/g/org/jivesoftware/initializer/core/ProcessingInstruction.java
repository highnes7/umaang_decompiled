package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.e;
import java.util.List;

public final class ProcessingInstruction
  extends f.g.org.org.stream.Object
{
  @z
  public List<e> errors;
  @z
  public Long index;
  
  public ProcessingInstruction() {}
  
  public ProcessingInstruction clone()
  {
    return (ProcessingInstruction)super.clone();
  }
  
  public ProcessingInstruction clone(String paramString, Object paramObject)
  {
    return (ProcessingInstruction)super.clone(paramString, paramObject);
  }
  
  public Long getIndex()
  {
    return index;
  }
  
  public List getPseudoAttributeNames()
  {
    return errors;
  }
  
  public ProcessingInstruction setData(List paramList)
  {
    errors = paramList;
    return this;
  }
  
  public ProcessingInstruction setPseudoAttribute(Long paramLong)
  {
    index = paramLong;
    return this;
  }
}
