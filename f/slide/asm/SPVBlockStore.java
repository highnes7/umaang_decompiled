package f.slide.asm;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import f.b.a.b;
import f.h.a.f;
import java.io.EOFException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

public abstract class SPVBlockStore
  implements a
{
  public static Logger log = Logger.getLogger(b.class.getName());
  public ThreadLocal<ByteBuffer> buffer = new Dispatcher.PerThreadQueuedDispatcher.2(this);
  
  public SPVBlockStore() {}
  
  public abstract Box get(String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public Box read(f paramF, Container paramContainer)
    throws IOException
  {
    ((ByteBuffer)buffer.get()).rewind().limit(8);
    int i = 0;
    do
    {
      i += paramF.read((ByteBuffer)buffer.get());
      if (i == 8)
      {
        ((ByteBuffer)buffer.get()).rewind();
        long l1 = ByteBufferList.readUInt32((ByteBuffer)buffer.get());
        Object localObject = null;
        if ((l1 < 8L) && (l1 > 1L))
        {
          paramF = log;
          paramContainer = new StringBuilder("Plausibility check failed: size < 8 (size = ");
          paramContainer.append(l1);
          paramContainer.append("). Stop parsing!");
          paramF.severe(paramContainer.toString());
          return null;
        }
        String str2 = ByteBufferList.read((ByteBuffer)buffer.get());
        if (l1 == 1L)
        {
          ((ByteBuffer)buffer.get()).limit(16);
          paramF.read((ByteBuffer)buffer.get());
          ((ByteBuffer)buffer.get()).position(8);
          l1 = ByteBufferList.readUInt64((ByteBuffer)buffer.get()) - 16L;
        }
        else
        {
          if (l1 == 0L)
          {
            paramF.size();
            paramF.position();
            localObject = new StringBuilder("'");
            ((StringBuilder)localObject).append(str2);
            ((StringBuilder)localObject).append("' with '");
            if ((paramContainer instanceof Box)) {
              paramF = ((Box)paramContainer).getType();
            } else {
              paramF = "IsoFile";
            }
            throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, paramF, "' as parent has length == 0. That's not supported"));
          }
          l1 -= 8L;
        }
        long l2 = l1;
        if ("uuid".equals(str2))
        {
          ((ByteBuffer)buffer.get()).limit(((ByteBuffer)buffer.get()).limit() + 16);
          paramF.read((ByteBuffer)buffer.get());
          localObject = new byte[16];
          i = ((ByteBuffer)buffer.get()).position() - 16;
          for (;;)
          {
            if (i >= ((ByteBuffer)buffer.get()).position())
            {
              l2 = l1 - 16L;
              break;
            }
            localObject[(i - (((ByteBuffer)buffer.get()).position() - 16))] = ((ByteBuffer)buffer.get()).get(i);
            i += 1;
          }
        }
        String str1;
        if ((paramContainer instanceof Box)) {
          str1 = ((Box)paramContainer).getType();
        } else {
          str1 = "";
        }
        localObject = get(str2, (byte[])localObject, str1);
        ((Box)localObject).setParent(paramContainer);
        ((ByteBuffer)buffer.get()).rewind();
        ((Box)localObject).parse(paramF, (ByteBuffer)buffer.get(), l2, this);
        return localObject;
      }
    } while (i >= 0);
    paramF = new EOFException();
    throw paramF;
  }
}
