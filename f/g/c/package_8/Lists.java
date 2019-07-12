package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.j.g;
import f.g.c.package_10.Function;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Preconditions;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;

@b(emulated=true)
public final class Lists
{
  public Lists() {}
  
  public static boolean addAllImpl(List paramList, int paramInt, Iterable paramIterable)
  {
    paramList = paramList.listIterator(paramInt);
    paramIterable = paramIterable.iterator();
    for (boolean bool = false; paramIterable.hasNext(); bool = true) {
      paramList.add(paramIterable.next());
    }
    return bool;
  }
  
  public static List asList(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return new fd.l(paramObject1, paramObject2, paramArrayOfObject);
  }
  
  public static List asList(Object paramObject, Object[] paramArrayOfObject)
  {
    return new fd.c(paramObject, paramArrayOfObject);
  }
  
  public static int computeArrayListCapacity(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    return g.b(paramInt + 5L + paramInt / 10);
  }
  
  public static boolean equalsImpl(List paramList, Object paramObject)
  {
    if (paramList != null)
    {
      if (paramObject == paramList) {
        return true;
      }
      if (!(paramObject instanceof List)) {
        return false;
      }
      paramObject = (List)paramObject;
      return (paramList.size() == paramObject.size()) && (Iterators.elementsEqual(paramList.iterator(), paramObject.iterator()));
    }
    throw new NullPointerException();
  }
  
  public static List filter(Iterable paramIterable)
  {
    return (List)paramIterable;
  }
  
  public static int hashCodeImpl(List paramList)
  {
    paramList = paramList.iterator();
    int j;
    for (int i = 1; paramList.hasNext(); i = i * 31 + j)
    {
      Object localObject = paramList.next();
      if (localObject == null) {
        j = 0;
      } else {
        j = localObject.hashCode();
      }
    }
    return i;
  }
  
  public static int indexOfImpl(List paramList, Object paramObject)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (Objects.equal(paramObject, paramList.next())) {
        return paramList.previousIndex();
      }
    }
    return -1;
  }
  
  public static int lastIndexOfImpl(List paramList, Object paramObject)
  {
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious()) {
      if (Objects.equal(paramObject, paramList.previous())) {
        return paramList.nextIndex();
      }
    }
    return -1;
  }
  
  public static ListIterator listIteratorImpl(List paramList, int paramInt)
  {
    return new fd.a(paramList).listIterator(paramInt);
  }
  
  public static ArrayList newArrayList(Iterable paramIterable)
  {
    if (paramIterable != null)
    {
      if ((paramIterable instanceof Collection)) {
        return new ArrayList(Collections2.cast(paramIterable));
      }
      return newArrayList(paramIterable.iterator());
    }
    throw new NullPointerException();
  }
  
  public static ArrayList newArrayList(Iterator paramIterator)
  {
    if (paramIterator != null)
    {
      ArrayList localArrayList = new ArrayList();
      while (paramIterator.hasNext()) {
        localArrayList.add(paramIterator.next());
      }
      return localArrayList;
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static ArrayList newArrayList(Object... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      ArrayList localArrayList = new ArrayList(computeArrayListCapacity(paramVarArgs.length));
      Collections.addAll(localArrayList, paramVarArgs);
      return localArrayList;
    }
    throw new NullPointerException();
  }
  
  public static ArrayList newArrayListWithCapacity(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    return new ArrayList(paramInt);
  }
  
  public static ArrayList newArrayListWithExpectedSize()
  {
    return new ArrayList();
  }
  
  public static ArrayList newArrayListWithExpectedSize(int paramInt)
  {
    return new ArrayList(computeArrayListCapacity(paramInt));
  }
  
  public static CopyOnWriteArrayList newCopyOnWriteArrayList()
  {
    return new CopyOnWriteArrayList();
  }
  
  public static CopyOnWriteArrayList newCopyOnWriteArrayList(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      paramIterable = Collections2.cast(paramIterable);
    } else {
      paramIterable = newArrayList(paramIterable);
    }
    return new CopyOnWriteArrayList((Collection)paramIterable);
  }
  
  public static LinkedList newLinkedList()
  {
    return new LinkedList();
  }
  
  public static LinkedList newLinkedList(Iterable paramIterable)
  {
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localLinkedList.add(paramIterable.next());
    }
    return localLinkedList;
  }
  
  public static List partition(List paramList, int paramInt)
  {
    if (paramList != null)
    {
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      if ((paramList instanceof RandomAccess)) {
        return new fd.f(paramList, paramInt);
      }
      return new fd.d(paramList, paramInt);
    }
    throw new NullPointerException();
  }
  
  public static ImmutableList reverse(String paramString)
  {
    if (paramString != null) {
      return new fd.i(paramString);
    }
    throw new NullPointerException();
  }
  
  public static List reverse(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return new fd.b(paramCharSequence);
    }
    throw new NullPointerException();
  }
  
  public static List reverse(List paramList)
  {
    if ((paramList instanceof fd.h)) {
      return ((fd.h)paramList).getDates();
    }
    if ((paramList instanceof RandomAccess)) {
      return new fd.g(paramList);
    }
    return new fd.h(paramList);
  }
  
  public static List subListImpl(List paramList, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static List transform(List paramList, Function paramFunction)
  {
    if ((paramList instanceof RandomAccess)) {
      return new fd.j(paramList, paramFunction);
    }
    return new fd.k(paramList, paramFunction);
  }
}
