package android.support.v4.package_7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentContainer;
import android.view.LayoutInflater;
import android.view.View;
import b.b.a.F;
import b.b.a.G;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import support.android.v4.util.Label;

public abstract class FragmentHostCallback<E>
  extends FragmentContainer
{
  @G
  public final Activity mActivity;
  @F
  public final Context mContext;
  public final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();
  @F
  public final Handler mHandler;
  public final int mWindowAnimations;
  
  public FragmentHostCallback(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt)
  {
    mActivity = paramActivity;
    Label.getKey(paramContext, "context == null");
    mContext = ((Context)paramContext);
    Label.getKey(paramHandler, "handler == null");
    mHandler = ((Handler)paramHandler);
    mWindowAnimations = paramInt;
  }
  
  public FragmentHostCallback(Context paramContext, Handler paramHandler, int paramInt)
  {
    this(localActivity, paramContext, paramHandler, paramInt);
  }
  
  public FragmentHostCallback(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, mHandler, 0);
  }
  
  public Activity getActivity()
  {
    return mActivity;
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public FragmentManagerImpl getFragmentManagerImpl()
  {
    return mFragmentManager;
  }
  
  public Handler getHandler()
  {
    return mHandler;
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  public abstract Object onGetHost();
  
  public LayoutInflater onGetLayoutInflater()
  {
    return LayoutInflater.from(mContext);
  }
  
  public int onGetWindowAnimations()
  {
    return mWindowAnimations;
  }
  
  public boolean onHasView()
  {
    return true;
  }
  
  public boolean onHasWindowAnimations()
  {
    return true;
  }
  
  public void onRequestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt) {}
  
  public boolean onShouldSaveFragmentState(Fragment paramFragment)
  {
    return true;
  }
  
  public boolean onShouldShowRequestPermissionRationale(String paramString)
  {
    return false;
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    onStartActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      mContext.startActivity(paramIntent);
      return;
    }
    throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
  }
  
  public void onStartIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (paramInt1 == -1)
    {
      ActivityCompat.startIntentSenderForResult(mActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
  }
  
  public void onSupportInvalidateOptionsMenu() {}
}
