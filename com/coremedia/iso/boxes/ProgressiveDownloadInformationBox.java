package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class ProgressiveDownloadInformationBox
  extends MimeMessage
{
  public static final String TYPE = "pdin";
  public List<Entry> entries = Collections.emptyList();
  
  static {}
  
  public ProgressiveDownloadInformationBox()
  {
    super("pdin");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    entries = new LinkedList();
    for (;;)
    {
      if (paramByteBuffer.remaining() < 8) {
        return;
      }
      Entry localEntry = new Entry(ByteBufferList.readUInt32(paramByteBuffer), ByteBufferList.readUInt32(paramByteBuffer));
      entries.add(localEntry);
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Iterator localIterator = entries.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Entry localEntry = (Entry)localIterator.next();
      paramByteBuffer.putInt((int)localEntry.getRate());
      paramByteBuffer.putInt((int)localEntry.getInitialDelay());
    }
  }
  
  public long getContentSize()
  {
    return entries.size() * 8 + 4;
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
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "ProgressiveDownloadInfoBox{entries="), entries, '}');
  }
  
  public static class Entry
  {
    public long initialDelay;
    public long rate;
    
    public Entry(long paramLong1, long paramLong2)
    {
      rate = paramLong1;
      initialDelay = paramLong2;
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
        if (initialDelay != initialDelay) {
          return false;
        }
        return rate == rate;
      }
      return false;
    }
    
    public long getInitialDelay()
    {
      return initialDelay;
    }
    
    public long getRate()
    {
      return rate;
    }
    
    public int hashCode()
    {
      long l = rate;
      int i = (int)(l ^ l >>> 32);
      l = initialDelay;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public void setInitialDelay(long paramLong)
    {
      initialDelay = paramLong;
    }
    
    public void setRate(long paramLong)
    {
      rate = paramLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Entry{rate=");
      localStringBuilder.append(rate);
      localStringBuilder.append(", initialDelay=");
      localStringBuilder.append(initialDelay);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
