package f.g.org.org.org.client;

import f.g.b.a.b.g.e;
import f.g.b.a.g.h;
import f.g.org.org.http.HttpIOExceptionHandler;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpUnsuccessfulResponseHandler;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@h
public class Credential
  implements HttpUnsuccessfulResponseHandler, HttpIOExceptionHandler
{
  public static final Logger LOGGER = Logger.getLogger(e.class.getName());
  public final HttpIOExceptionHandler instance;
  public final Buffer lock;
  public final HttpUnsuccessfulResponseHandler method;
  
  public Credential(Buffer paramBuffer, HttpRequest paramHttpRequest)
  {
    if (paramBuffer != null)
    {
      lock = paramBuffer;
      instance = paramHttpRequest.getIOExceptionHandler();
      method = paramHttpRequest.getUnsuccessfulResponseHandler();
      paramHttpRequest.setIOExceptionHandler(this);
      paramHttpRequest.setUnsuccessfulResponseHandler(this);
      return;
    }
    throw new NullPointerException();
  }
  
  public boolean get(HttpRequest paramHttpRequest, boolean paramBoolean)
    throws IOException
  {
    HttpIOExceptionHandler localHttpIOExceptionHandler = instance;
    if ((localHttpIOExceptionHandler != null) && (localHttpIOExceptionHandler.get(paramHttpRequest, paramBoolean))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      paramHttpRequest = lock;
      try
      {
        paramHttpRequest.create();
        return paramBoolean;
      }
      catch (IOException paramHttpRequest)
      {
        LOGGER.log(Level.WARNING, "exception thrown while calling server callback", paramHttpRequest);
      }
    }
    return paramBoolean;
  }
  
  public boolean handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, boolean paramBoolean)
    throws IOException
  {
    HttpUnsuccessfulResponseHandler localHttpUnsuccessfulResponseHandler = method;
    boolean bool;
    if ((localHttpUnsuccessfulResponseHandler != null) && (localHttpUnsuccessfulResponseHandler.handleResponse(paramHttpRequest, paramHttpResponse, paramBoolean))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && (paramBoolean) && (paramHttpResponse.getStatusCode() / 100 == 5))
    {
      paramHttpRequest = lock;
      try
      {
        paramHttpRequest.create();
        return bool;
      }
      catch (IOException paramHttpRequest)
      {
        LOGGER.log(Level.WARNING, "exception thrown while calling server callback", paramHttpRequest);
      }
    }
    return bool;
  }
}
