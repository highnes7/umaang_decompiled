package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import java.io.Serializable;
import java.util.Iterator;

@b(serializable=true)
public final class LexicographicalOrdering<T>
  extends mf<Iterable<T>>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final mf<? super T> elementOrder;
  
  public LexicographicalOrdering(Ordering paramOrdering)
  {
    elementOrder = paramOrdering;
  }
  
  public int compare(Iterable paramIterable1, Iterable paramIterable2)
  {
    paramIterable1 = paramIterable1.iterator();
    paramIterable2 = paramIterable2.iterator();
    while (paramIterable1.hasNext())
    {
      if (!paramIterable2.hasNext()) {
        return 1;
      }
      int i = elementOrder.compare(paramIterable1.next(), paramIterable2.next());
      if (i != 0) {
        return i;
      }
    }
    if (paramIterable2.hasNext()) {
      return -1;
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof LexicographicalOrdering))
    {
      paramObject = (LexicographicalOrdering)paramObject;
      return elementOrder.equals(elementOrder);
    }
    return false;
  }
  
  public int hashCode()
  {
    return elementOrder.hashCode() ^ 0x7BB78CF5;
  }
  
  public String toString()
  {
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), elementOrder, ".lexicographical()");
  }
}
