package com.coremedia.iso.boxes;

import f.h.a.Message;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class TrackReferenceTypeBox
  extends Message
{
  public static final String TYPE1 = "hint";
  public static final String TYPE2 = "cdsc";
  public long[] trackIds;
  
  static {}
  
  public TrackReferenceTypeBox(String paramString)
  {
    super(paramString);
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.remaining() / 4;
    trackIds = new long[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      trackIds[i] = ByteBufferList.readUInt32(paramByteBuffer);
      i += 1;
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    long[] arrayOfLong = trackIds;
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
    return trackIds.length * 4;
  }
  
  public long[] getTrackIds()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return trackIds;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TrackReferenceTypeBox[type=");
    ((StringBuilder)localObject).append(getType());
    int i = 0;
    for (;;)
    {
      if (i >= trackIds.length)
      {
        ((StringBuilder)localObject).append("]");
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).append(";trackId");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append(trackIds[i]);
      i += 1;
    }
  }
}
