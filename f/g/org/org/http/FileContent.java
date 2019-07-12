package f.g.org.org.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class FileContent
  extends AbstractInputStreamContent
{
  public final File file;
  
  public FileContent(String paramString, File paramFile)
  {
    super(paramString);
    if (paramFile != null)
    {
      file = paramFile;
      return;
    }
    throw new NullPointerException();
  }
  
  public File getFile()
  {
    return file;
  }
  
  public InputStream getInputStream()
    throws FileNotFoundException
  {
    return new FileInputStream(file);
  }
  
  public long getLength()
  {
    return file.length();
  }
  
  public boolean retrySupported()
  {
    return true;
  }
  
  public FileContent setCloseInputStream(boolean paramBoolean)
  {
    closeInputStream = paramBoolean;
    return this;
  }
  
  public FileContent setType(String paramString)
  {
    type = paramString;
    return this;
  }
}
