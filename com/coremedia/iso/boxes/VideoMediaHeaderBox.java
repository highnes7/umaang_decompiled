package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class VideoMediaHeaderBox
  extends AbstractMediaHeaderBox
{
  public static final String TYPE = "vmhd";
  public int graphicsmode = 0;
  public int[] opcolor = new int[3];
  
  static {}
  
  public VideoMediaHeaderBox()
  {
    super("vmhd");
    setFlags(1);
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    graphicsmode = ByteBufferList.get(paramByteBuffer);
    opcolor = new int[3];
    int i = 0;
    for (;;)
    {
      if (i >= 3) {
        return;
      }
      opcolor[i] = ByteBufferList.get(paramByteBuffer);
      i += 1;
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.append(paramByteBuffer, graphicsmode);
    int[] arrayOfInt = opcolor;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      Label.append(paramByteBuffer, arrayOfInt[i]);
      i += 1;
    }
  }
  
  public long getContentSize()
  {
    return 12L;
  }
  
  public int getGraphicsmode()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return graphicsmode;
  }
  
  public int[] getOpcolor()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return opcolor;
  }
  
  public void setGraphicsmode(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    graphicsmode = paramInt;
  }
  
  public void setOpcolor(int[] paramArrayOfInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramArrayOfInt);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    opcolor = paramArrayOfInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "VideoMediaHeaderBox[graphicsmode=");
    localStringBuilder.append(getGraphicsmode());
    localStringBuilder.append(";opcolor0=");
    localStringBuilder.append(getOpcolor()[0]);
    localStringBuilder.append(";opcolor1=");
    localStringBuilder.append(getOpcolor()[1]);
    localStringBuilder.append(";opcolor2=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, getOpcolor()[2], "]");
  }
}
