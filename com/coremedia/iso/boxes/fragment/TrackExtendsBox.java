package com.coremedia.iso.boxes.fragment;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class TrackExtendsBox
  extends MimeMessage
{
  public static final String TYPE = "trex";
  public long defaultSampleDescriptionIndex;
  public long defaultSampleDuration;
  public SampleFlags defaultSampleFlags;
  public long defaultSampleSize;
  public long trackId;
  
  static {}
  
  public TrackExtendsBox()
  {
    super("trex");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    trackId = ByteBufferList.readUInt32(paramByteBuffer);
    defaultSampleDescriptionIndex = ByteBufferList.readUInt32(paramByteBuffer);
    defaultSampleDuration = ByteBufferList.readUInt32(paramByteBuffer);
    defaultSampleSize = ByteBufferList.readUInt32(paramByteBuffer);
    defaultSampleFlags = new SampleFlags(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)trackId);
    paramByteBuffer.putInt((int)defaultSampleDescriptionIndex);
    paramByteBuffer.putInt((int)defaultSampleDuration);
    paramByteBuffer.putInt((int)defaultSampleSize);
    defaultSampleFlags.getContent(paramByteBuffer);
  }
  
  public long getContentSize()
  {
    return 24L;
  }
  
  public long getDefaultSampleDescriptionIndex()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleDescriptionIndex;
  }
  
  public long getDefaultSampleDuration()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleDuration;
  }
  
  public SampleFlags getDefaultSampleFlags()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleFlags;
  }
  
  public String getDefaultSampleFlagsStr()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleFlags.toString();
  }
  
  public long getDefaultSampleSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleSize;
  }
  
  public long getTrackId()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return trackId;
  }
  
  public void setDefaultSampleDescriptionIndex(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    defaultSampleDescriptionIndex = paramLong;
  }
  
  public void setDefaultSampleDuration(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    defaultSampleDuration = paramLong;
  }
  
  public void setDefaultSampleFlags(SampleFlags paramSampleFlags)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this, paramSampleFlags);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    defaultSampleFlags = paramSampleFlags;
  }
  
  public void setDefaultSampleSize(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    defaultSampleSize = paramLong;
  }
  
  public void setTrackId(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    trackId = paramLong;
  }
}
