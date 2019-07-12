package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import org.aspectj.lang.JoinPoint;

public class RatingBox
  extends MimeMessage
{
  public static final String TYPE = "rtng";
  public String language;
  public String ratingCriteria;
  public String ratingEntity;
  public String ratingInfo;
  
  static {}
  
  public RatingBox()
  {
    super("rtng");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    ratingEntity = ByteBufferList.read(paramByteBuffer);
    ratingCriteria = ByteBufferList.read(paramByteBuffer);
    language = ByteBufferList.nextToken(paramByteBuffer);
    ratingInfo = ByteBufferList.readString(paramByteBuffer);
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.put(Buffer.append(ratingEntity));
    paramByteBuffer.put(Buffer.append(ratingCriteria));
    Label.add(paramByteBuffer, language);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(ratingInfo));
    paramByteBuffer.put((byte)0);
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.convert(ratingInfo) + 15;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public String getRatingCriteria()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return ratingCriteria;
  }
  
  public String getRatingEntity()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return ratingEntity;
  }
  
  public String getRatingInfo()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return ratingInfo;
  }
  
  public void setLanguage(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    language = paramString;
  }
  
  public void setRatingCriteria(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    ratingCriteria = paramString;
  }
  
  public void setRatingEntity(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    ratingEntity = paramString;
  }
  
  public void setRatingInfo(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    ratingInfo = paramString;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RatingBox[language=");
    ((StringBuilder)localObject).append(getLanguage());
    ((StringBuilder)localObject).append("ratingEntity=");
    ((StringBuilder)localObject).append(getRatingEntity());
    ((StringBuilder)localObject).append(";ratingCriteria=");
    ((StringBuilder)localObject).append(getRatingCriteria());
    ((StringBuilder)localObject).append(";language=");
    ((StringBuilder)localObject).append(getLanguage());
    ((StringBuilder)localObject).append(";ratingInfo=");
    ((StringBuilder)localObject).append(getRatingInfo());
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
}
