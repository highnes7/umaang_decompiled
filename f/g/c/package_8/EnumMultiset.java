package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.l;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;

@b(emulated=true)
public final class EnumMultiset<E extends Enum<E>>
  extends l<E>
{
  @c("Not needed in emulated source")
  public static final long serialVersionUID = 0L;
  public transient Class<E> type;
  
  public EnumMultiset(Class paramClass)
  {
    super(new WellBehavedMap(new EnumMap(paramClass)));
    type = paramClass;
  }
  
  public static EnumMultiset create(Class paramClass)
  {
    return new EnumMultiset(paramClass);
  }
  
  public static EnumMultiset create(Iterable paramIterable)
  {
    Object localObject = paramIterable.iterator();
    Preconditions.checkArgument(((Iterator)localObject).hasNext(), "EnumMultiset constructor passed empty Iterable");
    localObject = new EnumMultiset(((Enum)((Iterator)localObject).next()).getDeclaringClass());
    Iterables.addAll((Collection)localObject, paramIterable);
    return localObject;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    type = ((Class)paramObjectInputStream.readObject());
    setBackingMap(new WellBehavedMap(new EnumMap(type)));
    Serialization.populateMultiset(this, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(type);
    Serialization.writeMultiset(this, paramObjectOutputStream);
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
}
