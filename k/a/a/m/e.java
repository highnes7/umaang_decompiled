package k.a.a.m;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import in.spicedigital.umang.activities.UpdateProfileScreen;

public final class e
  implements View.OnClickListener
{
  public e(f paramF, Activity paramActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = a.get(f.A, "");
    ((UpdateProfileScreen)b).h(paramView);
    d.dismiss();
  }
}
