package com.google.android.android.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.android.common.internal.TextUtils;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.internal.zzbcd;
import com.google.android.android.internal.zzbci;
import java.lang.ref.WeakReference;

public final class Layer
  extends ImageLoader
{
  public WeakReference<ImageView> zzfrw;
  
  public Layer(ImageView paramImageView, int paramInt)
  {
    super(null, paramInt);
    TextUtils.replace(paramImageView);
    zzfrw = new WeakReference(paramImageView);
  }
  
  public Layer(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    TextUtils.replace(paramImageView);
    zzfrw = new WeakReference(paramImageView);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Layer)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    Object localObject = (Layer)paramObject;
    paramObject = (ImageView)zzfrw.get();
    localObject = (ImageView)zzfrw.get();
    return (localObject != null) && (paramObject != null) && (zzbf.equal(localObject, paramObject));
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ImageView localImageView = (ImageView)zzfrw.get();
    if (localImageView != null)
    {
      int i;
      if ((!paramBoolean2) && (!paramBoolean3)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && ((localImageView instanceof zzbci)))
      {
        zzbci.zzajc();
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      paramBoolean1 = get(paramBoolean1, paramBoolean2);
      Object localObject = paramDrawable;
      if (paramBoolean1)
      {
        Drawable localDrawable = localImageView.getDrawable();
        localObject = localDrawable;
        if (localDrawable != null)
        {
          if ((localDrawable instanceof zzbcd)) {
            localObject = ((zzbcd)localDrawable).zzaja();
          }
        }
        else {
          localObject = null;
        }
        localObject = new zzbcd((Drawable)localObject, paramDrawable);
      }
      localImageView.setImageDrawable((Drawable)localObject);
      if ((localImageView instanceof zzbci))
      {
        if (paramBoolean3) {
          paramDrawable = zzfrp.uri;
        } else {
          paramDrawable = null;
        }
        zzbci.extract(paramDrawable);
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      if (paramBoolean1) {
        ((zzbcd)localObject).startTransition(250);
      }
    }
  }
}
