package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.package_10.Absent;
import f.g.c.package_10.Function;
import f.g.c.package_10.Optional;
import f.g.c.package_10.Predicate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

@a
@b(emulated=true)
public abstract class FluentIterable<E>
  implements Iterable<E>
{
  public final Iterable<E> iterable;
  
  public FluentIterable()
  {
    iterable = this;
  }
  
  public FluentIterable(Iterable paramIterable)
  {
    if (paramIterable != null)
    {
      iterable = paramIterable;
      return;
    }
    throw new NullPointerException();
  }
  
  public static FluentIterable from(FluentIterable paramFluentIterable)
  {
    if (paramFluentIterable != null) {
      return paramFluentIterable;
    }
    throw new NullPointerException();
  }
  
  public static FluentIterable from(Iterable paramIterable)
  {
    if ((paramIterable instanceof FluentIterable)) {
      return (FluentIterable)paramIterable;
    }
    return new Iterables.8(paramIterable, paramIterable);
  }
  
  public final boolean allMatch(Predicate paramPredicate)
  {
    return Iterables.all(iterable, paramPredicate);
  }
  
  public final FluentIterable append(int paramInt)
  {
    return from(Iterables.limit(iterable, paramInt));
  }
  
  public final boolean contains(Object paramObject)
  {
    return Iterables.contains(iterable, paramObject);
  }
  
  public final FluentIterable cycle()
  {
    return from(Iterables.cycle(iterable));
  }
  
  public final FluentIterable filter(Class paramClass)
  {
    return from(Iterables.filter(iterable, paramClass));
  }
  
  public final boolean filter(Predicate paramPredicate)
  {
    return Iterables.filter(iterable, paramPredicate);
  }
  
  public final Optional first()
  {
    Iterator localIterator = iterable.iterator();
    if (localIterator.hasNext()) {
      return Optional.of(localIterator.next());
    }
    return Absent.INSTANCE;
  }
  
  public final Optional firstMatch(Predicate paramPredicate)
  {
    return Iterables.tryFind(iterable, paramPredicate);
  }
  
  public final Object get(int paramInt)
  {
    return Iterables.get(iterable, paramInt);
  }
  
  public final boolean isEmpty()
  {
    return iterable.iterator().hasNext() ^ true;
  }
  
  public final Optional last()
  {
    Object localObject1 = iterable;
    if ((localObject1 instanceof List))
    {
      localObject1 = (List)localObject1;
      if (((List)localObject1).isEmpty()) {
        return Absent.INSTANCE;
      }
      return Optional.of(((List)localObject1).get(((List)localObject1).size() - 1));
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (!((Iterator)localObject1).hasNext()) {
      return Absent.INSTANCE;
    }
    Object localObject2 = iterable;
    if ((localObject2 instanceof SortedSet)) {
      return Optional.of(((SortedSet)localObject2).last());
    }
    do
    {
      localObject2 = ((Iterator)localObject1).next();
    } while (((Iterator)localObject1).hasNext());
    return Optional.of(localObject2);
  }
  
  public final int size()
  {
    return Iterables.size(iterable);
  }
  
  public final FluentIterable skip(int paramInt)
  {
    return from(Iterables.skip(iterable, paramInt));
  }
  
  public final FluentIterable skip(Predicate paramPredicate)
  {
    return from(Iterables.get(iterable, paramPredicate));
  }
  
  public final Object[] toArray(Class paramClass)
  {
    return Iterables.toArray(iterable, paramClass);
  }
  
  public final ImmutableList toList()
  {
    return ImmutableList.copyOf(iterable);
  }
  
  public final ImmutableSet toSet()
  {
    return ImmutableSet.copyOf(iterable);
  }
  
  public final ImmutableList toSortedList(Comparator paramComparator)
  {
    return Ordering.from(paramComparator).immutableSortedCopy(iterable);
  }
  
  public final ImmutableSortedSet toSortedSet(Comparator paramComparator)
  {
    return ImmutableSortedSet.copyOf(paramComparator, iterable);
  }
  
  public String toString()
  {
    return Iterables.toString(iterable);
  }
  
  public final FluentIterable transform(Function paramFunction)
  {
    return from(Iterables.transform(iterable, paramFunction));
  }
  
  public FluentIterable transformAndConcat(Function paramFunction)
  {
    return from(Iterables.concat(transform(paramFunction)));
  }
}
