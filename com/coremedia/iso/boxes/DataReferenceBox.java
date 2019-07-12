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
import java.util.List;

public class DataReferenceBox
  extends b
  implements FullBox
{
  public static final String TYPE = "dref";
  public int flags;
  public int version;
  
  public DataReferenceBox()
  {
    super("dref");
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    Label.put(localByteBuffer, version);
    Label.set(localByteBuffer, flags);
    localByteBuffer.putInt((int)((e)this).getBoxes().size());
    paramWritableByteChannel.write((ByteBuffer)localByteBuffer.rewind());
    ((e)this).writeContainer(paramWritableByteChannel);
  }
  
  public int getFlags()
  {
    return flags;
  }
  
  public long getSize()
  {
    long l = ((e)this).getContainerSize() + 8L;
    int i;
    if ((!largeBox) && (8L + l < 4294967296L)) {
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
    paramByteBuffer = ByteBuffer.allocate(8);
    paramF.read(paramByteBuffer);
    paramByteBuffer.rewind();
    version = ByteBufferList.readUInt8(paramByteBuffer);
    flags = ByteBufferList.getInt(paramByteBuffer);
    ((e)this).parseContainer(paramF, paramLong - 8L, paramA);
  }
  
  public void setFlags(int paramInt)
  {
    flags = paramInt;
  }
  
  public void setVersion(int paramInt)
  {
    version = paramInt;
  }
}
