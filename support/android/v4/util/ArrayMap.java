package support.android.v4.util;

import b.b.a.G;
import b.b.x.n.n;
import b.b.x.n.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayMap<K, V>
  extends t<K, V>
  implements Map<K, V>
{
  @G
  public n<K, V> mCollections;
  
  public ArrayMap() {}
  
  public ArrayMap(int paramInt)
  {
    super(paramInt);
  }
  
  public ArrayMap(SimpleArrayMap paramSimpleArrayMap)
  {
    if (paramSimpleArrayMap != null) {
      putAll(paramSimpleArrayMap);
    }
  }
  
  private MapCollections getCollection()
  {
    if (mCollections == null) {
      mCollections = new ArrayMap.1(this);
    }
    return mCollections;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    return MapCollections.containsAllHelper(this, paramCollection);
  }
  
  public Set entrySet()
  {
    return getCollection().getEntrySet();
  }
  
  public Set keySet()
  {
    return getCollection().getKeySet();
  }
  
  public void putAll(Map paramMap)
  {
    int i = mSize;
    ensureCapacity(paramMap.size() + i);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    return MapCollections.removeAllHelper(this, paramCollection);
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    return MapCollections.retainAllHelper(this, paramCollection);
  }
  
  public Collection values()
  {
    return getCollection().getValues();
  }
}
