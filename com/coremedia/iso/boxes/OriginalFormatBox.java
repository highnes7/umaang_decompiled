package com.coremedia.iso.boxes;

import f.h.a.Message;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class OriginalFormatBox
  extends Message
{
  public static final String TYPE = "frma";
  public String dataFormat = "    ";
  
  static {}
  
  public OriginalFormatBox()
  {
    super("frma");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    dataFormat = ByteBufferList.read(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(Buffer.append(dataFormat));
  }
  
  public long getContentSize()
  {
    return 4L;
  }
  
  public String getDataFormat()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return dataFormat;
  }
  
  public void setDataFormat(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    dataFormat = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "OriginalFormatBox[dataFormat=");
    localStringBuilder.append(getDataFormat());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
