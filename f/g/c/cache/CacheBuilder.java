package f.g.c.cache;

import f.g.c.a.b;
import f.g.c.b.C;
import f.g.c.b.ya;
import f.g.c.c.P;
import f.g.c.c.X;
import f.g.c.c.a.b;
import f.g.c.c.g;
import f.g.c.c.g.a;
import f.g.c.c.g.b;
import f.g.c.package_10.ClassWriter;
import f.g.c.package_10.Equivalence;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Objects.ToStringHelper;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Supplier;
import f.g.c.package_10.Ticker;
import f.g.c.package_10.za.e;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@b(emulated=true)
public final class CacheBuilder<K, V>
{
  public static final ya<a.b> CACHE_STATS_COUNTER = new Striped.5();
  public static final int DEFAULT_CONCURRENCY_LEVEL = 16;
  public static final int DEFAULT_EXPIRATION_NANOS = 0;
  public static final int DEFAULT_INITIAL_CAPACITY = 4;
  public static final int DEFAULT_REFRESH_NANOS = 0;
  public static final Handle EMPTY_STATS;
  public static final ya<? extends a.b> NULL_STATS_COUNTER = new za.e(new AbstractCache.StatsCounter()
  {
    public void recordEviction() {}
    
    public void recordHits(int paramAnonymousInt) {}
    
    public void recordLoadException(long paramAnonymousLong) {}
    
    public void recordLoadSuccess(long paramAnonymousLong) {}
    
    public void recordMisses(int paramAnonymousInt) {}
    
    public Handle snapshot()
    {
      return CacheBuilder.EMPTY_STATS;
    }
  });
  public static final Ticker NULL_TICKER = new Ticker()
  {
    public long read()
    {
      return 0L;
    }
  };
  public static final int UNSET_INT = -1;
  public static final Logger logger = Logger.getLogger(g.class.getName());
  public int concurrencyLevel = -1;
  public long expireAfterAccessNanos = -1L;
  public long expireAfterWriteNanos = -1L;
  public int initialCapacity = -1;
  public C<Object> keyEquivalence;
  public LocalCache.Strength keyStrength;
  public long maximumSize = -1L;
  public long maximumWeight = -1L;
  public long refreshNanos = -1L;
  public P<? super K, ? super V> removalListener;
  public ya<? extends a.b> statsCounterSupplier = NULL_STATS_COUNTER;
  public boolean strictParsing = true;
  public Ticker ticker;
  public C<Object> valueEquivalence;
  public LocalCache.Strength valueStrength;
  public X<? super K, ? super V> weigher;
  
  static
  {
    EMPTY_STATS = new Handle(0L, 0L, 0L, 0L, 0L, 0L);
  }
  
  public CacheBuilder() {}
  
  private void checkNonLoadingCache()
  {
    boolean bool;
    if (refreshNanos == -1L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "refreshAfterWrite requires a LoadingCache");
  }
  
  private void checkWeightWithWeigher()
  {
    Weigher localWeigher = weigher;
    boolean bool2 = true;
    boolean bool1 = true;
    if (localWeigher == null)
    {
      if (maximumWeight != -1L) {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "maximumWeight requires weigher");
      return;
    }
    if (strictParsing)
    {
      if (maximumWeight != -1L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "weigher requires maximumWeight");
      return;
    }
    if (maximumWeight == -1L) {
      logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
    }
  }
  
  public static CacheBuilder from(CacheBuilderSpec paramCacheBuilderSpec)
  {
    return paramCacheBuilderSpec.toCacheBuilder().lenientParsing();
  }
  
  public static CacheBuilder from(String paramString)
  {
    return CacheBuilderSpec.parse(paramString).toCacheBuilder().lenientParsing();
  }
  
  public static CacheBuilder newBuilder()
  {
    return new CacheBuilder();
  }
  
  public Cache build()
  {
    checkWeightWithWeigher();
    checkNonLoadingCache();
    return new LocalCache.LocalManualCache(this);
  }
  
  public LoadingCache build(CacheLoader paramCacheLoader)
  {
    checkWeightWithWeigher();
    return new LocalCache.LocalLoadingCache(this, paramCacheLoader);
  }
  
  public CacheBuilder concurrencyLevel(int paramInt)
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
  
  public CacheBuilder expireAfterAccess(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
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
    expireAfterAccessNanos = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public CacheBuilder expireAfterWrite(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (expireAfterWriteNanos == -1L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "expireAfterWrite was already set to %s ns", new Object[] { Long.valueOf(expireAfterWriteNanos) });
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "duration cannot be negative: %s %s", new Object[] { Long.valueOf(paramLong), paramTimeUnit });
    expireAfterWriteNanos = paramTimeUnit.toNanos(paramLong);
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
  
  public LocalCache.Strength getKeyStrength()
  {
    return (LocalCache.Strength)Objects.firstNonNull(keyStrength, LocalCache.Strength.STRONG);
  }
  
  public long getMaximumWeight()
  {
    if (expireAfterWriteNanos != 0L)
    {
      if (expireAfterAccessNanos == 0L) {
        return 0L;
      }
      if (weigher == null) {
        return maximumSize;
      }
      return maximumWeight;
    }
    return 0L;
  }
  
  public long getRefreshNanos()
  {
    long l = refreshNanos;
    if (l == -1L) {
      return 0L;
    }
    return l;
  }
  
  public RemovalListener getRemovalListener()
  {
    return (RemovalListener)Objects.firstNonNull(removalListener, NullListener.INSTANCE);
  }
  
  public Supplier getStatsCounterSupplier()
  {
    return statsCounterSupplier;
  }
  
  public Ticker getTicker(boolean paramBoolean)
  {
    Ticker localTicker = ticker;
    if (localTicker != null) {
      return localTicker;
    }
    if (paramBoolean) {
      return Ticker.ticker;
    }
    return NULL_TICKER;
  }
  
  public Equivalence getValueEquivalence()
  {
    return (Equivalence)Objects.firstNonNull(valueEquivalence, getValueStrength().defaultEquivalence());
  }
  
  public LocalCache.Strength getValueStrength()
  {
    return (LocalCache.Strength)Objects.firstNonNull(valueStrength, LocalCache.Strength.STRONG);
  }
  
  public Weigher getWeigher()
  {
    return (Weigher)Objects.firstNonNull(weigher, OneWeigher.INSTANCE);
  }
  
  public CacheBuilder initialCapacity(int paramInt)
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
  
  public CacheBuilder keyEquivalence(Equivalence paramEquivalence)
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
      return this;
    }
    throw new NullPointerException();
  }
  
  public CacheBuilder lenientParsing()
  {
    strictParsing = false;
    return this;
  }
  
  public CacheBuilder maximumSize(long paramLong)
  {
    long l = maximumSize;
    boolean bool2 = true;
    boolean bool1;
    if (l == -1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "maximum size was already set to %s", new Object[] { Long.valueOf(maximumSize) });
    if (maximumWeight == -1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "maximum weight was already set to %s", new Object[] { Long.valueOf(maximumWeight) });
    if (weigher == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "maximum size can not be combined with weigher");
    if (paramLong >= 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "maximum size must not be negative");
    maximumSize = paramLong;
    return this;
  }
  
  public CacheBuilder maximumWeight(long paramLong)
  {
    long l = maximumWeight;
    boolean bool2 = true;
    boolean bool1;
    if (l == -1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "maximum weight was already set to %s", new Object[] { Long.valueOf(maximumWeight) });
    if (maximumSize == -1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "maximum size was already set to %s", new Object[] { Long.valueOf(maximumSize) });
    maximumWeight = paramLong;
    if (paramLong >= 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "maximum weight must not be negative");
    return this;
  }
  
  public CacheBuilder recordStats()
  {
    statsCounterSupplier = CACHE_STATS_COUNTER;
    return this;
  }
  
  public CacheBuilder refreshAfterWrite(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit != null)
    {
      boolean bool;
      if (refreshNanos == -1L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "refresh was already set to %s ns", new Object[] { Long.valueOf(refreshNanos) });
      if (paramLong > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "duration must be positive: %s %s", new Object[] { Long.valueOf(paramLong), paramTimeUnit });
      refreshNanos = paramTimeUnit.toNanos(paramLong);
      return this;
    }
    throw new NullPointerException();
  }
  
  public CacheBuilder removalListener(RemovalListener paramRemovalListener)
  {
    boolean bool;
    if (removalListener == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    if (paramRemovalListener != null)
    {
      removalListener = paramRemovalListener;
      return this;
    }
    throw new NullPointerException();
  }
  
  public CacheBuilder setKeyStrength(LocalCache.Strength paramStrength)
  {
    boolean bool;
    if (keyStrength == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Key strength was already set to %s", new Object[] { keyStrength });
    if (paramStrength != null)
    {
      keyStrength = paramStrength;
      return this;
    }
    throw new NullPointerException();
  }
  
  public CacheBuilder setValueStrength(LocalCache.Strength paramStrength)
  {
    boolean bool;
    if (valueStrength == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Value strength was already set to %s", new Object[] { valueStrength });
    if (paramStrength != null)
    {
      valueStrength = paramStrength;
      return this;
    }
    throw new NullPointerException();
  }
  
  public CacheBuilder softValues()
  {
    return setValueStrength(LocalCache.Strength.SOFT);
  }
  
  public CacheBuilder strongKeys()
  {
    return setKeyStrength(LocalCache.Strength.STRONG);
  }
  
  public CacheBuilder strongValues()
  {
    return setValueStrength(LocalCache.Strength.STRONG);
  }
  
  public CacheBuilder ticker(Ticker paramTicker)
  {
    boolean bool;
    if (ticker == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    if (paramTicker != null)
    {
      ticker = paramTicker;
      return this;
    }
    throw new NullPointerException();
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
    long l = maximumWeight;
    if (l != -1L) {
      if (weigher == null) {
        localToStringHelper.add("maximumSize", l);
      } else {
        localToStringHelper.add("maximumWeight", l);
      }
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
    if (valueEquivalence != null) {
      localToStringHelper.addValue("valueEquivalence");
    }
    if (removalListener != null) {
      localToStringHelper.addValue("removalListener");
    }
    return localToStringHelper.toString();
  }
  
  public CacheBuilder valueEquivalence(Equivalence paramEquivalence)
  {
    boolean bool;
    if (valueEquivalence == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "value equivalence was already set to %s", new Object[] { valueEquivalence });
    if (paramEquivalence != null)
    {
      valueEquivalence = paramEquivalence;
      return this;
    }
    throw new NullPointerException();
  }
  
  public CacheBuilder weakKeys()
  {
    return setKeyStrength(LocalCache.Strength.WEAK);
  }
  
  public CacheBuilder weakValues()
  {
    return setValueStrength(LocalCache.Strength.WEAK);
  }
  
  public CacheBuilder weigher(Weigher paramWeigher)
  {
    boolean bool;
    if (weigher == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    if (strictParsing)
    {
      if (maximumSize == -1L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "weigher can not be combined with maximum size", new Object[] { Long.valueOf(maximumSize) });
    }
    if (paramWeigher != null)
    {
      weigher = paramWeigher;
      return this;
    }
    throw new NullPointerException();
  }
  
  public enum NullListener
    implements P<Object, Object>
  {
    INSTANCE;
    
    public void onRemoval(RemovalNotification paramRemovalNotification) {}
  }
  
  public enum OneWeigher
    implements X<Object, Object>
  {
    INSTANCE;
    
    public int weigh(Object paramObject1, Object paramObject2)
    {
      return 1;
    }
  }
}
