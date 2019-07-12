package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.eb;
import f.g.c.d.sh;
import f.g.c.d.y;
import f.g.c.j.g;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

@b(emulated=true)
public final class TreeMultiset<E>
  extends y<E>
  implements Serializable
{
  @c("not needed in emulated source")
  public static final long serialVersionUID = 1L;
  public final transient f.g.c.d.sh.b<E> header;
  public final transient eb<E> range;
  public final transient f.g.c.d.sh.c<f.g.c.d.sh.b<E>> rootReference;
  
  public TreeMultiset(sh.c paramC, GeneralRange paramGeneralRange, sh.b paramB)
  {
    super(paramGeneralRange.comparator());
    rootReference = paramC;
    range = paramGeneralRange;
    header = paramB;
  }
  
  public TreeMultiset(Comparator paramComparator)
  {
    super(paramComparator);
    range = GeneralRange.all(paramComparator);
    header = new sh.b(null, 1);
    paramComparator = header;
    i = paramComparator;
    s = paramComparator;
    rootReference = new sh.c(null);
  }
  
  private long add(sh.a paramA, sh.b paramB)
  {
    if (paramB == null) {
      return 0L;
    }
    int i = comparator().compare(range.getLowerEndpoint(), m);
    if (i < 0) {
      return add(paramA, b);
    }
    if (i == 0)
    {
      i = range.getLowerBoundType().ordinal();
      if (i != 0)
      {
        if (i == 1) {
          return paramA.size(b);
        }
        throw new AssertionError();
      }
      long l = paramA.get(paramB);
      return paramA.size(b) + l;
    }
    return paramA.size(b) + paramA.get(paramB) + add(paramA, a);
  }
  
  public static void add(sh.b paramB1, sh.b paramB2, sh.b paramB3)
  {
    i = paramB2;
    s = paramB1;
    i = paramB3;
    s = paramB2;
  }
  
  private long aggregateForEntries(sh.a paramA)
  {
    sh.b localB = (sh.b)rootReference.get();
    long l2 = paramA.size(localB);
    long l1 = l2;
    if (range.hasLowerBound()) {
      l1 = l2 - add(paramA, localB);
    }
    if (range.hasUpperBound()) {
      return l1 - remove(paramA, localB);
    }
    return l1;
  }
  
  public static int b(sh.b paramB)
  {
    if (paramB == null) {
      return 0;
    }
    return j;
  }
  
  public static TreeMultiset create()
  {
    return new TreeMultiset(Ordering.natural());
  }
  
  public static TreeMultiset create(Iterable paramIterable)
  {
    TreeMultiset localTreeMultiset = create();
    Iterables.addAll(localTreeMultiset, paramIterable);
    return localTreeMultiset;
  }
  
  public static TreeMultiset create(Comparator paramComparator)
  {
    if (paramComparator == null) {
      return new TreeMultiset(Ordering.natural());
    }
    return new TreeMultiset(paramComparator);
  }
  
  public static void d(sh.b paramB1, sh.b paramB2)
  {
    i = paramB2;
    s = paramB1;
  }
  
  private sh.b firstNode()
  {
    if ((sh.b)rootReference.get() == null) {
      return null;
    }
    sh.b localB1;
    if (range.hasLowerBound())
    {
      Object localObject = range.getLowerEndpoint();
      sh.b localB3 = sh.b.access$getCeiling((sh.b)rootReference.get(), comparator(), localObject);
      sh.b localB2 = localB3;
      if (localB3 == null) {
        return null;
      }
      localB1 = localB2;
      if (range.getLowerBoundType() == BoundType.OPEN)
      {
        localB1 = localB2;
        if (comparator().compare(localObject, localB3.getElement()) == 0) {
          localB1 = i;
        }
      }
    }
    else
    {
      localB1 = header.i;
    }
    if ((localB1 == header) || (!range.contains(localB1.getElement()))) {
      return null;
    }
    return localB1;
  }
  
  private sh.b lastNode()
  {
    if ((sh.b)rootReference.get() == null) {
      return null;
    }
    sh.b localB1;
    if (range.hasUpperBound())
    {
      Object localObject = range.getUpperEndpoint();
      sh.b localB3 = sh.b.access$getFloor((sh.b)rootReference.get(), comparator(), localObject);
      sh.b localB2 = localB3;
      if (localB3 == null) {
        return null;
      }
      localB1 = localB2;
      if (range.getUpperBoundType() == BoundType.OPEN)
      {
        localB1 = localB2;
        if (comparator().compare(localObject, localB3.getElement()) == 0) {
          localB1 = s;
        }
      }
    }
    else
    {
      localB1 = header.s;
    }
    if ((localB1 == header) || (!range.contains(localB1.getElement()))) {
      return null;
    }
    return localB1;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    Object localObject = (Comparator)paramObjectInputStream.readObject();
    Serialization.getFieldSetter(y.class, "comparator").set(this, localObject);
    Serialization.getFieldSetter(sh.class, "range").set(this, GeneralRange.all((Comparator)localObject));
    Serialization.getFieldSetter(sh.class, "rootReference").set(this, new sh.c(null));
    localObject = new sh.b(null, 1);
    Serialization.getFieldSetter(sh.class, "header").set(this, localObject);
    i = ((sh.b)localObject);
    s = ((sh.b)localObject);
    Serialization.populateMultiset(this, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  private long remove(sh.a paramA, sh.b paramB)
  {
    if (paramB == null) {
      return 0L;
    }
    int i = comparator().compare(range.getUpperEndpoint(), m);
    if (i > 0) {
      return remove(paramA, a);
    }
    if (i == 0)
    {
      i = range.getUpperBoundType().ordinal();
      if (i != 0)
      {
        if (i == 1) {
          return paramA.size(a);
        }
        throw new AssertionError();
      }
      long l = paramA.get(paramB);
      return paramA.size(a) + l;
    }
    return paramA.size(a) + paramA.get(paramB) + remove(paramA, b);
  }
  
  private Ye.a wrapEntry(sh.b paramB)
  {
    return new TreeMultiset.1(this, paramB);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(elementSet().comparator());
    Serialization.writeMultiset(this, paramObjectOutputStream);
  }
  
  public int add(Object paramObject, int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "occurrences must be >= 0 but was %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      return count(paramObject);
    }
    Preconditions.checkArgument(range.contains(paramObject));
    sh.b localB = (sh.b)rootReference.get();
    if (localB == null)
    {
      comparator().compare(paramObject, paramObject);
      paramObject = new sh.b(paramObject, paramInt);
      localObject = header;
      add((sh.b)localObject, paramObject, (sh.b)localObject);
      rootReference.get(localB, paramObject);
      return 0;
    }
    Object localObject = new int[1];
    paramObject = localB.add(comparator(), paramObject, paramInt, (int[])localObject);
    rootReference.get(localB, paramObject);
    return localObject[0];
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
  
  public Comparator comparator()
  {
    return comparator;
  }
  
  public boolean contains(Object paramObject)
  {
    return count(paramObject) > 0;
  }
  
  public int count(Object paramObject)
  {
    try
    {
      Object localObject = rootReference;
      try
      {
        localObject = ((sh.c)localObject).get();
        localObject = (sh.b)localObject;
        GeneralRange localGeneralRange = range;
        boolean bool = localGeneralRange.contains(paramObject);
        if (bool)
        {
          if (localObject == null) {
            return 0;
          }
          int i = ((sh.b)localObject).add(comparator(), paramObject);
          return i;
        }
        return 0;
      }
      catch (ClassCastException paramObject)
      {
        return 0;
      }
      return 0;
    }
    catch (NullPointerException paramObject) {}
  }
  
  public Iterator descendingEntryIterator()
  {
    return new TreeMultiset.3(this);
  }
  
  public int distinctElements()
  {
    return g.b(aggregateForEntries(sh.a.N));
  }
  
  public Iterator entryIterator()
  {
    return new TreeMultiset.2(this);
  }
  
  public boolean equals(Object paramObject)
  {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  public SortedMultiset headMultiset(Object paramObject, BoundType paramBoundType)
  {
    return new TreeMultiset(rootReference, range.intersect(GeneralRange.upTo(comparator(), paramObject, paramBoundType)), header);
  }
  
  public Iterator iterator()
  {
    return Multisets.iteratorImpl(this);
  }
  
  public int remove(Object paramObject, int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "occurrences must be >= 0 but was %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      return count(paramObject);
    }
    sh.b localB = (sh.b)rootReference.get();
    int[] arrayOfInt = new int[1];
    GeneralRange localGeneralRange = range;
    try
    {
      bool = localGeneralRange.contains(paramObject);
      if (bool)
      {
        if (localB == null) {
          return 0;
        }
        paramObject = localB.b(comparator(), paramObject, paramInt, arrayOfInt);
        rootReference.get(localB, paramObject);
        return arrayOfInt[0];
      }
      return 0;
    }
    catch (ClassCastException paramObject)
    {
      return 0;
    }
    catch (NullPointerException paramObject) {}
    return 0;
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
  
  public int setCount(Object paramObject, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (!range.contains(paramObject))
    {
      if (paramInt == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1);
      return 0;
    }
    sh.b localB = (sh.b)rootReference.get();
    if (localB == null)
    {
      if (paramInt > 0)
      {
        add(paramObject, paramInt);
        return 0;
      }
    }
    else
    {
      int[] arrayOfInt = new int[1];
      paramObject = localB.a(comparator(), paramObject, paramInt, arrayOfInt);
      rootReference.get(localB, paramObject);
      return arrayOfInt[0];
    }
    return 0;
  }
  
  public boolean setCount(Object paramObject, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if (paramInt1 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    Preconditions.checkArgument(range.contains(paramObject));
    sh.b localB = (sh.b)rootReference.get();
    if (localB == null)
    {
      if (paramInt1 == 0)
      {
        if (paramInt2 > 0)
        {
          add(paramObject, paramInt2);
          return true;
        }
      }
      else {
        return false;
      }
    }
    else
    {
      int[] arrayOfInt = new int[1];
      paramObject = localB.a(comparator(), paramObject, paramInt1, paramInt2, arrayOfInt);
      rootReference.get(localB, paramObject);
      return arrayOfInt[0] == paramInt1;
    }
    return true;
  }
  
  public int size()
  {
    return g.b(aggregateForEntries(sh.a.b));
  }
  
  public SortedMultiset tailMultiset(Object paramObject, BoundType paramBoundType)
  {
    return new TreeMultiset(rootReference, range.intersect(GeneralRange.downTo(comparator(), paramObject, paramBoundType)), header);
  }
}
