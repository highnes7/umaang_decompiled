package android.support.design.animation;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import java.util.WeakHashMap;

public class DrawableAlphaProperty
  extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
  public final WeakHashMap<Drawable, Integer> alphaCache = new WeakHashMap();
  
  public DrawableAlphaProperty()
  {
    super(Integer.class, "drawableAlphaCompat");
  }
  
  public Integer get(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    return Integer.valueOf(paramDrawable.getAlpha());
  }
  
  public void setDrawable(Drawable paramDrawable, Integer paramInteger)
  {
    int i = Build.VERSION.SDK_INT;
    paramDrawable.setAlpha(paramInteger.intValue());
  }
}
