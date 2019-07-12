package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.d.Yg;
import java.util.SortedMap;
import java.util.SortedSet;

@a
@b
public abstract interface RowSortedTable<R, C, V>
  extends Yg<R, C, V>
{
  public abstract SortedSet rowKeySet();
  
  public abstract SortedMap rowMap();
}
