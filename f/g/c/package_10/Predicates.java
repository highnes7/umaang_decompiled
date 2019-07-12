package f.g.c.package_10;

import f.g.c.a.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@b(emulated=true)
public final class Predicates
{
  public static final Joiner COMMA_JOINER = new Joiner(",");
  
  public Predicates() {}
  
  public static Predicate and(Predicate paramPredicate1, Predicate paramPredicate2)
  {
    if (paramPredicate1 != null)
    {
      if (paramPredicate2 != null) {
        return new ea.a(asList(paramPredicate1, paramPredicate2), null);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Predicate and(Iterable paramIterable)
  {
    return new ea.j(defensiveCopy(paramIterable), null);
  }
  
  public static Predicate and(Predicate... paramVarArgs)
  {
    return new ea.a(defensiveCopy(paramVarArgs), null);
  }
  
  public static List asList(Predicate paramPredicate1, Predicate paramPredicate2)
  {
    return Arrays.asList(new Predicate[] { paramPredicate1, paramPredicate2 });
  }
  
  public static Predicate b()
  {
    return ea.i.o.a();
  }
  
  public static Predicate c()
  {
    return ea.i.i.a();
  }
  
  public static Predicate compose(Predicate paramPredicate, Function paramFunction)
  {
    return new ea.c(paramPredicate, paramFunction);
  }
  
  public static Predicate contains(Pattern paramPattern)
  {
    return new ea.d(paramPattern);
  }
  
  public static List defensiveCopy(Iterable paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      Preconditions.checkNotNull(localObject);
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  public static List defensiveCopy(Object... paramVarArgs)
  {
    return defensiveCopy(Arrays.asList(paramVarArgs));
  }
  
  public static Predicate equalTo()
  {
    return ea.i.c.a();
  }
  
  public static Predicate equalTo(Object paramObject)
  {
    if (paramObject == null) {
      return equalTo();
    }
    return new ea.g(paramObject, null);
  }
  
  public static Predicate getElementType()
  {
    return ea.i.b.a();
  }
  
  public static Predicate in(Collection paramCollection)
  {
    return new ea.e(paramCollection, null);
  }
  
  public static Predicate instanceOf(Class paramClass)
  {
    return new ea.f(paramClass, null);
  }
  
  public static Predicate not(Predicate paramPredicate)
  {
    return new ea.h(paramPredicate);
  }
  
  public static Predicate notNull(Class paramClass)
  {
    return new ea.b(paramClass, null);
  }
  
  public static Predicate notNull(String paramString)
  {
    return new ea.d(paramString);
  }
  
  public static Predicate or(Predicate paramPredicate1, Predicate paramPredicate2)
  {
    if (paramPredicate1 != null)
    {
      if (paramPredicate2 != null) {
        return new ea.j(asList(paramPredicate1, paramPredicate2), null);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Predicate or(Iterable paramIterable)
  {
    return new ea.a(defensiveCopy(paramIterable), null);
  }
  
  public static Predicate or(Predicate... paramVarArgs)
  {
    return new ea.j(defensiveCopy(paramVarArgs), null);
  }
}
