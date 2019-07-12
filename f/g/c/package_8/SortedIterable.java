package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Comparator;
import java.util.Iterator;

@b
public abstract interface SortedIterable<T>
  extends Iterable<T>
{
  public abstract Comparator comparator();
  
  public abstract Iterator iterator();
}
