package support.android.v4.app;

import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;

public final class EnvironmentCompat
{
  public static final String MEDIA_UNKNOWN = "unknown";
  public static final String TAG = "EnvironmentCompat";
  
  public EnvironmentCompat() {}
  
  public static String getStorageState(File paramFile)
  {
    int i = Build.VERSION.SDK_INT;
    return Environment.getStorageState(paramFile);
  }
}
