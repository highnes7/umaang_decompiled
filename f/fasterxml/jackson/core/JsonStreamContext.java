package f.fasterxml.jackson.core;

public abstract class JsonStreamContext
{
  public static final int TYPE_ARRAY = 1;
  public static final int TYPE_OBJECT = 2;
  public static final int TYPE_ROOT = 0;
  public int _index;
  public int _type;
  
  public JsonStreamContext() {}
  
  public final int getCurrentIndex()
  {
    int i = _index;
    if (i < 0) {
      return 0;
    }
    return i;
  }
  
  public abstract String getCurrentName();
  
  public final int getEntryCount()
  {
    return _index + 1;
  }
  
  public abstract JsonStreamContext getParent();
  
  public final String getTypeDesc()
  {
    int i = _type;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return "?";
        }
        return "OBJECT";
      }
      return "ARRAY";
    }
    return "ROOT";
  }
  
  public final boolean inArray()
  {
    return _type == 1;
  }
  
  public final boolean inObject()
  {
    return _type == 2;
  }
  
  public final boolean inRoot()
  {
    return _type == 0;
  }
}
