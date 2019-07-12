package f.fasterxml.jackson.core.'annotation';

import f.fasterxml.jackson.core.Base64Variant;
import f.fasterxml.jackson.core.Daemon;
import f.fasterxml.jackson.core.JsonLocation;
import f.fasterxml.jackson.core.JsonParseException;
import f.fasterxml.jackson.core.JsonStreamContext;
import f.fasterxml.jackson.core.JsonToken;
import f.fasterxml.jackson.core.impl.IOContext;
import f.fasterxml.jackson.core.impl.NumberInput;
import f.fasterxml.jackson.core.json.JsonReadContext;
import f.fasterxml.jackson.core.util.ByteArrayBuilder;
import f.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ParserBase
  extends ParserMinimalBase
{
  public static final BigDecimal BD_MAX_INT = new BigDecimal(BI_MAX_INT);
  public static final BigDecimal BD_MAX_LONG;
  public static final BigDecimal BD_MIN_INT;
  public static final BigDecimal BD_MIN_LONG;
  public static final BigInteger BI_MAX_INT;
  public static final BigInteger BI_MAX_LONG;
  public static final BigInteger BI_MIN_INT = BigInteger.valueOf(-2147483648L);
  public static final BigInteger BI_MIN_LONG;
  public static final char CHAR_NULL = '\000';
  public static final int INT_0 = 48;
  public static final int INT_1 = 49;
  public static final int INT_2 = 50;
  public static final int INT_3 = 51;
  public static final int INT_4 = 52;
  public static final int INT_5 = 53;
  public static final int INT_6 = 54;
  public static final int INT_7 = 55;
  public static final int INT_8 = 56;
  public static final int INT_9 = 57;
  public static final int INT_DECIMAL_POINT = 46;
  public static final int INT_E = 69;
  public static final int INT_MINUS = 45;
  public static final int INT_PLUS = 43;
  public static final int INT_e = 101;
  public static final double MAX_INT_D = 2.147483647E9D;
  public static final long MAX_INT_L = 2147483647L;
  public static final double MAX_LONG_D = 9.223372036854776E18D;
  public static final double MIN_INT_D = -2.147483648E9D;
  public static final long MIN_INT_L = -2147483648L;
  public static final double MIN_LONG_D = -9.223372036854776E18D;
  public static final int NR_BIGDECIMAL = 16;
  public static final int NR_BIGINT = 4;
  public static final int NR_DOUBLE = 8;
  public static final int NR_INT = 1;
  public static final int NR_LONG = 2;
  public static final int QUIET_HOURS_DEFAULT_END_MINUTE = 0;
  public byte[] _binaryValue;
  public ByteArrayBuilder _byteArrayBuilder = null;
  public boolean _closed;
  public long _currInputProcessed = 0L;
  public int _currInputRow = 1;
  public int _currInputRowStart = 0;
  public int _expLength;
  public int _fractLength;
  public int _inputEnd = 0;
  public int _inputPtr = 0;
  public int _intLength;
  public final IOContext _ioContext;
  public boolean _nameCopied = false;
  public char[] _nameCopyBuffer = null;
  public JsonToken _nextToken;
  public int _numTypesValid = 0;
  public BigDecimal _numberBigDecimal;
  public BigInteger _numberBigInt;
  public double _numberDouble;
  public int _numberInt;
  public long _numberLong;
  public boolean _numberNegative;
  public JsonReadContext _parsingContext;
  public final TextBuffer _textBuffer;
  public int _tokenInputCol = 0;
  public int _tokenInputRow = 1;
  public long _tokenInputTotal = 0L;
  
  static
  {
    BI_MAX_INT = BigInteger.valueOf(2147483647L);
    BI_MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    BI_MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    BD_MIN_LONG = new BigDecimal(BI_MIN_LONG);
    BD_MAX_LONG = new BigDecimal(BI_MAX_LONG);
    BD_MIN_INT = new BigDecimal(BI_MIN_INT);
  }
  
  public ParserBase(IOContext paramIOContext, int paramInt)
  {
    _features = paramInt;
    _ioContext = paramIOContext;
    _textBuffer = paramIOContext.constructTextBuffer();
    _parsingContext = JsonReadContext.createRootContext();
  }
  
  private void _parseSlowFloatValue(int paramInt)
    throws IOException, JsonParseException
  {
    if (paramInt == 16) {
      localObject = _textBuffer;
    }
    try
    {
      localObject = ((TextBuffer)localObject).contentsAsDecimal();
      _numberBigDecimal = ((BigDecimal)localObject);
      _numTypesValid = 16;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      double d;
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Malformed numeric value '");
      localStringBuilder.append(_textBuffer.contentsAsString());
      localStringBuilder.append("'");
      _wrapError(localStringBuilder.toString(), localNumberFormatException);
    }
    Object localObject = _textBuffer;
    d = ((TextBuffer)localObject).contentsAsDouble();
    _numberDouble = d;
    _numTypesValid = 8;
    return;
  }
  
  private void _parseSlowIntValue(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException, JsonParseException
  {
    String str = _textBuffer.contentsAsString();
    boolean bool = _numberNegative;
    try
    {
      bool = NumberInput.inLongRange(paramArrayOfChar, paramInt2, paramInt3, bool);
      if (bool)
      {
        long l = Long.parseLong(str);
        _numberLong = l;
        _numTypesValid = 2;
        return;
      }
      paramArrayOfChar = new BigInteger(str);
      _numberBigInt = paramArrayOfChar;
      _numTypesValid = 4;
      return;
    }
    catch (NumberFormatException paramArrayOfChar)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Malformed numeric value '");
      localStringBuilder.append(str);
      localStringBuilder.append("'");
      _wrapError(localStringBuilder.toString(), paramArrayOfChar);
    }
  }
  
  public abstract void _closeInput()
    throws IOException;
  
  public final int _decodeBase64Escape(Base64Variant paramBase64Variant, char paramChar, int paramInt)
    throws IOException, JsonParseException
  {
    if (paramChar == '\\')
    {
      char c = _decodeEscaped();
      if ((c <= ' ') && (paramInt == 0)) {
        return -1;
      }
      paramChar = paramBase64Variant.decodeBase64Char(c);
      if (paramChar >= 0) {
        return paramChar;
      }
      throw reportInvalidBase64Char(paramBase64Variant, c, paramInt);
    }
    throw reportInvalidBase64Char(paramBase64Variant, paramChar, paramInt);
  }
  
  public final int _decodeBase64Escape(Base64Variant paramBase64Variant, int paramInt1, int paramInt2)
    throws IOException, JsonParseException
  {
    if (paramInt1 == 92)
    {
      paramInt1 = _decodeEscaped();
      if ((paramInt1 <= 32) && (paramInt2 == 0)) {
        return -1;
      }
      int i = paramBase64Variant.decodeBase64Char(paramInt1);
      if (i >= 0) {
        return i;
      }
      throw reportInvalidBase64Char(paramBase64Variant, paramInt1, paramInt2);
    }
    throw reportInvalidBase64Char(paramBase64Variant, paramInt1, paramInt2);
  }
  
  public char _decodeEscaped()
    throws IOException, JsonParseException
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void _finishString()
    throws IOException, JsonParseException;
  
  public ByteArrayBuilder _getByteArrayBuilder()
  {
    ByteArrayBuilder localByteArrayBuilder = _byteArrayBuilder;
    if (localByteArrayBuilder == null) {
      _byteArrayBuilder = new ByteArrayBuilder();
    } else {
      localByteArrayBuilder.reset();
    }
    return _byteArrayBuilder;
  }
  
  public void _handleEOF()
    throws JsonParseException
  {
    if (!_parsingContext.inRoot())
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(": expected close marker for ");
      localStringBuilder.append(_parsingContext.getTypeDesc());
      localStringBuilder.append(" (from ");
      localStringBuilder.append(_parsingContext.getStartLocation(_ioContext.getSourceReference()));
      localStringBuilder.append(")");
      _reportInvalidEOF(localStringBuilder.toString());
    }
  }
  
  public void _parseNumericValue(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject = _currToken;
    if (localObject == JsonToken.VALUE_NUMBER_INT)
    {
      localObject = _textBuffer.getTextBuffer();
      int j = _textBuffer.getTextOffset();
      int i = j;
      int k = _intLength;
      if (_numberNegative) {
        i = j + 1;
      }
      if (k <= 9)
      {
        i = NumberInput.parseInt((char[])localObject, i, k);
        paramInt = i;
        if (_numberNegative) {
          paramInt = -i;
        }
        _numberInt = paramInt;
        _numTypesValid = 1;
        return;
      }
      if (k <= 18)
      {
        long l2 = NumberInput.parseLong((char[])localObject, i, k);
        long l1 = l2;
        if (_numberNegative) {
          l1 = -l2;
        }
        if (k == 10) {
          if (_numberNegative)
          {
            if (l1 >= -2147483648L)
            {
              _numberInt = ((int)l1);
              _numTypesValid = 1;
            }
          }
          else if (l1 <= 2147483647L)
          {
            _numberInt = ((int)l1);
            _numTypesValid = 1;
            return;
          }
        }
        _numberLong = l1;
        _numTypesValid = 2;
        return;
      }
      _parseSlowIntValue(paramInt, (char[])localObject, i, k);
      return;
    }
    if (localObject == JsonToken.VALUE_NUMBER_FLOAT)
    {
      _parseSlowFloatValue(paramInt);
      return;
    }
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Current token (");
    ((StringBuilder)localObject).append(_currToken);
    ((StringBuilder)localObject).append(") not numeric, can not use numeric value accessors");
    _reportError(((StringBuilder)localObject).toString());
  }
  
  public void _releaseBuffers()
    throws IOException
  {
    _textBuffer.releaseBuffers();
    char[] arrayOfChar = _nameCopyBuffer;
    if (arrayOfChar != null)
    {
      _nameCopyBuffer = null;
      _ioContext.releaseNameCopyBuffer(arrayOfChar);
    }
  }
  
  public void _reportMismatchedEndMarker(int paramInt, char paramChar)
    throws JsonParseException
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
    ((StringBuilder)localObject).append(_parsingContext.getStartLocation(_ioContext.getSourceReference()));
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected close marker '");
    localStringBuilder.append((char)paramInt);
    localStringBuilder.append("': expected '");
    localStringBuilder.append(paramChar);
    localStringBuilder.append("' (for ");
    localStringBuilder.append(_parsingContext.getTypeDesc());
    localStringBuilder.append(" starting at ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")");
    _reportError(localStringBuilder.toString());
  }
  
  public void close()
    throws IOException
  {
    if (!_closed)
    {
      _closed = true;
      try
      {
        _closeInput();
        _releaseBuffers();
        return;
      }
      catch (Throwable localThrowable)
      {
        _releaseBuffers();
        throw localThrowable;
      }
    }
  }
  
  public void convertNumberToBigDecimal()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x8) != 0) {
      _numberBigDecimal = new BigDecimal(getText());
    } else if ((i & 0x4) != 0) {
      _numberBigDecimal = new BigDecimal(_numberBigInt);
    } else if ((i & 0x2) != 0) {
      _numberBigDecimal = BigDecimal.valueOf(_numberLong);
    } else if ((i & 0x1) != 0) {
      _numberBigDecimal = BigDecimal.valueOf(_numberInt);
    } else {
      _throwInternal();
    }
    _numTypesValid |= 0x10;
  }
  
  public void convertNumberToBigInteger()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x10) != 0) {
      _numberBigInt = _numberBigDecimal.toBigInteger();
    } else if ((i & 0x2) != 0) {
      _numberBigInt = BigInteger.valueOf(_numberLong);
    } else if ((i & 0x1) != 0) {
      _numberBigInt = BigInteger.valueOf(_numberInt);
    } else if ((i & 0x8) != 0) {
      _numberBigInt = BigDecimal.valueOf(_numberDouble).toBigInteger();
    } else {
      _throwInternal();
    }
    _numTypesValid |= 0x4;
  }
  
  public void convertNumberToDouble()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x10) != 0) {
      _numberDouble = _numberBigDecimal.doubleValue();
    } else if ((i & 0x4) != 0) {
      _numberDouble = _numberBigInt.doubleValue();
    } else if ((i & 0x2) != 0) {
      _numberDouble = _numberLong;
    } else if ((i & 0x1) != 0) {
      _numberDouble = _numberInt;
    } else {
      _throwInternal();
    }
    _numTypesValid |= 0x8;
  }
  
  public void convertNumberToInt()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x2) != 0)
    {
      long l = _numberLong;
      i = (int)l;
      if (i != l)
      {
        StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Numeric value (");
        localStringBuilder.append(getText());
        localStringBuilder.append(") out of range of int");
        _reportError(localStringBuilder.toString());
      }
      _numberInt = i;
    }
    else if ((i & 0x4) != 0)
    {
      if ((BI_MIN_INT.compareTo(_numberBigInt) > 0) || (BI_MAX_INT.compareTo(_numberBigInt) < 0)) {
        reportOverflowInt();
      }
      _numberInt = _numberBigInt.intValue();
    }
    else if ((i & 0x8) != 0)
    {
      double d = _numberDouble;
      if ((d < -2.147483648E9D) || (d > 2.147483647E9D)) {
        reportOverflowInt();
      }
      _numberInt = ((int)_numberDouble);
    }
    else if ((i & 0x10) != 0)
    {
      if ((BD_MIN_INT.compareTo(_numberBigDecimal) > 0) || (BD_MAX_INT.compareTo(_numberBigDecimal) < 0)) {
        reportOverflowInt();
      }
      _numberInt = _numberBigDecimal.intValue();
    }
    else
    {
      _throwInternal();
    }
    _numTypesValid |= 0x1;
  }
  
  public void convertNumberToLong()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x1) != 0)
    {
      _numberLong = _numberInt;
    }
    else if ((i & 0x4) != 0)
    {
      if ((BI_MIN_LONG.compareTo(_numberBigInt) > 0) || (BI_MAX_LONG.compareTo(_numberBigInt) < 0)) {
        reportOverflowLong();
      }
      _numberLong = _numberBigInt.longValue();
    }
    else if ((i & 0x8) != 0)
    {
      double d = _numberDouble;
      if ((d < -9.223372036854776E18D) || (d > 9.223372036854776E18D)) {
        reportOverflowLong();
      }
      _numberLong = (_numberDouble);
    }
    else if ((i & 0x10) != 0)
    {
      if ((BD_MIN_LONG.compareTo(_numberBigDecimal) > 0) || (BD_MAX_LONG.compareTo(_numberBigDecimal) < 0)) {
        reportOverflowLong();
      }
      _numberLong = _numberBigDecimal.longValue();
    }
    else
    {
      _throwInternal();
    }
    _numTypesValid |= 0x2;
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x4) == 0)
    {
      if (i == 0) {
        _parseNumericValue(4);
      }
      if ((_numTypesValid & 0x4) == 0) {
        convertNumberToBigInteger();
      }
    }
    return _numberBigInt;
  }
  
  public JsonLocation getCurrentLocation()
  {
    int i = _inputPtr;
    int j = _currInputRowStart;
    return new JsonLocation(_ioContext.getSourceReference(), _currInputProcessed + _inputPtr - 1L, _currInputRow, i - j + 1);
  }
  
  public String getCurrentName()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = _currToken;
    if ((localJsonToken != JsonToken.START_OBJECT) && (localJsonToken != JsonToken.START_ARRAY)) {
      return _parsingContext.getCurrentName();
    }
    return _parsingContext.getParent().getCurrentName();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x10) == 0)
    {
      if (i == 0) {
        _parseNumericValue(16);
      }
      if ((_numTypesValid & 0x10) == 0) {
        convertNumberToBigDecimal();
      }
    }
    return _numberBigDecimal;
  }
  
  public double getDoubleValue()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x8) == 0)
    {
      if (i == 0) {
        _parseNumericValue(8);
      }
      if ((_numTypesValid & 0x8) == 0) {
        convertNumberToDouble();
      }
    }
    return _numberDouble;
  }
  
  public float getFloatValue()
    throws IOException, JsonParseException
  {
    return (float)getDoubleValue();
  }
  
  public int getIntValue()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x1) == 0)
    {
      if (i == 0) {
        _parseNumericValue(1);
      }
      if ((_numTypesValid & 0x1) == 0) {
        convertNumberToInt();
      }
    }
    return _numberInt;
  }
  
  public long getLongValue()
    throws IOException, JsonParseException
  {
    int i = _numTypesValid;
    if ((i & 0x2) == 0)
    {
      if (i == 0) {
        _parseNumericValue(2);
      }
      if ((_numTypesValid & 0x2) == 0) {
        convertNumberToLong();
      }
    }
    return _numberLong;
  }
  
  public Daemon getNumberType()
    throws IOException, JsonParseException
  {
    if (_numTypesValid == 0) {
      _parseNumericValue(0);
    }
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      int i = _numTypesValid;
      if ((i & 0x1) != 0) {
        return Daemon.Aria2;
      }
      if ((i & 0x2) != 0) {
        return Daemon.Bitflu;
      }
      return Daemon.BitTorrent;
    }
    if ((_numTypesValid & 0x10) != 0) {
      return Daemon.VALUE_NUMBER_INT;
    }
    return Daemon.VALUE_NUMBER_FLOAT;
  }
  
  public Number getNumberValue()
    throws IOException, JsonParseException
  {
    if (_numTypesValid == 0) {
      _parseNumericValue(0);
    }
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      i = _numTypesValid;
      if ((i & 0x1) != 0) {
        return Integer.valueOf(_numberInt);
      }
      if ((i & 0x2) != 0) {
        return Long.valueOf(_numberLong);
      }
      if ((i & 0x4) != 0) {
        return _numberBigInt;
      }
      return _numberBigDecimal;
    }
    int i = _numTypesValid;
    if ((i & 0x10) != 0) {
      return _numberBigDecimal;
    }
    if ((i & 0x8) == 0) {
      _throwInternal();
    }
    return Double.valueOf(_numberDouble);
  }
  
  public JsonReadContext getParsingContext()
  {
    return _parsingContext;
  }
  
  public long getTokenCharacterOffset()
  {
    return _tokenInputTotal;
  }
  
  public int getTokenColumnNr()
  {
    int i = _tokenInputCol;
    if (i < 0) {
      return i;
    }
    return i + 1;
  }
  
  public int getTokenLineNr()
  {
    return _tokenInputRow;
  }
  
  public JsonLocation getTokenLocation()
  {
    return new JsonLocation(_ioContext.getSourceReference(), getTokenCharacterOffset(), getTokenLineNr(), getTokenColumnNr());
  }
  
  public boolean hasTextCharacters()
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken == JsonToken.VALUE_STRING) {
      return true;
    }
    if (localJsonToken == JsonToken.FIELD_NAME) {
      return _nameCopied;
    }
    return false;
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  public abstract boolean loadMore()
    throws IOException;
  
  public final void loadMoreGuaranteed()
    throws IOException
  {
    if (!loadMore()) {
      _reportInvalidEOF();
    }
  }
  
  public void overrideCurrentName(String paramString)
  {
    JsonReadContext localJsonReadContext2 = _parsingContext;
    JsonToken localJsonToken = _currToken;
    JsonReadContext localJsonReadContext1;
    if (localJsonToken != JsonToken.START_OBJECT)
    {
      localJsonReadContext1 = localJsonReadContext2;
      if (localJsonToken != JsonToken.START_ARRAY) {}
    }
    else
    {
      localJsonReadContext1 = localJsonReadContext2.getParent();
    }
    localJsonReadContext1.setCurrentName(paramString);
  }
  
  public IllegalArgumentException reportInvalidBase64Char(Base64Variant paramBase64Variant, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    return reportInvalidBase64Char(paramBase64Variant, paramInt1, paramInt2, null);
  }
  
  public IllegalArgumentException reportInvalidBase64Char(Base64Variant paramBase64Variant, int paramInt1, int paramInt2, String paramString)
    throws IllegalArgumentException
  {
    if (paramInt1 <= 32)
    {
      paramBase64Variant = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal white space character (code 0x");
      paramBase64Variant.append(Integer.toHexString(paramInt1));
      paramBase64Variant.append(") as character #");
      paramBase64Variant.append(paramInt2 + 1);
      paramBase64Variant.append(" of 4-char base64 unit: can only used between units");
      paramBase64Variant = paramBase64Variant.toString();
    }
    else if (paramBase64Variant.usesPaddingChar(paramInt1))
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected padding character ('");
      ((StringBuilder)localObject).append(paramBase64Variant.getPaddingChar());
      ((StringBuilder)localObject).append("') as character #");
      ((StringBuilder)localObject).append(paramInt2 + 1);
      ((StringBuilder)localObject).append(" of 4-char base64 unit: padding only legal as 3rd or 4th character");
      paramBase64Variant = ((StringBuilder)localObject).toString();
    }
    else if ((Character.isDefined(paramInt1)) && (!Character.isISOControl(paramInt1)))
    {
      paramBase64Variant = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal character '");
      paramBase64Variant.append((char)paramInt1);
      paramBase64Variant.append("' (code 0x");
      paramBase64Variant.append(Integer.toHexString(paramInt1));
      paramBase64Variant.append(") in base64 content");
      paramBase64Variant = paramBase64Variant.toString();
    }
    else
    {
      paramBase64Variant = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal character (code 0x");
      paramBase64Variant.append(Integer.toHexString(paramInt1));
      paramBase64Variant.append(") in base64 content");
      paramBase64Variant = paramBase64Variant.toString();
    }
    Object localObject = paramBase64Variant;
    if (paramString != null) {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramBase64Variant, ": ", paramString);
    }
    return new IllegalArgumentException((String)localObject);
  }
  
  public void reportInvalidNumber(String paramString)
    throws JsonParseException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid numeric value: ");
    localStringBuilder.append(paramString);
    _reportError(localStringBuilder.toString());
  }
  
  public void reportOverflowInt()
    throws IOException, JsonParseException
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Numeric value (");
    localStringBuilder.append(getText());
    localStringBuilder.append(") out of range of int (");
    localStringBuilder.append(Integer.MIN_VALUE);
    localStringBuilder.append(" - ");
    localStringBuilder.append(Integer.MAX_VALUE);
    localStringBuilder.append(")");
    _reportError(localStringBuilder.toString());
  }
  
  public void reportOverflowLong()
    throws IOException, JsonParseException
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Numeric value (");
    localStringBuilder.append(getText());
    localStringBuilder.append(") out of range of long (");
    localStringBuilder.append(Long.MIN_VALUE);
    localStringBuilder.append(" - ");
    localStringBuilder.append(Long.MAX_VALUE);
    localStringBuilder.append(")");
    _reportError(localStringBuilder.toString());
  }
  
  public void reportUnexpectedNumberChar(int paramInt, String paramString)
    throws JsonParseException
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected character (");
    ((StringBuilder)localObject).append(ParserMinimalBase._getCharDesc(paramInt));
    ((StringBuilder)localObject).append(") in numeric value");
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (paramString != null) {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, ": ", paramString);
    }
    _reportError((String)localObject);
  }
  
  public final JsonToken reset(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < 1) && (paramInt3 < 1)) {
      return resetInt(paramBoolean, paramInt1);
    }
    return resetFloat(paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public final JsonToken resetAsNaN(String paramString, double paramDouble)
  {
    _textBuffer.resetWithString(paramString);
    _numberDouble = paramDouble;
    _numTypesValid = 8;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public final JsonToken resetFloat(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    _numberNegative = paramBoolean;
    _intLength = paramInt1;
    _fractLength = paramInt2;
    _expLength = paramInt3;
    _numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public final JsonToken resetInt(boolean paramBoolean, int paramInt)
  {
    _numberNegative = paramBoolean;
    _intLength = paramInt;
    _fractLength = 0;
    _expLength = 0;
    _numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_INT;
  }
}
