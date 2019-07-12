package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Map;

@b
public abstract interface MapDifference<K, V>
{
  public abstract Map entriesDiffering();
  
  public abstract Map entriesInCommon();
  
  public abstract Map entriesOnlyOnLeft();
  
  public abstract Map entriesOnlyOnRight();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract boolean n();
}
