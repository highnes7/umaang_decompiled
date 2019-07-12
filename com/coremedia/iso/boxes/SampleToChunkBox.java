package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class SampleToChunkBox
  extends MimeMessage
{
  public static final String TYPE = "stsc";
  public List<Entry> entries = Collections.emptyList();
  
  static {}
  
  public SampleToChunkBox()
  {
    super("stsc");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    int j = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    entries = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      entries.add(new Entry(ByteBufferList.readUInt32(paramByteBuffer), ByteBufferList.readUInt32(paramByteBuffer), ByteBufferList.readUInt32(paramByteBuffer)));
      i += 1;
    }
  }
  
  public long[] blowup(int paramInt)
  {
    Object localObject1 = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject1);
    long[] arrayOfLong = new long[paramInt];
    localObject1 = new LinkedList(entries);
    Collections.reverse((List)localObject1);
    Iterator localIterator = ((List)localObject1).iterator();
    localObject1 = (Entry)localIterator.next();
    paramInt = arrayOfLong.length;
    for (;;)
    {
      if (paramInt <= 1)
      {
        arrayOfLong[0] = ((Entry)localObject1).getSamplesPerChunk();
        return arrayOfLong;
      }
      arrayOfLong[(paramInt - 1)] = ((Entry)localObject1).getSamplesPerChunk();
      Object localObject2 = localObject1;
      if (paramInt == ((Entry)localObject1).getFirstChunk()) {
        localObject2 = (Entry)localIterator.next();
      }
      paramInt -= 1;
      localObject1 = localObject2;
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
      Entry localEntry = (Entry)localIterator.next();
      paramByteBuffer.putInt((int)localEntry.getFirstChunk());
      paramByteBuffer.putInt((int)localEntry.getSamplesPerChunk());
      paramByteBuffer.putInt((int)localEntry.getSampleDescriptionIndex());
    }
  }
  
  public long getContentSize()
  {
    return entries.size() * 12 + 8;
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
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "SampleToChunkBox[entryCount=");
    localStringBuilder.append(entries.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class Entry
  {
    public long firstChunk;
    public long sampleDescriptionIndex;
    public long samplesPerChunk;
    
    public Entry(long paramLong1, long paramLong2, long paramLong3)
    {
      firstChunk = paramLong1;
      samplesPerChunk = paramLong2;
      sampleDescriptionIndex = paramLong3;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (Entry.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (Entry)paramObject;
        if (firstChunk != firstChunk) {
          return false;
        }
        if (sampleDescriptionIndex != sampleDescriptionIndex) {
          return false;
        }
        return samplesPerChunk == samplesPerChunk;
      }
      return false;
    }
    
    public long getFirstChunk()
    {
      return firstChunk;
    }
    
    public long getSampleDescriptionIndex()
    {
      return sampleDescriptionIndex;
    }
    
    public long getSamplesPerChunk()
    {
      return samplesPerChunk;
    }
    
    public int hashCode()
    {
      long l = firstChunk;
      int i = (int)(l ^ l >>> 32);
      l = samplesPerChunk;
      int j = (int)(l ^ l >>> 32);
      l = sampleDescriptionIndex;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public void setFirstChunk(long paramLong)
    {
      firstChunk = paramLong;
    }
    
    public void setSampleDescriptionIndex(long paramLong)
    {
      sampleDescriptionIndex = paramLong;
    }
    
    public void setSamplesPerChunk(long paramLong)
    {
      samplesPerChunk = paramLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Entry{firstChunk=");
      localStringBuilder.append(firstChunk);
      localStringBuilder.append(", samplesPerChunk=");
      localStringBuilder.append(samplesPerChunk);
      localStringBuilder.append(", sampleDescriptionIndex=");
      localStringBuilder.append(sampleDescriptionIndex);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
