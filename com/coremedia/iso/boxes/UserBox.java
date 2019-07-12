package com.coremedia.iso.boxes;

import f.h.a.Message;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class UserBox
  extends Message
{
  public static final String TYPE = "uuid";
  public byte[] data;
  
  static {}
  
  public UserBox(byte[] paramArrayOfByte)
  {
    super("uuid", paramArrayOfByte);
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
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, paramArrayOfByte);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    data = paramArrayOfByte;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this), "UserBox[type=");
    localStringBuilder.append(getType());
    localStringBuilder.append(";userType=");
    localStringBuilder.append(new String(getUserType()));
    localStringBuilder.append(";contentLength=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, data.length, "]");
  }
}
