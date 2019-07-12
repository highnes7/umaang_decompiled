package android.support.v7.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import b.b.a.K;
import b.b.a.N;
import support.android.v4.media.session.SupportMenuItem;

@K(16)
@N({b.b.a.N.a.b})
public class MenuItemWrapperJB
  extends MenuItemWrapperICS
{
  public MenuItemWrapperJB(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }
  
  public MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider paramActionProvider)
  {
    return new ActionProviderWrapperJB(mContext, paramActionProvider);
  }
  
  public class ActionProviderWrapperJB
    extends MenuItemWrapperICS.ActionProviderWrapper
    implements android.view.ActionProvider.VisibilityListener
  {
    public support.android.v4.view.ActionProvider.VisibilityListener mListener;
    
    public ActionProviderWrapperJB(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public boolean isVisible()
    {
      return mInner.isVisible();
    }
    
    public void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      support.android.v4.view.ActionProvider.VisibilityListener localVisibilityListener = mListener;
      if (localVisibilityListener != null) {
        localVisibilityListener.onActionProviderVisibilityChanged(paramBoolean);
      }
    }
    
    public View onCreateActionView(MenuItem paramMenuItem)
    {
      return mInner.onCreateActionView(paramMenuItem);
    }
    
    public boolean overridesItemVisibility()
    {
      return mInner.overridesItemVisibility();
    }
    
    public void refreshVisibility()
    {
      mInner.refreshVisibility();
    }
    
    public void setVisibilityListener(support.android.v4.view.ActionProvider.VisibilityListener paramVisibilityListener)
    {
      mListener = paramVisibilityListener;
      ActionProvider localActionProvider = mInner;
      if (paramVisibilityListener != null) {
        paramVisibilityListener = this;
      } else {
        paramVisibilityListener = null;
      }
      localActionProvider.setVisibilityListener(paramVisibilityListener);
    }
  }
}
