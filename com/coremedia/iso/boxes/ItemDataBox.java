package com.coremedia.iso.boxes;

import f.h.a.Message;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class ItemDataBox
  extends Message
{
  public static final String TYPE = "idat";
  public ByteBuffer data = ByteBuffer.allocate(0);
  
  static {}
  
  public ItemDataBox()
  {
    super("idat");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    data = paramByteBuffer.slice();
    int i = paramByteBuffer.position();
    paramByteBuffer.position(paramByteBuffer.remaining() + i);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(data);
  }
  
  public long getContentSize()
  {
    return data.limit();
  }
  
  public ByteBuffer getData()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return data;
  }
  
  public void setData(ByteBuffer paramByteBuffer)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramByteBuffer);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    data = paramByteBuffer;
  }
}
