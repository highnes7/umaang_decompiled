package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import java.util.NoSuchElementException;

@a
@b
public abstract class DiscreteDomain<C extends Comparable>
{
  public DiscreteDomain() {}
  
  public abstract long distance(Comparable paramComparable1, Comparable paramComparable2);
  
  public Comparable maxValue()
  {
    throw new NoSuchElementException();
  }
  
  public Comparable minValue()
  {
    throw new NoSuchElementException();
  }
  
  public abstract Comparable next(Comparable paramComparable);
  
  public abstract Comparable previous(Comparable paramComparable);
}
