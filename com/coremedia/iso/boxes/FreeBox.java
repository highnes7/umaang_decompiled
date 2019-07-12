package com.coremedia.iso.boxes;

import f.h.a.f;
import f.h.a.g.c;
import f.slide.asm.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FreeBox
  implements Box
{
  public static final String TYPE = "free";
  public ByteBuffer data;
  public long offset;
  public Container parent;
  public List<Box> replacers = new LinkedList();
  
  public FreeBox()
  {
    data = ByteBuffer.wrap(new byte[0]);
  }
  
  public FreeBox(int paramInt)
  {
    data = ByteBuffer.allocate(paramInt);
  }
  
  public void addAndReplace(Box paramBox)
  {
    data.position(c.a(paramBox.getSize()));
    data = data.slice();
    replacers.add(paramBox);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (FreeBox.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (FreeBox)paramObject;
      if (getData() != null)
      {
        if (!getData().equals(paramObject.getData())) {
          return false;
        }
      }
      else
      {
        if (paramObject.getData() == null) {
          break label63;
        }
        return false;
      }
      return true;
    }
    else
    {
      return false;
    }
    label63:
    return true;
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    Object localObject = replacers.iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        localObject = ByteBuffer.allocate(8);
        ((ByteBuffer)localObject).putInt((int)(data.limit() + 8));
        ((ByteBuffer)localObject).put("free".getBytes());
        ((ByteBuffer)localObject).rewind();
        paramWritableByteChannel.write((ByteBuffer)localObject);
        ((ByteBuffer)localObject).rewind();
        data.rewind();
        paramWritableByteChannel.write(data);
        data.rewind();
        return;
      }
      ((Box)((Iterator)localObject).next()).getBox(paramWritableByteChannel);
    }
  }
  
  public ByteBuffer getData()
  {
    ByteBuffer localByteBuffer = data;
    if (localByteBuffer != null) {
      return (ByteBuffer)localByteBuffer.duplicate().rewind();
    }
    return null;
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
    Iterator localIterator = replacers.iterator();
    for (long l = 8L;; l += ((Box)localIterator.next()).getSize()) {
      if (!localIterator.hasNext()) {
        return l + data.limit();
      }
    }
  }
  
  public String getType()
  {
    return "free";
  }
  
  public int hashCode()
  {
    ByteBuffer localByteBuffer = data;
    if (localByteBuffer != null) {
      return localByteBuffer.hashCode();
    }
    return 0;
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    offset = (paramF.position() - paramByteBuffer.remaining());
    if (paramLong > 1048576L)
    {
      data = paramF.a(paramF.position(), paramLong);
      paramF.position(paramF.position() + paramLong);
      return;
    }
    data = ByteBuffer.allocate(c.a(paramLong));
    paramF.read(data);
  }
  
  public void setData(ByteBuffer paramByteBuffer)
  {
    data = paramByteBuffer;
  }
  
  public void setParent(Container paramContainer)
  {
    parent = paramContainer;
  }
}
