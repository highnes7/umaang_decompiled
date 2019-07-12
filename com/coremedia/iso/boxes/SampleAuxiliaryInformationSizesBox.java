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

public class SampleAuxiliaryInformationSizesBox
  extends MimeMessage
{
  public static final String TYPE = "saiz";
  public String auxInfoType;
  public String auxInfoTypeParameter;
  public int defaultSampleInfoSize;
  public int sampleCount;
  public List<Short> sampleInfoSizes = new LinkedList();
  
  static {}
  
  public SampleAuxiliaryInformationSizesBox()
  {
    super("saiz");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    if ((getFlags() & 0x1) == 1)
    {
      auxInfoType = ByteBufferList.read(paramByteBuffer);
      auxInfoTypeParameter = ByteBufferList.read(paramByteBuffer);
    }
    defaultSampleInfoSize = ((short)ByteBufferList.readUInt8(paramByteBuffer));
    sampleCount = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    sampleInfoSizes.clear();
    if (defaultSampleInfoSize == 0)
    {
      int i = 0;
      for (;;)
      {
        if (i >= sampleCount) {
          return;
        }
        sampleInfoSizes.add(Short.valueOf((short)ByteBufferList.readUInt8(paramByteBuffer)));
        i += 1;
      }
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
    paramByteBuffer.put((byte)(defaultSampleInfoSize & 0xFF));
    if (defaultSampleInfoSize == 0)
    {
      paramByteBuffer.putInt((int)sampleInfoSizes.size());
      Iterator localIterator = sampleInfoSizes.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        paramByteBuffer.put((byte)(((Short)localIterator.next()).shortValue() & 0xFF));
      }
    }
    paramByteBuffer.putInt((int)sampleCount);
  }
  
  public long getContentSize()
  {
    int i;
    if ((getFlags() & 0x1) == 1) {
      i = 12;
    } else {
      i = 4;
    }
    int j;
    if (defaultSampleInfoSize == 0) {
      j = sampleInfoSizes.size();
    } else {
      j = 0;
    }
    return i + 5 + j;
  }
  
  public int getDefaultSampleInfoSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleInfoSize;
  }
  
  public int getSampleCount()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sampleCount;
  }
  
  public List getSampleInfoSizes()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sampleInfoSizes;
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
  
  public void setDefaultSampleInfoSize(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    defaultSampleInfoSize = paramInt;
  }
  
  public void setSampleCount(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    sampleCount = paramInt;
  }
  
  public void setSampleInfoSizes(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    sampleInfoSizes = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this), "SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=");
    localStringBuilder.append(defaultSampleInfoSize);
    localStringBuilder.append(", sampleCount=");
    localStringBuilder.append(sampleCount);
    localStringBuilder.append(", auxInfoType='");
    f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, auxInfoType, '\'', ", auxInfoTypeParameter='");
    localStringBuilder.append(auxInfoTypeParameter);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
