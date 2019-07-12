package f.fasterxml.jackson.core.util;

import f.fasterxml.jackson.core.Base64Variant;
import f.fasterxml.jackson.core.Daemon;
import f.fasterxml.jackson.core.FormatSchema;
import f.fasterxml.jackson.core.JsonLocation;
import f.fasterxml.jackson.core.JsonParseException;
import f.fasterxml.jackson.core.JsonParser;
import f.fasterxml.jackson.core.JsonParser.Feature;
import f.fasterxml.jackson.core.JsonStreamContext;
import f.fasterxml.jackson.core.JsonToken;
import f.fasterxml.jackson.core.ObjectCodec;
import f.fasterxml.jackson.core.Version;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonParserDelegate
  extends JsonParser
{
  public JsonParser delegate;
  
  public JsonParserDelegate(JsonParser paramJsonParser)
  {
    delegate = paramJsonParser;
  }
  
  public boolean canUseSchema()
  {
    return delegate.canUseSchema();
  }
  
  public boolean canUseSchema(FormatSchema paramFormatSchema)
  {
    return delegate.canUseSchema(paramFormatSchema);
  }
  
  public void clearCurrentToken()
  {
    delegate.clearCurrentToken();
  }
  
  public void close()
    throws IOException
  {
    delegate.close();
  }
  
  public JsonParser disable(JsonParser.Feature paramFeature)
  {
    delegate.disable(paramFeature);
    return this;
  }
  
  public JsonParser enable(JsonParser.Feature paramFeature)
  {
    delegate.enable(paramFeature);
    return this;
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException, JsonParseException
  {
    return delegate.getBigIntegerValue();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    return delegate.getBinaryValue(paramBase64Variant);
  }
  
  public boolean getBooleanValue()
    throws IOException, JsonParseException
  {
    return delegate.getBooleanValue();
  }
  
  public byte getByteValue()
    throws IOException, JsonParseException
  {
    return delegate.getByteValue();
  }
  
  public ObjectCodec getCodec()
  {
    return delegate.getCodec();
  }
  
  public JsonLocation getCurrentLocation()
  {
    return delegate.getCurrentLocation();
  }
  
  public String getCurrentName()
    throws IOException, JsonParseException
  {
    return delegate.getCurrentName();
  }
  
  public JsonToken getCurrentToken()
  {
    return delegate.getCurrentToken();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException, JsonParseException
  {
    return delegate.getDecimalValue();
  }
  
  public double getDoubleValue()
    throws IOException, JsonParseException
  {
    return delegate.getDoubleValue();
  }
  
  public Object getEmbeddedObject()
    throws IOException, JsonParseException
  {
    return delegate.getEmbeddedObject();
  }
  
  public float getFloatValue()
    throws IOException, JsonParseException
  {
    return delegate.getFloatValue();
  }
  
  public Object getInputSource()
  {
    return delegate.getInputSource();
  }
  
  public int getIntValue()
    throws IOException, JsonParseException
  {
    return delegate.getIntValue();
  }
  
  public JsonToken getLastClearedToken()
  {
    return delegate.getLastClearedToken();
  }
  
  public long getLongValue()
    throws IOException, JsonParseException
  {
    return delegate.getLongValue();
  }
  
  public Daemon getNumberType()
    throws IOException, JsonParseException
  {
    return delegate.getNumberType();
  }
  
  public Number getNumberValue()
    throws IOException, JsonParseException
  {
    return delegate.getNumberValue();
  }
  
  public JsonStreamContext getParsingContext()
  {
    return delegate.getParsingContext();
  }
  
  public FormatSchema getSchema()
  {
    return delegate.getSchema();
  }
  
  public short getShortValue()
    throws IOException, JsonParseException
  {
    return delegate.getShortValue();
  }
  
  public String getText()
    throws IOException, JsonParseException
  {
    return delegate.getText();
  }
  
  public char[] getTextCharacters()
    throws IOException, JsonParseException
  {
    return delegate.getTextCharacters();
  }
  
  public int getTextLength()
    throws IOException, JsonParseException
  {
    return delegate.getTextLength();
  }
  
  public int getTextOffset()
    throws IOException, JsonParseException
  {
    return delegate.getTextOffset();
  }
  
  public JsonLocation getTokenLocation()
  {
    return delegate.getTokenLocation();
  }
  
  public boolean getValueAsBoolean()
    throws IOException, JsonParseException
  {
    return delegate.getValueAsBoolean();
  }
  
  public boolean getValueAsBoolean(boolean paramBoolean)
    throws IOException, JsonParseException
  {
    return delegate.getValueAsBoolean(paramBoolean);
  }
  
  public double getValueAsDouble()
    throws IOException, JsonParseException
  {
    return delegate.getValueAsDouble();
  }
  
  public double getValueAsDouble(double paramDouble)
    throws IOException, JsonParseException
  {
    return delegate.getValueAsDouble(paramDouble);
  }
  
  public int getValueAsInt()
    throws IOException, JsonParseException
  {
    return delegate.getValueAsInt();
  }
  
  public int getValueAsInt(int paramInt)
    throws IOException, JsonParseException
  {
    return delegate.getValueAsInt(paramInt);
  }
  
  public long getValueAsLong()
    throws IOException, JsonParseException
  {
    return delegate.getValueAsLong();
  }
  
  public long getValueAsLong(long paramLong)
    throws IOException, JsonParseException
  {
    return delegate.getValueAsLong(paramLong);
  }
  
  public String getValueAsString()
    throws IOException, JsonParseException
  {
    return delegate.getValueAsString();
  }
  
  public String getValueAsString(String paramString)
    throws IOException, JsonParseException
  {
    return delegate.getValueAsString(paramString);
  }
  
  public boolean hasCurrentToken()
  {
    return delegate.hasCurrentToken();
  }
  
  public boolean hasTextCharacters()
  {
    return delegate.hasTextCharacters();
  }
  
  public boolean isClosed()
  {
    return delegate.isClosed();
  }
  
  public boolean isEnabled(JsonParser.Feature paramFeature)
  {
    return delegate.isEnabled(paramFeature);
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    return delegate.nextToken();
  }
  
  public JsonToken nextValue()
    throws IOException, JsonParseException
  {
    return delegate.nextValue();
  }
  
  public void overrideCurrentName(String paramString)
  {
    delegate.overrideCurrentName(paramString);
  }
  
  public int readBinaryValue(Base64Variant paramBase64Variant, OutputStream paramOutputStream)
    throws IOException, JsonParseException
  {
    return delegate.readBinaryValue(paramBase64Variant, paramOutputStream);
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    delegate.setCodec(paramObjectCodec);
  }
  
  public void setSchema(FormatSchema paramFormatSchema)
  {
    delegate.setSchema(paramFormatSchema);
  }
  
  public JsonParser skipChildren()
    throws IOException, JsonParseException
  {
    delegate.skipChildren();
    return this;
  }
  
  public Version version()
  {
    return delegate.version();
  }
}
