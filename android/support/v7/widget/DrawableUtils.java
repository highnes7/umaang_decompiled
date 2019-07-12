package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import b.b.a.N;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import support.android.v4.internal.drawable.DrawableCompat;

@N({b.b.a.N.a.b})
public class DrawableUtils
{
  public static final Rect INSETS_NONE = new Rect();
  public static final String TAG = "DrawableUtils";
  public static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
  public static Class<?> sInsetsClazz;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    try
    {
      Class localClass = Class.forName("android.graphics.Insets");
      sInsetsClazz = localClass;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public DrawableUtils() {}
  
  public static boolean canSafelyMutateDrawable(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    if ((paramDrawable instanceof DrawableContainer))
    {
      paramDrawable = paramDrawable.getConstantState();
      if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        i = 0;
        while (i < j)
        {
          if (!canSafelyMutateDrawable(paramDrawable[i])) {
            return false;
          }
          i += 1;
        }
      }
    }
    else
    {
      if ((paramDrawable instanceof support.android.v4.internal.drawable.DrawableWrapper)) {
        return canSafelyMutateDrawable(((support.android.v4.internal.drawable.DrawableWrapper)paramDrawable).getWrappedDrawable());
      }
      if ((paramDrawable instanceof android.support.v7.graphics.drawable.DrawableWrapper)) {
        return canSafelyMutateDrawable(((android.support.v7.graphics.drawable.DrawableWrapper)paramDrawable).getWrappedDrawable());
      }
      if ((paramDrawable instanceof ScaleDrawable)) {
        return canSafelyMutateDrawable(((ScaleDrawable)paramDrawable).getDrawable());
      }
    }
    return true;
  }
  
  public static void fixDrawable(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))) {
      fixVectorDrawableTinting(paramDrawable);
    }
  }
  
  public static void fixVectorDrawableTinting(Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
      paramDrawable.setState(ThemeUtils.EMPTY_STATE_SET);
    } else {
      paramDrawable.setState(ThemeUtils.CHECKED_STATE_SET);
    }
    paramDrawable.setState(arrayOfInt);
  }
  
  public static Rect getOpticalBounds(Drawable paramDrawable)
  {
    if (sInsetsClazz != null) {}
    try
    {
      paramDrawable = DrawableCompat.unwrap(paramDrawable);
      Object localObject1 = paramDrawable.getClass();
      localObject1 = ((Class)localObject1).getMethod("getOpticalInsets", new Class[0]);
      paramDrawable = ((Method)localObject1).invoke(paramDrawable, new Object[0]);
      if (paramDrawable != null)
      {
        localObject1 = new Rect();
        Object localObject2 = sInsetsClazz;
        localObject2 = ((Class)localObject2).getFields();
        int k = localObject2.length;
        int j = 0;
        while (j < k)
        {
          Object localObject3 = localObject2[j];
          String str = localObject3.getName();
          int i = -1;
          int m = str.hashCode();
          boolean bool;
          switch (m)
          {
          default: 
            break;
          case 108511772: 
            bool = str.equals("right");
            if (bool) {
              i = 2;
            }
            break;
          case 3317767: 
            bool = str.equals("left");
            if (bool) {
              i = 0;
            }
            break;
          case 115029: 
            bool = str.equals("top");
            if (bool) {
              i = 1;
            }
            break;
          case -1383228885: 
            bool = str.equals("bottom");
            if (bool) {
              i = 3;
            }
            break;
          }
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i == 3)
                {
                  i = localObject3.getInt(paramDrawable);
                  bottom = i;
                }
              }
              else
              {
                i = localObject3.getInt(paramDrawable);
                right = i;
              }
            }
            else
            {
              i = localObject3.getInt(paramDrawable);
              top = i;
            }
          }
          else
          {
            i = localObject3.getInt(paramDrawable);
            left = i;
          }
          j += 1;
        }
        return localObject1;
      }
    }
    catch (Exception paramDrawable)
    {
      for (;;) {}
    }
    return INSETS_NONE;
  }
  
  public static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
}
