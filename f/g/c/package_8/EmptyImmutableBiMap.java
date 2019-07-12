package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.nb;

@b(emulated=true)
public final class EmptyImmutableBiMap
  extends nb<Object, Object>
{
  public static final EmptyImmutableBiMap INSTANCE = new EmptyImmutableBiMap();
  
  public EmptyImmutableBiMap() {}
  
  public ImmutableMap delegate()
  {
    return ImmutableMap.of();
  }
  
  public ImmutableBiMap inverse()
  {
    return this;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public Object readResolve()
  {
    return INSTANCE;
  }
}
