package f.fasterxml.jackson.core.impl;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

public class UTF32Reader
  extends BaseReader
{
  public final boolean _bigEndian;
  public int _byteCount;
  public int _charCount;
  public final boolean _managedBuffers;
  public char _surrogate;
  
  public UTF32Reader(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramIOContext, paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    boolean bool = false;
    _surrogate = '\000';
    _charCount = 0;
    _byteCount = 0;
    _bigEndian = paramBoolean;
    paramBoolean = bool;
    if (paramInputStream != null) {
      paramBoolean = true;
    }
    _managedBuffers = paramBoolean;
  }
  
  private boolean loadMore(int paramInt)
    throws IOException
  {
    int i = _byteCount;
    _byteCount = (_length - paramInt + i);
    Object localObject;
    if (paramInt > 0)
    {
      if (_ptr > 0)
      {
        i = 0;
        while (i < paramInt)
        {
          localObject = _buffer;
          localObject[i] = localObject[(_ptr + i)];
          i += 1;
        }
        _ptr = 0;
      }
      _length = paramInt;
    }
    else
    {
      _ptr = 0;
      localObject = _in;
      if (localObject == null) {
        paramInt = -1;
      } else {
        paramInt = ((InputStream)localObject).read(_buffer);
      }
      if (paramInt < 1)
      {
        _length = 0;
        if (paramInt < 0)
        {
          if (!_managedBuffers) {
            break label236;
          }
          freeBuffers();
          return false;
        }
        reportStrangeStream();
      }
    }
    for (_length = paramInt;; _length += paramInt)
    {
      paramInt = _length;
      if (paramInt >= 4) {
        break;
      }
      localObject = _in;
      if (localObject == null)
      {
        paramInt = -1;
      }
      else
      {
        byte[] arrayOfByte = _buffer;
        paramInt = ((InputStream)localObject).read(arrayOfByte, paramInt, arrayOfByte.length - paramInt);
      }
      if (paramInt < 1)
      {
        if (paramInt < 0)
        {
          if (_managedBuffers) {
            freeBuffers();
          }
          reportUnexpectedEOF(_length, 4);
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
        reportStrangeStream();
      }
    }
    return true;
    label236:
    return false;
  }
  
  private void reportInvalid(int paramInt1, int paramInt2, String paramString)
    throws IOException
  {
    int i = _byteCount;
    int j = _ptr;
    int k = _charCount;
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Invalid UTF-32 character 0x");
    localStringBuilder.append(Integer.toHexString(paramInt1));
    localStringBuilder.append(paramString);
    localStringBuilder.append(" at char #");
    localStringBuilder.append(k + paramInt2);
    localStringBuilder.append(", byte #");
    throw new CharConversionException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, i + j - 1, ")"));
  }
  
  private void reportUnexpectedEOF(int paramInt1, int paramInt2)
    throws IOException
  {
    int i = _byteCount;
    int j = _charCount;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected EOF in the middle of a 4-byte UTF-32 char: got ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", needed ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", at char #");
    localStringBuilder.append(j);
    localStringBuilder.append(", byte #");
    localStringBuilder.append(i + paramInt1);
    localStringBuilder.append(")");
    throw new CharConversionException(localStringBuilder.toString());
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_buffer == null) {
      return -1;
    }
    if (paramInt2 < 1) {
      return paramInt2;
    }
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
      reportBounds(paramArrayOfChar, paramInt1, paramInt2);
    }
    int n = paramInt2 + paramInt1;
    int i = _surrogate;
    if (i != 0)
    {
      paramInt2 = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = i;
      _surrogate = '\000';
    }
    else
    {
      paramInt2 = _length - _ptr;
      if ((paramInt2 < 4) && (!loadMore(paramInt2))) {
        return -1;
      }
      paramInt2 = paramInt1;
    }
    while (paramInt2 < n)
    {
      int j = _ptr;
      byte[] arrayOfByte;
      if (_bigEndian)
      {
        arrayOfByte = _buffer;
        k = arrayOfByte[j] << 24 | (arrayOfByte[(j + 1)] & 0xFF) << 16 | (arrayOfByte[(j + 2)] & 0xFF) << 8;
        j = arrayOfByte[(j + 3)] & 0xFF;
      }
      else
      {
        arrayOfByte = _buffer;
        k = arrayOfByte[j] & 0xFF | (arrayOfByte[(j + 1)] & 0xFF) << 8 | (arrayOfByte[(j + 2)] & 0xFF) << 16;
        j = arrayOfByte[(j + 3)] << 24;
      }
      int m = j | k;
      _ptr += 4;
      j = paramInt2;
      int k = m;
      if (m > 65535) {
        if (m <= 1114111)
        {
          k = m - 65536;
          j = paramInt2 + 1;
          paramArrayOfChar[paramInt2] = ((char)((k >> 10) + 55296));
          k = k & 0x3FF | 0xDC00;
          if (j >= n)
          {
            _surrogate = ((char)k);
            paramInt2 = j;
            break;
          }
        }
        else
        {
          paramArrayOfChar = f.sufficientlysecure.rootcommands.util.StringBuilder.append("(above ");
          paramArrayOfChar.append(Integer.toHexString(1114111));
          paramArrayOfChar.append(") ");
          reportInvalid(m, paramInt2 - paramInt1, paramArrayOfChar.toString());
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
      }
      paramInt2 = j + 1;
      paramArrayOfChar[j] = ((char)k);
      if (_ptr >= _length) {
        break;
      }
    }
    paramInt1 = paramInt2 - paramInt1;
    _charCount += paramInt1;
    return paramInt1;
  }
}
