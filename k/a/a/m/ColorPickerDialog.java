package k.a.a.m;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import in.spicedigital.umang.activities.LoginScreen;

public final class ColorPickerDialog
  implements View.OnClickListener
{
  public ColorPickerDialog(Dialog paramDialog, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    dialog.cancel();
    paramView = new Intent(mContext, LoginScreen.class);
    mContext.startActivity(paramView);
  }
}
