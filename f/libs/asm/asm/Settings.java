package f.libs.asm.asm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import l.a.a.a.a.f.Cache;

public class Settings
{
  public static final String PREFERENCE_AUTOSTART = "analytics_launched";
  public static final String SETTINGS_TABLE = "settings";
  public final Cache this$0;
  
  public Settings(Cache paramCache)
  {
    this$0 = paramCache;
  }
  
  public static Settings read(Context paramContext)
  {
    return new Settings(new l.a.a.a.a.f.Settings(paramContext, "settings"));
  }
  
  public void clear()
  {
    Cache localCache = this$0;
    localCache.save(localCache.edit().putBoolean("analytics_launched", true));
  }
  
  public boolean get()
  {
    return this$0.getSharedPreferences().getBoolean("analytics_launched", false);
  }
}
