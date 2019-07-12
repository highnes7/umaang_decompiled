package f.g.c.package_10;

import f.g.c.a.b;

@b
public final class o
  extends h
{
  public static final int EXPONENT_BIAS = 1023;
  public static final double MIN = 0.5D;
  public final char[] a;
  public final long b;
  public final boolean c;
  
  public o(char[] paramArrayOfChar, long paramLong, boolean paramBoolean, String paramString)
  {
    super(paramString);
    a = paramArrayOfChar;
    b = paramLong;
    c = paramBoolean;
  }
  
  public static h a(char[] paramArrayOfChar, String paramString)
  {
    int m = paramArrayOfChar.length;
    int k = 0;
    boolean bool;
    if (paramArrayOfChar[0] == 0) {
      bool = true;
    } else {
      bool = false;
    }
    int n = paramArrayOfChar.length;
    long l = 0L;
    int j = 0;
    while (j < n)
    {
      l |= 1L << paramArrayOfChar[j];
      j += 1;
    }
    char[] arrayOfChar = new char[chooseTableSize(m)];
    m = arrayOfChar.length - 1;
    n = paramArrayOfChar.length;
    j = k;
    if (j < n)
    {
      int i = paramArrayOfChar[j];
      for (k = i & m;; k = k + 1 & m) {
        if (arrayOfChar[k] == 0)
        {
          arrayOfChar[k] = i;
          j += 1;
          break;
        }
      }
    }
    return new o(arrayOfChar, l, bool, paramString);
  }
  
  private boolean a(int paramInt)
  {
    return 1L == (b >> paramInt & 1L);
  }
  
  public static int chooseTableSize(int paramInt)
  {
    if (paramInt == 1) {
      return 2;
    }
    int i = Integer.highestOneBit(paramInt - 1) << 1;
    for (;;)
    {
      double d = i;
      Double.isNaN(d);
      if (d * 0.5D >= paramInt) {
        break;
      }
      i <<= 1;
    }
    return i;
  }
  
  public h a()
  {
    return this;
  }
  
  public boolean a(char paramChar)
  {
    if (paramChar == 0) {
      return c;
    }
    if (!a(paramChar)) {
      return false;
    }
    char c1 = a.length - 1;
    int j = paramChar & c1;
    int i = j;
    int k;
    do
    {
      char[] arrayOfChar = a;
      if (arrayOfChar[i] == 0) {
        return false;
      }
      if (arrayOfChar[i] == paramChar) {
        return true;
      }
      k = i + 1 & c1;
      i = k;
    } while (k != j);
    return false;
  }
}
