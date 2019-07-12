package f.slide.asm;

import java.nio.ByteBuffer;

public final class ByteVector
{
  public ByteVector() {}
  
  public static long read(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 8) {
              return ByteBufferList.readUInt64(paramByteBuffer);
            }
            paramByteBuffer = new StringBuilder("I don't know how to read ");
            paramByteBuffer.append(paramInt);
            paramByteBuffer.append(" bytes");
            throw new RuntimeException(paramByteBuffer.toString());
          }
          return ByteBufferList.readUInt32(paramByteBuffer);
        }
        paramInt = ByteBufferList.getInt(paramByteBuffer);
      }
    }
    for (;;)
    {
      return paramInt;
      paramInt = ByteBufferList.get(paramByteBuffer);
      continue;
      paramInt = ByteBufferList.readUInt8(paramByteBuffer);
    }
  }
}
