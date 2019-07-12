package com.coremedia.iso.boxes;

import f.h.a.Message;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class FileTypeBox
  extends Message
{
  public static final String TYPE = "ftyp";
  public List<String> compatibleBrands = Collections.emptyList();
  public String majorBrand;
  public long minorVersion;
  
  static {}
  
  public FileTypeBox()
  {
    super("ftyp");
  }
  
  public FileTypeBox(String paramString, long paramLong, List paramList)
  {
    super("ftyp");
    majorBrand = paramString;
    minorVersion = paramLong;
    compatibleBrands = paramList;
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    majorBrand = ByteBufferList.read(paramByteBuffer);
    minorVersion = ByteBufferList.readUInt32(paramByteBuffer);
    int j = paramByteBuffer.remaining() / 4;
    compatibleBrands = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      compatibleBrands.add(ByteBufferList.read(paramByteBuffer));
      i += 1;
    }
  }
  
  public List getCompatibleBrands()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return compatibleBrands;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(Buffer.append(majorBrand));
    paramByteBuffer.putInt((int)minorVersion);
    Iterator localIterator = compatibleBrands.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      paramByteBuffer.put(Buffer.append((String)localIterator.next()));
    }
  }
  
  public long getContentSize()
  {
    return compatibleBrands.size() * 4 + 8;
  }
  
  public String getMajorBrand()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return majorBrand;
  }
  
  public long getMinorVersion()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return minorVersion;
  }
  
  public void setCompatibleBrands(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    compatibleBrands = paramList;
  }
  
  public void setMajorBrand(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    majorBrand = paramString;
  }
  
  public void setMinorVersion(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    minorVersion = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("FileTypeBox[", "majorBrand=");
    localStringBuilder.append(getMajorBrand());
    localStringBuilder.append(";");
    localStringBuilder.append("minorVersion=");
    localStringBuilder.append(getMinorVersion());
    Iterator localIterator = compatibleBrands.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.write(localStringBuilder, ";", "compatibleBrand=", (String)localIterator.next());
    }
  }
}
