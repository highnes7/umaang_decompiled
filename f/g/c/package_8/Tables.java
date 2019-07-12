package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.b.J;
import f.g.c.package_10.Function;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Supplier;
import java.util.Map;

@b
public final class Tables
{
  public static final J<? extends Map<?, ?>, ? extends Map<?, ?>> UNMODIFIABLE_WRAPPER = new Annotations.3();
  
  public Tables() {}
  
  public static Function access$getUnmodifiableWrapper()
  {
    return UNMODIFIABLE_WRAPPER;
  }
  
  public static Table get(Map paramMap, Supplier paramSupplier)
  {
    Preconditions.checkArgument(paramMap.isEmpty());
    if (paramSupplier != null) {
      return new StandardTable(paramMap, paramSupplier);
    }
    throw new NullPointerException();
  }
  
  public static Yg.a immutableCell(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new _g.b(paramObject1, paramObject2, paramObject3);
  }
  
  public static Table transformValues(Table paramTable)
  {
    return new _g.f(paramTable);
  }
  
  public static Table transformValues(Table paramTable, Function paramFunction)
  {
    return new _g.c(paramTable, paramFunction);
  }
  
  public static Table transpose(Table paramTable)
  {
    if ((paramTable instanceof _g.d)) {
      return original;
    }
    return new _g.d(paramTable);
  }
  
  public static RowSortedTable unmodifiableRowSortedTable(RowSortedTable paramRowSortedTable)
  {
    return new _g.e(paramRowSortedTable);
  }
}
