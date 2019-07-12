package com.coremedia.iso.boxes.threegpp26244;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import org.aspectj.lang.JoinPoint;

public class LocationInformationBox
  extends MimeMessage
{
  public static final String TYPE = "loci";
  public String additionalNotes = "";
  public double altitude;
  public String astronomicalBody = "";
  public String language;
  public double latitude;
  public double longitude;
  public String name = "";
  public int role;
  
  static {}
  
  public LocationInformationBox()
  {
    super("loci");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    language = ByteBufferList.nextToken(paramByteBuffer);
    name = ByteBufferList.readString(paramByteBuffer);
    role = ByteBufferList.readUInt8(paramByteBuffer);
    longitude = ByteBufferList.update(paramByteBuffer);
    latitude = ByteBufferList.update(paramByteBuffer);
    altitude = ByteBufferList.update(paramByteBuffer);
    astronomicalBody = ByteBufferList.readString(paramByteBuffer);
    additionalNotes = ByteBufferList.readString(paramByteBuffer);
  }
  
  public String getAdditionalNotes()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_14, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return additionalNotes;
  }
  
  public double getAltitude()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return altitude;
  }
  
  public String getAstronomicalBody()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_12, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return astronomicalBody;
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.add(paramByteBuffer, language);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(name));
    paramByteBuffer.put((byte)0);
    paramByteBuffer.put((byte)(role & 0xFF));
    Label.put(paramByteBuffer, longitude);
    Label.put(paramByteBuffer, latitude);
    Label.put(paramByteBuffer, altitude);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(astronomicalBody));
    paramByteBuffer.put((byte)0);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(additionalNotes));
    paramByteBuffer.put((byte)0);
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.append(name).length + 22 + f.slide.asm.ByteBuffer.append(astronomicalBody).length + f.slide.asm.ByteBuffer.append(additionalNotes).length;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public double getLatitude()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return latitude;
  }
  
  public double getLongitude()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return longitude;
  }
  
  public String getName()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return name;
  }
  
  public int getRole()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return role;
  }
  
  public void setAdditionalNotes(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_15, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    additionalNotes = paramString;
  }
  
  public void setAltitude(double paramDouble)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this, new Double(paramDouble));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    altitude = paramDouble;
  }
  
  public void setAstronomicalBody(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_13, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    astronomicalBody = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    language = paramString;
  }
  
  public void setLatitude(double paramDouble)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, new Double(paramDouble));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    latitude = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, new Double(paramDouble));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    longitude = paramDouble;
  }
  
  public void setName(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    name = paramString;
  }
  
  public void setRole(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    role = paramInt;
  }
}
