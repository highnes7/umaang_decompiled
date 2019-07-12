package support.android.asm;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.util.Property;

public class ValueAnimatorCompat
{
  public ValueAnimatorCompat() {}
  
  public static PropertyValuesHolder ofFloat(Property paramProperty, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return PropertyValuesHolder.ofObject(paramProperty, null, paramPath);
    }
    return PropertyValuesHolder.ofFloat(new Item(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}
