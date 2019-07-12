package support.android.v4.util;

public final class f
{
  public int b;
  public int[] i;
  public int k;
  public int s;
  
  public f()
  {
    this(8);
  }
  
  public f(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (paramInt <= 1073741824)
      {
        int j = paramInt;
        if (Integer.bitCount(paramInt) != 1) {
          j = Integer.highestOneBit(paramInt - 1) << 1;
        }
        k = (j - 1);
        i = new int[j];
        return;
      }
      throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    throw new IllegalArgumentException("capacity must be >= 1");
  }
  
  private void a()
  {
    int[] arrayOfInt1 = i;
    int j = arrayOfInt1.length;
    int m = s;
    int n = j - m;
    int i1 = j << 1;
    if (i1 >= 0)
    {
      int[] arrayOfInt2 = new int[i1];
      System.arraycopy(arrayOfInt1, m, arrayOfInt2, 0, n);
      System.arraycopy(i, 0, arrayOfInt2, n, s);
      i = arrayOfInt2;
      s = 0;
      b = j;
      k = (i1 - 1);
      return;
    }
    throw new RuntimeException("Max array capacity exceeded");
  }
  
  public void a(int paramInt)
  {
    s = (s - 1 & k);
    int[] arrayOfInt = i;
    int j = s;
    arrayOfInt[j] = paramInt;
    if (j == b) {
      a();
    }
  }
  
  public int add()
  {
    int j = s;
    if (j != b) {
      return i[j];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int b()
  {
    return b - s & k;
  }
  
  public void b(int paramInt)
  {
    int[] arrayOfInt = i;
    int j = b;
    arrayOfInt[j] = paramInt;
    b = (k & j + 1);
    if (b == s) {
      a();
    }
  }
  
  public int c()
  {
    int j = s;
    int m = b;
    if (j != m)
    {
      j = k & m - 1;
      m = i[j];
      b = j;
      return m;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b()))
    {
      int[] arrayOfInt = i;
      int j = s;
      return arrayOfInt[(k & j + paramInt)];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void d()
  {
    b = s;
  }
  
  public void d(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (paramInt <= b())
    {
      int j = b;
      b = (k & j - paramInt);
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int f()
  {
    int j = s;
    int m = b;
    if (j != m) {
      return i[(m - 1 & k)];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int g()
  {
    int j = s;
    if (j != b)
    {
      int m = i[j];
      s = (j + 1 & k);
      return m;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void g(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (paramInt <= b())
    {
      int j = s;
      s = (k & j + paramInt);
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public boolean m()
  {
    return s == b;
  }
}
