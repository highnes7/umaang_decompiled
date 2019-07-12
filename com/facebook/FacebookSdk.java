package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FacebookSdk
{
  public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
  public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
  public static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
  public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized.";
  public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
  public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
  public static final int DEFAULT_CORE_POOL_SIZE = 5;
  public static final int DEFAULT_KEEP_ALIVE = 1;
  public static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
  public static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory()
  {
    public final AtomicInteger counter = new AtomicInteger(0);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("FacebookSdk #");
      localStringBuilder.append(counter.incrementAndGet());
      return new Thread(paramAnonymousRunnable, localStringBuilder.toString());
    }
  };
  public static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE;
  public static final String FACEBOOK_COM = "facebook.com";
  public static final String HASHTAG = "com.facebook.FacebookSdk";
  public static final Object LOCK;
  public static final int MAX_REQUEST_CODE_RANGE = 100;
  public static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
  public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
  public static volatile String appClientToken;
  public static Context applicationContext;
  public static volatile String applicationId;
  public static volatile String applicationName;
  public static LockOnGetVariable<File> cacheDir;
  public static int callbackRequestCodeOffset;
  public static volatile Executor executor;
  public static volatile String facebookDomain;
  public static volatile boolean isDebugEnabled;
  public static boolean isLegacyTokenUpgradeSupported;
  public static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[] { LoggingBehavior.DEVELOPER_ERRORS }));
  public static AtomicLong onProgressThreshold;
  public static Boolean sdkInitialized = Boolean.valueOf(false);
  public static volatile int webDialogTheme;
  
  static
  {
    facebookDomain = "facebook.com";
    onProgressThreshold = new AtomicLong(65536L);
    isDebugEnabled = false;
    isLegacyTokenUpgradeSupported = false;
    callbackRequestCodeOffset = 64206;
    LOCK = new Object();
    DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
  }
  
  public FacebookSdk() {}
  
  public static void addLoggingBehavior(LoggingBehavior paramLoggingBehavior)
  {
    HashSet localHashSet = loggingBehaviors;
    try
    {
      loggingBehaviors.add(paramLoggingBehavior);
      updateGraphDebugBehavior();
      return;
    }
    catch (Throwable paramLoggingBehavior)
    {
      throw paramLoggingBehavior;
    }
  }
  
  public static void clearLoggingBehaviors()
  {
    HashSet localHashSet = loggingBehaviors;
    try
    {
      loggingBehaviors.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static Context getApplicationContext()
  {
    Validate.sdkInitialized();
    return applicationContext;
  }
  
  public static String getApplicationId()
  {
    Validate.sdkInitialized();
    return applicationId;
  }
  
  public static String getApplicationName()
  {
    Validate.sdkInitialized();
    return applicationName;
  }
  
  /* Error */
  public static String getApplicationSignature(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 172	com/facebook/internal/Validate:sdkInitialized	()V
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 191	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: invokevirtual 194	android/content/Context:getPackageName	()Ljava/lang/String;
    //   24: astore_0
    //   25: aload_1
    //   26: aload_0
    //   27: bipush 64
    //   29: invokevirtual 200	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   32: astore_0
    //   33: aload_0
    //   34: getfield 206	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +39 -> 78
    //   42: aload_1
    //   43: arraylength
    //   44: ifne +5 -> 49
    //   47: aconst_null
    //   48: areturn
    //   49: ldc -48
    //   51: invokestatic 214	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: getfield 206	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   60: iconst_0
    //   61: aaload
    //   62: invokevirtual 220	android/content/pm/Signature:toByteArray	()[B
    //   65: invokevirtual 224	java/security/MessageDigest:update	([B)V
    //   68: aload_1
    //   69: invokevirtual 227	java/security/MessageDigest:digest	()[B
    //   72: bipush 9
    //   74: invokestatic 233	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: astore_0
    //   81: aconst_null
    //   82: areturn
    //   83: astore_0
    //   84: aconst_null
    //   85: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramContext	Context
    //   13	56	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	33	80	android/content/pm/PackageManager$NameNotFoundException
    //   49	55	83	java/security/NoSuchAlgorithmException
  }
  
  public static File getCacheDir()
  {
    Validate.sdkInitialized();
    return (File)cacheDir.getValue();
  }
  
  public static int getCallbackRequestCodeOffset()
  {
    Validate.sdkInitialized();
    return callbackRequestCodeOffset;
  }
  
  public static String getClientToken()
  {
    Validate.sdkInitialized();
    return appClientToken;
  }
  
  public static Executor getExecutor()
  {
    Object localObject = LOCK;
    try
    {
      if (executor == null) {
        executor = AsyncTask.THREAD_POOL_EXECUTOR;
      }
      return executor;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static String getFacebookDomain()
  {
    return facebookDomain;
  }
  
  public static boolean getLimitEventAndDataUsage(Context paramContext)
  {
    Validate.sdkInitialized();
    return paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
  }
  
  public static Set getLoggingBehaviors()
  {
    HashSet localHashSet = loggingBehaviors;
    try
    {
      Set localSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
      return localSet;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static long getOnProgressThreshold()
  {
    Validate.sdkInitialized();
    return onProgressThreshold.get();
  }
  
  public static String getSdkVersion()
  {
    return "4.6.0";
  }
  
  public static int getWebDialogTheme()
  {
    Validate.sdkInitialized();
    return webDialogTheme;
  }
  
  public static boolean isDebugEnabled()
  {
    return isDebugEnabled;
  }
  
  public static boolean isFacebookRequestCode(int paramInt)
  {
    int i = callbackRequestCodeOffset;
    return (paramInt >= i) && (paramInt < i + 100);
  }
  
  public static boolean isInitialized()
  {
    try
    {
      boolean bool = sdkInitialized.booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static boolean isLegacyTokenUpgradeSupported()
  {
    return isLegacyTokenUpgradeSupported;
  }
  
  public static boolean isLoggingBehaviorEnabled(LoggingBehavior paramLoggingBehavior)
  {
    HashSet localHashSet = loggingBehaviors;
    try
    {
      if ((!isDebugEnabled) || (!loggingBehaviors.contains(paramLoggingBehavior))) {
        break label39;
      }
      bool = true;
    }
    catch (Throwable paramLoggingBehavior)
    {
      for (;;)
      {
        continue;
        boolean bool = false;
      }
    }
    return bool;
    throw paramLoggingBehavior;
  }
  
  public static void loadDefaultsFromMetadata(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        if (metaData == null) {
          return;
        }
        if (applicationId == null)
        {
          Object localObject = metaData.get("com.facebook.sdk.ApplicationId");
          if ((localObject instanceof String))
          {
            localObject = (String)localObject;
            if (((String)localObject).toLowerCase(Locale.ROOT).startsWith("fb")) {
              applicationId = ((String)localObject).substring(2);
            } else {
              applicationId = (String)localObject;
            }
          }
          else if ((localObject instanceof Integer))
          {
            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
          }
        }
        if (applicationName == null) {
          applicationName = metaData.getString("com.facebook.sdk.ApplicationName");
        }
        if (appClientToken == null) {
          appClientToken = metaData.getString("com.facebook.sdk.ClientToken");
        }
        if (webDialogTheme == 0)
        {
          webDialogTheme = metaData.getInt("com.facebook.sdk.WebDialogTheme");
          return;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  public static GraphResponse publishInstallAndWaitForResponse(Context paramContext, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a14 = a13\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static void publishInstallAsync(Context paramContext, final String paramString)
  {
    paramContext = paramContext.getApplicationContext();
    getExecutor().execute(new Runnable()
    {
      public void run()
      {
        FacebookSdk.publishInstallAndWaitForResponse(val$applicationContext, paramString);
      }
    });
  }
  
  public static void removeLoggingBehavior(LoggingBehavior paramLoggingBehavior)
  {
    HashSet localHashSet = loggingBehaviors;
    try
    {
      loggingBehaviors.remove(paramLoggingBehavior);
      return;
    }
    catch (Throwable paramLoggingBehavior)
    {
      throw paramLoggingBehavior;
    }
  }
  
  public static void sdkInitialize(Context paramContext)
  {
    try
    {
      sdkInitialize(paramContext, null);
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static void sdkInitialize(Context paramContext, int paramInt)
  {
    try
    {
      sdkInitialize(paramContext, paramInt, null);
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static void sdkInitialize(Context paramContext, int paramInt, InitializeCallback paramInitializeCallback)
  {
    try
    {
      if ((sdkInitialized.booleanValue()) && (paramInt != callbackRequestCodeOffset)) {
        throw new FacebookException("The callback request code offset can't be updated once the SDK is initialized.");
      }
      if (paramInt >= 0)
      {
        callbackRequestCodeOffset = paramInt;
        sdkInitialize(paramContext);
        return;
      }
      throw new FacebookException("The callback request code offset can't be negative.");
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static void sdkInitialize(Context paramContext, InitializeCallback paramInitializeCallback)
  {
    try
    {
      if (sdkInitialized.booleanValue())
      {
        if (paramInitializeCallback != null) {
          paramInitializeCallback.onInitialized();
        }
        return;
      }
      Validate.notNull(paramContext, "applicationContext");
      Validate.hasFacebookActivity(paramContext, false);
      Validate.hasInternetPermissions(paramContext, false);
      applicationContext = paramContext.getApplicationContext();
      loadDefaultsFromMetadata(applicationContext);
      Utility.loadAppSettingsAsync(applicationContext, applicationId);
      NativeProtocol.updateAllAvailableProtocolVersionsAsync();
      BoltsMeasurementEventListener.getInstance(applicationContext);
      cacheDir = new LockOnGetVariable(new Callable()
      {
        public File call()
          throws Exception
        {
          return FacebookSdk.applicationContext.getCacheDir();
        }
      });
      paramContext = new FutureTask(new Callable()
      {
        public Void call()
          throws Exception
        {
          AccessTokenManager.getInstance().loadCurrentAccessToken();
          ProfileManager.getInstance().loadCurrentProfile();
          if ((AccessToken.getCurrentAccessToken() != null) && (Profile.getCurrentProfile() == null)) {
            Profile.fetchProfileForCurrentAccessToken();
          }
          FacebookSdk.InitializeCallback localInitializeCallback = val$callback;
          if (localInitializeCallback != null) {
            localInitializeCallback.onInitialized();
          }
          return null;
        }
      });
      getExecutor().execute(paramContext);
      sdkInitialized = Boolean.valueOf(true);
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static void setApplicationId(String paramString)
  {
    applicationId = paramString;
  }
  
  public static void setApplicationName(String paramString)
  {
    applicationName = paramString;
  }
  
  public static void setCacheDir(File paramFile)
  {
    cacheDir = new LockOnGetVariable(paramFile);
  }
  
  public static void setClientToken(String paramString)
  {
    appClientToken = paramString;
  }
  
  public static void setExecutor(Executor paramExecutor)
  {
    Validate.notNull(paramExecutor, "executor");
    Object localObject = LOCK;
    try
    {
      executor = paramExecutor;
      return;
    }
    catch (Throwable paramExecutor)
    {
      throw paramExecutor;
    }
  }
  
  public static void setFacebookDomain(String paramString)
  {
    String str = HASHTAG;
    facebookDomain = paramString;
  }
  
  public static void setIsDebugEnabled(boolean paramBoolean)
  {
    isDebugEnabled = paramBoolean;
  }
  
  public static void setLegacyTokenUpgradeSupported(boolean paramBoolean)
  {
    isLegacyTokenUpgradeSupported = paramBoolean;
  }
  
  public static void setLimitEventAndDataUsage(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", paramBoolean).apply();
  }
  
  public static void setOnProgressThreshold(long paramLong)
  {
    onProgressThreshold.set(paramLong);
  }
  
  public static void setWebDialogTheme(int paramInt)
  {
    webDialogTheme = paramInt;
  }
  
  public static void updateGraphDebugBehavior()
  {
    if ((loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) && (!loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING))) {
      loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
    }
  }
  
  public static abstract interface InitializeCallback
  {
    public abstract void onInitialized();
  }
}
