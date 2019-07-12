package support.android.v4.app;

import android.os.Build.VERSION;
import android.os.Trace;

public final class TraceCompat
{
  public TraceCompat() {}
  
  public static void beginSection(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    Trace.beginSection(paramString);
  }
  
  public static void endSection()
  {
    int i = Build.VERSION.SDK_INT;
    Trace.endSection();
  }
}
