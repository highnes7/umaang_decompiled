package com.google.android.android.internal;

import android.content.Context;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

public final class zzcbr
  extends zzcdu
{
  public String mAppId;
  public String zzcye;
  public String zzdmb;
  public String zzdmc;
  public String zzilf;
  public long zzilj;
  public int zzipi;
  public long zzipj;
  public int zzipk;
  
  public zzcbr(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  private final String zzauq()
  {
    zzuj();
    try
    {
      String str = FirebaseInstanceId.d().c();
      return str;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    zzaul().zzayf().append("Failed to retrieve Firebase Instance Id");
    return null;
  }
  
  public final String getAppId()
  {
    zzwk();
    return mAppId;
  }
  
  public final String getGmpAppId()
  {
    zzwk();
    return zzcye;
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final String zzaya()
  {
    byte[] arrayOfByte = new byte[16];
    zzauh().zzazy().nextBytes(arrayOfByte);
    return String.format(Locale.US, "%032x", new Object[] { new BigInteger(1, arrayOfByte) });
  }
  
  public final int zzayb()
  {
    zzwk();
    return zzipi;
  }
  
  public final zzcas zzjb(String paramString)
  {
    zzuj();
    String str1 = getAppId();
    String str2 = getGmpAppId();
    zzwk();
    String str3 = zzdmc;
    long l1 = zzayb();
    zzwk();
    String str4 = zzilf;
    zzcax.zzauv();
    zzwk();
    zzuj();
    if (zzipj == 0L) {
      zzipj = zziki.zzauh().zzah(getContext(), getContext().getPackageName());
    }
    long l2 = zzipj;
    boolean bool1 = zziki.isEnabled();
    boolean bool2 = zzaumzzirh;
    String str5 = zzauq();
    zzwk();
    long l3 = zziki.zzaze();
    zzwk();
    return new zzcas(str1, str2, str3, l1, str4, 11400L, l2, paramString, bool1, bool2 ^ true, str5, 0L, l3, zzipk);
  }
  
  public final void zzuk()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
}
