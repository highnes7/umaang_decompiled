package f.g.org.org.apache.util;

import f.g.b.a.g.h;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonParser;
import f.g.org.org.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@h
public class MockJsonParser
  extends JsonParser
{
  public final JsonFactory factory;
  public boolean isClosed;
  
  public MockJsonParser(JsonFactory paramJsonFactory)
  {
    factory = paramJsonFactory;
  }
  
  public void close()
    throws IOException
  {
    isClosed = true;
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    return null;
  }
  
  public byte getByteValue()
    throws IOException
  {
    return 0;
  }
  
  public String getCurrentName()
    throws IOException
  {
    return null;
  }
  
  public JsonToken getCurrentToken()
  {
    return null;
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    return null;
  }
  
  public double getDoubleValue()
    throws IOException
  {
    return 0.0D;
  }
  
  public JsonFactory getFactory()
  {
    return factory;
  }
  
  public float getFloatValue()
    throws IOException
  {
    return 0.0F;
  }
  
  public int getIntValue()
    throws IOException
  {
    return 0;
  }
  
  public long getLongValue()
    throws IOException
  {
    return 0L;
  }
  
  public short getShortValue()
    throws IOException
  {
    return 0;
  }
  
  public String getText()
    throws IOException
  {
    return null;
  }
  
  public boolean isClosed()
  {
    return isClosed;
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    return null;
  }
  
  public JsonParser skipChildren()
    throws IOException
  {
    return null;
  }
}
