package com.google.android.android.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class zzbcn
{
  public static void a(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public static void a(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {
      return;
    }
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    zzah(paramParcel, paramInt);
  }
  
  public static void addMenuItem(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable == null)
    {
      if (paramBoolean) {
        write(paramParcel, paramInt1, 0);
      }
    }
    else
    {
      paramInt1 = zzag(paramParcel, paramInt1);
      paramParcelable.writeToParcel(paramParcel, paramInt2);
      zzah(paramParcel, paramInt1);
    }
  }
  
  public static void append(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      if (paramBoolean) {
        write(paramParcel, paramInt, 0);
      }
    }
    else
    {
      paramInt = zzag(paramParcel, paramInt);
      paramParcel.writeString(paramString);
      zzah(paramParcel, paramInt);
    }
  }
  
  public static void enqueue(Parcel paramParcel, int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong == null) {
      return;
    }
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeLongArray(paramArrayOfLong);
    zzah(paramParcel, paramInt);
  }
  
  public static void onAction(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public static void readString(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    zzah(paramParcel, paramInt);
  }
  
  public static void readString(Parcel paramParcel, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (paramArrayOfFloat == null) {
      return;
    }
    paramInt = zzag(paramParcel, 7);
    paramParcel.writeFloatArray(paramArrayOfFloat);
    zzah(paramParcel, paramInt);
  }
  
  public static void save(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        write(paramParcel, paramInt, 0);
      }
    }
    else
    {
      int i = zzag(paramParcel, paramInt);
      int j = paramList.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        Parcelable localParcelable = (Parcelable)paramList.get(paramInt);
        if (localParcelable == null) {
          paramParcel.writeInt(0);
        } else {
          write(paramParcel, localParcelable, 0);
        }
        paramInt += 1;
      }
      zzah(paramParcel, i);
    }
  }
  
  public static void set(Parcel paramParcel, int paramInt, float paramFloat)
  {
    write(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void setCustomVar(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    write(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void write(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(paramInt1 | 0xFFFF0000);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt1 | paramInt2 << 16);
  }
  
  public static void write(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    int i = zzag(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(((Integer)paramList.get(paramInt)).intValue());
      paramInt += 1;
    }
    zzah(paramParcel, i);
  }
  
  public static void write(Parcel paramParcel, Parcelable paramParcelable, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramParcelable.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  public static void writeDouble(Parcel paramParcel, int paramInt, double paramDouble)
  {
    write(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void writeHeader(Parcel paramParcel, int paramInt, long paramLong)
  {
    write(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void writeHeader(Parcel paramParcel, int paramInt1, Parcelable[] paramArrayOfParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfParcelable == null) {
      return;
    }
    int i = zzag(paramParcel, paramInt1);
    int j = paramArrayOfParcelable.length;
    paramParcel.writeInt(j);
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      Parcelable localParcelable = paramArrayOfParcelable[paramInt1];
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      } else {
        write(paramParcel, localParcelable, paramInt2);
      }
      paramInt1 += 1;
    }
    zzah(paramParcel, i);
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, byte paramByte)
  {
    write(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    zzah(paramParcel, paramInt);
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder == null) {
      return;
    }
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    zzah(paramParcel, paramInt);
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      if (paramBoolean) {
        write(paramParcel, paramInt, 0);
      }
    }
    else
    {
      paramInt = zzag(paramParcel, paramInt);
      paramParcel.writeByteArray(paramArrayOfByte);
      zzah(paramParcel, paramInt);
    }
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int i = zzag(paramParcel, paramInt);
    int j = paramArrayOfByte.length;
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeByteArray(paramArrayOfByte[paramInt]);
      paramInt += 1;
    }
    zzah(paramParcel, i);
  }
  
  public static int writeValue(Parcel paramParcel)
  {
    return zzag(paramParcel, 20293);
  }
  
  public static void writeValue(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean)
  {
    if (paramParcel2 == null) {
      return;
    }
    paramInt = zzag(paramParcel1, 2);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    zzah(paramParcel1, paramInt);
  }
  
  public static void writeValue(Parcel paramParcel, int paramInt, Double paramDouble, boolean paramBoolean)
  {
    if (paramDouble == null) {
      return;
    }
    write(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble.doubleValue());
  }
  
  public static void writeValue(Parcel paramParcel, int paramInt, Float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == null) {
      return;
    }
    write(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat.floatValue());
  }
  
  public static void writeValue(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if (paramInteger == null) {
      return;
    }
    write(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }
  
  public static void writeValue(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (paramLong == null) {
      return;
    }
    write(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
  }
  
  public static void writeValue(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeList(paramList);
    zzah(paramParcel, paramInt);
  }
  
  public static void writeValue(Parcel paramParcel, int paramInt, short paramShort)
  {
    write(paramParcel, 3, 4);
    paramParcel.writeInt(paramShort);
  }
  
  public static void writeValue(Parcel paramParcel, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeIntArray(paramArrayOfInt);
    zzah(paramParcel, paramInt);
  }
  
  public static void writeValue(Parcel paramParcel, int paramInt, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (paramArrayOfBoolean == null) {
      return;
    }
    paramInt = zzag(paramParcel, paramInt);
    paramParcel.writeBooleanArray(paramArrayOfBoolean);
    zzah(paramParcel, paramInt);
  }
  
  public static int zzag(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(paramInt | 0xFFFF0000);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  public static void zzah(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  public static void zzai(Parcel paramParcel, int paramInt)
  {
    zzah(paramParcel, paramInt);
  }
}
