package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.package_10.Preconditions;
import java.util.Iterator;

@a
@b
public final class Ranges
{
  public Ranges() {}
  
  public static Range all()
  {
    return new Range(Cut.belowAll(), Cut.aboveAll());
  }
  
  public static Range atLeast(Comparable paramComparable)
  {
    return new Range(Cut.belowValue(paramComparable), Cut.aboveAll());
  }
  
  public static Range atMost(Comparable paramComparable)
  {
    return new Range(Cut.belowAll(), Cut.aboveValue(paramComparable));
  }
  
  public static Range closed(Comparable paramComparable1, Comparable paramComparable2)
  {
    return new Range(Cut.belowValue(paramComparable1), Cut.aboveValue(paramComparable2));
  }
  
  public static Range closedOpen(Comparable paramComparable1, Comparable paramComparable2)
  {
    return new Range(Cut.belowValue(paramComparable1), Cut.belowValue(paramComparable2));
  }
  
  public static Range create(Cut paramCut1, Cut paramCut2)
  {
    return new Range(paramCut1, paramCut2);
  }
  
  public static Range downTo(Comparable paramComparable, BoundType paramBoundType)
  {
    int i = paramBoundType.ordinal();
    if (i != 0)
    {
      if (i == 1) {
        return atLeast(paramComparable);
      }
      throw new AssertionError();
    }
    return greaterThan(paramComparable);
  }
  
  public static Range encloseAll(Iterable paramIterable)
  {
    if (paramIterable != null)
    {
      if ((paramIterable instanceof ContiguousSet)) {
        return ((ContiguousSet)paramIterable).range();
      }
      Iterator localIterator = paramIterable.iterator();
      paramIterable = localIterator.next();
      Preconditions.checkNotNull(paramIterable);
      Comparable localComparable = (Comparable)paramIterable;
      Object localObject;
      for (paramIterable = localComparable; localIterator.hasNext(); paramIterable = (Comparable)Ordering.natural().max(paramIterable, localObject))
      {
        localObject = localIterator.next();
        Preconditions.checkNotNull(localObject);
        localObject = (Comparable)localObject;
        localComparable = (Comparable)Ordering.natural().min(localComparable, localObject);
      }
      return closed(localComparable, paramIterable);
    }
    paramIterable = new NullPointerException();
    throw paramIterable;
  }
  
  public static Range greaterThan(Comparable paramComparable)
  {
    return new Range(Cut.aboveValue(paramComparable), Cut.aboveAll());
  }
  
  public static Range lessThan(Comparable paramComparable)
  {
    return new Range(Cut.belowAll(), Cut.belowValue(paramComparable));
  }
  
  public static Range open(Comparable paramComparable1, Comparable paramComparable2)
  {
    return new Range(Cut.aboveValue(paramComparable1), Cut.aboveValue(paramComparable2));
  }
  
  public static Range range(Comparable paramComparable1, BoundType paramBoundType1, Comparable paramComparable2, BoundType paramBoundType2)
  {
    if (paramBoundType1 != null)
    {
      if (paramBoundType2 != null)
      {
        if (paramBoundType1 == BoundType.OPEN) {
          paramComparable1 = Cut.aboveValue(paramComparable1);
        } else {
          paramComparable1 = Cut.belowValue(paramComparable1);
        }
        if (paramBoundType2 == BoundType.OPEN) {
          paramBoundType1 = Cut.belowValue(paramComparable2);
        } else {
          paramBoundType1 = Cut.aboveValue(paramComparable2);
        }
        return new Range(paramComparable1, paramBoundType1);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Range range(Comparable paramComparable1, Comparable paramComparable2)
  {
    return new Range(Cut.aboveValue(paramComparable1), Cut.belowValue(paramComparable2));
  }
  
  public static Range singleton(Comparable paramComparable)
  {
    return closed(paramComparable, paramComparable);
  }
  
  public static Range upTo(Comparable paramComparable, BoundType paramBoundType)
  {
    int i = paramBoundType.ordinal();
    if (i != 0)
    {
      if (i == 1) {
        return atMost(paramComparable);
      }
      throw new AssertionError();
    }
    return lessThan(paramComparable);
  }
}
