package f.slide.asm;

public final class Label
{
  public Label() {}
  
  public static void a(java.nio.ByteBuffer paramByteBuffer, int paramInt)
  {
    paramInt &= 0xFFFF;
    paramByteBuffer.put((byte)(paramInt & 0xFF & 0xFF));
    paramByteBuffer.put((byte)(paramInt >> 8 & 0xFF));
  }
  
  public static void a(java.nio.ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramByteBuffer, (int)paramLong & 0xFFFF);
    a(paramByteBuffer, (int)(paramLong >> 16 & 0xFFFF));
  }
  
  public static void a(java.nio.ByteBuffer paramByteBuffer, String paramString)
  {
    paramString = ByteBuffer.append(paramString);
    paramByteBuffer.put((byte)(paramString.length & 0xFF));
    paramByteBuffer.put(paramString);
  }
  
  public static void add(java.nio.ByteBuffer paramByteBuffer, String paramString)
  {
    if (paramString.getBytes().length == 3)
    {
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (i >= 3)
        {
          append(paramByteBuffer, j);
          return;
        }
        j += (paramString.getBytes()[i] - 96 << (2 - i) * 5);
        i += 1;
      }
    }
    paramByteBuffer = new StringBuilder("\"");
    paramByteBuffer.append(paramString);
    paramByteBuffer.append("\" language string isn't exactly 3 characters long!");
    paramByteBuffer = new IllegalArgumentException(paramByteBuffer.toString());
    throw paramByteBuffer;
  }
  
  public static void append(java.nio.ByteBuffer paramByteBuffer, int paramInt)
  {
    paramInt &= 0xFFFF;
    paramByteBuffer.put((byte)(paramInt >> 8 & 0xFF));
    paramByteBuffer.put((byte)(paramInt & 0xFF & 0xFF));
  }
  
  public static void copyTo(java.nio.ByteBuffer paramByteBuffer, long paramLong)
  {
    paramByteBuffer.putInt((int)paramLong);
  }
  
  public static void copyTo(java.nio.ByteBuffer paramByteBuffer, String paramString)
  {
    paramByteBuffer.put(ByteBuffer.append(paramString));
    paramByteBuffer.put((byte)0);
  }
  
  public static void put(java.nio.ByteBuffer paramByteBuffer, double paramDouble)
  {
    int i = (int)(paramDouble * 65536.0D);
    paramByteBuffer.put((byte)((0xFF000000 & i) >> 24));
    paramByteBuffer.put((byte)((0xFF0000 & i) >> 16));
    paramByteBuffer.put((byte)((0xFF00 & i) >> 8));
    paramByteBuffer.put((byte)(i & 0xFF));
  }
  
  public static void put(java.nio.ByteBuffer paramByteBuffer, int paramInt)
  {
    paramByteBuffer.put((byte)(paramInt & 0xFF));
  }
  
  public static void put(java.nio.ByteBuffer paramByteBuffer, String paramString)
  {
    paramByteBuffer.put(ByteBuffer.append(paramString));
    paramByteBuffer.put((byte)0);
  }
  
  public static void read(java.nio.ByteBuffer paramByteBuffer, double paramDouble)
  {
    int i = (int)(paramDouble * 1.073741824E9D);
    paramByteBuffer.put((byte)((0xFF000000 & i) >> 24));
    paramByteBuffer.put((byte)((0xFF0000 & i) >> 16));
    paramByteBuffer.put((byte)((0xFF00 & i) >> 8));
    paramByteBuffer.put((byte)(i & 0xFF));
  }
  
  public static void set(java.nio.ByteBuffer paramByteBuffer, int paramInt)
  {
    paramInt &= 0xFFFFFF;
    append(paramByteBuffer, paramInt >> 8);
    paramByteBuffer.put((byte)(paramInt & 0xFF));
  }
  
  public static void write(java.nio.ByteBuffer paramByteBuffer, double paramDouble)
  {
    int i = (short)(int)(paramDouble * 256.0D);
    paramByteBuffer.put((byte)((0xFF00 & i) >> 8));
    paramByteBuffer.put((byte)(i & 0xFF));
  }
  
  public static void writeInt64(java.nio.ByteBuffer paramByteBuffer, long paramLong)
  {
    paramByteBuffer.putLong(paramLong);
  }
}
