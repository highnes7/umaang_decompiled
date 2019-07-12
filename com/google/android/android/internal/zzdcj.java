package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.dynamite.DynamiteModule;
import com.google.android.android.dynamite.DynamiteModule.zzc;
import com.google.android.android.dynamite.DynamiteModule.zzd;

public abstract class zzdcj<T>
{
  public final Context mContext;
  public final Object mLock = new Object();
  public final String mTag;
  public boolean zzkjo = false;
  public T zzkjp;
  
  public zzdcj(Context paramContext, String paramString)
  {
    mContext = paramContext;
    mTag = paramString;
  }
  
  public abstract Object getChat(DynamiteModule paramDynamiteModule, Context paramContext)
    throws RemoteException, DynamiteModule.zzc;
  
  public final boolean isOperational()
  {
    return zzbip() != null;
  }
  
  public abstract void zzbim()
    throws RemoteException;
  
  public final void zzbio()
  {
    localObject = mLock;
    for (;;)
    {
      try
      {
        if (zzkjp == null) {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      try
      {
        zzbim();
      }
      catch (RemoteException localRemoteException) {}
    }
  }
  
  public final Object zzbip()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/google/android/android/internal/zzdcj:mLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 47	com/google/android/android/internal/zzdcj:zzkjp	Ljava/lang/Object;
    //   11: ifnull +12 -> 23
    //   14: aload_0
    //   15: getfield 47	com/google/android/android/internal/zzdcj:zzkjp	Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_1
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: aload_0
    //   24: getfield 26	com/google/android/android/internal/zzdcj:mContext	Landroid/content/Context;
    //   27: astore_2
    //   28: getstatic 55	com/google/android/android/dynamite/DynamiteModule:zzgps	Lcom/google/android/android/dynamite/DynamiteModule$zzd;
    //   31: astore_3
    //   32: aload_2
    //   33: aload_3
    //   34: ldc 57
    //   36: invokestatic 61	com/google/android/android/dynamite/DynamiteModule:get	(Landroid/content/Context;Lcom/google/android/android/dynamite/DynamiteModule$zzd;Ljava/lang/String;)Lcom/google/android/android/dynamite/DynamiteModule;
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 26	com/google/android/android/internal/zzdcj:mContext	Landroid/content/Context;
    //   44: astore_3
    //   45: aload_0
    //   46: aload_2
    //   47: aload_3
    //   48: invokevirtual 63	com/google/android/android/internal/zzdcj:getChat	(Lcom/google/android/android/dynamite/DynamiteModule;Landroid/content/Context;)Ljava/lang/Object;
    //   51: astore_2
    //   52: aload_0
    //   53: aload_2
    //   54: putfield 47	com/google/android/android/internal/zzdcj:zzkjp	Ljava/lang/Object;
    //   57: goto +3 -> 60
    //   60: aload_0
    //   61: getfield 24	com/google/android/android/internal/zzdcj:zzkjo	Z
    //   64: ifne +18 -> 82
    //   67: aload_0
    //   68: getfield 47	com/google/android/android/internal/zzdcj:zzkjp	Ljava/lang/Object;
    //   71: ifnonnull +11 -> 82
    //   74: aload_0
    //   75: iconst_1
    //   76: putfield 24	com/google/android/android/internal/zzdcj:zzkjo	Z
    //   79: goto +17 -> 96
    //   82: aload_0
    //   83: getfield 24	com/google/android/android/internal/zzdcj:zzkjo	Z
    //   86: ifeq +10 -> 96
    //   89: aload_0
    //   90: getfield 47	com/google/android/android/internal/zzdcj:zzkjp	Ljava/lang/Object;
    //   93: ifnull +3 -> 96
    //   96: aload_0
    //   97: getfield 47	com/google/android/android/internal/zzdcj:zzkjp	Ljava/lang/Object;
    //   100: astore_2
    //   101: aload_1
    //   102: monitorexit
    //   103: aload_2
    //   104: areturn
    //   105: astore_2
    //   106: aload_1
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: goto -51 -> 60
    //   114: astore_2
    //   115: goto -55 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	zzdcj
    //   4	103	1	localObject1	Object
    //   18	86	2	localObject2	Object
    //   105	4	2	localThrowable	Throwable
    //   110	1	2	localZzc	DynamiteModule.zzc
    //   114	1	2	localRemoteException	RemoteException
    //   31	17	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	105	java/lang/Throwable
    //   23	32	105	java/lang/Throwable
    //   32	40	105	java/lang/Throwable
    //   40	45	105	java/lang/Throwable
    //   45	52	105	java/lang/Throwable
    //   52	57	105	java/lang/Throwable
    //   60	79	105	java/lang/Throwable
    //   82	96	105	java/lang/Throwable
    //   96	103	105	java/lang/Throwable
    //   106	108	105	java/lang/Throwable
    //   32	40	110	com/google/android/android/dynamite/DynamiteModule$zzc
    //   45	52	110	com/google/android/android/dynamite/DynamiteModule$zzc
    //   32	40	114	android/os/RemoteException
    //   45	52	114	android/os/RemoteException
  }
}
