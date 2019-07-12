package com.google.android.android.common.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.NodeList;

public final class Option
{
  public static Set get(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 256) {
      return new NodeList(paramInt);
    }
    return new HashSet(paramInt, 1.0F);
  }
  
  public static Set get(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Set localSet = get(3, false);
    localSet.add(paramObject1);
    localSet.add(paramObject2);
    localSet.add(paramObject3);
    return Collections.unmodifiableSet(localSet);
  }
  
  public static Set get(Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              localObject1 = get(paramVarArgs.length, false);
              Collections.addAll((Collection)localObject1, paramVarArgs);
              return Collections.unmodifiableSet((Set)localObject1);
            }
            localObject1 = paramVarArgs[0];
            localObject2 = paramVarArgs[1];
            Object localObject3 = paramVarArgs[2];
            paramVarArgs = paramVarArgs[3];
            Set localSet = get(4, false);
            localSet.add(localObject1);
            localSet.add(localObject2);
            localSet.add(localObject3);
            localSet.add(paramVarArgs);
            return Collections.unmodifiableSet(localSet);
          }
          return get(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
        }
        Object localObject1 = paramVarArgs[0];
        paramVarArgs = paramVarArgs[1];
        Object localObject2 = get(2, false);
        ((Set)localObject2).add(localObject1);
        ((Set)localObject2).add(paramVarArgs);
        return Collections.unmodifiableSet((Set)localObject2);
      }
      return Collections.singleton(paramVarArgs[0]);
    }
    return Collections.emptySet();
  }
  
  public static Map getValue(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 256) {
      return new ArrayMap(paramInt);
    }
    return new HashMap(paramInt, 1.0F);
  }
  
  public static Map of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    Map localMap = getValue(2, false);
    localMap.put(paramObject1, paramObject2);
    localMap.put(paramObject3, paramObject4);
    return Collections.unmodifiableMap(localMap);
  }
  
  public static Map of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10, Object paramObject11, Object paramObject12)
  {
    Map localMap = getValue(6, false);
    localMap.put(paramObject1, paramObject2);
    localMap.put(paramObject3, paramObject4);
    localMap.put(paramObject5, paramObject6);
    localMap.put(paramObject7, paramObject8);
    localMap.put(paramObject9, paramObject10);
    localMap.put(paramObject11, paramObject12);
    return Collections.unmodifiableMap(localMap);
  }
}
