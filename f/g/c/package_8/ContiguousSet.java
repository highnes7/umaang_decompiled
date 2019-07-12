package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.d.Wb;
import f.g.c.d.oa;
import f.g.c.package_10.Preconditions;
import java.util.Comparator;
import java.util.NoSuchElementException;

@a
@b(emulated=true)
public abstract class ContiguousSet<C extends Comparable>
  extends Wb<C>
{
  public final oa<C> domain;
  
  public ContiguousSet(DiscreteDomain paramDiscreteDomain)
  {
    super(Ordering.natural());
    domain = paramDiscreteDomain;
  }
  
  public static ContiguousSet create(Range paramRange, DiscreteDomain paramDiscreteDomain)
  {
    if (paramRange != null)
    {
      if (paramDiscreteDomain != null) {
        try
        {
          boolean bool = paramRange.hasLowerBound();
          Range localRange1;
          if (!bool) {
            localRange1 = paramRange.intersection(Ranges.atLeast(paramDiscreteDomain.minValue()));
          } else {
            localRange1 = paramRange;
          }
          bool = paramRange.hasUpperBound();
          Range localRange2 = localRange1;
          if (!bool) {
            localRange2 = localRange1.intersection(Ranges.atMost(paramDiscreteDomain.maxValue()));
          }
          int i;
          if ((!localRange2.isEmpty()) && (lowerBound.leastValueAbove(paramDiscreteDomain).compareTo(upperBound.greatestValueBelow(paramDiscreteDomain)) <= 0)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0) {
            return new EmptyContiguousSet(paramDiscreteDomain);
          }
          return new RegularContiguousSet(localRange2, paramDiscreteDomain);
        }
        catch (NoSuchElementException paramRange)
        {
          throw new IllegalArgumentException(paramRange);
        }
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public ContiguousSet headSet(Comparable paramComparable, boolean paramBoolean)
  {
    if (paramComparable != null) {
      return headSetImpl(paramComparable, paramBoolean);
    }
    throw new NullPointerException();
  }
  
  public ContiguousSet headSetImpl(Comparable paramComparable)
  {
    if (paramComparable != null) {
      return headSetImpl(paramComparable, false);
    }
    throw new NullPointerException();
  }
  
  public abstract ContiguousSet headSetImpl(Comparable paramComparable, boolean paramBoolean);
  
  public abstract ContiguousSet intersection(ContiguousSet paramContiguousSet);
  
  public abstract Range range();
  
  public abstract Range range(BoundType paramBoundType1, BoundType paramBoundType2);
  
  public ContiguousSet subSet(Comparable paramComparable1, Comparable paramComparable2)
  {
    if (paramComparable1 != null)
    {
      if (paramComparable2 != null)
      {
        boolean bool;
        if (comparator().compare(paramComparable1, paramComparable2) <= 0) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool);
        return subSetImpl(paramComparable1, true, paramComparable2, false);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public ContiguousSet subSet(Comparable paramComparable1, boolean paramBoolean1, Comparable paramComparable2, boolean paramBoolean2)
  {
    if (paramComparable1 != null)
    {
      if (paramComparable2 != null)
      {
        boolean bool;
        if (comparator().compare(paramComparable1, paramComparable2) <= 0) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool);
        return subSetImpl(paramComparable1, paramBoolean1, paramComparable2, paramBoolean2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public abstract ContiguousSet subSetImpl(Comparable paramComparable1, boolean paramBoolean1, Comparable paramComparable2, boolean paramBoolean2);
  
  public ContiguousSet tailSet(Comparable paramComparable)
  {
    if (paramComparable != null) {
      return tailSetImpl(paramComparable, true);
    }
    throw new NullPointerException();
  }
  
  public ContiguousSet tailSet(Comparable paramComparable, boolean paramBoolean)
  {
    if (paramComparable != null) {
      return tailSetImpl(paramComparable, paramBoolean);
    }
    throw new NullPointerException();
  }
  
  public abstract ContiguousSet tailSetImpl(Comparable paramComparable, boolean paramBoolean);
  
  public String toString()
  {
    return range().toString();
  }
}
