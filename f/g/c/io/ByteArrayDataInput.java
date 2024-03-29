package f.g.c.io;

import java.io.DataInput;

public abstract interface ByteArrayDataInput
  extends DataInput
{
  public abstract boolean readBoolean();
  
  public abstract byte readByte();
  
  public abstract char readChar();
  
  public abstract double readDouble();
  
  public abstract float readFloat();
  
  public abstract void readFully(byte[] paramArrayOfByte);
  
  public abstract void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int readInt();
  
  public abstract String readLine();
  
  public abstract long readLong();
  
  public abstract short readShort();
  
  public abstract String readUTF();
  
  public abstract int readUnsignedByte();
  
  public abstract int readUnsignedShort();
  
  public abstract int skipBytes(int paramInt);
}
