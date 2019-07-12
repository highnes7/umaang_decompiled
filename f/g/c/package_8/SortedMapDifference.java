package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.d.sd;
import java.util.SortedMap;

@a
@b
public abstract interface SortedMapDifference<K, V>
  extends sd<K, V>
{
  public abstract SortedMap entriesDiffering();
  
  public abstract SortedMap entriesInCommon();
  
  public abstract SortedMap entriesOnlyOnLeft();
  
  public abstract SortedMap entriesOnlyOnRight();
}
