package f.g.org.org.util;

import f.g.b.a.g.b.a;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ArrayValueMap
{
  public final Object destination;
  public final Map<Field, b.a> fieldMap = new ArrayMap();
  public final Map<String, b.a> keyMap = new ArrayMap();
  
  public ArrayValueMap(Object paramObject)
  {
    destination = paramObject;
  }
  
  public void put(String paramString, Class paramClass, Object paramObject)
  {
    ArrayValue localArrayValue2 = (ArrayValue)keyMap.get(paramString);
    ArrayValue localArrayValue1 = localArrayValue2;
    if (localArrayValue2 == null)
    {
      localArrayValue1 = new ArrayValue(paramClass);
      keyMap.put(paramString, localArrayValue1);
    }
    localArrayValue1.addValue(paramClass, paramObject);
  }
  
  public void put(Field paramField, Class paramClass, Object paramObject)
  {
    ArrayValue localArrayValue2 = (ArrayValue)fieldMap.get(paramField);
    ArrayValue localArrayValue1 = localArrayValue2;
    if (localArrayValue2 == null)
    {
      localArrayValue1 = new ArrayValue(paramClass);
      fieldMap.put(paramField, localArrayValue1);
    }
    localArrayValue1.addValue(paramClass, paramObject);
  }
  
  public void setValues()
  {
    Iterator localIterator = keyMap.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      ((Map)destination).put(localEntry.getKey(), ((ArrayValue)localEntry.getValue()).toArray());
    }
    localIterator = fieldMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      FieldInfo.setFieldValue((Field)localEntry.getKey(), destination, ((ArrayValue)localEntry.getValue()).toArray());
    }
  }
  
  public class ArrayValue
  {
    public final ArrayList<Object> values = new ArrayList();
    
    public ArrayValue() {}
    
    public void addValue(Class paramClass, Object paramObject)
    {
      boolean bool;
      if (paramClass == ArrayValueMap.this) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.append(bool);
      values.add(paramObject);
    }
    
    public Object toArray()
    {
      return Types.toArray(values, ArrayValueMap.this);
    }
  }
}
