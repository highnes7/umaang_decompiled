package support.android.v4.app;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import java.util.Locale;

public final class b
{
  public b() {}
  
  public static Label a(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return Label.a(paramConfiguration.getLocales());
    }
    return Label.a(new Locale[] { locale });
  }
}
