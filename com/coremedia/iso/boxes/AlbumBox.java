package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import org.aspectj.lang.JoinPoint;

public class AlbumBox
  extends MimeMessage
{
  public static final String TYPE = "albm";
  public String albumTitle;
  public String language;
  public int trackNumber;
  
  static {}
  
  public AlbumBox()
  {
    super("albm");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    language = ByteBufferList.nextToken(paramByteBuffer);
    albumTitle = ByteBufferList.readString(paramByteBuffer);
    if (paramByteBuffer.remaining() > 0)
    {
      trackNumber = ByteBufferList.readUInt8(paramByteBuffer);
      return;
    }
    trackNumber = -1;
  }
  
  public String getAlbumTitle()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return albumTitle;
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.add(paramByteBuffer, language);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(albumTitle));
    paramByteBuffer.put((byte)0);
    int i = trackNumber;
    if (i != -1) {
      paramByteBuffer.put((byte)(i & 0xFF));
    }
  }
  
  public long getContentSize()
  {
    int j = f.slide.asm.ByteBuffer.convert(albumTitle);
    int i = 1;
    if (trackNumber == -1) {
      i = 0;
    }
    return j + 6 + 1 + i;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public int getTrackNumber()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return trackNumber;
  }
  
  public void setAlbumTitle(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    albumTitle = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    language = paramString;
  }
  
  public void setTrackNumber(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    trackNumber = paramInt;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AlbumBox[language=");
    ((StringBuilder)localObject).append(getLanguage());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("albumTitle=");
    ((StringBuilder)localObject).append(getAlbumTitle());
    if (trackNumber >= 0)
    {
      ((StringBuilder)localObject).append(";trackNumber=");
      ((StringBuilder)localObject).append(getTrackNumber());
    }
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
}
