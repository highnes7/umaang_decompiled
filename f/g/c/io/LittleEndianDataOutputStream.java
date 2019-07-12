package f.g.c.io;

import f.g.c.a.a;
import f.g.c.j.h;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@a
public class LittleEndianDataOutputStream
  extends FilterOutputStream
  implements DataOutput
{
  public LittleEndianDataOutputStream(OutputStream paramOutputStream) {}
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    ((DataOutputStream)out).writeBoolean(paramBoolean);
  }
  
  public void writeByte(int paramInt)
    throws IOException
  {
    ((DataOutputStream)out).writeByte(paramInt);
  }
  
  public void writeBytes(String paramString)
    throws IOException
  {
    ((DataOutputStream)out).writeBytes(paramString);
  }
  
  public void writeChar(int paramInt)
    throws IOException
  {
    writeShort(paramInt);
  }
  
  public void writeChars(String paramString)
    throws IOException
  {
    int i = 0;
    while (i < paramString.length())
    {
      writeChar(paramString.charAt(i));
      i += 1;
    }
  }
  
  public void writeDouble(double paramDouble)
    throws IOException
  {
    writeLong(Double.doubleToLongBits(paramDouble));
  }
  
  public void writeFloat(float paramFloat)
    throws IOException
  {
    writeInt(Float.floatToIntBits(paramFloat));
  }
  
  public void writeInt(int paramInt)
    throws IOException
  {
    out.write(paramInt & 0xFF);
    out.write(paramInt >> 8 & 0xFF);
    out.write(paramInt >> 16 & 0xFF);
    out.write(paramInt >> 24 & 0xFF);
  }
  
  public void writeLong(long paramLong)
    throws IOException
  {
    byte[] arrayOfByte = h.b(Long.reverseBytes(paramLong));
    write(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void writeShort(int paramInt)
    throws IOException
  {
    out.write(paramInt & 0xFF);
    out.write(paramInt >> 8 & 0xFF);
  }
  
  public void writeUTF(String paramString)
    throws IOException
  {
    ((DataOutputStream)out).writeUTF(paramString);
  }
}
