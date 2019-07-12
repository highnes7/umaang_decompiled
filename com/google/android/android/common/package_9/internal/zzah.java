package com.google.android.android.common.package_9.internal;

import com.google.android.android.tasks.Task;
import com.google.android.gms.common.api.internal.zzs;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzah
{
  public final Map<zzs<?>, Boolean> zzfla = Collections.synchronizedMap(new WeakHashMap());
  public final Map<com.google.android.gms.tasks.TaskCompletionSource<?>, Boolean> zzflb = Collections.synchronizedMap(new WeakHashMap());
  
  public zzah() {}
  
  /* Error */
  private final void forEach(boolean paramBoolean, com.google.android.android.common.package_9.Status paramStatus)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/google/android/android/common/package_9/internal/zzah:zzfla	Ljava/util/Map;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: new 35	java/util/HashMap
    //   10: dup
    //   11: aload_0
    //   12: getfield 24	com/google/android/android/common/package_9/internal/zzah:zzfla	Ljava/util/Map;
    //   15: invokespecial 38	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   18: astore 4
    //   20: aload_3
    //   21: monitorexit
    //   22: aload_0
    //   23: getfield 26	com/google/android/android/common/package_9/internal/zzah:zzflb	Ljava/util/Map;
    //   26: astore 5
    //   28: aload 5
    //   30: monitorenter
    //   31: new 35	java/util/HashMap
    //   34: dup
    //   35: aload_0
    //   36: getfield 26	com/google/android/android/common/package_9/internal/zzah:zzflb	Ljava/util/Map;
    //   39: invokespecial 38	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   42: astore_3
    //   43: aload 5
    //   45: monitorexit
    //   46: aload 4
    //   48: invokeinterface 44 1 0
    //   53: invokeinterface 50 1 0
    //   58: astore 4
    //   60: aload 4
    //   62: invokeinterface 56 1 0
    //   67: ifeq +52 -> 119
    //   70: aload 4
    //   72: invokeinterface 60 1 0
    //   77: checkcast 62	java/util/Map$Entry
    //   80: astore 5
    //   82: iload_1
    //   83: ifne +19 -> 102
    //   86: aload 5
    //   88: invokeinterface 65 1 0
    //   93: checkcast 67	java/lang/Boolean
    //   96: invokevirtual 70	java/lang/Boolean:booleanValue	()Z
    //   99: ifeq -39 -> 60
    //   102: aload 5
    //   104: invokeinterface 73 1 0
    //   109: checkcast 75	com/google/android/android/common/package_9/internal/Log
    //   112: aload_2
    //   113: invokevirtual 78	com/google/android/android/common/package_9/internal/Log:next	(Lcom/google/android/android/common/package_9/Status;)V
    //   116: goto -56 -> 60
    //   119: aload_3
    //   120: invokeinterface 44 1 0
    //   125: invokeinterface 50 1 0
    //   130: astore_3
    //   131: aload_3
    //   132: invokeinterface 56 1 0
    //   137: ifeq +59 -> 196
    //   140: aload_3
    //   141: invokeinterface 60 1 0
    //   146: checkcast 62	java/util/Map$Entry
    //   149: astore 4
    //   151: iload_1
    //   152: ifne +19 -> 171
    //   155: aload 4
    //   157: invokeinterface 65 1 0
    //   162: checkcast 67	java/lang/Boolean
    //   165: invokevirtual 70	java/lang/Boolean:booleanValue	()Z
    //   168: ifeq -37 -> 131
    //   171: aload 4
    //   173: invokeinterface 73 1 0
    //   178: checkcast 80	com/google/android/android/tasks/TaskCompletionSource
    //   181: new 82	com/google/android/android/common/package_9/ApiException
    //   184: dup
    //   185: aload_2
    //   186: invokespecial 84	com/google/android/android/common/package_9/ApiException:<init>	(Lcom/google/android/android/common/package_9/Status;)V
    //   189: invokevirtual 88	com/google/android/android/tasks/TaskCompletionSource:trySetException	(Ljava/lang/Exception;)Z
    //   192: pop
    //   193: goto -62 -> 131
    //   196: return
    //   197: astore_2
    //   198: aload 5
    //   200: monitorexit
    //   201: aload_2
    //   202: athrow
    //   203: astore_2
    //   204: aload_3
    //   205: monitorexit
    //   206: goto +3 -> 209
    //   209: aload_2
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	zzah
    //   0	211	1	paramBoolean	boolean
    //   0	211	2	paramStatus	com.google.android.android.common.package_9.Status
    //   4	201	3	localObject1	Object
    //   18	154	4	localObject2	Object
    //   26	173	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	46	197	java/lang/Throwable
    //   198	201	197	java/lang/Throwable
    //   7	22	203	java/lang/Throwable
    //   204	206	203	java/lang/Throwable
  }
  
  public final void execute(Log paramLog, boolean paramBoolean)
  {
    zzfla.put(paramLog, Boolean.valueOf(paramBoolean));
    paramLog.set(new zzai(this, paramLog));
  }
  
  public final void setPriority(com.google.android.android.tasks.TaskCompletionSource paramTaskCompletionSource, boolean paramBoolean)
  {
    zzflb.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new zzaj(this, paramTaskCompletionSource));
  }
  
  public final boolean zzags()
  {
    return (!zzfla.isEmpty()) || (!zzflb.isEmpty());
  }
  
  public final void zzagt()
  {
    forEach(false, zzbp.zzfnk);
  }
  
  public final void zzagu()
  {
    forEach(true, zzdj.zzfpq);
  }
}
