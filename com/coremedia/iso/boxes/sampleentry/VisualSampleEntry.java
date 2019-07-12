package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.boxes.Container;
import f.h.a.b;
import f.h.a.e;
import f.h.a.f;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import f.slide.asm.a;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.WritableByteChannel;

public final class VisualSampleEntry
  extends AbstractSampleEntry
  implements Container
{
  public static final String TYPE1 = "mp4v";
  public static final String TYPE2 = "s263";
  public static final String TYPE3 = "avc1";
  public static final String TYPE4 = "avc3";
  public static final String TYPE5 = "drmi";
  public static final String TYPE_ENCRYPTED = "encv";
  public String compressorname = "";
  public int depth = 24;
  public int frameCount = 1;
  public int height;
  public double horizresolution = 72.0D;
  public long[] predefined = new long[3];
  public double vertresolution = 72.0D;
  public int width;
  
  public VisualSampleEntry()
  {
    super("avc1");
  }
  
  public VisualSampleEntry(String paramString)
  {
    super(paramString);
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    java.nio.ByteBuffer localByteBuffer = java.nio.ByteBuffer.allocate(78);
    localByteBuffer.position(6);
    Label.append(localByteBuffer, dataReferenceIndex);
    Label.append(localByteBuffer, 0);
    Label.append(localByteBuffer, 0);
    localByteBuffer.putInt((int)predefined[0]);
    localByteBuffer.putInt((int)predefined[1]);
    localByteBuffer.putInt((int)predefined[2]);
    Label.append(localByteBuffer, getWidth());
    Label.append(localByteBuffer, getHeight());
    Label.put(localByteBuffer, getHorizresolution());
    Label.put(localByteBuffer, getVertresolution());
    localByteBuffer.putInt((int)0L);
    Label.append(localByteBuffer, getFrameCount());
    localByteBuffer.put((byte)(f.slide.asm.ByteBuffer.convert(getCompressorname()) & 0xFF));
    localByteBuffer.put(f.slide.asm.ByteBuffer.append(getCompressorname()));
    int i = f.slide.asm.ByteBuffer.convert(getCompressorname());
    for (;;)
    {
      if (i >= 31)
      {
        Label.append(localByteBuffer, getDepth());
        Label.append(localByteBuffer, 65535);
        paramWritableByteChannel.write((java.nio.ByteBuffer)localByteBuffer.rewind());
        ((e)this).writeContainer(paramWritableByteChannel);
        return;
      }
      i += 1;
      localByteBuffer.put((byte)0);
    }
  }
  
  public String getCompressorname()
  {
    return compressorname;
  }
  
  public int getDepth()
  {
    return depth;
  }
  
  public int getFrameCount()
  {
    return frameCount;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public double getHorizresolution()
  {
    return horizresolution;
  }
  
  public long getSize()
  {
    long l = ((e)this).getContainerSize() + 78L;
    int i;
    if ((!largeBox) && (8L + l < 4294967296L)) {
      i = 8;
    } else {
      i = 16;
    }
    return l + i;
  }
  
  public double getVertresolution()
  {
    return vertresolution;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public void parse(f paramF, java.nio.ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    paramByteBuffer = java.nio.ByteBuffer.allocate(78);
    paramF.read(paramByteBuffer);
    paramByteBuffer.position(6);
    dataReferenceIndex = ByteBufferList.get(paramByteBuffer);
    ByteBufferList.get(paramByteBuffer);
    ByteBufferList.get(paramByteBuffer);
    predefined[0] = ByteBufferList.readUInt32(paramByteBuffer);
    predefined[1] = ByteBufferList.readUInt32(paramByteBuffer);
    predefined[2] = ByteBufferList.readUInt32(paramByteBuffer);
    width = ByteBufferList.get(paramByteBuffer);
    height = ByteBufferList.get(paramByteBuffer);
    horizresolution = ByteBufferList.update(paramByteBuffer);
    vertresolution = ByteBufferList.update(paramByteBuffer);
    ByteBufferList.readUInt32(paramByteBuffer);
    frameCount = ByteBufferList.get(paramByteBuffer);
    int j = ByteBufferList.readUInt8(paramByteBuffer);
    int i = j;
    if (j > 31)
    {
      localObject = System.out;
      StringBuilder localStringBuilder = new StringBuilder("invalid compressor name displayable data: ");
      localStringBuilder.append(j);
      ((PrintStream)localObject).println(localStringBuilder.toString());
      i = 31;
    }
    Object localObject = new byte[i];
    paramByteBuffer.get((byte[])localObject);
    compressorname = f.slide.asm.ByteBuffer.decode((byte[])localObject);
    if (i < 31) {
      paramByteBuffer.get(new byte[31 - i]);
    }
    depth = ByteBufferList.get(paramByteBuffer);
    ByteBufferList.get(paramByteBuffer);
    ((e)this).parseContainer(paramF, paramLong - 78L, paramA);
  }
  
  public void setCompressorname(String paramString)
  {
    compressorname = paramString;
  }
  
  public void setDepth(int paramInt)
  {
    depth = paramInt;
  }
  
  public void setFrameCount(int paramInt)
  {
    frameCount = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    height = paramInt;
  }
  
  public void setHorizresolution(double paramDouble)
  {
    horizresolution = paramDouble;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public void setVertresolution(double paramDouble)
  {
    vertresolution = paramDouble;
  }
  
  public void setWidth(int paramInt)
  {
    width = paramInt;
  }
}
