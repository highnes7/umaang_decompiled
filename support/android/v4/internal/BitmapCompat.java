package support.android.v4.internal;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class BitmapCompat
{
  public BitmapCompat() {}
  
  public static int getAllocationByteCount(Bitmap paramBitmap)
  {
    int i = Build.VERSION.SDK_INT;
    return paramBitmap.getAllocationByteCount();
  }
  
  public static boolean hasMipMap(Bitmap paramBitmap)
  {
    int i = Build.VERSION.SDK_INT;
    return paramBitmap.hasMipMap();
  }
  
  public static void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    paramBitmap.setHasMipMap(paramBoolean);
  }
}
