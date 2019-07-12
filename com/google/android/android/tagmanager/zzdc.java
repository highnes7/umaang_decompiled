package com.google.android.android.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.android.gms.tagmanager.zzp;

@TargetApi(12)
public final class zzdc<K, V>
  implements zzp<K, V>
{
  public LruCache<K, V> zzjsp;
  
  public zzdc(int paramInt, ImageLoader.ImageCache paramImageCache)
  {
    zzjsp = new zzdd(this, 1048576, paramImageCache);
  }
  
  public final Object get(Object paramObject)
  {
    return zzjsp.get(paramObject);
  }
  
  public final void put(Object paramObject1, Object paramObject2)
  {
    zzjsp.put(paramObject1, paramObject2);
  }
}
