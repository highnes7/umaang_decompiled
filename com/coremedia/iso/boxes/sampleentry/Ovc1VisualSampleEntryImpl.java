package com.coremedia.iso.boxes.sampleentry;

import f.h.a.b;
import f.h.a.f;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import f.slide.asm.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class Ovc1VisualSampleEntryImpl
  extends AbstractSampleEntry
{
  public static final String TYPE = "ovc1";
  public byte[] vc1Content = new byte[0];
  
  public Ovc1VisualSampleEntryImpl()
  {
    super("ovc1");
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.position(6);
    Label.append(localByteBuffer, dataReferenceIndex);
    paramWritableByteChannel.write((ByteBuffer)localByteBuffer.rewind());
    paramWritableByteChannel.write(ByteBuffer.wrap(vc1Content));
  }
  
  public long getSize()
  {
    boolean bool = largeBox;
    int j = 16;
    int i = j;
    if (!bool) {
      if (vc1Content.length + 16 >= 4294967296L) {
        i = j;
      } else {
        i = 8;
      }
    }
    return i + vc1Content.length + 8L;
  }
  
  public byte[] getVc1Content()
  {
    return vc1Content;
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    paramByteBuffer = ByteBuffer.allocate(c.a(paramLong));
    paramF.read(paramByteBuffer);
    paramByteBuffer.position(6);
    dataReferenceIndex = ByteBufferList.get(paramByteBuffer);
    vc1Content = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(vc1Content);
  }
  
  public void setVc1Content(byte[] paramArrayOfByte)
  {
    vc1Content = paramArrayOfByte;
  }
}
