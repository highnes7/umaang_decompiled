package f.g.org.org.org.client;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.AbstractInputStreamContent;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.EmptyContent;
import f.g.org.org.http.GZipEncoding;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpContent;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.MultipartContent;
import f.g.org.org.org.Request;
import f.g.org.org.util.Context;
import f.g.org.org.util.GenericData;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class Buffer
{
  public static final int DEFAULT_CAPACITY = 1024;
  public static final String EVENTS = "X-Upload-Content-Length";
  public static final int IMMUTABLE = 10485760;
  public static final int MB = 1048576;
  public static final int TYPE_GESTURE_DETECTION_START = 262144;
  public static final String shortName = "X-Upload-Content-Type";
  public ByteArrayBuffer buf;
  public Element buffer = Element.a;
  public final HttpTransport bytes;
  public HttpRequest context;
  public Byte count;
  public String data = "POST";
  public long head;
  public byte[] index;
  public InputStream inputStream;
  public boolean isDisplayed;
  public int length = 10485760;
  public boolean mLoaded;
  public long mValue;
  public HttpHeaders name = new HttpHeaders();
  public String offset = "*";
  public int pos;
  public HttpContent position;
  public boolean s;
  public final HttpRequestFactory size;
  public final AbstractInputStreamContent this$0;
  public Context topic = Context.c;
  public long value;
  
  public Buffer(AbstractInputStreamContent paramAbstractInputStreamContent, HttpTransport paramHttpTransport, AnnotationVisitor paramAnnotationVisitor)
  {
    if (paramAbstractInputStreamContent != null)
    {
      this$0 = paramAbstractInputStreamContent;
      if (paramHttpTransport != null)
      {
        bytes = paramHttpTransport;
        if (paramAnnotationVisitor == null) {
          paramAbstractInputStreamContent = paramHttpTransport.createRequestFactory();
        } else {
          paramAbstractInputStreamContent = paramHttpTransport.createRequestFactory(paramAnnotationVisitor);
        }
        size = paramAbstractInputStreamContent;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  private HttpResponse execute(GenericUrl paramGenericUrl)
    throws IOException
  {
    paramGenericUrl = read(paramGenericUrl);
    if (!paramGenericUrl.isSuccessStatusCode()) {
      return paramGenericUrl;
    }
    try
    {
      Object localObject = new GenericUrl(paramGenericUrl.getHeaders().getLocation());
      paramGenericUrl.disconnect();
      inputStream = this$0.getInputStream();
      paramGenericUrl = (GenericUrl)localObject;
      if (!inputStream.markSupported())
      {
        paramGenericUrl = (GenericUrl)localObject;
        if (isEmpty())
        {
          inputStream = new BufferedInputStream(inputStream);
          paramGenericUrl = (GenericUrl)localObject;
        }
      }
      for (;;)
      {
        context = size.buildRequest(paramGenericUrl, null);
        read();
        new Credential(this, context);
        if (isEmpty()) {
          localObject = execute(context);
        } else {
          localObject = get(context);
        }
        long l1;
        long l3;
        try
        {
          boolean bool1 = ((HttpResponse)localObject).isSuccessStatusCode();
          if (bool1)
          {
            value = getValue();
            bool1 = this$0.getCloseInputStream();
            if (bool1) {
              inputStream.close();
            }
            write(Element.name);
            return localObject;
          }
          int i = ((HttpResponse)localObject).getStatusCode();
          if (i != 308) {
            return localObject;
          }
          String str = ((HttpResponse)localObject).getHeaders().getLocation();
          if (str != null) {
            paramGenericUrl = new GenericUrl(str);
          }
          l1 = read(((HttpResponse)localObject).getHeaders().remove());
          long l2 = value;
          l2 = l1 - l2;
          boolean bool2 = true;
          if (l2 >= 0L)
          {
            l3 = pos;
            if (l2 <= l3)
            {
              bool1 = true;
              break label294;
            }
          }
          bool1 = false;
          label294:
          Preconditions.set(bool1);
          l3 = pos;
          l3 -= l2;
          bool1 = isEmpty();
          if (bool1)
          {
            if (l3 <= 0L) {
              break label385;
            }
            inputStream.reset();
            l3 = inputStream.skip(l2);
            if (l2 == l3) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            Preconditions.set(bool1);
          }
        }
        catch (Throwable paramGenericUrl)
        {
          break;
        }
        if (l3 == 0L) {
          index = null;
        }
        label385:
        value = l1;
        write(Element.size);
        ((HttpResponse)localObject).disconnect();
      }
      ((HttpResponse)localObject).disconnect();
      throw paramGenericUrl;
    }
    catch (Throwable localThrowable)
    {
      paramGenericUrl.disconnect();
      throw localThrowable;
    }
  }
  
  private HttpResponse execute(HttpRequest paramHttpRequest)
    throws IOException
  {
    new Request().intercept(paramHttpRequest);
    paramHttpRequest.setThrowExceptionOnExecuteError(false);
    return paramHttpRequest.execute();
  }
  
  private HttpResponse get(HttpRequest paramHttpRequest)
    throws IOException
  {
    if ((!isDisplayed) && (!(paramHttpRequest.getContent() instanceof EmptyContent))) {
      paramHttpRequest.setEncoding(new GZipEncoding());
    }
    return execute(paramHttpRequest);
  }
  
  private long getValue()
    throws IOException
  {
    if (!mLoaded)
    {
      mValue = this$0.getLength();
      mLoaded = true;
    }
    return mValue;
  }
  
  private boolean isEmpty()
    throws IOException
  {
    return getValue() >= 0L;
  }
  
  private HttpResponse put(GenericUrl paramGenericUrl)
    throws IOException
  {
    write(Element.size);
    Object localObject = this$0;
    if (position != null)
    {
      localObject = new MultipartContent().setContentParts(Arrays.asList(new HttpContent[] { position, this$0 }));
      paramGenericUrl.put("uploadType", "multipart");
    }
    else
    {
      paramGenericUrl.put("uploadType", "media");
    }
    paramGenericUrl = size.buildRequest(data, paramGenericUrl, (HttpContent)localObject);
    paramGenericUrl.getHeaders().putAll(name);
    paramGenericUrl = get(paramGenericUrl);
    try
    {
      boolean bool = isEmpty();
      if (bool) {
        value = getValue();
      }
      write(Element.name);
      return paramGenericUrl;
    }
    catch (Throwable localThrowable)
    {
      paramGenericUrl.disconnect();
      throw localThrowable;
    }
  }
  
  private long read(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    return Long.parseLong(paramString.substring(paramString.indexOf('-') + 1)) + 1L;
  }
  
  private HttpResponse read(GenericUrl paramGenericUrl)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private void read()
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a25 = a24\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private void write(Element paramElement)
    throws IOException
  {
    buffer = paramElement;
    paramElement = buf;
    if (paramElement != null) {
      paramElement.remove(this);
    }
  }
  
  public Buffer append(int paramInt)
  {
    boolean bool;
    if ((paramInt > 0) && (paramInt % 262144 == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "chunkSize must be a positive multiple of 262144.");
    length = paramInt;
    return this;
  }
  
  public Buffer append(HttpHeaders paramHttpHeaders)
  {
    name = paramHttpHeaders;
    return this;
  }
  
  public Buffer append(ByteArrayBuffer paramByteArrayBuffer)
  {
    buf = paramByteArrayBuffer;
    return this;
  }
  
  public Buffer append(boolean paramBoolean)
  {
    isDisplayed = paramBoolean;
    return this;
  }
  
  public void create()
    throws IOException
  {
    Preconditions.checkNotNull(context, "The current request should not be null");
    context.setContent(new EmptyContent());
    HttpHeaders localHttpHeaders = context.getHeaders();
    if (isEmpty()) {
      localObject = Long.valueOf(getValue());
    } else {
      localObject = "*";
    }
    Object localObject = String.valueOf(localObject);
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 8);
    localStringBuilder.append("bytes */");
    localStringBuilder.append((String)localObject);
    localHttpHeaders.setContentRange(localStringBuilder.toString());
  }
  
  public String encode()
  {
    return data;
  }
  
  public ByteArrayBuffer getByte()
  {
    return buf;
  }
  
  public Element getCommand()
  {
    return buffer;
  }
  
  public boolean getOffSet()
  {
    return s;
  }
  
  public HttpHeaders getShortName()
  {
    return name;
  }
  
  public Context getTopic()
  {
    return topic;
  }
  
  public boolean isDisplayed()
  {
    return isDisplayed;
  }
  
  public HttpTransport readByte()
  {
    return bytes;
  }
  
  public long readLong()
  {
    return value;
  }
  
  public HttpContent readShort()
  {
    return position;
  }
  
  public int size()
  {
    return length;
  }
  
  public HttpContent timeout()
  {
    return this$0;
  }
  
  public double write()
    throws IOException
  {
    Preconditions.checkArgument(isEmpty(), "Cannot call getProgress() if the specified AbstractInputStreamContent has no content length. Use  getNumBytesUploaded() to denote progress instead.");
    if (getValue() == 0L) {
      return 0.0D;
    }
    double d1 = value;
    double d2 = getValue();
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public HttpResponse write(GenericUrl paramGenericUrl)
    throws IOException
  {
    boolean bool;
    if (buffer == Element.a) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    if (s) {
      return put(paramGenericUrl);
    }
    return execute(paramGenericUrl);
  }
  
  public Buffer write(HttpContent paramHttpContent)
  {
    position = paramHttpContent;
    return this;
  }
  
  public Buffer write(Context paramContext)
  {
    topic = paramContext;
    return this;
  }
  
  public Buffer write(String paramString)
  {
    boolean bool;
    if ((!paramString.equals("POST")) && (!paramString.equals("PUT"))) {
      bool = false;
    } else {
      bool = true;
    }
    Preconditions.append(bool);
    data = paramString;
    return this;
  }
  
  public Buffer write(boolean paramBoolean)
  {
    s = paramBoolean;
    return this;
  }
}
