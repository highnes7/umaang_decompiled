package f.fasterxml.jackson.core.util;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class ByteArrayBuilder
  extends OutputStream
{
  public static final int DEFAULT_BLOCK_ARRAY_SIZE = 40;
  public static final int INITIAL_BLOCK_SIZE = 500;
  public static final int MAX_BLOCK_SIZE = 262144;
  public static final byte[] NO_BYTES = new byte[0];
  public final BufferRecycler _bufferRecycler;
  public byte[] _currBlock;
  public int _currBlockPtr;
  public final LinkedList<byte[]> _pastBlocks = new LinkedList();
  public int _pastLen;
  
  public ByteArrayBuilder()
  {
    this(null, 500);
  }
  
  public ByteArrayBuilder(int paramInt)
  {
    this(null, paramInt);
  }
  
  public ByteArrayBuilder(BufferRecycler paramBufferRecycler)
  {
    this(paramBufferRecycler, 500);
  }
  
  public ByteArrayBuilder(BufferRecycler paramBufferRecycler, int paramInt)
  {
    _bufferRecycler = paramBufferRecycler;
    if (paramBufferRecycler == null)
    {
      _currBlock = new byte[paramInt];
      return;
    }
    _currBlock = paramBufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER);
  }
  
  private void _allocMore()
  {
    _pastLen += _currBlock.length;
    int j = Math.max(_pastLen >> 1, 1000);
    int i = j;
    if (j > 262144) {
      i = 262144;
    }
    _pastBlocks.add(_currBlock);
    _currBlock = new byte[i];
    _currBlockPtr = 0;
  }
  
  public void append(int paramInt)
  {
    if (_currBlockPtr >= _currBlock.length) {
      _allocMore();
    }
    byte[] arrayOfByte = _currBlock;
    int i = _currBlockPtr;
    _currBlockPtr = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }
  
  public void appendThreeBytes(int paramInt)
  {
    int i = _currBlockPtr;
    byte[] arrayOfByte = _currBlock;
    if (i + 2 < arrayOfByte.length)
    {
      _currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 16));
      i = _currBlockPtr;
      _currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      i = _currBlockPtr;
      _currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    append(paramInt >> 16);
    append(paramInt >> 8);
    append(paramInt);
  }
  
  public void appendTwoBytes(int paramInt)
  {
    int i = _currBlockPtr;
    byte[] arrayOfByte = _currBlock;
    if (i + 1 < arrayOfByte.length)
    {
      _currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      i = _currBlockPtr;
      _currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    append(paramInt >> 8);
    append(paramInt);
  }
  
  public void close() {}
  
  public byte[] completeAndCoalesce(int paramInt)
  {
    _currBlockPtr = paramInt;
    return toByteArray();
  }
  
  public byte[] finishCurrentSegment()
  {
    _allocMore();
    return _currBlock;
  }
  
  public void flush() {}
  
  public byte[] getCurrentSegment()
  {
    return _currBlock;
  }
  
  public int getCurrentSegmentLength()
  {
    return _currBlockPtr;
  }
  
  public void release()
  {
    reset();
    BufferRecycler localBufferRecycler = _bufferRecycler;
    if (localBufferRecycler != null)
    {
      byte[] arrayOfByte = _currBlock;
      if (arrayOfByte != null)
      {
        localBufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER, arrayOfByte);
        _currBlock = null;
      }
    }
  }
  
  public void reset()
  {
    _pastLen = 0;
    _currBlockPtr = 0;
    if (!_pastBlocks.isEmpty()) {
      _pastBlocks.clear();
    }
  }
  
  public byte[] resetAndGetFirstSegment()
  {
    reset();
    return _currBlock;
  }
  
  public void setCurrentSegmentLength(int paramInt)
  {
    _currBlockPtr = paramInt;
  }
  
  public byte[] toByteArray()
  {
    int j = _pastLen + _currBlockPtr;
    if (j == 0) {
      return NO_BYTES;
    }
    Object localObject = new byte[j];
    Iterator localIterator = _pastBlocks.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte = (byte[])localIterator.next();
      int k = arrayOfByte.length;
      System.arraycopy(arrayOfByte, 0, localObject, i, k);
      i += k;
    }
    System.arraycopy(_currBlock, 0, localObject, i, _currBlockPtr);
    i += _currBlockPtr;
    if (i == j)
    {
      if (!_pastBlocks.isEmpty())
      {
        reset();
        return localObject;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Internal error: total len assumed to be ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", copied ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" bytes");
      localObject = new RuntimeException(((StringBuilder)localObject).toString());
      throw ((Throwable)localObject);
    }
    return localObject;
  }
  
  public void write(int paramInt)
  {
    append(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      int k = Math.min(_currBlock.length - _currBlockPtr, paramInt2);
      int j = i;
      paramInt1 = paramInt2;
      if (k > 0)
      {
        System.arraycopy(paramArrayOfByte, i, _currBlock, _currBlockPtr, k);
        j = i + k;
        _currBlockPtr += k;
        paramInt1 = paramInt2 - k;
      }
      if (paramInt1 <= 0) {
        return;
      }
      _allocMore();
      i = j;
      paramInt2 = paramInt1;
    }
  }
}
