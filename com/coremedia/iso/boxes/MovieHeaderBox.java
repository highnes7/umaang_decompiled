package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.e;
import f.h.a.g.l;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;

public class MovieHeaderBox
  extends MimeMessage
{
  public static final String TYPE = "mvhd";
  public Date creationTime;
  public int currentTime;
  public long duration;
  public l matrix = l.a;
  public Date modificationTime;
  public long nextTrackId;
  public int posterTime;
  public int previewDuration;
  public int previewTime;
  public double rate = 1.0D;
  public int selectionDuration;
  public int selectionTime;
  public long timescale;
  public float volume = 1.0F;
  
  static {}
  
  public MovieHeaderBox()
  {
    super("mvhd");
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
    rate = ByteBufferList.update(paramByteBuffer);
    volume = ByteBufferList.add(paramByteBuffer);
    ByteBufferList.get(paramByteBuffer);
    ByteBufferList.readUInt32(paramByteBuffer);
    ByteBufferList.readUInt32(paramByteBuffer);
    matrix = l.a(paramByteBuffer);
    previewTime = paramByteBuffer.getInt();
    previewDuration = paramByteBuffer.getInt();
    posterTime = paramByteBuffer.getInt();
    selectionTime = paramByteBuffer.getInt();
    selectionDuration = paramByteBuffer.getInt();
    currentTime = paramByteBuffer.getInt();
    nextTrackId = ByteBufferList.readUInt32(paramByteBuffer);
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
    Label.put(paramByteBuffer, rate);
    Label.write(paramByteBuffer, volume);
    Label.append(paramByteBuffer, 0);
    int i = (int)0L;
    paramByteBuffer.putInt(i);
    paramByteBuffer.putInt(i);
    matrix.b(paramByteBuffer);
    paramByteBuffer.putInt(previewTime);
    paramByteBuffer.putInt(previewDuration);
    paramByteBuffer.putInt(posterTime);
    paramByteBuffer.putInt(selectionTime);
    paramByteBuffer.putInt(selectionDuration);
    paramByteBuffer.putInt(currentTime);
    paramByteBuffer.putInt((int)nextTrackId);
  }
  
  public long getContentSize()
  {
    long l;
    if (getVersion() == 1) {
      l = 32L;
    } else {
      l = 20L;
    }
    return l + 80L;
  }
  
  public Date getCreationTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return creationTime;
  }
  
  public int getCurrentTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_27, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return currentTime;
  }
  
  public long getDuration()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return duration;
  }
  
  public l getMatrix()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return matrix;
  }
  
  public Date getModificationTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return modificationTime;
  }
  
  public long getNextTrackId()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return nextTrackId;
  }
  
  public int getPosterTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_21, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return posterTime;
  }
  
  public int getPreviewDuration()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_19, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return previewDuration;
  }
  
  public int getPreviewTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_17, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return previewTime;
  }
  
  public double getRate()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return rate;
  }
  
  public int getSelectionDuration()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_25, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return selectionDuration;
  }
  
  public int getSelectionTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_23, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return selectionTime;
  }
  
  public long getTimescale()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return timescale;
  }
  
  public float getVolume()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return volume;
  }
  
  public void setCreationTime(Date paramDate)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, paramDate);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    creationTime = paramDate;
    if (paramDate.getTime() / 1000L + 2082844800L >= 4294967296L) {
      setVersion(1);
    }
  }
  
  public void setCurrentTime(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_28, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    currentTime = paramInt;
  }
  
  public void setDuration(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_12, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    duration = paramLong;
    if (paramLong >= 4294967296L) {
      setVersion(1);
    }
  }
  
  public void setMatrix(l paramL)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_15, this, this, paramL);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    matrix = paramL;
  }
  
  public void setModificationTime(Date paramDate)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this, paramDate);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    modificationTime = paramDate;
    if (paramDate.getTime() / 1000L + 2082844800L >= 4294967296L) {
      setVersion(1);
    }
  }
  
  public void setNextTrackId(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_16, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    nextTrackId = paramLong;
  }
  
  public void setPosterTime(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_22, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    posterTime = paramInt;
  }
  
  public void setPreviewDuration(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_20, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    previewDuration = paramInt;
  }
  
  public void setPreviewTime(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_18, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    previewTime = paramInt;
  }
  
  public void setRate(double paramDouble)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_13, this, this, new Double(paramDouble));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    rate = paramDouble;
  }
  
  public void setSelectionDuration(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_26, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    selectionDuration = paramInt;
  }
  
  public void setSelectionTime(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_24, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    selectionTime = paramInt;
  }
  
  public void setTimescale(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    timescale = paramLong;
  }
  
  public void setVolume(float paramFloat)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_14, this, this, new Float(paramFloat));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    volume = paramFloat;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MovieHeaderBox[");
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
    ((StringBuilder)localObject).append("rate=");
    ((StringBuilder)localObject).append(getRate());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("volume=");
    ((StringBuilder)localObject).append(getVolume());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("matrix=");
    ((StringBuilder)localObject).append(matrix);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("nextTrackId=");
    ((StringBuilder)localObject).append(getNextTrackId());
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
}
