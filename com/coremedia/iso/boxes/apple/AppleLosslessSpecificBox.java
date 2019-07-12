package com.coremedia.iso.boxes.apple;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public final class AppleLosslessSpecificBox
  extends MimeMessage
{
  public static final String TYPE = "alac";
  public long bitRate;
  public int channels;
  public int historyMult;
  public int initialHistory;
  public int kModifier;
  public long maxCodedFrameSize;
  public long maxSamplePerFrame;
  public long sampleRate;
  public int sampleSize;
  public int unknown1;
  public int unknown2;
  
  static {}
  
  public AppleLosslessSpecificBox()
  {
    super("alac");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    maxSamplePerFrame = ByteBufferList.readUInt32(paramByteBuffer);
    unknown1 = ByteBufferList.readUInt8(paramByteBuffer);
    sampleSize = ByteBufferList.readUInt8(paramByteBuffer);
    historyMult = ByteBufferList.readUInt8(paramByteBuffer);
    initialHistory = ByteBufferList.readUInt8(paramByteBuffer);
    kModifier = ByteBufferList.readUInt8(paramByteBuffer);
    channels = ByteBufferList.readUInt8(paramByteBuffer);
    unknown2 = ByteBufferList.get(paramByteBuffer);
    maxCodedFrameSize = ByteBufferList.readUInt32(paramByteBuffer);
    bitRate = ByteBufferList.readUInt32(paramByteBuffer);
    sampleRate = ByteBufferList.readUInt32(paramByteBuffer);
  }
  
  public long getBitRate()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_18, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return bitRate;
  }
  
  public int getChannels()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_12, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return channels;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)maxSamplePerFrame);
    paramByteBuffer.put((byte)(unknown1 & 0xFF));
    paramByteBuffer.put((byte)(sampleSize & 0xFF));
    paramByteBuffer.put((byte)(historyMult & 0xFF));
    paramByteBuffer.put((byte)(initialHistory & 0xFF));
    paramByteBuffer.put((byte)(kModifier & 0xFF));
    paramByteBuffer.put((byte)(channels & 0xFF));
    Label.append(paramByteBuffer, unknown2);
    paramByteBuffer.putInt((int)maxCodedFrameSize);
    paramByteBuffer.putInt((int)bitRate);
    paramByteBuffer.putInt((int)sampleRate);
  }
  
  public long getContentSize()
  {
    return 28L;
  }
  
  public int getHistoryMult()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return historyMult;
  }
  
  public int getInitialHistory()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return initialHistory;
  }
  
  public int getKModifier()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return kModifier;
  }
  
  public long getMaxCodedFrameSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_16, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return maxCodedFrameSize;
  }
  
  public long getMaxSamplePerFrame()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return maxSamplePerFrame;
  }
  
  public long getSampleRate()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_20, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sampleRate;
  }
  
  public int getSampleSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sampleSize;
  }
  
  public int getUnknown1()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return unknown1;
  }
  
  public int getUnknown2()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_14, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return unknown2;
  }
  
  public void setBitRate(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_19, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    bitRate = paramInt;
  }
  
  public void setChannels(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_13, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    channels = paramInt;
  }
  
  public void setHistoryMult(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    historyMult = paramInt;
  }
  
  public void setInitialHistory(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    initialHistory = paramInt;
  }
  
  public void setKModifier(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    kModifier = paramInt;
  }
  
  public void setMaxCodedFrameSize(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_17, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    maxCodedFrameSize = paramInt;
  }
  
  public void setMaxSamplePerFrame(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    maxSamplePerFrame = paramInt;
  }
  
  public void setSampleRate(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_21, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    sampleRate = paramInt;
  }
  
  public void setSampleSize(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    sampleSize = paramInt;
  }
  
  public void setUnknown1(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    unknown1 = paramInt;
  }
  
  public void setUnknown2(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_15, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    unknown2 = paramInt;
  }
}
