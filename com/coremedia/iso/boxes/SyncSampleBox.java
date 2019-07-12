package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class SyncSampleBox
  extends MimeMessage
{
  public static final String TYPE = "stss";
  public long[] sampleNumber;
  
  static {}
  
  public SyncSampleBox()
  {
    super("stss");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    int j = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    sampleNumber = new long[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      sampleNumber[i] = ByteBufferList.readUInt32(paramByteBuffer);
      i += 1;
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)sampleNumber.length);
    long[] arrayOfLong = sampleNumber;
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
  
  public long getContentSize()
  {
    return sampleNumber.length * 4 + 8;
  }
  
  public long[] getSampleNumber()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sampleNumber;
  }
  
  public void setSampleNumber(long[] paramArrayOfLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, paramArrayOfLong);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    sampleNumber = paramArrayOfLong;
  }
  
  public String toString()
  {
    return StringBuilder.append(StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this), "SyncSampleBox[entryCount="), sampleNumber.length, "]");
  }
}
