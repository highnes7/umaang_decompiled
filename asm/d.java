package asm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

public abstract class d
{
  public PrintStream r;
  
  public d() {}
  
  private byte[] getString(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
    {
      byte[] arrayOfByte2 = paramByteBuffer.array();
      arrayOfByte1 = arrayOfByte2;
      if ((arrayOfByte2.length == paramByteBuffer.capacity()) && (arrayOfByte2.length == paramByteBuffer.remaining()))
      {
        paramByteBuffer.position(paramByteBuffer.limit());
        break label46;
      }
    }
    byte[] arrayOfByte1 = null;
    label46:
    if (arrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte1);
      return arrayOfByte1;
    }
    return arrayOfByte1;
  }
  
  public abstract int a();
  
  public int a(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return paramArrayOfByte.length;
      }
      int j = paramInputStream.read();
      if (j == -1) {
        return i;
      }
      paramArrayOfByte[i] = ((byte)j);
      i += 1;
    }
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      a(paramArrayOfByte, localByteArrayOutputStream);
      paramArrayOfByte = localByteArrayOutputStream.toString("8859_1");
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new Error("CharacterEncoder.encode internal error");
  }
  
  public void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[e()];
    d(paramOutputStream);
    int j = a(paramInputStream, arrayOfByte);
    int i;
    if (j != 0)
    {
      write(paramOutputStream, j);
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        if (j < e())
        {
          l(paramOutputStream);
          return;
        }
        e(paramOutputStream);
        break;
      }
      if (a() + i <= j) {
        write(paramOutputStream, arrayOfByte, i, a());
      } else {
        write(paramOutputStream, arrayOfByte, i, j - i);
      }
      i += a();
    }
  }
  
  public String b(ByteBuffer paramByteBuffer)
  {
    return c(getString(paramByteBuffer));
  }
  
  public void b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[e()];
    d(paramOutputStream);
    int j = a(paramInputStream, arrayOfByte);
    int i;
    if (j != 0)
    {
      write(paramOutputStream, j);
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        e(paramOutputStream);
        if (j >= e()) {
          break;
        }
        l(paramOutputStream);
        return;
      }
      if (a() + i <= j) {
        write(paramOutputStream, arrayOfByte, i, a());
      } else {
        write(paramOutputStream, arrayOfByte, i, j - i);
      }
      i += a();
    }
  }
  
  public void b(ByteBuffer paramByteBuffer, OutputStream paramOutputStream)
    throws IOException
  {
    c(getString(paramByteBuffer), paramOutputStream);
  }
  
  public void b(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    a(new ByteArrayInputStream(paramArrayOfByte), paramOutputStream);
  }
  
  public String c(ByteBuffer paramByteBuffer)
  {
    return a(getString(paramByteBuffer));
  }
  
  public String c(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      b(paramArrayOfByte, localByteArrayOutputStream);
      return localByteArrayOutputStream.toString();
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new Error("CharacterEncoder.encodeBuffer internal error");
  }
  
  public void c(ByteBuffer paramByteBuffer, OutputStream paramOutputStream)
    throws IOException
  {
    b(getString(paramByteBuffer), paramOutputStream);
  }
  
  public void c(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    b(new ByteArrayInputStream(paramArrayOfByte), paramOutputStream);
  }
  
  public void d(OutputStream paramOutputStream)
    throws IOException
  {
    r = new PrintStream(paramOutputStream);
  }
  
  public abstract int e();
  
  public void e(OutputStream paramOutputStream)
    throws IOException
  {
    r.println();
  }
  
  public void l(OutputStream paramOutputStream)
    throws IOException
  {}
  
  public void write(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {}
  
  public abstract void write(OutputStream paramOutputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
}
