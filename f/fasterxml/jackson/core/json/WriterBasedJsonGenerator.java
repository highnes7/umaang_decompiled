package f.fasterxml.jackson.core.json;

import f.fasterxml.jackson.core.'annotation'.GeneratorBase;
import f.fasterxml.jackson.core.Base64Variant;
import f.fasterxml.jackson.core.JsonGenerationException;
import f.fasterxml.jackson.core.JsonGenerator;
import f.fasterxml.jackson.core.JsonGenerator.Feature;
import f.fasterxml.jackson.core.JsonStreamContext;
import f.fasterxml.jackson.core.ObjectCodec;
import f.fasterxml.jackson.core.PrettyPrinter;
import f.fasterxml.jackson.core.SerializableString;
import f.fasterxml.jackson.core.impl.CharacterEscapes;
import f.fasterxml.jackson.core.impl.IOContext;
import f.fasterxml.jackson.core.impl.Utf8StreamParser;
import f.fasterxml.jackson.core.impl.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class WriterBasedJsonGenerator
  extends JsonGeneratorImpl
{
  public static final char[] HEX_CHARS = ;
  public static final int SHORT_WRITE = 32;
  public SerializableString _currentEscape;
  public char[] _entityBuffer;
  public char[] _outputBuffer;
  public int _outputEnd;
  public int _outputHead = 0;
  public int _outputTail = 0;
  public final Writer _writer;
  
  public WriterBasedJsonGenerator(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec, Writer paramWriter)
  {
    super(paramIOContext, paramInt, paramObjectCodec);
    _writer = paramWriter;
    _outputBuffer = paramIOContext.allocConcatBuffer();
    _outputEnd = _outputBuffer.length;
  }
  
  private char[] _allocateEntityBuffer()
  {
    char[] arrayOfChar = new char[14];
    arrayOfChar[0] = '\\';
    arrayOfChar[2] = '\\';
    arrayOfChar[3] = 'u';
    arrayOfChar[4] = '0';
    arrayOfChar[5] = '0';
    arrayOfChar[8] = '\\';
    arrayOfChar[9] = 'u';
    _entityBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  private void _appendCharacterEscape(char paramChar, int paramInt)
    throws IOException, JsonGenerationException
  {
    if (paramInt >= 0)
    {
      if (_outputTail + 2 > _outputEnd) {
        _flushBuffer();
      }
      localObject = _outputBuffer;
      paramChar = _outputTail;
      _outputTail = (paramChar + '\001');
      localObject[paramChar] = 92;
      paramChar = _outputTail;
      _outputTail = (paramChar + '\001');
      localObject[paramChar] = ((char)paramInt);
      return;
    }
    if (paramInt != -2)
    {
      if (_outputTail + 2 > _outputEnd) {
        _flushBuffer();
      }
      paramInt = _outputTail;
      localObject = _outputBuffer;
      int i = paramInt + 1;
      localObject[paramInt] = 92;
      paramInt = i + 1;
      localObject[i] = 117;
      if (paramChar > '?')
      {
        i = 0xFF & paramChar >> '\b';
        int j = paramInt + 1;
        arrayOfChar = HEX_CHARS;
        localObject[paramInt] = arrayOfChar[(i >> 4)];
        paramInt = j + 1;
        localObject[j] = arrayOfChar[(i & 0xF)];
        paramChar = (char)(paramChar & 0xFF);
      }
      else
      {
        i = paramInt + 1;
        localObject[paramInt] = 48;
        paramInt = i + 1;
        localObject[i] = 48;
      }
      i = paramInt + 1;
      char[] arrayOfChar = HEX_CHARS;
      localObject[paramInt] = arrayOfChar[(paramChar >> '\004')];
      localObject[i] = arrayOfChar[(paramChar & 0xF)];
      _outputTail = i;
      return;
    }
    Object localObject = _currentEscape;
    if (localObject == null)
    {
      localObject = _characterEscapes.getEscapeSequence(paramChar).getValue();
    }
    else
    {
      localObject = ((SerializableString)localObject).getValue();
      _currentEscape = null;
    }
    paramChar = ((String)localObject).length();
    if (_outputTail + paramChar > _outputEnd)
    {
      _flushBuffer();
      if (paramChar > _outputEnd)
      {
        _writer.write((String)localObject);
        return;
      }
    }
    ((String)localObject).getChars(0, paramChar, _outputBuffer, _outputTail);
    _outputTail += paramChar;
  }
  
  private int _prependOrWriteCharacterEscape(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3)
    throws IOException, JsonGenerationException
  {
    if (paramInt3 >= 0)
    {
      if ((paramInt1 > 1) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 2;
        paramArrayOfChar[paramInt1] = '\\';
        paramArrayOfChar[(paramInt1 + 1)] = ((char)paramInt3);
        return paramInt1;
      }
      localObject = _entityBuffer;
      paramArrayOfChar = (char[])localObject;
      if (localObject == null) {
        paramArrayOfChar = _allocateEntityBuffer();
      }
      paramArrayOfChar[1] = ((char)paramInt3);
      _writer.write(paramArrayOfChar, 0, 2);
      return paramInt1;
    }
    if (paramInt3 != -2)
    {
      if ((paramInt1 > 5) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 6;
        paramInt2 = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = '\\';
        paramInt1 = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = 'u';
        if (paramChar > '?')
        {
          paramInt2 = paramChar >> '\b' & 0xFF;
          paramInt3 = paramInt1 + 1;
          localObject = HEX_CHARS;
          paramArrayOfChar[paramInt1] = localObject[(paramInt2 >> 4)];
          paramInt1 = paramInt3 + 1;
          paramArrayOfChar[paramInt3] = localObject[(paramInt2 & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
        }
        else
        {
          paramInt2 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = '0';
          paramInt1 = paramInt2 + 1;
          paramArrayOfChar[paramInt2] = '0';
        }
        paramInt2 = paramInt1 + 1;
        localObject = HEX_CHARS;
        paramArrayOfChar[paramInt1] = localObject[(paramChar >> '\004')];
        paramArrayOfChar[paramInt2] = localObject[(paramChar & 0xF)];
        return paramInt2 - 5;
      }
      localObject = _entityBuffer;
      paramArrayOfChar = (char[])localObject;
      if (localObject == null) {
        paramArrayOfChar = _allocateEntityBuffer();
      }
      _outputHead = _outputTail;
      if (paramChar > '?')
      {
        paramInt2 = paramChar >> '\b' & 0xFF;
        paramChar &= 0xFF;
        localObject = HEX_CHARS;
        paramArrayOfChar[10] = localObject[(paramInt2 >> 4)];
        paramArrayOfChar[11] = localObject[(paramInt2 & 0xF)];
        paramArrayOfChar[12] = localObject[(paramChar >> '\004')];
        paramArrayOfChar[13] = localObject[(paramChar & 0xF)];
        _writer.write(paramArrayOfChar, 8, 6);
        return paramInt1;
      }
      localObject = HEX_CHARS;
      paramArrayOfChar[6] = localObject[(paramChar >> '\004')];
      paramArrayOfChar[7] = localObject[(paramChar & 0xF)];
      _writer.write(paramArrayOfChar, 2, 6);
      return paramInt1;
    }
    Object localObject = _currentEscape;
    if (localObject == null)
    {
      localObject = _characterEscapes.getEscapeSequence(paramChar).getValue();
    }
    else
    {
      localObject = ((SerializableString)localObject).getValue();
      _currentEscape = null;
    }
    paramChar = ((String)localObject).length();
    if ((paramInt1 >= paramChar) && (paramInt1 < paramInt2))
    {
      paramInt1 -= paramChar;
      ((String)localObject).getChars(0, paramChar, paramArrayOfChar, paramInt1);
      return paramInt1;
    }
    _writer.write((String)localObject);
    return paramInt1;
  }
  
  private void _prependOrWriteCharacterEscape(char paramChar, int paramInt)
    throws IOException, JsonGenerationException
  {
    char[] arrayOfChar;
    if (paramInt >= 0)
    {
      paramChar = _outputTail;
      if (paramChar >= '\002')
      {
        paramChar -= '\002';
        _outputHead = paramChar;
        localObject = _outputBuffer;
        localObject[paramChar] = 92;
        localObject[(paramChar + '\001')] = ((char)paramInt);
        return;
      }
      arrayOfChar = _entityBuffer;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = _allocateEntityBuffer();
      }
      _outputHead = _outputTail;
      localObject[1] = ((char)paramInt);
      _writer.write((char[])localObject, 0, 2);
      return;
    }
    if (paramInt != -2)
    {
      paramInt = _outputTail;
      if (paramInt >= 6)
      {
        localObject = _outputBuffer;
        paramInt -= 6;
        _outputHead = paramInt;
        localObject[paramInt] = 92;
        paramInt += 1;
        localObject[paramInt] = 117;
        if (paramChar > '?')
        {
          int i = paramChar >> '\b' & 0xFF;
          paramInt += 1;
          arrayOfChar = HEX_CHARS;
          localObject[paramInt] = arrayOfChar[(i >> 4)];
          paramInt += 1;
          localObject[paramInt] = arrayOfChar[(i & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
        }
        else
        {
          paramInt += 1;
          localObject[paramInt] = 48;
          paramInt += 1;
          localObject[paramInt] = 48;
        }
        paramInt += 1;
        arrayOfChar = HEX_CHARS;
        localObject[paramInt] = arrayOfChar[(paramChar >> '\004')];
        localObject[(paramInt + 1)] = arrayOfChar[(paramChar & 0xF)];
        return;
      }
      arrayOfChar = _entityBuffer;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = _allocateEntityBuffer();
      }
      _outputHead = _outputTail;
      if (paramChar > '?')
      {
        paramInt = paramChar >> '\b' & 0xFF;
        paramChar &= 0xFF;
        arrayOfChar = HEX_CHARS;
        localObject[10] = arrayOfChar[(paramInt >> 4)];
        localObject[11] = arrayOfChar[(paramInt & 0xF)];
        localObject[12] = arrayOfChar[(paramChar >> '\004')];
        localObject[13] = arrayOfChar[(paramChar & 0xF)];
        _writer.write((char[])localObject, 8, 6);
        return;
      }
      arrayOfChar = HEX_CHARS;
      localObject[6] = arrayOfChar[(paramChar >> '\004')];
      localObject[7] = arrayOfChar[(paramChar & 0xF)];
      _writer.write((char[])localObject, 2, 6);
      return;
    }
    Object localObject = _currentEscape;
    if (localObject == null)
    {
      localObject = _characterEscapes.getEscapeSequence(paramChar).getValue();
    }
    else
    {
      localObject = ((SerializableString)localObject).getValue();
      _currentEscape = null;
    }
    paramChar = ((String)localObject).length();
    paramInt = _outputTail;
    if (paramInt >= paramChar)
    {
      paramInt -= paramChar;
      _outputHead = paramInt;
      ((String)localObject).getChars(0, paramChar, _outputBuffer, paramInt);
      return;
    }
    _outputHead = paramInt;
    _writer.write((String)localObject);
  }
  
  private int _readMore(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramInt2)
    {
      paramArrayOfByte[paramInt1] = paramArrayOfByte[i];
      paramInt1 += 1;
      i += 1;
    }
    paramInt3 = Math.min(paramInt3, paramArrayOfByte.length);
    do
    {
      paramInt2 = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt3 - paramInt1);
      if (paramInt2 < 0) {
        return paramInt1;
      }
      paramInt2 = paramInt1 + paramInt2;
      paramInt1 = paramInt2;
    } while (paramInt2 < 3);
    return paramInt2;
  }
  
  private void _writeLongString(String paramString)
    throws IOException, JsonGenerationException
  {
    _flushBuffer();
    int m = paramString.length();
    int k;
    for (int i = 0;; i = k)
    {
      k = _outputEnd;
      int j = k;
      if (i + k > m) {
        j = m - i;
      }
      k = i + j;
      paramString.getChars(i, k, _outputBuffer, 0);
      if (_characterEscapes != null)
      {
        _writeSegmentCustom(j);
      }
      else
      {
        i = _maximumNonEscapedChar;
        if (i != 0) {
          _writeSegmentASCII(j, i);
        } else {
          _writeSegment(j);
        }
      }
      if (k >= m) {
        return;
      }
    }
  }
  
  private void _writeNull()
    throws IOException
  {
    if (_outputTail + 4 >= _outputEnd) {
      _flushBuffer();
    }
    int i = _outputTail;
    char[] arrayOfChar = _outputBuffer;
    arrayOfChar[i] = 'n';
    i += 1;
    arrayOfChar[i] = 'u';
    i += 1;
    arrayOfChar[i] = 'l';
    i += 1;
    arrayOfChar[i] = 'l';
    _outputTail = (i + 1);
  }
  
  private void _writeQuotedInt(int paramInt)
    throws IOException
  {
    if (_outputTail + 13 >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _outputTail = f.a(paramInt, arrayOfChar, _outputTail);
    arrayOfChar = _outputBuffer;
    paramInt = _outputTail;
    _outputTail = (paramInt + 1);
    arrayOfChar[paramInt] = '"';
  }
  
  private void _writeQuotedLong(long paramLong)
    throws IOException
  {
    if (_outputTail + 23 >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _outputTail = f.a(paramLong, arrayOfChar, _outputTail);
    arrayOfChar = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
  }
  
  private void _writeQuotedRaw(Object paramObject)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    writeRaw(paramObject.toString());
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramObject = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramObject[i] = 34;
  }
  
  private void _writeSegment(int paramInt)
    throws IOException, JsonGenerationException
  {
    int[] arrayOfInt = _outputEscapes;
    int n = arrayOfInt.length;
    int j = 0;
    int i;
    for (int k = 0; j < paramInt; k = _prependOrWriteCharacterEscape(_outputBuffer, j, paramInt, i, arrayOfInt[i]))
    {
      do
      {
        i = _outputBuffer[j];
        if ((i < n) && (arrayOfInt[i] != 0)) {
          break;
        }
        m = j + 1;
        j = m;
      } while (m < paramInt);
      j = m;
      int m = j - k;
      if (m > 0)
      {
        _writer.write(_outputBuffer, k, m);
        if (j >= paramInt) {
          return;
        }
      }
      j += 1;
    }
  }
  
  private void _writeSegmentASCII(int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int[] arrayOfInt = _outputEscapes;
    int i2 = Math.min(arrayOfInt.length, paramInt2 + 1);
    int k = 0;
    int m = 0;
    int j = 0;
    while (k < paramInt1)
    {
      int n = j;
      j = k;
      int i;
      int i1;
      do
      {
        i = _outputBuffer[j];
        if (i < i2)
        {
          n = arrayOfInt[i];
          k = n;
          if (n != 0)
          {
            i1 = j;
            j = n;
            break;
          }
        }
        else
        {
          k = n;
          if (i > paramInt2)
          {
            k = -1;
            i1 = j;
            j = k;
            break;
          }
        }
        i1 = j + 1;
        j = i1;
        n = k;
      } while (i1 < paramInt1);
      j = k;
      k = i1 - m;
      if (k > 0)
      {
        _writer.write(_outputBuffer, m, k);
        if (i1 >= paramInt1) {
          return;
        }
      }
      k = i1 + 1;
      m = _prependOrWriteCharacterEscape(_outputBuffer, k, paramInt1, i, j);
    }
  }
  
  private void _writeSegmentCustom(int paramInt)
    throws IOException, JsonGenerationException
  {
    int[] arrayOfInt = _outputEscapes;
    int j = _maximumNonEscapedChar;
    int m = j;
    if (j < 1) {
      m = 65535;
    }
    int i3 = Math.min(arrayOfInt.length, m + 1);
    CharacterEscapes localCharacterEscapes = _characterEscapes;
    int k = 0;
    int n = 0;
    j = 0;
    while (k < paramInt)
    {
      int i1 = j;
      j = k;
      int i;
      int i2;
      do
      {
        i = _outputBuffer[j];
        if (i < i3)
        {
          i1 = arrayOfInt[i];
          k = i1;
          if (i1 != 0)
          {
            k = j;
            j = i1;
            break;
          }
        }
        else
        {
          if (i > m)
          {
            i1 = -1;
            k = j;
            j = i1;
            break;
          }
          SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
          _currentEscape = localSerializableString;
          k = i1;
          if (localSerializableString != null)
          {
            i1 = -2;
            k = j;
            j = i1;
            break;
          }
        }
        i2 = j + 1;
        j = i2;
        i1 = k;
      } while (i2 < paramInt);
      j = k;
      k = i2;
      i1 = k - n;
      if (i1 > 0)
      {
        _writer.write(_outputBuffer, n, i1);
        if (k >= paramInt) {
          return;
        }
      }
      k += 1;
      n = _prependOrWriteCharacterEscape(_outputBuffer, k, paramInt, i, j);
    }
  }
  
  private void _writeString(String paramString)
    throws IOException, JsonGenerationException
  {
    int i = paramString.length();
    int j = _outputEnd;
    if (i > j)
    {
      _writeLongString(paramString);
      return;
    }
    if (_outputTail + i > j) {
      _flushBuffer();
    }
    paramString.getChars(0, i, _outputBuffer, _outputTail);
    if (_characterEscapes != null)
    {
      _writeStringCustom(i);
      return;
    }
    j = _maximumNonEscapedChar;
    if (j != 0)
    {
      _writeStringASCII(i, j);
      return;
    }
    _writeString2(i);
  }
  
  private void _writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if (_characterEscapes != null)
    {
      _writeStringCustom(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    int i = _maximumNonEscapedChar;
    if (i != 0)
    {
      _writeStringASCII(paramArrayOfChar, paramInt1, paramInt2, i);
      return;
    }
    int j = paramInt2 + paramInt1;
    int[] arrayOfInt = _outputEscapes;
    int k = arrayOfInt.length;
    while (paramInt1 < j)
    {
      paramInt2 = paramInt1;
      do
      {
        i = paramArrayOfChar[paramInt2];
        if ((i < k) && (arrayOfInt[i] != 0)) {
          break;
        }
        i = paramInt2 + 1;
        paramInt2 = i;
      } while (i < j);
      paramInt2 = i;
      i = paramInt2 - paramInt1;
      if (i < 32)
      {
        if (_outputTail + i > _outputEnd) {
          _flushBuffer();
        }
        if (i > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt1, _outputBuffer, _outputTail, i);
          _outputTail += i;
        }
      }
      else
      {
        _flushBuffer();
        _writer.write(paramArrayOfChar, paramInt1, i);
      }
      if (paramInt2 >= j) {
        return;
      }
      paramInt1 = paramInt2 + 1;
      char c = paramArrayOfChar[paramInt2];
      _appendCharacterEscape(c, arrayOfInt[c]);
    }
  }
  
  private void _writeString2(int paramInt)
    throws IOException, JsonGenerationException
  {
    paramInt = _outputTail + paramInt;
    int[] arrayOfInt = _outputEscapes;
    int i = arrayOfInt.length;
    if (_outputTail < paramInt)
    {
      int j;
      do
      {
        char[] arrayOfChar = _outputBuffer;
        j = _outputTail;
        int k = arrayOfChar[j];
        if ((k < i) && (arrayOfInt[k] != 0))
        {
          k = _outputHead;
          j -= k;
          if (j > 0) {
            _writer.write(arrayOfChar, k, j);
          }
          arrayOfChar = _outputBuffer;
          j = _outputTail;
          _outputTail = (j + 1);
          char c = arrayOfChar[j];
          _prependOrWriteCharacterEscape(c, arrayOfInt[c]);
          break;
        }
        j = _outputTail + 1;
        _outputTail = j;
      } while (j < paramInt);
    }
  }
  
  private void _writeStringASCII(int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int j = _outputTail + paramInt1;
    int[] arrayOfInt = _outputEscapes;
    int k = Math.min(arrayOfInt.length, paramInt2 + 1);
    if (_outputTail < j) {
      label127:
      do
      {
        int i = _outputBuffer[_outputTail];
        if (i < k)
        {
          paramInt1 = arrayOfInt[i];
          if (paramInt1 == 0) {
            break label127;
          }
        }
        else
        {
          if (i <= paramInt2) {
            break label127;
          }
          paramInt1 = -1;
        }
        int n = _outputTail;
        int m = _outputHead;
        n -= m;
        if (n > 0) {
          _writer.write(_outputBuffer, m, n);
        }
        _outputTail += 1;
        _prependOrWriteCharacterEscape(i, paramInt1);
        break;
        paramInt1 = _outputTail + 1;
        _outputTail = paramInt1;
      } while (paramInt1 < j);
    }
  }
  
  private void _writeStringASCII(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    throws IOException, JsonGenerationException
  {
    int n = paramInt2 + paramInt1;
    int[] arrayOfInt = _outputEscapes;
    int i1 = Math.min(arrayOfInt.length, paramInt3 + 1);
    int j = 0;
    paramInt2 = paramInt1;
    paramInt1 = j;
    while (paramInt2 < n)
    {
      j = paramInt2;
      int k = paramInt1;
      int i;
      int m;
      do
      {
        i = paramArrayOfChar[j];
        if (i < i1)
        {
          k = arrayOfInt[i];
          paramInt1 = k;
          if (k != 0)
          {
            paramInt1 = k;
            break;
          }
        }
        else
        {
          paramInt1 = k;
          if (i > paramInt3)
          {
            paramInt1 = -1;
            break;
          }
        }
        m = j + 1;
        k = paramInt1;
        j = m;
      } while (m < n);
      j = m;
      k = j - paramInt2;
      if (k < 32)
      {
        if (_outputTail + k > _outputEnd) {
          _flushBuffer();
        }
        if (k > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt2, _outputBuffer, _outputTail, k);
          _outputTail += k;
        }
      }
      else
      {
        _flushBuffer();
        _writer.write(paramArrayOfChar, paramInt2, k);
      }
      if (j >= n) {
        return;
      }
      paramInt2 = j + 1;
      _appendCharacterEscape(i, paramInt1);
    }
  }
  
  private void _writeStringCustom(int paramInt)
    throws IOException, JsonGenerationException
  {
    int k = _outputTail + paramInt;
    int[] arrayOfInt = _outputEscapes;
    paramInt = _maximumNonEscapedChar;
    int j = paramInt;
    if (paramInt < 1) {
      j = 65535;
    }
    int m = Math.min(arrayOfInt.length, j + 1);
    CharacterEscapes localCharacterEscapes = _characterEscapes;
    if (_outputTail < k) {
      label173:
      do
      {
        int i = _outputBuffer[_outputTail];
        if (i < m)
        {
          paramInt = arrayOfInt[i];
          if (paramInt == 0) {
            break label173;
          }
        }
        else if (i > j)
        {
          paramInt = -1;
        }
        else
        {
          SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
          _currentEscape = localSerializableString;
          if (localSerializableString == null) {
            break label173;
          }
          paramInt = -2;
        }
        int i1 = _outputTail;
        int n = _outputHead;
        i1 -= n;
        if (i1 > 0) {
          _writer.write(_outputBuffer, n, i1);
        }
        _outputTail += 1;
        _prependOrWriteCharacterEscape(i, paramInt);
        break;
        paramInt = _outputTail + 1;
        _outputTail = paramInt;
      } while (paramInt < k);
    }
  }
  
  private void _writeStringCustom(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int i1 = paramInt2 + paramInt1;
    int[] arrayOfInt = _outputEscapes;
    paramInt2 = _maximumNonEscapedChar;
    int k = paramInt2;
    if (paramInt2 < 1) {
      k = 65535;
    }
    int i2 = Math.min(arrayOfInt.length, k + 1);
    CharacterEscapes localCharacterEscapes = _characterEscapes;
    int j = 0;
    paramInt2 = paramInt1;
    paramInt1 = j;
    while (paramInt2 < i1)
    {
      j = paramInt2;
      int m = paramInt1;
      int i;
      int n;
      do
      {
        i = paramArrayOfChar[j];
        if (i < i2)
        {
          m = arrayOfInt[i];
          paramInt1 = m;
          if (m != 0)
          {
            paramInt1 = m;
            break;
          }
        }
        else
        {
          if (i > k)
          {
            paramInt1 = -1;
            break;
          }
          SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
          _currentEscape = localSerializableString;
          paramInt1 = m;
          if (localSerializableString != null)
          {
            paramInt1 = -2;
            break;
          }
        }
        n = j + 1;
        m = paramInt1;
        j = n;
      } while (n < i1);
      j = n;
      m = j - paramInt2;
      if (m < 32)
      {
        if (_outputTail + m > _outputEnd) {
          _flushBuffer();
        }
        if (m > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt2, _outputBuffer, _outputTail, m);
          _outputTail += m;
        }
      }
      else
      {
        _flushBuffer();
        _writer.write(paramArrayOfChar, paramInt2, m);
      }
      if (j >= i1) {
        return;
      }
      paramInt2 = j + 1;
      _appendCharacterEscape(i, paramInt1);
    }
  }
  
  private void writeRawLong(String paramString)
    throws IOException, JsonGenerationException
  {
    int i = _outputEnd;
    int j = _outputTail;
    i -= j;
    paramString.getChars(0, i, _outputBuffer, j);
    _outputTail += i;
    _flushBuffer();
    j = paramString.length() - i;
    for (;;)
    {
      int m = _outputEnd;
      if (j <= m) {
        break;
      }
      int k = i + m;
      paramString.getChars(i, k, _outputBuffer, 0);
      _outputHead = 0;
      _outputTail = m;
      _flushBuffer();
      j -= m;
      i = k;
    }
    paramString.getChars(i, i + j, _outputBuffer, 0);
    _outputHead = 0;
    _outputTail = j;
  }
  
  public void _flushBuffer()
    throws IOException
  {
    int j = _outputTail;
    int i = _outputHead;
    j -= i;
    if (j > 0)
    {
      _outputHead = 0;
      _outputTail = 0;
      _writer.write(_outputBuffer, i, j);
    }
  }
  
  public void _releaseBuffers()
  {
    char[] arrayOfChar = _outputBuffer;
    if (arrayOfChar != null)
    {
      _outputBuffer = null;
      _ioContext.releaseConcatBuffer(arrayOfChar);
    }
  }
  
  public void _verifyPrettyValueWrite(String paramString, int paramInt)
    throws IOException, JsonGenerationException
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            _cantHappen();
            return;
          }
          _cfgPrettyPrinter.writeRootValueSeparator(this);
          return;
        }
        _cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
        return;
      }
      _cfgPrettyPrinter.writeArrayValueSeparator(this);
      return;
    }
    if (_writeContext.inArray())
    {
      _cfgPrettyPrinter.beforeArrayValues(this);
      return;
    }
    if (_writeContext.inObject()) {
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
  }
  
  public void _verifyValueWrite(String paramString)
    throws IOException, JsonGenerationException
  {
    int j = _writeContext.writeValue();
    if (j == 5)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can not ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", expecting field name");
      _reportError(localStringBuilder.toString());
    }
    if (_cfgPrettyPrinter == null)
    {
      int i;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return;
          }
          paramString = _rootValueSeparator;
          if (paramString == null) {
            return;
          }
          writeRaw(paramString.getValue());
          return;
        }
        i = 58;
      }
      else
      {
        i = 44;
      }
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramString = _outputBuffer;
      j = _outputTail;
      paramString[j] = i;
      _outputTail = (j + 1);
    }
    else
    {
      _verifyPrettyValueWrite(paramString, j);
    }
  }
  
  public int _writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException, JsonGenerationException
  {
    int i6 = _outputEnd - 6;
    int i = paramBase64Variant.getMaxLineLength();
    int i2 = -3;
    i >>= 2;
    int k = 0;
    int j = 0;
    int i1 = 0;
    for (;;)
    {
      int n = i2;
      int i3 = j;
      int m = i1;
      if (j > i2)
      {
        m = _readMore(paramInputStream, paramArrayOfByte, j, i1, paramArrayOfByte.length);
        if (m < 3)
        {
          if (m <= 0) {
            break;
          }
          if (_outputTail > i6) {
            _flushBuffer();
          }
          n = paramArrayOfByte[0] << 16;
          j = 1;
          i = n;
          if (1 < m)
          {
            i = n | (paramArrayOfByte[1] & 0xFF) << 8;
            j = 2;
          }
          _outputTail = paramBase64Variant.encodeBase64Partial(i, j, _outputBuffer, _outputTail);
          return k + j;
        }
        n = m - 3;
        i3 = 0;
      }
      if (_outputTail > i6) {
        _flushBuffer();
      }
      i1 = i3 + 1;
      j = paramArrayOfByte[i3];
      i2 = i1 + 1;
      i1 = paramArrayOfByte[i1];
      i3 = i2 + 1;
      i2 = paramArrayOfByte[i2];
      int i4 = k + 3;
      _outputTail = paramBase64Variant.encodeBase64Chunk((i1 & 0xFF | j << 8) << 8 | i2 & 0xFF, _outputBuffer, _outputTail);
      int i5 = i - 1;
      k = i4;
      i2 = n;
      i = i5;
      j = i3;
      i1 = m;
      if (i5 <= 0)
      {
        char[] arrayOfChar = _outputBuffer;
        i = _outputTail;
        _outputTail = (i + 1);
        arrayOfChar[i] = '\\';
        i = _outputTail;
        _outputTail = (i + 1);
        arrayOfChar[i] = 'n';
        i = paramBase64Variant.getMaxLineLength() >> 2;
        k = i4;
        i2 = n;
        j = i3;
        i1 = m;
      }
    }
    return k;
  }
  
  public int _writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
    throws IOException, JsonGenerationException
  {
    int i5 = _outputEnd - 6;
    int j = paramBase64Variant.getMaxLineLength() >> 2;
    int i1 = -3;
    int m = 0;
    int k = 0;
    int i = paramInt;
    paramInt = m;
    int n;
    for (;;)
    {
      m = k;
      n = paramInt;
      if (i <= 2) {
        break;
      }
      n = k;
      m = i1;
      int i2 = paramInt;
      if (paramInt > i1)
      {
        n = _readMore(paramInputStream, paramArrayOfByte, paramInt, k, i);
        if (n < 3)
        {
          paramInt = 0;
          m = n;
          n = paramInt;
          break;
        }
        m = n - 3;
        i2 = 0;
      }
      if (_outputTail > i5) {
        _flushBuffer();
      }
      k = i2 + 1;
      paramInt = paramArrayOfByte[i2];
      i1 = k + 1;
      k = paramArrayOfByte[k];
      i2 = i1 + 1;
      i1 = paramArrayOfByte[i1];
      int i3 = i - 3;
      _outputTail = paramBase64Variant.encodeBase64Chunk((k & 0xFF | paramInt << 8) << 8 | i1 & 0xFF, _outputBuffer, _outputTail);
      int i4 = j - 1;
      k = n;
      j = i4;
      i1 = m;
      paramInt = i2;
      i = i3;
      if (i4 <= 0)
      {
        char[] arrayOfChar = _outputBuffer;
        paramInt = _outputTail;
        _outputTail = (paramInt + 1);
        arrayOfChar[paramInt] = '\\';
        paramInt = _outputTail;
        _outputTail = (paramInt + 1);
        arrayOfChar[paramInt] = 'n';
        j = paramBase64Variant.getMaxLineLength() >> 2;
        k = n;
        i1 = m;
        paramInt = i2;
        i = i3;
      }
    }
    paramInt = i;
    if (i > 0)
    {
      m = _readMore(paramInputStream, paramArrayOfByte, n, m, i);
      paramInt = i;
      if (m > 0)
      {
        if (_outputTail > i5) {
          _flushBuffer();
        }
        k = paramArrayOfByte[0] << 16;
        j = 1;
        paramInt = k;
        if (1 < m)
        {
          paramInt = k | (paramArrayOfByte[1] & 0xFF) << 8;
          j = 2;
        }
        _outputTail = paramBase64Variant.encodeBase64Partial(paramInt, j, _outputBuffer, _outputTail);
        paramInt = i - j;
      }
    }
    return paramInt;
  }
  
  public void _writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int k = _outputEnd - 6;
    int j = paramBase64Variant.getMaxLineLength() >> 2;
    int i = paramInt1;
    paramInt1 = j;
    while (i <= paramInt2 - 3)
    {
      if (_outputTail > k) {
        _flushBuffer();
      }
      int n = i + 1;
      j = paramArrayOfByte[i];
      int m = n + 1;
      n = paramArrayOfByte[n];
      i = m + 1;
      _outputTail = paramBase64Variant.encodeBase64Chunk((j << 8 | n & 0xFF) << 8 | paramArrayOfByte[m] & 0xFF, _outputBuffer, _outputTail);
      j = paramInt1 - 1;
      paramInt1 = j;
      if (j <= 0)
      {
        char[] arrayOfChar = _outputBuffer;
        paramInt1 = _outputTail;
        _outputTail = (paramInt1 + 1);
        arrayOfChar[paramInt1] = '\\';
        paramInt1 = _outputTail;
        _outputTail = (paramInt1 + 1);
        arrayOfChar[paramInt1] = 'n';
        paramInt1 = paramBase64Variant.getMaxLineLength() >> 2;
      }
    }
    j = paramInt2 - i;
    if (j > 0)
    {
      if (_outputTail > k) {
        _flushBuffer();
      }
      paramInt2 = paramArrayOfByte[i] << 16;
      paramInt1 = paramInt2;
      if (j == 2) {
        paramInt1 = paramInt2 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8;
      }
      _outputTail = paramBase64Variant.encodeBase64Partial(paramInt1, j, _outputBuffer, _outputTail);
    }
  }
  
  public void _writeFieldName(SerializableString paramSerializableString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (_cfgPrettyPrinter != null)
    {
      _writePPFieldName(paramSerializableString, paramBoolean);
      return;
    }
    if (_outputTail + 1 >= _outputEnd) {
      _flushBuffer();
    }
    if (paramBoolean)
    {
      arrayOfChar = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = ',';
    }
    paramSerializableString = paramSerializableString.asQuotedChars();
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      writeRaw(paramSerializableString, 0, paramSerializableString.length);
      return;
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    i = paramSerializableString.length;
    int j = _outputTail;
    if (j + i + 1 >= _outputEnd)
    {
      writeRaw(paramSerializableString, 0, i);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
    }
    System.arraycopy(paramSerializableString, 0, arrayOfChar, j, i);
    _outputTail += i;
    paramSerializableString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramSerializableString[i] = 34;
  }
  
  public void _writeFieldName(String paramString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (_cfgPrettyPrinter != null)
    {
      _writePPFieldName(paramString, paramBoolean);
      return;
    }
    if (_outputTail + 1 >= _outputEnd) {
      _flushBuffer();
    }
    if (paramBoolean)
    {
      arrayOfChar = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = ',';
    }
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      _writeString(paramString);
      return;
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramString);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  public void _writePPFieldName(SerializableString paramSerializableString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (paramBoolean) {
      _cfgPrettyPrinter.writeObjectEntrySeparator(this);
    } else {
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
    paramSerializableString = paramSerializableString.asQuotedChars();
    if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = '"';
      writeRaw(paramSerializableString, 0, paramSerializableString.length);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
    }
    writeRaw(paramSerializableString, 0, paramSerializableString.length);
  }
  
  public void _writePPFieldName(String paramString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (paramBoolean) {
      _cfgPrettyPrinter.writeObjectEntrySeparator(this);
    } else {
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
    if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = '"';
      _writeString(paramString);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramString[i] = 34;
      return;
    }
    _writeString(paramString);
  }
  
  public void close()
    throws IOException
  {
    _closed = true;
    if ((_outputBuffer != null) && (isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT))) {
      for (;;)
      {
        JsonWriteContext localJsonWriteContext = getOutputContext();
        if (localJsonWriteContext.inArray())
        {
          writeEndArray();
        }
        else
        {
          if (!localJsonWriteContext.inObject()) {
            break;
          }
          writeEndObject();
        }
      }
    }
    _flushBuffer();
    if (_writer != null) {
      if ((!_ioContext.isResourceManaged()) && (!isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)))
      {
        if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
          _writer.flush();
        }
      }
      else {
        _writer.close();
      }
    }
    _releaseBuffers();
  }
  
  public void flush()
    throws IOException
  {
    _flushBuffer();
    if ((_writer != null) && (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      _writer.flush();
    }
  }
  
  public Object getOutputTarget()
  {
    return _writer;
  }
  
  public int writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, int paramInt)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write binary value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    Object localObject = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    localObject[i] = 34;
    localObject = _ioContext.allocBase64Buffer();
    if (paramInt < 0) {}
    try
    {
      i = _writeBinary(paramBase64Variant, paramInputStream, (byte[])localObject);
      break label150;
      int j = _writeBinary(paramBase64Variant, paramInputStream, (byte[])localObject, paramInt);
      i = paramInt;
      if (j > 0)
      {
        paramBase64Variant = new StringBuilder();
        paramBase64Variant.append("Too few bytes available: missing ");
        paramBase64Variant.append(j);
        paramBase64Variant.append(" bytes (out of ");
        paramBase64Variant.append(paramInt);
        paramBase64Variant.append(")");
        _reportError(paramBase64Variant.toString());
        i = paramInt;
      }
      label150:
      _ioContext.releaseBase64Buffer((byte[])localObject);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramBase64Variant = _outputBuffer;
      paramInt = _outputTail;
      _outputTail = (paramInt + 1);
      paramBase64Variant[paramInt] = 34;
      return i;
    }
    catch (Throwable paramBase64Variant)
    {
      _ioContext.releaseBase64Buffer((byte[])localObject);
      throw paramBase64Variant;
    }
  }
  
  public void writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write binary value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeBinary(paramBase64Variant, paramArrayOfByte, paramInt1, paramInt2 + paramInt1);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramBase64Variant = _outputBuffer;
    paramInt1 = _outputTail;
    _outputTail = (paramInt1 + 1);
    paramBase64Variant[paramInt1] = 34;
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write boolean value");
    if (_outputTail + 5 >= _outputEnd) {
      _flushBuffer();
    }
    int i = _outputTail;
    char[] arrayOfChar = _outputBuffer;
    if (paramBoolean)
    {
      arrayOfChar[i] = 't';
      i += 1;
      arrayOfChar[i] = 'r';
      i += 1;
      arrayOfChar[i] = 'u';
      i += 1;
      arrayOfChar[i] = 'e';
    }
    else
    {
      arrayOfChar[i] = 'f';
      i += 1;
      arrayOfChar[i] = 'a';
      i += 1;
      arrayOfChar[i] = 'l';
      i += 1;
      arrayOfChar[i] = 's';
      i += 1;
      arrayOfChar[i] = 'e';
    }
    _outputTail = (i + 1);
  }
  
  public void writeEndArray()
    throws IOException, JsonGenerationException
  {
    if (!_writeContext.inArray())
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Current context not an ARRAY but ");
      ((StringBuilder)localObject).append(_writeContext.getTypeDesc());
      _reportError(((StringBuilder)localObject).toString());
    }
    Object localObject = _cfgPrettyPrinter;
    if (localObject != null)
    {
      ((PrettyPrinter)localObject).writeEndArray(this, _writeContext.getEntryCount());
    }
    else
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      localObject = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      localObject[i] = 93;
    }
    _writeContext = _writeContext.getParent();
  }
  
  public void writeEndObject()
    throws IOException, JsonGenerationException
  {
    if (!_writeContext.inObject())
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Current context not an object but ");
      ((StringBuilder)localObject).append(_writeContext.getTypeDesc());
      _reportError(((StringBuilder)localObject).toString());
    }
    Object localObject = _cfgPrettyPrinter;
    if (localObject != null)
    {
      ((PrettyPrinter)localObject).writeEndObject(this, _writeContext.getEntryCount());
    }
    else
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      localObject = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      localObject[i] = 125;
    }
    _writeContext = _writeContext.getParent();
  }
  
  public void writeFieldName(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    int i = _writeContext.writeFieldName(paramSerializableString.getValue());
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    _writeFieldName(paramSerializableString, bool);
  }
  
  public void writeFieldName(String paramString)
    throws IOException, JsonGenerationException
  {
    int i = _writeContext.writeFieldName(paramString);
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    _writeFieldName(paramString, bool);
  }
  
  public void writeNull()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write null value");
    _writeNull();
  }
  
  public void writeNumber(double paramDouble)
    throws IOException, JsonGenerationException
  {
    if ((!_cfgNumbersAsStrings) && (((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble))) || (!isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      _verifyValueWrite("write number");
      writeRaw(String.valueOf(paramDouble));
      return;
    }
    writeString(String.valueOf(paramDouble));
  }
  
  public void writeNumber(float paramFloat)
    throws IOException, JsonGenerationException
  {
    if ((!_cfgNumbersAsStrings) && (((!Float.isNaN(paramFloat)) && (!Float.isInfinite(paramFloat))) || (!isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      _verifyValueWrite("write number");
      writeRaw(String.valueOf(paramFloat));
      return;
    }
    writeString(String.valueOf(paramFloat));
  }
  
  public void writeNumber(int paramInt)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedInt(paramInt);
      return;
    }
    if (_outputTail + 11 >= _outputEnd) {
      _flushBuffer();
    }
    _outputTail = f.a(paramInt, _outputBuffer, _outputTail);
  }
  
  public void writeNumber(long paramLong)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedLong(paramLong);
      return;
    }
    if (_outputTail + 21 >= _outputEnd) {
      _flushBuffer();
    }
    _outputTail = f.a(paramLong, _outputBuffer, _outputTail);
  }
  
  public void writeNumber(String paramString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramString);
      return;
    }
    writeRaw(paramString);
  }
  
  public void writeNumber(BigDecimal paramBigDecimal)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (paramBigDecimal == null)
    {
      _writeNull();
      return;
    }
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramBigDecimal);
      return;
    }
    writeRaw(paramBigDecimal.toString());
  }
  
  public void writeNumber(BigInteger paramBigInteger)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (paramBigInteger == null)
    {
      _writeNull();
      return;
    }
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramBigInteger);
      return;
    }
    writeRaw(paramBigInteger.toString());
  }
  
  public void writeRaw(char paramChar)
    throws IOException, JsonGenerationException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = paramChar;
  }
  
  public void writeRaw(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    writeRaw(paramSerializableString.getValue());
  }
  
  public void writeRaw(String paramString)
    throws IOException, JsonGenerationException
  {
    int k = paramString.length();
    int j = _outputEnd - _outputTail;
    int i = j;
    if (j == 0)
    {
      _flushBuffer();
      i = _outputEnd - _outputTail;
    }
    if (i >= k)
    {
      paramString.getChars(0, k, _outputBuffer, _outputTail);
      _outputTail += k;
      return;
    }
    writeRawLong(paramString);
  }
  
  public void writeRaw(String paramString, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int j = _outputEnd - _outputTail;
    int i = j;
    if (j < paramInt2)
    {
      _flushBuffer();
      i = _outputEnd - _outputTail;
    }
    if (i >= paramInt2)
    {
      paramString.getChars(paramInt1, paramInt1 + paramInt2, _outputBuffer, _outputTail);
      _outputTail += paramInt2;
      return;
    }
    writeRawLong(paramString.substring(paramInt1, paramInt2 + paramInt1));
  }
  
  public void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if (paramInt2 < 32)
    {
      if (paramInt2 > _outputEnd - _outputTail) {
        _flushBuffer();
      }
      System.arraycopy(paramArrayOfChar, paramInt1, _outputBuffer, _outputTail, paramInt2);
      _outputTail += paramInt2;
      return;
    }
    _flushBuffer();
    _writer.write(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeStartArray()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("start an array");
    _writeContext = _writeContext.createChildArrayContext();
    Object localObject = _cfgPrettyPrinter;
    if (localObject != null)
    {
      ((PrettyPrinter)localObject).writeStartArray(this);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    localObject = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    localObject[i] = 91;
  }
  
  public void writeStartObject()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("start an object");
    _writeContext = _writeContext.createChildObjectContext();
    Object localObject = _cfgPrettyPrinter;
    if (localObject != null)
    {
      ((PrettyPrinter)localObject).writeStartObject(this);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    localObject = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    localObject[i] = 123;
  }
  
  public void writeString(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write text value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    paramSerializableString = paramSerializableString.asQuotedChars();
    i = paramSerializableString.length;
    if (i < 32)
    {
      if (i > _outputEnd - _outputTail) {
        _flushBuffer();
      }
      System.arraycopy(paramSerializableString, 0, _outputBuffer, _outputTail, i);
      _outputTail += i;
    }
    else
    {
      _flushBuffer();
      _writer.write(paramSerializableString, 0, i);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramSerializableString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramSerializableString[i] = 34;
  }
  
  public void writeString(String paramString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write text value");
    if (paramString == null)
    {
      _writeNull();
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramString);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  public void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write text value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramArrayOfChar, paramInt1, paramInt2);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramArrayOfChar = _outputBuffer;
    paramInt1 = _outputTail;
    _outputTail = (paramInt1 + 1);
    paramArrayOfChar[paramInt1] = '"';
  }
  
  public void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _reportUnsupportedOperation();
  }
}
