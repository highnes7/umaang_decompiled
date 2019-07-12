package f.libs.asm.menu;

import l.a.a.a.a.c.Request.Priority;
import l.a.a.a.a.c.n;

public class NameRevCommand
  extends n<Void>
{
  public NameRevCommand(f paramF) {}
  
  public Void call()
    throws Exception
  {
    return wrappedRunnable.run();
  }
  
  public Request.Priority getPriority()
  {
    return Request.Priority.IMMEDIATE;
  }
}
