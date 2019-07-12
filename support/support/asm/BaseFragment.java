package support.support.asm;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import b.b.a.N;

@N({b.b.a.N.a.b})
public class BaseFragment
  extends android.app.Fragment
{
  public static final String TAG = "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag";
  public Fragment mapView;
  
  public BaseFragment() {}
  
  private void getItem(c paramC)
  {
    Object localObject = getActivity();
    if ((localObject instanceof Item))
    {
      ((Item)localObject).getLifecycle().append(paramC);
      return;
    }
    if ((localObject instanceof d))
    {
      localObject = ((d)localObject).getLifecycle();
      if ((localObject instanceof MethodWriter)) {
        ((MethodWriter)localObject).append(paramC);
      }
    }
  }
  
  public static BaseFragment onPause(Activity paramActivity)
  {
    return (BaseFragment)paramActivity.getFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  private void onPause(Fragment paramFragment)
  {
    if (paramFragment != null) {
      paramFragment.onCreate();
    }
  }
  
  private void onResume(Fragment paramFragment)
  {
    if (paramFragment != null) {
      paramFragment.onResume();
    }
  }
  
  private void onStart(Fragment paramFragment)
  {
    if (paramFragment != null) {
      paramFragment.onStart();
    }
  }
  
  public static void showDialog(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new BaseFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = mapView;
    if (paramBundle != null) {
      paramBundle.onCreate();
    }
    getItem(c.ON_CREATE);
  }
  
  public void onActivityCreated(Fragment paramFragment)
  {
    mapView = paramFragment;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getItem(c.ON_DESTROY);
    mapView = null;
  }
  
  public void onPause()
  {
    super.onPause();
    getItem(c.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    Fragment localFragment = mapView;
    if (localFragment != null) {
      localFragment.onResume();
    }
    getItem(c.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    Fragment localFragment = mapView;
    if (localFragment != null) {
      localFragment.onStart();
    }
    getItem(c.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    getItem(c.ON_STOP);
  }
}
