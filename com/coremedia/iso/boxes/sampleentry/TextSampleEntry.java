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

public class TextSampleEntry
  extends AbstractSampleEntry
{
  public static final String TYPE1 = "tx3g";
  public static final String TYPE_ENCRYPTED = "enct";
  public int[] backgroundColorRgba = new int[4];
  public BoxRecord boxRecord = new BoxRecord();
  public long displayFlags;
  public int horizontalJustification;
  public StyleRecord styleRecord = new StyleRecord();
  public int verticalJustification;
  
  public TextSampleEntry()
  {
    super("tx3g");
  }
  
  public TextSampleEntry(String paramString)
  {
    super(paramString);
  }
  
  public int[] getBackgroundColorRgba()
  {
    return backgroundColorRgba;
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    ByteBuffer localByteBuffer = ByteBuffer.allocate(38);
    localByteBuffer.position(6);
    Label.append(localByteBuffer, dataReferenceIndex);
    localByteBuffer.putInt((int)displayFlags);
    localByteBuffer.put((byte)(horizontalJustification & 0xFF));
    localByteBuffer.put((byte)(verticalJustification & 0xFF));
    localByteBuffer.put((byte)(backgroundColorRgba[0] & 0xFF));
    localByteBuffer.put((byte)(backgroundColorRgba[1] & 0xFF));
    localByteBuffer.put((byte)(backgroundColorRgba[2] & 0xFF));
    localByteBuffer.put((byte)(backgroundColorRgba[3] & 0xFF));
    boxRecord.getContent(localByteBuffer);
    styleRecord.getContent(localByteBuffer);
    paramWritableByteChannel.write((ByteBuffer)localByteBuffer.rewind());
    ((e)this).writeContainer(paramWritableByteChannel);
  }
  
  public BoxRecord getBoxRecord()
  {
    return boxRecord;
  }
  
  public int getHorizontalJustification()
  {
    return horizontalJustification;
  }
  
  public long getSize()
  {
    long l = ((e)this).getContainerSize() + 38L;
    int i;
    if ((!largeBox) && (l < 4294967296L)) {
      i = 8;
    } else {
      i = 16;
    }
    return l + i;
  }
  
  public StyleRecord getStyleRecord()
  {
    return styleRecord;
  }
  
  public int getVerticalJustification()
  {
    return verticalJustification;
  }
  
  public boolean isContinuousKaraoke()
  {
    return (displayFlags & 0x800) == 2048L;
  }
  
  public boolean isFillTextRegion()
  {
    return (displayFlags & 0x40000) == 262144L;
  }
  
  public boolean isScrollDirection()
  {
    return (displayFlags & 0x180) == 384L;
  }
  
  public boolean isScrollIn()
  {
    return (displayFlags & 0x20) == 32L;
  }
  
  public boolean isScrollOut()
  {
    return (displayFlags & 0x40) == 64L;
  }
  
  public boolean isWriteTextVertically()
  {
    return (displayFlags & 0x20000) == 131072L;
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    paramByteBuffer = ByteBuffer.allocate(38);
    paramF.read(paramByteBuffer);
    paramByteBuffer.position(6);
    dataReferenceIndex = ByteBufferList.get(paramByteBuffer);
    displayFlags = ByteBufferList.readUInt32(paramByteBuffer);
    horizontalJustification = ByteBufferList.readUInt8(paramByteBuffer);
    verticalJustification = ByteBufferList.readUInt8(paramByteBuffer);
    backgroundColorRgba = new int[4];
    backgroundColorRgba[0] = ByteBufferList.readUInt8(paramByteBuffer);
    backgroundColorRgba[1] = ByteBufferList.readUInt8(paramByteBuffer);
    backgroundColorRgba[2] = ByteBufferList.readUInt8(paramByteBuffer);
    backgroundColorRgba[3] = ByteBufferList.readUInt8(paramByteBuffer);
    boxRecord = new BoxRecord();
    boxRecord.parse(paramByteBuffer);
    styleRecord = new StyleRecord();
    styleRecord.parse(paramByteBuffer);
    ((e)this).parseContainer(paramF, paramLong - 38L, paramA);
  }
  
  public void setBackgroundColorRgba(int[] paramArrayOfInt)
  {
    backgroundColorRgba = paramArrayOfInt;
  }
  
  public void setBoxRecord(BoxRecord paramBoxRecord)
  {
    boxRecord = paramBoxRecord;
  }
  
  public void setContinuousKaraoke(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      displayFlags |= 0x800;
      return;
    }
    displayFlags &= 0xFFFFFFFFFFFFF7FF;
  }
  
  public void setFillTextRegion(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      displayFlags |= 0x40000;
      return;
    }
    displayFlags &= 0xFFFFFFFFFFFBFFFF;
  }
  
  public void setHorizontalJustification(int paramInt)
  {
    horizontalJustification = paramInt;
  }
  
  public void setScrollDirection(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      displayFlags |= 0x180;
      return;
    }
    displayFlags &= 0xFFFFFFFFFFFFFE7F;
  }
  
  public void setScrollIn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      displayFlags |= 0x20;
      return;
    }
    displayFlags &= 0xFFFFFFFFFFFFFFDF;
  }
  
  public void setScrollOut(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      displayFlags |= 0x40;
      return;
    }
    displayFlags &= 0xFFFFFFFFFFFFFFBF;
  }
  
  public void setStyleRecord(StyleRecord paramStyleRecord)
  {
    styleRecord = paramStyleRecord;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public void setVerticalJustification(int paramInt)
  {
    verticalJustification = paramInt;
  }
  
  public void setWriteTextVertically(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      displayFlags |= 0x20000;
      return;
    }
    displayFlags &= 0xFFFFFFFFFFFDFFFF;
  }
  
  public String toString()
  {
    return "TextSampleEntry";
  }
  
  public static class BoxRecord
  {
    public int bottom;
    public int left;
    public int right;
    public int top;
    
    public BoxRecord() {}
    
    public BoxRecord(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      top = paramInt1;
      left = paramInt2;
      bottom = paramInt3;
      right = paramInt4;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (BoxRecord.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (BoxRecord)paramObject;
        if (bottom != bottom) {
          return false;
        }
        if (left != left) {
          return false;
        }
        if (right != right) {
          return false;
        }
        return top == top;
      }
      return false;
    }
    
    public void getContent(ByteBuffer paramByteBuffer)
    {
      Label.append(paramByteBuffer, top);
      Label.append(paramByteBuffer, left);
      Label.append(paramByteBuffer, bottom);
      Label.append(paramByteBuffer, right);
    }
    
    public int getSize()
    {
      return 8;
    }
    
    public int hashCode()
    {
      return ((top * 31 + left) * 31 + bottom) * 31 + right;
    }
    
    public void parse(ByteBuffer paramByteBuffer)
    {
      top = ByteBufferList.get(paramByteBuffer);
      left = ByteBufferList.get(paramByteBuffer);
      bottom = ByteBufferList.get(paramByteBuffer);
      right = ByteBufferList.get(paramByteBuffer);
    }
  }
  
  public static class StyleRecord
  {
    public int endChar;
    public int faceStyleFlags;
    public int fontId;
    public int fontSize;
    public int startChar;
    public int[] textColor = { 255, 255, 255, 255 };
    
    public StyleRecord() {}
    
    public StyleRecord(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
    {
      startChar = paramInt1;
      endChar = paramInt2;
      fontId = paramInt3;
      faceStyleFlags = paramInt4;
      fontSize = paramInt5;
      textColor = paramArrayOfInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (StyleRecord.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (StyleRecord)paramObject;
        if (endChar != endChar) {
          return false;
        }
        if (faceStyleFlags != faceStyleFlags) {
          return false;
        }
        if (fontId != fontId) {
          return false;
        }
        if (fontSize != fontSize) {
          return false;
        }
        if (startChar != startChar) {
          return false;
        }
        return Arrays.equals(textColor, textColor);
      }
      return false;
    }
    
    public void getContent(ByteBuffer paramByteBuffer)
    {
      Label.append(paramByteBuffer, startChar);
      Label.append(paramByteBuffer, endChar);
      Label.append(paramByteBuffer, fontId);
      paramByteBuffer.put((byte)(faceStyleFlags & 0xFF));
      paramByteBuffer.put((byte)(fontSize & 0xFF));
      paramByteBuffer.put((byte)(textColor[0] & 0xFF));
      paramByteBuffer.put((byte)(textColor[1] & 0xFF));
      paramByteBuffer.put((byte)(textColor[2] & 0xFF));
      paramByteBuffer.put((byte)(textColor[3] & 0xFF));
    }
    
    public int getSize()
    {
      return 12;
    }
    
    public int hashCode()
    {
      int j = startChar;
      int k = endChar;
      int m = fontId;
      int n = faceStyleFlags;
      int i1 = fontSize;
      int[] arrayOfInt = textColor;
      int i;
      if (arrayOfInt != null) {
        i = Arrays.hashCode(arrayOfInt);
      } else {
        i = 0;
      }
      return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i;
    }
    
    public void parse(ByteBuffer paramByteBuffer)
    {
      startChar = ByteBufferList.get(paramByteBuffer);
      endChar = ByteBufferList.get(paramByteBuffer);
      fontId = ByteBufferList.get(paramByteBuffer);
      faceStyleFlags = ByteBufferList.readUInt8(paramByteBuffer);
      fontSize = ByteBufferList.readUInt8(paramByteBuffer);
      textColor = new int[4];
      textColor[0] = ByteBufferList.readUInt8(paramByteBuffer);
      textColor[1] = ByteBufferList.readUInt8(paramByteBuffer);
      textColor[2] = ByteBufferList.readUInt8(paramByteBuffer);
      textColor[3] = ByteBufferList.readUInt8(paramByteBuffer);
    }
  }
}
