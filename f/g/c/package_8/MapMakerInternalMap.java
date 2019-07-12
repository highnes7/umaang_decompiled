package f.g.c.package_8;

import f.g.c.b.C;
import f.g.c.d.Cd;
import f.g.c.j.g;
import f.g.c.package_10.Equivalence;
import f.g.c.package_10.Ticker;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapMakerInternalMap<K, V>
  extends AbstractMap<K, V>
  implements ConcurrentMap<K, V>, Serializable
{
  public static final long CLEANUP_EXECUTOR_DELAY_SECS = 60L;
  public static final int CONTAINS_VALUE_RETRIES = 3;
  public static final int DRAIN_MAX = 16;
  public static final int DRAIN_THRESHOLD = 63;
  public static final int MAXIMUM_CAPACITY = 1073741824;
  public static final int MAX_SEGMENTS = 65536;
  public static final f.g.c.d.Cd.B<Object, Object> UNSET = new Cd.B()
  {
    public void clear(Cd.B paramAnonymousB) {}
    
    public Cd.B copyFor(ReferenceQueue paramAnonymousReferenceQueue, Object paramAnonymousObject, Cd.m paramAnonymousM)
    {
      return this;
    }
    
    public Object get()
    {
      return null;
    }
    
    public boolean isComputingReference()
    {
      return false;
    }
    
    public Cd.m navigateNext()
    {
      return null;
    }
    
    public Object waitForValue()
    {
      return null;
    }
  };
  public static final Logger logger = Logger.getLogger(Cd.class.getName());
  public static final long serialVersionUID = 5L;
  public static final Queue<? extends Object> table = new LinkedBlockingQueue();
  public final int concurrencyLevel;
  public final transient Cd.d entryFactory;
  public transient Set<Map.Entry<K, V>> entrySet;
  public final long expireAfterAccessNanos;
  public final long expireAfterWriteNanos;
  public final C<Object> keyEquivalence;
  public transient Set<K> keySet;
  public final Cd.u keyStrength;
  public final int maximumSize;
  public final f.g.c.d.ud.d<K, V> removalListener;
  public final Queue<f.g.c.d.ud.e<K, V>> removalNotificationQueue;
  public final transient int segmentMask;
  public final transient int segmentShift;
  public final transient f.g.c.d.Cd.n<K, V>[] segments;
  public final Ticker ticker;
  public final C<Object> valueEquivalence;
  public final Cd.u valueStrength;
  public transient Collection<V> values;
  
  public MapMakerInternalMap(MapMaker paramMapMaker) {}
  
  public static void append(Cd.m paramM1, Cd.m paramM2)
  {
    paramM1.buf(paramM2);
    paramM2.d(paramM1);
  }
  
  public static void b(Cd.m paramM1, Cd.m paramM2)
  {
    paramM1.a(paramM2);
    paramM2.b(paramM1);
  }
  
  public static void clear(Cd.m paramM)
  {
    Cd.l localL = Cd.l.a;
    paramM.buf(localL);
    paramM.d(localL);
  }
  
  public static void d(Cd.m paramM)
  {
    Cd.l localL = Cd.l.a;
    paramM.a(localL);
    paramM.b(localL);
  }
  
  public static Cd.m getDimensionPixelSize()
  {
    return Cd.l.a;
  }
  
  public static Queue getEntry()
  {
    return table;
  }
  
  public static int rehash(int paramInt)
  {
    paramInt += (paramInt << 15 ^ 0xCD7D);
    paramInt ^= paramInt >>> 10;
    paramInt += (paramInt << 3);
    paramInt ^= paramInt >>> 6;
    paramInt = (paramInt << 2) + (paramInt << 14) + paramInt;
    return paramInt >>> 16 ^ paramInt;
  }
  
  public static Cd.B unset()
  {
    return UNSET;
  }
  
  public void clear()
  {
    Cd.n[] arrayOfN = segments;
    int j = arrayOfN.length;
    int i = 0;
    while (i < j)
    {
      arrayOfN[i].clear();
      i += 1;
    }
  }
  
  public boolean containsKey(Cd.m paramM)
  {
    return segmentFor(paramM.getHash()).getLiveValue(paramM) != null;
  }
  
  public boolean containsKey(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int i = hash(paramObject);
    return segmentFor(i).containsKey(paramObject, i);
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    Cd.n[] arrayOfN = segments;
    long l2 = -1L;
    int i = 0;
    while (i < 3)
    {
      int m = arrayOfN.length;
      long l1 = 0L;
      int j = 0;
      while (j < m)
      {
        Cd.n localN = arrayOfN[j];
        int k = count;
        AtomicReferenceArray localAtomicReferenceArray = table;
        k = 0;
        while (k < localAtomicReferenceArray.length())
        {
          for (Cd.m localM = (Cd.m)localAtomicReferenceArray.get(k); localM != null; localM = localM.getNext())
          {
            Object localObject = localN.getLiveValue(localM);
            if ((localObject != null) && (valueEquivalence.equivalent(paramObject, localObject))) {
              return true;
            }
          }
          k += 1;
        }
        l1 += modCount;
        j += 1;
      }
      if (l1 == l2) {
        break;
      }
      i += 1;
      l2 = l1;
    }
    return false;
  }
  
  public Cd.m copyEntry(Cd.m paramM1, Cd.m paramM2)
  {
    return segmentFor(paramM1.getHash()).copyEntry(paramM1, paramM2);
  }
  
  public Cd.n createSegment(int paramInt1, int paramInt2)
  {
    return new Cd.n(this, paramInt1, paramInt2);
  }
  
  public Set entrySet()
  {
    Object localObject = entrySet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new Cd.f(this);
    entrySet = ((Set)localObject);
    return localObject;
  }
  
  public boolean evictsBySize()
  {
    return maximumSize != -1;
  }
  
  public boolean expires()
  {
    return (expiresAfterWrite()) || (expiresAfterAccess());
  }
  
  public boolean expiresAfterAccess()
  {
    return expireAfterAccessNanos > 0L;
  }
  
  public boolean expiresAfterWrite()
  {
    return expireAfterWriteNanos > 0L;
  }
  
  public Object get(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = hash(paramObject);
    return segmentFor(i).get(paramObject, i);
  }
  
  public Cd.m getEntry(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = hash(paramObject);
    return segmentFor(i).getEntry(paramObject, i);
  }
  
  public Cd.m getLiveEntry(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = hash(paramObject);
    return segmentFor(i).getLiveEntry(paramObject, i);
  }
  
  public Object getLiveValue(Cd.m paramM)
  {
    if (paramM.getKey() == null) {
      return null;
    }
    Object localObject = paramM.getValueReference().get();
    if (localObject == null) {
      return null;
    }
    if ((expires()) && (isExpired(paramM))) {
      return null;
    }
    return localObject;
  }
  
  public int hash(Object paramObject)
  {
    return rehash(keyEquivalence.hash(paramObject));
  }
  
  public boolean isEmpty()
  {
    Cd.n[] arrayOfN = segments;
    long l = 0L;
    int i = 0;
    while (i < arrayOfN.length)
    {
      if (count != 0) {
        return false;
      }
      l += modCount;
      i += 1;
    }
    if (l != 0L)
    {
      i = 0;
      while (i < arrayOfN.length)
      {
        if (count != 0) {
          return false;
        }
        l -= modCount;
        i += 1;
      }
      if (l != 0L) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isExpired(Cd.m paramM)
  {
    return isExpired(paramM, ticker.read());
  }
  
  public boolean isExpired(Cd.m paramM, long paramLong)
  {
    return paramLong - paramM.p() > 0L;
  }
  
  public Set keySet()
  {
    Object localObject = keySet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new Cd.k(this);
    keySet = ((Set)localObject);
    return localObject;
  }
  
  public Cd.m newEntry(Object paramObject, int paramInt, Cd.m paramM)
  {
    return segmentFor(paramInt).newEntry(paramObject, paramInt, paramM);
  }
  
  public final Cd.n[] newSegmentArray(int paramInt)
  {
    return new Cd.n[paramInt];
  }
  
  public Cd.B newValueReference(Cd.m paramM, Object paramObject)
  {
    int i = paramM.getHash();
    return valueStrength.referenceValue(segmentFor(i), paramM, paramObject);
  }
  
  public void processPendingNotifications()
  {
    for (;;)
    {
      ud.e localE = (ud.e)removalNotificationQueue.poll();
      if (localE == null) {
        break;
      }
      ud.d localD = removalListener;
      try
      {
        localD.onRemoval(localE);
      }
      catch (Exception localException)
      {
        logger.log(Level.WARNING, "Exception thrown by removal listener", localException);
      }
    }
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        int i = hash(paramObject1);
        return segmentFor(i).put(paramObject1, i, paramObject2, false);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void putAll(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Object putIfAbsent(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        int i = hash(paramObject1);
        return segmentFor(i).put(paramObject1, i, paramObject2, true);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void reclaimKey(Cd.m paramM)
  {
    int i = paramM.getHash();
    segmentFor(i).removeEntry(paramM, i);
  }
  
  public void reclaimValue(Cd.B paramB)
  {
    Cd.m localM = paramB.navigateNext();
    int i = localM.getHash();
    segmentFor(i).reclaimValue(localM.getKey(), i, paramB);
  }
  
  public Object remove(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = hash(paramObject);
    return segmentFor(i).remove(paramObject, i);
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      int i = hash(paramObject1);
      return segmentFor(i).remove(paramObject1, i, paramObject2);
    }
    return false;
  }
  
  public Object replace(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        int i = hash(paramObject1);
        return segmentFor(i).replace(paramObject1, i, paramObject2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public boolean replace(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramObject1 != null)
    {
      if (paramObject3 != null)
      {
        if (paramObject2 == null) {
          return false;
        }
        int i = hash(paramObject1);
        return segmentFor(i).replace(paramObject1, i, paramObject2, paramObject3);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public Cd.n segmentFor(int paramInt)
  {
    return segments[(paramInt >>> segmentShift & segmentMask)];
  }
  
  public int size()
  {
    Cd.n[] arrayOfN = segments;
    long l = 0L;
    int i = 0;
    while (i < arrayOfN.length)
    {
      l += count;
      i += 1;
    }
    return g.b(l);
  }
  
  public boolean usesKeyReferences()
  {
    return keyStrength != Cd.u.STRONG;
  }
  
  public boolean usesValueReferences()
  {
    return valueStrength != Cd.u.STRONG;
  }
  
  public Collection values()
  {
    Object localObject = values;
    if (localObject != null) {
      return localObject;
    }
    localObject = new Cd.C(this);
    values = ((Collection)localObject);
    return localObject;
  }
  
  public Object writeReplace()
  {
    return new Cd.o(keyStrength, valueStrength, keyEquivalence, valueEquivalence, expireAfterWriteNanos, expireAfterAccessNanos, maximumSize, concurrencyLevel, removalListener, this);
  }
}
