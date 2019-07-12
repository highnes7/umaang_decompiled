package support.android.v4.util;

public final class i<E>
{
  public E[] a;
  public int b;
  public int c;
  public int i;
  
  public i()
  {
    this(8);
  }
  
  public i(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (paramInt <= 1073741824)
      {
        int j = paramInt;
        if (Integer.bitCount(paramInt) != 1) {
          j = Integer.highestOneBit(paramInt - 1) << 1;
        }
        c = (j - 1);
        a = new Object[j];
        return;
      }
      throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    throw new IllegalArgumentException("capacity must be >= 1");
  }
  
  private void a()
  {
    Object[] arrayOfObject1 = a;
    int j = arrayOfObject1.length;
    int k = i;
    int m = j - k;
    int n = j << 1;
    if (n >= 0)
    {
      Object[] arrayOfObject2 = new Object[n];
      System.arraycopy(arrayOfObject1, k, arrayOfObject2, 0, m);
      System.arraycopy(a, 0, arrayOfObject2, m, i);
      a = arrayOfObject2;
      i = 0;
      b = j;
      c = (n - 1);
      return;
    }
    throw new RuntimeException("Max array capacity exceeded");
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (paramInt <= d())
    {
      int k = a.length;
      int m = i;
      int j = k;
      if (paramInt < k - m) {
        j = m + paramInt;
      }
      k = i;
      while (k < j)
      {
        a[k] = null;
        k += 1;
      }
      k = i;
      m = j - k;
      j = paramInt - m;
      i = (c & k + m);
      if (j > 0)
      {
        paramInt = 0;
        while (paramInt < j)
        {
          a[paramInt] = null;
          paramInt += 1;
        }
        i = j;
      }
    }
    else
    {
      ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
      throw localArrayIndexOutOfBoundsException;
    }
  }
  
  public void a(Object paramObject)
  {
    i = (i - 1 & c);
    Object[] arrayOfObject = a;
    int j = i;
    arrayOfObject[j] = paramObject;
    if (j == b) {
      a();
    }
  }
  
  public Object b()
  {
    int j = i;
    int k = b;
    if (j != k)
    {
      j = c & k - 1;
      Object[] arrayOfObject = a;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      b = j;
      return localObject;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public Object b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < d()))
    {
      Object[] arrayOfObject = a;
      int j = i;
      return arrayOfObject[(c & j + paramInt)];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public Object c()
  {
    int j = i;
    if (j != b)
    {
      Object[] arrayOfObject = a;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      i = (j + 1 & c);
      return localObject;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void clear()
  {
    a(d());
  }
  
  public int d()
  {
    return b - i & c;
  }
  
  public void d(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (paramInt <= d())
    {
      int j = 0;
      int k = b;
      if (paramInt < k) {
        j = k - paramInt;
      }
      k = j;
      int m;
      for (;;)
      {
        m = b;
        if (k >= m) {
          break;
        }
        a[k] = null;
        k += 1;
      }
      j = m - j;
      paramInt -= j;
      b = (m - j);
      if (paramInt > 0)
      {
        b = a.length;
        j = b - paramInt;
        paramInt = j;
        while (paramInt < b)
        {
          a[paramInt] = null;
          paramInt += 1;
        }
        b = j;
      }
    }
    else
    {
      ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
      throw localArrayIndexOutOfBoundsException;
    }
  }
  
  public void e(Object paramObject)
  {
    Object[] arrayOfObject = a;
    int j = b;
    arrayOfObject[j] = paramObject;
    b = (c & j + 1);
    if (b == i) {
      a();
    }
  }
  
  public Object f()
  {
    int j = i;
    int k = b;
    if (j != k) {
      return a[(k - 1 & c)];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public boolean g()
  {
    return i == b;
  }
  
  public Object getItem()
  {
    int j = i;
    if (j != b) {
      return a[j];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
}
