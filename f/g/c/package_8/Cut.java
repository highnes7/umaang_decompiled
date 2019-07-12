package f.g.c.package_8;

import f.g.c.d.la;
import java.io.Serializable;

@f.g.c.a.b
public abstract class Cut<C extends Comparable>
  implements Comparable<la<C>>, Serializable
{
  public static final long serialVersionUID = 0L;
  public final C endpoint;
  
  public Cut(Comparable paramComparable)
  {
    endpoint = paramComparable;
  }
  
  public static Cut aboveAll()
  {
    return la.a.h;
  }
  
  public static Cut aboveValue(Comparable paramComparable)
  {
    return new la.b(paramComparable);
  }
  
  public static Cut belowAll()
  {
    return la.c.GERMAN;
  }
  
  public static Cut belowValue(Comparable paramComparable)
  {
    return new la.d(paramComparable);
  }
  
  public Cut canonical(DiscreteDomain paramDiscreteDomain)
  {
    return this;
  }
  
  public int compareTo(Cut paramCut)
  {
    if (paramCut == la.c.GERMAN) {
      return 1;
    }
    if (paramCut == la.a.h) {
      return -1;
    }
    int i = endpoint.compareTo(endpoint);
    if (i != 0) {
      return i;
    }
    return f.g.c.j.b.a(this instanceof la.b, paramCut instanceof la.b);
  }
  
  public abstract void describeAsLowerBound(StringBuilder paramStringBuilder);
  
  public abstract void describeAsUpperBound(StringBuilder paramStringBuilder);
  
  public Comparable endpoint()
  {
    return endpoint;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Cut))
    {
      paramObject = (Cut)paramObject;
      try
      {
        int i = compareTo(paramObject);
        if (i == 0) {
          return true;
        }
      }
      catch (ClassCastException paramObject) {}
    }
    return false;
  }
  
  public abstract Comparable greatestValueBelow(DiscreteDomain paramDiscreteDomain);
  
  public abstract boolean isLessThan(Comparable paramComparable);
  
  public abstract Comparable leastValueAbove(DiscreteDomain paramDiscreteDomain);
  
  public abstract BoundType typeAsLowerBound();
  
  public abstract BoundType typeAsUpperBound();
  
  public abstract Cut withLowerBoundType(BoundType paramBoundType, DiscreteDomain paramDiscreteDomain);
  
  public abstract Cut withUpperBoundType(BoundType paramBoundType, DiscreteDomain paramDiscreteDomain);
}
