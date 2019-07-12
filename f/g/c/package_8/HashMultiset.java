package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.l;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@b(emulated=true, serializable=true)
public final class HashMultiset<E>
  extends l<E>
{
  @c("Not needed in emulated source.")
  public static final long serialVersionUID = 0L;
  
  public HashMultiset()
  {
    super(new HashMap());
  }
  
  public HashMultiset(int paramInt)
  {
    super(Maps.newHashMapWithExpectedSize(paramInt));
  }
  
  public static HashMultiset create()
  {
    return new HashMultiset();
  }
  
  public static HashMultiset create(int paramInt)
  {
    return new HashMultiset(paramInt);
  }
  
  public static HashMultiset create(Iterable paramIterable)
  {
    HashMultiset localHashMultiset = new HashMultiset(Multisets.inferDistinctElements(paramIterable));
    Iterables.addAll(localHashMultiset, paramIterable);
    return localHashMultiset;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    setBackingMap(Maps.newHashMapWithExpectedSize(i));
    Serialization.populateMultiset(this, paramObjectInputStream, i);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultiset(this, paramObjectOutputStream);
  }
  
  public boolean add(Object paramObject)
  {
    add(paramObject, 1);
    return true;
  }
  
  public boolean addAll(Collection paramCollection)
  {
    return Multisets.addAllImpl(this, paramCollection);
  }
  
  public boolean contains(Object paramObject)
  {
    return count(paramObject) > 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  public Iterator iterator()
  {
    return new LinkedListMultimap.ValueForKeyIterator(this);
  }
  
  public boolean remove(Object paramObject)
  {
    return remove(paramObject, 1) > 0;
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    return Multisets.removeAllImpl(this, paramCollection);
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    return Multisets.retainAllImpl(this, paramCollection);
  }
  
  public boolean setCount(Object paramObject, int paramInt1, int paramInt2)
  {
    return Multisets.setCountImpl(this, paramObject, paramInt1, paramInt2);
  }
}
