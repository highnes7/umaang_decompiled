package f.g.org.org.http;

import f.g.b.a.g.h;
import f.g.org.org.util.BackOff;
import f.g.org.org.util.Context;
import f.g.org.org.util.ImageManager;
import java.io.IOException;

@h
public class Frame
  implements HttpIOExceptionHandler
{
  public final BackOff a;
  public Context c = Context.c;
  
  public Frame(BackOff paramBackOff)
  {
    if (paramBackOff != null)
    {
      a = paramBackOff;
      return;
    }
    throw new NullPointerException();
  }
  
  public final Context b()
  {
    return c;
  }
  
  public final BackOff c()
  {
    return a;
  }
  
  public boolean get(HttpRequest paramHttpRequest, boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean) {
      return false;
    }
    paramHttpRequest = c;
    BackOff localBackOff = a;
    try
    {
      paramBoolean = ImageManager.put(paramHttpRequest, localBackOff);
      return paramBoolean;
    }
    catch (InterruptedException paramHttpRequest) {}
    return false;
  }
  
  public Frame init(Context paramContext)
  {
    if (paramContext != null)
    {
      c = paramContext;
      return this;
    }
    throw new NullPointerException();
  }
}
