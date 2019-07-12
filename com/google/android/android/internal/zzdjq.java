package com.google.android.android.internal;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public final class zzdjq
{
  public static zzdjr zzlhx;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a3 = a2\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static void connectionLost(Throwable paramThrowable)
  {
    zzlhx.printStackTrace(paramThrowable);
  }
  
  public static void printStackTrace(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    zzlhx.printStackTrace(paramThrowable, paramPrintStream);
  }
  
  public static void printStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    zzlhx.printStackTrace(paramThrowable, paramPrintWriter);
  }
  
  public static Integer zzbnu()
  {
    try
    {
      Object localObject = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      return (Integer)localObject;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
    }
    return null;
  }
  
  public final class zza
    extends zzdjr
  {
    public zza() {}
    
    public final void printStackTrace(Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
    
    public final void printStackTrace(Throwable paramThrowable, PrintStream paramPrintStream)
    {
      paramThrowable.printStackTrace(paramPrintStream);
    }
    
    public final void printStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter)
    {
      paramThrowable.printStackTrace(paramPrintWriter);
    }
  }
}
