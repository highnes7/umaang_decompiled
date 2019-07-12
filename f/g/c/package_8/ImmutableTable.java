package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Yg;
import java.util.Iterator;
import java.util.Set;

@b
public abstract class ImmutableTable<R, C, V>
  implements Yg<R, C, V>
{
  public ImmutableTable() {}
  
  public static final ImmutableTable copyOf(Table paramTable)
  {
    if ((paramTable instanceof ImmutableTable)) {
      return (ImmutableTable)paramTable;
    }
    int i = paramTable.size();
    if (i != 0)
    {
      if (i != 1)
      {
        Nb.b localB = ImmutableSet.builder();
        paramTable = paramTable.cellSet().iterator();
        while (paramTable.hasNext())
        {
          Yg.a localA = (Yg.a)paramTable.next();
          localB.add(get(localA.getRowKey(), localA.getColumnKey(), localA.getValue()));
        }
        return RegularImmutableTable.forCells(localB.build());
      }
      paramTable = (Yg.a)Iterables.getOnlyElement(paramTable.cellSet());
      return new SingletonImmutableTable(paramTable.getRowKey(), paramTable.getColumnKey(), paramTable.getValue());
    }
    return EmptyImmutableTable.INSTANCE;
  }
  
  public static final Yb.a copyOf()
  {
    return new Yb.a();
  }
  
  public static Yg.a get(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        if (paramObject3 != null) {
          return Tables.immutableCell(paramObject1, paramObject2, paramObject3);
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static final ImmutableTable of()
  {
    return EmptyImmutableTable.INSTANCE;
  }
  
  public static final ImmutableTable of(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new SingletonImmutableTable(paramObject1, paramObject2, paramObject3);
  }
  
  public abstract ImmutableSet cellSet();
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract ImmutableMap column(Object paramObject);
  
  public abstract ImmutableSet columnKeySet();
  
  public abstract ImmutableMap columnMap();
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Table))
    {
      paramObject = (Table)paramObject;
      return cellSet().equals(paramObject.cellSet());
    }
    return false;
  }
  
  public int hashCode()
  {
    return cellSet().hashCode();
  }
  
  public final Object put(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void putAll(Table paramTable)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract ImmutableMap row(Object paramObject);
  
  public abstract ImmutableSet rowKeySet();
  
  public abstract ImmutableMap rowMap();
  
  public String toString()
  {
    return rowMap().toString();
  }
}
