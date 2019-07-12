package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class HintMediaHeaderBox
  extends AbstractMediaHeaderBox
{
  public static final String TYPE = "hmhd";
  public long avgBitrate;
  public int avgPduSize;
  public long maxBitrate;
  public int maxPduSize;
  
  static {}
  
  public HintMediaHeaderBox()
  {
    super("hmhd");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    maxPduSize = ByteBufferList.get(paramByteBuffer);
    avgPduSize = ByteBufferList.get(paramByteBuffer);
    maxBitrate = ByteBufferList.readUInt32(paramByteBuffer);
    avgBitrate = ByteBufferList.readUInt32(paramByteBuffer);
    ByteBufferList.readUInt32(paramByteBuffer);
  }
  
  public long getAvgBitrate()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avgBitrate;
  }
  
  public int getAvgPduSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avgPduSize;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.append(paramByteBuffer, maxPduSize);
    Label.append(paramByteBuffer, avgPduSize);
    paramByteBuffer.putInt((int)maxBitrate);
    paramByteBuffer.putInt((int)avgBitrate);
    paramByteBuffer.putInt((int)0L);
  }
  
  public long getContentSize()
  {
    return 20L;
  }
  
  public long getMaxBitrate()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return maxBitrate;
  }
  
  public int getMaxPduSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return maxPduSize;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this), "HintMediaHeaderBox{maxPduSize=");
    localStringBuilder.append(maxPduSize);
    localStringBuilder.append(", avgPduSize=");
    localStringBuilder.append(avgPduSize);
    localStringBuilder.append(", maxBitrate=");
    localStringBuilder.append(maxBitrate);
    localStringBuilder.append(", avgBitrate=");
    localStringBuilder.append(avgBitrate);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
