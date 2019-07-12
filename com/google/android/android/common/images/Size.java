package com.google.android.android.common.images;

public final class Size
{
  public final int zzakq;
  public final int zzakr;
  
  public Size(int paramInt1, int paramInt2)
  {
    zzakq = paramInt1;
    zzakr = paramInt2;
  }
  
  public static Size parseSize(String paramString)
    throws NumberFormatException
  {
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.indexOf('*');
      i = j;
      if (j < 0) {
        i = paramString.indexOf('x');
      }
      if (i < 0) {}
    }
    try
    {
      j = Integer.parseInt(paramString.substring(0, i));
      Size localSize = new Size(j, Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    zzfx(paramString);
    throw new NullPointerException("Null throw statement replaced by Soot");
    zzfx(paramString);
    throw new NullPointerException("Null throw statement replaced by Soot");
    throw new IllegalArgumentException("string must not be null");
  }
  
  public static NumberFormatException zzfx(String paramString)
  {
    throw new NumberFormatException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 16), "Invalid Size: \"", paramString, "\""));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof Size))
    {
      paramObject = (Size)paramObject;
      if ((zzakq == zzakq) && (zzakr == zzakr)) {
        return true;
      }
    }
    return false;
  }
  
  public final int getHeight()
  {
    return zzakr;
  }
  
  public final int getWidth()
  {
    return zzakq;
  }
  
  public final int hashCode()
  {
    int i = zzakr;
    int j = zzakq;
    return i ^ (j >>> 16 | j << 16);
  }
  
  public final String toString()
  {
    int i = zzakq;
    int j = zzakr;
    StringBuilder localStringBuilder = new StringBuilder(23);
    localStringBuilder.append(i);
    localStringBuilder.append("x");
    localStringBuilder.append(j);
    return localStringBuilder.toString();
  }
}
