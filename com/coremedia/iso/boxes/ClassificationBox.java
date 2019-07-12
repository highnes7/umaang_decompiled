package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.Buffer;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import org.aspectj.lang.JoinPoint;

public class ClassificationBox
  extends MimeMessage
{
  public static final String TYPE = "clsf";
  public String classificationEntity;
  public String classificationInfo;
  public int classificationTableIndex;
  public String language;
  
  static {}
  
  public ClassificationBox()
  {
    super("clsf");
  }
  
  public void _parseDetails(java.nio.ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    classificationEntity = Buffer.evaluate(arrayOfByte);
    classificationTableIndex = ByteBufferList.get(paramByteBuffer);
    language = ByteBufferList.nextToken(paramByteBuffer);
    classificationInfo = ByteBufferList.readString(paramByteBuffer);
  }
  
  public String getClassificationEntity()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return classificationEntity;
  }
  
  public String getClassificationInfo()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return classificationInfo;
  }
  
  public int getClassificationTableIndex()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return classificationTableIndex;
  }
  
  public void getContent(java.nio.ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(Buffer.append(classificationEntity));
    Label.append(paramByteBuffer, classificationTableIndex);
    Label.add(paramByteBuffer, language);
    paramByteBuffer.put(f.slide.asm.ByteBuffer.append(classificationInfo));
    paramByteBuffer.put((byte)0);
  }
  
  public long getContentSize()
  {
    return f.slide.asm.ByteBuffer.convert(classificationInfo) + 8 + 1;
  }
  
  public String getLanguage()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return language;
  }
  
  public void setClassificationEntity(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    classificationEntity = paramString;
  }
  
  public void setClassificationInfo(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    classificationInfo = paramString;
  }
  
  public void setClassificationTableIndex(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    classificationTableIndex = paramInt;
  }
  
  public void setLanguage(String paramString)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this, paramString);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    language = paramString;
  }
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ClassificationBox[language=");
    ((StringBuilder)localObject).append(getLanguage());
    ((StringBuilder)localObject).append("classificationEntity=");
    ((StringBuilder)localObject).append(getClassificationEntity());
    ((StringBuilder)localObject).append(";classificationTableIndex=");
    ((StringBuilder)localObject).append(getClassificationTableIndex());
    ((StringBuilder)localObject).append(";language=");
    ((StringBuilder)localObject).append(getLanguage());
    ((StringBuilder)localObject).append(";classificationInfo=");
    ((StringBuilder)localObject).append(getClassificationInfo());
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
}
