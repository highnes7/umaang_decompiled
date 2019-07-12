package com.google.android.android.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.package_7.Fragment;
import com.google.android.android.common.package_9.internal.zzcg;

public abstract class ListItem
  implements DialogInterface.OnClickListener
{
  public ListItem() {}
  
  public static ListItem getView(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    return new SettingsFragment.4(paramIntent, paramFragment, paramInt);
  }
  
  public static ListItem setTitle(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return new Factory(paramIntent, paramActivity, paramInt);
  }
  
  public static ListItem toString(zzcg paramZzcg, Intent paramIntent, int paramInt)
  {
    return new Delta(paramIntent, paramZzcg, 2);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      zzaka();
      paramDialogInterface.dismiss();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramDialogInterface.dismiss();
      throw localThrowable;
      paramDialogInterface.dismiss();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public abstract void zzaka();
}
