package f.fasterxml.jackson.core.format;

import f.fasterxml.jackson.core.JsonFactory;
import f.fasterxml.jackson.core.JsonParser;
import f.fasterxml.jackson.core.impl.MergedStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataFormatMatcher
{
  public final byte[] _bufferedData;
  public final int _bufferedLength;
  public final int _bufferedStart;
  public final JsonFactory _match;
  public final MatchStrength _matchStrength;
  public final InputStream _originalStream;
  
  public DataFormatMatcher(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, JsonFactory paramJsonFactory, MatchStrength paramMatchStrength)
  {
    _originalStream = paramInputStream;
    _bufferedData = paramArrayOfByte;
    _bufferedStart = paramInt1;
    _bufferedLength = paramInt2;
    _match = paramJsonFactory;
    _matchStrength = paramMatchStrength;
  }
  
  public JsonParser createParserWithMatch()
    throws IOException
  {
    JsonFactory localJsonFactory = _match;
    if (localJsonFactory == null) {
      return null;
    }
    if (_originalStream == null) {
      return localJsonFactory.createParser(_bufferedData, _bufferedStart, _bufferedLength);
    }
    return localJsonFactory.createJsonParser(getDataStream());
  }
  
  public InputStream getDataStream()
  {
    InputStream localInputStream = _originalStream;
    if (localInputStream == null) {
      return new ByteArrayInputStream(_bufferedData, _bufferedStart, _bufferedLength);
    }
    return new MergedStream(null, localInputStream, _bufferedData, _bufferedStart, _bufferedLength);
  }
  
  public JsonFactory getMatch()
  {
    return _match;
  }
  
  public MatchStrength getMatchStrength()
  {
    MatchStrength localMatchStrength2 = _matchStrength;
    MatchStrength localMatchStrength1 = localMatchStrength2;
    if (localMatchStrength2 == null) {
      localMatchStrength1 = MatchStrength.INCONCLUSIVE;
    }
    return localMatchStrength1;
  }
  
  public String getMatchedFormatName()
  {
    return _match.getFormatName();
  }
  
  public boolean hasMatch()
  {
    return _match != null;
  }
}
