package f.g.org.org.stream.util;

import f.g.org.org.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonParserDelegate
  extends f.g.org.org.stream.JsonParser
{
  public final JsonFactory _jsonFactory;
  public final f.fasterxml.jackson.core.JsonParser delegate;
  
  public JsonParserDelegate(JsonFactory paramJsonFactory, f.fasterxml.jackson.core.JsonParser paramJsonParser)
  {
    _jsonFactory = paramJsonFactory;
    delegate = paramJsonParser;
  }
  
  public void close()
    throws IOException
  {
    delegate.close();
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    return delegate.getBigIntegerValue();
  }
  
  public byte getByteValue()
    throws IOException
  {
    return delegate.getByteValue();
  }
  
  public String getCurrentName()
    throws IOException
  {
    return delegate.getCurrentName();
  }
  
  public JsonToken getCurrentToken()
  {
    return JsonFactory.convert(delegate.getCurrentToken());
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    return delegate.getDecimalValue();
  }
  
  public double getDoubleValue()
    throws IOException
  {
    return delegate.getDoubleValue();
  }
  
  public JsonFactory getFactory()
  {
    return _jsonFactory;
  }
  
  public float getFloatValue()
    throws IOException
  {
    return delegate.getFloatValue();
  }
  
  public int getIntValue()
    throws IOException
  {
    return delegate.getIntValue();
  }
  
  public long getLongValue()
    throws IOException
  {
    return delegate.getLongValue();
  }
  
  public short getShortValue()
    throws IOException
  {
    return delegate.getShortValue();
  }
  
  public String getText()
    throws IOException
  {
    return delegate.getText();
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    return JsonFactory.convert(delegate.nextToken());
  }
  
  public f.g.org.org.stream.JsonParser skipChildren()
    throws IOException
  {
    delegate.skipChildren();
    return this;
  }
}
