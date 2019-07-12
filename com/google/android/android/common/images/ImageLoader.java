package com.google.android.android.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.android.common.internal.TextUtils;
import com.google.android.android.internal.zzbcj;

public abstract class ImageLoader
{
  public final BitmapLoader zzfrp;
  public int zzfrq = 0;
  public int zzfrr = 0;
  public boolean zzfrs = false;
  public boolean zzfrt = true;
  public boolean zzfru = false;
  public boolean zzfrv = true;
  
  public ImageLoader(Uri paramUri, int paramInt)
  {
    zzfrp = new BitmapLoader(paramUri);
    zzfrr = paramInt;
  }
  
  public final boolean get(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (zzfrt) && (!paramBoolean2) && (!paramBoolean1);
  }
  
  public final void load(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    TextUtils.replace(paramBitmap);
    loadImage(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }
  
  public final void load(Context paramContext, zzbcj paramZzbcj)
  {
    if (zzfrv) {
      loadImage(null, false, true, false);
    }
  }
  
  public final void load(Context paramContext, zzbcj paramZzbcj, boolean paramBoolean)
  {
    int i = zzfrr;
    if (i != 0) {
      paramContext = paramContext.getResources().getDrawable(i);
    } else {
      paramContext = null;
    }
    loadImage(paramContext, paramBoolean, false, false);
  }
  
  public abstract void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}
