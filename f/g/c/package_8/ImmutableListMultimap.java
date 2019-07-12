package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.Ib;
import f.g.c.d.cd;
import f.g.c.d.xb;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b(emulated=true, serializable=true)
public class ImmutableListMultimap<K, V>
  extends Ib<K, V>
  implements cd<K, V>
{
  @c("Not needed in emulated source")
  public static final long serialVersionUID = 0L;
  public transient xb<V, K> inverse;
  
  public ImmutableListMultimap(ImmutableMap paramImmutableMap, int paramInt)
  {
    super(paramImmutableMap, paramInt);
  }
  
  public static ImmutableListMultimap copyOf(Multimap paramMultimap)
  {
    if (paramMultimap.isEmpty()) {
      return EmptyImmutableListMultimap.INSTANCE;
    }
    if ((paramMultimap instanceof ImmutableListMultimap))
    {
      localObject = (ImmutableListMultimap)paramMultimap;
      if (!((ImmutableMultimap)localObject).isPartialView()) {
        return localObject;
      }
    }
    Object localObject = ImmutableMap.builder();
    int i = 0;
    paramMultimap = paramMultimap.asMap().entrySet().iterator();
    while (paramMultimap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMultimap.next();
      ImmutableList localImmutableList = ImmutableList.copyOf((Collection)localEntry.getValue());
      if (!localImmutableList.isEmpty())
      {
        ((Ab.a)localObject).put(localEntry.getKey(), localImmutableList);
        i = localImmutableList.size() + i;
      }
    }
    return new ImmutableListMultimap(((Ab.a)localObject).build(), i);
  }
  
  public static xb.a copyOf()
  {
    return new xb.a();
  }
  
  private ImmutableListMultimap invert()
  {
    Object localObject = new xb.a();
    Iterator localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((xb.a)localObject).put(localEntry.getValue(), localEntry.getKey());
    }
    localObject = ((xb.a)localObject).build();
    inverse = this;
    return localObject;
  }
  
  public static ImmutableListMultimap of()
  {
    return EmptyImmutableListMultimap.INSTANCE;
  }
  
  public static ImmutableListMultimap of(Object paramObject1, Object paramObject2)
  {
    xb.a localA = new xb.a();
    localA.put(paramObject1, paramObject2);
    return localA.build();
  }
  
  public static ImmutableListMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    xb.a localA = new xb.a();
    localA.put(paramObject1, paramObject2);
    localA.put(paramObject3, paramObject4);
    return localA.build();
  }
  
  public static ImmutableListMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    xb.a localA = new xb.a();
    localA.put(paramObject1, paramObject2);
    localA.put(paramObject3, paramObject4);
    localA.put(paramObject5, paramObject6);
    return localA.build();
  }
  
  public static ImmutableListMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
  {
    xb.a localA = new xb.a();
    localA.put(paramObject1, paramObject2);
    localA.put(paramObject3, paramObject4);
    localA.put(paramObject5, paramObject6);
    localA.put(paramObject7, paramObject8);
    return localA.build();
  }
  
  public static ImmutableListMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    xb.a localA = new xb.a();
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
          localA.put(localObject, ImmutableList.copyOf(arrayOfObject));
          j += n;
          i += 1;
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
  
  public ImmutableList get(Object paramObject)
  {
    ImmutableList localImmutableList = (ImmutableList)map.get(paramObject);
    paramObject = localImmutableList;
    if (localImmutableList == null) {
      paramObject = ImmutableList.of();
    }
    return paramObject;
  }
  
  public ImmutableListMultimap inverse()
  {
    ImmutableListMultimap localImmutableListMultimap2 = inverse;
    ImmutableListMultimap localImmutableListMultimap1 = localImmutableListMultimap2;
    if (localImmutableListMultimap2 == null)
    {
      localImmutableListMultimap1 = invert();
      inverse = localImmutableListMultimap1;
    }
    return localImmutableListMultimap1;
  }
  
  public ImmutableList removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList replaceValues(Object paramObject, Iterable paramIterable)
  {
    throw new UnsupportedOperationException();
  }
}
