package support.android.v4.tts;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RawDocumentFile
  extends DocumentFile
{
  public File mFile;
  
  public RawDocumentFile(DocumentFile paramDocumentFile, File paramFile)
  {
    super(paramDocumentFile);
    mFile = paramFile;
  }
  
  public static boolean deleteContents(File paramFile)
  {
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      boolean bool1 = true;
      while (i < j)
      {
        File localFile = paramFile[i];
        boolean bool2 = bool1;
        if (localFile.isDirectory()) {
          bool2 = bool1 & deleteContents(localFile);
        }
        bool1 = bool2;
        if (!localFile.delete())
        {
          StringBuilder.append("Failed to delete ", localFile);
          bool1 = false;
        }
        i += 1;
      }
      return bool1;
    }
    return true;
  }
  
  public static String getTypeForName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i >= 0)
    {
      paramString = paramString.substring(i + 1).toLowerCase();
      paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    return "application/octet-stream";
  }
  
  public boolean canRead()
  {
    return mFile.canRead();
  }
  
  public boolean canWrite()
  {
    return mFile.canWrite();
  }
  
  public DocumentFile createDirectory(String paramString)
  {
    paramString = new File(mFile, paramString);
    if ((!paramString.isDirectory()) && (!paramString.mkdir())) {
      return null;
    }
    return new RawDocumentFile(this, paramString);
  }
  
  public DocumentFile createFile(String paramString1, String paramString2)
  {
    String str = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString1);
    paramString1 = paramString2;
    if (str != null) {
      paramString1 = StringBuilder.append(paramString2, ".", str);
    }
    paramString1 = new File(mFile, paramString1);
    try
    {
      paramString1.createNewFile();
      paramString1 = new RawDocumentFile(this, paramString1);
      return paramString1;
    }
    catch (IOException paramString1)
    {
      StringBuilder.append("Failed to createFile: ", paramString1);
    }
    return null;
  }
  
  public boolean delete()
  {
    deleteContents(mFile);
    return mFile.delete();
  }
  
  public boolean exists()
  {
    return mFile.exists();
  }
  
  public String getName()
  {
    return mFile.getName();
  }
  
  public String getType()
  {
    if (mFile.isDirectory()) {
      return null;
    }
    return getTypeForName(mFile.getName());
  }
  
  public Uri getUri()
  {
    return Uri.fromFile(mFile);
  }
  
  public boolean isDirectory()
  {
    return mFile.isDirectory();
  }
  
  public boolean isFile()
  {
    return mFile.isFile();
  }
  
  public long lastModified()
  {
    return mFile.lastModified();
  }
  
  public long length()
  {
    return mFile.length();
  }
  
  public DocumentFile[] listFiles()
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = mFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new RawDocumentFile(this, arrayOfFile[i]));
        i += 1;
      }
    }
    return (DocumentFile[])localArrayList.toArray(new DocumentFile[localArrayList.size()]);
  }
  
  public boolean renameTo()
  {
    return false;
  }
  
  public boolean renameTo(String paramString)
  {
    paramString = new File(mFile.getParentFile(), paramString);
    if (mFile.renameTo(paramString))
    {
      mFile = paramString;
      return true;
    }
    return false;
  }
}
