package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class SampleSizeBox
  extends MimeMessage
{
  public static final String TYPE = "stsz";
  public int sampleCount;
  public long sampleSize;
  public long[] sampleSizes = new long[0];
  
  static {}
  
  public SampleSizeBox()
  {
    super("stsz");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    sampleSize = ByteBufferList.readUInt32(paramByteBuffer);
    sampleCount = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    if (sampleSize == 0L)
    {
      sampleSizes = new long[sampleCount];
      int i = 0;
      for (;;)
      {
        if (i >= sampleCount) {
          return;
        }
        sampleSizes[i] = ByteBufferList.readUInt32(paramByteBuffer);
        i += 1;
      }
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)sampleSize);
    if (sampleSize == 0L)
    {
      paramByteBuffer.putInt((int)sampleSizes.length);
      long[] arrayOfLong = sampleSizes;
      int j = arrayOfLong.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        paramByteBuffer.putInt((int)arrayOfLong[i]);
        i += 1;
      }
    }
    paramByteBuffer.putInt((int)sampleCount);
  }
  
  public long getContentSize()
  {
    int i;
    if (sampleSize == 0L) {
      i = sampleSizes.length * 4;
    } else {
      i = 0;
    }
    return i + 12;
  }
  
  public long getSampleCount()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (sampleSize > 0L) {}
    for (int i = sampleCount;; i = sampleSizes.length) {
      return i;
    }
  }
  
  public long getSampleSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sampleSize;
  }
  
  public long getSampleSizeAtIndex(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    long l = sampleSize;
    if (l > 0L) {
      return l;
    }
    return sampleSizes[paramInt];
  }
  
  public long[] getSampleSizes()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sampleSizes;
  }
  
  public void setSampleSize(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    sampleSize = paramLong;
  }
  
  public void setSampleSizes(long[] paramArrayOfLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, paramArrayOfLong);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    sampleSizes = paramArrayOfLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this), "SampleSizeBox[sampleSize=");
    localStringBuilder.append(getSampleSize());
    localStringBuilder.append(";sampleCount=");
    localStringBuilder.append(getSampleCount());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
