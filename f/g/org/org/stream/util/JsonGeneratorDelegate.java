package f.g.org.org.stream.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonGeneratorDelegate
  extends f.g.org.org.stream.JsonGenerator
{
  public final JsonFactory _jsonFactory;
  public final f.fasterxml.jackson.core.JsonGenerator delegate;
  
  public JsonGeneratorDelegate(JsonFactory paramJsonFactory, f.fasterxml.jackson.core.JsonGenerator paramJsonGenerator)
  {
    _jsonFactory = paramJsonFactory;
    delegate = paramJsonGenerator;
  }
  
  public void close()
    throws IOException
  {
    delegate.close();
  }
  
  public void flush()
    throws IOException
  {
    delegate.flush();
  }
  
  public JsonFactory getFactory()
  {
    return _jsonFactory;
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    delegate.writeBoolean(paramBoolean);
  }
  
  public void writeEndArray()
    throws IOException
  {
    delegate.writeEndArray();
  }
  
  public void writeEndObject()
    throws IOException
  {
    delegate.writeEndObject();
  }
  
  public void writeFieldName()
    throws IOException
  {
    delegate.useDefaultPrettyPrinter();
  }
  
  public void writeFieldName(String paramString)
    throws IOException
  {
    delegate.writeFieldName(paramString);
  }
  
  public void writeNull()
    throws IOException
  {
    delegate.writeNull();
  }
  
  public void writeNumber(double paramDouble)
    throws IOException
  {
    delegate.writeNumber(paramDouble);
  }
  
  public void writeNumber(float paramFloat)
    throws IOException
  {
    delegate.writeNumber(paramFloat);
  }
  
  public void writeNumber(int paramInt)
    throws IOException
  {
    delegate.writeNumber(paramInt);
  }
  
  public void writeNumber(long paramLong)
    throws IOException
  {
    delegate.writeNumber(paramLong);
  }
  
  public void writeNumber(String paramString)
    throws IOException
  {
    delegate.writeNumber(paramString);
  }
  
  public void writeNumber(BigDecimal paramBigDecimal)
    throws IOException
  {
    delegate.writeNumber(paramBigDecimal);
  }
  
  public void writeNumber(BigInteger paramBigInteger)
    throws IOException
  {
    delegate.writeNumber(paramBigInteger);
  }
  
  public void writeStartArray()
    throws IOException
  {
    delegate.writeStartArray();
  }
  
  public void writeStartObject()
    throws IOException
  {
    delegate.writeStartObject();
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    delegate.writeString(paramString);
  }
}
