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
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class UTF8JsonGenerator
  extends JsonGeneratorImpl
{
  public static final byte BYTE_0 = 48;
  public static final byte BYTE_BACKSLASH = 92;
  public static final byte BYTE_COLON = 58;
  public static final byte BYTE_COMMA = 44;
  public static final byte BYTE_LBRACKET = 91;
  public static final byte BYTE_LCURLY = 123;
  public static final byte BYTE_QUOTE = 34;
  public static final byte BYTE_RBRACKET = 93;
  public static final byte BYTE_RCURLY = 125;
  public static final byte BYTE_u = 117;
  public static final byte[] FALSE_BYTES = { 102, 97, 108, 115, 101 };
  public static final byte[] HEX_CHARS = ;
  public static final int MAX_BYTES_TO_BUFFER = 512;
  public static final byte[] NULL_BYTES = { 110, 117, 108, 108 };
  public static final int SURR1_FIRST = 55296;
  public static final int SURR1_LAST = 56319;
  public static final int SURR2_FIRST = 56320;
  public static final int SURR2_LAST = 57343;
  public static final byte[] TRUE_BYTES = { 116, 114, 117, 101 };
  public boolean _bufferRecyclable;
  public char[] _charBuffer;
  public final int _charBufferLength;
  public byte[] _entityBuffer;
  public byte[] _outputBuffer;
  public final int _outputEnd;
  public final int _outputMaxContiguous;
  public final OutputStream _outputStream;
  public int _outputTail = 0;
  
  public UTF8JsonGenerator(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec, OutputStream paramOutputStream)
  {
    super(paramIOContext, paramInt, paramObjectCodec);
    _outputStream = paramOutputStream;
    _bufferRecyclable = true;
    _outputBuffer = paramIOContext.allocWriteEncodingBuffer();
    _outputEnd = _outputBuffer.length;
    _outputMaxContiguous = (_outputEnd >> 3);
    _charBuffer = paramIOContext.allocConcatBuffer();
    _charBufferLength = _charBuffer.length;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar(127);
    }
  }
  
  public UTF8JsonGenerator(IOContext paramIOContext, int paramInt1, ObjectCodec paramObjectCodec, OutputStream paramOutputStream, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramIOContext, paramInt1, paramObjectCodec);
    _outputStream = paramOutputStream;
    _bufferRecyclable = paramBoolean;
    _outputTail = paramInt2;
    _outputBuffer = paramArrayOfByte;
    _outputEnd = _outputBuffer.length;
    _outputMaxContiguous = (_outputEnd >> 3);
    _charBuffer = paramIOContext.allocConcatBuffer();
    _charBufferLength = _charBuffer.length;
  }
  
  private int _handleLongCustomEscape(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws IOException, JsonGenerationException
  {
    int j = paramArrayOfByte2.length;
    int i = paramInt1;
    if (paramInt1 + j > paramInt2)
    {
      _outputTail = paramInt1;
      _flushBuffer();
      paramInt1 = _outputTail;
      if (j > paramArrayOfByte1.length)
      {
        _outputStream.write(paramArrayOfByte2, 0, j);
        return paramInt1;
      }
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt1, j);
      i = paramInt1 + j;
    }
    paramInt1 = i;
    if (paramInt3 * 6 + i > paramInt2)
    {
      _flushBuffer();
      paramInt1 = _outputTail;
    }
    return paramInt1;
  }
  
  private int _outputMultiByteChar(int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte1 = _outputBuffer;
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      i = paramInt2 + 1;
      arrayOfByte1[paramInt2] = 92;
      paramInt2 = i + 1;
      arrayOfByte1[i] = 117;
      i = paramInt2 + 1;
      byte[] arrayOfByte2 = HEX_CHARS;
      arrayOfByte1[paramInt2] = arrayOfByte2[(paramInt1 >> 12 & 0xF)];
      paramInt2 = i + 1;
      arrayOfByte1[i] = arrayOfByte2[(paramInt1 >> 8 & 0xF)];
      i = paramInt2 + 1;
      arrayOfByte1[paramInt2] = arrayOfByte2[(paramInt1 >> 4 & 0xF)];
      arrayOfByte1[i] = arrayOfByte2[(paramInt1 & 0xF)];
      return i + 1;
    }
    int i = paramInt2 + 1;
    arrayOfByte1[paramInt2] = ((byte)(paramInt1 >> 12 | 0xE0));
    paramInt2 = i + 1;
    arrayOfByte1[i] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
    arrayOfByte1[paramInt2] = ((byte)(paramInt1 & 0x3F | 0x80));
    return paramInt2 + 1;
  }
  
  private int _outputRawMultiByteChar(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException
  {
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      if (paramInt2 >= paramInt3) {
        _reportError("Split surrogate on writeRaw() input (last character)");
      }
      _outputSurrogates(paramInt1, paramArrayOfChar[paramInt2]);
      return paramInt2 + 1;
    }
    paramArrayOfChar = _outputBuffer;
    paramInt3 = _outputTail;
    _outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 12 | 0xE0));
    paramInt3 = _outputTail;
    _outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
    paramInt3 = _outputTail;
    _outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 & 0x3F | 0x80));
    return paramInt2;
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
  
  private final void _writeBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    if (_outputTail + i > _outputEnd)
    {
      _flushBuffer();
      if (i > 512)
      {
        _outputStream.write(paramArrayOfByte, 0, i);
        return;
      }
    }
    System.arraycopy(paramArrayOfByte, 0, _outputBuffer, _outputTail, i);
    _outputTail += i;
  }
  
  private final void _writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_outputTail + paramInt2 > _outputEnd)
    {
      _flushBuffer();
      if (paramInt2 > 512)
      {
        _outputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt1, _outputBuffer, _outputTail, paramInt2);
    _outputTail += paramInt2;
  }
  
  private int _writeCustomEscape(byte[] paramArrayOfByte, int paramInt1, SerializableString paramSerializableString, int paramInt2)
    throws IOException, JsonGenerationException
  {
    paramSerializableString = paramSerializableString.asUnquotedUTF8();
    int i = paramSerializableString.length;
    if (i > 6) {
      return _handleLongCustomEscape(paramArrayOfByte, paramInt1, _outputEnd, paramSerializableString, paramInt2);
    }
    System.arraycopy(paramSerializableString, 0, paramArrayOfByte, paramInt1, i);
    return paramInt1 + i;
  }
  
  private void _writeCustomStringSegment2(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if ((paramInt2 - paramInt1) * 6 + _outputTail > _outputEnd) {
      _flushBuffer();
    }
    int k = _outputTail;
    byte[] arrayOfByte = _outputBuffer;
    int[] arrayOfInt = _outputEscapes;
    int i = _maximumNonEscapedChar;
    int j = i;
    if (i <= 0) {
      j = 65535;
    }
    CharacterEscapes localCharacterEscapes = _characterEscapes;
    i = paramInt1;
    paramInt1 = k;
    while (i < paramInt2)
    {
      k = i + 1;
      i = paramArrayOfChar[i];
      int m;
      SerializableString localSerializableString;
      if (i <= 127)
      {
        if (arrayOfInt[i] == 0)
        {
          arrayOfByte[paramInt1] = ((byte)i);
          i = k;
          paramInt1 += 1;
          continue;
        }
        m = arrayOfInt[i];
        if (m > 0)
        {
          i = paramInt1 + 1;
          arrayOfByte[paramInt1] = 92;
          paramInt1 = i + 1;
          arrayOfByte[i] = ((byte)m);
          break label355;
        }
        if (m == -2)
        {
          localSerializableString = localCharacterEscapes.getEscapeSequence(i);
          if (localSerializableString == null)
          {
            StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Invalid custom escape definitions; custom escape not found for character code 0x");
            localStringBuilder.append(Integer.toHexString(i));
            localStringBuilder.append(", although was supposed to have one");
            _reportError(localStringBuilder.toString());
          }
          paramInt1 = _writeCustomEscape(arrayOfByte, paramInt1, localSerializableString, paramInt2 - k);
        }
        else
        {
          paramInt1 = _writeGenericEscape(i, paramInt1);
        }
      }
      else
      {
        if (i <= j) {
          break label263;
        }
        paramInt1 = _writeGenericEscape(i, paramInt1);
      }
      for (;;)
      {
        break;
        label263:
        localSerializableString = localCharacterEscapes.getEscapeSequence(i);
        if (localSerializableString != null)
        {
          paramInt1 = _writeCustomEscape(arrayOfByte, paramInt1, localSerializableString, paramInt2 - k);
        }
        else if (i <= 2047)
        {
          m = paramInt1 + 1;
          arrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
          paramInt1 = m + 1;
          arrayOfByte[m] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          paramInt1 = _outputMultiByteChar(i, paramInt1);
        }
      }
      label355:
      i = k;
    }
    _outputTail = paramInt1;
  }
  
  private int _writeGenericEscape(int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte1 = _outputBuffer;
    int i = paramInt2 + 1;
    arrayOfByte1[paramInt2] = 92;
    paramInt2 = i + 1;
    arrayOfByte1[i] = 117;
    if (paramInt1 > 255)
    {
      i = 0xFF & paramInt1 >> 8;
      int j = paramInt2 + 1;
      arrayOfByte2 = HEX_CHARS;
      arrayOfByte1[paramInt2] = arrayOfByte2[(i >> 4)];
      paramInt2 = j + 1;
      arrayOfByte1[j] = arrayOfByte2[(i & 0xF)];
      paramInt1 &= 0xFF;
    }
    else
    {
      i = paramInt2 + 1;
      arrayOfByte1[paramInt2] = 48;
      paramInt2 = i + 1;
      arrayOfByte1[i] = 48;
    }
    i = paramInt2 + 1;
    byte[] arrayOfByte2 = HEX_CHARS;
    arrayOfByte1[paramInt2] = arrayOfByte2[(paramInt1 >> 4)];
    arrayOfByte1[i] = arrayOfByte2[(paramInt1 & 0xF)];
    return i + 1;
  }
  
  private void _writeLongString(String paramString)
    throws IOException, JsonGenerationException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    _writeStringSegments(paramString);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  private void _writeLongString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramArrayOfChar = _outputBuffer;
    paramInt1 = _outputTail;
    _outputTail = (paramInt1 + 1);
    paramArrayOfChar[paramInt1] = '"';
    _writeStringSegments(_charBuffer, 0, paramInt2);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramArrayOfChar = _outputBuffer;
    paramInt1 = _outputTail;
    _outputTail = (paramInt1 + 1);
    paramArrayOfChar[paramInt1] = '"';
  }
  
  private void _writeNull()
    throws IOException
  {
    if (_outputTail + 4 >= _outputEnd) {
      _flushBuffer();
    }
    System.arraycopy(NULL_BYTES, 0, _outputBuffer, _outputTail, 4);
    _outputTail += 4;
  }
  
  private void _writeQuotedInt(int paramInt)
    throws IOException
  {
    if (_outputTail + 13 >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    _outputTail = f.a(paramInt, arrayOfByte, _outputTail);
    arrayOfByte = _outputBuffer;
    paramInt = _outputTail;
    _outputTail = (paramInt + 1);
    arrayOfByte[paramInt] = 34;
  }
  
  private void _writeQuotedLong(long paramLong)
    throws IOException
  {
    if (_outputTail + 23 >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    _outputTail = f.a(paramLong, arrayOfByte, _outputTail);
    arrayOfByte = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
  }
  
  private void _writeQuotedRaw(Object paramObject)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    writeRaw(paramObject.toString());
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramObject = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramObject[i] = 34;
  }
  
  private final void _writeSegmentedRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int j = _outputEnd;
    byte[] arrayOfByte = _outputBuffer;
    if (paramInt1 < paramInt2)
    {
      int i;
      do
      {
        i = paramArrayOfChar[paramInt1];
        if (i >= 128)
        {
          if (_outputTail + 3 >= _outputEnd) {
            _flushBuffer();
          }
          i = paramInt1 + 1;
          paramInt1 = paramArrayOfChar[paramInt1];
          if (paramInt1 < 2048)
          {
            k = _outputTail;
            _outputTail = (k + 1);
            arrayOfByte[k] = ((byte)(paramInt1 >> 6 | 0xC0));
            k = _outputTail;
            _outputTail = (k + 1);
            arrayOfByte[k] = ((byte)(paramInt1 & 0x3F | 0x80));
          }
          else
          {
            _outputRawMultiByteChar(paramInt1, paramArrayOfChar, i, paramInt2);
          }
          paramInt1 = i;
          break;
        }
        if (_outputTail >= j) {
          _flushBuffer();
        }
        int k = _outputTail;
        _outputTail = (k + 1);
        arrayOfByte[k] = ((byte)i);
        i = paramInt1 + 1;
        paramInt1 = i;
      } while (i < paramInt2);
    }
  }
  
  private final void _writeStringSegment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int j = paramInt2 + paramInt1;
    int i = _outputTail;
    byte[] arrayOfByte = _outputBuffer;
    int[] arrayOfInt = _outputEscapes;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt2 < j)
    {
      i = paramArrayOfChar[paramInt2];
      if ((i > 127) || (arrayOfInt[i] != 0)) {
        break;
      }
      arrayOfByte[paramInt1] = ((byte)i);
      paramInt2 += 1;
      paramInt1 += 1;
    }
    _outputTail = paramInt1;
    if (paramInt2 < j)
    {
      if (_characterEscapes != null)
      {
        _writeCustomStringSegment2(paramArrayOfChar, paramInt2, j);
        return;
      }
      if (_maximumNonEscapedChar == 0)
      {
        _writeStringSegment2(paramArrayOfChar, paramInt2, j);
        return;
      }
      _writeStringSegmentASCII2(paramArrayOfChar, paramInt2, j);
    }
  }
  
  private final void _writeStringSegment2(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if ((paramInt2 - paramInt1) * 6 + _outputTail > _outputEnd) {
      _flushBuffer();
    }
    int j = _outputTail;
    byte[] arrayOfByte = _outputBuffer;
    int[] arrayOfInt = _outputEscapes;
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramInt2)
    {
      j = i + 1;
      i = paramArrayOfChar[i];
      int k;
      if (i <= 127)
      {
        if (arrayOfInt[i] == 0)
        {
          arrayOfByte[paramInt1] = ((byte)i);
          i = j;
          paramInt1 += 1;
          continue;
        }
        k = arrayOfInt[i];
        if (k > 0)
        {
          i = paramInt1 + 1;
          arrayOfByte[paramInt1] = 92;
          paramInt1 = i + 1;
          arrayOfByte[i] = ((byte)k);
        }
        else
        {
          paramInt1 = _writeGenericEscape(i, paramInt1);
        }
      }
      else if (i <= 2047)
      {
        k = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
        paramInt1 = k + 1;
        arrayOfByte[k] = ((byte)(i & 0x3F | 0x80));
      }
      else
      {
        paramInt1 = _outputMultiByteChar(i, paramInt1);
      }
      i = j;
    }
    _outputTail = paramInt1;
  }
  
  private final void _writeStringSegmentASCII2(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if ((paramInt2 - paramInt1) * 6 + _outputTail > _outputEnd) {
      _flushBuffer();
    }
    int j = _outputTail;
    byte[] arrayOfByte = _outputBuffer;
    int[] arrayOfInt = _outputEscapes;
    int k = _maximumNonEscapedChar;
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramInt2)
    {
      j = i + 1;
      i = paramArrayOfChar[i];
      int m;
      if (i <= 127)
      {
        if (arrayOfInt[i] == 0)
        {
          arrayOfByte[paramInt1] = ((byte)i);
          i = j;
          paramInt1 += 1;
          continue;
        }
        m = arrayOfInt[i];
        if (m > 0)
        {
          i = paramInt1 + 1;
          arrayOfByte[paramInt1] = 92;
          paramInt1 = i + 1;
          arrayOfByte[i] = ((byte)m);
        }
        else
        {
          paramInt1 = _writeGenericEscape(i, paramInt1);
        }
      }
      else
      {
        if (i <= k) {
          break label175;
        }
        paramInt1 = _writeGenericEscape(i, paramInt1);
      }
      for (;;)
      {
        i = j;
        break;
        label175:
        if (i <= 2047)
        {
          m = paramInt1 + 1;
          arrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
          paramInt1 = m + 1;
          arrayOfByte[m] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          paramInt1 = _outputMultiByteChar(i, paramInt1);
        }
      }
    }
    _outputTail = paramInt1;
  }
  
  private final void _writeStringSegments(String paramString)
    throws IOException, JsonGenerationException
  {
    int i = paramString.length();
    char[] arrayOfChar = _charBuffer;
    int k;
    for (int j = 0; i > 0; j = k)
    {
      int m = Math.min(_outputMaxContiguous, i);
      k = j + m;
      paramString.getChars(j, k, arrayOfChar, 0);
      if (_outputTail + m > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(arrayOfChar, 0, m);
      i -= m;
    }
  }
  
  private final void _writeStringSegments(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int i;
    do
    {
      i = Math.min(_outputMaxContiguous, paramInt2);
      if (_outputTail + i > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(paramArrayOfChar, paramInt1, i);
      paramInt1 += i;
      i = paramInt2 - i;
      paramInt2 = i;
    } while (i > 0);
  }
  
  private void _writeUTF8Segment(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int[] arrayOfInt = _outputEscapes;
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      int j = paramArrayOfByte[i];
      if ((j >= 0) && (arrayOfInt[j] != 0))
      {
        _writeUTF8Segment2(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      i += 1;
    }
    if (_outputTail + paramInt2 > _outputEnd) {
      _flushBuffer();
    }
    System.arraycopy(paramArrayOfByte, paramInt1, _outputBuffer, _outputTail, paramInt2);
    _outputTail += paramInt2;
  }
  
  private void _writeUTF8Segment2(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int j = _outputTail;
    int k = j;
    if (paramInt2 * 6 + j > _outputEnd)
    {
      _flushBuffer();
      k = _outputTail;
    }
    byte[] arrayOfByte = _outputBuffer;
    int[] arrayOfInt = _outputEscapes;
    j = paramInt1;
    for (;;)
    {
      int m = j;
      if (m >= paramInt2 + paramInt1) {
        break;
      }
      j = m + 1;
      int i = paramArrayOfByte[m];
      if ((i >= 0) && (arrayOfInt[i] != 0))
      {
        m = arrayOfInt[i];
        if (m > 0)
        {
          int n = k + 1;
          arrayOfByte[k] = 92;
          k = n + 1;
          arrayOfByte[n] = ((byte)m);
        }
        else
        {
          k = _writeGenericEscape(i, k);
        }
      }
      else
      {
        arrayOfByte[k] = i;
        k += 1;
      }
    }
    _outputTail = k;
  }
  
  private void _writeUTF8Segments(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int i;
    do
    {
      i = Math.min(_outputMaxContiguous, paramInt2);
      _writeUTF8Segment(paramArrayOfByte, paramInt1, i);
      paramInt1 += i;
      i = paramInt2 - i;
      paramInt2 = i;
    } while (i > 0);
  }
  
  public final int _decodeSurrogate(int paramInt1, int paramInt2)
    throws IOException
  {
    if ((paramInt2 < 56320) || (paramInt2 > 57343))
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Incomplete surrogate pair: first char 0x");
      localStringBuilder.append(Integer.toHexString(paramInt1));
      localStringBuilder.append(", second 0x");
      localStringBuilder.append(Integer.toHexString(paramInt2));
      _reportError(localStringBuilder.toString());
    }
    return paramInt2 - 56320 + ((paramInt1 - 55296 << 10) + 65536);
  }
  
  public final void _flushBuffer()
    throws IOException
  {
    int i = _outputTail;
    if (i > 0)
    {
      _outputTail = 0;
      _outputStream.write(_outputBuffer, 0, i);
    }
  }
  
  public final void _outputSurrogates(int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = _decodeSurrogate(paramInt1, paramInt2);
    if (_outputTail + 4 > _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    paramInt2 = _outputTail;
    _outputTail = (paramInt2 + 1);
    arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 18 | 0xF0));
    paramInt2 = _outputTail;
    _outputTail = (paramInt2 + 1);
    arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 12 & 0x3F | 0x80));
    paramInt2 = _outputTail;
    _outputTail = (paramInt2 + 1);
    arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
    paramInt2 = _outputTail;
    _outputTail = (paramInt2 + 1);
    arrayOfByte[paramInt2] = ((byte)(paramInt1 & 0x3F | 0x80));
  }
  
  public void _releaseBuffers()
  {
    Object localObject = _outputBuffer;
    if ((localObject != null) && (_bufferRecyclable))
    {
      _outputBuffer = null;
      _ioContext.releaseWriteEncodingBuffer((byte[])localObject);
    }
    localObject = _charBuffer;
    if (localObject != null)
    {
      _charBuffer = null;
      _ioContext.releaseConcatBuffer((char[])localObject);
    }
  }
  
  public final void _verifyPrettyValueWrite(String paramString, int paramInt)
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
  
  public final void _verifyValueWrite(String paramString)
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
          paramString = paramString.asUnquotedUTF8();
          if (paramString.length <= 0) {
            return;
          }
          _writeBytes(paramString);
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
        byte[] arrayOfByte = _outputBuffer;
        i = _outputTail;
        _outputTail = (i + 1);
        arrayOfByte[i] = 92;
        i = _outputTail;
        _outputTail = (i + 1);
        arrayOfByte[i] = 110;
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
        byte[] arrayOfByte = _outputBuffer;
        paramInt = _outputTail;
        _outputTail = (paramInt + 1);
        arrayOfByte[paramInt] = 92;
        paramInt = _outputTail;
        _outputTail = (paramInt + 1);
        arrayOfByte[paramInt] = 110;
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
        byte[] arrayOfByte = _outputBuffer;
        paramInt1 = _outputTail;
        _outputTail = (paramInt1 + 1);
        arrayOfByte[paramInt1] = 92;
        paramInt1 = _outputTail;
        _outputTail = (paramInt1 + 1);
        arrayOfByte[paramInt1] = 110;
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
  
  public final void _writeFieldName(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      i = paramSerializableString.appendQuotedUTF8(_outputBuffer, _outputTail);
      if (i < 0)
      {
        _writeBytes(paramSerializableString.asQuotedUTF8());
        return;
      }
      _outputTail += i;
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    i = paramSerializableString.appendQuotedUTF8(arrayOfByte, _outputTail);
    if (i < 0) {
      _writeBytes(paramSerializableString.asQuotedUTF8());
    } else {
      _outputTail += i;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramSerializableString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramSerializableString[i] = 34;
  }
  
  public final void _writeFieldName(String paramString)
    throws IOException, JsonGenerationException
  {
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      _writeStringSegments(paramString);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    i = paramString.length();
    if (i <= _charBufferLength)
    {
      paramString.getChars(0, i, _charBuffer, 0);
      if (i <= _outputMaxContiguous)
      {
        if (_outputTail + i > _outputEnd) {
          _flushBuffer();
        }
        _writeStringSegment(_charBuffer, 0, i);
      }
      else
      {
        _writeStringSegments(_charBuffer, 0, i);
      }
    }
    else
    {
      _writeStringSegments(paramString);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  public final void _writePPFieldName(SerializableString paramSerializableString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (paramBoolean) {
      _cfgPrettyPrinter.writeObjectEntrySeparator(this);
    } else {
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
    paramBoolean = isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES);
    int i;
    if (paramBoolean)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = 34;
    }
    _writeBytes(paramSerializableString.asQuotedUTF8());
    if (paramBoolean)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramSerializableString[i] = 34;
    }
  }
  
  public final void _writePPFieldName(String paramString, boolean paramBoolean)
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
      byte[] arrayOfByte = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = 34;
      i = paramString.length();
      if (i <= _charBufferLength)
      {
        paramString.getChars(0, i, _charBuffer, 0);
        if (i <= _outputMaxContiguous)
        {
          if (_outputTail + i > _outputEnd) {
            _flushBuffer();
          }
          _writeStringSegment(_charBuffer, 0, i);
        }
        else
        {
          _writeStringSegments(_charBuffer, 0, i);
        }
      }
      else
      {
        _writeStringSegments(paramString);
      }
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramString[i] = 34;
      return;
    }
    _writeStringSegments(paramString);
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
    if (_outputStream != null) {
      if ((!_ioContext.isResourceManaged()) && (!isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)))
      {
        if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
          _outputStream.flush();
        }
      }
      else {
        _outputStream.close();
      }
    }
    _releaseBuffers();
  }
  
  public final void flush()
    throws IOException
  {
    _flushBuffer();
    if ((_outputStream != null) && (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      _outputStream.flush();
    }
  }
  
  public Object getOutputTarget()
  {
    return _outputStream;
  }
  
  public int writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, int paramInt)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write binary value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    arrayOfByte = _ioContext.allocBase64Buffer();
    if (paramInt < 0) {}
    try
    {
      i = _writeBinary(paramBase64Variant, paramInputStream, arrayOfByte);
      break label150;
      int j = _writeBinary(paramBase64Variant, paramInputStream, arrayOfByte, paramInt);
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
      _ioContext.releaseBase64Buffer(arrayOfByte);
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
      _ioContext.releaseBase64Buffer(arrayOfByte);
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
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
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
    byte[] arrayOfByte;
    if (paramBoolean) {
      arrayOfByte = TRUE_BYTES;
    } else {
      arrayOfByte = FALSE_BYTES;
    }
    int i = arrayOfByte.length;
    System.arraycopy(arrayOfByte, 0, _outputBuffer, _outputTail, i);
    _outputTail += i;
  }
  
  public final void writeEndArray()
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
  
  public final void writeEndObject()
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
  
  public final void writeFieldName(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    int i = _writeContext.writeFieldName(paramSerializableString.getValue());
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    Object localObject = _cfgPrettyPrinter;
    boolean bool = true;
    if (localObject != null)
    {
      if (i != 1) {
        bool = false;
      }
      _writePPFieldName(paramSerializableString, bool);
      return;
    }
    if (i == 1)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      localObject = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      localObject[i] = 44;
    }
    _writeFieldName(paramSerializableString);
  }
  
  public final void writeFieldName(String paramString)
    throws IOException, JsonGenerationException
  {
    int i = _writeContext.writeFieldName(paramString);
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    Object localObject = _cfgPrettyPrinter;
    boolean bool = true;
    if (localObject != null)
    {
      if (i != 1) {
        bool = false;
      }
      _writePPFieldName(paramString, bool);
      return;
    }
    if (i == 1)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      localObject = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      localObject[i] = 44;
    }
    _writeFieldName(paramString);
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
    if (_outputTail + 11 >= _outputEnd) {
      _flushBuffer();
    }
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedInt(paramInt);
      return;
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
    if (_outputTail + 3 >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i;
    if (paramChar <= '')
    {
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = ((byte)paramChar);
      return;
    }
    if (paramChar < '?')
    {
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = ((byte)(paramChar >> '\006' | 0xC0));
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = ((byte)(paramChar & 0x3F | 0x80));
      return;
    }
    _outputRawMultiByteChar(paramChar, null, 0, 0);
  }
  
  public void writeRaw(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    paramSerializableString = paramSerializableString.asUnquotedUTF8();
    if (paramSerializableString.length > 0) {
      _writeBytes(paramSerializableString);
    }
  }
  
  public void writeRaw(String paramString)
    throws IOException, JsonGenerationException
  {
    int i = paramString.length();
    int m;
    for (int j = 0; i > 0; j = m)
    {
      char[] arrayOfChar = _charBuffer;
      m = arrayOfChar.length;
      int k = m;
      if (i < m) {
        k = i;
      }
      m = j + k;
      paramString.getChars(j, m, arrayOfChar, 0);
      writeRaw(arrayOfChar, 0, k);
      i -= k;
    }
  }
  
  public void writeRaw(String paramString, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    while (paramInt2 > 0)
    {
      char[] arrayOfChar = _charBuffer;
      int j = arrayOfChar.length;
      int i = j;
      if (paramInt2 < j) {
        i = paramInt2;
      }
      j = paramInt1 + i;
      paramString.getChars(paramInt1, j, arrayOfChar, 0);
      writeRaw(arrayOfChar, 0, i);
      paramInt2 -= i;
      paramInt1 = j;
    }
  }
  
  public final void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int i = paramInt2 + paramInt2 + paramInt2;
    int j = _outputTail;
    int k = _outputEnd;
    if (j + i > k)
    {
      if (k < i)
      {
        _writeSegmentedRaw(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
      _flushBuffer();
    }
    i = paramInt2 + paramInt1;
    if (paramInt1 < i) {
      do
      {
        paramInt2 = paramArrayOfChar[paramInt1];
        if (paramInt2 > 127)
        {
          paramInt2 = paramInt1 + 1;
          paramInt1 = paramArrayOfChar[paramInt1];
          if (paramInt1 < 2048)
          {
            arrayOfByte = _outputBuffer;
            j = _outputTail;
            _outputTail = (j + 1);
            arrayOfByte[j] = ((byte)(paramInt1 >> 6 | 0xC0));
            j = _outputTail;
            _outputTail = (j + 1);
            arrayOfByte[j] = ((byte)(paramInt1 & 0x3F | 0x80));
          }
          else
          {
            _outputRawMultiByteChar(paramInt1, paramArrayOfChar, paramInt2, i);
          }
          paramInt1 = paramInt2;
          break;
        }
        byte[] arrayOfByte = _outputBuffer;
        j = _outputTail;
        _outputTail = (j + 1);
        arrayOfByte[j] = ((byte)paramInt2);
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramInt2;
      } while (paramInt2 < i);
    }
  }
  
  public void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write text value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    _writeBytes(paramArrayOfByte, paramInt1, paramInt2);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramArrayOfByte = _outputBuffer;
    paramInt1 = _outputTail;
    _outputTail = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = 34;
  }
  
  public final void writeStartArray()
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
  
  public final void writeStartObject()
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
  
  public final void writeString(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write text value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    i = paramSerializableString.appendQuotedUTF8(arrayOfByte, _outputTail);
    if (i < 0) {
      _writeBytes(paramSerializableString.asQuotedUTF8());
    } else {
      _outputTail += i;
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
    int i = paramString.length();
    if (i > _charBufferLength)
    {
      _writeLongString(paramString);
      return;
    }
    paramString.getChars(0, i, _charBuffer, 0);
    if (i > _outputMaxContiguous)
    {
      _writeLongString(_charBuffer, 0, i);
      return;
    }
    if (_outputTail + i >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    int j = _outputTail;
    _outputTail = (j + 1);
    paramString[j] = 34;
    _writeStringSegment(_charBuffer, 0, i);
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
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    if (paramInt2 <= _outputMaxContiguous)
    {
      if (_outputTail + paramInt2 > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(paramArrayOfChar, paramInt1, paramInt2);
    }
    else
    {
      _writeStringSegments(paramArrayOfChar, paramInt1, paramInt2);
    }
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
    _verifyValueWrite("write text value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    if (paramInt2 <= _outputMaxContiguous) {
      _writeUTF8Segment(paramArrayOfByte, paramInt1, paramInt2);
    } else {
      _writeUTF8Segments(paramArrayOfByte, paramInt1, paramInt2);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramArrayOfByte = _outputBuffer;
    paramInt1 = _outputTail;
    _outputTail = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = 34;
  }
}
