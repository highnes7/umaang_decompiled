package f.objectweb.asm;

import android.graphics.Path;
import android.graphics.Path.Direction;

public class StepNormalizer
  implements FixedStepHandler
{
  public StepNormalizer(PagerSlidingTabStrip paramPagerSlidingTabStrip) {}
  
  public void init(float paramFloat)
  {
    Object localObject2 = this$0;
    Object localObject1 = this;
    float f2 = m * paramFloat;
    int i;
    if (f2 > width) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      this$0.onDraw();
    }
    localObject1 = this;
    localObject2 = this$0;
    float f1 = b.y * 255.0F;
    width = f2;
    f2 = 1.5F * paramFloat;
    level = ((int)Math.min(f1, f2 * f1));
    this$0.mPath.reset();
    localObject2 = this$0;
    Object localObject3 = mPath;
    int[] arrayOfInt = x;
    ((Path)localObject3).addCircle(arrayOfInt[0], arrayOfInt[1], width, Path.Direction.CW);
    this$0.v = ((int)Math.min(255.0F, f2 * 255.0F));
    if (i != 0)
    {
      localObject2 = this$0;
      f1 = e;
      t = (Math.min(1.0F, f2) * f1);
    }
    else
    {
      localObject2 = this$0;
      t = (e * paramFloat);
      w *= paramFloat;
    }
    localObject3 = this$0;
    localObject2 = localObject1;
    height = ((int)(((PagerSlidingTabStrip)localObject3).set(paramFloat, 0.7F) * 255.0F));
    if (i != 0) {
      this$0.onDraw();
    }
    localObject1 = this$0;
    ((PagerSlidingTabStrip)localObject1).a(rect);
  }
}
