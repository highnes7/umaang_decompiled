package support.android.v4.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import b.b.a.N;

public abstract class ActionProvider
{
  public static final String TAG = "ActionProvider(support)";
  public final Context mContext;
  public SubUiVisibilityListener mSubUiVisibilityListener;
  public VisibilityListener mVisibilityListener;
  
  public ActionProvider(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return true;
  }
  
  public abstract View onCreateActionView();
  
  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return onCreateActionView();
  }
  
  public boolean onPerformDefaultAction()
  {
    return false;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu) {}
  
  public boolean overridesItemVisibility()
  {
    return false;
  }
  
  public void refreshVisibility()
  {
    if ((mVisibilityListener != null) && (overridesItemVisibility())) {
      mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }
  }
  
  public void reset()
  {
    mVisibilityListener = null;
    mSubUiVisibilityListener = null;
  }
  
  public void setSubUiVisibilityListener(SubUiVisibilityListener paramSubUiVisibilityListener)
  {
    mSubUiVisibilityListener = paramSubUiVisibilityListener;
  }
  
  public void setVisibilityListener(VisibilityListener paramVisibilityListener)
  {
    if ((mVisibilityListener != null) && (paramVisibilityListener != null))
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" instance while it is still in use somewhere else?");
      localStringBuilder.toString();
    }
    mVisibilityListener = paramVisibilityListener;
  }
  
  public void subUiVisibilityChanged(boolean paramBoolean)
  {
    SubUiVisibilityListener localSubUiVisibilityListener = mSubUiVisibilityListener;
    if (localSubUiVisibilityListener != null) {
      localSubUiVisibilityListener.onSubUiVisibilityChanged(paramBoolean);
    }
  }
  
  @N({b.b.a.N.a.b})
  public abstract interface SubUiVisibilityListener
  {
    public abstract void onSubUiVisibilityChanged(boolean paramBoolean);
  }
  
  public abstract interface VisibilityListener
  {
    public abstract void onActionProviderVisibilityChanged(boolean paramBoolean);
  }
}
