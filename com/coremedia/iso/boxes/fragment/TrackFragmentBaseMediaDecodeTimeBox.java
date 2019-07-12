package com.coremedia.iso.boxes.fragment;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class TrackFragmentBaseMediaDecodeTimeBox
  extends MimeMessage
{
  public static final String TYPE = "tfdt";
  public long baseMediaDecodeTime;
  
  static {}
  
  public TrackFragmentBaseMediaDecodeTimeBox()
  {
    super("tfdt");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    if (getVersion() == 1)
    {
      baseMediaDecodeTime = ByteBufferList.readUInt64(paramByteBuffer);
      return;
    }
    baseMediaDecodeTime = ByteBufferList.readUInt32(paramByteBuffer);
  }
  
  public long getBaseMediaDecodeTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return baseMediaDecodeTime;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    if (getVersion() == 1)
    {
      paramByteBuffer.putLong(baseMediaDecodeTime);
      return;
    }
    paramByteBuffer.putInt((int)baseMediaDecodeTime);
  }
  
  public long getContentSize()
  {
    int i;
    if (getVersion() == 0) {
      i = 8;
    } else {
      i = 12;
    }
    return i;
  }
  
  public void setBaseMediaDecodeTime(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    baseMediaDecodeTime = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "TrackFragmentBaseMediaDecodeTimeBox{baseMediaDecodeTime=");
    localStringBuilder.append(baseMediaDecodeTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
