package com.coremedia.iso.boxes.apple;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import org.aspectj.lang.JoinPoint;

public class AppleDataReferenceBox
  extends MimeMessage
{
  public static final String TYPE = "rdrf";
  public String dataReference;
  public int dataReferenceSize;
  public String dataReferenceType;
  
  static {}
  
  public AppleDataReferenceBox()
  {
    super("rdrf");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    dataReferenceType = ByteBufferList.read(paramByteBuffer);
    dataReferenceSize = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    dataReference = ByteBufferList.readString(paramByteBuffer, dataReferenceSize);
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.put(Buffer.append(dataReferenceType));
    paramByteBuffer.putInt((int)dataReferenceSize);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(dataReference));
  }
  
  public long getContentSize()
  {
    return dataReferenceSize + 12;
  }
  
  public String getDataReference()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return dataReference;
  }
  
  public long getDataReferenceSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return dataReferenceSize;
  }
  
  public String getDataReferenceType()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return dataReferenceType;
  }
}
