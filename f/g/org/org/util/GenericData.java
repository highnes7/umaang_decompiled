package f.g.org.org.util;

import f.g.b.a.g.w.c;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericData
  extends AbstractMap<String, Object>
  implements Cloneable
{
  public final ClassInfo classInfo;
  public Map<String, Object> unknownFields = new ArrayMap();
  
  public GenericData()
  {
    this(EnumSet.noneOf(w.c.class));
  }
  
  public GenericData(EnumSet paramEnumSet)
  {
    classInfo = ClassInfo.of(getClass(), paramEnumSet.contains(PubSubElementType.CREATE));
  }
  
  public GenericData clone()
  {
    try
    {
      Object localObject1 = super.clone();
      localObject1 = (GenericData)localObject1;
      Data.deepCopy(this, localObject1);
      Object localObject2 = unknownFields;
      localObject2 = Data.clone(localObject2);
      unknownFields = ((Map)localObject2);
      return localObject1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException(localCloneNotSupportedException);
    }
  }
  
  public GenericData clone(String paramString, Object paramObject)
  {
    Object localObject = classInfo.getFieldInfo(paramString);
    if (localObject != null)
    {
      ((FieldInfo)localObject).setValue(this, paramObject);
      return this;
    }
    localObject = paramString;
    if (classInfo.getIgnoreCase()) {
      localObject = paramString.toLowerCase();
    }
    unknownFields.put(localObject, paramObject);
    return this;
  }
  
  public Set entrySet()
  {
    return new EntrySet();
  }
  
  public final Object get(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return null;
    }
    String str = (String)paramObject;
    paramObject = classInfo.getFieldInfo(str);
    if (paramObject != null) {
      return paramObject.getValue(this);
    }
    paramObject = str;
    if (classInfo.getIgnoreCase()) {
      paramObject = str.toLowerCase();
    }
    return unknownFields.get(paramObject);
  }
  
  public final ClassInfo getClassInfo()
  {
    return classInfo;
  }
  
  public final Map getUnknownKeys()
  {
    return unknownFields;
  }
  
  public final Object put(String paramString, Object paramObject)
  {
    Object localObject = classInfo.getFieldInfo(paramString);
    if (localObject != null)
    {
      paramString = ((FieldInfo)localObject).getValue(this);
      ((FieldInfo)localObject).setValue(this, paramObject);
      return paramString;
    }
    localObject = paramString;
    if (classInfo.getIgnoreCase()) {
      localObject = paramString.toLowerCase();
    }
    return unknownFields.put(localObject, paramObject);
  }
  
  public final void putAll(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      clone((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final Object remove(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return null;
    }
    String str = (String)paramObject;
    if (classInfo.getFieldInfo(str) == null)
    {
      paramObject = str;
      if (classInfo.getIgnoreCase()) {
        paramObject = str.toLowerCase();
      }
      return unknownFields.remove(paramObject);
    }
    throw new UnsupportedOperationException();
  }
  
  public final void setUnknownKeys(Map paramMap)
  {
    unknownFields = paramMap;
  }
  
  public final class EntrySet
    extends AbstractSet<Map.Entry<String, Object>>
  {
    public final DataMap.EntrySet dataEntrySet = new DataMap(GenericData.this, classInfo.getIgnoreCase()).entrySet();
    
    public EntrySet() {}
    
    public void clear()
    {
      unknownFields.clear();
      dataEntrySet.clear();
    }
    
    public Iterator iterator()
    {
      return new LinkedHashMultimap.SetDecorator.1(GenericData.this, dataEntrySet);
    }
    
    public int size()
    {
      int i = unknownFields.size();
      return dataEntrySet.size() + i;
    }
  }
}
