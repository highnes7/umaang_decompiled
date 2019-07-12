package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public final class DataMap
  extends AbstractMap<String, Object>
{
  public final ClassInfo classInfo;
  public final Object object;
  
  public DataMap(Object paramObject, boolean paramBoolean)
  {
    object = paramObject;
    classInfo = ClassInfo.of(paramObject.getClass(), paramBoolean);
    Preconditions.append(classInfo.isEnum() ^ true);
  }
  
  public boolean containsKey(Object paramObject)
  {
    return get(paramObject) != null;
  }
  
  public EntrySet entrySet()
  {
    return new EntrySet();
  }
  
  public Object get(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return null;
    }
    paramObject = classInfo.getFieldInfo((String)paramObject);
    if (paramObject == null) {
      return null;
    }
    return paramObject.getValue(object);
  }
  
  public Object put(String paramString, Object paramObject)
  {
    FieldInfo localFieldInfo = classInfo.getFieldInfo(paramString);
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "no field of key ".concat(paramString);
    } else {
      paramString = new String("no field of key ");
    }
    Preconditions.checkNotNull(localFieldInfo, paramString);
    paramString = localFieldInfo.getValue(object);
    Object localObject = object;
    if (paramObject != null)
    {
      localFieldInfo.setValue(localObject, paramObject);
      return paramString;
    }
    throw new NullPointerException();
  }
  
  public final class EntryIterator
    implements Iterator<Map.Entry<String, Object>>
  {
    public FieldInfo currentFieldInfo;
    public boolean isComputed;
    public boolean isRemoved;
    public FieldInfo nextFieldInfo;
    public Object nextFieldValue;
    public int nextKeyIndex = -1;
    
    public EntryIterator() {}
    
    public boolean hasNext()
    {
      if (!isComputed)
      {
        isComputed = true;
        for (nextFieldValue = null; nextFieldValue == null; nextFieldValue = nextFieldInfo.getValue(object))
        {
          int i = nextKeyIndex + 1;
          nextKeyIndex = i;
          if (i >= classInfo.names.size()) {
            break;
          }
          ClassInfo localClassInfo = classInfo;
          nextFieldInfo = localClassInfo.getFieldInfo((String)names.get(nextKeyIndex));
        }
      }
      return nextFieldValue != null;
    }
    
    public Map.Entry next()
    {
      if (hasNext())
      {
        currentFieldInfo = nextFieldInfo;
        Object localObject = nextFieldValue;
        isComputed = false;
        isRemoved = false;
        nextFieldInfo = null;
        nextFieldValue = null;
        return new TByteLongMapDecorator.1.1.1(DataMap.this, currentFieldInfo, localObject);
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      boolean bool;
      if ((currentFieldInfo != null) && (!isRemoved)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.set(bool);
      isRemoved = true;
      currentFieldInfo.setValue(object, null);
    }
  }
  
  public final class EntrySet
    extends AbstractSet<Map.Entry<String, Object>>
  {
    public EntrySet() {}
    
    public void clear()
    {
      Iterator localIterator = classInfo.names.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        classInfo.getFieldInfo(str).setValue(object, null);
      }
    }
    
    public boolean isEmpty()
    {
      Iterator localIterator = classInfo.names.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (classInfo.getFieldInfo(str).getValue(object) != null) {
          return false;
        }
      }
      return true;
    }
    
    public DataMap.EntryIterator iterator()
    {
      return new DataMap.EntryIterator(DataMap.this);
    }
    
    public int size()
    {
      Iterator localIterator = classInfo.names.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (classInfo.getFieldInfo(str).getValue(object) != null) {
          i += 1;
        }
      }
      return i;
    }
  }
}
