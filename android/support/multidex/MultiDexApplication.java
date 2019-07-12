package android.support.multidex;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import support.android.widget.MultiDex;

public class MultiDexApplication
  extends Application
{
  public MultiDexApplication() {}
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    MultiDex.install(this);
  }
}
