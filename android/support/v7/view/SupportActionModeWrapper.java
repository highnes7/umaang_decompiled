package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.support.v7.view.menu.MenuWrapperICS;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import b.b.a.N;
import b.b.x.n.t;
import java.util.ArrayList;
import support.android.v4.media.session.SupportMenu;
import support.android.v4.media.session.SupportMenuItem;
import support.android.v4.util.SimpleArrayMap;

@N({b.b.a.N.a.b})
public class SupportActionModeWrapper
  extends android.view.ActionMode
{
  public final Context mContext;
  public final ActionMode mWrappedObject;
  
  public SupportActionModeWrapper(Context paramContext, ActionMode paramActionMode)
  {
    mContext = paramContext;
    mWrappedObject = paramActionMode;
  }
  
  public void finish()
  {
    mWrappedObject.finish();
  }
  
  public View getCustomView()
  {
    return mWrappedObject.getCustomView();
  }
  
  public Menu getMenu()
  {
    return new MenuWrapperICS(mContext, (SupportMenu)mWrappedObject.getMenu());
  }
  
  public MenuInflater getMenuInflater()
  {
    return mWrappedObject.getMenuInflater();
  }
  
  public CharSequence getSubtitle()
  {
    return mWrappedObject.getSubtitle();
  }
  
  public Object getTag()
  {
    return mWrappedObject.getTag();
  }
  
  public CharSequence getTitle()
  {
    return mWrappedObject.getTitle();
  }
  
  public boolean getTitleOptionalHint()
  {
    return mWrappedObject.getTitleOptionalHint();
  }
  
  public void invalidate()
  {
    mWrappedObject.invalidate();
  }
  
  public boolean isTitleOptional()
  {
    return mWrappedObject.isTitleOptional();
  }
  
  public void setCustomView(View paramView)
  {
    mWrappedObject.setCustomView(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    mWrappedObject.setSubtitle(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    mWrappedObject.setSubtitle(paramCharSequence);
  }
  
  public void setTag(Object paramObject)
  {
    mWrappedObject.setTag(paramObject);
  }
  
  public void setTitle(int paramInt)
  {
    mWrappedObject.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mWrappedObject.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    mWrappedObject.setTitleOptionalHint(paramBoolean);
  }
  
  @N({b.b.a.N.a.b})
  public static class CallbackWrapper
    implements ActionMode.Callback
  {
    public final ArrayList<SupportActionModeWrapper> mActionModes;
    public final Context mContext;
    public final t<Menu, Menu> mMenus;
    public final android.view.ActionMode.Callback mWrappedCallback;
    
    public CallbackWrapper(Context paramContext, android.view.ActionMode.Callback paramCallback)
    {
      mContext = paramContext;
      mWrappedCallback = paramCallback;
      mActionModes = new ArrayList();
      mMenus = new SimpleArrayMap();
    }
    
    private Menu getMenuWrapper(Menu paramMenu)
    {
      Object localObject = (Menu)mMenus.get(paramMenu);
      if (localObject == null)
      {
        localObject = new MenuWrapperICS(mContext, (SupportMenu)paramMenu);
        mMenus.put(paramMenu, localObject);
        return localObject;
      }
      return localObject;
    }
    
    public android.view.ActionMode getActionModeWrapper(ActionMode paramActionMode)
    {
      int j = mActionModes.size();
      int i = 0;
      while (i < j)
      {
        SupportActionModeWrapper localSupportActionModeWrapper = (SupportActionModeWrapper)mActionModes.get(i);
        if ((localSupportActionModeWrapper != null) && (mWrappedObject == paramActionMode)) {
          return localSupportActionModeWrapper;
        }
        i += 1;
      }
      paramActionMode = new SupportActionModeWrapper(mContext, paramActionMode);
      mActionModes.add(paramActionMode);
      return paramActionMode;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return mWrappedCallback.onActionItemClicked(getActionModeWrapper(paramActionMode), MenuWrapperFactory.wrapSupportMenuItem(mContext, (SupportMenuItem)paramMenuItem));
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrappedCallback.onCreateActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      mWrappedCallback.onDestroyActionMode(getActionModeWrapper(paramActionMode));
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrappedCallback.onPrepareActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
    }
  }
}
