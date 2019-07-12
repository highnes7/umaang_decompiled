package views;

import d.m;
import java.util.Locale;

public class h
{
  public final Label b = new Label();
  
  public h() {}
  
  public Label a()
  {
    return b;
  }
  
  public boolean b()
  {
    return b.a();
  }
  
  public void e()
  {
    b.b();
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { m.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(b()) });
  }
}
