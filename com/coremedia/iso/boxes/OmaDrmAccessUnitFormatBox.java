package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public final class OmaDrmAccessUnitFormatBox
  extends MimeMessage
{
  public static final String TYPE = "odaf";
  public byte allBits;
  public int initVectorLength;
  public int keyIndicatorLength;
  public boolean selectiveEncryption;
  
  static {}
  
  public OmaDrmAccessUnitFormatBox()
  {
    super("odaf");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    allBits = ((byte)ByteBufferList.readUInt8(paramByteBuffer));
    boolean bool;
    if ((allBits & 0x80) == 128) {
      bool = true;
    } else {
      bool = false;
    }
    selectiveEncryption = bool;
    keyIndicatorLength = ByteBufferList.readUInt8(paramByteBuffer);
    initVectorLength = ByteBufferList.readUInt8(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.put((byte)(allBits & 0xFF));
    paramByteBuffer.put((byte)(keyIndicatorLength & 0xFF));
    paramByteBuffer.put((byte)(initVectorLength & 0xFF));
  }
  
  public long getContentSize()
  {
    return 7L;
  }
  
  public int getInitVectorLength()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return initVectorLength;
  }
  
  public int getKeyIndicatorLength()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return keyIndicatorLength;
  }
  
  public boolean isSelectiveEncryption()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return selectiveEncryption;
  }
  
  public void setAllBits(byte paramByte)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Byte(paramByte));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    allBits = paramByte;
    boolean bool;
    if ((paramByte & 0x80) == 128) {
      bool = true;
    } else {
      bool = false;
    }
    selectiveEncryption = bool;
  }
  
  public void setInitVectorLength(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    initVectorLength = paramInt;
  }
  
  public void setKeyIndicatorLength(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    keyIndicatorLength = paramInt;
  }
}
