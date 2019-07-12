package f.objectweb.asm;

import android.view.View;

public class e
  extends f
{
  public final View a;
  
  public e(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    super(paramCharSequence1, paramCharSequence2);
    if (paramView != null)
    {
      a = paramView;
      return;
    }
    throw new IllegalArgumentException("Given null view to target");
  }
  
  public void a(Runnable paramRunnable)
  {
    b.a(a, new Plot.a(this, paramRunnable));
  }
}
