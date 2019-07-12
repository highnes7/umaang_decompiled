package f.g.org.org.http;

import f.g.org.org.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractInputStreamContent
  implements HttpContent
{
  public boolean closeInputStream = true;
  public String type;
  
  public AbstractInputStreamContent(String paramString)
  {
    setType(paramString);
  }
  
  public final boolean getCloseInputStream()
  {
    return closeInputStream;
  }
  
  public abstract InputStream getInputStream()
    throws IOException;
  
  public String getType()
  {
    return type;
  }
  
  public AbstractInputStreamContent setCloseInputStream(boolean paramBoolean)
  {
    closeInputStream = paramBoolean;
    return this;
  }
  
  public AbstractInputStreamContent setType(String paramString)
  {
    type = paramString;
    return this;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    IOUtils.copy(getInputStream(), paramOutputStream, closeInputStream);
    paramOutputStream.flush();
  }
}
