package com.google.android.android.common.util;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IOUtils
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable) {}
    }
  }
  
  public static void closeSilently(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null) {
      try
      {
        paramParcelFileDescriptor.close();
        return;
      }
      catch (IOException paramParcelFileDescriptor) {}
    }
  }
  
  public static byte[] readFully(InputStream paramInputStream, boolean paramBoolean)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    write(paramInputStream, localByteArrayOutputStream, paramBoolean);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static long write(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    return write(paramInputStream, paramOutputStream, paramBoolean, 1024);
  }
  
  /* Error */
  public static long write(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: iload_3
    //   1: newarray byte
    //   3: astore 6
    //   5: lconst_0
    //   6: lstore 4
    //   8: aload_0
    //   9: aload 6
    //   11: iconst_0
    //   12: aload 6
    //   14: arraylength
    //   15: invokevirtual 47	java/io/InputStream:read	([BII)I
    //   18: istore_3
    //   19: iload_3
    //   20: iconst_m1
    //   21: if_icmpeq +21 -> 42
    //   24: lload 4
    //   26: iload_3
    //   27: i2l
    //   28: ladd
    //   29: lstore 4
    //   31: aload_1
    //   32: aload 6
    //   34: iconst_0
    //   35: iload_3
    //   36: invokevirtual 52	java/io/OutputStream:write	([BII)V
    //   39: goto -31 -> 8
    //   42: iload_2
    //   43: ifeq +70 -> 113
    //   46: aload_0
    //   47: invokeinterface 14 1 0
    //   52: aload_1
    //   53: ifnull +60 -> 113
    //   56: aload_1
    //   57: invokeinterface 14 1 0
    //   62: lload 4
    //   64: lreturn
    //   65: astore 6
    //   67: iload_2
    //   68: ifeq +23 -> 91
    //   71: aload_0
    //   72: ifnull +9 -> 81
    //   75: aload_0
    //   76: invokeinterface 14 1 0
    //   81: aload_1
    //   82: ifnull +9 -> 91
    //   85: aload_1
    //   86: invokeinterface 14 1 0
    //   91: goto +3 -> 94
    //   94: aload 6
    //   96: athrow
    //   97: astore_0
    //   98: goto -46 -> 52
    //   101: astore_0
    //   102: lload 4
    //   104: lreturn
    //   105: astore_0
    //   106: goto -25 -> 81
    //   109: astore_0
    //   110: goto -16 -> 94
    //   113: lload 4
    //   115: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramInputStream	InputStream
    //   0	116	1	paramOutputStream	OutputStream
    //   0	116	2	paramBoolean	boolean
    //   0	116	3	paramInt	int
    //   6	108	4	l	long
    //   3	30	6	arrayOfByte	byte[]
    //   65	30	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	19	65	java/lang/Throwable
    //   31	39	65	java/lang/Throwable
    //   46	52	97	java/io/IOException
    //   56	62	101	java/io/IOException
    //   75	81	105	java/io/IOException
    //   85	91	109	java/io/IOException
  }
}
