package f.libs.asm.menu;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class q
  implements k
{
  public static final String e = "io.fabric.unity.crashlytics.version";
  public final String a;
  public final Context c;
  
  public q(Context paramContext, String paramString)
  {
    c = paramContext;
    a = paramString;
  }
  
  public String a()
  {
    Object localObject = c.getPackageManager();
    String str = a;
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo(str, 128);
      localObject = metaData;
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("io.fabric.unity.crashlytics.version");
        return localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
}
