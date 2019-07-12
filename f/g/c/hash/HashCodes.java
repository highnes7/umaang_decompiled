package f.g.c.hash;

import f.g.c.a.a;
import f.g.c.package_10.Preconditions;
import java.io.Serializable;

@a
public final class HashCodes
{
  public HashCodes() {}
  
  public static HashCode fromBytes(byte[] paramArrayOfByte)
  {
    boolean bool;
    if (paramArrayOfByte.length >= 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "A HashCode must contain at least 4 bytes.");
    return new BytesHashCode((byte[])paramArrayOfByte.clone());
  }
  
  public static HashCode fromBytesNoCopy(int paramInt)
  {
    return new HashCode.BytesHashCode(paramInt);
  }
  
  public static HashCode fromBytesNoCopy(byte[] paramArrayOfByte)
  {
    return new BytesHashCode();
  }
  
  public static HashCode fromLong(long paramLong)
  {
    return new HashCode.LongHashCode(paramLong);
  }
  
  public final class BytesHashCode
    extends HashCode
    implements Serializable
  {
    public static final long serialVersionUID = 0L;
    
    public BytesHashCode() {}
    
    public byte[] asBytes()
    {
      return (byte[])clone();
    }
    
    public int asInt()
    {
      byte[] arrayOfByte = HashCodes.this;
      int i = arrayOfByte[0];
      int j = arrayOfByte[1];
      int k = arrayOfByte[2];
      return (arrayOfByte[3] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
    }
    
    public long asLong()
    {
      byte[] arrayOfByte = HashCodes.this;
      if (arrayOfByte.length >= 8)
      {
        long l = arrayOfByte[0];
        return (arrayOfByte[1] & 0xFF) << 8 | l & 0xFF | (arrayOfByte[2] & 0xFF) << 16 | (arrayOfByte[3] & 0xFF) << 24 | (arrayOfByte[4] & 0xFF) << 32 | (arrayOfByte[5] & 0xFF) << 40 | (arrayOfByte[6] & 0xFF) << 48 | (arrayOfByte[7] & 0xFF) << 56;
      }
      throw new IllegalStateException("Not enough bytes");
    }
    
    public int bits()
    {
      return HashCodes.this.length * 8;
    }
  }
}
