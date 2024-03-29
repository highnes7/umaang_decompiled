package android.support.design.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;

@TargetApi(21)
public class MaterialButtonBackgroundDrawable
  extends RippleDrawable
{
  public MaterialButtonBackgroundDrawable(ColorStateList paramColorStateList, InsetDrawable paramInsetDrawable, Drawable paramDrawable)
  {
    super(paramColorStateList, paramInsetDrawable, paramDrawable);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (getDrawable(0) != null) {
      ((GradientDrawable)((LayerDrawable)((InsetDrawable)getDrawable(0)).getDrawable()).getDrawable(0)).setColorFilter(paramColorFilter);
    }
  }
}
