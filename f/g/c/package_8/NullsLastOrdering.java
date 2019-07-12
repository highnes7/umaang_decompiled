package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import java.io.Serializable;

@b(serializable=true)
public final class NullsLastOrdering<T>
  extends mf<T>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final mf<? super T> ordering;
  
  public NullsLastOrdering(Ordering paramOrdering)
  {
    ordering = paramOrdering;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return 0;
    }
    if (paramObject1 == null) {
      return 1;
    }
    if (paramObject2 == null) {
      return -1;
    }
    return ordering.compare(paramObject1, paramObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof NullsLastOrdering))
    {
      paramObject = (NullsLastOrdering)paramObject;
      return ordering.equals(ordering);
    }
    return false;
  }
  
  public int hashCode()
  {
    return ordering.hashCode() ^ 0xC9177248;
  }
  
  public Ordering nullsFirst()
  {
    return ordering.nullsFirst();
  }
  
  public Ordering nullsLast()
  {
    return this;
  }
  
  public Ordering reverse()
  {
    return ordering.reverse().nullsFirst();
  }
  
  public String toString()
  {
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), ordering, ".nullsLast()");
  }
}
