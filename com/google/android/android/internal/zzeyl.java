package com.google.android.android.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzeyl
{
  public static Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final Object zzott = new Object();
  
  public static void blur(zzeyh paramZzeyh1, zzeyh paramZzeyh2)
  {
    paramZzeyh1 = zzotl;
    if (paramZzeyh1 != null) {
      zzotl = ((zzeyj)paramZzeyh1.clone());
    }
  }
  
  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat1.length != 0)) {
      return Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
    }
    return (paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length == 0);
  }
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt1.length != 0)) {
      return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
    }
    return (paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0);
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0)) {
      return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
    }
    return (paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0);
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    int k;
    if (paramArrayOfObject1 == null) {
      k = 0;
    } else {
      k = paramArrayOfObject1.length;
    }
    int m;
    if (paramArrayOfObject2 == null) {
      m = 0;
    } else {
      m = paramArrayOfObject2.length;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      int n = j;
      if (i < k)
      {
        n = j;
        if (paramArrayOfObject1[i] == null)
        {
          i += 1;
          continue;
        }
      }
      while ((n < m) && (paramArrayOfObject2[n] == null)) {
        n += 1;
      }
      if (i >= k) {
        j = 1;
      } else {
        j = 0;
      }
      int i1;
      if (n >= m) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((j != 0) && (i1 != 0)) {
        return true;
      }
      if (j != i1) {
        return false;
      }
      if (!paramArrayOfObject1[i].equals(paramArrayOfObject2[n])) {
        return false;
      }
      i += 1;
      j = n + 1;
    }
  }
  
  public static boolean equals(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if ((paramArrayOfBoolean1 != null) && (paramArrayOfBoolean1.length != 0)) {
      return Arrays.equals(paramArrayOfBoolean1, paramArrayOfBoolean2);
    }
    return (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean2.length == 0);
  }
  
  public static boolean equals(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    int k;
    if (paramArrayOfByte1 == null) {
      k = 0;
    } else {
      k = paramArrayOfByte1.length;
    }
    int m;
    if (paramArrayOfByte2 == null) {
      m = 0;
    } else {
      m = paramArrayOfByte2.length;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      int n = j;
      if (i < k)
      {
        n = j;
        if (paramArrayOfByte1[i] == null)
        {
          i += 1;
          continue;
        }
      }
      while ((n < m) && (paramArrayOfByte2[n] == null)) {
        n += 1;
      }
      if (i >= k) {
        j = 1;
      } else {
        j = 0;
      }
      int i1;
      if (n >= m) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((j != 0) && (i1 != 0)) {
        return true;
      }
      if (j != i1) {
        return false;
      }
      if (!Arrays.equals(paramArrayOfByte1[i], paramArrayOfByte2[n])) {
        return false;
      }
      i += 1;
      j = n + 1;
    }
  }
  
  public static int hashCode(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0)) {
      return Arrays.hashCode(paramArrayOfFloat);
    }
    return 0;
  }
  
  public static int hashCode(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0)) {
      return Arrays.hashCode(paramArrayOfInt);
    }
    return 0;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0)) {
      return Arrays.hashCode(paramArrayOfLong);
    }
    return 0;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    int j = 0;
    int i;
    if (paramArrayOfObject == null) {
      i = 0;
    } else {
      i = paramArrayOfObject.length;
    }
    int m;
    for (int k = 0; j < i; k = m)
    {
      Object localObject = paramArrayOfObject[j];
      m = k;
      if (localObject != null) {
        m = localObject.hashCode() + k * 31;
      }
      j += 1;
    }
    return k;
  }
  
  public static int hashCode(boolean[] paramArrayOfBoolean)
  {
    if ((paramArrayOfBoolean != null) && (paramArrayOfBoolean.length != 0)) {
      return Arrays.hashCode(paramArrayOfBoolean);
    }
    return 0;
  }
  
  public static int hashCode(byte[][] paramArrayOfByte)
  {
    int j = 0;
    int i;
    if (paramArrayOfByte == null) {
      i = 0;
    } else {
      i = paramArrayOfByte.length;
    }
    int m;
    for (int k = 0; j < i; k = m)
    {
      byte[] arrayOfByte = paramArrayOfByte[j];
      m = k;
      if (arrayOfByte != null) {
        m = Arrays.hashCode(arrayOfByte) + k * 31;
      }
      j += 1;
    }
    return k;
  }
}
