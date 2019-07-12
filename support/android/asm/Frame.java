package support.android.asm;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

public class Frame
{
  public static final int EMBED = 12;
  public static final String TAG = "ViewUtils";
  public static final l a;
  public static Field b;
  public static final Property<View, Float> c = new VideoCapture(Float.class, "translationAlpha");
  public static boolean e;
  public static final Property<View, Rect> table = new NativeUint8Array(Rect.class, "clipBounds");
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 22) {
      a = new e();
    } else if (i >= 21) {
      a = new i();
    } else {
      a = new h();
    }
  }
  
  public Frame() {}
  
  public static x a(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return new NavigationMenuPresenter(paramView);
  }
  
  public static void a(View paramView, float paramFloat)
  {
    a.a(paramView, paramFloat);
  }
  
  public static void a(View paramView, Matrix paramMatrix)
  {
    a.draw(paramView, paramMatrix);
  }
  
  public static void b(View paramView)
  {
    a.setTitle(paramView);
  }
  
  public static void b(View paramView, Matrix paramMatrix)
  {
    a.a(paramView, paramMatrix);
  }
  
  public static void c(View paramView)
  {
    a.b(paramView);
  }
  
  public static void c(View paramView, Matrix paramMatrix)
  {
    a.b(paramView, paramMatrix);
  }
  
  public static float d(View paramView)
  {
    return a.a(paramView);
  }
  
  public static Object get(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return new GOST3410ParameterSpec(paramView);
  }
  
  public static void init()
  {
    if (!e)
    {
      try
      {
        Field localField = View.class.getDeclaredField("mViewFlags");
        b = localField;
        localField = b;
        localField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;) {}
      }
      e = true;
      return;
    }
  }
  
  public static void set(View paramView, int paramInt)
  {
    init();
    Field localField = b;
    if (localField != null) {
      try
      {
        int i = localField.getInt(paramView);
        localField = b;
        localField.setInt(paramView, paramInt | i & 0xFFFFFFF3);
        return;
      }
      catch (IllegalAccessException paramView) {}
    }
  }
  
  public static void set(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}
