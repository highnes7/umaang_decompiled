package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Gg;
import f.g.c.d.Ig;
import f.g.c.d.Zf;
import f.g.c.package_10.Supplier;
import java.util.SortedMap;
import java.util.SortedSet;

@b
public class StandardRowSortedTable<R, C, V>
  extends Ig<R, C, V>
  implements Zf<R, C, V>
{
  public static final long serialVersionUID = 0L;
  public transient SortedSet<R> rowKeySet;
  public transient Gg<R, C, V>.b rowMap;
  
  public StandardRowSortedTable(SortedMap paramSortedMap, Supplier paramSupplier)
  {
    super(paramSortedMap, paramSupplier);
  }
  
  private SortedMap sortedBackingMap()
  {
    return (SortedMap)backingMap;
  }
  
  public SortedSet rowKeySet()
  {
    Object localObject = rowKeySet;
    if (localObject == null)
    {
      localObject = new Gg.a(this, null);
      rowKeySet = ((SortedSet)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public SortedMap rowMap()
  {
    Gg.b localB2 = rowMap;
    Gg.b localB1 = localB2;
    if (localB2 == null)
    {
      localB1 = new Gg.b(this, null);
      rowMap = localB1;
    }
    return localB1;
  }
}
