package l.a.a.a;

public class Logger
  implements Log
{
  public int level;
  
  public Logger()
  {
    level = 4;
  }
  
  public Logger(int paramInt)
  {
    level = paramInt;
  }
  
  public void d(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) || (write(paramString1, paramInt))) {
      android.util.Log.println(paramInt, paramString1, paramString2);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    log(paramString1, paramString2, null);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    write(paramString1, 6);
  }
  
  public void e(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public void error(String paramString1, String paramString2, Throwable paramThrowable)
  {
    write(paramString1, 2);
  }
  
  public int getLogLevel()
  {
    return level;
  }
  
  public void i(String paramString1, String paramString2)
  {
    info(paramString1, paramString2, null);
  }
  
  public void info(String paramString1, String paramString2, Throwable paramThrowable)
  {
    write(paramString1, 4);
  }
  
  public void log(String paramString1, String paramString2)
  {
    error(paramString1, paramString2, null);
  }
  
  public void log(String paramString1, String paramString2, Throwable paramThrowable)
  {
    write(paramString1, 3);
  }
  
  public void println(int paramInt, String paramString1, String paramString2)
  {
    d(paramInt, paramString1, paramString2, false);
  }
  
  public void remove(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public void setLogLevel(int paramInt)
  {
    level = paramInt;
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    write(paramString1, 5);
  }
  
  public boolean write(String paramString, int paramInt)
  {
    return (level <= paramInt) || (android.util.Log.isLoggable(paramString, paramInt));
  }
}
