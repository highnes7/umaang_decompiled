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

public class SubtitleSampleEntry
  extends AbstractSampleEntry
{
  public static final String TYPE1 = "stpp";
  public String imageMimeType = "";
  public String namespace = "";
  public String schemaLocation = "";
  
  public SubtitleSampleEntry()
  {
    super("stpp");
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    int i = namespace.length();
    int j = schemaLocation.length();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(imageMimeType.length() + (j + (i + 8)) + 3);
    localByteBuffer.position(6);
    Label.append(localByteBuffer, dataReferenceIndex);
    Label.put(localByteBuffer, namespace);
    Label.put(localByteBuffer, schemaLocation);
    Label.put(localByteBuffer, imageMimeType);
    paramWritableByteChannel.write((ByteBuffer)localByteBuffer.rewind());
    ((e)this).writeContainer(paramWritableByteChannel);
  }
  
  public String getImageMimeType()
  {
    return imageMimeType;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public String getSchemaLocation()
  {
    return schemaLocation;
  }
  
  public long getSize()
  {
    long l = ((e)this).getContainerSize();
    int j = namespace.length();
    int i = 8;
    int k = schemaLocation.length();
    l += imageMimeType.length() + (k + (j + 8)) + 3;
    if ((largeBox) || (8L + l >= 4294967296L)) {
      i = 16;
    }
    return l + i;
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    paramF.read((ByteBuffer)localByteBuffer.rewind());
    localByteBuffer.position(6);
    dataReferenceIndex = ByteBufferList.get(localByteBuffer);
    long l = paramF.position();
    localByteBuffer = ByteBuffer.allocate(1024);
    paramF.read((ByteBuffer)localByteBuffer.rewind());
    namespace = ByteBufferList.readString((ByteBuffer)localByteBuffer.rewind());
    paramF.position(namespace.length() + l + 1L);
    paramF.read((ByteBuffer)localByteBuffer.rewind());
    schemaLocation = ByteBufferList.readString((ByteBuffer)localByteBuffer.rewind());
    paramF.position(namespace.length() + l + schemaLocation.length() + 2L);
    paramF.read((ByteBuffer)localByteBuffer.rewind());
    imageMimeType = ByteBufferList.readString((ByteBuffer)localByteBuffer.rewind());
    paramF.position(l + namespace.length() + schemaLocation.length() + imageMimeType.length() + 3L);
    int i = paramByteBuffer.remaining();
    int j = namespace.length();
    int k = schemaLocation.length();
    l = imageMimeType.length() + (k + (j + i)) + 3;
    ((e)this).parseContainer(paramF, paramLong - l, paramA);
  }
  
  public void setImageMimeType(String paramString)
  {
    imageMimeType = paramString;
  }
  
  public void setNamespace(String paramString)
  {
    namespace = paramString;
  }
  
  public void setSchemaLocation(String paramString)
  {
    schemaLocation = paramString;
  }
}
