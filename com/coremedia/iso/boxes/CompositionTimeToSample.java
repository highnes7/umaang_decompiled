package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class CompositionTimeToSample
  extends MimeMessage
{
  public static final String TYPE = "ctts";
  public List<Entry> entries = Collections.emptyList();
  
  static {}
  
  public CompositionTimeToSample()
  {
    super("ctts");
  }
  
  public static int[] blowupCompositionTimes(List paramList)
  {
    Object localObject = paramList.iterator();
    for (long l = 0L;; l += ((Entry)((Iterator)localObject).next()).getCount()) {
      if (!((Iterator)localObject).hasNext())
      {
        localObject = new int[(int)l];
        paramList = paramList.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramList.hasNext()) {
            return localObject;
          }
          Entry localEntry = (Entry)paramList.next();
          int j = 0;
          while (j < localEntry.getCount())
          {
            localObject[i] = localEntry.getOffset();
            j += 1;
            i += 1;
          }
        }
      }
    }
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
      Entry localEntry = new Entry(c.a(ByteBufferList.readUInt32(paramByteBuffer)), paramByteBuffer.getInt());
      entries.add(localEntry);
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
      Entry localEntry = (Entry)localIterator.next();
      paramByteBuffer.putInt((int)localEntry.getCount());
      paramByteBuffer.putInt(localEntry.getOffset());
    }
  }
  
  public long getContentSize()
  {
    return entries.size() * 8 + 8;
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
  
  public static class Entry
  {
    public int count;
    public int offset;
    
    public Entry(int paramInt1, int paramInt2)
    {
      count = paramInt1;
      offset = paramInt2;
    }
    
    public int getCount()
    {
      return count;
    }
    
    public int getOffset()
    {
      return offset;
    }
    
    public void setCount(int paramInt)
    {
      count = paramInt;
    }
    
    public void setOffset(int paramInt)
    {
      offset = paramInt;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Entry{count=");
      localStringBuilder.append(count);
      localStringBuilder.append(", offset=");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, offset, '}');
    }
  }
}
