package support.android.v4.speech.tts;

import android.database.sqlite.SQLiteCursor;
import android.os.Build.VERSION;

public final class x
{
  public x() {}
  
  public static void a(SQLiteCursor paramSQLiteCursor, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      paramSQLiteCursor.setFillWindowForwardOnly(paramBoolean);
    }
  }
}
