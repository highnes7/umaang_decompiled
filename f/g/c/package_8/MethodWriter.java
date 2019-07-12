package f.g.c.package_8;

import f.g.c.d.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodWriter<E>
  extends g<List<E>>
{
  public final List<E> b;
  public final int[] i;
  public int j;
  public final int[] k;
  
  public MethodWriter(List paramList)
  {
    b = new ArrayList(paramList);
    int n = paramList.size();
    i = new int[n];
    k = new int[n];
    int m = 0;
    while (m < n)
    {
      i[m] = 0;
      k[m] = 1;
      m += 1;
    }
    j = Integer.MAX_VALUE;
  }
  
  public void a()
  {
    int[] arrayOfInt = k;
    int m = j;
    arrayOfInt[m] = (-arrayOfInt[m]);
    j = (m - 1);
  }
  
  public void b()
  {
    j = (b.size() - 1);
    if (j == -1) {
      return;
    }
    int m = 0;
    int[] arrayOfInt;
    int n;
    int i1;
    for (;;)
    {
      arrayOfInt = i;
      n = j;
      i1 = arrayOfInt[n] + k[n];
      if (i1 < 0)
      {
        a();
      }
      else
      {
        if (i1 != n + 1) {
          break;
        }
        if (n == 0) {
          return;
        }
        m += 1;
        a();
      }
    }
    Collections.swap(b, n - arrayOfInt[n] + m, n - i1 + m);
    i[j] = i1;
  }
  
  public List computeNext()
  {
    if (j <= 0) {
      return (List)endOfData();
    }
    ImmutableList localImmutableList = ImmutableList.copyOf(b);
    b();
    return localImmutableList;
  }
}
