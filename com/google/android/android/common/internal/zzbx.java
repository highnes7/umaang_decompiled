package com.google.android.android.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.android.R.color;
import com.google.android.android.R.drawable;
import com.google.android.android.R.string;
import com.google.android.android.common.util.IpAddress;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import support.android.v4.internal.drawable.DrawableCompat;

public final class zzbx
  extends Button
{
  public zzbx(Context paramContext)
  {
    super(paramContext, null, 16842824);
  }
  
  public zzbx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, null, 16842824);
  }
  
  public static int getPath(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          return paramInt4;
        }
        throw new IllegalStateException(StringBuilder.add(33, "Unknown color scheme: ", paramInt1));
      }
    }
    else {
      return paramInt2;
    }
    return paramInt3;
  }
  
  public final void init(Resources paramResources, int paramInt1, int paramInt2)
  {
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    int i = (int)(getDisplayMetricsdensity * 48.0F + 0.5F);
    setMinHeight(i);
    setMinWidth(i);
    i = R.drawable.common_google_signin_btn_icon_dark;
    int j = R.drawable.common_google_signin_btn_icon_light;
    i = getPath(paramInt2, i, j, j);
    j = R.drawable.common_google_signin_btn_text_dark;
    int k = R.drawable.common_google_signin_btn_text_light;
    j = getPath(paramInt2, j, k, k);
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if (paramInt1 != 2) {
        throw new IllegalStateException(StringBuilder.add(32, "Unknown button size: ", paramInt1));
      }
    }
    else {
      i = j;
    }
    Object localObject = DrawableCompat.wrap(paramResources.getDrawable(i));
    DrawableCompat.setTintList((Drawable)localObject, paramResources.getColorStateList(R.color.common_google_signin_btn_tint));
    DrawableCompat.setTintMode((Drawable)localObject, PorterDuff.Mode.SRC_ATOP);
    setBackgroundDrawable((Drawable)localObject);
    i = R.color.common_google_signin_btn_text_dark;
    j = R.color.common_google_signin_btn_text_light;
    localObject = paramResources.getColorStateList(getPath(paramInt2, i, j, j));
    zzbp.append(localObject);
    setTextColor((ColorStateList)localObject);
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2)
        {
          setText(null);
          break label258;
        }
        throw new IllegalStateException(StringBuilder.add(32, "Unknown button size: ", paramInt1));
      }
      paramInt1 = R.string.common_signin_button_text_long;
    }
    else
    {
      paramInt1 = R.string.common_signin_button_text;
    }
    setText(paramResources.getString(paramInt1));
    label258:
    setTransformationMethod(null);
    if (IpAddress.zzci(getContext())) {
      setGravity(19);
    }
  }
}
