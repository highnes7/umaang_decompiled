package f.g.org.org.apache.util;

import f.g.b.a.g.h;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@h
public class MockJsonGenerator
  extends JsonGenerator
{
  public final JsonFactory factory;
  
  public MockJsonGenerator(JsonFactory paramJsonFactory)
  {
    factory = paramJsonFactory;
  }
  
  public void close()
    throws IOException
  {}
  
  public void flush()
    throws IOException
  {}
  
  public JsonFactory getFactory()
  {
    return factory;
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {}
  
  public void writeEndArray()
    throws IOException
  {}
  
  public void writeEndObject()
    throws IOException
  {}
  
  public void writeFieldName(String paramString)
    throws IOException
  {}
  
  public void writeNull()
    throws IOException
  {}
  
  public void writeNumber(double paramDouble)
    throws IOException
  {}
  
  public void writeNumber(float paramFloat)
    throws IOException
  {}
  
  public void writeNumber(int paramInt)
    throws IOException
  {}
  
  public void writeNumber(long paramLong)
    throws IOException
  {}
  
  public void writeNumber(String paramString)
    throws IOException
  {}
  
  public void writeNumber(BigDecimal paramBigDecimal)
    throws IOException
  {}
  
  public void writeNumber(BigInteger paramBigInteger)
    throws IOException
  {}
  
  public void writeStartArray()
    throws IOException
  {}
  
  public void writeStartObject()
    throws IOException
  {}
  
  public void writeString(String paramString)
    throws IOException
  {}
}
