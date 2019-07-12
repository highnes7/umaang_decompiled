package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.package_10.Function;

@a
public final class Interners
{
  public Interners() {}
  
  public static Function compose(Interner paramInterner)
  {
    if (paramInterner != null) {
      return new ac.a(paramInterner);
    }
    throw new NullPointerException();
  }
  
  public static Interner newStrongInterner()
  {
    return new Interners.1(new MapMaker().makeMap());
  }
  
  public static Interner newWeakInterner()
  {
    return new ac.b();
  }
}
