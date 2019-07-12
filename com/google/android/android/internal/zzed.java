package com.google.android.android.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;

public class zzed
{
  public static final ClassLoader zzajz = com.google.android.gms.internal.zzed.class.getClassLoader();
  
  public zzed() {}
  
  public static void append(Parcel paramParcel, Parcelable paramParcelable)
  {
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
  }
  
  public static void append(Parcel paramParcel, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public static Parcelable get(Parcel paramParcel, Parcelable.Creator paramCreator)
  {
    if (paramParcel.readInt() == 0) {
      return null;
    }
    return (Parcelable)paramCreator.createFromParcel(paramParcel);
  }
  
  public static void get(Parcel paramParcel, IInterface paramIInterface)
  {
    if (paramIInterface == null) {}
    for (paramIInterface = null;; paramIInterface = paramIInterface.asBinder())
    {
      paramParcel.writeStrongBinder(paramIInterface);
      return;
    }
  }
  
  public static ArrayList readDate(Parcel paramParcel)
  {
    return paramParcel.readArrayList(zzajz);
  }
  
  public static boolean readString(Parcel paramParcel)
  {
    return paramParcel.readInt() == 1;
  }
  
  public static HashMap requestMap(Parcel paramParcel)
  {
    return paramParcel.readHashMap(zzajz);
  }
  
  public static void writeValue(Parcel paramParcel, Parcelable paramParcelable)
  {
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 1);
  }
}
