package android.support.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion
{
  public PathMotion() {}
  
  public PathMotion(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public abstract Path draw(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
}
