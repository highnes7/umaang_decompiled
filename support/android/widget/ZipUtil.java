package support.android.widget;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

public final class ZipUtil
{
  public static final int BUFFER_SIZE = 16384;
  public static final int ENDHDR = 22;
  public static final int ENDSIG = 101010256;
  
  public ZipUtil() {}
  
  public static long computeCrcOfCentralDir(RandomAccessFile paramRandomAccessFile, CentralDirectory paramCentralDirectory)
    throws IOException
  {
    CRC32 localCRC32 = new CRC32();
    long l = size;
    paramRandomAccessFile.seek(offset);
    int i = (int)Math.min(16384L, l);
    paramCentralDirectory = new byte['?'];
    for (i = paramRandomAccessFile.read(paramCentralDirectory, 0, i); i != -1; i = paramRandomAccessFile.read(paramCentralDirectory, 0, (int)Math.min(16384L, l)))
    {
      localCRC32.update(paramCentralDirectory, 0, i);
      l -= i;
      if (l == 0L) {
        break;
      }
    }
    return localCRC32.getValue();
  }
  
  public static CentralDirectory findCentralDirectory(RandomAccessFile paramRandomAccessFile)
    throws IOException, ZipException
  {
    long l2 = paramRandomAccessFile.length() - 22L;
    long l1 = 0L;
    if (l2 >= 0L)
    {
      long l3 = l2 - 65536L;
      if (l3 >= 0L) {
        l1 = l3;
      }
      int i = Integer.reverseBytes(101010256);
      do
      {
        paramRandomAccessFile.seek(l2);
        if (paramRandomAccessFile.readInt() == i)
        {
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          localObject = new CentralDirectory();
          size = (Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFF);
          offset = (Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFF);
          return localObject;
        }
        l2 -= 1L;
      } while (l2 >= l1);
      throw new ZipException("End Of Central Directory signature not found");
    }
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("File too short to be a zip file: ");
    ((StringBuilder)localObject).append(paramRandomAccessFile.length());
    paramRandomAccessFile = new ZipException(((StringBuilder)localObject).toString());
    throw paramRandomAccessFile;
  }
  
  public static long getZipCrc(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    try
    {
      long l = computeCrcOfCentralDir(paramFile, findCentralDirectory(paramFile));
      paramFile.close();
      return l;
    }
    catch (Throwable localThrowable)
    {
      paramFile.close();
      throw localThrowable;
    }
  }
  
  public class CentralDirectory
  {
    public long offset;
    public long size;
    
    public CentralDirectory() {}
  }
}
