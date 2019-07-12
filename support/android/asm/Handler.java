package support.android.asm;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Handler
{
  public static boolean b = false;
  public static Method c;
  public static final String start = "ImageViewUtils";
  
  public Handler() {}
  
  public static void a()
  {
    if (!b)
    {
      try
      {
        Method localMethod = ImageView.class.getDeclaredMethod("animateTransform", new Class[] { Matrix.class });
        c = localMethod;
        localMethod = c;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      b = true;
      return;
    }
  }
  
  public static void a(ImageView paramImageView, Matrix paramMatrix)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramImageView.setImageMatrix(paramMatrix);
      return;
    }
    a();
    Method localMethod = c;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramImageView, new Object[] { paramMatrix });
        return;
      }
      catch (InvocationTargetException paramImageView)
      {
        throw new RuntimeException(paramImageView.getCause());
      }
      catch (IllegalAccessException paramImageView) {}
    }
  }
  
  public static void animate(ImageView paramImageView, Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramAnimator.addListener(new MainActivity.3(paramImageView));
    }
  }
  
  public static void init(ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      ImageView.ScaleType localScaleType1 = paramImageView.getScaleType();
      paramImageView.setTag(R.id.save_scale_type, localScaleType1);
      ImageView.ScaleType localScaleType2 = ImageView.ScaleType.MATRIX;
      if (localScaleType1 == localScaleType2) {
        paramImageView.setTag(R.id.save_image_matrix, paramImageView.getImageMatrix());
      } else {
        paramImageView.setScaleType(localScaleType2);
      }
      paramImageView.setImageMatrix(GA.values);
    }
  }
}
