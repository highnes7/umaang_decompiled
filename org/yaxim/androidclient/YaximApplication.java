package org.yaxim.androidclient;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import f.l.a.b.ImageLoaderConfiguration.Builder;
import f.l.a.b.i;
import f.libs.asm.b;
import g.a.a.MemorizingTrustManager;
import l.a.a.a.Item;
import org.yaxim.androidclient.data.YaximConfiguration;

public class YaximApplication
  extends Application
{
  public static final String XMPP_IDENTITY_NAME = "yaxim";
  public static final String XMPP_IDENTITY_TYPE = "phone";
  public static ContextWrapper mContext;
  public YaximConfiguration mConfig;
  public MemorizingTrustManager mMTM;
  
  public YaximApplication() {}
  
  public static YaximApplication getApp(Context paramContext)
  {
    return (YaximApplication)paramContext.getApplicationContext();
  }
  
  public static ContextWrapper getAppContext()
  {
    return mContext;
  }
  
  public static YaximConfiguration getConfig(Context paramContext)
  {
    return getApplicationContextmConfig;
  }
  
  public void onCreate()
  {
    mContext = this;
    super.onCreate();
    mMTM = new MemorizingTrustManager(this);
    mConfig = new YaximConfiguration(PreferenceManager.getDefaultSharedPreferences(this));
    PreferenceManager.getDefaultSharedPreferences(this).edit().putLong("uniqueId", System.currentTimeMillis()).commit();
    try
    {
      localObject = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
      f.l.a.b.f.a().init((i)localObject);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject = new b();
          l.a.a.a.f.a(this, new Item[] { localObject });
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
    }
  }
}
