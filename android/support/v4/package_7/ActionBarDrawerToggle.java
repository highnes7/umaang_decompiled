package android.support.v4.package_7;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.c;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import java.lang.reflect.Method;
import support.android.v4.content.ContextCompat;
import support.android.v4.view.ViewCompat;

@Deprecated
public class ActionBarDrawerToggle
  implements DrawerLayout.c
{
  public static final int ID_HOME = 16908332;
  public static final String TAG = "ActionBarDrawerToggle";
  public static final int[] THEME_ATTRS = { 16843531 };
  public static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334F;
  public final Activity mActivity;
  public final Delegate mActivityImpl;
  public final int mCloseDrawerContentDescRes;
  public Drawable mDrawerImage;
  public final int mDrawerImageResource;
  public boolean mDrawerIndicatorEnabled = true;
  public final DrawerLayout mDrawerLayout;
  public boolean mHasCustomUpIndicator;
  public Drawable mHomeAsUpIndicator;
  public final int mOpenDrawerContentDescRes;
  public SetIndicatorInfo mSetIndicatorInfo;
  public SlideDrawable mSlider;
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramActivity, paramDrawerLayout, assumeMaterial(paramActivity) ^ true, paramInt1, paramInt2, paramInt3);
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    mActivity = paramActivity;
    if ((paramActivity instanceof DelegateProvider)) {
      mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
    } else {
      mActivityImpl = null;
    }
    mDrawerLayout = paramDrawerLayout;
    mDrawerImageResource = paramInt1;
    mOpenDrawerContentDescRes = paramInt2;
    mCloseDrawerContentDescRes = paramInt3;
    mHomeAsUpIndicator = getThemeUpIndicator();
    mDrawerImage = ContextCompat.getDrawable(paramActivity, paramInt1);
    mSlider = new SlideDrawable(mDrawerImage);
    paramActivity = mSlider;
    float f;
    if (paramBoolean) {
      f = 0.33333334F;
    } else {
      f = 0.0F;
    }
    paramActivity.setOffset(f);
  }
  
  public static boolean assumeMaterial(Context paramContext)
  {
    return (getApplicationInfotargetSdkVersion >= 21) && (Build.VERSION.SDK_INT >= 21);
  }
  
  private Drawable getThemeUpIndicator()
  {
    Object localObject = mActivityImpl;
    if (localObject != null) {
      return ((Delegate)localObject).getThemeUpIndicator();
    }
    int i = Build.VERSION.SDK_INT;
    localObject = mActivity.getActionBar();
    if (localObject != null) {
      localObject = ((ActionBar)localObject).getThemedContext();
    } else {
      localObject = mActivity;
    }
    localObject = ((Context)localObject).obtainStyledAttributes(null, THEME_ATTRS, 16843470, 0);
    Drawable localDrawable = ((TypedArray)localObject).getDrawable(0);
    ((TypedArray)localObject).recycle();
    return localDrawable;
  }
  
  private void setActionBarDescription(int paramInt)
  {
    Object localObject = mActivityImpl;
    if (localObject != null)
    {
      ((Delegate)localObject).setActionBarDescription(paramInt);
      return;
    }
    int i = Build.VERSION.SDK_INT;
    localObject = mActivity.getActionBar();
    if (localObject != null) {
      ((ActionBar)localObject).setHomeActionContentDescription(paramInt);
    }
  }
  
  private void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    Object localObject = mActivityImpl;
    if (localObject != null)
    {
      ((Delegate)localObject).setActionBarUpIndicator(paramDrawable, paramInt);
      return;
    }
    int i = Build.VERSION.SDK_INT;
    localObject = mActivity.getActionBar();
    if (localObject != null)
    {
      ((ActionBar)localObject).setHomeAsUpIndicator(paramDrawable);
      ((ActionBar)localObject).setHomeActionContentDescription(paramInt);
    }
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!mHasCustomUpIndicator) {
      mHomeAsUpIndicator = getThemeUpIndicator();
    }
    mDrawerImage = ContextCompat.getDrawable(mActivity, mDrawerImageResource);
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    mSlider.setPosition(0.0F);
    if (mDrawerIndicatorEnabled) {
      setActionBarDescription(mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    mSlider.setPosition(1.0F);
    if (mDrawerIndicatorEnabled) {
      setActionBarDescription(mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    float f = mSlider.getPosition();
    if (paramFloat > 0.5F) {
      paramFloat = Math.max(f, Math.max(0.0F, paramFloat - 0.5F) * 2.0F);
    } else {
      paramFloat = Math.min(f, paramFloat * 2.0F);
    }
    mSlider.setPosition(paramFloat);
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (mDrawerIndicatorEnabled))
    {
      if (mDrawerLayout.isDrawerVisible(8388611)) {
        mDrawerLayout.closeDrawer(8388611);
      } else {
        mDrawerLayout.openDrawer(8388611);
      }
      return true;
    }
    return false;
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    if (paramBoolean != mDrawerIndicatorEnabled)
    {
      if (paramBoolean)
      {
        SlideDrawable localSlideDrawable = mSlider;
        int i;
        if (mDrawerLayout.isDrawerOpen(8388611)) {
          i = mCloseDrawerContentDescRes;
        } else {
          i = mOpenDrawerContentDescRes;
        }
        setActionBarUpIndicator(localSlideDrawable, i);
      }
      else
      {
        setActionBarUpIndicator(mHomeAsUpIndicator, 0);
      }
      mDrawerIndicatorEnabled = paramBoolean;
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(mActivity, paramInt);
    } else {
      localDrawable = null;
    }
    setHomeAsUpIndicator(localDrawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      mHomeAsUpIndicator = getThemeUpIndicator();
      mHasCustomUpIndicator = false;
    }
    else
    {
      mHomeAsUpIndicator = paramDrawable;
      mHasCustomUpIndicator = true;
    }
    if (!mDrawerIndicatorEnabled) {
      setActionBarUpIndicator(mHomeAsUpIndicator, 0);
    }
  }
  
  public void syncState()
  {
    if (mDrawerLayout.isDrawerOpen(8388611)) {
      mSlider.setPosition(1.0F);
    } else {
      mSlider.setPosition(0.0F);
    }
    if (mDrawerIndicatorEnabled)
    {
      SlideDrawable localSlideDrawable = mSlider;
      int i;
      if (mDrawerLayout.isDrawerOpen(8388611)) {
        i = mCloseDrawerContentDescRes;
      } else {
        i = mOpenDrawerContentDescRes;
      }
      setActionBarUpIndicator(localSlideDrawable, i);
    }
  }
  
  @Deprecated
  public abstract interface Delegate
  {
    public abstract Drawable getThemeUpIndicator();
    
    public abstract void setActionBarDescription(int paramInt);
    
    public abstract void setActionBarUpIndicator(Drawable paramDrawable, int paramInt);
  }
  
  @Deprecated
  public abstract interface DelegateProvider
  {
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  public class SetIndicatorInfo
  {
    public Method mSetHomeActionContentDescription;
    public Method mSetHomeAsUpIndicator;
    public ImageView mUpIndicatorView;
    
    public SetIndicatorInfo()
    {
      try
      {
        localObject = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
        mSetHomeAsUpIndicator = ((Method)localObject);
        localObject = Integer.TYPE;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Object localObject;
        label52:
        for (;;) {}
      }
      try
      {
        localObject = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[] { localObject });
        mSetHomeActionContentDescription = ((Method)localObject);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label52;
      }
      this$1 = this$1.findViewById(16908332);
      if (this$1 == null) {
        return;
      }
      localObject = (ViewGroup)this$1.getParent();
      if (((ViewGroup)localObject).getChildCount() != 2) {
        return;
      }
      this$1 = ((ViewGroup)localObject).getChildAt(0);
      localObject = ((ViewGroup)localObject).getChildAt(1);
      if (this$1.getId() == 16908332) {
        this$1 = (ActionBarDrawerToggle)localObject;
      }
      if ((this$1 instanceof ImageView))
      {
        mUpIndicatorView = ((ImageView)this$1);
        return;
      }
    }
  }
  
  public class SlideDrawable
    extends InsetDrawable
    implements Drawable.Callback
  {
    public final boolean mHasMirroring;
    public float mOffset;
    public float mPosition;
    public final Rect mTmpRect;
    
    public SlideDrawable(Drawable paramDrawable)
    {
      super(0);
      int i = Build.VERSION.SDK_INT;
      mHasMirroring = true;
      mTmpRect = new Rect();
    }
    
    public void draw(Canvas paramCanvas)
    {
      copyBounds(mTmpRect);
      paramCanvas.save();
      int i = ViewCompat.getLayoutDirection(mActivity.getWindow().getDecorView());
      int j = 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        j = -1;
      }
      int k = mTmpRect.width();
      float f1 = -mOffset;
      float f2 = k;
      paramCanvas.translate(f1 * f2 * mPosition * j, 0.0F);
      if ((i != 0) && (!mHasMirroring))
      {
        paramCanvas.translate(f2, 0.0F);
        paramCanvas.scale(-1.0F, 1.0F);
      }
      super.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public float getPosition()
    {
      return mPosition;
    }
    
    public void setOffset(float paramFloat)
    {
      mOffset = paramFloat;
      invalidateSelf();
    }
    
    public void setPosition(float paramFloat)
    {
      mPosition = paramFloat;
      invalidateSelf();
    }
  }
}
