package f.g.c.cache;

import f.g.c.a.a;
import f.g.c.a.d;
import f.g.c.c.i.k;
import f.g.c.d.Ab;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Objects.ToStringHelper;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Splitter;
import f.g.c.package_8.Ab.a;
import f.g.c.package_8.ImmutableList;
import f.g.c.package_8.ImmutableMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@a
public final class CacheBuilderSpec
{
  public static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
  public static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
  public static final Ab<String, i.k> VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser()).put("weakKeys", new KeyStrengthParser(LocalCache.Strength.WEAK)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(LocalCache.Strength.WEAK)).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();
  @d
  public long accessExpirationDuration;
  @d
  public TimeUnit accessExpirationTimeUnit;
  @d
  public Integer concurrencyLevel;
  @d
  public Integer initialCapacity;
  @d
  public LocalCache.Strength keyStrength;
  @d
  public Long maximumSize;
  @d
  public Long maximumWeight;
  @d
  public long refreshDuration;
  @d
  public TimeUnit refreshTimeUnit;
  public final String specification;
  @d
  public LocalCache.Strength valueStrength;
  @d
  public long writeExpirationDuration;
  @d
  public TimeUnit writeExpirationTimeUnit;
  
  public CacheBuilderSpec(String paramString)
  {
    specification = paramString;
  }
  
  public static CacheBuilderSpec disableCaching()
  {
    return parse("maximumSize=0");
  }
  
  public static Long durationInNanos(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      return null;
    }
    return Long.valueOf(paramTimeUnit.toNanos(paramLong));
  }
  
  public static CacheBuilderSpec parse(String paramString)
  {
    CacheBuilderSpec localCacheBuilderSpec = new CacheBuilderSpec(paramString);
    if (paramString.length() > 0)
    {
      Iterator localIterator = KEYS_SPLITTER.split(paramString).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(str));
        Preconditions.checkArgument(paramString.isEmpty() ^ true, "blank key-value pair");
        boolean bool;
        if (paramString.size() <= 2) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool, "key-value pair %s with more than one equals sign", new Object[] { str });
        str = (String)paramString.get(0);
        ValueParser localValueParser = (ValueParser)VALUE_PARSERS.get(str);
        if (localValueParser != null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool, "unknown key %s", new Object[] { str });
        if (paramString.size() == 1) {
          paramString = null;
        } else {
          paramString = (String)paramString.get(1);
        }
        localValueParser.parse(localCacheBuilderSpec, str, paramString);
      }
    }
    return localCacheBuilderSpec;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CacheBuilderSpec)) {
      return false;
    }
    paramObject = (CacheBuilderSpec)paramObject;
    return (Objects.equal(initialCapacity, initialCapacity)) && (Objects.equal(maximumSize, maximumSize)) && (Objects.equal(maximumWeight, maximumWeight)) && (Objects.equal(concurrencyLevel, concurrencyLevel)) && (Objects.equal(keyStrength, keyStrength)) && (Objects.equal(valueStrength, valueStrength)) && (Objects.equal(durationInNanos(writeExpirationDuration, writeExpirationTimeUnit), durationInNanos(writeExpirationDuration, writeExpirationTimeUnit))) && (Objects.equal(durationInNanos(accessExpirationDuration, accessExpirationTimeUnit), durationInNanos(accessExpirationDuration, accessExpirationTimeUnit))) && (Objects.equal(durationInNanos(refreshDuration, refreshTimeUnit), durationInNanos(refreshDuration, refreshTimeUnit)));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { initialCapacity, maximumSize, maximumWeight, concurrencyLevel, keyStrength, valueStrength, durationInNanos(writeExpirationDuration, writeExpirationTimeUnit), durationInNanos(accessExpirationDuration, accessExpirationTimeUnit), durationInNanos(refreshDuration, refreshTimeUnit) });
  }
  
  public CacheBuilder toCacheBuilder()
  {
    CacheBuilder localCacheBuilder = new CacheBuilder();
    Object localObject = initialCapacity;
    if (localObject != null) {
      localCacheBuilder.initialCapacity(((Integer)localObject).intValue());
    }
    localObject = maximumSize;
    if (localObject != null) {
      localCacheBuilder.maximumSize(((Long)localObject).longValue());
    }
    localObject = maximumWeight;
    if (localObject != null) {
      localCacheBuilder.maximumWeight(((Long)localObject).longValue());
    }
    localObject = concurrencyLevel;
    if (localObject != null) {
      localCacheBuilder.concurrencyLevel(((Integer)localObject).intValue());
    }
    localObject = keyStrength;
    if (localObject != null) {
      if (((Enum)localObject).ordinal() == 2) {
        localCacheBuilder.weakKeys();
      } else {
        throw new AssertionError();
      }
    }
    localObject = valueStrength;
    if (localObject != null)
    {
      int i = ((Enum)localObject).ordinal();
      if (i != 1)
      {
        if (i == 2) {
          localCacheBuilder.weakValues();
        } else {
          throw new AssertionError();
        }
      }
      else {
        localCacheBuilder.softValues();
      }
    }
    localObject = writeExpirationTimeUnit;
    if (localObject != null) {
      localCacheBuilder.expireAfterWrite(writeExpirationDuration, (TimeUnit)localObject);
    }
    localObject = accessExpirationTimeUnit;
    if (localObject != null) {
      localCacheBuilder.expireAfterAccess(accessExpirationDuration, (TimeUnit)localObject);
    }
    localObject = refreshTimeUnit;
    if (localObject != null) {
      localCacheBuilder.refreshAfterWrite(refreshDuration, (TimeUnit)localObject);
    }
    return localCacheBuilder;
  }
  
  public String toParsableString()
  {
    return specification;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).addValue(toParsableString()).toString();
  }
  
  public class AccessDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    public AccessDurationParser() {}
    
    public void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (accessExpirationTimeUnit == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "expireAfterAccess already set");
      accessExpirationDuration = paramLong;
      accessExpirationTimeUnit = paramTimeUnit;
    }
  }
  
  public class ConcurrencyLevelParser
    extends CacheBuilderSpec.IntegerParser
  {
    public ConcurrencyLevelParser() {}
    
    public void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt)
    {
      boolean bool;
      if (concurrencyLevel == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "concurrency level was already set to ", new Object[] { concurrencyLevel });
      concurrencyLevel = Integer.valueOf(paramInt);
    }
  }
  
  public abstract class DurationParser
    implements CacheBuilderSpec.ValueParser
  {
    public DurationParser() {}
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      boolean bool;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "value of key %s omitted", new Object[] { paramString1 });
      try
      {
        int i = paramString2.length();
        i = paramString2.charAt(i - 1);
        long l1 = 1L;
        if (i != 100)
        {
          l2 = l1;
          if (i != 104)
          {
            l2 = l1;
            if (i == 109) {
              break label133;
            }
            if (i == 115) {
              break label141;
            }
            paramCacheBuilderSpec = new IllegalArgumentException(String.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[] { paramString1, paramString2 }));
            throw paramCacheBuilderSpec;
          }
        }
        else
        {
          l2 = 24L;
        }
        l2 *= 60L;
        label133:
        l1 = l2 * 60L;
        label141:
        TimeUnit localTimeUnit = TimeUnit.SECONDS;
        i = paramString2.length();
        long l2 = Long.parseLong(paramString2.substring(0, i - 1));
        parseDuration(paramCacheBuilderSpec, l1 * l2, localTimeUnit);
        return;
      }
      catch (NumberFormatException paramCacheBuilderSpec)
      {
        for (;;) {}
      }
      throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }));
    }
    
    public abstract void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit);
  }
  
  public class InitialCapacityParser
    extends CacheBuilderSpec.IntegerParser
  {
    public InitialCapacityParser() {}
    
    public void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt)
    {
      boolean bool;
      if (initialCapacity == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "initial capacity was already set to ", new Object[] { initialCapacity });
      initialCapacity = Integer.valueOf(paramInt);
    }
  }
  
  public abstract class IntegerParser
    implements CacheBuilderSpec.ValueParser
  {
    public IntegerParser() {}
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      boolean bool;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "value of key %s omitted", new Object[] { paramString1 });
      try
      {
        parseInteger(paramCacheBuilderSpec, Integer.parseInt(paramString2));
        return;
      }
      catch (NumberFormatException paramCacheBuilderSpec)
      {
        throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }), paramCacheBuilderSpec);
      }
    }
    
    public abstract void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt);
  }
  
  public class KeyStrengthParser
    implements CacheBuilderSpec.ValueParser
  {
    public KeyStrengthParser() {}
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      boolean bool;
      if (paramString2 == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "key %s does not take values", new Object[] { paramString1 });
      if (keyStrength == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "%s was already set to %s", new Object[] { paramString1, keyStrength });
      keyStrength = CacheBuilderSpec.this;
    }
  }
  
  public abstract class LongParser
    implements CacheBuilderSpec.ValueParser
  {
    public LongParser() {}
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      boolean bool;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "value of key %s omitted", new Object[] { paramString1 });
      try
      {
        parseLong(paramCacheBuilderSpec, Long.parseLong(paramString2));
        return;
      }
      catch (NumberFormatException paramCacheBuilderSpec)
      {
        throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }), paramCacheBuilderSpec);
      }
    }
    
    public abstract void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong);
  }
  
  public class MaximumSizeParser
    extends CacheBuilderSpec.LongParser
  {
    public MaximumSizeParser() {}
    
    public void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong)
    {
      boolean bool;
      if (maximumSize == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "maximum size was already set to ", new Object[] { maximumSize });
      if (maximumWeight == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "maximum weight was already set to ", new Object[] { maximumWeight });
      maximumSize = Long.valueOf(paramLong);
    }
  }
  
  public class MaximumWeightParser
    extends CacheBuilderSpec.LongParser
  {
    public MaximumWeightParser() {}
    
    public void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong)
    {
      boolean bool;
      if (maximumWeight == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "maximum weight was already set to ", new Object[] { maximumWeight });
      if (maximumSize == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "maximum size was already set to ", new Object[] { maximumSize });
      maximumWeight = Long.valueOf(paramLong);
    }
  }
  
  public class RefreshDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    public RefreshDurationParser() {}
    
    public void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (refreshTimeUnit == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "refreshAfterWrite already set");
      refreshDuration = paramLong;
      refreshTimeUnit = paramTimeUnit;
    }
  }
  
  public abstract interface ValueParser
  {
    public abstract void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2);
  }
  
  public class ValueStrengthParser
    implements CacheBuilderSpec.ValueParser
  {
    public ValueStrengthParser() {}
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      boolean bool;
      if (paramString2 == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "key %s does not take values", new Object[] { paramString1 });
      if (valueStrength == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "%s was already set to %s", new Object[] { paramString1, valueStrength });
      valueStrength = CacheBuilderSpec.this;
    }
  }
  
  public class WriteDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    public WriteDurationParser() {}
    
    public void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (writeExpirationTimeUnit == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "expireAfterWrite already set");
      writeExpirationDuration = paramLong;
      writeExpirationTimeUnit = paramTimeUnit;
    }
  }
}
