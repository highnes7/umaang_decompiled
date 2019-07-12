package f.l.a.c;

import android.util.Log;
import f.l.a.b.f;

public final class L
{
  public static final String LOG_FORMAT = "%1$s\n%2$s";
  public static volatile boolean c;
  public static volatile boolean writeLogs;
  
  public L() {}
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (c) {
      log(3, null, paramString, paramVarArgs);
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    log(6, null, paramString, paramVarArgs);
  }
  
  public static void e(Throwable paramThrowable)
  {
    log(6, paramThrowable, null, new Object[0]);
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(6, paramThrowable, paramString, paramVarArgs);
  }
  
  public static void log(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (!writeLogs) {
      return;
    }
    String str = paramString;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString, paramVarArgs);
    }
    if (paramThrowable != null)
    {
      paramString = str;
      if (str == null) {
        paramString = paramThrowable.getMessage();
      }
      str = String.format("%1$s\n%2$s", new Object[] { paramString, Log.getStackTraceString(paramThrowable) });
    }
    Log.println(paramInt, f.TAG, str);
  }
  
  public static void log(String paramString, Object... paramVarArgs)
  {
    log(4, null, paramString, paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    log(5, null, paramString, paramVarArgs);
  }
  
  public static void writeDebugLogs()
  {
    writeLogs = true;
  }
  
  public static void writeDebugLogs(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static void writeLogs()
  {
    writeLogs = false;
  }
  
  public static void writeLogs(boolean paramBoolean)
  {
    writeLogs = paramBoolean;
  }
}
