package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class SampleAuxiliaryInformationOffsetsBox
  extends MimeMessage
{
  public static final String TYPE = "saio";
  public String auxInfoType;
  public String auxInfoTypeParameter;
  public List<Long> offsets = new LinkedList();
  
  static {}
  
  public SampleAuxiliaryInformationOffsetsBox()
  {
    super("saio");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    if ((getFlags() & 0x1) == 1)
    {
      auxInfoType = ByteBufferList.read(paramByteBuffer);
      auxInfoTypeParameter = ByteBufferList.read(paramByteBuffer);
    }
    int j = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    offsets.clear();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      if (getVersion() == 0) {
        offsets.add(Long.valueOf(ByteBufferList.readUInt32(paramByteBuffer)));
      } else {
        offsets.add(Long.valueOf(ByteBufferList.readUInt64(paramByteBuffer)));
      }
      i += 1;
    }
  }
  
  public String getAuxInfoType()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return auxInfoType;
  }
  
  public String getAuxInfoTypeParameter()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return auxInfoTypeParameter;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    if ((getFlags() & 0x1) == 1)
    {
      paramByteBuffer.put(Buffer.append(auxInfoType));
      paramByteBuffer.put(Buffer.append(auxInfoTypeParameter));
    }
    paramByteBuffer.putInt((int)offsets.size());
    Iterator localIterator = offsets.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Long localLong = (Long)localIterator.next();
      if (getVersion() == 0) {
        paramByteBuffer.putInt((int)localLong.longValue());
      } else {
        paramByteBuffer.putLong(localLong.longValue());
      }
    }
  }
  
  public long getContentSize()
  {
    int i = getVersion();
    int j = 8;
    if (i == 0) {
      i = offsets.size() * 4;
    } else {
      i = offsets.size() * 8;
    }
    if ((getFlags() & 0x1) != 1) {
      j = 0;
    }
    return i + 8 + j;
  }
  
  public List getOffsets()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return offsets;
  }
  
  public void setAuxInfoType(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    auxInfoType = paramString;
  }
  
  public void setAuxInfoTypeParameter(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    auxInfoTypeParameter = paramString;
  }
  
  public void setOffsets(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    offsets = paramList;
  }
}
