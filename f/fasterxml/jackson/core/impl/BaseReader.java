package f.fasterxml.jackson.core.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public abstract class BaseReader
  extends Reader
{
  public static final int LAST_VALID_UNICODE_CHAR = 1114111;
  public static final char NULL_BYTE = '\000';
  public static final char NULL_CHAR = '\000';
  public byte[] _buffer;
  public final IOContext _context;
  public InputStream _in;
  public int _length;
  public int _ptr;
  public char[] _tmpBuf = null;
  
  public BaseReader(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _context = paramIOContext;
    _in = paramInputStream;
    _buffer = paramArrayOfByte;
    _ptr = paramInt1;
    _length = paramInt2;
  }
  
  public void close()
    throws IOException
  {
    InputStream localInputStream = _in;
    if (localInputStream != null)
    {
      _in = null;
      freeBuffers();
      localInputStream.close();
    }
  }
  
  public final void freeBuffers()
  {
    byte[] arrayOfByte = _buffer;
    if (arrayOfByte != null)
    {
      _buffer = null;
      _context.releaseReadIOBuffer(arrayOfByte);
    }
  }
  
  public int read()
    throws IOException
  {
    if (_tmpBuf == null) {
      _tmpBuf = new char[1];
    }
    if (read(_tmpBuf, 0, 1) < 1) {
      return -1;
    }
    return _tmpBuf[0];
  }
  
  public void reportBounds(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("read(buf,");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("), cbuf[");
    throw new ArrayIndexOutOfBoundsException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, paramArrayOfChar.length, "]"));
  }
  
  public void reportStrangeStream()
    throws IOException
  {
    throw new IOException("Strange I/O stream, returned 0 bytes on read");
  }
}
