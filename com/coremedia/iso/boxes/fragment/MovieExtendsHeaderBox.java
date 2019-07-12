package com.coremedia.iso.boxes.fragment;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class MovieExtendsHeaderBox
  extends MimeMessage
{
  public static final String TYPE = "mehd";
  public long fragmentDuration;
  
  static {}
  
  public MovieExtendsHeaderBox()
  {
    super("mehd");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    long l;
    if (getVersion() == 1) {
      l = ByteBufferList.readUInt64(paramByteBuffer);
    } else {
      l = ByteBufferList.readUInt32(paramByteBuffer);
    }
    fragmentDuration = l;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    if (getVersion() == 1)
    {
      paramByteBuffer.putLong(fragmentDuration);
      return;
    }
    paramByteBuffer.putInt((int)fragmentDuration);
  }
  
  public long getContentSize()
  {
    int i;
    if (getVersion() == 1) {
      i = 12;
    } else {
      i = 8;
    }
    return i;
  }
  
  public long getFragmentDuration()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return fragmentDuration;
  }
  
  public void setFragmentDuration(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    fragmentDuration = paramLong;
  }
}
