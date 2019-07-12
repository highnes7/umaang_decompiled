package f.libs.asm.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class n
  implements DialogInterface.OnClickListener
{
  public n(ac paramAc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.cancel(false);
    paramDialogInterface.dismiss();
  }
}
