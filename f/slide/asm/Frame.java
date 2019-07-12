package f.slide.asm;

import java.io.ByteArrayOutputStream;

public class Frame
{
  public static final char[] DOUBLE = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public Frame() {}
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    int m = paramArrayOfByte.length;
    int j = 0;
    if (paramInt > 0) {
      i = m / paramInt;
    } else {
      i = 0;
    }
    char[] arrayOfChar1 = new char[(m << 1) + i];
    int i = 0;
    for (;;)
    {
      if (j >= m) {
        return new String(arrayOfChar1);
      }
      int k = i;
      if (paramInt > 0)
      {
        k = i;
        if (j % paramInt == 0)
        {
          k = i;
          if (i > 0)
          {
            arrayOfChar1[i] = '-';
            k = i + 1;
          }
        }
      }
      int n = k + 1;
      char[] arrayOfChar2 = DOUBLE;
      arrayOfChar1[k] = arrayOfChar2[((paramArrayOfByte[j] & 0xF0) >>> 4)];
      i = n + 1;
      arrayOfChar1[n] = arrayOfChar2[(paramArrayOfByte[j] & 0xF)];
      j += 1;
    }
  }
  
  public static byte[] init(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j;
    for (int i = 0;; i = j)
    {
      if (i >= paramString.length()) {
        return localByteArrayOutputStream.toByteArray();
      }
      j = i + 2;
      localByteArrayOutputStream.write(Integer.parseInt(paramString.substring(i, j), 16));
    }
  }
}
