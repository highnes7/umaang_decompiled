package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.e;
import f.h.a.g.l;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;

public class TrackHeaderBox
  extends MimeMessage
{
  public static final String TYPE = "tkhd";
  public int alternateGroup;
  public Date creationTime;
  public long duration;
  public double height;
  public int layer;
  public l matrix = l.a;
  public Date modificationTime;
  public long trackId;
  public float volume;
  public double width;
  
  static {}
  
  public TrackHeaderBox()
  {
    super("tkhd");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    if (getVersion() == 1)
    {
      creationTime = e.a(ByteBufferList.readUInt64(paramByteBuffer));
      modificationTime = e.a(ByteBufferList.readUInt64(paramByteBuffer));
      trackId = ByteBufferList.readUInt32(paramByteBuffer);
      ByteBufferList.readUInt32(paramByteBuffer);
      duration = ByteBufferList.readUInt64(paramByteBuffer);
    }
    else
    {
      creationTime = e.a(ByteBufferList.readUInt32(paramByteBuffer));
      modificationTime = e.a(ByteBufferList.readUInt32(paramByteBuffer));
      trackId = ByteBufferList.readUInt32(paramByteBuffer);
      ByteBufferList.readUInt32(paramByteBuffer);
      duration = ByteBufferList.readUInt32(paramByteBuffer);
    }
    ByteBufferList.readUInt32(paramByteBuffer);
    ByteBufferList.readUInt32(paramByteBuffer);
    layer = ByteBufferList.get(paramByteBuffer);
    alternateGroup = ByteBufferList.get(paramByteBuffer);
    volume = ByteBufferList.add(paramByteBuffer);
    ByteBufferList.get(paramByteBuffer);
    matrix = l.a(paramByteBuffer);
    width = ByteBufferList.update(paramByteBuffer);
    height = ByteBufferList.update(paramByteBuffer);
  }
  
  public int getAlternateGroup()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return alternateGroup;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this, paramByteBuffer);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    writeVersionAndFlags(paramByteBuffer);
    if (getVersion() == 1)
    {
      paramByteBuffer.putLong(e.a(creationTime));
      paramByteBuffer.putLong(e.a(modificationTime));
      paramByteBuffer.putInt((int)trackId);
      paramByteBuffer.putInt((int)0L);
      paramByteBuffer.putLong(duration);
    }
    else
    {
      paramByteBuffer.putInt((int)e.a(creationTime));
      paramByteBuffer.putInt((int)e.a(modificationTime));
      paramByteBuffer.putInt((int)trackId);
      paramByteBuffer.putInt((int)0L);
      paramByteBuffer.putInt((int)duration);
    }
    int i = (int)0L;
    paramByteBuffer.putInt(i);
    paramByteBuffer.putInt(i);
    Label.append(paramByteBuffer, layer);
    Label.append(paramByteBuffer, alternateGroup);
    Label.write(paramByteBuffer, volume);
    Label.append(paramByteBuffer, 0);
    matrix.b(paramByteBuffer);
    Label.put(paramByteBuffer, width);
    Label.put(paramByteBuffer, height);
  }
  
  public long getContentSize()
  {
    long l;
    if (getVersion() == 1) {
      l = 36L;
    } else {
      l = 24L;
    }
    return l + 60L;
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
  
  public double getHeight()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return height;
  }
  
  public int getLayer()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return layer;
  }
  
  public l getMatrix()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return matrix;
  }
  
  public Date getModificationTime()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return modificationTime;
  }
  
  public long getTrackId()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return trackId;
  }
  
  public float getVolume()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return volume;
  }
  
  public double getWidth()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return width;
  }
  
  public boolean isEnabled()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_22, this, this), this) & 0x1) > 0;
  }
  
  public boolean isInMovie()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_23, this, this), this) & 0x2) > 0;
  }
  
  public boolean isInPoster()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_25, this, this), this) & 0x8) > 0;
  }
  
  public boolean isInPreview()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_24, this, this), this) & 0x4) > 0;
  }
  
  public void setAlternateGroup(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_17, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    alternateGroup = paramInt;
  }
  
  public void setCreationTime(Date paramDate)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_12, this, this, paramDate);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    creationTime = paramDate;
    if (paramDate.getTime() / 1000L + 2082844800L >= 4294967296L) {
      setVersion(1);
    }
  }
  
  public void setDuration(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_15, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    duration = paramLong;
    if (paramLong >= 4294967296L) {
      setFlags(1);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_26, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x1);
      return;
    }
    setFlags(getFlags() & 0xFFFFFFFE);
  }
  
  public void setHeight(double paramDouble)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_21, this, this, new Double(paramDouble));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    height = paramDouble;
  }
  
  public void setInMovie(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_27, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x2);
      return;
    }
    setFlags(getFlags() & 0xFFFFFFFD);
  }
  
  public void setInPoster(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_29, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x8);
      return;
    }
    setFlags(getFlags() & 0xFFFFFFF7);
  }
  
  public void setInPreview(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_28, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x4);
      return;
    }
    setFlags(getFlags() & 0xFFFFFFFB);
  }
  
  public void setLayer(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_16, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    layer = paramInt;
  }
  
  public void setMatrix(l paramL)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_19, this, this, paramL);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    matrix = paramL;
  }
  
  public void setModificationTime(Date paramDate)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_13, this, this, paramDate);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    modificationTime = paramDate;
    if (paramDate.getTime() / 1000L + 2082844800L >= 4294967296L) {
      setVersion(1);
    }
  }
  
  public void setTrackId(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_14, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    trackId = paramLong;
  }
  
  public void setVolume(float paramFloat)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_18, this, this, new Float(paramFloat));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    volume = paramFloat;
  }
  
  public void setWidth(double paramDouble)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_20, this, this, new Double(paramDouble));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    width = paramDouble;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TrackHeaderBox[");
    ((StringBuilder)localObject).append("creationTime=");
    ((StringBuilder)localObject).append(getCreationTime());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("modificationTime=");
    ((StringBuilder)localObject).append(getModificationTime());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("trackId=");
    ((StringBuilder)localObject).append(getTrackId());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("duration=");
    ((StringBuilder)localObject).append(getDuration());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("layer=");
    ((StringBuilder)localObject).append(getLayer());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("alternateGroup=");
    ((StringBuilder)localObject).append(getAlternateGroup());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("volume=");
    ((StringBuilder)localObject).append(getVolume());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("matrix=");
    ((StringBuilder)localObject).append(matrix);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("width=");
    ((StringBuilder)localObject).append(getWidth());
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append("height=");
    ((StringBuilder)localObject).append(getHeight());
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
}
