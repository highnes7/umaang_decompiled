package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.D;
import f.g.org.org.util.Data;
import java.util.List;

public final class AbstractNode
  extends f.g.org.org.stream.Object
{
  @z
  public List<D> children;
  
  static
  {
    Data.nullOf(D.class);
  }
  
  public AbstractNode() {}
  
  public AbstractNode clone()
  {
    return (AbstractNode)super.clone();
  }
  
  public AbstractNode clone(String paramString, Object paramObject)
  {
    return (AbstractNode)super.clone(paramString, paramObject);
  }
  
  public List getChildren()
  {
    return children;
  }
  
  public AbstractNode setChildren(List paramList)
  {
    children = paramList;
    return this;
  }
}
