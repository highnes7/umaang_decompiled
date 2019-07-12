package f.g.org.org.http;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.Context;
import f.g.org.org.util.ObjectParser;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class HttpRequest
{
  public static final String BOUNDARY = "1.20.0";
  public static final String METHOD_DELETE = "Google-HTTP-Java-Client/1.20.0 (gzip)";
  @Deprecated
  @h
  public BackOffPolicy backOffPolicy;
  public int connectTimeout = 20000;
  public HttpContent content;
  public int contentLoggingLimit = 16384;
  public boolean curlLoggingEnabled = true;
  public HttpEncoding encoding;
  public Object executeInterceptor;
  public boolean followRedirects = true;
  public HttpHeaders headers = new HttpHeaders();
  @h
  public HttpIOExceptionHandler ioExceptionHandler;
  public boolean loggingEnabled = true;
  public int numRetries = 10;
  public ObjectParser objectParser;
  public int readTimeout = 20000;
  public String requestMethod;
  public HttpHeaders responseHeaders = new HttpHeaders();
  public HttpResponseInterceptor responseInterceptor;
  @Deprecated
  @h
  public boolean retryOnExecuteIOException = false;
  public Context sleeper = Context.c;
  public boolean suppressUserAgentSuffix;
  public boolean throwExceptionOnExecuteError = true;
  public final HttpTransport transport;
  public HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
  public GenericUrl url;
  
  public HttpRequest(HttpTransport paramHttpTransport, String paramString)
  {
    transport = paramHttpTransport;
    setRequestMethod(paramString);
  }
  
  public HttpResponse execute()
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a20 = a19\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public Future executeAsync()
  {
    return executeAsync(Executors.newSingleThreadExecutor());
  }
  
  public Future executeAsync(Executor paramExecutor)
  {
    FutureTask localFutureTask = new FutureTask(new HttpRequest.1(this));
    paramExecutor.execute(localFutureTask);
    return localFutureTask;
  }
  
  public BackOffPolicy getBackOffPolicy()
  {
    return backOffPolicy;
  }
  
  public int getConnectTimeout()
  {
    return connectTimeout;
  }
  
  public HttpContent getContent()
  {
    return content;
  }
  
  public int getContentLoggingLimit()
  {
    return contentLoggingLimit;
  }
  
  public HttpEncoding getEncoding()
  {
    return encoding;
  }
  
  public boolean getFollowRedirects()
  {
    return followRedirects;
  }
  
  public HttpHeaders getHeaders()
  {
    return headers;
  }
  
  public HttpIOExceptionHandler getIOExceptionHandler()
  {
    return ioExceptionHandler;
  }
  
  public Object getInterceptor()
  {
    return executeInterceptor;
  }
  
  public int getNumberOfRetries()
  {
    return numRetries;
  }
  
  public final ObjectParser getParser()
  {
    return objectParser;
  }
  
  public int getReadTimeout()
  {
    return readTimeout;
  }
  
  public String getRequestMethod()
  {
    return requestMethod;
  }
  
  public HttpHeaders getResponseHeaders()
  {
    return responseHeaders;
  }
  
  public HttpResponseInterceptor getResponseInterceptor()
  {
    return responseInterceptor;
  }
  
  public boolean getRetryOnExecuteIOException()
  {
    return retryOnExecuteIOException;
  }
  
  public Context getSleeper()
  {
    return sleeper;
  }
  
  public boolean getSuppressUserAgentSuffix()
  {
    return suppressUserAgentSuffix;
  }
  
  public boolean getThrowExceptionOnExecuteError()
  {
    return throwExceptionOnExecuteError;
  }
  
  public HttpTransport getTransport()
  {
    return transport;
  }
  
  public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler()
  {
    return unsuccessfulResponseHandler;
  }
  
  public GenericUrl getUrl()
  {
    return url;
  }
  
  public boolean handleRedirect(int paramInt, HttpHeaders paramHttpHeaders)
  {
    paramHttpHeaders = paramHttpHeaders.getLocation();
    if ((getFollowRedirects()) && (HttpStatus.isRedirect(paramInt)) && (paramHttpHeaders != null))
    {
      setUrl(new GenericUrl(url.toURL(paramHttpHeaders)));
      if (paramInt == 303)
      {
        setRequestMethod("GET");
        setContent(null);
      }
      headers.setAuthorization(null);
      headers.setIfMatch(null);
      headers.setIfNoneMatch(null);
      headers.setIfModifiedSince(null);
      headers.setIfUnmodifiedSince(null);
      headers.setIfRange(null);
      return true;
    }
    return false;
  }
  
  public boolean isCurlLoggingEnabled()
  {
    return curlLoggingEnabled;
  }
  
  public boolean isLoggingEnabled()
  {
    return loggingEnabled;
  }
  
  public HttpRequest setBackOffPolicy(BackOffPolicy paramBackOffPolicy)
  {
    backOffPolicy = paramBackOffPolicy;
    return this;
  }
  
  public HttpRequest setConnectTimeout(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    connectTimeout = paramInt;
    return this;
  }
  
  public HttpRequest setContent(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    numRetries = paramInt;
    return this;
  }
  
  public HttpRequest setContent(HttpContent paramHttpContent)
  {
    content = paramHttpContent;
    return this;
  }
  
  public HttpRequest setContent(HttpHeaders paramHttpHeaders)
  {
    if (paramHttpHeaders != null)
    {
      responseHeaders = paramHttpHeaders;
      return this;
    }
    throw new NullPointerException();
  }
  
  public HttpRequest setContentLoggingLimit(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "The content logging limit must be non-negative.");
    contentLoggingLimit = paramInt;
    return this;
  }
  
  public HttpRequest setCurlLoggingEnabled(boolean paramBoolean)
  {
    curlLoggingEnabled = paramBoolean;
    return this;
  }
  
  public HttpRequest setEncoding(HttpEncoding paramHttpEncoding)
  {
    encoding = paramHttpEncoding;
    return this;
  }
  
  public HttpRequest setEncoding(Context paramContext)
  {
    if (paramContext != null)
    {
      sleeper = paramContext;
      return this;
    }
    throw new NullPointerException();
  }
  
  public HttpRequest setFollowRedirects(boolean paramBoolean)
  {
    followRedirects = paramBoolean;
    return this;
  }
  
  public HttpRequest setHeaders(HttpHeaders paramHttpHeaders)
  {
    if (paramHttpHeaders != null)
    {
      headers = paramHttpHeaders;
      return this;
    }
    throw new NullPointerException();
  }
  
  public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler paramHttpIOExceptionHandler)
  {
    ioExceptionHandler = paramHttpIOExceptionHandler;
    return this;
  }
  
  public HttpRequest setInterceptor(Object paramObject)
  {
    executeInterceptor = paramObject;
    return this;
  }
  
  public HttpRequest setLoggingEnabled(boolean paramBoolean)
  {
    loggingEnabled = paramBoolean;
    return this;
  }
  
  public HttpRequest setParser(ObjectParser paramObjectParser)
  {
    objectParser = paramObjectParser;
    return this;
  }
  
  public HttpRequest setReadTimeout(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    readTimeout = paramInt;
    return this;
  }
  
  public HttpRequest setRequestMethod(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (!HttpMediaType.matchesToken(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    Preconditions.append(bool);
    requestMethod = paramString;
    return this;
  }
  
  public HttpRequest setResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor)
  {
    responseInterceptor = paramHttpResponseInterceptor;
    return this;
  }
  
  public HttpRequest setRetryOnExecuteIOException(boolean paramBoolean)
  {
    retryOnExecuteIOException = paramBoolean;
    return this;
  }
  
  public HttpRequest setSuppressUserAgentSuffix(boolean paramBoolean)
  {
    suppressUserAgentSuffix = paramBoolean;
    return this;
  }
  
  public HttpRequest setThrowExceptionOnExecuteError(boolean paramBoolean)
  {
    throwExceptionOnExecuteError = paramBoolean;
    return this;
  }
  
  public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler paramHttpUnsuccessfulResponseHandler)
  {
    unsuccessfulResponseHandler = paramHttpUnsuccessfulResponseHandler;
    return this;
  }
  
  public HttpRequest setUrl(GenericUrl paramGenericUrl)
  {
    if (paramGenericUrl != null)
    {
      url = paramGenericUrl;
      return this;
    }
    throw new NullPointerException();
  }
}
