package com.google.android.android.common.util;

import java.util.ArrayList;
import java.util.Arrays;

public final class EventHandler
{
  public static byte[] encrypt(byte[]... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return new byte[0];
    }
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte1 = Arrays.copyOf(paramVarArgs[0], j);
    j = paramVarArgs[0].length;
    i = 1;
    while (i < paramVarArgs.length)
    {
      byte[] arrayOfByte2 = paramVarArgs[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public static ArrayList execute(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfObject[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static void execute(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"");
      paramStringBuilder.append(paramArrayOfString[i]);
      paramStringBuilder.append("\"");
      i += 1;
    }
  }
  
  public static Integer[] toObject(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int j = paramArrayOfInt.length;
    Integer[] arrayOfInteger = new Integer[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static void toString(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[i]));
      i += 1;
    }
  }
  
  public static void toString(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[i]));
      i += 1;
    }
  }
  
  public static void toString(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[i]));
      i += 1;
    }
  }
  
  public static void toString(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfObject[i].toString());
      i += 1;
    }
  }
  
  public static void write(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[i]));
      i += 1;
    }
  }
}
