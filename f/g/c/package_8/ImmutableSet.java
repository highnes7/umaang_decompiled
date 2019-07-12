package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.rb;
import f.g.c.package_10.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@b(emulated=true, serializable=true)
public abstract class ImmutableSet<E>
  extends rb<E>
  implements Set<E>
{
  public static final int CUTOFF = (int)Math.floor(7.516192768E8D);
  public static final double DESIRED_LOAD_FACTOR = 0.7D;
  public static final int MAX_TABLE_SIZE = 1073741824;
  
  public ImmutableSet() {}
  
  public static Nb.b builder()
  {
    return new Nb.b(4);
  }
  
  public static int chooseTableSize(int paramInt)
  {
    int i = CUTOFF;
    boolean bool = true;
    if (paramInt < i)
    {
      i = Integer.highestOneBit(paramInt - 1) << 1;
      for (;;)
      {
        double d = i;
        Double.isNaN(d);
        if (d * 0.7D >= paramInt) {
          break;
        }
        i <<= 1;
      }
      return i;
    }
    if (paramInt >= 1073741824) {
      bool = false;
    }
    Preconditions.checkArgument(bool, "collection too large");
    return 1073741824;
  }
  
  public static ImmutableSet copyOf(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return copyOf(Collections2.cast(paramIterable));
    }
    return of(paramIterable.iterator());
  }
  
  public static ImmutableSet copyOf(Collection paramCollection)
  {
    if (((paramCollection instanceof ImmutableSet)) && (!(paramCollection instanceof ImmutableSortedSet)))
    {
      ImmutableSet localImmutableSet = (ImmutableSet)paramCollection;
      if (!localImmutableSet.isPartialView()) {
        return localImmutableSet;
      }
    }
    return of(paramCollection);
  }
  
  public static ImmutableSet create(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        int n = chooseTableSize(paramInt);
        Object[] arrayOfObject = new Object[n];
        int i1 = n - 1;
        int i = 0;
        int j = 0;
        int k = 0;
        if (i < paramInt)
        {
          localObject1 = paramVarArgs[i];
          ObjectArrays.get(localObject1, i);
          int i2 = localObject1.hashCode();
          int m = CopyOnWriteArrayList.get(i2);
          for (;;)
          {
            int i3 = m & i1;
            Object localObject2 = arrayOfObject[i3];
            if (localObject2 == null)
            {
              paramVarArgs[j] = localObject1;
              arrayOfObject[i3] = localObject1;
              k += i2;
              j += 1;
            }
            else
            {
              if (!localObject2.equals(localObject1)) {
                break label128;
              }
            }
            i += 1;
            break;
            label128:
            m += 1;
          }
        }
        Arrays.fill(paramVarArgs, j, paramInt, null);
        if (j == 1) {
          return new SingletonImmutableSet(paramVarArgs[0], k);
        }
        if (n != chooseTableSize(j)) {
          return create(j, paramVarArgs);
        }
        Object localObject1 = paramVarArgs;
        if (j < paramVarArgs.length) {
          localObject1 = ObjectArrays.add(paramVarArgs, j);
        }
        return new .ImmutableSet.RegularImmutableSet((Object[])localObject1, k, arrayOfObject, i1);
      }
      return new SingletonImmutableSet(paramVarArgs[0]);
    }
    return EmptyImmutableSet.INSTANCE;
  }
  
  public static ImmutableSet of()
  {
    return EmptyImmutableSet.INSTANCE;
  }
  
  public static ImmutableSet of(Object paramObject)
  {
    return new SingletonImmutableSet(paramObject);
  }
  
  public static ImmutableSet of(Object paramObject1, Object paramObject2)
  {
    return create(2, new Object[] { paramObject1, paramObject2 });
  }
  
  public static ImmutableSet of(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return create(3, new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static ImmutableSet of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return create(4, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static ImmutableSet of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    return create(5, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
  }
  
  public static ImmutableSet of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object... paramVarArgs)
  {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 6];
    arrayOfObject[0] = paramObject1;
    arrayOfObject[1] = paramObject2;
    arrayOfObject[2] = paramObject3;
    arrayOfObject[3] = paramObject4;
    arrayOfObject[4] = paramObject5;
    arrayOfObject[5] = paramObject6;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 6, paramVarArgs.length);
    return create(arrayOfObject.length, arrayOfObject);
  }
  
  public static ImmutableSet of(Collection paramCollection)
  {
    paramCollection = paramCollection.toArray();
    int i = paramCollection.length;
    if (i != 0)
    {
      if (i != 1) {
        return create(paramCollection.length, paramCollection);
      }
      return new SingletonImmutableSet(paramCollection[0]);
    }
    return EmptyImmutableSet.INSTANCE;
  }
  
  public static ImmutableSet of(Iterator paramIterator)
  {
    if (!paramIterator.hasNext()) {
      return EmptyImmutableSet.INSTANCE;
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return new SingletonImmutableSet(localObject);
    }
    return new Nb.b(4).add(localObject).addModules(paramIterator).build();
  }
  
  public static ImmutableSet of(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i != 0)
    {
      if (i != 1) {
        return create(paramArrayOfObject.length, (Object[])paramArrayOfObject.clone());
      }
      return new SingletonImmutableSet(paramArrayOfObject[0]);
    }
    return EmptyImmutableSet.INSTANCE;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof ImmutableSet)) && (isHashCodeFast()) && (((ImmutableSet)paramObject).isHashCodeFast()) && (hashCode() != paramObject.hashCode())) {
      return false;
    }
    return Sets.equalsImpl(this, paramObject);
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  public boolean isHashCodeFast()
  {
    return false;
  }
  
  public abstract UnmodifiableIterator iterator();
  
  public Object writeReplace()
  {
    return new Nb.c(toArray());
  }
}
