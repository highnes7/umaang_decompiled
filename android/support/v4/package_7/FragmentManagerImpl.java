package android.support.v4.package_7;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import b.b.a.G;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import support.android.v4.util.DebugUtils;
import support.android.v4.util.LogWriter;
import support.android.v4.util.NodeList;
import support.android.v4.view.ViewCompat;
import support.support.asm.Line;
import support.support.asm.Log;

public final class FragmentManagerImpl
  extends FragmentManager
  implements LayoutInflater.Factory2
{
  public static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  public static final Interpolator ACCELERATE_QUINT;
  public static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  public static boolean DEBUG = false;
  public static final Interpolator DECELERATE_CUBIC;
  public static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
  public static final String TAG = "FragmentManager";
  public static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  public static final String TARGET_STATE_TAG = "android:target_state";
  public static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  public static final String VIEW_STATE_TAG = "android:view_state";
  public static Field sAnimationListenerField;
  public SparseArray<android.support.v4.app.Fragment> mActive;
  public final ArrayList<android.support.v4.app.Fragment> mAdded = new ArrayList();
  public ArrayList<Integer> mAvailBackStackIndices;
  public ArrayList<android.support.v4.app.BackStackRecord> mBackStack;
  public ArrayList<android.support.v4.app.FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  public ArrayList<android.support.v4.app.BackStackRecord> mBackStackIndices;
  public FragmentContainer mContainer;
  public ArrayList<android.support.v4.app.Fragment> mCreatedMenus;
  public int mCurState = 0;
  public boolean mDestroyed;
  public Runnable mExecCommit = new Runnable()
  {
    public void run()
    {
      execPendingActions();
    }
  };
  public boolean mExecutingActions;
  public boolean mHavePendingDeferredStart;
  public FragmentHostCallback mHost;
  public final CopyOnWriteArrayList<android.support.v4.app.FragmentManagerImpl.FragmentLifecycleCallbacksHolder> mLifecycleCallbacks = new CopyOnWriteArrayList();
  public boolean mNeedMenuInvalidate;
  public int mNextFragmentIndex = 0;
  public String mNoTransactionsBecause;
  public Fragment mParent;
  public ArrayList<android.support.v4.app.FragmentManagerImpl.OpGenerator> mPendingActions;
  public ArrayList<android.support.v4.app.FragmentManagerImpl.StartEnterTransitionListener> mPostponedTransactions;
  @G
  public Fragment mPrimaryNav;
  public FragmentManagerNonConfig mSavedNonConfig;
  public SparseArray<Parcelable> mStateArray = null;
  public Bundle mStateBundle = null;
  public boolean mStateSaved;
  public boolean mStopped;
  public ArrayList<android.support.v4.app.Fragment> mTmpAddedFragments;
  public ArrayList<Boolean> mTmpIsPop;
  public ArrayList<android.support.v4.app.BackStackRecord> mTmpRecords;
  
  static
  {
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  public FragmentManagerImpl() {}
  
  private void addAddedFragments(NodeList paramNodeList)
  {
    int i = mCurState;
    if (i < 1) {
      return;
    }
    int j = Math.min(i, 3);
    int k = mAdded.size();
    i = 0;
    while (i < k)
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if (mState < j)
      {
        moveToState(localFragment, j, localFragment.getNextAnim(), localFragment.getNextTransition(), false);
        if ((mView != null) && (!mHidden) && (mIsNewlyAdded)) {
          paramNodeList.add(localFragment);
        }
      }
      i += 1;
    }
  }
  
  private void animateRemoveFragment(Fragment paramFragment, AnimationOrAnimator paramAnimationOrAnimator, int paramInt)
  {
    View localView = mView;
    ViewGroup localViewGroup = mContainer;
    localViewGroup.startViewTransition(localView);
    paramFragment.setStateAfterAnimating(paramInt);
    Object localObject = animation;
    if (localObject != null)
    {
      localObject = new EndViewTransitionAnimator((Animation)localObject, localViewGroup, localView);
      paramFragment.setAnimatingAway(mView);
      ((Animation)localObject).setAnimationListener(new FragmentManagerImpl.2(this, getAnimationListener((Animation)localObject), localViewGroup, paramFragment));
      setHWLayerAnimListenerIfAlpha(localView, paramAnimationOrAnimator);
      mView.startAnimation((Animation)localObject);
      return;
    }
    localObject = animator;
    paramFragment.setAnimator((Animator)localObject);
    ((Animator)localObject).addListener(new FragmentManagerImpl.3(this, localViewGroup, localView, paramFragment));
    ((Animator)localObject).setTarget(mView);
    setHWLayerAnimListenerIfAlpha(mView, paramAnimationOrAnimator);
    ((Animator)localObject).start();
  }
  
  private void burpActive()
  {
    SparseArray localSparseArray = mActive;
    if (localSparseArray != null)
    {
      int i = localSparseArray.size() - 1;
      while (i >= 0)
      {
        if (mActive.valueAt(i) == null)
        {
          localSparseArray = mActive;
          localSparseArray.delete(localSparseArray.keyAt(i));
        }
        i -= 1;
      }
    }
  }
  
  private void checkStateLoss()
  {
    if (!isStateSaved())
    {
      if (mNoTransactionsBecause == null) {
        return;
      }
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Can not perform this action inside of ");
      localStringBuilder.append(mNoTransactionsBecause);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  private void cleanupExec()
  {
    mExecutingActions = false;
    mTmpIsPop.clear();
    mTmpRecords.clear();
  }
  
  private void dispatchStateChange(int paramInt)
  {
    try
    {
      mExecutingActions = true;
      moveToState(paramInt, false);
      mExecutingActions = false;
      execPendingActions();
      return;
    }
    catch (Throwable localThrowable)
    {
      mExecutingActions = false;
      throw localThrowable;
    }
  }
  
  private void endAnimatingAwayFragments()
  {
    Object localObject = mActive;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((SparseArray)localObject).size();
    }
    while (j < i)
    {
      localObject = (Fragment)mActive.valueAt(j);
      if (localObject != null) {
        if (((Fragment)localObject).getAnimatingAway() != null)
        {
          int k = ((Fragment)localObject).getStateAfterAnimating();
          View localView = ((Fragment)localObject).getAnimatingAway();
          Animation localAnimation = localView.getAnimation();
          if (localAnimation != null)
          {
            localAnimation.cancel();
            localView.clearAnimation();
          }
          ((Fragment)localObject).setAnimatingAway(null);
          moveToState((Fragment)localObject, k, 0, 0, false);
        }
        else if (((Fragment)localObject).getAnimator() != null)
        {
          ((Fragment)localObject).getAnimator().end();
        }
      }
      j += 1;
    }
  }
  
  private void ensureExecReady(boolean paramBoolean)
  {
    if (!mExecutingActions)
    {
      if (mHost != null)
      {
        if (Looper.myLooper() == mHost.getHandler().getLooper())
        {
          if (!paramBoolean) {
            checkStateLoss();
          }
          if (mTmpRecords == null)
          {
            mTmpRecords = new ArrayList();
            mTmpIsPop = new ArrayList();
          }
          mExecutingActions = true;
          try
          {
            executePostponedTransaction(null, null);
            mExecutingActions = false;
            return;
          }
          catch (Throwable localThrowable)
          {
            mExecutingActions = false;
            throw localThrowable;
          }
        }
        throw new IllegalStateException("Must be called from main thread of fragment host");
      }
      throw new IllegalStateException("Fragment host has been destroyed");
    }
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  public static void executeOps(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList1.get(paramInt1);
      boolean bool2 = ((Boolean)paramArrayList2.get(paramInt1)).booleanValue();
      boolean bool1 = true;
      if (bool2)
      {
        localBackStackRecord.bumpBackStackNesting(-1);
        if (paramInt1 != paramInt2 - 1) {
          bool1 = false;
        }
        localBackStackRecord.executePopOps(bool1);
      }
      else
      {
        localBackStackRecord.bumpBackStackNesting(1);
        localBackStackRecord.executeOps();
      }
      paramInt1 += 1;
    }
  }
  
  private void executeOpsTogether(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    int j = paramInt1;
    boolean bool = getmReorderingAllowed;
    Object localObject = mTmpAddedFragments;
    if (localObject == null) {
      mTmpAddedFragments = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    mTmpAddedFragments.addAll(mAdded);
    localObject = getPrimaryNavigationFragment();
    int k = paramInt1;
    int i = 0;
    while (k < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList1.get(k);
      if (!((Boolean)paramArrayList2.get(k)).booleanValue()) {
        localObject = localBackStackRecord.expandOps(mTmpAddedFragments, (Fragment)localObject);
      } else {
        localObject = localBackStackRecord.trackAddedFragmentsInPop(mTmpAddedFragments, (Fragment)localObject);
      }
      if ((i == 0) && (!mAddToBackStack)) {
        i = 0;
      } else {
        i = 1;
      }
      k += 1;
    }
    mTmpAddedFragments.clear();
    if (!bool) {
      FragmentTransition.startTransitions(this, paramArrayList1, paramArrayList2, paramInt1, paramInt2, false);
    }
    executeOps(paramArrayList1, paramArrayList2, paramInt1, paramInt2);
    int m;
    if (bool)
    {
      localObject = new NodeList(0);
      addAddedFragments((NodeList)localObject);
      m = postponePostponableTransactions(paramArrayList1, paramArrayList2, paramInt1, paramInt2, (NodeList)localObject);
      makeRemovedFragmentsInvisible((NodeList)localObject);
    }
    else
    {
      m = paramInt2;
    }
    k = j;
    if (m != paramInt1)
    {
      k = j;
      if (bool)
      {
        FragmentTransition.startTransitions(this, paramArrayList1, paramArrayList2, paramInt1, m, true);
        moveToState(mCurState, true);
        k = j;
      }
    }
    while (k < paramInt2)
    {
      localObject = (BackStackRecord)paramArrayList1.get(k);
      if (((Boolean)paramArrayList2.get(k)).booleanValue())
      {
        paramInt1 = mIndex;
        if (paramInt1 >= 0)
        {
          freeBackStackIndex(paramInt1);
          mIndex = -1;
        }
      }
      ((BackStackRecord)localObject).runOnCommitRunnables();
      k += 1;
    }
    if (i != 0) {
      reportBackStackChanged();
    }
  }
  
  private void executePostponedTransaction(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Object localObject = mPostponedTransactions;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((ArrayList)localObject).size();
    }
    int i = 0;
    while (i < j)
    {
      localObject = (StartEnterTransitionListener)mPostponedTransactions.get(i);
      int k;
      int m;
      if ((paramArrayList1 != null) && (!mIsBack))
      {
        k = paramArrayList1.indexOf(mRecord);
        if ((k != -1) && (((Boolean)paramArrayList2.get(k)).booleanValue()))
        {
          ((StartEnterTransitionListener)localObject).cancelTransaction();
          k = j;
          m = i;
          break label221;
        }
      }
      if (!((StartEnterTransitionListener)localObject).isReady())
      {
        k = j;
        m = i;
        if (paramArrayList1 != null)
        {
          k = j;
          m = i;
          if (!mRecord.interactsWith(paramArrayList1, 0, paramArrayList1.size())) {}
        }
      }
      else
      {
        mPostponedTransactions.remove(i);
        m = i - 1;
        k = j - 1;
        if ((paramArrayList1 != null) && (!mIsBack))
        {
          i = paramArrayList1.indexOf(mRecord);
          if ((i != -1) && (((Boolean)paramArrayList2.get(i)).booleanValue()))
          {
            ((StartEnterTransitionListener)localObject).cancelTransaction();
            break label221;
          }
        }
        ((StartEnterTransitionListener)localObject).completeTransaction();
      }
      label221:
      i = m + 1;
      j = k;
    }
  }
  
  private Fragment findFragmentUnder(Fragment paramFragment)
  {
    ViewGroup localViewGroup = mContainer;
    View localView = mView;
    if (localViewGroup != null)
    {
      if (localView == null) {
        return null;
      }
      int i = mAdded.indexOf(paramFragment) - 1;
      while (i >= 0)
      {
        paramFragment = (Fragment)mAdded.get(i);
        if ((mContainer == localViewGroup) && (mView != null)) {
          return paramFragment;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  private void forcePostponedTransactions()
  {
    if (mPostponedTransactions != null) {
      while (!mPostponedTransactions.isEmpty()) {
        ((StartEnterTransitionListener)mPostponedTransactions.remove(0)).completeTransaction();
      }
    }
  }
  
  private boolean generateOpsForPendingActions(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    try
    {
      ArrayList localArrayList = mPendingActions;
      int i = 0;
      if ((localArrayList != null) && (mPendingActions.size() != 0))
      {
        int j = mPendingActions.size();
        boolean bool = false;
        while (i < j)
        {
          bool |= ((OpGenerator)mPendingActions.get(i)).generateOps(paramArrayList1, paramArrayList2);
          i += 1;
        }
        mPendingActions.clear();
        mHost.getHandler().removeCallbacks(mExecCommit);
        return bool;
      }
      return false;
    }
    catch (Throwable paramArrayList1)
    {
      throw paramArrayList1;
    }
  }
  
  public static Animation.AnimationListener getAnimationListener(Animation paramAnimation)
  {
    if (sAnimationListenerField == null) {}
    try
    {
      Field localField = Animation.class.getDeclaredField("mListener");
      sAnimationListenerField = localField;
      localField = sAnimationListenerField;
      localField.setAccessible(true);
      localField = sAnimationListenerField;
      paramAnimation = localField.get(paramAnimation);
      return (Animation.AnimationListener)paramAnimation;
    }
    catch (NoSuchFieldException paramAnimation)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramAnimation)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static AnimationOrAnimator makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(DECELERATE_CUBIC);
    paramContext.setDuration(220L);
    return new AnimationOrAnimator();
  }
  
  public static AnimationOrAnimator makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setInterpolator(DECELERATE_QUINT);
    ((Animation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((Animation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((Animation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    return new AnimationOrAnimator();
  }
  
  private void makeRemovedFragmentsInvisible(NodeList paramNodeList)
  {
    int j = paramNodeList.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramNodeList.get(i);
      if (!mAdded)
      {
        View localView = localFragment.getView();
        mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  public static boolean modifiesAlpha(Animator paramAnimator)
  {
    if (paramAnimator == null) {
      return false;
    }
    int i;
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = ((ValueAnimator)paramAnimator).getValues();
      i = 0;
      while (i < paramAnimator.length)
      {
        if ("alpha".equals(paramAnimator[i].getPropertyName())) {
          return true;
        }
        i += 1;
      }
    }
    if ((paramAnimator instanceof AnimatorSet))
    {
      paramAnimator = ((AnimatorSet)paramAnimator).getChildAnimations();
      i = 0;
      while (i < paramAnimator.size())
      {
        if (modifiesAlpha((Animator)paramAnimator.get(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean modifiesAlpha(AnimationOrAnimator paramAnimationOrAnimator)
  {
    Animation localAnimation = animation;
    if ((localAnimation instanceof AlphaAnimation)) {
      return true;
    }
    if ((localAnimation instanceof AnimationSet))
    {
      paramAnimationOrAnimator = ((AnimationSet)localAnimation).getAnimations();
      int i = 0;
      while (i < paramAnimationOrAnimator.size())
      {
        if ((paramAnimationOrAnimator.get(i) instanceof AlphaAnimation)) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return modifiesAlpha(animator);
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2)
  {
    execPendingActions();
    ensureExecReady(true);
    Object localObject = mPrimaryNav;
    if ((localObject != null) && (paramInt1 < 0) && (paramString == null))
    {
      localObject = ((Fragment)localObject).peekChildFragmentManager();
      if ((localObject != null) && (((FragmentManager)localObject).popBackStackImmediate())) {
        return true;
      }
    }
    boolean bool = popBackStackState(mTmpRecords, mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool)
    {
      mExecutingActions = true;
      try
      {
        removeRedundantOperationsAndExecute(mTmpRecords, mTmpIsPop);
        cleanupExec();
      }
      catch (Throwable paramString)
      {
        cleanupExec();
        throw paramString;
      }
    }
    doPendingDeferredStart();
    burpActive();
    return bool;
  }
  
  private int postponePostponableTransactions(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, NodeList paramNodeList)
  {
    int i = paramInt2 - 1;
    int k;
    for (int j = paramInt2; i >= paramInt1; j = k)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList1.get(i);
      boolean bool = ((Boolean)paramArrayList2.get(i)).booleanValue();
      int m;
      if ((localBackStackRecord.isPostponed()) && (!localBackStackRecord.interactsWith(paramArrayList1, i + 1, paramInt2))) {
        m = 1;
      } else {
        m = 0;
      }
      k = j;
      if (m != 0)
      {
        if (mPostponedTransactions == null) {
          mPostponedTransactions = new ArrayList();
        }
        StartEnterTransitionListener localStartEnterTransitionListener = new StartEnterTransitionListener(localBackStackRecord, bool);
        mPostponedTransactions.add(localStartEnterTransitionListener);
        localBackStackRecord.setOnStartPostponedListener(localStartEnterTransitionListener);
        if (bool) {
          localBackStackRecord.executeOps();
        } else {
          localBackStackRecord.executePopOps(false);
        }
        k = j - 1;
        if (i != k)
        {
          paramArrayList1.remove(i);
          paramArrayList1.add(k, localBackStackRecord);
        }
        addAddedFragments(paramNodeList);
      }
      i -= 1;
    }
    return j;
  }
  
  private void removeRedundantOperationsAndExecute(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      if (paramArrayList1.isEmpty()) {
        return;
      }
      if ((paramArrayList2 != null) && (paramArrayList1.size() == paramArrayList2.size()))
      {
        executePostponedTransaction(paramArrayList1, paramArrayList2);
        int n = paramArrayList1.size();
        int i = 0;
        int j;
        for (int k = 0; i < n; k = j)
        {
          int m = i;
          j = k;
          if (!getmReorderingAllowed)
          {
            if (k != i) {
              executeOpsTogether(paramArrayList1, paramArrayList2, k, i);
            }
            k = i + 1;
            j = k;
            if (((Boolean)paramArrayList2.get(i)).booleanValue()) {
              for (;;)
              {
                j = k;
                if (k >= n) {
                  break;
                }
                j = k;
                if (!((Boolean)paramArrayList2.get(k)).booleanValue()) {
                  break;
                }
                j = k;
                if (getmReorderingAllowed) {
                  break;
                }
                k += 1;
              }
            }
            executeOpsTogether(paramArrayList1, paramArrayList2, i, j);
            m = j - 1;
          }
          i = m + 1;
        }
        if (k != n) {
          executeOpsTogether(paramArrayList1, paramArrayList2, k, n);
        }
      }
      else
      {
        throw new IllegalStateException("Internal error with the back stack records");
      }
    }
  }
  
  public static int reverseTransit(int paramInt)
  {
    if (paramInt != 4097)
    {
      if (paramInt != 4099)
      {
        if (paramInt != 8194) {
          return 0;
        }
        return 4097;
      }
      return 4099;
    }
    return 8194;
  }
  
  public static void setHWLayerAnimListenerIfAlpha(View paramView, AnimationOrAnimator paramAnimationOrAnimator)
  {
    if (paramView != null)
    {
      if (paramAnimationOrAnimator == null) {
        return;
      }
      if (shouldRunOnHWLayer(paramView, paramAnimationOrAnimator))
      {
        Object localObject = animator;
        if (localObject != null)
        {
          ((Animator)localObject).addListener(new AnimatorOnHWLayerIfNeededListener());
          return;
        }
        localObject = getAnimationListener(animation);
        paramView.setLayerType(2, null);
        animation.setAnimationListener(new AnimateOnHWLayerIfNeededListener((Animation.AnimationListener)localObject));
      }
    }
  }
  
  public static void setRetaining(FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    if (paramFragmentManagerNonConfig == null) {
      return;
    }
    Object localObject = paramFragmentManagerNonConfig.getFragments();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        nextmRetaining = true;
      }
    }
    paramFragmentManagerNonConfig = paramFragmentManagerNonConfig.getChildNonConfigs();
    if (paramFragmentManagerNonConfig != null)
    {
      paramFragmentManagerNonConfig = paramFragmentManagerNonConfig.iterator();
      while (paramFragmentManagerNonConfig.hasNext()) {
        setRetaining((FragmentManagerNonConfig)paramFragmentManagerNonConfig.next());
      }
    }
  }
  
  public static boolean shouldRunOnHWLayer(View paramView, AnimationOrAnimator paramAnimationOrAnimator)
  {
    if (paramView != null)
    {
      if (paramAnimationOrAnimator == null) {
        return false;
      }
      int i = Build.VERSION.SDK_INT;
      if ((paramView.getLayerType() == 0) && (ViewCompat.hasOverlappingRendering(paramView)) && (modifiesAlpha(paramAnimationOrAnimator))) {
        return true;
      }
    }
    return false;
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    paramRuntimeException.getMessage();
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null) {}
    try
    {
      localFragmentHostCallback.onDump("  ", null, localPrintWriter, new String[0]);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    dump("  ", null, localPrintWriter, new String[0]);
    throw paramRuntimeException;
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 4097)
    {
      if (paramInt != 4099)
      {
        if (paramInt != 8194) {
          return -1;
        }
        if (paramBoolean) {
          return 3;
        }
        return 4;
      }
      if (paramBoolean) {
        return 5;
      }
      return 6;
    }
    if (paramBoolean) {
      return 1;
    }
    return 2;
  }
  
  public void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (mBackStack == null) {
      mBackStack = new ArrayList();
    }
    mBackStack.add(paramBackStackRecord);
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (DEBUG) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("add: ", paramFragment);
    }
    makeActive(paramFragment);
    if (!mDetached)
    {
      if (!mAdded.contains(paramFragment))
      {
        ArrayList localArrayList = mAdded;
        try
        {
          mAdded.add(paramFragment);
          mAdded = true;
          mRemoving = false;
          if (mView == null) {
            mHiddenChanged = false;
          }
          if ((mHasMenu) && (mMenuVisible)) {
            mNeedMenuInvalidate = true;
          }
          if (!paramBoolean) {
            return;
          }
          moveToState(paramFragment);
          return;
        }
        catch (Throwable paramFragment)
        {
          throw paramFragment;
        }
      }
      throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment already added: ", paramFragment));
    }
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (mBackStackChangeListeners == null) {
      mBackStackChangeListeners = new ArrayList();
    }
    mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    try
    {
      StringBuilder localStringBuilder;
      if ((mAvailBackStackIndices != null) && (mAvailBackStackIndices.size() > 0))
      {
        i = ((Integer)mAvailBackStackIndices.remove(mAvailBackStackIndices.size() - 1)).intValue();
        if (DEBUG)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Adding back stack index ");
          localStringBuilder.append(i);
          localStringBuilder.append(" with ");
          localStringBuilder.append(paramBackStackRecord);
          localStringBuilder.toString();
        }
        mBackStackIndices.set(i, paramBackStackRecord);
        return i;
      }
      if (mBackStackIndices == null) {
        mBackStackIndices = new ArrayList();
      }
      int i = mBackStackIndices.size();
      if (DEBUG)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting back stack index ");
        localStringBuilder.append(i);
        localStringBuilder.append(" to ");
        localStringBuilder.append(paramBackStackRecord);
        localStringBuilder.toString();
      }
      mBackStackIndices.add(paramBackStackRecord);
      return i;
    }
    catch (Throwable paramBackStackRecord)
    {
      throw paramBackStackRecord;
    }
  }
  
  public void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (mHost == null)
    {
      mHost = paramFragmentHostCallback;
      mContainer = paramFragmentContainer;
      mParent = paramFragment;
      return;
    }
    throw new IllegalStateException("Already attached");
  }
  
  public void attachFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("attach: ", paramFragment);
    }
    if (mDetached)
    {
      mDetached = false;
      if (!mAdded) {
        if (!mAdded.contains(paramFragment))
        {
          if (DEBUG) {
            f.sufficientlysecure.rootcommands.util.StringBuilder.append("add from attach: ", paramFragment);
          }
          ArrayList localArrayList = mAdded;
          try
          {
            mAdded.add(paramFragment);
            mAdded = true;
            if ((!mHasMenu) || (!mMenuVisible)) {
              return;
            }
            mNeedMenuInvalidate = true;
            return;
          }
          catch (Throwable paramFragment)
          {
            throw paramFragment;
          }
        }
        else
        {
          throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment already added: ", paramFragment));
        }
      }
    }
  }
  
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  public void completeExecute(BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      paramBackStackRecord.executePopOps(paramBoolean3);
    } else {
      paramBackStackRecord.executeOps();
    }
    Object localObject = new ArrayList(1);
    ArrayList localArrayList = new ArrayList(1);
    ((ArrayList)localObject).add(paramBackStackRecord);
    localArrayList.add(Boolean.valueOf(paramBoolean1));
    if (paramBoolean2) {
      FragmentTransition.startTransitions(this, (ArrayList)localObject, localArrayList, 0, 1, true);
    }
    if (paramBoolean3) {
      moveToState(mCurState, true);
    }
    localObject = mActive;
    if (localObject != null)
    {
      int j = ((SparseArray)localObject).size();
      int i = 0;
      while (i < j)
      {
        localObject = (Fragment)mActive.valueAt(i);
        if ((localObject != null) && (mView != null) && (mIsNewlyAdded) && (paramBackStackRecord.interactsWith(mContainerId)))
        {
          float f = mPostponedAlpha;
          if (f > 0.0F) {
            mView.setAlpha(f);
          }
          if (paramBoolean3)
          {
            mPostponedAlpha = 0.0F;
          }
          else
          {
            mPostponedAlpha = -1.0F;
            mIsNewlyAdded = false;
          }
        }
        i += 1;
      }
    }
  }
  
  public void completeShowHideFragment(Fragment paramFragment)
  {
    if (mView != null)
    {
      AnimationOrAnimator localAnimationOrAnimator = loadAnimation(paramFragment, paramFragment.getNextTransition(), mHidden ^ true, paramFragment.getNextTransitionStyle());
      if (localAnimationOrAnimator != null)
      {
        Object localObject = animator;
        if (localObject != null)
        {
          ((Animator)localObject).setTarget(mView);
          if (mHidden)
          {
            if (paramFragment.isHideReplaced())
            {
              paramFragment.setHideReplaced(false);
            }
            else
            {
              localObject = mContainer;
              View localView = mView;
              ((ViewGroup)localObject).startViewTransition(localView);
              animator.addListener(new FragmentManagerImpl.4(this, (ViewGroup)localObject, localView, paramFragment));
            }
          }
          else {
            mView.setVisibility(0);
          }
          setHWLayerAnimListenerIfAlpha(mView, localAnimationOrAnimator);
          animator.start();
          break label213;
        }
      }
      if (localAnimationOrAnimator != null)
      {
        setHWLayerAnimListenerIfAlpha(mView, localAnimationOrAnimator);
        mView.startAnimation(animation);
        animation.start();
      }
      int i;
      if ((mHidden) && (!paramFragment.isHideReplaced())) {
        i = 8;
      } else {
        i = 0;
      }
      mView.setVisibility(i);
      if (paramFragment.isHideReplaced()) {
        paramFragment.setHideReplaced(false);
      }
    }
    label213:
    if ((mAdded) && (mHasMenu) && (mMenuVisible)) {
      mNeedMenuInvalidate = true;
    }
    mHiddenChanged = false;
    paramFragment.onHiddenChanged(mHidden);
  }
  
  public void detachFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("detach: ", paramFragment);
    }
    if (!mDetached)
    {
      mDetached = true;
      if (mAdded)
      {
        if (DEBUG) {
          f.sufficientlysecure.rootcommands.util.StringBuilder.append("remove from detach: ", paramFragment);
        }
        ArrayList localArrayList = mAdded;
        try
        {
          mAdded.remove(paramFragment);
          if ((mHasMenu) && (mMenuVisible)) {
            mNeedMenuInvalidate = true;
          }
          mAdded = false;
          return;
        }
        catch (Throwable paramFragment)
        {
          throw paramFragment;
        }
      }
    }
  }
  
  public void dispatchActivityCreated()
  {
    mStateSaved = false;
    mStopped = false;
    dispatchStateChange(2);
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    int i = 0;
    while (i < mAdded.size())
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
      i += 1;
    }
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    if (mCurState < 1) {
      return false;
    }
    int i = 0;
    while (i < mAdded.size())
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void dispatchCreate()
  {
    mStateSaved = false;
    mStopped = false;
    dispatchStateChange(1);
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i = mCurState;
    int j = 0;
    if (i < 1) {
      return false;
    }
    Object localObject1 = null;
    i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < mAdded.size(); bool1 = bool2)
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      Object localObject2 = localObject1;
      bool2 = bool1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localFragment);
          bool2 = true;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (mCreatedMenus != null)
    {
      i = j;
      while (i < mCreatedMenus.size())
      {
        paramMenu = (Fragment)mCreatedMenus.get(i);
        if ((localObject1 == null) || (!localObject1.contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i += 1;
      }
    }
    mCreatedMenus = localObject1;
    return bool1;
  }
  
  public void dispatchDestroy()
  {
    mDestroyed = true;
    execPendingActions();
    dispatchStateChange(0);
    mHost = null;
    mContainer = null;
    mParent = null;
  }
  
  public void dispatchDestroyView()
  {
    dispatchStateChange(1);
  }
  
  public void dispatchLowMemory()
  {
    int i = 0;
    while (i < mAdded.size())
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
      i += 1;
    }
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    int i = mAdded.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentActivityCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  public void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentAttached(paramFragment, paramContext, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentAttached(this, paramFragment, paramContext);
      }
    }
  }
  
  public void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentCreated(paramFragment, paramBundle, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  public void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentDestroyed(paramFragment, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentDestroyed(this, paramFragment);
      }
    }
  }
  
  public void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentDetached(paramFragment, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentDetached(this, paramFragment);
      }
    }
  }
  
  public void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPaused(paramFragment, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentPaused(this, paramFragment);
      }
    }
  }
  
  public void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPreAttached(paramFragment, paramContext, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentPreAttached(this, paramFragment, paramContext);
      }
    }
  }
  
  public void dispatchOnFragmentPreCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPreCreated(paramFragment, paramBundle, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentPreCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  public void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentResumed(paramFragment, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentResumed(this, paramFragment);
      }
    }
  }
  
  public void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentSaveInstanceState(this, paramFragment, paramBundle);
      }
    }
  }
  
  public void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentStarted(paramFragment, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentStarted(this, paramFragment);
      }
    }
  }
  
  public void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentStopped(paramFragment, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentStopped(this, paramFragment);
      }
    }
  }
  
  public void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentViewCreated(this, paramFragment, paramView, paramBundle);
      }
    }
  }
  
  public void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentViewDestroyed(paramFragment, true);
      }
    }
    localObject = mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (mRecursive)) {
        mCallback.onFragmentViewDestroyed(this, paramFragment);
      }
    }
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (mCurState < 1) {
      return false;
    }
    int i = 0;
    while (i < mAdded.size())
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (mCurState < 1) {
      return;
    }
    int i = 0;
    while (i < mAdded.size())
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if (localFragment != null) {
        localFragment.performOptionsMenuClosed(paramMenu);
      }
      i += 1;
    }
  }
  
  public void dispatchPause()
  {
    dispatchStateChange(3);
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    int i = mAdded.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    int j = mCurState;
    int i = 0;
    if (j < 1) {
      return false;
    }
    boolean bool2;
    for (boolean bool1 = false; i < mAdded.size(); bool1 = bool2)
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      bool2 = bool1;
      if (localFragment != null)
      {
        bool2 = bool1;
        if (localFragment.performPrepareOptionsMenu(paramMenu)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public void dispatchResume()
  {
    mStateSaved = false;
    mStopped = false;
    dispatchStateChange(4);
  }
  
  public void dispatchStart()
  {
    mStateSaved = false;
    mStopped = false;
    dispatchStateChange(3);
  }
  
  public void dispatchStop()
  {
    mStopped = true;
    dispatchStateChange(2);
  }
  
  public void doPendingDeferredStart()
  {
    if (mHavePendingDeferredStart)
    {
      mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "    ");
    Object localObject = mActive;
    int j = 0;
    int i;
    if (localObject != null)
    {
      k = ((SparseArray)localObject).size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < k)
        {
          localObject = (Fragment)mActive.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localObject);
          if (localObject != null) {
            ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    int k = mAdded.size();
    if (k > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i = 0;
      while (i < k)
      {
        localObject = (Fragment)mAdded.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(((Fragment)localObject).toString());
        i += 1;
      }
    }
    localObject = mCreatedMenus;
    if (localObject != null)
    {
      k = ((ArrayList)localObject).size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          localObject = (Fragment)mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
          i += 1;
        }
      }
    }
    localObject = mBackStack;
    if (localObject != null)
    {
      k = ((ArrayList)localObject).size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          localObject = (BackStackRecord)mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((BackStackRecord)localObject).toString());
          ((BackStackRecord)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          i += 1;
        }
      }
    }
    try
    {
      if (mBackStackIndices != null)
      {
        k = mBackStackIndices.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < k)
          {
            paramFileDescriptor = (BackStackRecord)mBackStackIndices.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((mAvailBackStackIndices != null) && (mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(mAvailBackStackIndices.toArray()));
      }
      paramFileDescriptor = mPendingActions;
      if (paramFileDescriptor != null)
      {
        k = paramFileDescriptor.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = j;
          while (i < k)
          {
            paramFileDescriptor = (OpGenerator)mPendingActions.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("FragmentManager misc state:");
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mHost=");
      paramPrintWriter.println(mHost);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mContainer=");
      paramPrintWriter.println(mContainer);
      if (mParent != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mParent=");
        paramPrintWriter.println(mParent);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mCurState=");
      paramPrintWriter.print(mCurState);
      paramPrintWriter.print(" mStateSaved=");
      paramPrintWriter.print(mStateSaved);
      paramPrintWriter.print(" mStopped=");
      paramPrintWriter.print(mStopped);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(mDestroyed);
      if (mNeedMenuInvalidate)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mNeedMenuInvalidate=");
        paramPrintWriter.println(mNeedMenuInvalidate);
      }
      if (mNoTransactionsBecause != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mNoTransactionsBecause=");
        paramPrintWriter.println(mNoTransactionsBecause);
        return;
      }
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void enqueueAction(OpGenerator paramOpGenerator, boolean paramBoolean)
  {
    if (!paramBoolean) {
      checkStateLoss();
    }
    try
    {
      if ((!mDestroyed) && (mHost != null))
      {
        if (mPendingActions == null) {
          mPendingActions = new ArrayList();
        }
        mPendingActions.add(paramOpGenerator);
        scheduleCommit();
        return;
      }
      if (paramBoolean) {
        return;
      }
      throw new IllegalStateException("Activity has been destroyed");
    }
    catch (Throwable paramOpGenerator)
    {
      throw paramOpGenerator;
    }
  }
  
  public void ensureInflatedFragmentView(Fragment paramFragment)
  {
    if ((mFromLayout) && (!mPerformedCreateView))
    {
      paramFragment.performCreateView(paramFragment.performGetLayoutInflater(mSavedFragmentState), null, mSavedFragmentState);
      View localView = mView;
      if (localView != null)
      {
        mInnerView = localView;
        localView.setSaveFromParentEnabled(false);
        if (mHidden) {
          mView.setVisibility(8);
        }
        paramFragment.onViewCreated(mView, mSavedFragmentState);
        dispatchOnFragmentViewCreated(paramFragment, mView, mSavedFragmentState, false);
        return;
      }
      mInnerView = null;
    }
  }
  
  public boolean execPendingActions()
  {
    ensureExecReady(true);
    boolean bool = false;
    while (generateOpsForPendingActions(mTmpRecords, mTmpIsPop))
    {
      mExecutingActions = true;
      try
      {
        removeRedundantOperationsAndExecute(mTmpRecords, mTmpIsPop);
        cleanupExec();
        bool = true;
      }
      catch (Throwable localThrowable)
      {
        cleanupExec();
        throw localThrowable;
      }
    }
    doPendingDeferredStart();
    burpActive();
    return bool;
  }
  
  public void execSingleAction(OpGenerator paramOpGenerator, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (mHost == null) {
        return;
      }
      if (mDestroyed) {
        return;
      }
    }
    ensureExecReady(paramBoolean);
    if (paramOpGenerator.generateOps(mTmpRecords, mTmpIsPop))
    {
      mExecutingActions = true;
      try
      {
        removeRedundantOperationsAndExecute(mTmpRecords, mTmpIsPop);
        cleanupExec();
      }
      catch (Throwable paramOpGenerator)
      {
        cleanupExec();
        throw paramOpGenerator;
      }
    }
    doPendingDeferredStart();
    burpActive();
  }
  
  public boolean executePendingTransactions()
  {
    boolean bool = execPendingActions();
    forcePostponedTransactions();
    return bool;
  }
  
  public Fragment findFragmentById(int paramInt)
  {
    int i = mAdded.size() - 1;
    while (i >= 0)
    {
      localObject = (Fragment)mAdded.get(i);
      if ((localObject != null) && (mFragmentId == paramInt)) {
        return localObject;
      }
      i -= 1;
    }
    Object localObject = mActive;
    if (localObject != null)
    {
      i = ((SparseArray)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)mActive.valueAt(i);
        if ((localObject != null) && (mFragmentId == paramInt)) {
          return localObject;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public Fragment findFragmentByTag(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)mAdded.get(i);
        if ((localObject != null) && (paramString.equals(mTag))) {
          return localObject;
        }
        i -= 1;
      }
    }
    Object localObject = mActive;
    if ((localObject != null) && (paramString != null))
    {
      i = ((SparseArray)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)mActive.valueAt(i);
        if ((localObject != null) && (paramString.equals(mTag))) {
          return localObject;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    Object localObject = mActive;
    if ((localObject != null) && (paramString != null))
    {
      int i = ((SparseArray)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)mActive.valueAt(i);
        if (localObject != null)
        {
          localObject = ((Fragment)localObject).findFragmentByWho(paramString);
          if (localObject != null) {
            return localObject;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public void freeBackStackIndex(int paramInt)
  {
    try
    {
      mBackStackIndices.set(paramInt, null);
      if (mAvailBackStackIndices == null) {
        mAvailBackStackIndices = new ArrayList();
      }
      if (DEBUG)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Freeing back stack index ");
        localStringBuilder.append(paramInt);
        localStringBuilder.toString();
      }
      mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int getActiveFragmentCount()
  {
    SparseArray localSparseArray = mActive;
    if (localSparseArray == null) {
      return 0;
    }
    return localSparseArray.size();
  }
  
  public List getActiveFragments()
  {
    Object localObject = mActive;
    if (localObject == null) {
      return null;
    }
    int j = ((SparseArray)localObject).size();
    localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(mActive.valueAt(i));
      i += 1;
    }
    return localObject;
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    ArrayList localArrayList = mBackStack;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      return null;
    }
    paramBundle = (Fragment)mActive.get(i);
    if (paramBundle != null) {
      return paramBundle;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment no longer exists for key ");
    paramBundle.append(paramString);
    paramBundle.append(": index ");
    paramBundle.append(i);
    throwException(new IllegalStateException(paramBundle.toString()));
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public List getFragments()
  {
    if (mAdded.isEmpty()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = mAdded;
    try
    {
      List localList = (List)mAdded.clone();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public LayoutInflater.Factory2 getLayoutInflaterFactory()
  {
    return this;
  }
  
  public Fragment getPrimaryNavigationFragment()
  {
    return mPrimaryNav;
  }
  
  public void hideFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("hide: ", paramFragment);
    }
    if (!mHidden)
    {
      mHidden = true;
      mHiddenChanged = (true ^ mHiddenChanged);
    }
  }
  
  public boolean isDestroyed()
  {
    return mDestroyed;
  }
  
  public boolean isStateAtLeast(int paramInt)
  {
    return mCurState >= paramInt;
  }
  
  public boolean isStateSaved()
  {
    return (mStateSaved) || (mStopped);
  }
  
  public AnimationOrAnimator loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int k = paramFragment.getNextAnim();
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, k);
    if (localAnimation != null) {
      return new AnimationOrAnimator(localAnimation);
    }
    paramFragment = paramFragment.onCreateAnimator(paramInt1, paramBoolean, k);
    if (paramFragment != null) {
      return new AnimationOrAnimator(paramFragment);
    }
    boolean bool;
    int j;
    int i;
    if (k != 0)
    {
      bool = "anim".equals(mHost.getContext().getResources().getResourceTypeName(k));
      j = 0;
      i = j;
      if (bool) {
        paramFragment = mHost;
      }
    }
    try
    {
      try
      {
        paramFragment = AnimationUtils.loadAnimation(paramFragment.getContext(), k);
        if (paramFragment != null)
        {
          paramFragment = new AnimationOrAnimator(paramFragment);
          return paramFragment;
        }
        i = 1;
      }
      catch (Resources.NotFoundException paramFragment)
      {
        throw paramFragment;
      }
    }
    catch (RuntimeException paramFragment)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i == 0) {
      try
      {
        paramFragment = AnimatorInflater.loadAnimator(mHost.getContext(), k);
        if (paramFragment != null)
        {
          paramFragment = new AnimationOrAnimator(paramFragment);
          return paramFragment;
        }
      }
      catch (RuntimeException paramFragment)
      {
        if (!bool)
        {
          paramFragment = AnimationUtils.loadAnimation(mHost.getContext(), k);
          if (paramFragment != null) {
            return new AnimationOrAnimator(paramFragment);
          }
        }
        else
        {
          throw paramFragment;
        }
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (mHost.onHasWindowAnimations()) {
          paramInt1 = mHost.onGetWindowAnimations();
        }
      }
      break;
    case 6: 
      return makeFadeAnimation(mHost.getContext(), 1.0F, 0.0F);
    case 5: 
      return makeFadeAnimation(mHost.getContext(), 0.0F, 1.0F);
    case 4: 
      return makeOpenCloseAnimation(mHost.getContext(), 1.0F, 1.075F, 1.0F, 0.0F);
    case 3: 
      return makeOpenCloseAnimation(mHost.getContext(), 0.975F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return makeOpenCloseAnimation(mHost.getContext(), 1.0F, 0.975F, 1.0F, 0.0F);
    case 1: 
      return makeOpenCloseAnimation(mHost.getContext(), 1.125F, 1.0F, 0.0F, 1.0F);
    }
    if (paramInt1 == 0) {
      return null;
    }
    return null;
  }
  
  public void makeActive(Fragment paramFragment)
  {
    if (mIndex >= 0) {
      return;
    }
    int i = mNextFragmentIndex;
    mNextFragmentIndex = (i + 1);
    paramFragment.setIndex(i, mParent);
    if (mActive == null) {
      mActive = new SparseArray();
    }
    mActive.put(mIndex, paramFragment);
    if (DEBUG) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("Allocated fragment index ", paramFragment);
    }
  }
  
  public void makeInactive(Fragment paramFragment)
  {
    if (mIndex < 0) {
      return;
    }
    if (DEBUG) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("Freeing fragment index ", paramFragment);
    }
    mActive.put(mIndex, null);
    paramFragment.initState();
  }
  
  public void moveFragmentToExpectedState(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    int j = mCurState;
    int i = j;
    if (mRemoving) {
      if (paramFragment.isInBackStack()) {
        i = Math.min(j, 1);
      } else {
        i = Math.min(j, 0);
      }
    }
    moveToState(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
    if (mView != null)
    {
      Object localObject1 = findFragmentUnder(paramFragment);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = mView;
        localObject2 = mContainer;
        i = ((ViewGroup)localObject2).indexOfChild((View)localObject1);
        j = ((ViewGroup)localObject2).indexOfChild(mView);
        if (j < i)
        {
          ((ViewGroup)localObject2).removeViewAt(j);
          ((ViewGroup)localObject2).addView(mView, i);
        }
      }
      if ((mIsNewlyAdded) && (mContainer != null))
      {
        float f = mPostponedAlpha;
        if (f > 0.0F) {
          mView.setAlpha(f);
        }
        mPostponedAlpha = 0.0F;
        mIsNewlyAdded = false;
        localObject1 = loadAnimation(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
        if (localObject1 != null)
        {
          setHWLayerAnimListenerIfAlpha(mView, (AnimationOrAnimator)localObject1);
          localObject2 = animation;
          if (localObject2 != null)
          {
            mView.startAnimation((Animation)localObject2);
          }
          else
          {
            animator.setTarget(mView);
            animator.start();
          }
        }
      }
    }
    if (mHiddenChanged) {
      completeShowHideFragment(paramFragment);
    }
  }
  
  public void moveToState(int paramInt, boolean paramBoolean)
  {
    if ((mHost == null) && (paramInt != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == mCurState)) {
      return;
    }
    mCurState = paramInt;
    if (mActive != null)
    {
      int i = mAdded.size();
      paramInt = 0;
      while (paramInt < i)
      {
        moveFragmentToExpectedState((Fragment)mAdded.get(paramInt));
        paramInt += 1;
      }
      i = mActive.size();
      paramInt = 0;
      Object localObject;
      while (paramInt < i)
      {
        localObject = (Fragment)mActive.valueAt(paramInt);
        if ((localObject != null) && ((mRemoving) || (mDetached)) && (!mIsNewlyAdded)) {
          moveFragmentToExpectedState((Fragment)localObject);
        }
        paramInt += 1;
      }
      startPendingDeferredFragments();
      if (mNeedMenuInvalidate)
      {
        localObject = mHost;
        if ((localObject != null) && (mCurState == 4))
        {
          ((FragmentHostCallback)localObject).onSupportInvalidateOptionsMenu();
          mNeedMenuInvalidate = false;
        }
      }
    }
  }
  
  public void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, mCurState, 0, 0, false);
  }
  
  public void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool2 = mAdded;
    int j = 1;
    boolean bool1 = true;
    if ((bool2) && (!mDetached))
    {
      i = paramInt1;
    }
    else
    {
      i = paramInt1;
      if (paramInt1 > 1) {
        i = 1;
      }
    }
    paramInt1 = i;
    if (mRemoving)
    {
      k = mState;
      paramInt1 = i;
      if (i > k) {
        if ((k == 0) && (paramFragment.isInBackStack())) {
          paramInt1 = 1;
        } else {
          paramInt1 = mState;
        }
      }
    }
    if ((mDeferStart) && (mState < 3) && (paramInt1 > 2)) {
      paramInt1 = 2;
    }
    int k = mState;
    if (k <= paramInt1)
    {
      if ((mFromLayout) && (!mInLayout)) {
        return;
      }
      if ((paramFragment.getAnimatingAway() != null) || (paramFragment.getAnimator() != null))
      {
        paramFragment.setAnimatingAway(null);
        paramFragment.setAnimator(null);
        moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
      }
      i = mState;
      if (i != 0)
      {
        paramInt2 = paramInt1;
        if (i != 1)
        {
          paramInt3 = paramInt1;
          if (i == 2) {
            break label1087;
          }
          paramInt2 = paramInt1;
          if (i == 3) {
            break label1122;
          }
          i = paramInt1;
          break label1658;
        }
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 > 0)
        {
          if (DEBUG) {
            f.sufficientlysecure.rootcommands.util.StringBuilder.append("moveto CREATED: ", paramFragment);
          }
          localObject1 = mSavedFragmentState;
          paramInt2 = paramInt1;
          if (localObject1 != null)
          {
            ((Bundle)localObject1).setClassLoader(mHost.getContext().getClassLoader());
            mSavedViewState = mSavedFragmentState.getSparseParcelableArray("android:view_state");
            mTarget = getFragment(mSavedFragmentState, "android:target_state");
            if (mTarget != null) {
              mTargetRequestCode = mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            localObject1 = mSavedUserVisibleHint;
            if (localObject1 != null)
            {
              mUserVisibleHint = ((Boolean)localObject1).booleanValue();
              mSavedUserVisibleHint = null;
            }
            else
            {
              mUserVisibleHint = mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            paramInt2 = paramInt1;
            if (!mUserVisibleHint)
            {
              mDeferStart = true;
              paramInt2 = paramInt1;
              if (paramInt1 > 2) {
                paramInt2 = 2;
              }
            }
          }
          localObject1 = mHost;
          mHost = ((FragmentHostCallback)localObject1);
          localObject2 = mParent;
          mParentFragment = ((Fragment)localObject2);
          if (localObject2 != null) {
            localObject1 = mChildFragmentManager;
          } else {
            localObject1 = ((FragmentHostCallback)localObject1).getFragmentManagerImpl();
          }
          mFragmentManager = ((FragmentManagerImpl)localObject1);
          localObject1 = mTarget;
          if (localObject1 != null)
          {
            localObject1 = mActive.get(mIndex);
            localObject2 = mTarget;
            if (localObject1 == localObject2)
            {
              if (mState < 1) {
                moveToState((Fragment)localObject2, 1, 0, 0, true);
              }
            }
            else {
              throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("Fragment ", paramFragment, " declared target fragment "), mTarget, " that does not belong to this FragmentManager!"));
            }
          }
          dispatchOnFragmentPreAttached(paramFragment, mHost.getContext(), false);
          mCalled = false;
          paramFragment.onAttach(mHost.getContext());
          if (mCalled)
          {
            localObject1 = mParentFragment;
            if (localObject1 == null) {
              mHost.onAttachFragment(paramFragment);
            } else {
              ((Fragment)localObject1).onAttachFragment(paramFragment);
            }
            dispatchOnFragmentAttached(paramFragment, mHost.getContext(), false);
            if (!mIsCreated)
            {
              dispatchOnFragmentPreCreated(paramFragment, mSavedFragmentState, false);
              paramFragment.performCreate(mSavedFragmentState);
              dispatchOnFragmentCreated(paramFragment, mSavedFragmentState, false);
            }
            else
            {
              paramFragment.restoreChildFragmentState(mSavedFragmentState);
              mState = 1;
            }
            mRetaining = false;
          }
          else
          {
            throw new SuperNotCalledException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", paramFragment, " did not call through to super.onAttach()"));
          }
        }
      }
      ensureInflatedFragmentView(paramFragment);
      paramInt3 = paramInt2;
      if (paramInt2 > 1)
      {
        if (DEBUG) {
          f.sufficientlysecure.rootcommands.util.StringBuilder.append("moveto ACTIVITY_CREATED: ", paramFragment);
        }
        if (!mFromLayout)
        {
          paramInt1 = mContainerId;
          if (paramInt1 != 0) {
            if (paramInt1 != -1)
            {
              localObject2 = (ViewGroup)mContainer.onFindViewById(paramInt1);
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label902;
              }
              if (mRestored)
              {
                localObject1 = localObject2;
                break label902;
              }
            }
          }
        }
      }
    }
    try
    {
      localObject1 = paramFragment.getResources();
      paramInt1 = mContainerId;
      localObject1 = ((Resources)localObject1).getResourceName(paramInt1);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;) {}
    }
    Object localObject1 = "unknown";
    Object localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("No view found for id 0x");
    ((StringBuilder)localObject2).append(Integer.toHexString(mContainerId));
    ((StringBuilder)localObject2).append(" (");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(") for fragment ");
    ((StringBuilder)localObject2).append(paramFragment);
    throwException(new IllegalArgumentException(((StringBuilder)localObject2).toString()));
    throw new NullPointerException("Null throw statement replaced by Soot");
    throwException(new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Cannot create fragment ", paramFragment, " for a container view with no id")));
    throw new NullPointerException("Null throw statement replaced by Soot");
    localObject1 = null;
    label902:
    mContainer = ((ViewGroup)localObject1);
    paramFragment.performCreateView(paramFragment.performGetLayoutInflater(mSavedFragmentState), (ViewGroup)localObject1, mSavedFragmentState);
    localObject2 = mView;
    if (localObject2 != null)
    {
      mInnerView = ((View)localObject2);
      ((View)localObject2).setSaveFromParentEnabled(false);
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView(mView);
      }
      if (mHidden) {
        mView.setVisibility(8);
      }
      paramFragment.onViewCreated(mView, mSavedFragmentState);
      dispatchOnFragmentViewCreated(paramFragment, mView, mSavedFragmentState, false);
      if ((mView.getVisibility() == 0) && (mContainer != null)) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      mIsNewlyAdded = paramBoolean;
    }
    else
    {
      mInnerView = null;
    }
    paramFragment.performActivityCreated(mSavedFragmentState);
    dispatchOnFragmentActivityCreated(paramFragment, mSavedFragmentState, false);
    if (mView != null) {
      paramFragment.restoreViewState(mSavedFragmentState);
    }
    mSavedFragmentState = null;
    paramInt3 = paramInt2;
    label1087:
    paramInt2 = paramInt3;
    if (paramInt3 > 2)
    {
      if (DEBUG) {
        f.sufficientlysecure.rootcommands.util.StringBuilder.append("moveto STARTED: ", paramFragment);
      }
      paramFragment.performStart();
      dispatchOnFragmentStarted(paramFragment, false);
      paramInt2 = paramInt3;
    }
    label1122:
    int i = paramInt2;
    if (paramInt2 > 3)
    {
      if (DEBUG) {
        f.sufficientlysecure.rootcommands.util.StringBuilder.append("moveto RESUMED: ", paramFragment);
      }
      paramFragment.performResume();
      dispatchOnFragmentResumed(paramFragment, false);
      mSavedFragmentState = null;
      mSavedViewState = null;
      i = paramInt2;
      break label1658;
      i = paramInt1;
      if (k > paramInt1)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 4)
              {
                i = paramInt1;
                break label1658;
              }
              if (paramInt1 < 4)
              {
                if (DEBUG) {
                  f.sufficientlysecure.rootcommands.util.StringBuilder.append("movefrom RESUMED: ", paramFragment);
                }
                paramFragment.performPause();
                dispatchOnFragmentPaused(paramFragment, false);
              }
            }
            if (paramInt1 < 3)
            {
              if (DEBUG) {
                f.sufficientlysecure.rootcommands.util.StringBuilder.append("movefrom STARTED: ", paramFragment);
              }
              paramFragment.performStop();
              dispatchOnFragmentStopped(paramFragment, false);
            }
          }
          if (paramInt1 < 2)
          {
            if (DEBUG) {
              f.sufficientlysecure.rootcommands.util.StringBuilder.append("movefrom ACTIVITY_CREATED: ", paramFragment);
            }
            if ((mView != null) && (mHost.onShouldSaveFragmentState(paramFragment)) && (mSavedViewState == null)) {
              saveFragmentViewState(paramFragment);
            }
            paramFragment.performDestroyView();
            dispatchOnFragmentViewDestroyed(paramFragment, false);
            localObject1 = mView;
            if (localObject1 != null)
            {
              localObject2 = mContainer;
              if (localObject2 != null)
              {
                ((ViewGroup)localObject2).endViewTransition((View)localObject1);
                mView.clearAnimation();
                if ((mCurState > 0) && (!mDestroyed) && (mView.getVisibility() == 0) && (mPostponedAlpha >= 0.0F)) {
                  localObject1 = loadAnimation(paramFragment, paramInt2, false, paramInt3);
                } else {
                  localObject1 = null;
                }
                mPostponedAlpha = 0.0F;
                if (localObject1 != null) {
                  animateRemoveFragment(paramFragment, (AnimationOrAnimator)localObject1, paramInt1);
                }
                mContainer.removeView(mView);
              }
            }
            mContainer = null;
            mView = null;
            mViewLifecycleOwner = null;
            mViewLifecycleOwnerLiveData.setValue(null);
            mInnerView = null;
            mInLayout = false;
          }
        }
        i = paramInt1;
        if (paramInt1 < 1)
        {
          if (mDestroyed) {
            if (paramFragment.getAnimatingAway() != null)
            {
              localObject1 = paramFragment.getAnimatingAway();
              paramFragment.setAnimatingAway(null);
              ((View)localObject1).clearAnimation();
            }
            else if (paramFragment.getAnimator() != null)
            {
              localObject1 = paramFragment.getAnimator();
              paramFragment.setAnimator(null);
              ((Animator)localObject1).cancel();
            }
          }
          if ((paramFragment.getAnimatingAway() == null) && (paramFragment.getAnimator() == null))
          {
            if (DEBUG) {
              f.sufficientlysecure.rootcommands.util.StringBuilder.append("movefrom CREATED: ", paramFragment);
            }
            if (!mRetaining)
            {
              paramFragment.performDestroy();
              dispatchOnFragmentDestroyed(paramFragment, false);
            }
            else
            {
              mState = 0;
            }
            paramFragment.performDetach();
            dispatchOnFragmentDetached(paramFragment, false);
            i = paramInt1;
            if (!paramBoolean) {
              if (!mRetaining)
              {
                makeInactive(paramFragment);
                i = paramInt1;
              }
              else
              {
                mHost = null;
                mParentFragment = null;
                mFragmentManager = null;
                i = paramInt1;
              }
            }
          }
          else
          {
            paramFragment.setStateAfterAnimating(paramInt1);
            i = j;
          }
        }
      }
    }
    label1658:
    if (mState != i)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("moveToState: Fragment state for ");
      ((StringBuilder)localObject1).append(paramFragment);
      ((StringBuilder)localObject1).append(" not updated inline; ");
      ((StringBuilder)localObject1).append("expected state ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" found ");
      ((StringBuilder)localObject1).append(mState);
      ((StringBuilder)localObject1).toString();
      mState = i;
      return;
    }
  }
  
  public void noteStateNotSaved()
  {
    mSavedNonConfig = null;
    int i = 0;
    mStateSaved = false;
    mStopped = false;
    int j = mAdded.size();
    while (i < j)
    {
      Fragment localFragment = (Fragment)mAdded.get(i);
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
      i += 1;
    }
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    paramString = paramAttributeSet.getAttributeValue(null, "class");
    String str1 = paramString;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
    int i = 0;
    if (paramString == null) {
      str1 = localTypedArray.getString(0);
    }
    int k = localTypedArray.getResourceId(1, -1);
    String str2 = localTypedArray.getString(2);
    localTypedArray.recycle();
    if (!Fragment.isSupportFragmentClass(mHost.getContext(), str1)) {
      return null;
    }
    if (paramView != null) {
      i = paramView.getId();
    }
    if ((i == -1) && (k == -1) && (str2 == null))
    {
      paramView = new StringBuilder();
      paramView.append(paramAttributeSet.getPositionDescription());
      paramView.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
      paramView.append(str1);
      throw new IllegalArgumentException(paramView.toString());
    }
    if (k != -1) {
      paramView = findFragmentById(k);
    } else {
      paramView = null;
    }
    paramString = paramView;
    if (paramView == null)
    {
      paramString = paramView;
      if (str2 != null) {
        paramString = findFragmentByTag(str2);
      }
    }
    paramView = paramString;
    if (paramString == null)
    {
      paramView = paramString;
      if (i != -1) {
        paramView = findFragmentById(i);
      }
    }
    if (DEBUG)
    {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append("onCreateView: id=0x");
      paramString.append(Integer.toHexString(k));
      paramString.append(" fname=");
      paramString.append(str1);
      paramString.append(" existing=");
      paramString.append(paramView);
      paramString.toString();
    }
    if (paramView == null)
    {
      paramString = mContainer.instantiate(paramContext, str1, null);
      mFromLayout = true;
      int j;
      if (k != 0) {
        j = k;
      } else {
        j = i;
      }
      mFragmentId = j;
      mContainerId = i;
      mTag = str2;
      mInLayout = true;
      mFragmentManager = this;
      paramView = mHost;
      mHost = paramView;
      paramString.onInflate(paramView.getContext(), paramAttributeSet, mSavedFragmentState);
      addFragment(paramString, true);
    }
    else
    {
      if (mInLayout) {
        break label525;
      }
      mInLayout = true;
      paramContext = mHost;
      mHost = paramContext;
      paramString = paramView;
      if (!mRetaining)
      {
        paramView.onInflate(paramContext.getContext(), paramAttributeSet, mSavedFragmentState);
        paramString = paramView;
      }
    }
    if ((mCurState < 1) && (mFromLayout)) {
      moveToState(paramString, 1, 0, 0, false);
    } else {
      moveToState(paramString);
    }
    paramView = mView;
    if (paramView != null)
    {
      if (k != 0) {
        paramView.setId(k);
      }
      if (mView.getTag() == null) {
        mView.setTag(str2);
      }
      return mView;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("Fragment ", str1, " did not create a view."));
    label525:
    paramView = new StringBuilder();
    paramView.append(paramAttributeSet.getPositionDescription());
    paramView.append(": Duplicate id 0x");
    paramView.append(Integer.toHexString(k));
    paramView.append(", tag ");
    paramView.append(str2);
    paramView.append(", or parent id 0x");
    paramView.append(Integer.toHexString(i));
    paramView.append(" with another fragment for ");
    paramView.append(str1);
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void performPendingDeferredStart(Fragment paramFragment)
  {
    if (mDeferStart)
    {
      if (mExecutingActions)
      {
        mHavePendingDeferredStart = true;
        return;
      }
      mDeferStart = false;
      moveToState(paramFragment, mCurState, 0, 0, false);
    }
  }
  
  public void popBackStack()
  {
    enqueueAction(new PopBackStackState(null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      enqueueAction(new PopBackStackState(null, paramInt1, paramInt2), false);
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Bad id: ", paramInt1));
  }
  
  public void popBackStack(String paramString, int paramInt)
  {
    enqueueAction(new PopBackStackState(paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate()
  {
    checkStateLoss();
    return popBackStackImmediate(null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    execPendingActions();
    if (paramInt1 >= 0) {
      return popBackStackImmediate(null, paramInt1, paramInt2);
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Bad id: ", paramInt1));
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  public boolean popBackStackState(ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = mBackStack;
    if (localObject == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = ((ArrayList)localObject).size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList1.add(mBackStack.remove(paramInt1));
      paramArrayList2.add(Boolean.valueOf(true));
      return true;
    }
    int j;
    if ((paramString == null) && (paramInt1 < 0))
    {
      j = -1;
    }
    else
    {
      int i = mBackStack.size() - 1;
      while (i >= 0)
      {
        localObject = (BackStackRecord)mBackStack.get(i);
        if (((paramString != null) && (paramString.equals(((BackStackRecord)localObject).getName()))) || ((paramInt1 >= 0) && (paramInt1 == mIndex))) {
          break;
        }
        i -= 1;
      }
      if (i < 0) {
        return false;
      }
      j = i;
      if ((paramInt2 & 0x1) != 0) {
        for (;;)
        {
          paramInt2 = i - 1;
          j = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          localObject = (BackStackRecord)mBackStack.get(paramInt2);
          if (paramString != null)
          {
            i = paramInt2;
            if (paramString.equals(((BackStackRecord)localObject).getName())) {}
          }
          else
          {
            j = paramInt2;
            if (paramInt1 < 0) {
              break;
            }
            j = paramInt2;
            if (paramInt1 != mIndex) {
              break;
            }
            i = paramInt2;
          }
        }
      }
    }
    if (j == mBackStack.size() - 1) {
      return false;
    }
    paramInt1 = mBackStack.size() - 1;
    while (paramInt1 > j)
    {
      paramArrayList1.add(mBackStack.remove(paramInt1));
      paramArrayList2.add(Boolean.valueOf(true));
      paramInt1 -= 1;
    }
    return true;
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    int i = mIndex;
    if (i >= 0)
    {
      paramBundle.putInt(paramString, i);
      return;
    }
    throwException(new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", paramFragment, " is not currently in the FragmentManager")));
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean)
  {
    mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(paramFragmentLifecycleCallbacks, paramBoolean));
  }
  
  public void removeFragment(Fragment paramFragment)
  {
    Object localObject;
    if (DEBUG)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("remove: ", paramFragment, " nesting=");
      ((StringBuilder)localObject).append(mBackStackNesting);
      ((StringBuilder)localObject).toString();
    }
    boolean bool = paramFragment.isInBackStack();
    if ((!mDetached) || ((bool ^ true)))
    {
      localObject = mAdded;
      try
      {
        mAdded.remove(paramFragment);
        if ((mHasMenu) && (mMenuVisible)) {
          mNeedMenuInvalidate = true;
        }
        mAdded = false;
        mRemoving = true;
        return;
      }
      catch (Throwable paramFragment)
      {
        throw paramFragment;
      }
    }
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    ArrayList localArrayList = mBackStackChangeListeners;
    if (localArrayList != null) {
      localArrayList.remove(paramOnBackStackChangedListener);
    }
  }
  
  public void reportBackStackChanged()
  {
    if (mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < mBackStackChangeListeners.size())
      {
        ((FragmentManager.OnBackStackChangedListener)mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
  }
  
  public void restoreAllState(Parcelable paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    if (paramParcelable == null) {
      return;
    }
    FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
    if (mActive == null) {
      return;
    }
    List localList;
    Object localObject2;
    Object localObject3;
    int j;
    int k;
    if (paramFragmentManagerNonConfig != null)
    {
      localList = paramFragmentManagerNonConfig.getFragments();
      localObject2 = paramFragmentManagerNonConfig.getChildNonConfigs();
      localObject3 = paramFragmentManagerNonConfig.getViewModelStores();
      if (localList != null) {
        i = localList.size();
      } else {
        i = 0;
      }
      j = 0;
      for (;;)
      {
        localObject1 = localObject2;
        paramParcelable = (Parcelable)localObject3;
        if (j >= i) {
          break label303;
        }
        paramParcelable = (Fragment)localList.get(j);
        if (DEBUG) {
          f.sufficientlysecure.rootcommands.util.StringBuilder.append("restoreAllState: re-attaching retained ", paramParcelable);
        }
        k = 0;
        for (;;)
        {
          localObject1 = mActive;
          if ((k >= localObject1.length) || (mIndex == mIndex)) {
            break;
          }
          k += 1;
        }
        localObject1 = mActive;
        if (k == localObject1.length) {
          break;
        }
        localObject1 = localObject1[k];
        mInstance = paramParcelable;
        mSavedViewState = null;
        mBackStackNesting = 0;
        mInLayout = false;
        mAdded = false;
        mTarget = null;
        Bundle localBundle = mSavedFragmentState;
        if (localBundle != null)
        {
          localBundle.setClassLoader(mHost.getContext().getClassLoader());
          mSavedViewState = mSavedFragmentState.getSparseParcelableArray("android:view_state");
          mSavedFragmentState = mSavedFragmentState;
        }
        j += 1;
      }
      paramFragmentManagerNonConfig = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Could not find active fragment with index ");
      paramFragmentManagerNonConfig.append(mIndex);
      throwException(new IllegalStateException(paramFragmentManagerNonConfig.toString()));
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    Object localObject1 = null;
    paramParcelable = null;
    label303:
    mActive = new SparseArray(mActive.length);
    int i = 0;
    for (;;)
    {
      localObject2 = mActive;
      if (i >= localObject2.length) {
        break;
      }
      localList = localObject2[i];
      if (localList != null)
      {
        if ((localObject1 != null) && (i < ((List)localObject1).size())) {
          localObject2 = (FragmentManagerNonConfig)((List)localObject1).get(i);
        } else {
          localObject2 = null;
        }
        if ((paramParcelable != null) && (i < paramParcelable.size())) {
          localObject3 = (Line)paramParcelable.get(i);
        } else {
          localObject3 = null;
        }
        localObject2 = localList.instantiate(mHost, mContainer, mParent, (FragmentManagerNonConfig)localObject2, (Line)localObject3);
        if (DEBUG)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("restoreAllState: active #");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(": ");
          ((StringBuilder)localObject3).append(localObject2);
          ((StringBuilder)localObject3).toString();
        }
        mActive.put(mIndex, localObject2);
        mInstance = null;
      }
      i += 1;
    }
    if (paramFragmentManagerNonConfig != null)
    {
      paramParcelable = paramFragmentManagerNonConfig.getFragments();
      if (paramParcelable != null) {
        i = paramParcelable.size();
      } else {
        i = 0;
      }
      j = 0;
      while (j < i)
      {
        paramFragmentManagerNonConfig = (Fragment)paramParcelable.get(j);
        k = mTargetIndex;
        if (k >= 0)
        {
          mTarget = ((Fragment)mActive.get(k));
          if (mTarget == null)
          {
            localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Re-attaching retained fragment ", paramFragmentManagerNonConfig, " target no longer exists: ");
            ((StringBuilder)localObject1).append(mTargetIndex);
            ((StringBuilder)localObject1).toString();
          }
        }
        j += 1;
      }
    }
    mAdded.clear();
    if (mAdded != null)
    {
      i = 0;
      for (;;)
      {
        paramParcelable = mAdded;
        if (i >= paramParcelable.length) {
          break label831;
        }
        paramParcelable = (Fragment)mActive.get(paramParcelable[i]);
        if (paramParcelable == null) {
          break label786;
        }
        mAdded = true;
        if (DEBUG)
        {
          paramFragmentManagerNonConfig = new StringBuilder();
          paramFragmentManagerNonConfig.append("restoreAllState: added #");
          paramFragmentManagerNonConfig.append(i);
          paramFragmentManagerNonConfig.append(": ");
          paramFragmentManagerNonConfig.append(paramParcelable);
          paramFragmentManagerNonConfig.toString();
        }
        if (!mAdded.contains(paramParcelable))
        {
          paramFragmentManagerNonConfig = mAdded;
          try
          {
            mAdded.add(paramParcelable);
            i += 1;
          }
          catch (Throwable paramParcelable)
          {
            throw paramParcelable;
          }
        }
      }
      throw new IllegalStateException("Already added!");
      label786:
      paramParcelable = f.sufficientlysecure.rootcommands.util.StringBuilder.append("No instantiated fragment for index #");
      paramParcelable.append(mAdded[i]);
      throwException(new IllegalStateException(paramParcelable.toString()));
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    label831:
    paramParcelable = mBackStack;
    if (paramParcelable != null)
    {
      mBackStack = new ArrayList(paramParcelable.length);
      i = 0;
      for (;;)
      {
        paramParcelable = mBackStack;
        if (i >= paramParcelable.length) {
          break;
        }
        paramParcelable = paramParcelable[i].instantiate(this);
        if (DEBUG)
        {
          paramFragmentManagerNonConfig = f.sufficientlysecure.rootcommands.util.StringBuilder.append("restoreAllState: back stack #", i, " (index ");
          paramFragmentManagerNonConfig.append(mIndex);
          paramFragmentManagerNonConfig.append("): ");
          paramFragmentManagerNonConfig.append(paramParcelable);
          paramFragmentManagerNonConfig.toString();
          paramFragmentManagerNonConfig = new PrintWriter(new LogWriter("FragmentManager"));
          paramParcelable.dump("  ", paramFragmentManagerNonConfig, false);
          paramFragmentManagerNonConfig.close();
        }
        mBackStack.add(paramParcelable);
        j = mIndex;
        if (j >= 0) {
          setBackStackIndex(j, paramParcelable);
        }
        i += 1;
      }
    }
    mBackStack = null;
    i = mPrimaryNavActiveIndex;
    if (i >= 0) {
      mPrimaryNav = ((Fragment)mActive.get(i));
    }
    mNextFragmentIndex = mNextFragmentIndex;
  }
  
  public FragmentManagerNonConfig retainNonConfig()
  {
    setRetaining(mSavedNonConfig);
    return mSavedNonConfig;
  }
  
  public Parcelable saveAllState()
  {
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions();
    mStateSaved = true;
    Object localObject3 = null;
    mSavedNonConfig = null;
    Object localObject1 = mActive;
    if (localObject1 != null)
    {
      if (((SparseArray)localObject1).size() <= 0) {
        return null;
      }
      int m = mActive.size();
      FragmentState[] arrayOfFragmentState = new FragmentState[m];
      int k = 0;
      int i = 0;
      int j = 0;
      while (i < m)
      {
        localObject1 = (Fragment)mActive.valueAt(i);
        if (localObject1 != null) {
          if (mIndex >= 0)
          {
            localObject2 = new FragmentState((Fragment)localObject1);
            arrayOfFragmentState[i] = localObject2;
            if ((mState > 0) && (mSavedFragmentState == null))
            {
              mSavedFragmentState = saveFragmentBasicState((Fragment)localObject1);
              localObject4 = mTarget;
              if (localObject4 != null) {
                if (mIndex >= 0)
                {
                  if (mSavedFragmentState == null) {
                    mSavedFragmentState = new Bundle();
                  }
                  putFragment(mSavedFragmentState, "android:target_state", mTarget);
                  j = mTargetRequestCode;
                  if (j != 0) {
                    mSavedFragmentState.putInt("android:target_req_state", j);
                  }
                }
                else
                {
                  localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failure saving state: ", localObject1, " has target not in fragment manager: ");
                  ((StringBuilder)localObject2).append(mTarget);
                  throwException(new IllegalStateException(((StringBuilder)localObject2).toString()));
                  throw new NullPointerException("Null throw statement replaced by Soot");
                }
              }
            }
            else
            {
              mSavedFragmentState = mSavedFragmentState;
            }
            if (DEBUG)
            {
              localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Saved state of ", localObject1, ": ");
              ((StringBuilder)localObject1).append(mSavedFragmentState);
              ((StringBuilder)localObject1).toString();
            }
            j = 1;
          }
          else
          {
            localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failure saving state: active ", localObject1, " has cleared index: ");
            ((StringBuilder)localObject2).append(mIndex);
            throwException(new IllegalStateException(((StringBuilder)localObject2).toString()));
            throw new NullPointerException("Null throw statement replaced by Soot");
          }
        }
        i += 1;
      }
      if (j == 0)
      {
        boolean bool = DEBUG;
        return null;
      }
      j = mAdded.size();
      if (j > 0)
      {
        localObject2 = new int[j];
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break label565;
          }
          localObject2[i] = mAdded.get(i)).mIndex;
          if (localObject2[i] < 0) {
            break;
          }
          if (DEBUG)
          {
            localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("saveAllState: adding fragment #", i, ": ");
            ((StringBuilder)localObject1).append(mAdded.get(i));
            ((StringBuilder)localObject1).toString();
          }
          i += 1;
        }
        localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failure saving state: active ");
        ((StringBuilder)localObject1).append(mAdded.get(i));
        ((StringBuilder)localObject1).append(" has cleared index: ");
        ((StringBuilder)localObject1).append(localObject2[i]);
        throwException(new IllegalStateException(((StringBuilder)localObject1).toString()));
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      localObject1 = null;
      label565:
      Object localObject4 = mBackStack;
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        j = ((ArrayList)localObject4).size();
        localObject2 = localObject3;
        if (j > 0)
        {
          localObject3 = new BackStackState[j];
          i = k;
          for (;;)
          {
            localObject2 = localObject3;
            if (i >= j) {
              break;
            }
            localObject3[i] = new BackStackState((BackStackRecord)mBackStack.get(i));
            if (DEBUG)
            {
              localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("saveAllState: adding back stack #", i, ": ");
              ((StringBuilder)localObject2).append(mBackStack.get(i));
              ((StringBuilder)localObject2).toString();
            }
            i += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      mActive = arrayOfFragmentState;
      mAdded = ((int[])localObject1);
      mBackStack = ((BackStackState[])localObject2);
      localObject1 = mPrimaryNav;
      if (localObject1 != null) {
        mPrimaryNavActiveIndex = mIndex;
      }
      mNextFragmentIndex = mNextFragmentIndex;
      saveNonConfig();
      return localObject3;
    }
    return null;
  }
  
  public Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    if (mStateBundle == null) {
      mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(mStateBundle);
    dispatchOnFragmentSaveInstanceState(paramFragment, mStateBundle, false);
    if (!mStateBundle.isEmpty())
    {
      localObject2 = mStateBundle;
      mStateBundle = null;
    }
    else
    {
      localObject2 = null;
    }
    if (mView != null) {
      saveFragmentViewState(paramFragment);
    }
    Object localObject1 = localObject2;
    if (mSavedViewState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putSparseParcelableArray("android:view_state", mSavedViewState);
    }
    Object localObject2 = localObject1;
    if (!mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", mUserVisibleHint);
    }
    return localObject2;
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    if (mIndex >= 0)
    {
      if (mState > 0)
      {
        paramFragment = saveFragmentBasicState(paramFragment);
        if (paramFragment != null) {
          return new Fragment.SavedState(paramFragment);
        }
      }
    }
    else
    {
      throwException(new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Fragment ", paramFragment, " is not currently in the FragmentManager")));
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    return null;
  }
  
  public void saveFragmentViewState(Fragment paramFragment)
  {
    if (mInnerView == null) {
      return;
    }
    SparseArray localSparseArray = mStateArray;
    if (localSparseArray == null) {
      mStateArray = new SparseArray();
    } else {
      localSparseArray.clear();
    }
    mInnerView.saveHierarchyState(mStateArray);
    if (mStateArray.size() > 0)
    {
      mSavedViewState = mStateArray;
      mStateArray = null;
    }
  }
  
  public void saveNonConfig()
  {
    Object localObject1 = mActive;
    Object localObject3 = this;
    if (localObject1 != null)
    {
      int i = 0;
      localObject1 = null;
      Object localObject4 = null;
      Object localObject2 = null;
      for (;;)
      {
        Object localObject10 = mActive;
        Object localObject5 = localObject3;
        localObject9 = localObject1;
        localObject8 = localObject4;
        localObject7 = localObject2;
        localObject6 = localObject5;
        if (i >= ((SparseArray)localObject10).size()) {
          break;
        }
        localObject6 = mActive;
        localObject7 = localObject5;
        Fragment localFragment = (Fragment)((SparseArray)localObject6).valueAt(i);
        localObject8 = localObject1;
        localObject9 = localObject4;
        localObject10 = localObject2;
        localObject6 = localObject7;
        if (localFragment != null)
        {
          localObject5 = localObject1;
          int j;
          if (mRetainInstance)
          {
            localObject6 = localObject1;
            if (localObject1 == null) {
              localObject6 = new ArrayList();
            }
            ((ArrayList)localObject6).add(localFragment);
            localObject1 = mTarget;
            if (localObject1 != null) {
              j = mIndex;
            } else {
              j = -1;
            }
            mTargetIndex = j;
            localObject5 = localObject6;
            if (DEBUG)
            {
              f.sufficientlysecure.rootcommands.util.StringBuilder.append("retainNonConfig: keeping retained ", localFragment);
              localObject5 = localObject6;
            }
          }
          localObject1 = mChildFragmentManager;
          if (localObject1 != null)
          {
            ((FragmentManagerImpl)localObject1).saveNonConfig();
            localObject8 = mChildFragmentManager.mSavedNonConfig;
          }
          else
          {
            localObject8 = mChildNonConfig;
          }
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = localObject4;
            if (localObject8 != null)
            {
              localObject4 = new ArrayList(mActive.size());
              j = 0;
              for (;;)
              {
                localObject1 = localObject4;
                if (j >= i) {
                  break;
                }
                ((ArrayList)localObject4).add(null);
                j += 1;
              }
            }
          }
          localObject6 = localObject3;
          if (localObject1 != null) {
            ((ArrayList)localObject1).add(localObject8);
          }
          localObject3 = localObject2;
          localObject4 = localObject6;
          if (localObject2 == null)
          {
            localObject3 = localObject2;
            localObject4 = localObject6;
            if (mViewModelStore != null)
            {
              localObject2 = mActive;
              localObject2 = new ArrayList(((SparseArray)localObject2).size());
              j = 0;
              for (;;)
              {
                localObject3 = localObject2;
                localObject4 = localObject6;
                if (j >= i) {
                  break;
                }
                ((ArrayList)localObject2).add(null);
                j += 1;
              }
            }
          }
          localObject8 = localObject5;
          localObject9 = localObject1;
          localObject10 = localObject3;
          localObject6 = localObject4;
          if (localObject3 != null)
          {
            ((ArrayList)localObject3).add(mViewModelStore);
            localObject6 = localObject4;
            localObject10 = localObject3;
            localObject9 = localObject1;
            localObject8 = localObject5;
          }
        }
        i += 1;
        localObject1 = localObject8;
        localObject4 = localObject9;
        localObject2 = localObject10;
        localObject3 = localObject6;
      }
    }
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = localObject3;
    if ((localObject9 == null) && (localObject8 == null) && (localObject7 == null))
    {
      mSavedNonConfig = null;
      return;
    }
    mSavedNonConfig = new FragmentManagerNonConfig(localObject9, (List)localObject8, localObject7);
  }
  
  public void scheduleCommit()
  {
    for (;;)
    {
      int j;
      try
      {
        ArrayList localArrayList = mPostponedTransactions;
        int k = 0;
        if ((localArrayList == null) || (mPostponedTransactions.isEmpty())) {
          break label96;
        }
        i = 1;
        j = k;
        if (mPendingActions == null) {
          break label101;
        }
        j = k;
        if (mPendingActions.size() != 1) {
          break label101;
        }
        j = 1;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      mHost.getHandler().removeCallbacks(mExecCommit);
      mHost.getHandler().post(mExecCommit);
      return;
      label96:
      int i = 0;
      continue;
      label101:
      if (i == 0) {
        if (j == 0) {}
      }
    }
  }
  
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    try
    {
      if (mBackStackIndices == null) {
        mBackStackIndices = new ArrayList();
      }
      int j = mBackStackIndices.size();
      int i = j;
      StringBuilder localStringBuilder;
      if (paramInt < j)
      {
        if (DEBUG)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Setting back stack index ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" to ");
          localStringBuilder.append(paramBackStackRecord);
          localStringBuilder.toString();
        }
        mBackStackIndices.set(paramInt, paramBackStackRecord);
      }
      else
      {
        while (i < paramInt)
        {
          mBackStackIndices.add(null);
          if (mAvailBackStackIndices == null) {
            mAvailBackStackIndices = new ArrayList();
          }
          if (DEBUG)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Adding available back stack index ");
            localStringBuilder.append(i);
            localStringBuilder.toString();
          }
          mAvailBackStackIndices.add(Integer.valueOf(i));
          i += 1;
        }
        if (DEBUG)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Adding back stack index ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" with ");
          localStringBuilder.append(paramBackStackRecord);
          localStringBuilder.toString();
        }
        mBackStackIndices.add(paramBackStackRecord);
      }
      return;
    }
    catch (Throwable paramBackStackRecord)
    {
      throw paramBackStackRecord;
    }
  }
  
  public void setPrimaryNavigationFragment(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((mActive.get(mIndex) != paramFragment) || ((mHost != null) && (paramFragment.getFragmentManager() != this))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not an active fragment of FragmentManager ");
      localStringBuilder.append(this);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    mPrimaryNav = paramFragment;
  }
  
  public void showFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("show: ", paramFragment);
    }
    if (mHidden)
    {
      mHidden = false;
      mHiddenChanged ^= true;
    }
  }
  
  public void startPendingDeferredFragments()
  {
    if (mActive == null) {
      return;
    }
    int i = 0;
    while (i < mActive.size())
    {
      Fragment localFragment = (Fragment)mActive.valueAt(i);
      if (localFragment != null) {
        performPendingDeferredStart(localFragment);
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    Fragment localFragment = mParent;
    if (localFragment != null) {
      DebugUtils.buildShortClassTag(localFragment, localStringBuilder);
    } else {
      DebugUtils.buildShortClassTag(mHost, localStringBuilder);
    }
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = mLifecycleCallbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        int j = mLifecycleCallbacks.size();
        if (i < j)
        {
          if (mLifecycleCallbacks.get(i)).mCallback != paramFragmentLifecycleCallbacks) {
            break label67;
          }
          mLifecycleCallbacks.remove(i);
        }
        return;
      }
      catch (Throwable paramFragmentLifecycleCallbacks)
      {
        throw paramFragmentLifecycleCallbacks;
      }
      label67:
      i += 1;
    }
  }
  
  public class AnimateOnHWLayerIfNeededListener
    extends FragmentManagerImpl.AnimationListenerWrapper
  {
    public AnimateOnHWLayerIfNeededListener(Animation.AnimationListener paramAnimationListener)
    {
      super();
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if ((!ViewCompat.cancel(FragmentManagerImpl.this)) && (Build.VERSION.SDK_INT < 24)) {
        setLayerType(0, null);
      } else {
        post(new FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.1(this));
      }
      Animation.AnimationListener localAnimationListener = mWrapped;
      if (localAnimationListener != null) {
        localAnimationListener.onAnimationEnd(paramAnimation);
      }
    }
  }
  
  public class AnimationListenerWrapper
    implements Animation.AnimationListener
  {
    public AnimationListenerWrapper() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      Animation.AnimationListener localAnimationListener = FragmentManagerImpl.this;
      if (localAnimationListener != null) {
        localAnimationListener.onAnimationEnd(paramAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation)
    {
      Animation.AnimationListener localAnimationListener = FragmentManagerImpl.this;
      if (localAnimationListener != null) {
        localAnimationListener.onAnimationRepeat(paramAnimation);
      }
    }
    
    public void onAnimationStart(Animation paramAnimation)
    {
      Animation.AnimationListener localAnimationListener = FragmentManagerImpl.this;
      if (localAnimationListener != null) {
        localAnimationListener.onAnimationStart(paramAnimation);
      }
    }
  }
  
  public class AnimationOrAnimator
  {
    public final Animation animation;
    public final Animator animator;
    
    public AnimationOrAnimator()
    {
      animation = null;
      animator = this$1;
      if (this$1 != null) {
        return;
      }
      throw new IllegalStateException("Animator cannot be null");
    }
    
    public AnimationOrAnimator()
    {
      animation = this$1;
      animator = null;
      if (this$1 != null) {
        return;
      }
      throw new IllegalStateException("Animation cannot be null");
    }
  }
  
  public class AnimatorOnHWLayerIfNeededListener
    extends AnimatorListenerAdapter
  {
    public AnimatorOnHWLayerIfNeededListener() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      setLayerType(0, null);
      paramAnimator.removeListener(this);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      setLayerType(2, null);
    }
  }
  
  public class EndViewTransitionAnimator
    extends AnimationSet
    implements Runnable
  {
    public boolean mAnimating = true;
    public final View mChild;
    public boolean mEnded;
    public final ViewGroup mParent;
    public boolean mTransitionEnded;
    
    public EndViewTransitionAnimator(ViewGroup paramViewGroup, View paramView)
    {
      super();
      mParent = paramViewGroup;
      mChild = paramView;
      addAnimation(this$1);
      mParent.post(this);
    }
    
    public boolean getTransformation(long paramLong, Transformation paramTransformation)
    {
      mAnimating = true;
      if (mEnded) {
        return mTransitionEnded ^ true;
      }
      if (!super.getTransformation(paramLong, paramTransformation))
      {
        mEnded = true;
        OneShotPreDrawListener.a(mParent, this);
      }
      return true;
    }
    
    public boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
    {
      mAnimating = true;
      if (mEnded) {
        return mTransitionEnded ^ true;
      }
      if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        mEnded = true;
        OneShotPreDrawListener.a(mParent, this);
      }
      return true;
    }
    
    public void run()
    {
      if ((!mEnded) && (mAnimating))
      {
        mAnimating = false;
        mParent.post(this);
        return;
      }
      mParent.endViewTransition(mChild);
      mTransitionEnded = true;
    }
  }
  
  public final class FragmentLifecycleCallbacksHolder
  {
    public final boolean mRecursive;
    
    public FragmentLifecycleCallbacksHolder(boolean paramBoolean)
    {
      mRecursive = paramBoolean;
    }
  }
  
  public class FragmentTag
  {
    public static final int[] Fragment = { 16842755, 16842960, 16842961 };
    public static final int Fragment_id = 1;
    public static final int Fragment_name = 0;
    public static final int Fragment_tag = 2;
    
    public FragmentTag() {}
  }
  
  public abstract interface OpGenerator
  {
    public abstract boolean generateOps(ArrayList paramArrayList1, ArrayList paramArrayList2);
  }
  
  public class PopBackStackState
    implements FragmentManagerImpl.OpGenerator
  {
    public final int mFlags;
    public final int mFolder;
    public final String mName;
    
    public PopBackStackState(String paramString, int paramInt1, int paramInt2)
    {
      mName = paramString;
      mFolder = paramInt1;
      mFlags = paramInt2;
    }
    
    public boolean generateOps(ArrayList paramArrayList1, ArrayList paramArrayList2)
    {
      Object localObject = mPrimaryNav;
      if ((localObject != null) && (mFolder < 0) && (mName == null))
      {
        localObject = ((Fragment)localObject).peekChildFragmentManager();
        if ((localObject != null) && (((FragmentManager)localObject).popBackStackImmediate())) {
          return false;
        }
      }
      return popBackStackState(paramArrayList1, paramArrayList2, mName, mFolder, mFlags);
    }
  }
  
  public class StartEnterTransitionListener
    implements Fragment.OnStartEnterTransitionListener
  {
    public final boolean mIsBack;
    public int mNumPostponed;
    
    public StartEnterTransitionListener(boolean paramBoolean)
    {
      mIsBack = paramBoolean;
    }
    
    public void cancelTransaction()
    {
      BackStackRecord localBackStackRecord = FragmentManagerImpl.this;
      mManager.completeExecute(localBackStackRecord, mIsBack, false, false);
    }
    
    public void completeTransaction()
    {
      int i = mNumPostponed;
      int j = 0;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject = mManager;
      int k = mAdded.size();
      while (j < k)
      {
        Fragment localFragment = (Fragment)mAdded.get(j);
        localFragment.setOnStartEnterTransitionListener(null);
        if ((i != 0) && (localFragment.isPostponed())) {
          localFragment.startPostponedEnterTransition();
        }
        j += 1;
      }
      localObject = FragmentManagerImpl.this;
      mManager.completeExecute((BackStackRecord)localObject, mIsBack, i ^ 0x1, true);
    }
    
    public boolean isReady()
    {
      return mNumPostponed == 0;
    }
    
    public void onStartEnterTransition()
    {
      mNumPostponed -= 1;
      if (mNumPostponed != 0) {
        return;
      }
      mManager.scheduleCommit();
    }
    
    public void startListening()
    {
      mNumPostponed += 1;
    }
  }
}
