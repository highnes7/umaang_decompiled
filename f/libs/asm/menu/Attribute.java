package f.libs.asm.menu;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import l.a.a.a.a.b.ClassWriter;
import l.a.a.a.a.b.f;

public class Attribute
{
  public static final AtomicLong id = new AtomicLong(0L);
  public static String name;
  
  public Attribute(f paramF)
  {
    Object localObject = new byte[10];
    read((byte[])localObject);
    set((byte[])localObject);
    setValue((byte[])localObject);
    paramF = ClassWriter.a(paramF.a());
    localObject = ClassWriter.toString((byte[])localObject);
    name = String.format(Locale.US, "%s-%s-%s-%s", new Object[] { ((String)localObject).substring(0, 12), ((String)localObject).substring(12, 16), ((String)localObject).subSequence(16, 20), paramF.substring(0, 12) }).toUpperCase(Locale.US);
  }
  
  public static byte[] get(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.putShort((short)(int)paramLong);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    return localByteBuffer.array();
  }
  
  private void read(byte[] paramArrayOfByte)
  {
    long l = new Date().getTime();
    byte[] arrayOfByte = write(l / 1000L);
    paramArrayOfByte[0] = arrayOfByte[0];
    paramArrayOfByte[1] = arrayOfByte[1];
    paramArrayOfByte[2] = arrayOfByte[2];
    paramArrayOfByte[3] = arrayOfByte[3];
    arrayOfByte = get(l % 1000L);
    paramArrayOfByte[4] = arrayOfByte[0];
    paramArrayOfByte[5] = arrayOfByte[1];
  }
  
  private void set(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = get(id.incrementAndGet());
    paramArrayOfByte[6] = arrayOfByte[0];
    paramArrayOfByte[7] = arrayOfByte[1];
  }
  
  private void setValue(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = get(Integer.valueOf(Process.myPid()).shortValue());
    paramArrayOfByte[8] = arrayOfByte[0];
    paramArrayOfByte[9] = arrayOfByte[1];
  }
  
  public static byte[] write(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt((int)paramLong);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    return localByteBuffer.array();
  }
  
  public String toString()
  {
    return name;
  }
}
