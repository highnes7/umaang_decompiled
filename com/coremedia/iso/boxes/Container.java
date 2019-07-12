package com.coremedia.iso.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

public abstract interface Container
{
  public abstract List getBoxes();
  
  public abstract List getBoxes(Class paramClass);
  
  public abstract List getBoxes(Class paramClass, boolean paramBoolean);
  
  public abstract ByteBuffer getByteBuffer(long paramLong1, long paramLong2)
    throws IOException;
  
  public abstract void setBoxes(List paramList);
  
  public abstract void writeContainer(WritableByteChannel paramWritableByteChannel)
    throws IOException;
}
