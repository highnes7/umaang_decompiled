package support.android.v4.internal.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import b.b.a.K;

@K(21)
public class RoundedBitmapDrawable21
  extends RoundedBitmapDrawable
{
  public RoundedBitmapDrawable21(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public void getOutline(Outline paramOutline)
  {
    updateDstRect();
    paramOutline.setRoundRect(mDstRect, getCornerRadius());
  }
  
  public void gravityCompatApply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
  }
  
  public boolean hasMipMap()
  {
    Bitmap localBitmap = mBitmap;
    return (localBitmap != null) && (localBitmap.hasMipMap());
  }
  
  public void setMipMap(boolean paramBoolean)
  {
    Bitmap localBitmap = mBitmap;
    if (localBitmap != null)
    {
      localBitmap.setHasMipMap(paramBoolean);
      invalidateSelf();
    }
  }
}
