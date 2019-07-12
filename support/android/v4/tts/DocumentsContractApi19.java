package support.android.v4.tts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import b.b.a.K;

@K(19)
public class DocumentsContractApi19
{
  public static final int META_ALT_LOCKED = 512;
  public static final String TAG = "DocumentFile";
  
  public DocumentsContractApi19() {}
  
  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) {
      return false;
    }
    return !TextUtils.isEmpty(getRawType(paramContext, paramUri));
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0) {
      return false;
    }
    String str = getRawType(paramContext, paramUri);
    int i = queryForInt(paramContext, paramUri, "flags", 0);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if ((i & 0x4) != 0) {
      return true;
    }
    if (("vnd.android.document/directory".equals(str)) && ((i & 0x8) != 0)) {
      return true;
    }
    return (!TextUtils.isEmpty(str)) && ((i & 0x2) != 0);
  }
  
  public static void closeQuietly(AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {
      try
      {
        paramAutoCloseable.close();
        return;
      }
      catch (RuntimeException paramAutoCloseable)
      {
        throw paramAutoCloseable;
      }
      catch (Exception paramAutoCloseable) {}
    }
  }
  
  public static boolean delete(Context paramContext, Uri paramUri)
  {
    if (!DocumentsContract.isDocumentUri(paramContext, paramUri)) {
      return false;
    }
    return (queryForLong(paramContext, paramUri) & 0x200) != 0L;
  }
  
  public static boolean exists(Context paramContext, Uri paramUri)
  {
    Object localObject = paramContext.getContentResolver();
    boolean bool = false;
    Uri localUri = null;
    paramContext = null;
    try
    {
      paramUri = ((ContentResolver)localObject).query(paramUri, new String[] { "document_id" }, null, null, null);
      localUri = paramUri;
      paramContext = localUri;
      int i = paramUri.getCount();
      if (i > 0) {
        bool = true;
      }
      closeQuietly(paramUri);
      return bool;
    }
    catch (Throwable paramUri) {}catch (Exception paramUri)
    {
      paramContext = localUri;
      localObject = new StringBuilder();
      paramContext = localUri;
      ((StringBuilder)localObject).append("Failed query: ");
      paramContext = localUri;
      ((StringBuilder)localObject).append(paramUri);
      paramContext = localUri;
      ((StringBuilder)localObject).toString();
      closeQuietly(localUri);
      return false;
    }
    closeQuietly(paramContext);
    throw paramUri;
  }
  
  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  public static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  public static String getType(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    if ("vnd.android.document/directory".equals(paramContext)) {
      return null;
    }
    return paramContext;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri)
  {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    return (!"vnd.android.document/directory".equals(paramContext)) && (!TextUtils.isEmpty(paramContext));
  }
  
  public static long lastModified(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }
  
  public static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt)
  {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }
  
  public static long queryForLong(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "flags", 0L);
  }
  
  public static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = null;
    paramContext = null;
    try
    {
      paramString = localContentResolver.query(paramUri, new String[] { paramString }, null, null, null);
      paramUri = paramString;
      paramContext = paramUri;
      localUri = paramUri;
      boolean bool = paramString.moveToFirst();
      if (bool)
      {
        paramContext = paramUri;
        localUri = paramUri;
        bool = paramString.isNull(0);
        if (!bool)
        {
          paramContext = paramUri;
          localUri = paramUri;
          long l = paramString.getLong(0);
          closeQuietly(paramString);
          return l;
        }
      }
      closeQuietly(paramString);
      return paramLong;
    }
    catch (Throwable paramUri) {}catch (Exception paramUri)
    {
      paramContext = localUri;
      paramString = new StringBuilder();
      paramContext = localUri;
      paramString.append("Failed query: ");
      paramContext = localUri;
      paramString.append(paramUri);
      paramContext = localUri;
      paramString.toString();
      closeQuietly(localUri);
      return paramLong;
    }
    closeQuietly(paramContext);
    throw paramUri;
  }
  
  public static String queryForString(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = null;
    paramContext = null;
    try
    {
      paramString1 = localContentResolver.query(paramUri, new String[] { paramString1 }, null, null, null);
      paramUri = paramString1;
      paramContext = paramUri;
      localUri = paramUri;
      boolean bool = paramString1.moveToFirst();
      if (bool)
      {
        paramContext = paramUri;
        localUri = paramUri;
        bool = paramString1.isNull(0);
        if (!bool)
        {
          paramContext = paramUri;
          localUri = paramUri;
          paramUri = paramString1.getString(0);
          closeQuietly(paramString1);
          return paramUri;
        }
      }
      closeQuietly(paramString1);
      return paramString2;
    }
    catch (Throwable paramUri) {}catch (Exception paramUri)
    {
      paramContext = localUri;
      paramString1 = new StringBuilder();
      paramContext = localUri;
      paramString1.append("Failed query: ");
      paramContext = localUri;
      paramString1.append(paramUri);
      paramContext = localUri;
      paramString1.toString();
      closeQuietly(localUri);
      return paramString2;
    }
    closeQuietly(paramContext);
    throw paramUri;
  }
}
