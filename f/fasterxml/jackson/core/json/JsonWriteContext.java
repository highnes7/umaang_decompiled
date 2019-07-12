package f.fasterxml.jackson.core.json;

import f.fasterxml.jackson.core.JsonStreamContext;

public class JsonWriteContext
  extends JsonStreamContext
{
  public static final int STATUS_EXPECT_NAME = 5;
  public static final int STATUS_EXPECT_VALUE = 4;
  public static final int STATUS_OK_AFTER_COLON = 2;
  public static final int STATUS_OK_AFTER_COMMA = 1;
  public static final int STATUS_OK_AFTER_SPACE = 3;
  public static final int STATUS_OK_AS_IS = 0;
  public JsonWriteContext _child = null;
  public String _currentName;
  public final JsonWriteContext _parent;
  
  public JsonWriteContext(int paramInt, JsonWriteContext paramJsonWriteContext)
  {
    _type = paramInt;
    _parent = paramJsonWriteContext;
    _index = -1;
  }
  
  public static JsonWriteContext createRootContext()
  {
    return new JsonWriteContext(0, null);
  }
  
  private JsonWriteContext reset(int paramInt)
  {
    _type = paramInt;
    _index = -1;
    _currentName = null;
    return this;
  }
  
  public final void appendDesc(StringBuilder paramStringBuilder)
  {
    int i = _type;
    if (i == 2)
    {
      paramStringBuilder.append('{');
      if (_currentName != null)
      {
        paramStringBuilder.append('"');
        paramStringBuilder.append(_currentName);
        paramStringBuilder.append('"');
      }
      else
      {
        paramStringBuilder.append('?');
      }
      paramStringBuilder.append('}');
      return;
    }
    if (i == 1)
    {
      paramStringBuilder.append('[');
      paramStringBuilder.append(getCurrentIndex());
      paramStringBuilder.append(']');
      return;
    }
    paramStringBuilder.append("/");
  }
  
  public final JsonWriteContext createChildArrayContext()
  {
    JsonWriteContext localJsonWriteContext = _child;
    if (localJsonWriteContext == null)
    {
      localJsonWriteContext = new JsonWriteContext(1, this);
      _child = localJsonWriteContext;
      return localJsonWriteContext;
    }
    localJsonWriteContext.reset(1);
    return localJsonWriteContext;
  }
  
  public final JsonWriteContext createChildObjectContext()
  {
    JsonWriteContext localJsonWriteContext = _child;
    if (localJsonWriteContext == null)
    {
      localJsonWriteContext = new JsonWriteContext(2, this);
      _child = localJsonWriteContext;
      return localJsonWriteContext;
    }
    localJsonWriteContext.reset(2);
    return localJsonWriteContext;
  }
  
  public final String getCurrentName()
  {
    return _currentName;
  }
  
  public final JsonWriteContext getParent()
  {
    return _parent;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    appendDesc(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public final int writeFieldName(String paramString)
  {
    if (_type == 2)
    {
      if (_currentName != null) {
        return 4;
      }
      _currentName = paramString;
      if (_index < 0) {
        return 0;
      }
      return 1;
    }
    return 4;
  }
  
  public final int writeValue()
  {
    int i = _type;
    if (i == 2)
    {
      if (_currentName == null) {
        return 5;
      }
      _currentName = null;
      _index += 1;
      return 2;
    }
    if (i == 1)
    {
      i = _index;
      _index = (i + 1);
      if (i < 0) {
        return 0;
      }
      return 1;
    }
    _index += 1;
    if (_index == 0) {
      return 0;
    }
    return 3;
  }
}
