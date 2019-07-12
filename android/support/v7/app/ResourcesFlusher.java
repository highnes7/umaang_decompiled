package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

public class ResourcesFlusher
{
  public static final String PAGE_KEY = "ResourcesFlusher";
  public static Field sDrawableCacheField;
  public static boolean sDrawableCacheFieldFetched;
  public static Field sResourcesImplField;
  public static boolean sResourcesImplFieldFetched;
  public static Class sThemedResourceCacheClazz;
  public static boolean sThemedResourceCacheClazzFetched;
  public static Field sThemedResourceCache_mUnthemedEntriesField;
  public static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
  
  public ResourcesFlusher() {}
  
  public static void flush(Resources paramResources)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return;
    }
    if (i >= 24)
    {
      flushNougats(paramResources);
      return;
    }
    if (i >= 23)
    {
      flushMarshmallows(paramResources);
      return;
    }
    if (i >= 21) {
      flushLollipops(paramResources);
    }
  }
  
  public static void flushLollipops(Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched) {}
    try
    {
      localField = Resources.class.getDeclaredField("mDrawableCache");
      sDrawableCacheField = localField;
      localField = sDrawableCacheField;
      localField.setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Field localField;
      for (;;) {}
    }
    sDrawableCacheFieldFetched = true;
    localField = sDrawableCacheField;
    if (localField != null)
    {
      try
      {
        paramResources = localField.get(paramResources);
        paramResources = (Map)paramResources;
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;) {}
      }
      paramResources = null;
      if (paramResources != null)
      {
        paramResources.clear();
        return;
      }
    }
  }
  
  public static void flushMarshmallows(Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched) {}
    try
    {
      localObject1 = Resources.class.getDeclaredField("mDrawableCache");
      sDrawableCacheField = (Field)localObject1;
      localObject1 = sDrawableCacheField;
      ((Field)localObject1).setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        Field localField;
        Object localObject1 = localField.get(paramResources);
        if (localObject1 != null) {
          break label54;
        }
        return;
        flushThemedResourcesCache(localObject1);
        return;
        localNoSuchFieldException = localNoSuchFieldException;
      }
      catch (IllegalAccessException paramResources)
      {
        for (;;)
        {
          Object localObject3;
          Object localObject2 = localObject3;
        }
      }
    }
    sDrawableCacheFieldFetched = true;
    localObject3 = null;
    localField = sDrawableCacheField;
    localObject1 = localObject3;
    if (localField == null) {}
  }
  
  public static void flushNougats(Resources paramResources)
  {
    if (!sResourcesImplFieldFetched) {}
    try
    {
      localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
      sResourcesImplField = (Field)localObject1;
      localObject1 = sResourcesImplField;
      ((Field)localObject1).setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      try
      {
        paramResources = ((Field)localObject1).get(paramResources);
        break label53;
        paramResources = null;
        if (paramResources != null) {
          break label58;
        }
        return;
        if (sDrawableCacheFieldFetched) {
          break label91;
        }
      }
      catch (IllegalAccessException localNoSuchFieldException2)
      {
        try
        {
          localObject1 = paramResources.getClass().getDeclaredField("mDrawableCache");
          sDrawableCacheField = (Field)localObject1;
          localObject1 = sDrawableCacheField;
          ((Field)localObject1).setAccessible(true);
          sDrawableCacheFieldFetched = true;
          localField = sDrawableCacheField;
          localObject1 = localObject3;
          if (localField == null) {
            break label107;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          try
          {
            for (;;)
            {
              Field localField;
              Object localObject1 = localField.get(paramResources);
              if (localObject1 == null) {
                break;
              }
              flushThemedResourcesCache(localObject1);
              return;
              localNoSuchFieldException1 = localNoSuchFieldException1;
              continue;
              paramResources = paramResources;
            }
            localNoSuchFieldException2 = localNoSuchFieldException2;
          }
          catch (IllegalAccessException paramResources)
          {
            for (;;)
            {
              Object localObject3;
              Object localObject2 = localObject3;
            }
          }
        }
      }
    }
    sResourcesImplFieldFetched = true;
    localObject1 = sResourcesImplField;
    if (localObject1 == null) {
      return;
    }
    localObject3 = null;
    label53:
    label58:
    label91:
    label107:
    return;
  }
  
  public static void flushThemedResourcesCache(Object paramObject)
  {
    if (!sThemedResourceCacheClazzFetched) {}
    try
    {
      localObject = Class.forName("android.content.res.ThemedResourceCache");
      sThemedResourceCacheClazz = (Class)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      for (;;) {}
    }
    sThemedResourceCacheClazzFetched = true;
    localObject = sThemedResourceCacheClazz;
    if (localObject == null) {
      return;
    }
    if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {}
    try
    {
      localObject = ((Class)localObject).getDeclaredField("mUnthemedEntries");
      sThemedResourceCache_mUnthemedEntriesField = (Field)localObject;
      localObject = sThemedResourceCache_mUnthemedEntriesField;
      ((Field)localObject).setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    localObject = sThemedResourceCache_mUnthemedEntriesField;
    if (localObject == null) {
      return;
    }
    try
    {
      paramObject = ((Field)localObject).get(paramObject);
      paramObject = (LongSparseArray)paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;) {}
    }
    paramObject = null;
    if (paramObject != null)
    {
      paramObject.clear();
      return;
    }
  }
}
