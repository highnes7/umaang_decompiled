package com.google.android.android.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.android.common.util.Connection;
import com.google.android.android.internal.zzbec;
import com.google.android.android.internal.zzbed;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransactionInput
{
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 11400000;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean zzffw;
  public static boolean zzffx;
  public static boolean zzffy;
  public static boolean zzffz;
  public static final AtomicBoolean zzfga = new AtomicBoolean();
  public static final AtomicBoolean zzfgb = new AtomicBoolean();
  
  public TransactionInput() {}
  
  public static boolean connect(Context paramContext, int paramInt)
  {
    return Connection.execute(paramContext, paramInt);
  }
  
  public static boolean connect(Context paramContext, int paramInt, String paramString)
  {
    return Connection.connect(paramContext, paramInt, paramString);
  }
  
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return PingManager.zzffk.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.getStatusString(paramInt);
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  /* Error */
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 81	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 95	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   10: getstatic 100	com/google/android/android/R$string:common_google_play_services_unknown_issue	I
    //   13: invokevirtual 105	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   16: pop
    //   17: goto +3 -> 20
    //   20: ldc 8
    //   22: aload_0
    //   23: invokevirtual 109	android/content/Context:getPackageName	()Ljava/lang/String;
    //   26: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifne +107 -> 136
    //   32: getstatic 34	com/google/android/android/common/TransactionInput:zzfgb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   35: invokevirtual 119	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   38: ifne +98 -> 136
    //   41: aload_0
    //   42: invokestatic 125	com/google/android/android/common/internal/zzbe:zzch	(Landroid/content/Context;)V
    //   45: getstatic 128	com/google/android/android/common/internal/zzbe:zzfvp	I
    //   48: istore_1
    //   49: iload_1
    //   50: ifeq +76 -> 126
    //   53: getstatic 130	com/google/android/android/common/TransactionInput:GOOGLE_PLAY_SERVICES_VERSION_CODE	I
    //   56: istore_2
    //   57: iload_1
    //   58: iload_2
    //   59: if_icmpne +6 -> 65
    //   62: goto +74 -> 136
    //   65: new 132	java/lang/StringBuilder
    //   68: dup
    //   69: ldc -122
    //   71: invokevirtual 138	java/lang/String:length	()I
    //   74: sipush 290
    //   77: iadd
    //   78: invokespecial 141	java/lang/StringBuilder:<init>	(I)V
    //   81: astore_0
    //   82: aload_0
    //   83: ldc -113
    //   85: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_0
    //   90: iload_2
    //   91: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_0
    //   96: ldc -104
    //   98: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_0
    //   103: iload_1
    //   104: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: new 154	java/lang/IllegalStateException
    //   111: dup
    //   112: aload_0
    //   113: ldc -100
    //   115: ldc -122
    //   117: ldc -98
    //   119: invokestatic 163	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   122: invokespecial 166	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   125: athrow
    //   126: new 154	java/lang/IllegalStateException
    //   129: dup
    //   130: ldc -88
    //   132: invokespecial 166	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   135: athrow
    //   136: aload_0
    //   137: invokestatic 174	com/google/android/android/common/util/IpAddress:zzcj	(Landroid/content/Context;)Z
    //   140: ifne +15 -> 155
    //   143: aload_0
    //   144: invokestatic 177	com/google/android/android/common/util/IpAddress:zzcl	(Landroid/content/Context;)Z
    //   147: ifne +8 -> 155
    //   150: iconst_1
    //   151: istore_1
    //   152: goto +5 -> 157
    //   155: iconst_0
    //   156: istore_1
    //   157: aconst_null
    //   158: astore 4
    //   160: iload_1
    //   161: ifeq +18 -> 179
    //   164: aload 5
    //   166: ldc 15
    //   168: sipush 8256
    //   171: invokevirtual 181	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   174: astore 4
    //   176: goto +3 -> 179
    //   179: aload 5
    //   181: ldc 8
    //   183: bipush 64
    //   185: invokevirtual 181	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   188: astore 6
    //   190: aload_0
    //   191: invokestatic 187	com/google/android/android/common/DataProvider:zzbz	(Landroid/content/Context;)Lcom/google/android/android/common/DataProvider;
    //   194: pop
    //   195: iload_1
    //   196: ifeq +38 -> 234
    //   199: aload 4
    //   201: getstatic 193	com/google/android/android/common/Bookshelf:zzffs	[Lcom/google/android/android/common/Vector2D;
    //   204: invokestatic 197	com/google/android/android/common/DataProvider:add	(Landroid/content/pm/PackageInfo;[Lcom/google/android/android/common/Vector2D;)Lcom/google/android/android/common/Vector2D;
    //   207: astore_0
    //   208: aload_0
    //   209: ifnonnull +6 -> 215
    //   212: bipush 9
    //   214: ireturn
    //   215: aload 6
    //   217: iconst_1
    //   218: anewarray 199	com/google/android/android/common/Vector2D
    //   221: dup
    //   222: iconst_0
    //   223: aload_0
    //   224: aastore
    //   225: invokestatic 197	com/google/android/android/common/DataProvider:add	(Landroid/content/pm/PackageInfo;[Lcom/google/android/android/common/Vector2D;)Lcom/google/android/android/common/Vector2D;
    //   228: ifnonnull +20 -> 248
    //   231: bipush 9
    //   233: ireturn
    //   234: aload 6
    //   236: getstatic 193	com/google/android/android/common/Bookshelf:zzffs	[Lcom/google/android/android/common/Vector2D;
    //   239: invokestatic 197	com/google/android/android/common/DataProvider:add	(Landroid/content/pm/PackageInfo;[Lcom/google/android/android/common/Vector2D;)Lcom/google/android/android/common/Vector2D;
    //   242: ifnonnull +6 -> 248
    //   245: bipush 9
    //   247: ireturn
    //   248: getstatic 130	com/google/android/android/common/TransactionInput:GOOGLE_PLAY_SERVICES_VERSION_CODE	I
    //   251: istore_1
    //   252: iload_1
    //   253: sipush 1000
    //   256: idiv
    //   257: istore_2
    //   258: aload 6
    //   260: getfield 204	android/content/pm/PackageInfo:versionCode	I
    //   263: istore_3
    //   264: iload_3
    //   265: sipush 1000
    //   268: idiv
    //   269: iload_2
    //   270: if_icmpge +46 -> 316
    //   273: new 132	java/lang/StringBuilder
    //   276: dup
    //   277: bipush 77
    //   279: invokespecial 141	java/lang/StringBuilder:<init>	(I)V
    //   282: astore_0
    //   283: aload_0
    //   284: ldc -50
    //   286: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_0
    //   291: iload_1
    //   292: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_0
    //   297: ldc -104
    //   299: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_0
    //   304: iload_3
    //   305: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_0
    //   310: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: pop
    //   314: iconst_2
    //   315: ireturn
    //   316: aload 6
    //   318: getfield 213	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   321: astore 4
    //   323: aload 4
    //   325: astore_0
    //   326: aload 4
    //   328: ifnonnull +27 -> 355
    //   331: aload 5
    //   333: ldc 8
    //   335: iconst_0
    //   336: invokevirtual 217	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   339: astore_0
    //   340: goto +15 -> 355
    //   343: astore_0
    //   344: ldc -37
    //   346: ldc -35
    //   348: aload_0
    //   349: invokestatic 227	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   352: pop
    //   353: iconst_1
    //   354: ireturn
    //   355: aload_0
    //   356: getfield 232	android/content/pm/ApplicationInfo:enabled	Z
    //   359: ifne +5 -> 364
    //   362: iconst_3
    //   363: ireturn
    //   364: iconst_0
    //   365: ireturn
    //   366: astore 4
    //   368: goto -348 -> 20
    //   371: astore_0
    //   372: bipush 9
    //   374: ireturn
    //   375: astore_0
    //   376: iconst_1
    //   377: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramContext	Context
    //   48	244	1	i	int
    //   56	215	2	j	int
    //   263	42	3	k	int
    //   158	169	4	localObject	Object
    //   366	1	4	localThrowable	Throwable
    //   4	328	5	localPackageManager	PackageManager
    //   188	129	6	localPackageInfo	PackageInfo
    // Exception table:
    //   from	to	target	type
    //   331	340	343	android/content/pm/PackageManager$NameNotFoundException
    //   6	17	366	java/lang/Throwable
    //   164	176	371	android/content/pm/PackageManager$NameNotFoundException
    //   179	190	375	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static boolean isUserRecoverableError(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 9);
  }
  
  /* Error */
  public static boolean load(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 8
    //   3: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: istore_3
    //   7: invokestatic 243	com/google/android/android/common/util/KeyguardManager:zzalj	()Z
    //   10: ifeq +56 -> 66
    //   13: aload_0
    //   14: invokevirtual 81	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   17: invokevirtual 247	android/content/pm/PackageManager:getPackageInstaller	()Landroid/content/pm/PackageInstaller;
    //   20: invokevirtual 253	android/content/pm/PackageInstaller:getAllSessions	()Ljava/util/List;
    //   23: astore 4
    //   25: aload 4
    //   27: invokeinterface 259 1 0
    //   32: astore 4
    //   34: aload 4
    //   36: invokeinterface 264 1 0
    //   41: ifeq +25 -> 66
    //   44: aload_1
    //   45: aload 4
    //   47: invokeinterface 268 1 0
    //   52: checkcast 270	android/content/pm/PackageInstaller$SessionInfo
    //   55: invokevirtual 273	android/content/pm/PackageInstaller$SessionInfo:getAppPackageName	()Ljava/lang/String;
    //   58: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifeq -27 -> 34
    //   64: iconst_1
    //   65: ireturn
    //   66: aload_0
    //   67: invokevirtual 81	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   70: astore 4
    //   72: aload 4
    //   74: aload_1
    //   75: sipush 8192
    //   78: invokevirtual 217	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   81: astore_1
    //   82: iload_3
    //   83: ifeq +8 -> 91
    //   86: aload_1
    //   87: getfield 232	android/content/pm/ApplicationInfo:enabled	Z
    //   90: ireturn
    //   91: aload_1
    //   92: getfield 232	android/content/pm/ApplicationInfo:enabled	Z
    //   95: ifeq +64 -> 159
    //   98: getstatic 278	android/os/Build$VERSION:SDK_INT	I
    //   101: istore_2
    //   102: aload_0
    //   103: ldc_w 280
    //   106: invokevirtual 284	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   109: astore_1
    //   110: aload_1
    //   111: checkcast 286	android/os/UserManager
    //   114: astore_1
    //   115: aload_1
    //   116: aload_0
    //   117: invokevirtual 109	android/content/Context:getPackageName	()Ljava/lang/String;
    //   120: invokevirtual 290	android/os/UserManager:getApplicationRestrictions	(Ljava/lang/String;)Landroid/os/Bundle;
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +26 -> 151
    //   128: ldc_w 292
    //   131: aload_0
    //   132: ldc_w 294
    //   135: invokevirtual 299	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: istore_3
    //   142: iload_3
    //   143: ifeq +8 -> 151
    //   146: iconst_1
    //   147: istore_2
    //   148: goto +5 -> 153
    //   151: iconst_0
    //   152: istore_2
    //   153: iload_2
    //   154: ifne +11 -> 165
    //   157: iconst_1
    //   158: ireturn
    //   159: iconst_0
    //   160: ireturn
    //   161: astore_0
    //   162: iconst_0
    //   163: ireturn
    //   164: astore_0
    //   165: iconst_0
    //   166: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramContext	Context
    //   0	167	1	paramString	String
    //   101	53	2	i	int
    //   6	137	3	bool	boolean
    //   23	50	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	25	161	java/lang/Exception
    //   72	82	164	android/content/pm/PackageManager$NameNotFoundException
    //   102	110	164	android/content/pm/PackageManager$NameNotFoundException
    //   115	124	164	android/content/pm/PackageManager$NameNotFoundException
    //   128	142	164	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static boolean parse(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return load(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  public static void zzbj(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = PingManager.zzffk.isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      Object localObject = PingManager.zzffk;
      paramContext = PingManager.get(paramContext, i, "e");
      localObject = new StringBuilder(57);
      ((StringBuilder)localObject).append("GooglePlayServices not available due to error ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).toString();
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }
  
  public static void zzbv(Context paramContext)
  {
    if (zzfga.getAndSet(true)) {
      return;
    }
    try
    {
      paramContext = paramContext.getSystemService("notification");
      paramContext = (NotificationManager)paramContext;
      if (paramContext != null)
      {
        paramContext.cancel(10436);
        return;
      }
    }
    catch (SecurityException paramContext) {}
  }
  
  public static int zzbw(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return 0;
  }
  
  public static boolean zzby(Context paramContext)
  {
    if (!zzffz) {}
    try
    {
      try
      {
        PackageInfo localPackageInfo = zzbed.zzcr(paramContext).getPackageInfo("com.google.android.gms", 64);
        if (localPackageInfo != null)
        {
          DataProvider.zzbz(paramContext);
          paramContext = Bookshelf.zzffs[1];
          paramContext = DataProvider.add(localPackageInfo, new Vector2D[] { paramContext });
          if (paramContext != null)
          {
            zzffy = true;
            break label71;
          }
        }
        zzffy = false;
      }
      catch (Throwable paramContext)
      {
        zzffz = true;
        throw paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label71:
      for (;;) {}
    }
    zzffz = true;
    if (!zzffy) {
      return !"user".equals(Build.TYPE);
    }
    return true;
  }
}
