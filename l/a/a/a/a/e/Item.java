package l.a.a.a.a.e;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;

public class Item
{
  public static final String ACCEPT = "Accept";
  public static final String ACCEPT_CHARSET = "Accept-Charset";
  public static final String ACCEPT_ENCODING = "Accept-Encoding";
  public static final String AUTHORIZATION = "Authorization";
  public static final String CONTENT_ENCODING = "Content-Encoding";
  public static final String CONTENT_LENGTH = "Content-Length";
  public static final String DATE = "Date";
  public static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
  public static final String DELETE_METHOD = "DELETE";
  public static final String DUE_DATE_FORMAT = "application/json";
  public static final String ETAG = "ETag";
  public static final String EXPIRES = "Expires";
  public static final String FORM_ENCODED = "application/x-www-form-urlencoded";
  public static final String GET_METHOD = "GET";
  public static final String GZIP_CODEC = "gzip";
  public static final String HEADER_CONTENT_TYPE = "Content-Type";
  public static final String HEAD_METHOD = "HEAD";
  public static final String IF_NONE_MATCH = "If-None-Match";
  public static final String LAST_MODIFIED = "Last-Modified";
  public static final String METHOD_NAME = "POST";
  public static final String OPTIONS_METHOD = "OPTIONS";
  public static final String PARAM_CHARSET = "charset";
  public static final String PROXY_AUTH_RESP = "Proxy-Authorization";
  public static final String PUT_METHOD = "PUT";
  public static final String REFERER = "Referer";
  public static final String SERVER = "Server";
  public static final String TAG = "Location";
  public static final String TRACE_METHOD = "TRACE";
  public static final String USER_AGENT = "User-Agent";
  public static m.c c = m.c.a;
  public static final String[] d = new String[0];
  public static final String i = "Cache-Control";
  public static final String mTag = "00content0boundary00";
  public static final String strVal1 = "multipart/form-data; boundary=00content0boundary00";
  public static final String strVal2 = "\r\n";
  public boolean M = true;
  public boolean N = false;
  public int a = 8192;
  public boolean b;
  public HttpURLConnection conn = null;
  public int g;
  public String h;
  public final URL j;
  public final String k;
  public boolean multipart;
  public m.g output;
  
  public Item(CharSequence paramCharSequence, String paramString)
    throws m.e
  {
    try
    {
      paramCharSequence = new URL(paramCharSequence.toString());
      j = paramCharSequence;
      k = paramString;
      return;
    }
    catch (MalformedURLException paramCharSequence)
    {
      throw ((Throwable)new m.e(paramCharSequence));
    }
  }
  
  public Item(URL paramURL, String paramString)
    throws m.e
  {
    j = paramURL;
    k = paramString;
  }
  
  public static Item a(CharSequence paramCharSequence)
    throws m.e
  {
    return new Item(paramCharSequence, "HEAD");
  }
  
  public static Item a(CharSequence paramCharSequence, Map paramMap, boolean paramBoolean)
  {
    paramMap = append(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = encode(paramMap);
    }
    return b(paramCharSequence);
  }
  
  public static Item a(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = append(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = encode(paramVarArgs);
    }
    return b(paramCharSequence);
  }
  
  public static Item a(URL paramURL)
    throws m.e
  {
    return new Item(paramURL, "HEAD");
  }
  
  public static Item add(CharSequence paramCharSequence, Map paramMap, boolean paramBoolean)
  {
    paramMap = append(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = encode(paramMap);
    }
    return a(paramCharSequence);
  }
  
  public static Item add(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = append(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = encode(paramVarArgs);
    }
    return a(paramCharSequence);
  }
  
  public static StringBuilder addParamPrefix(String paramString, StringBuilder paramStringBuilder)
  {
    int m = paramString.indexOf('?');
    int n = paramStringBuilder.length() - 1;
    if (m == -1)
    {
      paramStringBuilder.append('?');
      return paramStringBuilder;
    }
    if ((m < n) && (paramString.charAt(n) != '&')) {
      paramStringBuilder.append('&');
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder addPathSeparator(String paramString, StringBuilder paramStringBuilder)
  {
    if (paramString.indexOf(':') + 2 == paramString.lastIndexOf('/')) {
      paramStringBuilder.append('/');
    }
    return paramStringBuilder;
  }
  
  public static String append(CharSequence paramCharSequence, Map paramMap)
  {
    Object localObject = paramCharSequence.toString();
    paramCharSequence = (CharSequence)localObject;
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return localObject;
      }
      paramCharSequence = new StringBuilder((String)localObject);
      addPathSeparator((String)localObject, paramCharSequence);
      addParamPrefix((String)localObject, paramCharSequence);
      paramMap = paramMap.entrySet().iterator();
      localObject = (Map.Entry)paramMap.next();
      paramCharSequence.append(((Map.Entry)localObject).getKey().toString());
      paramCharSequence.append('=');
      localObject = ((Map.Entry)localObject).getValue();
      if (localObject != null) {
        paramCharSequence.append(localObject);
      }
      while (paramMap.hasNext())
      {
        paramCharSequence.append('&');
        localObject = (Map.Entry)paramMap.next();
        paramCharSequence.append(((Map.Entry)localObject).getKey().toString());
        paramCharSequence.append('=');
        localObject = ((Map.Entry)localObject).getValue();
        if (localObject != null) {
          paramCharSequence.append(localObject);
        }
      }
      paramCharSequence = paramCharSequence.toString();
    }
    return paramCharSequence;
  }
  
  public static String append(CharSequence paramCharSequence, Object... paramVarArgs)
  {
    Object localObject = paramCharSequence.toString();
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return localObject;
      }
      int m = paramVarArgs.length;
      int n = 2;
      if (m % 2 == 0)
      {
        paramCharSequence = new StringBuilder((String)localObject);
        addPathSeparator((String)localObject, paramCharSequence);
        addParamPrefix((String)localObject, paramCharSequence);
        paramCharSequence.append(paramVarArgs[0]);
        paramCharSequence.append('=');
        localObject = paramVarArgs[1];
        m = n;
        if (localObject != null)
        {
          paramCharSequence.append(localObject);
          m = n;
        }
        while (m < paramVarArgs.length)
        {
          paramCharSequence.append('&');
          paramCharSequence.append(paramVarArgs[m]);
          paramCharSequence.append('=');
          localObject = paramVarArgs[(m + 1)];
          if (localObject != null) {
            paramCharSequence.append(localObject);
          }
          m += 2;
        }
        return paramCharSequence.toString();
      }
      throw new IllegalArgumentException("Must specify an even number of parameter names/values");
    }
    return localObject;
  }
  
  private HttpURLConnection b()
  {
    Object localObject1;
    Object localObject2;
    if (h != null)
    {
      localObject1 = c;
      localObject2 = j;
    }
    try
    {
      localObject1 = ((m.c)localObject1).a((URL)localObject2, init());
      break label48;
      localObject1 = c;
      localObject2 = j;
      localObject1 = ((m.c)localObject1).a((URL)localObject2);
      label48:
      localObject2 = k;
      ((HttpURLConnection)localObject1).setRequestMethod((String)localObject2);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      throw ((Throwable)new m.e(localIOException));
    }
  }
  
  public static Item b(CharSequence paramCharSequence)
    throws m.e
  {
    return new Item(paramCharSequence, "PUT");
  }
  
  public static Item build(CharSequence paramCharSequence)
    throws m.e
  {
    return new Item(paramCharSequence, "POST");
  }
  
  public static Item build(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = append(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = encode(paramVarArgs);
    }
    return build(paramCharSequence);
  }
  
  public static Item build(URL paramURL)
    throws m.e
  {
    return new Item(paramURL, "PUT");
  }
  
  public static String encode(CharSequence paramCharSequence)
    throws m.e
  {
    try
    {
      URL localURL = new URL(paramCharSequence.toString());
      Object localObject = localURL.getHost();
      paramCharSequence = (CharSequence)localObject;
      int m = localURL.getPort();
      if (m != -1)
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append((String)localObject);
        paramCharSequence.append(':');
        paramCharSequence.append(Integer.toString(m));
        paramCharSequence = paramCharSequence.toString();
      }
      try
      {
        paramCharSequence = new URI(localURL.getProtocol(), paramCharSequence, localURL.getPath(), localURL.getQuery(), localURL.getRef()).toASCIIString();
        m = paramCharSequence.indexOf('?');
        if (m > 0)
        {
          m += 1;
          int n = paramCharSequence.length();
          if (m < n)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramCharSequence.substring(0, m));
            ((StringBuilder)localObject).append(paramCharSequence.substring(m).replace("+", "%2B").replace("#", "%23"));
            paramCharSequence = ((StringBuilder)localObject).toString();
            return paramCharSequence;
          }
        }
      }
      catch (URISyntaxException paramCharSequence)
      {
        localObject = new IOException("Parsing URI failed");
        ((IOException)localObject).initCause(paramCharSequence);
        throw ((Throwable)new m.e((IOException)localObject));
      }
      return paramCharSequence;
    }
    catch (IOException paramCharSequence)
    {
      throw ((Throwable)new m.e(paramCharSequence));
    }
  }
  
  public static Item get(CharSequence paramCharSequence)
    throws m.e
  {
    return new Item(paramCharSequence, "GET");
  }
  
  public static Item get(CharSequence paramCharSequence, Map paramMap, boolean paramBoolean)
  {
    paramMap = append(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = encode(paramMap);
    }
    return toString(paramCharSequence);
  }
  
  public static Item get(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = append(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = encode(paramVarArgs);
    }
    return toString(paramCharSequence);
  }
  
  public static Item get(URL paramURL)
    throws m.e
  {
    return new Item(paramURL, "TRACE");
  }
  
  public static String getValidCharset(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return "UTF-8";
  }
  
  private Proxy init()
  {
    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(h, g));
  }
  
  public static Item load(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = append(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = encode(paramVarArgs);
    }
    return get(paramCharSequence);
  }
  
  public static Item load(URL paramURL)
    throws m.e
  {
    return new Item(paramURL, "GET");
  }
  
  public static void nonProxyHosts(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int n = paramVarArgs.length - 1;
      int m = 0;
      while (m < n)
      {
        localStringBuilder.append(paramVarArgs[m]);
        localStringBuilder.append('|');
        m += 1;
      }
      localStringBuilder.append(paramVarArgs[n]);
      setProperty("http.nonProxyHosts", localStringBuilder.toString());
      return;
    }
    setProperty("http.nonProxyHosts", null);
  }
  
  public static void proxyHost(String paramString)
  {
    setProperty("http.proxyHost", paramString);
    setProperty("https.proxyHost", paramString);
  }
  
  public static void proxyPort(int paramInt)
  {
    String str = Integer.toString(paramInt);
    setProperty("http.proxyPort", str);
    setProperty("https.proxyPort", str);
  }
  
  public static Item read(CharSequence paramCharSequence, Map paramMap, boolean paramBoolean)
  {
    paramMap = append(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = encode(paramMap);
    }
    return get(paramCharSequence);
  }
  
  public static Item send(URL paramURL)
    throws m.e
  {
    return new Item(paramURL, "POST");
  }
  
  public static void send(boolean paramBoolean)
  {
    setProperty("http.keepAlive", Boolean.toString(paramBoolean));
  }
  
  public static Item setDescription(CharSequence paramCharSequence)
    throws m.e
  {
    return new Item(paramCharSequence, "TRACE");
  }
  
  public static Item setId(CharSequence paramCharSequence)
    throws m.e
  {
    return new Item(paramCharSequence, "OPTIONS");
  }
  
  public static Item setId(URL paramURL)
    throws m.e
  {
    return new Item(paramURL, "OPTIONS");
  }
  
  public static void setKey(m.c paramC)
  {
    if (paramC == null)
    {
      c = m.c.a;
      return;
    }
    c = paramC;
  }
  
  public static String setProperty(String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a3 = a2\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static Item toString(CharSequence paramCharSequence)
    throws m.e
  {
    return new Item(paramCharSequence, "DELETE");
  }
  
  public static Item toString(CharSequence paramCharSequence, Map paramMap, boolean paramBoolean)
  {
    paramMap = append(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = encode(paramMap);
    }
    return build(paramCharSequence);
  }
  
  public static Item toString(URL paramURL)
    throws m.e
  {
    return new Item(paramURL, "DELETE");
  }
  
  public Item a()
  {
    getConnection().disconnect();
    return this;
  }
  
  public Item a(int paramInt)
  {
    if (paramInt >= 1)
    {
      a = paramInt;
      return this;
    }
    throw new IllegalArgumentException("Size must be greater than zero");
  }
  
  public Item a(File paramFile)
    throws m.e
  {
    try
    {
      paramFile = new BufferedInputStream(new FileInputStream(paramFile));
      return a(paramFile);
    }
    catch (FileNotFoundException paramFile)
    {
      throw ((Throwable)new m.e(paramFile));
    }
  }
  
  public Item a(InputStream paramInputStream)
    throws m.e
  {
    try
    {
      openOutput();
      OutputStream localOutputStream = (OutputStream)output;
      read(paramInputStream, localOutputStream);
      return this;
    }
    catch (IOException paramInputStream)
    {
      throw ((Throwable)new m.e(paramInputStream));
    }
  }
  
  public Item a(OutputStream paramOutputStream)
    throws m.e
  {
    try
    {
      paramOutputStream = read(read(), paramOutputStream);
      return paramOutputStream;
    }
    catch (IOException paramOutputStream)
    {
      throw ((Throwable)new m.e(paramOutputStream));
    }
  }
  
  public Item a(PrintStream paramPrintStream)
    throws m.e
  {
    return a(paramPrintStream);
  }
  
  public Item a(Writer paramWriter)
    throws m.e
  {
    BufferedReader localBufferedReader = bufferedReader();
    return (Item)new i(this, localBufferedReader, M, localBufferedReader, paramWriter).call();
  }
  
  public Item a(Appendable paramAppendable)
    throws m.e
  {
    BufferedReader localBufferedReader = bufferedReader();
    return (Item)new h(this, localBufferedReader, M, localBufferedReader, paramAppendable).call();
  }
  
  public Item a(Object paramObject1, Object paramObject2)
    throws m.e
  {
    return a(paramObject1, paramObject2, "UTF-8");
  }
  
  public Item a(Object paramObject1, Object paramObject2, String paramString)
    throws m.e
  {
    boolean bool = b ^ true;
    if (bool)
    {
      contentType("application/x-www-form-urlencoded", paramString);
      b = true;
    }
    paramString = getValidCharset(paramString);
    try
    {
      openOutput();
      if (!bool)
      {
        localObject = (BufferedOutputStream)output;
        ((BufferedOutputStream)localObject).write(38);
      }
      Object localObject = output;
      ((m.g)localObject).b(URLEncoder.encode(paramObject1.toString(), paramString));
      paramObject1 = (BufferedOutputStream)output;
      paramObject1.write(61);
      if (paramObject2 != null)
      {
        paramObject1 = output;
        paramObject1.b(URLEncoder.encode(paramObject2.toString(), paramString));
        return this;
      }
    }
    catch (IOException paramObject1)
    {
      throw ((Throwable)new m.e(paramObject1));
    }
    return this;
  }
  
  public Item a(String paramString, int paramInt)
  {
    if (conn == null)
    {
      h = paramString;
      g = paramInt;
      return this;
    }
    throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
  }
  
  public Item a(String paramString, File paramFile)
    throws m.e
  {
    return a(paramString, null, paramFile);
  }
  
  public Item a(String paramString, InputStream paramInputStream)
    throws m.e
  {
    return a(paramString, null, null, paramInputStream);
  }
  
  public Item a(String paramString, Number paramNumber)
  {
    if (paramNumber != null) {
      paramNumber = paramNumber.toString();
    } else {
      paramNumber = null;
    }
    return get(paramString, paramNumber);
  }
  
  public Item a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Basic ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString1);
    localStringBuilder2.append(':');
    localStringBuilder2.append(paramString2);
    localStringBuilder1.append(m.a.a(localStringBuilder2.toString()));
    return c(localStringBuilder1.toString());
  }
  
  public Item a(String paramString1, String paramString2, File paramFile)
    throws m.e
  {
    return a(paramString1, paramString2, null, paramFile);
  }
  
  public Item a(String paramString1, String paramString2, Number paramNumber)
    throws m.e
  {
    if (paramNumber != null) {
      paramNumber = paramNumber.toString();
    } else {
      paramNumber = null;
    }
    return a(paramString1, paramString2, paramNumber);
  }
  
  public Item a(String paramString1, String paramString2, String paramString3)
    throws m.e
  {
    return a(paramString1, paramString2, null, paramString3);
  }
  
  /* Error */
  public Item a(String paramString1, String paramString2, String paramString3, File paramFile)
    throws m.e
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 441	java/io/BufferedInputStream
    //   9: dup
    //   10: new 443	java/io/FileInputStream
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 446	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 449	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore 4
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: aload_3
    //   28: aload 4
    //   30: invokevirtual 528	l/a/a/a/a/e/Item:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)Ll/a/a/a/a/e/Item;
    //   33: astore_1
    //   34: aload 4
    //   36: invokevirtual 556	java/io/BufferedInputStream:close	()V
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: aload 4
    //   44: astore 5
    //   46: goto +32 -> 78
    //   49: astore_1
    //   50: aload 4
    //   52: astore 5
    //   54: goto +12 -> 66
    //   57: astore_1
    //   58: goto +20 -> 78
    //   61: astore_1
    //   62: aload 6
    //   64: astore 5
    //   66: new 141	l/a/a/a/a/e/m$e
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 171	l/a/a/a/a/e/m$e:<init>	(Ljava/io/IOException;)V
    //   74: checkcast 173	java/lang/Throwable
    //   77: athrow
    //   78: aload 5
    //   80: ifnull +8 -> 88
    //   83: aload 5
    //   85: invokevirtual 556	java/io/BufferedInputStream:close	()V
    //   88: aload_1
    //   89: athrow
    //   90: astore_2
    //   91: aload_1
    //   92: areturn
    //   93: astore_2
    //   94: goto -6 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	Item
    //   0	97	1	paramString1	String
    //   0	97	2	paramString2	String
    //   0	97	3	paramString3	String
    //   0	97	4	paramFile	File
    //   4	80	5	localObject1	Object
    //   1	62	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	34	41	java/lang/Throwable
    //   24	34	49	java/io/IOException
    //   6	24	57	java/lang/Throwable
    //   66	78	57	java/lang/Throwable
    //   6	24	61	java/io/IOException
    //   34	39	90	java/io/IOException
    //   83	88	93	java/io/IOException
  }
  
  public Item a(String paramString1, String paramString2, String paramString3, InputStream paramInputStream)
    throws m.e
  {
    try
    {
      startPart();
      writePartHeader(paramString1, paramString2, paramString3);
      paramString1 = (OutputStream)output;
      read(paramInputStream, paramString1);
      return this;
    }
    catch (IOException paramString1)
    {
      throw ((Throwable)new m.e(paramString1));
    }
  }
  
  public Item a(String paramString1, String paramString2, String paramString3, String paramString4)
    throws m.e
  {
    try
    {
      startPart();
      writePartHeader(paramString1, paramString2, paramString3);
      paramString1 = output;
      paramString1.b(paramString4);
      return this;
    }
    catch (IOException paramString1)
    {
      throw ((Throwable)new m.e(paramString1));
    }
  }
  
  public Item a(Map.Entry paramEntry)
    throws m.e
  {
    return b(paramEntry, "UTF-8");
  }
  
  public Item a(Map paramMap)
    throws m.e
  {
    return a(paramMap, "UTF-8");
  }
  
  public Item a(Map paramMap, String paramString)
    throws m.e
  {
    if (!paramMap.isEmpty())
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext()) {
        b((Map.Entry)paramMap.next(), paramString);
      }
    }
    return this;
  }
  
  public Item a(boolean paramBoolean)
  {
    getConnection().setUseCaches(paramBoolean);
    return this;
  }
  
  public Item a(byte[] paramArrayOfByte)
    throws m.e
  {
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public String[] a(String paramString)
  {
    Map localMap = headers();
    if ((localMap != null) && (!localMap.isEmpty()))
    {
      paramString = (List)localMap.get(paramString);
      if ((paramString != null) && (!paramString.isEmpty())) {
        return (String[])paramString.toArray(new String[paramString.size()]);
      }
      return d;
    }
    return d;
  }
  
  public Item add(String paramString)
  {
    return get("Accept-Encoding", paramString);
  }
  
  public Item add(String paramString1, String paramString2)
  {
    return a(paramString1, null, paramString2);
  }
  
  public boolean add()
    throws m.e
  {
    return 201 == get();
  }
  
  public Item b(Map.Entry paramEntry, String paramString)
    throws m.e
  {
    return a(paramEntry.getKey(), paramEntry.getValue(), paramString);
  }
  
  public String body()
    throws m.e
  {
    return body(charset());
  }
  
  public String body(String paramString)
    throws m.e
  {
    ByteArrayOutputStream localByteArrayOutputStream = byteStream();
    try
    {
      read(read(), localByteArrayOutputStream);
      paramString = localByteArrayOutputStream.toString(getValidCharset(paramString));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw ((Throwable)new m.e(paramString));
    }
  }
  
  public BufferedReader bufferedReader()
    throws m.e
  {
    return bufferedReader(charset());
  }
  
  public BufferedReader bufferedReader(String paramString)
    throws m.e
  {
    return new BufferedReader(reader(paramString), a);
  }
  
  public Item build()
  {
    return add("gzip");
  }
  
  public Item build(String paramString)
  {
    return load(Integer.parseInt(paramString));
  }
  
  public ByteArrayOutputStream byteStream()
  {
    int m = contentLength();
    if (m > 0) {
      return new ByteArrayOutputStream(m);
    }
    return new ByteArrayOutputStream();
  }
  
  public Item c(String paramString)
  {
    return get("Authorization", paramString);
  }
  
  public Item c(String paramString, Number paramNumber)
    throws m.e
  {
    return a(paramString, null, paramNumber);
  }
  
  public String cacheControl()
  {
    return header("Cache-Control");
  }
  
  public String charset()
  {
    return parameter("Content-Type", "charset");
  }
  
  public Item closeOutput()
    throws IOException
  {
    Object localObject = output;
    if (localObject == null) {
      return this;
    }
    if (multipart) {
      ((m.g)localObject).b("\r\n--00content0boundary00--\r\n");
    }
    if (M) {
      localObject = (BufferedOutputStream)output;
    }
    try
    {
      ((BufferedOutputStream)localObject).close();
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    ((BufferedOutputStream)output).close();
    output = null;
    return this;
  }
  
  public Item closeOutputQuietly()
    throws m.e
  {
    try
    {
      Item localItem = closeOutput();
      return localItem;
    }
    catch (IOException localIOException)
    {
      throw ((Throwable)new m.e(localIOException));
    }
  }
  
  public String contentEncoding()
  {
    return header("Content-Encoding");
  }
  
  public int contentLength()
  {
    return intHeader("Content-Length");
  }
  
  public Item contentType(String paramString)
  {
    return contentType(paramString, null);
  }
  
  public Item contentType(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramString2);
      return get("Content-Type", localStringBuilder.toString());
    }
    return get("Content-Type", paramString1);
  }
  
  public long date()
  {
    return dateHeader("Date");
  }
  
  public long dateHeader(String paramString)
    throws m.e
  {
    return dateHeader(paramString, -1L);
  }
  
  public long dateHeader(String paramString, long paramLong)
    throws m.e
  {
    closeOutputQuietly();
    return getConnection().getHeaderFieldDate(paramString, paramLong);
  }
  
  public String doInBackground()
    throws m.e
  {
    try
    {
      closeOutput();
      String str = getConnection().getResponseMessage();
      return str;
    }
    catch (IOException localIOException)
    {
      throw ((Throwable)new m.e(localIOException));
    }
  }
  
  public String eTag()
  {
    return header("ETag");
  }
  
  public long expires()
  {
    return dateHeader("Expires");
  }
  
  public int get()
    throws m.e
  {
    try
    {
      closeOutput();
      int m = getConnection().getResponseCode();
      return m;
    }
    catch (IOException localIOException)
    {
      throw ((Throwable)new m.e(localIOException));
    }
  }
  
  public Item get(int paramInt)
  {
    getConnection().setConnectTimeout(paramInt);
    return this;
  }
  
  public Item get(File paramFile)
    throws m.e
  {
    try
    {
      paramFile = new FileOutputStream(paramFile);
      int m = a;
      paramFile = new BufferedOutputStream(paramFile, m);
      return (Item)new g(this, paramFile, M, paramFile).call();
    }
    catch (FileNotFoundException paramFile)
    {
      throw ((Throwable)new m.e(paramFile));
    }
  }
  
  public Item get(String paramString)
  {
    return get("Accept", paramString);
  }
  
  public Item get(String paramString1, String paramString2)
  {
    getConnection().setRequestProperty(paramString1, paramString2);
    return this;
  }
  
  public Item get(Map.Entry paramEntry)
  {
    return get((String)paramEntry.getKey(), (String)paramEntry.getValue());
  }
  
  public String getBody()
  {
    return header("Content-Type");
  }
  
  public Map getBody(String paramString)
  {
    return getParams(header(paramString));
  }
  
  public HttpURLConnection getConnection()
  {
    if (conn == null) {
      conn = b();
    }
    return conn;
  }
  
  public Item getItem(String paramString)
  {
    return get("Referer", paramString);
  }
  
  public String getParam(String paramString1, String paramString2)
  {
    String str;
    if (paramString1 != null)
    {
      if (paramString1.length() == 0) {
        return null;
      }
      int i2 = paramString1.length();
      int i1 = paramString1.indexOf(';') + 1;
      if (i1 != 0)
      {
        if (i1 == i2) {
          return null;
        }
        int i3 = paramString1.indexOf(';', i1);
        int m = i3;
        int n = i1;
        if (i3 == -1) {}
        for (n = i1;; n = i1)
        {
          m = i2;
          do
          {
            if (n >= m) {
              break;
            }
            i1 = paramString1.indexOf('=', n);
            if ((i1 != -1) && (i1 < m) && (paramString2.equals(paramString1.substring(n, i1).trim())))
            {
              str = paramString1.substring(i1 + 1, m).trim();
              n = str.length();
              if (n != 0)
              {
                if (n > 2)
                {
                  if ('"' != str.charAt(0)) {
                    break label226;
                  }
                  m = n - 1;
                  if ('"' != str.charAt(m)) {
                    break label226;
                  }
                  return str.substring(1, m);
                }
                return str;
              }
            }
            i1 = m + 1;
            i3 = paramString1.indexOf(';', i1);
            m = i3;
            n = i1;
          } while (i3 != -1);
        }
      }
    }
    return null;
    label226:
    return str;
  }
  
  public Map getParams(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      int n = paramString.length();
      int i1 = paramString.indexOf(';') + 1;
      if ((i1 != 0) && (i1 != n))
      {
        int i2 = paramString.indexOf(';', i1);
        int m = i2;
        if (i2 == -1) {
          m = n;
        }
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        while (i1 < m)
        {
          i2 = paramString.indexOf('=', i1);
          if ((i2 != -1) && (i2 < m))
          {
            String str1 = paramString.substring(i1, i2).trim();
            if (str1.length() > 0)
            {
              String str2 = paramString.substring(i2 + 1, m).trim();
              i1 = str2.length();
              if (i1 != 0)
              {
                if ((i1 > 2) && ('"' == str2.charAt(0)))
                {
                  i1 -= 1;
                  if ('"' == str2.charAt(i1))
                  {
                    localLinkedHashMap.put(str1, str2.substring(1, i1));
                    break label216;
                  }
                }
                localLinkedHashMap.put(str1, str2);
              }
            }
          }
          label216:
          i2 = m + 1;
          int i3 = paramString.indexOf(';', i2);
          m = i3;
          i1 = i2;
          if (i3 == -1)
          {
            m = n;
            i1 = i2;
          }
        }
        return localLinkedHashMap;
      }
      return Collections.emptyMap();
    }
    return Collections.emptyMap();
  }
  
  public int getTitle()
  {
    return a;
  }
  
  public boolean hasTags()
    throws m.e
  {
    return 400 == get();
  }
  
  public String header(String paramString)
    throws m.e
  {
    closeOutputQuietly();
    return getConnection().getHeaderField(paramString);
  }
  
  public Map headers()
    throws m.e
  {
    closeOutputQuietly();
    return getConnection().getHeaderFields();
  }
  
  public Item init(Reader paramReader, Writer paramWriter)
    throws IOException
  {
    return (Item)new k(this, paramReader, M, paramReader, paramWriter).call();
  }
  
  public int intHeader(String paramString)
    throws m.e
  {
    return intHeader(paramString, -1);
  }
  
  public int intHeader(String paramString, int paramInt)
    throws m.e
  {
    closeOutputQuietly();
    return getConnection().getHeaderFieldInt(paramString, paramInt);
  }
  
  public boolean isFullSpan()
  {
    return M;
  }
  
  public boolean isNone()
    throws m.e
  {
    return 500 == get();
  }
  
  public boolean isUnknown()
    throws m.e
  {
    return 200 == get();
  }
  
  public long lastModified()
  {
    return dateHeader("Last-Modified");
  }
  
  public Item load(int paramInt)
  {
    getConnection().setFixedLengthStreamingMode(paramInt);
    return this;
  }
  
  public Item load(String paramString)
  {
    return get("Proxy-Authorization", paramString);
  }
  
  public Item load(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Basic ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString1);
    localStringBuilder2.append(':');
    localStringBuilder2.append(paramString2);
    localStringBuilder1.append(m.a.a(localStringBuilder2.toString()));
    return load(localStringBuilder1.toString());
  }
  
  public Item load(AtomicInteger paramAtomicInteger)
    throws m.e
  {
    paramAtomicInteger.set(get());
    return this;
  }
  
  public Item load(boolean paramBoolean)
  {
    getConnection().setInstanceFollowRedirects(paramBoolean);
    return this;
  }
  
  public byte[] load()
    throws m.e
  {
    ByteArrayOutputStream localByteArrayOutputStream = byteStream();
    try
    {
      read(read(), localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw ((Throwable)new m.e(localIOException));
    }
  }
  
  public String location()
  {
    return header("Location");
  }
  
  public String method()
  {
    return getConnection().getRequestMethod();
  }
  
  public Item newClass(String paramString)
  {
    return get("User-Agent", paramString);
  }
  
  public Item newString(String paramString)
  {
    return get("Accept-Charset", paramString);
  }
  
  public boolean onItemSelected()
    throws m.e
  {
    return 404 == get();
  }
  
  public boolean onLongClick()
    throws m.e
  {
    return 304 == get();
  }
  
  public Item openOutput()
    throws IOException
  {
    if (output != null) {
      return this;
    }
    getConnection().setDoOutput(true);
    String str = getParam(getConnection().getRequestProperty("Content-Type"), "charset");
    output = new m.g(getConnection().getOutputStream(), str, a);
    return this;
  }
  
  public String parameter(String paramString1, String paramString2)
  {
    return getParam(header(paramString1), paramString2);
  }
  
  public Item partHeader(String paramString1, String paramString2)
    throws m.e
  {
    return send(paramString1).send(": ").send(paramString2).send("\r\n");
  }
  
  public BufferedInputStream read()
    throws m.e
  {
    return new BufferedInputStream(stream(), a);
  }
  
  public Item read(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return (Item)new j(this, paramInputStream, M, paramInputStream, paramOutputStream).call();
  }
  
  public Item readTimeout(int paramInt)
  {
    getConnection().setReadTimeout(paramInt);
    return this;
  }
  
  public InputStreamReader reader()
    throws m.e
  {
    return reader(charset());
  }
  
  public InputStreamReader reader(String paramString)
    throws m.e
  {
    try
    {
      paramString = new InputStreamReader(stream(), getValidCharset(paramString));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw ((Throwable)new m.e(paramString));
    }
  }
  
  public Item send(Reader paramReader)
    throws m.e
  {
    try
    {
      openOutput();
      Object localObject = output;
      Charset localCharset = m.g.a((m.g)localObject).charset();
      localObject = new OutputStreamWriter((OutputStream)localObject, localCharset);
      return (Item)new l(this, (Flushable)localObject, paramReader, (Writer)localObject).call();
    }
    catch (IOException paramReader)
    {
      throw ((Throwable)new m.e(paramReader));
    }
  }
  
  public Item send(CharSequence paramCharSequence)
    throws m.e
  {
    try
    {
      openOutput();
      m.g localG = output;
      localG.b(paramCharSequence.toString());
      return this;
    }
    catch (IOException paramCharSequence)
    {
      throw ((Throwable)new m.e(paramCharSequence));
    }
  }
  
  public String server()
  {
    return header("Server");
  }
  
  public boolean setAuthor()
    throws m.e
  {
    return contentLength() == 0;
  }
  
  public Item setFullSpan()
    throws m.e
  {
    return this;
  }
  
  public Item setFullSpan(boolean paramBoolean)
  {
    M = paramBoolean;
    return this;
  }
  
  public Item setId(boolean paramBoolean)
  {
    N = paramBoolean;
    return this;
  }
  
  public Item setTab()
  {
    return this;
  }
  
  public Item startPart()
    throws IOException
  {
    if (!multipart)
    {
      multipart = true;
      contentType("multipart/form-data; boundary=00content0boundary00").openOutput();
      output.b("--00content0boundary00\r\n");
      return this;
    }
    output.b("\r\n--00content0boundary00\r\n");
    return this;
  }
  
  public InputStream stream()
    throws m.e
  {
    if (get() < 400)
    {
      try
      {
        InputStream localInputStream1 = getConnection().getInputStream();
      }
      catch (IOException localIOException1)
      {
        throw ((Throwable)new m.e(localIOException1));
      }
    }
    else
    {
      InputStream localInputStream2 = getConnection().getErrorStream();
      Object localObject = localInputStream2;
      if (localInputStream2 == null) {
        try
        {
          localObject = getConnection().getInputStream();
        }
        catch (IOException localIOException2)
        {
          throw ((Throwable)new m.e(localIOException2));
        }
      }
    }
    if (N)
    {
      if (!"gzip".equals(contentEncoding())) {
        return localIOException2;
      }
      try
      {
        GZIPInputStream localGZIPInputStream = new GZIPInputStream(localIOException2);
        return localGZIPInputStream;
      }
      catch (IOException localIOException3)
      {
        throw ((Throwable)new m.e(localIOException3));
      }
    }
    return localIOException3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(method());
    localStringBuilder.append(' ');
    localStringBuilder.append(url());
    return localStringBuilder.toString();
  }
  
  public Item update()
  {
    return get("application/json");
  }
  
  public Item update(int paramInt)
  {
    getConnection().setChunkedStreamingMode(paramInt);
    return this;
  }
  
  public Item update(long paramLong)
  {
    getConnection().setIfModifiedSince(paramLong);
    return this;
  }
  
  public Item update(String paramString)
  {
    return get("If-None-Match", paramString);
  }
  
  public Item update(String paramString1, String paramString2)
    throws IOException
  {
    return writePartHeader(paramString1, paramString2, null);
  }
  
  public Item update(Map paramMap)
  {
    if (!paramMap.isEmpty())
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext()) {
        get((Map.Entry)paramMap.next());
      }
    }
    return this;
  }
  
  public Item update(AtomicReference paramAtomicReference)
    throws m.e
  {
    paramAtomicReference.set(body());
    return this;
  }
  
  public Item update(AtomicReference paramAtomicReference, String paramString)
    throws m.e
  {
    paramAtomicReference.set(body(paramString));
    return this;
  }
  
  public URL url()
  {
    return getConnection().getURL();
  }
  
  public Item writePartHeader(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    paramString1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("form-data; name=\"", paramString1);
    if (paramString2 != null)
    {
      paramString1.append("\"; filename=\"");
      paramString1.append(paramString2);
    }
    paramString1.append('"');
    partHeader("Content-Disposition", paramString1.toString());
    if (paramString3 != null) {
      partHeader("Content-Type", paramString3);
    }
    return send("\r\n");
  }
  
  public OutputStreamWriter writer()
    throws m.e
  {
    try
    {
      openOutput();
      Object localObject1 = output;
      Object localObject2 = output;
      localObject2 = m.g.a((m.g)localObject2).charset();
      localObject1 = (OutputStream)localObject1;
      localObject1 = new OutputStreamWriter((OutputStream)localObject1, (Charset)localObject2);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      throw ((Throwable)new m.e(localIOException));
    }
  }
}
