package support.android.asm;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import support.android.v4.view.ViewCompat;

public final class NativeUint8Array
  extends Property<View, Rect>
{
  public NativeUint8Array(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Rect get(View paramView)
  {
    return ViewCompat.create(paramView);
  }
  
  public void init(View paramView, Rect paramRect)
  {
    ViewCompat.get(paramView, paramRect);
  }
}
