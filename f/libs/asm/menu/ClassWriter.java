package f.libs.asm.menu;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import l.a.a.a.Log;
import l.a.a.a.a.b.Handle;
import l.a.a.a.a.b.MethodVisitor;
import l.a.a.a.a.b.o;
import l.a.a.a.a.g.Label;

public class ClassWriter
{
  public static final String C = "invalidClsFiles";
  public static final String CLASS = "BeginSession";
  public static final int COMPUTE_FRAMES = 64;
  public static final int COMPUTE_MAXS = 1;
  public static final boolean D = false;
  public static final String DOUBLE = "_r";
  public static final String E = "SessionCrash";
  public static final String EXTENSION = ".json";
  public static final int FIELD = 1;
  public static final String FLOAT = "crash";
  public static final String H = "SessionMissingBinaryImages";
  public static final String I = "Crashlytics Android SDK/%s";
  public static final int IMPLVAR_INSN = 4;
  public static final String INT = "com.crashlytics.ApiEndpoint";
  public static final String J = "SessionEvent";
  public static final String K = "SessionApp";
  public static final String KEY_TIMESTAMP = "timestamp";
  public static final FilenameFilter L = new NotificationLite("BeginSession");
  public static final int LDC_INSN = 8;
  public static final String LONG = "fatal";
  public static final int LOOK_INSN = 1024;
  public static final int M = 35;
  public static final int METH = 10;
  public static final FileFilter N;
  public static final Comparator<File> O;
  public static final String STATE_ERROR = "error";
  public static final String e = "_ae";
  public static final String f = "SessionDevice";
  public static final String key = "SessionOS";
  public static final String l = "fatal-sessions";
  public static final Pattern p = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
  public static final Map<String, String> q = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
  public static final FilenameFilter r = new MainActivity.2();
  public static final String[] s = { "SessionUser", "SessionApp", "SessionOS", "SessionDevice" };
  public static final String t = "nonfatal-sessions";
  public static final String threshold = "com.crashlytics.CollectCustomKeys";
  public static final String version = "SessionUser";
  public static final String x = "clx";
  public static final Comparator<File> y;
  public ExceptionHandler A;
  public final e a;
  public final l.a.a.a.a.b.f b;
  public final f c;
  public final Context d;
  public final ImageLoader.Task g;
  public final l.a.a.a.a.e.LayoutManager h;
  public final LayoutManager i;
  public final AtomicInteger index = new AtomicInteger(0);
  public final Path j;
  public final b k;
  public final f.libs.asm.asm.k m;
  public final Qa.b n;
  public final Frame o;
  public final l.a.a.a.a.f.a u;
  public final String v;
  public final CopyOnWriteArrayList w;
  public final Qa.c z;
  
  static
  {
    N = new FalseFileFilter();
    O = new HeapElement.1();
    y = new Version.BuildAwareOrder();
  }
  
  public ClassWriter(f paramF, Context paramContext, l.a.a.a.a.e.LayoutManager paramLayoutManager, l.a.a.a.a.b.f paramF1, ImageLoader.Task paramTask, l.a.a.a.a.f.a paramA, e paramE, k paramK, CopyOnWriteArrayList paramCopyOnWriteArrayList, f.libs.asm.asm.k paramK1)
  {
    c = paramF;
    d = paramContext;
    h = paramLayoutManager;
    b = paramF1;
    g = paramTask;
    u = paramA;
    a = paramE;
    v = paramK.a();
    w = paramCopyOnWriteArrayList;
    m = paramK1;
    paramF = paramF.getContext();
    i = new LayoutManager(paramA);
    k = new b(paramF, i);
    z = new FileList(this, null);
    n = new k.a(this, null);
    o = new Frame(paramF);
    j = new PathParser(1024, new Path[] { new GroupExtractor(10) });
  }
  
  private Item a(String paramString)
  {
    if (get()) {
      return new Item(c.getCount(), c.f(), c.a());
    }
    return new g(d()).a(paramString);
  }
  
  private void a()
    throws Exception
  {
    Date localDate = new Date();
    String str = new Attribute(b).toString();
    Log localLog = l.a.a.a.f.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Opening a new session with ID ");
    localStringBuilder.append(str);
    localLog.d("CrashlyticsCore", localStringBuilder.toString());
    a(str, localDate);
    c(str);
    b(str);
    run(str);
    k.a(str);
  }
  
  private void a(int paramInt)
  {
    HashSet localHashSet = new HashSet();
    java.lang.Object localObject = visitTypeAnnotation();
    int i1 = Math.min(paramInt, localObject.length);
    paramInt = 0;
    while (paramInt < i1)
    {
      localHashSet.add(get(localObject[paramInt]));
      paramInt += 1;
    }
    k.a(localHashSet);
    localObject = new KeyProfilesActivity.1(null);
    match(c(d().listFiles((FilenameFilter)localObject)), localHashSet);
  }
  
  private void a(long paramLong)
  {
    if (initializeDatabase())
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
      return;
    }
    if (m != null)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Logging Crashlytics event to Firebase");
      Bundle localBundle = new Bundle();
      localBundle.putInt("_r", 1);
      localBundle.putInt("fatal", 1);
      localBundle.putLong("timestamp", paramLong);
      m.a("clx", "_ae", localBundle);
      return;
    }
    l.a.a.a.f.get().d("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
  }
  
  private void a(android.content.Context paramContext, File paramFile, String paramString)
    throws IOException
  {
    byte[] arrayOfByte1 = a.d(paramFile);
    byte[] arrayOfByte2 = a.b(paramFile);
    paramContext = a.a(paramFile, paramContext);
    if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
    {
      a(paramString, "<native-crash: minidump>");
      paramFile = b(paramString, "BeginSession.json");
      byte[] arrayOfByte3 = b(paramString, "SessionApp.json");
      byte[] arrayOfByte4 = b(paramString, "SessionDevice.json");
      byte[] arrayOfByte5 = b(paramString, "SessionOS.json");
      byte[] arrayOfByte6 = a.a(new g(d()).c(paramString));
      java.lang.Object localObject = new b(c.getContext(), i, paramString);
      byte[] arrayOfByte7 = ((b)localObject).e();
      ((b)localObject).d();
      localObject = a.a(new g(d()).d(paramString));
      paramString = new File(u.a(), paramString);
      if (!paramString.mkdir())
      {
        l.a.a.a.f.get().d("CrashlyticsCore", "Couldn't create native sessions directory");
        return;
      }
      a(arrayOfByte1, new File(paramString, "minidump"));
      a(arrayOfByte2, new File(paramString, "metadata"));
      a(paramContext, new File(paramString, "binaryImages"));
      a(paramFile, new File(paramString, "session"));
      a(arrayOfByte3, new File(paramString, "app"));
      a(arrayOfByte4, new File(paramString, "device"));
      a(arrayOfByte5, new File(paramString, "os"));
      a(arrayOfByte6, new File(paramString, "user"));
      a(arrayOfByte7, new File(paramString, "logs"));
      a((byte[])localObject, new File(paramString, "keys"));
      return;
    }
    paramContext = l.a.a.a.f.get();
    paramString = new StringBuilder();
    paramString.append("No minidump data found in directory ");
    paramString.append(paramFile);
    paramContext.remove("CrashlyticsCore", paramString.toString());
  }
  
  public static void a(ByteVector paramByteVector, File paramFile)
    throws IOException
  {
    java.lang.Object localObject;
    if (!paramFile.exists())
    {
      paramByteVector = l.a.a.a.f.get();
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Tried to include a file that doesn't exist: ");
      ((StringBuilder)localObject).append(paramFile.getName());
      paramByteVector.d("CrashlyticsCore", ((StringBuilder)localObject).toString(), null);
      return;
    }
    try
    {
      localObject = new FileInputStream(paramFile);
      try
      {
        a((InputStream)localObject, paramByteVector, (int)paramFile.length());
        l.a.a.a.a.b.ClassWriter.close((Closeable)localObject, "Failed to close file input stream.");
        return;
      }
      catch (Throwable paramFile)
      {
        paramByteVector = (ByteVector)localObject;
      }
      l.a.a.a.a.b.ClassWriter.close(paramByteVector, "Failed to close file input stream.");
    }
    catch (Throwable paramFile)
    {
      paramByteVector = null;
    }
    throw paramFile;
  }
  
  private void a(ByteVector paramByteVector, String paramString)
    throws IOException
  {
    String[] arrayOfString = s;
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = arrayOfString[i1];
      java.lang.Object localObject1 = new ClassReader(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, str, ".cls"));
      localObject1 = c(d().listFiles((FilenameFilter)localObject1));
      java.lang.Object localObject2;
      if (localObject1.length == 0)
      {
        localObject1 = l.a.a.a.f.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Can't find ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" data for session ID ");
        ((StringBuilder)localObject2).append(paramString);
        ((Log)localObject1).d("CrashlyticsCore", ((StringBuilder)localObject2).toString(), null);
      }
      else
      {
        localObject2 = l.a.a.a.f.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Collecting ");
        localStringBuilder.append(str);
        localStringBuilder.append(" data for session ID ");
        localStringBuilder.append(paramString);
        ((Log)localObject2).d("CrashlyticsCore", localStringBuilder.toString());
        a(paramByteVector, localObject1[0]);
      }
      i1 += 1;
    }
  }
  
  private void a(ByteVector paramByteVector, Date paramDate, Thread paramThread, Throwable paramThrowable, String paramString, boolean paramBoolean)
    throws Exception
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a32 = a31\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static void a(ByteVector paramByteVector, File[] paramArrayOfFile, String paramString)
  {
    Arrays.sort(paramArrayOfFile, l.a.a.a.a.b.ClassWriter.a);
    int i2 = paramArrayOfFile.length;
    int i1 = 0;
    while (i1 < i2)
    {
      File localFile = paramArrayOfFile[i1];
      try
      {
        Log localLog = l.a.a.a.f.get();
        Locale localLocale = Locale.US;
        String str = localFile.getName();
        localLog.d("CrashlyticsCore", String.format(localLocale, "Found Non Fatal for session ID %s in %s ", new java.lang.Object[] { paramString, str }));
        a(paramByteVector, localFile);
      }
      catch (Exception localException)
      {
        l.a.a.a.f.get().d("CrashlyticsCore", "Error writting non-fatal to session.", localException);
      }
      i1 += 1;
    }
  }
  
  private void a(i paramI)
  {
    if (paramI == null) {
      return;
    }
    try
    {
      paramI.a();
      return;
    }
    catch (IOException paramI)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Error closing session file stream in the presence of an exception", paramI);
    }
  }
  
  private void a(File paramFile, String paramString, int paramInt)
  {
    java.lang.Object localObject1 = l.a.a.a.f.get();
    java.lang.Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Collecting session parts for ID ");
    ((StringBuilder)localObject2).append(paramString);
    ((Log)localObject1).d("CrashlyticsCore", ((StringBuilder)localObject2).toString());
    localObject1 = new ClassReader(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "SessionCrash"));
    localObject1 = c(d().listFiles((FilenameFilter)localObject1));
    boolean bool1;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    l.a.a.a.f.get().d("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new java.lang.Object[] { paramString, Boolean.valueOf(bool1) }));
    localObject2 = new ClassReader(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "SessionEvent"));
    localObject2 = c(d().listFiles((FilenameFilter)localObject2));
    boolean bool2;
    if ((localObject2 != null) && (localObject2.length > 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    l.a.a.a.f.get().d("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new java.lang.Object[] { paramString, Boolean.valueOf(bool2) }));
    if ((!bool1) && (!bool2))
    {
      paramFile = l.a.a.a.f.get();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("No events present for session ID ");
      ((StringBuilder)localObject1).append(paramString);
      paramFile.d("CrashlyticsCore", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject2 = a(paramString, (File[])localObject2, paramInt);
      if (bool1) {
        localObject1 = localObject1[0];
      } else {
        localObject1 = null;
      }
      a(paramFile, paramString, (File[])localObject2, (File)localObject1);
    }
    paramFile = l.a.a.a.f.get();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Removing session part files for ID ");
    ((StringBuilder)localObject1).append(paramString);
    paramFile.d("CrashlyticsCore", ((StringBuilder)localObject1).toString());
    put(paramString);
  }
  
  /* Error */
  private void a(File paramFile1, String paramString, File[] paramArrayOfFile, File paramFile2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +9 -> 11
    //   5: iconst_1
    //   6: istore 5
    //   8: goto +6 -> 14
    //   11: iconst_0
    //   12: istore 5
    //   14: iload 5
    //   16: ifeq +12 -> 28
    //   19: aload_0
    //   20: invokevirtual 661	f/libs/asm/menu/ClassWriter:c	()Ljava/io/File;
    //   23: astore 8
    //   25: goto +9 -> 34
    //   28: aload_0
    //   29: invokevirtual 663	f/libs/asm/menu/ClassWriter:f	()Ljava/io/File;
    //   32: astore 8
    //   34: aload 8
    //   36: invokevirtual 537	java/io/File:exists	()Z
    //   39: ifne +9 -> 48
    //   42: aload 8
    //   44: invokevirtual 666	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: aconst_null
    //   55: astore 9
    //   57: aconst_null
    //   58: astore 13
    //   60: new 626	f/libs/asm/menu/i
    //   63: dup
    //   64: aload 8
    //   66: aload_2
    //   67: invokespecial 667	f/libs/asm/menu/i:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore 12
    //   72: aload 13
    //   74: astore 10
    //   76: aload 11
    //   78: astore 8
    //   80: aload 12
    //   82: astore 9
    //   84: aload 12
    //   86: invokestatic 672	f/libs/asm/menu/ByteVector:a	(Ljava/io/OutputStream;)Lf/libs/asm/menu/ByteVector;
    //   89: astore 13
    //   91: aload 13
    //   93: astore 11
    //   95: aload 11
    //   97: astore 10
    //   99: aload 11
    //   101: astore 8
    //   103: aload 12
    //   105: astore 9
    //   107: invokestatic 348	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   110: astore 14
    //   112: aload 11
    //   114: astore 10
    //   116: aload 11
    //   118: astore 8
    //   120: aload 12
    //   122: astore 9
    //   124: new 350	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 351	java/lang/StringBuilder:<init>	()V
    //   131: astore 15
    //   133: aload 11
    //   135: astore 10
    //   137: aload 11
    //   139: astore 8
    //   141: aload 12
    //   143: astore 9
    //   145: aload 15
    //   147: ldc_w 674
    //   150: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 11
    //   156: astore 10
    //   158: aload 11
    //   160: astore 8
    //   162: aload 12
    //   164: astore 9
    //   166: aload 15
    //   168: aload_2
    //   169: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 11
    //   175: astore 10
    //   177: aload 11
    //   179: astore 8
    //   181: aload 12
    //   183: astore 9
    //   185: aload 14
    //   187: ldc_w 359
    //   190: aload 15
    //   192: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokeinterface 365 3 0
    //   200: aload 11
    //   202: astore 10
    //   204: aload 11
    //   206: astore 8
    //   208: aload 12
    //   210: astore 9
    //   212: aload 13
    //   214: aload_1
    //   215: invokestatic 581	f/libs/asm/menu/ClassWriter:a	(Lf/libs/asm/menu/ByteVector;Ljava/io/File;)V
    //   218: aload 11
    //   220: astore 10
    //   222: aload 11
    //   224: astore 8
    //   226: aload 12
    //   228: astore 9
    //   230: new 334	java/util/Date
    //   233: dup
    //   234: invokespecial 335	java/util/Date:<init>	()V
    //   237: invokevirtual 677	java/util/Date:getTime	()J
    //   240: lstore 6
    //   242: lload 6
    //   244: ldc2_w 678
    //   247: ldiv
    //   248: lstore 6
    //   250: aload 11
    //   252: astore 10
    //   254: aload 11
    //   256: astore 8
    //   258: aload 12
    //   260: astore 9
    //   262: aload 13
    //   264: iconst_4
    //   265: lload 6
    //   267: invokevirtual 683	f/libs/asm/menu/ByteVector:write	(IJ)V
    //   270: aload 11
    //   272: astore 10
    //   274: aload 11
    //   276: astore 8
    //   278: aload 12
    //   280: astore 9
    //   282: aload 13
    //   284: iconst_5
    //   285: iload 5
    //   287: invokevirtual 686	f/libs/asm/menu/ByteVector:put	(IZ)V
    //   290: aload 11
    //   292: astore 10
    //   294: aload 11
    //   296: astore 8
    //   298: aload 12
    //   300: astore 9
    //   302: aload 13
    //   304: bipush 11
    //   306: iconst_1
    //   307: invokevirtual 689	f/libs/asm/menu/ByteVector:put	(II)V
    //   310: aload 11
    //   312: astore 10
    //   314: aload 11
    //   316: astore 8
    //   318: aload 12
    //   320: astore 9
    //   322: aload 13
    //   324: bipush 12
    //   326: iconst_3
    //   327: invokevirtual 691	f/libs/asm/menu/ByteVector:get	(II)V
    //   330: aload 11
    //   332: astore 10
    //   334: aload 11
    //   336: astore 8
    //   338: aload 12
    //   340: astore 9
    //   342: aload_0
    //   343: aload 13
    //   345: aload_2
    //   346: invokespecial 693	f/libs/asm/menu/ClassWriter:a	(Lf/libs/asm/menu/ByteVector;Ljava/lang/String;)V
    //   349: aload 11
    //   351: astore 10
    //   353: aload 11
    //   355: astore 8
    //   357: aload 12
    //   359: astore 9
    //   361: aload 13
    //   363: aload_3
    //   364: aload_2
    //   365: invokestatic 695	f/libs/asm/menu/ClassWriter:a	(Lf/libs/asm/menu/ByteVector;[Ljava/io/File;Ljava/lang/String;)V
    //   368: iload 5
    //   370: ifeq +22 -> 392
    //   373: aload 11
    //   375: astore 10
    //   377: aload 11
    //   379: astore 8
    //   381: aload 12
    //   383: astore 9
    //   385: aload 13
    //   387: aload 4
    //   389: invokestatic 581	f/libs/asm/menu/ClassWriter:a	(Lf/libs/asm/menu/ByteVector;Ljava/io/File;)V
    //   392: aload 13
    //   394: ldc_w 697
    //   397: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   400: aload 12
    //   402: ldc_w 702
    //   405: invokestatic 566	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   408: return
    //   409: astore_3
    //   410: aload 12
    //   412: astore_1
    //   413: goto +19 -> 432
    //   416: astore_1
    //   417: aconst_null
    //   418: astore_2
    //   419: aload 9
    //   421: astore 8
    //   423: aload_2
    //   424: astore 9
    //   426: goto +102 -> 528
    //   429: astore_3
    //   430: aconst_null
    //   431: astore_1
    //   432: aload 10
    //   434: astore 8
    //   436: aload_1
    //   437: astore 9
    //   439: invokestatic 348	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   442: astore 4
    //   444: aload 10
    //   446: astore 8
    //   448: aload_1
    //   449: astore 9
    //   451: new 350	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 351	java/lang/StringBuilder:<init>	()V
    //   458: astore 11
    //   460: aload 10
    //   462: astore 8
    //   464: aload_1
    //   465: astore 9
    //   467: aload 11
    //   469: ldc_w 704
    //   472: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 10
    //   478: astore 8
    //   480: aload_1
    //   481: astore 9
    //   483: aload 11
    //   485: aload_2
    //   486: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 10
    //   492: astore 8
    //   494: aload_1
    //   495: astore 9
    //   497: aload 4
    //   499: ldc_w 359
    //   502: aload 11
    //   504: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: aload_3
    //   508: invokeinterface 548 4 0
    //   513: aload 10
    //   515: ldc_w 697
    //   518: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   521: aload_0
    //   522: aload_1
    //   523: invokespecial 706	f/libs/asm/menu/ClassWriter:a	(Lf/libs/asm/menu/i;)V
    //   526: return
    //   527: astore_1
    //   528: aload 8
    //   530: ldc_w 697
    //   533: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   536: aload 9
    //   538: ldc_w 702
    //   541: invokestatic 566	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   544: aload_1
    //   545: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	this	ClassWriter
    //   0	546	1	paramFile1	File
    //   0	546	2	paramString	String
    //   0	546	3	paramArrayOfFile	File[]
    //   0	546	4	paramFile2	File
    //   6	363	5	bool	boolean
    //   240	26	6	l1	long
    //   23	506	8	localObject1	java.lang.Object
    //   55	482	9	localObject2	java.lang.Object
    //   49	465	10	localObject3	java.lang.Object
    //   52	451	11	localObject4	java.lang.Object
    //   70	341	12	localI	i
    //   58	335	13	localByteVector	ByteVector
    //   110	76	14	localLog	Log
    //   131	60	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   84	91	409	java/lang/Exception
    //   107	112	409	java/lang/Exception
    //   124	133	409	java/lang/Exception
    //   145	154	409	java/lang/Exception
    //   166	173	409	java/lang/Exception
    //   185	200	409	java/lang/Exception
    //   212	218	409	java/lang/Exception
    //   230	242	409	java/lang/Exception
    //   262	270	409	java/lang/Exception
    //   282	290	409	java/lang/Exception
    //   302	310	409	java/lang/Exception
    //   322	330	409	java/lang/Exception
    //   342	349	409	java/lang/Exception
    //   361	368	409	java/lang/Exception
    //   385	392	409	java/lang/Exception
    //   60	72	416	java/lang/Throwable
    //   60	72	429	java/lang/Exception
    //   84	91	527	java/lang/Throwable
    //   107	112	527	java/lang/Throwable
    //   124	133	527	java/lang/Throwable
    //   145	154	527	java/lang/Throwable
    //   166	173	527	java/lang/Throwable
    //   185	200	527	java/lang/Throwable
    //   212	218	527	java/lang/Throwable
    //   230	242	527	java/lang/Throwable
    //   262	270	527	java/lang/Throwable
    //   282	290	527	java/lang/Throwable
    //   302	310	527	java/lang/Throwable
    //   322	330	527	java/lang/Throwable
    //   342	349	527	java/lang/Throwable
    //   361	368	527	java/lang/Throwable
    //   385	392	527	java/lang/Throwable
    //   439	444	527	java/lang/Throwable
    //   451	460	527	java/lang/Throwable
    //   467	476	527	java/lang/Throwable
    //   483	490	527	java/lang/Throwable
    //   497	513	527	java/lang/Throwable
  }
  
  public static void a(InputStream paramInputStream, ByteVector paramByteVector, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = 0;
    while (paramInt < arrayOfByte.length)
    {
      int i1 = paramInputStream.read(arrayOfByte, paramInt, arrayOfByte.length - paramInt);
      if (i1 < 0) {
        break;
      }
      paramInt += i1;
    }
    paramByteVector.add(arrayOfByte);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    f.libs.asm.asm.e localE = (f.libs.asm.asm.e)l.a.a.a.f.add(f.c.a.a.b.class);
    if (localE == null)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Answers is not available");
      return;
    }
    localE.b(new o(paramString1, paramString2));
  }
  
  private void a(String paramString1, String paramString2, Object paramObject)
    throws Exception
  {
    java.lang.Object localObject1 = null;
    java.lang.Object localObject3 = null;
    java.lang.Object localObject2;
    try
    {
      localObject2 = d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      localObject2 = new i((File)localObject2, localStringBuilder.toString());
      paramString1 = localObject3;
      try
      {
        localObject1 = ByteVector.a((OutputStream)localObject2);
        paramString1 = (String)localObject1;
        paramObject.a((ByteVector)localObject1);
        paramString1 = new StringBuilder();
        paramString1.append("Failed to flush to session ");
        paramString1.append(paramString2);
        paramString1.append(" file.");
        l.a.a.a.a.b.ClassWriter.a((Flushable)localObject1, paramString1.toString());
        paramString1 = new StringBuilder();
        paramString1.append("Failed to close session ");
        paramString1.append(paramString2);
        paramString1.append(" file.");
        l.a.a.a.a.b.ClassWriter.close((Closeable)localObject2, paramString1.toString());
        return;
      }
      catch (Throwable paramObject)
      {
        localObject1 = paramString1;
        paramString1 = (String)localObject2;
      }
      localObject2 = new StringBuilder();
    }
    catch (Throwable paramObject)
    {
      paramString1 = null;
    }
    ((StringBuilder)localObject2).append("Failed to flush to session ");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(" file.");
    l.a.a.a.a.b.ClassWriter.a((Flushable)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to close session ");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(" file.");
    l.a.a.a.a.b.ClassWriter.close(paramString1, ((StringBuilder)localObject1).toString());
    throw paramObject;
  }
  
  private void a(String paramString1, String paramString2, f.a paramA)
    throws Exception
  {
    StringBuilder localStringBuilder1 = null;
    try
    {
      File localFile = d();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append(paramString2);
      paramString1 = new FileOutputStream(new File(localFile, localStringBuilder2.toString()));
      try
      {
        paramA.a(paramString1);
        paramA = new StringBuilder();
        paramA.append("Failed to close ");
        paramA.append(paramString2);
        paramA.append(" file.");
        l.a.a.a.a.b.ClassWriter.close(paramString1, paramA.toString());
        return;
      }
      catch (Throwable paramA) {}
      localStringBuilder1 = new StringBuilder();
    }
    catch (Throwable paramA)
    {
      paramString1 = localStringBuilder1;
    }
    localStringBuilder1.append("Failed to close ");
    localStringBuilder1.append(paramString2);
    localStringBuilder1.append(" file.");
    l.a.a.a.a.b.ClassWriter.close(paramString1, localStringBuilder1.toString());
    throw paramA;
  }
  
  private void a(String paramString, Date paramDate)
    throws Exception
  {
    String str = String.format(Locale.US, "Crashlytics Android SDK/%s", new java.lang.Object[] { c.c() });
    long l1 = paramDate.getTime() / 1000L;
    a(paramString, "BeginSession", new x(this, paramString, str, l1));
    a(paramString, "BeginSession.json", new t(this, paramString, str, l1));
  }
  
  /* Error */
  private void a(Date paramDate, Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 766	f/libs/asm/menu/ClassWriter:b	()Ljava/lang/String;
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 8
    //   15: aload 9
    //   17: ifnonnull +19 -> 36
    //   20: invokestatic 348	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   23: ldc_w 359
    //   26: ldc_w 768
    //   29: aconst_null
    //   30: invokeinterface 548 4 0
    //   35: return
    //   36: aload 9
    //   38: aload_3
    //   39: invokevirtual 772	java/lang/Object:getClass	()Ljava/lang/Class;
    //   42: invokevirtual 775	java/lang/Class:getName	()Ljava/lang/String;
    //   45: invokestatic 777	f/libs/asm/menu/ClassWriter:add	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: invokestatic 348	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   51: astore 4
    //   53: new 350	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 351	java/lang/StringBuilder:<init>	()V
    //   60: astore 7
    //   62: aload 7
    //   64: ldc_w 779
    //   67: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 7
    //   73: aload_3
    //   74: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 7
    //   80: ldc_w 781
    //   83: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 7
    //   89: aload_2
    //   90: invokevirtual 784	java/lang/Thread:getName	()Ljava/lang/String;
    //   93: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 4
    //   99: ldc_w 359
    //   102: aload 7
    //   104: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokeinterface 365 3 0
    //   112: aload_0
    //   113: getfield 231	f/libs/asm/menu/ClassWriter:index	Ljava/util/concurrent/atomic/AtomicInteger;
    //   116: astore 4
    //   118: aload 4
    //   120: invokevirtual 788	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   123: invokestatic 791	l/a/a/a/a/b/ClassWriter:get	(I)Ljava/lang/String;
    //   126: astore 4
    //   128: new 350	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 351	java/lang/StringBuilder:<init>	()V
    //   135: astore 7
    //   137: aload 7
    //   139: aload 9
    //   141: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 7
    //   147: ldc 79
    //   149: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 7
    //   155: aload 4
    //   157: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 7
    //   163: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore 4
    //   168: new 626	f/libs/asm/menu/i
    //   171: dup
    //   172: aload_0
    //   173: invokevirtual 324	f/libs/asm/menu/ClassWriter:d	()Ljava/io/File;
    //   176: aload 4
    //   178: invokespecial 667	f/libs/asm/menu/i:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   181: astore 4
    //   183: aload 6
    //   185: astore 5
    //   187: aload 4
    //   189: astore 6
    //   191: aload 4
    //   193: invokestatic 672	f/libs/asm/menu/ByteVector:a	(Ljava/io/OutputStream;)Lf/libs/asm/menu/ByteVector;
    //   196: astore 7
    //   198: aload_0
    //   199: aload 7
    //   201: aload_1
    //   202: aload_2
    //   203: aload_3
    //   204: ldc 106
    //   206: iconst_0
    //   207: invokespecial 793	f/libs/asm/menu/ClassWriter:a	(Lf/libs/asm/menu/ByteVector;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    //   210: aload 7
    //   212: ldc_w 795
    //   215: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   218: goto +68 -> 286
    //   221: astore_1
    //   222: aload 7
    //   224: astore 5
    //   226: goto +99 -> 325
    //   229: astore_2
    //   230: aload 7
    //   232: astore_1
    //   233: goto +24 -> 257
    //   236: astore_2
    //   237: aload 8
    //   239: astore_1
    //   240: goto +17 -> 257
    //   243: astore_1
    //   244: aconst_null
    //   245: astore 4
    //   247: goto +78 -> 325
    //   250: astore_2
    //   251: aconst_null
    //   252: astore 4
    //   254: aload 8
    //   256: astore_1
    //   257: aload_1
    //   258: astore 5
    //   260: aload 4
    //   262: astore 6
    //   264: invokestatic 348	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   267: ldc_w 359
    //   270: ldc_w 797
    //   273: aload_2
    //   274: invokeinterface 548 4 0
    //   279: aload_1
    //   280: ldc_w 795
    //   283: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   286: aload 4
    //   288: ldc_w 799
    //   291: invokestatic 566	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   294: aload_0
    //   295: aload 9
    //   297: bipush 64
    //   299: invokespecial 801	f/libs/asm/menu/ClassWriter:b	(Ljava/lang/String;I)V
    //   302: return
    //   303: astore_1
    //   304: invokestatic 348	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   307: ldc_w 359
    //   310: ldc_w 803
    //   313: aload_1
    //   314: invokeinterface 548 4 0
    //   319: return
    //   320: astore_1
    //   321: aload 6
    //   323: astore 4
    //   325: aload 5
    //   327: ldc_w 795
    //   330: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   333: aload 4
    //   335: ldc_w 799
    //   338: invokestatic 566	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   341: aload_1
    //   342: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	ClassWriter
    //   0	343	1	paramDate	Date
    //   0	343	2	paramThread	Thread
    //   0	343	3	paramThrowable	Throwable
    //   51	283	4	localObject1	java.lang.Object
    //   10	316	5	localObject2	java.lang.Object
    //   7	315	6	localObject3	java.lang.Object
    //   60	171	7	localObject4	java.lang.Object
    //   13	242	8	localObject5	java.lang.Object
    //   4	292	9	str	String
    // Exception table:
    //   from	to	target	type
    //   198	210	221	java/lang/Throwable
    //   198	210	229	java/lang/Exception
    //   191	198	236	java/lang/Exception
    //   48	53	243	java/lang/Throwable
    //   53	112	243	java/lang/Throwable
    //   112	118	243	java/lang/Throwable
    //   118	128	243	java/lang/Throwable
    //   128	168	243	java/lang/Throwable
    //   168	183	243	java/lang/Throwable
    //   48	53	250	java/lang/Exception
    //   53	112	250	java/lang/Exception
    //   118	128	250	java/lang/Exception
    //   128	168	250	java/lang/Exception
    //   168	183	250	java/lang/Exception
    //   294	302	303	java/lang/Exception
    //   191	198	320	java/lang/Throwable
    //   264	279	320	java/lang/Throwable
  }
  
  private void a(l.a.a.a.a.g.Frame paramFrame, boolean paramBoolean)
    throws Exception
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  private void a(l.a.a.a.a.g.e paramE)
  {
    if (paramE == null)
    {
      l.a.a.a.f.get().remove("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
      return;
    }
    android.content.Context localContext = c.getContext();
    paramE = a;
    paramE = c(d, a);
    paramE = new Plot(a.a, paramE, z, n);
    File[] arrayOfFile = listFiles();
    int i2 = arrayOfFile.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Segment localSegment = new Segment(arrayOfFile[i1], q);
      d.invoke(new Plot.a(localContext, localSegment, paramE));
      i1 += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, File paramFile)
    throws IOException
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      put(paramArrayOfByte, paramFile);
    }
  }
  
  private void a(File[] paramArrayOfFile, int paramInt1, int paramInt2)
  {
    l.a.a.a.f.get().d("CrashlyticsCore", "Closing open sessions.");
    while (paramInt1 < paramArrayOfFile.length)
    {
      File localFile = paramArrayOfFile[paramInt1];
      String str = get(localFile);
      Log localLog = l.a.a.a.f.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Closing session: ");
      localStringBuilder.append(str);
      localLog.d("CrashlyticsCore", localStringBuilder.toString());
      a(localFile, str, paramInt2);
      paramInt1 += 1;
    }
  }
  
  private File[] a(File paramFile)
  {
    return c(paramFile.listFiles());
  }
  
  private File[] a(File paramFile, FilenameFilter paramFilenameFilter)
  {
    return c(paramFile.listFiles(paramFilenameFilter));
  }
  
  private File[] a(FileFilter paramFileFilter)
  {
    return c(d().listFiles(paramFileFilter));
  }
  
  private File[] a(String paramString, File[] paramArrayOfFile, int paramInt)
  {
    File[] arrayOfFile = paramArrayOfFile;
    if (paramArrayOfFile.length > paramInt)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new java.lang.Object[] { Integer.valueOf(paramInt) }));
      b(paramString, paramInt);
      paramString = new ClassReader(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "SessionEvent"));
      arrayOfFile = c(d().listFiles(paramString));
    }
    return arrayOfFile;
  }
  
  public static void add(String paramString1, String paramString2)
  {
    f.libs.asm.asm.e localE = (f.libs.asm.asm.e)l.a.a.a.f.add(f.c.a.a.b.class);
    if (localE == null)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Answers is not available");
      return;
    }
    localE.a(new MethodVisitor(paramString1, paramString2));
  }
  
  private String b()
  {
    File[] arrayOfFile = visitTypeAnnotation();
    if (arrayOfFile.length > 0) {
      return get(arrayOfFile[0]);
    }
    return null;
  }
  
  private void b(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i2 = arrayOfFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        b(arrayOfFile[i1]);
        i1 += 1;
      }
    }
    paramFile.delete();
  }
  
  private void b(String paramString)
    throws Exception
  {
    boolean bool = l.a.a.a.a.b.ClassWriter.get(c.getContext());
    a(paramString, "SessionOS", new SignatureWriter(this, bool));
    a(paramString, "SessionOS.json", new Color(this, bool));
  }
  
  private void b(String paramString, int paramInt)
  {
    Type.a(d(), new ClassReader(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "SessionEvent")), paramInt, y);
  }
  
  /* Error */
  private void b(Date paramDate, Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 8
    //   12: aload_0
    //   13: invokespecial 766	f/libs/asm/menu/ClassWriter:b	()Ljava/lang/String;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +33 -> 53
    //   23: invokestatic 348	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   26: ldc_w 359
    //   29: ldc_w 910
    //   32: aconst_null
    //   33: invokeinterface 548 4 0
    //   38: aconst_null
    //   39: ldc_w 912
    //   42: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   45: aconst_null
    //   46: ldc_w 914
    //   49: invokestatic 566	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   52: return
    //   53: aload 6
    //   55: aload_3
    //   56: invokevirtual 772	java/lang/Object:getClass	()Ljava/lang/Class;
    //   59: invokevirtual 775	java/lang/Class:getName	()Ljava/lang/String;
    //   62: invokestatic 462	f/libs/asm/menu/ClassWriter:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokevirtual 324	f/libs/asm/menu/ClassWriter:d	()Ljava/io/File;
    //   69: astore 9
    //   71: new 350	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 351	java/lang/StringBuilder:<init>	()V
    //   78: astore 10
    //   80: aload 10
    //   82: aload 6
    //   84: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 10
    //   90: ldc 59
    //   92: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: new 626	f/libs/asm/menu/i
    //   99: dup
    //   100: aload 9
    //   102: aload 10
    //   104: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokespecial 667	f/libs/asm/menu/i:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   110: astore 6
    //   112: aload 7
    //   114: astore 4
    //   116: aload 6
    //   118: astore 7
    //   120: aload 6
    //   122: invokestatic 672	f/libs/asm/menu/ByteVector:a	(Ljava/io/OutputStream;)Lf/libs/asm/menu/ByteVector;
    //   125: astore 9
    //   127: aload 9
    //   129: astore 5
    //   131: aload 5
    //   133: astore 8
    //   135: aload 5
    //   137: astore 4
    //   139: aload 6
    //   141: astore 7
    //   143: aload_0
    //   144: aload 9
    //   146: aload_1
    //   147: aload_2
    //   148: aload_3
    //   149: ldc 66
    //   151: iconst_1
    //   152: invokespecial 793	f/libs/asm/menu/ClassWriter:a	(Lf/libs/asm/menu/ByteVector;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    //   155: aload 5
    //   157: astore_1
    //   158: aload 6
    //   160: astore_2
    //   161: goto +51 -> 212
    //   164: astore_3
    //   165: aload 8
    //   167: astore_1
    //   168: aload 6
    //   170: astore_2
    //   171: goto +20 -> 191
    //   174: astore_1
    //   175: aconst_null
    //   176: astore 7
    //   178: aload 5
    //   180: astore 4
    //   182: goto +46 -> 228
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_2
    //   188: aload 4
    //   190: astore_1
    //   191: aload_1
    //   192: astore 4
    //   194: aload_2
    //   195: astore 7
    //   197: invokestatic 348	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   200: ldc_w 359
    //   203: ldc_w 916
    //   206: aload_3
    //   207: invokeinterface 548 4 0
    //   212: aload_1
    //   213: ldc_w 912
    //   216: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   219: aload_2
    //   220: ldc_w 914
    //   223: invokestatic 566	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   226: return
    //   227: astore_1
    //   228: aload 4
    //   230: ldc_w 912
    //   233: invokestatic 700	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   236: aload 7
    //   238: ldc_w 914
    //   241: invokestatic 566	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   244: aload_1
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	ClassWriter
    //   0	246	1	paramDate	Date
    //   0	246	2	paramThread	Thread
    //   0	246	3	paramThrowable	Throwable
    //   1	228	4	localObject1	java.lang.Object
    //   7	172	5	localObject2	java.lang.Object
    //   16	153	6	localObject3	java.lang.Object
    //   4	233	7	localObject4	java.lang.Object
    //   10	156	8	localObject5	java.lang.Object
    //   69	76	9	localObject6	java.lang.Object
    //   78	25	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   120	127	164	java/lang/Exception
    //   143	155	164	java/lang/Exception
    //   12	18	174	java/lang/Throwable
    //   23	38	174	java/lang/Throwable
    //   53	65	174	java/lang/Throwable
    //   65	71	174	java/lang/Throwable
    //   71	112	174	java/lang/Throwable
    //   12	18	185	java/lang/Exception
    //   23	38	185	java/lang/Exception
    //   53	65	185	java/lang/Exception
    //   65	71	185	java/lang/Exception
    //   71	112	185	java/lang/Exception
    //   120	127	227	java/lang/Throwable
    //   143	155	227	java/lang/Throwable
    //   197	212	227	java/lang/Throwable
  }
  
  private byte[] b(String paramString1, String paramString2)
  {
    return a.a(new File(d(), f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString1, paramString2)));
  }
  
  private File[] b(FilenameFilter paramFilenameFilter)
  {
    return c(d().listFiles(paramFilenameFilter));
  }
  
  private j c(String paramString1, String paramString2)
  {
    String str = l.a.a.a.a.b.ClassWriter.a(c.getContext(), "com.crashlytics.ApiEndpoint");
    return new FixedTableModel.a(new XYPlot(c, str, paramString1, h), new PagerSlidingTabStrip(c, str, paramString2, h));
  }
  
  private void c(String paramString)
    throws Exception
  {
    String str1 = b.e();
    java.lang.Object localObject = a;
    String str2 = c;
    localObject = b;
    String str3 = b.a();
    int i1 = Handle.a(a.g).getId();
    a(paramString, "SessionApp", new FieldWriter(this, str1, str2, (String)localObject, str3, i1));
    a(paramString, "SessionApp.json", new Widget(this, str1, str2, (String)localObject, str3, i1));
  }
  
  private boolean c(l.a.a.a.a.g.e paramE)
  {
    if (paramE == null) {
      return false;
    }
    return (b.f) && (!g.save());
  }
  
  private File[] c(File[] paramArrayOfFile)
  {
    File[] arrayOfFile = paramArrayOfFile;
    if (paramArrayOfFile == null) {
      arrayOfFile = new File[0];
    }
    return arrayOfFile;
  }
  
  public static String get(File paramFile)
  {
    return paramFile.getName().substring(0, 35);
  }
  
  private File[] get(String paramString)
  {
    paramString = new FilePickerActivity.ExtensionFilenameFilter(paramString);
    return c(d().listFiles(paramString));
  }
  
  private boolean initializeDatabase()
  {
    try
    {
      Class.forName("com.google.firebase.crash.FirebaseCrash");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return false;
  }
  
  private void match(File[] paramArrayOfFile, Set paramSet)
  {
    int i2 = paramArrayOfFile.length;
    int i1 = 0;
    while (i1 < i2)
    {
      File localFile = paramArrayOfFile[i1];
      String str = localFile.getName();
      java.lang.Object localObject = p.matcher(str);
      StringBuilder localStringBuilder;
      if (!((Matcher)localObject).matches())
      {
        localObject = l.a.a.a.f.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Deleting unknown file: ");
        localStringBuilder.append(str);
        ((Log)localObject).d("CrashlyticsCore", localStringBuilder.toString());
        localFile.delete();
      }
      else if (!paramSet.contains(((Matcher)localObject).group(1)))
      {
        localObject = l.a.a.a.f.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Trimming session file: ");
        localStringBuilder.append(str);
        ((Log)localObject).d("CrashlyticsCore", localStringBuilder.toString());
        localFile.delete();
      }
      i1 += 1;
    }
  }
  
  private void put(String paramString)
  {
    paramString = get(paramString);
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramString[i1].delete();
      i1 += 1;
    }
  }
  
  private void put(Set paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      b((File)paramSet.next());
    }
  }
  
  private void put(byte[] paramArrayOfByte, File paramFile)
    throws IOException
  {
    java.lang.Object localObject = null;
    try
    {
      paramFile = new GZIPOutputStream(new FileOutputStream(paramFile));
      try
      {
        paramFile.write(paramArrayOfByte);
        paramFile.finish();
        l.a.a.a.a.b.ClassWriter.close(paramFile);
        return;
      }
      catch (Throwable localThrowable)
      {
        paramArrayOfByte = paramFile;
        paramFile = localThrowable;
      }
      l.a.a.a.a.b.ClassWriter.close(paramArrayOfByte);
    }
    catch (Throwable paramFile)
    {
      paramArrayOfByte = localThrowable;
    }
    throw paramFile;
  }
  
  private String replace()
  {
    File[] arrayOfFile = visitTypeAnnotation();
    if (arrayOfFile.length > 1) {
      return get(arrayOfFile[1]);
    }
    return null;
  }
  
  private void run(String paramString)
    throws Exception
  {
    android.content.Context localContext = c.getContext();
    java.lang.Object localObject = new StatFs(Environment.getDataDirectory().getPath());
    int i1 = l.a.a.a.a.b.ClassWriter.c();
    int i2 = Runtime.getRuntime().availableProcessors();
    long l1 = l.a.a.a.a.b.ClassWriter.get();
    long l2 = ((StatFs)localObject).getBlockCount() * ((StatFs)localObject).getBlockSize();
    boolean bool = l.a.a.a.a.b.ClassWriter.init(localContext);
    localObject = b.apply();
    int i3 = l.a.a.a.a.b.ClassWriter.execute(localContext);
    a(paramString, "SessionDevice", new Switch(this, i1, i2, l1, l2, bool, (Map)localObject, i3));
    a(paramString, "SessionDevice.json", new NumberPicker(this, i1, i2, l1, l2, bool, (Map)localObject, i3));
  }
  
  private void update()
  {
    File localFile = getParent();
    if (!localFile.exists()) {
      return;
    }
    File[] arrayOfFile = c(localFile.listFiles(new CrashMechanism.1.1()));
    Arrays.sort(arrayOfFile, Collections.reverseOrder());
    HashSet localHashSet = new HashSet();
    int i1 = 0;
    while ((i1 < arrayOfFile.length) && (localHashSet.size() < 4))
    {
      localHashSet.add(get(arrayOfFile[i1]));
      i1 += 1;
    }
    match(a(localFile), localHashSet);
  }
  
  private void visit(String paramString)
    throws Exception
  {
    a(paramString, "SessionUser", new w(this, a(paramString)));
  }
  
  private File[] visitTypeAnnotation()
  {
    File[] arrayOfFile = newUTF8();
    Arrays.sort(arrayOfFile, O);
    return arrayOfFile;
  }
  
  public void a(float paramFloat, l.a.a.a.a.g.e paramE)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public void a(long paramLong, String paramString)
  {
    d.invoke(new IntegerPolynomial.CombineTask(this, paramLong, paramString));
  }
  
  public void a(la.b paramB, Thread paramThread, Throwable paramThrowable, boolean paramBoolean)
  {
    try
    {
      java.lang.Object localObject = l.a.a.a.f.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Crashlytics is handling uncaught exception \"");
      localStringBuilder.append(paramThrowable);
      localStringBuilder.append("\" from thread ");
      localStringBuilder.append(paramThread.getName());
      ((Log)localObject).d("CrashlyticsCore", localStringBuilder.toString());
      o.a();
      localObject = new Date();
      d.get(new PhotoDataAdapter.GetUpdateInfo(this, (Date)localObject, paramThread, paramThrowable, paramB, paramBoolean));
      return;
    }
    catch (Throwable paramB)
    {
      throw paramB;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    d.invoke(new OperatorBufferWithSingleObservable.1(this, paramString1, paramString2, paramString3));
  }
  
  public void a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, boolean paramBoolean)
  {
    visitAnnotation();
    A = new ExceptionHandler(new AppCompatDelegateImplV7(this), new ExtensionData(null), paramBoolean, paramUncaughtExceptionHandler);
    Thread.setDefaultUncaughtExceptionHandler(A);
  }
  
  public void a(Map paramMap)
  {
    d.invoke(new ConnectionPool.1(this, paramMap));
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage == null) {
      return true;
    }
    return ((Boolean)d.get(new SafeAsyncTask.Task(this, paramMessage))).booleanValue();
  }
  
  public boolean a(l.a.a.a.a.g.Frame paramFrame)
  {
    return ((Boolean)d.get(new PhotoDataAdapter.UpdateContent(this, paramFrame))).booleanValue();
  }
  
  public void accept()
  {
    d.invoke(new DayFragment.1(this));
  }
  
  public void b(int paramInt)
  {
    paramInt -= Type.a(c(), paramInt, y);
    int i1 = Type.a(f(), paramInt, y);
    Type.a(d(), r, paramInt - i1, y);
  }
  
  public void b(Thread paramThread, Throwable paramThrowable)
  {
    Date localDate = new Date();
    d.invoke(new AppCompatDelegateImplV7.4(this, localDate, paramThread, paramThrowable));
  }
  
  public void b(l.a.a.a.a.g.Frame paramFrame)
    throws Exception
  {
    a(paramFrame, false);
  }
  
  public void b(l.a.a.a.a.g.e paramE)
  {
    if (b.w)
    {
      boolean bool = w.a();
      paramE = l.a.a.a.f.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Registered Firebase Analytics event listener for breadcrumbs: ");
      localStringBuilder.append(bool);
      paramE.d("CrashlyticsCore", localStringBuilder.toString());
    }
  }
  
  public File c()
  {
    return new File(d(), "fatal-sessions");
  }
  
  public File d()
  {
    return u.a();
  }
  
  public void doInBackground(File[] paramArrayOfFile)
  {
    java.lang.Object localObject = new HashSet();
    int i3 = paramArrayOfFile.length;
    int i2 = 0;
    int i1 = 0;
    File localFile;
    Log localLog;
    StringBuilder localStringBuilder;
    while (i1 < i3)
    {
      localFile = paramArrayOfFile[i1];
      localLog = l.a.a.a.f.get();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Found invalid session part file: ");
      localStringBuilder.append(localFile);
      localLog.d("CrashlyticsCore", localStringBuilder.toString());
      ((Set)localObject).add(get(localFile));
      i1 += 1;
    }
    if (((Set)localObject).isEmpty()) {
      return;
    }
    paramArrayOfFile = getParent();
    if (!paramArrayOfFile.exists()) {
      paramArrayOfFile.mkdir();
    }
    localObject = new RootClass.AnnotationsFinder.1(this, (Set)localObject);
    localObject = c(d().listFiles((FilenameFilter)localObject));
    i3 = localObject.length;
    i1 = i2;
    while (i1 < i3)
    {
      localFile = localObject[i1];
      localLog = l.a.a.a.f.get();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Moving session file: ");
      localStringBuilder.append(localFile);
      localLog.d("CrashlyticsCore", localStringBuilder.toString());
      if (!localFile.renameTo(new File(paramArrayOfFile, localFile.getName())))
      {
        localLog = l.a.a.a.f.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not move session file. Deleting ");
        localStringBuilder.append(localFile);
        localLog.d("CrashlyticsCore", localStringBuilder.toString());
        localFile.delete();
      }
      i1 += 1;
    }
    update();
  }
  
  public File f()
  {
    return new File(d(), "nonfatal-sessions");
  }
  
  public boolean get()
  {
    ExceptionHandler localExceptionHandler = A;
    return (localExceptionHandler != null) && (localExceptionHandler.get());
  }
  
  public File getParent()
  {
    return new File(d(), "invalidClsFiles");
  }
  
  public File[] listFiles()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, a(c(), r));
    Collections.addAll(localLinkedList, a(f(), r));
    Collections.addAll(localLinkedList, a(d(), r));
    return (File[])localLinkedList.toArray(new File[localLinkedList.size()]);
  }
  
  public File[] newUTF8()
  {
    return b(L);
  }
  
  public void put()
  {
    o.init();
  }
  
  public File[] toByteArray()
  {
    return a(N);
  }
  
  public boolean visit()
  {
    return newUTF8().length > 0;
  }
  
  public void visitAnnotation()
  {
    d.invoke(new HttpRequestTaskCallable(this));
  }
}
