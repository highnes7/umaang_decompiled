package f.g.c.io;

import f.g.c.a.a;
import f.g.c.g.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@a
public final class FileBackedOutputStream
  extends OutputStream
{
  public File file;
  public final int fileThreshold;
  public MemoryOutput memory;
  public OutputStream out;
  public final boolean resetOnFinalize;
  public final y<InputStream> source;
  
  public FileBackedOutputStream(int paramInt)
  {
    this(paramInt, false);
  }
  
  public FileBackedOutputStream(int paramInt, boolean paramBoolean)
  {
    fileThreshold = paramInt;
    resetOnFinalize = paramBoolean;
    memory = new MemoryOutput(null);
    out = memory;
    if (paramBoolean)
    {
      source = new FileBackedOutputStream.1(this);
      return;
    }
    source = new FileBackedOutputStream.2(this);
  }
  
  private InputStream openStream()
    throws IOException
  {
    try
    {
      if (file != null)
      {
        localObject = new FileInputStream(file);
        return localObject;
      }
      Object localObject = new ByteArrayInputStream(memory.getBuffer(), 0, memory.getCount());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void update(int paramInt)
    throws IOException
  {
    if ((file == null) && (memory.getCount() + paramInt > fileThreshold))
    {
      File localFile = File.createTempFile("FileBackedOutputStream", null);
      if (resetOnFinalize) {
        localFile.deleteOnExit();
      }
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localFileOutputStream.write(memory.getBuffer(), 0, memory.getCount());
      localFileOutputStream.flush();
      out = localFileOutputStream;
      file = localFile;
      memory = null;
    }
  }
  
  public InputSupplier asByteSource()
  {
    return source;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      out.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      out.flush();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public File getFile()
  {
    try
    {
      File localFile = file;
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void reset()
    throws IOException
  {
    File localFile2;
    try
    {
      close();
      try
      {
        if (memory == null) {
          memory = new MemoryOutput(null);
        } else {
          memory.reset();
        }
        out = memory;
        if (file != null)
        {
          File localFile1 = file;
          file = null;
          if (!localFile1.delete())
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("Could not delete: ");
            localStringBuilder1.append(localFile1);
            throw new IOException(localStringBuilder1.toString());
          }
        }
        return;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      if (memory == null) {
        memory = new MemoryOutput(null);
      } else {
        memory.reset();
      }
      out = memory;
      StringBuilder localStringBuilder2;
      if (file != null)
      {
        localFile2 = file;
        file = null;
        if (!localFile2.delete())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("Could not delete: ");
          localStringBuilder2.append(localFile2);
          throw new IOException(localStringBuilder2.toString());
        }
      }
      throw localStringBuilder2;
    }
    throw localFile2;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      update(1);
      out.write(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      write(paramArrayOfByte, 0, paramArrayOfByte.length);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      update(paramInt2);
      out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public class MemoryOutput
    extends ByteArrayOutputStream
  {
    public MemoryOutput() {}
    
    public byte[] getBuffer()
    {
      return buf;
    }
    
    public int getCount()
    {
      return count;
    }
  }
}
