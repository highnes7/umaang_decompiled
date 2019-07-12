package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.z;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@b(emulated=true, serializable=true)
public class TreeMultimap<K, V>
  extends z<K, V>
{
  @c("not needed in emulated source")
  public static final long serialVersionUID = 0L;
  public transient Comparator<? super K> keyComparator;
  public transient Comparator<? super V> valueComparator;
  
  public TreeMultimap(Comparator paramComparator1, Comparator paramComparator2)
  {
    super(new TreeMap(paramComparator1));
    keyComparator = paramComparator1;
    valueComparator = paramComparator2;
  }
  
  public TreeMultimap(Comparator paramComparator1, Comparator paramComparator2, Multimap paramMultimap)
  {
    this(paramComparator1, paramComparator2);
    putAll(paramMultimap);
  }
  
  public static TreeMultimap create()
  {
    return new TreeMultimap(Ordering.natural(), Ordering.natural());
  }
  
  public static TreeMultimap create(Multimap paramMultimap)
  {
    TreeMultimap localTreeMultimap = new TreeMultimap(Ordering.natural(), Ordering.natural());
    localTreeMultimap.putAll(paramMultimap);
    return localTreeMultimap;
  }
  
  public static TreeMultimap create(Comparator paramComparator1, Comparator paramComparator2)
  {
    if (paramComparator1 != null)
    {
      if (paramComparator2 != null) {
        return new TreeMultimap(paramComparator1, paramComparator2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    Comparator localComparator = (Comparator)paramObjectInputStream.readObject();
    Preconditions.checkNotNull(localComparator);
    keyComparator = ((Comparator)localComparator);
    localComparator = (Comparator)paramObjectInputStream.readObject();
    Preconditions.checkNotNull(localComparator);
    valueComparator = ((Comparator)localComparator);
    setMap(new TreeMap(keyComparator));
    Serialization.populateMultimap(this, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(keyComparator());
    paramObjectOutputStream.writeObject(valueComparator());
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  public SortedMap asMap()
  {
    return (SortedMap)super.asMap();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return map.containsKey(paramObject);
  }
  
  public SortedSet createCollection()
  {
    return new TreeSet(valueComparator);
  }
  
  public Comparator keyComparator()
  {
    return keyComparator;
  }
  
  public SortedSet keySet()
  {
    return (SortedSet)super.keySet();
  }
  
  public int size()
  {
    return totalSize;
  }
  
  public Comparator valueComparator()
  {
    return valueComparator;
  }
}
