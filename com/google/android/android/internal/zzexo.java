package com.google.android.android.internal;

public final class zzexo
{
  public static final zzexp zzorx;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65) && (paramInt3 <= -65)) {
      return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    paramInt2 -= paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return a(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
        }
        throw new AssertionError();
      }
      return zzag(i, paramArrayOfByte[paramInt1]);
    }
    return zzky(i);
  }
  
  public static int decode(CharSequence paramCharSequence)
  {
    int n = paramCharSequence.length();
    int m = 0;
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '?')) {
      j += 1;
    }
    int i = n;
    for (;;)
    {
      k = i;
      if (j >= n) {
        break label208;
      }
      k = paramCharSequence.charAt(j);
      if (k >= 2048) {
        break;
      }
      i += (127 - k >>> 31);
      j += 1;
    }
    int i2 = paramCharSequence.length();
    int k = m;
    while (j < i2)
    {
      int i3 = paramCharSequence.charAt(j);
      if (i3 < 2048)
      {
        k += (127 - i3 >>> 31);
        m = j;
      }
      else
      {
        int i1 = k + 2;
        k = i1;
        m = j;
        if (55296 <= i3)
        {
          k = i1;
          m = j;
          if (i3 <= 57343) {
            if (Character.codePointAt(paramCharSequence, j) >= 65536)
            {
              m = j + 1;
              k = i1;
            }
            else
            {
              throw new zzexr(j, i2);
            }
          }
        }
      }
      j = m + 1;
    }
    k = i + k;
    label208:
    if (k >= n) {
      return k;
    }
    long l = k;
    paramCharSequence = new StringBuilder(54);
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(l + 4294967296L);
    paramCharSequence = new IllegalArgumentException(paramCharSequence.toString());
    throw paramCharSequence;
  }
  
  public static int decode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zzorx.decode(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static boolean putInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zzorx.a(0, paramArrayOfByte, paramInt1, paramInt2) == 0;
  }
  
  public static int zzag(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65)) {
      return paramInt1 ^ paramInt2 << 8;
    }
    return -1;
  }
  
  public static int zzky(int paramInt)
  {
    if (paramInt > -12) {
      return -1;
    }
    return paramInt;
  }
}
