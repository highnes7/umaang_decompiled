package f.g.c.package_8;

import f.g.c.b.J;
import f.g.c.d.Cd;
import f.g.c.package_10.Function;
import java.util.concurrent.ExecutionException;

public class ComputingConcurrentHashMap<K, V>
  extends Cd<K, V>
{
  public static final long serialVersionUID = 4L;
  public final J<? super K, ? extends V> computingFunction;
  
  public ComputingConcurrentHashMap(MapMaker paramMapMaker, Function paramFunction)
  {
    super(paramMapMaker);
    if (paramFunction != null)
    {
      computingFunction = paramFunction;
      return;
    }
    throw new NullPointerException();
  }
  
  public Cd.n createSegment(int paramInt1, int paramInt2)
  {
    return new ba.d(this, paramInt1, paramInt2);
  }
  
  public Object getOrCompute(Object paramObject)
    throws ExecutionException
  {
    if (paramObject != null)
    {
      int i = hash(paramObject);
      return segmentFor(i).getOrCompute(paramObject, i, computingFunction);
    }
    throw new NullPointerException();
  }
  
  public ba.d segmentFor(int paramInt)
  {
    return (ba.d)segments[(paramInt >>> segmentShift & segmentMask)];
  }
  
  public Object writeReplace()
  {
    return new ba.e(keyStrength, valueStrength, keyEquivalence, valueEquivalence, expireAfterWriteNanos, expireAfterAccessNanos, maximumSize, concurrencyLevel, removalListener, this, computingFunction);
  }
}
