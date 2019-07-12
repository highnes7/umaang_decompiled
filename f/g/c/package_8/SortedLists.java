package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.package_10.Function;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@a
@b
public final class SortedLists
{
  public SortedLists() {}
  
  public static int binarySearch(List paramList, Function paramFunction, Comparable paramComparable, tg.b paramB, tg.a paramA)
  {
    return binarySearch(paramList, paramFunction, paramComparable, Ordering.natural(), paramB, paramA);
  }
  
  public static int binarySearch(List paramList, Function paramFunction, Object paramObject, Comparator paramComparator, tg.b paramB, tg.a paramA)
  {
    return binarySearch(Lists.transform(paramList, paramFunction), paramObject, paramComparator, paramB, paramA);
  }
  
  public static int binarySearch(List paramList, Comparable paramComparable, tg.b paramB, tg.a paramA)
  {
    if (paramComparable != null) {
      return binarySearch(paramList, paramComparable, Ordering.natural(), paramB, paramA);
    }
    throw new NullPointerException();
  }
  
  public static int binarySearch(List paramList, Object paramObject, Comparator paramComparator, tg.b paramB, tg.a paramA)
  {
    if (paramComparator != null)
    {
      if (paramList != null)
      {
        if (paramB != null)
        {
          if (paramA != null)
          {
            Object localObject = paramList;
            if (!(paramList instanceof RandomAccess)) {
              localObject = Lists.newArrayList((Iterable)paramList);
            }
            int j = 0;
            int i = ((List)localObject).size() - 1;
            while (j <= i)
            {
              int k = j + i >>> 1;
              int m = paramComparator.compare(paramObject, ((List)localObject).get(k));
              if (m < 0) {
                i = k - 1;
              } else if (m > 0) {
                j = k + 1;
              } else {
                return paramB.resultIndex(paramComparator, paramObject, ((List)localObject).subList(j, i + 1), k - j) + j;
              }
            }
            return paramA.resultIndex(j);
          }
          throw new NullPointerException();
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    paramList = new NullPointerException();
    throw paramList;
  }
}
