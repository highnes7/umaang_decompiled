package org.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class JSONObject
{
  public static final Object NULL = new JSONObject.Null(null);
  public Map map = new HashMap();
  
  public JSONObject() {}
  
  public JSONObject(Object paramObject)
  {
    this();
    populateInternalMap(paramObject, false);
  }
  
  public JSONObject(Object paramObject, boolean paramBoolean)
  {
    this();
    populateInternalMap(paramObject, paramBoolean);
  }
  
  public JSONObject(Object paramObject, String[] paramArrayOfString)
  {
    this();
    Class localClass = paramObject.getClass();
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfString.length) {
        return;
      }
      String str = paramArrayOfString[i];
      try
      {
        putOpt(str, localClass.getField(str).get(paramObject));
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public JSONObject(String paramString)
    throws JSONException
  {
    this(new JSONTokener(paramString));
  }
  
  public JSONObject(Map paramMap) {}
  
  public JSONObject(Map paramMap, boolean paramBoolean)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      for (;;)
      {
        if (!paramMap.hasNext()) {
          return;
        }
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (isStandardProperty(localEntry.getValue().getClass())) {
          map.put(localEntry.getKey(), localEntry.getValue());
        } else {
          map.put(localEntry.getKey(), new JSONObject(localEntry.getValue(), paramBoolean));
        }
      }
    }
  }
  
  public JSONObject(JSONObject paramJSONObject, String[] paramArrayOfString)
    throws JSONException
  {
    this();
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfString.length) {
        return;
      }
      putOnce(paramArrayOfString[i], paramJSONObject.opt(paramArrayOfString[i]));
      i += 1;
    }
  }
  
  public JSONObject(JSONTokener paramJSONTokener)
    throws JSONException
  {
    this();
    if (paramJSONTokener.nextClean() == '{')
    {
      for (;;)
      {
        int i = paramJSONTokener.nextClean();
        if (i == 0) {
          break label138;
        }
        if (i == 125) {
          return;
        }
        paramJSONTokener.back();
        String str = paramJSONTokener.nextValue().toString();
        i = paramJSONTokener.nextClean();
        if (i == 61)
        {
          if (paramJSONTokener.next() != '>') {
            paramJSONTokener.back();
          }
        }
        else {
          if (i != 58) {
            break;
          }
        }
        putOnce(str, paramJSONTokener.nextValue());
        i = paramJSONTokener.nextClean();
        if ((i != 44) && (i != 59))
        {
          if (i == 125) {
            return;
          }
          throw paramJSONTokener.syntaxError("Expected a ',' or '}'");
        }
        if (paramJSONTokener.nextClean() == '}') {
          return;
        }
        paramJSONTokener.back();
      }
      throw paramJSONTokener.syntaxError("Expected a ':' after a key");
      label138:
      throw paramJSONTokener.syntaxError("A JSONObject text must end with '}'");
    }
    paramJSONTokener = paramJSONTokener.syntaxError("A JSONObject text must begin with '{'");
    throw paramJSONTokener;
  }
  
  public static String doubleToString(double paramDouble)
  {
    String str2;
    String str1;
    if ((!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble)))
    {
      str2 = Double.toString(paramDouble);
      str1 = str2;
      if (str2.indexOf('.') > 0)
      {
        if ((str2.indexOf('e') < 0) && (str2.indexOf('E') < 0)) {
          for (;;)
          {
            if (!str1.endsWith("0"))
            {
              if (!str1.endsWith(".")) {
                break;
              }
              return f.sufficientlysecure.rootcommands.util.StringBuilder.format(str1, -1, 0);
            }
            str1 = f.sufficientlysecure.rootcommands.util.StringBuilder.format(str1, -1, 0);
          }
        }
      }
      else {
        return str2;
      }
    }
    else
    {
      return "null";
    }
    return str2;
    return str1;
  }
  
  public static String[] getNames(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    paramObject = paramObject.getClass().getFields();
    int j = paramObject.length;
    if (j == 0) {
      return null;
    }
    String[] arrayOfString = new String[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return arrayOfString;
      }
      arrayOfString[i] = paramObject[i].getName();
      i += 1;
    }
  }
  
  public static String[] getNames(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.length();
    if (i == 0) {
      return null;
    }
    paramJSONObject = paramJSONObject.keys();
    String[] arrayOfString = new String[i];
    i = 0;
    for (;;)
    {
      if (!paramJSONObject.hasNext()) {
        return arrayOfString;
      }
      arrayOfString[i] = ((String)paramJSONObject.next());
      i += 1;
    }
  }
  
  public static boolean isStandardProperty(Class paramClass)
  {
    return (paramClass.isPrimitive()) || (paramClass.isAssignableFrom(Byte.class)) || (paramClass.isAssignableFrom(Short.class)) || (paramClass.isAssignableFrom(Integer.class)) || (paramClass.isAssignableFrom(Long.class)) || (paramClass.isAssignableFrom(Float.class)) || (paramClass.isAssignableFrom(Double.class)) || (paramClass.isAssignableFrom(Character.class)) || (paramClass.isAssignableFrom(String.class)) || (paramClass.isAssignableFrom(Boolean.class));
  }
  
  public static String numberToString(Number paramNumber)
    throws JSONException
  {
    String str;
    if (paramNumber != null)
    {
      testValidity(paramNumber);
      str = paramNumber.toString();
      paramNumber = str;
      if (str.indexOf('.') > 0)
      {
        if ((str.indexOf('e') < 0) && (str.indexOf('E') < 0)) {
          for (;;)
          {
            if (!paramNumber.endsWith("0"))
            {
              if (!paramNumber.endsWith(".")) {
                break;
              }
              return f.sufficientlysecure.rootcommands.util.StringBuilder.format(paramNumber, -1, 0);
            }
            paramNumber = f.sufficientlysecure.rootcommands.util.StringBuilder.format(paramNumber, -1, 0);
          }
        }
      }
      else {
        return str;
      }
    }
    else
    {
      paramNumber = new JSONException("Null pointer");
      throw paramNumber;
    }
    return str;
    return paramNumber;
  }
  
  private void populateInternalMap(Object paramObject, boolean paramBoolean)
  {
    Object localObject1 = paramObject.getClass();
    if (((Class)localObject1).getClassLoader() == null) {
      paramBoolean = false;
    }
    Method[] arrayOfMethod;
    if (paramBoolean) {
      arrayOfMethod = ((Class)localObject1).getMethods();
    } else {
      arrayOfMethod = ((Class)localObject1).getDeclaredMethods();
    }
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfMethod.length) {
        return;
      }
      Object localObject3 = arrayOfMethod[i];
      try
      {
        boolean bool = Modifier.isPublic(((Method)localObject3).getModifiers());
        if (bool)
        {
          Object localObject2 = ((Method)localObject3).getName();
          localObject1 = "";
          bool = ((String)localObject2).startsWith("get");
          if (bool)
          {
            localObject1 = ((String)localObject2).substring(3);
          }
          else
          {
            bool = ((String)localObject2).startsWith("is");
            if (bool) {
              localObject1 = ((String)localObject2).substring(2);
            }
          }
          int j = ((String)localObject1).length();
          if (j > 0)
          {
            bool = Character.isUpperCase(((String)localObject1).charAt(0));
            if (bool)
            {
              localObject2 = ((Method)localObject3).getParameterTypes();
              if (localObject2.length == 0)
              {
                j = ((String)localObject1).length();
                if (j == 1)
                {
                  localObject2 = ((String)localObject1).toLowerCase();
                }
                else
                {
                  bool = Character.isUpperCase(((String)localObject1).charAt(1));
                  localObject2 = localObject1;
                  if (!bool)
                  {
                    localObject2 = new StringBuilder(String.valueOf(((String)localObject1).substring(0, 1).toLowerCase()));
                    ((StringBuilder)localObject2).append(((String)localObject1).substring(1));
                    localObject2 = ((StringBuilder)localObject2).toString();
                  }
                }
                localObject1 = ((Method)localObject3).invoke(paramObject, null);
                if (localObject1 == null)
                {
                  localObject1 = map;
                  localObject3 = NULL;
                  ((Map)localObject1).put(localObject2, localObject3);
                }
                else
                {
                  bool = localObject1.getClass().isArray();
                  if (bool)
                  {
                    localObject3 = map;
                    ((Map)localObject3).put(localObject2, new JSONArray(localObject1, paramBoolean));
                  }
                  else if ((localObject1 instanceof Collection))
                  {
                    localObject3 = map;
                    localObject1 = (Collection)localObject1;
                    ((Map)localObject3).put(localObject2, new JSONArray((Collection)localObject1, paramBoolean));
                  }
                  else if ((localObject1 instanceof Map))
                  {
                    localObject3 = map;
                    localObject1 = (Map)localObject1;
                    ((Map)localObject3).put(localObject2, new JSONObject((Map)localObject1, paramBoolean));
                  }
                  else
                  {
                    bool = isStandardProperty(localObject1.getClass());
                    if (bool)
                    {
                      localObject3 = map;
                      ((Map)localObject3).put(localObject2, localObject1);
                    }
                    else
                    {
                      bool = localObject1.getClass().getPackage().getName().startsWith("java");
                      if (!bool)
                      {
                        localObject3 = localObject1.getClass().getClassLoader();
                        if (localObject3 != null)
                        {
                          localObject3 = map;
                          ((Map)localObject3).put(localObject2, new JSONObject(localObject1, paramBoolean));
                          break label554;
                        }
                      }
                      localObject3 = map;
                      ((Map)localObject3).put(localObject2, localObject1.toString());
                    }
                  }
                }
              }
            }
          }
        }
        label554:
        i += 1;
      }
      catch (Exception paramObject)
      {
        paramObject = new RuntimeException(paramObject);
        throw paramObject;
      }
    }
  }
  
  public static String quote(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      int k = paramString.length();
      StringBuffer localStringBuffer = new StringBuffer(k + 4);
      localStringBuffer.append('"');
      int i = 0;
      char c;
      for (int j = 0;; j = c)
      {
        if (i >= k)
        {
          localStringBuffer.append('"');
          return localStringBuffer.toString();
        }
        c = paramString.charAt(i);
        if (c != '\f')
        {
          if (c != '\r')
          {
            if (c != '"') {
              if (c != '/')
              {
                if (c != '\\') {
                  switch (c)
                  {
                  default: 
                    if ((c >= ' ') && ((c < '?') || (c >= '?')) && ((c < '?') || (c >= '?')))
                    {
                      localStringBuffer.append(c);
                    }
                    else
                    {
                      Object localObject = new StringBuilder("000");
                      ((StringBuilder)localObject).append(Integer.toHexString(c));
                      localObject = ((StringBuilder)localObject).toString();
                      StringBuilder localStringBuilder = new StringBuilder("\\u");
                      localStringBuilder.append(((String)localObject).substring(((String)localObject).length() - 4));
                      localStringBuffer.append(localStringBuilder.toString());
                    }
                    break;
                  case '\n': 
                    localStringBuffer.append("\\n");
                    break;
                  case '\t': 
                    localStringBuffer.append("\\t");
                    break;
                  case '\b': 
                    localStringBuffer.append("\\b");
                    break;
                  }
                }
              }
              else
              {
                if (j == 60) {
                  localStringBuffer.append('\\');
                }
                localStringBuffer.append(c);
                break label358;
              }
            }
            localStringBuffer.append('\\');
            localStringBuffer.append(c);
          }
          else
          {
            localStringBuffer.append("\\r");
          }
        }
        else {
          localStringBuffer.append("\\f");
        }
        label358:
        i += 1;
      }
    }
    return "\"\"";
  }
  
  public static Object stringToValue(String paramString)
  {
    if (paramString.equals("")) {
      return paramString;
    }
    if (paramString.equalsIgnoreCase("true")) {
      return Boolean.TRUE;
    }
    if (paramString.equalsIgnoreCase("false")) {
      return Boolean.FALSE;
    }
    if (paramString.equalsIgnoreCase("null")) {
      return NULL;
    }
    int i = paramString.charAt(0);
    if (((i >= 48) && (i <= 57)) || (i == 46) || (i == 45) || (i == 43))
    {
      if ((i != 48) || ((paramString.length() > 2) && ((paramString.charAt(1) == 'x') || (paramString.charAt(1) == 'X')))) {}
      try
      {
        localObject = new Integer(Integer.parseInt(paramString.substring(2), 16));
        return localObject;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            i = paramString.indexOf('.');
            if (i <= -1)
            {
              i = paramString.indexOf('e');
              if (i <= -1)
              {
                i = paramString.indexOf('E');
                if (i <= -1)
                {
                  localObject = new Long(paramString);
                  long l = ((Long)localObject).longValue();
                  i = ((Long)localObject).intValue();
                  if (l == i)
                  {
                    localObject = new Integer(((Long)localObject).intValue());
                    return localObject;
                  }
                  return localObject;
                }
              }
            }
            Object localObject = Double.valueOf(paramString);
            return localObject;
          }
          catch (Exception localException2) {}
          localException1 = localException1;
        }
      }
      localObject = new Integer(Integer.parseInt(paramString, 8));
      return localObject;
    }
    return paramString;
  }
  
  public static void testValidity(Object paramObject)
    throws JSONException
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Double))
      {
        paramObject = (Double)paramObject;
        if ((!paramObject.isInfinite()) && (!paramObject.isNaN())) {
          return;
        }
        throw new JSONException("JSON does not allow non-finite numbers.");
      }
      if ((paramObject instanceof Float))
      {
        paramObject = (Float)paramObject;
        if ((!paramObject.isInfinite()) && (!paramObject.isNaN())) {
          return;
        }
        throw new JSONException("JSON does not allow non-finite numbers.");
      }
    }
  }
  
  public static String valueToString(Object paramObject)
    throws JSONException
  {
    if ((paramObject != null) && (!paramObject.equals(null)))
    {
      if ((paramObject instanceof JSONString))
      {
        paramObject = (JSONString)paramObject;
        try
        {
          paramObject = paramObject.toJSONString();
          if ((paramObject instanceof String)) {
            return paramObject;
          }
          localObject = new StringBuilder("Bad value from toJSONString: ");
          ((StringBuilder)localObject).append(paramObject);
          throw new JSONException(((StringBuilder)localObject).toString());
        }
        catch (Exception paramObject)
        {
          throw new JSONException(paramObject);
        }
      }
      if ((paramObject instanceof Number)) {
        return numberToString((Number)paramObject);
      }
      boolean bool = paramObject instanceof Boolean;
      Object localObject = paramObject;
      if (!bool)
      {
        bool = localObject instanceof JSONObject;
        if (!bool)
        {
          bool = localObject instanceof JSONArray;
          if (!bool)
          {
            if ((localObject instanceof Map)) {
              return new JSONObject((Map)localObject).toString();
            }
            if ((localObject instanceof Collection)) {
              return new JSONArray((Collection)localObject).toString();
            }
            if (localObject.getClass().isArray()) {
              return new JSONArray(localObject).toString();
            }
            return quote(localObject.toString());
          }
        }
      }
      return paramObject.toString();
    }
    return "null";
  }
  
  public static String valueToString(Object paramObject, int paramInt1, int paramInt2)
    throws JSONException
  {
    Object localObject;
    if ((paramObject != null) && (!paramObject.equals(null))) {
      if ((paramObject instanceof JSONString)) {
        localObject = (JSONString)paramObject;
      }
    }
    try
    {
      localObject = ((JSONString)localObject).toJSONString();
      if ((localObject instanceof String)) {
        return localObject;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if ((paramObject instanceof Number)) {
      return numberToString((Number)paramObject);
    }
    if ((paramObject instanceof Boolean)) {
      return paramObject.toString();
    }
    if ((paramObject instanceof JSONObject)) {
      return ((JSONObject)paramObject).toString(paramInt1, paramInt2);
    }
    if ((paramObject instanceof JSONArray)) {
      return ((JSONArray)paramObject).toString(paramInt1, paramInt2);
    }
    if ((paramObject instanceof Map)) {
      return new JSONObject((Map)paramObject).toString(paramInt1, paramInt2);
    }
    if ((paramObject instanceof Collection)) {
      return new JSONArray((Collection)paramObject).toString(paramInt1, paramInt2);
    }
    if (paramObject.getClass().isArray()) {
      return new JSONArray(paramObject).toString(paramInt1, paramInt2);
    }
    return quote(paramObject.toString());
    return "null";
  }
  
  public JSONObject accumulate(String paramString, Object paramObject)
    throws JSONException
  {
    testValidity(paramObject);
    Object localObject = opt(paramString);
    if (localObject == null)
    {
      localObject = paramObject;
      if ((paramObject instanceof JSONArray)) {
        localObject = new JSONArray().put(paramObject);
      }
      put(paramString, localObject);
      return this;
    }
    if ((localObject instanceof JSONArray))
    {
      ((JSONArray)localObject).put(paramObject);
      return this;
    }
    put(paramString, new JSONArray().put(localObject).put(paramObject));
    return this;
  }
  
  public JSONObject append(String paramString, Object paramObject)
    throws JSONException
  {
    testValidity(paramObject);
    Object localObject = opt(paramString);
    if (localObject == null)
    {
      put(paramString, new JSONArray().put(paramObject));
      return this;
    }
    if ((localObject instanceof JSONArray))
    {
      put(paramString, ((JSONArray)localObject).put(paramObject));
      return this;
    }
    paramObject = new StringBuilder("JSONObject[");
    paramObject.append(paramString);
    paramObject.append("] is not a JSONArray.");
    throw new JSONException(paramObject.toString());
  }
  
  public Object get(String paramString)
    throws JSONException
  {
    Object localObject = opt(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder("JSONObject[");
    ((StringBuilder)localObject).append(quote(paramString));
    ((StringBuilder)localObject).append("] not found.");
    throw new JSONException(((StringBuilder)localObject).toString());
  }
  
  public JSONObject get(String paramString, int paramInt)
    throws JSONException
  {
    put(paramString, new Integer(paramInt));
    return this;
  }
  
  public JSONObject get(String paramString, long paramLong)
    throws JSONException
  {
    put(paramString, new Long(paramLong));
    return this;
  }
  
  public JSONObject get(String paramString, boolean paramBoolean)
    throws JSONException
  {
    Boolean localBoolean;
    if (paramBoolean) {
      localBoolean = Boolean.TRUE;
    } else {
      localBoolean = Boolean.FALSE;
    }
    put(paramString, localBoolean);
    return this;
  }
  
  public boolean getBoolean(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if (!localObject.equals(Boolean.FALSE))
    {
      boolean bool = localObject instanceof String;
      if ((!bool) || (!((String)localObject).equalsIgnoreCase("false")))
      {
        if ((!localObject.equals(Boolean.TRUE)) && ((!bool) || (!((String)localObject).equalsIgnoreCase("true"))))
        {
          localObject = new StringBuilder("JSONObject[");
          ((StringBuilder)localObject).append(quote(paramString));
          ((StringBuilder)localObject).append("] is not a Boolean.");
          throw new JSONException(((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public double getDouble(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if ((localObject instanceof Number)) {
      localObject = (Number)localObject;
    }
    try
    {
      d = ((Number)localObject).doubleValue();
      return d;
    }
    catch (Exception localException)
    {
      double d;
      for (;;) {}
    }
    localObject = (String)localObject;
    d = Double.valueOf((String)localObject).doubleValue();
    return d;
    localObject = new StringBuilder("JSONObject[");
    ((StringBuilder)localObject).append(quote(paramString));
    ((StringBuilder)localObject).append("] is not a number.");
    throw new JSONException(((StringBuilder)localObject).toString());
  }
  
  public int getInt(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if ((localObject instanceof Number)) {
      return ((Number)localObject).intValue();
    }
    return (int)getDouble(paramString);
  }
  
  public JSONArray getJSONArray(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if ((localObject instanceof JSONArray)) {
      return (JSONArray)localObject;
    }
    localObject = new StringBuilder("JSONObject[");
    ((StringBuilder)localObject).append(quote(paramString));
    ((StringBuilder)localObject).append("] is not a JSONArray.");
    throw new JSONException(((StringBuilder)localObject).toString());
  }
  
  public JSONObject getJSONObject(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if ((localObject instanceof JSONObject)) {
      return (JSONObject)localObject;
    }
    localObject = new StringBuilder("JSONObject[");
    ((StringBuilder)localObject).append(quote(paramString));
    ((StringBuilder)localObject).append("] is not a JSONObject.");
    throw new JSONException(((StringBuilder)localObject).toString());
  }
  
  public long getLong(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if ((localObject instanceof Number)) {
      return ((Number)localObject).longValue();
    }
    return getDouble(paramString);
  }
  
  public String getString(String paramString)
    throws JSONException
  {
    return get(paramString).toString();
  }
  
  public boolean has(String paramString)
  {
    return map.containsKey(paramString);
  }
  
  public JSONObject increment(String paramString, Map paramMap)
    throws JSONException
  {
    put(paramString, new JSONObject(paramMap));
    return this;
  }
  
  public boolean isNull(String paramString)
  {
    return NULL.equals(opt(paramString));
  }
  
  public Iterator keys()
  {
    return map.keySet().iterator();
  }
  
  public int length()
  {
    return map.size();
  }
  
  public JSONArray names()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = keys();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (localJSONArray.length() != 0) {
          break;
        }
        return null;
      }
      localJSONArray.put(localIterator.next());
    }
    return localJSONArray;
  }
  
  public Object opt(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return map.get(paramString);
  }
  
  public boolean optBoolean(String paramString)
  {
    return optBoolean(paramString, false);
  }
  
  public boolean optBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = getBoolean(paramString);
      return bool;
    }
    catch (Exception paramString) {}
    return paramBoolean;
  }
  
  public double optDouble(String paramString)
  {
    return optDouble(paramString, NaN.0D);
  }
  
  public double optDouble(String paramString, double paramDouble)
  {
    try
    {
      paramString = opt(paramString);
      if ((paramString instanceof Number))
      {
        paramString = (Number)paramString;
        d = paramString.doubleValue();
        return d;
      }
      paramString = (String)paramString;
      double d = new Double(paramString).doubleValue();
      return d;
    }
    catch (Exception paramString) {}
    return paramDouble;
  }
  
  public int optInt(String paramString)
  {
    return optInt(paramString, 0);
  }
  
  public int optInt(String paramString, int paramInt)
  {
    try
    {
      int i = getInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public JSONArray optJSONArray(String paramString)
  {
    paramString = opt(paramString);
    if ((paramString instanceof JSONArray)) {
      return (JSONArray)paramString;
    }
    return null;
  }
  
  public JSONObject optJSONObject(String paramString)
  {
    paramString = opt(paramString);
    if ((paramString instanceof JSONObject)) {
      return (JSONObject)paramString;
    }
    return null;
  }
  
  public long optLong(String paramString)
  {
    return optLong(paramString, 0L);
  }
  
  public long optLong(String paramString, long paramLong)
  {
    try
    {
      long l = getLong(paramString);
      return l;
    }
    catch (Exception paramString) {}
    return paramLong;
  }
  
  public String optString(String paramString)
  {
    return optString(paramString, "");
  }
  
  public String optString(String paramString1, String paramString2)
  {
    paramString1 = opt(paramString1);
    if (paramString1 != null) {
      return paramString1.toString();
    }
    return paramString2;
  }
  
  public JSONObject put(String paramString, double paramDouble)
    throws JSONException
  {
    put(paramString, new Double(paramDouble));
    return this;
  }
  
  public JSONObject put(String paramString, Object paramObject)
    throws JSONException
  {
    if (paramString != null)
    {
      if (paramObject != null)
      {
        testValidity(paramObject);
        map.put(paramString, paramObject);
        return this;
      }
      remove(paramString);
      return this;
    }
    throw new JSONException("Null key.");
  }
  
  public JSONObject put(String paramString, Collection paramCollection)
    throws JSONException
  {
    put(paramString, new JSONArray(paramCollection));
    return this;
  }
  
  public JSONObject putOnce(String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramString != null) && (paramObject != null))
    {
      if (opt(paramString) == null)
      {
        put(paramString, paramObject);
        return this;
      }
      paramObject = new StringBuilder("Duplicate key \"");
      paramObject.append(paramString);
      paramObject.append("\"");
      throw new JSONException(paramObject.toString());
    }
    return this;
  }
  
  public JSONObject putOpt(String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramString != null) && (paramObject != null)) {
      put(paramString, paramObject);
    }
    return this;
  }
  
  public Object remove(String paramString)
  {
    return map.remove(paramString);
  }
  
  public Iterator sortedKeys()
  {
    return new TreeSet(map.keySet()).iterator();
  }
  
  public JSONArray toJSONArray(JSONArray paramJSONArray)
    throws JSONException
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      for (;;)
      {
        if (i >= paramJSONArray.length()) {
          return localJSONArray;
        }
        localJSONArray.put(opt(paramJSONArray.getString(i)));
        i += 1;
      }
    }
    return null;
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = keys();
      StringBuffer localStringBuffer = new StringBuffer("{");
      for (;;)
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        if (!bool)
        {
          localStringBuffer.append('}');
          localObject1 = localStringBuffer.toString();
          return localObject1;
        }
        int i = localStringBuffer.length();
        if (i > 1) {
          localStringBuffer.append(',');
        }
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuffer.append(quote(localObject2.toString()));
        localStringBuffer.append(':');
        Map localMap = map;
        localStringBuffer.append(valueToString(localMap.get(localObject2)));
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String toString(int paramInt)
    throws JSONException
  {
    return toString(paramInt, 0);
  }
  
  public String toString(int paramInt1, int paramInt2)
    throws JSONException
  {
    int i = length();
    if (i == 0) {
      return "{}";
    }
    Object localObject1 = sortedKeys();
    StringBuffer localStringBuffer = new StringBuffer("{");
    int k = paramInt2 + paramInt1;
    int j;
    if (i == 1)
    {
      localObject1 = ((Iterator)localObject1).next();
      localStringBuffer.append(quote(localObject1.toString()));
      localStringBuffer.append(": ");
      localStringBuffer.append(valueToString(map.get(localObject1), paramInt1, paramInt2));
    }
    else
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      j = 0;
      i = 0;
      if (bool) {
        break label173;
      }
      if (localStringBuffer.length() > 1)
      {
        localStringBuffer.append('\n');
        paramInt1 = i;
        while (paramInt1 < paramInt2)
        {
          localStringBuffer.append(' ');
          paramInt1 += 1;
        }
      }
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
    label173:
    Object localObject2 = ((Iterator)localObject1).next();
    if (localStringBuffer.length() > 1)
    {
      localStringBuffer.append(",\n");
      i = j;
    }
    else
    {
      localStringBuffer.append('\n');
      i = j;
    }
    for (;;)
    {
      if (i >= k)
      {
        localStringBuffer.append(quote(localObject2.toString()));
        localStringBuffer.append(": ");
        localStringBuffer.append(valueToString(map.get(localObject2), paramInt1, k));
        break;
      }
      localStringBuffer.append(' ');
      i += 1;
    }
  }
  
  /* Error */
  public java.io.Writer write(java.io.Writer paramWriter)
    throws JSONException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 203	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   6: astore 4
    //   8: aload_1
    //   9: bipush 123
    //   11: invokevirtual 578	java/io/Writer:write	(I)V
    //   14: aload 4
    //   16: invokeinterface 93 1 0
    //   21: istore_3
    //   22: iload_3
    //   23: ifne +11 -> 34
    //   26: aload_1
    //   27: bipush 125
    //   29: invokevirtual 578	java/io/Writer:write	(I)V
    //   32: aload_1
    //   33: areturn
    //   34: iload_2
    //   35: ifeq +9 -> 44
    //   38: aload_1
    //   39: bipush 44
    //   41: invokevirtual 578	java/io/Writer:write	(I)V
    //   44: aload 4
    //   46: invokeinterface 97 1 0
    //   51: astore 5
    //   53: aload_1
    //   54: aload 5
    //   56: invokevirtual 137	java/lang/Object:toString	()Ljava/lang/String;
    //   59: invokestatic 430	org/json/JSONObject:quote	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 580	java/io/Writer:write	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: bipush 58
    //   68: invokevirtual 578	java/io/Writer:write	(I)V
    //   71: aload_0
    //   72: getfield 26	org/json/JSONObject:map	Ljava/util/Map;
    //   75: astore 6
    //   77: aload 6
    //   79: aload 5
    //   81: invokeinterface 499 2 0
    //   86: astore 5
    //   88: aload 5
    //   90: instanceof 2
    //   93: ifeq +20 -> 113
    //   96: aload 5
    //   98: checkcast 2	org/json/JSONObject
    //   101: astore 5
    //   103: aload 5
    //   105: aload_1
    //   106: invokevirtual 582	org/json/JSONObject:write	(Ljava/io/Writer;)Ljava/io/Writer;
    //   109: pop
    //   110: goto +37 -> 147
    //   113: aload 5
    //   115: instanceof 306
    //   118: ifeq +20 -> 138
    //   121: aload 5
    //   123: checkcast 306	org/json/JSONArray
    //   126: astore 5
    //   128: aload 5
    //   130: aload_1
    //   131: invokevirtual 583	org/json/JSONArray:write	(Ljava/io/Writer;)Ljava/io/Writer;
    //   134: pop
    //   135: goto +12 -> 147
    //   138: aload_1
    //   139: aload 5
    //   141: invokestatic 560	org/json/JSONObject:valueToString	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 580	java/io/Writer:write	(Ljava/lang/String;)V
    //   147: iconst_1
    //   148: istore_2
    //   149: goto -135 -> 14
    //   152: astore_1
    //   153: new 58	org/json/JSONException
    //   156: dup
    //   157: aload_1
    //   158: invokespecial 415	org/json/JSONException:<init>	(Ljava/lang/Throwable;)V
    //   161: astore_1
    //   162: goto +3 -> 165
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	JSONObject
    //   0	167	1	paramWriter	java.io.Writer
    //   1	148	2	i	int
    //   21	2	3	bool	boolean
    //   6	39	4	localIterator	Iterator
    //   51	89	5	localObject	Object
    //   75	3	6	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	14	152	java/io/IOException
    //   14	22	152	java/io/IOException
    //   26	32	152	java/io/IOException
    //   38	44	152	java/io/IOException
    //   44	71	152	java/io/IOException
    //   77	88	152	java/io/IOException
    //   103	110	152	java/io/IOException
    //   128	135	152	java/io/IOException
    //   138	147	152	java/io/IOException
  }
}
