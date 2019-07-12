package f.fasterxml.jackson.core.json;

import f.fasterxml.jackson.core.JsonLocation;
import f.fasterxml.jackson.core.JsonStreamContext;
import f.fasterxml.jackson.core.impl.Utf8StreamParser;

public final class JsonReadContext
  extends JsonStreamContext
{
  public JsonReadContext _child = null;
  public int _columnNr;
  public String _currentName;
  public int _lineNr;
  public final JsonReadContext _parent;
  
  public JsonReadContext(JsonReadContext paramJsonReadContext, int paramInt1, int paramInt2, int paramInt3)
  {
    _type = paramInt1;
    _parent = paramJsonReadContext;
    _lineNr = paramInt2;
    _columnNr = paramInt3;
    _index = -1;
  }
  
  public static JsonReadContext createRootContext()
  {
    return new JsonReadContext(null, 0, 1, 0);
  }
  
  public static JsonReadContext createRootContext(int paramInt1, int paramInt2)
  {
    return new JsonReadContext(null, 0, paramInt1, paramInt2);
  }
  
  public JsonReadContext createChildArrayContext(int paramInt1, int paramInt2)
  {
    JsonReadContext localJsonReadContext = _child;
    if (localJsonReadContext == null)
    {
      localJsonReadContext = new JsonReadContext(this, 1, paramInt1, paramInt2);
      _child = localJsonReadContext;
      return localJsonReadContext;
    }
    localJsonReadContext.reset(1, paramInt1, paramInt2);
    return localJsonReadContext;
  }
  
  public JsonReadContext createChildObjectContext(int paramInt1, int paramInt2)
  {
    JsonReadContext localJsonReadContext = _child;
    if (localJsonReadContext == null)
    {
      localJsonReadContext = new JsonReadContext(this, 2, paramInt1, paramInt2);
      _child = localJsonReadContext;
      return localJsonReadContext;
    }
    localJsonReadContext.reset(2, paramInt1, paramInt2);
    return localJsonReadContext;
  }
  
  public boolean expectComma()
  {
    int i = _index + 1;
    _index = i;
    return (_type != 0) && (i > 0);
  }
  
  public String getCurrentName()
  {
    return _currentName;
  }
  
  public JsonReadContext getParent()
  {
    return _parent;
  }
  
  public JsonLocation getStartLocation(Object paramObject)
  {
    return new JsonLocation(paramObject, -1L, _lineNr, _columnNr);
  }
  
  public void reset(int paramInt1, int paramInt2, int paramInt3)
  {
    _type = paramInt1;
    _index = -1;
    _lineNr = paramInt2;
    _columnNr = paramInt3;
    _currentName = null;
  }
  
  public void setCurrentName(String paramString)
  {
    _currentName = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    int i = _type;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localStringBuilder.append('{');
          if (_currentName != null)
          {
            localStringBuilder.append('"');
            Utf8StreamParser.appendQuoted(localStringBuilder, _currentName);
            localStringBuilder.append('"');
          }
          else
          {
            localStringBuilder.append('?');
          }
          localStringBuilder.append('}');
        }
      }
      else
      {
        localStringBuilder.append('[');
        localStringBuilder.append(getCurrentIndex());
        localStringBuilder.append(']');
      }
    }
    else {
      localStringBuilder.append("/");
    }
    return localStringBuilder.toString();
  }
}
