package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import java.io.Serializable;
import java.util.List;

@b(serializable=true)
public final class AllEqualOrdering
  extends mf<Object>
  implements Serializable
{
  public static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
  public static final long serialVersionUID = 0L;
  
  public AllEqualOrdering() {}
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return 0;
  }
  
  public ImmutableList immutableSortedCopy(Iterable paramIterable)
  {
    return ImmutableList.copyOf(paramIterable);
  }
  
  public Ordering reverse()
  {
    return this;
  }
  
  public List sortedCopy(Iterable paramIterable)
  {
    return Lists.newArrayList(paramIterable);
  }
  
  public String toString()
  {
    return "Ordering.allEqual()";
  }
}
