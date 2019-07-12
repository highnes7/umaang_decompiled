package com.google.android.android.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.android.common.internal.TextUtils;
import com.google.android.android.common.internal.zzbf;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class Game
  extends ImageLoader
{
  public WeakReference<com.google.android.gms.common.images.ImageManager.OnImageLoadedListener> zzfrx;
  
  public Game(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    super(paramUri, 0);
    TextUtils.replace(paramOnImageLoadedListener);
    zzfrx = new WeakReference(paramOnImageLoadedListener);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Game)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Game)paramObject;
    ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)zzfrx.get();
    ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)zzfrx.get();
    return (localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (zzbf.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (zzbf.equal(zzfrp, zzfrp));
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzfrp });
  }
  
  public final void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean2)
    {
      ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)zzfrx.get();
      if (localOnImageLoadedListener != null) {
        localOnImageLoadedListener.onImageLoaded(zzfrp.uri, paramDrawable, paramBoolean3);
      }
    }
  }
}
