package f.fasterxml.jackson.core.jsonschema;

public abstract class ObjectNode
{
  public ObjectNode() {}
  
  public abstract boolean _childrenEqual();
  
  public abstract ObjectNode deepCopy();
  
  public abstract boolean equals();
  
  public abstract String findValue(int paramInt);
  
  public abstract Class findValuesAsText();
  
  public abstract boolean get();
  
  public abstract boolean get(Class paramClass);
  
  public abstract boolean isEmpty();
  
  public abstract boolean isObject();
  
  public abstract ObjectNode put(int paramInt);
  
  public abstract boolean put();
  
  public abstract boolean putAll();
  
  public abstract String putNull();
  
  public abstract boolean remove();
  
  public abstract boolean removeAll();
  
  public abstract boolean replace();
  
  public abstract boolean serialize();
  
  public abstract boolean set();
  
  public abstract int size();
  
  public abstract ObjectNode without();
}
