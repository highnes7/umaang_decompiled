package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.h;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.Item;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@h
public class Log
{
  public static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
  public static final Pattern oPatternPrefixSearch = Pattern.compile("\\s*max-age\\s*=\\s*(\\d+)\\s*");
  public final String f;
  public final Item g;
  public long h;
  public final JsonFactory jsonFactory;
  public final Lock lock = new ReentrantLock();
  public List<PublicKey> publicKeys;
  public final HttpTransport transport;
  
  public Log(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
  {
    this(new d(paramHttpTransport, paramJsonFactory));
  }
  
  public Log(d paramD)
  {
    transport = e;
    jsonFactory = a;
    g = g;
    f = f;
  }
  
  public final Item b()
  {
    return g;
  }
  
  public final String d()
  {
    return f;
  }
  
  public final long f()
  {
    return h;
  }
  
  public final List getPublicKeys()
    throws GeneralSecurityException, IOException
  {
    lock.lock();
    try
    {
      List localList = publicKeys;
      if (localList != null)
      {
        long l1 = g.currentTimeMillis();
        long l2 = h;
        if (l1 + 300000L <= l2) {}
      }
      else
      {
        refresh();
      }
      localList = publicKeys;
      lock.unlock();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public final JsonFactory getText()
  {
    return jsonFactory;
  }
  
  public final HttpTransport log()
  {
    return transport;
  }
  
  /* Error */
  public Log refresh()
    throws GeneralSecurityException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	f/g/org/org/org/objectweb/asm/Log:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 89 1 0
    //   9: aload_0
    //   10: new 110	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 111	java/util/ArrayList:<init>	()V
    //   17: putfield 91	f/g/org/org/org/objectweb/asm/Log:publicKeys	Ljava/util/List;
    //   20: invokestatic 117	f/g/org/org/util/SecurityUtils:getX509CertificateFactory	()Ljava/security/cert/CertificateFactory;
    //   23: astore 8
    //   25: aload_0
    //   26: getfield 59	f/g/org/org/org/objectweb/asm/Log:transport	Lf/g/org/org/http/HttpTransport;
    //   29: invokevirtual 123	f/g/org/org/http/HttpTransport:createRequestFactory	()Lf/g/org/org/http/HttpRequestFactory;
    //   32: new 125	f/g/org/org/http/GenericUrl
    //   35: dup
    //   36: aload_0
    //   37: getfield 70	f/g/org/org/org/objectweb/asm/Log:f	Ljava/lang/String;
    //   40: invokespecial 128	f/g/org/org/http/GenericUrl:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 134	f/g/org/org/http/HttpRequestFactory:buildRequest	(Lf/g/org/org/http/GenericUrl;)Lf/g/org/org/http/HttpRequest;
    //   46: invokevirtual 140	f/g/org/org/http/HttpRequest:execute	()Lf/g/org/org/http/HttpResponse;
    //   49: astore 6
    //   51: aload_0
    //   52: getfield 67	f/g/org/org/org/objectweb/asm/Log:g	Lf/g/org/org/util/Item;
    //   55: invokeinterface 96 1 0
    //   60: lstore_1
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 146	f/g/org/org/http/HttpResponse:getHeaders	()Lf/g/org/org/http/HttpHeaders;
    //   67: invokevirtual 150	f/g/org/org/org/objectweb/asm/Log:statDisk	(Lf/g/org/org/http/HttpHeaders;)J
    //   70: lstore_3
    //   71: aload_0
    //   72: lload_3
    //   73: ldc2_w 151
    //   76: lmul
    //   77: lload_1
    //   78: ladd
    //   79: putfield 77	f/g/org/org/org/objectweb/asm/Log:h	J
    //   82: aload_0
    //   83: getfield 64	f/g/org/org/org/objectweb/asm/Log:jsonFactory	Lf/g/org/org/stream/JsonFactory;
    //   86: aload 6
    //   88: invokevirtual 156	f/g/org/org/http/HttpResponse:getContent	()Ljava/io/InputStream;
    //   91: invokevirtual 162	f/g/org/org/stream/JsonFactory:createJsonParser	(Ljava/io/InputStream;)Lf/g/org/org/stream/JsonParser;
    //   94: astore 9
    //   96: aload 9
    //   98: invokevirtual 168	f/g/org/org/stream/JsonParser:getCurrentToken	()Lf/g/org/org/stream/JsonToken;
    //   101: astore 7
    //   103: aload 7
    //   105: astore 6
    //   107: aload 7
    //   109: ifnonnull +10 -> 119
    //   112: aload 9
    //   114: invokevirtual 171	f/g/org/org/stream/JsonParser:nextToken	()Lf/g/org/org/stream/JsonToken;
    //   117: astore 6
    //   119: getstatic 177	f/g/org/org/stream/JsonToken:START_OBJECT	Lf/g/org/org/stream/JsonToken;
    //   122: astore 7
    //   124: aload 6
    //   126: aload 7
    //   128: if_acmpne +9 -> 137
    //   131: iconst_1
    //   132: istore 5
    //   134: goto +6 -> 140
    //   137: iconst_0
    //   138: istore 5
    //   140: iload 5
    //   142: invokestatic 183	f/g/org/org/codehaus/libs/objectweb/asm/asm/Preconditions:append	(Z)V
    //   145: aload 9
    //   147: invokevirtual 171	f/g/org/org/stream/JsonParser:nextToken	()Lf/g/org/org/stream/JsonToken;
    //   150: astore 6
    //   152: getstatic 186	f/g/org/org/stream/JsonToken:END_OBJECT	Lf/g/org/org/stream/JsonToken;
    //   155: astore 7
    //   157: aload 6
    //   159: aload 7
    //   161: if_acmpeq +52 -> 213
    //   164: aload 9
    //   166: invokevirtual 171	f/g/org/org/stream/JsonParser:nextToken	()Lf/g/org/org/stream/JsonToken;
    //   169: pop
    //   170: aload 8
    //   172: new 188	java/io/ByteArrayInputStream
    //   175: dup
    //   176: aload 9
    //   178: invokevirtual 190	f/g/org/org/stream/JsonParser:getText	()Ljava/lang/String;
    //   181: invokestatic 196	f/g/org/org/util/StringUtils:getBytesUtf8	(Ljava/lang/String;)[B
    //   184: invokespecial 199	java/io/ByteArrayInputStream:<init>	([B)V
    //   187: invokevirtual 205	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   190: checkcast 207	java/security/cert/X509Certificate
    //   193: astore 6
    //   195: aload_0
    //   196: getfield 91	f/g/org/org/org/objectweb/asm/Log:publicKeys	Ljava/util/List;
    //   199: aload 6
    //   201: invokevirtual 211	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   204: invokeinterface 217 2 0
    //   209: pop
    //   210: goto -65 -> 145
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 91	f/g/org/org/org/objectweb/asm/Log:publicKeys	Ljava/util/List;
    //   218: invokestatic 223	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   221: putfield 91	f/g/org/org/org/objectweb/asm/Log:publicKeys	Ljava/util/List;
    //   224: aload 9
    //   226: invokevirtual 226	f/g/org/org/stream/JsonParser:close	()V
    //   229: aload_0
    //   230: getfield 54	f/g/org/org/org/objectweb/asm/Log:lock	Ljava/util/concurrent/locks/Lock;
    //   233: invokeinterface 103 1 0
    //   238: aload_0
    //   239: areturn
    //   240: astore 6
    //   242: aload 9
    //   244: invokevirtual 226	f/g/org/org/stream/JsonParser:close	()V
    //   247: aload 6
    //   249: athrow
    //   250: astore 6
    //   252: aload_0
    //   253: getfield 54	f/g/org/org/org/objectweb/asm/Log:lock	Ljava/util/concurrent/locks/Lock;
    //   256: invokeinterface 103 1 0
    //   261: goto +3 -> 264
    //   264: aload 6
    //   266: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	Log
    //   60	18	1	l1	long
    //   70	3	3	l2	long
    //   132	9	5	bool	boolean
    //   49	151	6	localObject	Object
    //   240	8	6	localThrowable1	Throwable
    //   250	15	6	localThrowable2	Throwable
    //   101	59	7	localJsonToken	f.g.org.org.stream.JsonToken
    //   23	148	8	localCertificateFactory	java.security.cert.CertificateFactory
    //   94	149	9	localJsonParser	f.g.org.org.stream.JsonParser
    // Exception table:
    //   from	to	target	type
    //   145	157	240	java/lang/Throwable
    //   164	210	240	java/lang/Throwable
    //   213	224	240	java/lang/Throwable
    //   9	71	250	java/lang/Throwable
    //   71	103	250	java/lang/Throwable
    //   112	119	250	java/lang/Throwable
    //   119	124	250	java/lang/Throwable
    //   140	145	250	java/lang/Throwable
    //   224	229	250	java/lang/Throwable
    //   242	250	250	java/lang/Throwable
  }
  
  public long statDisk(HttpHeaders paramHttpHeaders)
  {
    if (paramHttpHeaders.getCacheControl() != null)
    {
      String[] arrayOfString = paramHttpHeaders.getCacheControl().split(",");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        localObject = oPatternPrefixSearch.matcher((CharSequence)localObject);
        if (((Matcher)localObject).matches())
        {
          l1 = Long.valueOf(((Matcher)localObject).group(1)).longValue();
          break label80;
        }
        i += 1;
      }
    }
    long l1 = 0L;
    label80:
    long l2 = l1;
    if (paramHttpHeaders.getAge() != null) {
      l2 = l1 - paramHttpHeaders.getAge().longValue();
    }
    return Math.max(0L, l2);
  }
}
