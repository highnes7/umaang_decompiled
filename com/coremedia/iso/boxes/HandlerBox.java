package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.JoinPoint;

public class HandlerBox
  extends MimeMessage
{
  public static final String TYPE = "hdlr";
  public static final Map<String, String> readableTypes;
  public long a;
  public long b;
  public long c;
  public String handlerType;
  public String name = null;
  public long shouldBeZeroButAppleWritesHereSomeValue;
  public boolean zeroTerm = true;
  
  static
  {
    ajc$preClinit();
    HashMap localHashMap = new HashMap();
    localHashMap.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
    localHashMap.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
    localHashMap.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
    localHashMap.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
    localHashMap.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
    localHashMap.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
    localHashMap.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
    localHashMap.put("mdir", "Apple Meta Data iTunes Reader");
    localHashMap.put("mp7b", "MPEG-7 binary XML");
    localHashMap.put("mp7t", "MPEG-7 XML");
    localHashMap.put("vide", "Video Track");
    localHashMap.put("soun", "Sound Track");
    localHashMap.put("hint", "Hint Track");
    localHashMap.put("appl", "Apple specific");
    localHashMap.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
    readableTypes = Collections.unmodifiableMap(localHashMap);
  }
  
  public HandlerBox()
  {
    super("hdlr");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    shouldBeZeroButAppleWritesHereSomeValue = ByteBufferList.readUInt32(paramByteBuffer);
    handlerType = ByteBufferList.read(paramByteBuffer);
    a = ByteBufferList.readUInt32(paramByteBuffer);
    b = ByteBufferList.readUInt32(paramByteBuffer);
    c = ByteBufferList.readUInt32(paramByteBuffer);
    if (paramByteBuffer.remaining() > 0)
    {
      name = ByteBufferList.readString(paramByteBuffer, paramByteBuffer.remaining());
      if (name.endsWith("\000"))
      {
        name = f.sufficientlysecure.rootcommands.util.StringBuilder.substring(name, 1, 0);
        zeroTerm = true;
        return;
      }
      zeroTerm = false;
      return;
    }
    zeroTerm = false;
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)shouldBeZeroButAppleWritesHereSomeValue);
    paramByteBuffer.put(Buffer.append(handlerType));
    paramByteBuffer.putInt((int)a);
    paramByteBuffer.putInt((int)b);
    paramByteBuffer.putInt((int)c);
    String str = name;
    if (str != null) {
      paramByteBuffer.put(f.slide.asm.ByteBuffer.append(str));
    }
    if (zeroTerm) {
      paramByteBuffer.put((byte)0);
    }
  }
  
  public long getContentSize()
  {
    if (zeroTerm) {}
    for (int i = f.slide.asm.ByteBuffer.convert(name) + 25;; i = f.slide.asm.ByteBuffer.convert(name) + 24) {
      return i;
    }
  }
  
  public String getHandlerType()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return handlerType;
  }
  
  public String getHumanReadableTrackType()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (readableTypes.get(handlerType) != null) {
      return (String)readableTypes.get(handlerType);
    }
    return "Unknown Handler Type";
  }
  
  public String getName()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return name;
  }
  
  public void setHandlerType(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    handlerType = paramString;
  }
  
  public void setName(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    name = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this), "HandlerBox[handlerType=");
    localStringBuilder.append(getHandlerType());
    localStringBuilder.append(";name=");
    localStringBuilder.append(getName());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
