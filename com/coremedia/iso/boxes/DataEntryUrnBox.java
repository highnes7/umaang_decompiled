package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import org.aspectj.lang.JoinPoint;

public class DataEntryUrnBox
  extends MimeMessage
{
  public static final String TYPE = "urn ";
  public String location;
  public String name;
  
  static {}
  
  public DataEntryUrnBox()
  {
    super("urn ");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    name = ByteBufferList.readString(paramByteBuffer);
    location = ByteBufferList.readString(paramByteBuffer);
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(name));
    paramByteBuffer.put((byte)0);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(location));
    paramByteBuffer.put((byte)0);
  }
  
  public long getContentSize()
  {
    int i = f.slide.asm.ByteBuffer.convert(name);
    return f.slide.asm.ByteBuffer.convert(location) + (i + 1) + 1;
  }
  
  public String getLocation()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return location;
  }
  
  public String getName()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return name;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "DataEntryUrlBox[name=");
    localStringBuilder.append(getName());
    localStringBuilder.append(";location=");
    localStringBuilder.append(getLocation());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
