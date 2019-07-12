package com.google.android.android.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class zzbcl
{
  public static byte[][] a(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    byte[][] arrayOfByte = new byte[k][];
    paramInt = 0;
    while (paramInt < k)
    {
      arrayOfByte[paramInt] = paramParcel.createByteArray();
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfByte;
  }
  
  public static void access$1100(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    paramParcel.setDataPosition(paramParcel.dataPosition() + paramInt);
  }
  
  public static Bundle add(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(i + paramInt);
    return localBundle;
  }
  
  public static short b(Parcel paramParcel, int paramInt)
  {
    toString(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static Double create(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    read(paramParcel, paramInt, i, 8);
    return Double.valueOf(paramParcel.readDouble());
  }
  
  public static int decode(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    int k = get(paramParcel, j);
    int i = paramParcel.dataPosition();
    if ((0xFFFF & j) != 20293)
    {
      localObject = String.valueOf(Integer.toHexString(j));
      if (((String)localObject).length() != 0) {
        localObject = "Expected object header. Got 0x".concat((String)localObject);
      } else {
        localObject = new String("Expected object header. Got 0x");
      }
      throw new zzbcm((String)localObject, paramParcel);
    }
    j = k + i;
    if ((j >= i) && (j <= paramParcel.dataSize())) {
      return j;
    }
    Object localObject = new StringBuilder(54);
    ((StringBuilder)localObject).append("Size read is invalid start=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" end=");
    ((StringBuilder)localObject).append(j);
    throw new zzbcm(((StringBuilder)localObject).toString(), paramParcel);
  }
  
  public static boolean[] finish(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfBoolean;
  }
  
  public static int get(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536) {
      return paramInt >> 16 & 0xFFFF;
    }
    return paramParcel.readInt();
  }
  
  public static ArrayList get(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(i + paramInt);
    return paramCreator;
  }
  
  public static int getId(Parcel paramParcel, int paramInt)
  {
    toString(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static Integer getIntProperty(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    read(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }
  
  public static long[] getList(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfLong;
  }
  
  public static float getNumber(Parcel paramParcel, int paramInt)
  {
    toString(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static int[] getParameter(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfInt;
  }
  
  public static long getValue(Parcel paramParcel, int paramInt)
  {
    toString(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static boolean invoke(Parcel paramParcel, int paramInt)
  {
    toString(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }
  
  public static IBinder obtain(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(i + paramInt);
    return localIBinder;
  }
  
  public static Object[] put(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(i + paramInt);
    return paramCreator;
  }
  
  public static BigDecimal read(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(i + paramInt);
    return new BigDecimal(new BigInteger(arrayOfByte), j);
  }
  
  public static void read(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == paramInt3) {
      return;
    }
    String str = Integer.toHexString(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 46));
    localStringBuilder.append("Expected size ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" got ");
    localStringBuilder.append(paramInt2);
    throw new zzbcm(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, " (0x", str, ")"), paramParcel);
  }
  
  public static Boolean readBoolean(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    read(paramParcel, paramInt, i, 4);
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public static Float readFloat(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    read(paramParcel, paramInt, i, 4);
    return Float.valueOf(paramParcel.readFloat());
  }
  
  public static void readFromParcel(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return;
    }
    paramParcel.readList(paramList, paramClassLoader);
    paramParcel.setDataPosition(i + paramInt);
  }
  
  public static BigDecimal[] readFromParcel(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    paramInt = 0;
    while (paramInt < k)
    {
      byte[] arrayOfByte = paramParcel.createByteArray();
      int m = paramParcel.readInt();
      arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(arrayOfByte), m);
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }
  
  public static double readLine(Parcel paramParcel, int paramInt)
  {
    toString(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static String readString(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    String str = paramParcel.readString();
    paramParcel.setDataPosition(i + paramInt);
    return str;
  }
  
  public static Long readValue(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    read(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }
  
  public static BigInteger sign(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + paramInt);
    return new BigInteger(arrayOfByte);
  }
  
  public static void toString(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    paramInt1 = get(paramParcel, paramInt1);
    if (paramInt1 == paramInt2) {
      return;
    }
    String str = Integer.toHexString(paramInt1);
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 46));
    localStringBuilder.append("Expected size ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" got ");
    localStringBuilder.append(paramInt1);
    throw new zzbcm(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, " (0x", str, ")"), paramParcel);
  }
  
  public static Parcelable unmarshall(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(i + paramInt);
    return paramCreator;
  }
  
  public static byte[] valueOf(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfByte;
  }
  
  public static byte writeBool(Parcel paramParcel, int paramInt)
  {
    toString(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static float[] writeValue(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfFloat;
  }
  
  public static String[] zzaa(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfString;
  }
  
  public static ArrayList zzab(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Integer.valueOf(paramParcel.readInt()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static ArrayList zzac(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(i + paramInt);
    return localArrayList;
  }
  
  public static Parcel zzad(Parcel paramParcel, int paramInt)
  {
    paramInt = get(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, i, paramInt);
    paramParcel.setDataPosition(i + paramInt);
    return localParcel;
  }
  
  public static Parcel[] zzae(Parcel paramParcel, int paramInt)
  {
    int i = get(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    Parcel[] arrayOfParcel = new Parcel[k];
    paramInt = 0;
    while (paramInt < k)
    {
      int m = paramParcel.readInt();
      if (m != 0)
      {
        int n = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, m);
        arrayOfParcel[paramInt] = localParcel;
        paramParcel.setDataPosition(n + m);
      }
      else
      {
        arrayOfParcel[paramInt] = null;
      }
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfParcel;
  }
  
  public static void zzaf(Parcel paramParcel, int paramInt)
  {
    if (paramParcel.dataPosition() == paramInt) {
      return;
    }
    throw new zzbcm(f.sufficientlysecure.rootcommands.util.StringBuilder.add(37, "Overread allowed size end=", paramInt), paramParcel);
  }
}
