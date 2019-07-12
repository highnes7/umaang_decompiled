package com.google.android.android.internal;

import com.google.android.gms.internal.zzanu;
import java.util.Map;

public final class zzapb
  extends com.google.android.gms.internal.zzamr
  implements zzanu<com.google.android.gms.internal.zzapc>
{
  public final zzapc zzduf = new zzapc();
  
  public zzapb(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  public final void setPrivacyList(String paramString1, String paramString2)
  {
    zzduf.zzdul.put(paramString1, paramString2);
  }
  
  public final void toFile(String paramString, int paramInt)
  {
    if ("ga_sessionTimeout".equals(paramString))
    {
      zzduf.zzduh = paramInt;
      return;
    }
    append("int configuration name not recognized", paramString);
  }
  
  public final void toFile(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final void tryParse(String paramString1, String paramString2)
  {
    if ("ga_trackingId".equals(paramString1))
    {
      zzduf.zzdjo = paramString2;
      return;
    }
    if ("ga_sampleFrequency".equals(paramString1))
    {
      paramString1 = zzduf;
      try
      {
        double d = Double.parseDouble(paramString2);
        zzdug = d;
        return;
      }
      catch (NumberFormatException paramString1)
      {
        append("Error parsing ga_sampleFrequency value", paramString2, paramString1);
        return;
      }
    }
    append("string configuration name not recognized", paramString1);
  }
}
