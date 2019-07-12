package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.l;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

@b(emulated=true, serializable=true)
public final class LinkedHashMultiset<E>
  extends l<E>
{
  @c("not needed in emulated source")
  public static final long serialVersionUID = 0L;
  
  public LinkedHashMultiset()
  {
    super(new LinkedHashMap());
  }
  
  public LinkedHashMultiset(int paramInt)
  {
    super(new LinkedHashMap(Maps.capacity(paramInt)));
  }
  
  public static LinkedHashMultiset create()
  {
    return new LinkedHashMultiset();
  }
  
  public static LinkedHashMultiset create(int paramInt)
  {
    return new LinkedHashMultiset(paramInt);
  }
  
  public static LinkedHashMultiset create(Iterable paramIterable)
  {
    LinkedHashMultiset localLinkedHashMultiset = new LinkedHashMultiset(Multisets.inferDistinctElements(paramIterable));
    Iterables.addAll(localLinkedHashMultiset, paramIterable);
    return localLinkedHashMultiset;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    setBackingMap(new LinkedHashMap(Maps.capacity(i)));
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
