package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

@a
@b
public final class Constraints
{
  public Constraints() {}
  
  public static ListIterator access$getConstrainedListIterator(ListIterator paramListIterator, Constraint paramConstraint)
  {
    return new ha.c(paramListIterator, paramConstraint);
  }
  
  public static Collection checkElements(Collection paramCollection, Constraint paramConstraint)
  {
    paramCollection = Lists.newArrayList(paramCollection);
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      paramConstraint.checkElement(localIterator.next());
    }
    return paramCollection;
  }
  
  public static Collection constrainedCollection(Collection paramCollection, Constraint paramConstraint)
  {
    return new ha.a(paramCollection, paramConstraint);
  }
  
  public static List constrainedList(List paramList, Constraint paramConstraint)
  {
    if ((paramList instanceof RandomAccess)) {
      return new ha.e(paramList, paramConstraint);
    }
    return new ha.b(paramList, paramConstraint);
  }
  
  public static Multiset constrainedMultiset(Multiset paramMultiset, Constraint paramConstraint)
  {
    return new ha.d(paramMultiset, paramConstraint);
  }
  
  public static Set constrainedSet(Set paramSet, Constraint paramConstraint)
  {
    return new ha.f(paramSet, paramConstraint);
  }
  
  public static SortedSet constrainedSortedSet(SortedSet paramSortedSet, Constraint paramConstraint)
  {
    return new ha.g(paramSortedSet, paramConstraint);
  }
  
  public static Collection constrainedTypePreservingCollection(Collection paramCollection, Constraint paramConstraint)
  {
    if ((paramCollection instanceof SortedSet)) {
      return new ha.g((SortedSet)paramCollection, paramConstraint);
    }
    if ((paramCollection instanceof Set)) {
      return new ha.f((Set)paramCollection, paramConstraint);
    }
    if ((paramCollection instanceof List)) {
      return constrainedList((List)paramCollection, paramConstraint);
    }
    return new ha.a(paramCollection, paramConstraint);
  }
  
  public static Constraint notNull()
  {
    return ha.h.INSTANCE;
  }
}
