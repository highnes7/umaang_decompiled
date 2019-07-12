package f.libs.asm.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class i
  extends FileOutputStream
{
  public static final String e = ".cls_temp";
  public static final FilenameFilter filter = new ExceptionHandler.2();
  public static final String t = ".cls";
  public File a;
  public final String channel;
  public File file;
  public boolean p = false;
  
  public i(File paramFile, String paramString)
    throws FileNotFoundException
  {
    super(new File(paramFile, f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, ".cls_temp")));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    channel = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, File.separator, paramString);
    file = new File(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), channel, ".cls_temp"));
  }
  
  public i(String paramString1, String paramString2)
    throws FileNotFoundException
  {
    this(new File(paramString1), paramString2);
  }
  
  public void a()
    throws IOException
  {
    if (p) {
      return;
    }
    p = true;
    super.flush();
    super.close();
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      try
      {
        boolean bool = p;
        if (bool) {
          return;
        }
        p = true;
        super.flush();
        super.close();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(channel);
        ((StringBuilder)localObject).append(".cls");
        File localFile = new File(((StringBuilder)localObject).toString());
        if (file.renameTo(localFile))
        {
          file = null;
          a = localFile;
          return;
        }
        localObject = "";
        if (!localFile.exists())
        {
          if (!file.exists()) {
            localObject = " (source does not exist)";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Could not rename temp file: ");
          localStringBuilder.append(file);
          localStringBuilder.append(" -> ");
          localStringBuilder.append(localFile);
          localStringBuilder.append((String)localObject);
          throw new IOException(localStringBuilder.toString());
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      String str = " (target already exists)";
    }
  }
  
  public File getFile()
  {
    return file;
  }
  
  public File n()
  {
    return a;
  }
}
