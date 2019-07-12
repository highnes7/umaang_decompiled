package com.coremedia.iso.boxes.fragment;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class MovieFragmentRandomAccessOffsetBox
  extends MimeMessage
{
  public static final String TYPE = "mfro";
  public long mfraSize;
  
  static {}
  
  public MovieFragmentRandomAccessOffsetBox()
  {
    super("mfro");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    mfraSize = ByteBufferList.readUInt32(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)mfraSize);
  }
  
  public long getContentSize()
  {
    return 8L;
  }
  
  public long getMfraSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return mfraSize;
  }
  
  public void setMfraSize(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    mfraSize = paramLong;
  }
}
