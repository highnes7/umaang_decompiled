package f.fasterxml.jackson.core.impl;

import java.io.IOException;
import java.io.InputStream;

public final class MergedStream
  extends InputStream
{
  public byte[] _buffer;
  public final IOContext _context;
  public final int _end;
  public final InputStream _in;
  public int _ptr;
  
  public MergedStream(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _context = paramIOContext;
    _in = paramInputStream;
    _buffer = paramArrayOfByte;
    _ptr = paramInt1;
    _end = paramInt2;
  }
  
  private void freeMergedBuffer()
  {
    byte[] arrayOfByte = _buffer;
    if (arrayOfByte != null)
    {
      _buffer = null;
      IOContext localIOContext = _context;
      if (localIOContext != null) {
        localIOContext.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  public int available()
    throws IOException
  {
    if (_buffer != null) {
      return _end - _ptr;
    }
    return _in.available();
  }
  
  public void close()
    throws IOException
  {
    freeMergedBuffer();
    _in.close();
  }
  
  public void mark(int paramInt)
  {
    if (_buffer == null) {
      _in.mark(paramInt);
    }
  }
  
  public boolean markSupported()
  {
    return (_buffer == null) && (_in.markSupported());
  }
  
  public int read()
    throws IOException
  {
    byte[] arrayOfByte = _buffer;
    int i;
    if (arrayOfByte != null)
    {
      i = _ptr;
      _ptr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (_ptr >= _end)
      {
        freeMergedBuffer();
        return i;
      }
    }
    else
    {
      return _in.read();
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    if (_buffer != null)
    {
      int j = _end - _ptr;
      i = paramInt2;
      if (paramInt2 > j) {
        i = j;
      }
      System.arraycopy(_buffer, _ptr, paramArrayOfByte, paramInt1, i);
      _ptr += i;
      if (_ptr >= _end)
      {
        freeMergedBuffer();
        return i;
      }
    }
    else
    {
      return _in.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    return i;
  }
  
  public void reset()
    throws IOException
  {
    if (_buffer == null) {
      _in.reset();
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l2;
    long l1;
    if (_buffer != null)
    {
      int i = _end;
      int j = _ptr;
      l2 = i - j;
      if (l2 > paramLong)
      {
        _ptr = (j + (int)paramLong);
        return paramLong;
      }
      freeMergedBuffer();
      l1 = l2 + 0L;
      l2 = paramLong - l2;
      paramLong = l1;
      l1 = l2;
    }
    else
    {
      l2 = 0L;
      l1 = paramLong;
      paramLong = l2;
    }
    if (l1 > 0L) {
      return paramLong + _in.skip(l1);
    }
    return paramLong;
  }
}
