package support.android.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import b.b.x.o.Y;

public class WindowInsetsCompat
{
  public final Object mSource;
  
  public WindowInsetsCompat(Object paramObject)
  {
    mSource = paramObject;
  }
  
  public WindowInsetsCompat(WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = null;
    if (i >= 20)
    {
      if (paramWindowInsetsCompat == null) {
        paramWindowInsetsCompat = localObject;
      } else {
        paramWindowInsetsCompat = new WindowInsets((WindowInsets)mSource);
      }
      mSource = paramWindowInsetsCompat;
      return;
    }
    mSource = null;
  }
  
  public static Object unwrap(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat == null) {
      return null;
    }
    return mSource;
  }
  
  public static WindowInsetsCompat unwrap(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new WindowInsetsCompat(paramObject);
  }
  
  public Label a()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Label.a(((WindowInsets)mSource).getDisplayCutout());
    }
    return null;
  }
  
  public WindowInsetsCompat consumeSystemWindowInsets()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new WindowInsetsCompat(((WindowInsets)mSource).consumeSystemWindowInsets());
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (Y.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (WindowInsetsCompat)paramObject;
      Object localObject = mSource;
      if (localObject == null) {
        return mSource == null;
      }
      return localObject.equals(mSource);
    }
    return false;
  }
  
  public WindowInsetsCompat get(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new WindowInsetsCompat(((WindowInsets)mSource).replaceSystemWindowInsets(paramRect));
    }
    return null;
  }
  
  public boolean get()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)mSource).hasSystemWindowInsets();
    }
    return false;
  }
  
  public int getStableInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)mSource).getStableInsetBottom();
    }
    return 0;
  }
  
  public int getStableInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)mSource).getStableInsetLeft();
    }
    return 0;
  }
  
  public int getStableInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)mSource).getStableInsetRight();
    }
    return 0;
  }
  
  public int getStableInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)mSource).getStableInsetTop();
    }
    return 0;
  }
  
  public int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)mSource).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)mSource).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)mSource).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)mSource).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public WindowInsetsCompat getTopInset()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new WindowInsetsCompat(((WindowInsets)mSource).consumeStableInsets());
    }
    return null;
  }
  
  public boolean hasInsets()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)mSource).hasInsets();
    }
    return false;
  }
  
  public boolean hasStableInsets()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)mSource).hasStableInsets();
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = mSource;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)mSource).isConsumed();
    }
    return false;
  }
  
  public boolean isRound()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)mSource).isRound();
    }
    return false;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new WindowInsetsCompat(((WindowInsets)mSource).consumeDisplayCutout());
    }
    return this;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new WindowInsetsCompat(((WindowInsets)mSource).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
}
