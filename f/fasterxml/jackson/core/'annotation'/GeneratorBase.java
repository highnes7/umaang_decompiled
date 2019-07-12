package f.fasterxml.jackson.core.'annotation';

import f.fasterxml.jackson.core.Base64Variant;
import f.fasterxml.jackson.core.JsonGenerationException;
import f.fasterxml.jackson.core.JsonGenerator;
import f.fasterxml.jackson.core.JsonGenerator.Feature;
import f.fasterxml.jackson.core.JsonParser;
import f.fasterxml.jackson.core.JsonProcessingException;
import f.fasterxml.jackson.core.JsonToken;
import f.fasterxml.jackson.core.ObjectCodec;
import f.fasterxml.jackson.core.SerializableString;
import f.fasterxml.jackson.core.TreeNode;
import f.fasterxml.jackson.core.Version;
import f.fasterxml.jackson.core.json.JsonWriteContext;
import f.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import f.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class GeneratorBase
  extends JsonGenerator
{
  public boolean _cfgNumbersAsStrings;
  public boolean _closed;
  public int _features;
  public ObjectCodec _objectCodec;
  public JsonWriteContext _writeContext;
  
  public GeneratorBase(int paramInt, ObjectCodec paramObjectCodec)
  {
    _features = paramInt;
    _writeContext = JsonWriteContext.createRootContext();
    _objectCodec = paramObjectCodec;
    _cfgNumbersAsStrings = isEnabled(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
  }
  
  public void _cantHappen()
  {
    throw new RuntimeException("Internal error: should never end up through this code path");
  }
  
  public abstract void _releaseBuffers();
  
  public void _reportError(String paramString)
    throws JsonGenerationException
  {
    throw new JsonGenerationException(paramString);
  }
  
  public void _reportUnsupportedOperation()
  {
    throw new UnsupportedOperationException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(this, f.sufficientlysecure.rootcommands.util.StringBuilder.append("Operation not supported by generator of type ")));
  }
  
  public final void _throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  public abstract void _verifyValueWrite(String paramString)
    throws IOException, JsonGenerationException;
  
  public void _writeSimpleObject(Object paramObject)
    throws IOException, JsonGenerationException
  {
    if (paramObject == null)
    {
      writeNull();
      return;
    }
    if ((paramObject instanceof String))
    {
      writeString((String)paramObject);
      return;
    }
    if ((paramObject instanceof Number))
    {
      localObject = (Number)paramObject;
      if ((localObject instanceof Integer))
      {
        writeNumber(((Number)localObject).intValue());
        return;
      }
      if ((localObject instanceof Long))
      {
        writeNumber(((Number)localObject).longValue());
        return;
      }
      if ((localObject instanceof Double))
      {
        writeNumber(((Number)localObject).doubleValue());
        return;
      }
      if ((localObject instanceof Float))
      {
        writeNumber(((Number)localObject).floatValue());
        return;
      }
      if ((localObject instanceof Short))
      {
        writeNumber(((Number)localObject).shortValue());
        return;
      }
      if ((localObject instanceof Byte))
      {
        writeNumber(((Number)localObject).byteValue());
        return;
      }
      if ((localObject instanceof BigInteger))
      {
        writeNumber((BigInteger)localObject);
        return;
      }
      if ((localObject instanceof BigDecimal))
      {
        writeNumber((BigDecimal)localObject);
        return;
      }
      if ((localObject instanceof AtomicInteger))
      {
        writeNumber(((AtomicInteger)localObject).get());
        return;
      }
      if ((localObject instanceof AtomicLong)) {
        writeNumber(((AtomicLong)localObject).get());
      }
    }
    else
    {
      if ((paramObject instanceof byte[]))
      {
        writeBinary((byte[])paramObject);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        writeBoolean(((Boolean)paramObject).booleanValue());
        return;
      }
      if ((paramObject instanceof AtomicBoolean))
      {
        writeBoolean(((AtomicBoolean)paramObject).get());
        return;
      }
    }
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed ");
    ((StringBuilder)localObject).append(paramObject.getClass().getName());
    ((StringBuilder)localObject).append(")");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void close()
    throws IOException
  {
    _closed = true;
  }
  
  public final void copyCurrentEvent(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == null) {
      _reportError("No current event to copy");
    }
    int i;
    switch (localJsonToken.ordinal())
    {
    default: 
      _cantHappen();
      return;
    case 6: 
      writeObject(paramJsonParser.getEmbeddedObject());
      return;
    case 12: 
      writeNull();
      return;
    case 11: 
      writeBoolean(false);
      return;
    case 10: 
      writeBoolean(true);
      return;
    case 9: 
      i = paramJsonParser.getNumberType().ordinal();
      if (i != 3)
      {
        if (i != 5)
        {
          writeNumber(paramJsonParser.getDoubleValue());
          return;
        }
        writeNumber(paramJsonParser.getDecimalValue());
        return;
      }
      writeNumber(paramJsonParser.getFloatValue());
      return;
    case 8: 
      i = paramJsonParser.getNumberType().ordinal();
      if (i != 0)
      {
        if (i != 2)
        {
          writeNumber(paramJsonParser.getLongValue());
          return;
        }
        writeNumber(paramJsonParser.getBigIntegerValue());
        return;
      }
      writeNumber(paramJsonParser.getIntValue());
      return;
    case 7: 
      if (paramJsonParser.hasTextCharacters())
      {
        writeString(paramJsonParser.getTextCharacters(), paramJsonParser.getTextOffset(), paramJsonParser.getTextLength());
        return;
      }
      writeString(paramJsonParser.getText());
      return;
    case 5: 
      writeFieldName(paramJsonParser.getCurrentName());
      return;
    case 4: 
      writeEndArray();
      return;
    case 3: 
      writeStartArray();
      return;
    case 2: 
      writeEndObject();
      return;
    }
    writeStartObject();
  }
  
  public final void copyCurrentStructure(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken2 = paramJsonParser.getCurrentToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME)
    {
      writeFieldName(paramJsonParser.getCurrentName());
      localJsonToken1 = paramJsonParser.nextToken();
    }
    int i = localJsonToken1.ordinal();
    if (i != 1)
    {
      if (i != 3)
      {
        copyCurrentEvent(paramJsonParser);
        return;
      }
      writeStartArray();
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        copyCurrentStructure(paramJsonParser);
      }
      writeEndArray();
      return;
    }
    writeStartObject();
    while (paramJsonParser.nextToken() != JsonToken.END_OBJECT) {
      copyCurrentStructure(paramJsonParser);
    }
    writeEndObject();
  }
  
  public JsonGenerator disable(JsonGenerator.Feature paramFeature)
  {
    _features &= paramFeature.getMask();
    if (paramFeature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS)
    {
      _cfgNumbersAsStrings = false;
      return this;
    }
    if (paramFeature == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
      setHighestNonEscapedChar(0);
    }
    return this;
  }
  
  public JsonGenerator enable(JsonGenerator.Feature paramFeature)
  {
    _features |= paramFeature.getMask();
    if (paramFeature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS)
    {
      _cfgNumbersAsStrings = true;
      return this;
    }
    if (paramFeature == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
      setHighestNonEscapedChar(127);
    }
    return this;
  }
  
  public abstract void flush()
    throws IOException;
  
  public final ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public final JsonWriteContext getOutputContext()
  {
    return _writeContext;
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  public final boolean isEnabled(JsonGenerator.Feature paramFeature)
  {
    int i = _features;
    return (paramFeature.getMask() & i) != 0;
  }
  
  public JsonGenerator setCodec(ObjectCodec paramObjectCodec)
  {
    _objectCodec = paramObjectCodec;
    return this;
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    if (getPrettyPrinter() != null) {
      return this;
    }
    return setPrettyPrinter(new DefaultPrettyPrinter(DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public int writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, int paramInt)
    throws IOException, JsonGenerationException
  {
    _reportUnsupportedOperation();
    return 0;
  }
  
  public void writeFieldName(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    writeFieldName(paramSerializableString.getValue());
  }
  
  public void writeObject(Object paramObject)
    throws IOException, JsonProcessingException
  {
    if (paramObject == null)
    {
      writeNull();
      return;
    }
    ObjectCodec localObjectCodec = _objectCodec;
    if (localObjectCodec != null)
    {
      localObjectCodec.writeValue(this, paramObject);
      return;
    }
    _writeSimpleObject(paramObject);
  }
  
  public void writeRawValue(String paramString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramString);
  }
  
  public void writeRawValue(String paramString, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramString, paramInt1, paramInt2);
  }
  
  public void writeRawValue(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void writeString(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    writeString(paramSerializableString.getValue());
  }
  
  public void writeTree(TreeNode paramTreeNode)
    throws IOException, JsonProcessingException
  {
    if (paramTreeNode == null)
    {
      writeNull();
      return;
    }
    ObjectCodec localObjectCodec = _objectCodec;
    if (localObjectCodec != null)
    {
      localObjectCodec.writeValue(this, paramTreeNode);
      return;
    }
    throw new IllegalStateException("No ObjectCodec defined for the generator, can not serialize JsonNode-based trees");
  }
}
