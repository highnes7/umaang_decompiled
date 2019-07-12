package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ab;
import f.g.c.package_10.Joiner;
import f.g.c.package_10.Preconditions;
import java.util.Map.Entry;

@b(emulated=true, serializable=true)
public final class RegularImmutableMap<K, V>
  extends Ab<K, V>
{
  public static final double MAX_LOAD_FACTOR = 1.2D;
  public static final long serialVersionUID = 0L;
  public final transient f.g.c.d.Df.b<K, V>[] entries;
  public final transient int keySetHashCode;
  public final transient int mask;
  public final transient f.g.c.d.Df.b<K, V>[] table;
  
  public RegularImmutableMap(Map.Entry... paramVarArgs)
  {
    int k = paramVarArgs.length;
    entries = new Df.b[k];
    int i = chooseTableSize(k);
    table = new Df.b[i];
    mask = (i - 1);
    i = 0;
    int j = 0;
    while (i < k)
    {
      Object localObject2 = paramVarArgs[i];
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      int m = localObject1.hashCode();
      j += m;
      m = CopyOnWriteArrayList.get(m) & mask;
      Df.b localB = table[m];
      localObject2 = newLinkedEntry(localObject1, ((Map.Entry)localObject2).getValue(), localB);
      table[m] = localObject2;
      entries[i] = localObject2;
      while (localB != null)
      {
        Preconditions.checkArgument(localObject1.equals(localB.getKey()) ^ true, "duplicate key: %s", new Object[] { localObject1 });
        localB = localB.next();
      }
      i += 1;
    }
    keySetHashCode = j;
  }
  
  public static int chooseTableSize(int paramInt)
  {
    int j = Integer.highestOneBit(paramInt);
    double d1 = paramInt;
    double d2 = j;
    Double.isNaN(d1);
    Double.isNaN(d2);
    int i = j;
    if (d1 / d2 > 1.2D)
    {
      i = j << 1;
      boolean bool;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "table too large: %s", new Object[] { Integer.valueOf(paramInt) });
    }
    return i;
  }
  
  private Df.b[] get(int paramInt)
  {
    return new Df.b[paramInt];
  }
  
  public static Df.b newLinkedEntry(Object paramObject1, Object paramObject2, Df.b paramB)
  {
    if (paramB == null) {
      return new Df.d(paramObject1, paramObject2);
    }
    return new Df.c(paramObject1, paramObject2, paramB);
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    Df.b[] arrayOfB = entries;
    int j = arrayOfB.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfB[i].getValue().equals(paramObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public ImmutableSet createEntrySet()
  {
    return new Df.a(this, null);
  }
  
  public ImmutableSet createKeySet()
  {
    return new RegularImmutableMap.1(this, entrySet(), keySetHashCode);
  }
  
  public Object get(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = CopyOnWriteArrayList.get(paramObject.hashCode());
    int j = mask;
    for (Df.b localB = table[(i & j)]; localB != null; localB = localB.next()) {
      if (paramObject.equals(localB.getKey())) {
        return localB.getValue();
      }
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return entries.length;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = Collections2.append(size());
    localStringBuilder.append('{');
    Collections2.STANDARD_JOINER.appendTo(localStringBuilder, entries);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
