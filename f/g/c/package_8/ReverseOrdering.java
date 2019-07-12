package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import java.io.Serializable;
import java.util.Iterator;

@b(serializable=true)
public final class ReverseOrdering<T>
  extends mf<T>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final mf<? super T> forwardOrder;
  
  public ReverseOrdering(Ordering paramOrdering)
  {
    if (paramOrdering != null)
    {
      forwardOrder = paramOrdering;
      return;
    }
    throw new NullPointerException();
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return forwardOrder.compare(paramObject2, paramObject1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ReverseOrdering))
    {
      paramObject = (ReverseOrdering)paramObject;
      return forwardOrder.equals(forwardOrder);
    }
    return false;
  }
  
  public int hashCode()
  {
    return -forwardOrder.hashCode();
  }
  
  public Object max(Iterable paramIterable)
  {
    return forwardOrder.min(paramIterable);
  }
  
  public Object max(Object paramObject1, Object paramObject2)
  {
    return forwardOrder.min(paramObject1, paramObject2);
  }
  
  public Object max(Object paramObject1, Object paramObject2, Object paramObject3, Object... paramVarArgs)
  {
    return forwardOrder.min(paramObject1, paramObject2, paramObject3, paramVarArgs);
  }
  
  public Object max(Iterator paramIterator)
  {
    return forwardOrder.min(paramIterator);
  }
  
  public Object min(Iterable paramIterable)
  {
    return forwardOrder.max(paramIterable);
  }
  
  public Object min(Object paramObject1, Object paramObject2)
  {
    return forwardOrder.max(paramObject1, paramObject2);
  }
  
  public Object min(Object paramObject1, Object paramObject2, Object paramObject3, Object... paramVarArgs)
  {
    return forwardOrder.max(paramObject1, paramObject2, paramObject3, paramVarArgs);
  }
  
  public Object min(Iterator paramIterator)
  {
    return forwardOrder.max(paramIterator);
  }
  
  public Ordering reverse()
  {
    return forwardOrder;
  }
  
  public String toString()
  {
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), forwardOrder, ".reverse()");
  }
}
