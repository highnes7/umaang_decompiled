package f.g.c.package_10;

import f.g.c.a.a;
import f.g.c.a.b;

@a
@b
public final class Converter
{
  public Converter() {}
  
  public static Equivalence equals()
  {
    return Equivalence.Equals.INSTANCE;
  }
  
  public static Equivalence identity()
  {
    return Equivalence.Identity.INSTANCE;
  }
}
