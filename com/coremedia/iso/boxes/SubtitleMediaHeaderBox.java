package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class SubtitleMediaHeaderBox
  extends AbstractMediaHeaderBox
{
  public static final String TYPE = "sthd";
  
  static {}
  
  public SubtitleMediaHeaderBox()
  {
    super("sthd");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
  }
  
  public long getContentSize()
  {
    return 4L;
  }
  
  public String toString()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return "SubtitleMediaHeaderBox";
  }
}
