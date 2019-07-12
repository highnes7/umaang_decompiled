package com.coremedia.iso.boxes.vodafone;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import org.aspectj.lang.JoinPoint;

public class CoverUriBox
  extends MimeMessage
{
  public static final String TYPE = "cvru";
  public String coverUri;
  
  static {}
  
  public CoverUriBox()
  {
    super("cvru");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    coverUri = ByteBufferList.readString(paramByteBuffer);
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(coverUri));
    paramByteBuffer.put((byte)0);
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.convert(coverUri) + 5;
  }
  
  public String getCoverUri()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return coverUri;
  }
  
  public void setCoverUri(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    coverUri = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "CoverUriBox[coverUri=");
    localStringBuilder.append(getCoverUri());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
