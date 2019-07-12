package support.android.asm;

import android.util.Property;
import android.view.View;

public final class VideoCapture
  extends Property<View, Float>
{
  public VideoCapture(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float get(View paramView)
  {
    return Float.valueOf(Frame.d(paramView));
  }
  
  public void set(View paramView, Float paramFloat)
  {
    float f = paramFloat.floatValue();
    Frame.a.a(paramView, f);
  }
}
