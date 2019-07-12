package f.fasterxml.jackson.core.impl;

public final class f
{
  public static final String[] A = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
  public static final String[] B = { "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10" };
  public static final char CHAR_NONE = '\000';
  public static final char[] a;
  public static int h;
  public static int i;
  public static long l;
  public static long n;
  public static final String s = String.valueOf(Long.MIN_VALUE);
  public static long t;
  public static long v;
  public static final char[] x;
  public static final byte[] y;
  
  static
  {
    a = new char['?'];
    x = new char['?'];
    int i7 = 0;
    int i4 = 0;
    int i3 = 0;
    while (i4 < 10)
    {
      int m = (char)(i4 + 48);
      int j;
      if (i4 == 0) {
        j = 0;
      } else {
        j = m;
      }
      int i5 = 0;
      while (i5 < 10)
      {
        int i1 = (char)(i5 + 48);
        int k;
        if ((i4 == 0) && (i5 == 0)) {
          k = 0;
        } else {
          k = i1;
        }
        int i6 = 0;
        while (i6 < 10)
        {
          int i2 = (char)(i6 + 48);
          char[] arrayOfChar = a;
          arrayOfChar[i3] = j;
          int i8 = i3 + 1;
          arrayOfChar[i8] = k;
          int i9 = i3 + 2;
          arrayOfChar[i9] = i2;
          arrayOfChar = x;
          arrayOfChar[i3] = m;
          arrayOfChar[i8] = i1;
          arrayOfChar[i9] = i2;
          i3 += 4;
          i6 += 1;
        }
        i5 += 1;
      }
      i4 += 1;
    }
    y = new byte['?'];
    i3 = i7;
    while (i3 < 4000)
    {
      y[i3] = ((byte)x[i3]);
      i3 += 1;
    }
  }
  
  public f() {}
  
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int k = paramInt1;
    int j = paramInt2;
    if (paramInt1 < 0)
    {
      if (paramInt1 == Integer.MIN_VALUE) {
        return a(paramInt1, paramArrayOfByte, paramInt2);
      }
      paramArrayOfByte[paramInt2] = 45;
      k = -paramInt1;
      j = paramInt2 + 1;
    }
    if (k < h)
    {
      if (k < 1000)
      {
        if (k < 10)
        {
          paramArrayOfByte[j] = ((byte)(k + 48));
          return j + 1;
        }
        return c(k, paramArrayOfByte, j);
      }
      paramInt1 = k / 1000;
      return b(k - paramInt1 * 1000, paramArrayOfByte, c(paramInt1, paramArrayOfByte, j));
    }
    if (k >= i) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      paramInt1 = i;
      k -= paramInt1;
      if (k >= paramInt1)
      {
        k -= paramInt1;
        paramInt1 = j + 1;
        paramArrayOfByte[j] = 50;
      }
      else
      {
        paramInt1 = j + 1;
        paramArrayOfByte[j] = 49;
      }
    }
    else
    {
      paramInt1 = j;
    }
    j = k / 1000;
    int m = j / 1000;
    if (paramInt2 != 0) {
      paramInt1 = b(m, paramArrayOfByte, paramInt1);
    } else {
      paramInt1 = c(m, paramArrayOfByte, paramInt1);
    }
    return b(k - j * 1000, paramArrayOfByte, b(j - m * 1000, paramArrayOfByte, paramInt1));
  }
  
  public static int a(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int k = paramInt1;
    int j = paramInt2;
    if (paramInt1 < 0)
    {
      if (paramInt1 == Integer.MIN_VALUE) {
        return a(paramInt1, paramArrayOfChar, paramInt2);
      }
      paramArrayOfChar[paramInt2] = '-';
      k = -paramInt1;
      j = paramInt2 + 1;
    }
    if (k < h)
    {
      if (k < 1000)
      {
        if (k < 10)
        {
          paramArrayOfChar[j] = ((char)(k + 48));
          return j + 1;
        }
        return b(k, paramArrayOfChar, j);
      }
      paramInt1 = k / 1000;
      return add(k - paramInt1 * 1000, paramArrayOfChar, b(paramInt1, paramArrayOfChar, j));
    }
    if (k >= i) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      paramInt1 = i;
      k -= paramInt1;
      if (k >= paramInt1)
      {
        k -= paramInt1;
        paramInt1 = j + 1;
        paramArrayOfChar[j] = '2';
      }
      else
      {
        paramInt1 = j + 1;
        paramArrayOfChar[j] = '1';
      }
    }
    else
    {
      paramInt1 = j;
    }
    j = k / 1000;
    int m = j / 1000;
    if (paramInt2 != 0) {
      paramInt1 = add(m, paramArrayOfChar, paramInt1);
    } else {
      paramInt1 = b(m, paramArrayOfChar, paramInt1);
    }
    return add(k - j * 1000, paramArrayOfChar, add(j - m * 1000, paramArrayOfChar, paramInt1));
  }
  
  public static int a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int j;
    long l1;
    if (paramLong < 0L)
    {
      if (paramLong > t) {
        return a((int)paramLong, paramArrayOfByte, paramInt);
      }
      if (paramLong == Long.MIN_VALUE)
      {
        k = s.length();
        j = 0;
        while (j < k)
        {
          paramArrayOfByte[paramInt] = ((byte)s.charAt(j));
          j += 1;
          paramInt += 1;
        }
        return paramInt;
      }
      paramArrayOfByte[paramInt] = 45;
      l1 = -paramLong;
      j = paramInt + 1;
    }
    else
    {
      l1 = paramLong;
      j = paramInt;
      if (paramLong <= l) {
        return a((int)paramLong, paramArrayOfByte, paramInt);
      }
    }
    int m = add(l1) + j;
    paramInt = m;
    while (l1 > l)
    {
      paramInt -= 3;
      long l2 = n;
      paramLong = l1 / l2;
      b((int)(l1 - l2 * paramLong), paramArrayOfByte, paramInt);
      l1 = paramLong;
    }
    int i1;
    for (int k = (int)l1; k >= 1000; k = i1)
    {
      paramInt -= 3;
      i1 = k / 1000;
      b(k - i1 * 1000, paramArrayOfByte, paramInt);
    }
    c(k, paramArrayOfByte, j);
    return m;
  }
  
  public static int a(long paramLong, char[] paramArrayOfChar, int paramInt)
  {
    int j;
    long l1;
    if (paramLong < 0L)
    {
      if (paramLong > t) {
        return a((int)paramLong, paramArrayOfChar, paramInt);
      }
      if (paramLong == Long.MIN_VALUE)
      {
        j = s.length();
        s.getChars(0, j, paramArrayOfChar, paramInt);
        return paramInt + j;
      }
      paramArrayOfChar[paramInt] = '-';
      l1 = -paramLong;
      j = paramInt + 1;
    }
    else
    {
      l1 = paramLong;
      j = paramInt;
      if (paramLong <= l) {
        return a((int)paramLong, paramArrayOfChar, paramInt);
      }
    }
    int m = add(l1) + j;
    paramInt = m;
    while (l1 > l)
    {
      paramInt -= 3;
      long l2 = n;
      paramLong = l1 / l2;
      add((int)(l1 - l2 * paramLong), paramArrayOfChar, paramInt);
      l1 = paramLong;
    }
    int i1;
    for (int k = (int)l1; k >= 1000; k = i1)
    {
      paramInt -= 3;
      i1 = k / 1000;
      add(k - i1 * 1000, paramArrayOfChar, paramInt);
    }
    b(k, paramArrayOfChar, j);
    return m;
  }
  
  public static String a(double paramDouble)
  {
    return Double.toString(paramDouble);
  }
  
  public static String a(int paramInt)
  {
    String[] arrayOfString = A;
    if (paramInt < arrayOfString.length)
    {
      if (paramInt >= 0) {
        return arrayOfString[paramInt];
      }
      int j = -paramInt - 1;
      arrayOfString = B;
      if (j < arrayOfString.length) {
        return arrayOfString[j];
      }
    }
    return Integer.toString(paramInt);
  }
  
  public static String a(long paramLong)
  {
    if ((paramLong <= 2147483647L) && (paramLong >= -2147483648L)) {
      return a((int)paramLong);
    }
    return Long.toString(paramLong);
  }
  
  public static int add(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int k = paramInt1 << 2;
    paramInt1 = paramInt2 + 1;
    char[] arrayOfChar = x;
    int j = k + 1;
    paramArrayOfChar[paramInt2] = arrayOfChar[k];
    paramInt2 = paramInt1 + 1;
    paramArrayOfChar[paramInt1] = arrayOfChar[j];
    paramArrayOfChar[paramInt2] = arrayOfChar[(j + 1)];
    return paramInt2 + 1;
  }
  
  public static int add(long paramLong)
  {
    long l1 = v;
    int j = 10;
    while (paramLong >= l1)
    {
      if (j == 19) {
        return j;
      }
      j += 1;
      l1 = (l1 << 1) + (l1 << 3);
    }
    return j;
  }
  
  public static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int k = paramInt1 << 2;
    paramInt1 = paramInt2 + 1;
    byte[] arrayOfByte = y;
    int j = k + 1;
    paramArrayOfByte[paramInt2] = arrayOfByte[k];
    paramInt2 = paramInt1 + 1;
    paramArrayOfByte[paramInt1] = arrayOfByte[j];
    paramArrayOfByte[paramInt2] = arrayOfByte[(j + 1)];
    return paramInt2 + 1;
  }
  
  public static int b(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    paramInt1 <<= 2;
    char[] arrayOfChar = a;
    int k = paramInt1 + 1;
    int j = arrayOfChar[paramInt1];
    paramInt1 = paramInt2;
    if (j != 0)
    {
      paramArrayOfChar[paramInt2] = j;
      paramInt1 = paramInt2 + 1;
    }
    j = a[k];
    paramInt2 = paramInt1;
    if (j != 0)
    {
      paramArrayOfChar[paramInt1] = j;
      paramInt2 = paramInt1 + 1;
    }
    paramArrayOfChar[paramInt2] = a[(k + 1)];
    return paramInt2 + 1;
  }
  
  public static int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramInt1 <<= 2;
    char[] arrayOfChar = a;
    int j = paramInt1 + 1;
    int k = arrayOfChar[paramInt1];
    paramInt1 = paramInt2;
    if (k != 0)
    {
      paramArrayOfByte[paramInt2] = ((byte)k);
      paramInt1 = paramInt2 + 1;
    }
    k = a[j];
    paramInt2 = paramInt1;
    if (k != 0)
    {
      paramArrayOfByte[paramInt1] = ((byte)k);
      paramInt2 = paramInt1 + 1;
    }
    paramArrayOfByte[paramInt2] = ((byte)a[(j + 1)]);
    return paramInt2 + 1;
  }
}
