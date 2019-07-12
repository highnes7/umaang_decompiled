package f.h.a;

import com.coremedia.iso.boxes.FullBox;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public abstract class MimeMessage
  extends Message
  implements FullBox
{
  public int flags;
  public int version;
  
  static {}
  
  public MimeMessage(String paramString)
  {
    super(paramString);
  }
  
  public MimeMessage(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString, paramArrayOfByte);
  }
  
  public int getFlags()
  {
    if (!isParsed) {
      parseDetails();
    }
    return flags;
  }
  
  public int getVersion()
  {
    if (!isParsed) {
      parseDetails();
    }
    return version;
  }
  
  public final long parseVersionAndFlags(ByteBuffer paramByteBuffer)
  {
    version = ByteBufferList.readUInt8(paramByteBuffer);
    flags = ByteBufferList.getInt(paramByteBuffer);
    return 4L;
  }
  
  public void setFlags(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Integer(paramInt));
    Factory.aspectOf().before(localJoinPoint);
    flags = paramInt;
  }
  
  public void setVersion(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this, new Integer(paramInt));
    Factory.aspectOf().before(localJoinPoint);
    version = paramInt;
  }
  
  public final void writeVersionAndFlags(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put((byte)(version & 0xFF));
    Label.set(paramByteBuffer, flags);
  }
}
