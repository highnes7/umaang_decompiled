package com.coremedia.iso.boxes.apple;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class AppleDataRateBox
  extends MimeMessage
{
  public static final String TYPE = "rmdr";
  public long dataRate;
  
  static {}
  
  public AppleDataRateBox()
  {
    super("rmdr");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    dataRate = ByteBufferList.readUInt32(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)dataRate);
  }
  
  public long getContentSize()
  {
    return 8L;
  }
  
  public long getDataRate()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return dataRate;
  }
}
