package support.android.v4.tts;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.DocumentsContract;
import b.b.a.G;
import java.io.File;

public abstract class DocumentFile
{
  public static final String TAG = "DocumentFile";
  @G
  public final DocumentFile mParent;
  
  public DocumentFile(DocumentFile paramDocumentFile)
  {
    mParent = paramDocumentFile;
  }
  
  public static DocumentFile fromFile(File paramFile)
  {
    return new RawDocumentFile(null, paramFile);
  }
  
  public static DocumentFile fromSingleUri(Context paramContext, Uri paramUri)
  {
    int i = Build.VERSION.SDK_INT;
    return new SingleDocumentFile(null, paramContext, paramUri);
  }
  
  public static DocumentFile fromTreeUri(Context paramContext, Uri paramUri)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new TreeDocumentFile(null, paramContext, DocumentsContract.buildDocumentUriUsingTree(paramUri, DocumentsContract.getTreeDocumentId(paramUri)));
    }
    return null;
  }
  
  public static boolean isDocumentUri(Context paramContext, Uri paramUri)
  {
    int i = Build.VERSION.SDK_INT;
    return DocumentsContract.isDocumentUri(paramContext, paramUri);
  }
  
  public abstract boolean canRead();
  
  public abstract boolean canWrite();
  
  public abstract DocumentFile createDirectory(String paramString);
  
  public abstract DocumentFile createFile(String paramString1, String paramString2);
  
  public abstract boolean delete();
  
  public abstract boolean exists();
  
  public DocumentFile findFile(String paramString)
  {
    DocumentFile[] arrayOfDocumentFile = listFiles();
    int j = arrayOfDocumentFile.length;
    int i = 0;
    while (i < j)
    {
      DocumentFile localDocumentFile = arrayOfDocumentFile[i];
      if (paramString.equals(localDocumentFile.getName())) {
        return localDocumentFile;
      }
      i += 1;
    }
    return null;
  }
  
  public abstract String getName();
  
  public DocumentFile getParentFile()
  {
    return mParent;
  }
  
  public abstract String getType();
  
  public abstract Uri getUri();
  
  public abstract boolean isDirectory();
  
  public abstract boolean isFile();
  
  public abstract long lastModified();
  
  public abstract long length();
  
  public abstract DocumentFile[] listFiles();
  
  public abstract boolean renameTo();
  
  public abstract boolean renameTo(String paramString);
}
