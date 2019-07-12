package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class SampleDependencyTypeBox
  extends MimeMessage
{
  public static final String TYPE = "sdtp";
  public List<Entry> entries = new ArrayList();
  
  static {}
  
  public SampleDependencyTypeBox()
  {
    super("sdtp");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    for (;;)
    {
      if (paramByteBuffer.remaining() <= 0) {
        return;
      }
      entries.add(new Entry(ByteBufferList.readUInt8(paramByteBuffer)));
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
      paramByteBuffer.put((byte)(nextvalue & 0xFF));
    }
  }
  
  public long getContentSize()
  {
    return entries.size() + 4;
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
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SampleDependencyTypeBox");
    ((StringBuilder)localObject).append("{entries=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString((StringBuilder)localObject, entries, '}');
  }
  
  public static class Entry
  {
    public int value;
    
    public Entry(int paramInt)
    {
      value = paramInt;
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
        return value == value;
      }
      return false;
    }
    
    public int getReserved()
    {
      return value >> 6 & 0x3;
    }
    
    public int getSampleDependsOn()
    {
      return value >> 4 & 0x3;
    }
    
    public int getSampleHasRedundancy()
    {
      return value & 0x3;
    }
    
    public int getSampleIsDependentOn()
    {
      return value >> 2 & 0x3;
    }
    
    public int hashCode()
    {
      return value;
    }
    
    public void setReserved(int paramInt)
    {
      value = ((paramInt & 0x3) << 6 | value & 0x3F);
    }
    
    public void setSampleDependsOn(int paramInt)
    {
      value = ((paramInt & 0x3) << 4 | value & 0xCF);
    }
    
    public void setSampleHasRedundancy(int paramInt)
    {
      value = (paramInt & 0x3 | value & 0xFC);
    }
    
    public void setSampleIsDependentOn(int paramInt)
    {
      value = ((paramInt & 0x3) << 2 | value & 0xF3);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Entry{reserved=");
      localStringBuilder.append(getReserved());
      localStringBuilder.append(", sampleDependsOn=");
      localStringBuilder.append(getSampleDependsOn());
      localStringBuilder.append(", sampleIsDependentOn=");
      localStringBuilder.append(getSampleIsDependentOn());
      localStringBuilder.append(", sampleHasRedundancy=");
      localStringBuilder.append(getSampleHasRedundancy());
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
