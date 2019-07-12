package com.google.android.android.tagmanager;

public final class zzgj
  extends Number
  implements Comparable<com.google.android.gms.tagmanager.zzgj>
{
  public double zzjwe;
  public long zzjwf;
  public boolean zzjwg;
  
  public zzgj(double paramDouble)
  {
    zzjwe = paramDouble;
    zzjwg = false;
  }
  
  public zzgj(long paramLong)
  {
    zzjwf = paramLong;
    zzjwg = true;
  }
  
  public static zzgj parseDouble(Double paramDouble)
  {
    return new zzgj(paramDouble.doubleValue());
  }
  
  public static zzgj zzbh(long paramLong)
  {
    return new zzgj(paramLong);
  }
  
  public static zzgj zzme(String paramString)
    throws NumberFormatException
  {
    try
    {
      localZzgj = new zzgj(Long.parseLong(paramString));
      return localZzgj;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      zzgj localZzgj;
      label28:
      for (;;) {}
    }
    try
    {
      localZzgj = new zzgj(Double.parseDouble(paramString));
      return localZzgj;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label28;
    }
    throw new NumberFormatException(String.valueOf(paramString).concat(" is not a valid TypedNumber"));
  }
  
  public final byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public final int compareTo(zzgj paramZzgj)
  {
    if ((zzjwg) && (zzjwg)) {
      return new Long(zzjwf).compareTo(Long.valueOf(zzjwf));
    }
    return Double.compare(doubleValue(), paramZzgj.doubleValue());
  }
  
  public final double doubleValue()
  {
    if (zzjwg) {
      return zzjwf;
    }
    return zzjwe;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof zzgj)) && (compareTo((zzgj)paramObject) == 0);
  }
  
  public final float floatValue()
  {
    return (float)doubleValue();
  }
  
  public final int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public final int intValue()
  {
    return (int)longValue();
  }
  
  public final long longValue()
  {
    if (zzjwg) {
      return zzjwf;
    }
    return zzjwe;
  }
  
  public final short shortValue()
  {
    return (short)(int)longValue();
  }
  
  public final String toString()
  {
    if (zzjwg) {
      return Long.toString(zzjwf);
    }
    return Double.toString(zzjwe);
  }
  
  public final boolean zzbfd()
  {
    return !zzjwg;
  }
  
  public final boolean zzbfe()
  {
    return zzjwg;
  }
}
