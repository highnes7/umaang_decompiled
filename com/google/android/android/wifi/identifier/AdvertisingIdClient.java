package com.google.android.android.wifi.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import b.b.a.G;
import com.google.android.android.common.GooglePlayServicesNotAvailableException;
import com.google.android.android.common.GooglePlayServicesRepairableException;
import com.google.android.android.common.HttpRequest;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.stats.Connector;
import com.google.android.android.internal.zzev;
import com.google.android.android.internal.zzew;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@KeepForSdkWithMembers
public class AdvertisingIdClient
{
  public final Context mContext;
  @G
  public HttpRequest zzall;
  @G
  public zzev zzalm;
  public boolean zzaln;
  public Object zzalo = new Object();
  @G
  public zza zzalp;
  public long zzalq;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false);
  }
  
  public AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean)
  {
    zzbp.append(paramContext);
    Context localContext = paramContext;
    if (paramBoolean)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext == null) {
        localContext = paramContext;
      }
    }
    mContext = localContext;
    zzaln = false;
    zzalq = paramLong;
  }
  
  private final boolean add(Info paramInfo, boolean paramBoolean, float paramFloat, long paramLong, String paramString, Throwable paramThrowable)
  {
    if (Math.random() > paramFloat) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    String str2 = "1";
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("app_context", str1);
    if (paramInfo != null)
    {
      if (paramInfo.isLimitAdTrackingEnabled()) {
        str1 = str2;
      } else {
        str1 = "0";
      }
      localHashMap.put("limit_ad_tracking", str1);
    }
    if ((paramInfo != null) && (paramInfo.getId() != null)) {
      localHashMap.put("ad_id_size", Integer.toString(paramInfo.getId().length()));
    }
    if (paramThrowable != null) {
      localHashMap.put("error", paramThrowable.getClass().getName());
    }
    if ((paramString != null) && (!paramString.isEmpty())) {
      localHashMap.put("experiment_id", paramString);
    }
    localHashMap.put("tag", "AdvertisingIdClient");
    localHashMap.put("time_spent", Long.toString(paramLong));
    new SplashScreen.1(this, localHashMap).start();
    return true;
  }
  
  public static zzev execute(Context paramContext, HttpRequest paramHttpRequest)
    throws IOException
  {
    paramContext = TimeUnit.MILLISECONDS;
    try
    {
      paramContext = zzew.execute(paramHttpRequest.getConnection(10000L, paramContext));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
      throw new IOException("Interrupted exception");
    }
    catch (InterruptedException paramContext)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: invokestatic 189	com/google/android/android/common/TransactionInput:getRemoteContext	(Landroid/content/Context;)Landroid/content/Context;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnonnull +6 -> 17
    //   14: goto +17 -> 31
    //   17: aload 9
    //   19: ldc -65
    //   21: iconst_0
    //   22: invokevirtual 195	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   25: astore 9
    //   27: aload 9
    //   29: astore 8
    //   31: aload 8
    //   33: ifnonnull +6 -> 39
    //   36: goto +17 -> 53
    //   39: aload 8
    //   41: ldc -59
    //   43: iconst_0
    //   44: invokeinterface 203 3 0
    //   49: istore_2
    //   50: goto +5 -> 55
    //   53: iconst_0
    //   54: istore_2
    //   55: aload 8
    //   57: ifnonnull +6 -> 63
    //   60: goto +17 -> 77
    //   63: aload 8
    //   65: ldc -51
    //   67: fconst_0
    //   68: invokeinterface 209 3 0
    //   73: fstore_1
    //   74: goto +5 -> 79
    //   77: fconst_0
    //   78: fstore_1
    //   79: aload 8
    //   81: ifnonnull +6 -> 87
    //   84: goto +17 -> 101
    //   87: aload 8
    //   89: ldc -45
    //   91: iconst_0
    //   92: invokeinterface 203 3 0
    //   97: istore_3
    //   98: goto +5 -> 103
    //   101: iconst_0
    //   102: istore_3
    //   103: aload 8
    //   105: ifnonnull +6 -> 111
    //   108: goto +19 -> 127
    //   111: aload 8
    //   113: ldc -43
    //   115: ldc -41
    //   117: invokeinterface 219 3 0
    //   122: astore 8
    //   124: goto +7 -> 131
    //   127: ldc -41
    //   129: astore 8
    //   131: iload_3
    //   132: ifeq +20 -> 152
    //   135: aload_0
    //   136: invokestatic 225	com/google/android/android/wifi/identifier/Element:getChild	(Landroid/content/Context;)Lcom/google/android/android/wifi/identifier/Element;
    //   139: invokevirtual 229	com/google/android/android/wifi/identifier/Element:getInfo	()Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$Info;
    //   142: astore 9
    //   144: aload 9
    //   146: ifnull +6 -> 152
    //   149: aload 9
    //   151: areturn
    //   152: new 2	com/google/android/android/wifi/identifier/AdvertisingIdClient
    //   155: dup
    //   156: aload_0
    //   157: ldc2_w 230
    //   160: iload_2
    //   161: invokespecial 31	com/google/android/android/wifi/identifier/AdvertisingIdClient:<init>	(Landroid/content/Context;JZ)V
    //   164: astore_0
    //   165: invokestatic 237	android/os/SystemClock:elapsedRealtime	()J
    //   168: lstore 4
    //   170: aload_0
    //   171: iconst_0
    //   172: invokespecial 240	com/google/android/android/wifi/identifier/AdvertisingIdClient:start	(Z)V
    //   175: aload_0
    //   176: invokevirtual 241	com/google/android/android/wifi/identifier/AdvertisingIdClient:getInfo	()Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$Info;
    //   179: astore 9
    //   181: invokestatic 237	android/os/SystemClock:elapsedRealtime	()J
    //   184: lstore 6
    //   186: aload_0
    //   187: aload 9
    //   189: iload_2
    //   190: fload_1
    //   191: lload 6
    //   193: lload 4
    //   195: lsub
    //   196: aload 8
    //   198: aconst_null
    //   199: invokespecial 243	com/google/android/android/wifi/identifier/AdvertisingIdClient:add	(Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$Info;ZFJLjava/lang/String;Ljava/lang/Throwable;)Z
    //   202: pop
    //   203: aload_0
    //   204: invokevirtual 246	com/google/android/android/wifi/identifier/AdvertisingIdClient:finish	()V
    //   207: aload 9
    //   209: areturn
    //   210: astore 8
    //   212: goto +23 -> 235
    //   215: astore 9
    //   217: aload_0
    //   218: aconst_null
    //   219: iload_2
    //   220: fload_1
    //   221: ldc2_w 230
    //   224: aload 8
    //   226: aload 9
    //   228: invokespecial 243	com/google/android/android/wifi/identifier/AdvertisingIdClient:add	(Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$Info;ZFJLjava/lang/String;Ljava/lang/Throwable;)Z
    //   231: pop
    //   232: aload 9
    //   234: athrow
    //   235: aload_0
    //   236: invokevirtual 246	com/google/android/android/wifi/identifier/AdvertisingIdClient:finish	()V
    //   239: aload 8
    //   241: athrow
    //   242: astore 9
    //   244: goto -213 -> 31
    //   247: astore 9
    //   249: goto -196 -> 53
    //   252: astore 9
    //   254: goto -177 -> 77
    //   257: astore 9
    //   259: goto -158 -> 101
    //   262: astore 8
    //   264: goto -137 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramContext	Context
    //   73	148	1	f	float
    //   49	171	2	bool1	boolean
    //   97	35	3	bool2	boolean
    //   168	26	4	l1	long
    //   184	8	6	l2	long
    //   1	196	8	localObject1	Object
    //   210	30	8	localThrowable1	Throwable
    //   262	1	8	localThrowable2	Throwable
    //   7	201	9	localObject2	Object
    //   215	18	9	localThrowable3	Throwable
    //   242	1	9	localThrowable4	Throwable
    //   247	1	9	localThrowable5	Throwable
    //   252	1	9	localThrowable6	Throwable
    //   257	1	9	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   217	235	210	java/lang/Throwable
    //   165	186	215	java/lang/Throwable
    //   186	203	215	java/lang/Throwable
    //   3	9	242	java/lang/Throwable
    //   17	27	242	java/lang/Throwable
    //   39	50	247	java/lang/Throwable
    //   63	74	252	java/lang/Throwable
    //   87	98	257	java/lang/Throwable
    //   111	124	262	java/lang/Throwable
  }
  
  public static HttpRequest init(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      int i = PingManager.zzffk.isGooglePlayServicesAvailable(paramContext);
      if ((i != 0) && (i != 2)) {
        throw new IOException("Google Play services not available");
      }
      HttpRequest localHttpRequest = new HttpRequest();
      Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
      localIntent.setPackage("com.google.android.gms");
      try
      {
        boolean bool = Connector.zzaky().start(paramContext, localIntent, localHttpRequest, 1);
        if (bool) {
          return localHttpRequest;
        }
        throw new IOException("Connection failure");
      }
      catch (Throwable paramContext)
      {
        throw new IOException(paramContext);
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    throw new GooglePlayServicesNotAvailableException(9);
  }
  
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  private final void start(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzbp.zzgh("Calling this from your main thread can lead to deadlock");
    try
    {
      if (zzaln) {
        finish();
      }
      zzall = init(mContext);
      zzalm = execute(mContext, zzall);
      zzaln = true;
      if (paramBoolean) {
        zzbh();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  /* Error */
  private final void zzbh()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzalo	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 319	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzalp	Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$zza;
    //   11: ifnull +22 -> 33
    //   14: aload_0
    //   15: getfield 319	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzalp	Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$zza;
    //   18: getfield 323	com/google/android/android/wifi/identifier/AdvertisingIdClient$zza:zzalu	Ljava/util/concurrent/CountDownLatch;
    //   21: invokevirtual 328	java/util/concurrent/CountDownLatch:countDown	()V
    //   24: aload_0
    //   25: getfield 319	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzalp	Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$zza;
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 331	java/lang/Thread:join	()V
    //   33: aload_0
    //   34: getfield 55	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzalq	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifle +19 -> 58
    //   42: aload_0
    //   43: new 8	com/google/android/android/wifi/identifier/AdvertisingIdClient$zza
    //   46: dup
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 55	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzalq	J
    //   52: invokespecial 334	com/google/android/android/wifi/identifier/AdvertisingIdClient$zza:<init>	(Lcom/google/android/android/wifi/identifier/AdvertisingIdClient;J)V
    //   55: putfield 319	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzalp	Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$zza;
    //   58: aload_1
    //   59: monitorexit
    //   60: return
    //   61: astore_2
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: astore_2
    //   67: goto -34 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	AdvertisingIdClient
    //   4	59	1	localObject	Object
    //   28	2	2	localZza	zza
    //   61	4	2	localThrowable	Throwable
    //   66	1	2	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   7	24	61	java/lang/Throwable
    //   29	33	61	java/lang/Throwable
    //   33	58	61	java/lang/Throwable
    //   58	60	61	java/lang/Throwable
    //   62	64	61	java/lang/Throwable
    //   29	33	66	java/lang/InterruptedException
  }
  
  public void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 306	com/google/android/android/common/internal/zzbp:zzgh	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 51	com/google/android/android/wifi/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   12: ifnull +55 -> 67
    //   15: aload_0
    //   16: getfield 310	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzall	Lcom/google/android/android/common/HttpRequest;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +6 -> 27
    //   24: goto +43 -> 67
    //   27: aload_0
    //   28: getfield 53	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzaln	Z
    //   31: ifeq +18 -> 49
    //   34: invokestatic 292	com/google/android/android/common/stats/Connector:zzaky	()Lcom/google/android/android/common/stats/Connector;
    //   37: pop
    //   38: aload_0
    //   39: getfield 51	com/google/android/android/wifi/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   42: aload_0
    //   43: getfield 310	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzall	Lcom/google/android/android/common/HttpRequest;
    //   46: invokevirtual 341	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 53	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzaln	Z
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 314	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzalm	Lcom/google/android/android/internal/zzev;
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 310	com/google/android/android/wifi/identifier/AdvertisingIdClient:zzall	Lcom/google/android/android/common/HttpRequest;
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: goto -27 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	AdvertisingIdClient
    //   19	2	1	localHttpRequest	HttpRequest
    //   70	4	1	localThrowable1	Throwable
    //   75	1	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	20	70	java/lang/Throwable
    //   49	66	70	java/lang/Throwable
    //   67	69	70	java/lang/Throwable
    //   71	73	70	java/lang/Throwable
    //   27	49	75	java/lang/Throwable
  }
  
  public Info getInfo()
    throws IOException
  {
    zzbp.zzgh("Calling this from your main thread can lead to deadlock");
    try
    {
      if (!zzaln)
      {
        Object localObject1 = zzalo;
        try
        {
          if ((zzalp != null) && (zzalp.zzalv)) {
            try
            {
              start(false);
              boolean bool = zzaln;
              if (bool) {
                break label98;
              }
              throw new IOException("AdvertisingIdClient cannot reconnect.");
            }
            catch (Exception localException)
            {
              throw new IOException("AdvertisingIdClient cannot reconnect.", localException);
            }
          }
          throw new IOException("AdvertisingIdClient is not connected.");
        }
        catch (Throwable localThrowable2)
        {
          throw localThrowable2;
        }
      }
      label98:
      zzbp.append(zzall);
      zzbp.append(zzalm);
      localObject2 = zzalm;
    }
    catch (Throwable localThrowable1)
    {
      Object localObject2;
      zzev localZzev;
      label155:
      throw localThrowable1;
    }
    try
    {
      localObject2 = ((zzev)localObject2).getId();
      localZzev = zzalm;
      localObject2 = new Info((String)localObject2, localZzev.getErrorMessage(true));
      zzbh();
      return localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      break label155;
    }
    throw new IOException("Remote exception");
  }
  
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    start(true);
  }
  
  public final class Info
  {
    public final boolean zzalx;
    
    public Info(boolean paramBoolean)
    {
      zzalx = paramBoolean;
    }
    
    public final String getId()
    {
      return AdvertisingIdClient.this;
    }
    
    public final boolean isLimitAdTrackingEnabled()
    {
      return zzalx;
    }
    
    public final String toString()
    {
      String str = AdvertisingIdClient.this;
      boolean bool = zzalx;
      StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 7));
      localStringBuilder.append("{");
      localStringBuilder.append(str);
      localStringBuilder.append("}");
      localStringBuilder.append(bool);
      return localStringBuilder.toString();
    }
  }
  
  public final class zza
    extends Thread
  {
    public WeakReference<com.google.android.gms.ads.identifier.AdvertisingIdClient> zzals;
    public long zzalt;
    public CountDownLatch zzalu;
    public boolean zzalv;
    
    public zza(long paramLong)
    {
      zzals = new WeakReference(this$1);
      zzalt = paramLong;
      zzalu = new CountDownLatch(1);
      zzalv = false;
      start();
    }
    
    private final void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)zzals.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        zzalv = true;
      }
    }
    
    public final void run()
    {
      CountDownLatch localCountDownLatch = zzalu;
      long l = zzalt;
      TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
      try
      {
        boolean bool = localCountDownLatch.await(l, localTimeUnit);
        if (bool) {
          return;
        }
        disconnect();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
      disconnect();
      return;
    }
  }
}
