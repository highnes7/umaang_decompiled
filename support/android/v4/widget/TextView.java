package support.android.v4.widget;

import android.os.Build.VERSION;
import b.b.a.N;

@N({b.b.a.N.a.b})
public abstract interface TextView
{
  @N({b.b.a.N.a.b})
  public static final boolean isInit;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 27) {
      bool = true;
    } else {
      bool = false;
    }
    isInit = bool;
  }
  
  public abstract int getAutoSizeMaxTextSize();
  
  public abstract int getAutoSizeMinTextSize();
  
  public abstract int getAutoSizeStepGranularity();
  
  public abstract int[] getAutoSizeTextAvailableSizes();
  
  public abstract int getAutoSizeTextType();
  
  public abstract void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException;
  
  public abstract void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException;
  
  public abstract void setAutoSizeTextTypeWithDefaults(int paramInt);
}
