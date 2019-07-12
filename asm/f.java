package asm;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public class f
  extends ByteVector
{
  public static final char[] g = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  public static final byte[] y = new byte['?'];
  public byte[] z = new byte[4];
  
  static
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= 255)
      {
        i = j;
        for (;;)
        {
          char[] arrayOfChar = g;
          if (i >= arrayOfChar.length) {
            return;
          }
          y[arrayOfChar[i]] = ((byte)i);
          i += 1;
        }
      }
      y[i] = -1;
      i += 1;
    }
  }
  
  public f() {}
  
  public int b()
  {
    return 72;
  }
  
  public int length()
  {
    return 4;
  }
  
  public void write(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    if (paramInt >= 2)
    {
      int j;
      int i;
      do
      {
        j = paramPushbackInputStream.read();
        i = -1;
        if (j == -1) {
          break;
        }
      } while ((j == 10) || (j == 13));
      byte[] arrayOfByte = z;
      arrayOfByte[0] = ((byte)j);
      if (a(paramPushbackInputStream, arrayOfByte, 1, paramInt - 1) != -1)
      {
        j = paramInt;
        if (paramInt > 3)
        {
          j = paramInt;
          if (z[3] == 61) {
            j = 3;
          }
        }
        int k = j;
        if (j > 2)
        {
          k = j;
          if (z[2] == 61) {
            k = 2;
          }
        }
        if (k != 2)
        {
          paramInt = i;
          if (k != 3)
          {
            if (k != 4)
            {
              paramInt = -1;
              j = -1;
              m = -1;
              break label237;
            }
            paramInt = y[(z[3] & 0xFF)];
          }
          paramPushbackInputStream = y;
          i = z[2];
          i = paramPushbackInputStream[(i & 0xFF)];
        }
        else
        {
          paramInt = -1;
        }
        paramPushbackInputStream = y;
        arrayOfByte = z;
        int m = paramPushbackInputStream[(arrayOfByte[1] & 0xFF)];
        j = arrayOfByte[0];
        int n = paramPushbackInputStream[(j & 0xFF)];
        j = paramInt;
        paramInt = i;
        i = n;
        label237:
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4) {
              return;
            }
            paramOutputStream.write((byte)(i << 2 & 0xFC | m >>> 4 & 0x3));
            paramOutputStream.write((byte)(m << 4 & 0xF0 | paramInt >>> 2 & 0xF));
            paramOutputStream.write((byte)(paramInt << 6 & 0xC0 | j & 0x3F));
            return;
          }
          paramOutputStream.write((byte)(i << 2 & 0xFC | 0x3 & m >>> 4));
          paramOutputStream.write((byte)(m << 4 & 0xF0 | paramInt >>> 2 & 0xF));
          return;
        }
        paramOutputStream.write((byte)(m >>> 4 & 0x3 | i << 2 & 0xFC));
        return;
      }
      throw new CacheDataSink.CacheDataSinkException();
      throw new CacheDataSink.CacheDataSinkException();
    }
    paramPushbackInputStream = new TransportException("BASE64Decoder: Not enough bytes for an atom.");
    throw paramPushbackInputStream;
  }
}
