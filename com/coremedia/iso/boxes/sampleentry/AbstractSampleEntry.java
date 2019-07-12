package com.coremedia.iso.boxes.sampleentry;

import f.h.a.b;
import f.h.a.f;
import f.slide.asm.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class AbstractSampleEntry
  extends b
  implements SampleEntry
{
  public int dataReferenceIndex = 1;
  
  public AbstractSampleEntry(String paramString)
  {
    super(paramString);
  }
  
  public abstract void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException;
  
  public int getDataReferenceIndex()
  {
    return dataReferenceIndex;
  }
  
  public abstract void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException;
  
  public void setDataReferenceIndex(int paramInt)
  {
    dataReferenceIndex = paramInt;
  }
}
