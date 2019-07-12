package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition
  extends TransitionSet
{
  public AutoTransition()
  {
    onCreate();
  }
  
  public AutoTransition(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    onCreate();
  }
  
  private void onCreate()
  {
    a(1);
    add(new Fade(2)).add(new ChangeBounds()).add(new Fade(1));
  }
}
