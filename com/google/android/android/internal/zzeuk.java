package com.google.android.android.internal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public abstract class zzeuk
  implements Serializable, Iterable<Byte>
{
  public static final zzeuk zzomx;
  public static final zzeuo zzomy;
  public int zzlib = 0;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public zzeuk() {}
  
  public static int add(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 < paramInt1)
        {
          localStringBuilder = new StringBuilder(66);
          localStringBuilder.append("Beginning index larger than ending index: ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramInt2);
          throw new IndexOutOfBoundsException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder(37);
        localStringBuilder.append("End index: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" >= ");
        localStringBuilder.append(paramInt3);
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("Beginning index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    return i;
  }
  
  public static void append(int paramInt1, int paramInt2)
  {
    if ((paramInt2 - (paramInt1 + 1) | paramInt1) < 0)
    {
      if (paramInt1 < 0) {
        throw new ArrayIndexOutOfBoundsException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(22, "Index < 0: ", paramInt1));
      }
      StringBuilder localStringBuilder = new StringBuilder(40);
      localStringBuilder.append("Index > length: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt2);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
  }
  
  public static zzeuk collate(Iterable paramIterable)
  {
    int i = ((Collection)paramIterable).size();
    if (i == 0) {
      return zzomx;
    }
    return toString(paramIterable.iterator(), i);
  }
  
  public static zzeuk putShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzeur(zzomy.copyByteArray(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static zzeuk toString(Iterator paramIterator, int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1) {
        return (zzeuk)paramIterator.next();
      }
      int i = paramInt >>> 1;
      zzeuk localZzeuk = toString(paramIterator, i);
      paramIterator = toString(paramIterator, paramInt - i);
      if (Integer.MAX_VALUE - localZzeuk.size() >= paramIterator.size()) {
        return zzews.append(localZzeuk, paramIterator);
      }
      paramInt = localZzeuk.size();
      i = paramIterator.size();
      paramIterator = new StringBuilder(53);
      paramIterator.append("ByteString would be too long: ");
      paramIterator.append(paramInt);
      paramIterator.append("+");
      paramIterator.append(i);
      throw new IllegalArgumentException(paramIterator.toString());
    }
    throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static zzeuk zzaz(byte[] paramArrayOfByte)
  {
    return putShort(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static zzeuk zzba(byte[] paramArrayOfByte)
  {
    return new zzeur(paramArrayOfByte);
  }
  
  public static zzeup zzjj(int paramInt)
  {
    return new zzeup(paramInt);
  }
  
  public static zzeuk zzti(String paramString)
  {
    return new zzeur(paramString.getBytes(zzevu.UTF_8));
  }
  
  public final void add(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    add(paramInt1, paramInt1 + paramInt3, size());
    add(paramInt2, paramInt2 + paramInt3, paramArrayOfByte.length);
    if (paramInt3 > 0) {
      ensureCapacity(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public abstract void decrypt(zzeuj paramZzeuj)
    throws IOException;
  
  public abstract void ensureCapacity(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hash(int paramInt1, int paramInt2, int paramInt3);
  
  public final int hashCode()
  {
    int i = zzlib;
    if (i == 0)
    {
      i = size();
      int j = hash(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      zzlib = i;
      return i;
    }
    return i;
  }
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract zzeuk multiply(int paramInt1, int paramInt2);
  
  public abstract int size();
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return zzevu.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    ensureCapacity(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public abstract zzeut zzcsg();
  
  public abstract int zzcsh();
  
  public abstract boolean zzcsi();
  
  public final int zzcsj()
  {
    return zzlib;
  }
  
  public abstract byte zzji(int paramInt);
}
