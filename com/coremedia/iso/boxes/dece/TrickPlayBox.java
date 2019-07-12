package com.coremedia.iso.boxes.dece;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class TrickPlayBox
  extends MimeMessage
{
  public static final String TYPE = "trik";
  public List<Entry> entries = new ArrayList();
  
  static {}
  
  public TrickPlayBox()
  {
    super("trik");
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
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return entries;
  }
  
  public void setEntries(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    entries = paramList;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TrickPlayBox");
    ((StringBuilder)localObject).append("{entries=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString((StringBuilder)localObject, entries, '}');
  }
  
  public static class Entry
  {
    public int value;
    
    public Entry() {}
    
    public Entry(int paramInt)
    {
      value = paramInt;
    }
    
    public int getDependencyLevel()
    {
      return value & 0x3F;
    }
    
    public int getPicType()
    {
      return value >> 6 & 0x3;
    }
    
    public void setDependencyLevel(int paramInt)
    {
      value = (paramInt & 0x3F | value);
    }
    
    public void setPicType(int paramInt)
    {
      value &= 0x1F;
      value = ((paramInt & 0x3) << 6 | value);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Entry", "{picType=");
      localStringBuilder.append(getPicType());
      localStringBuilder.append(",dependencyLevel=");
      localStringBuilder.append(getDependencyLevel());
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
