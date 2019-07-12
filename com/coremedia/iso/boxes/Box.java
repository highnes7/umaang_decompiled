package com.coremedia.iso.boxes;

import f.h.a.f;
import f.slide.asm.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract interface Box
{
  public abstract void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException;
  
  public abstract long getOffset();
  
  public abstract Container getParent();
  
  public abstract long getSize();
  
  public abstract String getType();
  
  public abstract void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException;
  
  public abstract void setParent(Container paramContainer);
}
