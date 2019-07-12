package asm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;

public abstract class ByteVector
{
  public ByteVector() {}
  
  public int a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {
        return paramInt2;
      }
      int j = paramInputStream.read();
      if (j == -1)
      {
        if (i != 0) {
          break;
        }
        return -1;
      }
      paramArrayOfByte[(i + paramInt1)] = ((byte)j);
      i += 1;
    }
    return i;
  }
  
  public int a(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return b();
  }
  
  public abstract int b();
  
  public ByteBuffer get(String paramString)
    throws IOException
  {
    return ByteBuffer.wrap(toByteArray(paramString));
  }
  
  public abstract int length();
  
  public void putByte(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream)
    throws IOException
  {}
  
  public void putByteArray(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream)
    throws IOException
  {}
  
  public byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    write(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public byte[] toByteArray(String paramString)
    throws IOException
  {
    Object localObject = new byte[paramString.length()];
    paramString.getBytes(0, paramString.length(), (byte[])localObject, 0);
    paramString = new ByteArrayInputStream((byte[])localObject);
    localObject = new ByteArrayOutputStream();
    write(paramString, (OutputStream)localObject);
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  public ByteBuffer write(InputStream paramInputStream)
    throws IOException
  {
    return ByteBuffer.wrap(toByteArray(paramInputStream));
  }
  
  public void write(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    paramInputStream = new PushbackInputStream(paramInputStream);
    write(paramInputStream, paramOutputStream);
    try
    {
      int j = a(paramInputStream, paramOutputStream);
      int i = 0;
      for (;;)
      {
        int k = length();
        if (k + i >= j)
        {
          k = length();
          if (k + i == j)
          {
            write(paramInputStream, paramOutputStream, length());
            length();
          }
          else
          {
            write(paramInputStream, paramOutputStream, j - i);
          }
          putByteArray(paramInputStream, paramOutputStream);
          break;
        }
        write(paramInputStream, paramOutputStream, length());
        length();
        k = length();
        i += k;
      }
    }
    catch (CacheDataSink.CacheDataSinkException localCacheDataSinkException)
    {
      for (;;) {}
    }
    putByte(paramInputStream, paramOutputStream);
  }
  
  public void write(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream)
    throws IOException
  {}
  
  public void write(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    throw new CacheDataSink.CacheDataSinkException();
  }
}
