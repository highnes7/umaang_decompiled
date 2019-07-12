package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class SubSampleInformationBox
  extends MimeMessage
{
  public static final String TYPE = "subs";
  public List<SampleEntry> entries = new ArrayList();
  public long entryCount;
  
  static {}
  
  public SubSampleInformationBox()
  {
    super("subs");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    entryCount = ByteBufferList.readUInt32(paramByteBuffer);
    int i = 0;
    if (i >= entryCount) {
      return;
    }
    SampleEntry localSampleEntry = new SampleEntry();
    localSampleEntry.setSampleDelta(ByteBufferList.readUInt32(paramByteBuffer));
    int k = ByteBufferList.get(paramByteBuffer);
    int j = 0;
    for (;;)
    {
      if (j >= k)
      {
        entries.add(localSampleEntry);
        i += 1;
        break;
      }
      SubSampleInformationBox.SampleEntry.SubsampleEntry localSubsampleEntry = new SubSampleInformationBox.SampleEntry.SubsampleEntry();
      long l;
      if (getVersion() == 1) {
        l = ByteBufferList.readUInt32(paramByteBuffer);
      } else {
        l = ByteBufferList.get(paramByteBuffer);
      }
      localSubsampleEntry.setSubsampleSize(l);
      localSubsampleEntry.setSubsamplePriority(ByteBufferList.readUInt8(paramByteBuffer));
      localSubsampleEntry.setDiscardable(ByteBufferList.readUInt8(paramByteBuffer));
      localSubsampleEntry.setReserved(ByteBufferList.readUInt32(paramByteBuffer));
      localSampleEntry.addSubsampleEntry(localSubsampleEntry);
      j += 1;
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)entries.size());
    Iterator localIterator = entries.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject = (SampleEntry)localIterator.next();
      paramByteBuffer.putInt((int)((SampleEntry)localObject).getSampleDelta());
      Label.append(paramByteBuffer, ((SampleEntry)localObject).getSubsampleCount());
      localObject = ((SampleEntry)localObject).getSubsampleEntries().iterator();
      while (((Iterator)localObject).hasNext())
      {
        SubSampleInformationBox.SampleEntry.SubsampleEntry localSubsampleEntry = (SubSampleInformationBox.SampleEntry.SubsampleEntry)((Iterator)localObject).next();
        if (getVersion() == 1) {
          paramByteBuffer.putInt((int)localSubsampleEntry.getSubsampleSize());
        } else {
          Label.append(paramByteBuffer, c.a(localSubsampleEntry.getSubsampleSize()));
        }
        paramByteBuffer.put((byte)(localSubsampleEntry.getSubsamplePriority() & 0xFF));
        paramByteBuffer.put((byte)(localSubsampleEntry.getDiscardable() & 0xFF));
        paramByteBuffer.putInt((int)localSubsampleEntry.getReserved());
      }
    }
  }
  
  public long getContentSize()
  {
    long l = entryCount;
    Iterator localIterator = entries.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return l * 6L + 8L + i;
      }
      int k = ((SampleEntry)localIterator.next()).getSubsampleCount();
      int j;
      if (getVersion() == 1) {
        j = 4;
      } else {
        j = 2;
      }
      i += (j + 1 + 1 + 4) * k;
    }
  }
  
  public List getEntries()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return entries;
  }
  
  public void setEntries(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    entries = paramList;
    entryCount = paramList.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "SubSampleInformationBox{entryCount=");
    localStringBuilder.append(entryCount);
    localStringBuilder.append(", entries=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(localStringBuilder, entries, '}');
  }
  
  public static class SampleEntry
  {
    public long sampleDelta;
    public int subsampleCount;
    public List<SubsampleEntry> subsampleEntries = new ArrayList();
    
    public SampleEntry() {}
    
    public void addSubsampleEntry(SubsampleEntry paramSubsampleEntry)
    {
      subsampleEntries.add(paramSubsampleEntry);
      subsampleCount += 1;
    }
    
    public long getSampleDelta()
    {
      return sampleDelta;
    }
    
    public int getSubsampleCount()
    {
      return subsampleCount;
    }
    
    public List getSubsampleEntries()
    {
      return subsampleEntries;
    }
    
    public void setSampleDelta(long paramLong)
    {
      sampleDelta = paramLong;
    }
    
    public void setSubsampleCount(int paramInt)
    {
      subsampleCount = paramInt;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("SampleEntry{sampleDelta=");
      localStringBuilder.append(sampleDelta);
      localStringBuilder.append(", subsampleCount=");
      localStringBuilder.append(subsampleCount);
      localStringBuilder.append(", subsampleEntries=");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(localStringBuilder, subsampleEntries, '}');
    }
    
    public static class SubsampleEntry
    {
      public int discardable;
      public long reserved;
      public int subsamplePriority;
      public long subsampleSize;
      
      public SubsampleEntry() {}
      
      public int getDiscardable()
      {
        return discardable;
      }
      
      public long getReserved()
      {
        return reserved;
      }
      
      public int getSubsamplePriority()
      {
        return subsamplePriority;
      }
      
      public long getSubsampleSize()
      {
        return subsampleSize;
      }
      
      public void setDiscardable(int paramInt)
      {
        discardable = paramInt;
      }
      
      public void setReserved(long paramLong)
      {
        reserved = paramLong;
      }
      
      public void setSubsamplePriority(int paramInt)
      {
        subsamplePriority = paramInt;
      }
      
      public void setSubsampleSize(long paramLong)
      {
        subsampleSize = paramLong;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("SubsampleEntry{subsampleSize=");
        localStringBuilder.append(subsampleSize);
        localStringBuilder.append(", subsamplePriority=");
        localStringBuilder.append(subsamplePriority);
        localStringBuilder.append(", discardable=");
        localStringBuilder.append(discardable);
        localStringBuilder.append(", reserved=");
        localStringBuilder.append(reserved);
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
    }
  }
}
