package f.g.org.org.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MockHttpContent
  implements StreamingContent
{
  public final StreamingContent content;
  public final Logger items;
  public final Level length;
  public final int type;
  
  public MockHttpContent(StreamingContent paramStreamingContent, Logger paramLogger, Level paramLevel, int paramInt)
  {
    content = paramStreamingContent;
    items = paramLogger;
    length = paramLevel;
    type = paramInt;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    LoggingOutputStream localLoggingOutputStream = new LoggingOutputStream(paramOutputStream, items, length, type);
    try
    {
      content.writeTo(localLoggingOutputStream);
      localLoggingOutputStream.getLogStream().close();
      paramOutputStream.flush();
      return;
    }
    catch (Throwable paramOutputStream)
    {
      localLoggingOutputStream.getLogStream().close();
      throw paramOutputStream;
    }
  }
}
