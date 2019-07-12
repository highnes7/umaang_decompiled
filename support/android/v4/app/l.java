package support.android.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;

public class l
{
  public l() {}
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return ((UserManager)paramContext.getSystemService(UserManager.class)).isUserUnlocked();
    }
    return true;
  }
}
