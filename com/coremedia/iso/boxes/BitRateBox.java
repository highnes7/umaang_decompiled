package com.coremedia.iso.boxes;

import f.h.a.Message;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public final class BitRateBox
  extends Message
{
  public static final String TYPE = "btrt";
  public long avgBitrate;
  public long bufferSizeDb;
  public long maxBitrate;
  
  static {}
  
  public BitRateBox()
  {
    super("btrt");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    bufferSizeDb = ByteBufferList.readUInt32(paramByteBuffer);
    maxBitrate = ByteBufferList.readUInt32(paramByteBuffer);
    avgBitrate = ByteBufferList.readUInt32(paramByteBuffer);
  }
  
  public long getAvgBitrate()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avgBitrate;
  }
  
  public long getBufferSizeDb()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return bufferSizeDb;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.putInt((int)bufferSizeDb);
    paramByteBuffer.putInt((int)maxBitrate);
    paramByteBuffer.putInt((int)avgBitrate);
  }
  
  public long getContentSize()
  {
    return 12L;
  }
  
  public long getMaxBitrate()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return maxBitrate;
  }
  
  public void setAvgBitrate(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avgBitrate = paramLong;
  }
  
  public void setBufferSizeDb(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    bufferSizeDb = paramLong;
  }
  
  public void setMaxBitrate(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    maxBitrate = paramLong;
  }
}
