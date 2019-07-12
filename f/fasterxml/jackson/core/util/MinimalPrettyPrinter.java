package f.fasterxml.jackson.core.util;

import f.fasterxml.jackson.core.JsonGenerationException;
import f.fasterxml.jackson.core.JsonGenerator;
import f.fasterxml.jackson.core.PrettyPrinter;
import java.io.IOException;
import java.io.Serializable;

public class MinimalPrettyPrinter
  implements PrettyPrinter, Serializable
{
  public static final String DEFAULT_ROOT_VALUE_SEPARATOR = " ";
  public static final long serialVersionUID = -562765100295218442L;
  public String _rootValueSeparator = " ";
  
  public MinimalPrettyPrinter()
  {
    _rootValueSeparator = " ";
  }
  
  public MinimalPrettyPrinter(String paramString)
  {
    _rootValueSeparator = paramString;
  }
  
  public void beforeArrayValues(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {}
  
  public void beforeObjectEntries(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {}
  
  public void setRootValueSeparator(String paramString)
  {
    _rootValueSeparator = paramString;
  }
  
  public void writeArrayValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(',');
  }
  
  public void writeEndArray(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(']');
  }
  
  public void writeEndObject(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw('}');
  }
  
  public void writeObjectEntrySeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(',');
  }
  
  public void writeObjectFieldValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(':');
  }
  
  public void writeRootValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    String str = _rootValueSeparator;
    if (str != null) {
      paramJsonGenerator.writeRaw(str);
    }
  }
  
  public void writeStartArray(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw('[');
  }
  
  public void writeStartObject(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw('{');
  }
}
