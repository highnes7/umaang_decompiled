package f.fasterxml.jackson.core.json;

import f.fasterxml.jackson.core.'annotation'.ParserBase;
import f.fasterxml.jackson.core.'annotation'.ParserMinimalBase;
import f.fasterxml.jackson.core.Base64Variant;
import f.fasterxml.jackson.core.JsonParseException;
import f.fasterxml.jackson.core.JsonParser;
import f.fasterxml.jackson.core.JsonParser.Feature;
import f.fasterxml.jackson.core.JsonStreamContext;
import f.fasterxml.jackson.core.JsonToken;
import f.fasterxml.jackson.core.ObjectCodec;
import f.fasterxml.jackson.core.SerializableString;
import f.fasterxml.jackson.core.Version;
import f.fasterxml.jackson.core.impl.IOContext;
import f.fasterxml.jackson.core.impl.Utf8StreamParser;
import f.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import f.fasterxml.jackson.core.sym.Name;
import f.fasterxml.jackson.core.sym.Name1;
import f.fasterxml.jackson.core.util.ByteArrayBuilder;
import f.fasterxml.jackson.core.util.TextBuffer;
import f.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class UTF8StreamJsonParser
  extends ParserBase
{
  public static final byte BYTE_LF = 10;
  public static final int[] sInputCodesLatin1 = Utf8StreamParser._inputPtr;
  public static final int[] sInputCodesUtf8 = Utf8StreamParser.sInputCodesLatin1;
  public boolean _bufferRecyclable;
  public byte[] _inputBuffer;
  public InputStream _inputStream;
  public ObjectCodec _objectCodec;
  public int _quad1;
  public int[] _quadBuffer = new int[16];
  public final BytesToNameCanonicalizer _symbols;
  public boolean _tokenIncomplete = false;
  
  public UTF8StreamJsonParser(IOContext paramIOContext, int paramInt1, InputStream paramInputStream, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramIOContext, paramInt1);
    _inputStream = paramInputStream;
    _objectCodec = paramObjectCodec;
    _symbols = paramBytesToNameCanonicalizer;
    _inputBuffer = paramArrayOfByte;
    _inputPtr = paramInt2;
    _inputEnd = paramInt3;
    _bufferRecyclable = paramBoolean;
  }
  
  private int _decodeUtf8_2(int paramInt)
    throws IOException, JsonParseException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    return (paramInt & 0x1F) << 6 | i & 0x3F;
  }
  
  private int _decodeUtf8_3(int paramInt)
    throws IOException, JsonParseException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private int _decodeUtf8_3fast(int paramInt)
    throws IOException, JsonParseException
  {
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private int _decodeUtf8_4(int paramInt)
    throws IOException, JsonParseException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int k = _inputPtr;
    _inputPtr = (k + 1);
    k = arrayOfByte[k];
    if ((k & 0xC0) != 128) {
      _reportInvalidOther(k & 0xFF, _inputPtr);
    }
    return ((((paramInt & 0x7) << 6 | i & 0x3F) << 6 | j & 0x3F) << 6 | k & 0x3F) - 65536;
  }
  
  private void _finishString2(char[] paramArrayOfChar, int paramInt)
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = _inputBuffer;
    char[] arrayOfChar = paramArrayOfChar;
    for (;;)
    {
      int i = _inputPtr;
      int j = i;
      if (i >= _inputEnd)
      {
        loadMoreGuaranteed();
        j = _inputPtr;
      }
      paramArrayOfChar = arrayOfChar;
      i = paramInt;
      if (paramInt >= arrayOfChar.length)
      {
        paramArrayOfChar = _textBuffer.finishCurrentSegment();
        i = 0;
      }
      int k = Math.min(_inputEnd, paramArrayOfChar.length - i + j);
      for (;;)
      {
        if (j >= k) {
          break label363;
        }
        paramInt = j + 1;
        j = arrayOfByte[j] & 0xFF;
        if (arrayOfInt[j] != 0)
        {
          _inputPtr = paramInt;
          if (j == 34)
          {
            _textBuffer.setCurrentLength(i);
            return;
          }
          paramInt = arrayOfInt[j];
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3)
              {
                if (paramInt != 4)
                {
                  if (j < 32)
                  {
                    _throwUnquotedSpace(j, "string value");
                    paramInt = j;
                  }
                  else
                  {
                    _reportInvalidChar(j);
                    paramInt = j;
                  }
                }
                else
                {
                  k = _decodeUtf8_4(j);
                  j = i + 1;
                  paramArrayOfChar[i] = ((char)(0xD800 | k >> 10));
                  paramInt = j;
                  arrayOfChar = paramArrayOfChar;
                  if (j >= paramArrayOfChar.length)
                  {
                    arrayOfChar = _textBuffer.finishCurrentSegment();
                    paramInt = 0;
                  }
                  j = k & 0x3FF | 0xDC00;
                  i = paramInt;
                  paramInt = j;
                  paramArrayOfChar = arrayOfChar;
                }
              }
              else if (_inputEnd - _inputPtr >= 2) {
                paramInt = _decodeUtf8_3fast(j);
              } else {
                paramInt = _decodeUtf8_3(j);
              }
            }
            else {
              paramInt = _decodeUtf8_2(j);
            }
          }
          else {
            paramInt = _decodeEscaped();
          }
          arrayOfChar = paramArrayOfChar;
          j = i;
          if (i >= paramArrayOfChar.length)
          {
            arrayOfChar = _textBuffer.finishCurrentSegment();
            j = 0;
          }
          arrayOfChar[j] = ((char)paramInt);
          paramInt = j + 1;
          break;
        }
        paramArrayOfChar[i] = ((char)j);
        j = paramInt;
        i += 1;
      }
      label363:
      _inputPtr = j;
      arrayOfChar = paramArrayOfChar;
      paramInt = i;
    }
  }
  
  private boolean _isNextTokenNameMaybe(int paramInt, SerializableString paramSerializableString)
    throws IOException, JsonParseException
  {
    String str = _parseFieldName(paramInt).getName();
    _parsingContext.setCurrentName(str);
    boolean bool = str.equals(paramSerializableString.getValue());
    _currToken = JsonToken.FIELD_NAME;
    paramInt = _skipWS();
    if (paramInt != 58) {
      _reportUnexpectedChar(paramInt, "was expecting a colon to separate field name and value");
    }
    paramInt = _skipWS();
    if (paramInt == 34)
    {
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return bool;
    }
    if (paramInt != 45)
    {
      if (paramInt != 91) {
        if (paramInt != 93) {
          if (paramInt != 102) {
            if (paramInt != 110)
            {
              if (paramInt == 116) {
                break label274;
              }
              if (paramInt != 123) {
                if (paramInt == 125) {
                  break label267;
                }
              }
            }
          }
        }
      }
      switch (paramInt)
      {
      default: 
        paramSerializableString = _handleUnexpectedValue(paramInt);
        break;
        paramSerializableString = JsonToken.START_OBJECT;
        break;
        _matchToken("null", 1);
        paramSerializableString = JsonToken.VALUE_NULL;
        break;
        _matchToken("false", 1);
        paramSerializableString = JsonToken.VALUE_FALSE;
        break;
        label267:
        _reportUnexpectedChar(paramInt, "expected a value");
        label274:
        _matchToken("true", 1);
        paramSerializableString = JsonToken.VALUE_TRUE;
        break;
        paramSerializableString = JsonToken.START_ARRAY;
        break;
      }
    }
    else
    {
      paramSerializableString = parseNumberText(paramInt);
    }
    _nextToken = paramSerializableString;
    return bool;
  }
  
  private void _isNextTokenNameYes()
    throws IOException, JsonParseException
  {
    int i = _inputPtr;
    if (i < _inputEnd)
    {
      byte[] arrayOfByte = _inputBuffer;
      if (arrayOfByte[i] == 58)
      {
        _inputPtr = (i + 1);
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfByte[i];
        if (i == 34)
        {
          _tokenIncomplete = true;
          _nextToken = JsonToken.VALUE_STRING;
          return;
        }
        if (i == 123)
        {
          _nextToken = JsonToken.START_OBJECT;
          return;
        }
        if (i == 91)
        {
          _nextToken = JsonToken.START_ARRAY;
          return;
        }
        int j = i & 0xFF;
        if (j > 32)
        {
          i = j;
          if (j != 47) {
            break label139;
          }
        }
        _inputPtr -= 1;
        i = _skipWS();
        break label139;
      }
    }
    i = _skipColon();
    label139:
    if (i != 34)
    {
      if (i != 45)
      {
        if (i != 91) {
          if (i != 93) {
            if (i != 102) {
              if (i != 110)
              {
                if (i == 116) {
                  break label342;
                }
                if (i != 123) {
                  if (i == 125) {
                    break label335;
                  }
                }
              }
            }
          }
        }
        switch (i)
        {
        default: 
          _nextToken = _handleUnexpectedValue(i);
          return;
          _nextToken = JsonToken.START_OBJECT;
          return;
          _matchToken("null", 1);
          _nextToken = JsonToken.VALUE_NULL;
          return;
          _matchToken("false", 1);
          _nextToken = JsonToken.VALUE_FALSE;
          return;
          label335:
          _reportUnexpectedChar(i, "expected a value");
          label342:
          _matchToken("true", 1);
          _nextToken = JsonToken.VALUE_TRUE;
          return;
          _nextToken = JsonToken.START_ARRAY;
          return;
        }
      }
      _nextToken = parseNumberText(i);
      return;
    }
    _tokenIncomplete = true;
    _nextToken = JsonToken.VALUE_STRING;
  }
  
  private JsonToken _nextAfterName()
  {
    _nameCopied = false;
    JsonToken localJsonToken = _nextToken;
    _nextToken = null;
    if (localJsonToken == JsonToken.START_ARRAY) {
      _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
    } else if (localJsonToken == JsonToken.START_OBJECT) {
      _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
    }
    _currToken = localJsonToken;
    return localJsonToken;
  }
  
  private JsonToken _parseFloatText(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    throws IOException, JsonParseException
  {
    int m = 0;
    int j;
    int i;
    int k;
    Object localObject;
    if (paramInt2 == 46)
    {
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      j = paramInt1 + 1;
      i = paramInt2;
      paramInt1 = 0;
      paramInt2 = j;
      for (;;)
      {
        if ((_inputPtr >= _inputEnd) && (!loadMore()))
        {
          k = 1;
          j = i;
          i = k;
          break label161;
        }
        localObject = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        j = localObject[i] & 0xFF;
        if ((j < 48) || (j > 57)) {
          break;
        }
        k = paramInt1 + 1;
        localObject = paramArrayOfChar;
        paramInt1 = paramInt2;
        if (paramInt2 >= paramArrayOfChar.length)
        {
          localObject = _textBuffer.finishCurrentSegment();
          paramInt1 = 0;
        }
        localObject[paramInt1] = ((char)j);
        paramInt2 = paramInt1 + 1;
        i = j;
        paramArrayOfChar = (char[])localObject;
        paramInt1 = k;
      }
      i = 0;
      label161:
      if (paramInt1 == 0) {
        reportUnexpectedNumberChar(j, "Decimal point not followed by a digit");
      }
      k = j;
      j = paramInt1;
      paramInt1 = i;
      localObject = paramArrayOfChar;
      i = k;
    }
    else
    {
      j = 0;
      k = 0;
      i = paramInt2;
      paramInt2 = paramInt1;
      localObject = paramArrayOfChar;
      paramInt1 = k;
    }
    int n;
    int i1;
    if (i != 101)
    {
      n = paramInt1;
      i1 = paramInt2;
      if (i != 69) {}
    }
    else
    {
      paramArrayOfChar = (char[])localObject;
      k = paramInt2;
      if (paramInt2 >= localObject.length)
      {
        paramArrayOfChar = _textBuffer.finishCurrentSegment();
        k = 0;
      }
      paramInt2 = k + 1;
      paramArrayOfChar[k] = ((char)i);
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = _inputBuffer;
      i = _inputPtr;
      _inputPtr = (i + 1);
      k = localObject[i] & 0xFF;
      if ((k != 45) && (k != 43)) {
        i = k;
      }
      for (;;)
      {
        m = 0;
        k = i;
        localObject = paramArrayOfChar;
        i = m;
        break;
        i = paramInt2;
        localObject = paramArrayOfChar;
        if (paramInt2 >= paramArrayOfChar.length)
        {
          localObject = _textBuffer.finishCurrentSegment();
          i = 0;
        }
        paramInt2 = i + 1;
        localObject[i] = ((char)k);
        if (_inputPtr >= _inputEnd) {
          loadMoreGuaranteed();
        }
        paramArrayOfChar = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = paramArrayOfChar[i] & 0xFF;
        paramArrayOfChar = (char[])localObject;
      }
      while ((k <= 57) && (k >= 48))
      {
        i += 1;
        paramArrayOfChar = (char[])localObject;
        m = paramInt2;
        if (paramInt2 >= localObject.length)
        {
          paramArrayOfChar = _textBuffer.finishCurrentSegment();
          m = 0;
        }
        paramInt2 = m + 1;
        paramArrayOfChar[m] = ((char)k);
        if ((_inputPtr >= _inputEnd) && (!loadMore()))
        {
          paramInt1 = i;
          i = paramInt2;
          paramInt2 = 1;
          break label571;
        }
        localObject = _inputBuffer;
        k = _inputPtr;
        _inputPtr = (k + 1);
        k = localObject[k] & 0xFF;
        localObject = paramArrayOfChar;
      }
      m = i;
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = m;
      label571:
      m = paramInt1;
      n = paramInt2;
      i1 = i;
      if (paramInt1 == 0)
      {
        reportUnexpectedNumberChar(k, "Exponent indicator not followed by a digit");
        i1 = i;
        n = paramInt2;
        m = paramInt1;
      }
    }
    if (n == 0) {
      _inputPtr -= 1;
    }
    _textBuffer.setCurrentLength(i1);
    return resetFloat(paramBoolean, paramInt3, j, m);
  }
  
  private JsonToken _parserNumber2(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException, JsonParseException
  {
    int j;
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore()))
      {
        _textBuffer.setCurrentLength(paramInt1);
        return resetInt(paramBoolean, paramInt2);
      }
      Object localObject = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      j = localObject[i] & 0xFF;
      if ((j > 57) || (j < 48)) {
        break;
      }
      localObject = paramArrayOfChar;
      i = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        paramArrayOfChar = _textBuffer;
        i = 0;
        localObject = paramArrayOfChar.finishCurrentSegment();
      }
      localObject[i] = ((char)j);
      paramInt2 += 1;
      paramInt1 = i + 1;
      paramArrayOfChar = (char[])localObject;
    }
    if ((j != 46) && (j != 101) && (j != 69))
    {
      _inputPtr -= 1;
      _textBuffer.setCurrentLength(paramInt1);
      return resetInt(paramBoolean, paramInt2);
    }
    return _parseFloatText(paramArrayOfChar, paramInt1, j, paramBoolean, paramInt2);
  }
  
  private void _skipCComment()
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = Utf8StreamParser._inputBuffer;
    for (;;)
    {
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        arrayOfByte = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        int j = arrayOfInt[i];
        if (j == 0) {
          continue;
        }
        if (j == 2) {
          break label182;
        }
        if (j == 3) {
          break label174;
        }
        if (j == 4) {
          break label166;
        }
        if (j == 10) {
          break label159;
        }
        if (j == 13) {
          break label152;
        }
        if (j != 42)
        {
          _reportInvalidChar(i);
          continue;
        }
        if ((_inputPtr < _inputEnd) || (loadMore())) {}
      }
      else
      {
        _reportInvalidEOF(" in a comment");
        return;
      }
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      if (arrayOfByte[i] == 47)
      {
        _inputPtr = (i + 1);
        return;
        label152:
        _skipCR();
        continue;
        label159:
        _skipLF();
        continue;
        label166:
        _skipUtf8_2(i);
        continue;
        label174:
        _skipUtf8_3(i);
        continue;
        label182:
        _skipUtf8_4(i);
      }
    }
  }
  
  private int _skipColon()
    throws IOException, JsonParseException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    Object localObject = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = localObject[i];
    if (i == 58)
    {
      i = _inputPtr;
      if (i < _inputEnd)
      {
        int j = localObject[i] & 0xFF;
        if ((j > 32) && (j != 47))
        {
          _inputPtr = (i + 1);
          return j;
        }
      }
    }
    else
    {
      i &= 0xFF;
    }
    for (;;)
    {
      if (i != 9) {
        if (i != 10)
        {
          if (i != 13)
          {
            if (i != 32)
            {
              if (i != 47)
              {
                if (i < 32) {
                  _throwInvalidSpace(i);
                }
                if (i != 58) {
                  _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
                }
                for (;;)
                {
                  if ((_inputPtr >= _inputEnd) && (!loadMore()))
                  {
                    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected end-of-input within/between ");
                    ((StringBuilder)localObject).append(_parsingContext.getTypeDesc());
                    ((StringBuilder)localObject).append(" entries");
                    throw _constructError(((StringBuilder)localObject).toString());
                  }
                  localObject = _inputBuffer;
                  i = _inputPtr;
                  _inputPtr = (i + 1);
                  i = localObject[i] & 0xFF;
                  if (i > 32)
                  {
                    if (i != 47) {
                      return i;
                    }
                    _skipComment();
                  }
                  else if (i != 32)
                  {
                    if (i == 10) {
                      _skipLF();
                    } else if (i == 13) {
                      _skipCR();
                    } else if (i != 9) {
                      _throwInvalidSpace(i);
                    }
                  }
                }
              }
              _skipComment();
            }
          }
          else {
            _skipCR();
          }
        }
        else {
          _skipLF();
        }
      }
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = _inputBuffer;
      i = _inputPtr;
      _inputPtr = (i + 1);
      i = localObject[i] & 0xFF;
    }
  }
  
  private void _skipComment()
    throws IOException, JsonParseException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
      _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    }
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in a comment");
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (i == 47)
    {
      _skipCppComment();
      return;
    }
    if (i == 42)
    {
      _skipCComment();
      return;
    }
    _reportUnexpectedChar(i, "was expecting either '*' or '/' for a comment");
  }
  
  private void _skipCppComment()
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = Utf8StreamParser._inputBuffer;
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        return;
      }
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      int j = arrayOfInt[i];
      if (j != 0) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j != 10)
              {
                if (j != 13)
                {
                  if (j != 42) {
                    _reportInvalidChar(i);
                  }
                }
                else {
                  _skipCR();
                }
              }
              else {
                _skipLF();
              }
            }
            else {
              _skipUtf8_2(i);
            }
          }
          else {
            _skipUtf8_3(i);
          }
        }
        else {
          _skipUtf8_4(i);
        }
      }
    }
  }
  
  private void _skipUtf8_2(int paramInt)
    throws IOException, JsonParseException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
  }
  
  private void _skipUtf8_3(int paramInt)
    throws IOException, JsonParseException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
  }
  
  private void _skipUtf8_4(int paramInt)
    throws IOException, JsonParseException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
  }
  
  private int _skipWS()
    throws IOException, JsonParseException
  {
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore()))
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected end-of-input within/between ");
        ((StringBuilder)localObject).append(_parsingContext.getTypeDesc());
        ((StringBuilder)localObject).append(" entries");
        throw _constructError(((StringBuilder)localObject).toString());
      }
      Object localObject = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = localObject[i] & 0xFF;
      if (i > 32)
      {
        if (i != 47) {
          return i;
        }
        _skipComment();
      }
      else if (i != 32)
      {
        if (i == 10) {
          _skipLF();
        } else if (i == 13) {
          _skipCR();
        } else if (i != 9) {
          _throwInvalidSpace(i);
        }
      }
    }
  }
  
  private int _skipWSOrEnd()
    throws IOException, JsonParseException
  {
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore()))
      {
        _handleEOF();
        return -1;
      }
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i != 47) {
          return i;
        }
        _skipComment();
      }
      else if (i != 32)
      {
        if (i == 10) {
          _skipLF();
        } else if (i == 13) {
          _skipCR();
        } else if (i != 9) {
          _throwInvalidSpace(i);
        }
      }
    }
  }
  
  private int _verifyNoLeadingZeroes()
    throws IOException, JsonParseException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      return 48;
    }
    int i = _inputBuffer[_inputPtr] & 0xFF;
    if (i >= 48)
    {
      if (i > 57) {
        return 48;
      }
      if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
        reportInvalidNumber("Leading zeroes not allowed");
      }
      _inputPtr += 1;
      if (i == 48)
      {
        int j;
        do
        {
          if ((_inputPtr >= _inputEnd) && (!loadMore())) {
            return i;
          }
          byte[] arrayOfByte = _inputBuffer;
          i = _inputPtr;
          j = arrayOfByte[i] & 0xFF;
          if (j < 48) {
            break;
          }
          if (j > 57) {
            return 48;
          }
          _inputPtr = (i + 1);
          i = j;
        } while (j == 48);
        return j;
        return 48;
      }
      return i;
    }
    return 48;
    return i;
  }
  
  private Name addName(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws JsonParseException
  {
    int i4 = (paramInt1 << 2) - 4 + paramInt2;
    int i;
    int i2;
    if (paramInt2 < 4)
    {
      i = paramInt1 - 1;
      i2 = paramArrayOfInt[i];
      paramArrayOfInt[i] = (i2 << (4 - paramInt2 << 3));
    }
    else
    {
      i2 = 0;
    }
    Object localObject1 = _textBuffer.emptyAndGetCurrentSegment();
    int n = 0;
    int i3;
    for (int m = 0; n < i4; m = i3 + 1)
    {
      i = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3) & 0xFF;
      int k = n + 1;
      n = k;
      i3 = m;
      Object localObject2 = localObject1;
      int i1 = i;
      if (i > 127)
      {
        if ((i & 0xE0) == 192)
        {
          j = i & 0x1F;
          i = 1;
        }
        else if ((i & 0xF0) == 224)
        {
          j = i & 0xF;
          i = 2;
        }
        else if ((i & 0xF8) == 240)
        {
          j = i & 0x7;
          i = 3;
        }
        else
        {
          _reportInvalidInitial(i);
          i = 1;
          j = 1;
        }
        if (k + i > i4) {
          _reportInvalidEOF(" in field name");
        }
        i1 = paramArrayOfInt[(k >> 2)] >> (3 - (k & 0x3) << 3);
        n = k + 1;
        if ((i1 & 0xC0) != 128) {
          _reportInvalidOther(i1);
        }
        i1 = j << 6 | i1 & 0x3F;
        int j = n;
        k = i1;
        if (i > 1)
        {
          j = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
          n += 1;
          if ((j & 0xC0) != 128) {
            _reportInvalidOther(j);
          }
          i1 = j & 0x3F | i1 << 6;
          j = n;
          k = i1;
          if (i > 2)
          {
            k = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
            j = n + 1;
            if ((k & 0xC0) != 128) {
              _reportInvalidOther(k & 0xFF);
            }
            k = i1 << 6 | k & 0x3F;
          }
        }
        n = j;
        i3 = m;
        localObject2 = localObject1;
        i1 = k;
        if (i > 2)
        {
          i = k - 65536;
          localObject2 = localObject1;
          if (m >= localObject1.length) {
            localObject2 = _textBuffer.expandCurrentSegment();
          }
          localObject2[m] = ((char)((i >> 10) + 55296));
          i1 = i & 0x3FF | 0xDC00;
          i3 = m + 1;
          n = j;
        }
      }
      localObject1 = localObject2;
      if (i3 >= localObject2.length) {
        localObject1 = _textBuffer.expandCurrentSegment();
      }
      localObject1[i3] = ((char)i1);
    }
    localObject1 = new String((char[])localObject1, 0, m);
    if (paramInt2 < 4) {
      paramArrayOfInt[(paramInt1 - 1)] = i2;
    }
    return _symbols.addName((String)localObject1, paramArrayOfInt, paramInt1);
  }
  
  private Name findName(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    Object localObject = _symbols.findName(paramInt1);
    if (localObject != null) {
      return localObject;
    }
    localObject = _quadBuffer;
    localObject[0] = paramInt1;
    return addName((int[])localObject, 1, paramInt2);
  }
  
  private Name findName(int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
  {
    Object localObject = _symbols.findName(paramInt1, paramInt2);
    if (localObject != null) {
      return localObject;
    }
    localObject = _quadBuffer;
    localObject[0] = paramInt1;
    localObject[1] = paramInt2;
    return addName((int[])localObject, 2, paramInt3);
  }
  
  private Name findName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 >= paramArrayOfInt.length)
    {
      paramArrayOfInt = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
      arrayOfInt = paramArrayOfInt;
      _quadBuffer = paramArrayOfInt;
    }
    int i = paramInt1 + 1;
    arrayOfInt[paramInt1] = paramInt2;
    Name localName = _symbols.findName(arrayOfInt, i);
    paramArrayOfInt = localName;
    if (localName == null) {
      paramArrayOfInt = addName(arrayOfInt, i, paramInt3);
    }
    return paramArrayOfInt;
  }
  
  public static int[] growArrayBy(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[paramInt];
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[paramInt + i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    return arrayOfInt;
  }
  
  private int nextByte()
    throws IOException, JsonParseException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  private JsonToken nextToken(int paramInt)
    throws IOException, JsonParseException
  {
    if (paramInt == 34)
    {
      _tokenIncomplete = true;
      localJsonToken = JsonToken.VALUE_STRING;
      _currToken = localJsonToken;
      return localJsonToken;
    }
    if (paramInt != 45)
    {
      if (paramInt != 91) {
        if (paramInt != 93) {
          if (paramInt != 102) {
            if (paramInt != 110)
            {
              if (paramInt == 116) {
                break label249;
              }
              if (paramInt != 123) {
                if (paramInt == 125) {
                  break label242;
                }
              }
            }
          }
        }
      }
      switch (paramInt)
      {
      default: 
        localJsonToken = _handleUnexpectedValue(paramInt);
        _currToken = localJsonToken;
        return localJsonToken;
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        localJsonToken = JsonToken.START_OBJECT;
        _currToken = localJsonToken;
        return localJsonToken;
        _matchToken("null", 1);
        localJsonToken = JsonToken.VALUE_NULL;
        _currToken = localJsonToken;
        return localJsonToken;
        _matchToken("false", 1);
        localJsonToken = JsonToken.VALUE_FALSE;
        _currToken = localJsonToken;
        return localJsonToken;
        label242:
        _reportUnexpectedChar(paramInt, "expected a value");
        label249:
        _matchToken("true", 1);
        localJsonToken = JsonToken.VALUE_TRUE;
        _currToken = localJsonToken;
        return localJsonToken;
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
        localJsonToken = JsonToken.START_ARRAY;
        _currToken = localJsonToken;
        return localJsonToken;
      }
    }
    JsonToken localJsonToken = parseNumberText(paramInt);
    _currToken = localJsonToken;
    return localJsonToken;
  }
  
  private Name parseFieldName(int paramInt1, int paramInt2, int paramInt3)
    throws IOException, JsonParseException
  {
    return parseEscapedFieldName(_quadBuffer, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private Name parseFieldName(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = _quadBuffer;
    arrayOfInt[0] = paramInt1;
    return parseEscapedFieldName(arrayOfInt, 1, paramInt2, paramInt3, paramInt4);
  }
  
  public void _closeInput()
    throws IOException
  {
    if (_inputStream != null)
    {
      if ((_ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        _inputStream.close();
      }
      _inputStream = null;
    }
  }
  
  public byte[] _decodeBase64(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    Object localObject = _getByteArrayBuilder();
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      int k = arrayOfByte[i] & 0xFF;
      if (k > 32)
      {
        int j = paramBase64Variant.decodeBase64Char(k);
        i = j;
        if (j < 0)
        {
          if (k == 34) {
            return ((ByteArrayBuilder)localObject).toByteArray();
          }
          j = _decodeBase64Escape(paramBase64Variant, k, 0);
          i = j;
          if (j < 0) {}
        }
        else
        {
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          j = _inputPtr;
          _inputPtr = (j + 1);
          int m = arrayOfByte[j] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(m);
          j = k;
          if (k < 0) {
            j = _decodeBase64Escape(paramBase64Variant, m, 1);
          }
          m = i << 6 | j;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          int n = arrayOfByte[i] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(n);
          i = k;
          j = i;
          if (k < 0)
          {
            if (k != -2)
            {
              if ((n == 34) && (!paramBase64Variant.usesPadding()))
              {
                ((ByteArrayBuilder)localObject).append(m >> 4);
                return ((ByteArrayBuilder)localObject).toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, n, 2);
            }
            j = i;
            if (i == -2)
            {
              if (_inputPtr >= _inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfByte = _inputBuffer;
              i = _inputPtr;
              _inputPtr = (i + 1);
              i = arrayOfByte[i] & 0xFF;
              if (paramBase64Variant.usesPaddingChar(i))
              {
                ((ByteArrayBuilder)localObject).append(m >> 4);
                continue;
              }
              localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("expected padding character '");
              ((StringBuilder)localObject).append(paramBase64Variant.getPaddingChar());
              ((StringBuilder)localObject).append("'");
              throw reportInvalidBase64Char(paramBase64Variant, i, 3, ((StringBuilder)localObject).toString());
            }
          }
          m = m << 6 | j;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          n = arrayOfByte[i] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(n);
          i = k;
          j = i;
          if (k < 0)
          {
            if (k != -2)
            {
              if ((n == 34) && (!paramBase64Variant.usesPadding()))
              {
                ((ByteArrayBuilder)localObject).appendTwoBytes(m >> 2);
                return ((ByteArrayBuilder)localObject).toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, n, 3);
            }
            j = i;
            if (i == -2)
            {
              ((ByteArrayBuilder)localObject).appendTwoBytes(m >> 2);
              continue;
            }
          }
          ((ByteArrayBuilder)localObject).appendThreeBytes(m << 6 | j);
        }
      }
    }
  }
  
  public int _decodeCharForError(int paramInt)
    throws IOException, JsonParseException
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      if ((paramInt & 0xE0) == 192) {}
      for (i = paramInt & 0x1F;; i = paramInt)
      {
        paramInt = 1;
        break;
        if ((paramInt & 0xF0) == 224)
        {
          i = paramInt & 0xF;
          paramInt = 2;
          break;
        }
        if ((paramInt & 0xF8) == 240)
        {
          i = paramInt & 0x7;
          paramInt = 3;
          break;
        }
        _reportInvalidInitial(paramInt & 0xFF);
      }
      int j = nextByte();
      if ((j & 0xC0) != 128) {
        _reportInvalidOther(j & 0xFF);
      }
      j = i << 6 | j & 0x3F;
      i = j;
      if (paramInt > 1)
      {
        i = nextByte();
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i & 0xFF);
        }
        j = j << 6 | i & 0x3F;
        i = j;
        if (paramInt > 2)
        {
          paramInt = nextByte();
          if ((paramInt & 0xC0) != 128) {
            _reportInvalidOther(paramInt & 0xFF);
          }
          i = j << 6 | paramInt & 0x3F;
        }
      }
    }
    else
    {
      return i;
    }
    return i;
  }
  
  public char _decodeEscaped()
    throws IOException, JsonParseException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i != 34) && (i != 47) && (i != 92))
    {
      if (i != 98)
      {
        if (i != 102)
        {
          if (i != 110)
          {
            if (i != 114)
            {
              if (i != 116)
              {
                if (i != 117) {
                  return _handleUnrecognizedCharacterEscape((char)_decodeCharForError(i));
                }
                i = 0;
                int j = 0;
                while (i < 4)
                {
                  if ((_inputPtr >= _inputEnd) && (!loadMore())) {
                    _reportInvalidEOF(" in character escape sequence");
                  }
                  arrayOfByte = _inputBuffer;
                  int k = _inputPtr;
                  _inputPtr = (k + 1);
                  k = arrayOfByte[k];
                  int m = Utf8StreamParser.charToHex(k);
                  if (m < 0) {
                    _reportUnexpectedChar(k, "expected a hex-digit for character escape sequence");
                  }
                  j = j << 4 | m;
                  i += 1;
                }
                return (char)j;
              }
              return '\t';
            }
            return '\r';
          }
          return '\n';
        }
        return '\f';
      }
      return '\b';
    }
    return (char)i;
  }
  
  public void _finishString()
    throws IOException, JsonParseException
  {
    int j = _inputPtr;
    int i = j;
    if (j >= _inputEnd)
    {
      loadMoreGuaranteed();
      i = _inputPtr;
    }
    j = 0;
    char[] arrayOfChar = _textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = sInputCodesUtf8;
    int k = Math.min(_inputEnd, arrayOfChar.length + i);
    byte[] arrayOfByte = _inputBuffer;
    while (i < k)
    {
      int m = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[m] != 0)
      {
        if (m != 34) {
          break;
        }
        _inputPtr = (i + 1);
        _textBuffer.setCurrentLength(j);
        return;
      }
      i += 1;
      arrayOfChar[j] = ((char)m);
      j += 1;
    }
    _inputPtr = i;
    _finishString2(arrayOfChar, j);
  }
  
  public JsonToken _handleApostropheValue()
    throws IOException, JsonParseException
  {
    Object localObject2 = _textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = _inputBuffer;
    int i = 0;
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      Object localObject1 = localObject2;
      int k = i;
      if (i >= localObject2.length)
      {
        localObject1 = _textBuffer.finishCurrentSegment();
        k = 0;
      }
      i = _inputEnd;
      int n = _inputPtr + (localObject1.length - k);
      int j = k;
      int m = i;
      if (n < i)
      {
        m = n;
        j = k;
      }
      for (;;)
      {
        k = _inputPtr;
        localObject2 = localObject1;
        i = j;
        if (k >= m) {
          break;
        }
        _inputPtr = (k + 1);
        n = arrayOfByte[k] & 0xFF;
        if ((n == 39) || (arrayOfInt[n] != 0)) {
          break label161;
        }
        localObject1[j] = ((char)n);
        j += 1;
      }
      label161:
      if (n == 39)
      {
        _textBuffer.setCurrentLength(j);
        return JsonToken.VALUE_STRING;
      }
      i = arrayOfInt[n];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (n < 32) {
                _throwUnquotedSpace(n, "string value");
              }
              _reportInvalidChar(n);
              localObject2 = localObject1;
              k = j;
              i = n;
            }
            else
            {
              m = _decodeUtf8_4(n);
              k = j + 1;
              localObject1[j] = ((char)(0xD800 | m >> 10));
              localObject2 = localObject1;
              i = k;
              if (k >= localObject1.length)
              {
                localObject2 = _textBuffer.finishCurrentSegment();
                i = 0;
              }
              j = 0xDC00 | m & 0x3FF;
              k = i;
              i = j;
            }
          }
          else if (_inputEnd - _inputPtr >= 2)
          {
            i = _decodeUtf8_3fast(n);
            localObject2 = localObject1;
            k = j;
          }
          else
          {
            i = _decodeUtf8_3(n);
            localObject2 = localObject1;
            k = j;
          }
        }
        else
        {
          i = _decodeUtf8_2(n);
          localObject2 = localObject1;
          k = j;
        }
      }
      else
      {
        localObject2 = localObject1;
        k = j;
        i = n;
        if (n != 34)
        {
          i = _decodeEscaped();
          k = j;
          localObject2 = localObject1;
        }
      }
      localObject1 = localObject2;
      j = k;
      if (k >= localObject2.length)
      {
        localObject1 = _textBuffer.finishCurrentSegment();
        j = 0;
      }
      localObject1[j] = ((char)i);
      i = j + 1;
      localObject2 = localObject1;
    }
  }
  
  public JsonToken _handleInvalidNumberStart(int paramInt, boolean paramBoolean)
    throws IOException, JsonParseException
  {
    int i = paramInt;
    if (paramInt == 73)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOFInValue();
      }
      Object localObject = _inputBuffer;
      paramInt = _inputPtr;
      _inputPtr = (paramInt + 1);
      paramInt = localObject[paramInt];
      double d = Double.NEGATIVE_INFINITY;
      StringBuilder localStringBuilder;
      if (paramInt == 78)
      {
        if (paramBoolean) {
          localObject = "-INF";
        } else {
          localObject = "+INF";
        }
        _matchToken((String)localObject, 3);
        if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
        {
          if (!paramBoolean) {
            d = Double.POSITIVE_INFINITY;
          }
          return resetAsNaN((String)localObject, d);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Non-standard token '");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        _reportError(localStringBuilder.toString());
        i = paramInt;
      }
      else
      {
        i = paramInt;
        if (paramInt == 110)
        {
          if (paramBoolean) {
            localObject = "-Infinity";
          } else {
            localObject = "+Infinity";
          }
          _matchToken((String)localObject, 3);
          if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
          {
            if (!paramBoolean) {
              d = Double.POSITIVE_INFINITY;
            }
            return resetAsNaN((String)localObject, d);
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Non-standard token '");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
          _reportError(localStringBuilder.toString());
          i = paramInt;
        }
      }
    }
    reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
    return null;
  }
  
  public JsonToken _handleUnexpectedValue(int paramInt)
    throws IOException, JsonParseException
  {
    if (paramInt != 39)
    {
      if (paramInt != 43)
      {
        if (paramInt == 78)
        {
          _matchToken("NaN", 1);
          if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            return resetAsNaN("NaN", NaN.0D);
          }
          _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
      }
      else
      {
        if ((_inputPtr >= _inputEnd) && (!loadMore())) {
          _reportInvalidEOFInValue();
        }
        byte[] arrayOfByte = _inputBuffer;
        paramInt = _inputPtr;
        _inputPtr = (paramInt + 1);
        return _handleInvalidNumberStart(arrayOfByte[paramInt] & 0xFF, false);
      }
    }
    else if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
      return _handleApostropheValue();
    }
    _reportUnexpectedChar(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
    return null;
  }
  
  public Name _handleUnusualFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return _parseApostropheFieldName();
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
      _reportUnexpectedChar(paramInt, "was expecting double-quote to start field name");
    }
    int[] arrayOfInt = Utf8StreamParser.ALLOW_SINGLE_QUOTES;
    if (arrayOfInt[paramInt] != 0) {
      _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    }
    Object localObject1 = _quadBuffer;
    int k = 0;
    int i = paramInt;
    paramInt = 0;
    int j = 0;
    for (;;)
    {
      if (k < 4)
      {
        k += 1;
        j = j << 8 | i;
        i = k;
      }
      else
      {
        localObject2 = localObject1;
        if (paramInt >= localObject1.length)
        {
          localObject1 = growArrayBy((int[])localObject1, localObject1.length);
          localObject2 = localObject1;
          _quadBuffer = ((int[])localObject1);
        }
        localObject2[paramInt] = j;
        paramInt += 1;
        j = i;
        i = 1;
        localObject1 = localObject2;
      }
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      Object localObject2 = _inputBuffer;
      k = _inputPtr;
      int m = localObject2[k] & 0xFF;
      if (arrayOfInt[m] != 0)
      {
        localObject2 = localObject1;
        k = paramInt;
        if (i > 0)
        {
          localObject2 = localObject1;
          if (paramInt >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            _quadBuffer = ((int[])localObject2);
          }
          localObject2[paramInt] = j;
          k = paramInt + 1;
        }
        localObject1 = _symbols.findName((int[])localObject2, k);
        if (localObject1 != null) {
          break;
        }
        return addName((int[])localObject2, k, i);
      }
      _inputPtr = (k + 1);
      k = i;
      i = m;
    }
    return localObject1;
  }
  
  public boolean _loadToHaveAtLeast(int paramInt)
    throws IOException
  {
    if (_inputStream == null) {
      return false;
    }
    int i = _inputEnd;
    int j = _inputPtr;
    i -= j;
    Object localObject;
    if ((i > 0) && (j > 0))
    {
      _currInputProcessed += j;
      _currInputRowStart -= j;
      localObject = _inputBuffer;
      System.arraycopy(localObject, j, localObject, 0, i);
      _inputEnd = i;
    }
    else
    {
      _inputEnd = 0;
    }
    _inputPtr = 0;
    for (;;)
    {
      j = _inputEnd;
      if (j >= paramInt) {
        break;
      }
      localObject = _inputStream;
      byte[] arrayOfByte = _inputBuffer;
      j = ((InputStream)localObject).read(arrayOfByte, j, arrayOfByte.length - j);
      if (j < 1)
      {
        _closeInput();
        if (j != 0) {
          return false;
        }
        throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("InputStream.read() returned 0 characters when trying to read ", i, " bytes"));
      }
      _inputEnd += j;
    }
    return true;
  }
  
  public void _matchToken(String paramString, int paramInt)
    throws IOException, JsonParseException
  {
    int j = paramString.length();
    int i;
    do
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in a value");
      }
      if (_inputBuffer[_inputPtr] != paramString.charAt(paramInt)) {
        _reportInvalidToken(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      }
      _inputPtr += 1;
      i = paramInt + 1;
      paramInt = i;
    } while (i < j);
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      return;
    }
    paramInt = _inputBuffer[_inputPtr] & 0xFF;
    if ((paramInt >= 48) && (paramInt != 93))
    {
      if (paramInt == 125) {
        return;
      }
      if (Character.isJavaIdentifierPart((char)_decodeCharForError(paramInt)))
      {
        _inputPtr += 1;
        _reportInvalidToken(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
      }
    }
  }
  
  public Name _parseApostropheFieldName()
    throws IOException, JsonParseException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing ''' for name");
    }
    Object localObject1 = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    int m = localObject1[i] & 0xFF;
    if (m == 39) {
      return Name1.getEmptyName();
    }
    int[] arrayOfInt = sInputCodesLatin1;
    localObject1 = _quadBuffer;
    int j = 0;
    i = 0;
    int k = 0;
    Object localObject2;
    for (;;)
    {
      if (m == 39)
      {
        if (j > 0)
        {
          localObject2 = localObject1;
          if (i >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            _quadBuffer = ((int[])localObject2);
          }
          m = i + 1;
          localObject2[i] = k;
          i = m;
          localObject1 = localObject2;
        }
        localObject2 = _symbols.findName((int[])localObject1, i);
        if (localObject2 != null) {
          break;
        }
        return addName((int[])localObject1, i, j);
      }
      int i2 = i;
      int n = m;
      localObject2 = localObject1;
      int i4 = j;
      int i3 = k;
      if (m != 34)
      {
        i2 = i;
        n = m;
        localObject2 = localObject1;
        i4 = j;
        i3 = k;
        if (arrayOfInt[m] != 0)
        {
          int i1;
          if (m != 92)
          {
            _throwUnquotedSpace(m, "name");
            i1 = m;
          }
          else
          {
            i1 = _decodeEscaped();
          }
          i2 = i;
          n = i1;
          localObject2 = localObject1;
          i4 = j;
          i3 = k;
          if (i1 > 127)
          {
            m = i;
            localObject2 = localObject1;
            n = j;
            i2 = k;
            if (j >= 4)
            {
              localObject2 = localObject1;
              if (i >= localObject1.length)
              {
                localObject2 = growArrayBy((int[])localObject1, localObject1.length);
                _quadBuffer = ((int[])localObject2);
              }
              localObject2[i] = k;
              m = i + 1;
              n = 0;
              i2 = 0;
            }
            if (i1 < 2048)
            {
              k = i2 << 8 | i1 >> 6 | 0xC0;
              j = n + 1;
              i = m;
              localObject1 = localObject2;
            }
            else
            {
              i2 = i2 << 8 | i1 >> 12 | 0xE0;
              n += 1;
              i = m;
              localObject1 = localObject2;
              j = n;
              k = i2;
              if (n >= 4)
              {
                localObject1 = localObject2;
                if (m >= localObject2.length)
                {
                  localObject1 = growArrayBy((int[])localObject2, localObject2.length);
                  _quadBuffer = ((int[])localObject1);
                }
                localObject1[m] = i2;
                i = m + 1;
                j = 0;
                k = 0;
              }
              k = k << 8 | i1 >> 6 & 0x3F | 0x80;
              j += 1;
            }
            n = i1 & 0x3F | 0x80;
            i3 = k;
            i4 = j;
            localObject2 = localObject1;
            i2 = i;
          }
        }
      }
      if (i4 < 4)
      {
        j = i4 + 1;
        k = n | i3 << 8;
        i = i2;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject2;
        if (i2 >= localObject2.length)
        {
          localObject2 = growArrayBy((int[])localObject2, localObject2.length);
          localObject1 = localObject2;
          _quadBuffer = ((int[])localObject2);
        }
        localObject1[i2] = i3;
        k = n;
        i = i2 + 1;
        j = 1;
      }
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      localObject2 = _inputBuffer;
      m = _inputPtr;
      _inputPtr = (m + 1);
      m = localObject2[m] & 0xFF;
    }
    return localObject2;
  }
  
  public Name _parseFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    if (paramInt != 34) {
      return _handleUnusualFieldName(paramInt);
    }
    paramInt = _inputPtr;
    if (paramInt + 9 > _inputEnd) {
      return slowParseFieldName();
    }
    byte[] arrayOfByte = _inputBuffer;
    int[] arrayOfInt = sInputCodesLatin1;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt] & 0xFF;
    if (arrayOfInt[paramInt] == 0)
    {
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[i] == 0)
      {
        paramInt = paramInt << 8 | i;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (arrayOfInt[i] == 0)
        {
          paramInt = paramInt << 8 | i;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i = arrayOfByte[i] & 0xFF;
          if (arrayOfInt[i] == 0)
          {
            paramInt = paramInt << 8 | i;
            i = _inputPtr;
            _inputPtr = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            if (arrayOfInt[i] == 0)
            {
              _quad1 = paramInt;
              return parseMediumFieldName(i, arrayOfInt);
            }
            if (i == 34) {
              return findName(paramInt, 4);
            }
            return parseFieldName(paramInt, i, 4);
          }
          if (i == 34) {
            return findName(paramInt, 3);
          }
          return parseFieldName(paramInt, i, 3);
        }
        if (i == 34) {
          return findName(paramInt, 2);
        }
        return parseFieldName(paramInt, i, 2);
      }
      if (i == 34) {
        return findName(paramInt, 1);
      }
      return parseFieldName(paramInt, i, 1);
    }
    if (paramInt == 34) {
      return Name1.getEmptyName();
    }
    return parseFieldName(0, paramInt, 0);
  }
  
  public int _readBinary(Base64Variant paramBase64Variant, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException, JsonParseException
  {
    int i1 = paramArrayOfByte.length;
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      byte[] arrayOfByte = _inputBuffer;
      j = _inputPtr;
      _inputPtr = (j + 1);
      int m = arrayOfByte[j] & 0xFF;
      if (m > 32)
      {
        j = paramBase64Variant.decodeBase64Char(m);
        int n = j;
        int i2;
        int i3;
        if (j < 0)
        {
          if (m == 34)
          {
            j = k;
          }
          else
          {
            j = _decodeBase64Escape(paramBase64Variant, m, 0);
            n = j;
            if (j < 0) {
              continue;
            }
          }
        }
        else
        {
          j = k;
          m = i;
          if (i > i1 - 3)
          {
            j = k + i;
            paramOutputStream.write(paramArrayOfByte, 0, i);
            m = 0;
          }
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i2 = arrayOfByte[i] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(i2);
          i = k;
          if (k < 0) {
            i = _decodeBase64Escape(paramBase64Variant, i2, 1);
          }
          i2 = n << 6 | i;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i3 = arrayOfByte[i] & 0xFF;
          n = paramBase64Variant.decodeBase64Char(i3);
          i = n;
          k = i;
          if (n < 0)
          {
            if (n != -2)
            {
              if ((i3 == 34) && (!paramBase64Variant.usesPadding()))
              {
                paramArrayOfByte[m] = ((byte)(i2 >> 4));
                i = m + 1;
                break label604;
              }
              i = _decodeBase64Escape(paramBase64Variant, i3, 2);
            }
            k = i;
            if (i == -2)
            {
              if (_inputPtr >= _inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfByte = _inputBuffer;
              i = _inputPtr;
              _inputPtr = (i + 1);
              i = arrayOfByte[i] & 0xFF;
              if (paramBase64Variant.usesPaddingChar(i))
              {
                i = m + 1;
                paramArrayOfByte[m] = ((byte)(i2 >> 4));
                break label746;
              }
              paramOutputStream = f.sufficientlysecure.rootcommands.util.StringBuilder.append("expected padding character '");
              paramOutputStream.append(paramBase64Variant.getPaddingChar());
              paramOutputStream.append("'");
              throw reportInvalidBase64Char(paramBase64Variant, i, 3, paramOutputStream.toString());
            }
          }
          i2 = i2 << 6 | k;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i3 = arrayOfByte[i] & 0xFF;
          n = paramBase64Variant.decodeBase64Char(i3);
          i = n;
          k = i;
          if (n >= 0) {
            break label691;
          }
          if (n == -2) {
            break label638;
          }
          if ((i3 != 34) || (paramBase64Variant.usesPadding())) {
            break label628;
          }
          k = i2 >> 2;
          n = m + 1;
          paramArrayOfByte[m] = ((byte)(k >> 8));
          i = n + 1;
          paramArrayOfByte[n] = ((byte)k);
        }
        label604:
        _tokenIncomplete = false;
        if (i <= 0) {
          break;
        }
        paramOutputStream.write(paramArrayOfByte, 0, i);
        return j + i;
        label628:
        i = _decodeBase64Escape(paramBase64Variant, i3, 3);
        label638:
        k = i;
        if (i == -2)
        {
          k = i2 >> 2;
          n = m + 1;
          paramArrayOfByte[m] = ((byte)(k >> 8));
          i = n + 1;
          paramArrayOfByte[n] = ((byte)k);
          k = j;
        }
        else
        {
          label691:
          k = i2 << 6 | k;
          i = m + 1;
          paramArrayOfByte[m] = ((byte)(k >> 16));
          m = i + 1;
          paramArrayOfByte[i] = ((byte)(k >> 8));
          i = m + 1;
          paramArrayOfByte[m] = ((byte)k);
          label746:
          k = j;
        }
      }
    }
    return j;
  }
  
  public void _releaseBuffers()
    throws IOException
  {
    super._releaseBuffers();
    if (_bufferRecyclable)
    {
      byte[] arrayOfByte = _inputBuffer;
      if (arrayOfByte != null)
      {
        _inputBuffer = null;
        _ioContext.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  public void _reportInvalidChar(int paramInt)
    throws JsonParseException
  {
    if (paramInt < 32) {
      _throwInvalidSpace(paramInt);
    }
    _reportInvalidInitial(paramInt);
  }
  
  public void _reportInvalidInitial(int paramInt)
    throws JsonParseException
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Invalid UTF-8 start byte 0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    _reportError(localStringBuilder.toString());
  }
  
  public void _reportInvalidOther(int paramInt)
    throws JsonParseException
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Invalid UTF-8 middle byte 0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    _reportError(localStringBuilder.toString());
  }
  
  public void _reportInvalidOther(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    _inputPtr = paramInt2;
    _reportInvalidOther(paramInt1);
  }
  
  public void _reportInvalidToken(String paramString1, String paramString2)
    throws IOException, JsonParseException
  {
    paramString1 = new StringBuilder(paramString1);
    for (;;)
    {
      Object localObject;
      char c;
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        localObject = _inputBuffer;
        int i = _inputPtr;
        _inputPtr = (i + 1);
        c = (char)_decodeCharForError(localObject[i]);
        if (Character.isJavaIdentifierPart(c)) {}
      }
      else
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unrecognized token '");
        ((StringBuilder)localObject).append(paramString1.toString());
        ((StringBuilder)localObject).append("': was expecting ");
        ((StringBuilder)localObject).append(paramString2);
        _reportError(((StringBuilder)localObject).toString());
        return;
      }
      paramString1.append(c);
    }
  }
  
  public void _skipCR()
    throws IOException
  {
    if ((_inputPtr < _inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      if (arrayOfByte[i] == 10) {
        _inputPtr = (i + 1);
      }
    }
    _currInputRow += 1;
    _currInputRowStart = _inputPtr;
  }
  
  public void _skipLF()
    throws IOException
  {
    _currInputRow += 1;
    _currInputRowStart = _inputPtr;
  }
  
  public void _skipString()
    throws IOException, JsonParseException
  {
    _tokenIncomplete = false;
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = _inputBuffer;
    for (;;)
    {
      int k = _inputPtr;
      int m = _inputEnd;
      int i = k;
      int j = m;
      if (k >= m)
      {
        loadMoreGuaranteed();
        i = _inputPtr;
        j = _inputEnd;
      }
      for (;;)
      {
        if (i >= j) {
          break label175;
        }
        k = i + 1;
        i = arrayOfByte[i] & 0xFF;
        if (arrayOfInt[i] != 0)
        {
          _inputPtr = k;
          if (i == 34) {
            return;
          }
          j = arrayOfInt[i];
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3)
              {
                if (j != 4)
                {
                  if (i < 32)
                  {
                    _throwUnquotedSpace(i, "string value");
                    break;
                  }
                  _reportInvalidChar(i);
                  break;
                }
                _skipUtf8_2(i);
                break;
              }
              _skipUtf8_3(i);
              break;
            }
            _skipUtf8_4(i);
            break;
          }
          _decodeEscaped();
          break;
        }
        i = k;
      }
      label175:
      _inputPtr = i;
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    _symbols.release();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    Object localObject = _currToken;
    if ((localObject != JsonToken.VALUE_STRING) && ((localObject != JsonToken.VALUE_EMBEDDED_OBJECT) || (_binaryValue == null)))
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Current token (");
      ((StringBuilder)localObject).append(_currToken);
      ((StringBuilder)localObject).append(") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
      _reportError(((StringBuilder)localObject).toString());
    }
    if (_tokenIncomplete)
    {
      try
      {
        localObject = _decodeBase64(paramBase64Variant);
        _binaryValue = ((byte[])localObject);
        _tokenIncomplete = false;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        paramBase64Variant = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to decode VALUE_STRING as base64 (", paramBase64Variant, "): ");
        paramBase64Variant.append(localIllegalArgumentException.getMessage());
        throw _constructError(paramBase64Variant.toString());
      }
    }
    else if (_binaryValue == null)
    {
      ByteArrayBuilder localByteArrayBuilder = _getByteArrayBuilder();
      _decodeBase64(getText(), localByteArrayBuilder, paramBase64Variant);
      _binaryValue = localByteArrayBuilder.toByteArray();
    }
    return _binaryValue;
  }
  
  public ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public Object getEmbeddedObject()
    throws IOException, JsonParseException
  {
    return null;
  }
  
  public Object getInputSource()
  {
    return _inputStream;
  }
  
  public String getText()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      return _textBuffer.contentsAsString();
    }
    return getText(localJsonToken);
  }
  
  public String getText(JsonToken paramJsonToken)
  {
    if (paramJsonToken == null) {
      return null;
    }
    int i = paramJsonToken.ordinal();
    if (i != 5)
    {
      if ((i != 7) && (i != 8) && (i != 9)) {
        return paramJsonToken.asString();
      }
      return _textBuffer.contentsAsString();
    }
    return _parsingContext.getCurrentName();
  }
  
  public char[] getTextCharacters()
    throws IOException, JsonParseException
  {
    Object localObject = _currToken;
    if (localObject != null)
    {
      int i = ((Enum)localObject).ordinal();
      if (i != 5)
      {
        if (i != 7)
        {
          if ((i != 8) && (i != 9)) {
            return _currToken.asCharArray();
          }
        }
        else if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
        return _textBuffer.getTextBuffer();
      }
      if (!_nameCopied)
      {
        localObject = _parsingContext.getCurrentName();
        i = ((String)localObject).length();
        char[] arrayOfChar = _nameCopyBuffer;
        if (arrayOfChar == null) {
          _nameCopyBuffer = _ioContext.allocNameCopyBuffer(i);
        } else if (arrayOfChar.length < i) {
          _nameCopyBuffer = new char[i];
        }
        ((String)localObject).getChars(0, i, _nameCopyBuffer, 0);
        _nameCopied = true;
      }
      return _nameCopyBuffer;
    }
    return null;
  }
  
  public int getTextLength()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken != null)
    {
      int i = localJsonToken.ordinal();
      if (i != 5)
      {
        if (i != 7)
        {
          if ((i != 8) && (i != 9)) {
            return _currToken.asCharArray().length;
          }
        }
        else if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
        return _textBuffer.size();
      }
      return _parsingContext.getCurrentName().length();
    }
    return 0;
  }
  
  public int getTextOffset()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken != null)
    {
      int i = localJsonToken.ordinal();
      if (i != 5)
      {
        if (i != 7)
        {
          if ((i != 8) && (i != 9)) {
            return 0;
          }
        }
        else if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
        return _textBuffer.getTextOffset();
      }
    }
    return 0;
  }
  
  public String getValueAsString()
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      return _textBuffer.contentsAsString();
    }
    return super.getValueAsString(null);
  }
  
  public String getValueAsString(String paramString)
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      return _textBuffer.contentsAsString();
    }
    return super.getValueAsString(paramString);
  }
  
  public boolean loadMore()
    throws IOException
  {
    long l = _currInputProcessed;
    int i = _inputEnd;
    _currInputProcessed = (l + i);
    _currInputRowStart -= i;
    InputStream localInputStream = _inputStream;
    if (localInputStream != null)
    {
      byte[] arrayOfByte = _inputBuffer;
      i = localInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i > 0)
      {
        _inputPtr = 0;
        _inputEnd = i;
        return true;
      }
      _closeInput();
      if (i != 0) {
        return false;
      }
      throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("InputStream.read() returned 0 characters when trying to read "), _inputBuffer.length, " bytes"));
    }
    return false;
  }
  
  public Boolean nextBooleanValue()
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      JsonToken localJsonToken = _nextToken;
      _nextToken = null;
      _currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_TRUE) {
        return Boolean.TRUE;
      }
      if (localJsonToken == JsonToken.VALUE_FALSE) {
        return Boolean.FALSE;
      }
      if (localJsonToken == JsonToken.START_ARRAY)
      {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
        return null;
      }
      if (localJsonToken == JsonToken.START_OBJECT)
      {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        return null;
      }
    }
    else
    {
      int i = nextToken().ordinal();
      if (i != 10)
      {
        if (i != 11) {
          return null;
        }
        return Boolean.FALSE;
      }
      return Boolean.TRUE;
    }
    return null;
  }
  
  public boolean nextFieldName(SerializableString paramSerializableString)
    throws IOException, JsonParseException
  {
    int j = 0;
    _numTypesValid = 0;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nextAfterName();
      return false;
    }
    if (_tokenIncomplete) {
      _skipString();
    }
    int k = _skipWSOrEnd();
    int i = k;
    if (k < 0)
    {
      close();
      _currToken = null;
      return false;
    }
    long l = _currInputProcessed;
    int m = _inputPtr;
    _tokenInputTotal = (l + m - 1L);
    _tokenInputRow = _currInputRow;
    _tokenInputCol = (m - _currInputRowStart - 1);
    _binaryValue = null;
    if (k == 93)
    {
      if (!_parsingContext.inArray()) {
        _reportMismatchedEndMarker(k, '}');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_ARRAY;
      return false;
    }
    if (k == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(k, ']');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_OBJECT;
      return false;
    }
    Object localObject;
    if (_parsingContext.expectComma())
    {
      if (k != 44)
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("was expecting comma to separate ");
        ((StringBuilder)localObject).append(_parsingContext.getTypeDesc());
        ((StringBuilder)localObject).append(" entries");
        _reportUnexpectedChar(k, ((StringBuilder)localObject).toString());
      }
      i = _skipWS();
    }
    if (!_parsingContext.inObject())
    {
      nextToken(i);
      return false;
    }
    if (i == 34)
    {
      localObject = paramSerializableString.asQuotedUTF8();
      k = localObject.length;
      m = _inputPtr;
      if (m + k < _inputEnd)
      {
        int n = m + k;
        if (_inputBuffer[n] == 34) {
          for (;;)
          {
            if (j == k)
            {
              _inputPtr = (n + 1);
              _parsingContext.setCurrentName(paramSerializableString.getValue());
              _currToken = JsonToken.FIELD_NAME;
              _isNextTokenNameYes();
              return true;
            }
            if (localObject[j] != _inputBuffer[(m + j)]) {
              break;
            }
            j += 1;
          }
        }
      }
    }
    return _isNextTokenNameMaybe(i, paramSerializableString);
  }
  
  public int nextIntValue(int paramInt)
    throws IOException, JsonParseException
  {
    int i;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      JsonToken localJsonToken = _nextToken;
      _nextToken = null;
      _currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        return getIntValue();
      }
      if (localJsonToken == JsonToken.START_ARRAY)
      {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
        return paramInt;
      }
      i = paramInt;
      if (localJsonToken == JsonToken.START_OBJECT)
      {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        return paramInt;
      }
    }
    else
    {
      i = paramInt;
      if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
        i = getIntValue();
      }
    }
    return i;
  }
  
  public long nextLongValue(long paramLong)
    throws IOException, JsonParseException
  {
    long l;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      JsonToken localJsonToken = _nextToken;
      _nextToken = null;
      _currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        return getLongValue();
      }
      if (localJsonToken == JsonToken.START_ARRAY)
      {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
        return paramLong;
      }
      l = paramLong;
      if (localJsonToken == JsonToken.START_OBJECT)
      {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        return paramLong;
      }
    }
    else
    {
      l = paramLong;
      if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
        l = getLongValue();
      }
    }
    return l;
  }
  
  public String nextTextValue()
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      JsonToken localJsonToken = _nextToken;
      _nextToken = null;
      _currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_STRING)
      {
        if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
        return _textBuffer.contentsAsString();
      }
      if (localJsonToken == JsonToken.START_ARRAY)
      {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
        return null;
      }
      if (localJsonToken == JsonToken.START_OBJECT)
      {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        return null;
      }
    }
    else if (nextToken() == JsonToken.VALUE_STRING)
    {
      return getText();
    }
    return null;
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    _numTypesValid = 0;
    if (_currToken == JsonToken.FIELD_NAME) {
      return _nextAfterName();
    }
    if (_tokenIncomplete) {
      _skipString();
    }
    int j = _skipWSOrEnd();
    int i = j;
    if (j < 0)
    {
      close();
      _currToken = null;
      return null;
    }
    long l = _currInputProcessed;
    int k = _inputPtr;
    _tokenInputTotal = (l + k - 1L);
    _tokenInputRow = _currInputRow;
    _tokenInputCol = (k - _currInputRowStart - 1);
    _binaryValue = null;
    if (j == 93)
    {
      if (!_parsingContext.inArray()) {
        _reportMismatchedEndMarker(j, '}');
      }
      _parsingContext = _parsingContext.getParent();
      localObject = JsonToken.END_ARRAY;
      _currToken = ((JsonToken)localObject);
      return localObject;
    }
    if (j == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(j, ']');
      }
      _parsingContext = _parsingContext.getParent();
      localObject = JsonToken.END_OBJECT;
      _currToken = ((JsonToken)localObject);
      return localObject;
    }
    if (_parsingContext.expectComma())
    {
      if (j != 44)
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("was expecting comma to separate ");
        ((StringBuilder)localObject).append(_parsingContext.getTypeDesc());
        ((StringBuilder)localObject).append(" entries");
        _reportUnexpectedChar(j, ((StringBuilder)localObject).toString());
      }
      i = _skipWS();
    }
    if (!_parsingContext.inObject()) {
      return nextToken(i);
    }
    Object localObject = _parseFieldName(i);
    _parsingContext.setCurrentName(((Name)localObject).getName());
    _currToken = JsonToken.FIELD_NAME;
    i = _skipWS();
    if (i != 58) {
      _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
    }
    i = _skipWS();
    if (i == 34)
    {
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return _currToken;
    }
    if (i != 45)
    {
      if (i != 91) {
        if (i != 93) {
          if (i != 102) {
            if (i != 110)
            {
              if (i == 116) {
                break label542;
              }
              if (i != 123) {
                if (i == 125) {
                  break label535;
                }
              }
            }
          }
        }
      }
      switch (i)
      {
      default: 
        localObject = _handleUnexpectedValue(i);
        break;
        localObject = JsonToken.START_OBJECT;
        break;
        _matchToken("null", 1);
        localObject = JsonToken.VALUE_NULL;
        break;
        _matchToken("false", 1);
        localObject = JsonToken.VALUE_FALSE;
        break;
        label535:
        _reportUnexpectedChar(i, "expected a value");
        label542:
        _matchToken("true", 1);
        localObject = JsonToken.VALUE_TRUE;
        break;
        localObject = JsonToken.START_ARRAY;
        break;
      }
    }
    else
    {
      localObject = parseNumberText(i);
    }
    _nextToken = ((JsonToken)localObject);
    return _currToken;
  }
  
  public Name parseEscapedFieldName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = sInputCodesLatin1;
    Object localObject;
    for (int i = paramInt3;; i = localObject[paramInt3] & 0xFF)
    {
      localObject = paramArrayOfInt;
      int j = paramInt1;
      int m = paramInt2;
      paramInt3 = i;
      int k = paramInt4;
      if (arrayOfInt[i] != 0)
      {
        if (i == 34)
        {
          localObject = paramArrayOfInt;
          paramInt3 = paramInt1;
          if (paramInt4 > 0)
          {
            localObject = paramArrayOfInt;
            if (paramInt1 >= paramArrayOfInt.length)
            {
              paramArrayOfInt = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
              localObject = paramArrayOfInt;
              _quadBuffer = paramArrayOfInt;
            }
            localObject[paramInt1] = paramInt2;
            paramInt3 = paramInt1 + 1;
          }
          paramArrayOfInt = _symbols.findName((int[])localObject, paramInt3);
          if (paramArrayOfInt != null) {
            break;
          }
          return addName((int[])localObject, paramInt3, paramInt4);
        }
        if (i != 92) {
          _throwUnquotedSpace(i, "name");
        } else {
          i = _decodeEscaped();
        }
        localObject = paramArrayOfInt;
        j = paramInt1;
        m = paramInt2;
        paramInt3 = i;
        k = paramInt4;
        if (i > 127)
        {
          localObject = paramArrayOfInt;
          paramInt3 = paramInt1;
          k = paramInt2;
          j = paramInt4;
          if (paramInt4 >= 4)
          {
            localObject = paramArrayOfInt;
            if (paramInt1 >= paramArrayOfInt.length)
            {
              paramArrayOfInt = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
              localObject = paramArrayOfInt;
              _quadBuffer = paramArrayOfInt;
            }
            localObject[paramInt1] = paramInt2;
            paramInt3 = paramInt1 + 1;
            k = 0;
            j = 0;
          }
          if (i < 2048)
          {
            paramInt2 = k << 8 | i >> 6 | 0xC0;
            paramInt4 = j + 1;
            paramArrayOfInt = (int[])localObject;
            paramInt1 = paramInt3;
            paramInt3 = paramInt4;
          }
          else
          {
            k = k << 8 | i >> 12 | 0xE0;
            j += 1;
            paramArrayOfInt = (int[])localObject;
            paramInt1 = paramInt3;
            paramInt4 = k;
            paramInt2 = j;
            if (j >= 4)
            {
              paramArrayOfInt = (int[])localObject;
              if (paramInt3 >= localObject.length)
              {
                localObject = growArrayBy((int[])localObject, localObject.length);
                paramArrayOfInt = (int[])localObject;
                _quadBuffer = ((int[])localObject);
              }
              paramArrayOfInt[paramInt3] = k;
              paramInt1 = paramInt3 + 1;
              paramInt4 = 0;
              paramInt2 = 0;
            }
            paramInt4 = paramInt4 << 8 | i >> 6 & 0x3F | 0x80;
            paramInt3 = paramInt2 + 1;
            paramInt2 = paramInt4;
          }
          paramInt4 = i & 0x3F | 0x80;
          k = paramInt3;
          paramInt3 = paramInt4;
          m = paramInt2;
          j = paramInt1;
          localObject = paramArrayOfInt;
        }
      }
      if (k < 4)
      {
        paramInt4 = k + 1;
        paramInt2 = m << 8 | paramInt3;
        paramArrayOfInt = (int[])localObject;
        paramInt1 = j;
      }
      else
      {
        paramArrayOfInt = (int[])localObject;
        if (j >= localObject.length)
        {
          localObject = growArrayBy((int[])localObject, localObject.length);
          paramArrayOfInt = (int[])localObject;
          _quadBuffer = ((int[])localObject);
        }
        paramArrayOfInt[j] = m;
        paramInt2 = paramInt3;
        paramInt1 = j + 1;
        paramInt4 = 1;
      }
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      localObject = _inputBuffer;
      paramInt3 = _inputPtr;
      _inputPtr = (paramInt3 + 1);
    }
    return paramArrayOfInt;
  }
  
  public Name parseLongFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = sInputCodesLatin1;
    int j = 2;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      j = _inputEnd;
      int k = _inputPtr;
      if (j - k < 4) {
        return parseEscapedFieldName(_quadBuffer, paramInt, 0, i, 0);
      }
      Object localObject = _inputBuffer;
      _inputPtr = (k + 1);
      j = localObject[k] & 0xFF;
      if (arrayOfInt[j] != 0)
      {
        if (j == 34) {
          return findName(_quadBuffer, paramInt, i, 1);
        }
        return parseEscapedFieldName(_quadBuffer, paramInt, i, j, 1);
      }
      i = i << 8 | j;
      j = _inputPtr;
      _inputPtr = (j + 1);
      j = localObject[j] & 0xFF;
      if (arrayOfInt[j] != 0)
      {
        if (j == 34) {
          return findName(_quadBuffer, paramInt, i, 2);
        }
        return parseEscapedFieldName(_quadBuffer, paramInt, i, j, 2);
      }
      i = i << 8 | j;
      j = _inputPtr;
      _inputPtr = (j + 1);
      j = localObject[j] & 0xFF;
      if (arrayOfInt[j] != 0)
      {
        if (j == 34) {
          return findName(_quadBuffer, paramInt, i, 3);
        }
        return parseEscapedFieldName(_quadBuffer, paramInt, i, j, 3);
      }
      j = i << 8 | j;
      i = _inputPtr;
      _inputPtr = (i + 1);
      i = localObject[i] & 0xFF;
      if (arrayOfInt[i] != 0)
      {
        if (i == 34) {
          return findName(_quadBuffer, paramInt, j, 4);
        }
        return parseEscapedFieldName(_quadBuffer, paramInt, j, i, 4);
      }
      localObject = _quadBuffer;
      if (paramInt >= localObject.length) {
        _quadBuffer = growArrayBy((int[])localObject, paramInt);
      }
      _quadBuffer[paramInt] = j;
      paramInt += 1;
    }
  }
  
  public Name parseMediumFieldName(int paramInt, int[] paramArrayOfInt)
    throws IOException, JsonParseException
  {
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt, 1);
      }
      return parseFieldName(_quad1, paramInt, i, 1);
    }
    paramInt = paramInt << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt, 2);
      }
      return parseFieldName(_quad1, paramInt, i, 2);
    }
    paramInt = paramInt << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt, 3);
      }
      return parseFieldName(_quad1, paramInt, i, 3);
    }
    paramInt = paramInt << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt, 4);
      }
      return parseFieldName(_quad1, paramInt, i, 4);
    }
    paramArrayOfInt = _quadBuffer;
    paramArrayOfInt[0] = _quad1;
    paramArrayOfInt[1] = paramInt;
    return parseLongFieldName(i);
  }
  
  public JsonToken parseNumberText(int paramInt)
    throws IOException, JsonParseException
  {
    char[] arrayOfChar = _textBuffer.emptyAndGetCurrentSegment();
    int i = 0;
    boolean bool;
    if (paramInt == 45) {
      bool = true;
    } else {
      bool = false;
    }
    byte[] arrayOfByte;
    if (bool)
    {
      arrayOfChar[0] = '-';
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      arrayOfByte = _inputBuffer;
      paramInt = _inputPtr;
      _inputPtr = (paramInt + 1);
      paramInt = arrayOfByte[paramInt] & 0xFF;
      if ((paramInt >= 48) && (paramInt <= 57)) {
        i = 1;
      } else {
        return _handleInvalidNumberStart(paramInt, true);
      }
    }
    int j = paramInt;
    if (paramInt == 48) {
      j = _verifyNoLeadingZeroes();
    }
    int k = i + 1;
    arrayOfChar[i] = ((char)j);
    i = _inputPtr + arrayOfChar.length;
    j = _inputEnd;
    paramInt = i;
    if (i > j) {
      paramInt = j;
    }
    j = 1;
    i = k;
    for (;;)
    {
      k = _inputPtr;
      if (k >= paramInt) {
        return _parserNumber2(arrayOfChar, i, bool, j);
      }
      arrayOfByte = _inputBuffer;
      _inputPtr = (k + 1);
      k = arrayOfByte[k] & 0xFF;
      if ((k < 48) || (k > 57)) {
        break;
      }
      j += 1;
      arrayOfChar[i] = ((char)k);
      i += 1;
    }
    if ((k != 46) && (k != 101) && (k != 69))
    {
      _inputPtr -= 1;
      _textBuffer.setCurrentLength(i);
      return resetInt(bool, j);
    }
    return _parseFloatText(arrayOfChar, i, k, bool, j);
  }
  
  public int readBinaryValue(Base64Variant paramBase64Variant, OutputStream paramOutputStream)
    throws IOException, JsonParseException
  {
    if ((_tokenIncomplete) && (_currToken == JsonToken.VALUE_STRING))
    {
      byte[] arrayOfByte = _ioContext.allocBase64Buffer();
      try
      {
        int i = _readBinary(paramBase64Variant, paramOutputStream, arrayOfByte);
        _ioContext.releaseBase64Buffer(arrayOfByte);
        return i;
      }
      catch (Throwable paramBase64Variant)
      {
        _ioContext.releaseBase64Buffer(arrayOfByte);
        throw paramBase64Variant;
      }
    }
    paramBase64Variant = getBinaryValue(paramBase64Variant);
    paramOutputStream.write(paramBase64Variant);
    return paramBase64Variant.length;
  }
  
  public int releaseBuffered(OutputStream paramOutputStream)
    throws IOException
  {
    int j = _inputEnd;
    int i = _inputPtr;
    j -= i;
    if (j < 1) {
      return 0;
    }
    paramOutputStream.write(_inputBuffer, i, j);
    return j;
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    _objectCodec = paramObjectCodec;
  }
  
  public Name slowParseFieldName()
    throws IOException, JsonParseException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing '\"' for name");
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (i == 34) {
      return Name1.getEmptyName();
    }
    return parseEscapedFieldName(_quadBuffer, 0, 0, i, 0);
  }
  
  public Version version()
  {
    return CoreVersion.instance.version();
  }
}
