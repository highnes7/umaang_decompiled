package f.g.org.org.util;

import f.g.b.a.g.n;
import f.g.b.a.g.v;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;

public final class ClassInfo
{
  public static final Map<Class<?>, n> CACHE = new WeakHashMap();
  public static final Map<Class<?>, n> CACHE_IGNORE_CASE = new WeakHashMap();
  public final Class<?> clazz;
  public final boolean ignoreCase;
  public final IdentityHashMap<String, v> nameToFieldInfoMap = new IdentityHashMap();
  public final List<String> names;
  
  public ClassInfo(Class paramClass, boolean paramBoolean)
  {
    clazz = paramClass;
    ignoreCase = paramBoolean;
    boolean bool;
    if ((paramBoolean) && (paramClass.isEnum())) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject1 = String.valueOf(paramClass);
    Object localObject2 = new StringBuilder(((String)localObject1).length() + 31);
    ((StringBuilder)localObject2).append("cannot ignore case on an enum: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Preconditions.checkArgument(bool, ((StringBuilder)localObject2).toString());
    TreeSet localTreeSet = new TreeSet(new BeanSerializer.1(this));
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      FieldInfo localFieldInfo = FieldInfo.of(localField);
      if (localFieldInfo != null)
      {
        localObject2 = localFieldInfo.getName();
        localObject1 = localObject2;
        if (paramBoolean) {
          localObject1 = ((String)localObject2).toLowerCase().intern();
        }
        Object localObject3 = (FieldInfo)nameToFieldInfoMap.get(localObject1);
        if (localObject3 == null) {
          bool = true;
        } else {
          bool = false;
        }
        if (paramBoolean) {
          localObject2 = "case-insensitive ";
        } else {
          localObject2 = "";
        }
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((FieldInfo)localObject3).getField();
        }
        Preconditions.checkArgument(bool, "two fields have the same %sname <%s>: %s and %s", new Object[] { localObject2, localObject1, localField, localObject3 });
        nameToFieldInfoMap.put(localObject1, localFieldInfo);
        localTreeSet.add(localObject1);
      }
      i += 1;
    }
    paramClass = paramClass.getSuperclass();
    if (paramClass != null)
    {
      paramClass = of(paramClass, paramBoolean);
      localTreeSet.addAll(names);
      paramClass = nameToFieldInfoMap.entrySet().iterator();
      while (paramClass.hasNext())
      {
        localObject1 = (Map.Entry)paramClass.next();
        localObject2 = (String)((Map.Entry)localObject1).getKey();
        if (!nameToFieldInfoMap.containsKey(localObject2)) {
          nameToFieldInfoMap.put(localObject2, ((Map.Entry)localObject1).getValue());
        }
      }
    }
    if (localTreeSet.isEmpty()) {
      paramClass = Collections.emptyList();
    } else {
      paramClass = Collections.unmodifiableList(new ArrayList(localTreeSet));
    }
    names = paramClass;
  }
  
  public static ClassInfo of(Class paramClass)
  {
    return of(paramClass, false);
  }
  
  public static ClassInfo of(Class paramClass, boolean paramBoolean)
  {
    if (paramClass == null) {
      return null;
    }
    Map localMap;
    if (paramBoolean) {
      localMap = CACHE_IGNORE_CASE;
    } else {
      localMap = CACHE;
    }
    try
    {
      ClassInfo localClassInfo2 = (ClassInfo)localMap.get(paramClass);
      ClassInfo localClassInfo1 = localClassInfo2;
      if (localClassInfo2 == null)
      {
        localClassInfo1 = new ClassInfo(paramClass, paramBoolean);
        localMap.put(paramClass, localClassInfo1);
      }
      return localClassInfo1;
    }
    catch (Throwable paramClass)
    {
      throw paramClass;
    }
  }
  
  public Field getField(String paramString)
  {
    paramString = getFieldInfo(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.getField();
  }
  
  public FieldInfo getFieldInfo(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (ignoreCase) {
        str = paramString.toLowerCase();
      }
      str = str.intern();
    }
    return (FieldInfo)nameToFieldInfoMap.get(str);
  }
  
  public Collection getFieldInfos()
  {
    return Collections.unmodifiableCollection(nameToFieldInfoMap.values());
  }
  
  public final boolean getIgnoreCase()
  {
    return ignoreCase;
  }
  
  public Collection getNames()
  {
    return names;
  }
  
  public Class getUnderlyingClass()
  {
    return clazz;
  }
  
  public boolean isEnum()
  {
    return clazz.isEnum();
  }
}
