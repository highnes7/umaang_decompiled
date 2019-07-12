package f.g.org.org.stream;

import f.g.b.a.d.i;
import f.g.b.a.g.w;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.ClassInfo;
import f.g.org.org.util.Data;
import f.g.org.org.util.FieldInfo;
import f.g.org.org.util.GenericData;
import f.g.org.org.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class JsonParser
{
  public static WeakHashMap<Class<?>, Field> cachedTypemapFields = new WeakHashMap();
  public static final Lock lock = new ReentrantLock();
  
  public JsonParser() {}
  
  public static Field getCachedTypemapFieldFor(Class paramClass)
  {
    java.lang.Object localObject1 = null;
    if (paramClass == null) {
      return null;
    }
    lock.lock();
    try
    {
      boolean bool = cachedTypemapFields.containsKey(paramClass);
      if (bool)
      {
        paramClass = (Field)cachedTypemapFields.get(paramClass);
        lock.unlock();
        return paramClass;
      }
      Iterator localIterator = ClassInfo.of(paramClass).getFieldInfos().iterator();
      for (;;)
      {
        bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        Field localField = ((FieldInfo)localIterator.next()).getField();
        java.lang.Object localObject2 = (JsonPolymorphicTypeMap)localField.getAnnotation(i.class);
        if (localObject2 != null)
        {
          if (localObject1 == null) {
            bool = true;
          } else {
            bool = false;
          }
          Preconditions.checkArgument(bool, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", new java.lang.Object[] { paramClass });
          Preconditions.checkArgument(Data.isPrimitive(localField.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", new java.lang.Object[] { paramClass, localField.getType() });
          localObject1 = ((JsonPolymorphicTypeMap)localObject2).typeDefinitions();
          localObject2 = new HashSet();
          int i = localObject1.length;
          if (i > 0) {
            bool = true;
          } else {
            bool = false;
          }
          Preconditions.checkArgument(bool, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
          int j = localObject1.length;
          i = 0;
          while (i < j)
          {
            java.lang.Object localObject3 = localObject1[i];
            Preconditions.checkArgument(((HashSet)localObject2).add(localObject3.key()), "Class contains two @TypeDef annotations with identical key: %s", new java.lang.Object[] { localObject3.key() });
            i += 1;
          }
          localObject1 = localField;
        }
      }
      cachedTypemapFields.put(paramClass, localObject1);
      lock.unlock();
      return localObject1;
    }
    catch (Throwable paramClass)
    {
      lock.unlock();
      throw paramClass;
    }
  }
  
  private void parse(ArrayList paramArrayList, java.lang.Object paramObject, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    if ((paramObject instanceof Object)) {
      ((Object)paramObject).put(getFactory());
    }
    java.lang.Object localObject2 = startParsingObjectOrArray();
    Class localClass = paramObject.getClass();
    ClassInfo localClassInfo = ClassInfo.of(localClass);
    boolean bool = w.class.isAssignableFrom(localClass);
    java.lang.Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = localObject2;
      if (Map.class.isAssignableFrom(localClass))
      {
        parseMap(null, (Map)paramObject, Types.getMapValueParameter(localClass), paramArrayList, paramCustomizeJsonParser);
        return;
      }
    }
    while (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject2 = getText();
      nextToken();
      if ((paramCustomizeJsonParser != null) && (paramCustomizeJsonParser.stopAt(paramObject, (String)localObject2))) {
        return;
      }
      localObject1 = localClassInfo.getFieldInfo((String)localObject2);
      if (localObject1 != null)
      {
        if ((((FieldInfo)localObject1).isFinal()) && (!((FieldInfo)localObject1).isPrimitive())) {
          throw new IllegalArgumentException("final array/object fields are not supported");
        }
        localObject2 = ((FieldInfo)localObject1).getField();
        int i = paramArrayList.size();
        paramArrayList.add(((Field)localObject2).getGenericType());
        localObject2 = parseValue((Field)localObject2, ((FieldInfo)localObject1).getGenericType(), paramArrayList, paramObject, paramCustomizeJsonParser, true);
        paramArrayList.remove(i);
        ((FieldInfo)localObject1).setValue(paramObject, localObject2);
      }
      else if (bool)
      {
        ((GenericData)paramObject).clone((String)localObject2, parseValue(null, null, paramArrayList, paramObject, paramCustomizeJsonParser, true));
      }
      else
      {
        if (paramCustomizeJsonParser != null) {
          paramCustomizeJsonParser.handleUnrecognizedKey(paramObject, (String)localObject2);
        }
        skipChildren();
      }
      localObject1 = nextToken();
    }
  }
  
  private void parseArray(Field paramField, Collection paramCollection, Type paramType, ArrayList paramArrayList, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    for (JsonToken localJsonToken = startParsingObjectOrArray(); localJsonToken != JsonToken.END_ARRAY; localJsonToken = nextToken()) {
      paramCollection.add(parseValue(paramField, paramType, paramArrayList, paramCollection, paramCustomizeJsonParser, true));
    }
  }
  
  private void parseMap(Field paramField, Map paramMap, Type paramType, ArrayList paramArrayList, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    for (java.lang.Object localObject = startParsingObjectOrArray(); localObject == JsonToken.FIELD_NAME; localObject = nextToken())
    {
      localObject = getText();
      nextToken();
      if ((paramCustomizeJsonParser != null) && (paramCustomizeJsonParser.stopAt(paramMap, (String)localObject))) {
        return;
      }
      paramMap.put(localObject, parseValue(paramField, paramType, paramArrayList, paramMap, paramCustomizeJsonParser, true));
    }
  }
  
  private final java.lang.Object parseValue(Field paramField, Type paramType, ArrayList paramArrayList, java.lang.Object paramObject, CustomizeJsonParser paramCustomizeJsonParser, boolean paramBoolean)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a85 = a84\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private JsonToken startParsing()
    throws IOException
  {
    JsonToken localJsonToken2 = getCurrentToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == null) {
      localJsonToken1 = nextToken();
    }
    boolean bool;
    if (localJsonToken1 != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "no JSON input found");
    return localJsonToken1;
  }
  
  private JsonToken startParsingObjectOrArray()
    throws IOException
  {
    JsonToken localJsonToken = startParsing();
    int i = localJsonToken.ordinal();
    if (i != 0)
    {
      if (i != 2) {
        return localJsonToken;
      }
      localJsonToken = nextToken();
      boolean bool;
      if ((localJsonToken != JsonToken.FIELD_NAME) && (localJsonToken != JsonToken.END_OBJECT)) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkArgument(bool, localJsonToken);
      return localJsonToken;
    }
    return nextToken();
  }
  
  public abstract void close()
    throws IOException;
  
  public abstract BigInteger getBigIntegerValue()
    throws IOException;
  
  public abstract byte getByteValue()
    throws IOException;
  
  public abstract String getCurrentName()
    throws IOException;
  
  public abstract JsonToken getCurrentToken();
  
  public abstract BigDecimal getDecimalValue()
    throws IOException;
  
  public abstract double getDoubleValue()
    throws IOException;
  
  public abstract JsonFactory getFactory();
  
  public abstract float getFloatValue()
    throws IOException;
  
  public abstract int getIntValue()
    throws IOException;
  
  public abstract long getLongValue()
    throws IOException;
  
  public abstract short getShortValue()
    throws IOException;
  
  public abstract String getText()
    throws IOException;
  
  public abstract JsonToken nextToken()
    throws IOException;
  
  public final java.lang.Object parse(Class paramClass)
    throws IOException
  {
    return parse(paramClass, null);
  }
  
  public final java.lang.Object parse(Class paramClass, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    return parse(paramClass, false, paramCustomizeJsonParser);
  }
  
  public java.lang.Object parse(Type paramType, boolean paramBoolean)
    throws IOException
  {
    return parse(paramType, paramBoolean, null);
  }
  
  public java.lang.Object parse(Type paramType, boolean paramBoolean, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    try
    {
      boolean bool = Void.class.equals(paramType);
      if (!bool) {
        startParsing();
      }
      paramType = parseValue(null, paramType, new ArrayList(), null, paramCustomizeJsonParser, true);
      if (paramBoolean)
      {
        close();
        return paramType;
      }
    }
    catch (Throwable paramType)
    {
      if (paramBoolean) {
        close();
      }
      throw paramType;
    }
    return paramType;
  }
  
  public final void parse(java.lang.Object paramObject)
    throws IOException
  {
    parse(paramObject, null);
  }
  
  public final void parse(java.lang.Object paramObject, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObject.getClass());
    parse(localArrayList, paramObject, paramCustomizeJsonParser);
  }
  
  public final java.lang.Object parseAndClose(Class paramClass)
    throws IOException
  {
    return parseAndClose(paramClass, null);
  }
  
  public final java.lang.Object parseAndClose(Class paramClass, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    try
    {
      paramClass = parse(paramClass, paramCustomizeJsonParser);
      close();
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      close();
      throw paramClass;
    }
  }
  
  public final void parseAndClose(java.lang.Object paramObject)
    throws IOException
  {
    parseAndClose(paramObject, null);
  }
  
  public final void parseAndClose(java.lang.Object paramObject, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    try
    {
      parse(paramObject, paramCustomizeJsonParser);
      close();
      return;
    }
    catch (Throwable paramObject)
    {
      close();
      throw paramObject;
    }
  }
  
  public final Collection parseArray(Class paramClass1, Class paramClass2)
    throws IOException
  {
    return parseArray(paramClass1, paramClass2, null);
  }
  
  public final Collection parseArray(Class paramClass1, Class paramClass2, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    paramClass1 = Data.newCollectionInstance(paramClass1);
    parseArray(paramClass1, paramClass2, paramCustomizeJsonParser);
    return paramClass1;
  }
  
  public final void parseArray(Collection paramCollection, Class paramClass)
    throws IOException
  {
    parseArray(paramCollection, paramClass, null);
  }
  
  public final void parseArray(Collection paramCollection, Class paramClass, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    parseArray(null, paramCollection, paramClass, new ArrayList(), paramCustomizeJsonParser);
  }
  
  public final Collection parseArrayAndClose(Class paramClass1, Class paramClass2)
    throws IOException
  {
    return parseArrayAndClose(paramClass1, paramClass2, null);
  }
  
  public final Collection parseArrayAndClose(Class paramClass1, Class paramClass2, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    try
    {
      paramClass1 = parseArray(paramClass1, paramClass2, paramCustomizeJsonParser);
      close();
      return paramClass1;
    }
    catch (Throwable paramClass1)
    {
      close();
      throw paramClass1;
    }
  }
  
  public final void parseArrayAndClose(Collection paramCollection, Class paramClass)
    throws IOException
  {
    parseArrayAndClose(paramCollection, paramClass, null);
  }
  
  public final void parseArrayAndClose(Collection paramCollection, Class paramClass, CustomizeJsonParser paramCustomizeJsonParser)
    throws IOException
  {
    try
    {
      parseArray(paramCollection, paramClass, paramCustomizeJsonParser);
      close();
      return;
    }
    catch (Throwable paramCollection)
    {
      close();
      throw paramCollection;
    }
  }
  
  public abstract JsonParser skipChildren()
    throws IOException;
  
  public final String skipToKey(Set paramSet)
    throws IOException
  {
    for (java.lang.Object localObject = startParsingObjectOrArray(); localObject == JsonToken.FIELD_NAME; localObject = nextToken())
    {
      localObject = getText();
      nextToken();
      if (paramSet.contains(localObject)) {
        return localObject;
      }
      skipChildren();
    }
    return null;
  }
  
  public final void skipToKey(String paramString)
    throws IOException
  {
    skipToKey(Collections.singleton(paramString));
  }
}
