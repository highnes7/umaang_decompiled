package support.android.asm;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public final class NativeFloat32Array
  extends Property<ImageView, Matrix>
{
  public NativeFloat32Array(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Matrix get(ImageView paramImageView)
  {
    return null;
  }
  
  public void set(ImageView paramImageView, Matrix paramMatrix)
  {
    Handler.a(paramImageView, paramMatrix);
  }
}
