package com.coremedia.iso.boxes.h264;

import f.h.a.Message;
import f.h.a.c.e.a.c;
import f.h.a.c.e.a.d;
import f.h.a.e.a.e;
import f.h.a.e.a.h;
import f.slide.asm.ByteBufferList;
import f.slide.asm.Frame;
import f.slide.asm.Label;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public final class AvcConfigurationBox
  extends Message
{
  public static final String TYPE = "avcC";
  public AVCDecoderConfigurationRecord avcDecoderConfigurationRecord = new AVCDecoderConfigurationRecord();
  
  static {}
  
  public AvcConfigurationBox()
  {
    super("avcC");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    avcDecoderConfigurationRecord = new AVCDecoderConfigurationRecord(paramByteBuffer);
  }
  
  public int getAvcLevelIndication()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.avcLevelIndication;
  }
  
  public int getAvcProfileIndication()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.avcProfileIndication;
  }
  
  public int getBitDepthChromaMinus8()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_18, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.bitDepthChromaMinus8;
  }
  
  public int getBitDepthLumaMinus8()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_16, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.bitDepthLumaMinus8;
  }
  
  public int getChromaFormat()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_14, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.chromaFormat;
  }
  
  public int getConfigurationVersion()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.configurationVersion;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_25, this, this, paramByteBuffer);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.getContent(paramByteBuffer);
  }
  
  public long getContentSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_24, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.getContentSize();
  }
  
  public int getLengthSizeMinusOne()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.lengthSizeMinusOne;
  }
  
  public String[] getPPS()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_27, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.getPPS();
  }
  
  public List getPictureParameterSets()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return Collections.unmodifiableList(avcDecoderConfigurationRecord.pictureParameterSets);
  }
  
  public int getProfileCompatibility()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.profileCompatibility;
  }
  
  public String[] getSPS()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_26, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.getSPS();
  }
  
  public List getSequenceParameterSetExts()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_20, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.sequenceParameterSetExts;
  }
  
  public List getSequenceParameterSets()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return Collections.unmodifiableList(avcDecoderConfigurationRecord.sequenceParameterSets);
  }
  
  public AVCDecoderConfigurationRecord getavcDecoderConfigurationRecord()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_28, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord;
  }
  
  public boolean hasExts()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_22, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return avcDecoderConfigurationRecord.hasExts;
  }
  
  public void setAvcLevelIndication(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.avcLevelIndication = paramInt;
  }
  
  public void setAvcProfileIndication(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.avcProfileIndication = paramInt;
  }
  
  public void setBitDepthChromaMinus8(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_19, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.bitDepthChromaMinus8 = paramInt;
  }
  
  public void setBitDepthLumaMinus8(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_17, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.bitDepthLumaMinus8 = paramInt;
  }
  
  public void setChromaFormat(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_15, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.chromaFormat = paramInt;
  }
  
  public void setConfigurationVersion(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.configurationVersion = paramInt;
  }
  
  public void setHasExts(boolean paramBoolean)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_23, this, this, new Boolean(paramBoolean));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.hasExts = paramBoolean;
  }
  
  public void setLengthSizeMinusOne(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.lengthSizeMinusOne = paramInt;
  }
  
  public void setPictureParameterSets(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_13, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.pictureParameterSets = paramList;
  }
  
  public void setProfileCompatibility(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.profileCompatibility = paramInt;
  }
  
  public void setSequenceParameterSetExts(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_21, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.sequenceParameterSetExts = paramList;
  }
  
  public void setSequenceParameterSets(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_12, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    avcDecoderConfigurationRecord.sequenceParameterSets = paramList;
  }
  
  public static class AVCDecoderConfigurationRecord
  {
    public int avcLevelIndication;
    public int avcProfileIndication;
    public int bitDepthChromaMinus8;
    public int bitDepthChromaMinus8PaddingBits;
    public int bitDepthLumaMinus8;
    public int bitDepthLumaMinus8PaddingBits;
    public int chromaFormat = 1;
    public int chromaFormatPaddingBits;
    public int configurationVersion;
    public boolean hasExts = true;
    public int lengthSizeMinusOne;
    public int lengthSizeMinusOnePaddingBits;
    public int numberOfSequenceParameterSetsPaddingBits;
    public List<byte[]> pictureParameterSets = new ArrayList();
    public int profileCompatibility;
    public List<byte[]> sequenceParameterSetExts;
    public List<byte[]> sequenceParameterSets = new ArrayList();
    
    public AVCDecoderConfigurationRecord()
    {
      bitDepthLumaMinus8 = 0;
      bitDepthChromaMinus8 = 0;
      sequenceParameterSetExts = new ArrayList();
      lengthSizeMinusOnePaddingBits = 63;
      numberOfSequenceParameterSetsPaddingBits = 7;
      chromaFormatPaddingBits = 31;
      bitDepthLumaMinus8PaddingBits = 31;
      bitDepthChromaMinus8PaddingBits = 31;
    }
    
    public AVCDecoderConfigurationRecord(ByteBuffer paramByteBuffer)
    {
      int j = 0;
      bitDepthLumaMinus8 = 0;
      bitDepthChromaMinus8 = 0;
      sequenceParameterSetExts = new ArrayList();
      lengthSizeMinusOnePaddingBits = 63;
      numberOfSequenceParameterSetsPaddingBits = 7;
      chromaFormatPaddingBits = 31;
      bitDepthLumaMinus8PaddingBits = 31;
      bitDepthChromaMinus8PaddingBits = 31;
      configurationVersion = ByteBufferList.readUInt8(paramByteBuffer);
      avcProfileIndication = ByteBufferList.readUInt8(paramByteBuffer);
      profileCompatibility = ByteBufferList.readUInt8(paramByteBuffer);
      avcLevelIndication = ByteBufferList.readUInt8(paramByteBuffer);
      Object localObject = new c(paramByteBuffer);
      lengthSizeMinusOnePaddingBits = ((c)localObject).a(6);
      lengthSizeMinusOne = ((c)localObject).a(2);
      numberOfSequenceParameterSetsPaddingBits = ((c)localObject).a(3);
      int k = ((c)localObject).a(5);
      int i = 0;
      for (;;)
      {
        if (i >= k)
        {
          long l = ByteBufferList.readUInt8(paramByteBuffer);
          i = 0;
          for (;;)
          {
            if (i >= l)
            {
              if (paramByteBuffer.remaining() < 4) {
                hasExts = false;
              }
              if (hasExts)
              {
                i = avcProfileIndication;
                if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
                {
                  localObject = new c(paramByteBuffer);
                  chromaFormatPaddingBits = ((c)localObject).a(6);
                  chromaFormat = ((c)localObject).a(2);
                  bitDepthLumaMinus8PaddingBits = ((c)localObject).a(5);
                  bitDepthLumaMinus8 = ((c)localObject).a(3);
                  bitDepthChromaMinus8PaddingBits = ((c)localObject).a(5);
                  bitDepthChromaMinus8 = ((c)localObject).a(3);
                  l = ByteBufferList.readUInt8(paramByteBuffer);
                  i = j;
                  for (;;)
                  {
                    if (i >= l) {
                      return;
                    }
                    localObject = new byte[ByteBufferList.get(paramByteBuffer)];
                    paramByteBuffer.get((byte[])localObject);
                    sequenceParameterSetExts.add(localObject);
                    i += 1;
                  }
                }
              }
              chromaFormat = -1;
              bitDepthLumaMinus8 = -1;
              bitDepthChromaMinus8 = -1;
              return;
            }
            localObject = new byte[ByteBufferList.get(paramByteBuffer)];
            paramByteBuffer.get((byte[])localObject);
            pictureParameterSets.add(localObject);
            i += 1;
          }
        }
        localObject = new byte[ByteBufferList.get(paramByteBuffer)];
        paramByteBuffer.get((byte[])localObject);
        sequenceParameterSets.add(localObject);
        i += 1;
      }
    }
    
    public void getContent(ByteBuffer paramByteBuffer)
    {
      paramByteBuffer.put((byte)(configurationVersion & 0xFF));
      paramByteBuffer.put((byte)(avcProfileIndication & 0xFF));
      paramByteBuffer.put((byte)(profileCompatibility & 0xFF));
      paramByteBuffer.put((byte)(avcLevelIndication & 0xFF));
      Object localObject = new d(paramByteBuffer);
      ((d)localObject).a(lengthSizeMinusOnePaddingBits, 6);
      ((d)localObject).a(lengthSizeMinusOne, 2);
      ((d)localObject).a(numberOfSequenceParameterSetsPaddingBits, 3);
      ((d)localObject).a(pictureParameterSets.size(), 5);
      localObject = sequenceParameterSets.iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          paramByteBuffer.put((byte)(pictureParameterSets.size() & 0xFF));
          localObject = pictureParameterSets.iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext())
            {
              if (hasExts)
              {
                int i = avcProfileIndication;
                if ((i != 100) && (i != 110) && (i != 122) && (i != 144)) {
                  break;
                }
                localObject = new d(paramByteBuffer);
                ((d)localObject).a(chromaFormatPaddingBits, 6);
                ((d)localObject).a(chromaFormat, 2);
                ((d)localObject).a(bitDepthLumaMinus8PaddingBits, 5);
                ((d)localObject).a(bitDepthLumaMinus8, 3);
                ((d)localObject).a(bitDepthChromaMinus8PaddingBits, 5);
                ((d)localObject).a(bitDepthChromaMinus8, 3);
                localObject = sequenceParameterSetExts.iterator();
                for (;;)
                {
                  if (!((Iterator)localObject).hasNext()) {
                    return;
                  }
                  arrayOfByte = (byte[])((Iterator)localObject).next();
                  Label.append(paramByteBuffer, arrayOfByte.length);
                  paramByteBuffer.put(arrayOfByte);
                }
              }
              return;
            }
            arrayOfByte = (byte[])((Iterator)localObject).next();
            Label.append(paramByteBuffer, arrayOfByte.length);
            paramByteBuffer.put(arrayOfByte);
          }
        }
        byte[] arrayOfByte = (byte[])((Iterator)localObject).next();
        Label.append(paramByteBuffer, arrayOfByte.length);
        paramByteBuffer.put(arrayOfByte);
      }
    }
    
    public long getContentSize()
    {
      Iterator localIterator = sequenceParameterSets.iterator();
      for (long l = 6L;; l = l + 2L + ((byte[])localIterator.next()).length) {
        if (!localIterator.hasNext())
        {
          l += 1L;
          localIterator = pictureParameterSets.iterator();
          for (;;)
          {
            if (!localIterator.hasNext())
            {
              if (hasExts)
              {
                int i = avcProfileIndication;
                if ((i != 100) && (i != 110) && (i != 122) && (i != 144)) {
                  break;
                }
                l += 4L;
                localIterator = sequenceParameterSetExts.iterator();
                for (;;)
                {
                  if (!localIterator.hasNext()) {
                    return l;
                  }
                  l = l + 2L + ((byte[])localIterator.next()).length;
                }
              }
              return l;
            }
            l = l + 2L + ((byte[])localIterator.next()).length;
          }
        }
      }
      return l;
    }
    
    public String[] getPPS()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = pictureParameterSets.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return (String[])localArrayList.toArray(new String[localArrayList.size()]);
        }
        Object localObject = (byte[])localIterator.next();
        int i = localObject.length;
        try
        {
          localObject = e.a(new ByteArrayInputStream((byte[])localObject, 1, i - 1)).toString();
          localArrayList.add(localObject);
        }
        catch (IOException localIOException)
        {
          RuntimeException localRuntimeException = new RuntimeException(localIOException);
          throw localRuntimeException;
        }
      }
    }
    
    public List getPictureParameterSetsAsStrings()
    {
      ArrayList localArrayList = new ArrayList(pictureParameterSets.size());
      Iterator localIterator = pictureParameterSets.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return localArrayList;
        }
        localArrayList.add(Frame.a((byte[])localIterator.next()));
      }
    }
    
    public String[] getSPS()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = sequenceParameterSets.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return (String[])localArrayList.toArray(new String[localArrayList.size()]);
        }
        Object localObject = (byte[])localIterator.next();
        int i = localObject.length;
        try
        {
          localObject = h.a(new ByteArrayInputStream((byte[])localObject, 1, i - 1)).toString();
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
        localObject = "not parsable";
        localArrayList.add(localObject);
      }
    }
    
    public List getSequenceParameterSetExtsAsStrings()
    {
      ArrayList localArrayList = new ArrayList(sequenceParameterSetExts.size());
      Iterator localIterator = sequenceParameterSetExts.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return localArrayList;
        }
        localArrayList.add(Frame.a((byte[])localIterator.next()));
      }
    }
    
    public List getSequenceParameterSetsAsStrings()
    {
      ArrayList localArrayList = new ArrayList(sequenceParameterSets.size());
      Iterator localIterator = sequenceParameterSets.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return localArrayList;
        }
        localArrayList.add(Frame.a((byte[])localIterator.next()));
      }
    }
  }
}
