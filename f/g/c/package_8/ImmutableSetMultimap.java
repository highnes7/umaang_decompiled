package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.Ib;
import f.g.c.d.Nb;
import f.g.c.d.Pb;
import f.g.c.d.Wb;
import f.g.c.d.bg;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b(emulated=true, serializable=true)
public class ImmutableSetMultimap<K, V>
  extends Ib<K, V>
  implements bg<K, V>
{
  @c("not needed in emulated source.")
  public static final long serialVersionUID = 0L;
  public final transient Wb<V> emptySet;
  public transient Nb<Map.Entry<K, V>> entries;
  public transient Pb<V, K> inverse;
  
  public ImmutableSetMultimap(ImmutableMap paramImmutableMap, int paramInt, Comparator paramComparator)
  {
    super(paramImmutableMap, paramInt);
    if (paramComparator == null) {
      paramImmutableMap = null;
    } else {
      paramImmutableMap = ImmutableSortedSet.emptySet(paramComparator);
    }
    emptySet = paramImmutableMap;
  }
  
  public static ImmutableSetMultimap copyOf(Multimap paramMultimap)
  {
    return copyOf(paramMultimap, null);
  }
  
  public static ImmutableSetMultimap copyOf(Multimap paramMultimap, Comparator paramComparator)
  {
    if (paramMultimap != null)
    {
      if ((paramMultimap.isEmpty()) && (paramComparator == null)) {
        return EmptyImmutableSetMultimap.INSTANCE;
      }
      if ((paramMultimap instanceof ImmutableSetMultimap))
      {
        localObject1 = (ImmutableSetMultimap)paramMultimap;
        if (!((ImmutableMultimap)localObject1).isPartialView()) {
          return localObject1;
        }
      }
      Object localObject1 = ImmutableMap.builder();
      int i = 0;
      Iterator localIterator = paramMultimap.asMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMultimap = (Map.Entry)localIterator.next();
        Object localObject2 = paramMultimap.getKey();
        paramMultimap = (Collection)paramMultimap.getValue();
        if (paramComparator == null) {
          paramMultimap = ImmutableSet.copyOf(paramMultimap);
        } else {
          paramMultimap = ImmutableSortedSet.copyOf(paramComparator, paramMultimap);
        }
        if (!paramMultimap.isEmpty())
        {
          ((Ab.a)localObject1).put(localObject2, paramMultimap);
          i = paramMultimap.size() + i;
        }
      }
      return new ImmutableSetMultimap(((Ab.a)localObject1).build(), i, paramComparator);
    }
    paramMultimap = new NullPointerException();
    throw paramMultimap;
  }
  
  public static Pb.a copyOf()
  {
    return new Pb.a();
  }
  
  private ImmutableSetMultimap invert()
  {
    Object localObject = new Pb.a();
    Iterator localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((Pb.a)localObject).put(localEntry.getValue(), localEntry.getKey());
    }
    localObject = ((Pb.a)localObject).build();
    inverse = this;
    return localObject;
  }
  
  public static ImmutableSetMultimap of()
  {
    return EmptyImmutableSetMultimap.INSTANCE;
  }
  
  public static ImmutableSetMultimap of(Object paramObject1, Object paramObject2)
  {
    Pb.a localA = new Pb.a();
    localA.put(paramObject1, paramObject2);
    return localA.build();
  }
  
  public static ImmutableSetMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    Pb.a localA = new Pb.a();
    localA.put(paramObject1, paramObject2);
    localA.put(paramObject3, paramObject4);
    return localA.build();
  }
  
  public static ImmutableSetMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Pb.a localA = new Pb.a();
    localA.put(paramObject1, paramObject2);
    localA.put(paramObject3, paramObject4);
    localA.put(paramObject5, paramObject6);
    return localA.build();
  }
  
  public static ImmutableSetMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
  {
    Pb.a localA = new Pb.a();
    localA.put(paramObject1, paramObject2);
    localA.put(paramObject3, paramObject4);
    localA.put(paramObject5, paramObject6);
    localA.put(paramObject7, paramObject8);
    return localA.build();
  }
  
  public static ImmutableSetMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    Pb.a localA = new Pb.a();
    localA.put(paramObject1, paramObject2);
    localA.put(paramObject3, paramObject4);
    localA.put(paramObject5, paramObject6);
    localA.put(paramObject7, paramObject8);
    localA.put(paramObject9, paramObject10);
    return localA.build();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int m = paramObjectInputStream.readInt();
    if (m >= 0)
    {
      Ab.a localA = ImmutableMap.builder();
      int i = 0;
      int j = 0;
      while (i < m)
      {
        Object localObject = paramObjectInputStream.readObject();
        int n = paramObjectInputStream.readInt();
        if (n > 0)
        {
          Object[] arrayOfObject = new Object[n];
          int k = 0;
          while (k < n)
          {
            arrayOfObject[k] = paramObjectInputStream.readObject();
            k += 1;
          }
          ImmutableSet localImmutableSet = ImmutableSet.of(arrayOfObject);
          if (localImmutableSet.size() == arrayOfObject.length)
          {
            localA.put(localObject, localImmutableSet);
            j += n;
            i += 1;
          }
          else
          {
            throw new InvalidObjectException(StringBuilder.toString("Duplicate key-value pairs exist for key ", localObject));
          }
        }
        else
        {
          throw new InvalidObjectException(StringBuilder.toString("Invalid value count ", n));
        }
      }
      try
      {
        paramObjectInputStream = localA.build();
        Ib.d.MAP_FIELD_SETTER.set(this, paramObjectInputStream);
        Ib.d.SIZE_FIELD_SETTER.set(this, j);
        return;
      }
      catch (IllegalArgumentException paramObjectInputStream)
      {
        throw ((InvalidObjectException)new InvalidObjectException(paramObjectInputStream.getMessage()).initCause(paramObjectInputStream));
      }
    }
    paramObjectInputStream = new InvalidObjectException(StringBuilder.toString("Invalid key count ", m));
    throw paramObjectInputStream;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  public ImmutableSet entries()
  {
    ImmutableSet localImmutableSet2 = entries;
    ImmutableSet localImmutableSet1 = localImmutableSet2;
    if (localImmutableSet2 == null)
    {
      localImmutableSet1 = ImmutableSet.copyOf(super.entries());
      entries = localImmutableSet1;
    }
    return localImmutableSet1;
  }
  
  public ImmutableSet get(Object paramObject)
  {
    paramObject = (ImmutableSet)map.get(paramObject);
    if (paramObject != null) {
      return paramObject;
    }
    paramObject = emptySet;
    if (paramObject != null) {
      return paramObject;
    }
    return ImmutableSet.of();
  }
  
  public ImmutableSetMultimap inverse()
  {
    ImmutableSetMultimap localImmutableSetMultimap2 = inverse;
    ImmutableSetMultimap localImmutableSetMultimap1 = localImmutableSetMultimap2;
    if (localImmutableSetMultimap2 == null)
    {
      localImmutableSetMultimap1 = invert();
      inverse = localImmutableSetMultimap1;
    }
    return localImmutableSetMultimap1;
  }
  
  public ImmutableSet removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSet replaceValues(Object paramObject, Iterable paramIterable)
  {
    throw new UnsupportedOperationException();
  }
}
