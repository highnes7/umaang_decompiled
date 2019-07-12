package l.a.a.a;

public abstract interface Log
{
  public abstract void d(int paramInt, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void error(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int getLogLevel();
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void info(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void log(String paramString1, String paramString2);
  
  public abstract void log(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void println(int paramInt, String paramString1, String paramString2);
  
  public abstract void remove(String paramString1, String paramString2);
  
  public abstract void setLogLevel(int paramInt);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract boolean write(String paramString, int paramInt);
}
