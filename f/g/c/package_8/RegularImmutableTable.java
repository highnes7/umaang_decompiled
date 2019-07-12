package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.b.J;
import f.g.c.d.Nb;
import f.g.c.d.Yb;
import f.g.c.d.vb;
import f.g.c.package_10.Function;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import m.a.h;

@b
public abstract class RegularImmutableTable<R, C, V>
  extends Yb<R, C, V>
{
  public static final J<f.g.c.d.Yg.a<Object, Object, Object>, Object> GET_VALUE_FUNCTION = new Function4();
  public final Nb<f.g.c.d.Yg.a<R, C, V>> cellSet;
  @h
  public volatile transient vb<V> values;
  
  public RegularImmutableTable(ImmutableSet paramImmutableSet)
  {
    cellSet = paramImmutableSet;
  }
  
  public static final RegularImmutableTable forCells(Iterable paramIterable)
  {
    return forCellsInternal(paramIterable, null, null);
  }
  
  public static final RegularImmutableTable forCells(List paramList, Comparator paramComparator1, Comparator paramComparator2)
  {
    if (paramList != null)
    {
      if ((paramComparator1 != null) || (paramComparator2 != null)) {
        Collections.sort(paramList, new RegularImmutableTable.1(paramComparator1, paramComparator2));
      }
      return forCellsInternal(paramList, paramComparator1, paramComparator2);
    }
    throw new NullPointerException();
  }
  
  public static final RegularImmutableTable forCellsInternal(Iterable paramIterable, Comparator paramComparator1, Comparator paramComparator2)
  {
    Object localObject2 = ImmutableSet.builder();
    Object localObject1 = ImmutableSet.builder();
    Nb.b localB = ImmutableSet.builder();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Yg.a localA = (Yg.a)paramIterable.next();
      ((Nb.b)localObject2).add(localA);
      ((Nb.b)localObject1).add(localA.getRowKey());
      localB.add(localA.getColumnKey());
    }
    localObject2 = ((Nb.b)localObject2).build();
    localObject1 = ((Nb.b)localObject1).build();
    paramIterable = (Iterable)localObject1;
    if (paramComparator1 != null)
    {
      paramIterable = Lists.newArrayList((Iterable)localObject1);
      Collections.sort(paramIterable, paramComparator1);
      paramIterable = ImmutableSet.copyOf(paramIterable);
    }
    localObject1 = localB.build();
    paramComparator1 = (Comparator)localObject1;
    if (paramComparator2 != null)
    {
      paramComparator1 = Lists.newArrayList((Iterable)localObject1);
      Collections.sort(paramComparator1, paramComparator2);
      paramComparator1 = ImmutableSet.copyOf(paramComparator1);
    }
    int i = ((Collection)localObject2).size();
    int j = paramIterable.size();
    if (i > paramComparator1.size() * j / 2) {
      return new Rf.a((ImmutableSet)localObject2, paramIterable, paramComparator1);
    }
    return new Rf.c((ImmutableSet)localObject2, paramIterable, paramComparator1);
  }
  
  private Function getValueFunction()
  {
    return GET_VALUE_FUNCTION;
  }
  
  public final ImmutableSet cellSet()
  {
    return cellSet;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final int size()
  {
    return cellSet().size();
  }
  
  public final ImmutableCollection values()
  {
    ImmutableList localImmutableList2 = values;
    ImmutableList localImmutableList1 = localImmutableList2;
    if (localImmutableList2 == null)
    {
      localImmutableList1 = ImmutableList.copyOf(Iterables.transform(cellSet(), GET_VALUE_FUNCTION));
      values = localImmutableList1;
    }
    return localImmutableList1;
  }
}
