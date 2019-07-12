package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class SoundMediaHeaderBox
  extends AbstractMediaHeaderBox
{
  public static final String TYPE = "smhd";
  public float balance;
  
  static {}
  
  public SoundMediaHeaderBox()
  {
    super("smhd");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    balance = ByteBufferList.add(paramByteBuffer);
    ByteBufferList.get(paramByteBuffer);
  }
  
  public float getBalance()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return balance;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    Label.write(paramByteBuffer, balance);
    Label.append(paramByteBuffer, 0);
  }
  
  public long getContentSize()
  {
    return 8L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this), "SoundMediaHeaderBox[balance=");
    localStringBuilder.append(getBalance());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
