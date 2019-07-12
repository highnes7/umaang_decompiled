package f.objectweb.asm;

import android.graphics.Path;
import android.graphics.Path.Direction;

public class LazilyLoadedCtor
  implements FixedStepHandler
{
  public LazilyLoadedCtor(PagerSlidingTabStrip paramPagerSlidingTabStrip) {}
  
  public void init(float paramFloat)
  {
    float f1 = Math.min(1.0F, 2.0F * paramFloat);
    PagerSlidingTabStrip localPagerSlidingTabStrip = this$0;
    width = ((0.2F * f1 + 1.0F) * m);
    f1 = 1.0F - f1;
    level = ((int)(b.y * f1 * 255.0F));
    mPath.reset();
    localPagerSlidingTabStrip = this$0;
    Path localPath = mPath;
    int[] arrayOfInt = x;
    localPath.addCircle(arrayOfInt[0], arrayOfInt[1], width, Path.Direction.CW);
    localPagerSlidingTabStrip = this$0;
    float f2 = 1.0F - paramFloat;
    int i = e;
    t = (i * f2);
    v = ((int)(f2 * 255.0F));
    w = ((paramFloat + 1.0F) * i);
    q = ((int)(f2 * q));
    height = ((int)(f1 * 255.0F));
    localPagerSlidingTabStrip.onDraw();
    localPagerSlidingTabStrip = this$0;
    localPagerSlidingTabStrip.a(rect);
  }
}
