package views;

import d.l;
import java.util.Locale;
import java.util.concurrent.CancellationException;

public class Label
{
  public boolean c;
  public final Object d = new Object();
  
  public Label() {}
  
  public boolean a()
  {
    Object localObject = d;
    try
    {
      boolean bool = c;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean b()
  {
    Object localObject = d;
    try
    {
      if (c) {
        return false;
      }
      c = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { l.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(c) });
  }
  
  public void visitMaxs()
    throws CancellationException
  {
    Object localObject = d;
    try
    {
      if (!c) {
        return;
      }
      throw new CancellationException();
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
