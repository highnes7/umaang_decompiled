package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.package_10.Equivalence;
import f.g.c.package_10.Function;
import f.g.c.package_10.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@a
@b(emulated=true)
public abstract class GenericMapMaker<K0, V0>
{
  @c("To be supported")
  public f.g.c.d.ud.d<K0, V0> removalListener;
  
  public GenericMapMaker() {}
  
  public abstract GenericMapMaker concurrencyLevel(int paramInt);
  
  public abstract GenericMapMaker expireAfterAccess(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract GenericMapMaker expireAfterWrite(long paramLong, TimeUnit paramTimeUnit);
  
  public ud.d getRemovalListener()
  {
    return (ud.d)Objects.firstNonNull(removalListener, fb.a.INSTANCE);
  }
  
  public abstract GenericMapMaker initialCapacity(int paramInt);
  
  public abstract GenericMapMaker keyEquivalence(Equivalence paramEquivalence);
  
  public abstract ConcurrentMap makeComputingMap(Function paramFunction);
  
  public abstract MapMakerInternalMap makeCustomMap();
  
  public abstract ConcurrentMap makeMap();
  
  public abstract GenericMapMaker maximumSize(int paramInt);
  
  public abstract GenericMapMaker softKeys();
  
  public abstract GenericMapMaker softValues();
  
  public abstract GenericMapMaker weakKeys();
  
  public abstract GenericMapMaker weakValues();
}
