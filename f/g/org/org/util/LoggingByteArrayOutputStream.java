package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingByteArrayOutputStream
  extends ByteArrayOutputStream
{
  public int bytesWritten;
  public boolean closed;
  public final Logger logger;
  public final Level loggingLevel;
  public final int maximumBytesToLog;
  
  public LoggingByteArrayOutputStream(Logger paramLogger, Level paramLevel, int paramInt)
  {
    if (paramLogger != null)
    {
      logger = paramLogger;
      if (paramLevel != null)
      {
        loggingLevel = paramLevel;
        boolean bool;
        if (paramInt >= 0) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.append(bool);
        maximumBytesToLog = paramInt;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static void appendBytes(StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt == 1)
    {
      paramStringBuilder.append("1 byte");
      return;
    }
    paramStringBuilder.append(NumberFormat.getInstance().format(paramInt));
    paramStringBuilder.append(" bytes");
  }
  
  public void close()
    throws IOException
  {
    try
    {
      if (!closed)
      {
        if (bytesWritten != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Total: ");
          appendBytes(localStringBuilder, bytesWritten);
          if ((count != 0) && (count < bytesWritten))
          {
            localStringBuilder.append(" (logging first ");
            appendBytes(localStringBuilder, count);
            localStringBuilder.append(")");
          }
          logger.config(localStringBuilder.toString());
          if (count != 0) {
            logger.log(loggingLevel, toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
          }
        }
        closed = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final int getBytesWritten()
  {
    try
    {
      int i = bytesWritten;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final int getMaximumBytesToLog()
  {
    return maximumBytesToLog;
  }
  
  public void write(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!closed)
        {
          bool = true;
          Preconditions.append(bool);
          bytesWritten += 1;
          if (count < maximumBytesToLog) {
            super.write(paramInt);
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (!closed)
        {
          bool = true;
          Preconditions.append(bool);
          bytesWritten += paramInt2;
          if (count < maximumBytesToLog)
          {
            int j = count + paramInt2;
            int i = paramInt2;
            if (j > maximumBytesToLog) {
              i = paramInt2 + (maximumBytesToLog - j);
            }
            super.write(paramArrayOfByte, paramInt1, i);
          }
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      boolean bool = false;
    }
  }
}
