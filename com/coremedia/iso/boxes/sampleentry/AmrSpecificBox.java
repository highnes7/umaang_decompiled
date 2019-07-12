package com.coremedia.iso.boxes.sampleentry;

import f.h.a.Message;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class AmrSpecificBox
  extends Message
{
  public static final String TYPE = "damr";
  public int decoderVersion;
  public int framesPerSample;
  public int modeChangePeriod;
  public int modeSet;
  public String vendor;
  
  static {}
  
  public AmrSpecificBox()
  {
    super("damr");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    vendor = Buffer.evaluate(arrayOfByte);
    decoderVersion = ByteBufferList.readUInt8(paramByteBuffer);
    modeSet = ByteBufferList.get(paramByteBuffer);
    modeChangePeriod = ByteBufferList.readUInt8(paramByteBuffer);
    framesPerSample = ByteBufferList.readUInt8(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, paramByteBuffer);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    paramByteBuffer.put(Buffer.append(vendor));
    paramByteBuffer.put((byte)(decoderVersion & 0xFF));
    Label.append(paramByteBuffer, modeSet);
    paramByteBuffer.put((byte)(modeChangePeriod & 0xFF));
    paramByteBuffer.put((byte)(framesPerSample & 0xFF));
  }
  
  public long getContentSize()
  {
    return 9L;
  }
  
  public int getDecoderVersion()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return decoderVersion;
  }
  
  public int getFramesPerSample()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return framesPerSample;
  }
  
  public int getModeChangePeriod()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return modeChangePeriod;
  }
  
  public int getModeSet()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return modeSet;
  }
  
  public String getVendor()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return vendor;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AmrSpecificBox[vendor=");
    ((StringBuilder)localObject).append(getVendor());
    ((StringBuilder)localObject).append(";decoderVersion=");
    ((StringBuilder)localObject).append(getDecoderVersion());
    ((StringBuilder)localObject).append(";modeSet=");
    ((StringBuilder)localObject).append(getModeSet());
    ((StringBuilder)localObject).append(";modeChangePeriod=");
    ((StringBuilder)localObject).append(getModeChangePeriod());
    ((StringBuilder)localObject).append(";framesPerSample=");
    ((StringBuilder)localObject).append(getFramesPerSample());
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
}
