package com.google.android.android.internal;

import b.b.a.X;
import com.google.android.android.common.internal.zzbp;
import java.net.URL;
import java.util.Map;

@X
public final class zzcce
  implements Runnable
{
  public final String mPackageName;
  public final URL zzbvn;
  public final byte[] zzgaj;
  public final zzccc zziqi;
  public final Map<String, String> zziqj;
  
  public zzcce(zzcca paramZzcca, String paramString, URL paramURL, byte[] paramArrayOfByte, Map paramMap, zzccc paramZzccc)
  {
    zzbp.zzgg(paramString);
    zzbp.append(paramURL);
    zzbp.append(paramZzccc);
    zzbvn = paramURL;
    zzgaj = paramArrayOfByte;
    zziqi = paramZzccc;
    mPackageName = paramString;
    zziqj = paramMap;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/google/android/android/internal/zzcce:zziqk	Lcom/google/android/android/internal/zzcca;
    //   4: invokevirtual 58	com/google/android/android/internal/zzcca:zzatw	()V
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 7
    //   13: aconst_null
    //   14: astore 8
    //   16: aconst_null
    //   17: astore 9
    //   19: aload_0
    //   20: getfield 39	com/google/android/android/internal/zzcce:zzbvn	Ljava/net/URL;
    //   23: astore 4
    //   25: aload 4
    //   27: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   30: astore 4
    //   32: aload 4
    //   34: instanceof 66
    //   37: istore_3
    //   38: iload_3
    //   39: ifeq +436 -> 475
    //   42: aload 4
    //   44: checkcast 66	java/net/HttpURLConnection
    //   47: astore 4
    //   49: aload 4
    //   51: iconst_0
    //   52: invokevirtual 70	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   55: invokestatic 76	com/google/android/android/internal/zzcax:zzawf	()J
    //   58: pop2
    //   59: aload 4
    //   61: ldc 77
    //   63: invokevirtual 81	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   66: invokestatic 84	com/google/android/android/internal/zzcax:zzawg	()J
    //   69: pop2
    //   70: aload 4
    //   72: ldc 85
    //   74: invokevirtual 88	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   77: aload 4
    //   79: iconst_0
    //   80: invokevirtual 91	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   83: aload 4
    //   85: iconst_1
    //   86: invokevirtual 94	java/net/HttpURLConnection:setDoInput	(Z)V
    //   89: aload_0
    //   90: getfield 47	com/google/android/android/internal/zzcce:zziqj	Ljava/util/Map;
    //   93: astore 5
    //   95: aload 5
    //   97: ifnull +95 -> 192
    //   100: aload_0
    //   101: getfield 47	com/google/android/android/internal/zzcce:zziqj	Ljava/util/Map;
    //   104: astore 5
    //   106: aload 5
    //   108: invokeinterface 100 1 0
    //   113: invokeinterface 106 1 0
    //   118: astore 5
    //   120: aload 5
    //   122: invokeinterface 112 1 0
    //   127: istore_3
    //   128: iload_3
    //   129: ifeq +63 -> 192
    //   132: aload 5
    //   134: invokeinterface 116 1 0
    //   139: astore 10
    //   141: aload 10
    //   143: checkcast 118	java/util/Map$Entry
    //   146: astore 11
    //   148: aload 11
    //   150: invokeinterface 121 1 0
    //   155: astore 10
    //   157: aload 10
    //   159: checkcast 123	java/lang/String
    //   162: astore 10
    //   164: aload 11
    //   166: invokeinterface 126 1 0
    //   171: astore 11
    //   173: aload 11
    //   175: checkcast 123	java/lang/String
    //   178: astore 11
    //   180: aload 4
    //   182: aload 10
    //   184: aload 11
    //   186: invokevirtual 130	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -69 -> 120
    //   192: aload_0
    //   193: getfield 41	com/google/android/android/internal/zzcce:zzgaj	[B
    //   196: astore 5
    //   198: aload 5
    //   200: ifnull +132 -> 332
    //   203: aload_0
    //   204: getfield 24	com/google/android/android/internal/zzcce:zziqk	Lcom/google/android/android/internal/zzcca;
    //   207: astore 5
    //   209: aload 5
    //   211: invokevirtual 134	com/google/android/android/internal/zzcca:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   214: astore 5
    //   216: aload_0
    //   217: getfield 41	com/google/android/android/internal/zzcce:zzgaj	[B
    //   220: astore 10
    //   222: aload 5
    //   224: aload 10
    //   226: invokevirtual 140	com/google/android/android/internal/zzcfw:compress	([B)[B
    //   229: astore 10
    //   231: aload_0
    //   232: getfield 24	com/google/android/android/internal/zzcce:zziqk	Lcom/google/android/android/internal/zzcca;
    //   235: astore 5
    //   237: aload 5
    //   239: invokevirtual 144	com/google/android/android/internal/zzcca:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   242: invokevirtual 150	com/google/android/android/internal/zzcbw:zzayj	()Lcom/google/android/android/internal/zzcby;
    //   245: astore 5
    //   247: aload 10
    //   249: arraylength
    //   250: istore_1
    //   251: aload 5
    //   253: ldc -104
    //   255: iload_1
    //   256: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: invokevirtual 163	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   262: aload 4
    //   264: iconst_1
    //   265: invokevirtual 166	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   268: aload 4
    //   270: ldc -88
    //   272: ldc -86
    //   274: invokevirtual 130	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload 10
    //   279: arraylength
    //   280: istore_1
    //   281: aload 4
    //   283: iload_1
    //   284: invokevirtual 173	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   287: aload 4
    //   289: invokevirtual 176	java/net/HttpURLConnection:connect	()V
    //   292: aload 4
    //   294: invokevirtual 180	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   297: astore 5
    //   299: aload 5
    //   301: aload 10
    //   303: invokevirtual 186	java/io/OutputStream:write	([B)V
    //   306: aload 5
    //   308: invokevirtual 189	java/io/OutputStream:close	()V
    //   311: goto +21 -> 332
    //   314: astore 7
    //   316: aload 4
    //   318: astore 6
    //   320: aload 7
    //   322: astore 4
    //   324: goto +170 -> 494
    //   327: astore 6
    //   329: goto +277 -> 606
    //   332: aload 4
    //   334: invokevirtual 193	java/net/HttpURLConnection:getResponseCode	()I
    //   337: istore_2
    //   338: iload_2
    //   339: istore_1
    //   340: aload 4
    //   342: invokevirtual 197	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   345: astore 7
    //   347: aload 7
    //   349: astore 5
    //   351: aload 4
    //   353: invokestatic 201	com/google/android/android/internal/zzcca:sendRequest	(Ljava/net/HttpURLConnection;)[B
    //   356: astore 9
    //   358: aload 4
    //   360: invokevirtual 204	java/net/HttpURLConnection:disconnect	()V
    //   363: aload_0
    //   364: getfield 24	com/google/android/android/internal/zzcce:zziqk	Lcom/google/android/android/internal/zzcca;
    //   367: invokevirtual 208	com/google/android/android/internal/zzcca:zzauk	()Lcom/google/android/android/internal/zzccr;
    //   370: new 210	com/google/android/android/internal/zzccd
    //   373: dup
    //   374: aload_0
    //   375: getfield 45	com/google/android/android/internal/zzcce:mPackageName	Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 43	com/google/android/android/internal/zzcce:zziqi	Lcom/google/android/android/internal/zzccc;
    //   382: iload_2
    //   383: aconst_null
    //   384: aload 9
    //   386: aload 7
    //   388: invokespecial 213	com/google/android/android/internal/zzccd:<init>	(Ljava/lang/String;Lcom/google/android/android/internal/zzccc;ILjava/lang/Throwable;[BLjava/util/Map;)V
    //   391: invokevirtual 219	com/google/android/android/internal/zzccr:e	(Ljava/lang/Runnable;)V
    //   394: return
    //   395: astore 7
    //   397: aload 6
    //   399: astore 8
    //   401: aload 4
    //   403: astore 6
    //   405: aload 5
    //   407: astore 4
    //   409: goto +102 -> 511
    //   412: astore 6
    //   414: goto +28 -> 442
    //   417: astore 7
    //   419: aconst_null
    //   420: astore 5
    //   422: aload 6
    //   424: astore 8
    //   426: aload 4
    //   428: astore 6
    //   430: aload 5
    //   432: astore 4
    //   434: goto +77 -> 511
    //   437: astore 6
    //   439: aconst_null
    //   440: astore 5
    //   442: aload 6
    //   444: astore 7
    //   446: aload 5
    //   448: astore 6
    //   450: goto +173 -> 623
    //   453: astore 7
    //   455: aload 9
    //   457: astore 5
    //   459: aload 4
    //   461: astore 6
    //   463: aload 7
    //   465: astore 4
    //   467: goto +27 -> 494
    //   470: astore 5
    //   472: goto +126 -> 598
    //   475: new 53	java/io/IOException
    //   478: dup
    //   479: ldc -35
    //   481: invokespecial 224	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   484: athrow
    //   485: astore 4
    //   487: aconst_null
    //   488: astore 6
    //   490: aload 9
    //   492: astore 5
    //   494: aconst_null
    //   495: astore 8
    //   497: iconst_0
    //   498: istore_1
    //   499: aload 4
    //   501: astore 7
    //   503: aload 8
    //   505: astore 4
    //   507: aload 5
    //   509: astore 8
    //   511: aload 8
    //   513: ifnull +37 -> 550
    //   516: aload 8
    //   518: invokevirtual 189	java/io/OutputStream:close	()V
    //   521: goto +29 -> 550
    //   524: astore 5
    //   526: aload_0
    //   527: getfield 24	com/google/android/android/internal/zzcce:zziqk	Lcom/google/android/android/internal/zzcca;
    //   530: invokevirtual 144	com/google/android/android/internal/zzcca:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   533: invokevirtual 227	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   536: ldc -27
    //   538: aload_0
    //   539: getfield 45	com/google/android/android/internal/zzcce:mPackageName	Ljava/lang/String;
    //   542: invokestatic 233	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   545: aload 5
    //   547: invokevirtual 236	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   550: aload 6
    //   552: ifnull +8 -> 560
    //   555: aload 6
    //   557: invokevirtual 204	java/net/HttpURLConnection:disconnect	()V
    //   560: aload_0
    //   561: getfield 24	com/google/android/android/internal/zzcce:zziqk	Lcom/google/android/android/internal/zzcca;
    //   564: invokevirtual 208	com/google/android/android/internal/zzcca:zzauk	()Lcom/google/android/android/internal/zzccr;
    //   567: new 210	com/google/android/android/internal/zzccd
    //   570: dup
    //   571: aload_0
    //   572: getfield 45	com/google/android/android/internal/zzcce:mPackageName	Ljava/lang/String;
    //   575: aload_0
    //   576: getfield 43	com/google/android/android/internal/zzcce:zziqi	Lcom/google/android/android/internal/zzccc;
    //   579: iload_1
    //   580: aconst_null
    //   581: aconst_null
    //   582: aload 4
    //   584: invokespecial 213	com/google/android/android/internal/zzccd:<init>	(Ljava/lang/String;Lcom/google/android/android/internal/zzccc;ILjava/lang/Throwable;[BLjava/util/Map;)V
    //   587: invokevirtual 219	com/google/android/android/internal/zzccr:e	(Ljava/lang/Runnable;)V
    //   590: aload 7
    //   592: athrow
    //   593: astore 5
    //   595: aconst_null
    //   596: astore 4
    //   598: aload 5
    //   600: astore 6
    //   602: aload 7
    //   604: astore 5
    //   606: aconst_null
    //   607: astore 8
    //   609: iconst_0
    //   610: istore_1
    //   611: aload 6
    //   613: astore 7
    //   615: aload 8
    //   617: astore 6
    //   619: aload 5
    //   621: astore 8
    //   623: aload 8
    //   625: ifnull +37 -> 662
    //   628: aload 8
    //   630: invokevirtual 189	java/io/OutputStream:close	()V
    //   633: goto +29 -> 662
    //   636: astore 5
    //   638: aload_0
    //   639: getfield 24	com/google/android/android/internal/zzcce:zziqk	Lcom/google/android/android/internal/zzcca;
    //   642: invokevirtual 144	com/google/android/android/internal/zzcca:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   645: invokevirtual 227	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   648: ldc -27
    //   650: aload_0
    //   651: getfield 45	com/google/android/android/internal/zzcce:mPackageName	Ljava/lang/String;
    //   654: invokestatic 233	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   657: aload 5
    //   659: invokevirtual 236	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   662: aload 4
    //   664: ifnull +8 -> 672
    //   667: aload 4
    //   669: invokevirtual 204	java/net/HttpURLConnection:disconnect	()V
    //   672: aload_0
    //   673: getfield 24	com/google/android/android/internal/zzcce:zziqk	Lcom/google/android/android/internal/zzcca;
    //   676: invokevirtual 208	com/google/android/android/internal/zzcca:zzauk	()Lcom/google/android/android/internal/zzccr;
    //   679: new 210	com/google/android/android/internal/zzccd
    //   682: dup
    //   683: aload_0
    //   684: getfield 45	com/google/android/android/internal/zzcce:mPackageName	Ljava/lang/String;
    //   687: aload_0
    //   688: getfield 43	com/google/android/android/internal/zzcce:zziqi	Lcom/google/android/android/internal/zzccc;
    //   691: iload_1
    //   692: aload 7
    //   694: checkcast 51	java/lang/Throwable
    //   697: aconst_null
    //   698: aload 6
    //   700: invokespecial 213	com/google/android/android/internal/zzccd:<init>	(Ljava/lang/String;Lcom/google/android/android/internal/zzccc;ILjava/lang/Throwable;[BLjava/util/Map;)V
    //   703: invokevirtual 219	com/google/android/android/internal/zzccr:e	(Ljava/lang/Runnable;)V
    //   706: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	zzcce
    //   250	442	1	i	int
    //   337	46	2	j	int
    //   37	92	3	bool	boolean
    //   23	443	4	localObject1	Object
    //   485	15	4	localThrowable1	Throwable
    //   505	163	4	localObject2	Object
    //   93	365	5	localObject3	Object
    //   470	1	5	localIOException1	java.io.IOException
    //   492	16	5	arrayOfByte1	byte[]
    //   524	22	5	localIOException2	java.io.IOException
    //   593	6	5	localIOException3	java.io.IOException
    //   604	16	5	localObject4	Object
    //   636	22	5	localIOException4	java.io.IOException
    //   8	311	6	localObject5	Object
    //   327	71	6	localIOException5	java.io.IOException
    //   403	1	6	localObject6	Object
    //   412	11	6	localIOException6	java.io.IOException
    //   428	1	6	localObject7	Object
    //   437	6	6	localIOException7	java.io.IOException
    //   448	251	6	localObject8	Object
    //   11	1	7	localObject9	Object
    //   314	7	7	localThrowable2	Throwable
    //   345	42	7	localMap	Map
    //   395	1	7	localThrowable3	Throwable
    //   417	1	7	localThrowable4	Throwable
    //   444	1	7	localIOException8	java.io.IOException
    //   453	11	7	localThrowable5	Throwable
    //   501	192	7	localObject10	Object
    //   14	615	8	localObject11	Object
    //   17	474	9	arrayOfByte2	byte[]
    //   139	163	10	localObject12	Object
    //   146	39	11	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   299	311	314	java/lang/Throwable
    //   299	311	327	java/io/IOException
    //   351	358	395	java/lang/Throwable
    //   351	358	412	java/io/IOException
    //   340	347	417	java/lang/Throwable
    //   340	347	437	java/io/IOException
    //   89	95	453	java/lang/Throwable
    //   106	120	453	java/lang/Throwable
    //   120	128	453	java/lang/Throwable
    //   132	141	453	java/lang/Throwable
    //   141	148	453	java/lang/Throwable
    //   148	157	453	java/lang/Throwable
    //   157	164	453	java/lang/Throwable
    //   164	173	453	java/lang/Throwable
    //   180	189	453	java/lang/Throwable
    //   192	198	453	java/lang/Throwable
    //   203	209	453	java/lang/Throwable
    //   209	216	453	java/lang/Throwable
    //   216	222	453	java/lang/Throwable
    //   222	231	453	java/lang/Throwable
    //   231	237	453	java/lang/Throwable
    //   237	247	453	java/lang/Throwable
    //   247	251	453	java/lang/Throwable
    //   251	277	453	java/lang/Throwable
    //   281	299	453	java/lang/Throwable
    //   332	338	453	java/lang/Throwable
    //   106	120	470	java/io/IOException
    //   120	128	470	java/io/IOException
    //   132	141	470	java/io/IOException
    //   148	157	470	java/io/IOException
    //   164	173	470	java/io/IOException
    //   180	189	470	java/io/IOException
    //   209	216	470	java/io/IOException
    //   222	231	470	java/io/IOException
    //   237	247	470	java/io/IOException
    //   251	277	470	java/io/IOException
    //   281	299	470	java/io/IOException
    //   332	338	470	java/io/IOException
    //   19	25	485	java/lang/Throwable
    //   25	32	485	java/lang/Throwable
    //   32	38	485	java/lang/Throwable
    //   49	89	485	java/lang/Throwable
    //   475	485	485	java/lang/Throwable
    //   516	521	524	java/io/IOException
    //   25	32	593	java/io/IOException
    //   49	89	593	java/io/IOException
    //   475	485	593	java/io/IOException
    //   628	633	636	java/io/IOException
  }
}
