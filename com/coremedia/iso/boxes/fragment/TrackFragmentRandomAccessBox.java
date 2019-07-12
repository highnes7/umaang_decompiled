package com.coremedia.iso.boxes.fragment;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.ByteVector;
import f.slide.asm.Request;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class TrackFragmentRandomAccessBox
  extends MimeMessage
{
  public static final String TYPE = "tfra";
  public List<Entry> entries = Collections.emptyList();
  public int lengthSizeOfSampleNum = 2;
  public int lengthSizeOfTrafNum = 2;
  public int lengthSizeOfTrunNum = 2;
  public int reserved;
  public long trackId;
  
  static {}
  
  public TrackFragmentRandomAccessBox()
  {
    super("tfra");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    trackId = ByteBufferList.readUInt32(paramByteBuffer);
    long l = ByteBufferList.readUInt32(paramByteBuffer);
    reserved = ((int)(l >> 6));
    lengthSizeOfTrafNum = (((int)(0x3F & l) >> 4) + 1);
    lengthSizeOfTrunNum = (((int)(0xC & l) >> 2) + 1);
    lengthSizeOfSampleNum = ((int)(l & 0x3) + 1);
    l = ByteBufferList.readUInt32(paramByteBuffer);
    entries = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i >= l) {
        return;
      }
      Entry localEntry = new Entry();
      if (getVersion() == 1)
      {
        time = ByteBufferList.readUInt64(paramByteBuffer);
        moofOffset = ByteBufferList.readUInt64(paramByteBuffer);
      }
      else
      {
        time = ByteBufferList.readUInt32(paramByteBuffer);
        moofOffset = ByteBufferList.readUInt32(paramByteBuffer);
      }
      trafNumber = ByteVector.read(paramByteBuffer, lengthSizeOfTrafNum);
      trunNumber = ByteVector.read(paramByteBuffer, lengthSizeOfTrunNum);
      sampleNumber = ByteVector.read(paramByteBuffer, lengthSizeOfSampleNum);
      entries.add(localEntry);
      i += 1;
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)trackId);
    paramByteBuffer.putInt((int)(reserved << 6 | (lengthSizeOfTrafNum - 1 & 0x3) << 4 | (lengthSizeOfTrunNum - 1 & 0x3) << 2 | lengthSizeOfSampleNum - 1 & 0x3));
    paramByteBuffer.putInt((int)entries.size());
    Iterator localIterator = entries.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Entry localEntry = (Entry)localIterator.next();
      if (getVersion() == 1)
      {
        paramByteBuffer.putLong(time);
        paramByteBuffer.putLong(moofOffset);
      }
      else
      {
        paramByteBuffer.putInt((int)time);
        paramByteBuffer.putInt((int)moofOffset);
      }
      Request.write(trafNumber, paramByteBuffer, lengthSizeOfTrafNum);
      Request.write(trunNumber, paramByteBuffer, lengthSizeOfTrunNum);
      Request.write(sampleNumber, paramByteBuffer, lengthSizeOfSampleNum);
    }
  }
  
  public long getContentSize()
  {
    if (getVersion() == 1) {
      i = entries.size() * 16;
    } else {
      i = entries.size() * 8;
    }
    long l1 = i;
    int i = lengthSizeOfTrafNum;
    long l2 = entries.size() * i;
    i = lengthSizeOfTrunNum;
    long l3 = entries.size() * i;
    i = lengthSizeOfSampleNum;
    return 16L + l1 + l2 + l3 + entries.size() * i;
  }
  
  public List getEntries()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return Collections.unmodifiableList(entries);
  }
  
  public int getLengthSizeOfSampleNum()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return lengthSizeOfSampleNum;
  }
  
  public int getLengthSizeOfTrafNum()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return lengthSizeOfTrafNum;
  }
  
  public int getLengthSizeOfTrunNum()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return lengthSizeOfTrunNum;
  }
  
  public long getNumberOfEntries()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return entries.size();
  }
  
  public int getReserved()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return reserved;
  }
  
  public long getTrackId()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return trackId;
  }
  
  public void setEntries(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    entries = paramList;
  }
  
  public void setLengthSizeOfSampleNum(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    lengthSizeOfSampleNum = paramInt;
  }
  
  public void setLengthSizeOfTrafNum(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    lengthSizeOfTrafNum = paramInt;
  }
  
  public void setLengthSizeOfTrunNum(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    lengthSizeOfTrunNum = paramInt;
  }
  
  public void setTrackId(long paramLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this, new Long(paramLong));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    trackId = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_12, this, this), "TrackFragmentRandomAccessBox{trackId=");
    localStringBuilder.append(trackId);
    localStringBuilder.append(", entries=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(localStringBuilder, entries, '}');
  }
  
  public static class Entry
  {
    public long moofOffset;
    public long sampleNumber;
    public long time;
    public long trafNumber;
    public long trunNumber;
    
    public Entry() {}
    
    public Entry(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      moofOffset = paramLong2;
      sampleNumber = paramLong5;
      time = paramLong1;
      trafNumber = paramLong3;
      trunNumber = paramLong4;
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
        if (moofOffset != moofOffset) {
          return false;
        }
        if (sampleNumber != sampleNumber) {
          return false;
        }
        if (time != time) {
          return false;
        }
        if (trafNumber != trafNumber) {
          return false;
        }
        return trunNumber == trunNumber;
      }
      return false;
    }
    
    public long getMoofOffset()
    {
      return moofOffset;
    }
    
    public long getSampleNumber()
    {
      return sampleNumber;
    }
    
    public long getTime()
    {
      return time;
    }
    
    public long getTrafNumber()
    {
      return trafNumber;
    }
    
    public long getTrunNumber()
    {
      return trunNumber;
    }
    
    public int hashCode()
    {
      long l = time;
      int i = (int)(l ^ l >>> 32);
      l = moofOffset;
      int j = (int)(l ^ l >>> 32);
      l = trafNumber;
      int k = (int)(l ^ l >>> 32);
      l = trunNumber;
      int m = (int)(l ^ l >>> 32);
      l = sampleNumber;
      return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l ^ l >>> 32);
    }
    
    public void setMoofOffset(long paramLong)
    {
      moofOffset = paramLong;
    }
    
    public void setSampleNumber(long paramLong)
    {
      sampleNumber = paramLong;
    }
    
    public void setTime(long paramLong)
    {
      time = paramLong;
    }
    
    public void setTrafNumber(long paramLong)
    {
      trafNumber = paramLong;
    }
    
    public void setTrunNumber(long paramLong)
    {
      trunNumber = paramLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Entry{time=");
      localStringBuilder.append(time);
      localStringBuilder.append(", moofOffset=");
      localStringBuilder.append(moofOffset);
      localStringBuilder.append(", trafNumber=");
      localStringBuilder.append(trafNumber);
      localStringBuilder.append(", trunNumber=");
      localStringBuilder.append(trunNumber);
      localStringBuilder.append(", sampleNumber=");
      localStringBuilder.append(sampleNumber);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
