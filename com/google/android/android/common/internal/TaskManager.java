package com.google.android.android.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.Language;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.package_9.CommonStatusCodes;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class TaskManager<T extends IInterface>
{
  public static String[] zzftj = { "service_esmobile", "service_googleme" };
  public final Context mContext;
  public final Handler mHandler;
  public final Object mLock = new Object();
  public final Looper zzakg;
  public final PingManager zzfko;
  public int zzfso;
  public long zzfsp;
  public long zzfsq;
  public int zzfsr;
  public long zzfss;
  public zzal zzfst;
  public final zzaf zzfsu;
  public final Object zzfsv = new Object();
  public zzax zzfsw;
  public Track zzfsx;
  public T zzfsy;
  public final ArrayList<zzi<?>> zzfsz = new ArrayList();
  public zzl zzfta;
  public int zzftb = 1;
  public final Point zzftc;
  public final Log zzftd;
  public final int zzfte;
  public final String zzftf;
  public ConnectionResult zzftg = null;
  public boolean zzfth = false;
  public AtomicInteger zzfti = new AtomicInteger(0);
  
  public TaskManager(Context paramContext, Looper paramLooper, int paramInt, Point paramPoint, Log paramLog, String paramString)
  {
    this(paramContext, paramLooper, paramString, localPingManager, paramInt, paramPoint, (Log)paramLog, null);
  }
  
  public TaskManager(Context paramContext, Looper paramLooper, zzaf paramZzaf, PingManager paramPingManager, int paramInt, Point paramPoint, Log paramLog, String paramString)
  {
    zzbp.get(paramContext, "Context must not be null");
    mContext = ((Context)paramContext);
    zzbp.get(paramLooper, "Looper must not be null");
    zzakg = ((Looper)paramLooper);
    zzbp.get(paramZzaf, "Supervisor must not be null");
    zzfsu = ((zzaf)paramZzaf);
    zzbp.get(paramPingManager, "API availability must not be null");
    zzfko = ((PingManager)paramPingManager);
    mHandler = new RegisteredMediaRouteProvider.ReceiveHandler(this, paramLooper);
    zzfte = paramInt;
    zzftc = paramPoint;
    zzftd = paramLog;
    zzftf = paramString;
  }
  
  private final boolean addTask(int paramInt1, int paramInt2, IInterface paramIInterface)
  {
    Object localObject = mLock;
    try
    {
      if (zzftb != paramInt1) {
        return false;
      }
      execute(paramInt2, paramIInterface);
      return true;
    }
    catch (Throwable paramIInterface)
    {
      throw paramIInterface;
    }
  }
  
  private final void execute(int paramInt, IInterface paramIInterface)
  {
    int i;
    if (paramInt == 4) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramIInterface != null) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbh(bool);
    Object localObject1 = mLock;
    try
    {
      zzftb = paramInt;
      zzfsy = paramIInterface;
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt == 4) {
            disconnect(paramIInterface);
          }
        }
        else
        {
          if ((zzfta != null) && (zzfst != null))
          {
            paramIInterface = zzfst.zzakk();
            str1 = zzfst.getPackageName();
            localObject2 = new StringBuilder(String.valueOf(paramIInterface).length() + 70 + String.valueOf(str1).length());
            ((StringBuilder)localObject2).append("Calling connect() while still connected, missing disconnect() for ");
            ((StringBuilder)localObject2).append(paramIInterface);
            ((StringBuilder)localObject2).append(" on ");
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).toString();
            zzfsu.uninstall(zzfst.zzakk(), zzfst.getPackageName(), zzfst.zzakg(), zzfta, zzaje());
            zzfti.incrementAndGet();
          }
          zzfta = new Provider.1(this, zzfti.get());
          zzfst = new zzal(zzajd(), zzhc(), false, 129);
          paramIInterface = zzfsu;
          String str1 = zzfst.zzakk();
          Object localObject2 = zzfst.getPackageName();
          paramInt = zzfst.zzakg();
          Provider.1 local1 = zzfta;
          String str2 = zzaje();
          if (!paramIInterface.open(new zzag(str1, (String)localObject2, paramInt), local1, str2))
          {
            paramIInterface = zzfst.zzakk();
            str1 = zzfst.getPackageName();
            localObject2 = new StringBuilder(String.valueOf(paramIInterface).length() + 34 + String.valueOf(str1).length());
            ((StringBuilder)localObject2).append("unable to connect to service: ");
            ((StringBuilder)localObject2).append(paramIInterface);
            ((StringBuilder)localObject2).append(" on ");
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).toString();
            connect(16, null, zzfti.get());
          }
        }
      }
      else if (zzfta != null)
      {
        zzfsu.uninstall(zzhc(), zzajd(), 129, zzfta, zzaje());
        zzfta = null;
      }
      return;
    }
    catch (Throwable paramIInterface)
    {
      throw paramIInterface;
    }
  }
  
  private final String zzaje()
  {
    String str2 = zzftf;
    String str1 = str2;
    if (str2 == null) {
      str1 = mContext.getClass().getName();
    }
    return str1;
  }
  
  private final boolean zzajg()
  {
    Object localObject = mLock;
    for (;;)
    {
      try
      {
        if (zzftb == 3)
        {
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  private final boolean zzajm()
  {
    if (zzfth) {
      return false;
    }
    if (TextUtils.isEmpty(zzhd())) {
      return false;
    }
    if (TextUtils.isEmpty(null)) {
      return false;
    }
    try
    {
      Class.forName(zzhd());
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private final void zzcd(int paramInt)
  {
    if (zzajg())
    {
      paramInt = 5;
      zzfth = true;
    }
    else
    {
      paramInt = 4;
    }
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(paramInt, zzfti.get(), 16));
  }
  
  public final void connect(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    paramBundle = mHandler;
    paramBundle.sendMessage(paramBundle.obtainMessage(7, paramInt2, -1, new SocketConnector(this, paramInt1, null)));
  }
  
  /* Error */
  public void disconnect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 117	com/google/android/android/common/internal/TaskManager:zzfti	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: invokevirtual 229	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   7: pop
    //   8: aload_0
    //   9: getfield 104	com/google/android/android/common/internal/TaskManager:zzfsz	Ljava/util/ArrayList;
    //   12: astore_3
    //   13: aload_3
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 104	com/google/android/android/common/internal/TaskManager:zzfsz	Ljava/util/ArrayList;
    //   19: invokevirtual 327	java/util/ArrayList:size	()I
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_1
    //   26: iload_2
    //   27: if_icmpge +24 -> 51
    //   30: aload_0
    //   31: getfield 104	com/google/android/android/common/internal/TaskManager:zzfsz	Ljava/util/ArrayList;
    //   34: iload_1
    //   35: invokevirtual 330	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   38: checkcast 332	com/google/android/android/common/internal/Bus
    //   41: invokevirtual 335	com/google/android/android/common/internal/Bus:removeListener	()V
    //   44: iload_1
    //   45: iconst_1
    //   46: iadd
    //   47: istore_1
    //   48: goto -23 -> 25
    //   51: aload_0
    //   52: getfield 104	com/google/android/android/common/internal/TaskManager:zzfsz	Ljava/util/ArrayList;
    //   55: invokevirtual 338	java/util/ArrayList:clear	()V
    //   58: aload_3
    //   59: monitorexit
    //   60: aload_0
    //   61: getfield 99	com/google/android/android/common/internal/TaskManager:zzfsv	Ljava/lang/Object;
    //   64: astore_3
    //   65: aload_3
    //   66: monitorenter
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 275	com/google/android/android/common/internal/TaskManager:zzfsw	Lcom/google/android/android/common/internal/zzax;
    //   72: aload_3
    //   73: monitorexit
    //   74: aload_0
    //   75: iconst_1
    //   76: aconst_null
    //   77: invokespecial 164	com/google/android/android/common/internal/TaskManager:execute	(ILandroid/os/IInterface;)V
    //   80: return
    //   81: astore 4
    //   83: aload_3
    //   84: monitorexit
    //   85: aload 4
    //   87: athrow
    //   88: astore 4
    //   90: aload_3
    //   91: monitorexit
    //   92: goto +3 -> 95
    //   95: aload 4
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	TaskManager
    //   24	24	1	i	int
    //   22	6	2	j	int
    //   12	79	3	localObject	Object
    //   81	5	4	localThrowable1	Throwable
    //   88	8	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   67	74	81	java/lang/Throwable
    //   83	85	81	java/lang/Throwable
    //   15	23	88	java/lang/Throwable
    //   30	44	88	java/lang/Throwable
    //   51	60	88	java/lang/Throwable
    //   90	92	88	java/lang/Throwable
  }
  
  public void disconnect(IInterface paramIInterface)
  {
    zzfsq = System.currentTimeMillis();
  }
  
  public void disconnect(Track paramTrack)
  {
    zzbp.get(paramTrack, "Connection progress callbacks cannot be null.");
    zzfsx = ((Track)paramTrack);
    execute(2, null);
  }
  
  public final void disconnect(Track paramTrack, int paramInt, PendingIntent paramPendingIntent)
  {
    zzbp.get(paramTrack, "Connection progress callbacks cannot be null.");
    zzfsx = ((Track)paramTrack);
    paramTrack = mHandler;
    paramTrack.sendMessage(paramTrack.obtainMessage(3, zzfti.get(), paramInt, paramPendingIntent));
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramFileDescriptor = mLock;
    try
    {
      int i = zzftb;
      paramArrayOfString = zzfsy;
      paramFileDescriptor = zzfsv;
      try
      {
        Object localObject = zzfsw;
        paramPrintWriter.append(paramString).append("mConnectState=");
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  paramFileDescriptor = "UNKNOWN";
                } else {
                  paramFileDescriptor = "DISCONNECTING";
                }
              }
              else {
                paramFileDescriptor = "CONNECTED";
              }
            }
            else {
              paramFileDescriptor = "LOCAL_CONNECTING";
            }
          }
          else {
            paramFileDescriptor = "REMOTE_CONNECTING";
          }
        }
        else {
          paramFileDescriptor = "DISCONNECTED";
        }
        paramPrintWriter.print(paramFileDescriptor);
        paramPrintWriter.append(" mService=");
        if (paramArrayOfString == null) {
          paramPrintWriter.append("null");
        } else {
          paramPrintWriter.append(zzhd()).append("@").append(Integer.toHexString(System.identityHashCode(paramArrayOfString.asBinder())));
        }
        paramPrintWriter.append(" mServiceBroker=");
        if (localObject == null) {
          paramPrintWriter.println("null");
        } else {
          paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((IInterface)localObject).asBinder())));
        }
        paramArrayOfString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        long l;
        StringBuilder localStringBuilder;
        if (zzfsq > 0L)
        {
          paramFileDescriptor = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          l = zzfsq;
          localObject = paramArrayOfString.format(new Date(l));
          localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, 21));
          localStringBuilder.append(l);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject);
          paramFileDescriptor.println(localStringBuilder.toString());
        }
        if (zzfsp > 0L)
        {
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          i = zzfso;
          if (i != 1)
          {
            if (i != 2) {
              paramFileDescriptor = String.valueOf(i);
            } else {
              paramFileDescriptor = "CAUSE_NETWORK_LOST";
            }
          }
          else {
            paramFileDescriptor = "CAUSE_SERVICE_DISCONNECTED";
          }
          paramPrintWriter.append(paramFileDescriptor);
          paramFileDescriptor = paramPrintWriter.append(" lastSuspendedTime=");
          l = zzfsp;
          localObject = paramArrayOfString.format(new Date(l));
          localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, 21));
          localStringBuilder.append(l);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject);
          paramFileDescriptor.println(localStringBuilder.toString());
        }
        if (zzfss > 0L)
        {
          paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(zzfsr));
          paramString = paramPrintWriter.append(" lastFailedTime=");
          l = zzfss;
          paramFileDescriptor = paramArrayOfString.format(new Date(l));
          paramPrintWriter = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramFileDescriptor, 21));
          paramPrintWriter.append(l);
          paramPrintWriter.append(" ");
          paramPrintWriter.append(paramFileDescriptor);
          paramString.println(paramPrintWriter.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public Account getAccount()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public final Looper getLooper()
  {
    return zzakg;
  }
  
  public abstract IInterface handleDataMessage(IBinder paramIBinder);
  
  public final boolean isConnected()
  {
    Object localObject = mLock;
    for (;;)
    {
      try
      {
        if (zzftb == 4)
        {
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public final boolean isConnecting()
  {
    Object localObject = mLock;
    for (;;)
    {
      try
      {
        if (zzftb == 2) {
          break label40;
        }
        if (zzftb != 3) {
          break label35;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      return bool;
      label35:
      boolean bool = false;
      continue;
      label40:
      bool = true;
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzfsr = paramConnectionResult.getErrorCode();
    zzfss = System.currentTimeMillis();
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzfso = paramInt;
    zzfsp = System.currentTimeMillis();
  }
  
  /* Error */
  public final void rename(zzam paramZzam, Set paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 500	com/google/android/android/common/internal/TaskManager:zzzu	()Landroid/os/Bundle;
    //   4: astore 4
    //   6: new 502	com/google/android/android/common/internal/CommandResult
    //   9: dup
    //   10: aload_0
    //   11: getfield 150	com/google/android/android/common/internal/TaskManager:zzfte	I
    //   14: invokespecial 503	com/google/android/android/common/internal/CommandResult:<init>	(I)V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: getfield 127	com/google/android/android/common/internal/TaskManager:mContext	Landroid/content/Context;
    //   23: invokevirtual 504	android/content/Context:getPackageName	()Ljava/lang/String;
    //   26: putfield 507	com/google/android/android/common/internal/CommandResult:zzfue	Ljava/lang/String;
    //   29: aload_3
    //   30: aload 4
    //   32: putfield 511	com/google/android/android/common/internal/CommandResult:zzfuh	Landroid/os/Bundle;
    //   35: aload_2
    //   36: ifnull +25 -> 61
    //   39: aload_3
    //   40: aload_2
    //   41: aload_2
    //   42: invokeinterface 514 1 0
    //   47: anewarray 516	com/google/android/android/common/package_9/Scope
    //   50: invokeinterface 520 2 0
    //   55: checkcast 522	[Lcom/google/android/android/common/package_9/Scope;
    //   58: putfield 525	com/google/android/android/common/internal/CommandResult:zzfug	[Lcom/google/android/android/common/package_9/Scope;
    //   61: aload_0
    //   62: invokevirtual 528	com/google/android/android/common/internal/TaskManager:zzaac	()Z
    //   65: ifeq +54 -> 119
    //   68: aload_0
    //   69: invokevirtual 530	com/google/android/android/common/internal/TaskManager:getAccount	()Landroid/accounts/Account;
    //   72: ifnull +11 -> 83
    //   75: aload_0
    //   76: invokevirtual 530	com/google/android/android/common/internal/TaskManager:getAccount	()Landroid/accounts/Account;
    //   79: astore_2
    //   80: goto +17 -> 97
    //   83: new 532	android/accounts/Account
    //   86: dup
    //   87: ldc_w 534
    //   90: ldc_w 536
    //   93: invokespecial 539	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: astore_2
    //   97: aload_3
    //   98: aload_2
    //   99: putfield 543	com/google/android/android/common/internal/CommandResult:zzfui	Landroid/accounts/Account;
    //   102: aload_1
    //   103: ifnull +31 -> 134
    //   106: aload_3
    //   107: aload_1
    //   108: invokeinterface 391 1 0
    //   113: putfield 547	com/google/android/android/common/internal/CommandResult:zzfuf	Landroid/os/IBinder;
    //   116: goto +18 -> 134
    //   119: aload_0
    //   120: invokevirtual 550	com/google/android/android/common/internal/TaskManager:zzajk	()Z
    //   123: ifeq +11 -> 134
    //   126: aload_3
    //   127: aload_0
    //   128: invokevirtual 530	com/google/android/android/common/internal/TaskManager:getAccount	()Landroid/accounts/Account;
    //   131: putfield 543	com/google/android/android/common/internal/CommandResult:zzfui	Landroid/accounts/Account;
    //   134: aload_3
    //   135: aload_0
    //   136: invokevirtual 554	com/google/android/android/common/internal/TaskManager:zzajh	()[Lcom/google/android/android/common/Language;
    //   139: putfield 558	com/google/android/android/common/internal/CommandResult:zzfuj	[Lcom/google/android/android/common/Language;
    //   142: aload_0
    //   143: getfield 99	com/google/android/android/common/internal/TaskManager:zzfsv	Ljava/lang/Object;
    //   146: astore_1
    //   147: aload_1
    //   148: monitorenter
    //   149: aload_0
    //   150: getfield 275	com/google/android/android/common/internal/TaskManager:zzfsw	Lcom/google/android/android/common/internal/zzax;
    //   153: ifnull +28 -> 181
    //   156: aload_0
    //   157: getfield 275	com/google/android/android/common/internal/TaskManager:zzfsw	Lcom/google/android/android/common/internal/zzax;
    //   160: new 560	com/google/android/android/common/internal/SearchableActivity
    //   163: dup
    //   164: aload_0
    //   165: aload_0
    //   166: getfield 117	com/google/android/android/common/internal/TaskManager:zzfti	Ljava/util/concurrent/atomic/AtomicInteger;
    //   169: invokevirtual 233	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   172: invokespecial 561	com/google/android/android/common/internal/SearchableActivity:<init>	(Lcom/google/android/android/common/internal/TaskManager;I)V
    //   175: aload_3
    //   176: invokeinterface 566 3 0
    //   181: aload_1
    //   182: monitorexit
    //   183: return
    //   184: astore_2
    //   185: aload_1
    //   186: monitorexit
    //   187: aload_2
    //   188: athrow
    //   189: aload_0
    //   190: bipush 8
    //   192: aconst_null
    //   193: aconst_null
    //   194: aload_0
    //   195: getfield 117	com/google/android/android/common/internal/TaskManager:zzfti	Ljava/util/concurrent/atomic/AtomicInteger;
    //   198: invokevirtual 233	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   201: invokevirtual 570	com/google/android/android/common/internal/TaskManager:show	(ILandroid/os/IBinder;Landroid/os/Bundle;I)V
    //   204: return
    //   205: astore_1
    //   206: aload_1
    //   207: athrow
    //   208: aload_0
    //   209: iconst_1
    //   210: invokevirtual 573	com/google/android/android/common/internal/TaskManager:zzcc	(I)V
    //   213: return
    //   214: astore_1
    //   215: goto -26 -> 189
    //   218: astore_1
    //   219: goto -11 -> 208
    //   222: astore_1
    //   223: goto -34 -> 189
    //   226: astore_1
    //   227: goto -38 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	TaskManager
    //   0	230	1	paramZzam	zzam
    //   0	230	2	paramSet	Set
    //   17	159	3	localCommandResult	CommandResult
    //   4	27	4	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   149	181	184	java/lang/Throwable
    //   181	183	184	java/lang/Throwable
    //   185	187	184	java/lang/Throwable
    //   187	189	205	java/lang/SecurityException
    //   142	149	214	java/lang/RuntimeException
    //   187	189	218	android/os/DeadObjectException
    //   187	189	222	android/os/RemoteException
    //   187	189	226	java/lang/RuntimeException
  }
  
  public void show(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(1, paramInt2, -1, new DeviceActivity(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  public boolean zzaac()
  {
    return false;
  }
  
  public boolean zzaal()
  {
    return false;
  }
  
  public Intent zzaam()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  public Bundle zzaeh()
  {
    return null;
  }
  
  public boolean zzaff()
  {
    return true;
  }
  
  public final IBinder zzafg()
  {
    Object localObject = zzfsv;
    try
    {
      if (zzfsw == null) {
        return null;
      }
      IBinder localIBinder = zzfsw.asBinder();
      return localIBinder;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String zzajd()
  {
    return "com.google.android.gms";
  }
  
  public final void zzajf()
  {
    int i = zzfko.isGooglePlayServicesAvailable(mContext);
    if (i != 0)
    {
      execute(1, null);
      disconnect(new CacheRequest(this), i, null);
      return;
    }
    disconnect(new CacheRequest(this));
  }
  
  public Language[] zzajh()
  {
    return new Language[0];
  }
  
  public final void zzaji()
  {
    if (isConnected()) {
      return;
    }
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public final IInterface zzajj()
    throws DeadObjectException
  {
    Object localObject = mLock;
    for (;;)
    {
      try
      {
        if (zzftb != 5)
        {
          zzaji();
          if (zzfsy != null)
          {
            bool = true;
            zzbp.append(bool, "Client is connected but service is null");
            IInterface localIInterface = zzfsy;
            return localIInterface;
          }
        }
        else
        {
          throw new DeadObjectException();
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public boolean zzajk()
  {
    return false;
  }
  
  public Set zzajl()
  {
    return Collections.EMPTY_SET;
  }
  
  public final void zzcc(int paramInt)
  {
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(6, zzfti.get(), paramInt));
  }
  
  public abstract String zzhc();
  
  public abstract String zzhd();
  
  public Bundle zzzu()
  {
    return new Bundle();
  }
}
