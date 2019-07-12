package com.coremedia.iso.boxes.vodafone;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import org.aspectj.lang.JoinPoint;

public class LyricsUriBox
  extends MimeMessage
{
  public static final String TYPE = "lrcu";
  public String lyricsUri;
  
  static {}
  
  public LyricsUriBox()
  {
    super("lrcu");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    lyricsUri = ByteBufferList.readString(paramByteBuffer);
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(lyricsUri));
    paramByteBuffer.put((byte)0);
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.convert(lyricsUri) + 5;
  }
  
  public String getLyricsUri()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return lyricsUri;
  }
  
  public void setLyricsUri(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    lyricsUri = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "LyricsUriBox[lyricsUri=");
    localStringBuilder.append(getLyricsUri());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
