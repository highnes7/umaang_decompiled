package com.google.android.android.internal;

import com.google.android.gms.internal.zzeyh;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzeyi<M extends zzeyh<M>, T>
{
  public int type;
  public final int uuid;
  public final Class<T> zzmlw;
  public com.google.android.gms.internal.zzevh<?, ?> zzoog;
  public final boolean zzotm;
  
  public zzeyi(int paramInt1, Class paramClass, int paramInt2, boolean paramBoolean)
  {
    this(11, paramClass, null, paramInt2, false);
  }
  
  public zzeyi(int paramInt1, Class paramClass, zzevh paramZzevh, int paramInt2, boolean paramBoolean)
  {
    type = paramInt1;
    zzmlw = paramClass;
    uuid = paramInt2;
    zzotm = false;
    zzoog = null;
  }
  
  private final Object readData(zzeye paramZzeye)
  {
    if (zzotm) {
      localObject1 = zzmlw.getComponentType();
    } else {
      localObject1 = zzmlw;
    }
    int i = type;
    if ((i == 10) || (i == 11)) {}
    try
    {
      localObject2 = ((Class)localObject1).newInstance();
      localObject2 = (zzeyn)localObject2;
      paramZzeye.digest((zzeyn)localObject2);
      return localObject2;
    }
    catch (IOException paramZzeye)
    {
      throw new IllegalArgumentException("Error reading extension field", paramZzeye);
    }
    catch (IllegalAccessException paramZzeye)
    {
      localObject1 = String.valueOf(localObject1);
      localObject2 = new StringBuilder(((String)localObject1).length() + 33);
      ((StringBuilder)localObject2).append("Error creating instance of class ");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalArgumentException(((StringBuilder)localObject2).toString(), paramZzeye);
    }
    catch (InstantiationException paramZzeye)
    {
      localObject1 = String.valueOf(localObject1);
      Object localObject2 = new StringBuilder(((String)localObject1).length() + 33);
      ((StringBuilder)localObject2).append("Error creating instance of class ");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalArgumentException(((StringBuilder)localObject2).toString(), paramZzeye);
    }
    i = type;
    paramZzeye = new StringBuilder(24);
    paramZzeye.append("Unknown type ");
    paramZzeye.append(i);
    paramZzeye = new IllegalArgumentException(paramZzeye.toString());
    throw paramZzeye;
    localObject2 = ((Class)localObject1).newInstance();
    localObject2 = (zzeyn)localObject2;
    i = uuid;
    paramZzeye.readFrom((zzeyn)localObject2, i >>> 3);
    return localObject2;
  }
  
  public static zzeyi refresh(int paramInt, Class paramClass, long paramLong)
  {
    return new zzeyi(11, paramClass, (int)paramLong, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzeyi)) {
      return false;
    }
    paramObject = (zzeyi)paramObject;
    return (type == type) && (zzmlw == zzmlw) && (uuid == uuid) && (zzotm == zzotm);
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final void init(Object paramObject, zzeyf paramZzeyf)
  {
    int i = uuid;
    try
    {
      paramZzeyf.zzlc(i);
      i = type;
      if (i != 10)
      {
        if (i == 11)
        {
          paramObject = (zzeyn)paramObject;
          paramZzeyf.operate(paramObject);
          return;
        }
        i = type;
        paramObject = new StringBuilder(24);
        paramObject.append("Unknown type ");
        paramObject.append(i);
        paramObject = new IllegalArgumentException(paramObject.toString());
        throw paramObject;
      }
      i = uuid;
      paramObject = (zzeyn)paramObject;
      paramObject.multiply(paramZzeyf);
      paramZzeyf.next(i >>> 3, 4);
      return;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
  }
  
  public final Object zzbn(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (zzotm)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i = 0;
      while (i < paramList.size())
      {
        byte[] arrayOfByte = getbytes;
        if (arrayOfByte.length != 0) {
          localArrayList.add(readData(zzeye.zzbe(arrayOfByte)));
        }
        i += 1;
      }
      int k = localArrayList.size();
      if (k == 0) {
        return null;
      }
      paramList = zzmlw;
      paramList = paramList.cast(Array.newInstance(paramList.getComponentType(), k));
      i = j;
      while (i < k)
      {
        Array.set(paramList, i, localArrayList.get(i));
        i += 1;
      }
      return paramList;
    }
    if (paramList.isEmpty()) {
      return null;
    }
    paramList = (zzeyp)f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramList, -1);
    return zzmlw.cast(readData(zzeye.zzbe(bytes)));
  }
  
  public final int zzcg(Object paramObject)
  {
    int i = uuid >>> 3;
    int j = type;
    if (j != 10)
    {
      if (j == 11) {
        return zzeyf.addMenuItem(i, (zzeyn)paramObject);
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(24, "Unknown type ", j));
    }
    paramObject = (zzeyn)paramObject;
    i = zzeyf.zzkb(i);
    return paramObject.zzhi() + (i << 1);
  }
}
