package android.support.v4.package_7;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import support.android.v4.view.PagerAdapter;

public abstract class FragmentStatePagerAdapter
  extends PagerAdapter
{
  public static final boolean DEBUG = false;
  public static final String TAG = "FragmentStatePagerAdapt";
  public FragmentTransaction mCurTransaction = null;
  public Fragment mCurrentPrimaryItem = null;
  public final FragmentManager mFragmentManager;
  public ArrayList<android.support.v4.app.Fragment> mFragments = new ArrayList();
  public ArrayList<android.support.v4.app.Fragment.SavedState> mSavedState = new ArrayList();
  
  public FragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    mFragmentManager = paramFragmentManager;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (mCurTransaction == null) {
      mCurTransaction = mFragmentManager.beginTransaction();
    }
    while (mSavedState.size() <= paramInt) {
      mSavedState.add(null);
    }
    ArrayList localArrayList = mSavedState;
    if (paramObject.isAdded()) {
      paramViewGroup = mFragmentManager.saveFragmentInstanceState(paramObject);
    } else {
      paramViewGroup = null;
    }
    localArrayList.set(paramInt, paramViewGroup);
    mFragments.set(paramInt, null);
    mCurTransaction.remove(paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    paramViewGroup = mCurTransaction;
    if (paramViewGroup != null)
    {
      paramViewGroup.commitNowAllowingStateLoss();
      mCurTransaction = null;
    }
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (mFragments.size() > paramInt)
    {
      localFragment = (Fragment)mFragments.get(paramInt);
      if (localFragment != null) {
        return localFragment;
      }
    }
    if (mCurTransaction == null) {
      mCurTransaction = mFragmentManager.beginTransaction();
    }
    Fragment localFragment = getItem(paramInt);
    if (mSavedState.size() > paramInt)
    {
      Fragment.SavedState localSavedState = (Fragment.SavedState)mSavedState.get(paramInt);
      if (localSavedState != null) {
        localFragment.setInitialSavedState(localSavedState);
      }
    }
    while (mFragments.size() <= paramInt) {
      mFragments.add(null);
    }
    localFragment.setMenuVisibility(false);
    localFragment.setUserVisibleHint(false);
    mFragments.set(paramInt, localFragment);
    mCurTransaction.add(paramViewGroup.getId(), localFragment);
    return localFragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      mSavedState.clear();
      mFragments.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          mSavedState.add((Fragment.SavedState)paramClassLoader[i]);
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        String str = (String)paramClassLoader.next();
        if (str.startsWith("f"))
        {
          i = Integer.parseInt(str.substring(1));
          Fragment localFragment = mFragmentManager.getFragment(paramParcelable, str);
          if (localFragment != null)
          {
            while (mFragments.size() <= i) {
              mFragments.add(null);
            }
            localFragment.setMenuVisibility(false);
            mFragments.set(i, localFragment);
          }
          else
          {
            StringBuilder.get("Bad fragment at key ", str);
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject1;
    Object localObject2;
    if (mSavedState.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[mSavedState.size()];
      mSavedState.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    else
    {
      localObject1 = null;
    }
    int i = 0;
    while (i < mFragments.size())
    {
      Fragment localFragment = (Fragment)mFragments.get(i);
      localObject2 = localObject1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        if (localFragment.isAdded())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          localObject1 = StringBuilder.toString("f", i);
          mFragmentManager.putFragment((Bundle)localObject2, (String)localObject1, localFragment);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    paramObject = mCurrentPrimaryItem;
    if (paramViewGroup != paramObject)
    {
      if (paramObject != null)
      {
        paramObject.setMenuVisibility(false);
        mCurrentPrimaryItem.setUserVisibleHint(false);
      }
      paramViewGroup.setMenuVisibility(true);
      paramViewGroup.setUserVisibleHint(true);
      mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() != -1) {
      return;
    }
    throw new IllegalStateException(StringBuilder.toString("ViewPager with adapter ", this, " requires a view id"));
  }
}
