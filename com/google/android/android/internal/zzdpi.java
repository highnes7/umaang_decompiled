package com.google.android.android.internal;

import com.google.android.gms.internal.zzdpf;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzdpi<A, B, C>
{
  public final Map<B, C> values;
  public final List<A> zzlsw;
  public final com.google.android.gms.internal.zzdov<A, B> zzlsx;
  public zzdpf<A, C> zzlsy;
  public zzdpf<A, C> zzlsz;
  
  public zzdpi(List paramList, Map paramMap, zzdov paramZzdov)
  {
    zzlsw = paramList;
    values = paramMap;
    zzlsx = paramZzdov;
  }
  
  public static zzdpg addChildren(List paramList, Map paramMap, zzdov paramZzdov, Comparator paramComparator)
  {
    paramMap = new zzdpi(paramList, paramMap, paramZzdov);
    Collections.sort(paramList, paramComparator);
    paramZzdov = new zzdpj(paramList.size()).iterator();
    int i = paramList.size();
    while (paramZzdov.hasNext())
    {
      paramList = (zzdpl)paramZzdov.next();
      int j = zzltd;
      i -= j;
      if (zzltc)
      {
        paramMap.moveToNext(zzdpc.zzlsq, j, i);
      }
      else
      {
        paramMap.moveToNext(zzdpc.zzlsq, j, i);
        j = zzltd;
        i -= j;
        paramMap.moveToNext(zzdpc.zzlsp, j, i);
      }
    }
    paramMap = zzlsy;
    paramList = paramMap;
    if (paramMap == null) {
      paramList = zzdpa.zzlso;
    }
    return new zzdpg(paramList, paramComparator, null);
  }
  
  private final void moveToNext(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private final zzdpb subtract(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return zzdpa.zzlso;
    }
    if (paramInt2 == 1)
    {
      localObject1 = zzlsw.get(paramInt1);
      return new zzdoz(localObject1, zzbi(localObject1), null, null);
    }
    paramInt2 /= 2;
    int i = paramInt1 + paramInt2;
    Object localObject1 = subtract(paramInt1, paramInt2);
    zzdpb localZzdpb = subtract(i + 1, paramInt2);
    Object localObject2 = zzlsw.get(i);
    return new zzdoz(localObject2, zzbi(localObject2), (zzdpb)localObject1, localZzdpb);
  }
  
  private final Object zzbi(Object paramObject)
  {
    return values.get(zzlsx.zzbd(paramObject));
  }
}
