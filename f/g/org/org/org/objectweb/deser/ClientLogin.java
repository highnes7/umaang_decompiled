package f.g.org.org.org.objectweb.deser;

import f.g.b.a.b.b.a.b.a;
import f.g.b.a.b.b.a.b.b;
import f.g.b.a.g.h;
import f.g.b.a.g.z;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Cache;
import f.g.org.org.http.FormatedText;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.Item;
import f.g.org.org.http.UrlEncodedContent;
import f.g.org.org.util.StringUtils;
import java.io.IOException;

@h
public final class ClientLogin
{
  @z
  public String accountType;
  @z("source")
  public String applicationName;
  @z("service")
  public String authTokenType;
  @z("logincaptcha")
  public String captchaAnswer;
  @z("logintoken")
  public String captchaToken;
  @z("Passwd")
  public String password;
  public GenericUrl serverUrl = new GenericUrl("https://www.google.com");
  public HttpTransport transport;
  @z("Email")
  public String username;
  
  public ClientLogin() {}
  
  public static String decode(String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return "GoogleLogin auth=".concat(paramString);
    }
    return new String("GoogleLogin auth=");
  }
  
  public Request authenticate()
    throws IOException
  {
    Object localObject1 = serverUrl.clone();
    ((GenericUrl)localObject1).appendRawPath("/accounts/ClientLogin");
    localObject1 = transport.createRequestFactory().buildPostRequest((GenericUrl)localObject1, new UrlEncodedContent(this));
    ((HttpRequest)localObject1).setParser(JsonParser.INSTANCE);
    ((HttpRequest)localObject1).setContentLoggingLimit(0);
    ((HttpRequest)localObject1).setThrowExceptionOnExecuteError(false);
    Object localObject2 = ((HttpRequest)localObject1).execute();
    if (((HttpResponse)localObject2).isSuccessStatusCode()) {
      return (Request)((HttpResponse)localObject2).parseAs(b.b.class);
    }
    localObject1 = new Item(((HttpResponse)localObject2).getStatusCode(), ((HttpResponse)localObject2).getStatusMessage(), ((HttpResponse)localObject2).getHeaders());
    ObjectIdInfo localObjectIdInfo = (ObjectIdInfo)((HttpResponse)localObject2).parseAs(b.a.class);
    String str = localObjectIdInfo.toString();
    localObject2 = FormatedText.computeMessageBuffer((HttpResponse)localObject2);
    if (!Cache.isEmpty(str))
    {
      ((StringBuilder)localObject2).append(StringUtils.LINE_SEPARATOR);
      ((StringBuilder)localObject2).append(str);
      ((Item)localObject1).setContent(str);
    }
    ((Item)localObject1).put(((StringBuilder)localObject2).toString());
    throw new BeanProperty((Item)localObject1, localObjectIdInfo);
  }
}
