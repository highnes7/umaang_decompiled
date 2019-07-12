package support.android.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class MultiDex
{
  public static final boolean IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
  public static final int MAX_SUPPORTED_SDK_VERSION = 20;
  public static final int MIN_SDK_VERSION = 4;
  public static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
  public static final String RANGE_STARTS = "";
  public static final String SECONDARY_FOLDER_NAME = "secondary-dexes";
  public static final String TAG = "MultiDex";
  public static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
  public static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
  public static final String c = "code_cache";
  public static final Set<File> installedApk = new HashSet();
  
  public MultiDex() {}
  
  public static void clearOldDexDir(Context paramContext)
    throws Exception
  {
    paramContext = new File(paramContext.getFilesDir(), "secondary-dexes");
    if (paramContext.isDirectory())
    {
      Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Clearing old secondary dex dir (");
      ((StringBuilder)localObject1).append(paramContext.getPath());
      ((StringBuilder)localObject1).append(").");
      ((StringBuilder)localObject1).toString();
      localObject1 = paramContext.listFiles();
      if (localObject1 == null)
      {
        localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to list secondary dex dir content (");
        ((StringBuilder)localObject1).append(paramContext.getPath());
        ((StringBuilder)localObject1).append(").");
        ((StringBuilder)localObject1).toString();
        return;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Trying to delete old file ");
        localStringBuilder.append(localObject2.getPath());
        localStringBuilder.append(" of size ");
        localStringBuilder.append(localObject2.length());
        localStringBuilder.toString();
        if (!localObject2.delete())
        {
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to delete old file ");
          localStringBuilder.append(localObject2.getPath());
          localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Deleted old file ");
          localStringBuilder.append(localObject2.getPath());
          localStringBuilder.toString();
        }
        i += 1;
      }
      if (!paramContext.delete())
      {
        localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to delete secondary dex dir ");
        ((StringBuilder)localObject1).append(paramContext.getPath());
        ((StringBuilder)localObject1).toString();
        return;
      }
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Deleted old secondary dex dir ");
      ((StringBuilder)localObject1).append(paramContext.getPath());
      ((StringBuilder)localObject1).toString();
    }
  }
  
  public static void expandFieldArray(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramString = findField(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])paramString.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, arrayOfObject1.length, paramArrayOfObject.length);
    paramString.set(paramObject, arrayOfObject2);
  }
  
  public static Field findField(Object paramObject, String paramString)
    throws NoSuchFieldException
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        boolean bool = localField.isAccessible();
        if (bool) {
          break label102;
        }
        localField.setAccessible(true);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;) {}
        return localNoSuchFieldException;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new NoSuchFieldException(((StringBuilder)localObject).toString());
    throw paramObject;
  }
  
  public static Method findMethod(Object paramObject, String paramString, Class... paramVarArgs)
    throws NoSuchMethodException
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Method localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        boolean bool = localMethod.isAccessible();
        if (bool) {
          break label132;
        }
        localMethod.setAccessible(true);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
        return localNoSuchMethodException;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Method ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" with parameters ");
    ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new NoSuchMethodException(((StringBuilder)localObject).toString());
    throw paramObject;
  }
  
  public static ApplicationInfo getApplicationInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationInfo();
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static File getFile(Context paramContext, File paramFile, String paramString)
    throws IOException
  {
    paramFile = new File(paramFile, "code_cache");
    try
    {
      mkdirChecked(paramFile);
      paramContext = paramFile;
    }
    catch (IOException paramFile)
    {
      for (;;) {}
    }
    paramContext = new File(paramContext.getFilesDir(), "code_cache");
    mkdirChecked(paramContext);
    paramContext = new File(paramContext, paramString);
    mkdirChecked(paramContext);
    return paramContext;
  }
  
  public static void install(Context paramContext)
  {
    if (IS_VM_MULTIDEX_CAPABLE) {
      return;
    }
    int i = Build.VERSION.SDK_INT;
    try
    {
      localObject1 = getApplicationInfo(paramContext);
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = sourceDir;
      localObject2 = new File((String)localObject2);
      localObject1 = dataDir;
      install(paramContext, (File)localObject2, new File((String)localObject1), "secondary-dexes", "");
      return;
    }
    catch (Exception paramContext)
    {
      Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("MultiDex installation failed (");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      ((StringBuilder)localObject1).append(").");
      throw new RuntimeException(((StringBuilder)localObject1).toString());
    }
  }
  
  public static void install(Context paramContext1, Context paramContext2)
  {
    if (IS_VM_MULTIDEX_CAPABLE) {
      return;
    }
    int i = Build.VERSION.SDK_INT;
    try
    {
      Object localObject2 = getApplicationInfo(paramContext1);
      if (localObject2 == null) {
        return;
      }
      ApplicationInfo localApplicationInfo = getApplicationInfo(paramContext2);
      if (localApplicationInfo == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext1.getPackageName());
      ((StringBuilder)localObject1).append(".");
      paramContext1 = ((StringBuilder)localObject1).toString();
      localObject1 = dataDir;
      localObject1 = new File((String)localObject1);
      localObject2 = sourceDir;
      localObject2 = new File((String)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext1);
      localStringBuilder.append("secondary-dexes");
      install(paramContext2, (File)localObject2, (File)localObject1, localStringBuilder.toString(), paramContext1);
      paramContext1 = sourceDir;
      install(paramContext2, new File(paramContext1), (File)localObject1, "secondary-dexes", "");
      return;
    }
    catch (Exception paramContext1)
    {
      paramContext2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("MultiDex installation failed (");
      paramContext2.append(paramContext1.getMessage());
      paramContext2.append(").");
      throw new RuntimeException(paramContext2.toString());
    }
  }
  
  /* Error */
  public static void install(Context paramContext, File paramFile1, File paramFile2, String paramString1, String paramString2)
    throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
  {
    // Byte code:
    //   0: getstatic 47	support/android/widget/MultiDex:installedApk	Ljava/util/Set;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: getstatic 47	support/android/widget/MultiDex:installedApk	Ljava/util/Set;
    //   11: aload_1
    //   12: invokeinterface 286 2 0
    //   17: ifeq +7 -> 24
    //   20: aload 6
    //   22: monitorexit
    //   23: return
    //   24: getstatic 47	support/android/widget/MultiDex:installedApk	Ljava/util/Set;
    //   27: aload_1
    //   28: invokeinterface 289 2 0
    //   33: pop
    //   34: getstatic 250	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 20
    //   39: if_icmple +100 -> 139
    //   42: new 120	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   49: astore 7
    //   51: aload 7
    //   53: ldc_w 291
    //   56: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 7
    //   62: getstatic 250	android/os/Build$VERSION:SDK_INT	I
    //   65: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 7
    //   71: ldc_w 296
    //   74: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 7
    //   80: bipush 20
    //   82: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 7
    //   88: ldc_w 298
    //   91: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 7
    //   97: ldc_w 300
    //   100: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 7
    //   106: ldc_w 302
    //   109: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 7
    //   115: ldc 49
    //   117: invokestatic 55	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 7
    //   126: ldc_w 304
    //   129: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 7
    //   135: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: pop
    //   139: aload_0
    //   140: invokevirtual 308	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   143: astore 7
    //   145: aload 7
    //   147: ifnonnull +7 -> 154
    //   150: aload 6
    //   152: monitorexit
    //   153: return
    //   154: aload_0
    //   155: invokestatic 310	support/android/widget/MultiDex:clearOldDexDir	(Landroid/content/Context;)V
    //   158: aload_0
    //   159: aload_2
    //   160: aload_3
    //   161: invokestatic 312	support/android/widget/MultiDex:getFile	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   164: astore_2
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: aload 4
    //   170: iconst_0
    //   171: invokestatic 318	support/android/widget/MultiDexExtractor:load	(Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/lang/String;Z)Ljava/util/List;
    //   174: astore_0
    //   175: aload_0
    //   176: invokeinterface 323 1 0
    //   181: ifne +15 -> 196
    //   184: getstatic 250	android/os/Build$VERSION:SDK_INT	I
    //   187: istore 5
    //   189: aload 7
    //   191: aload_0
    //   192: aload_2
    //   193: invokestatic 326	support/android/widget/MultiDex$V19:install	(Ljava/lang/ClassLoader;Ljava/util/List;Ljava/io/File;)V
    //   196: aload 6
    //   198: monitorexit
    //   199: return
    //   200: aload 6
    //   202: monitorexit
    //   203: return
    //   204: astore_0
    //   205: aload 6
    //   207: monitorexit
    //   208: aload_0
    //   209: athrow
    //   210: astore_0
    //   211: goto -11 -> 200
    //   214: astore 8
    //   216: goto -58 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramContext	Context
    //   0	219	1	paramFile1	File
    //   0	219	2	paramFile2	File
    //   0	219	3	paramString1	String
    //   0	219	4	paramString2	String
    //   187	1	5	i	int
    //   3	203	6	localSet	Set
    //   49	141	7	localObject	Object
    //   214	1	8	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	23	204	java/lang/Throwable
    //   24	139	204	java/lang/Throwable
    //   139	145	204	java/lang/Throwable
    //   150	153	204	java/lang/Throwable
    //   158	196	204	java/lang/Throwable
    //   196	199	204	java/lang/Throwable
    //   200	203	204	java/lang/Throwable
    //   205	208	204	java/lang/Throwable
    //   139	145	210	java/lang/RuntimeException
    //   154	158	214	java/lang/Throwable
  }
  
  public static void install(ClassLoader paramClassLoader, File paramFile, List paramList)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException
  {
    if (!paramList.isEmpty())
    {
      int i = Build.VERSION.SDK_INT;
      V19.install(paramClassLoader, paramList, paramFile);
    }
  }
  
  public static boolean isVMMultidexCapable(String paramString)
  {
    bool2 = false;
    bool1 = bool2;
    if (paramString != null)
    {
      localObject = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!((Matcher)localObject).matches()) {}
    }
    try
    {
      int i = Integer.parseInt(((Matcher)localObject).group(1));
      int j = Integer.parseInt(((Matcher)localObject).group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j < 1) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("VM with version ", paramString);
    if (bool1) {
      paramString = " has multidex support";
    } else {
      paramString = " does not have multidex support";
    }
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).toString();
    return bool1;
  }
  
  public static void mkdirChecked(File paramFile)
    throws IOException
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      Object localObject = paramFile.getParentFile();
      if (localObject == null)
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to create dir ");
        ((StringBuilder)localObject).append(paramFile.getPath());
        ((StringBuilder)localObject).append(". Parent file is null.");
        ((StringBuilder)localObject).toString();
      }
      else
      {
        StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to create dir ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.append(". parent file is a dir ");
        localStringBuilder.append(((File)localObject).isDirectory());
        localStringBuilder.append(", a file ");
        localStringBuilder.append(((File)localObject).isFile());
        localStringBuilder.append(", exists ");
        localStringBuilder.append(((File)localObject).exists());
        localStringBuilder.append(", readable ");
        localStringBuilder.append(((File)localObject).canRead());
        localStringBuilder.append(", writable ");
        localStringBuilder.append(((File)localObject).canWrite());
        localStringBuilder.toString();
      }
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to create directory ");
      ((StringBuilder)localObject).append(paramFile.getPath());
      throw new IOException(((StringBuilder)localObject).toString());
    }
  }
  
  public final class V14
  {
    public V14() {}
    
    public static void install(ClassLoader paramClassLoader, List paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
    {
      paramClassLoader = MultiDex.findField(paramClassLoader, "pathList").get(paramClassLoader);
      MultiDex.expandFieldArray(paramClassLoader, "dexElements", makeDexElements(paramClassLoader, new ArrayList(paramList), paramFile));
    }
    
    public static Object[] makeDexElements(Object paramObject, ArrayList paramArrayList, File paramFile)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])MultiDex.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile });
    }
  }
  
  public final class V19
  {
    public V19() {}
    
    public static void install(ClassLoader paramClassLoader, List paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
    {
      Object localObject = MultiDex.findField(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      MultiDex.expandFieldArray(localObject, "dexElements", makeDexElements(localObject, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        while (paramClassLoader.hasNext()) {
          paramList = (IOException)paramClassLoader.next();
        }
        paramList = MultiDex.findField(localObject, "dexElementsSuppressedExceptions");
        paramFile = (IOException[])paramList.get(localObject);
        if (paramFile == null)
        {
          paramClassLoader = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
        }
        else
        {
          paramClassLoader = new IOException[localArrayList.size() + paramFile.length];
          localArrayList.toArray(paramClassLoader);
          System.arraycopy(paramFile, 0, paramClassLoader, localArrayList.size(), paramFile.length);
        }
        paramList.set(localObject, paramClassLoader);
      }
    }
    
    public static Object[] makeDexElements(Object paramObject, ArrayList paramArrayList1, File paramFile, ArrayList paramArrayList2)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])MultiDex.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(paramObject, new Object[] { paramArrayList1, paramFile, paramArrayList2 });
    }
  }
  
  public final class V4
  {
    public V4() {}
    
    public static void install(ClassLoader paramClassLoader, List paramList)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException
    {
      int i = paramList.size();
      Field localField = MultiDex.findField(paramClassLoader, "path");
      StringBuilder localStringBuilder = new StringBuilder((String)localField.get(paramClassLoader));
      String[] arrayOfString = new String[i];
      File[] arrayOfFile = new File[i];
      ZipFile[] arrayOfZipFile = new ZipFile[i];
      DexFile[] arrayOfDexFile = new DexFile[i];
      paramList = paramList.listIterator();
      while (paramList.hasNext())
      {
        Object localObject = (File)paramList.next();
        String str = ((File)localObject).getAbsolutePath();
        localStringBuilder.append(':');
        localStringBuilder.append(str);
        i = paramList.previousIndex();
        arrayOfString[i] = str;
        arrayOfFile[i] = localObject;
        arrayOfZipFile[i] = new ZipFile((File)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(".dex");
        arrayOfDexFile[i] = DexFile.loadDex(str, ((StringBuilder)localObject).toString(), 0);
      }
      localField.set(paramClassLoader, localStringBuilder.toString());
      MultiDex.expandFieldArray(paramClassLoader, "mPaths", arrayOfString);
      MultiDex.expandFieldArray(paramClassLoader, "mFiles", arrayOfFile);
      MultiDex.expandFieldArray(paramClassLoader, "mZips", arrayOfZipFile);
      MultiDex.expandFieldArray(paramClassLoader, "mDexs", arrayOfDexFile);
    }
  }
}
