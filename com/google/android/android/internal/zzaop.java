package com.google.android.android.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzaop
  extends zzams
{
  public static final byte[] zzdtm = "\n".getBytes();
  public final String zzbwi = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { "GoogleAnalytics", zzamt.VERSION, Build.VERSION.RELEASE, zzapd.query(Locale.getDefault()), Build.MODEL, Build.ID });
  public final zzaoz zzdtl;
  
  public zzaop(zzamu paramZzamu)
  {
    super(paramZzamu);
    zzdtl = new zzaoz(paramZzamu.zzvx());
  }
  
  public static void add(StringBuilder paramStringBuilder, String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    if (paramStringBuilder.length() != 0) {
      paramStringBuilder.append('&');
    }
    paramStringBuilder.append(URLEncoder.encode(paramString1, "UTF-8"));
    paramStringBuilder.append('=');
    paramStringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
  }
  
  private final URL encodeParameters(zzaoi paramZzaoi)
  {
    Object localObject2;
    String str;
    Object localObject1;
    if (paramZzaoi.zzyp())
    {
      localObject2 = String.valueOf(zzanv.zzyb());
      paramZzaoi = (zzaoi)localObject2;
      str = String.valueOf(zzanv.zzyd());
      localObject1 = str;
      if (str.length() != 0)
      {
        localObject2 = localObject1;
        localObject1 = paramZzaoi;
        paramZzaoi = ((String)localObject1).concat((String)localObject2);
        break label105;
      }
    }
    for (paramZzaoi = new String((String)localObject2);; paramZzaoi = new String((String)localObject2))
    {
      break label105;
      localObject2 = String.valueOf(zzanv.zzyc());
      localObject1 = localObject2;
      str = String.valueOf(zzanv.zzyd());
      paramZzaoi = str;
      if (str.length() != 0)
      {
        localObject2 = paramZzaoi;
        break;
      }
    }
    try
    {
      label105:
      paramZzaoi = new URL(paramZzaoi);
      return paramZzaoi;
    }
    catch (MalformedURLException paramZzaoi)
    {
      toString("Error trying to parse the hardcoded host url", paramZzaoi);
    }
    return null;
  }
  
  private final int get(URL paramURL)
  {
    zzbp.append(paramURL);
    add("GET request", paramURL);
    URL localURL2 = null;
    URL localURL1 = null;
    try
    {
      HttpURLConnection localHttpURLConnection = openConnection(paramURL);
      paramURL = localHttpURLConnection;
      localURL1 = paramURL;
      localURL2 = paramURL;
      localHttpURLConnection.connect();
      localURL1 = paramURL;
      localURL2 = paramURL;
      sendRequest(localHttpURLConnection);
      localURL1 = paramURL;
      localURL2 = paramURL;
      int i = localHttpURLConnection.getResponseCode();
      if (i == 200)
      {
        localURL1 = paramURL;
        localURL2 = paramURL;
        zzwc().zzvv();
      }
      localURL1 = paramURL;
      localURL2 = paramURL;
      add("GET status", Integer.valueOf(i));
      localHttpURLConnection.disconnect();
      return i;
    }
    catch (Throwable paramURL) {}catch (IOException paramURL)
    {
      localURL1 = localURL2;
      append("Network GET connection error", paramURL);
      if (localURL2 != null) {
        localURL2.disconnect();
      }
      return 0;
    }
    if (localURL1 != null) {
      localURL1.disconnect();
    }
    throw paramURL;
  }
  
  private final HttpURLConnection openConnection(URL paramURL)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    if ((paramURL instanceof HttpURLConnection))
    {
      paramURL = (HttpURLConnection)paramURL;
      paramURL.setDefaultUseCaches(false);
      paramURL.setConnectTimeout(((Integer)zzaod.zzdsd.setDoOutput()).intValue());
      paramURL.setReadTimeout(((Integer)zzaod.zzdse.setDoOutput()).intValue());
      paramURL.setInstanceFollowRedirects(false);
      paramURL.setRequestProperty("User-Agent", zzbwi);
      paramURL.setDoInput(true);
      return paramURL;
    }
    throw new IOException("Failed to obtain http connection");
  }
  
  private final URL read(zzaoi paramZzaoi, String paramString)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramZzaoi.zzyp())
    {
      localObject2 = zzanv.zzyb();
      localObject1 = localObject2;
      localObject3 = zzanv.zzyd();
      paramZzaoi = (zzaoi)localObject3;
      localObject3 = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject3, f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject2, 1))));
      localObject2 = paramZzaoi;
    }
    else
    {
      localObject2 = zzanv.zzyc();
      paramZzaoi = (zzaoi)localObject2;
      localObject3 = zzanv.zzyd();
      localObject1 = localObject3;
      localObject3 = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject3, f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject2, 1))));
      localObject2 = localObject1;
      localObject1 = paramZzaoi;
    }
    paramZzaoi = f.sufficientlysecure.rootcommands.util.StringBuilder.replace((StringBuilder)localObject3, (String)localObject1, (String)localObject2, "?", paramString);
    try
    {
      paramZzaoi = new URL(paramZzaoi);
      return paramZzaoi;
    }
    catch (MalformedURLException paramZzaoi)
    {
      toString("Error trying to parse the hardcoded host url", paramZzaoi);
    }
    return null;
  }
  
  private final List request(List paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    label129:
    label249:
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      zzaoi localZzaoi = (zzaoi)localIterator.next();
      zzbp.append(localZzaoi);
      boolean bool = localZzaoi.zzyp();
      int i = 1;
      paramList = create(localZzaoi, bool ^ true);
      Object localObject;
      if (paramList == null)
      {
        localObject = zzvy();
        paramList = "Error formatting hit for upload";
        ((zzaon)localObject).append(localZzaoi, paramList);
      }
      else
      {
        if (paramList.length() <= ((Integer)zzaod.zzdrt.setDoOutput()).intValue())
        {
          paramList = read(localZzaoi, paramList);
          if (paramList == null)
          {
            paramList = "Failed to build collect GET endpoint url";
            zzdq(paramList);
          }
          else
          {
            if (get(paramList) == 200) {
              break label249;
            }
          }
        }
        do
        {
          i = 0;
          break label249;
          paramList = create(localZzaoi, false);
          if (paramList == null)
          {
            localObject = zzvy();
            paramList = "Error formatting hit for POST upload";
            break;
          }
          paramList = paramList.getBytes();
          if (paramList.length > ((Integer)zzaod.zzdry.setDoOutput()).intValue())
          {
            localObject = zzvy();
            paramList = "Hit payload exceeds size limit";
            break;
          }
          localObject = encodeParameters(localZzaoi);
          if (localObject == null)
          {
            paramList = "Failed to build collect POST endpoint url";
            break label129;
          }
        } while (send((URL)localObject, paramList) != 200);
      }
      if (i == 0) {
        break;
      }
      localArrayList.add(Long.valueOf(localZzaoi.zzym()));
    } while (localArrayList.size() < zzanv.zzxz());
    return localArrayList;
  }
  
  /* Error */
  private final int send(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 164	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 164	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_0
    //   11: ldc_w 350
    //   14: aload_2
    //   15: arraylength
    //   16: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aload_1
    //   20: invokevirtual 354	com/google/android/android/internal/zzamr:write	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   23: invokestatic 357	com/google/android/android/internal/zzamr:zzqu	()Z
    //   26: ifeq +18 -> 44
    //   29: aload_0
    //   30: ldc_w 359
    //   33: new 16	java/lang/String
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 362	java/lang/String:<init>	([B)V
    //   41: invokevirtual 365	com/google/android/android/internal/zzamr:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   44: aconst_null
    //   45: astore 6
    //   47: aconst_null
    //   48: astore 9
    //   50: aconst_null
    //   51: astore 4
    //   53: aconst_null
    //   54: astore 7
    //   56: aload_0
    //   57: invokevirtual 369	com/google/android/android/internal/zzamr:getContext	()Landroid/content/Context;
    //   60: invokevirtual 374	android/content/Context:getPackageName	()Ljava/lang/String;
    //   63: pop
    //   64: aload_0
    //   65: aload_1
    //   66: invokespecial 172	com/google/android/android/internal/zzaop:openConnection	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   69: astore 8
    //   71: aload 8
    //   73: astore 5
    //   75: aload 7
    //   77: astore 6
    //   79: aload 9
    //   81: astore_1
    //   82: aload 5
    //   84: astore 4
    //   86: aload 8
    //   88: iconst_1
    //   89: invokevirtual 376	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   92: aload_2
    //   93: arraylength
    //   94: istore_3
    //   95: aload 7
    //   97: astore 6
    //   99: aload 9
    //   101: astore_1
    //   102: aload 5
    //   104: astore 4
    //   106: aload 8
    //   108: iload_3
    //   109: invokevirtual 379	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   112: aload 7
    //   114: astore 6
    //   116: aload 9
    //   118: astore_1
    //   119: aload 5
    //   121: astore 4
    //   123: aload 8
    //   125: invokevirtual 177	java/net/HttpURLConnection:connect	()V
    //   128: aload 7
    //   130: astore 6
    //   132: aload 9
    //   134: astore_1
    //   135: aload 5
    //   137: astore 4
    //   139: aload 8
    //   141: invokevirtual 383	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   144: astore 9
    //   146: aload 9
    //   148: astore 7
    //   150: aload 7
    //   152: astore 6
    //   154: aload 7
    //   156: astore_1
    //   157: aload 5
    //   159: astore 4
    //   161: aload 9
    //   163: aload_2
    //   164: invokevirtual 387	java/io/OutputStream:write	([B)V
    //   167: aload 7
    //   169: astore 6
    //   171: aload 7
    //   173: astore_1
    //   174: aload 5
    //   176: astore 4
    //   178: aload_0
    //   179: aload 8
    //   181: invokespecial 181	com/google/android/android/internal/zzaop:sendRequest	(Ljava/net/HttpURLConnection;)V
    //   184: aload 7
    //   186: astore 6
    //   188: aload 7
    //   190: astore_1
    //   191: aload 5
    //   193: astore 4
    //   195: aload 8
    //   197: invokevirtual 184	java/net/HttpURLConnection:getResponseCode	()I
    //   200: istore_3
    //   201: iload_3
    //   202: sipush 200
    //   205: if_icmpne +21 -> 226
    //   208: aload 7
    //   210: astore 6
    //   212: aload 7
    //   214: astore_1
    //   215: aload 5
    //   217: astore 4
    //   219: aload_0
    //   220: invokevirtual 188	com/google/android/android/internal/zzamr:zzwc	()Lcom/google/android/android/internal/zzamj;
    //   223: invokevirtual 193	com/google/android/android/internal/zzamj:zzvv	()V
    //   226: aload 7
    //   228: astore 6
    //   230: aload 7
    //   232: astore_1
    //   233: aload 5
    //   235: astore 4
    //   237: aload_0
    //   238: ldc_w 389
    //   241: iload_3
    //   242: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: invokevirtual 168	com/google/android/android/internal/zzamr:add	(Ljava/lang/String;Ljava/lang/Object;)V
    //   248: aload 9
    //   250: invokevirtual 392	java/io/OutputStream:close	()V
    //   253: goto +12 -> 265
    //   256: astore_1
    //   257: aload_0
    //   258: ldc_w 394
    //   261: aload_1
    //   262: invokevirtual 153	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   265: aload 8
    //   267: invokevirtual 203	java/net/HttpURLConnection:disconnect	()V
    //   270: iload_3
    //   271: ireturn
    //   272: astore_2
    //   273: goto +21 -> 294
    //   276: astore_2
    //   277: aconst_null
    //   278: astore 5
    //   280: aload 4
    //   282: astore_1
    //   283: aload 5
    //   285: astore 4
    //   287: goto +57 -> 344
    //   290: astore_2
    //   291: aconst_null
    //   292: astore 5
    //   294: aload 6
    //   296: astore_1
    //   297: aload 5
    //   299: astore 4
    //   301: aload_0
    //   302: ldc_w 396
    //   305: aload_2
    //   306: invokevirtual 207	com/google/android/android/internal/zzamr:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   309: aload 6
    //   311: ifnull +20 -> 331
    //   314: aload 6
    //   316: invokevirtual 392	java/io/OutputStream:close	()V
    //   319: goto +12 -> 331
    //   322: astore_1
    //   323: aload_0
    //   324: ldc_w 394
    //   327: aload_1
    //   328: invokevirtual 153	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   331: aload 5
    //   333: ifnull +8 -> 341
    //   336: aload 5
    //   338: invokevirtual 203	java/net/HttpURLConnection:disconnect	()V
    //   341: iconst_0
    //   342: ireturn
    //   343: astore_2
    //   344: aload_1
    //   345: ifnull +19 -> 364
    //   348: aload_1
    //   349: invokevirtual 392	java/io/OutputStream:close	()V
    //   352: goto +12 -> 364
    //   355: astore_1
    //   356: aload_0
    //   357: ldc_w 394
    //   360: aload_1
    //   361: invokevirtual 153	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   364: aload 4
    //   366: ifnull +8 -> 374
    //   369: aload 4
    //   371: invokevirtual 203	java/net/HttpURLConnection:disconnect	()V
    //   374: aload_2
    //   375: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	zzaop
    //   0	376	1	paramURL	URL
    //   0	376	2	paramArrayOfByte	byte[]
    //   94	177	3	i	int
    //   51	319	4	localObject1	Object
    //   73	264	5	localHttpURLConnection1	HttpURLConnection
    //   45	270	6	localObject2	Object
    //   54	177	7	localOutputStream1	java.io.OutputStream
    //   69	197	8	localHttpURLConnection2	HttpURLConnection
    //   48	201	9	localOutputStream2	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   248	253	256	java/io/IOException
    //   86	92	272	java/io/IOException
    //   106	112	272	java/io/IOException
    //   123	128	272	java/io/IOException
    //   139	146	272	java/io/IOException
    //   161	167	272	java/io/IOException
    //   178	184	272	java/io/IOException
    //   195	201	272	java/io/IOException
    //   219	226	272	java/io/IOException
    //   237	248	272	java/io/IOException
    //   56	71	276	java/lang/Throwable
    //   56	71	290	java/io/IOException
    //   314	319	322	java/io/IOException
    //   86	92	343	java/lang/Throwable
    //   106	112	343	java/lang/Throwable
    //   123	128	343	java/lang/Throwable
    //   139	146	343	java/lang/Throwable
    //   161	167	343	java/lang/Throwable
    //   178	184	343	java/lang/Throwable
    //   195	201	343	java/lang/Throwable
    //   219	226	343	java/lang/Throwable
    //   237	248	343	java/lang/Throwable
    //   301	309	343	java/lang/Throwable
    //   348	352	355	java/io/IOException
  }
  
  /* Error */
  private final int sendRequest(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 164	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 164	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aconst_null
    //   11: astore 10
    //   13: aconst_null
    //   14: astore 9
    //   16: aload_0
    //   17: invokevirtual 369	com/google/android/android/internal/zzamr:getContext	()Landroid/content/Context;
    //   20: invokevirtual 374	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: pop
    //   24: new 398	java/io/ByteArrayOutputStream
    //   27: dup
    //   28: invokespecial 400	java/io/ByteArrayOutputStream:<init>	()V
    //   31: astore 8
    //   33: new 402	java/util/zip/GZIPOutputStream
    //   36: dup
    //   37: aload 8
    //   39: invokespecial 405	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   42: astore 11
    //   44: aload 11
    //   46: aload_2
    //   47: invokevirtual 406	java/util/zip/GZIPOutputStream:write	([B)V
    //   50: aload 11
    //   52: invokevirtual 407	java/util/zip/GZIPOutputStream:close	()V
    //   55: aload 8
    //   57: invokevirtual 408	java/io/ByteArrayOutputStream:close	()V
    //   60: aload 8
    //   62: invokevirtual 411	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   65: astore 11
    //   67: aload 11
    //   69: arraylength
    //   70: istore_3
    //   71: aload 11
    //   73: arraylength
    //   74: i2l
    //   75: lstore 5
    //   77: lload 5
    //   79: ldc2_w 412
    //   82: lmul
    //   83: aload_2
    //   84: arraylength
    //   85: i2l
    //   86: ldiv
    //   87: lstore 5
    //   89: aload_0
    //   90: ldc_w 415
    //   93: iload_3
    //   94: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: lload 5
    //   99: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: aload_1
    //   103: invokevirtual 419	com/google/android/android/internal/zzamr:info	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   106: aload 11
    //   108: arraylength
    //   109: istore_3
    //   110: aload_2
    //   111: arraylength
    //   112: istore 4
    //   114: iload_3
    //   115: iload 4
    //   117: if_icmple +27 -> 144
    //   120: aload 11
    //   122: arraylength
    //   123: istore_3
    //   124: aload_2
    //   125: arraylength
    //   126: istore 4
    //   128: aload_0
    //   129: ldc_w 421
    //   132: iload_3
    //   133: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: iload 4
    //   138: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: invokevirtual 423	com/google/android/android/internal/zzamr:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   144: invokestatic 357	com/google/android/android/internal/zzamr:zzqu	()Z
    //   147: istore 7
    //   149: iload 7
    //   151: ifeq +49 -> 200
    //   154: new 16	java/lang/String
    //   157: dup
    //   158: aload_2
    //   159: invokespecial 362	java/lang/String:<init>	([B)V
    //   162: astore_2
    //   163: aload_2
    //   164: invokevirtual 132	java/lang/String:length	()I
    //   167: istore_3
    //   168: iload_3
    //   169: ifeq +13 -> 182
    //   172: ldc 14
    //   174: aload_2
    //   175: invokevirtual 136	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore_2
    //   179: goto +13 -> 192
    //   182: new 16	java/lang/String
    //   185: dup
    //   186: ldc 14
    //   188: invokespecial 139	java/lang/String:<init>	(Ljava/lang/String;)V
    //   191: astore_2
    //   192: aload_0
    //   193: ldc_w 425
    //   196: aload_2
    //   197: invokevirtual 365	com/google/android/android/internal/zzamr:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   200: aload_0
    //   201: aload_1
    //   202: invokespecial 172	com/google/android/android/internal/zzaop:openConnection	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   205: astore 8
    //   207: aload 8
    //   209: iconst_1
    //   210: invokevirtual 376	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   213: aload 8
    //   215: ldc_w 427
    //   218: ldc_w 429
    //   221: invokevirtual 432	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 11
    //   226: arraylength
    //   227: istore_3
    //   228: aload 8
    //   230: iload_3
    //   231: invokevirtual 379	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   234: aload 8
    //   236: invokevirtual 177	java/net/HttpURLConnection:connect	()V
    //   239: aload 8
    //   241: invokevirtual 383	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   244: astore_1
    //   245: aload_1
    //   246: aload 11
    //   248: invokevirtual 387	java/io/OutputStream:write	([B)V
    //   251: aload_1
    //   252: invokevirtual 392	java/io/OutputStream:close	()V
    //   255: aload_0
    //   256: aload 8
    //   258: invokespecial 181	com/google/android/android/internal/zzaop:sendRequest	(Ljava/net/HttpURLConnection;)V
    //   261: aload 8
    //   263: invokevirtual 184	java/net/HttpURLConnection:getResponseCode	()I
    //   266: istore_3
    //   267: iload_3
    //   268: sipush 200
    //   271: if_icmpne +10 -> 281
    //   274: aload_0
    //   275: invokevirtual 188	com/google/android/android/internal/zzamr:zzwc	()Lcom/google/android/android/internal/zzamj;
    //   278: invokevirtual 193	com/google/android/android/internal/zzamj:zzvv	()V
    //   281: aload_0
    //   282: ldc_w 389
    //   285: iload_3
    //   286: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: invokevirtual 168	com/google/android/android/internal/zzamr:add	(Ljava/lang/String;Ljava/lang/Object;)V
    //   292: aload 8
    //   294: invokevirtual 203	java/net/HttpURLConnection:disconnect	()V
    //   297: iload_3
    //   298: ireturn
    //   299: astore 9
    //   301: aload_1
    //   302: astore_2
    //   303: aload 9
    //   305: astore_1
    //   306: goto +85 -> 391
    //   309: astore 9
    //   311: aload_1
    //   312: astore_2
    //   313: aload 9
    //   315: astore_1
    //   316: goto +34 -> 350
    //   319: astore_1
    //   320: aload 10
    //   322: astore_2
    //   323: goto +68 -> 391
    //   326: astore_1
    //   327: aload 9
    //   329: astore_2
    //   330: goto +20 -> 350
    //   333: astore_1
    //   334: aconst_null
    //   335: astore 8
    //   337: aload 10
    //   339: astore_2
    //   340: goto +51 -> 391
    //   343: astore_1
    //   344: aconst_null
    //   345: astore 8
    //   347: aload 9
    //   349: astore_2
    //   350: aload_0
    //   351: ldc_w 434
    //   354: aload_1
    //   355: invokevirtual 207	com/google/android/android/internal/zzamr:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   358: aload_2
    //   359: ifnull +19 -> 378
    //   362: aload_2
    //   363: invokevirtual 392	java/io/OutputStream:close	()V
    //   366: goto +12 -> 378
    //   369: astore_1
    //   370: aload_0
    //   371: ldc_w 436
    //   374: aload_1
    //   375: invokevirtual 153	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   378: aload 8
    //   380: ifnull +8 -> 388
    //   383: aload 8
    //   385: invokevirtual 203	java/net/HttpURLConnection:disconnect	()V
    //   388: iconst_0
    //   389: ireturn
    //   390: astore_1
    //   391: aload_2
    //   392: ifnull +19 -> 411
    //   395: aload_2
    //   396: invokevirtual 392	java/io/OutputStream:close	()V
    //   399: goto +12 -> 411
    //   402: astore_2
    //   403: aload_0
    //   404: ldc_w 436
    //   407: aload_2
    //   408: invokevirtual 153	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   411: aload 8
    //   413: ifnull +8 -> 421
    //   416: aload 8
    //   418: invokevirtual 203	java/net/HttpURLConnection:disconnect	()V
    //   421: aload_1
    //   422: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	zzaop
    //   0	423	1	paramURL	URL
    //   0	423	2	paramArrayOfByte	byte[]
    //   70	228	3	i	int
    //   112	25	4	j	int
    //   75	23	5	l	long
    //   147	3	7	bool	boolean
    //   31	386	8	localObject1	Object
    //   14	1	9	localObject2	Object
    //   299	5	9	localThrowable	Throwable
    //   309	39	9	localIOException	IOException
    //   11	327	10	localObject3	Object
    //   42	205	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   245	255	299	java/lang/Throwable
    //   245	255	309	java/io/IOException
    //   207	224	319	java/lang/Throwable
    //   228	245	319	java/lang/Throwable
    //   255	267	319	java/lang/Throwable
    //   274	281	319	java/lang/Throwable
    //   281	292	319	java/lang/Throwable
    //   207	224	326	java/io/IOException
    //   228	245	326	java/io/IOException
    //   255	267	326	java/io/IOException
    //   274	281	326	java/io/IOException
    //   281	292	326	java/io/IOException
    //   16	24	333	java/lang/Throwable
    //   24	33	333	java/lang/Throwable
    //   33	67	333	java/lang/Throwable
    //   67	71	333	java/lang/Throwable
    //   71	77	333	java/lang/Throwable
    //   77	89	333	java/lang/Throwable
    //   89	106	333	java/lang/Throwable
    //   106	114	333	java/lang/Throwable
    //   120	124	333	java/lang/Throwable
    //   128	144	333	java/lang/Throwable
    //   144	149	333	java/lang/Throwable
    //   154	168	333	java/lang/Throwable
    //   172	179	333	java/lang/Throwable
    //   182	192	333	java/lang/Throwable
    //   192	200	333	java/lang/Throwable
    //   200	207	333	java/lang/Throwable
    //   16	24	343	java/io/IOException
    //   24	33	343	java/io/IOException
    //   33	67	343	java/io/IOException
    //   89	106	343	java/io/IOException
    //   128	144	343	java/io/IOException
    //   144	149	343	java/io/IOException
    //   154	168	343	java/io/IOException
    //   172	179	343	java/io/IOException
    //   182	192	343	java/io/IOException
    //   192	200	343	java/io/IOException
    //   200	207	343	java/io/IOException
    //   362	366	369	java/io/IOException
    //   350	358	390	java/lang/Throwable
    //   395	399	402	java/io/IOException
  }
  
  /* Error */
  private final void sendRequest(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 440	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4: astore_3
    //   5: aload_3
    //   6: astore_1
    //   7: sipush 1024
    //   10: newarray byte
    //   12: astore 4
    //   14: aload_3
    //   15: aload 4
    //   17: invokevirtual 445	java/io/InputStream:read	([B)I
    //   20: istore_2
    //   21: iload_2
    //   22: ifgt -8 -> 14
    //   25: aload_3
    //   26: invokevirtual 446	java/io/InputStream:close	()V
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: ldc_w 448
    //   35: aload_1
    //   36: invokevirtual 153	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   39: return
    //   40: astore 4
    //   42: aload_1
    //   43: astore_3
    //   44: aload 4
    //   46: astore_1
    //   47: goto +6 -> 53
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +19 -> 73
    //   57: aload_3
    //   58: invokevirtual 446	java/io/InputStream:close	()V
    //   61: goto +12 -> 73
    //   64: astore_3
    //   65: aload_0
    //   66: ldc_w 448
    //   69: aload_3
    //   70: invokevirtual 153	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   73: goto +3 -> 76
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	zzaop
    //   0	78	1	paramHttpURLConnection	HttpURLConnection
    //   20	2	2	i	int
    //   4	54	3	localObject	Object
    //   64	6	3	localIOException	IOException
    //   12	4	4	arrayOfByte	byte[]
    //   40	5	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   25	29	30	java/io/IOException
    //   7	14	40	java/lang/Throwable
    //   14	21	40	java/lang/Throwable
    //   0	5	50	java/lang/Throwable
    //   57	61	64	java/io/IOException
  }
  
  private final URL zzyy()
  {
    Object localObject = String.valueOf(zzanv.zzyb());
    String str = String.valueOf((String)zzaod.zzdrs.setDoOutput());
    if (str.length() != 0) {
      localObject = ((String)localObject).concat(str);
    } else {
      localObject = new String((String)localObject);
    }
    try
    {
      localObject = new URL((String)localObject);
      return localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      toString("Error trying to parse the hardcoded host url", localMalformedURLException);
    }
    return null;
  }
  
  public final List calculate(List paramList)
  {
    TerminalManager.zzuj();
    zzwk();
    zzbp.append(paramList);
    boolean bool2 = zzvz().zzye().isEmpty();
    boolean bool1 = false;
    int i;
    int j;
    if ((!bool2) && (zzdtl.calculate(((Integer)zzaod.zzdsb.setDoOutput()).intValue() * 1000L)))
    {
      if (zzanl.zzdv((String)zzaod.zzdru.setDoOutput()) != zzanl.zzdqa) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (zzanr.zzdw((String)zzaod.zzdrv.setDoOutput()) == zzanr.zzdql)
      {
        bool1 = true;
        j = i;
      }
    }
    else
    {
      j = 0;
    }
    if (j != 0)
    {
      zzbp.zzbh(paramList.isEmpty() ^ true);
      add("Uploading batched hits. compression, count", Boolean.valueOf(bool1), Integer.valueOf(paramList.size()));
      zzaoq localZzaoq = new zzaoq(this);
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        zzaoi localZzaoi = (zzaoi)paramList.next();
        if (!localZzaoq.multiply(localZzaoi)) {
          break;
        }
        localArrayList.add(Long.valueOf(localZzaoi.zzym()));
      }
      if (localZzaoq.zzza() == 0) {
        return localArrayList;
      }
      paramList = zzyy();
      if (paramList == null)
      {
        zzdq("Failed to build batching endpoint url");
      }
      else
      {
        if (bool1) {
          i = sendRequest(paramList, localZzaoq.getPayload());
        } else {
          i = send(paramList, localZzaoq.getPayload());
        }
        if (200 == i)
        {
          d("Batched upload completed. Hits batched", Integer.valueOf(localZzaoq.zzza()));
          return localArrayList;
        }
        d("Network error uploading hits. status code", Integer.valueOf(i));
        if (zzvz().zzye().contains(Integer.valueOf(i)))
        {
          zzdp("Server instructed the client to stop batching");
          zzdtl.start();
        }
      }
      return Collections.emptyList();
    }
    return request(paramList);
  }
  
  public final String create(zzaoi paramZzaoi, boolean paramBoolean)
  {
    zzbp.append(paramZzaoi);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramZzaoi.zziy().entrySet().iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        Object localObject1 = localIterator.next();
        Object localObject2 = (Map.Entry)localObject1;
        localObject1 = ((Map.Entry)localObject2).getKey();
        localObject1 = (String)localObject1;
        bool = "ht".equals(localObject1);
        if (!bool)
        {
          bool = "qt".equals(localObject1);
          if (!bool)
          {
            bool = "AppUID".equals(localObject1);
            if (!bool)
            {
              bool = "z".equals(localObject1);
              if (!bool)
              {
                bool = "_gmsv".equals(localObject1);
                if (!bool)
                {
                  localObject2 = ((Map.Entry)localObject2).getValue();
                  localObject2 = (String)localObject2;
                  add(localStringBuilder, (String)localObject1, (String)localObject2);
                }
              }
            }
          }
        }
      }
      add(localStringBuilder, "ht", String.valueOf(paramZzaoi.zzyn()));
      long l1 = zzvx().currentTimeMillis();
      long l2 = paramZzaoi.zzyn();
      add(localStringBuilder, "qt", String.valueOf(l1 - l2));
      if (paramBoolean)
      {
        l1 = paramZzaoi.zzyq();
        if (l1 != 0L) {
          paramZzaoi = String.valueOf(l1);
        } else {
          paramZzaoi = String.valueOf(paramZzaoi.zzym());
        }
        add(localStringBuilder, "z", paramZzaoi);
      }
      paramZzaoi = localStringBuilder.toString();
      return paramZzaoi;
    }
    catch (UnsupportedEncodingException paramZzaoi)
    {
      toString("Failed to encode name or value", paramZzaoi);
    }
    return null;
  }
  
  public final void zzuk()
  {
    d("Network initialized. User agent", zzbwi);
  }
  
  public final boolean zzyx()
  {
    TerminalManager.zzuj();
    zzwk();
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    localObject = null;
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
      return true;
    }
    zzdm("No network connectivity");
    return false;
  }
}
