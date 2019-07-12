package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class EditListBox
  extends MimeMessage
{
  public static final String TYPE = "elst";
  public List<Entry> entries = new LinkedList();
  
  static {}
  
  public EditListBox()
  {
    super("elst");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    int j = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    entries = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      entries.add(new Entry(this, paramByteBuffer));
      i += 1;
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
      ((Entry)localIterator.next()).getContent(paramByteBuffer);
    }
  }
  
  public long getContentSize()
  {
    int i;
    if (getVersion() == 1) {
      i = entries.size() * 20;
    } else {
      i = entries.size() * 12;
    }
    return i + 8L;
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
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "EditListBox{entries="), entries, '}');
  }
  
  public static class Entry
  {
    public EditListBox editListBox;
    public double mediaRate;
    public long mediaTime;
    public long segmentDuration;
    
    public Entry(EditListBox paramEditListBox, long paramLong1, long paramLong2, double paramDouble)
    {
      segmentDuration = paramLong1;
      mediaTime = paramLong2;
      mediaRate = paramDouble;
      editListBox = paramEditListBox;
    }
    
    public Entry(EditListBox paramEditListBox, ByteBuffer paramByteBuffer)
    {
      if (paramEditListBox.getVersion() == 1)
      {
        segmentDuration = ByteBufferList.readUInt64(paramByteBuffer);
        mediaTime = paramByteBuffer.getLong();
        mediaRate = ByteBufferList.update(paramByteBuffer);
      }
      else
      {
        segmentDuration = ByteBufferList.readUInt32(paramByteBuffer);
        mediaTime = paramByteBuffer.getInt();
        mediaRate = ByteBufferList.update(paramByteBuffer);
      }
      editListBox = paramEditListBox;
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
        if (mediaTime != mediaTime) {
          return false;
        }
        return segmentDuration == segmentDuration;
      }
      return false;
    }
    
    public void getContent(ByteBuffer paramByteBuffer)
    {
      if (editListBox.getVersion() == 1)
      {
        paramByteBuffer.putLong(segmentDuration);
        paramByteBuffer.putLong(mediaTime);
      }
      else
      {
        paramByteBuffer.putInt((int)c.a(segmentDuration));
        paramByteBuffer.putInt(c.a(mediaTime));
      }
      Label.put(paramByteBuffer, mediaRate);
    }
    
    public double getMediaRate()
    {
      return mediaRate;
    }
    
    public long getMediaTime()
    {
      return mediaTime;
    }
    
    public long getSegmentDuration()
    {
      return segmentDuration;
    }
    
    public int hashCode()
    {
      long l = segmentDuration;
      int i = (int)(l ^ l >>> 32);
      l = mediaTime;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public void setMediaRate(double paramDouble)
    {
      mediaRate = paramDouble;
    }
    
    public void setMediaTime(long paramLong)
    {
      mediaTime = paramLong;
    }
    
    public void setSegmentDuration(long paramLong)
    {
      segmentDuration = paramLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Entry{segmentDuration=");
      localStringBuilder.append(segmentDuration);
      localStringBuilder.append(", mediaTime=");
      localStringBuilder.append(mediaTime);
      localStringBuilder.append(", mediaRate=");
      localStringBuilder.append(mediaRate);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
