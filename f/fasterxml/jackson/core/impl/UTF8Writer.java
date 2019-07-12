package f.fasterxml.jackson.core.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class UTF8Writer
  extends Writer
{
  public static final int SURR1_FIRST = 55296;
  public static final int SURR1_LAST = 56319;
  public static final int SURR2_FIRST = 56320;
  public static final int SURR2_LAST = 57343;
  public final IOContext _context;
  public OutputStream _out;
  public byte[] _outBuffer;
  public final int _outBufferEnd;
  public int _outPtr;
  public int _surrogate = 0;
  
  public UTF8Writer(IOContext paramIOContext, OutputStream paramOutputStream)
  {
    _context = paramIOContext;
    _out = paramOutputStream;
    _outBuffer = paramIOContext.allocWriteEncodingBuffer();
    _outBufferEnd = (_outBuffer.length - 4);
    _outPtr = 0;
  }
  
  private int convertSurrogate(int paramInt)
    throws IOException
  {
    int i = _surrogate;
    _surrogate = 0;
    if ((paramInt >= 56320) && (paramInt <= 57343)) {
      return paramInt - 56320 + ((i - 55296 << 10) + 65536);
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Broken surrogate pair: first char 0x");
    localStringBuilder.append(Integer.toHexString(i));
    localStringBuilder.append(", second 0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    localStringBuilder.append("; illegal combination");
    throw new IOException(localStringBuilder.toString());
  }
  
  private void throwIllegal(int paramInt)
    throws IOException
  {
    if (paramInt <= 1114111)
    {
      if (paramInt >= 55296)
      {
        if (paramInt <= 56319)
        {
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unmatched first part of surrogate pair (0x");
          localStringBuilder.append(Integer.toHexString(paramInt));
          localStringBuilder.append(")");
          throw new IOException(localStringBuilder.toString());
        }
        localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unmatched second part of surrogate pair (0x");
        localStringBuilder.append(Integer.toHexString(paramInt));
        localStringBuilder.append(")");
        throw new IOException(localStringBuilder.toString());
      }
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal character point (0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(") to output");
      throw new IOException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal character point (0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    localStringBuilder.append(") to output; max is 0x10FFFF as per RFC 4627");
    throw new IOException(localStringBuilder.toString());
  }
  
  public Writer append(char paramChar)
    throws IOException
  {
    write(paramChar);
    return this;
  }
  
  public void close()
    throws IOException
  {
    OutputStream localOutputStream = _out;
    if (localOutputStream != null)
    {
      int i = _outPtr;
      if (i > 0)
      {
        localOutputStream.write(_outBuffer, 0, i);
        _outPtr = 0;
      }
      localOutputStream = _out;
      _out = null;
      byte[] arrayOfByte = _outBuffer;
      if (arrayOfByte != null)
      {
        _outBuffer = null;
        _context.releaseWriteEncodingBuffer(arrayOfByte);
      }
      localOutputStream.close();
      i = _surrogate;
      _surrogate = 0;
      if (i <= 0) {
        return;
      }
      throwIllegal(i);
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  public void flush()
    throws IOException
  {
    OutputStream localOutputStream = _out;
    if (localOutputStream != null)
    {
      int i = _outPtr;
      if (i > 0)
      {
        localOutputStream.write(_outBuffer, 0, i);
        _outPtr = 0;
      }
      _out.flush();
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    int i;
    if (_surrogate > 0)
    {
      i = convertSurrogate(paramInt);
    }
    else
    {
      i = paramInt;
      if (paramInt >= 55296)
      {
        i = paramInt;
        if (paramInt <= 57343)
        {
          if (paramInt <= 56319)
          {
            _surrogate = paramInt;
            return;
          }
          throwIllegal(paramInt);
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
      }
    }
    paramInt = _outPtr;
    if (paramInt >= _outBufferEnd)
    {
      _out.write(_outBuffer, 0, paramInt);
      _outPtr = 0;
    }
    byte[] arrayOfByte;
    if (i < 128)
    {
      arrayOfByte = _outBuffer;
      paramInt = _outPtr;
      _outPtr = (paramInt + 1);
      arrayOfByte[paramInt] = ((byte)i);
      return;
    }
    paramInt = _outPtr;
    int j;
    if (i < 2048)
    {
      arrayOfByte = _outBuffer;
      j = paramInt + 1;
      arrayOfByte[paramInt] = ((byte)(i >> 6 | 0xC0));
      paramInt = j + 1;
      arrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
    }
    else if (i <= 65535)
    {
      arrayOfByte = _outBuffer;
      j = paramInt + 1;
      arrayOfByte[paramInt] = ((byte)(i >> 12 | 0xE0));
      paramInt = j + 1;
      arrayOfByte[j] = ((byte)(i >> 6 & 0x3F | 0x80));
      arrayOfByte[paramInt] = ((byte)(i & 0x3F | 0x80));
      paramInt += 1;
    }
    else
    {
      if (i > 1114111) {
        break label338;
      }
      arrayOfByte = _outBuffer;
      j = paramInt + 1;
      arrayOfByte[paramInt] = ((byte)(i >> 18 | 0xF0));
      paramInt = j + 1;
      arrayOfByte[j] = ((byte)(i >> 12 & 0x3F | 0x80));
      j = paramInt + 1;
      arrayOfByte[paramInt] = ((byte)(i >> 6 & 0x3F | 0x80));
      paramInt = j + 1;
      arrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
    }
    _outPtr = paramInt;
    return;
    label338:
    throwIllegal(i);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void write(String paramString)
    throws IOException
  {
    write(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1) {
        write(paramString.charAt(paramInt1));
      }
    }
    else
    {
      int i = paramInt1;
      int j = paramInt2;
      if (_surrogate > 0)
      {
        i = paramString.charAt(paramInt1);
        j = paramInt2 - 1;
        write(convertSurrogate(i));
        i = paramInt1 + 1;
      }
      paramInt1 = _outPtr;
      byte[] arrayOfByte = _outBuffer;
      int i1 = _outBufferEnd;
      int i2 = j + i;
      paramInt2 = i;
      for (;;)
      {
        i = paramInt1;
        if (paramInt2 >= i2) {
          break;
        }
        i = paramInt1;
        if (paramInt1 >= i1)
        {
          _out.write(arrayOfByte, 0, paramInt1);
          i = 0;
        }
        j = paramInt2 + 1;
        int m = paramString.charAt(paramInt2);
        int k = m;
        paramInt2 = i;
        paramInt1 = j;
        if (m < 128)
        {
          paramInt2 = i + 1;
          arrayOfByte[i] = ((byte)m);
          paramInt1 = i2 - j;
          k = i1 - paramInt2;
          i = paramInt1;
          if (paramInt1 > k) {
            i = k;
          }
          for (paramInt1 = j;; paramInt1 = m)
          {
            m = paramInt1;
            k = m;
            paramInt1 = paramInt2;
            if (m >= i + j)
            {
              paramInt2 = k;
              break;
            }
            m += 1;
            int n = paramString.charAt(k);
            k = n;
            if (n >= 128)
            {
              paramInt2 = paramInt1;
              paramInt1 = m;
              break label266;
            }
            paramInt2 += 1;
            arrayOfByte[paramInt1] = ((byte)n);
          }
        }
        label266:
        if (k < 2048)
        {
          j = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(k >> 6 | 0xC0));
          i = j + 1;
          arrayOfByte[j] = ((byte)(k & 0x3F | 0x80));
          paramInt2 = paramInt1;
          paramInt1 = i;
        }
        else if ((k >= 55296) && (k <= 57343))
        {
          if (k <= 56319)
          {
            _surrogate = k;
            if (paramInt1 >= i2)
            {
              i = paramInt2;
              break;
            }
            i = paramInt1 + 1;
            j = convertSurrogate(paramString.charAt(paramInt1));
            if (j <= 1114111)
            {
              paramInt1 = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(j >> 18 | 0xF0));
              paramInt2 = paramInt1 + 1;
              arrayOfByte[paramInt1] = ((byte)(j >> 12 & 0x3F | 0x80));
              k = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(j >> 6 & 0x3F | 0x80));
              paramInt1 = k + 1;
              arrayOfByte[k] = ((byte)(j & 0x3F | 0x80));
              paramInt2 = i;
            }
            else
            {
              _outPtr = paramInt2;
              throwIllegal(j);
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
          }
          else
          {
            _outPtr = paramInt2;
            throwIllegal(k);
            throw new NullPointerException("Null throw statement replaced by Soot");
          }
        }
        else
        {
          i = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(k >> 12 | 0xE0));
          j = i + 1;
          arrayOfByte[i] = ((byte)(k >> 6 & 0x3F | 0x80));
          arrayOfByte[j] = ((byte)(k & 0x3F | 0x80));
          paramInt2 = paramInt1;
          paramInt1 = j + 1;
        }
      }
      _outPtr = i;
    }
  }
  
  public void write(char[] paramArrayOfChar)
    throws IOException
  {
    write(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1) {
        write(paramArrayOfChar[paramInt1]);
      }
    }
    else
    {
      int i = paramInt1;
      int j = paramInt2;
      if (_surrogate > 0)
      {
        i = paramArrayOfChar[paramInt1];
        j = paramInt2 - 1;
        write(convertSurrogate(i));
        i = paramInt1 + 1;
      }
      paramInt1 = _outPtr;
      byte[] arrayOfByte = _outBuffer;
      int n = _outBufferEnd;
      int i1 = j + i;
      paramInt2 = i;
      for (;;)
      {
        i = paramInt1;
        if (paramInt2 >= i1) {
          break;
        }
        i = paramInt1;
        if (paramInt1 >= n)
        {
          _out.write(arrayOfByte, 0, paramInt1);
          i = 0;
        }
        j = paramInt2 + 1;
        int m = paramArrayOfChar[paramInt2];
        int k = m;
        paramInt2 = i;
        paramInt1 = j;
        if (m < 128)
        {
          paramInt2 = i + 1;
          arrayOfByte[i] = ((byte)m);
          paramInt1 = i1 - j;
          k = n - paramInt2;
          i = paramInt1;
          if (paramInt1 > k) {
            i = k;
          }
          for (paramInt1 = j;; paramInt1 = m)
          {
            m = paramInt1;
            k = m;
            paramInt1 = paramInt2;
            if (m >= i + j)
            {
              paramInt2 = k;
              break;
            }
            m += 1;
            k = paramArrayOfChar[k];
            if (k >= 128)
            {
              paramInt2 = paramInt1;
              paramInt1 = m;
              break label254;
            }
            paramInt2 += 1;
            arrayOfByte[paramInt1] = ((byte)k);
          }
        }
        label254:
        if (k < 2048)
        {
          j = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(k >> 6 | 0xC0));
          i = j + 1;
          arrayOfByte[j] = ((byte)(k & 0x3F | 0x80));
          paramInt2 = paramInt1;
          paramInt1 = i;
        }
        else if ((k >= 55296) && (k <= 57343))
        {
          if (k <= 56319)
          {
            _surrogate = k;
            if (paramInt1 >= i1)
            {
              i = paramInt2;
              break;
            }
            i = paramInt1 + 1;
            j = convertSurrogate(paramArrayOfChar[paramInt1]);
            if (j <= 1114111)
            {
              paramInt1 = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(j >> 18 | 0xF0));
              paramInt2 = paramInt1 + 1;
              arrayOfByte[paramInt1] = ((byte)(j >> 12 & 0x3F | 0x80));
              k = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(j >> 6 & 0x3F | 0x80));
              paramInt1 = k + 1;
              arrayOfByte[k] = ((byte)(j & 0x3F | 0x80));
              paramInt2 = i;
            }
            else
            {
              _outPtr = paramInt2;
              throwIllegal(j);
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
          }
          else
          {
            _outPtr = paramInt2;
            throwIllegal(k);
            throw new NullPointerException("Null throw statement replaced by Soot");
          }
        }
        else
        {
          i = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(k >> 12 | 0xE0));
          j = i + 1;
          arrayOfByte[i] = ((byte)(k >> 6 & 0x3F | 0x80));
          arrayOfByte[j] = ((byte)(k & 0x3F | 0x80));
          paramInt2 = paramInt1;
          paramInt1 = j + 1;
        }
      }
      _outPtr = i;
    }
  }
}
