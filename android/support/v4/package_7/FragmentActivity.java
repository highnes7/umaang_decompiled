package android.support.v4.package_7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import b.b.x.n.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import support.android.v4.util.SparseArrayCompat;
import support.support.asm.ClassReader;
import support.support.asm.CurrencyUnit;
import support.support.asm.Line;
import support.support.asm.MethodWriter;
import support.support.asm.f;

public class FragmentActivity
  extends SupportActivity
  implements CurrencyUnit, ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator
{
  public static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  public static final String FRAGMENTS_TAG = "android:support:fragments";
  public static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  public static final int MSG_RESUME_PENDING = 2;
  public static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  public static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  public static final String TAG = "FragmentActivity";
  public boolean mCreated;
  public final FragmentController mFragments = new FragmentController(new HostCallbacks());
  public final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (what != 2)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
      }
      onResumeFragments();
      mFragments.execPendingActions();
    }
  };
  public int mNextCandidateRequestIndex;
  public u<String> mPendingFragmentActivityResults;
  public boolean mRequestedPermissionsFromFragment;
  public boolean mResumed;
  public boolean mStartedActivityFromFragment;
  public boolean mStartedIntentSenderFromFragment;
  public boolean mStopped = true;
  public Line mViewModelStore;
  
  public FragmentActivity() {}
  
  private int allocateRequestIndex(Fragment paramFragment)
  {
    if (mPendingFragmentActivityResults.size() < 65534)
    {
      while (mPendingFragmentActivityResults.indexOfKey(mNextCandidateRequestIndex) >= 0) {
        mNextCandidateRequestIndex = ((mNextCandidateRequestIndex + 1) % 65534);
      }
      int i = mNextCandidateRequestIndex;
      mPendingFragmentActivityResults.put(i, mWho);
      mNextCandidateRequestIndex = ((mNextCandidateRequestIndex + 1) % 65534);
      return i;
    }
    paramFragment = new IllegalStateException("Too many pending Fragment activity results.");
    throw paramFragment;
  }
  
  public static void checkForValidRequestCode(int paramInt)
  {
    if ((paramInt & 0xFFFF0000) == 0) {
      return;
    }
    throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
  }
  
  private void markFragmentsCreated()
  {
    while (markState(getSupportFragmentManager(), f.d)) {}
  }
  
  public static boolean markState(FragmentManager paramFragmentManager, f paramF)
  {
    paramFragmentManager = paramFragmentManager.getFragments().iterator();
    boolean bool1 = false;
    while (paramFragmentManager.hasNext())
    {
      Object localObject = (Fragment)paramFragmentManager.next();
      if (localObject != null)
      {
        boolean bool2 = bool1;
        if (((Fragment)localObject).getLifecycle().a().a(f.g))
        {
          mLifecycleRegistry.a(paramF);
          bool2 = true;
        }
        localObject = ((Fragment)localObject).peekChildFragmentManager();
        bool1 = bool2;
        if (localObject != null) {
          bool1 = bool2 | markState((FragmentManager)localObject, paramF);
        }
      }
    }
    return bool1;
  }
  
  public final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return mFragments.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("  ");
    localObject = ((StringBuilder)localObject).toString();
    paramPrintWriter.print((String)localObject);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(mCreated);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(mStopped);
    if (getApplication() != null) {
      LoaderManager.getInstance(this).dump((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    mFragments.getSupportFragmentManager().dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null) {
      return custom;
    }
    return null;
  }
  
  public ClassReader getLifecycle()
  {
    return mLifecycleRegistry;
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return mFragments.getSupportFragmentManager();
  }
  
  public LoaderManager getSupportLoaderManager()
  {
    return LoaderManager.getInstance(this);
  }
  
  public Line getViewModelStore()
  {
    if (getApplication() != null)
    {
      if (mViewModelStore == null)
      {
        NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
        if (localNonConfigurationInstances != null) {
          mViewModelStore = viewModelStore;
        }
        if (mViewModelStore == null) {
          mViewModelStore = new Line();
        }
      }
      return mViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      i -= 1;
      localObject = (String)mPendingFragmentActivityResults.get(i);
      mPendingFragmentActivityResults.put(i);
      if (localObject == null) {
        return;
      }
      Fragment localFragment = mFragments.findFragmentByWho((String)localObject);
      if (localFragment == null)
      {
        f.sufficientlysecure.rootcommands.util.StringBuilder.get("Activity result no fragment exists for who: ", (String)localObject);
        return;
      }
      localFragment.onActivityResult(paramInt1 & 0xFFFF, paramInt2, paramIntent);
      return;
    }
    Object localObject = ActivityCompat.sDelegate;
    if ((localObject != null) && (((ActivityCompat.PermissionCompatDelegate)localObject).onActivityResult(this, paramInt1, paramInt2, paramIntent))) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    FragmentManager localFragmentManager = mFragments.getSupportFragmentManager();
    boolean bool = localFragmentManager.isStateSaved();
    if ((bool) && (Build.VERSION.SDK_INT <= 25)) {
      return;
    }
    if ((bool) || (!localFragmentManager.popBackStackImmediate())) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    mFragments.noteStateNotSaved();
    mFragments.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject2 = mFragments;
    Object localObject1 = null;
    ((FragmentController)localObject2).attachHost(null);
    super.onCreate(paramBundle);
    localObject2 = (NonConfigurationInstances)getLastNonConfigurationInstance();
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = viewModelStore;
      if ((localObject3 != null) && (mViewModelStore == null)) {
        mViewModelStore = ((Line)localObject3);
      }
    }
    if (paramBundle != null)
    {
      localObject3 = paramBundle.getParcelable("android:support:fragments");
      FragmentController localFragmentController = mFragments;
      if (localObject2 != null) {
        localObject1 = fragments;
      }
      localFragmentController.restoreAllState((Parcelable)localObject3, (FragmentManagerNonConfig)localObject1);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        localObject1 = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject1 != null) && (paramBundle != null) && (localObject1.length == paramBundle.length))
        {
          mPendingFragmentActivityResults = new SparseArrayCompat(localObject1.length);
          int i = 0;
          while (i < localObject1.length)
          {
            mPendingFragmentActivityResults.put(localObject1[i], paramBundle[i]);
            i += 1;
          }
        }
      }
    }
    if (mPendingFragmentActivityResults == null)
    {
      mPendingFragmentActivityResults = new SparseArrayCompat(10);
      mNextCandidateRequestIndex = 0;
    }
    mFragments.dispatchCreate();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      return super.onCreatePanelMenu(paramInt, paramMenu) | mFragments.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    if (localView == null) {
      return super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView2 = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((mViewModelStore != null) && (!isChangingConfigurations())) {
      mViewModelStore.reset();
    }
    mFragments.dispatchDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    mFragments.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    if (paramInt != 0)
    {
      if (paramInt != 6) {
        return false;
      }
      return mFragments.dispatchContextItemSelected(paramMenuItem);
    }
    return mFragments.dispatchOptionsItemSelected(paramMenuItem);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    mFragments.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    mFragments.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      mFragments.dispatchOptionsMenuClosed(paramMenu);
    }
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPause()
  {
    super.onPause();
    mResumed = false;
    if (mHandler.hasMessages(2))
    {
      mHandler.removeMessages(2);
      onResumeFragments();
    }
    mFragments.dispatchPause();
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    mFragments.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    mHandler.removeMessages(2);
    onResumeFragments();
    mFragments.execPendingActions();
  }
  
  public boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null)) {
      return onPrepareOptionsPanel(paramView, paramMenu) | mFragments.dispatchPrepareOptionsMenu(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    mFragments.noteStateNotSaved();
    int i = paramInt >> 16 & 0xFFFF;
    if (i != 0)
    {
      i -= 1;
      String str = (String)mPendingFragmentActivityResults.get(i);
      mPendingFragmentActivityResults.put(i);
      if (str == null) {
        return;
      }
      Fragment localFragment = mFragments.findFragmentByWho(str);
      if (localFragment == null)
      {
        f.sufficientlysecure.rootcommands.util.StringBuilder.get("Activity result no fragment exists for who: ", str);
        return;
      }
      localFragment.onRequestPermissionsResult(paramInt & 0xFFFF, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    mHandler.sendEmptyMessage(2);
    mResumed = true;
    mFragments.execPendingActions();
  }
  
  public void onResumeFragments()
  {
    mFragments.dispatchResume();
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    Object localObject = onRetainCustomNonConfigurationInstance();
    FragmentManagerNonConfig localFragmentManagerNonConfig = mFragments.retainNestedNonConfig();
    if ((localFragmentManagerNonConfig == null) && (mViewModelStore == null) && (localObject == null)) {
      return null;
    }
    NonConfigurationInstances localNonConfigurationInstances = new NonConfigurationInstances();
    custom = localObject;
    viewModelStore = mViewModelStore;
    fragments = localFragmentManagerNonConfig;
    return localNonConfigurationInstances;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    markFragmentsCreated();
    Object localObject = mFragments.saveAllState();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (mPendingFragmentActivityResults.size() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", mNextCandidateRequestIndex);
      localObject = new int[mPendingFragmentActivityResults.size()];
      String[] arrayOfString = new String[mPendingFragmentActivityResults.size()];
      int i = 0;
      while (i < mPendingFragmentActivityResults.size())
      {
        localObject[i] = mPendingFragmentActivityResults.keyAt(i);
        arrayOfString[i] = ((String)mPendingFragmentActivityResults.valueAt(i));
        i += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    mStopped = false;
    if (!mCreated)
    {
      mCreated = true;
      mFragments.dispatchActivityCreated();
    }
    mFragments.noteStateNotSaved();
    mFragments.execPendingActions();
    mFragments.dispatchStart();
  }
  
  public void onStateNotSaved()
  {
    mFragments.noteStateNotSaved();
  }
  
  public void onStop()
  {
    super.onStop();
    mStopped = true;
    markFragmentsCreated();
    mFragments.dispatchStop();
  }
  
  public void requestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt == -1)
    {
      ActivityCompat.requestPermissions(this, paramArrayOfString, paramInt);
      return;
    }
    checkForValidRequestCode(paramInt);
    try
    {
      mRequestedPermissionsFromFragment = true;
      int i = allocateRequestIndex(paramFragment);
      ActivityCompat.requestPermissions(this, paramArrayOfString, (i + 1 << 16) + (paramInt & 0xFFFF));
      mRequestedPermissionsFromFragment = false;
      return;
    }
    catch (Throwable paramFragment)
    {
      mRequestedPermissionsFromFragment = false;
      throw paramFragment;
    }
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.setEnterSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.setExitSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if ((!mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    mStartedActivityFromFragment = true;
    if (paramInt == -1) {}
    try
    {
      ActivityCompat.startActivityForResult(this, paramIntent, -1, paramBundle);
      mStartedActivityFromFragment = false;
      return;
    }
    catch (Throwable paramFragment)
    {
      int i;
      mStartedActivityFromFragment = false;
      throw paramFragment;
    }
    checkForValidRequestCode(paramInt);
    i = allocateRequestIndex(paramFragment);
    ActivityCompat.startActivityForResult(this, paramIntent, (i + 1 << 16) + (paramInt & 0xFFFF), paramBundle);
    mStartedActivityFromFragment = false;
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
    throws IntentSender.SendIntentException
  {
    if ((!mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if ((!mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    mStartedIntentSenderFromFragment = true;
    if (paramInt1 == -1) {}
    try
    {
      ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      mStartedIntentSenderFromFragment = false;
      return;
    }
    catch (Throwable paramFragment)
    {
      int i;
      mStartedIntentSenderFromFragment = false;
      throw paramFragment;
    }
    checkForValidRequestCode(paramInt1);
    i = allocateRequestIndex(paramFragment);
    ActivityCompat.startIntentSenderForResult(this, paramIntentSender, (i + 1 << 16) + (paramInt1 & 0xFFFF), paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    mStartedIntentSenderFromFragment = false;
  }
  
  public void supportFinishAfterTransition()
  {
    ActivityCompat.finishAfterTransition(this);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    invalidateOptionsMenu();
  }
  
  public void supportPostponeEnterTransition()
  {
    ActivityCompat.postponeEnterTransition(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    ActivityCompat.startPostponedEnterTransition(this);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt)
  {
    if ((!mRequestedPermissionsFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
  }
  
  public class HostCallbacks
    extends android.support.v4.app.FragmentHostCallback<android.support.v4.app.FragmentActivity>
  {
    public HostCallbacks()
    {
      super();
    }
    
    public void onAttachFragment(Fragment paramFragment)
    {
      FragmentActivity.this.onAttachFragment(paramFragment);
    }
    
    public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    
    public View onFindViewById(int paramInt)
    {
      return findViewById(paramInt);
    }
    
    public FragmentActivity onGetHost()
    {
      return FragmentActivity.this;
    }
    
    public LayoutInflater onGetLayoutInflater()
    {
      return getLayoutInflater().cloneInContext(FragmentActivity.this);
    }
    
    public int onGetWindowAnimations()
    {
      Window localWindow = getWindow();
      if (localWindow == null) {
        return 0;
      }
      return getAttributeswindowAnimations;
    }
    
    public boolean onHasView()
    {
      Window localWindow = getWindow();
      return (localWindow != null) && (localWindow.peekDecorView() != null);
    }
    
    public boolean onHasWindowAnimations()
    {
      return getWindow() != null;
    }
    
    public void onRequestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
    {
      requestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
    }
    
    public boolean onShouldSaveFragmentState(Fragment paramFragment)
    {
      return !isFinishing();
    }
    
    public boolean onShouldShowRequestPermissionRationale(String paramString)
    {
      return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, paramString);
    }
    
    public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
    {
      startActivityFromFragment(paramFragment, paramIntent, paramInt);
    }
    
    public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
    {
      startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    }
    
    public void onStartIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
      throws IntentSender.SendIntentException
    {
      startIntentSenderFromFragment(paramFragment, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    }
    
    public void onSupportInvalidateOptionsMenu()
    {
      supportInvalidateOptionsMenu();
    }
  }
  
  public final class NonConfigurationInstances
  {
    public Object custom;
    public FragmentManagerNonConfig fragments;
    public Line viewModelStore;
    
    public NonConfigurationInstances() {}
  }
}
