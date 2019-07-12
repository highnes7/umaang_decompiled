package android.support.v4.package_7;

import android.support.v4.app.Fragment;
import b.a.b.C;
import java.util.List;

public class FragmentManagerNonConfig
{
  public final List<android.support.v4.app.FragmentManagerNonConfig> mChildNonConfigs;
  public final List<Fragment> mFragments;
  public final List<C> mViewModelStores;
  
  public FragmentManagerNonConfig(List paramList1, List paramList2, List paramList3)
  {
    mFragments = paramList1;
    mChildNonConfigs = paramList2;
    mViewModelStores = paramList3;
  }
  
  public List getChildNonConfigs()
  {
    return mChildNonConfigs;
  }
  
  public List getFragments()
  {
    return mFragments;
  }
  
  public List getViewModelStores()
  {
    return mViewModelStores;
  }
}
