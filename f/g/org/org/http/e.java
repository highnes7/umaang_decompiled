package f.g.org.org.http;

import f.g.b.a.g.h;
import f.g.org.org.util.BackOff;
import f.g.org.org.util.Context;
import f.g.org.org.util.ImageManager;
import java.io.IOException;

@h
public class e
  implements HttpUnsuccessfulResponseHandler
{
  public Label b = Label.b;
  public final BackOff j;
  public Context l = Context.c;
  
  public e(BackOff paramBackOff)
  {
    if (paramBackOff != null)
    {
      j = paramBackOff;
      return;
    }
    throw new NullPointerException();
  }
  
  public final Label a()
  {
    return b;
  }
  
  public e a(Label paramLabel)
  {
    if (paramLabel != null)
    {
      b = paramLabel;
      return this;
    }
    throw new NullPointerException();
  }
  
  public e a(Context paramContext)
  {
    if (paramContext != null)
    {
      l = paramContext;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final BackOff b()
  {
    return j;
  }
  
  public final Context getId()
  {
    return l;
  }
  
  public final boolean handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean) {
      return false;
    }
    if (b.isRequired(paramHttpResponse))
    {
      paramHttpRequest = l;
      paramHttpResponse = j;
      try
      {
        paramBoolean = ImageManager.put(paramHttpRequest, paramHttpResponse);
        return paramBoolean;
      }
      catch (InterruptedException paramHttpRequest) {}
    }
    return false;
  }
}
