package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import org.aspectj.lang.JoinPoint;

public class KeywordsBox
  extends MimeMessage
{
  public static final String TYPE = "kywd";
  public String[] keywords;
  public String language;
  
  static {}
  
  public KeywordsBox()
  {
    super("kywd");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    language = ByteBufferList.nextToken(paramByteBuffer);
    int j = ByteBufferList.readUInt8(paramByteBuffer);
    keywords = new String[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ByteBufferList.readUInt8(paramByteBuffer);
      keywords[i] = ByteBufferList.readString(paramByteBuffer);
      i += 1;
    }
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.add(paramByteBuffer, language);
    paramByteBuffer.put((byte)(keywords.length & 0xFF));
    String[] arrayOfString = keywords;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      String str = arrayOfString[i];
      paramByteBuffer.put((byte)(f.slide.asm.ByteBuffer.convert(str) + 1 & 0xFF));
      paramByteBuffer.put(f.slide.asm.ByteBuffer.append(str));
      i += 1;
    }
  }
  
  public long getContentSize()
  {
    String[] arrayOfString = keywords;
    int j = arrayOfString.length;
    long l = 7L;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return l;
      }
      l += f.slide.asm.ByteBuffer.convert(arrayOfString[i]) + 1 + 1;
      i += 1;
    }
  }
  
  public String[] getKeywords()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return keywords;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public void setKeywords(String[] paramArrayOfString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, paramArrayOfString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    keywords = paramArrayOfString;
  }
  
  public void setLanguage(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    language = paramString;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("KeywordsBox[language=");
    ((StringBuffer)localObject).append(getLanguage());
    int i = 0;
    for (;;)
    {
      if (i >= keywords.length)
      {
        ((StringBuffer)localObject).append("]");
        return ((StringBuffer)localObject).toString();
      }
      ((StringBuffer)localObject).append(";keyword");
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append("=");
      ((StringBuffer)localObject).append(keywords[i]);
      i += 1;
    }
  }
}
