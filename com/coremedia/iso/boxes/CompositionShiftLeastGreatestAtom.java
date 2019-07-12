package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class CompositionShiftLeastGreatestAtom
  extends MimeMessage
{
  public static final String TYPE = "cslg";
  public int compositionOffsetToDisplayOffsetShift;
  public int displayEndTime;
  public int displayStartTime;
  public int greatestDisplayOffset;
  public int leastDisplayOffset;
  
  static {}
  
  public CompositionShiftLeastGreatestAtom()
  {
    super("cslg");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    compositionOffsetToDisplayOffsetShift = paramByteBuffer.getInt();
    leastDisplayOffset = paramByteBuffer.getInt();
    greatestDisplayOffset = paramByteBuffer.getInt();
    displayStartTime = paramByteBuffer.getInt();
    displayEndTime = paramByteBuffer.getInt();
  }
  
  public int getCompositionOffsetToDisplayOffsetShift()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return compositionOffsetToDisplayOffsetShift;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt(compositionOffsetToDisplayOffsetShift);
    paramByteBuffer.putInt(leastDisplayOffset);
    paramByteBuffer.putInt(greatestDisplayOffset);
    paramByteBuffer.putInt(displayStartTime);
    paramByteBuffer.putInt(displayEndTime);
  }
  
  public long getContentSize()
  {
    return 24L;
  }
  
  public int getDisplayEndTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return displayEndTime;
  }
  
  public int getDisplayStartTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return displayStartTime;
  }
  
  public int getGreatestDisplayOffset()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return greatestDisplayOffset;
  }
  
  public int getLeastDisplayOffset()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return leastDisplayOffset;
  }
  
  public void setCompositionOffsetToDisplayOffsetShift(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    compositionOffsetToDisplayOffsetShift = paramInt;
  }
  
  public void setDisplayEndTime(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    displayEndTime = paramInt;
  }
  
  public void setDisplayStartTime(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    displayStartTime = paramInt;
  }
  
  public void setGreatestDisplayOffset(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    greatestDisplayOffset = paramInt;
  }
  
  public void setLeastDisplayOffset(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    leastDisplayOffset = paramInt;
  }
}
