package com.coremedia.iso.boxes.mdat;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import f.h.a.f;
import f.slide.asm.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Logger;

public final class MediaDataBox
  implements Box
{
  public static final String TYPE = "mdat";
  public static Logger log = Logger.getLogger(MediaDataBox.class.getName());
  public f dataSource;
  public boolean largeBox = false;
  public long offset;
  public Container parent;
  public long size;
  
  public MediaDataBox() {}
  
  public static void transfer(f paramF, long paramLong1, long paramLong2, WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    for (long l = 0L;; l += paramF.a(paramLong1 + l, Math.min(67076096L, paramLong2 - l), paramWritableByteChannel)) {
      if (l >= paramLong2) {
        return;
      }
    }
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    transfer(dataSource, offset, size, paramWritableByteChannel);
  }
  
  public long getOffset()
  {
    return offset;
  }
  
  public Container getParent()
  {
    return parent;
  }
  
  public long getSize()
  {
    return size;
  }
  
  public String getType()
  {
    return "mdat";
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    offset = (paramF.position() - paramByteBuffer.remaining());
    dataSource = paramF;
    size = (paramByteBuffer.remaining() + paramLong);
    paramF.position(paramF.position() + paramLong);
  }
  
  public void setParent(Container paramContainer)
  {
    parent = paramContainer;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MediaDataBox{size=");
    localStringBuilder.append(size);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
