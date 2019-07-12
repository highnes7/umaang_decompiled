package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;

public class ChunkOffset64BitBox
  extends ChunkOffsetBox
{
  public static final String TYPE = "co64";
  public long[] chunkOffsets;
  
  static {}
  
  public ChunkOffset64BitBox()
  {
    super("co64");
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
      chunkOffsets[i] = ByteBufferList.readUInt64(paramByteBuffer);
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
      paramByteBuffer.putLong(arrayOfLong[i]);
      i += 1;
    }
  }
  
  public long getContentSize()
  {
    return chunkOffsets.length * 8 + 8;
  }
}
