package f.slide.asm;

import f.h.a.g.f;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public final class ByteBufferList
{
  public static f b = new f();
  public static byte[] c = new byte[4];
  
  public ByteBufferList() {}
  
  public static float add(java.nio.ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[2];
    paramByteBuffer.get(arrayOfByte);
    return (short)((short)(0x0 | arrayOfByte[0] << 8 & 0xFF00) | arrayOfByte[1] & 0xFF) / 256.0F;
  }
  
  public static int get(java.nio.ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.get();
    int i = j;
    if (j < 0) {
      i = j + 256;
    }
    int k = paramByteBuffer.get();
    j = k;
    if (k < 0) {
      j = k + 256;
    }
    return (i << 8) + 0 + j;
  }
  
  public static int getBytes(java.nio.ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.get();
    int i = j;
    if (j < 0) {
      i = j + 256;
    }
    int k = paramByteBuffer.get();
    j = k;
    if (k < 0) {
      j = k + 256;
    }
    return i + 0 + (j << 8);
  }
  
  public static int getInt(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte + 256;
    }
    return paramByte;
  }
  
  public static int getInt(java.nio.ByteBuffer paramByteBuffer)
  {
    int k = get(paramByteBuffer);
    int j = paramByteBuffer.get();
    int i = j;
    if (j < 0) {
      i = j + 256;
    }
    return (k << 8) + 0 + i;
  }
  
  public static long getLong(java.nio.ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.get();
    int i = j;
    if (j < 0) {
      i = j + 256;
    }
    long l1 = i;
    j = paramByteBuffer.get();
    i = j;
    if (j < 0) {
      i = j + 256;
    }
    long l2 = i;
    j = paramByteBuffer.get();
    i = j;
    if (j < 0) {
      i = j + 256;
    }
    long l3 = i;
    j = paramByteBuffer.get();
    i = j;
    if (j < 0) {
      i = j + 256;
    }
    return (i << 24) + (l3 << 16) + (l2 << 8) + (l1 << 0);
  }
  
  public static double init(java.nio.ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    double d = 0x0 | arrayOfByte[0] << 24 & 0xFF000000 | arrayOfByte[1] << 16 & 0xFF0000 | arrayOfByte[2] << 8 & 0xFF00 | arrayOfByte[3] & 0xFF;
    Double.isNaN(d);
    return d / 1.073741824E9D;
  }
  
  public static String nextToken(java.nio.ByteBuffer paramByteBuffer)
  {
    int j = get(paramByteBuffer);
    paramByteBuffer = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i >= 3) {
        return paramByteBuffer.toString();
      }
      paramByteBuffer.append((char)((j >> (2 - i) * 5 & 0x1F) + 96));
      i += 1;
    }
  }
  
  public static String read(java.nio.ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.get(c);
    paramByteBuffer = c;
    int i = paramByteBuffer[0];
    int j = paramByteBuffer[1];
    int k = paramByteBuffer[2];
    i = paramByteBuffer[3] & 0xFF | i << 24 & 0xFF000000 | j << 16 & 0xFF0000 | k << 8 & 0xFF00;
    paramByteBuffer = (String)b.b(i);
    if (paramByteBuffer != null) {
      return paramByteBuffer;
    }
    paramByteBuffer = c;
    try
    {
      paramByteBuffer = new String(paramByteBuffer, "ISO-8859-1");
      f localF = b;
      localF.a(i, paramByteBuffer);
      return paramByteBuffer;
    }
    catch (UnsupportedEncodingException paramByteBuffer)
    {
      throw new RuntimeException(paramByteBuffer);
    }
  }
  
  public static String readString(java.nio.ByteBuffer paramByteBuffer)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramByteBuffer.get();
      if (i == 0) {
        return ByteBuffer.decode(localByteArrayOutputStream.toByteArray());
      }
      localByteArrayOutputStream.write(i);
    }
  }
  
  public static String readString(java.nio.ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return ByteBuffer.decode(arrayOfByte);
  }
  
  public static long readUInt32(java.nio.ByteBuffer paramByteBuffer)
  {
    long l2 = paramByteBuffer.getInt();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = l2 + 4294967296L;
    }
    return l1;
  }
  
  public static long readUInt64(java.nio.ByteBuffer paramByteBuffer)
  {
    long l = (readUInt32(paramByteBuffer) << 32) + 0L;
    if (l >= 0L) {
      return readUInt32(paramByteBuffer) + l;
    }
    throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
  }
  
  public static int readUInt8(java.nio.ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    if (i < 0) {
      return i + 256;
    }
    return i;
  }
  
  public static double update(java.nio.ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    double d = 0x0 | arrayOfByte[0] << 24 & 0xFF000000 | arrayOfByte[1] << 16 & 0xFF0000 | arrayOfByte[2] << 8 & 0xFF00 | arrayOfByte[3] & 0xFF;
    Double.isNaN(d);
    return d / 65536.0D;
  }
}
