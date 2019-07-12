package f.g.org.org.org.network;

import f.g.b.a.b.c.b.b;
import f.g.org.org.http.BackOffPolicy;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpContent;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpStatus;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.HttpUnsuccessfulResponseHandler;
import f.g.org.org.util.ObjectParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class ClassWriter
{
  public final List<b.b<?, ?>> a;
  public final InputStream buffer;
  public List<b.b<?, ?>> c = new ArrayList();
  public final String index;
  public int items = 0;
  public boolean k;
  public boolean p = true;
  public final boolean state;
  
  public ClassWriter(InputStream paramInputStream, String paramString, List paramList, boolean paramBoolean)
    throws IOException
  {
    index = paramString;
    a = paramList;
    state = paramBoolean;
    buffer = paramInputStream;
    put(getTags());
  }
  
  private HttpResponse execute(int paramInt, InputStream paramInputStream, List paramList1, List paramList2)
    throws IOException
  {
    paramInputStream = new NetHttpTransport(paramInt, paramInputStream, paramList1, paramList2).createRequestFactory().buildPostRequest(new GenericUrl("http://google.com/"), null);
    paramInputStream.setLoggingEnabled(false);
    paramInputStream.setThrowExceptionOnExecuteError(false);
    return paramInputStream.execute();
  }
  
  private void execute(Item paramItem, int paramInt, HttpResponse paramHttpResponse)
    throws IOException
  {
    Request localRequest = this$0;
    HttpHeaders localHttpHeaders = paramHttpResponse.getHeaders();
    HttpUnsuccessfulResponseHandler localHttpUnsuccessfulResponseHandler = request.getUnsuccessfulResponseHandler();
    BackOffPolicy localBackOffPolicy = request.getBackOffPolicy();
    int i = 0;
    k = false;
    if (HttpStatus.isSuccess(paramInt))
    {
      if (localRequest == null) {
        return;
      }
      localRequest.onFailure(get(c, paramHttpResponse, paramItem), localHttpHeaders);
      return;
    }
    HttpContent localHttpContent = request.getContent();
    boolean bool1;
    if ((state) && ((localHttpContent == null) || (localHttpContent.retrySupported()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (localHttpUnsuccessfulResponseHandler != null) {
      bool2 = localHttpUnsuccessfulResponseHandler.handleResponse(request, paramHttpResponse, bool1);
    } else {
      bool2 = false;
    }
    paramInt = i;
    if (!bool2) {
      if (request.handleRedirect(paramHttpResponse.getStatusCode(), paramHttpResponse.getHeaders()))
      {
        paramInt = 1;
      }
      else
      {
        paramInt = i;
        if (bool1)
        {
          paramInt = i;
          if (localBackOffPolicy != null)
          {
            paramInt = i;
            if (localBackOffPolicy.isBackOffRequired(paramHttpResponse.getStatusCode()))
            {
              k = true;
              paramInt = i;
            }
          }
        }
      }
    }
    if ((bool1) && ((bool2) || (k) || (paramInt != 0)))
    {
      c.add(paramItem);
      return;
    }
    if (localRequest == null) {
      return;
    }
    localRequest.onSuccess(get(index, paramHttpResponse, paramItem), localHttpHeaders);
  }
  
  public static InputStream get(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = j;
    if (j > 0)
    {
      i = j;
      if (paramArrayOfByte[(j - 1)] == 10) {
        i = j - 1;
      }
    }
    j = i;
    if (i > 0)
    {
      j = i;
      if (paramArrayOfByte[(i - 1)] == 13) {
        j = i - 1;
      }
    }
    return new ByteArrayInputStream(paramArrayOfByte, 0, j);
  }
  
  private Object get(Class paramClass, HttpResponse paramHttpResponse, Item paramItem)
    throws IOException
  {
    if (paramClass == Void.class) {
      return null;
    }
    return request.getParser().parseAndClose(paramHttpResponse.getContent(), paramHttpResponse.getContentCharset(), paramClass);
  }
  
  private String get()
    throws IOException
  {
    int j = buffer.read();
    int i = j;
    if (j == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    while (i != -1)
    {
      localStringBuilder.append((char)i);
      if (i == 10) {
        break;
      }
      i = buffer.read();
    }
    return localStringBuilder.toString();
  }
  
  private String getTags()
    throws IOException
  {
    return toString(get());
  }
  
  private void put(String paramString)
    throws IOException
  {
    if (paramString.equals(String.valueOf(index).concat("--")))
    {
      p = false;
      buffer.close();
    }
  }
  
  public static String toString(String paramString)
  {
    if (paramString.endsWith("\r\n")) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.format(paramString, -2, 0);
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = f.sufficientlysecure.rootcommands.util.StringBuilder.format(paramString, -1, 0);
    }
    return str;
  }
  
  public void parse()
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a18 = a17\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
}
