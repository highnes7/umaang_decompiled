package android.support.design.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import b.b.a.N;

@N({b.b.a.N.a.b})
public class DrawableUtils
{
  public DrawableUtils() {}
  
  public static PorterDuffColorFilter updateTintFilter(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(paramDrawable.getState(), 0), paramMode);
    }
    return null;
  }
}
