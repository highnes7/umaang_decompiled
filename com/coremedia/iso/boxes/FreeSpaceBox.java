package com.coremedia.iso.boxes;

import f.h.a.Message;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class FreeSpaceBox
  extends Message
{
  public static final String TYPE = "skip";
  public byte[] data;
  
  static {}
  
  public FreeSpaceBox()
  {
    super("skip");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    data = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(data);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(data);
  }
  
  public long getContentSize()
  {
    return data.length;
  }
  
  public byte[] getData()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return data;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this, paramArrayOfByte);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    data = paramArrayOfByte;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "FreeSpaceBox[size=");
    localStringBuilder.append(data.length);
    localStringBuilder.append(";type=");
    localStringBuilder.append(getType());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
