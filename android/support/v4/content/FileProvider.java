package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import b.b.a.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.v4.content.ContextCompat;

public class FileProvider
  extends ContentProvider
{
  public static final String ATTR_NAME = "external-media-path";
  public static final String ATTR_PATH = "path";
  public static final String AUTHORITY = "external-files-path";
  public static final String[] COLUMNS = { "_display_name", "_size" };
  public static final String COLUMN_SKILLS_NAME = "name";
  public static final File DEVICE_ROOT = new File("/");
  public static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  public static final String TAG = "external-cache-path";
  public static final String TAG_CACHE_PATH = "cache-path";
  public static final String TAG_EXTERNAL = "external-path";
  public static final String TAG_FILES_PATH = "files-path";
  public static final String TAG_ROOT_PATH = "root-path";
  @t("sCache")
  public static HashMap<String, a> sCache = new HashMap();
  public a mStrategy;
  
  public FileProvider() {}
  
  public static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      File localFile = paramFile;
      if (str != null) {
        localFile = new File(paramFile, str);
      }
      i += 1;
      paramFile = localFile;
    }
    return paramFile;
  }
  
  public static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  public static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  public static a getPathStrategy(Context paramContext, String paramString)
  {
    HashMap localHashMap = sCache;
    try
    {
      a localA = (a)sCache.get(paramString);
      Object localObject = localA;
      if (localA == null) {
        try
        {
          paramContext = parsePathStrategy(paramContext, paramString);
          localObject = paramContext;
          sCache.put(paramString, paramContext);
        }
        catch (XmlPullParserException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
        catch (IOException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }
  
  public static int modeToMode(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
    {
      if ("wa".equals(paramString)) {
        return 704643072;
      }
      if ("rw".equals(paramString)) {
        return 939524096;
      }
      if ("rwt".equals(paramString)) {
        return 1006632960;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Invalid mode: ", paramString));
    }
    return 738197504;
  }
  
  public static a parsePathStrategy(Context paramContext, String paramString)
    throws IOException, XmlPullParserException
  {
    b localB = new b(paramString);
    XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser != null)
    {
      for (;;)
      {
        int i = localXmlResourceParser.next();
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          Object localObject2 = localXmlResourceParser.getName();
          Object localObject1 = null;
          String str1 = localXmlResourceParser.getAttributeValue(null, "name");
          String str2 = localXmlResourceParser.getAttributeValue(null, "path");
          if ("root-path".equals(localObject2))
          {
            paramString = DEVICE_ROOT;
          }
          else if ("files-path".equals(localObject2))
          {
            paramString = paramContext.getFilesDir();
          }
          else if ("cache-path".equals(localObject2))
          {
            paramString = paramContext.getCacheDir();
          }
          else if ("external-path".equals(localObject2))
          {
            paramString = Environment.getExternalStorageDirectory();
          }
          else if ("external-files-path".equals(localObject2))
          {
            localObject2 = ContextCompat.getExternalFilesDirs(paramContext, null);
            paramString = localObject1;
            if (localObject2.length > 0) {
              paramString = localObject2[0];
            }
          }
          else if ("external-cache-path".equals(localObject2))
          {
            localObject2 = ContextCompat.getExternalCacheDirs(paramContext);
            paramString = localObject1;
            if (localObject2.length > 0) {
              paramString = localObject2[0];
            }
          }
          else
          {
            paramString = localObject1;
            if (Build.VERSION.SDK_INT >= 21)
            {
              paramString = localObject1;
              if ("external-media-path".equals(localObject2))
              {
                localObject2 = paramContext.getExternalMediaDirs();
                paramString = localObject1;
                if (localObject2.length > 0) {
                  paramString = localObject2[0];
                }
              }
            }
          }
          if (paramString != null) {
            localB.addRoot(str1, buildPath(paramString, new String[] { str2 }));
          }
        }
      }
      return localB;
    }
    paramContext = new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    throw paramContext;
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!exported)
    {
      if (grantUriPermissions)
      {
        mStrategy = getPathStrategy(paramContext, authority);
        return;
      }
      throw new SecurityException("Provider must grant uri permissions");
    }
    throw new SecurityException("Provider must not be exported");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = mStrategy.getFileForUri(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null) {
        return paramUri;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    return ParcelFileDescriptor.open(mStrategy.getFileForUri(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = mStrategy.getFileForUri(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int k;
    for (int i = 0; j < m; i = k)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
      }
      for (i = k;; i = k)
      {
        k = i;
        break;
        k = i;
        if (!"_size".equals(paramString2)) {
          break;
        }
        paramArrayOfString2[i] = "_size";
        k = i + 1;
        paramArrayOfString1[i] = Long.valueOf(paramString1.length());
      }
      j += 1;
    }
    paramUri = copyOf(paramArrayOfString2, i);
    paramArrayOfString1 = copyOf(paramArrayOfString1, i);
    paramUri = new MatrixCursor(paramUri, 1);
    paramUri.addRow(paramArrayOfString1);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  public static abstract interface a
  {
    public abstract File getFileForUri(Uri paramUri);
    
    public abstract Uri getUriForFile(File paramFile);
  }
  
  public static class b
    implements FileProvider.a
  {
    public final String mAuthority;
    public final HashMap<String, File> mRoots = new HashMap();
    
    public b(String paramString)
    {
      mAuthority = paramString;
    }
    
    public void addRoot(String paramString, File paramFile)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          File localFile = paramFile.getCanonicalFile();
          mRoots.put(paramString, localFile);
          return;
        }
        catch (IOException paramString)
        {
          throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Failed to resolve canonical path for ", paramFile), paramString);
        }
      }
      throw new IllegalArgumentException("Name must not be empty");
    }
    
    public File getFileForUri(Uri paramUri)
    {
      Object localObject2 = paramUri.getEncodedPath();
      int i = ((String)localObject2).indexOf('/', 1);
      Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
      localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
      localObject1 = (File)mRoots.get(localObject1);
      if (localObject1 != null) {
        paramUri = new File((File)localObject1, (String)localObject2);
      }
      try
      {
        localObject2 = paramUri.getCanonicalFile();
        if (((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
          return localObject2;
        }
        throw new SecurityException("Resolved path jumped beyond configured root");
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Failed to resolve canonical path for ", paramUri));
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unable to find configured root for ", paramUri));
    }
    
    public Uri getUriForFile(File paramFile)
    {
      try
      {
        Object localObject2 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = mRoots.entrySet().iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          String str = ((File)((Map.Entry)localObject1).getValue()).getPath();
          if ((((String)localObject2).startsWith(str)) && ((paramFile == null) || (str.length() > ((File)paramFile.getValue()).getPath().length()))) {
            paramFile = (File)localObject1;
          }
        }
        if (paramFile != null)
        {
          localObject1 = ((File)paramFile.getValue()).getPath();
          if (((String)localObject1).endsWith("/")) {
            localObject1 = ((String)localObject2).substring(((String)localObject1).length());
          } else {
            localObject1 = ((String)localObject2).substring(((String)localObject1).length() + 1);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Uri.encode((String)paramFile.getKey()));
          ((StringBuilder)localObject2).append('/');
          ((StringBuilder)localObject2).append(Uri.encode((String)localObject1, "/"));
          paramFile = ((StringBuilder)localObject2).toString();
          return new Uri.Builder().scheme("content").authority(mAuthority).encodedPath(paramFile).build();
        }
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Failed to find configured root that contains ", (String)localObject2));
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      paramFile = new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Failed to resolve canonical path for ", paramFile));
      throw paramFile;
    }
  }
}
