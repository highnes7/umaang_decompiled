package f.fasterxml.jackson.core.impl;

import f.fasterxml.jackson.core.JsonEncoding;
import f.fasterxml.jackson.core.util.BufferRecycler;
import f.fasterxml.jackson.core.util.BufferRecycler.ByteBufferType;
import f.fasterxml.jackson.core.util.BufferRecycler.CharBufferType;
import f.fasterxml.jackson.core.util.TextBuffer;

public final class IOContext
{
  public byte[] _base64Buffer = null;
  public final BufferRecycler _bufferRecycler;
  public char[] _concatCBuffer = null;
  public JsonEncoding _encoding;
  public final boolean _managedResource;
  public char[] _nameCopyBuffer = null;
  public byte[] _readIOBuffer = null;
  public final Object _sourceRef;
  public char[] _tokenCBuffer = null;
  public byte[] _writeEncodingBuffer = null;
  
  public IOContext(BufferRecycler paramBufferRecycler, Object paramObject, boolean paramBoolean)
  {
    _bufferRecycler = paramBufferRecycler;
    _sourceRef = paramObject;
    _managedResource = paramBoolean;
  }
  
  public byte[] allocBase64Buffer()
  {
    if (_base64Buffer == null)
    {
      _base64Buffer = _bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.BASE64_CODEC_BUFFER);
      return _base64Buffer;
    }
    throw new IllegalStateException("Trying to call allocBase64Buffer() second time");
  }
  
  public char[] allocConcatBuffer()
  {
    if (_concatCBuffer == null)
    {
      _concatCBuffer = _bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.CONCAT_BUFFER);
      return _concatCBuffer;
    }
    throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
  }
  
  public char[] allocNameCopyBuffer(int paramInt)
  {
    if (_nameCopyBuffer == null)
    {
      _nameCopyBuffer = _bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, paramInt);
      return _nameCopyBuffer;
    }
    throw new IllegalStateException("Trying to call allocNameCopyBuffer() second time");
  }
  
  public byte[] allocReadIOBuffer()
  {
    if (_readIOBuffer == null)
    {
      _readIOBuffer = _bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.READ_IO_BUFFER);
      return _readIOBuffer;
    }
    throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
  }
  
  public char[] allocTokenBuffer()
  {
    if (_tokenCBuffer == null)
    {
      _tokenCBuffer = _bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.TOKEN_BUFFER);
      return _tokenCBuffer;
    }
    throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
  }
  
  public byte[] allocWriteEncodingBuffer()
  {
    if (_writeEncodingBuffer == null)
    {
      _writeEncodingBuffer = _bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.WRITE_ENCODING_BUFFER);
      return _writeEncodingBuffer;
    }
    throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
  }
  
  public TextBuffer constructTextBuffer()
  {
    return new TextBuffer(_bufferRecycler);
  }
  
  public JsonEncoding getEncoding()
  {
    return _encoding;
  }
  
  public Object getSourceReference()
  {
    return _sourceRef;
  }
  
  public boolean isResourceManaged()
  {
    return _managedResource;
  }
  
  public void releaseBase64Buffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte == _base64Buffer)
      {
        _base64Buffer = null;
        _bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.BASE64_CODEC_BUFFER, paramArrayOfByte);
        return;
      }
      throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
  }
  
  public void releaseConcatBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar == _concatCBuffer)
      {
        _concatCBuffer = null;
        _bufferRecycler.releaseCharBuffer(BufferRecycler.CharBufferType.CONCAT_BUFFER, paramArrayOfChar);
        return;
      }
      throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
  }
  
  public void releaseNameCopyBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar == _nameCopyBuffer)
      {
        _nameCopyBuffer = null;
        _bufferRecycler.releaseCharBuffer(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, paramArrayOfChar);
        return;
      }
      throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
  }
  
  public void releaseReadIOBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte == _readIOBuffer)
      {
        _readIOBuffer = null;
        _bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.READ_IO_BUFFER, paramArrayOfByte);
        return;
      }
      throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
  }
  
  public void releaseTokenBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar == _tokenCBuffer)
      {
        _tokenCBuffer = null;
        _bufferRecycler.releaseCharBuffer(BufferRecycler.CharBufferType.TOKEN_BUFFER, paramArrayOfChar);
        return;
      }
      throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
  }
  
  public void releaseWriteEncodingBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte == _writeEncodingBuffer)
      {
        _writeEncodingBuffer = null;
        _bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.WRITE_ENCODING_BUFFER, paramArrayOfByte);
        return;
      }
      throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
  }
  
  public void setEncoding(JsonEncoding paramJsonEncoding)
  {
    _encoding = paramJsonEncoding;
  }
}
