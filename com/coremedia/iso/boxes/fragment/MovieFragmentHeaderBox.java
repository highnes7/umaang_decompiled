package com.coremedia.iso.boxes.fragment;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class MovieFragmentHeaderBox
  extends MimeMessage
{
  public static final String TYPE = "mfhd";
  public long sequenceNumber;
  
  static {}
  
  public MovieFragmentHeaderBox()
  {
    super("mfhd");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    sequenceNumber = ByteBufferList.readUInt32(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)sequenceNumber);
  }
  
  public long getContentSize()
  {
    return 8L;
  }
  
  public long getSequenceNumber()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sequenceNumber;
  }
  
  public void setSequenceNumber(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    sequenceNumber = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "MovieFragmentHeaderBox{sequenceNumber=");
    localStringBuilder.append(sequenceNumber);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
