package android.support.design.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.package_7.DialogFragment;
import android.support.v4.package_7.Fragment;
import android.support.v7.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment
  extends AppCompatDialogFragment
{
  public BottomSheetDialogFragment() {}
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new BottomSheetDialog(getContext(), getTheme());
  }
}
