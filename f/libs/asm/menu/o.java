package f.libs.asm.menu;

public class o
{
  public final String a;
  public final o b;
  public final StackTraceElement[] c;
  public final String d;
  
  public o(Throwable paramThrowable, Path paramPath)
  {
    d = paramThrowable.getLocalizedMessage();
    a = paramThrowable.getClass().getName();
    c = paramPath.extract(paramThrowable.getStackTrace());
    paramThrowable = paramThrowable.getCause();
    if (paramThrowable != null) {
      paramThrowable = new o(paramThrowable, paramPath);
    } else {
      paramThrowable = null;
    }
    b = paramThrowable;
  }
}
