package com.google.android.android.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public final class zzbch
  extends Drawable.ConstantState
{
  public int mChangingConfigurations;
  public int zzfsn;
  
  public zzbch(zzbch paramZzbch)
  {
    if (paramZzbch != null)
    {
      mChangingConfigurations = mChangingConfigurations;
      zzfsn = zzfsn;
    }
  }
  
  public final int getChangingConfigurations()
  {
    return mChangingConfigurations;
  }
  
  public final Drawable newDrawable()
  {
    return new zzbcd(this);
  }
}
