package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.e;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;

public class MediaHeaderBox
  extends MimeMessage
{
  public static final String TYPE = "mdhd";
  public Date creationTime = new Date();
  public long duration;
  public String language = "eng";
  public Date modificationTime = new Date();
  public long timescale;
  
  static {}
  
  public MediaHeaderBox()
  {
    super("mdhd");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    if (getVersion() == 1)
    {
      creationTime = e.a(ByteBufferList.readUInt64(paramByteBuffer));
      modificationTime = e.a(ByteBufferList.readUInt64(paramByteBuffer));
      timescale = ByteBufferList.readUInt32(paramByteBuffer);
      duration = ByteBufferList.readUInt64(paramByteBuffer);
    }
    else
    {
      creationTime = e.a(ByteBufferList.readUInt32(paramByteBuffer));
      modificationTime = e.a(ByteBufferList.readUInt32(paramByteBuffer));
      timescale = ByteBufferList.readUInt32(paramByteBuffer);
      duration = ByteBufferList.readUInt32(paramByteBuffer);
    }
    language = ByteBufferList.nextToken(paramByteBuffer);
    ByteBufferList.get(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    if (getVersion() == 1)
    {
      paramByteBuffer.putLong(e.a(creationTime));
      paramByteBuffer.putLong(e.a(modificationTime));
      paramByteBuffer.putInt((int)timescale);
      paramByteBuffer.putLong(duration);
    }
    else
    {
      paramByteBuffer.putInt((int)e.a(creationTime));
      paramByteBuffer.putInt((int)e.a(modificationTime));
      paramByteBuffer.putInt((int)timescale);
      paramByteBuffer.putInt((int)duration);
    }
    Label.add(paramByteBuffer, language);
    Label.append(paramByteBuffer, 0);
  }
  
  public long getContentSize()
  {
    long l;
    if (getVersion() == 1) {
      l = 32L;
    } else {
      l = 20L;
    }
    return l + 2L + 2L;
  }
  
  public Date getCreationTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return creationTime;
  }
  
  public long getDuration()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return duration;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public Date getModificationTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return modificationTime;
  }
  
  public long getTimescale()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return timescale;
  }
  
  public void setCreationTime(Date paramDate)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, paramDate);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    creationTime = paramDate;
  }
  
  public void setDuration(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    duration = paramLong;
  }
  
  public void setLanguage(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    language = paramString;
  }
  
  public void setModificationTime(Date paramDate)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this, paramDate);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    modificationTime = paramDate;
  }
  
  public void setTimescale(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    timescale = paramLong;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MediaHeaderBox[");
    ((StringBuilder)localObject).append("creationTime=");
    ((StringBuilder)localObject).append(getCreationTime());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("modificationTime=");
    ((StringBuilder)localObject).append(getModificationTime());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("timescale=");
    ((StringBuilder)localObject).append(getTimescale());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("duration=");
    ((StringBuilder)localObject).append(getDuration());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("language=");
    ((StringBuilder)localObject).append(getLanguage());
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
}
