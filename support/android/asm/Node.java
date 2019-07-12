package support.android.asm;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public class Node
  implements TypeEvaluator<Rect>
{
  public Rect next;
  
  public Node() {}
  
  public Node(Rect paramRect)
  {
    next = paramRect;
  }
  
  public Rect evaluate(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    int i = left;
    i += (int)((left - i) * paramFloat);
    int j = top;
    j += (int)((top - j) * paramFloat);
    int k = right;
    k += (int)((right - k) * paramFloat);
    int m = bottom;
    m += (int)((bottom - m) * paramFloat);
    paramRect1 = next;
    if (paramRect1 == null) {
      return new Rect(i, j, k, m);
    }
    paramRect1.set(i, j, k, m);
    return next;
  }
}
