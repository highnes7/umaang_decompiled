package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Nb;
import f.g.c.d.Ye;
import f.g.c.d.rb;
import f.g.c.j.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

@b(serializable=true)
public abstract class ImmutableMultiset<E>
  extends rb<E>
  implements Ye<E>
{
  public transient Nb<f.g.c.d.Ye.a<E>> entrySet;
  
  public ImmutableMultiset() {}
  
  public static ImmutableMultiset copyFromEntries(Collection paramCollection)
  {
    Ab.a localA = ImmutableMap.builder();
    paramCollection = paramCollection.iterator();
    long l = 0L;
    while (paramCollection.hasNext())
    {
      Ye.a localA1 = (Ye.a)paramCollection.next();
      int i = localA1.getCount();
      if (i > 0)
      {
        localA.put(localA1.getElement(), Integer.valueOf(i));
        l += i;
      }
    }
    if (l == 0L) {
      return EmptyImmutableMultiset.INSTANCE;
    }
    return new RegularImmutableMultiset(localA.build(), g.b(l));
  }
  
  public static ImmutableMultiset copyOf(Iterable paramIterable)
  {
    if ((paramIterable instanceof ImmutableMultiset))
    {
      ImmutableMultiset localImmutableMultiset = (ImmutableMultiset)paramIterable;
      if (!localImmutableMultiset.isPartialView()) {
        return localImmutableMultiset;
      }
    }
    if ((paramIterable instanceof Multiset)) {
      paramIterable = Multisets.cast(paramIterable);
    } else {
      paramIterable = LinkedHashMultiset.create(paramIterable);
    }
    return copyOfInternal((Multiset)paramIterable);
  }
  
  public static ImmutableMultiset copyOf(Iterator paramIterator)
  {
    LinkedHashMultiset localLinkedHashMultiset = new LinkedHashMultiset();
    Iterators.addAll(localLinkedHashMultiset, paramIterator);
    return copyFromEntries(localLinkedHashMultiset.entrySet());
  }
  
  public static ImmutableMultiset copyOf(Object[] paramArrayOfObject)
  {
    return copyOf(Arrays.asList(paramArrayOfObject));
  }
  
  public static Mb.a copyOf()
  {
    return new Mb.a();
  }
  
  public static ImmutableMultiset copyOfInternal(Multiset paramMultiset)
  {
    return copyFromEntries(paramMultiset.entrySet());
  }
  
  public static ImmutableMultiset copyOfInternal(Object... paramVarArgs)
  {
    return copyOf(Arrays.asList(paramVarArgs));
  }
  
  public static ImmutableMultiset of()
  {
    return EmptyImmutableMultiset.INSTANCE;
  }
  
  public static ImmutableMultiset of(Object paramObject)
  {
    return copyOfInternal(new Object[] { paramObject });
  }
  
  public static ImmutableMultiset of(Object paramObject1, Object paramObject2)
  {
    return copyOfInternal(new Object[] { paramObject1, paramObject2 });
  }
  
  public static ImmutableMultiset of(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return copyOfInternal(new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static ImmutableMultiset of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return copyOfInternal(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static ImmutableMultiset of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    return copyOfInternal(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
  }
  
  public static ImmutableMultiset of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length + 6);
    Collections.addAll(localArrayList, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
    Collections.addAll(localArrayList, paramVarArgs);
    return copyOf(localArrayList);
  }
  
  public final int add(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(Object paramObject)
  {
    return count(paramObject) > 0;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    return elementSet().containsAll(paramCollection);
  }
  
  public abstract ImmutableSet createEntrySet();
  
  public ImmutableSet entrySet()
  {
    ImmutableSet localImmutableSet2 = entrySet;
    ImmutableSet localImmutableSet1 = localImmutableSet2;
    if (localImmutableSet2 == null)
    {
      localImmutableSet1 = createEntrySet();
      entrySet = localImmutableSet1;
    }
    return localImmutableSet1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Multiset))
    {
      paramObject = (Multiset)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        Ye.a localA = (Ye.a)paramObject.next();
        if (count(localA.getElement()) != localA.getCount()) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(entrySet());
  }
  
  public UnmodifiableIterator iterator()
  {
    return new ImmutableMultiset.1(this, entrySet().iterator());
  }
  
  public final int remove(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final int setCount(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean setCount(Object paramObject, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return entrySet().toString();
  }
  
  public Object writeReplace()
  {
    return new Mb.d(this);
  }
}
