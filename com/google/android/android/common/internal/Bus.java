package com.google.android.android.common.internal;

import java.util.ArrayList;

public abstract class Bus<TListener>
{
  public TListener mListener;
  public boolean zzftm;
  
  public Bus(TaskManager paramTaskManager, Object paramObject)
  {
    mListener = paramObject;
    zzftm = false;
  }
  
  public final void removeListener()
  {
    try
    {
      mListener = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public abstract void search(Object paramObject);
  
  public final void unregister()
  {
    removeListener();
    ArrayList localArrayList = TaskManager.remove(zzftl);
    try
    {
      TaskManager.remove(zzftl).remove(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  /* Error */
  public final void zzajo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/google/android/android/common/internal/Bus:mListener	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 23	com/google/android/android/common/internal/Bus:zzftm	Z
    //   11: ifeq +48 -> 59
    //   14: aload_0
    //   15: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: astore_2
    //   19: new 54	java/lang/StringBuilder
    //   22: dup
    //   23: aload_2
    //   24: invokevirtual 58	java/lang/String:length	()I
    //   27: bipush 47
    //   29: iadd
    //   30: invokespecial 61	java/lang/StringBuilder:<init>	(I)V
    //   33: astore_3
    //   34: aload_3
    //   35: ldc 63
    //   37: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: aload_2
    //   43: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: ldc 69
    //   50: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: pop
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: ifnull +14 -> 76
    //   65: aload_0
    //   66: aload_1
    //   67: invokevirtual 75	com/google/android/android/common/internal/Bus:search	(Ljava/lang/Object;)V
    //   70: goto +6 -> 76
    //   73: astore_1
    //   74: aload_1
    //   75: athrow
    //   76: aload_0
    //   77: monitorenter
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 23	com/google/android/android/common/internal/Bus:zzftm	Z
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_0
    //   86: invokevirtual 77	com/google/android/android/common/internal/Bus:unregister	()V
    //   89: return
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	Bus
    //   6	61	1	localObject	Object
    //   73	2	1	localRuntimeException	RuntimeException
    //   90	4	1	localThrowable1	Throwable
    //   95	4	1	localThrowable2	Throwable
    //   18	25	2	str	String
    //   33	22	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   65	70	73	java/lang/RuntimeException
    //   78	85	90	java/lang/Throwable
    //   91	93	90	java/lang/Throwable
    //   2	59	95	java/lang/Throwable
    //   59	61	95	java/lang/Throwable
    //   96	98	95	java/lang/Throwable
  }
}
