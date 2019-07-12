package android.support.v4.package_7;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import b.a.b.j;
import b.a.b.r;
import b.b.a.G;
import b.b.x.n.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import support.android.v4.util.DebugUtils;
import support.android.v4.util.SimpleArrayMap;
import support.android.v4.view.LayoutInflaterCompatHC;
import support.support.asm.ClassReader;
import support.support.asm.CurrencyUnit;
import support.support.asm.Line;
import support.support.asm.Log;
import support.support.asm.MethodWriter;
import support.support.asm.c;
import support.support.asm.d;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener, d, CurrencyUnit
{
  public static final int ACTIVITY_CREATED = 2;
  public static final int CREATED = 1;
  public static final int INITIALIZING = 0;
  public static final int RESUMED = 4;
  public static final int STARTED = 3;
  public static final Object USE_DEFAULT_TRANSITION = new Object();
  public static final t<String, Class<?>> sClassMap = new SimpleArrayMap();
  public boolean mAdded;
  public AnimationInfo mAnimationInfo;
  public Bundle mArguments;
  public int mBackStackNesting;
  public boolean mCalled;
  public FragmentManagerImpl mChildFragmentManager;
  public FragmentManagerNonConfig mChildNonConfig;
  public ViewGroup mContainer;
  public int mContainerId;
  public boolean mDeferStart;
  public boolean mDetached;
  public int mFragmentId;
  public FragmentManagerImpl mFragmentManager;
  public boolean mFromLayout;
  public boolean mHasMenu;
  public boolean mHidden;
  public boolean mHiddenChanged;
  public FragmentHostCallback mHost;
  public boolean mInLayout;
  public int mIndex = -1;
  public View mInnerView;
  public boolean mIsCreated;
  public boolean mIsNewlyAdded;
  public LayoutInflater mLayoutInflater;
  public MethodWriter mLifecycleRegistry = new MethodWriter(this);
  public boolean mMenuVisible = true;
  public Fragment mParentFragment;
  public boolean mPerformedCreateView;
  public float mPostponedAlpha;
  public boolean mRemoving;
  public boolean mRestored;
  public boolean mRetainInstance;
  public boolean mRetaining;
  public Bundle mSavedFragmentState;
  @G
  public Boolean mSavedUserVisibleHint;
  public SparseArray<Parcelable> mSavedViewState;
  public int mState = 0;
  public String mTag;
  public Fragment mTarget;
  public int mTargetIndex = -1;
  public int mTargetRequestCode;
  public boolean mUserVisibleHint = true;
  public View mView;
  public d mViewLifecycleOwner;
  public r<j> mViewLifecycleOwnerLiveData = new Log();
  public MethodWriter mViewLifecycleRegistry;
  public Line mViewModelStore;
  public String mWho;
  
  public Fragment() {}
  
  private AnimationInfo ensureAnimationInfo()
  {
    if (mAnimationInfo == null) {
      mAnimationInfo = new AnimationInfo();
    }
    return mAnimationInfo;
  }
  
  public static Fragment instantiate(Context paramContext, String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }
  
  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    Object localObject1 = sClassMap;
    try
    {
      localObject1 = ((SimpleArrayMap)localObject1).get(paramString);
      Object localObject2 = (Class)localObject1;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramContext.getClassLoader().loadClass(paramString);
        paramContext = (Context)localObject1;
        localObject2 = sClassMap;
        ((SimpleArrayMap)localObject2).put(paramString, localObject1);
        localObject1 = paramContext;
      }
      paramContext = ((Class)localObject1).getConstructor(new Class[0]);
      paramContext = paramContext.newInstance(new Object[0]);
      paramContext = (Fragment)paramContext;
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.setArguments(paramBundle);
        return paramContext;
      }
    }
    catch (InvocationTargetException paramContext)
    {
      throw new InstantiationException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unable to instantiate fragment ", paramString, ": calling Fragment constructor caused an exception"), paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      throw new InstantiationException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unable to instantiate fragment ", paramString, ": could not find Fragment constructor"), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (InstantiationException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new InstantiationException(paramBundle.toString(), paramContext);
    }
    return paramContext;
  }
  
  public static boolean isSupportFragmentClass(Context paramContext, String paramString)
  {
    Object localObject1 = sClassMap;
    try
    {
      localObject1 = ((SimpleArrayMap)localObject1).get(paramString);
      Object localObject2 = (Class)localObject1;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramContext.getClassLoader().loadClass(paramString);
        paramContext = (Context)localObject1;
        localObject2 = sClassMap;
        ((SimpleArrayMap)localObject2).put(paramString, localObject1);
        localObject1 = paramContext;
      }
      boolean bool = android.support.v4.app.Fragment.class.isAssignableFrom((Class)localObject1);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  public void callStartTransitionListener()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    OnStartEnterTransitionListener localOnStartEnterTransitionListener = null;
    if (localAnimationInfo != null)
    {
      mEnterTransitionPostponed = false;
      localOnStartEnterTransitionListener = mStartEnterTransitionListener;
      mStartEnterTransitionListener = null;
    }
    if (localOnStartEnterTransitionListener != null) {
      localOnStartEnterTransitionListener.onStartEnterTransition();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(mState);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(mIndex);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(mRetainInstance);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(mRetaining);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(mUserVisibleHint);
    if (mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(mFragmentManager);
    }
    if (mHost != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(mHost);
    }
    if (mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(mParentFragment);
    }
    if (mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(mArguments);
    }
    if (mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(mSavedFragmentState);
    }
    if (mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(mSavedViewState);
    }
    if (mTarget != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(mTarget);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(mTargetRequestCode);
    }
    if (getNextAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(getNextAnim());
    }
    if (mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(mContainer);
    }
    if (mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(mView);
    }
    if (mInnerView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(getStateAfterAnimating());
    }
    if (getContext() != null) {
      LoaderManager.getInstance(this).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (mChildFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Child ");
      localStringBuilder.append(mChildFragmentManager);
      localStringBuilder.append(":");
      paramPrintWriter.println(localStringBuilder.toString());
      mChildFragmentManager.dump(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    if (paramString.equals(mWho)) {
      return this;
    }
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      return localFragmentManagerImpl.findFragmentByWho(paramString);
    }
    return null;
  }
  
  public final FragmentActivity getActivity()
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback == null) {
      return null;
    }
    return (FragmentActivity)localFragmentHostCallback.getActivity();
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    Object localObject = mAnimationInfo;
    if (localObject != null)
    {
      localObject = mAllowEnterTransitionOverlap;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return true;
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    Object localObject = mAnimationInfo;
    if (localObject != null)
    {
      localObject = mAllowReturnTransitionOverlap;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return true;
  }
  
  public View getAnimatingAway()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return null;
    }
    return mAnimatingAway;
  }
  
  public Animator getAnimator()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return null;
    }
    return mAnimator;
  }
  
  public final Bundle getArguments()
  {
    return mArguments;
  }
  
  public final FragmentManager getChildFragmentManager()
  {
    if (mChildFragmentManager == null)
    {
      instantiateChildFragmentManager();
      int i = mState;
      if (i >= 4) {
        mChildFragmentManager.dispatchResume();
      } else if (i >= 3) {
        mChildFragmentManager.dispatchStart();
      } else if (i >= 2) {
        mChildFragmentManager.dispatchActivityCreated();
      } else if (i >= 1) {
        mChildFragmentManager.dispatchCreate();
      }
    }
    return mChildFragmentManager;
  }
  
  public Context getContext()
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback == null) {
      return null;
    }
    return localFragmentHostCallback.getContext();
  }
  
  public Object getEnterTransition()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return null;
    }
    return mEnterTransition;
  }
  
  public SharedElementCallback getEnterTransitionCallback()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return null;
    }
    return mEnterTransitionCallback;
  }
  
  public Object getExitTransition()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return null;
    }
    return mExitTransition;
  }
  
  public SharedElementCallback getExitTransitionCallback()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return null;
    }
    return mExitTransitionCallback;
  }
  
  public final FragmentManager getFragmentManager()
  {
    return mFragmentManager;
  }
  
  public final Object getHost()
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback == null) {
      return null;
    }
    return localFragmentHostCallback.onGetHost();
  }
  
  public final int getId()
  {
    return mFragmentId;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    LayoutInflater localLayoutInflater2 = mLayoutInflater;
    LayoutInflater localLayoutInflater1 = localLayoutInflater2;
    if (localLayoutInflater2 == null) {
      localLayoutInflater1 = performGetLayoutInflater(null);
    }
    return localLayoutInflater1;
  }
  
  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    paramBundle = mHost;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.onGetLayoutInflater();
      getChildFragmentManager();
      LayoutInflaterCompatHC.setFactory(paramBundle, mChildFragmentManager.getLayoutInflaterFactory());
      return paramBundle;
    }
    throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
  }
  
  public ClassReader getLifecycle()
  {
    return mLifecycleRegistry;
  }
  
  public LoaderManager getLoaderManager()
  {
    return LoaderManager.getInstance(this);
  }
  
  public int getNextAnim()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return 0;
    }
    return mNextAnim;
  }
  
  public int getNextTransition()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return 0;
    }
    return mNextTransition;
  }
  
  public int getNextTransitionStyle()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return 0;
    }
    return mNextTransitionStyle;
  }
  
  public final Fragment getParentFragment()
  {
    return mParentFragment;
  }
  
  public Object getReenterTransition()
  {
    Object localObject = mAnimationInfo;
    if (localObject == null) {
      return null;
    }
    localObject = mReenterTransition;
    if (localObject == USE_DEFAULT_TRANSITION) {
      return getExitTransition();
    }
    return localObject;
  }
  
  public final Resources getResources()
  {
    return requireContext().getResources();
  }
  
  public final boolean getRetainInstance()
  {
    return mRetainInstance;
  }
  
  public Object getReturnTransition()
  {
    Object localObject = mAnimationInfo;
    if (localObject == null) {
      return null;
    }
    localObject = mReturnTransition;
    if (localObject == USE_DEFAULT_TRANSITION) {
      return getEnterTransition();
    }
    return localObject;
  }
  
  public Object getSharedElementEnterTransition()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return null;
    }
    return mSharedElementEnterTransition;
  }
  
  public Object getSharedElementReturnTransition()
  {
    Object localObject = mAnimationInfo;
    if (localObject == null) {
      return null;
    }
    localObject = mSharedElementReturnTransition;
    if (localObject == USE_DEFAULT_TRANSITION) {
      return getSharedElementEnterTransition();
    }
    return localObject;
  }
  
  public int getStateAfterAnimating()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return 0;
    }
    return mStateAfterAnimating;
  }
  
  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  public final String getTag()
  {
    return mTag;
  }
  
  public final Fragment getTargetFragment()
  {
    return mTarget;
  }
  
  public final int getTargetRequestCode()
  {
    return mTargetRequestCode;
  }
  
  public final CharSequence getText(int paramInt)
  {
    return getResources().getText(paramInt);
  }
  
  public boolean getUserVisibleHint()
  {
    return mUserVisibleHint;
  }
  
  public View getView()
  {
    return mView;
  }
  
  public d getViewLifecycleOwner()
  {
    d localD = mViewLifecycleOwner;
    if (localD != null) {
      return localD;
    }
    throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
  }
  
  public LiveData getViewLifecycleOwnerLiveData()
  {
    return mViewLifecycleOwnerLiveData;
  }
  
  public Line getViewModelStore()
  {
    if (getContext() != null)
    {
      if (mViewModelStore == null) {
        mViewModelStore = new Line();
      }
      return mViewModelStore;
    }
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  public final boolean hasOptionsMenu()
  {
    return mHasMenu;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public void initState()
  {
    mIndex = -1;
    mWho = null;
    mAdded = false;
    mRemoving = false;
    mFromLayout = false;
    mInLayout = false;
    mRestored = false;
    mBackStackNesting = 0;
    mFragmentManager = null;
    mChildFragmentManager = null;
    mHost = null;
    mFragmentId = 0;
    mContainerId = 0;
    mTag = null;
    mHidden = false;
    mDetached = false;
    mRetaining = false;
  }
  
  public void instantiateChildFragmentManager()
  {
    if (mHost != null)
    {
      mChildFragmentManager = new FragmentManagerImpl();
      mChildFragmentManager.attachController(mHost, new Fragment.2(this), this);
      return;
    }
    throw new IllegalStateException("Fragment has not been attached yet.");
  }
  
  public final boolean isAdded()
  {
    return (mHost != null) && (mAdded);
  }
  
  public final boolean isDetached()
  {
    return mDetached;
  }
  
  public final boolean isHidden()
  {
    return mHidden;
  }
  
  public boolean isHideReplaced()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return false;
    }
    return mIsHideReplaced;
  }
  
  public final boolean isInBackStack()
  {
    return mBackStackNesting > 0;
  }
  
  public final boolean isInLayout()
  {
    return mInLayout;
  }
  
  public final boolean isMenuVisible()
  {
    return mMenuVisible;
  }
  
  public boolean isPostponed()
  {
    AnimationInfo localAnimationInfo = mAnimationInfo;
    if (localAnimationInfo == null) {
      return false;
    }
    return mEnterTransitionPostponed;
  }
  
  public final boolean isRemoving()
  {
    return mRemoving;
  }
  
  public final boolean isResumed()
  {
    return mState >= 4;
  }
  
  public final boolean isStateSaved()
  {
    FragmentManagerImpl localFragmentManagerImpl = mFragmentManager;
    if (localFragmentManagerImpl == null) {
      return false;
    }
    return localFragmentManagerImpl.isStateSaved();
  }
  
  public final boolean isVisible()
  {
    if ((isAdded()) && (!isHidden()))
    {
      View localView = mView;
      if ((localView != null) && (localView.getWindowToken() != null) && (mView.getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public void noteStateNotSaved()
  {
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.noteStateNotSaved();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    mCalled = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAttach(Activity paramActivity)
  {
    mCalled = true;
  }
  
  public void onAttach(Context paramContext)
  {
    mCalled = true;
    paramContext = mHost;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = paramContext.getActivity();
    }
    if (paramContext != null)
    {
      mCalled = false;
      onAttach(paramContext);
    }
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    mCalled = true;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    mCalled = true;
    restoreChildFragmentState(paramBundle);
    paramBundle = mChildFragmentManager;
    if ((paramBundle != null) && (!paramBundle.isStateAtLeast(1))) {
      mChildFragmentManager.dispatchCreate();
    }
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    getActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public void onDestroy()
  {
    int i = 1;
    mCalled = true;
    Object localObject = getActivity();
    if ((localObject == null) || (!((Activity)localObject).isChangingConfigurations())) {
      i = 0;
    }
    localObject = mViewModelStore;
    if ((localObject != null) && (i == 0)) {
      ((Line)localObject).reset();
    }
  }
  
  public void onDestroyOptionsMenu() {}
  
  public void onDestroyView()
  {
    mCalled = true;
  }
  
  public void onDetach()
  {
    mCalled = true;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    return getLayoutInflater(paramBundle);
  }
  
  public void onHiddenChanged(boolean paramBoolean) {}
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    mCalled = true;
  }
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    mCalled = true;
    paramContext = mHost;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = paramContext.getActivity();
    }
    if (paramContext != null)
    {
      mCalled = false;
      onInflate(paramContext, paramAttributeSet, paramBundle);
    }
  }
  
  public void onLowMemory()
  {
    mCalled = true;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {}
  
  public void onPause()
  {
    mCalled = true;
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) {}
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onResume()
  {
    mCalled = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    mCalled = true;
  }
  
  public void onStop()
  {
    mCalled = true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    mCalled = true;
  }
  
  public FragmentManager peekChildFragmentManager()
  {
    return mChildFragmentManager;
  }
  
  public void performActivityCreated(Bundle paramBundle)
  {
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.noteStateNotSaved();
    }
    mState = 2;
    mCalled = false;
    onActivityCreated(paramBundle);
    if (mCalled)
    {
      paramBundle = mChildFragmentManager;
      if (paramBundle != null) {
        paramBundle.dispatchActivityCreated();
      }
    }
    else
    {
      throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }
  }
  
  public void performConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.dispatchConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    if (!mHidden)
    {
      if (onContextItemSelected(paramMenuItem)) {
        return true;
      }
      FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
      if ((localFragmentManagerImpl != null) && (localFragmentManagerImpl.dispatchContextItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public void performCreate(Bundle paramBundle)
  {
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.noteStateNotSaved();
    }
    mState = 1;
    mCalled = false;
    onCreate(paramBundle);
    mIsCreated = true;
    if (mCalled)
    {
      mLifecycleRegistry.append(c.ON_CREATE);
      return;
    }
    throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onCreate()"));
  }
  
  public boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool1 = mHidden;
    boolean bool2 = false;
    if (!bool1)
    {
      bool1 = bool2;
      if (mHasMenu)
      {
        bool1 = bool2;
        if (mMenuVisible)
        {
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
          bool1 = true;
        }
      }
      FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
      if (localFragmentManagerImpl != null) {
        return bool1 | localFragmentManagerImpl.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
      }
    }
    else
    {
      return false;
    }
    return bool1;
  }
  
  public void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.noteStateNotSaved();
    }
    mPerformedCreateView = true;
    mViewLifecycleOwner = new Fragment.3(this);
    mViewLifecycleRegistry = null;
    mView = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (mView != null)
    {
      mViewLifecycleOwner.getLifecycle();
      mViewLifecycleOwnerLiveData.setValue(mViewLifecycleOwner);
      return;
    }
    if (mViewLifecycleRegistry == null)
    {
      mViewLifecycleOwner = null;
      return;
    }
    throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
  }
  
  public void performDestroy()
  {
    mLifecycleRegistry.append(c.ON_DESTROY);
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.dispatchDestroy();
    }
    mState = 0;
    mCalled = false;
    mIsCreated = false;
    onDestroy();
    if (mCalled)
    {
      mChildFragmentManager = null;
      return;
    }
    throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onDestroy()"));
  }
  
  public void performDestroyView()
  {
    if (mView != null) {
      mViewLifecycleRegistry.append(c.ON_DESTROY);
    }
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.dispatchDestroyView();
    }
    mState = 1;
    mCalled = false;
    onDestroyView();
    if (mCalled)
    {
      LoaderManager.getInstance(this).markForRedelivery();
      mPerformedCreateView = false;
      return;
    }
    throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onDestroyView()"));
  }
  
  public void performDetach()
  {
    mCalled = false;
    onDetach();
    mLayoutInflater = null;
    if (mCalled)
    {
      Object localObject = mChildFragmentManager;
      if (localObject != null)
      {
        if (mRetaining)
        {
          ((FragmentManagerImpl)localObject).dispatchDestroy();
          mChildFragmentManager = null;
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Child FragmentManager of ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" was not ");
        ((StringBuilder)localObject).append(" destroyed and this fragment is not retaining instance");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onDetach()"));
    }
  }
  
  public LayoutInflater performGetLayoutInflater(Bundle paramBundle)
  {
    mLayoutInflater = onGetLayoutInflater(paramBundle);
    return mLayoutInflater;
  }
  
  public void performLowMemory()
  {
    onLowMemory();
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.dispatchLowMemory();
    }
  }
  
  public void performMultiWindowModeChanged(boolean paramBoolean)
  {
    onMultiWindowModeChanged(paramBoolean);
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.dispatchMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (!mHidden)
    {
      if ((mHasMenu) && (mMenuVisible) && (onOptionsItemSelected(paramMenuItem))) {
        return true;
      }
      FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
      if ((localFragmentManagerImpl != null) && (localFragmentManagerImpl.dispatchOptionsItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public void performOptionsMenuClosed(Menu paramMenu)
  {
    if (!mHidden)
    {
      if ((mHasMenu) && (mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
      if (localFragmentManagerImpl != null) {
        localFragmentManagerImpl.dispatchOptionsMenuClosed(paramMenu);
      }
    }
  }
  
  public void performPause()
  {
    if (mView != null) {
      mViewLifecycleRegistry.append(c.ON_PAUSE);
    }
    mLifecycleRegistry.append(c.ON_PAUSE);
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.dispatchPause();
    }
    mState = 3;
    mCalled = false;
    onPause();
    if (mCalled) {
      return;
    }
    throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onPause()"));
  }
  
  public void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    onPictureInPictureModeChanged(paramBoolean);
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.dispatchPictureInPictureModeChanged(paramBoolean);
    }
  }
  
  public boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool1 = mHidden;
    boolean bool2 = false;
    if (!bool1)
    {
      bool1 = bool2;
      if (mHasMenu)
      {
        bool1 = bool2;
        if (mMenuVisible)
        {
          onPrepareOptionsMenu(paramMenu);
          bool1 = true;
        }
      }
      FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
      if (localFragmentManagerImpl != null) {
        return bool1 | localFragmentManagerImpl.dispatchPrepareOptionsMenu(paramMenu);
      }
    }
    else
    {
      return false;
    }
    return bool1;
  }
  
  public void performResume()
  {
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null)
    {
      localFragmentManagerImpl.noteStateNotSaved();
      mChildFragmentManager.execPendingActions();
    }
    mState = 4;
    mCalled = false;
    onResume();
    if (mCalled)
    {
      localFragmentManagerImpl = mChildFragmentManager;
      if (localFragmentManagerImpl != null)
      {
        localFragmentManagerImpl.dispatchResume();
        mChildFragmentManager.execPendingActions();
      }
      mLifecycleRegistry.append(c.ON_RESUME);
      if (mView != null) {
        mViewLifecycleRegistry.append(c.ON_RESUME);
      }
    }
    else
    {
      throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onResume()"));
    }
  }
  
  public void performSaveInstanceState(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    Object localObject = mChildFragmentManager;
    if (localObject != null)
    {
      localObject = ((FragmentManagerImpl)localObject).saveAllState();
      if (localObject != null) {
        paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
      }
    }
  }
  
  public void performStart()
  {
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null)
    {
      localFragmentManagerImpl.noteStateNotSaved();
      mChildFragmentManager.execPendingActions();
    }
    mState = 3;
    mCalled = false;
    onStart();
    if (mCalled)
    {
      localFragmentManagerImpl = mChildFragmentManager;
      if (localFragmentManagerImpl != null) {
        localFragmentManagerImpl.dispatchStart();
      }
      mLifecycleRegistry.append(c.ON_START);
      if (mView != null) {
        mViewLifecycleRegistry.append(c.ON_START);
      }
    }
    else
    {
      throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onStart()"));
    }
  }
  
  public void performStop()
  {
    if (mView != null) {
      mViewLifecycleRegistry.append(c.ON_STOP);
    }
    mLifecycleRegistry.append(c.ON_STOP);
    FragmentManagerImpl localFragmentManagerImpl = mChildFragmentManager;
    if (localFragmentManagerImpl != null) {
      localFragmentManagerImpl.dispatchStop();
    }
    mState = 2;
    mCalled = false;
    onStop();
    if (mCalled) {
      return;
    }
    throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onStop()"));
  }
  
  public void postponeEnterTransition()
  {
    ensureAnimationInfomEnterTransitionPostponed = true;
  }
  
  public void registerForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }
  
  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null)
    {
      localFragmentHostCallback.onRequestPermissionsFromFragment(this, paramArrayOfString, paramInt);
      return;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " not attached to Activity"));
  }
  
  public final FragmentActivity requireActivity()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      return localFragmentActivity;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " not attached to an activity."));
  }
  
  public final Context requireContext()
  {
    Context localContext = getContext();
    if (localContext != null) {
      return localContext;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " not attached to a context."));
  }
  
  public final FragmentManager requireFragmentManager()
  {
    FragmentManager localFragmentManager = getFragmentManager();
    if (localFragmentManager != null) {
      return localFragmentManager;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " not associated with a fragment manager."));
  }
  
  public final Object requireHost()
  {
    Object localObject = getHost();
    if (localObject != null) {
      return localObject;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " not attached to a host."));
  }
  
  public void restoreChildFragmentState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (mChildFragmentManager == null) {
          instantiateChildFragmentManager();
        }
        mChildFragmentManager.restoreAllState(paramBundle, mChildNonConfig);
        mChildNonConfig = null;
        mChildFragmentManager.dispatchCreate();
      }
    }
  }
  
  public final void restoreViewState(Bundle paramBundle)
  {
    SparseArray localSparseArray = mSavedViewState;
    if (localSparseArray != null)
    {
      mInnerView.restoreHierarchyState(localSparseArray);
      mSavedViewState = null;
    }
    mCalled = false;
    onViewStateRestored(paramBundle);
    if (mCalled)
    {
      if (mView != null) {
        mViewLifecycleRegistry.append(c.ON_CREATE);
      }
    }
    else {
      throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " did not call through to super.onViewStateRestored()"));
    }
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfomAllowEnterTransitionOverlap = Boolean.valueOf(paramBoolean);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfomAllowReturnTransitionOverlap = Boolean.valueOf(paramBoolean);
  }
  
  public void setAnimatingAway(View paramView)
  {
    ensureAnimationInfomAnimatingAway = paramView;
  }
  
  public void setAnimator(Animator paramAnimator)
  {
    ensureAnimationInfomAnimator = paramAnimator;
  }
  
  public void setArguments(Bundle paramBundle)
  {
    if ((mIndex >= 0) && (isStateSaved())) {
      throw new IllegalStateException("Fragment already active and state has been saved");
    }
    mArguments = paramBundle;
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfomEnterTransitionCallback = paramSharedElementCallback;
  }
  
  public void setEnterTransition(Object paramObject)
  {
    ensureAnimationInfomEnterTransition = paramObject;
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfomExitTransitionCallback = paramSharedElementCallback;
  }
  
  public void setExitTransition(Object paramObject)
  {
    ensureAnimationInfomExitTransition = paramObject;
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (mHasMenu != paramBoolean)
    {
      mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        mHost.onSupportInvalidateOptionsMenu();
      }
    }
  }
  
  public void setHideReplaced(boolean paramBoolean)
  {
    ensureAnimationInfomIsHideReplaced = paramBoolean;
  }
  
  public final void setIndex(int paramInt, Fragment paramFragment)
  {
    mIndex = paramInt;
    if (paramFragment != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(mWho);
      localStringBuilder.append(":");
      localStringBuilder.append(mIndex);
      mWho = localStringBuilder.toString();
      return;
    }
    paramFragment = f.sufficientlysecure.rootcommands.util.StringBuilder.append("android:fragment:");
    paramFragment.append(mIndex);
    mWho = paramFragment.toString();
  }
  
  public void setInitialSavedState(SavedState paramSavedState)
  {
    if (mIndex < 0)
    {
      if (paramSavedState != null)
      {
        paramSavedState = mState;
        if (paramSavedState != null) {}
      }
      else
      {
        paramSavedState = null;
      }
      mSavedFragmentState = paramSavedState;
      return;
    }
    throw new IllegalStateException("Fragment already active");
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    if (mMenuVisible != paramBoolean)
    {
      mMenuVisible = paramBoolean;
      if ((mHasMenu) && (isAdded()) && (!isHidden())) {
        mHost.onSupportInvalidateOptionsMenu();
      }
    }
  }
  
  public void setNextAnim(int paramInt)
  {
    if ((mAnimationInfo == null) && (paramInt == 0)) {
      return;
    }
    ensureAnimationInfomNextAnim = paramInt;
  }
  
  public void setNextTransition(int paramInt1, int paramInt2)
  {
    if ((mAnimationInfo == null) && (paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    ensureAnimationInfo();
    AnimationInfo localAnimationInfo = mAnimationInfo;
    mNextTransition = paramInt1;
    mNextTransitionStyle = paramInt2;
  }
  
  public void setOnStartEnterTransitionListener(OnStartEnterTransitionListener paramOnStartEnterTransitionListener)
  {
    ensureAnimationInfo();
    Object localObject = mAnimationInfo.mStartEnterTransitionListener;
    if (paramOnStartEnterTransitionListener == localObject) {
      return;
    }
    if ((paramOnStartEnterTransitionListener != null) && (localObject != null)) {
      throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Trying to set a replacement startPostponedEnterTransition on ", this));
    }
    localObject = mAnimationInfo;
    if (mEnterTransitionPostponed) {
      mStartEnterTransitionListener = paramOnStartEnterTransitionListener;
    }
    if (paramOnStartEnterTransitionListener != null) {
      paramOnStartEnterTransitionListener.startListening();
    }
  }
  
  public void setReenterTransition(Object paramObject)
  {
    ensureAnimationInfomReenterTransition = paramObject;
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    mRetainInstance = paramBoolean;
  }
  
  public void setReturnTransition(Object paramObject)
  {
    ensureAnimationInfomReturnTransition = paramObject;
  }
  
  public void setSharedElementEnterTransition(Object paramObject)
  {
    ensureAnimationInfomSharedElementEnterTransition = paramObject;
  }
  
  public void setSharedElementReturnTransition(Object paramObject)
  {
    ensureAnimationInfomSharedElementReturnTransition = paramObject;
  }
  
  public void setStateAfterAnimating(int paramInt)
  {
    ensureAnimationInfomStateAfterAnimating = paramInt;
  }
  
  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    FragmentManager localFragmentManager = getFragmentManager();
    if (paramFragment != null) {
      localObject = paramFragment.getFragmentManager();
    } else {
      localObject = null;
    }
    if ((localFragmentManager != null) && (localObject != null) && (localFragmentManager != localObject)) {
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", paramFragment, " must share the same FragmentManager to be set as a target fragment"));
    }
    Object localObject = paramFragment;
    while (localObject != null) {
      if (localObject != this)
      {
        localObject = ((Fragment)localObject).getTargetFragment();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Setting ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(" as the target of ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" would create a target cycle");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    mTarget = paramFragment;
    mTargetRequestCode = paramInt;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!mUserVisibleHint) && (paramBoolean) && (mState < 3) && (mFragmentManager != null) && (isAdded()) && (mIsCreated)) {
      mFragmentManager.performPendingDeferredStart(this);
    }
    mUserVisibleHint = paramBoolean;
    boolean bool;
    if ((mState < 3) && (!paramBoolean)) {
      bool = true;
    } else {
      bool = false;
    }
    mDeferStart = bool;
    if (mSavedFragmentState != null) {
      mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
    }
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null) {
      return localFragmentHostCallback.onShouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivity(paramIntent, null);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null)
    {
      localFragmentHostCallback.onStartActivityFromFragment(this, paramIntent, -1, paramBundle);
      return;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " not attached to Activity"));
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt, null);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null)
    {
      localFragmentHostCallback.onStartActivityFromFragment(this, paramIntent, paramInt, paramBundle);
      return;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " not attached to Activity"));
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null)
    {
      localFragmentHostCallback.onStartIntentSenderFromFragment(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", this, " not attached to Activity"));
  }
  
  public void startPostponedEnterTransition()
  {
    FragmentManagerImpl localFragmentManagerImpl = mFragmentManager;
    if ((localFragmentManagerImpl != null) && (mHost != null))
    {
      if (Looper.myLooper() != mFragmentManager.mHost.getHandler().getLooper())
      {
        mFragmentManager.mHost.getHandler().postAtFrontOfQueue(new Fragment.1(this));
        return;
      }
      callStartTransitionListener();
      return;
    }
    ensureAnimationInfomEnterTransitionPostponed = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    if (mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(mIndex);
    }
    if (mFragmentId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(mFragmentId));
    }
    if (mTag != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(mTag);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }
  
  public class AnimationInfo
  {
    public Boolean mAllowEnterTransitionOverlap;
    public Boolean mAllowReturnTransitionOverlap;
    public View mAnimatingAway;
    public Animator mAnimator;
    public Object mEnterTransition = null;
    public SharedElementCallback mEnterTransitionCallback;
    public boolean mEnterTransitionPostponed;
    public Object mExitTransition;
    public SharedElementCallback mExitTransitionCallback;
    public boolean mIsHideReplaced;
    public int mNextAnim;
    public int mNextTransition;
    public int mNextTransitionStyle;
    public Object mReenterTransition;
    public Object mReturnTransition;
    public Object mSharedElementEnterTransition;
    public Object mSharedElementReturnTransition;
    public Fragment.OnStartEnterTransitionListener mStartEnterTransitionListener;
    public int mStateAfterAnimating;
    
    public AnimationInfo()
    {
      this$1 = Fragment.USE_DEFAULT_TRANSITION;
      mReturnTransition = this$1;
      mExitTransition = null;
      mReenterTransition = this$1;
      mSharedElementEnterTransition = null;
      mSharedElementReturnTransition = this$1;
      mEnterTransitionCallback = null;
      mExitTransitionCallback = null;
    }
  }
  
  public class InstantiationException
    extends RuntimeException
  {
    public InstantiationException(Exception paramException)
    {
      super(paramException);
    }
  }
  
  public abstract interface OnStartEnterTransitionListener
  {
    public abstract void onStartEnterTransition();
    
    public abstract void startListening();
  }
  
  public class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<android.support.v4.app.Fragment.SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public Fragment.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Fragment.SavedState(paramAnonymousParcel, null);
      }
      
      public Fragment.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new Fragment.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public Fragment.SavedState[] newArray(int paramAnonymousInt)
      {
        return new Fragment.SavedState[paramAnonymousInt];
      }
    };
    public final Bundle mState;
    
    public SavedState()
    {
      mState = this$1;
    }
    
    public SavedState(ClassLoader paramClassLoader)
    {
      mState = this$1.readBundle();
      if (paramClassLoader != null)
      {
        this$1 = mState;
        if (this$1 != null) {
          this$1.setClassLoader(paramClassLoader);
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeBundle(mState);
    }
  }
}
