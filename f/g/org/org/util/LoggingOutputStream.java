package f.g.org.org.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingOutputStream
  extends FilterOutputStream
{
  public final LoggingByteArrayOutputStream logStream;
  
  public LoggingOutputStream(OutputStream paramOutputStream, Logger paramLogger, Level paramLevel, int paramInt)
  {
    super(paramOutputStream);
    logStream = new LoggingByteArrayOutputStream(paramLogger, paramLevel, paramInt);
  }
  
  public void close()
    throws IOException
  {
    logStream.close();
    super.close();
  }
  
  public final LoggingByteArrayOutputStream getLogStream()
  {
    return logStream;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    out.write(paramInt);
    logStream.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    out.write(paramArrayOfByte, paramInt1, paramInt2);
    logStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}
