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
import f.fasterxml.jackson.core.Version;
import f.fasterxml.jackson.core.impl.IOContext;
import f.fasterxml.jackson.core.impl.Utf8StreamParser;
import f.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import f.fasterxml.jackson.core.util.ByteArrayBuilder;
import f.fasterxml.jackson.core.util.TextBuffer;
import f.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public final class ReaderBasedJsonParser
  extends ParserBase
{
  public final int _hashSeed;
  public char[] _inputBuffer;
  public ObjectCodec _objectCodec;
  public Reader _reader;
  public final CharsToNameCanonicalizer _symbols;
  public boolean _tokenIncomplete = false;
  
  public ReaderBasedJsonParser(IOContext paramIOContext, int paramInt, Reader paramReader, ObjectCodec paramObjectCodec, CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    super(paramIOContext, paramInt);
    _reader = paramReader;
    _inputBuffer = paramIOContext.allocTokenBuffer();
    _objectCodec = paramObjectCodec;
    _symbols = paramCharsToNameCanonicalizer;
    _hashSeed = paramCharsToNameCanonicalizer.hashSeed();
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
  
  private String _parseFieldName2(int paramInt1, int paramInt2, int paramInt3)
    throws IOException, JsonParseException
  {
    _textBuffer.resetWithShared(_inputBuffer, paramInt1, _inputPtr - paramInt1);
    Object localObject1 = _textBuffer.getCurrentSegment();
    paramInt1 = _textBuffer.getCurrentSegmentSize();
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore()))
      {
        localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(": was expecting closing '");
        ((StringBuilder)localObject2).append((char)paramInt3);
        ((StringBuilder)localObject2).append("' for name");
        _reportInvalidEOF(((StringBuilder)localObject2).toString());
      }
      Object localObject2 = _inputBuffer;
      int k = _inputPtr;
      _inputPtr = (k + 1);
      int j = localObject2[k];
      if (j <= 92)
      {
        if (j == 92)
        {
          i = _decodeEscaped();
          break label212;
        }
        if (j <= paramInt3)
        {
          if (j == paramInt3)
          {
            _textBuffer.setCurrentLength(paramInt1);
            localObject1 = _textBuffer;
            localObject2 = ((TextBuffer)localObject1).getTextBuffer();
            paramInt1 = ((TextBuffer)localObject1).getTextOffset();
            paramInt3 = ((TextBuffer)localObject1).size();
            return _symbols.findSymbol((char[])localObject2, paramInt1, paramInt3, paramInt2);
          }
          if (j < 32) {
            _throwUnquotedSpace(j, "name");
          }
        }
      }
      int i = j;
      label212:
      paramInt2 = paramInt2 * 33 + j;
      k = paramInt1 + 1;
      localObject1[paramInt1] = i;
      if (k >= localObject1.length)
      {
        localObject1 = _textBuffer.finishCurrentSegment();
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = k;
      }
    }
  }
  
  private String _parseUnusualFieldName2(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    throws IOException, JsonParseException
  {
    _textBuffer.resetWithShared(_inputBuffer, paramInt1, _inputPtr - paramInt1);
    char[] arrayOfChar = _textBuffer.getCurrentSegment();
    paramInt1 = _textBuffer.getCurrentSegmentSize();
    int k = paramArrayOfInt.length;
    for (;;)
    {
      int i;
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        i = _inputBuffer[_inputPtr];
        if (i <= k ? paramArrayOfInt[i] == 0 : Character.isJavaIdentifierPart(i)) {}
      }
      else
      {
        _textBuffer.setCurrentLength(paramInt1);
        paramArrayOfInt = _textBuffer;
        arrayOfChar = paramArrayOfInt.getTextBuffer();
        paramInt1 = paramArrayOfInt.getTextOffset();
        j = paramArrayOfInt.size();
        return _symbols.findSymbol(arrayOfChar, paramInt1, j, paramInt2);
      }
      _inputPtr += 1;
      paramInt2 = paramInt2 * 33 + i;
      int j = paramInt1 + 1;
      arrayOfChar[paramInt1] = i;
      if (j >= arrayOfChar.length)
      {
        arrayOfChar = _textBuffer.finishCurrentSegment();
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = j;
      }
    }
  }
  
  private void _skipCComment()
    throws IOException, JsonParseException
  {
    for (;;)
    {
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        arrayOfChar = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfChar[i];
        if (i > 42) {
          continue;
        }
        if (i != 42) {
          break label102;
        }
        if ((_inputPtr < _inputEnd) || (loadMore())) {}
      }
      else
      {
        _reportInvalidEOF(" in a comment");
        return;
      }
      char[] arrayOfChar = _inputBuffer;
      int i = _inputPtr;
      if (arrayOfChar[i] == '/')
      {
        _inputPtr = (i + 1);
        return;
        label102:
        if (i < 32) {
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
    char[] arrayOfChar = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfChar[i];
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
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      char[] arrayOfChar = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfChar[i];
      if (i < 32)
      {
        if (i == 10)
        {
          _skipLF();
          return;
        }
        if (i == 13)
        {
          _skipCR();
          return;
        }
        if (i != 9) {
          _throwInvalidSpace(i);
        }
      }
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
      i = localObject[i];
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
      char[] arrayOfChar = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfChar[i];
      if (i > 32)
      {
        if (i == 47) {
          _skipComment();
        } else {
          return i;
        }
      }
      else if (i != 32) {
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
  
  private char _verifyNoLeadingZeroes()
    throws IOException, JsonParseException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      return '0';
    }
    char c1 = _inputBuffer[_inputPtr];
    if (c1 >= '0')
    {
      if (c1 > '9') {
        return '0';
      }
      if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
        reportInvalidNumber("Leading zeroes not allowed");
      }
      _inputPtr += 1;
      if (c1 == '0')
      {
        char c2;
        do
        {
          if ((_inputPtr >= _inputEnd) && (!loadMore())) {
            return c1;
          }
          char[] arrayOfChar = _inputBuffer;
          int i = _inputPtr;
          c2 = arrayOfChar[i];
          if (c2 < '0') {
            break;
          }
          if (c2 > '9') {
            return '0';
          }
          _inputPtr = (i + 1);
          c1 = c2;
        } while (c2 == '0');
        return c2;
        return '0';
      }
      return c1;
    }
    return '0';
    return c1;
  }
  
  private JsonToken parseNumberText2(boolean paramBoolean)
    throws IOException, JsonParseException
  {
    Object localObject1 = _textBuffer.emptyAndGetCurrentSegment();
    Object localObject2 = localObject1;
    int i4 = 0;
    if (paramBoolean)
    {
      localObject1[0] = 45;
      k = 1;
    }
    else
    {
      k = 0;
    }
    int m = _inputPtr;
    if (m < _inputEnd)
    {
      localObject1 = _inputBuffer;
      _inputPtr = (m + 1);
      i = localObject1[m];
    }
    else
    {
      i = getNextChar("No digit following minus sign");
    }
    int j = i;
    if (i == 48) {
      j = _verifyNoLeadingZeroes();
    }
    int n = 0;
    int i = j;
    int i1;
    while ((i >= 48) && (i <= 57))
    {
      n += 1;
      localObject1 = localObject2;
      i1 = k;
      if (k >= localObject2.length)
      {
        localObject1 = _textBuffer.finishCurrentSegment();
        i1 = 0;
      }
      m = i1 + 1;
      localObject1[i1] = i;
      if ((_inputPtr >= _inputEnd) && (!loadMore()))
      {
        i = 0;
        k = 1;
        i2 = n;
        break label239;
      }
      localObject2 = _inputBuffer;
      k = _inputPtr;
      _inputPtr = (k + 1);
      i = localObject2[k];
      k = m;
      localObject2 = localObject1;
    }
    m = k;
    int k = 0;
    int i2 = n;
    localObject1 = localObject2;
    label239:
    if (i2 == 0)
    {
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Missing integer part (next char ");
      ((StringBuilder)localObject2).append(ParserMinimalBase._getCharDesc(i));
      ((StringBuilder)localObject2).append(")");
      reportInvalidNumber(((StringBuilder)localObject2).toString());
    }
    int i3;
    if (i == 46)
    {
      n = m + 1;
      localObject1[m] = i;
      i1 = 0;
      m = n;
      n = i1;
      for (;;)
      {
        if ((_inputPtr >= _inputEnd) && (!loadMore()))
        {
          i1 = 1;
          break;
        }
        localObject2 = _inputBuffer;
        i1 = _inputPtr;
        _inputPtr = (i1 + 1);
        j = localObject2[i1];
        i = j;
        i1 = k;
        if (j < 48) {
          break;
        }
        if (j > 57)
        {
          i = j;
          i1 = k;
          break;
        }
        i1 = n + 1;
        localObject2 = localObject1;
        n = m;
        if (m >= localObject1.length)
        {
          localObject2 = _textBuffer.finishCurrentSegment();
          n = 0;
        }
        localObject2[n] = j;
        m = n + 1;
        localObject1 = localObject2;
        n = i1;
        i = j;
      }
      if (n == 0) {
        reportUnexpectedNumberChar(i, "Decimal point not followed by a digit");
      }
      localObject2 = localObject1;
      i3 = n;
      k = i1;
    }
    else
    {
      i3 = 0;
      localObject2 = localObject1;
    }
    int i5;
    if (i != 101)
    {
      i1 = i4;
      i4 = m;
      i5 = k;
      if (i != 69) {}
    }
    else
    {
      localObject1 = localObject2;
      n = m;
      if (m >= localObject2.length)
      {
        localObject1 = _textBuffer.finishCurrentSegment();
        n = 0;
      }
      m = n + 1;
      localObject1[n] = i;
      n = _inputPtr;
      if (n < _inputEnd)
      {
        localObject2 = _inputBuffer;
        _inputPtr = (n + 1);
        i = localObject2[n];
      }
      else
      {
        i = getNextChar("expected a digit for number exponent");
      }
      if ((i != 45) && (i != 43)) {
        break label702;
      }
      localObject2 = localObject1;
      n = m;
      if (m >= localObject1.length)
      {
        localObject2 = _textBuffer.finishCurrentSegment();
        n = 0;
      }
      m = n + 1;
      localObject2[n] = i;
      n = _inputPtr;
      if (n < _inputEnd)
      {
        localObject1 = _inputBuffer;
        _inputPtr = (n + 1);
        i = localObject1[n];
        localObject1 = localObject2;
      }
      else
      {
        i = getNextChar("expected a digit for number exponent");
        localObject1 = localObject2;
      }
      label702:
      i1 = 0;
      for (localObject2 = localObject1; (i <= 57) && (i >= 48); localObject2 = localObject1)
      {
        i1 += 1;
        localObject1 = localObject2;
        n = m;
        if (m >= localObject2.length)
        {
          localObject1 = _textBuffer.finishCurrentSegment();
          n = 0;
        }
        m = n + 1;
        localObject1[n] = i;
        if ((_inputPtr >= _inputEnd) && (!loadMore()))
        {
          n = 1;
          k = i1;
          break label836;
        }
        localObject2 = _inputBuffer;
        n = _inputPtr;
        _inputPtr = (n + 1);
        i = localObject2[n];
      }
      n = k;
      k = i1;
      label836:
      i1 = k;
      i4 = m;
      i5 = n;
      if (k == 0)
      {
        reportUnexpectedNumberChar(i, "Exponent indicator not followed by a digit");
        i5 = n;
        i4 = m;
        i1 = k;
      }
    }
    if (i5 == 0) {
      _inputPtr -= 1;
    }
    _textBuffer.setCurrentLength(i4);
    return reset(paramBoolean, i2, i3, i1);
  }
  
  public void _closeInput()
    throws IOException
  {
    if (_reader != null)
    {
      if ((_ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        _reader.close();
      }
      _reader = null;
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
      char[] arrayOfChar = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      char c = arrayOfChar[i];
      if (c > ' ')
      {
        int j = paramBase64Variant.decodeBase64Char(c);
        i = j;
        if (j < 0)
        {
          if (c == '"') {
            return ((ByteArrayBuilder)localObject).toByteArray();
          }
          j = _decodeBase64Escape(paramBase64Variant, c, 0);
          i = j;
          if (j < 0) {}
        }
        else
        {
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = _inputBuffer;
          j = _inputPtr;
          _inputPtr = (j + 1);
          c = arrayOfChar[j];
          int k = paramBase64Variant.decodeBase64Char(c);
          j = k;
          if (k < 0) {
            j = _decodeBase64Escape(paramBase64Variant, c, 1);
          }
          int m = i << 6 | j;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          c = arrayOfChar[i];
          k = paramBase64Variant.decodeBase64Char(c);
          i = k;
          j = i;
          if (k < 0)
          {
            if (k != -2)
            {
              if ((c == '"') && (!paramBase64Variant.usesPadding()))
              {
                ((ByteArrayBuilder)localObject).append(m >> 4);
                return ((ByteArrayBuilder)localObject).toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, c, 2);
            }
            j = i;
            if (i == -2)
            {
              if (_inputPtr >= _inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfChar = _inputBuffer;
              i = _inputPtr;
              _inputPtr = (i + 1);
              c = arrayOfChar[i];
              if (paramBase64Variant.usesPaddingChar(c))
              {
                ((ByteArrayBuilder)localObject).append(m >> 4);
                continue;
              }
              localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("expected padding character '");
              ((StringBuilder)localObject).append(paramBase64Variant.getPaddingChar());
              ((StringBuilder)localObject).append("'");
              throw reportInvalidBase64Char(paramBase64Variant, c, 3, ((StringBuilder)localObject).toString());
            }
          }
          m = m << 6 | j;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          c = arrayOfChar[i];
          k = paramBase64Variant.decodeBase64Char(c);
          i = k;
          j = i;
          if (k < 0)
          {
            if (k != -2)
            {
              if ((c == '"') && (!paramBase64Variant.usesPadding()))
              {
                ((ByteArrayBuilder)localObject).appendTwoBytes(m >> 2);
                return ((ByteArrayBuilder)localObject).toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, c, 3);
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
  
  public char _decodeEscaped()
    throws IOException, JsonParseException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    char[] arrayOfChar = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    char c = arrayOfChar[i];
    if ((c != '"') && (c != '/') && (c != '\\'))
    {
      if (c != 'b')
      {
        if (c != 'f')
        {
          if (c != 'n')
          {
            if (c != 'r')
            {
              if (c != 't')
              {
                if (c != 'u') {
                  return _handleUnrecognizedCharacterEscape(c);
                }
                i = 0;
                int j = 0;
                while (i < 4)
                {
                  if ((_inputPtr >= _inputEnd) && (!loadMore())) {
                    _reportInvalidEOF(" in character escape sequence");
                  }
                  arrayOfChar = _inputBuffer;
                  int k = _inputPtr;
                  _inputPtr = (k + 1);
                  k = arrayOfChar[k];
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
    return c;
  }
  
  public void _finishString()
    throws IOException, JsonParseException
  {
    int i = _inputPtr;
    int k = _inputEnd;
    int j = i;
    if (i < k)
    {
      localObject2 = Utf8StreamParser._inputPtr;
      int m = localObject2.length;
      do
      {
        localObject1 = _inputBuffer;
        int n = localObject1[i];
        if ((n < m) && (localObject2[n] != 0))
        {
          j = i;
          if (n != 34) {
            break;
          }
          localObject2 = _textBuffer;
          j = _inputPtr;
          ((TextBuffer)localObject2).resetWithShared((char[])localObject1, j, i - j);
          _inputPtr = (i + 1);
          return;
        }
        j = i + 1;
        i = j;
      } while (j < k);
    }
    Object localObject1 = _textBuffer;
    Object localObject2 = _inputBuffer;
    i = _inputPtr;
    ((TextBuffer)localObject1).resetWithCopy((char[])localObject2, i, j - i);
    _inputPtr = j;
    _finishString2();
  }
  
  public void _finishString2()
    throws IOException, JsonParseException
  {
    Object localObject1 = _textBuffer.getCurrentSegment();
    int k = _textBuffer.getCurrentSegmentSize();
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(": was expecting closing quote for a string value");
      }
      Object localObject2 = _inputBuffer;
      int m = _inputPtr;
      _inputPtr = (m + 1);
      int j = localObject2[m];
      int i = j;
      if (j <= 92) {
        if (j == 92)
        {
          i = _decodeEscaped();
        }
        else
        {
          i = j;
          if (j <= 34)
          {
            if (j == 34)
            {
              _textBuffer.setCurrentLength(k);
              return;
            }
            i = j;
            if (j < 32)
            {
              _throwUnquotedSpace(j, "string value");
              i = j;
            }
          }
        }
      }
      localObject2 = localObject1;
      m = k;
      if (k >= localObject1.length)
      {
        localObject2 = _textBuffer.finishCurrentSegment();
        m = 0;
      }
      localObject2[m] = i;
      k = m + 1;
      localObject1 = localObject2;
    }
  }
  
  public JsonToken _handleApostropheValue()
    throws IOException, JsonParseException
  {
    Object localObject1 = _textBuffer.emptyAndGetCurrentSegment();
    int k = _textBuffer.getCurrentSegmentSize();
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(": was expecting closing quote for a string value");
      }
      Object localObject2 = _inputBuffer;
      int m = _inputPtr;
      _inputPtr = (m + 1);
      int j = localObject2[m];
      int i = j;
      if (j <= 92) {
        if (j == 92)
        {
          i = _decodeEscaped();
        }
        else
        {
          i = j;
          if (j <= 39)
          {
            if (j == 39)
            {
              _textBuffer.setCurrentLength(k);
              return JsonToken.VALUE_STRING;
            }
            i = j;
            if (j < 32)
            {
              _throwUnquotedSpace(j, "string value");
              i = j;
            }
          }
        }
      }
      localObject2 = localObject1;
      m = k;
      if (k >= localObject1.length)
      {
        localObject2 = _textBuffer.finishCurrentSegment();
        m = 0;
      }
      localObject2[m] = i;
      k = m + 1;
      localObject1 = localObject2;
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
        char[] arrayOfChar = _inputBuffer;
        paramInt = _inputPtr;
        _inputPtr = (paramInt + 1);
        return _handleInvalidNumberStart(arrayOfChar[paramInt], false);
      }
    }
    else if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
      return _handleApostropheValue();
    }
    _reportUnexpectedChar(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
    return null;
  }
  
  public String _handleUnusualFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return _parseApostropheFieldName();
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
      _reportUnexpectedChar(paramInt, "was expecting double-quote to start field name");
    }
    int[] arrayOfInt = Utf8StreamParser._quadBuffer;
    int m = arrayOfInt.length;
    boolean bool;
    if (paramInt < m)
    {
      if ((arrayOfInt[paramInt] == 0) && ((paramInt < 48) || (paramInt > 57))) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = Character.isJavaIdentifierPart((char)paramInt);
    }
    if (!bool) {
      _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    }
    int i = _inputPtr;
    int k = _hashSeed;
    int n = _inputEnd;
    int j = i;
    paramInt = k;
    if (i < n)
    {
      paramInt = k;
      do
      {
        char[] arrayOfChar = _inputBuffer;
        j = arrayOfChar[i];
        if (j < m)
        {
          if (arrayOfInt[j] != 0)
          {
            j = _inputPtr - 1;
            _inputPtr = i;
            return _symbols.findSymbol(arrayOfChar, j, i - j, paramInt);
          }
        }
        else if (!Character.isJavaIdentifierPart((char)j))
        {
          j = _inputPtr - 1;
          _inputPtr = i;
          return _symbols.findSymbol(_inputBuffer, j, i - j, paramInt);
        }
        k = paramInt * 33 + j;
        j = i + 1;
        i = j;
        paramInt = k;
      } while (j < n);
      paramInt = k;
    }
    i = _inputPtr;
    _inputPtr = j;
    return _parseUnusualFieldName2(i - 1, paramInt, arrayOfInt);
  }
  
  public void _matchToken(String paramString, int paramInt)
    throws IOException, JsonParseException
  {
    int j = paramString.length();
    int i;
    do
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOFInValue();
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
    char c = _inputBuffer[_inputPtr];
    if ((c >= '0') && (c != ']'))
    {
      if (c == '}') {
        return;
      }
      if (Character.isJavaIdentifierPart(c)) {
        _reportInvalidToken(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
      }
    }
  }
  
  public String _parseApostropheFieldName()
    throws IOException, JsonParseException
  {
    int k = _inputPtr;
    int m = _hashSeed;
    int n = _inputEnd;
    int j = k;
    int i = m;
    if (k < n)
    {
      int[] arrayOfInt = Utf8StreamParser._inputPtr;
      int i1 = arrayOfInt.length;
      i = m;
      j = k;
      do
      {
        char[] arrayOfChar = _inputBuffer;
        k = arrayOfChar[j];
        if (k == 39)
        {
          k = _inputPtr;
          _inputPtr = (j + 1);
          return _symbols.findSymbol(arrayOfChar, k, j - k, i);
        }
        if ((k < i1) && (arrayOfInt[k] != 0)) {
          break;
        }
        m = i * 33 + k;
        k = j + 1;
        j = k;
        i = m;
      } while (k < n);
      i = m;
      j = k;
    }
    k = _inputPtr;
    _inputPtr = j;
    return _parseFieldName2(k, i, 39);
  }
  
  public String _parseFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    if (paramInt != 34) {
      return _handleUnusualFieldName(paramInt);
    }
    paramInt = _inputPtr;
    int i = _hashSeed;
    int m = _inputEnd;
    int k = i;
    int j = paramInt;
    if (paramInt < m)
    {
      int[] arrayOfInt = Utf8StreamParser._inputPtr;
      int n = arrayOfInt.length;
      do
      {
        char[] arrayOfChar = _inputBuffer;
        int i1 = arrayOfChar[paramInt];
        if ((i1 < n) && (arrayOfInt[i1] != 0))
        {
          k = i;
          j = paramInt;
          if (i1 != 34) {
            break;
          }
          j = _inputPtr;
          _inputPtr = (paramInt + 1);
          return _symbols.findSymbol(arrayOfChar, j, paramInt - j, i);
        }
        k = i * 33 + i1;
        j = paramInt + 1;
        i = k;
        paramInt = j;
      } while (j < m);
    }
    paramInt = _inputPtr;
    _inputPtr = j;
    return _parseFieldName2(paramInt, k, 34);
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
      char[] arrayOfChar = _inputBuffer;
      j = _inputPtr;
      _inputPtr = (j + 1);
      char c = arrayOfChar[j];
      if (c > ' ')
      {
        j = paramBase64Variant.decodeBase64Char(c);
        int n = j;
        int m;
        int i2;
        if (j < 0)
        {
          if (c == '"')
          {
            j = k;
          }
          else
          {
            j = _decodeBase64Escape(paramBase64Variant, c, 0);
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
          arrayOfChar = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          c = arrayOfChar[i];
          k = paramBase64Variant.decodeBase64Char(c);
          i = k;
          if (k < 0) {
            i = _decodeBase64Escape(paramBase64Variant, c, 1);
          }
          i2 = n << 6 | i;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          c = arrayOfChar[i];
          n = paramBase64Variant.decodeBase64Char(c);
          i = n;
          k = i;
          if (n < 0)
          {
            if (n != -2)
            {
              if ((c == '"') && (!paramBase64Variant.usesPadding()))
              {
                paramArrayOfByte[m] = ((byte)(i2 >> 4));
                i = m + 1;
                break label584;
              }
              i = _decodeBase64Escape(paramBase64Variant, c, 2);
            }
            k = i;
            if (i == -2)
            {
              if (_inputPtr >= _inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfChar = _inputBuffer;
              i = _inputPtr;
              _inputPtr = (i + 1);
              c = arrayOfChar[i];
              if (paramBase64Variant.usesPaddingChar(c))
              {
                i = m + 1;
                paramArrayOfByte[m] = ((byte)(i2 >> 4));
                break label726;
              }
              paramOutputStream = f.sufficientlysecure.rootcommands.util.StringBuilder.append("expected padding character '");
              paramOutputStream.append(paramBase64Variant.getPaddingChar());
              paramOutputStream.append("'");
              throw reportInvalidBase64Char(paramBase64Variant, c, 3, paramOutputStream.toString());
            }
          }
          i2 = i2 << 6 | k;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          c = arrayOfChar[i];
          n = paramBase64Variant.decodeBase64Char(c);
          i = n;
          k = i;
          if (n >= 0) {
            break label671;
          }
          if (n == -2) {
            break label618;
          }
          if ((c != '"') || (paramBase64Variant.usesPadding())) {
            break label608;
          }
          k = i2 >> 2;
          n = m + 1;
          paramArrayOfByte[m] = ((byte)(k >> 8));
          i = n + 1;
          paramArrayOfByte[n] = ((byte)k);
        }
        label584:
        _tokenIncomplete = false;
        if (i <= 0) {
          break;
        }
        paramOutputStream.write(paramArrayOfByte, 0, i);
        return j + i;
        label608:
        i = _decodeBase64Escape(paramBase64Variant, c, 3);
        label618:
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
          label671:
          k = i2 << 6 | k;
          i = m + 1;
          paramArrayOfByte[m] = ((byte)(k >> 16));
          m = i + 1;
          paramArrayOfByte[i] = ((byte)(k >> 8));
          i = m + 1;
          paramArrayOfByte[m] = ((byte)k);
          label726:
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
    char[] arrayOfChar = _inputBuffer;
    if (arrayOfChar != null)
    {
      _inputBuffer = null;
      _ioContext.releaseTokenBuffer(arrayOfChar);
    }
  }
  
  public void _reportInvalidToken(String paramString1, String paramString2)
    throws IOException, JsonParseException
  {
    paramString1 = new StringBuilder(paramString1);
    for (;;)
    {
      char c;
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        c = _inputBuffer[_inputPtr];
        if (Character.isJavaIdentifierPart(c)) {}
      }
      else
      {
        paramString2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unrecognized token '");
        paramString2.append(paramString1.toString());
        paramString2.append("': was expecting ");
        _reportError(paramString2.toString());
        return;
      }
      _inputPtr += 1;
      paramString1.append(c);
    }
  }
  
  public void _skipCR()
    throws IOException
  {
    if ((_inputPtr < _inputEnd) || (loadMore()))
    {
      char[] arrayOfChar = _inputBuffer;
      int i = _inputPtr;
      if (arrayOfChar[i] == '\n') {
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
    int i = _inputPtr;
    int j = _inputEnd;
    char[] arrayOfChar = _inputBuffer;
    for (;;)
    {
      int m = i;
      int k = j;
      if (i >= j)
      {
        _inputPtr = i;
        if (!loadMore()) {
          _reportInvalidEOF(": was expecting closing quote for a string value");
        }
        m = _inputPtr;
        k = _inputEnd;
      }
      i = m + 1;
      j = arrayOfChar[m];
      if (j <= 92)
      {
        if (j == 92)
        {
          _inputPtr = i;
          _decodeEscaped();
          i = _inputPtr;
          j = _inputEnd;
          continue;
        }
        if (j <= 34)
        {
          if (j == 34)
          {
            _inputPtr = i;
            return;
          }
          if (j < 32)
          {
            _inputPtr = i;
            _throwUnquotedSpace(j, "string value");
          }
        }
      }
      j = k;
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
    return _reader;
  }
  
  public char getNextChar(String paramString)
    throws IOException, JsonParseException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(paramString);
    }
    paramString = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    return paramString[i];
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
    Object localObject = _reader;
    if (localObject != null)
    {
      char[] arrayOfChar = _inputBuffer;
      i = ((Reader)localObject).read(arrayOfChar, 0, arrayOfChar.length);
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
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Reader returned 0 characters when trying to read ");
      ((StringBuilder)localObject).append(_inputEnd);
      throw new IOException(((StringBuilder)localObject).toString());
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
    Object localObject;
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
    boolean bool = _parsingContext.inObject();
    j = i;
    if (bool)
    {
      localObject = _parseFieldName(i);
      _parsingContext.setCurrentName((String)localObject);
      _currToken = JsonToken.FIELD_NAME;
      i = _skipWS();
      if (i != 58) {
        _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
      }
      j = _skipWS();
    }
    if (j != 34)
    {
      if (j != 45)
      {
        if (j != 91) {
          if (j != 93) {
            if (j != 102) {
              if (j != 110)
              {
                if (j == 116) {
                  break label549;
                }
                if (j != 123) {
                  if (j == 125) {
                    break label541;
                  }
                }
              }
            }
          }
        }
        switch (j)
        {
        default: 
          localObject = _handleUnexpectedValue(j);
          break;
          if (!bool) {
            _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
          }
          localObject = JsonToken.START_OBJECT;
          break;
          _matchToken("null", 1);
          localObject = JsonToken.VALUE_NULL;
          break;
          _matchToken("false", 1);
          localObject = JsonToken.VALUE_FALSE;
          break;
          label541:
          _reportUnexpectedChar(j, "expected a value");
          label549:
          _matchToken("true", 1);
          localObject = JsonToken.VALUE_TRUE;
          break;
          if (!bool) {
            _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
          }
          localObject = JsonToken.START_ARRAY;
          break;
        }
      }
      else
      {
        localObject = parseNumberText(j);
      }
    }
    else
    {
      _tokenIncomplete = true;
      localObject = JsonToken.VALUE_STRING;
    }
    if (bool)
    {
      _nextToken = ((JsonToken)localObject);
      return _currToken;
    }
    _currToken = ((JsonToken)localObject);
    return localObject;
  }
  
  public JsonToken parseNumberText(int paramInt)
    throws IOException, JsonParseException
  {
    int i5 = 0;
    int m = 0;
    int i3 = 0;
    int k = 1;
    boolean bool1;
    if (paramInt == 45) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int n = _inputPtr;
    int i4 = n - 1;
    int i6 = _inputEnd;
    int i = n;
    int j = paramInt;
    char[] arrayOfChar;
    if (bool1)
    {
      if (n >= i6) {
        break label408;
      }
      arrayOfChar = _inputBuffer;
      i = n + 1;
      j = arrayOfChar[n];
      if ((j <= 57) && (j >= 48)) {
        break label112;
      }
      _inputPtr = i;
      return _handleInvalidNumberStart(j, true);
    }
    label112:
    paramInt = k;
    if (j != 48) {
      for (;;)
      {
        if (i < _inputEnd)
        {
          arrayOfChar = _inputBuffer;
          j = i + 1;
          k = arrayOfChar[i];
          if ((k >= 48) && (k <= 57))
          {
            paramInt += 1;
            i = j;
          }
          else
          {
            if (k == 46)
            {
              i = 0;
              for (k = j;; k = j)
              {
                if (k >= i6) {
                  break label408;
                }
                arrayOfChar = _inputBuffer;
                j = k + 1;
                k = arrayOfChar[k];
                if ((k < 48) || (k > 57)) {
                  break;
                }
                i += 1;
              }
              if (i == 0) {
                reportUnexpectedNumberChar(k, "Decimal point not followed by a digit");
              }
            }
            else
            {
              i = 0;
            }
            if (k != 101)
            {
              n = paramInt;
              bool2 = bool1;
              i1 = i;
              i2 = j;
              if (k != 69) {
                break label504;
              }
            }
            if (j < i6)
            {
              arrayOfChar = _inputBuffer;
              k = j + 1;
              m = arrayOfChar[j];
              if ((m != 45) && (m != 43))
              {
                j = k;
                k = i5;
                i3 = m;
              }
              else
              {
                if (k >= i6) {
                  break label408;
                }
                arrayOfChar = _inputBuffer;
                j = k + 1;
                m = arrayOfChar[k];
                k = i3;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i3 = m;
      if ((i3 > 57) || (i3 < 48)) {
        break;
      }
      k += 1;
      if (j >= i6)
      {
        label408:
        paramInt = i4;
        if (bool1) {
          paramInt = i4 + 1;
        }
        _inputPtr = paramInt;
        return parseNumberText2(bool1);
      }
      arrayOfChar = _inputBuffer;
      n = j + 1;
      m = arrayOfChar[j];
      j = n;
    }
    m = k;
    n = paramInt;
    boolean bool2 = bool1;
    int i1 = i;
    int i2 = j;
    if (k == 0)
    {
      reportUnexpectedNumberChar(i3, "Exponent indicator not followed by a digit");
      i2 = j;
      i1 = i;
      bool2 = bool1;
      n = paramInt;
      m = k;
    }
    label504:
    paramInt = i2 - 1;
    _inputPtr = paramInt;
    _textBuffer.resetWithShared(_inputBuffer, i4, paramInt - i4);
    return reset(bool2, n, i1, m);
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
  
  public int releaseBuffered(Writer paramWriter)
    throws IOException
  {
    int j = _inputEnd;
    int i = _inputPtr;
    j -= i;
    if (j < 1) {
      return 0;
    }
    paramWriter.write(_inputBuffer, i, j);
    return j;
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    _objectCodec = paramObjectCodec;
  }
  
  public Version version()
  {
    return CoreVersion.instance.version();
  }
}
