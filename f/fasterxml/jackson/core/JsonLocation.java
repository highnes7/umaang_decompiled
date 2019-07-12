package f.fasterxml.jackson.core;

import java.io.Serializable;

public class JsonLocation
  implements Serializable
{
  public static final JsonLocation NA = new JsonLocation("N/A", -1L, -1L, -1, -1);
  public static final long serialVersionUID = 1L;
  public final int _columnNr;
  public final int _lineNr;
  public final Object _sourceRef;
  public final long _totalBytes;
  public final long _totalChars;
  
  public JsonLocation(Object paramObject, long paramLong, int paramInt1, int paramInt2)
  {
    _sourceRef = paramObject;
    _totalBytes = -1L;
    _totalChars = paramLong;
    _lineNr = paramInt1;
    _columnNr = paramInt2;
  }
  
  public JsonLocation(Object paramObject, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    _sourceRef = paramObject;
    _totalBytes = paramLong1;
    _totalChars = paramLong2;
    _lineNr = paramInt1;
    _columnNr = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof JsonLocation)) {
      return false;
    }
    paramObject = (JsonLocation)paramObject;
    Object localObject = _sourceRef;
    if (localObject == null)
    {
      if (_sourceRef != null) {
        return false;
      }
    }
    else if (!localObject.equals(_sourceRef)) {
      return false;
    }
    return (_lineNr == _lineNr) && (_columnNr == _columnNr) && (_totalChars == _totalChars) && (getByteOffset() == paramObject.getByteOffset());
  }
  
  public long getByteOffset()
  {
    return _totalBytes;
  }
  
  public long getCharOffset()
  {
    return _totalChars;
  }
  
  public int getColumnNr()
  {
    return _columnNr;
  }
  
  public int getLineNr()
  {
    return _lineNr;
  }
  
  public Object getSourceRef()
  {
    return _sourceRef;
  }
  
  public int hashCode()
  {
    Object localObject = _sourceRef;
    int i;
    if (localObject == null) {
      i = 1;
    } else {
      i = localObject.hashCode();
    }
    return ((i ^ _lineNr) + _columnNr ^ (int)_totalChars) + (int)_totalBytes;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[Source: ");
    Object localObject = _sourceRef;
    if (localObject == null) {
      localStringBuilder.append("UNKNOWN");
    } else {
      localStringBuilder.append(localObject.toString());
    }
    localStringBuilder.append("; line: ");
    localStringBuilder.append(_lineNr);
    localStringBuilder.append(", column: ");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, _columnNr, ']');
  }
}
