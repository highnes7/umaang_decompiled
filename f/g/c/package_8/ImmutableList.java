package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.rb;
import f.g.c.package_10.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

@b(emulated=true, serializable=true)
public abstract class ImmutableList<E>
  extends rb<E>
  implements List<E>, RandomAccess
{
  public ImmutableList() {}
  
  public static vb.a add()
  {
    return new vb.a(4);
  }
  
  public static ImmutableList construct(Object... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      ObjectArrays.get(paramVarArgs[i], i);
      i += 1;
    }
    return new RegularImmutableList(paramVarArgs);
  }
  
  public static ImmutableList copyFromCollection(Collection paramCollection)
  {
    return of(paramCollection.toArray());
  }
  
  public static ImmutableList copyOf(Iterable paramIterable)
  {
    if (paramIterable != null)
    {
      if ((paramIterable instanceof Collection)) {
        return copyOf(Collections2.cast(paramIterable));
      }
      return of(paramIterable.iterator());
    }
    throw new NullPointerException();
  }
  
  public static ImmutableList copyOf(Collection paramCollection)
  {
    if ((paramCollection instanceof ImmutableCollection))
    {
      ImmutableList localImmutableList = ((ImmutableCollection)paramCollection).asList();
      paramCollection = localImmutableList;
      if (localImmutableList.isPartialView()) {
        return of(localImmutableList.toArray());
      }
    }
    else
    {
      paramCollection = of(paramCollection.toArray());
    }
    return paramCollection;
  }
  
  public static ImmutableList copyOf(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i != 0)
    {
      if (i != 1) {
        return construct((Object[])paramArrayOfObject.clone());
      }
      return new SingletonImmutableList(paramArrayOfObject[0]);
    }
    return EmptyImmutableList.INSTANCE;
  }
  
  public static ImmutableList of()
  {
    return EmptyImmutableList.INSTANCE;
  }
  
  public static ImmutableList of(Object paramObject)
  {
    return new SingletonImmutableList(paramObject);
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2)
  {
    return construct(new Object[] { paramObject1, paramObject2 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10, Object paramObject11)
  {
    return construct(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11 });
  }
  
  public static ImmutableList of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10, Object paramObject11, Object paramObject12, Object... paramVarArgs)
  {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 12];
    arrayOfObject[0] = paramObject1;
    arrayOfObject[1] = paramObject2;
    arrayOfObject[2] = paramObject3;
    arrayOfObject[3] = paramObject4;
    arrayOfObject[4] = paramObject5;
    arrayOfObject[5] = paramObject6;
    arrayOfObject[6] = paramObject7;
    arrayOfObject[7] = paramObject8;
    arrayOfObject[8] = paramObject9;
    arrayOfObject[9] = paramObject10;
    arrayOfObject[10] = paramObject11;
    arrayOfObject[11] = paramObject12;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 12, paramVarArgs.length);
    return construct(arrayOfObject);
  }
  
  public static ImmutableList of(Iterator paramIterator)
  {
    if (!paramIterator.hasNext()) {
      return EmptyImmutableList.INSTANCE;
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return new SingletonImmutableList(localObject);
    }
    return new vb.a(4).add(localObject).addModules(paramIterator).build();
  }
  
  public static ImmutableList of(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i != 0)
    {
      if (i != 1) {
        return construct(paramArrayOfObject);
      }
      return new SingletonImmutableList(paramArrayOfObject[0]);
    }
    return EmptyImmutableList.INSTANCE;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList asList()
  {
    return this;
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return Lists.equalsImpl(this, paramObject);
  }
  
  public int hashCode()
  {
    return Lists.hashCodeImpl(this);
  }
  
  public int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    return Lists.indexOfImpl(this, paramObject);
  }
  
  public UnmodifiableIterator iterator()
  {
    return listIterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    return Lists.lastIndexOfImpl(this, paramObject);
  }
  
  public UnmodifiableListIterator listIterator()
  {
    return listIterator(0);
  }
  
  public UnmodifiableListIterator listIterator(int paramInt)
  {
    return new ImmutableList.1(this, size(), paramInt);
  }
  
  public final Object remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList reverse()
  {
    return new vb.b(this);
  }
  
  public final Object set(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    int i = paramInt2 - paramInt1;
    if (i != 0)
    {
      if (i != 1) {
        return subListUnchecked(paramInt1, paramInt2);
      }
      return new SingletonImmutableList(get(paramInt1));
    }
    return EmptyImmutableList.INSTANCE;
  }
  
  public ImmutableList subListUnchecked(int paramInt1, int paramInt2)
  {
    return new vb.d(this, paramInt1, paramInt2 - paramInt1);
  }
  
  public Object writeReplace()
  {
    return new vb.c(toArray());
  }
}
