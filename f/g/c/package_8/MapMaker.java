package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.b.C;
import f.g.c.d.fb;
import f.g.c.package_10.ClassWriter;
import f.g.c.package_10.Equivalence;
import f.g.c.package_10.Function;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Objects.ToStringHelper;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Ticker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@b(emulated=true)
public final class MapMaker
  extends fb<Object, Object>
{
  public static final int DEFAULT_CONCURRENCY_LEVEL = 4;
  public static final int DEFAULT_EXPIRATION_NANOS = 0;
  public static final int DEFAULT_INITIAL_CAPACITY = 16;
  public static final int UNSET_INT = -1;
  public int concurrencyLevel = -1;
  public long expireAfterAccessNanos = -1L;
  public long expireAfterWriteNanos = -1L;
  public int initialCapacity = -1;
  public C<Object> keyEquivalence;
  public Cd.u keyStrength;
  public int maximumSize = -1;
  public ud.c nullRemovalCause;
  public Ticker ticker;
  public boolean useCustomMap;
  public Cd.u valueStrength;
  
  public MapMaker() {}
  
  private void checkExpiration(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (expireAfterWriteNanos == -1L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "expireAfterWrite was already set to %s ns", new Object[] { Long.valueOf(expireAfterWriteNanos) });
    if (expireAfterAccessNanos == -1L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "expireAfterAccess was already set to %s ns", new Object[] { Long.valueOf(expireAfterAccessNanos) });
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "duration cannot be negative: %s %s", new Object[] { Long.valueOf(paramLong), paramTimeUnit });
  }
  
  public MapMaker concurrencyLevel(int paramInt)
  {
    int i = concurrencyLevel;
    boolean bool2 = true;
    boolean bool1;
    if (i == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "concurrency level was already set to %s", new Object[] { Integer.valueOf(concurrencyLevel) });
    if (paramInt > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    concurrencyLevel = paramInt;
    return this;
  }
  
  public MapMaker expireAfterAccess(long paramLong, TimeUnit paramTimeUnit)
  {
    checkExpiration(paramLong, paramTimeUnit);
    expireAfterWriteNanos = paramTimeUnit.toNanos(paramLong);
    if ((paramLong == 0L) && (nullRemovalCause == null)) {
      nullRemovalCause = ud.c.EXPIRED;
    }
    useCustomMap = true;
    return this;
  }
  
  public MapMaker expireAfterWrite(long paramLong, TimeUnit paramTimeUnit)
  {
    checkExpiration(paramLong, paramTimeUnit);
    expireAfterAccessNanos = paramTimeUnit.toNanos(paramLong);
    if ((paramLong == 0L) && (nullRemovalCause == null)) {
      nullRemovalCause = ud.c.EXPIRED;
    }
    useCustomMap = true;
    return this;
  }
  
  public int getConcurrencyLevel()
  {
    int i = concurrencyLevel;
    if (i == -1) {
      return 4;
    }
    return i;
  }
  
  public long getExpireAfterAccessNanos()
  {
    long l = expireAfterAccessNanos;
    if (l == -1L) {
      return 0L;
    }
    return l;
  }
  
  public long getExpireAfterWriteNanos()
  {
    long l = expireAfterWriteNanos;
    if (l == -1L) {
      return 0L;
    }
    return l;
  }
  
  public int getInitialCapacity()
  {
    int i = initialCapacity;
    if (i == -1) {
      return 16;
    }
    return i;
  }
  
  public Equivalence getKeyEquivalence()
  {
    return (Equivalence)Objects.firstNonNull(keyEquivalence, getKeyStrength().defaultEquivalence());
  }
  
  public Cd.u getKeyStrength()
  {
    return (Cd.u)Objects.firstNonNull(keyStrength, Cd.u.STRONG);
  }
  
  public Ticker getTicker()
  {
    return (Ticker)Objects.firstNonNull(ticker, Ticker.ticker);
  }
  
  public Cd.u getValueStrength()
  {
    return (Cd.u)Objects.firstNonNull(valueStrength, Cd.u.STRONG);
  }
  
  public MapMaker initialCapacity(int paramInt)
  {
    int i = initialCapacity;
    boolean bool2 = true;
    boolean bool1;
    if (i == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "initial capacity was already set to %s", new Object[] { Integer.valueOf(initialCapacity) });
    if (paramInt >= 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    initialCapacity = paramInt;
    return this;
  }
  
  public MapMaker keyEquivalence(Equivalence paramEquivalence)
  {
    boolean bool;
    if (keyEquivalence == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "key equivalence was already set to %s", new Object[] { keyEquivalence });
    if (paramEquivalence != null)
    {
      keyEquivalence = paramEquivalence;
      useCustomMap = true;
      return this;
    }
    throw new NullPointerException();
  }
  
  public ConcurrentMap makeComputingMap(Function paramFunction)
  {
    if (nullRemovalCause == null) {
      return new ba.c(this, paramFunction);
    }
    return new ud.a(this, paramFunction);
  }
  
  public MapMakerInternalMap makeCustomMap()
  {
    return new MapMakerInternalMap(this);
  }
  
  public ConcurrentMap makeMap()
  {
    if (!useCustomMap) {
      return new ConcurrentHashMap(getInitialCapacity(), 0.75F, getConcurrencyLevel());
    }
    if (nullRemovalCause == null) {
      return new MapMakerInternalMap(this);
    }
    return new ud.b(this);
  }
  
  public MapMaker maximumSize(int paramInt)
  {
    int i = maximumSize;
    boolean bool2 = false;
    if (i == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "maximum size was already set to %s", new Object[] { Integer.valueOf(maximumSize) });
    boolean bool1 = bool2;
    if (paramInt >= 0) {
      bool1 = true;
    }
    Preconditions.checkArgument(bool1, "maximum size must not be negative");
    maximumSize = paramInt;
    useCustomMap = true;
    if (maximumSize == 0) {
      nullRemovalCause = ud.c.SIZE;
    }
    return this;
  }
  
  public GenericMapMaker removalListener(ud.d paramD)
  {
    boolean bool;
    if (removalListener == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    if (paramD != null)
    {
      removalListener = paramD;
      useCustomMap = true;
      return this;
    }
    throw new NullPointerException();
  }
  
  public MapMaker setKeyStrength(Cd.u paramU)
  {
    boolean bool;
    if (keyStrength == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Key strength was already set to %s", new Object[] { keyStrength });
    if (paramU != null)
    {
      keyStrength = paramU;
      if (paramU != Cd.u.STRONG)
      {
        useCustomMap = true;
        return this;
      }
    }
    else
    {
      throw new NullPointerException();
    }
    return this;
  }
  
  public MapMaker setValueStrength(Cd.u paramU)
  {
    boolean bool;
    if (valueStrength == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Value strength was already set to %s", new Object[] { valueStrength });
    if (paramU != null)
    {
      valueStrength = paramU;
      if (paramU != Cd.u.STRONG)
      {
        useCustomMap = true;
        return this;
      }
    }
    else
    {
      throw new NullPointerException();
    }
    return this;
  }
  
  public MapMaker softKeys()
  {
    return setKeyStrength(Cd.u.SOFT);
  }
  
  public MapMaker softValues()
  {
    return setValueStrength(Cd.u.SOFT);
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    int i = initialCapacity;
    if (i != -1) {
      localToStringHelper.add("initialCapacity", i);
    }
    i = concurrencyLevel;
    if (i != -1) {
      localToStringHelper.add("concurrencyLevel", i);
    }
    i = maximumSize;
    if (i != -1) {
      localToStringHelper.add("maximumSize", i);
    }
    if (expireAfterWriteNanos != -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(expireAfterWriteNanos);
      ((StringBuilder)localObject).append("ns");
      localToStringHelper.add("expireAfterWrite", ((StringBuilder)localObject).toString());
    }
    if (expireAfterAccessNanos != -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(expireAfterAccessNanos);
      ((StringBuilder)localObject).append("ns");
      localToStringHelper.add("expireAfterAccess", ((StringBuilder)localObject).toString());
    }
    Object localObject = keyStrength;
    if (localObject != null) {
      localToStringHelper.add("keyStrength", ClassWriter.toLowerCase(((Enum)localObject).toString()));
    }
    localObject = valueStrength;
    if (localObject != null) {
      localToStringHelper.add("valueStrength", ClassWriter.toLowerCase(((Enum)localObject).toString()));
    }
    if (keyEquivalence != null) {
      localToStringHelper.addValue("keyEquivalence");
    }
    if (removalListener != null) {
      localToStringHelper.addValue("removalListener");
    }
    return localToStringHelper.toString();
  }
  
  public MapMaker weakKeys()
  {
    return setKeyStrength(Cd.u.WEAK);
  }
  
  public MapMaker weakValues()
  {
    return setValueStrength(Cd.u.WEAK);
  }
}
