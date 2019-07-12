package com.google.android.android.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.package_7.DialogFragment;
import android.support.v4.package_7.FragmentManager;
import com.google.android.android.common.internal.zzbp;

public class SupportErrorDialogFragment
  extends DialogFragment
{
  public Dialog mDialog = null;
  public DialogInterface.OnCancelListener zzffh = null;
  
  public SupportErrorDialogFragment() {}
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog)
  {
    return newInstance(paramDialog, null);
  }
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    SupportErrorDialogFragment localSupportErrorDialogFragment = new SupportErrorDialogFragment();
    zzbp.get(paramDialog, "Cannot display null dialog");
    paramDialog = (Dialog)paramDialog;
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    mDialog = paramDialog;
    if (paramOnCancelListener != null) {
      zzffh = paramOnCancelListener;
    }
    return localSupportErrorDialogFragment;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnCancelListener localOnCancelListener = zzffh;
    if (localOnCancelListener != null) {
      localOnCancelListener.onCancel(paramDialogInterface);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if (mDialog == null) {
      setShowsDialog(false);
    }
    return mDialog;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    super.show(paramFragmentManager, paramString);
  }
}
