package com.coremedia.iso.boxes;

import f.h.a.b;
import f.h.a.e;
import f.h.a.f;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import f.slide.asm.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class MetaBox
  extends b
{
  public static final String TYPE = "meta";
  public int flags;
  public int version;
  
  public MetaBox()
  {
    super("meta");
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    writeVersionAndFlags(localByteBuffer);
    paramWritableByteChannel.write((ByteBuffer)localByteBuffer.rewind());
    ((e)this).writeContainer(paramWritableByteChannel);
  }
  
  public int getFlags()
  {
    return flags;
  }
  
  public long getSize()
  {
    long l = ((e)this).getContainerSize() + 4L;
    int i;
    if ((!largeBox) && (l < 4294967296L)) {
      i = 8;
    } else {
      i = 16;
    }
    return l + i;
  }
  
  public int getVersion()
  {
    return version;
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    paramByteBuffer = ByteBuffer.allocate(4);
    paramF.read(paramByteBuffer);
    parseVersionAndFlags((ByteBuffer)paramByteBuffer.rewind());
    ((e)this).parseContainer(paramF, paramLong - 4L, paramA);
  }
  
  public final long parseVersionAndFlags(ByteBuffer paramByteBuffer)
  {
    version = ByteBufferList.readUInt8(paramByteBuffer);
    flags = ByteBufferList.getInt(paramByteBuffer);
    return 4L;
  }
  
  public void setFlags(int paramInt)
  {
    flags = paramInt;
  }
  
  public void setVersion(int paramInt)
  {
    version = paramInt;
  }
  
  public final void writeVersionAndFlags(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put((byte)(version & 0xFF));
    Label.set(paramByteBuffer, flags);
  }
}
