package android.support.v4.package_7;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import support.android.v4.view.PagerAdapter;

public abstract class FragmentPagerAdapter
  extends PagerAdapter
{
  public static final boolean DEBUG = false;
  public static final String TAG = "FragmentPagerAdapter";
  public FragmentTransaction mCurTransaction = null;
  public Fragment mCurrentPrimaryItem = null;
  public final FragmentManager mFragmentManager;
  
  public FragmentPagerAdapter(FragmentManager paramFragmentManager)
  {
    mFragmentManager = paramFragmentManager;
  }
  
  public static String makeFragmentName(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android:switcher:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(":");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (mCurTransaction == null) {
      mCurTransaction = mFragmentManager.beginTransaction();
    }
    mCurTransaction.detach((Fragment)paramObject);
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
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (mCurTransaction == null) {
      mCurTransaction = mFragmentManager.beginTransaction();
    }
    long l = getItemId(paramInt);
    Object localObject = makeFragmentName(paramViewGroup.getId(), l);
    Fragment localFragment = mFragmentManager.findFragmentByTag((String)localObject);
    localObject = localFragment;
    if (localFragment != null)
    {
      mCurTransaction.attach(localFragment);
    }
    else
    {
      localFragment = getItem(paramInt);
      localObject = localFragment;
      mCurTransaction.add(paramViewGroup.getId(), localFragment, makeFragmentName(paramViewGroup.getId(), l));
    }
    if (localObject != mCurrentPrimaryItem)
    {
      ((Fragment)localObject).setMenuVisibility(false);
      ((Fragment)localObject).setUserVisibleHint(false);
    }
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
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
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("ViewPager with adapter ", this, " requires a view id"));
  }
}
