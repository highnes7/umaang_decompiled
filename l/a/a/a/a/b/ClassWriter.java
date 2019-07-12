package l.a.a.a.a.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.crypto.Cipher;
import l.a.a.a.Log;
import l.a.a.a.f;

public class ClassWriter
{
  public static final String A = "com.crashlytics.prefs";
  public static final int COMPUTE_FRAMES = 2;
  public static final int COMPUTE_MAXS = 1;
  public static final String D = "D";
  public static final String EAST = "E";
  public static final String FLOAT = "sdk";
  public static final long GLOBAL_ATTRIBUTE_DB_ID = -1L;
  public static final String HASH_METHOD_CAPS = "SHA-1";
  public static final String I = "google_sdk";
  public static final int IMPLVAR_INSN = 4;
  public static final String INT = "io.fabric.android.build_id";
  public static final String INTEROPERABILITY = "V";
  public static final String IN_PROGRESS = "A";
  public static final int K = 1024;
  public static final boolean L = false;
  public static final int LDC_INSN = 8;
  public static final int M = 1048576;
  public static final int MANA_INSN = 1073741824;
  public static final String WEST = "W";
  public static final Comparator<File> a = new Version.BuildAwareOrder();
  public static Boolean b;
  public static long c = 0L;
  public static final String d = "I";
  public static final String f = "?";
  public static final String i = "SHA-256";
  public static final String key = "com.google.firebase.crashlytics.unity_version";
  public static final char[] s = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final String t = "com.crashlytics.android.build_id";
  public static final String threshold = "com.crashlytics.Trace";
  public static final int x = 16;
  public static final int y = 32;
  
  static
  {
    c = -1L;
  }
  
  public ClassWriter() {}
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, getName(paramContext));
  }
  
  public static int a(Context paramContext, boolean paramBoolean)
  {
    paramContext = create(paramContext);
    if ((paramBoolean) && (paramContext != null))
    {
      if (paramContext.floatValue() >= 99.0D) {
        return 3;
      }
      if (paramContext.floatValue() < 99.0D) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 125	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 156	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   12: invokevirtual 160	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   15: astore_0
    //   16: aload_0
    //   17: getfield 165	android/content/pm/PackageItemInfo:icon	I
    //   20: istore_1
    //   21: aload_3
    //   22: iload_1
    //   23: invokevirtual 169	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   26: astore 5
    //   28: aload 5
    //   30: astore_3
    //   31: aload_3
    //   32: astore_0
    //   33: aload 5
    //   35: invokestatic 172	l/a/a/a/a/b/ClassWriter:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   38: astore 6
    //   40: aload_3
    //   41: astore_0
    //   42: aload 6
    //   44: invokestatic 176	l/a/a/a/a/b/ClassWriter:put	(Ljava/lang/String;)Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifeq +9 -> 58
    //   52: aload 4
    //   54: astore_0
    //   55: goto +6 -> 61
    //   58: aload 6
    //   60: astore_0
    //   61: aload 5
    //   63: ldc -78
    //   65: invokestatic 182	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   68: aload_0
    //   69: areturn
    //   70: astore 4
    //   72: goto +25 -> 97
    //   75: goto +17 -> 92
    //   78: astore_0
    //   79: goto -4 -> 75
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_3
    //   85: aload_0
    //   86: astore 4
    //   88: goto +81 -> 169
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_0
    //   95: astore 4
    //   97: aload_3
    //   98: astore_0
    //   99: invokestatic 188	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   102: astore 5
    //   104: aload_3
    //   105: astore_0
    //   106: new 190	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   113: astore 6
    //   115: aload_3
    //   116: astore_0
    //   117: aload 6
    //   119: ldc -63
    //   121: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: astore_0
    //   127: aload 6
    //   129: aload 4
    //   131: checkcast 150	java/lang/Exception
    //   134: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   137: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: astore_0
    //   143: aload 5
    //   145: ldc -53
    //   147: aload 6
    //   149: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokeinterface 212 3 0
    //   157: aload_3
    //   158: ldc -78
    //   160: invokestatic 182	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore 4
    //   167: aload_0
    //   168: astore_3
    //   169: aload_3
    //   170: ldc -78
    //   172: invokestatic 182	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   175: goto +3 -> 178
    //   178: aload 4
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramContext	Context
    //   20	3	1	j	int
    //   47	2	2	bool	boolean
    //   7	163	3	localObject1	Object
    //   1	52	4	localObject2	Object
    //   70	1	4	localException	Exception
    //   86	44	4	localContext	Context
    //   165	14	4	localThrowable	Throwable
    //   26	118	5	localObject3	Object
    //   38	110	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   33	40	70	java/lang/Exception
    //   42	48	70	java/lang/Exception
    //   8	16	78	java/lang/Exception
    //   3	8	82	java/lang/Throwable
    //   8	16	82	java/lang/Throwable
    //   16	21	82	java/lang/Throwable
    //   21	28	82	java/lang/Throwable
    //   3	8	91	java/lang/Exception
    //   21	28	91	java/lang/Exception
    //   33	40	165	java/lang/Throwable
    //   42	48	165	java/lang/Throwable
    //   99	104	165	java/lang/Throwable
    //   106	115	165	java/lang/Throwable
    //   117	125	165	java/lang/Throwable
    //   127	141	165	java/lang/Throwable
    //   143	157	165	java/lang/Throwable
  }
  
  public static String a(Context paramContext, String paramString)
  {
    int j = paramContext.getResources().getIdentifier(paramString, "string", getName(paramContext));
    if (j > 0) {
      return paramContext.getString(j);
    }
    return "";
  }
  
  public static String a(InputStream paramInputStream)
  {
    return read(paramInputStream, "SHA-1");
  }
  
  public static String a(String paramString)
  {
    return read(paramString.getBytes(), "SHA-1");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((paramContext instanceof Activity)) {
      get((Activity)paramContext, paramInt);
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (b(paramContext)) {
      f.get().println(paramInt, "Fabric", paramString2);
    }
  }
  
  public static void a(Context paramContext, String paramString, Throwable paramThrowable)
  {
    if (b(paramContext)) {
      f.get().e("Fabric", paramString);
    }
  }
  
  public static void a(Flushable paramFlushable, String paramString)
  {
    if (paramFlushable != null) {
      try
      {
        paramFlushable.flush();
        return;
      }
      catch (IOException paramFlushable)
      {
        f.get().d("Fabric", paramString, paramFlushable);
      }
    }
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    for (;;)
    {
      int j = paramInputStream.read(paramArrayOfByte);
      if (j == -1) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, j);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!f.d())
    {
      f.get().remove(paramString1, paramString2);
      return;
    }
    throw new IllegalArgumentException(paramString2);
  }
  
  public static long add(String paramString1, String paramString2, int paramInt)
  {
    return Long.parseLong(paramString1.split(paramString2)[0].trim()) * paramInt;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (b(paramContext)) {
      f.get().d("Fabric", paramString);
    }
  }
  
  public static boolean b(Context paramContext)
  {
    if (b == null) {
      b = Boolean.valueOf(getBoolean(paramContext, "com.crashlytics.Trace", false));
    }
    return b.booleanValue();
  }
  
  public static int c()
  {
    return YLayoutStyle.a().ordinal();
  }
  
  public static String c(Context paramContext)
  {
    int k = paramContext.getResources().getIdentifier("io.fabric.android.build_id", "string", getName(paramContext));
    int j = k;
    if (k == 0) {
      j = paramContext.getResources().getIdentifier("com.crashlytics.android.build_id", "string", getName(paramContext));
    }
    if (j != 0)
    {
      paramContext = paramContext.getResources().getString(j);
      Log localLog = f.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Build ID is: ");
      localStringBuilder.append(paramContext);
      localLog.d("Fabric", localStringBuilder.toString());
      return paramContext;
    }
    return null;
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (RuntimeException paramCloseable)
      {
        throw paramCloseable;
      }
      catch (Exception paramCloseable) {}
    }
  }
  
  public static void close(Closeable paramCloseable, String paramString)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        f.get().d("Fabric", paramString, paramCloseable);
      }
    }
  }
  
  public static Float create(Context paramContext)
  {
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (paramContext == null) {
      return null;
    }
    int j = paramContext.getIntExtra("level", -1);
    int k = paramContext.getIntExtra("scale", -1);
    return Float.valueOf(j / k);
  }
  
  public static byte[] decodeHex(String paramString)
  {
    int k = paramString.length();
    byte[] arrayOfByte = new byte[k / 2];
    int j = 0;
    while (j < k)
    {
      int m = j / 2;
      int n = Character.digit(paramString.charAt(j), 16);
      arrayOfByte[m] = ((byte)(Character.digit(paramString.charAt(j + 1), 16) + (n << 4)));
      j += 2;
    }
    return arrayOfByte;
  }
  
  /* Error */
  public static String doInBackground(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 381	java/io/File:exists	()Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 7
    //   8: iload_3
    //   9: ifeq +225 -> 234
    //   12: new 383	java/io/BufferedReader
    //   15: dup
    //   16: new 385	java/io/FileReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 388	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   24: sipush 1024
    //   27: invokespecial 391	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   30: astore 5
    //   32: aload 5
    //   34: astore 4
    //   36: aload 5
    //   38: invokevirtual 394	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore 8
    //   43: aload 7
    //   45: astore 4
    //   47: aload 5
    //   49: astore 6
    //   51: aload 8
    //   53: ifnull +65 -> 118
    //   56: aload 5
    //   58: astore 4
    //   60: ldc_w 396
    //   63: invokestatic 402	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   66: aload 8
    //   68: iconst_2
    //   69: invokevirtual 405	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;I)[Ljava/lang/String;
    //   72: astore 6
    //   74: aload 5
    //   76: astore 4
    //   78: aload 6
    //   80: arraylength
    //   81: istore_2
    //   82: iload_2
    //   83: iconst_1
    //   84: if_icmple -52 -> 32
    //   87: aload 6
    //   89: iconst_0
    //   90: aaload
    //   91: astore 8
    //   93: aload 5
    //   95: astore 4
    //   97: aload 8
    //   99: aload_1
    //   100: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: istore_3
    //   104: iload_3
    //   105: ifeq -73 -> 32
    //   108: aload 6
    //   110: iconst_1
    //   111: aaload
    //   112: astore 4
    //   114: aload 5
    //   116: astore 6
    //   118: aload 6
    //   120: ldc_w 411
    //   123: invokestatic 182	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   126: aload 4
    //   128: areturn
    //   129: astore 4
    //   131: aload 5
    //   133: astore_1
    //   134: aload 4
    //   136: astore 5
    //   138: goto +14 -> 152
    //   141: astore_0
    //   142: aconst_null
    //   143: astore 4
    //   145: goto +79 -> 224
    //   148: astore 5
    //   150: aconst_null
    //   151: astore_1
    //   152: aload_1
    //   153: astore 4
    //   155: invokestatic 188	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   158: astore 6
    //   160: aload_1
    //   161: astore 4
    //   163: new 190	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   170: astore 8
    //   172: aload_1
    //   173: astore 4
    //   175: aload 8
    //   177: ldc_w 413
    //   180: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: astore 4
    //   187: aload 8
    //   189: aload_0
    //   190: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_1
    //   195: astore 4
    //   197: aload 6
    //   199: ldc -53
    //   201: aload 8
    //   203: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aload 5
    //   208: invokeinterface 264 4 0
    //   213: aload 7
    //   215: astore 4
    //   217: aload_1
    //   218: astore 6
    //   220: goto -102 -> 118
    //   223: astore_0
    //   224: aload 4
    //   226: ldc_w 411
    //   229: invokestatic 182	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   232: aload_0
    //   233: athrow
    //   234: aconst_null
    //   235: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramFile	File
    //   0	236	1	paramString	String
    //   81	4	2	j	int
    //   4	101	3	bool	boolean
    //   34	93	4	localObject1	Object
    //   129	6	4	localException1	Exception
    //   143	82	4	localObject2	Object
    //   30	107	5	localObject3	Object
    //   148	59	5	localException2	Exception
    //   49	170	6	localObject4	Object
    //   6	208	7	localObject5	Object
    //   41	161	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	43	129	java/lang/Exception
    //   60	74	129	java/lang/Exception
    //   97	104	129	java/lang/Exception
    //   12	32	141	java/lang/Throwable
    //   12	32	148	java/lang/Exception
    //   36	43	223	java/lang/Throwable
    //   60	74	223	java/lang/Throwable
    //   78	82	223	java/lang/Throwable
    //   97	104	223	java/lang/Throwable
    //   155	160	223	java/lang/Throwable
    //   163	172	223	java/lang/Throwable
    //   175	184	223	java/lang/Throwable
    //   187	194	223	java/lang/Throwable
    //   197	213	223	java/lang/Throwable
  }
  
  public static boolean eqSameCase(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public static int execute(Context paramContext)
  {
    if (init(paramContext)) {
      k = 1;
    } else {
      k = 0;
    }
    int j = k;
    if (get(paramContext)) {
      j = k | 0x2;
    }
    int k = j;
    if (update()) {
      k = j | 0x4;
    }
    return k;
  }
  
  public static long get()
  {
    try
    {
      if (c == -1L)
      {
        long l2 = 0L;
        String str = doInBackground(new File("/proc/meminfo"), "MemTotal");
        l1 = l2;
        if (!TextUtils.isEmpty(str))
        {
          str = str.toUpperCase(Locale.US);
          try
          {
            boolean bool = str.endsWith("KB");
            if (bool)
            {
              l1 = add(str, "KB", 1024);
            }
            else
            {
              bool = str.endsWith("MB");
              if (bool)
              {
                l1 = add(str, "MB", 1048576);
              }
              else
              {
                bool = str.endsWith("GB");
                if (bool)
                {
                  l1 = add(str, "GB", 1073741824);
                }
                else
                {
                  Log localLog = f.get();
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("Unexpected meminfo format while computing RAM: ");
                  ((StringBuilder)localObject).append(str);
                  localLog.d("Fabric", ((StringBuilder)localObject).toString());
                  l1 = l2;
                }
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Object localObject = f.get();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unexpected meminfo format while computing RAM: ");
            localStringBuilder.append(str);
            ((Log)localObject).d("Fabric", localStringBuilder.toString(), localNumberFormatException);
            l1 = l2;
          }
        }
        c = l1;
      }
      long l1 = c;
      return l1;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static String get(int paramInt)
  {
    if (paramInt >= 0) {
      return String.format(Locale.US, "%1$10s", new Object[] { Integer.valueOf(paramInt) }).replace(' ', '0');
    }
    throw new IllegalArgumentException("value must be zero or greater");
  }
  
  public static String get(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new Scanner(paramInputStream).useDelimiter("\\A");
    if (paramInputStream.hasNext()) {
      return paramInputStream.next();
    }
    return "";
  }
  
  public static String get(String paramString)
  {
    return read(paramString.getBytes(), "SHA-256");
  }
  
  public static String get(String paramString1, String paramString2)
  {
    return read(paramString1.getBytes(), paramString2);
  }
  
  public static String get(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return null;
      }
      Object localObject = new ArrayList();
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        String str = paramVarArgs[j];
        if (str != null) {
          ((List)localObject).add(str.replace("-", "").toLowerCase(Locale.US));
        }
        j += 1;
      }
      Collections.sort((List)localObject);
      paramVarArgs = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramVarArgs.append((String)((Iterator)localObject).next());
      }
      paramVarArgs = paramVarArgs.toString();
      if (paramVarArgs.length() > 0) {
        return read(paramVarArgs.getBytes(), "SHA-1");
      }
    }
    return null;
  }
  
  public static void get(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    paramInt = Build.VERSION.SDK_INT;
    paramActivity.finishAffinity();
  }
  
  public static boolean get(Context paramContext)
  {
    boolean bool = init(paramContext);
    paramContext = Build.TAGS;
    if ((!bool) && (paramContext != null) && (paramContext.contains("test-keys"))) {
      return true;
    }
    if (new File("/system/app/Superuser.apk").exists()) {
      return true;
    }
    paramContext = new File("/system/xbin/su");
    return (!bool) && (paramContext.exists());
  }
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramContext != null)
    {
      Resources localResources = paramContext.getResources();
      bool = paramBoolean;
      if (localResources != null)
      {
        int j = paramContext.getResources().getIdentifier(paramString, "bool", getName(paramContext));
        if (j > 0) {
          return localResources.getBoolean(j);
        }
        j = paramContext.getResources().getIdentifier(paramString, "string", getName(paramContext));
        bool = paramBoolean;
        if (j > 0) {
          bool = Boolean.parseBoolean(paramContext.getString(j));
        }
      }
    }
    return bool;
  }
  
  public static String getCharacter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 7: 
      return "A";
    case 6: 
      return "E";
    case 5: 
      return "W";
    case 4: 
      return "I";
    case 3: 
      return "D";
    }
    return "V";
  }
  
  public static Cipher getCipher(int paramInt, String paramString)
    throws InvalidKeyException
  {
    throw new InvalidKeyException("This method is deprecated");
  }
  
  public static SharedPreferences getDefaultSharedPreferences(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.crashlytics.prefs", 0);
  }
  
  public static long getFreeSpace(String paramString)
  {
    paramString = new StatFs(paramString);
    long l = paramString.getBlockSize();
    return paramString.getBlockCount() * l - l * paramString.getAvailableBlocks();
  }
  
  public static int getIcon(Context paramContext)
  {
    return getApplicationContextgetApplicationInfoicon;
  }
  
  public static String getName(Context paramContext)
  {
    int j = getApplicationContextgetApplicationInfoicon;
    if (j > 0) {}
    try
    {
      String str = paramContext.getResources().getResourcePackageName(j);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;) {}
    }
    return paramContext.getPackageName();
    return paramContext.getPackageName();
  }
  
  public static String getString(Context paramContext)
  {
    int j = paramContext.getResources().getIdentifier("com.google.firebase.crashlytics.unity_version", "string", getName(paramContext));
    if (j != 0)
    {
      paramContext = paramContext.getResources().getString(j);
      Log localLog = f.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unity Editor version is: ");
      localStringBuilder.append(paramContext);
      localLog.d("Fabric", localStringBuilder.toString());
      return paramContext;
    }
    return null;
  }
  
  public static boolean hasPermission(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static void hide(Context paramContext, View paramView)
  {
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null) {
      paramContext.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public static void hideKeyboard(Context paramContext, View paramView)
  {
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null) {
      paramContext.showSoftInputFromInputMethod(paramView.getWindowToken(), 0);
    }
  }
  
  public static boolean init(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    return ("sdk".equals(Build.PRODUCT)) || ("google_sdk".equals(Build.PRODUCT)) || (paramContext == null);
  }
  
  public static long initialize(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    return availMem;
  }
  
  public static boolean isDebugMode(Context paramContext)
  {
    return (getApplicationInfoflags & 0x2) != 0;
  }
  
  public static boolean isOnline(Context paramContext)
  {
    int j;
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {
        return true;
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  public static ActivityManager.RunningAppProcessInfo isRunning(String paramString, Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (processName.equals(paramString)) {
          return localRunningAppProcessInfo;
        }
      }
    }
    return null;
  }
  
  public static void put(String paramString1, String paramString2)
  {
    if (!f.d())
    {
      f.get().remove(paramString1, paramString2);
      return;
    }
    throw new IllegalStateException(paramString2);
  }
  
  public static boolean put(Context paramContext)
  {
    return false;
  }
  
  public static boolean put(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String read(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      byte[] arrayOfByte = new byte['?'];
      for (;;)
      {
        int j = paramInputStream.read(arrayOfByte);
        if (j == -1) {
          break;
        }
        paramString.update(arrayOfByte, 0, j);
      }
      paramInputStream = toString(paramString.digest());
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      f.get().d("Fabric", "Could not calculate hash for app icon.", paramInputStream);
    }
    return "";
  }
  
  public static String read(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      localMessageDigest.update(paramArrayOfByte);
      return toString(localMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      f.get().d("Fabric", f.sufficientlysecure.rootcommands.util.StringBuilder.append("Could not create hashing algorithm: ", paramString, ", returning empty string."), paramArrayOfByte);
    }
    return "";
  }
  
  public static boolean start(Context paramContext)
  {
    if (init(paramContext)) {
      return false;
    }
    return ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(8) != null;
  }
  
  public static String toString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[j] & 0xFF;
      int m = j * 2;
      char[] arrayOfChar2 = s;
      arrayOfChar1[m] = arrayOfChar2[(k >>> 4)];
      arrayOfChar1[(m + 1)] = arrayOfChar2[(k & 0xF)];
      j += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public static boolean update()
  {
    return (Debug.isDebuggerConnected()) || (Debug.waitingForDebugger());
  }
}
