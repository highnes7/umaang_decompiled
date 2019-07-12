package f.fasterxml.jackson.core;

import f.fasterxml.jackson.core.jsonschema.ObjectNode;
import f.fasterxml.jackson.core.jsonschema.TypeReference;
import java.io.IOException;
import java.util.Iterator;

public abstract class ObjectCodec
{
  public ObjectCodec() {}
  
  public abstract TreeNode createArrayNode();
  
  public JsonFactory getFactory()
  {
    return getJsonFactory();
  }
  
  public abstract JsonFactory getJsonFactory();
  
  public abstract TreeNode readTree();
  
  public abstract TreeNode readTree(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException;
  
  public abstract Object readValue(JsonParser paramJsonParser, ObjectNode paramObjectNode)
    throws IOException, JsonProcessingException;
  
  public abstract Object readValue(JsonParser paramJsonParser, TypeReference paramTypeReference)
    throws IOException, JsonProcessingException;
  
  public abstract Object readValue(JsonParser paramJsonParser, Class paramClass)
    throws IOException, JsonProcessingException;
  
  public abstract Iterator readValues(JsonParser paramJsonParser, ObjectNode paramObjectNode)
    throws IOException, JsonProcessingException;
  
  public abstract Iterator readValues(JsonParser paramJsonParser, TypeReference paramTypeReference)
    throws IOException, JsonProcessingException;
  
  public abstract Iterator readValues(JsonParser paramJsonParser, Class paramClass)
    throws IOException, JsonProcessingException;
  
  public abstract JsonParser treeAsTokens(TreeNode paramTreeNode);
  
  public abstract Object treeToValue(TreeNode paramTreeNode, Class paramClass)
    throws JsonProcessingException;
  
  public abstract void writeValue(JsonGenerator paramJsonGenerator, Object paramObject)
    throws IOException, JsonProcessingException;
}
