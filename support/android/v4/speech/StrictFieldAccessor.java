package support.android.v4.speech;

import android.database.CursorWindow;
import android.os.Build.VERSION;

public final class StrictFieldAccessor
{
  public StrictFieldAccessor() {}
  
  public static CursorWindow get(String paramString, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new CursorWindow(paramString, paramLong);
    }
    return new CursorWindow(paramString);
  }
}
