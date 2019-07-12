package com.coremedia.iso.boxes.fragment;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class TrackFragmentHeaderBox
  extends MimeMessage
{
  public static final String TYPE = "tfhd";
  public long baseDataOffset = -1L;
  public boolean defaultBaseIsMoof;
  public long defaultSampleDuration = -1L;
  public SampleFlags defaultSampleFlags;
  public long defaultSampleSize = -1L;
  public boolean durationIsEmpty;
  public long sampleDescriptionIndex;
  public long trackId;
  
  static {}
  
  public TrackFragmentHeaderBox()
  {
    super("tfhd");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    trackId = ByteBufferList.readUInt32(paramByteBuffer);
    if ((getFlags() & 0x1) == 1) {
      baseDataOffset = ByteBufferList.readUInt64(paramByteBuffer);
    }
    if ((getFlags() & 0x2) == 2) {
      sampleDescriptionIndex = ByteBufferList.readUInt32(paramByteBuffer);
    }
    if ((getFlags() & 0x8) == 8) {
      defaultSampleDuration = ByteBufferList.readUInt32(paramByteBuffer);
    }
    if ((getFlags() & 0x10) == 16) {
      defaultSampleSize = ByteBufferList.readUInt32(paramByteBuffer);
    }
    if ((getFlags() & 0x20) == 32) {
      defaultSampleFlags = new SampleFlags(paramByteBuffer);
    }
    if ((getFlags() & 0x10000) == 65536) {
      durationIsEmpty = true;
    }
    if ((getFlags() & 0x20000) == 131072) {
      defaultBaseIsMoof = true;
    }
  }
  
  public long getBaseDataOffset()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return baseDataOffset;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)trackId);
    if ((getFlags() & 0x1) == 1) {
      paramByteBuffer.putLong(getBaseDataOffset());
    }
    if ((getFlags() & 0x2) == 2) {
      paramByteBuffer.putInt((int)getSampleDescriptionIndex());
    }
    if ((getFlags() & 0x8) == 8) {
      paramByteBuffer.putInt((int)getDefaultSampleDuration());
    }
    if ((getFlags() & 0x10) == 16) {
      paramByteBuffer.putInt((int)getDefaultSampleSize());
    }
    if ((getFlags() & 0x20) == 32) {
      defaultSampleFlags.getContent(paramByteBuffer);
    }
  }
  
  public long getContentSize()
  {
    int i = getFlags();
    if ((i & 0x1) == 1) {
      l2 = 16L;
    } else {
      l2 = 8L;
    }
    long l1 = l2;
    if ((i & 0x2) == 2) {
      l1 = l2 + 4L;
    }
    long l2 = l1;
    if ((i & 0x8) == 8) {
      l2 = l1 + 4L;
    }
    l1 = l2;
    if ((i & 0x10) == 16) {
      l1 = l2 + 4L;
    }
    l2 = l1;
    if ((i & 0x20) == 32) {
      l2 = l1 + 4L;
    }
    return l2;
  }
  
  public long getDefaultSampleDuration()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleDuration;
  }
  
  public SampleFlags getDefaultSampleFlags()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleFlags;
  }
  
  public long getDefaultSampleSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultSampleSize;
  }
  
  public long getSampleDescriptionIndex()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return sampleDescriptionIndex;
  }
  
  public long getTrackId()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return trackId;
  }
  
  public boolean hasBaseDataOffset()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this), this) & 0x1) != 0;
  }
  
  public boolean hasDefaultSampleDuration()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), this) & 0x8) != 0;
  }
  
  public boolean hasDefaultSampleFlags()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this), this) & 0x20) != 0;
  }
  
  public boolean hasDefaultSampleSize()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this), this) & 0x10) != 0;
  }
  
  public boolean hasSampleDescriptionIndex()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this), this) & 0x2) != 0;
  }
  
  public boolean isDefaultBaseIsMoof()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_12, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return defaultBaseIsMoof;
  }
  
  public boolean isDurationIsEmpty()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return durationIsEmpty;
  }
  
  public void setBaseDataOffset(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_14, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramLong == -1L) {
      setFlags(getFlags() & 0x7FFFFFFE);
    } else {
      setFlags(getFlags() | 0x1);
    }
    baseDataOffset = paramLong;
  }
  
  public void setDefaultBaseIsMoof(boolean paramBoolean)
  {
    setFlags(f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_20, this, this, new Boolean(paramBoolean)), this) | 0x20000);
    defaultBaseIsMoof = paramBoolean;
  }
  
  public void setDefaultSampleDuration(long paramLong)
  {
    setFlags(f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_16, this, this, new Long(paramLong)), this) | 0x8);
    defaultSampleDuration = paramLong;
  }
  
  public void setDefaultSampleFlags(SampleFlags paramSampleFlags)
  {
    setFlags(f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_18, this, this, paramSampleFlags), this) | 0x20);
    defaultSampleFlags = paramSampleFlags;
  }
  
  public void setDefaultSampleSize(long paramLong)
  {
    setFlags(f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_17, this, this, new Long(paramLong)), this) | 0x10);
    defaultSampleSize = paramLong;
  }
  
  public void setDurationIsEmpty(boolean paramBoolean)
  {
    setFlags(f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_19, this, this, new Boolean(paramBoolean)), this) | 0x10000);
    durationIsEmpty = paramBoolean;
  }
  
  public void setSampleDescriptionIndex(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_15, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramLong == -1L) {
      setFlags(getFlags() & 0x7FFFFFFD);
    } else {
      setFlags(getFlags() | 0x2);
    }
    sampleDescriptionIndex = paramLong;
  }
  
  public void setTrackId(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_13, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    trackId = paramLong;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_21, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TrackFragmentHeaderBox");
    ((StringBuilder)localObject).append("{trackId=");
    ((StringBuilder)localObject).append(trackId);
    ((StringBuilder)localObject).append(", baseDataOffset=");
    ((StringBuilder)localObject).append(baseDataOffset);
    ((StringBuilder)localObject).append(", sampleDescriptionIndex=");
    ((StringBuilder)localObject).append(sampleDescriptionIndex);
    ((StringBuilder)localObject).append(", defaultSampleDuration=");
    ((StringBuilder)localObject).append(defaultSampleDuration);
    ((StringBuilder)localObject).append(", defaultSampleSize=");
    ((StringBuilder)localObject).append(defaultSampleSize);
    ((StringBuilder)localObject).append(", defaultSampleFlags=");
    ((StringBuilder)localObject).append(defaultSampleFlags);
    ((StringBuilder)localObject).append(", durationIsEmpty=");
    ((StringBuilder)localObject).append(durationIsEmpty);
    ((StringBuilder)localObject).append(", defaultBaseIsMoof=");
    ((StringBuilder)localObject).append(defaultBaseIsMoof);
    ((StringBuilder)localObject).append('}');
    return ((StringBuilder)localObject).toString();
  }
}
