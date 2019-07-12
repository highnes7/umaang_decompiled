package com.google.android.android.internal;

import com.google.android.gms.internal.zzevi;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class zzevh<MessageType extends com.google.android.gms.internal.zzevh<MessageType, BuilderType>, BuilderType extends zzevi<MessageType, BuilderType>>
  extends com.google.android.gms.internal.zzeuc<MessageType, BuilderType>
{
  public zzexl zzooe = zzexl.zzoqy;
  public int zzoof = -1;
  
  public zzevh() {}
  
  public static zzevh clearNotification(zzevh paramZzevh, zzeut paramZzeut, zzevd paramZzevd)
    throws zzevz
  {
    paramZzevh = (zzevh)paramZzevh.truncate(zzevp.zzoos, null, null);
    int i = zzevp.zzooq;
    try
    {
      paramZzevh.truncate(i, paramZzeut, paramZzevd);
      i = zzevp.zzoor;
      paramZzevh.truncate(i, null, null);
      zzooe.zzbhs();
      return paramZzevh;
    }
    catch (RuntimeException paramZzevh)
    {
      if ((paramZzevh.getCause() instanceof zzevz)) {
        throw ((zzevz)paramZzevh.getCause());
      }
      throw paramZzevh;
    }
  }
  
  public static Object get(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  public static zzevh showList(zzevh paramZzevh, zzeuk paramZzeuk)
    throws zzevz
  {
    paramZzevh = showList(paramZzevh, paramZzeuk, zzevd.zzctu());
    int j = 1;
    int i;
    if (paramZzevh != null)
    {
      if (paramZzevh.truncate(zzevp.zzooo, Boolean.TRUE, null) != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new zzexk(paramZzevh).zzcvo().filter(paramZzevh);
      }
    }
    if (paramZzevh != null)
    {
      if (paramZzevh.truncate(zzevp.zzooo, Boolean.TRUE, null) != null) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0) {
        return paramZzevh;
      }
      throw new zzexk(paramZzevh).zzcvo().filter(paramZzevh);
    }
    return paramZzevh;
  }
  
  /* Error */
  public static zzevh showList(zzevh paramZzevh, zzeuk paramZzeuk, zzevd paramZzevd)
    throws zzevz
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 115	com/google/android/android/internal/zzeuk:zzcsg	()Lcom/google/android/android/internal/zzeut;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokestatic 117	com/google/android/android/internal/zzevh:clearNotification	(Lcom/google/android/android/internal/zzevh;Lcom/google/android/android/internal/zzeut;Lcom/google/android/android/internal/zzevd;)Lcom/google/android/android/internal/zzevh;
    //   11: astore_0
    //   12: aload_1
    //   13: iconst_0
    //   14: invokevirtual 123	com/google/android/android/internal/zzeut:zzjk	(I)V
    //   17: aload_0
    //   18: areturn
    //   19: astore_1
    //   20: aload_1
    //   21: aload_0
    //   22: invokevirtual 109	com/google/android/android/internal/zzevz:filter	(Lcom/google/android/android/internal/zzewl;)Lcom/google/android/android/internal/zzevz;
    //   25: athrow
    //   26: astore_0
    //   27: aload_0
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	paramZzevh	zzevh
    //   0	29	1	paramZzeuk	zzeuk
    //   0	29	2	paramZzevd	zzevd
    // Exception table:
    //   from	to	target	type
    //   12	17	19	com/google/android/android/internal/zzevz
    //   0	12	26	com/google/android/android/internal/zzevz
    //   20	26	26	com/google/android/android/internal/zzevz
  }
  
  public static zzevh showList(zzevh paramZzevh, byte[] paramArrayOfByte)
    throws zzevz
  {
    paramZzevh = showList(paramZzevh, paramArrayOfByte, zzevd.zzctu());
    if (paramZzevh != null)
    {
      int i;
      if (paramZzevh.truncate(zzevp.zzooo, Boolean.TRUE, null) != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return paramZzevh;
      }
      throw new zzexk(paramZzevh).zzcvo().filter(paramZzevh);
    }
    return paramZzevh;
  }
  
  /* Error */
  public static zzevh showList(zzevh paramZzevh, byte[] paramArrayOfByte, zzevd paramZzevd)
    throws zzevz
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: istore_3
    //   3: aload_1
    //   4: iconst_0
    //   5: iload_3
    //   6: iconst_0
    //   7: invokestatic 131	com/google/android/android/internal/zzeut:append	([BIIZ)Lcom/google/android/android/internal/zzeut;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: invokestatic 117	com/google/android/android/internal/zzevh:clearNotification	(Lcom/google/android/android/internal/zzevh;Lcom/google/android/android/internal/zzeut;Lcom/google/android/android/internal/zzevd;)Lcom/google/android/android/internal/zzevh;
    //   17: astore_0
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 123	com/google/android/android/internal/zzeut:zzjk	(I)V
    //   23: aload_0
    //   24: areturn
    //   25: astore_1
    //   26: aload_1
    //   27: aload_0
    //   28: invokevirtual 109	com/google/android/android/internal/zzevz:filter	(Lcom/google/android/android/internal/zzewl;)Lcom/google/android/android/internal/zzevz;
    //   31: athrow
    //   32: astore_0
    //   33: aload_0
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	paramZzevh	zzevh
    //   0	35	1	paramArrayOfByte	byte[]
    //   0	35	2	paramZzevd	zzevd
    //   2	4	3	i	int
    // Exception table:
    //   from	to	target	type
    //   18	23	25	com/google/android/android/internal/zzevz
    //   3	18	32	com/google/android/android/internal/zzevz
    //   26	32	32	com/google/android/android/internal/zzevz
  }
  
  public static zzevx zzctz()
  {
    return zzevt.zzopc;
  }
  
  public static zzevy zzcua()
  {
    return zzewr.zzopr;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!((zzevh)truncate(zzevp.zzoou, null, null)).getClass().isInstance(paramObject)) {
      return false;
    }
    zzevk localZzevk = zzevk.zzooj;
    Object localObject = (zzevh)paramObject;
    int i = zzevp.zzoop;
    try
    {
      truncate(i, localZzevk, localObject);
      paramObject = zzooe;
      localObject = zzooe;
      paramObject = localZzevk.truncate(paramObject, (zzexl)localObject);
      zzooe = paramObject;
      return true;
    }
    catch (zzevl paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    int i = zzomr;
    if (i != 0) {
      return i;
    }
    zzevn localZzevn = new zzevn();
    truncate(zzevp.zzoop, localZzevn, this);
    zzexl localZzexl = zzooe;
    zzooe = localZzevn.truncate(localZzexl, localZzexl);
    zzomr = zzoom;
    return zzomr;
  }
  
  public final boolean isInitialized()
  {
    return truncate(zzevp.zzooo, Boolean.TRUE, null) != null;
  }
  
  public final boolean next(int paramInt, zzeut paramZzeut)
    throws IOException
  {
    if ((paramInt & 0x7) == 4) {
      return false;
    }
    if (zzooe == zzexl.zzoqy) {
      zzooe = new zzexl();
    }
    return zzooe.next(paramInt, paramZzeut);
  }
  
  public String toString()
  {
    return zzewo.safeString(this, super.toString());
  }
  
  public abstract Object truncate(int paramInt, Object paramObject1, Object paramObject2);
  
  public final zzewp zzcty()
  {
    return (zzewp)truncate(zzevp.zzoov, null, null);
  }
}
