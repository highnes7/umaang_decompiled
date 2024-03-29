package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import support.android.v4.content.ContextCompat;
import support.android.v4.content.asm.Type;

public final class AppCompatResources
{
  public static final String LOG_TAG = "AppCompatResources";
  public static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();
  public static final Object sColorStateCacheLock = new Object();
  public static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap(0);
  
  public AppCompatResources() {}
  
  public static void addColorStateListToCache(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    Object localObject = sColorStateCacheLock;
    try
    {
      SparseArray localSparseArray2 = (SparseArray)sColorStateCaches.get(paramContext);
      SparseArray localSparseArray1 = localSparseArray2;
      if (localSparseArray2 == null)
      {
        localSparseArray1 = new SparseArray();
        sColorStateCaches.put(paramContext, localSparseArray1);
      }
      localSparseArray1.append(paramInt, new ColorStateListCacheEntry(paramColorStateList, paramContext.getResources().getConfiguration()));
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static ColorStateList getCachedColorStateList(Context paramContext, int paramInt)
  {
    Object localObject = sColorStateCacheLock;
    try
    {
      SparseArray localSparseArray = (SparseArray)sColorStateCaches.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        ColorStateListCacheEntry localColorStateListCacheEntry = (ColorStateListCacheEntry)localSparseArray.get(paramInt);
        if (localColorStateListCacheEntry != null)
        {
          if (configuration.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = value;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static ColorStateList getColorStateList(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    ColorStateList localColorStateList = getCachedColorStateList(paramContext, paramInt);
    if (localColorStateList != null) {
      return localColorStateList;
    }
    localColorStateList = inflateColorStateList(paramContext, paramInt);
    if (localColorStateList != null)
    {
      addColorStateListToCache(paramContext, paramInt, localColorStateList);
      return localColorStateList;
    }
    return ContextCompat.getColorStateList(paramContext, paramInt);
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    return AppCompatDrawableManager.get().getDrawable(paramContext, paramInt);
  }
  
  public static TypedValue getTypedValue()
  {
    TypedValue localTypedValue2 = (TypedValue)TL_TYPED_VALUE.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      TL_TYPED_VALUE.set(localTypedValue1);
    }
    return localTypedValue1;
  }
  
  public static ColorStateList inflateColorStateList(Context paramContext, int paramInt)
  {
    if (isColorInt(paramContext, paramInt)) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    XmlResourceParser localXmlResourceParser = localResources.getXml(paramInt);
    try
    {
      paramContext = Type.create(localResources, localXmlResourceParser, paramContext.getTheme());
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static boolean isColorInt(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    TypedValue localTypedValue = getTypedValue();
    paramContext.getValue(paramInt, localTypedValue, true);
    paramInt = type;
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  private static class ColorStateListCacheEntry
  {
    public final Configuration configuration;
    public final ColorStateList value;
    
    public ColorStateListCacheEntry(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      value = paramColorStateList;
      configuration = paramConfiguration;
    }
  }
}
