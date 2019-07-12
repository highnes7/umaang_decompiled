package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ab;
import java.util.Map;

@b(emulated=true, serializable=true)
public final class EmptyImmutableMap
  extends Ab<Object, Object>
{
  public static final EmptyImmutableMap INSTANCE = new EmptyImmutableMap();
  public static final long serialVersionUID = 0L;
  
  public EmptyImmutableMap() {}
  
  public boolean containsKey(Object paramObject)
  {
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return false;
  }
  
  public ImmutableSet createEntrySet()
  {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSet entrySet()
  {
    return ImmutableSet.of();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map)) {
      return ((Map)paramObject).isEmpty();
    }
    return false;
  }
  
  public Object get(Object paramObject)
  {
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public ImmutableSet keySet()
  {
    return ImmutableSet.of();
  }
  
  public Object readResolve()
  {
    return INSTANCE;
  }
  
  public int size()
  {
    return 0;
  }
  
  public String toString()
  {
    return "{}";
  }
  
  public ImmutableCollection values()
  {
    return ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION;
  }
}
