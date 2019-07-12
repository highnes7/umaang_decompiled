package f.fasterxml.jackson.core.'annotation';

import f.fasterxml.jackson.core.Base64Variant;
import f.fasterxml.jackson.core.JsonParseException;
import f.fasterxml.jackson.core.JsonParser;
import f.fasterxml.jackson.core.JsonParser.Feature;
import f.fasterxml.jackson.core.JsonProcessingException;
import f.fasterxml.jackson.core.JsonStreamContext;
import f.fasterxml.jackson.core.JsonToken;
import f.fasterxml.jackson.core.Version;
import f.fasterxml.jackson.core.impl.NumberInput;
import f.fasterxml.jackson.core.util.ByteArrayBuilder;
import f.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class ParserMinimalBase
  extends JsonParser
{
  public static final int INT_APOSTROPHE = 39;
  public static final int INT_ASTERISK = 42;
  public static final int INT_BACKSLASH = 92;
  public static final int INT_COLON = 58;
  public static final int INT_COMMA = 44;
  public static final int INT_CR = 13;
  public static final int INT_LBRACKET = 91;
  public static final int INT_LCURLY = 123;
  public static final int INT_LF = 10;
  public static final int INT_QUOTE = 34;
  public static final int INT_RBRACKET = 93;
  public static final int INT_RCURLY = 125;
  public static final int INT_SLASH = 47;
  public static final int INT_SPACE = 32;
  public static final int INT_TAB = 9;
  public static final int INT_b = 98;
  public static final int INT_f = 102;
  public static final int INT_n = 110;
  public static final int INT_r = 114;
  public static final int INT_t = 116;
  public static final int INT_u = 117;
  public JsonToken _currToken;
  public JsonToken _lastClearedToken;
  
  public ParserMinimalBase() {}
  
  public ParserMinimalBase(int paramInt)
  {
    super(paramInt);
  }
  
  public static final String _getCharDesc(int paramInt)
  {
    char c = (char)paramInt;
    if (Character.isISOControl(c)) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString("(CTRL-CHAR, code ", paramInt, ")");
    }
    if (paramInt > 255)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      localStringBuilder.append(c);
      localStringBuilder.append("' (code ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" / 0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("'");
    localStringBuilder.append(c);
    localStringBuilder.append("' (code ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final JsonParseException _constructError(String paramString, Throwable paramThrowable)
  {
    return new JsonParseException(paramString, getCurrentLocation(), paramThrowable);
  }
  
  public void _decodeBase64(String paramString, ByteArrayBuilder paramByteArrayBuilder, Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    int k = paramString.length();
    int i = 0;
    if (i < k) {
      for (;;)
      {
        int j = i + 1;
        char c = paramString.charAt(i);
        if (j >= k) {
          return;
        }
        if (c > ' ')
        {
          int m = paramBase64Variant.decodeBase64Char(c);
          if (m < 0) {
            _reportInvalidBase64(paramBase64Variant, c, 0, null);
          }
          if (j >= k) {
            _reportBase64EOF();
          }
          i = j + 1;
          c = paramString.charAt(j);
          j = paramBase64Variant.decodeBase64Char(c);
          if (j < 0) {
            _reportInvalidBase64(paramBase64Variant, c, 1, null);
          }
          m = m << 6 | j;
          if (i >= k)
          {
            if (!paramBase64Variant.usesPadding())
            {
              paramByteArrayBuilder.append(m >> 4);
              return;
            }
            _reportBase64EOF();
          }
          j = i + 1;
          c = paramString.charAt(i);
          i = paramBase64Variant.decodeBase64Char(c);
          if (i < 0)
          {
            if (i != -2) {
              _reportInvalidBase64(paramBase64Variant, c, 2, null);
            }
            if (j >= k) {
              _reportBase64EOF();
            }
            i = j + 1;
            c = paramString.charAt(j);
            if (!paramBase64Variant.usesPaddingChar(c))
            {
              StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("expected padding character '");
              localStringBuilder.append(paramBase64Variant.getPaddingChar());
              localStringBuilder.append("'");
              _reportInvalidBase64(paramBase64Variant, c, 3, localStringBuilder.toString());
            }
            paramByteArrayBuilder.append(m >> 4);
            break;
          }
          m = m << 6 | i;
          if (j >= k)
          {
            if (!paramBase64Variant.usesPadding())
            {
              paramByteArrayBuilder.appendTwoBytes(m >> 2);
              return;
            }
            _reportBase64EOF();
          }
          i = j + 1;
          c = paramString.charAt(j);
          j = paramBase64Variant.decodeBase64Char(c);
          if (j < 0)
          {
            if (j != -2) {
              _reportInvalidBase64(paramBase64Variant, c, 3, null);
            }
            paramByteArrayBuilder.appendTwoBytes(m >> 2);
          }
          else
          {
            paramByteArrayBuilder.appendThreeBytes(m << 6 | j);
          }
          break;
        }
        i = j;
      }
    }
  }
  
  public abstract void _handleEOF()
    throws JsonParseException;
  
  public char _handleUnrecognizedCharacterEscape(char paramChar)
    throws JsonProcessingException
  {
    if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
      return paramChar;
    }
    if ((paramChar == '\'') && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return paramChar;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unrecognized character escape ");
    localStringBuilder.append(_getCharDesc(paramChar));
    _reportError(localStringBuilder.toString());
    return paramChar;
  }
  
  public void _reportBase64EOF()
    throws JsonParseException
  {
    throw _constructError("Unexpected end-of-String in base64 content");
  }
  
  public final void _reportError(String paramString)
    throws JsonParseException
  {
    throw _constructError(paramString);
  }
  
  public void _reportInvalidBase64(Base64Variant paramBase64Variant, char paramChar, int paramInt, String paramString)
    throws JsonParseException
  {
    if (paramChar <= ' ')
    {
      paramBase64Variant = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal white space character (code 0x");
      paramBase64Variant.append(Integer.toHexString(paramChar));
      paramBase64Variant.append(") as character #");
      paramBase64Variant.append(paramInt + 1);
      paramBase64Variant.append(" of 4-char base64 unit: can only used between units");
      paramBase64Variant = paramBase64Variant.toString();
    }
    else if (paramBase64Variant.usesPaddingChar(paramChar))
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected padding character ('");
      ((StringBuilder)localObject).append(paramBase64Variant.getPaddingChar());
      ((StringBuilder)localObject).append("') as character #");
      ((StringBuilder)localObject).append(paramInt + 1);
      ((StringBuilder)localObject).append(" of 4-char base64 unit: padding only legal as 3rd or 4th character");
      paramBase64Variant = ((StringBuilder)localObject).toString();
    }
    else if ((Character.isDefined(paramChar)) && (!Character.isISOControl(paramChar)))
    {
      paramBase64Variant = new StringBuilder();
      paramBase64Variant.append("Illegal character '");
      paramBase64Variant.append(paramChar);
      paramBase64Variant.append("' (code 0x");
      paramBase64Variant.append(Integer.toHexString(paramChar));
      paramBase64Variant.append(") in base64 content");
      paramBase64Variant = paramBase64Variant.toString();
    }
    else
    {
      paramBase64Variant = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal character (code 0x");
      paramBase64Variant.append(Integer.toHexString(paramChar));
      paramBase64Variant.append(") in base64 content");
      paramBase64Variant = paramBase64Variant.toString();
    }
    Object localObject = paramBase64Variant;
    if (paramString != null) {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramBase64Variant, ": ", paramString);
    }
    throw _constructError((String)localObject);
  }
  
  public void _reportInvalidEOF()
    throws JsonParseException
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(" in ");
    localStringBuilder.append(_currToken);
    _reportInvalidEOF(localStringBuilder.toString());
  }
  
  public void _reportInvalidEOF(String paramString)
    throws JsonParseException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected end-of-input");
    localStringBuilder.append(paramString);
    _reportError(localStringBuilder.toString());
  }
  
  public void _reportInvalidEOFInValue()
    throws JsonParseException
  {
    _reportInvalidEOF(" in a value");
  }
  
  public void _reportUnexpectedChar(int paramInt, String paramString)
    throws JsonParseException
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected character (");
    ((StringBuilder)localObject).append(_getCharDesc(paramInt));
    ((StringBuilder)localObject).append(")");
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (paramString != null) {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, ": ", paramString);
    }
    _reportError((String)localObject);
  }
  
  public final void _throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  public void _throwInvalidSpace(int paramInt)
    throws JsonParseException
  {
    paramInt = (char)paramInt;
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal character (");
    localStringBuilder.append(_getCharDesc(paramInt));
    localStringBuilder.append("): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    _reportError(localStringBuilder.toString());
  }
  
  public void _throwUnquotedSpace(int paramInt, String paramString)
    throws JsonParseException
  {
    if ((!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS)) || (paramInt >= 32))
    {
      paramInt = (char)paramInt;
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal unquoted character (");
      localStringBuilder.append(_getCharDesc(paramInt));
      localStringBuilder.append("): has to be escaped using backslash to be included in ");
      localStringBuilder.append(paramString);
      _reportError(localStringBuilder.toString());
    }
  }
  
  public final void _wrapError(String paramString, Throwable paramThrowable)
    throws JsonParseException
  {
    throw _constructError(paramString, paramThrowable);
  }
  
  public void clearCurrentToken()
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken != null)
    {
      _lastClearedToken = localJsonToken;
      _currToken = null;
    }
  }
  
  public abstract void close()
    throws IOException;
  
  public abstract byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException;
  
  public abstract String getCurrentName()
    throws IOException, JsonParseException;
  
  public JsonToken getCurrentToken()
  {
    return _currToken;
  }
  
  public JsonToken getLastClearedToken()
  {
    return _lastClearedToken;
  }
  
  public abstract JsonStreamContext getParsingContext();
  
  public abstract String getText()
    throws IOException, JsonParseException;
  
  public abstract char[] getTextCharacters()
    throws IOException, JsonParseException;
  
  public abstract int getTextLength()
    throws IOException, JsonParseException;
  
  public abstract int getTextOffset()
    throws IOException, JsonParseException;
  
  public boolean getValueAsBoolean(boolean paramBoolean)
    throws IOException, JsonParseException
  {
    Object localObject = _currToken;
    if (localObject != null)
    {
      switch (((Enum)localObject).ordinal())
      {
      default: 
        return paramBoolean;
      case 9: 
        return paramBoolean;
      case 6: 
        localObject = getEmbeddedObject();
        if ((localObject instanceof Boolean)) {
          return ((Boolean)localObject).booleanValue();
        }
      case 7: 
        if (!"true".equals(getText().trim())) {
          break label135;
        }
        return true;
      case 11: 
      case 12: 
        return false;
      case 10: 
        return true;
      }
      if (getIntValue() != 0) {
        return true;
      }
    }
    else
    {
      label135:
      return paramBoolean;
    }
    return false;
  }
  
  public double getValueAsDouble(double paramDouble)
    throws IOException, JsonParseException
  {
    Object localObject = _currToken;
    double d = paramDouble;
    if (localObject != null) {
      switch (((Enum)localObject).ordinal())
      {
      default: 
        return paramDouble;
      case 7: 
        return NumberInput.parseAsDouble(getText(), paramDouble);
      case 6: 
        localObject = getEmbeddedObject();
        d = paramDouble;
        if ((localObject instanceof Number)) {
          return ((Number)localObject).doubleValue();
        }
        break;
      case 11: 
      case 12: 
        return 0.0D;
      case 10: 
        return 1.0D;
      case 8: 
      case 9: 
        d = getDoubleValue();
      }
    }
    return d;
  }
  
  public int getValueAsInt(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject = _currToken;
    int i = paramInt;
    if (localObject != null) {
      switch (((Enum)localObject).ordinal())
      {
      default: 
        return paramInt;
      case 7: 
        return NumberInput.parseAsInt(getText(), paramInt);
      case 6: 
        localObject = getEmbeddedObject();
        i = paramInt;
        if ((localObject instanceof Number)) {
          return ((Number)localObject).intValue();
        }
        break;
      case 11: 
      case 12: 
        return 0;
      case 10: 
        return 1;
      case 8: 
      case 9: 
        i = getIntValue();
      }
    }
    return i;
  }
  
  public long getValueAsLong(long paramLong)
    throws IOException, JsonParseException
  {
    Object localObject = _currToken;
    long l = paramLong;
    if (localObject != null) {
      switch (((Enum)localObject).ordinal())
      {
      default: 
        return paramLong;
      case 7: 
        return NumberInput.parseAsLong(getText(), paramLong);
      case 6: 
        localObject = getEmbeddedObject();
        l = paramLong;
        if ((localObject instanceof Number)) {
          return ((Number)localObject).longValue();
        }
        break;
      case 11: 
      case 12: 
        return 0L;
      case 10: 
        return 1L;
      case 8: 
      case 9: 
        l = getLongValue();
      }
    }
    return l;
  }
  
  public String getValueAsString(String paramString)
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken != JsonToken.VALUE_STRING)
    {
      str = paramString;
      if (localJsonToken == null) {
        return str;
      }
      str = paramString;
      if (localJsonToken == JsonToken.VALUE_NULL) {
        return str;
      }
      if (!localJsonToken.isScalarValue()) {
        return paramString;
      }
    }
    String str = getText();
    return str;
  }
  
  public boolean hasCurrentToken()
  {
    return _currToken != null;
  }
  
  public abstract boolean hasTextCharacters();
  
  public abstract boolean isClosed();
  
  public abstract JsonToken nextToken()
    throws IOException, JsonParseException;
  
  public JsonToken nextValue()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = nextToken();
    if (localJsonToken == JsonToken.FIELD_NAME) {
      return nextToken();
    }
    return localJsonToken;
  }
  
  public abstract void overrideCurrentName(String paramString);
  
  public JsonParser skipChildren()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = _currToken;
    if ((localJsonToken != JsonToken.START_OBJECT) && (localJsonToken != JsonToken.START_ARRAY)) {
      return this;
    }
    int i = 1;
    for (;;)
    {
      localJsonToken = nextToken();
      if (localJsonToken == null)
      {
        _handleEOF();
        return this;
      }
      int j = localJsonToken.ordinal();
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            if (j != 4) {
              continue;
            }
          }
        }
        else
        {
          j = i - 1;
          i = j;
          if (j != 0) {
            continue;
          }
          return this;
        }
      }
      i += 1;
    }
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
}
