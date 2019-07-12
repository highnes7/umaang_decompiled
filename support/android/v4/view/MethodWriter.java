package support.android.v4.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnUnhandledKeyEventListener;
import b.b.a.K;

@K(28)
public class MethodWriter
  implements View.OnUnhandledKeyEventListener
{
  public x access;
  
  public MethodWriter(x paramX)
  {
    access = paramX;
  }
  
  public boolean onUnhandledKeyEvent(View paramView, KeyEvent paramKeyEvent)
  {
    return access.onUnhandledKeyEvent(paramView, paramKeyEvent);
  }
}
