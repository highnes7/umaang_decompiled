package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;

@a
@b
public abstract interface Constraint<E>
{
  public abstract Object checkElement(Object paramObject);
  
  public abstract String toString();
}
