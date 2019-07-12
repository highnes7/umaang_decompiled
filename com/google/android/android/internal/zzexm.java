package com.google.android.android.internal;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class zzexm
{
  public static final Logger logger;
  public static final Unsafe zzlal;
  public static final boolean zzonr;
  public static final Class<?> zzorb;
  public static final boolean zzorc;
  public static final boolean zzord;
  public static final boolean zzore;
  public static final zzd zzorf;
  public static final boolean zzorg;
  public static final long zzorh;
  public static final long zzori;
  public static final long zzorj;
  public static final long zzork;
  public static final long zzorl;
  public static final long zzorm;
  public static final long zzorn;
  public static final long zzoro;
  public static final long zzorp;
  public static final long zzorq;
  public static final long zzorr;
  public static final long zzors;
  public static final long zzort;
  public static final long zzoru;
  public static final boolean zzorv;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a8 = a7\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public zzexm() {}
  
  public static void add(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = getField(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    setInt(paramObject, l, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  public static byte get(Object paramObject, long paramLong)
  {
    return (byte)(getField(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  public static boolean get(Class paramClass)
  {
    if (!zzcvw()) {
      return false;
    }
    try
    {
      Class localClass = zzorb;
      localClass.getMethod("peekLong", new Class[] { paramClass, Boolean.TYPE });
      localClass.getMethod("pokeLong", new Class[] { paramClass, Long.TYPE, Boolean.TYPE });
      localClass.getMethod("pokeInt", new Class[] { paramClass, Integer.TYPE, Boolean.TYPE });
      localClass.getMethod("peekInt", new Class[] { paramClass, Boolean.TYPE });
      localClass.getMethod("pokeByte", new Class[] { paramClass, Byte.TYPE });
      localClass.getMethod("peekByte", new Class[] { paramClass });
      localClass.getMethod("pokeByteArray", new Class[] { paramClass, [B.class, Integer.TYPE, Integer.TYPE });
      localClass.getMethod("peekByteArray", new Class[] { paramClass, [B.class, Integer.TYPE, Integer.TYPE });
      return true;
    }
    catch (Throwable paramClass) {}
    return false;
  }
  
  public static int getField(Class paramClass)
  {
    if (zzonr) {
      return zzorfzzorw.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  public static int getField(Object paramObject, long paramLong)
  {
    return zzorfzzorw.getInt(paramObject, paramLong);
  }
  
  public static Field getField(Class paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static byte read(Object paramObject, long paramLong)
  {
    return (byte)(getField(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  public static int read(Class paramClass)
  {
    if (zzonr) {
      return zzorfzzorw.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  public static byte readByte(byte[] paramArrayOfByte, long paramLong)
  {
    return zzorf.readByte(paramArrayOfByte, zzorh + paramLong);
  }
  
  public static void setBytes(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    zzorf.setBytes(paramArrayOfByte, zzorh + paramLong, paramByte);
  }
  
  public static void setInt(Object paramObject, long paramLong, int paramInt)
  {
    zzorfzzorw.putInt(paramObject, paramLong, paramInt);
  }
  
  public static void setValue(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = getField(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    setInt(paramObject, l, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  public static boolean zzcvr()
  {
    return zzonr;
  }
  
  public static boolean zzcvs()
  {
    return zzorg;
  }
  
  public static Unsafe zzcvt()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new zzexn());
      return localUnsafe;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static boolean zzcvu()
  {
    Object localObject = zzlal;
    if (localObject == null) {
      return false;
    }
    try
    {
      localObject = localObject.getClass();
      ((Class)localObject).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject).getMethod("arrayBaseOffset", new Class[] { Class.class });
      ((Class)localObject).getMethod("arrayIndexScale", new Class[] { Class.class });
      ((Class)localObject).getMethod("getInt", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putInt", new Class[] { Object.class, Long.TYPE, Integer.TYPE });
      ((Class)localObject).getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putLong", new Class[] { Object.class, Long.TYPE, Long.TYPE });
      ((Class)localObject).getMethod("getObject", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putObject", new Class[] { Object.class, Long.TYPE, Object.class });
      boolean bool = zzcvw();
      if (bool) {
        return true;
      }
      ((Class)localObject).getMethod("getByte", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putByte", new Class[] { Object.class, Long.TYPE, Byte.TYPE });
      ((Class)localObject).getMethod("getBoolean", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE });
      ((Class)localObject).getMethod("getFloat", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putFloat", new Class[] { Object.class, Long.TYPE, Float.TYPE });
      ((Class)localObject).getMethod("getDouble", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putDouble", new Class[] { Object.class, Long.TYPE, Double.TYPE });
      return true;
    }
    catch (Throwable localThrowable)
    {
      localObject = logger;
      Level localLevel = Level.WARNING;
      String str = String.valueOf(localThrowable);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject).logp(localLevel, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean zzcvv()
  {
    Object localObject = zzlal;
    if (localObject == null) {
      return false;
    }
    try
    {
      localObject = localObject.getClass();
      ((Class)localObject).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject).getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      boolean bool = zzcvw();
      if (bool) {
        return true;
      }
      ((Class)localObject).getMethod("getByte", new Class[] { Long.TYPE });
      ((Class)localObject).getMethod("putByte", new Class[] { Long.TYPE, Byte.TYPE });
      ((Class)localObject).getMethod("getInt", new Class[] { Long.TYPE });
      ((Class)localObject).getMethod("putInt", new Class[] { Long.TYPE, Integer.TYPE });
      ((Class)localObject).getMethod("getLong", new Class[] { Long.TYPE });
      ((Class)localObject).getMethod("putLong", new Class[] { Long.TYPE, Long.TYPE });
      ((Class)localObject).getMethod("copyMemory", new Class[] { Long.TYPE, Long.TYPE, Long.TYPE });
      ((Class)localObject).getMethod("copyMemory", new Class[] { Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE });
      return true;
    }
    catch (Throwable localThrowable)
    {
      localObject = logger;
      Level localLevel = Level.WARNING;
      String str = String.valueOf(localThrowable);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject).logp(localLevel, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean zzcvw()
  {
    return (zzorb != null) && (!zzorc);
  }
  
  public static Class zztn(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final class zza
    extends zzexm.zzd
  {
    public zza()
    {
      super();
    }
    
    public final byte readByte(Object paramObject, long paramLong)
    {
      if (zzexm.zzorv) {
        return zzexm.read(paramObject, paramLong);
      }
      return zzexm.get(paramObject, paramLong);
    }
    
    public final void setBytes(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzexm.zzorv)
      {
        zzexm.setValue(paramObject, paramLong, paramByte);
        return;
      }
      zzexm.add(paramObject, paramLong, paramByte);
    }
  }
  
  public final class zzb
    extends zzexm.zzd
  {
    public zzb()
    {
      super();
    }
    
    public final byte readByte(Object paramObject, long paramLong)
    {
      if (zzexm.zzorv) {
        return zzexm.read(paramObject, paramLong);
      }
      return zzexm.get(paramObject, paramLong);
    }
    
    public final void setBytes(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzexm.zzorv)
      {
        zzexm.setValue(paramObject, paramLong, paramByte);
        return;
      }
      zzexm.add(paramObject, paramLong, paramByte);
    }
  }
  
  public final class zzc
    extends zzexm.zzd
  {
    public zzc()
    {
      super();
    }
    
    public final byte readByte(Object paramObject, long paramLong)
    {
      return zzorw.getByte(paramObject, paramLong);
    }
    
    public final void setBytes(Object paramObject, long paramLong, byte paramByte)
    {
      zzorw.putByte(paramObject, paramLong, paramByte);
    }
  }
  
  public abstract class zzd
  {
    public zzd() {}
    
    public abstract byte readByte(Object paramObject, long paramLong);
    
    public abstract void setBytes(Object paramObject, long paramLong, byte paramByte);
  }
}
