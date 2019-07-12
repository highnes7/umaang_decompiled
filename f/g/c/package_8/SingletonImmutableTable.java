package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Yb;
import f.g.c.package_10.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

@b
public final class SingletonImmutableTable<R, C, V>
  extends Yb<R, C, V>
{
  public final C singleColumnKey;
  public final R singleRowKey;
  public final V singleValue;
  
  public SingletonImmutableTable(Yg.a paramA)
  {
    this(paramA.getRowKey(), paramA.getColumnKey(), paramA.getValue());
  }
  
  public SingletonImmutableTable(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramObject1 != null)
    {
      singleRowKey = paramObject1;
      if (paramObject2 != null)
      {
        singleColumnKey = paramObject2;
        if (paramObject3 != null)
        {
          singleValue = paramObject3;
          return;
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public ImmutableSet cellSet()
  {
    return ImmutableSet.of(Tables.immutableCell(singleRowKey, singleColumnKey, singleValue));
  }
  
  public ImmutableMap column(Object paramObject)
  {
    if (paramObject != null)
    {
      if (containsColumn(paramObject)) {
        return ImmutableMap.of(singleRowKey, singleValue);
      }
      return ImmutableMap.of();
    }
    throw new NullPointerException();
  }
  
  public ImmutableSet columnKeySet()
  {
    return ImmutableSet.of(singleColumnKey);
  }
  
  public ImmutableMap columnMap()
  {
    return ImmutableMap.of(singleColumnKey, ImmutableMap.of(singleRowKey, singleValue));
  }
  
  public boolean contains(Object paramObject1, Object paramObject2)
  {
    return (containsRow(paramObject1)) && (containsColumn(paramObject2));
  }
  
  public boolean containsColumn(Object paramObject)
  {
    return Objects.equal(singleColumnKey, paramObject);
  }
  
  public boolean containsRow(Object paramObject)
  {
    return Objects.equal(singleRowKey, paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return Objects.equal(singleValue, paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Table))
    {
      paramObject = (Table)paramObject;
      if (paramObject.size() == 1)
      {
        paramObject = (Yg.a)paramObject.cellSet().iterator().next();
        return (Objects.equal(singleRowKey, paramObject.getRowKey())) && (Objects.equal(singleColumnKey, paramObject.getColumnKey())) && (Objects.equal(singleValue, paramObject.getValue()));
      }
    }
    return false;
  }
  
  public Object get(Object paramObject1, Object paramObject2)
  {
    if (contains(paramObject1, paramObject2)) {
      return singleValue;
    }
    return null;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { singleRowKey, singleColumnKey, singleValue });
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public ImmutableMap row(Object paramObject)
  {
    if (paramObject != null)
    {
      if (containsRow(paramObject)) {
        return ImmutableMap.of(singleColumnKey, singleValue);
      }
      return ImmutableMap.of();
    }
    throw new NullPointerException();
  }
  
  public ImmutableSet rowKeySet()
  {
    return ImmutableSet.of(singleRowKey);
  }
  
  public ImmutableMap rowMap()
  {
    return ImmutableMap.of(singleRowKey, ImmutableMap.of(singleColumnKey, singleValue));
  }
  
  public int size()
  {
    return 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    localStringBuilder.append(singleRowKey);
    localStringBuilder.append("={");
    localStringBuilder.append(singleColumnKey);
    localStringBuilder.append('=');
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, singleValue, "}}");
  }
  
  public ImmutableCollection values()
  {
    return ImmutableSet.of(singleValue);
  }
}
