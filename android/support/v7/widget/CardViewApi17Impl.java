package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import b.b.a.K;

@K(17)
public class CardViewApi17Impl
  extends CardViewBaseImpl
{
  public CardViewApi17Impl() {}
  
  public void initStatic()
  {
    RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper()
    {
      public void drawRoundRect(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        paramAnonymousCanvas.drawRoundRect(paramAnonymousRectF, paramAnonymousFloat, paramAnonymousFloat, paramAnonymousPaint);
      }
    };
  }
}
