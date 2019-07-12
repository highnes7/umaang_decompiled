package com.facebook.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil
{
  public JsonUtil() {}
  
  public static void jsonObjectClear(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.keys();
    while (paramJSONObject.hasNext())
    {
      paramJSONObject.next();
      paramJSONObject.remove();
    }
  }
  
  public static boolean jsonObjectContainsValue(JSONObject paramJSONObject, Object paramObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject = paramJSONObject.opt((String)localIterator.next());
      if ((localObject != null) && (localObject.equals(paramObject))) {
        return true;
      }
    }
    return false;
  }
  
  public static Set jsonObjectEntrySet(JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashSet.add(new JSONObjectEntry(str, paramJSONObject.opt(str)));
    }
    return localHashSet;
  }
  
  public static Set jsonObjectKeySet(JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    paramJSONObject = paramJSONObject.keys();
    while (paramJSONObject.hasNext()) {
      localHashSet.add(paramJSONObject.next());
    }
    return localHashSet;
  }
  
  public static void jsonObjectPutAll(JSONObject paramJSONObject, Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        Object localObject = localEntry.getKey();
        localObject = (String)localObject;
        paramJSONObject.putOpt((String)localObject, localEntry.getValue());
      }
      catch (JSONException paramJSONObject)
      {
        throw new IllegalArgumentException(paramJSONObject);
      }
    }
  }
  
  public static Collection jsonObjectValues(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext()) {
      localArrayList.add(paramJSONObject.opt((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  private static final class JSONObjectEntry
    implements Map.Entry<String, Object>
  {
    public final String range;
    public final Object value;
    
    public JSONObjectEntry(String paramString, Object paramObject)
    {
      range = paramString;
      value = paramObject;
    }
    
    public String getKey()
    {
      return range;
    }
    
    public Object getValue()
    {
      return value;
    }
    
    public Object setValue(Object paramObject)
    {
      throw new UnsupportedOperationException("JSONObjectEntry is immutable");
    }
  }
}
