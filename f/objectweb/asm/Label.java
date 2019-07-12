package f.objectweb.asm;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;

public class Label
{
  public Label() {}
  
  public static int a(int paramInt, float paramFloat)
  {
    float f;
    if (paramFloat > 1.0F)
    {
      f = 1.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat <= 0.0F) {
        f = 0.0F;
      }
    }
    return paramInt & 0xFFFFFF | (int)((paramInt >>> 24) * f) << 24;
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(2, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int getColor(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int getColor(Context paramContext, String paramString)
  {
    Resources.Theme localTheme = paramContext.getTheme();
    if (localTheme == null) {
      return -1;
    }
    TypedValue localTypedValue = new TypedValue();
    int i = paramContext.getResources().getIdentifier(paramString, "attr", paramContext.getPackageName());
    if (i == 0) {
      return -1;
    }
    localTheme.resolveAttribute(i, localTypedValue, true);
    return data;
  }
}
