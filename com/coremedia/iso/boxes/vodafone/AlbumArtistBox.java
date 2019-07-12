package com.coremedia.iso.boxes.vodafone;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import org.aspectj.lang.JoinPoint;

public class AlbumArtistBox
  extends MimeMessage
{
  public static final String TYPE = "albr";
  public String albumArtist;
  public String language;
  
  static {}
  
  public AlbumArtistBox()
  {
    super("albr");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    language = ByteBufferList.nextToken(paramByteBuffer);
    albumArtist = ByteBufferList.readString(paramByteBuffer);
  }
  
  public String getAlbumArtist()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return albumArtist;
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.add(paramByteBuffer, language);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(albumArtist));
    paramByteBuffer.put((byte)0);
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.convert(albumArtist) + 6 + 1;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public void setAlbumArtist(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    albumArtist = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    language = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this), "AlbumArtistBox[language=");
    localStringBuilder.append(getLanguage());
    localStringBuilder.append(";albumArtist=");
    localStringBuilder.append(getAlbumArtist());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
