package f.g.c.package_10;

import f.g.c.a.b;

@b
public final class d
  extends h
{
  public static final int PREFIX_6_BITS = 63;
  public static final int v = 128;
  public final char[] a;
  public final boolean b;
  public final boolean e;
  public final long f;
  
  public d(char[] paramArrayOfChar, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    super(paramString);
    a = paramArrayOfChar;
    f = paramLong;
    e = paramBoolean1;
    b = paramBoolean2;
  }
  
  public static h a(char[] paramArrayOfChar, String paramString)
  {
    int j = paramArrayOfChar.length;
    boolean bool1;
    if (paramArrayOfChar[0] == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int k = paramArrayOfChar.length;
    long l = 0L;
    int i = 0;
    while (i < k)
    {
      l |= 1L << paramArrayOfChar[i];
      i += 1;
    }
    Object localObject = null;
    i = j;
    while (i < 128)
    {
      char[] arrayOfChar = a(i, paramArrayOfChar, false);
      localObject = arrayOfChar;
      if (arrayOfChar != null) {
        break;
      }
      i += 1;
    }
    boolean bool2;
    if (localObject == null)
    {
      bool2 = true;
      localObject = a(128, paramArrayOfChar, true);
    }
    else
    {
      bool2 = false;
    }
    return new d((char[])localObject, l, bool1, bool2, paramString);
  }
  
  private boolean a(int paramInt)
  {
    return 1L == (f >> paramInt & 1L);
  }
  
  public static char[] a(int paramInt, char[] paramArrayOfChar, boolean paramBoolean)
  {
    char[] arrayOfChar = new char[paramInt];
    int k = 0;
    while (k < paramArrayOfChar.length)
    {
      int i = paramArrayOfChar[k];
      int m = i % paramInt;
      int j = m;
      if (m < 0) {
        j = m + paramInt;
      }
      if ((arrayOfChar[j] != 0) && (!paramBoolean)) {
        return null;
      }
      m = j;
      if (paramBoolean) {
        for (;;)
        {
          m = j;
          if (arrayOfChar[j] == 0) {
            break;
          }
          j = (j + 1) % paramInt;
        }
      }
      arrayOfChar[m] = i;
      k += 1;
    }
    return arrayOfChar;
  }
  
  public h a()
  {
    return this;
  }
  
  public boolean a(char paramChar)
  {
    if (paramChar == 0) {
      return e;
    }
    if (!a(paramChar)) {
      return false;
    }
    char[] arrayOfChar = a;
    int j = paramChar % arrayOfChar.length;
    int i = j;
    if (j < 0) {}
    for (i = j + arrayOfChar.length;; i = (i + 1) % arrayOfChar.length)
    {
      arrayOfChar = a;
      if (arrayOfChar[i] == 0) {
        return false;
      }
      if (arrayOfChar[i] == paramChar) {
        return true;
      }
      if (!b) {
        break;
      }
    }
    return false;
  }
}
