package com.coremedia.iso.boxes.vodafone;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import org.aspectj.lang.JoinPoint;

public class ContentDistributorIdBox
  extends MimeMessage
{
  public static final String TYPE = "cdis";
  public String contentDistributorId;
  public String language;
  
  static {}
  
  public ContentDistributorIdBox()
  {
    super("cdis");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    language = ByteBufferList.nextToken(paramByteBuffer);
    contentDistributorId = ByteBufferList.readString(paramByteBuffer);
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.add(paramByteBuffer, language);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(contentDistributorId));
    paramByteBuffer.put((byte)0);
  }
  
  public String getContentDistributorId()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return contentDistributorId;
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.convert(contentDistributorId) + 2 + 5;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "ContentDistributorIdBox[language=");
    localStringBuilder.append(getLanguage());
    localStringBuilder.append(";contentDistributorId=");
    localStringBuilder.append(getContentDistributorId());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
