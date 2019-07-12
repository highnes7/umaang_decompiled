package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ab;
import f.g.c.d.Mb;
import java.util.Map.Entry;

@b(serializable=true)
public class RegularImmutableMultiset<E>
  extends Mb<E>
{
  public final transient Ab<E, Integer> map;
  public final transient int size;
  
  public RegularImmutableMultiset(ImmutableMap paramImmutableMap, int paramInt)
  {
    map = paramImmutableMap;
    size = paramInt;
  }
  
  public static Ye.a entryFromMapEntry(Map.Entry paramEntry)
  {
    return Multisets.immutableEntry(paramEntry.getKey(), ((Integer)paramEntry.getValue()).intValue());
  }
  
  public boolean contains(Object paramObject)
  {
    return map.containsKey(paramObject);
  }
  
  public int count(Object paramObject)
  {
    paramObject = (Integer)map.get(paramObject);
    if (paramObject == null) {
      return 0;
    }
    return paramObject.intValue();
  }
  
  public ImmutableSet createEntrySet()
  {
    return new Gf.a(this, null);
  }
  
  public ImmutableSet elementSet()
  {
    return map.keySet();
  }
  
  public int hashCode()
  {
    return map.hashCode();
  }
  
  public boolean isPartialView()
  {
    return map.isPartialView();
  }
  
  public int size()
  {
    return size;
  }
}
