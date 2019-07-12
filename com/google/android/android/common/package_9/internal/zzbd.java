package com.google.android.android.common.package_9.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.package_7.FragmentActivity;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.zzae;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.GoogleApiClient.Builder;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.internal.zzbcr;
import com.google.android.android.internal.zzbct;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.api.internal.zzw;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzbd
  extends GoogleApiClient
  implements zzce
{
  public final Context mContext;
  public final Looper zzakg;
  public final int zzfhj;
  public final GoogleApiAvailability zzfhl;
  public com.google.android.gms.common.api.Api.zza<? extends zzcps, zzcpt> zzfhm;
  public boolean zzfhp;
  public final Lock zzfke;
  public AccountInformation zzfkj;
  public Map<Api<?>, Boolean> zzfkm;
  public final Queue<zzm<?, ?>> zzfks = new LinkedList();
  public final com.google.android.android.common.internal.zzad zzfmg;
  public zzcd zzfmh = null;
  public volatile boolean zzfmi;
  public long zzfmj = 120000L;
  public long zzfmk = 5000L;
  public final zzbi zzfml;
  public zzby zzfmm;
  public final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zze> zzfmn;
  public Set<Scope> zzfmo = new HashSet();
  public final zzcn zzfmp = new zzcn();
  public final ArrayList<zzw> zzfmq;
  public Integer zzfmr = null;
  public Set<com.google.android.gms.common.api.internal.zzdg> zzfms = null;
  public final zzdj zzfmt;
  public final zzae zzfmu = new zzbe(this);
  
  public zzbd(Context paramContext, Lock paramLock, Looper paramLooper, AccountInformation paramAccountInformation, GoogleApiAvailability paramGoogleApiAvailability, com.google.android.android.common.package_9.Api.zza paramZza, Map paramMap1, List paramList1, List paramList2, Map paramMap2, int paramInt1, int paramInt2, ArrayList paramArrayList, boolean paramBoolean)
  {
    mContext = paramContext;
    zzfke = paramLock;
    zzfhp = false;
    zzfmg = new com.google.android.android.common.internal.zzad(paramLooper, zzfmu);
    zzakg = paramLooper;
    zzfml = new zzbi(this, paramLooper);
    zzfhl = paramGoogleApiAvailability;
    zzfhj = paramInt1;
    if (zzfhj >= 0) {
      zzfmr = Integer.valueOf(paramInt2);
    }
    zzfkm = paramMap1;
    zzfmn = paramMap2;
    zzfmq = paramArrayList;
    zzfmt = new zzdj(zzfmn);
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      zzfmg.registerConnectionCallbacks(paramLock);
    }
    paramContext = paramList2.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)paramContext.next();
      zzfmg.registerConnectionFailedListener(paramLock);
    }
    zzfkj = paramAccountInformation;
    zzfhm = paramZza;
  }
  
  private final void printStackTrace(GoogleApiClient paramGoogleApiClient, zzda paramZzda, boolean paramBoolean)
  {
    zzbcr.zzfwh.readError(paramGoogleApiClient).setResultCallback(new zzbh(this, paramZzda, paramBoolean, paramGoogleApiClient));
  }
  
  private final void resume()
  {
    zzfke.lock();
    try
    {
      boolean bool = zzfmi;
      if (bool) {
        zzahg();
      }
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public static int transform(Iterable paramIterable, boolean paramBoolean)
  {
    paramIterable = paramIterable.iterator();
    int j = 0;
    int i = 0;
    while (paramIterable.hasNext())
    {
      com.google.android.android.common.package_9.Api.zze localZze = (com.google.android.android.common.package_9.Api.zze)paramIterable.next();
      int k = j;
      if (localZze.zzaac()) {
        k = 1;
      }
      j = k;
      if (localZze.zzaal())
      {
        i = 1;
        j = k;
      }
    }
    if (j != 0)
    {
      if (i != 0)
      {
        if (paramBoolean) {
          return 2;
        }
      }
      else {
        return 1;
      }
    }
    else {
      return 3;
    }
    return 1;
  }
  
  private final void zzahg()
  {
    zzfmg.zzakf();
    zzfmh.connect();
  }
  
  private final void zzahh()
  {
    zzfke.lock();
    try
    {
      boolean bool = zzahi();
      if (bool) {
        zzahg();
      }
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  private final void zzbt(int paramInt)
  {
    Object localObject1 = zzfmr;
    if (localObject1 == null) {
      zzfmr = Integer.valueOf(paramInt);
    } else {
      if (((Integer)localObject1).intValue() != paramInt) {
        break label382;
      }
    }
    if (zzfmh != null) {
      return;
    }
    localObject1 = zzfmn.values().iterator();
    int i = 0;
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.google.android.android.common.package_9.Api.zze)((Iterator)localObject1).next();
      j = i;
      if (((com.google.android.android.common.package_9.Api.zze)localObject2).zzaac()) {
        j = 1;
      }
      i = j;
      if (((com.google.android.android.common.package_9.Api.zze)localObject2).zzaal())
      {
        paramInt = 1;
        i = j;
      }
    }
    int j = zzfmr.intValue();
    if (j != 1)
    {
      if ((j == 2) && (i != 0))
      {
        if (zzfhp)
        {
          zzfmh = new zzad(mContext, zzfke, zzakg, zzfhl, zzfmn, zzfkj, zzfkm, zzfhm, zzfmq, this, true);
          return;
        }
        zzfmh = TaskManager.evaluate(mContext, this, zzfke, zzakg, zzfhl, zzfmn, zzfkj, zzfkm, zzfhm, zzfmq);
      }
    }
    else
    {
      if (i == 0) {
        break label371;
      }
      if (paramInt != 0) {
        break label360;
      }
    }
    if ((zzfhp) && (paramInt == 0))
    {
      zzfmh = new zzad(mContext, zzfke, zzakg, zzfhl, zzfmn, zzfkj, zzfkm, zzfhm, zzfmq, this, false);
      return;
    }
    zzfmh = new zzbl(mContext, this, zzfke, zzakg, zzfhl, zzfmn, zzfkj, zzfkm, zzfhm, zzfmq, this);
    return;
    label360:
    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
    label371:
    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
    label382:
    localObject1 = zzbu(paramInt);
    Object localObject2 = zzbu(zzfmr.intValue());
    paramInt = ((String)localObject1).length();
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject2).length() + (paramInt + 51));
    localStringBuilder.append("Cannot use sign-in mode: ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(". Mode was already set to ");
    localStringBuilder.append((String)localObject2);
    localObject1 = new IllegalStateException(localStringBuilder.toString());
    throw ((Throwable)localObject1);
  }
  
  public static String zzbu(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "UNKNOWN";
        }
        return "SIGN_IN_MODE_NONE";
      }
      return "SIGN_IN_MODE_OPTIONAL";
    }
    return "SIGN_IN_MODE_REQUIRED";
  }
  
  public final ConnectionResult blockingConnect()
  {
    Object localObject = Looper.myLooper();
    Looper localLooper = Looper.getMainLooper();
    boolean bool2 = true;
    boolean bool1;
    if (localObject != localLooper) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzbp.append(bool1, "blockingConnect must not be called on the UI thread");
    zzfke.lock();
    try
    {
      int i = zzfhj;
      if (i >= 0)
      {
        localObject = zzfmr;
        if (localObject != null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        zzbp.append(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      else
      {
        localObject = zzfmr;
        if (localObject == null)
        {
          zzfmr = Integer.valueOf(transform(zzfmn.values(), false));
        }
        else
        {
          i = zzfmr.intValue();
          if (i == 2) {
            break label167;
          }
        }
      }
      zzbt(zzfmr.intValue());
      zzfmg.zzakf();
      localObject = zzfmh.blockingConnect();
      zzfke.unlock();
      return localObject;
      label167:
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.append(bool, "blockingConnect must not be called on the UI thread");
    zzbp.get(paramTimeUnit, "TimeUnit must not be null");
    zzfke.lock();
    try
    {
      Integer localInteger = zzfmr;
      if (localInteger == null)
      {
        zzfmr = Integer.valueOf(transform(zzfmn.values(), false));
      }
      else
      {
        int i = zzfmr.intValue();
        if (i == 2) {
          break label133;
        }
      }
      zzbt(zzfmr.intValue());
      zzfmg.zzakf();
      paramTimeUnit = zzfmh.blockingConnect(paramLong, paramTimeUnit);
      zzfke.unlock();
      return paramTimeUnit;
      label133:
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    catch (Throwable paramTimeUnit)
    {
      zzfke.unlock();
      throw paramTimeUnit;
    }
  }
  
  public final PendingResult clearDefaultAccountAndReconnect()
  {
    zzbp.append(isConnected(), "GoogleApiClient is not connected yet.");
    boolean bool;
    if (zzfmr.intValue() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.append(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
    zzda localZzda = new zzda(this);
    if (zzfmn.containsKey(zzbcr.zzdwp))
    {
      printStackTrace(this, localZzda, false);
      return localZzda;
    }
    AtomicReference localAtomicReference = new AtomicReference();
    Object localObject = new zzbf(this, localAtomicReference, localZzda);
    zzbg localZzbg = new zzbg(this, localZzda);
    localObject = new GoogleApiClient.Builder(mContext).addApi(zzbcr.IOERR).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject).addOnConnectionFailedListener(localZzbg).setHandler(zzfml).build();
    localAtomicReference.set(localObject);
    ((GoogleApiClient)localObject).connect();
    return localZzda;
  }
  
  public final void connect()
  {
    zzfke.lock();
    try
    {
      int i = zzfhj;
      boolean bool = false;
      Integer localInteger;
      if (i >= 0)
      {
        localInteger = zzfmr;
        if (localInteger != null) {
          bool = true;
        }
        zzbp.append(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      else
      {
        localInteger = zzfmr;
        if (localInteger == null)
        {
          zzfmr = Integer.valueOf(transform(zzfmn.values(), false));
        }
        else
        {
          i = zzfmr.intValue();
          if (i == 2) {
            break label107;
          }
        }
      }
      connect(zzfmr.intValue());
      zzfke.unlock();
      return;
      label107:
      throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final void connect(int paramInt)
  {
    zzfke.lock();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramInt != 1) {
        if (paramInt == 2) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(33);
      localStringBuilder.append("Illegal sign-in mode: ");
      localStringBuilder.append(paramInt);
      zzbp.get(bool1, localStringBuilder.toString());
      zzbt(paramInt);
      zzahg();
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final Logger d(Logger paramLogger)
  {
    if (paramLogger.zzafe() != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.get(bool, "This task can not be executed (it's probably a Batch or malformed)");
    boolean bool = zzfmn.containsKey(paramLogger.zzafe());
    Object localObject;
    if (paramLogger.zzafj() != null) {
      localObject = paramLogger.zzafj().getName();
    } else {
      localObject = "the API";
    }
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, 65));
    localStringBuilder.append("GoogleApiClient is not configured to use ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" required for this call.");
    zzbp.get(bool, localStringBuilder.toString());
    zzfke.lock();
    try
    {
      localObject = zzfmh;
      if (localObject != null)
      {
        bool = zzfmi;
        if (bool)
        {
          zzfks.add(paramLogger);
          for (;;)
          {
            bool = zzfks.isEmpty();
            localObject = paramLogger;
            if (bool) {
              break;
            }
            localObject = (Logger)zzfks.remove();
            zzfmt.next((Log)localObject);
            ((Logger)localObject).remove(Status.zzfhx);
          }
        }
        localObject = zzfmh.addTask(paramLogger);
        zzfke.unlock();
        return localObject;
      }
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
    catch (Throwable paramLogger)
    {
      zzfke.unlock();
      throw paramLogger;
    }
  }
  
  public final boolean deleteAccount(zzcv paramZzcv)
  {
    zzcd localZzcd = zzfmh;
    return (localZzcd != null) && (localZzcd.addTask(paramZzcv));
  }
  
  /* Error */
  public final void disconnect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 104	com/google/android/android/common/package_9/internal/zzbd:zzfke	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 221 1 0
    //   9: aload_0
    //   10: getfield 145	com/google/android/android/common/package_9/internal/zzbd:zzfmt	Lcom/google/android/android/common/package_9/internal/zzdj;
    //   13: invokevirtual 509	com/google/android/android/common/package_9/internal/zzdj:release	()V
    //   16: aload_0
    //   17: getfield 66	com/google/android/android/common/package_9/internal/zzbd:zzfmh	Lcom/google/android/android/common/package_9/internal/zzcd;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +12 -> 34
    //   25: aload_0
    //   26: getfield 66	com/google/android/android/common/package_9/internal/zzbd:zzfmh	Lcom/google/android/android/common/package_9/internal/zzcd;
    //   29: invokeinterface 511 1 0
    //   34: aload_0
    //   35: getfield 89	com/google/android/android/common/package_9/internal/zzbd:zzfmp	Lcom/google/android/android/common/package_9/internal/zzcn;
    //   38: invokevirtual 512	com/google/android/android/common/package_9/internal/zzcn:release	()V
    //   41: aload_0
    //   42: getfield 71	com/google/android/android/common/package_9/internal/zzbd:zzfks	Ljava/util/Queue;
    //   45: invokeinterface 513 1 0
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 157 1 0
    //   57: istore_1
    //   58: iload_1
    //   59: ifeq +25 -> 84
    //   62: aload_2
    //   63: invokeinterface 161 1 0
    //   68: checkcast 449	com/google/android/android/common/package_9/internal/Logger
    //   71: astore_3
    //   72: aload_3
    //   73: aconst_null
    //   74: invokevirtual 518	com/google/android/android/common/package_9/internal/Log:remove	(Lcom/google/android/android/common/package_9/internal/zzdm;)V
    //   77: aload_3
    //   78: invokevirtual 521	com/google/android/android/common/package_9/internal/Log:cancel	()V
    //   81: goto -30 -> 51
    //   84: aload_0
    //   85: getfield 71	com/google/android/android/common/package_9/internal/zzbd:zzfks	Ljava/util/Queue;
    //   88: invokeinterface 524 1 0
    //   93: aload_0
    //   94: getfield 66	com/google/android/android/common/package_9/internal/zzbd:zzfmh	Lcom/google/android/android/common/package_9/internal/zzcd;
    //   97: astore_2
    //   98: aload_2
    //   99: ifnonnull +13 -> 112
    //   102: aload_0
    //   103: getfield 104	com/google/android/android/common/package_9/internal/zzbd:zzfke	Ljava/util/concurrent/locks/Lock;
    //   106: invokeinterface 229 1 0
    //   111: return
    //   112: aload_0
    //   113: invokevirtual 255	com/google/android/android/common/package_9/internal/zzbd:zzahi	()Z
    //   116: pop
    //   117: aload_0
    //   118: getfield 113	com/google/android/android/common/package_9/internal/zzbd:zzfmg	Lcom/google/android/android/common/internal/zzad;
    //   121: invokevirtual 527	com/google/android/android/common/internal/zzad:zzake	()V
    //   124: goto -22 -> 102
    //   127: astore_2
    //   128: aload_0
    //   129: getfield 104	com/google/android/android/common/package_9/internal/zzbd:zzfke	Ljava/util/concurrent/locks/Lock;
    //   132: invokeinterface 229 1 0
    //   137: goto +3 -> 140
    //   140: aload_2
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	zzbd
    //   57	2	1	bool	boolean
    //   20	79	2	localObject	Object
    //   127	14	2	localThrowable	Throwable
    //   71	7	3	localLogger	Logger
    // Exception table:
    //   from	to	target	type
    //   9	21	127	java/lang/Throwable
    //   25	34	127	java/lang/Throwable
    //   34	51	127	java/lang/Throwable
    //   51	58	127	java/lang/Throwable
    //   62	81	127	java/lang/Throwable
    //   84	98	127	java/lang/Throwable
    //   112	124	127	java/lang/Throwable
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(zzfmi);
    paramPrintWriter.append(" mWorkQueue.size()=").print(zzfks.size());
    Object localObject = zzfmt;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(zzfps.size());
    localObject = zzfmh;
    if (localObject != null) {
      ((zzcd)localObject).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void ensureInitialized(zzdg paramZzdg)
  {
    zzfke.lock();
    try
    {
      Set localSet = zzfms;
      if (localSet == null) {
        zzfms = new HashSet();
      }
      zzfms.add(paramZzdg);
      zzfke.unlock();
      return;
    }
    catch (Throwable paramZzdg)
    {
      zzfke.unlock();
      throw paramZzdg;
    }
  }
  
  public final Logger get(Logger paramLogger)
  {
    if (paramLogger.zzafe() != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.get(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
    boolean bool = zzfmn.containsKey(paramLogger.zzafe());
    Object localObject;
    if (paramLogger.zzafj() != null) {
      localObject = paramLogger.zzafj().getName();
    } else {
      localObject = "the API";
    }
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, 65));
    localStringBuilder.append("GoogleApiClient is not configured to use ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" required for this call.");
    zzbp.get(bool, localStringBuilder.toString());
    zzfke.lock();
    try
    {
      localObject = zzfmh;
      if (localObject == null) {
        zzfks.add(paramLogger);
      } else {
        paramLogger = zzfmh.removeTask(paramLogger);
      }
      zzfke.unlock();
      return paramLogger;
    }
    catch (Throwable paramLogger)
    {
      zzfke.unlock();
      throw paramLogger;
    }
  }
  
  public final com.google.android.android.common.package_9.Api.zze getChange(com.google.android.android.common.package_9.Api.zzc paramZzc)
  {
    paramZzc = (com.google.android.android.common.package_9.Api.zze)zzfmn.get(paramZzc);
    zzbp.get(paramZzc, "Appropriate Api was not requested.");
    return paramZzc;
  }
  
  public final ConnectionResult getConnectionResult(Sample paramSample)
  {
    zzfke.lock();
    try
    {
      boolean bool = isConnected();
      if (!bool)
      {
        bool = zzfmi;
        if (!bool) {
          throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
        }
      }
      bool = zzfmn.containsKey(paramSample.zzafe());
      if (bool)
      {
        ConnectionResult localConnectionResult = zzfmh.getConnectionResult(paramSample);
        if (localConnectionResult == null)
        {
          bool = zzfmi;
          if (bool) {}
          for (paramSample = ConnectionResult.zzfff;; paramSample = new ConnectionResult(8, null))
          {
            zzfke.unlock();
            return paramSample;
            zzahk();
            android.util.Log.wtf("GoogleApiClientImpl", String.valueOf(paramSample.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
          }
        }
        zzfke.unlock();
        return localConnectionResult;
      }
      throw new IllegalArgumentException(String.valueOf(paramSample.getName()).concat(" was never registered with GoogleApiClient"));
    }
    catch (Throwable paramSample)
    {
      zzfke.unlock();
      throw paramSample;
    }
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public final Looper getLooper()
  {
    return zzakg;
  }
  
  public final boolean has(Sample paramSample)
  {
    return zzfmn.containsKey(paramSample.zzafe());
  }
  
  public final boolean hasConnectedApi(Sample paramSample)
  {
    if (!isConnected()) {
      return false;
    }
    paramSample = (com.google.android.android.common.package_9.Api.zze)zzfmn.get(paramSample.zzafe());
    return (paramSample != null) && (paramSample.isConnected());
  }
  
  public final boolean isConnected()
  {
    zzcd localZzcd = zzfmh;
    return (localZzcd != null) && (localZzcd.isConnected());
  }
  
  public final boolean isConnecting()
  {
    zzcd localZzcd = zzfmh;
    return (localZzcd != null) && (localZzcd.isConnecting());
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return zzfmg.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return zzfmg.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public final void reconnect()
  {
    disconnect();
    connect();
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzfmg.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzfmg.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final void removeAccount(zzdg paramZzdg)
  {
    zzfke.lock();
    try
    {
      Object localObject = zzfms;
      if (localObject == null) {
        paramZzdg = "Attempted to remove pending transform when no transforms are registered.";
      }
      for (localObject = new Exception();; localObject = new Exception())
      {
        android.util.Log.wtf("GoogleApiClientImpl", paramZzdg, (Throwable)localObject);
        break label90;
        bool = zzfms.remove(paramZzdg);
        if (bool) {
          break;
        }
        paramZzdg = "Failed to remove pending transform - this may lead to memory leaks!";
      }
      boolean bool = zzahj();
      if (!bool) {
        zzfmh.zzagi();
      }
      label90:
      zzfke.unlock();
      return;
    }
    catch (Throwable paramZzdg)
    {
      zzfke.unlock();
      throw paramZzdg;
    }
  }
  
  public final void removeTask(Bundle paramBundle)
  {
    while (!zzfks.isEmpty()) {
      d((Logger)zzfks.remove());
    }
    zzfmg.connect(paramBundle);
  }
  
  public final void removeTask(ConnectionResult paramConnectionResult)
  {
    if (!PingManager.create(mContext, paramConnectionResult.getErrorCode())) {
      zzahi();
    }
    if (!zzfmi)
    {
      zzfmg.show(paramConnectionResult);
      zzfmg.zzake();
    }
  }
  
  public final zzcj setResolution(Object paramObject)
  {
    zzfke.lock();
    try
    {
      paramObject = zzfmp.setResolution(paramObject, zzakg, "NO_TYPE");
      zzfke.unlock();
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      zzfke.unlock();
      throw paramObject;
    }
  }
  
  public final void setSorting(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean) && (!zzfmi))
    {
      zzfmi = true;
      if (zzfmm == null) {
        zzfmm = GoogleApiAvailability.start(mContext.getApplicationContext(), new zzbj(this));
      }
      zzbi localZzbi = zzfml;
      localZzbi.sendMessageDelayed(localZzbi.obtainMessage(1), zzfmj);
      localZzbi = zzfml;
      localZzbi.sendMessageDelayed(localZzbi.obtainMessage(2), zzfmk);
    }
    zzfmt.zzaiq();
    zzfmg.zzce(paramInt);
    zzfmg.zzake();
    if (paramInt == 2) {
      zzahg();
    }
  }
  
  public final void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = new zzcf(paramFragmentActivity);
    if (zzfhj >= 0)
    {
      ActivityBase.onCreate(paramFragmentActivity).zzbp(zzfhj);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzfmg.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzfmg.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final void zzafp()
  {
    zzcd localZzcd = zzfmh;
    if (localZzcd != null) {
      localZzcd.zzafp();
    }
  }
  
  public final boolean zzahi()
  {
    if (!zzfmi) {
      return false;
    }
    zzfmi = false;
    zzfml.removeMessages(2);
    zzfml.removeMessages(1);
    zzby localZzby = zzfmm;
    if (localZzby != null)
    {
      localZzby.unregister();
      zzfmm = null;
    }
    return true;
  }
  
  public final boolean zzahj()
  {
    zzfke.lock();
    try
    {
      Set localSet = zzfms;
      if (localSet == null)
      {
        zzfke.unlock();
        return false;
      }
      boolean bool = zzfms.isEmpty();
      zzfke.unlock();
      return bool ^ true;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final String zzahk()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
}
