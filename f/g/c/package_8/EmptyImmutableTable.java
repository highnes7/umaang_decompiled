package f.g.c.package_8;

import f.g.c.d.Yb;

@f.g.c.a.b
@m.a.a.b
public final class EmptyImmutableTable
  extends Yb<Object, Object, Object>
{
  public static final EmptyImmutableTable INSTANCE = new EmptyImmutableTable();
  public static final long serialVersionUID = 0L;
  
  public EmptyImmutableTable() {}
  
  public ImmutableSet cellSet()
  {
    return ImmutableSet.of();
  }
  
  public ImmutableMap column(Object paramObject)
  {
    if (paramObject != null) {
      return ImmutableMap.of();
    }
    throw new NullPointerException();
  }
  
  public ImmutableSet columnKeySet()
  {
    return ImmutableSet.of();
  }
  
  public ImmutableMap columnMap()
  {
    return ImmutableMap.of();
  }
  
  public boolean contains(Object paramObject1, Object paramObject2)
  {
    return false;
  }
  
  public boolean containsColumn(Object paramObject)
  {
    return false;
  }
  
  public boolean containsRow(Object paramObject)
  {
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Table)) {
      return ((Table)paramObject).isEmpty();
    }
    return false;
  }
  
  public Object get(Object paramObject1, Object paramObject2)
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
  
  public Object readResolve()
  {
    return INSTANCE;
  }
  
  public ImmutableMap row(Object paramObject)
  {
    if (paramObject != null) {
      return ImmutableMap.of();
    }
    throw new NullPointerException();
  }
  
  public ImmutableSet rowKeySet()
  {
    return ImmutableSet.of();
  }
  
  public ImmutableMap rowMap()
  {
    return ImmutableMap.of();
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
    return ImmutableSet.of();
  }
}
