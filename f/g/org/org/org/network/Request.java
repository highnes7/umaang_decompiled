package f.g.org.org.org.network;

import f.g.org.org.http.HttpHeaders;
import java.io.IOException;

public abstract interface Request<T, E>
{
  public abstract void onFailure(Object paramObject, HttpHeaders paramHttpHeaders)
    throws IOException;
  
  public abstract void onSuccess(Object paramObject, HttpHeaders paramHttpHeaders)
    throws IOException;
}
