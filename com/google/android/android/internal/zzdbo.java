package com.google.android.android.internal;

import com.google.android.android.tagmanager.zzdj;
import com.google.android.android.tagmanager.zzdk;
import com.google.android.android.tagmanager.zzgk;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzdbo
{
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['?'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static Object get(Object[] paramArrayOfObject, int paramInt, String paramString)
    throws zzdbw
  {
    if ((paramInt >= 0) && (paramInt < paramArrayOfObject.length)) {
      return paramArrayOfObject[paramInt];
    }
    paramArrayOfObject = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 45));
    paramArrayOfObject.append("Index out of bounds detected: ");
    paramArrayOfObject.append(paramInt);
    paramArrayOfObject.append(" in ");
    paramArrayOfObject.append(paramString);
    zzmx(paramArrayOfObject.toString());
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public static zzdbs getPreferences(zzbl paramZzbl)
    throws zzdbw
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a26 = a25\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static zzbp multiply(int paramInt, zzbl paramZzbl, zzbp[] paramArrayOfZzbp, Set paramSet)
    throws zzdbw
  {
    zzbp localZzbp;
    int i;
    int k;
    int m;
    int j;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    if (!paramSet.contains(Integer.valueOf(paramInt)))
    {
      localZzbp = (zzbp)get(zzwl, paramInt, "values");
      if (paramArrayOfZzbp[paramInt] != null) {
        return paramArrayOfZzbp[paramInt];
      }
      paramSet.add(Integer.valueOf(paramInt));
      i = type;
      k = 0;
      m = 0;
      j = 0;
      switch (i)
      {
      default: 
        localObject1 = null;
        break;
      case 7: 
        localObject3 = multiply(localZzbp);
        localObject2 = localObject3;
        localObject4 = reducezzxq;
        zzyh = new zzbp[localObject4.length];
        k = localObject4.length;
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (j >= k) {
            break;
          }
          m = localObject4[j];
          zzyh[i] = multiply(m, paramZzbl, paramArrayOfZzbp, paramSet);
          j += 1;
          i += 1;
        }
      case 4: 
        localObject2 = multiply(localZzbp);
        localObject1 = localObject2;
        zzyd = zzgk.toString(multiply(reducezzxr, paramZzbl, paramArrayOfZzbp, paramSet));
        break;
      case 3: 
        localObject3 = multiply(localZzbp);
        localObject2 = localObject3;
        localObject1 = reduce(localZzbp);
        localObject4 = zzxn;
        i = localObject4.length;
        int[] arrayOfInt = zzxo;
        if (i == arrayOfInt.length)
        {
          zzyb = new zzbp[localObject4.length];
          zzyc = new zzbp[localObject4.length];
          m = localObject4.length;
          j = 0;
          i = 0;
          while (j < m)
          {
            int n = localObject4[j];
            zzyb[i] = multiply(n, paramZzbl, paramArrayOfZzbp, paramSet);
            j += 1;
            i += 1;
          }
          localObject4 = zzxo;
          m = localObject4.length;
          i = 0;
          j = k;
          for (;;)
          {
            localObject1 = localObject2;
            if (j >= m) {
              break;
            }
            k = localObject4[j];
            zzyc[i] = multiply(k, paramZzbl, paramArrayOfZzbp, paramSet);
            j += 1;
            i += 1;
          }
        }
        paramInt = localObject4.length;
        i = arrayOfInt.length;
        paramZzbl = new StringBuilder(58);
        paramZzbl.append("Uneven map keys (");
        paramZzbl.append(paramInt);
        paramZzbl.append(") and map values (");
        paramZzbl.append(i);
        paramZzbl.append(")");
        zzmx(paramZzbl.toString());
        throw new NullPointerException("Null throw statement replaced by Soot");
      case 2: 
        localObject2 = reduce(localZzbp);
        localObject1 = multiply(localZzbp);
        localObject2 = zzxm;
        zzya = new zzbp[localObject2.length];
        k = localObject2.length;
        i = 0;
        j = m;
      }
    }
    for (;;)
    {
      if (j < k)
      {
        m = localObject2[j];
        localObject3 = zzya;
      }
      try
      {
        localObject4 = multiply(m, paramZzbl, paramArrayOfZzbp, paramSet);
        localObject3[i] = localObject4;
        j += 1;
        i += 1;
      }
      catch (Throwable paramZzbl)
      {
        label639:
        throw paramZzbl;
      }
    }
    break label639;
    Object localObject1 = localZzbp;
    if (localObject1 != null)
    {
      paramArrayOfZzbp[paramInt] = localObject1;
      paramSet.remove(Integer.valueOf(paramInt));
      return localObject1;
    }
    paramZzbl = String.valueOf(localZzbp);
    paramArrayOfZzbp = new StringBuilder(paramZzbl.length() + 15);
    paramArrayOfZzbp.append("Invalid value: ");
    paramArrayOfZzbp.append(paramZzbl);
    zzmx(paramArrayOfZzbp.toString());
    throw new NullPointerException("Null throw statement replaced by Soot");
    paramZzbl = String.valueOf(paramSet);
    paramArrayOfZzbp = new StringBuilder(paramZzbl.length() + 90);
    paramArrayOfZzbp.append("Value cycle detected.  Current value reference: ");
    paramArrayOfZzbp.append(paramInt);
    paramArrayOfZzbp.append(".  Previous value references: ");
    paramArrayOfZzbp.append(paramZzbl);
    paramArrayOfZzbp.append(".");
    zzmx(paramArrayOfZzbp.toString());
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public static zzbp multiply(zzbp paramZzbp)
  {
    zzbp localZzbp = new zzbp();
    type = type;
    zzyi = ((int[])zzyi.clone());
    boolean bool = zzyj;
    if (bool) {
      zzyj = bool;
    }
    return localZzbp;
  }
  
  public static zzdbu onResult(zzbm paramZzbm, List paramList1, List paramList2, List paramList3, zzbl paramZzbl)
  {
    zzdbv localZzdbv = new zzdbv();
    int[] arrayOfInt = zzxa;
    int k = arrayOfInt.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localZzdbv.delete((zzdbq)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    arrayOfInt = zzxb;
    k = arrayOfInt.length;
    i = 0;
    while (i < k)
    {
      localZzdbv.join((zzdbq)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    paramList3 = zzxc;
    k = paramList3.length;
    i = 0;
    while (i < k)
    {
      localZzdbv.addUrls((zzdbq)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList3 = zzxe;
    k = paramList3.length;
    i = 0;
    int m;
    while (i < k)
    {
      m = paramList3[i];
      localZzdbv.zznl(zzwl[Integer.valueOf(m).intValue()].string);
      i += 1;
    }
    paramList3 = zzxd;
    k = paramList3.length;
    i = 0;
    while (i < k)
    {
      localZzdbv.set((zzdbq)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList1 = zzxf;
    k = paramList1.length;
    i = 0;
    while (i < k)
    {
      m = paramList1[i];
      localZzdbv.zznm(zzwl[Integer.valueOf(m).intValue()].string);
      i += 1;
    }
    paramList1 = zzxg;
    k = paramList1.length;
    i = 0;
    while (i < k)
    {
      localZzdbv.command((zzdbq)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramList1 = zzxi;
    k = paramList1.length;
    i = 0;
    while (i < k)
    {
      m = paramList1[i];
      localZzdbv.zznn(zzwl[Integer.valueOf(m).intValue()].string);
      i += 1;
    }
    paramList1 = zzxh;
    k = paramList1.length;
    i = 0;
    while (i < k)
    {
      localZzdbv.exists((zzdbq)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramZzbm = zzxj;
    k = paramZzbm.length;
    i = j;
    while (i < k)
    {
      j = paramZzbm[i];
      localZzdbv.zzno(zzwl[Integer.valueOf(j).intValue()].string);
      i += 1;
    }
    return localZzdbv.zzbic();
  }
  
  public static zzbf.zza reduce(zzbp paramZzbp)
    throws zzdbw
  {
    if ((zzbf.zza)paramZzbp.addTo(zzbf.zza.zzxk) != null) {
      return (zzbf.zza)paramZzbp.addTo(zzbf.zza.zzxk);
    }
    paramZzbp = String.valueOf(paramZzbp);
    StringBuilder localStringBuilder = new StringBuilder(paramZzbp.length() + 54);
    localStringBuilder.append("Expected a ServingValue and didn't get one. Value is: ");
    localStringBuilder.append(paramZzbp);
    zzmx(localStringBuilder.toString());
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public static zzdbq replace(zzbh paramZzbh, zzbl paramZzbl, zzbp[] paramArrayOfZzbp, int paramInt)
    throws zzdbw
  {
    HashMap localHashMap = new HashMap();
    int[] arrayOfInt = zzvw;
    int i = arrayOfInt.length;
    paramInt = 0;
    paramZzbh = null;
    while (paramInt < i)
    {
      int j = arrayOfInt[paramInt];
      Object localObject = (zzbk)get(zzwm, Integer.valueOf(j).intValue(), "properties");
      String str = (String)get(zzwk, length, "keys");
      localObject = (zzbp)get(paramArrayOfZzbp, value, "values");
      if (zzbe.zzsv.toString().equals(str)) {
        paramZzbh = (zzbh)localObject;
      } else {
        localHashMap.put(str, localObject);
      }
      paramInt += 1;
    }
    return new zzdbq(localHashMap, paramZzbh, null);
  }
  
  public static void zzmx(String paramString)
    throws zzdbw
  {
    zzdj.zzjss.get(paramString);
    throw new zzdbw(paramString);
  }
}
