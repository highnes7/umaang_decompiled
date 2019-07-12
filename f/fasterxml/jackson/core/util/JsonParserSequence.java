package f.fasterxml.jackson.core.util;

import f.fasterxml.jackson.core.JsonParseException;
import f.fasterxml.jackson.core.JsonParser;
import f.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParserSequence
  extends JsonParserDelegate
{
  public int _nextParser;
  public final JsonParser[] _parsers;
  
  public JsonParserSequence(JsonParser[] paramArrayOfJsonParser)
  {
    super(paramArrayOfJsonParser[0]);
    _parsers = paramArrayOfJsonParser;
    _nextParser = 1;
  }
  
  public static JsonParserSequence createFlattened(JsonParser paramJsonParser1, JsonParser paramJsonParser2)
  {
    boolean bool = paramJsonParser1 instanceof JsonParserSequence;
    if ((!bool) && (!(paramJsonParser2 instanceof JsonParserSequence))) {
      return new JsonParserSequence(new JsonParser[] { paramJsonParser1, paramJsonParser2 });
    }
    ArrayList localArrayList = new ArrayList();
    if (bool) {
      ((JsonParserSequence)paramJsonParser1).addFlattenedActiveParsers(localArrayList);
    } else {
      localArrayList.add(paramJsonParser1);
    }
    if ((paramJsonParser2 instanceof JsonParserSequence)) {
      ((JsonParserSequence)paramJsonParser2).addFlattenedActiveParsers(localArrayList);
    } else {
      localArrayList.add(paramJsonParser2);
    }
    return new JsonParserSequence((JsonParser[])localArrayList.toArray(new JsonParser[localArrayList.size()]));
  }
  
  public void addFlattenedActiveParsers(List paramList)
  {
    int i = _nextParser - 1;
    int j = _parsers.length;
    while (i < j)
    {
      JsonParser localJsonParser = _parsers[i];
      if ((localJsonParser instanceof JsonParserSequence)) {
        ((JsonParserSequence)localJsonParser).addFlattenedActiveParsers(paramList);
      } else {
        paramList.add(localJsonParser);
      }
      i += 1;
    }
  }
  
  public void close()
    throws IOException
  {
    do
    {
      delegate.close();
    } while (switchToNext());
  }
  
  public int containedParsersCount()
  {
    return _parsers.length;
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = delegate.nextToken();
    if (localJsonToken != null) {
      return localJsonToken;
    }
    while (switchToNext())
    {
      localJsonToken = delegate.nextToken();
      if (localJsonToken != null) {
        return localJsonToken;
      }
    }
    return null;
  }
  
  public boolean switchToNext()
  {
    int i = _nextParser;
    JsonParser[] arrayOfJsonParser = _parsers;
    if (i >= arrayOfJsonParser.length) {
      return false;
    }
    _nextParser = (i + 1);
    delegate = arrayOfJsonParser[i];
    return true;
  }
}
