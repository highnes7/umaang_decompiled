package f.g.c.package_10;

import f.g.c.a.b;
import java.util.concurrent.TimeUnit;

@b
public final class Suppliers
{
  public Suppliers() {}
  
  public static Supplier cache(Object paramObject)
  {
    return new za.e(paramObject);
  }
  
  public static Supplier compose(Function paramFunction, Supplier paramSupplier)
  {
    if (paramFunction != null)
    {
      if (paramSupplier != null) {
        return new za.c(paramFunction, paramSupplier);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Supplier compose(Supplier paramSupplier)
  {
    if (paramSupplier != null) {
      return new za.f(paramSupplier);
    }
    throw new NullPointerException();
  }
  
  public static Function getCovers()
  {
    return za.d.covers;
  }
  
  public static Supplier memoize(Supplier paramSupplier)
  {
    if ((paramSupplier instanceof za.b)) {
      return paramSupplier;
    }
    if (paramSupplier != null) {
      return new za.b(paramSupplier);
    }
    throw new NullPointerException();
  }
  
  public static Supplier memoizeWithExpiration(Supplier paramSupplier, long paramLong, TimeUnit paramTimeUnit)
  {
    return new za.a(paramSupplier, paramLong, paramTimeUnit);
  }
}
