package f.g.c.package_8;

import f.g.c.a.b;
import java.util.NoSuchElementException;

@b
public final class Interpreter
{
  public Interpreter() {}
  
  public static Object get(Ye.a paramA)
  {
    if (paramA != null) {
      return paramA.getElement();
    }
    throw new NoSuchElementException();
  }
}
