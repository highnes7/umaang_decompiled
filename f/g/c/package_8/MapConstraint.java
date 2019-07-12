package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;

@a
@b
public abstract interface MapConstraint<K, V>
{
  public abstract void checkKeyValue(Object paramObject1, Object paramObject2);
  
  public abstract String toString();
}
