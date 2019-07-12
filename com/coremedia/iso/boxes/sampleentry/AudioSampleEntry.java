package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import f.h.a.b;
import f.h.a.e;
import f.h.a.f;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Label;
import f.slide.asm.a;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public final class AudioSampleEntry
  extends AbstractSampleEntry
{
  public static final String TYPE1 = "samr";
  public static final String TYPE10 = "mlpa";
  public static final String TYPE11 = "dtsl";
  public static final String TYPE12 = "dtsh";
  public static final String TYPE13 = "dtse";
  public static final String TYPE2 = "sawb";
  public static final String TYPE3 = "mp4a";
  public static final String TYPE4 = "drms";
  public static final String TYPE5 = "alac";
  public static final String TYPE7 = "owma";
  public static final String TYPE8 = "ac-3";
  public static final String TYPE9 = "ec-3";
  public static final String TYPE_ENCRYPTED = "enca";
  public long bytesPerFrame;
  public long bytesPerPacket;
  public long bytesPerSample;
  public int channelCount;
  public int compressionId;
  public int packetSize;
  public int reserved1;
  public long reserved2;
  public long sampleRate;
  public int sampleSize;
  public long samplesPerPacket;
  public int soundVersion;
  public byte[] soundVersion2Data;
  
  public AudioSampleEntry(String paramString)
  {
    super(paramString);
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    int i = soundVersion;
    int j = 0;
    if (i == 1) {
      i = 16;
    } else {
      i = 0;
    }
    if (soundVersion == 2) {
      j = 36;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 28 + j);
    localByteBuffer.position(6);
    Label.append(localByteBuffer, dataReferenceIndex);
    Label.append(localByteBuffer, soundVersion);
    Label.append(localByteBuffer, reserved1);
    localByteBuffer.putInt((int)reserved2);
    Label.append(localByteBuffer, channelCount);
    Label.append(localByteBuffer, sampleSize);
    Label.append(localByteBuffer, compressionId);
    Label.append(localByteBuffer, packetSize);
    if (type.equals("mlpa")) {
      localByteBuffer.putInt((int)getSampleRate());
    } else {
      localByteBuffer.putInt((int)(getSampleRate() << 16));
    }
    if (soundVersion == 1)
    {
      localByteBuffer.putInt((int)samplesPerPacket);
      localByteBuffer.putInt((int)bytesPerPacket);
      localByteBuffer.putInt((int)bytesPerFrame);
      localByteBuffer.putInt((int)bytesPerSample);
    }
    if (soundVersion == 2)
    {
      localByteBuffer.putInt((int)samplesPerPacket);
      localByteBuffer.putInt((int)bytesPerPacket);
      localByteBuffer.putInt((int)bytesPerFrame);
      localByteBuffer.putInt((int)bytesPerSample);
      localByteBuffer.put(soundVersion2Data);
    }
    paramWritableByteChannel.write((ByteBuffer)localByteBuffer.rewind());
    ((e)this).writeContainer(paramWritableByteChannel);
  }
  
  public long getBytesPerFrame()
  {
    return bytesPerFrame;
  }
  
  public long getBytesPerPacket()
  {
    return bytesPerPacket;
  }
  
  public long getBytesPerSample()
  {
    return bytesPerSample;
  }
  
  public int getChannelCount()
  {
    return channelCount;
  }
  
  public int getCompressionId()
  {
    return compressionId;
  }
  
  public int getPacketSize()
  {
    return packetSize;
  }
  
  public int getReserved1()
  {
    return reserved1;
  }
  
  public long getReserved2()
  {
    return reserved2;
  }
  
  public long getSampleRate()
  {
    return sampleRate;
  }
  
  public int getSampleSize()
  {
    return sampleSize;
  }
  
  public long getSamplesPerPacket()
  {
    return samplesPerPacket;
  }
  
  public long getSize()
  {
    int i = soundVersion;
    int k = 16;
    int j = 0;
    if (i == 1) {
      i = 16;
    } else {
      i = 0;
    }
    if (soundVersion == 2) {
      j = 36;
    }
    long l = i + 28 + j;
    l = ((e)this).getContainerSize() + l;
    i = k;
    if (!largeBox) {
      if (8L + l >= 4294967296L) {
        i = k;
      } else {
        i = 8;
      }
    }
    return l + i;
  }
  
  public int getSoundVersion()
  {
    return soundVersion;
  }
  
  public byte[] getSoundVersion2Data()
  {
    return soundVersion2Data;
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, final long paramLong, a paramA)
    throws IOException
  {
    paramByteBuffer = ByteBuffer.allocate(28);
    paramF.read(paramByteBuffer);
    paramByteBuffer.position(6);
    dataReferenceIndex = ByteBufferList.get(paramByteBuffer);
    soundVersion = ByteBufferList.get(paramByteBuffer);
    reserved1 = ByteBufferList.get(paramByteBuffer);
    reserved2 = ByteBufferList.readUInt32(paramByteBuffer);
    channelCount = ByteBufferList.get(paramByteBuffer);
    sampleSize = ByteBufferList.get(paramByteBuffer);
    compressionId = ByteBufferList.get(paramByteBuffer);
    packetSize = ByteBufferList.get(paramByteBuffer);
    sampleRate = ByteBufferList.readUInt32(paramByteBuffer);
    boolean bool = type.equals("mlpa");
    int j = 16;
    if (!bool) {
      sampleRate >>>= 16;
    }
    if (soundVersion == 1)
    {
      paramByteBuffer = ByteBuffer.allocate(16);
      paramF.read(paramByteBuffer);
      paramByteBuffer.rewind();
      samplesPerPacket = ByteBufferList.readUInt32(paramByteBuffer);
      bytesPerPacket = ByteBufferList.readUInt32(paramByteBuffer);
      bytesPerFrame = ByteBufferList.readUInt32(paramByteBuffer);
      bytesPerSample = ByteBufferList.readUInt32(paramByteBuffer);
    }
    int k = soundVersion;
    int i = 36;
    if (k == 2)
    {
      paramByteBuffer = ByteBuffer.allocate(36);
      paramF.read(paramByteBuffer);
      paramByteBuffer.rewind();
      samplesPerPacket = ByteBufferList.readUInt32(paramByteBuffer);
      bytesPerPacket = ByteBufferList.readUInt32(paramByteBuffer);
      bytesPerFrame = ByteBufferList.readUInt32(paramByteBuffer);
      bytesPerSample = ByteBufferList.readUInt32(paramByteBuffer);
      soundVersion2Data = new byte[20];
      paramByteBuffer.get(soundVersion2Data);
    }
    if ("owma".equals(type))
    {
      System.err.println("owma");
      if (soundVersion != 1) {
        j = 0;
      }
      l1 = j;
      if (soundVersion != 2) {
        i = 0;
      }
      paramLong = paramLong - 28L - l1 - i;
      paramByteBuffer = ByteBuffer.allocate(c.a(paramLong));
      paramF.read(paramByteBuffer);
      paramF = new Box()
      {
        public void getBox(WritableByteChannel paramAnonymousWritableByteChannel)
          throws IOException
        {
          val$owmaSpecifics.rewind();
          paramAnonymousWritableByteChannel.write(val$owmaSpecifics);
        }
        
        public long getOffset()
        {
          return 0L;
        }
        
        public Container getParent()
        {
          return (Container)AudioSampleEntry.this;
        }
        
        public long getSize()
        {
          return paramLong;
        }
        
        public String getType()
        {
          return "----";
        }
        
        public void parse(f paramAnonymousF, ByteBuffer paramAnonymousByteBuffer, long paramAnonymousLong, a paramAnonymousA)
          throws IOException
        {
          throw new RuntimeException("NotImplemented");
        }
        
        public void setParent(Container paramAnonymousContainer)
        {
          if (!AudioSampleEntry.$assertionsDisabled)
          {
            if (paramAnonymousContainer == AudioSampleEntry.this) {
              return;
            }
            throw new AssertionError("you cannot diswown this special box");
          }
        }
      };
      ((e)this).addBox(paramF);
      return;
    }
    if (soundVersion != 1) {
      j = 0;
    }
    long l1 = j;
    if (soundVersion != 2) {
      i = 0;
    }
    long l2 = i;
    ((e)this).parseContainer(paramF, paramLong - 28L - l1 - l2, paramA);
  }
  
  public void setBytesPerFrame(long paramLong)
  {
    bytesPerFrame = paramLong;
  }
  
  public void setBytesPerPacket(long paramLong)
  {
    bytesPerPacket = paramLong;
  }
  
  public void setBytesPerSample(long paramLong)
  {
    bytesPerSample = paramLong;
  }
  
  public void setChannelCount(int paramInt)
  {
    channelCount = paramInt;
  }
  
  public void setCompressionId(int paramInt)
  {
    compressionId = paramInt;
  }
  
  public void setPacketSize(int paramInt)
  {
    packetSize = paramInt;
  }
  
  public void setReserved1(int paramInt)
  {
    reserved1 = paramInt;
  }
  
  public void setReserved2(long paramLong)
  {
    reserved2 = paramLong;
  }
  
  public void setSampleRate(long paramLong)
  {
    sampleRate = paramLong;
  }
  
  public void setSampleSize(int paramInt)
  {
    sampleSize = paramInt;
  }
  
  public void setSamplesPerPacket(long paramLong)
  {
    samplesPerPacket = paramLong;
  }
  
  public void setSoundVersion(int paramInt)
  {
    soundVersion = paramInt;
  }
  
  public void setSoundVersion2Data(byte[] paramArrayOfByte)
  {
    soundVersion2Data = paramArrayOfByte;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioSampleEntry{bytesPerSample=");
    localStringBuilder.append(bytesPerSample);
    localStringBuilder.append(", bytesPerFrame=");
    localStringBuilder.append(bytesPerFrame);
    localStringBuilder.append(", bytesPerPacket=");
    localStringBuilder.append(bytesPerPacket);
    localStringBuilder.append(", samplesPerPacket=");
    localStringBuilder.append(samplesPerPacket);
    localStringBuilder.append(", packetSize=");
    localStringBuilder.append(packetSize);
    localStringBuilder.append(", compressionId=");
    localStringBuilder.append(compressionId);
    localStringBuilder.append(", soundVersion=");
    localStringBuilder.append(soundVersion);
    localStringBuilder.append(", sampleRate=");
    localStringBuilder.append(sampleRate);
    localStringBuilder.append(", sampleSize=");
    localStringBuilder.append(sampleSize);
    localStringBuilder.append(", channelCount=");
    localStringBuilder.append(channelCount);
    localStringBuilder.append(", boxes=");
    localStringBuilder.append(((e)this).getBoxes());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
