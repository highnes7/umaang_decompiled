package f.slide.asm;

import java.nio.ByteBuffer;

public final class Request
{
  public Request() {}
  
  public static void write(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 8)
            {
              paramByteBuffer.putLong(paramLong);
              return;
            }
            paramByteBuffer = new StringBuilder("I don't know how to read ");
            paramByteBuffer.append(paramInt);
            paramByteBuffer.append(" bytes");
            throw new RuntimeException(paramByteBuffer.toString());
          }
          paramByteBuffer.putInt((int)paramLong);
          return;
        }
        Label.set(paramByteBuffer, (int)(paramLong & 0xFFFFFF));
        return;
      }
      Label.append(paramByteBuffer, (int)(paramLong & 0xFFFF));
      return;
    }
    paramByteBuffer.put((byte)((int)(paramLong & 0xFF) & 0xFF));
  }
}
