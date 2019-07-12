package support.android.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;

public final class MultiDexExtractor
{
  public static final int BUFFER_SIZE = 16384;
  public static final String DEX_PREFIX = "classes";
  public static final String DEX_SUFFIX = ".dex";
  public static final String EVENTLOG_URL = "dex.time.";
  public static final String EXTRACTED_NAME_EXT = ".classes";
  public static final String EXTRACTED_SUFFIX = ".zip";
  public static final long GLOBAL_ATTRIBUTE_DB_ID = -1L;
  public static final String KEY_CRC = "crc";
  public static final String KEY_DEX_NUMBER = "dex.number";
  public static final String KEY_TIME_STAMP = "timestamp";
  public static final int MAX_EXTRACT_ATTEMPTS = 3;
  public static final String NO_VALUE = "dex.crc.";
  public static final String PAGE_KEY = "MultiDex.lock";
  public static final String PREFS_FILE = "multidex.version";
  public static final String TAG = "MultiDex";
  
  public MultiDexExtractor() {}
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  /* Error */
  public static void extract(ZipFile paramZipFile, java.util.zip.ZipEntry paramZipEntry, File paramFile, String paramString)
    throws IOException, java.io.FileNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 78	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore 6
    //   7: ldc 80
    //   9: aload_3
    //   10: invokestatic 86	f/sufficientlysecure/rootcommands/util/StringBuilder:toString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13: ldc 25
    //   15: aload_2
    //   16: invokevirtual 92	java/io/File:getParentFile	()Ljava/io/File;
    //   19: invokestatic 96	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   22: astore_0
    //   23: ldc 98
    //   25: invokestatic 102	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: astore_3
    //   29: aload_3
    //   30: aload_0
    //   31: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   34: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: pop
    //   43: new 113	java/util/zip/ZipOutputStream
    //   46: dup
    //   47: new 115	java/io/BufferedOutputStream
    //   50: dup
    //   51: new 117	java/io/FileOutputStream
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 123	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: invokespecial 124	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_3
    //   66: new 126	java/util/zip/ZipEntry
    //   69: dup
    //   70: ldc -128
    //   72: invokespecial 131	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   75: astore 7
    //   77: aload 7
    //   79: aload_1
    //   80: invokevirtual 135	java/util/zip/ZipEntry:getTime	()J
    //   83: invokevirtual 139	java/util/zip/ZipEntry:setTime	(J)V
    //   86: aload_3
    //   87: aload 7
    //   89: invokevirtual 143	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   92: sipush 16384
    //   95: newarray byte
    //   97: astore_1
    //   98: aload 6
    //   100: aload_1
    //   101: invokevirtual 149	java/io/InputStream:read	([B)I
    //   104: istore 4
    //   106: iload 4
    //   108: iconst_m1
    //   109: if_icmpeq +22 -> 131
    //   112: aload_3
    //   113: aload_1
    //   114: iconst_0
    //   115: iload 4
    //   117: invokevirtual 153	java/util/zip/ZipOutputStream:write	([BII)V
    //   120: aload 6
    //   122: aload_1
    //   123: invokevirtual 149	java/io/InputStream:read	([B)I
    //   126: istore 4
    //   128: goto -22 -> 106
    //   131: aload_3
    //   132: invokevirtual 156	java/util/zip/ZipOutputStream:closeEntry	()V
    //   135: aload_3
    //   136: invokevirtual 157	java/util/zip/ZipOutputStream:close	()V
    //   139: aload_0
    //   140: invokevirtual 161	java/io/File:setReadOnly	()Z
    //   143: istore 5
    //   145: iload 5
    //   147: ifeq +116 -> 263
    //   150: new 108	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   157: astore_1
    //   158: aload_1
    //   159: ldc -92
    //   161: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: aload_2
    //   167: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   170: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_1
    //   175: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: pop
    //   179: aload_0
    //   180: aload_2
    //   181: invokevirtual 168	java/io/File:renameTo	(Ljava/io/File;)Z
    //   184: istore 5
    //   186: iload 5
    //   188: ifeq +16 -> 204
    //   191: aload 6
    //   193: invokeinterface 66 1 0
    //   198: aload_0
    //   199: invokevirtual 171	java/io/File:delete	()Z
    //   202: pop
    //   203: return
    //   204: new 108	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   211: astore_1
    //   212: aload_1
    //   213: ldc -83
    //   215: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_1
    //   220: aload_0
    //   221: invokevirtual 176	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   224: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_1
    //   229: ldc -78
    //   231: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_1
    //   236: aload_2
    //   237: invokevirtual 176	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   240: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_1
    //   245: ldc -76
    //   247: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: new 61	java/io/IOException
    //   254: dup
    //   255: aload_1
    //   256: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokespecial 181	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   262: athrow
    //   263: new 108	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   270: astore_1
    //   271: aload_1
    //   272: ldc -73
    //   274: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_1
    //   279: aload_0
    //   280: invokevirtual 176	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   283: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: ldc -71
    //   290: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_1
    //   295: aload_2
    //   296: invokevirtual 176	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   299: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_1
    //   304: ldc -69
    //   306: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: new 61	java/io/IOException
    //   313: dup
    //   314: aload_1
    //   315: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokespecial 181	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   321: athrow
    //   322: astore_1
    //   323: aload_3
    //   324: invokevirtual 157	java/util/zip/ZipOutputStream:close	()V
    //   327: aload_1
    //   328: athrow
    //   329: astore_1
    //   330: aload 6
    //   332: invokeinterface 66 1 0
    //   337: aload_0
    //   338: invokevirtual 171	java/io/File:delete	()Z
    //   341: pop
    //   342: goto +3 -> 345
    //   345: aload_1
    //   346: athrow
    //   347: astore_1
    //   348: goto -150 -> 198
    //   351: astore_2
    //   352: goto -15 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	paramZipFile	ZipFile
    //   0	355	1	paramZipEntry	java.util.zip.ZipEntry
    //   0	355	2	paramFile	File
    //   0	355	3	paramString	String
    //   104	23	4	i	int
    //   143	44	5	bool	boolean
    //   5	326	6	localInputStream	java.io.InputStream
    //   75	13	7	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   66	106	322	java/lang/Throwable
    //   112	128	322	java/lang/Throwable
    //   131	135	322	java/lang/Throwable
    //   43	66	329	java/lang/Throwable
    //   135	145	329	java/lang/Throwable
    //   150	186	329	java/lang/Throwable
    //   204	263	329	java/lang/Throwable
    //   263	322	329	java/lang/Throwable
    //   323	329	329	java/lang/Throwable
    //   191	198	347	java/io/IOException
    //   330	337	351	java/io/IOException
  }
  
  public static SharedPreferences getMultiDexPreferences(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    return paramContext.getSharedPreferences("multidex.version", 4);
  }
  
  public static long getTimeStamp(File paramFile)
  {
    long l2 = paramFile.lastModified();
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  public static boolean isModified(Context paramContext, File paramFile, long paramLong, String paramString)
  {
    paramContext = getMultiDexPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("timestamp");
    if (paramContext.getLong(localStringBuilder.toString(), -1L) == getTimeStamp(paramFile))
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("crc");
      if (paramContext.getLong(paramFile.toString(), -1L) == paramLong) {
        return false;
      }
    }
    return true;
  }
  
  public static List load(Context paramContext, File paramFile1, File paramFile2, String paramString)
    throws IOException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile1.getName());
    ((StringBuilder)localObject).append(".classes");
    paramFile1 = ((StringBuilder)localObject).toString();
    localObject = getMultiDexPreferences(paramContext);
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append("dex.number");
    int j = ((SharedPreferences)localObject).getInt(paramContext.toString(), 1);
    ArrayList localArrayList = new ArrayList(j - 1);
    int i = 2;
    while (i <= j)
    {
      paramContext = new Shader(paramFile2, f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramFile1, i, ".zip"));
      if (paramContext.isFile())
      {
        length = toString(paramContext);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("dex.crc.");
        localStringBuilder.append(i);
        long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), -1L);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("dex.time.");
        localStringBuilder.append(i);
        long l2 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), -1L);
        long l3 = paramContext.lastModified();
        if ((l2 == l3) && (l1 == length))
        {
          localArrayList.add(paramContext);
          i += 1;
        }
        else
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Invalid extracted dex: ");
          paramFile1.append(paramContext);
          paramFile1.append(" (key \"");
          paramFile1.append(paramString);
          paramFile1.append("\"), expected modification time: ");
          paramFile1.append(l2);
          paramFile1.append(", modification time: ");
          paramFile1.append(l3);
          paramFile1.append(", expected crc: ");
          paramFile1.append(l1);
          paramFile1.append(", file crc: ");
          paramFile1.append(length);
          throw new IOException(paramFile1.toString());
        }
      }
      else
      {
        paramFile1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Missing extracted secondary dex file '");
        paramFile1.append(paramContext.getPath());
        paramFile1.append("'");
        throw new IOException(paramFile1.toString());
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public static List load(Context paramContext, File paramFile1, File paramFile2, String paramString, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: ldc_w 280
    //   3: invokestatic 102	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6: astore 7
    //   8: aload 7
    //   10: aload_1
    //   11: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   14: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 7
    //   20: ldc_w 282
    //   23: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 7
    //   29: iload 4
    //   31: invokevirtual 285	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: ldc_w 282
    //   40: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 7
    //   46: aload_3
    //   47: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 7
    //   53: ldc_w 287
    //   56: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 7
    //   62: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: pop
    //   66: aload_1
    //   67: invokestatic 243	support/android/widget/MultiDexExtractor:toString	(Ljava/io/File;)J
    //   70: lstore 5
    //   72: new 88	java/io/File
    //   75: dup
    //   76: aload_2
    //   77: ldc 46
    //   79: invokespecial 288	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   82: astore 13
    //   84: new 290	java/io/RandomAccessFile
    //   87: dup
    //   88: aload 13
    //   90: ldc_w 292
    //   93: invokespecial 293	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   96: astore 12
    //   98: aconst_null
    //   99: astore 11
    //   101: aconst_null
    //   102: astore 9
    //   104: aload 12
    //   106: invokevirtual 297	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   109: astore 8
    //   111: aload 8
    //   113: astore 7
    //   115: new 108	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   122: astore 10
    //   124: aload 10
    //   126: ldc_w 299
    //   129: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 10
    //   135: aload 13
    //   137: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   140: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 10
    //   146: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: pop
    //   150: aload 8
    //   152: invokevirtual 305	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   155: astore 10
    //   157: new 108	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   164: astore 11
    //   166: aload 11
    //   168: aload 13
    //   170: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   173: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 11
    //   179: ldc_w 307
    //   182: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 11
    //   188: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: pop
    //   192: iload 4
    //   194: ifne +61 -> 255
    //   197: aload_0
    //   198: aload_1
    //   199: lload 5
    //   201: aload_3
    //   202: invokestatic 309	support/android/widget/MultiDexExtractor:isModified	(Landroid/content/Context;Ljava/io/File;JLjava/lang/String;)Z
    //   205: istore 4
    //   207: iload 4
    //   209: ifne +46 -> 255
    //   212: aload_0
    //   213: aload_1
    //   214: aload_2
    //   215: aload_3
    //   216: invokestatic 311	support/android/widget/MultiDexExtractor:load	(Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/util/List;
    //   219: astore 11
    //   221: aload 11
    //   223: astore_0
    //   224: goto +56 -> 280
    //   227: aload_1
    //   228: aload_2
    //   229: invokestatic 315	support/android/widget/MultiDexExtractor:performExtractions	(Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   232: astore 11
    //   234: aload 11
    //   236: astore_2
    //   237: aload_0
    //   238: aload_3
    //   239: aload_1
    //   240: invokestatic 218	support/android/widget/MultiDexExtractor:getTimeStamp	(Ljava/io/File;)J
    //   243: lload 5
    //   245: aload 11
    //   247: invokestatic 319	support/android/widget/MultiDexExtractor:put	(Landroid/content/Context;Ljava/lang/String;JJLjava/util/List;)V
    //   250: aload_2
    //   251: astore_0
    //   252: goto +28 -> 280
    //   255: aload_1
    //   256: aload_2
    //   257: invokestatic 315	support/android/widget/MultiDexExtractor:performExtractions	(Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   260: astore 11
    //   262: aload 11
    //   264: astore_2
    //   265: aload_0
    //   266: aload_3
    //   267: aload_1
    //   268: invokestatic 218	support/android/widget/MultiDexExtractor:getTimeStamp	(Ljava/io/File;)J
    //   271: lload 5
    //   273: aload 11
    //   275: invokestatic 319	support/android/widget/MultiDexExtractor:put	(Landroid/content/Context;Ljava/lang/String;JJLjava/util/List;)V
    //   278: aload_2
    //   279: astore_0
    //   280: aload 9
    //   282: astore_1
    //   283: aload 10
    //   285: ifnull +37 -> 322
    //   288: aload 10
    //   290: invokevirtual 324	java/nio/channels/FileLock:release	()V
    //   293: aload 9
    //   295: astore_1
    //   296: goto +26 -> 322
    //   299: astore_1
    //   300: ldc_w 326
    //   303: invokestatic 102	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: astore_2
    //   307: aload_2
    //   308: aload 13
    //   310: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   313: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_2
    //   318: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: pop
    //   322: aload 8
    //   324: invokeinterface 66 1 0
    //   329: aload 12
    //   331: invokeinterface 66 1 0
    //   336: aload_1
    //   337: ifnonnull +36 -> 373
    //   340: ldc_w 328
    //   343: invokestatic 102	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: astore_1
    //   347: aload_1
    //   348: aload_0
    //   349: invokeinterface 332 1 0
    //   354: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_1
    //   359: ldc_w 334
    //   362: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_1
    //   367: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: pop
    //   371: aload_0
    //   372: areturn
    //   373: aload_1
    //   374: checkcast 72	java/lang/Throwable
    //   377: athrow
    //   378: astore_0
    //   379: aload 10
    //   381: astore_1
    //   382: goto +17 -> 399
    //   385: astore_0
    //   386: aload 11
    //   388: astore_1
    //   389: goto +10 -> 399
    //   392: astore_0
    //   393: aconst_null
    //   394: astore 7
    //   396: aload 11
    //   398: astore_1
    //   399: aload_1
    //   400: ifnull +37 -> 437
    //   403: aload_1
    //   404: checkcast 321	java/nio/channels/FileLock
    //   407: astore_1
    //   408: aload_1
    //   409: invokevirtual 324	java/nio/channels/FileLock:release	()V
    //   412: goto +25 -> 437
    //   415: ldc_w 326
    //   418: invokestatic 102	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: astore_1
    //   422: aload_1
    //   423: aload 13
    //   425: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   428: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_1
    //   433: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: pop
    //   437: aload 7
    //   439: ifnull +10 -> 449
    //   442: aload 7
    //   444: invokeinterface 66 1 0
    //   449: aload 12
    //   451: invokeinterface 66 1 0
    //   456: aload_0
    //   457: athrow
    //   458: astore 11
    //   460: goto -233 -> 227
    //   463: astore_2
    //   464: goto -135 -> 329
    //   467: astore_2
    //   468: goto -132 -> 336
    //   471: astore_1
    //   472: goto -57 -> 415
    //   475: astore_1
    //   476: goto -27 -> 449
    //   479: astore_1
    //   480: goto -24 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	paramContext	Context
    //   0	483	1	paramFile1	File
    //   0	483	2	paramFile2	File
    //   0	483	3	paramString	String
    //   0	483	4	paramBoolean	boolean
    //   70	202	5	l	long
    //   6	437	7	localObject1	Object
    //   109	214	8	localFileChannel	java.nio.channels.FileChannel
    //   102	192	9	localObject2	Object
    //   122	258	10	localObject3	Object
    //   99	298	11	localObject4	Object
    //   458	1	11	localIOException	IOException
    //   96	354	12	localRandomAccessFile	java.io.RandomAccessFile
    //   82	342	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   288	293	299	java/io/IOException
    //   157	192	378	java/lang/Throwable
    //   197	207	378	java/lang/Throwable
    //   212	221	378	java/lang/Throwable
    //   227	234	378	java/lang/Throwable
    //   237	250	378	java/lang/Throwable
    //   255	262	378	java/lang/Throwable
    //   265	278	378	java/lang/Throwable
    //   115	157	385	java/lang/Throwable
    //   104	111	392	java/lang/Throwable
    //   212	221	458	java/io/IOException
    //   322	329	463	java/io/IOException
    //   329	336	467	java/io/IOException
    //   408	412	471	java/io/IOException
    //   442	449	475	java/io/IOException
    //   449	456	479	java/io/IOException
  }
  
  public static List performExtractions(File paramFile1, File paramFile2)
    throws IOException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile1.getName());
    ((StringBuilder)localObject).append(".classes");
    String str = ((StringBuilder)localObject).toString();
    prepareDexDir(paramFile2, str);
    localArrayList = new ArrayList();
    ZipFile localZipFile = new ZipFile(paramFile1);
    int j = 2;
    for (;;)
    {
      try
      {
        paramFile1 = new StringBuilder();
        paramFile1.append("classes");
        paramFile1.append(2);
        paramFile1.append(".dex");
        paramFile1 = localZipFile.getEntry(paramFile1.toString());
        if (paramFile1 != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(".zip");
          localShader = new Shader(paramFile2, ((StringBuilder)localObject).toString());
          localArrayList.add(localShader);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Extraction is needed for file ");
          ((StringBuilder)localObject).append(localShader);
          ((StringBuilder)localObject).toString();
          m = 0;
          k = 0;
          if ((m < 3) && (k == 0))
          {
            n = m + 1;
            extract(localZipFile, paramFile1, localShader, str);
          }
        }
      }
      catch (Throwable paramFile1)
      {
        try
        {
          Shader localShader;
          int m;
          int k;
          int n;
          long l;
          int i;
          StringBuilder localStringBuilder;
          boolean bool;
          localZipFile.close();
          return localArrayList;
        }
        catch (IOException paramFile1)
        {
          return localArrayList;
        }
        paramFile1 = paramFile1;
      }
      try
      {
        l = toString(localShader);
        length = l;
        i = 1;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to read crc from ");
      ((StringBuilder)localObject).append(localShader.getAbsolutePath());
      ((StringBuilder)localObject).toString();
      i = 0;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Extraction ");
      if (i != 0) {
        localObject = "succeeded";
      } else {
        localObject = "failed";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" - length ");
      localStringBuilder.append(localShader.getAbsolutePath());
      localStringBuilder.append(": ");
      localStringBuilder.append(localShader.length());
      localStringBuilder.append(" - crc: ");
      localStringBuilder.append(length);
      localStringBuilder.toString();
      m = n;
      k = i;
      if (i == 0)
      {
        localShader.delete();
        bool = localShader.exists();
        m = n;
        k = i;
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to delete corrupted secondary dex '");
          ((StringBuilder)localObject).append(localShader.getPath());
          ((StringBuilder)localObject).append("'");
          ((StringBuilder)localObject).toString();
          m = n;
          k = i;
          continue;
          if (k == 0) {
            continue;
          }
          j += 1;
          paramFile1 = new StringBuilder();
          paramFile1.append("classes");
          paramFile1.append(j);
          paramFile1.append(".dex");
          paramFile1 = localZipFile.getEntry(paramFile1.toString());
        }
      }
    }
    paramFile1 = new StringBuilder();
    paramFile1.append("Could not create zip file ");
    paramFile1.append(localShader.getAbsolutePath());
    paramFile1.append(" for secondary dex (");
    paramFile1.append(j);
    paramFile1.append(")");
    throw new IOException(paramFile1.toString());
    try
    {
      localZipFile.close();
    }
    catch (IOException paramFile2)
    {
      for (;;) {}
    }
    throw paramFile1;
  }
  
  public static void prepareDexDir(File paramFile, String paramString)
  {
    paramString = paramFile.listFiles(new MultiDexExtractor.1(paramString));
    if (paramString == null)
    {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to list secondary dex dir content (");
      paramString.append(paramFile.getPath());
      paramString.append(").");
      paramString.toString();
      return;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramFile = paramString[i];
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Trying to delete old file ");
      localStringBuilder.append(paramFile.getPath());
      localStringBuilder.append(" of size ");
      localStringBuilder.append(paramFile.length());
      localStringBuilder.toString();
      if (!paramFile.delete())
      {
        localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to delete old file ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Deleted old file ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.toString();
      }
      i += 1;
    }
  }
  
  public static void put(Context paramContext, String paramString, long paramLong1, long paramLong2, List paramList)
  {
    paramContext = getMultiDexPreferences(paramContext).edit();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("timestamp");
    paramContext.putLong(((StringBuilder)localObject).toString(), paramLong1);
    paramContext.putLong(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), paramString, "crc"), paramLong2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("dex.number");
    paramContext.putInt(((StringBuilder)localObject).toString(), paramList.size() + 1);
    paramList = paramList.iterator();
    int i = 2;
    while (paramList.hasNext())
    {
      localObject = (Shader)paramList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("dex.crc.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), length);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("dex.time.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), ((File)localObject).lastModified());
      i += 1;
    }
    paramContext.commit();
  }
  
  public static long toString(File paramFile)
    throws IOException
  {
    long l2 = ZipUtil.getZipCrc(paramFile);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
}
