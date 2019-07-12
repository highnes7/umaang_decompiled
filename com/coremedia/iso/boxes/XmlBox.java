package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import org.aspectj.lang.JoinPoint;

public class XmlBox
  extends MimeMessage
{
  public static final String TYPE = "xml ";
  public String xml = "";
  
  static {}
  
  public XmlBox()
  {
    super("xml ");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    xml = ByteBufferList.readString(paramByteBuffer, paramByteBuffer.remaining());
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(xml));
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.convert(xml) + 4;
  }
  
  public String getXml()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return xml;
  }
  
  public void setXml(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    xml = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "XmlBox{xml='");
    localStringBuilder.append(xml);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
