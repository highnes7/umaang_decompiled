package f.g.org.org.dom4j.util;

import f.g.b.a.g.h;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.UrlEncodedParser;
import java.io.IOException;

@h
public abstract class HttpRequest
  extends GenericUrl
{
  public ACRALog log;
  public String password;
  public boolean status;
  public HttpTransport transport;
  
  public HttpRequest(String paramString)
  {
    super(paramString);
  }
  
  public final HttpResponse execute()
    throws IOException
  {
    Object localObject2 = transport.createRequestFactory();
    if (status) {
      localObject1 = "POST";
    } else {
      localObject1 = "GET";
    }
    Object localObject1 = ((HttpRequestFactory)localObject2).buildRequest((String)localObject1, this, null);
    get().intercept((f.g.org.org.http.HttpRequest)localObject1);
    localObject1 = ((f.g.org.org.http.HttpRequest)localObject1).execute();
    ((f.g.org.org.http.HttpResponse)localObject1).setContentLoggingLimit(0);
    localObject2 = new HttpResponse();
    UrlEncodedParser.parse(((f.g.org.org.http.HttpResponse)localObject1).parseAsString(), localObject2);
    return localObject2;
  }
  
  public Namespace get()
  {
    Namespace localNamespace = new Namespace();
    consumerKey = password;
    log = log;
    return localNamespace;
  }
}
