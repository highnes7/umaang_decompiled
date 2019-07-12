package f.g.org.org.org.parser;

import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.Item;
import f.g.org.org.stream.JsonFactory;
import java.io.IOException;

public class FormatedText
  extends f.g.org.org.http.FormatedText
{
  public static final long MASK_TOKEN_FULL_LEN = 409811126989994864L;
  public final transient Element updateElement;
  
  public FormatedText(Item paramItem, Element paramElement)
  {
    super(paramItem);
    updateElement = paramElement;
  }
  
  public static HttpResponse execute(JsonFactory paramJsonFactory, HttpRequest paramHttpRequest)
    throws FormatedText, IOException
  {
    HttpResponse localHttpResponse;
    if (paramJsonFactory != null)
    {
      boolean bool = paramHttpRequest.getThrowExceptionOnExecuteError();
      if (bool) {
        paramHttpRequest.setThrowExceptionOnExecuteError(false);
      }
      localHttpResponse = paramHttpRequest.execute();
      paramHttpRequest.setThrowExceptionOnExecuteError(bool);
      if (bool)
      {
        if (localHttpResponse.isSuccessStatusCode()) {
          return localHttpResponse;
        }
        throw from(paramJsonFactory, localHttpResponse);
      }
    }
    else
    {
      throw new NullPointerException();
    }
    return localHttpResponse;
  }
  
  /* Error */
  public static FormatedText from(JsonFactory paramJsonFactory, HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: new 54	f/g/org/org/http/Item
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 58	f/g/org/org/http/HttpResponse:getStatusCode	()I
    //   8: aload_1
    //   9: invokevirtual 62	f/g/org/org/http/HttpResponse:getStatusMessage	()Ljava/lang/String;
    //   12: aload_1
    //   13: invokevirtual 66	f/g/org/org/http/HttpResponse:getHeaders	()Lf/g/org/org/http/HttpHeaders;
    //   16: invokespecial 69	f/g/org/org/http/Item:<init>	(ILjava/lang/String;Lf/g/org/org/http/HttpHeaders;)V
    //   19: astore 7
    //   21: aload_0
    //   22: ifnull +410 -> 432
    //   25: aconst_null
    //   26: astore_3
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 4
    //   33: aload_1
    //   34: invokevirtual 40	f/g/org/org/http/HttpResponse:isSuccessStatusCode	()Z
    //   37: istore_2
    //   38: iload_2
    //   39: ifne +307 -> 346
    //   42: ldc 71
    //   44: aload_1
    //   45: invokevirtual 74	f/g/org/org/http/HttpResponse:getContentType	()Ljava/lang/String;
    //   48: invokestatic 80	f/g/org/org/http/HttpMediaType:equalsIgnoreParameters	(Ljava/lang/String;Ljava/lang/String;)Z
    //   51: istore_2
    //   52: iload_2
    //   53: ifeq +293 -> 346
    //   56: aload_1
    //   57: invokevirtual 84	f/g/org/org/http/HttpResponse:getContent	()Ljava/io/InputStream;
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +282 -> 346
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 84	f/g/org/org/http/HttpResponse:getContent	()Ljava/io/InputStream;
    //   72: invokevirtual 90	f/g/org/org/stream/JsonFactory:createJsonParser	(Ljava/io/InputStream;)Lf/g/org/org/stream/JsonParser;
    //   75: astore 6
    //   77: aload 6
    //   79: astore_0
    //   80: aload 6
    //   82: invokevirtual 96	f/g/org/org/stream/JsonParser:getCurrentToken	()Lf/g/org/org/stream/JsonToken;
    //   85: astore 5
    //   87: aload 5
    //   89: astore_3
    //   90: aload 5
    //   92: ifnonnull +9 -> 101
    //   95: aload 6
    //   97: invokevirtual 99	f/g/org/org/stream/JsonParser:nextToken	()Lf/g/org/org/stream/JsonToken;
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull +77 -> 179
    //   105: aload 6
    //   107: ldc 101
    //   109: invokevirtual 105	f/g/org/org/stream/JsonParser:skipToKey	(Ljava/lang/String;)V
    //   112: aload 6
    //   114: invokevirtual 96	f/g/org/org/stream/JsonParser:getCurrentToken	()Lf/g/org/org/stream/JsonToken;
    //   117: astore_3
    //   118: getstatic 111	f/g/org/org/stream/JsonToken:END_OBJECT	Lf/g/org/org/stream/JsonToken;
    //   121: astore 5
    //   123: aload_3
    //   124: aload 5
    //   126: if_acmpeq +53 -> 179
    //   129: aload 6
    //   131: ldc 113
    //   133: invokevirtual 117	f/g/org/org/stream/JsonParser:parseAndClose	(Ljava/lang/Class;)Ljava/lang/Object;
    //   136: astore_3
    //   137: aload_3
    //   138: checkcast 119	f/g/org/org/org/parser/Element
    //   141: astore_3
    //   142: aload_3
    //   143: invokevirtual 124	f/g/org/org/stream/Object:toPrettyString	()Ljava/lang/String;
    //   146: astore 4
    //   148: aload_3
    //   149: astore_0
    //   150: goto +37 -> 187
    //   153: astore 5
    //   155: aload_0
    //   156: astore 4
    //   158: aload_3
    //   159: astore_0
    //   160: aload 5
    //   162: astore_3
    //   163: goto +141 -> 304
    //   166: astore 5
    //   168: aload_0
    //   169: astore 4
    //   171: aload_3
    //   172: astore_0
    //   173: aload 5
    //   175: astore_3
    //   176: goto +88 -> 264
    //   179: aconst_null
    //   180: astore_3
    //   181: aload 4
    //   183: astore_0
    //   184: aload_3
    //   185: astore 4
    //   187: aload 4
    //   189: astore_3
    //   190: aload_0
    //   191: astore 5
    //   193: aload_0
    //   194: ifnonnull +183 -> 377
    //   197: aload 6
    //   199: invokevirtual 127	f/g/org/org/stream/JsonParser:close	()V
    //   202: aload 4
    //   204: astore_3
    //   205: aload_0
    //   206: astore 5
    //   208: goto +169 -> 377
    //   211: astore 5
    //   213: aload 4
    //   215: astore_3
    //   216: aload 5
    //   218: astore 4
    //   220: goto +146 -> 366
    //   223: astore_3
    //   224: aconst_null
    //   225: astore 5
    //   227: aload_0
    //   228: astore 4
    //   230: aload 5
    //   232: astore_0
    //   233: goto +71 -> 304
    //   236: astore_3
    //   237: aconst_null
    //   238: astore 5
    //   240: aload_0
    //   241: astore 4
    //   243: aload 5
    //   245: astore_0
    //   246: goto +18 -> 264
    //   249: astore_3
    //   250: aconst_null
    //   251: astore 4
    //   253: aconst_null
    //   254: astore_0
    //   255: goto +49 -> 304
    //   258: astore_3
    //   259: aconst_null
    //   260: astore 4
    //   262: aconst_null
    //   263: astore_0
    //   264: aload_3
    //   265: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   268: aload 4
    //   270: ifnonnull +13 -> 283
    //   273: aload_0
    //   274: astore 5
    //   276: aload_1
    //   277: invokevirtual 133	f/g/org/org/http/HttpResponse:ignore	()V
    //   280: goto +15 -> 295
    //   283: aload_0
    //   284: ifnonnull +11 -> 295
    //   287: aload_0
    //   288: astore 5
    //   290: aload 4
    //   292: invokevirtual 127	f/g/org/org/stream/JsonParser:close	()V
    //   295: aconst_null
    //   296: astore_3
    //   297: aload_0
    //   298: astore 5
    //   300: goto +77 -> 377
    //   303: astore_3
    //   304: aload 4
    //   306: ifnull +18 -> 324
    //   309: aload_0
    //   310: ifnonnull +21 -> 331
    //   313: aload_0
    //   314: astore 5
    //   316: aload 4
    //   318: invokevirtual 127	f/g/org/org/stream/JsonParser:close	()V
    //   321: goto +10 -> 331
    //   324: aload_0
    //   325: astore 5
    //   327: aload_1
    //   328: invokevirtual 133	f/g/org/org/http/HttpResponse:ignore	()V
    //   331: aload_0
    //   332: astore 5
    //   334: aload_3
    //   335: athrow
    //   336: astore 4
    //   338: aconst_null
    //   339: astore_3
    //   340: aload 5
    //   342: astore_0
    //   343: goto +23 -> 366
    //   346: aload_1
    //   347: invokevirtual 136	f/g/org/org/http/HttpResponse:parseAsString	()Ljava/lang/String;
    //   350: astore_0
    //   351: aload_0
    //   352: astore_3
    //   353: goto +24 -> 377
    //   356: astore 4
    //   358: aconst_null
    //   359: astore 5
    //   361: aload_3
    //   362: astore_0
    //   363: aload 5
    //   365: astore_3
    //   366: aload 4
    //   368: checkcast 22	java/io/IOException
    //   371: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   374: aload_0
    //   375: astore 5
    //   377: aload_1
    //   378: invokestatic 140	f/g/org/org/http/FormatedText:computeMessageBuffer	(Lf/g/org/org/http/HttpResponse;)Ljava/lang/StringBuilder;
    //   381: astore_0
    //   382: aload_3
    //   383: invokestatic 146	f/g/org/org/codehaus/libs/objectweb/asm/asm/Cache:isEmpty	(Ljava/lang/String;)Z
    //   386: ifne +24 -> 410
    //   389: aload_0
    //   390: getstatic 152	f/g/org/org/util/StringUtils:LINE_SEPARATOR	Ljava/lang/String;
    //   393: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload_0
    //   398: aload_3
    //   399: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 7
    //   405: aload_3
    //   406: invokevirtual 162	f/g/org/org/http/Item:setContent	(Ljava/lang/String;)Lf/g/org/org/http/Item;
    //   409: pop
    //   410: aload 7
    //   412: aload_0
    //   413: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokevirtual 168	f/g/org/org/http/Item:put	(Ljava/lang/String;)Lf/g/org/org/http/Item;
    //   419: pop
    //   420: new 2	f/g/org/org/org/parser/FormatedText
    //   423: dup
    //   424: aload 7
    //   426: aload 5
    //   428: invokespecial 170	f/g/org/org/org/parser/FormatedText:<init>	(Lf/g/org/org/http/Item;Lf/g/org/org/org/parser/Element;)V
    //   431: areturn
    //   432: new 46	java/lang/NullPointerException
    //   435: dup
    //   436: invokespecial 49	java/lang/NullPointerException:<init>	()V
    //   439: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	paramJsonFactory	JsonFactory
    //   0	440	1	paramHttpResponse	HttpResponse
    //   37	16	2	bool	boolean
    //   26	190	3	localObject1	Object
    //   223	1	3	localThrowable1	Throwable
    //   236	1	3	localIOException1	IOException
    //   249	1	3	localThrowable2	Throwable
    //   258	7	3	localIOException2	IOException
    //   296	1	3	localObject2	Object
    //   303	32	3	localThrowable3	Throwable
    //   339	67	3	localObject3	Object
    //   31	286	4	localObject4	Object
    //   336	1	4	localIOException3	IOException
    //   356	11	4	localIOException4	IOException
    //   28	97	5	localJsonToken	f.g.org.org.stream.JsonToken
    //   153	8	5	localThrowable4	Throwable
    //   166	8	5	localIOException5	IOException
    //   191	16	5	localJsonFactory1	JsonFactory
    //   211	6	5	localIOException6	IOException
    //   225	202	5	localJsonFactory2	JsonFactory
    //   60	138	6	localObject5	Object
    //   19	406	7	localItem	Item
    // Exception table:
    //   from	to	target	type
    //   142	148	153	java/lang/Throwable
    //   142	148	166	java/io/IOException
    //   197	202	211	java/io/IOException
    //   80	87	223	java/lang/Throwable
    //   95	101	223	java/lang/Throwable
    //   105	118	223	java/lang/Throwable
    //   118	123	223	java/lang/Throwable
    //   129	137	223	java/lang/Throwable
    //   137	142	223	java/lang/Throwable
    //   80	87	236	java/io/IOException
    //   95	101	236	java/io/IOException
    //   105	118	236	java/io/IOException
    //   129	137	236	java/io/IOException
    //   67	77	249	java/lang/Throwable
    //   67	77	258	java/io/IOException
    //   264	268	303	java/lang/Throwable
    //   276	280	336	java/io/IOException
    //   290	295	336	java/io/IOException
    //   316	321	336	java/io/IOException
    //   327	331	336	java/io/IOException
    //   334	336	336	java/io/IOException
    //   33	38	356	java/io/IOException
    //   42	52	356	java/io/IOException
    //   56	62	356	java/io/IOException
    //   346	351	356	java/io/IOException
  }
  
  public final Element getUpdateElement()
  {
    return updateElement;
  }
}
