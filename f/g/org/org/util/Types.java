package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Types
{
  public Types() {}
  
  public static Type getActualParameterAtPosition(Type paramType, Class paramClass, int paramInt)
  {
    paramClass = getSuperParameterizedType(paramType, paramClass);
    if (paramClass == null) {
      return null;
    }
    paramClass = paramClass.getActualTypeArguments()[paramInt];
    if ((paramClass instanceof TypeVariable))
    {
      paramType = resolveTypeVariable(Arrays.asList(new Type[] { paramType }), (TypeVariable)paramClass);
      if (paramType != null) {
        return paramType;
      }
    }
    return paramClass;
  }
  
  public static Type getArrayComponentType(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {
      return ((GenericArrayType)paramType).getGenericComponentType();
    }
    return ((Class)paramType).getComponentType();
  }
  
  public static Type getBound(WildcardType paramWildcardType)
  {
    Type[] arrayOfType = paramWildcardType.getLowerBounds();
    if (arrayOfType.length != 0) {
      return arrayOfType[0];
    }
    return paramWildcardType.getUpperBounds()[0];
  }
  
  public static Type getIterableParameter(Type paramType)
  {
    return getActualParameterAtPosition(paramType, Iterable.class, 0);
  }
  
  public static Type getMapValueParameter(Type paramType)
  {
    return getActualParameterAtPosition(paramType, Map.class, 1);
  }
  
  public static Class getRawArrayComponentType(List paramList, Type paramType)
  {
    Type localType = paramType;
    if ((paramType instanceof TypeVariable)) {
      localType = resolveTypeVariable(paramList, (TypeVariable)paramType);
    }
    if ((localType instanceof GenericArrayType)) {
      return Array.newInstance(getRawArrayComponentType(paramList, getArrayComponentType(localType)), 0).getClass();
    }
    if ((localType instanceof Class)) {
      return (Class)localType;
    }
    if ((localType instanceof ParameterizedType)) {
      return getRawClass((ParameterizedType)localType);
    }
    boolean bool;
    if (localType == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "wildcard type is not supported: %s", new Object[] { localType });
    return Object.class;
  }
  
  public static Class getRawClass(ParameterizedType paramParameterizedType)
  {
    return (Class)paramParameterizedType.getRawType();
  }
  
  public static ParameterizedType getSuperParameterizedType(Type paramType, Class paramClass)
  {
    Object localObject = paramType;
    if (!(paramType instanceof Class))
    {
      if ((paramType instanceof ParameterizedType)) {
        localObject = paramType;
      }
    }
    else {
      while ((localObject != null) && (localObject != Object.class))
      {
        if ((localObject instanceof Class))
        {
          paramType = (Class)localObject;
        }
        else
        {
          paramType = (ParameterizedType)localObject;
          localObject = (Class)paramType.getRawType();
          if (localObject == paramClass) {
            return paramType;
          }
          paramType = (Type)localObject;
          if (paramClass.isInterface())
          {
            Type[] arrayOfType = ((Class)localObject).getGenericInterfaces();
            int j = arrayOfType.length;
            int i = 0;
            for (;;)
            {
              paramType = (Type)localObject;
              if (i >= j) {
                break label159;
              }
              Type localType = arrayOfType[i];
              if ((localType instanceof Class)) {
                paramType = (Class)localType;
              } else {
                paramType = getRawClass((ParameterizedType)localType);
              }
              if (paramClass.isAssignableFrom(paramType))
              {
                localObject = localType;
                break;
              }
              i += 1;
            }
          }
        }
        label159:
        localObject = paramType.getGenericSuperclass();
      }
    }
    return null;
  }
  
  public static IllegalArgumentException handleExceptionForNewInstance(Exception paramException, Class paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder("unable to create new instance of class ");
    localStringBuilder.append(paramClass.getName());
    Object localObject = new ArrayList();
    boolean bool = paramClass.isArray();
    int i = 0;
    if (bool)
    {
      ((ArrayList)localObject).add("because it is an array");
    }
    else if (paramClass.isPrimitive())
    {
      ((ArrayList)localObject).add("because it is primitive");
    }
    else if (paramClass == Void.class)
    {
      ((ArrayList)localObject).add("because it is void");
    }
    else
    {
      if (Modifier.isInterface(paramClass.getModifiers())) {
        ((ArrayList)localObject).add("because it is an interface");
      } else if (Modifier.isAbstract(paramClass.getModifiers())) {
        ((ArrayList)localObject).add("because it is abstract");
      }
      if ((paramClass.getEnclosingClass() != null) && (!Modifier.isStatic(paramClass.getModifiers()))) {
        ((ArrayList)localObject).add("because it is not static");
      }
      if (!Modifier.isPublic(paramClass.getModifiers())) {
        ((ArrayList)localObject).add("possibly because it is not public");
      }
    }
    try
    {
      paramClass.getConstructor(new Class[0]);
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
    ((ArrayList)localObject).add("because it has no accessible default constructor");
    paramClass = ((ArrayList)localObject).iterator();
    while (paramClass.hasNext())
    {
      localObject = (String)paramClass.next();
      if (i != 0) {
        localStringBuilder.append(" and");
      } else {
        i = 1;
      }
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
    }
    return new IllegalArgumentException(localStringBuilder.toString(), paramException);
  }
  
  public static boolean isArray(Type paramType)
  {
    return ((paramType instanceof GenericArrayType)) || (((paramType instanceof Class)) && (((Class)paramType).isArray()));
  }
  
  public static boolean isAssignableToOrFrom(Class paramClass1, Class paramClass2)
  {
    return (paramClass1.isAssignableFrom(paramClass2)) || (paramClass2.isAssignableFrom(paramClass1));
  }
  
  public static Iterable iterableOf(Object paramObject)
  {
    if ((paramObject instanceof Iterable)) {
      return (Iterable)paramObject;
    }
    Class localClass = paramObject.getClass();
    Preconditions.checkArgument(localClass.isArray(), "not an array or Iterable: %s", new Object[] { localClass });
    if (!localClass.getComponentType().isPrimitive()) {
      return Arrays.asList((Object[])paramObject);
    }
    return new Types.1(paramObject);
  }
  
  public static Object newInstance(Class paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw handleExceptionForNewInstance(localInstantiationException, paramClass);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw handleExceptionForNewInstance(localIllegalAccessException, paramClass);
    }
  }
  
  public static Type resolveTypeVariable(List paramList, TypeVariable paramTypeVariable)
  {
    Object localObject = paramTypeVariable.getGenericDeclaration();
    if ((localObject instanceof Class))
    {
      Class localClass = (Class)localObject;
      int i = paramList.size();
      for (ParameterizedType localParameterizedType = null; localParameterizedType == null; localParameterizedType = getSuperParameterizedType((Type)paramList.get(i), localClass))
      {
        i -= 1;
        if (i < 0) {
          break;
        }
      }
      if (localParameterizedType != null)
      {
        localObject = ((GenericDeclaration)localObject).getTypeParameters();
        i = 0;
        while ((i < localObject.length) && (!localObject[i].equals(paramTypeVariable))) {
          i += 1;
        }
        paramTypeVariable = localParameterizedType.getActualTypeArguments()[i];
        if ((paramTypeVariable instanceof TypeVariable))
        {
          paramList = resolveTypeVariable(paramList, (TypeVariable)paramTypeVariable);
          if (paramList == null) {
            return paramTypeVariable;
          }
          return paramList;
        }
        return paramTypeVariable;
      }
    }
    return null;
    return paramTypeVariable;
  }
  
  public static Object toArray(Collection paramCollection, Class paramClass)
  {
    if (paramClass.isPrimitive())
    {
      paramClass = Array.newInstance(paramClass, paramCollection.size());
      int i = 0;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Array.set(paramClass, i, paramCollection.next());
        i += 1;
      }
      return paramClass;
    }
    return paramCollection.toArray((Object[])Array.newInstance(paramClass, paramCollection.size()));
  }
}
