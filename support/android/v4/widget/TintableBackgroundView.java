package support.android.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import b.b.a.N;

@N({b.b.a.N.a.b})
public abstract interface TintableBackgroundView
{
  public abstract ColorStateList getSupportImageTintList();
  
  public abstract PorterDuff.Mode getSupportImageTintMode();
  
  public abstract void setSupportImageTintList(ColorStateList paramColorStateList);
  
  public abstract void setSupportImageTintMode(PorterDuff.Mode paramMode);
}
