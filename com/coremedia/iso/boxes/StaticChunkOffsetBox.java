package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class StaticChunkOffsetBox
  extends ChunkOffsetBox
{
  public static final String TYPE = "stco";
  public long[] chunkOffsets = new long[0];
  
  static {}
  
  public StaticChunkOffsetBox()
  {
    super("stco");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    int j = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    chunkOffsets = new long[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      chunkOffsets[i] = ByteBufferList.readUInt32(paramByteBuffer);
      i += 1;
    }
  }
  
  public long[] getChunkOffsets()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return chunkOffsets;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)chunkOffsets.length);
    long[] arrayOfLong = chunkOffsets;
    int j = arrayOfLong.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      paramByteBuffer.putInt((int)arrayOfLong[i]);
      i += 1;
    }
  }
  
  public long getContentSize()
  {
    return chunkOffsets.length * 4 + 8;
  }
  
  public void setChunkOffsets(long[] paramArrayOfLong)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramArrayOfLong);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    chunkOffsets = paramArrayOfLong;
  }
}
