package l.a.a.a.a.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import l.a.a.a.Item;

public class Settings
  implements Cache
{
  public final Context context;
  public final SharedPreferences pref;
  public final String settings;
  
  public Settings(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      context = paramContext;
      settings = paramString;
      pref = context.getSharedPreferences(settings, 0);
      return;
    }
    throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
  }
  
  public Settings(Item paramItem)
  {
    this(paramItem.getContext(), paramItem.getClass().getName());
  }
  
  public SharedPreferences.Editor edit()
  {
    return pref.edit();
  }
  
  public SharedPreferences getSharedPreferences()
  {
    return pref;
  }
  
  public boolean save(SharedPreferences.Editor paramEditor)
  {
    int i = Build.VERSION.SDK_INT;
    paramEditor.apply();
    return true;
  }
}
