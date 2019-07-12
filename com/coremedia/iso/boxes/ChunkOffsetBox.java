package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import org.aspectj.lang.JoinPoint;

public abstract class ChunkOffsetBox
  extends MimeMessage
{
  static {}
  
  public ChunkOffsetBox(String paramString)
  {
    super(paramString);
  }
  
  public abstract long[] getChunkOffsets();
  
  public String toString()
  {
    Object localObject = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before((JoinPoint)localObject);
    localObject = new StringBuilder(getClass().getSimpleName());
    ((StringBuilder)localObject).append("[entryCount=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, getChunkOffsets().length, "]");
  }
}
