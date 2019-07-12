package android.support.v4.package_7;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class DialogFragment
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  public static final String SAVED_BACK_STACK_ID = "android:backStackId";
  public static final String SAVED_CANCELABLE = "android:cancelable";
  public static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
  public static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
  public static final String SAVED_STYLE = "android:style";
  public static final String SAVED_THEME = "android:theme";
  public static final int STYLE_NORMAL = 0;
  public static final int STYLE_NO_FRAME = 2;
  public static final int STYLE_NO_INPUT = 3;
  public static final int STYLE_NO_TITLE = 1;
  public int mBackStackId = -1;
  public boolean mCancelable = true;
  public Dialog mDialog;
  public boolean mDismissed;
  public boolean mShownByMe;
  public boolean mShowsDialog = true;
  public int mStyle = 0;
  public int mTheme = 0;
  public boolean mViewDestroyed;
  
  public DialogFragment() {}
  
  public void dismiss()
  {
    dismissInternal(false);
  }
  
  public void dismissAllowingStateLoss()
  {
    dismissInternal(true);
  }
  
  public void dismissInternal(boolean paramBoolean)
  {
    if (mDismissed) {
      return;
    }
    mDismissed = true;
    mShownByMe = false;
    Object localObject = mDialog;
    if (localObject != null) {
      ((Dialog)localObject).dismiss();
    }
    mViewDestroyed = true;
    if (mBackStackId >= 0)
    {
      getFragmentManager().popBackStack(mBackStackId, 1);
      mBackStackId = -1;
      return;
    }
    localObject = getFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).remove(this);
    if (paramBoolean)
    {
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
    ((FragmentTransaction)localObject).commit();
  }
  
  public Dialog getDialog()
  {
    return mDialog;
  }
  
  public boolean getShowsDialog()
  {
    return mShowsDialog;
  }
  
  public int getTheme()
  {
    return mTheme;
  }
  
  public boolean isCancelable()
  {
    return mCancelable;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    mCalled = true;
    if (!mShowsDialog) {
      return;
    }
    Object localObject = getView();
    if (localObject != null) {
      if (((View)localObject).getParent() == null) {
        mDialog.setContentView((View)localObject);
      } else {
        throw new IllegalStateException("DialogFragment can not be attached to a container view");
      }
    }
    localObject = getActivity();
    if (localObject != null) {
      mDialog.setOwnerActivity((Activity)localObject);
    }
    mDialog.setCancelable(mCancelable);
    mDialog.setOnCancelListener(this);
    mDialog.setOnDismissListener(this);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("android:savedDialogState");
      if (paramBundle != null) {
        mDialog.onRestoreInstanceState(paramBundle);
      }
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (!mShownByMe) {
      mDismissed = false;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool;
    if (mContainerId == 0) {
      bool = true;
    } else {
      bool = false;
    }
    mShowsDialog = bool;
    if (paramBundle != null)
    {
      mStyle = paramBundle.getInt("android:style", 0);
      mTheme = paramBundle.getInt("android:theme", 0);
      mCancelable = paramBundle.getBoolean("android:cancelable", true);
      mShowsDialog = paramBundle.getBoolean("android:showsDialog", mShowsDialog);
      mBackStackId = paramBundle.getInt("android:backStackId", -1);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new Dialog(getActivity(), getTheme());
  }
  
  public void onDestroyView()
  {
    mCalled = true;
    Dialog localDialog = mDialog;
    if (localDialog != null)
    {
      mViewDestroyed = true;
      localDialog.dismiss();
      mDialog = null;
    }
  }
  
  public void onDetach()
  {
    mCalled = true;
    if ((!mShownByMe) && (!mDismissed)) {
      mDismissed = true;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!mViewDestroyed) {
      dismissInternal(true);
    }
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    if (!mShowsDialog) {
      return getLayoutInflater(paramBundle);
    }
    mDialog = onCreateDialog(paramBundle);
    paramBundle = mDialog;
    if (paramBundle != null)
    {
      setupDialog(paramBundle, mStyle);
      return (LayoutInflater)mDialog.getContext().getSystemService("layout_inflater");
    }
    return (LayoutInflater)mHost.getContext().getSystemService("layout_inflater");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Object localObject = mDialog;
    if (localObject != null)
    {
      localObject = ((Dialog)localObject).onSaveInstanceState();
      if (localObject != null) {
        paramBundle.putBundle("android:savedDialogState", (Bundle)localObject);
      }
    }
    int i = mStyle;
    if (i != 0) {
      paramBundle.putInt("android:style", i);
    }
    i = mTheme;
    if (i != 0) {
      paramBundle.putInt("android:theme", i);
    }
    boolean bool = mCancelable;
    if (!bool) {
      paramBundle.putBoolean("android:cancelable", bool);
    }
    bool = mShowsDialog;
    if (!bool) {
      paramBundle.putBoolean("android:showsDialog", bool);
    }
    i = mBackStackId;
    if (i != -1) {
      paramBundle.putInt("android:backStackId", i);
    }
  }
  
  public void onStart()
  {
    mCalled = true;
    Dialog localDialog = mDialog;
    if (localDialog != null)
    {
      mViewDestroyed = false;
      localDialog.show();
    }
  }
  
  public void onStop()
  {
    mCalled = true;
    Dialog localDialog = mDialog;
    if (localDialog != null) {
      localDialog.hide();
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    mCancelable = paramBoolean;
    Dialog localDialog = mDialog;
    if (localDialog != null) {
      localDialog.setCancelable(paramBoolean);
    }
  }
  
  public void setShowsDialog(boolean paramBoolean)
  {
    mShowsDialog = paramBoolean;
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    mStyle = paramInt1;
    paramInt1 = mStyle;
    if ((paramInt1 == 2) || (paramInt1 == 3)) {
      mTheme = 16973913;
    }
    if (paramInt2 != 0) {
      mTheme = paramInt2;
    }
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return;
      }
      paramDialog.getWindow().addFlags(24);
    }
    paramDialog.requestWindowFeature(1);
  }
  
  public int show(FragmentTransaction paramFragmentTransaction, String paramString)
  {
    mDismissed = false;
    mShownByMe = true;
    paramFragmentTransaction.add(this, paramString);
    mViewDestroyed = false;
    mBackStackId = paramFragmentTransaction.commit();
    return mBackStackId;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    mDismissed = false;
    mShownByMe = true;
    paramFragmentManager = paramFragmentManager.beginTransaction();
    paramFragmentManager.add(this, paramString);
    paramFragmentManager.commit();
  }
  
  public void showNow(FragmentManager paramFragmentManager, String paramString)
  {
    mDismissed = false;
    mShownByMe = true;
    paramFragmentManager = paramFragmentManager.beginTransaction();
    paramFragmentManager.add(this, paramString);
    paramFragmentManager.commitNow();
  }
}
