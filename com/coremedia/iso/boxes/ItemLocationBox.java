package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.slide.asm.ByteBufferList;
import f.slide.asm.ByteVector;
import f.slide.asm.Label;
import f.slide.asm.Request;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class ItemLocationBox
  extends MimeMessage
{
  public static final String TYPE = "iloc";
  public int baseOffsetSize = 8;
  public int indexSize = 0;
  public List<Item> items = new LinkedList();
  public int lengthSize = 8;
  public int offsetSize = 8;
  
  static {}
  
  public ItemLocationBox()
  {
    super("iloc");
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    int i = ByteBufferList.readUInt8(paramByteBuffer);
    offsetSize = (i >>> 4);
    lengthSize = (i & 0xF);
    i = ByteBufferList.readUInt8(paramByteBuffer);
    baseOffsetSize = (i >>> 4);
    if (getVersion() == 1) {
      indexSize = (i & 0xF);
    }
    int j = ByteBufferList.get(paramByteBuffer);
    i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      items.add(new Item(paramByteBuffer));
      i += 1;
    }
  }
  
  public Extent createExtent(long paramLong1, long paramLong2, long paramLong3)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_11, this, this, new Object[] { new Long(paramLong1), new Long(paramLong2), new Long(paramLong3) });
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return new Extent(paramLong1, paramLong2, paramLong3);
  }
  
  public Extent createExtent(ByteBuffer paramByteBuffer)
  {
    return new Extent(paramByteBuffer);
  }
  
  public Item createItem(int paramInt1, int paramInt2, int paramInt3, long paramLong, List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_10, this, this, new Object[] { new Integer(paramInt1), new Integer(paramInt2), new Integer(paramInt3), new Long(paramLong), paramList });
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return new Item(paramInt1, paramInt2, paramInt3, paramLong, paramList);
  }
  
  public Item createItem(ByteBuffer paramByteBuffer)
  {
    return new Item(paramByteBuffer);
  }
  
  public int getBaseOffsetSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_4, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return baseOffsetSize;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.put((byte)((offsetSize << 4 | lengthSize) & 0xFF));
    if (getVersion() == 1) {
      paramByteBuffer.put((byte)((baseOffsetSize << 4 | indexSize) & 0xFF));
    } else {
      paramByteBuffer.put((byte)(baseOffsetSize << 4 & 0xFF));
    }
    Label.append(paramByteBuffer, items.size());
    Iterator localIterator = items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((Item)localIterator.next()).getContent(paramByteBuffer);
    }
  }
  
  public long getContentSize()
  {
    Iterator localIterator = items.iterator();
    for (long l = 8L;; l += ((Item)localIterator.next()).getSize()) {
      if (!localIterator.hasNext()) {
        return l;
      }
    }
  }
  
  public int getIndexSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_6, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return indexSize;
  }
  
  public List getItems()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_8, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return items;
  }
  
  public int getLengthSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return lengthSize;
  }
  
  public int getOffsetSize()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return offsetSize;
  }
  
  public void setBaseOffsetSize(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_5, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    baseOffsetSize = paramInt;
  }
  
  public void setIndexSize(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_7, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    indexSize = paramInt;
  }
  
  public void setItems(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_9, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    items = paramList;
  }
  
  public void setLengthSize(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_3, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    lengthSize = paramInt;
  }
  
  public void setOffsetSize(int paramInt)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, new Integer(paramInt));
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    offsetSize = paramInt;
  }
  
  public class Extent
  {
    public long extentIndex;
    public long extentLength;
    public long extentOffset;
    
    public Extent(long paramLong1, long paramLong2, long paramLong3)
    {
      extentOffset = paramLong1;
      extentLength = paramLong2;
      extentIndex = paramLong3;
    }
    
    public Extent(ByteBuffer paramByteBuffer)
    {
      if (getVersion() == 1)
      {
        int i = indexSize;
        if (i > 0) {
          extentIndex = ByteVector.read(paramByteBuffer, i);
        }
      }
      extentOffset = ByteVector.read(paramByteBuffer, offsetSize);
      extentLength = ByteVector.read(paramByteBuffer, lengthSize);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (Extent.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (Extent)paramObject;
        if (extentIndex != extentIndex) {
          return false;
        }
        if (extentLength != extentLength) {
          return false;
        }
        return extentOffset == extentOffset;
      }
      return false;
    }
    
    public void getContent(ByteBuffer paramByteBuffer)
    {
      if (getVersion() == 1)
      {
        int i = indexSize;
        if (i > 0) {
          Request.write(extentIndex, paramByteBuffer, i);
        }
      }
      Request.write(extentOffset, paramByteBuffer, offsetSize);
      Request.write(extentLength, paramByteBuffer, lengthSize);
    }
    
    public int getSize()
    {
      int i = indexSize;
      if (i <= 0) {
        i = 0;
      }
      ItemLocationBox localItemLocationBox = ItemLocationBox.this;
      return i + offsetSize + lengthSize;
    }
    
    public int hashCode()
    {
      long l = extentOffset;
      int i = (int)(l ^ l >>> 32);
      l = extentLength;
      int j = (int)(l ^ l >>> 32);
      l = extentIndex;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Extent", "{extentOffset=");
      localStringBuilder.append(extentOffset);
      localStringBuilder.append(", extentLength=");
      localStringBuilder.append(extentLength);
      localStringBuilder.append(", extentIndex=");
      localStringBuilder.append(extentIndex);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public class Item
  {
    public long baseOffset;
    public int constructionMethod;
    public int dataReferenceIndex;
    public List<ItemLocationBox.Extent> extents = new LinkedList();
    public int itemId;
    
    public Item(int paramInt1, int paramInt2, int paramInt3, long paramLong, List paramList)
    {
      itemId = paramInt1;
      constructionMethod = paramInt2;
      dataReferenceIndex = paramInt3;
      baseOffset = paramLong;
      extents = paramList;
    }
    
    public Item(ByteBuffer paramByteBuffer)
    {
      itemId = ByteBufferList.get(paramByteBuffer);
      if (getVersion() == 1) {
        constructionMethod = (ByteBufferList.get(paramByteBuffer) & 0xF);
      }
      dataReferenceIndex = ByteBufferList.get(paramByteBuffer);
      int i = baseOffsetSize;
      if (i > 0) {
        baseOffset = ByteVector.read(paramByteBuffer, i);
      } else {
        baseOffset = 0L;
      }
      int j = ByteBufferList.get(paramByteBuffer);
      i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        extents.add(new ItemLocationBox.Extent(ItemLocationBox.this, paramByteBuffer));
        i += 1;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (Item.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (Item)paramObject;
        if (baseOffset != baseOffset) {
          return false;
        }
        if (constructionMethod != constructionMethod) {
          return false;
        }
        if (dataReferenceIndex != dataReferenceIndex) {
          return false;
        }
        if (itemId != itemId) {
          return false;
        }
        List localList = extents;
        if (localList != null)
        {
          if (!localList.equals(extents)) {
            return false;
          }
        }
        else
        {
          if (extents == null) {
            break label117;
          }
          return false;
        }
        return true;
      }
      else
      {
        return false;
      }
      label117:
      return true;
    }
    
    public void getContent(ByteBuffer paramByteBuffer)
    {
      Label.append(paramByteBuffer, itemId);
      if (getVersion() == 1) {
        Label.append(paramByteBuffer, constructionMethod);
      }
      Label.append(paramByteBuffer, dataReferenceIndex);
      int i = baseOffsetSize;
      if (i > 0) {
        Request.write(baseOffset, paramByteBuffer, i);
      }
      Label.append(paramByteBuffer, extents.size());
      Iterator localIterator = extents.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        ((ItemLocationBox.Extent)localIterator.next()).getContent(paramByteBuffer);
      }
    }
    
    public int getSize()
    {
      if (getVersion() == 1) {
        i = 4;
      } else {
        i = 2;
      }
      int i = i + 2 + baseOffsetSize + 2;
      Iterator localIterator = extents.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return i;
        }
        i += ((ItemLocationBox.Extent)localIterator.next()).getSize();
      }
    }
    
    public int hashCode()
    {
      int j = itemId;
      int k = constructionMethod;
      int m = dataReferenceIndex;
      long l = baseOffset;
      int n = (int)(l ^ l >>> 32);
      List localList = extents;
      int i;
      if (localList != null) {
        i = localList.hashCode();
      } else {
        i = 0;
      }
      return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
    }
    
    public void setBaseOffset(long paramLong)
    {
      baseOffset = paramLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Item{baseOffset=");
      localStringBuilder.append(baseOffset);
      localStringBuilder.append(", itemId=");
      localStringBuilder.append(itemId);
      localStringBuilder.append(", constructionMethod=");
      localStringBuilder.append(constructionMethod);
      localStringBuilder.append(", dataReferenceIndex=");
      localStringBuilder.append(dataReferenceIndex);
      localStringBuilder.append(", extents=");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(localStringBuilder, extents, '}');
    }
  }
}
