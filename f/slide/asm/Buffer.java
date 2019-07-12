package f.slide.asm;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.MovieBox;
import f.h.a.e;
import f.h.a.f;
import f.h.a.g.j;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.List;

@f.h.a.a.a
public class Buffer
  extends e
  implements Closeable
{
  public static j d = j.a(f.b.a.g.class);
  
  public Buffer(f paramF)
    throws IOException
  {
    parseContainer(paramF, paramF.size(), new ClassWriter(new String[0]));
  }
  
  public Buffer(f paramF, a paramA)
    throws IOException
  {
    dataSource = paramF;
    boxParser = paramA;
  }
  
  public Buffer(String paramString)
    throws IOException
  {
    this(new f.h.a.g(new File(paramString)));
  }
  
  public static byte[] append(String paramString)
  {
    byte[] arrayOfByte = new byte[4];
    if (paramString != null)
    {
      int i = 0;
      for (;;)
      {
        if (i >= Math.min(4, paramString.length())) {
          return arrayOfByte;
        }
        arrayOfByte[i] = ((byte)paramString.charAt(i));
        i += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static String evaluate(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4];
    if (paramArrayOfByte != null) {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, Math.min(paramArrayOfByte.length, 4));
    }
    try
    {
      paramArrayOfByte = new String(arrayOfByte, "ISO-8859-1");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new Error("Required character encoding is missing", paramArrayOfByte);
    }
  }
  
  public void close()
    throws IOException
  {
    dataSource.close();
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    writeContainer(paramWritableByteChannel);
  }
  
  public long getSize()
  {
    return getContainerSize();
  }
  
  public MovieBox getValue()
  {
    Iterator localIterator = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof MovieBox));
    return (MovieBox)localBox;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("IsoFile[");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(dataSource, localStringBuilder, "]");
  }
}
