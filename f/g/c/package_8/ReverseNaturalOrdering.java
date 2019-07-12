package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import java.io.Serializable;
import java.util.Iterator;

@b(serializable=true)
public final class ReverseNaturalOrdering
  extends mf<Comparable>
  implements Serializable
{
  public static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
  public static final long serialVersionUID = 0L;
  
  public ReverseNaturalOrdering() {}
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int compare(Comparable paramComparable1, Comparable paramComparable2)
  {
    if (paramComparable1 != null)
    {
      if (paramComparable1 == paramComparable2) {
        return 0;
      }
      return paramComparable2.compareTo(paramComparable1);
    }
    throw new NullPointerException();
  }
  
  public Comparable max(Comparable paramComparable1, Comparable paramComparable2)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramComparable1, paramComparable2);
  }
  
  public Comparable max(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3, Comparable... paramVarArgs)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramComparable1, paramComparable2, paramComparable3, paramVarArgs);
  }
  
  public Comparable max(Iterable paramIterable)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramIterable);
  }
  
  public Comparable max(Iterator paramIterator)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramIterator);
  }
  
  public Comparable min(Comparable paramComparable1, Comparable paramComparable2)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramComparable1, paramComparable2);
  }
  
  public Comparable min(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3, Comparable... paramVarArgs)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramComparable1, paramComparable2, paramComparable3, paramVarArgs);
  }
  
  public Comparable min(Iterable paramIterable)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramIterable);
  }
  
  public Comparable min(Iterator paramIterator)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramIterator);
  }
  
  public Ordering reverse()
  {
    return Ordering.natural();
  }
  
  public String toString()
  {
    return "Ordering.natural().reverse()";
  }
}
