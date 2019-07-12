package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class RecordingYearBox
  extends MimeMessage
{
  public static final String TYPE = "yrrc";
  public int recordingYear;
  
  static {}
  
  public RecordingYearBox()
  {
    super("yrrc");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    recordingYear = ByteBufferList.get(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.append(paramByteBuffer, recordingYear);
  }
  
  public long getContentSize()
  {
    return 6L;
  }
  
  public int getRecordingYear()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return recordingYear;
  }
  
  public void setRecordingYear(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    recordingYear = paramInt;
  }
}
