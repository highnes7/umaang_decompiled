package com.coremedia.iso.boxes.sampleentry;

import f.h.a.b;
import f.h.a.e;
import f.h.a.f;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import f.slide.asm.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.List;

public class MpegSampleEntry
  extends AbstractSampleEntry
{
  public MpegSampleEntry()
  {
    super("mp4s");
  }
  
  public MpegSampleEntry(String paramString)
  {
    super(paramString);
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.position(6);
    Label.append(localByteBuffer, dataReferenceIndex);
    paramWritableByteChannel.write((ByteBuffer)localByteBuffer.rewind());
    ((e)this).writeContainer(paramWritableByteChannel);
  }
  
  public long getSize()
  {
    long l = ((e)this).getContainerSize() + 8L;
    int i;
    if ((!largeBox) && (l < 4294967296L)) {
      i = 8;
    } else {
      i = 16;
    }
    return l + i;
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    paramByteBuffer = ByteBuffer.allocate(8);
    paramF.read(paramByteBuffer);
    paramByteBuffer.position(6);
    dataReferenceIndex = ByteBufferList.get(paramByteBuffer);
    ((e)this).parseContainer(paramF, paramLong - 8L, paramA);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MpegSampleEntry");
    localStringBuilder.append(Arrays.asList(new List[] { ((e)this).getBoxes() }));
    return localStringBuilder.toString();
  }
}
