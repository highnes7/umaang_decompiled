package com.google.android.android.tagmanager;

import com.google.android.gms.tagmanager.zzs;

public final class TileCache<K, V>
{
  public zzs<K, V> zzjoy = new BitmapLruCache(this);
  
  public TileCache() {}
  
  public static Cache createCache(int paramInt, ImageLoader.ImageCache paramImageCache)
  {
    return new zzdc(1048576, paramImageCache);
  }
}
