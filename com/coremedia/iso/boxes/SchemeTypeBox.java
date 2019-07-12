package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import org.aspectj.lang.JoinPoint;

public class SchemeTypeBox
  extends MimeMessage
{
  public static final String TYPE = "schm";
  public String schemeType = "    ";
  public String schemeUri = null;
  public long schemeVersion;
  
  static {}
  
  public SchemeTypeBox()
  {
    super("schm");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    schemeType = ByteBufferList.read(paramByteBuffer);
    schemeVersion = ByteBufferList.readUInt32(paramByteBuffer);
    if ((getFlags() & 0x1) == 1) {
      schemeUri = ByteBufferList.readString(paramByteBuffer);
    }
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.put(Buffer.append(schemeType));
    paramByteBuffer.putInt((int)schemeVersion);
    if ((getFlags() & 0x1) == 1) {
      paramByteBuffer.put(f.slide.asm.ByteBuffer.append(schemeUri));
    }
  }
  
  public long getContentSize()
  {
    int i;
    if ((getFlags() & 0x1) == 1) {
      i = f.slide.asm.ByteBuffer.convert(schemeUri) + 1;
    } else {
      i = 0;
    }
    return i + 12;
  }
  
  public String getSchemeType()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return schemeType;
  }
  
  public String getSchemeUri()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return schemeUri;
  }
  
  public long getSchemeVersion()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return schemeVersion;
  }
  
  public void setSchemeType(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    schemeType = paramString;
  }
  
  public void setSchemeUri(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    schemeUri = paramString;
  }
  
  public void setSchemeVersion(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    schemeVersion = paramInt;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Schema Type Box[");
    ((StringBuilder)localObject).append("schemeUri=");
    f.sufficientlysecure.rootcommands.util.StringBuilder.write((StringBuilder)localObject, schemeUri, "; ", "schemeType=");
    f.sufficientlysecure.rootcommands.util.StringBuilder.write((StringBuilder)localObject, schemeType, "; ", "schemeVersion=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, schemeUri, "; ", "]");
  }
}
