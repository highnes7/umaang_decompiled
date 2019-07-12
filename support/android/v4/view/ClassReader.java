package support.android.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;

public final class ClassReader
{
  public static final int EXPAND_FRAMES = 8;
  public static final int STANDARD_GAP_WIDTH = 10;
  public static final int b = 9;
  
  public ClassReader() {}
  
  public static View b(Window paramWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramWindow.requireViewById(paramInt);
    }
    paramWindow = paramWindow.findViewById(paramInt);
    if (paramWindow != null) {
      return paramWindow;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this Window");
  }
}
