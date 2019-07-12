package f.g.c.io;

import f.g.c.a.a;
import f.g.c.j.g;
import f.g.c.j.h;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@a
public final class LittleEndianDataInputStream
  extends FilterInputStream
  implements DataInput
{
  public LittleEndianDataInputStream(InputStream paramInputStream) {}
  
  private byte readAndCheckByte()
    throws IOException, EOFException
  {
    int i = in.read();
    if (-1 != i) {
      return (byte)i;
    }
    throw new EOFException();
  }
  
  public boolean readBoolean()
    throws IOException
  {
    return readUnsignedByte() != 0;
  }
  
  public byte readByte()
    throws IOException
  {
    return (byte)readUnsignedByte();
  }
  
  public char readChar()
    throws IOException
  {
    return (char)readUnsignedShort();
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(readLong());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(readInt());
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteStreams.readFully(this, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    ByteStreams.readFully(this, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int readInt()
    throws IOException
  {
    byte b1 = readAndCheckByte();
    byte b2 = readAndCheckByte();
    byte b3 = readAndCheckByte();
    return g.a(readAndCheckByte(), b3, b2, b1);
  }
  
  public String readLine()
  {
    throw new UnsupportedOperationException("readLine is not supported");
  }
  
  public long readLong()
    throws IOException
  {
    byte b1 = readAndCheckByte();
    byte b2 = readAndCheckByte();
    byte b3 = readAndCheckByte();
    byte b4 = readAndCheckByte();
    byte b5 = readAndCheckByte();
    byte b6 = readAndCheckByte();
    byte b7 = readAndCheckByte();
    return h.a(readAndCheckByte(), b7, b6, b5, b4, b3, b2, b1);
  }
  
  public short readShort()
    throws IOException
  {
    return (short)readUnsignedShort();
  }
  
  public String readUTF()
    throws IOException
  {
    return new DataInputStream(in).readUTF();
  }
  
  public int readUnsignedByte()
    throws IOException
  {
    int i = in.read();
    if (i >= 0) {
      return i;
    }
    throw new EOFException();
  }
  
  public int readUnsignedShort()
    throws IOException
  {
    byte b = readAndCheckByte();
    return g.a((byte)0, (byte)0, readAndCheckByte(), b);
  }
  
  public int skipBytes(int paramInt)
    throws IOException
  {
    return (int)in.skip(paramInt);
  }
}
