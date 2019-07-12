package com.coremedia.iso.boxes.fragment;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class TrackRunBox
  extends MimeMessage
{
  public static final String TYPE = "trun";
  public int dataOffset;
  public List<Entry> entries = new ArrayList();
  public SampleFlags firstSampleFlags;
  
  static {}
  
  public TrackRunBox()
  {
    super("trun");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    long l = ByteBufferList.readUInt32(paramByteBuffer);
    if ((getFlags() & 0x1) == 1) {
      dataOffset = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    } else {
      dataOffset = -1;
    }
    if ((getFlags() & 0x4) == 4) {
      firstSampleFlags = new SampleFlags(paramByteBuffer);
    }
    int i = 0;
    for (;;)
    {
      if (i >= l) {
        return;
      }
      Entry localEntry = new Entry();
      if ((getFlags() & 0x100) == 256) {
        sampleDuration = ByteBufferList.readUInt32(paramByteBuffer);
      }
      if ((getFlags() & 0x200) == 512) {
        sampleSize = ByteBufferList.readUInt32(paramByteBuffer);
      }
      if ((getFlags() & 0x400) == 1024) {
        sampleFlags = new SampleFlags(paramByteBuffer);
      }
      if ((getFlags() & 0x800) == 2048) {
        if (getVersion() == 0) {
          sampleCompositionTimeOffset = ByteBufferList.readUInt32(paramByteBuffer);
        } else {
          sampleCompositionTimeOffset = paramByteBuffer.getInt();
        }
      }
      entries.add(localEntry);
      i += 1;
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)entries.size());
    int i = getFlags();
    if ((i & 0x1) == 1) {
      paramByteBuffer.putInt((int)dataOffset);
    }
    if ((i & 0x4) == 4) {
      firstSampleFlags.getContent(paramByteBuffer);
    }
    Iterator localIterator = entries.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Entry localEntry = (Entry)localIterator.next();
      if ((i & 0x100) == 256) {
        paramByteBuffer.putInt((int)sampleDuration);
      }
      if ((i & 0x200) == 512) {
        paramByteBuffer.putInt((int)sampleSize);
      }
      if ((i & 0x400) == 1024) {
        sampleFlags.getContent(paramByteBuffer);
      }
      if ((i & 0x800) == 2048) {
        if (getVersion() == 0) {
          paramByteBuffer.putInt((int)sampleCompositionTimeOffset);
        } else {
          paramByteBuffer.putInt((int)sampleCompositionTimeOffset);
        }
      }
    }
  }
  
  public long getContentSize()
  {
    int i = getFlags();
    if ((i & 0x1) == 1) {
      l1 = 12L;
    } else {
      l1 = 8L;
    }
    long l3 = l1;
    if ((i & 0x4) == 4) {
      l3 = l1 + 4L;
    }
    long l2 = 0L;
    if ((i & 0x100) == 256) {
      l2 = 4L;
    }
    long l1 = l2;
    if ((i & 0x200) == 512) {
      l1 = l2 + 4L;
    }
    l2 = l1;
    if ((i & 0x400) == 1024) {
      l2 = l1 + 4L;
    }
    l1 = l2;
    if ((i & 0x800) == 2048) {
      l1 = l2 + 4L;
    }
    return l1 * entries.size() + l3;
  }
  
  public int getDataOffset()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_15, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return dataOffset;
  }
  
  public List getEntries()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return entries;
  }
  
  public SampleFlags getFirstSampleFlags()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_16, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return firstSampleFlags;
  }
  
  public long[] getSampleCompositionTimeOffsets()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    if (isSampleCompositionTimeOffsetPresent())
    {
      localObject = new long[entries.size()];
      int i = 0;
      for (;;)
      {
        if (i >= localObject.length) {
          return localObject;
        }
        localObject[i] = ((Entry)entries.get(i)).getSampleCompositionTimeOffset();
        i += 1;
      }
    }
    return null;
  }
  
  public long getSampleCount()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return entries.size();
  }
  
  public boolean isDataOffsetPresent()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this), this) & 0x1) == 1;
  }
  
  public boolean isFirstSampleFlagsPresent()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this), this) & 0x4) == 4;
  }
  
  public boolean isSampleCompositionTimeOffsetPresent()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this), this) & 0x800) == 2048;
  }
  
  public boolean isSampleDurationPresent()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this), this) & 0x100) == 256;
  }
  
  public boolean isSampleFlagsPresent()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this), this) & 0x400) == 1024;
  }
  
  public boolean isSampleSizePresent()
  {
    return (f.sufficientlysecure.rootcommands.util.StringBuilder.addEntry(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this), this) & 0x200) == 512;
  }
  
  public void setDataOffset(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramInt == -1) {
      setFlags(getFlags() & 0xFFFFFE);
    } else {
      setFlags(getFlags() | 0x1);
    }
    dataOffset = paramInt;
  }
  
  public void setDataOffsetPresent(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x1);
      return;
    }
    setFlags(getFlags() & 0xFFFFFE);
  }
  
  public void setEntries(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_19, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    entries = paramList;
  }
  
  public void setFirstSampleFlags(SampleFlags paramSampleFlags)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_17, this, this, paramSampleFlags);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramSampleFlags == null) {
      setFlags(getFlags() & 0xFFFFFB);
    } else {
      setFlags(getFlags() | 0x4);
    }
    firstSampleFlags = paramSampleFlags;
  }
  
  public void setSampleCompositionTimeOffsetPresent(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_14, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x800);
      return;
    }
    setFlags(getFlags() & 0xFFF7FF);
  }
  
  public void setSampleDurationPresent(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_12, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x100);
      return;
    }
    setFlags(getFlags() & 0xFFFEFF);
  }
  
  public void setSampleFlagsPresent(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_13, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x400);
      return;
    }
    setFlags(getFlags() & 0xFFFBFF);
  }
  
  public void setSampleSizePresent(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    if (paramBoolean)
    {
      setFlags(getFlags() | 0x200);
      return;
    }
    setFlags(getFlags() & 0xFFFDFF);
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_18, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TrackRunBox");
    ((StringBuilder)localObject).append("{sampleCount=");
    ((StringBuilder)localObject).append(entries.size());
    ((StringBuilder)localObject).append(", dataOffset=");
    ((StringBuilder)localObject).append(dataOffset);
    ((StringBuilder)localObject).append(", dataOffsetPresent=");
    ((StringBuilder)localObject).append(isDataOffsetPresent());
    ((StringBuilder)localObject).append(", sampleSizePresent=");
    ((StringBuilder)localObject).append(isSampleSizePresent());
    ((StringBuilder)localObject).append(", sampleDurationPresent=");
    ((StringBuilder)localObject).append(isSampleDurationPresent());
    ((StringBuilder)localObject).append(", sampleFlagsPresentPresent=");
    ((StringBuilder)localObject).append(isSampleFlagsPresent());
    ((StringBuilder)localObject).append(", sampleCompositionTimeOffsetPresent=");
    ((StringBuilder)localObject).append(isSampleCompositionTimeOffsetPresent());
    ((StringBuilder)localObject).append(", firstSampleFlags=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString((StringBuilder)localObject, firstSampleFlags, '}');
  }
  
  public static class Entry
  {
    public long sampleCompositionTimeOffset;
    public long sampleDuration;
    public SampleFlags sampleFlags;
    public long sampleSize;
    
    public Entry() {}
    
    public Entry(long paramLong1, long paramLong2, SampleFlags paramSampleFlags, int paramInt)
    {
      sampleDuration = paramLong1;
      sampleSize = paramLong2;
      sampleFlags = paramSampleFlags;
      sampleCompositionTimeOffset = paramInt;
    }
    
    public long getSampleCompositionTimeOffset()
    {
      return sampleCompositionTimeOffset;
    }
    
    public long getSampleDuration()
    {
      return sampleDuration;
    }
    
    public SampleFlags getSampleFlags()
    {
      return sampleFlags;
    }
    
    public long getSampleSize()
    {
      return sampleSize;
    }
    
    public void setSampleCompositionTimeOffset(int paramInt)
    {
      sampleCompositionTimeOffset = paramInt;
    }
    
    public void setSampleDuration(long paramLong)
    {
      sampleDuration = paramLong;
    }
    
    public void setSampleFlags(SampleFlags paramSampleFlags)
    {
      sampleFlags = paramSampleFlags;
    }
    
    public void setSampleSize(long paramLong)
    {
      sampleSize = paramLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Entry{sampleDuration=");
      localStringBuilder.append(sampleDuration);
      localStringBuilder.append(", sampleSize=");
      localStringBuilder.append(sampleSize);
      localStringBuilder.append(", sampleFlags=");
      localStringBuilder.append(sampleFlags);
      localStringBuilder.append(", sampleCompositionTimeOffset=");
      localStringBuilder.append(sampleCompositionTimeOffset);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
