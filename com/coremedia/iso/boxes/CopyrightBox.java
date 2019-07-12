package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import org.aspectj.lang.JoinPoint;

public class CopyrightBox
  extends MimeMessage
{
  public static final String TYPE = "cprt";
  public String copyright;
  public String language;
  
  static {}
  
  public CopyrightBox()
  {
    super("cprt");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    language = ByteBufferList.nextToken(paramByteBuffer);
    copyright = ByteBufferList.readString(paramByteBuffer);
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.add(paramByteBuffer, language);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(copyright));
    paramByteBuffer.put((byte)0);
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.convert(copyright) + 7;
  }
  
  public String getCopyright()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return copyright;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public void setCopyright(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    copyright = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    language = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this), "CopyrightBox[language=");
    localStringBuilder.append(getLanguage());
    localStringBuilder.append(";copyright=");
    localStringBuilder.append(getCopyright());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
