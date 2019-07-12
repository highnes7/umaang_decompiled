package l.a.a.a.a.f;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract interface Cache
{
  public abstract SharedPreferences.Editor edit();
  
  public abstract SharedPreferences getSharedPreferences();
  
  public abstract boolean save(SharedPreferences.Editor paramEditor);
}
