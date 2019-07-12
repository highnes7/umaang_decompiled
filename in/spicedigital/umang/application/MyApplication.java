package in.spicedigital.umang.application;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import com.google.android.android.analytics.GoogleAnalytics;
import com.google.android.android.analytics.Tracker;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import f.l.a.a.a.b.Md5FileNameGenerator;
import f.l.a.b.ImageLoaderConfiguration.Builder;
import f.l.a.b.a.QueueProcessingType;
import f.l.a.c.L;
import f.libs.asm.b;
import f.u.a.a.i;
import g.a.a.MemorizingTrustManager;
import java.util.ArrayList;
import k.a.a.c.Y;
import k.a.a.m.Config;
import k.a.a.m.ImageCache.2;
import l.a.a.a.Item;
import org.yaxim.androidclient.data.YaximConfiguration;

public class MyApplication
  extends MultiDexApplication
{
  public static final String APP_NAME = "umang_al_n";
  public static final String PAGE_KEY = "yaxim";
  public static final String PHONE = "phone";
  public static String a;
  public static ArrayList<Y> albums = new ArrayList();
  public static String b;
  public static String c;
  public static ArrayList<Y> context;
  public static Tracker counter;
  public static ArrayList<Y> events;
  public static String f;
  public static String g;
  public static ArrayList<Y> i;
  public static ArrayList<Y> id;
  public static GoogleAnalytics instance;
  public static ArrayList<Y> k;
  public static ArrayList<Y> l;
  public static boolean limit;
  public static ArrayList<Y> list;
  public static ArrayList<Y> log;
  public static String m;
  public static ArrayList<Y> o;
  public static String packageName;
  public static ArrayList<Y> properties;
  public static String q;
  public static ArrayList<Y> queue;
  public static String s;
  public static ArrayList<Y> songs = new ArrayList();
  public static boolean started;
  public static String t;
  public static boolean version;
  public static String versionName;
  public final String TAG = "MyApplication";
  public ImageCache.2 locale;
  public YaximConfiguration mConfig;
  public MemorizingTrustManager receiver;
  
  static
  {
    id = new ArrayList();
    log = new ArrayList();
    properties = new ArrayList();
    events = new ArrayList();
    context = new ArrayList();
    list = new ArrayList();
    queue = new ArrayList();
    i = new ArrayList();
    k = new ArrayList();
    l = new ArrayList();
    o = new ArrayList();
    s = "";
    c = "";
    t = "";
    g = "";
    q = "";
    m = "";
    b = "";
    f = "";
    a = "";
    versionName = "";
    packageName = "";
    version = true;
    started = false;
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
  }
  
  public MyApplication() {}
  
  public static void cancelTimer()
  {
    limit = false;
  }
  
  public static YaximConfiguration getConfig(Context paramContext)
  {
    return getApplicationContextmConfig;
  }
  
  public static MyApplication getInstance(Context paramContext)
  {
    return (MyApplication)paramContext.getApplicationContext();
  }
  
  public static boolean getLimit()
  {
    return limit;
  }
  
  public static void initImageLoader(Context paramContext)
  {
    paramContext = new ImageLoaderConfiguration.Builder(paramContext);
    paramContext.threadPriority(3);
    paramContext.denyCacheImageMultipleSizesInMemory();
    paramContext.diskCacheFileNameGenerator(new Md5FileNameGenerator());
    paramContext.diskCacheSize(52428800);
    paramContext.tasksProcessingOrder(QueueProcessingType.LIFO);
    L.writeLogs(false);
    f.l.a.b.f.a().init(paramContext.build());
  }
  
  public static void startTimer()
  {
    limit = true;
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(Config.wrap(paramContext, "en"));
  }
  
  public Tracker get()
  {
    try
    {
      if (counter == null)
      {
        counter = instance.newTracker(2131951618);
        counter.enableAdvertisingIdCollection(true);
      }
      Tracker localTracker = counter;
      return localTracker;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate()
  {
    super.onCreate();
    TwitterAuthConfig localTwitterAuthConfig = new TwitterAuthConfig("9ZrCPrFhft2URsplNqQM6kceh", "yMxZOPyakNtUMkHRG2s1acA84lZkp5l8sE6kNIrJCDgcZRYmub");
    receiver = new MemorizingTrustManager(this);
    mConfig = new YaximConfiguration(PreferenceManager.getDefaultSharedPreferences(this));
    l.a.a.a.f.a(this, new Item[] { new b(), new f.u.a.a.a.f(localTwitterAuthConfig), new i(localTwitterAuthConfig) });
    initImageLoader(getApplicationContext());
    try
    {
      Class.forName("android.os.AsyncTask");
      locale = new ImageCache.2();
      registerComponentCallbacks(locale);
      instance = GoogleAnalytics.getInstance(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}
