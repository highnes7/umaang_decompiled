package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.L;
import f.g.c.d.Sa;
import f.g.c.d.Ya;
import f.g.c.d.d;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b(emulated=true)
public abstract class AbstractBiMap<K, V>
  extends Sa<K, V>
  implements L<K, V>, Serializable
{
  @c("Not needed in emulated source.")
  public static final long serialVersionUID = 0L;
  public transient Map<K, V> delegate;
  public transient Set<Map.Entry<K, V>> entrySet;
  public transient d<V, K> inverse;
  public transient Set<K> keySet;
  public transient Set<V> valueSet;
  
  public AbstractBiMap(Map paramMap, AbstractBiMap paramAbstractBiMap)
  {
    delegate = paramMap;
    inverse = paramAbstractBiMap;
  }
  
  public AbstractBiMap(Map paramMap1, Map paramMap2)
  {
    setDelegates(paramMap1, paramMap2);
  }
  
  private Object putInBothMaps(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    checkKey(paramObject1);
    checkValue(paramObject2);
    boolean bool = containsKey(paramObject1);
    if ((bool) && (Objects.equal(paramObject2, get(paramObject1)))) {
      return paramObject2;
    }
    if (paramBoolean) {
      inverse().remove(paramObject2);
    } else {
      Preconditions.checkArgument(containsValue(paramObject2) ^ true, "value already present: %s", new Object[] { paramObject2 });
    }
    Object localObject = delegate.put(paramObject1, paramObject2);
    updateInverseMap(paramObject1, bool, localObject, paramObject2);
    return localObject;
  }
  
  private Object removeFromBothMaps(Object paramObject)
  {
    paramObject = delegate.remove(paramObject);
    removeFromInverseMap(paramObject);
    return paramObject;
  }
  
  private void removeFromInverseMap(Object paramObject)
  {
    inverse.delegate.remove(paramObject);
  }
  
  private void updateInverseMap(Object paramObject1, boolean paramBoolean, Object paramObject2, Object paramObject3)
  {
    if (paramBoolean) {
      inverse.delegate.remove(paramObject2);
    }
    inverse.delegate.put(paramObject3, paramObject1);
  }
  
  public Object checkKey(Object paramObject)
  {
    return paramObject;
  }
  
  public Object checkValue(Object paramObject)
  {
    return paramObject;
  }
  
  public void clear()
  {
    delegate.clear();
    inverse.delegate.clear();
  }
  
  public boolean containsValue(Object paramObject)
  {
    return inverse.containsKey(paramObject);
  }
  
  public Map delegate()
  {
    return delegate;
  }
  
  public Set entrySet()
  {
    Object localObject = entrySet;
    if (localObject == null)
    {
      localObject = new EntrySet();
      entrySet = ((Set)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public Object forcePut(Object paramObject1, Object paramObject2)
  {
    return putInBothMaps(paramObject1, paramObject2, true);
  }
  
  public BiMap inverse()
  {
    return inverse;
  }
  
  public Set keySet()
  {
    Object localObject = keySet;
    if (localObject == null)
    {
      localObject = new KeySet(null);
      keySet = ((Set)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    return putInBothMaps(paramObject1, paramObject2, false);
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
  
  public Object remove(Object paramObject)
  {
    if (containsKey(paramObject))
    {
      paramObject = delegate.remove(paramObject);
      removeFromInverseMap(paramObject);
      return paramObject;
    }
    return null;
  }
  
  public void setDelegates(Map paramMap1, Map paramMap2)
  {
    Map localMap = delegate;
    boolean bool2 = true;
    boolean bool1;
    if (localMap == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1);
    if (inverse == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1);
    Preconditions.checkArgument(paramMap1.isEmpty());
    Preconditions.checkArgument(paramMap2.isEmpty());
    if (paramMap1 != paramMap2) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    delegate = paramMap1;
    inverse = new Inverse(paramMap2, this, null);
  }
  
  public void setInverse(AbstractBiMap paramAbstractBiMap)
  {
    inverse = paramAbstractBiMap;
  }
  
  public Set values()
  {
    Object localObject = valueSet;
    if (localObject == null)
    {
      localObject = new ValueSet();
      valueSet = ((Set)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public class EntrySet
    extends Ya<Map.Entry<K, V>>
  {
    public final Set<Map.Entry<K, V>> esDelegate = AbstractBiMap.access$getDelegate(AbstractBiMap.this).entrySet();
    
    public EntrySet() {}
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return Maps.containsEntryImpl(delegate(), paramObject);
    }
    
    public boolean containsAll(Collection paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    public Set delegate()
    {
      return esDelegate;
    }
    
    public Iterator iterator()
    {
      return new TByteByteMapDecorator.1.1(this, esDelegate.iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      if (!esDelegate.contains(paramObject)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      AbstractBiMap.access$getDelegate(inverse).remove(paramObject.getValue());
      esDelegate.remove(paramObject);
      return true;
    }
    
    public boolean removeAll(Collection paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public Object[] toArray(Object[] paramArrayOfObject)
    {
      return standardToArray(paramArrayOfObject);
    }
  }
  
  public class Inverse<K, V>
    extends d<K, V>
  {
    @c("Not needed in emulated source.")
    public static final long serialVersionUID = 0L;
    
    public Inverse(AbstractBiMap paramAbstractBiMap)
    {
      super(paramAbstractBiMap, null);
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      setInverse((AbstractBiMap)paramObjectInputStream.readObject());
    }
    
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      paramObjectOutputStream.writeObject(inverse());
    }
    
    public Object checkKey(Object paramObject)
    {
      return inverse.checkValue(paramObject);
    }
    
    public Object checkValue(Object paramObject)
    {
      return inverse.checkKey(paramObject);
    }
    
    public Object delegate()
    {
      return delegate;
    }
    
    public Object readResolve()
    {
      return inverse().inverse();
    }
  }
  
  public class KeySet
    extends Ya<K>
  {
    public KeySet() {}
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    public Set delegate()
    {
      return AbstractBiMap.access$getDelegate(AbstractBiMap.this).keySet();
    }
    
    public Iterator iterator()
    {
      return Maps.valueIterator(entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      if (!contains(paramObject)) {
        return false;
      }
      AbstractBiMap.removeFromBothMaps(AbstractBiMap.this, paramObject);
      return true;
    }
    
    public boolean removeAll(Collection paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
  }
  
  public class ValueSet
    extends Ya<V>
  {
    public final Set<V> valuesDelegate = inverse.keySet();
    
    public ValueSet() {}
    
    public Set delegate()
    {
      return valuesDelegate;
    }
    
    public Iterator iterator()
    {
      return Maps.keyIterator(entrySet().iterator());
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public Object[] toArray(Object[] paramArrayOfObject)
    {
      return standardToArray(paramArrayOfObject);
    }
    
    public String toString()
    {
      return standardToString();
    }
  }
}
