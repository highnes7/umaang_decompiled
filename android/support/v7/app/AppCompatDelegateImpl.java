package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.package_7.NavUtils;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.SupportActionModeWrapper.CallbackWrapper;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.OnAttachListener;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Adapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.b.a.W;
import java.lang.reflect.Constructor;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import support.android.v4.view.LayoutInflaterCompatHC;
import support.android.v4.view.OnApplyWindowInsetsListener;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.ViewPropertyAnimatorCompat;
import support.android.v4.view.ViewPropertyAnimatorListenerAdapter;
import support.android.v4.view.WindowInsetsCompat;
import support.android.v4.view.c;

public class AppCompatDelegateImpl
  extends AppCompatDelegate
  implements MenuBuilder.Callback, LayoutInflater.Factory2
{
  public static final boolean DEBUG = false;
  public static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
  public static final boolean IS_PRE_LOLLIPOP;
  public static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
  public static boolean sInstalledExceptionHandler;
  public static final int[] sWindowBackgroundStyleable;
  public ActionBar mActionBar;
  public ActionMenuPresenterCallback mActionMenuPresenterCallback;
  public android.support.v7.view.ActionMode mActionMode;
  public PopupWindow mActionModePopup;
  public ActionBarContextView mActionModeView;
  public final AppCompatCallback mAppCompatCallback;
  public AppCompatViewInflater mAppCompatViewInflater;
  public final Window.Callback mAppCompatWindowCallback;
  public boolean mApplyDayNightCalled;
  public AutoNightModeManager mAutoNightModeManager;
  public boolean mClosingActionMenu;
  public final Context mContext;
  public DecorContentParent mDecorContentParent;
  public boolean mEnableDefaultActionBarUp;
  public ViewPropertyAnimatorCompat mFadeAnim = null;
  public boolean mFeatureIndeterminateProgress;
  public boolean mFeatureProgress;
  public boolean mHandleNativeActionModes = true;
  public boolean mHasActionBar;
  public int mInvalidatePanelMenuFeatures;
  public boolean mInvalidatePanelMenuPosted;
  public final Runnable mInvalidatePanelMenuRunnable = new Runnable()
  {
    public void run()
    {
      AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if ((mInvalidatePanelMenuFeatures & 0x1) != 0) {
        localAppCompatDelegateImpl.doInvalidatePanelMenu(0);
      }
      localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if ((mInvalidatePanelMenuFeatures & 0x1000) != 0) {
        localAppCompatDelegateImpl.doInvalidatePanelMenu(108);
      }
      localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      mInvalidatePanelMenuPosted = false;
      mInvalidatePanelMenuFeatures = 0;
    }
  };
  public boolean mIsDestroyed;
  public boolean mIsFloating;
  public int mLocalNightMode = -100;
  public boolean mLongPressBackDown;
  public MenuInflater mMenuInflater;
  public final Window.Callback mOriginalWindowCallback;
  public boolean mOverlayActionBar;
  public boolean mOverlayActionMode;
  public PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  public PanelFeatureState[] mPanels;
  public PanelFeatureState mPreparedPanel;
  public Runnable mShowActionModePopup;
  public View mStatusGuard;
  public ViewGroup mSubDecor;
  public boolean mSubDecorInstalled;
  public Rect mTempRect1;
  public Rect mTempRect2;
  public CharSequence mTitle;
  public TextView mTitleView;
  public final Window mWindow;
  public boolean mWindowNoTitle;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 21) {
      bool = true;
    } else {
      bool = false;
    }
    IS_PRE_LOLLIPOP = bool;
    sWindowBackgroundStyleable = new int[] { 16842836 };
    if ((IS_PRE_LOLLIPOP) && (!sInstalledExceptionHandler))
    {
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
      {
        private boolean shouldWrapException(Throwable paramAnonymousThrowable)
        {
          if ((paramAnonymousThrowable instanceof Resources.NotFoundException))
          {
            paramAnonymousThrowable = paramAnonymousThrowable.getMessage();
            if ((paramAnonymousThrowable != null) && ((paramAnonymousThrowable.contains("drawable")) || (paramAnonymousThrowable.contains("Drawable")))) {
              return true;
            }
          }
          return false;
        }
        
        public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
        {
          if (shouldWrapException(paramAnonymousThrowable))
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramAnonymousThrowable.getMessage());
            ((StringBuilder)localObject).append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            localObject = new Resources.NotFoundException(((StringBuilder)localObject).toString());
            ((Throwable)localObject).initCause(paramAnonymousThrowable.getCause());
            ((Throwable)localObject).setStackTrace(paramAnonymousThrowable.getStackTrace());
            val$defHandler.uncaughtException(paramAnonymousThread, (Throwable)localObject);
            return;
          }
          val$defHandler.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
        }
      });
      sInstalledExceptionHandler = true;
    }
  }
  
  public AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    mContext = paramContext;
    mWindow = paramWindow;
    mAppCompatCallback = paramAppCompatCallback;
    mOriginalWindowCallback = mWindow.getCallback();
    paramWindow = mOriginalWindowCallback;
    if (!(paramWindow instanceof AppCompatWindowCallback))
    {
      mAppCompatWindowCallback = new AppCompatWindowCallback(paramWindow);
      mWindow.setCallback(mAppCompatWindowCallback);
      paramContext = TintTypedArray.obtainStyledAttributes(paramContext, null, sWindowBackgroundStyleable);
      paramWindow = paramContext.getDrawableIfKnown(0);
      if (paramWindow != null) {
        mWindow.setBackgroundDrawable(paramWindow);
      }
      paramContext.recycle();
      return;
    }
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  private void applyFixedSizeWindow()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)mSubDecor.findViewById(16908290);
    Object localObject = mWindow.getDecorView();
    localContentFrameLayout.setDecorPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private ViewGroup createSubDecor()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private void ensureAutoNightModeManager()
  {
    if (mAutoNightModeManager == null) {
      mAutoNightModeManager = new AutoNightModeManager(TwilightManager.getInstance(mContext));
    }
  }
  
  private void ensureSubDecor()
  {
    if (!mSubDecorInstalled)
    {
      mSubDecor = createSubDecor();
      Object localObject1 = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = mDecorContentParent;
        if (localObject2 != null)
        {
          ((DecorContentParent)localObject2).setWindowTitle((CharSequence)localObject1);
        }
        else if (peekSupportActionBar() != null)
        {
          peekSupportActionBar().setWindowTitle((CharSequence)localObject1);
        }
        else
        {
          localObject2 = mTitleView;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject1);
          }
        }
      }
      applyFixedSizeWindow();
      onSubDecorInstalled(mSubDecor);
      mSubDecorInstalled = true;
      localObject1 = getPanelState(0, false);
      if ((!mIsDestroyed) && ((localObject1 == null) || (menu == null))) {
        invalidatePanelMenu(108);
      }
    }
  }
  
  private int getNightMode()
  {
    int i = mLocalNightMode;
    if (i != -100) {
      return i;
    }
    return AppCompatDelegate.sDefaultNightMode;
  }
  
  private void initWindowDecorActionBar()
  {
    ensureSubDecor();
    if (mHasActionBar)
    {
      if (mActionBar != null) {
        return;
      }
      Object localObject = mOriginalWindowCallback;
      if ((localObject instanceof Activity)) {
        mActionBar = new WindowDecorActionBar((Activity)localObject, mOverlayActionBar);
      } else if ((localObject instanceof Dialog)) {
        mActionBar = new WindowDecorActionBar((Dialog)localObject);
      }
      localObject = mActionBar;
      if (localObject != null) {
        ((ActionBar)localObject).setDefaultDisplayHomeAsUpEnabled(mEnableDefaultActionBarUp);
      }
    }
  }
  
  private boolean initializePanelContent(PanelFeatureState paramPanelFeatureState)
  {
    View localView = createdPanelView;
    if (localView != null)
    {
      shownPanelView = localView;
      return true;
    }
    if (menu == null) {
      return false;
    }
    if (mPanelMenuPresenterCallback == null) {
      mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
    }
    shownPanelView = ((View)paramPanelFeatureState.getListMenuView(mPanelMenuPresenterCallback));
    return shownPanelView != null;
  }
  
  private boolean initializePanelDecor(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
    decorView = new ListMenuDecorView(listPresenterContext);
    gravity = 81;
    return true;
  }
  
  private boolean initializePanelMenu(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = mContext;
    int i = featureId;
    if (i != 0)
    {
      localObject1 = localContext;
      if (i != 108) {}
    }
    else
    {
      localObject1 = localContext;
      if (mDecorContentParent != null)
      {
        TypedValue localTypedValue = new TypedValue();
        Resources.Theme localTheme = localContext.getTheme();
        localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
        localObject1 = null;
        if (resourceId != 0)
        {
          localObject2 = localContext.getResources().newTheme();
          localObject1 = localObject2;
          ((Resources.Theme)localObject2).setTo(localTheme);
          ((Resources.Theme)localObject2).applyStyle(resourceId, true);
          ((Resources.Theme)localObject2).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        else
        {
          localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        Object localObject2 = localObject1;
        if (resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = localContext.getResources().newTheme();
            localObject2 = localObject1;
            ((Resources.Theme)localObject1).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(resourceId, true);
        }
        localObject1 = localContext;
        if (localObject2 != null)
        {
          localObject1 = new ContextThemeWrapper(localContext, 0);
          ((ContextThemeWrapper)localObject1).getTheme().setTo((Resources.Theme)localObject2);
        }
      }
    }
    Object localObject1 = new MenuBuilder((Context)localObject1);
    ((MenuBuilder)localObject1).setCallback(this);
    paramPanelFeatureState.setMenu((MenuBuilder)localObject1);
    return true;
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    mInvalidatePanelMenuFeatures = (1 << paramInt | mInvalidatePanelMenuFeatures);
    if (!mInvalidatePanelMenuPosted)
    {
      ViewCompat.postOnAnimation(mWindow.getDecorView(), mInvalidatePanelMenuRunnable);
      mInvalidatePanelMenuPosted = true;
    }
  }
  
  private boolean onKeyDownPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
      if (!isOpen) {
        return preparePanel(localPanelFeatureState, paramKeyEvent);
      }
    }
    return false;
  }
  
  private boolean onKeyUpPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (mActionMode != null) {
      return false;
    }
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    boolean bool;
    if (paramInt == 0)
    {
      DecorContentParent localDecorContentParent = mDecorContentParent;
      if ((localDecorContentParent != null) && (localDecorContentParent.canShowOverflowMenu()) && (!ViewConfiguration.get(mContext).hasPermanentMenuKey()))
      {
        if (!mDecorContentParent.isOverflowMenuShowing())
        {
          if ((mIsDestroyed) || (!preparePanel(localPanelFeatureState, paramKeyEvent))) {
            break label180;
          }
          bool = mDecorContentParent.showOverflowMenu();
          break label198;
        }
        bool = mDecorContentParent.hideOverflowMenu();
        break label198;
      }
    }
    if ((!isOpen) && (!isHandled))
    {
      if (isPrepared)
      {
        if (refreshMenuContent)
        {
          isPrepared = false;
          bool = preparePanel(localPanelFeatureState, paramKeyEvent);
        }
        else
        {
          bool = true;
        }
        if (bool)
        {
          openPanel(localPanelFeatureState, paramKeyEvent);
          bool = true;
          break label198;
        }
      }
      label180:
      bool = false;
    }
    else
    {
      bool = isOpen;
      closePanel(localPanelFeatureState, true);
    }
    label198:
    if (bool)
    {
      paramKeyEvent = (AudioManager)mContext.getSystemService("audio");
      if (paramKeyEvent != null) {
        paramKeyEvent.playSoundEffect(0);
      }
    }
    return bool;
  }
  
  private void openPanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (!isOpen)
    {
      if (mIsDestroyed) {
        return;
      }
      if (featureId == 0)
      {
        if ((mContext.getResources().getConfiguration().screenLayout & 0xF) == 4) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return;
        }
      }
      Object localObject = getWindowCallback();
      if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(featureId, menu)))
      {
        closePanel(paramPanelFeatureState, true);
        return;
      }
      WindowManager localWindowManager = (WindowManager)mContext.getSystemService("window");
      if (localWindowManager == null) {
        return;
      }
      if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {
        return;
      }
      if ((decorView != null) && (!refreshDecorView))
      {
        paramKeyEvent = createdPanelView;
        if (paramKeyEvent != null)
        {
          paramKeyEvent = paramKeyEvent.getLayoutParams();
          if ((paramKeyEvent != null) && (width == -1))
          {
            i = -1;
            break label338;
          }
        }
      }
      else
      {
        paramKeyEvent = decorView;
        if (paramKeyEvent == null)
        {
          initializePanelDecor(paramPanelFeatureState);
          if (decorView != null) {}
        }
        else if ((refreshDecorView) && (paramKeyEvent.getChildCount() > 0))
        {
          decorView.removeAllViews();
        }
        if (!initializePanelContent(paramPanelFeatureState)) {
          return;
        }
        if (!paramPanelFeatureState.hasPanelItems()) {
          return;
        }
        localObject = shownPanelView.getLayoutParams();
        paramKeyEvent = (KeyEvent)localObject;
        if (localObject == null) {
          paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
        }
        i = background;
        decorView.setBackgroundResource(i);
        localObject = shownPanelView.getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeView(shownPanelView);
        }
        decorView.addView(shownPanelView, paramKeyEvent);
        if (!shownPanelView.hasFocus()) {
          shownPanelView.requestFocus();
        }
      }
      int i = -2;
      label338:
      isHandled = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, x, y, 1002, 8519680, -3);
      gravity = gravity;
      windowAnimations = windowAnimations;
      localWindowManager.addView(decorView, paramKeyEvent);
      isOpen = true;
    }
  }
  
  private boolean performPanelShortcut(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (!isPrepared)
    {
      bool1 = bool2;
      if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {}
    }
    else
    {
      MenuBuilder localMenuBuilder = menu;
      bool1 = bool2;
      if (localMenuBuilder != null) {
        bool1 = localMenuBuilder.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    if ((bool1) && ((paramInt2 & 0x1) == 0) && (mDecorContentParent == null)) {
      closePanel(paramPanelFeatureState, true);
    }
    return bool1;
  }
  
  private boolean preparePanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (mIsDestroyed) {
      return false;
    }
    boolean bool = isPrepared;
    PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
    if (bool) {
      return true;
    }
    Object localObject1 = mPreparedPanel;
    if ((localObject1 != null) && (localObject1 != localPanelFeatureState)) {
      closePanel((PanelFeatureState)localObject1, false);
    }
    localObject1 = getWindowCallback();
    if (localObject1 != null) {
      createdPanelView = ((Window.Callback)localObject1).onCreatePanelView(featureId);
    }
    int i = featureId;
    if ((i != 0) && (i != 108)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2;
    if (i != 0)
    {
      localObject2 = mDecorContentParent;
      if (localObject2 != null) {
        ((DecorContentParent)localObject2).setMenuPrepared();
      }
    }
    if ((createdPanelView == null) && ((i == 0) || (!(peekSupportActionBar() instanceof ToolbarActionBar))))
    {
      if ((menu == null) || (refreshMenuContent))
      {
        if (menu == null)
        {
          initializePanelMenu(localPanelFeatureState);
          if (menu == null) {
            return false;
          }
        }
        if ((i != 0) && (mDecorContentParent != null))
        {
          if (mActionMenuPresenterCallback == null) {
            mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
          }
          mDecorContentParent.setMenu(menu, mActionMenuPresenterCallback);
        }
        menu.stopDispatchingItemsChanged();
        if (!((Window.Callback)localObject1).onCreatePanelMenu(featureId, menu))
        {
          localPanelFeatureState.setMenu(null);
          if (i != 0)
          {
            paramPanelFeatureState = mDecorContentParent;
            if (paramPanelFeatureState != null)
            {
              paramPanelFeatureState.setMenu(null, mActionMenuPresenterCallback);
              return false;
            }
          }
        }
        else
        {
          refreshMenuContent = false;
        }
      }
      else
      {
        menu.stopDispatchingItemsChanged();
        localObject2 = frozenActionViewState;
        if (localObject2 != null)
        {
          menu.restoreActionViewStates((Bundle)localObject2);
          frozenActionViewState = null;
        }
        if (!((Window.Callback)localObject1).onPreparePanel(0, createdPanelView, menu))
        {
          if (i != 0)
          {
            paramPanelFeatureState = mDecorContentParent;
            if (paramPanelFeatureState != null) {
              paramPanelFeatureState.setMenu(null, mActionMenuPresenterCallback);
            }
          }
          menu.startDispatchingItemsChanged();
          return false;
        }
        if (paramKeyEvent != null) {
          i = paramKeyEvent.getDeviceId();
        } else {
          i = -1;
        }
        if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
          bool = true;
        } else {
          bool = false;
        }
        qwertyMode = bool;
        menu.setQwertyMode(qwertyMode);
        menu.startDispatchingItemsChanged();
      }
    }
    else
    {
      isPrepared = true;
      isHandled = false;
      mPreparedPanel = paramPanelFeatureState;
      return true;
    }
    return false;
  }
  
  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    paramMenuBuilder = mDecorContentParent;
    if ((paramMenuBuilder != null) && (paramMenuBuilder.canShowOverflowMenu()) && ((!ViewConfiguration.get(mContext).hasPermanentMenuKey()) || (mDecorContentParent.isOverflowMenuShowPending())))
    {
      paramMenuBuilder = getWindowCallback();
      if ((mDecorContentParent.isOverflowMenuShowing()) && (paramBoolean))
      {
        mDecorContentParent.hideOverflowMenu();
        if (!mIsDestroyed) {
          paramMenuBuilder.onPanelClosed(108, getPanelState0menu);
        }
      }
      else if ((paramMenuBuilder != null) && (!mIsDestroyed))
      {
        if ((mInvalidatePanelMenuPosted) && ((mInvalidatePanelMenuFeatures & 0x1) != 0))
        {
          mWindow.getDecorView().removeCallbacks(mInvalidatePanelMenuRunnable);
          mInvalidatePanelMenuRunnable.run();
        }
        PanelFeatureState localPanelFeatureState = getPanelState(0, true);
        MenuBuilder localMenuBuilder = menu;
        if ((localMenuBuilder != null) && (!refreshMenuContent) && (paramMenuBuilder.onPreparePanel(0, createdPanelView, localMenuBuilder)))
        {
          paramMenuBuilder.onMenuOpened(108, menu);
          mDecorContentParent.showOverflowMenu();
        }
      }
    }
    else
    {
      paramMenuBuilder = getPanelState(0, true);
      refreshDecorView = true;
      closePanel(paramMenuBuilder, false);
      openPanel(paramMenuBuilder, null);
    }
  }
  
  private int sanitizeWindowFeatureId(int paramInt)
  {
    if (paramInt == 8) {
      return 108;
    }
    if (paramInt == 9) {
      return 109;
    }
    return paramInt;
  }
  
  private boolean shouldInheritContext(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = mWindow.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View))) {
        break;
      }
      if (ViewCompat.cancel((View)paramViewParent)) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
    return false;
  }
  
  private boolean shouldRecreateOnNightModeChange()
  {
    Object localObject;
    Context localContext1;
    Context localContext2;
    if (mApplyDayNightCalled)
    {
      localObject = mContext;
      if ((localObject instanceof Activity))
      {
        localObject = ((Context)localObject).getPackageManager();
        localContext1 = mContext;
        localContext2 = mContext;
      }
    }
    else
    {
      try
      {
        localObject = ((PackageManager)localObject).getActivityInfo(new ComponentName(localContext1, localContext2.getClass()), 0);
        if ((configChanges & 0x200) != 0) {
          break label70;
        }
        return true;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        return true;
      }
      return false;
    }
    label70:
    return false;
  }
  
  private void throwFeatureRequestIfSubDecorInstalled()
  {
    if (!mSubDecorInstalled) {
      return;
    }
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  private boolean updateForNightMode(int paramInt)
  {
    Resources localResources = mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = uiMode;
    if (paramInt == 2) {
      paramInt = 32;
    } else {
      paramInt = 16;
    }
    if ((i & 0x30) != paramInt)
    {
      if (shouldRecreateOnNightModeChange())
      {
        ((Activity)mContext).recreate();
      }
      else
      {
        localConfiguration = new Configuration(localConfiguration);
        DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
        uiMode = (paramInt | uiMode & 0xFFFFFFCF);
        localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
        if (Build.VERSION.SDK_INT < 26) {
          ResourcesFlusher.flush(localResources);
        }
      }
      return true;
    }
    return false;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)mSubDecor.findViewById(16908290)).addView(paramView, paramLayoutParams);
    mOriginalWindowCallback.onContentChanged();
  }
  
  public boolean applyDayNight()
  {
    int i = getNightMode();
    int j = mapNightMode(i);
    boolean bool;
    if (j != -1) {
      bool = updateForNightMode(j);
    } else {
      bool = false;
    }
    if (i == 0)
    {
      ensureAutoNightModeManager();
      mAutoNightModeManager.setup();
    }
    mApplyDayNightCalled = true;
    return bool;
  }
  
  public void callOnPanelClosed(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localObject1 = mPanels;
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < localObject1.length) {
            localPanelFeatureState = localObject1[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = menu;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!isOpen)) {
      return;
    }
    if (!mIsDestroyed) {
      mOriginalWindowCallback.onPanelClosed(paramInt, (Menu)localObject2);
    }
  }
  
  public void checkCloseActionMenu(MenuBuilder paramMenuBuilder)
  {
    if (mClosingActionMenu) {
      return;
    }
    mClosingActionMenu = true;
    mDecorContentParent.dismissPopups();
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramMenuBuilder);
    }
    mClosingActionMenu = false;
  }
  
  public void closePanel(int paramInt)
  {
    closePanel(getPanelState(paramInt, true), true);
  }
  
  public void closePanel(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (featureId == 0))
    {
      localObject = mDecorContentParent;
      if ((localObject != null) && (((DecorContentParent)localObject).isOverflowMenuShowing()))
      {
        checkCloseActionMenu(menu);
        return;
      }
    }
    Object localObject = (WindowManager)mContext.getSystemService("window");
    if ((localObject != null) && (isOpen))
    {
      ViewGroup localViewGroup = decorView;
      if (localViewGroup != null)
      {
        ((ViewManager)localObject).removeView(localViewGroup);
        if (paramBoolean) {
          callOnPanelClosed(featureId, paramPanelFeatureState, null);
        }
      }
    }
    isPrepared = false;
    isHandled = false;
    isOpen = false;
    shownPanelView = null;
    refreshDecorView = true;
    if (mPreparedPanel == paramPanelFeatureState) {
      mPreparedPanel = null;
    }
  }
  
  public View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject = mAppCompatViewInflater;
    boolean bool = false;
    if (localObject == null)
    {
      localObject = mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
      if ((localObject == null) || (AppCompatViewInflater.class.getName().equals(localObject))) {}
    }
    try
    {
      mAppCompatViewInflater = ((AppCompatViewInflater)Class.forName((String)localObject).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed to instantiate custom view inflater ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(". Falling back to default.");
    localStringBuilder.toString();
    mAppCompatViewInflater = new AppCompatViewInflater();
    break label149;
    mAppCompatViewInflater = new AppCompatViewInflater();
    label149:
    if (IS_PRE_LOLLIPOP)
    {
      if ((paramAttributeSet instanceof XmlPullParser))
      {
        if (((XmlPullParser)paramAttributeSet).getDepth() > 1) {
          bool = true;
        }
      }
      else {
        bool = shouldInheritContext((ViewParent)paramView);
      }
    }
    else {
      bool = false;
    }
    return mAppCompatViewInflater.createView(paramView, paramString, paramContext, paramAttributeSet, bool, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
  }
  
  public void dismissPopups()
  {
    Object localObject = mDecorContentParent;
    if (localObject != null) {
      ((DecorContentParent)localObject).dismissPopups();
    }
    if (mActionModePopup != null)
    {
      mWindow.getDecorView().removeCallbacks(mShowActionModePopup);
      if (mActionModePopup.isShowing()) {
        localObject = mActionModePopup;
      }
    }
    try
    {
      ((PopupWindow)localObject).dismiss();
      mActionModePopup = null;
      endOnGoingFadeAnimation();
      localObject = getPanelState(0, false);
      if (localObject != null)
      {
        localObject = menu;
        if (localObject != null)
        {
          ((MenuBuilder)localObject).close();
          return;
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    Object localObject = mOriginalWindowCallback;
    boolean bool = localObject instanceof c;
    int i = 1;
    if ((bool) || ((localObject instanceof AppCompatDialog)))
    {
      localObject = mWindow.getDecorView();
      if ((localObject != null) && (ViewCompat.a((View)localObject, paramKeyEvent))) {
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (mOriginalWindowCallback.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() != 0) {
      i = 0;
    }
    if (i != 0) {
      return onKeyDown(j, paramKeyEvent);
    }
    return onKeyUp(j, paramKeyEvent);
  }
  
  public void doInvalidatePanelMenu(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    if (menu != null)
    {
      Bundle localBundle = new Bundle();
      menu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        frozenActionViewState = localBundle;
      }
      menu.stopDispatchingItemsChanged();
      menu.clear();
    }
    refreshMenuContent = true;
    refreshDecorView = true;
    if (((paramInt == 108) || (paramInt == 0)) && (mDecorContentParent != null))
    {
      localPanelFeatureState = getPanelState(0, false);
      if (localPanelFeatureState != null)
      {
        isPrepared = false;
        preparePanel(localPanelFeatureState, null);
      }
    }
  }
  
  public void endOnGoingFadeAnimation()
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = mFadeAnim;
    if (localViewPropertyAnimatorCompat != null) {
      localViewPropertyAnimatorCompat.cancel();
    }
  }
  
  public PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = mPanels;
    int j = 0;
    int i;
    if (arrayOfPanelFeatureState != null) {
      i = arrayOfPanelFeatureState.length;
    } else {
      i = 0;
    }
    while (j < i)
    {
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (menu == paramMenu)) {
        return localPanelFeatureState;
      }
      j += 1;
    }
    return null;
  }
  
  public View findViewById(int paramInt)
  {
    ensureSubDecor();
    return mWindow.findViewById(paramInt);
  }
  
  public final Context getActionBarThemedContext()
  {
    Object localObject1 = getSupportActionBar();
    if (localObject1 != null) {
      localObject1 = ((ActionBar)localObject1).getThemedContext();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mContext;
    }
    return localObject2;
  }
  
  public final AutoNightModeManager getAutoNightModeManager()
  {
    ensureAutoNightModeManager();
    return mAutoNightModeManager;
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarDrawableToggleImpl();
  }
  
  public MenuInflater getMenuInflater()
  {
    if (mMenuInflater == null)
    {
      initWindowDecorActionBar();
      Object localObject = mActionBar;
      if (localObject != null) {
        localObject = ((ActionBar)localObject).getThemedContext();
      } else {
        localObject = mContext;
      }
      mMenuInflater = new SupportMenuInflater((Context)localObject);
    }
    return mMenuInflater;
  }
  
  public PanelFeatureState getPanelState(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = mPanels;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      mPanels = ((PanelFeatureState[])localObject1);
    }
    Object localObject3 = localObject1[paramInt];
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
    }
    return localObject2;
  }
  
  public ViewGroup getSubDecor()
  {
    return mSubDecor;
  }
  
  public ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return mActionBar;
  }
  
  public final CharSequence getTitle()
  {
    Window.Callback localCallback = mOriginalWindowCallback;
    if ((localCallback instanceof Activity)) {
      return ((Activity)localCallback).getTitle();
    }
    return mTitle;
  }
  
  public final Window.Callback getWindowCallback()
  {
    return mWindow.getCallback();
  }
  
  public boolean hasWindowFeature(int paramInt)
  {
    int i = sanitizeWindowFeatureId(paramInt);
    boolean bool;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 5)
        {
          if (i != 10)
          {
            if (i != 108)
            {
              if (i != 109) {
                bool = false;
              } else {
                bool = mOverlayActionBar;
              }
            }
            else {
              bool = mHasActionBar;
            }
          }
          else {
            bool = mOverlayActionMode;
          }
        }
        else {
          bool = mFeatureIndeterminateProgress;
        }
      }
      else {
        bool = mFeatureProgress;
      }
    }
    else {
      bool = mWindowNoTitle;
    }
    if (!bool) {
      return mWindow.hasFeature(paramInt);
    }
    return true;
  }
  
  public void installViewFactory()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      LayoutInflaterCompatHC.setFactory(localLayoutInflater, this);
      return;
    }
    localLayoutInflater.getFactory2();
  }
  
  public void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.invalidateOptionsMenu())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return mHandleNativeActionModes;
  }
  
  public int mapNightMode(int paramInt)
  {
    if (paramInt != -100)
    {
      if (paramInt != 0) {
        return paramInt;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)mContext.getSystemService(UiModeManager.class)).getNightMode() == 0)) {
        return -1;
      }
      ensureAutoNightModeManager();
      return mAutoNightModeManager.getApplyableNightMode();
    }
    return -1;
  }
  
  public boolean onBackPressed()
  {
    Object localObject = mActionMode;
    if (localObject != null)
    {
      ((android.support.v7.view.ActionMode)localObject).finish();
      return true;
    }
    localObject = getSupportActionBar();
    return (localObject != null) && (((ActionBar)localObject).collapseActionView());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((mHasActionBar) && (mSubDecorInstalled))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    AppCompatDrawableManager.get().onConfigurationChanged(mContext);
    applyDayNight();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject2 = mOriginalWindowCallback;
    Object localObject1;
    if ((localObject2 instanceof Activity))
    {
      localObject1 = null;
      localObject2 = (Activity)localObject2;
    }
    try
    {
      localObject2 = NavUtils.getParentActivityName((Activity)localObject2);
      localObject1 = localObject2;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    if (localObject1 != null)
    {
      localObject1 = peekSupportActionBar();
      if (localObject1 == null) {
        mEnableDefaultActionBarUp = true;
      } else {
        ((ActionBar)localObject1).setDefaultDisplayHomeAsUpEnabled(true);
      }
    }
    if ((paramBundle != null) && (mLocalNightMode == -100))
    {
      mLocalNightMode = paramBundle.getInt("appcompat:local_night_mode", -100);
      return;
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy()
  {
    if (mInvalidatePanelMenuPosted) {
      mWindow.getDecorView().removeCallbacks(mInvalidatePanelMenuRunnable);
    }
    mIsDestroyed = true;
    Object localObject = mActionBar;
    if (localObject != null) {
      ((ActionBar)localObject).onDestroy();
    }
    localObject = mAutoNightModeManager;
    if (localObject != null) {
      ((AutoNightModeManager)localObject).cleanup();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt != 4)
    {
      if (paramInt != 82) {
        return false;
      }
      onKeyDownPanel(0, paramKeyEvent);
      return true;
    }
    if ((paramKeyEvent.getFlags() & 0x80) == 0) {
      bool = false;
    }
    mLongPressBackDown = bool;
    return false;
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {
      return true;
    }
    localObject = mPreparedPanel;
    if ((localObject != null) && (performPanelShortcut((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)))
    {
      paramKeyEvent = mPreparedPanel;
      if (paramKeyEvent != null)
      {
        isHandled = true;
        return true;
      }
    }
    else
    {
      if (mPreparedPanel == null)
      {
        localObject = getPanelState(0, true);
        preparePanel((PanelFeatureState)localObject, paramKeyEvent);
        boolean bool = performPanelShortcut((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
        isPrepared = false;
        if (!bool) {
          break label117;
        }
        return true;
      }
      return false;
    }
    return true;
    label117:
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if (paramInt != 82) {
        return false;
      }
      onKeyUpPanel(0, paramKeyEvent);
      return true;
    }
    boolean bool = mLongPressBackDown;
    mLongPressBackDown = false;
    paramKeyEvent = getPanelState(0, false);
    if ((paramKeyEvent != null) && (isOpen))
    {
      if (!bool)
      {
        closePanel(paramKeyEvent, true);
        return true;
      }
    }
    else {
      return onBackPressed();
    }
    return true;
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!mIsDestroyed))
    {
      paramMenuBuilder = findMenuPanel(paramMenuBuilder.getRootMenu());
      if (paramMenuBuilder != null) {
        return localCallback.onMenuItemSelected(featureId, paramMenuItem);
      }
    }
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(paramMenuBuilder, true);
  }
  
  public void onMenuOpened(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.dispatchMenuVisibilityChanged(true);
      }
    }
  }
  
  public void onPanelClosed(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).dispatchMenuVisibilityChanged(false);
      }
    }
    else if (paramInt == 0)
    {
      localObject = getPanelState(paramInt, true);
      if (isOpen) {
        closePanel((PanelFeatureState)localObject, false);
      }
    }
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    ensureSubDecor();
  }
  
  public void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    int i = mLocalNightMode;
    if (i != -100) {
      paramBundle.putInt("appcompat:local_night_mode", i);
    }
  }
  
  public void onStart()
  {
    applyDayNight();
  }
  
  public void onStop()
  {
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      ((ActionBar)localObject).setShowHideAnimationEnabled(false);
    }
    localObject = mAutoNightModeManager;
    if (localObject != null) {
      ((AutoNightModeManager)localObject).cleanup();
    }
  }
  
  public void onSubDecorInstalled(ViewGroup paramViewGroup) {}
  
  public final ActionBar peekSupportActionBar()
  {
    return mActionBar;
  }
  
  public boolean requestWindowFeature(int paramInt)
  {
    paramInt = sanitizeWindowFeatureId(paramInt);
    if ((mWindowNoTitle) && (paramInt == 108)) {
      return false;
    }
    if ((mHasActionBar) && (paramInt == 1)) {
      mHasActionBar = false;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 10)
          {
            if (paramInt != 108)
            {
              if (paramInt != 109) {
                return mWindow.requestFeature(paramInt);
              }
              throwFeatureRequestIfSubDecorInstalled();
              mOverlayActionBar = true;
              return true;
            }
            throwFeatureRequestIfSubDecorInstalled();
            mHasActionBar = true;
            return true;
          }
          throwFeatureRequestIfSubDecorInstalled();
          mOverlayActionMode = true;
          return true;
        }
        throwFeatureRequestIfSubDecorInstalled();
        mFeatureIndeterminateProgress = true;
        return true;
      }
      throwFeatureRequestIfSubDecorInstalled();
      mFeatureProgress = true;
      return true;
    }
    throwFeatureRequestIfSubDecorInstalled();
    mWindowNoTitle = true;
    return true;
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(mContext).inflate(paramInt, localViewGroup);
    mOriginalWindowCallback.onContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    mOriginalWindowCallback.onContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    mOriginalWindowCallback.onContentChanged();
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    mHandleNativeActionModes = paramBoolean;
  }
  
  public void setLocalNightMode(int paramInt)
  {
    if ((paramInt != -1) && (paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      return;
    }
    if (mLocalNightMode != paramInt)
    {
      mLocalNightMode = paramInt;
      if (mApplyDayNightCalled) {
        applyDayNight();
      }
    }
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(mOriginalWindowCallback instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if (!(localActionBar instanceof WindowDecorActionBar))
    {
      mMenuInflater = null;
      if (localActionBar != null) {
        localActionBar.onDestroy();
      }
      if (paramToolbar != null)
      {
        paramToolbar = new ToolbarActionBar(paramToolbar, ((Activity)mOriginalWindowCallback).getTitle(), mAppCompatWindowCallback);
        mActionBar = paramToolbar;
        mWindow.setCallback(paramToolbar.getWrappedWindowCallback());
      }
      else
      {
        mActionBar = null;
        mWindow.setCallback(mAppCompatWindowCallback);
      }
      invalidateOptionsMenu();
      return;
    }
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    Object localObject = mDecorContentParent;
    if (localObject != null)
    {
      ((DecorContentParent)localObject).setWindowTitle(paramCharSequence);
      return;
    }
    if (peekSupportActionBar() != null)
    {
      peekSupportActionBar().setWindowTitle(paramCharSequence);
      return;
    }
    localObject = mTitleView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
  }
  
  public final boolean shouldAnimateActionModeView()
  {
    if (mSubDecorInstalled)
    {
      ViewGroup localViewGroup = mSubDecor;
      if ((localViewGroup != null) && (ViewCompat.isLaidOut(localViewGroup))) {
        return true;
      }
    }
    return false;
  }
  
  public android.support.v7.view.ActionMode startSupportActionMode(android.support.v7.view.ActionMode.Callback paramCallback)
  {
    if (paramCallback != null)
    {
      Object localObject = mActionMode;
      if (localObject != null) {
        ((android.support.v7.view.ActionMode)localObject).finish();
      }
      paramCallback = new ActionModeCallbackWrapperV9(paramCallback);
      localObject = getSupportActionBar();
      if (localObject != null)
      {
        mActionMode = ((ActionBar)localObject).startActionMode(paramCallback);
        localObject = mActionMode;
        if (localObject != null)
        {
          AppCompatCallback localAppCompatCallback = mAppCompatCallback;
          if (localAppCompatCallback != null) {
            localAppCompatCallback.onSupportActionModeStarted((android.support.v7.view.ActionMode)localObject);
          }
        }
      }
      if (mActionMode == null) {
        mActionMode = startSupportActionModeFromWindow(paramCallback);
      }
      return mActionMode;
    }
    throw new IllegalArgumentException("ActionMode callback can not be null.");
  }
  
  public android.support.v7.view.ActionMode startSupportActionModeFromWindow(android.support.v7.view.ActionMode.Callback paramCallback)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a15 = a14\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public int updateStatusGuard(int paramInt)
  {
    Object localObject1 = mActionModeView;
    int i1 = 0;
    int i;
    int j;
    if ((localObject1 != null) && ((((View)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)mActionModeView.getLayoutParams();
      boolean bool = mActionModeView.isShown();
      int m = 1;
      int k;
      int n;
      if (bool)
      {
        if (mTempRect1 == null)
        {
          mTempRect1 = new Rect();
          mTempRect2 = new Rect();
        }
        Object localObject2 = mTempRect1;
        Rect localRect = mTempRect2;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        ViewUtils.computeFitSystemWindows(mSubDecor, (Rect)localObject2, localRect);
        if (top == 0) {
          i = paramInt;
        } else {
          i = 0;
        }
        if (topMargin != i)
        {
          topMargin = paramInt;
          localObject2 = mStatusGuard;
          if (localObject2 == null)
          {
            mStatusGuard = new View(mContext);
            mStatusGuard.setBackgroundColor(mContext.getResources().getColor(R.color.abc_input_method_navigation_guard));
            mSubDecor.addView(mStatusGuard, -1, new ViewGroup.LayoutParams(-1, paramInt));
          }
          else
          {
            localObject2 = ((View)localObject2).getLayoutParams();
            if (height != paramInt)
            {
              height = paramInt;
              mStatusGuard.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
          j = 1;
        }
        else
        {
          j = 0;
        }
        if (mStatusGuard == null) {
          m = 0;
        }
        k = m;
        n = j;
        i = paramInt;
        if (!mOverlayActionMode)
        {
          k = m;
          n = j;
          i = paramInt;
          if (m != 0)
          {
            i = 0;
            k = m;
            n = j;
          }
        }
      }
      else
      {
        if (topMargin != 0)
        {
          topMargin = 0;
          j = 1;
        }
        else
        {
          j = 0;
        }
        k = 0;
        i = paramInt;
        n = j;
      }
      j = k;
      paramInt = i;
      if (n != 0)
      {
        mActionModeView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        j = k;
        paramInt = i;
      }
    }
    else
    {
      j = 0;
    }
    localObject1 = mStatusGuard;
    if (localObject1 != null)
    {
      if (j != 0) {
        i = i1;
      } else {
        i = 8;
      }
      ((View)localObject1).setVisibility(i);
    }
    return paramInt;
  }
  
  private class ActionBarDrawableToggleImpl
    implements ActionBarDrawerToggle.Delegate
  {
    public ActionBarDrawableToggleImpl() {}
    
    public Context getActionBarThemedContext()
    {
      return AppCompatDelegateImpl.this.getActionBarThemedContext();
    }
    
    public Drawable getThemeUpIndicator()
    {
      TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[] { R.attr.homeAsUpIndicator });
      Drawable localDrawable = localTintTypedArray.getDrawable(0);
      localTintTypedArray.recycle();
      return localDrawable;
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = getSupportActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int paramInt)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  private final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    public ActionMenuPresenterCallback() {}
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      checkCloseActionMenu(paramMenuBuilder);
    }
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      Window.Callback localCallback = getWindowCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramMenuBuilder);
      }
      return true;
    }
  }
  
  public class ActionModeCallbackWrapperV9
    implements android.support.v7.view.ActionMode.Callback
  {
    public android.support.v7.view.ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapperV9(android.support.v7.view.ActionMode.Callback paramCallback)
    {
      mWrapped = paramCallback;
    }
    
    public boolean onActionItemClicked(android.support.v7.view.ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(android.support.v7.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(android.support.v7.view.ActionMode paramActionMode)
    {
      mWrapped.onDestroyActionMode(paramActionMode);
      paramActionMode = AppCompatDelegateImpl.this;
      if (mActionModePopup != null) {
        mWindow.getDecorView().removeCallbacks(mShowActionModePopup);
      }
      paramActionMode = AppCompatDelegateImpl.this;
      if (mActionModeView != null)
      {
        paramActionMode.endOnGoingFadeAnimation();
        paramActionMode = AppCompatDelegateImpl.this;
        mFadeAnim = ViewCompat.animate(mActionModeView).alpha(0.0F);
        mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter()
        {
          public void onAnimationEnd(View paramAnonymousView)
          {
            mActionModeView.setVisibility(8);
            paramAnonymousView = AppCompatDelegateImpl.this;
            PopupWindow localPopupWindow = mActionModePopup;
            if (localPopupWindow != null) {
              localPopupWindow.dismiss();
            } else if ((mActionModeView.getParent() instanceof View)) {
              ViewCompat.requestApplyInsets((View)mActionModeView.getParent());
            }
            mActionModeView.removeAllViews();
            mFadeAnim.setListener(null);
            mFadeAnim = null;
          }
        });
      }
      paramActionMode = AppCompatDelegateImpl.this;
      AppCompatCallback localAppCompatCallback = mAppCompatCallback;
      if (localAppCompatCallback != null) {
        localAppCompatCallback.onSupportActionModeFinished(mActionMode);
      }
      mActionMode = null;
    }
    
    public boolean onPrepareActionMode(android.support.v7.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
  
  public class AppCompatWindowCallback
    extends WindowCallbackWrapper
  {
    public AppCompatWindowCallback(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (mWrapped.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (mWrapped.dispatchKeyShortcutEvent(paramKeyEvent)) || (onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof MenuBuilder))) {
        return false;
      }
      return mWrapped.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      mWrapped.onMenuOpened(paramInt, paramMenu);
      onMenuOpened(paramInt);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      mWrapped.onPanelClosed(paramInt, paramMenu);
      onPanelClosed(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      MenuBuilder localMenuBuilder;
      if ((paramMenu instanceof MenuBuilder)) {
        localMenuBuilder = (MenuBuilder)paramMenu;
      } else {
        localMenuBuilder = null;
      }
      if ((paramInt == 0) && (localMenuBuilder == null)) {
        return false;
      }
      if (localMenuBuilder != null) {
        localMenuBuilder.setOverrideVisibleItems(true);
      }
      boolean bool = mWrapped.onPreparePanel(paramInt, paramView, paramMenu);
      if (localMenuBuilder != null) {
        localMenuBuilder.setOverrideVisibleItems(false);
      }
      return bool;
    }
    
    public void onProvideKeyboardShortcuts(List paramList, Menu paramMenu, int paramInt)
    {
      Object localObject = getPanelState(0, true);
      if (localObject != null)
      {
        localObject = menu;
        if (localObject != null)
        {
          mWrapped.onProvideKeyboardShortcuts(paramList, (Menu)localObject, paramInt);
          return;
        }
      }
      mWrapped.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      if (isHandleNativeActionModesEnabled()) {
        return startAsSupportActionMode(paramCallback);
      }
      return mWrapped.onWindowStartingActionMode(paramCallback);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback paramCallback, int paramInt)
    {
      if ((isHandleNativeActionModesEnabled()) && (paramInt == 0)) {
        return startAsSupportActionMode(paramCallback);
      }
      return mWrapped.onWindowStartingActionMode(paramCallback, paramInt);
    }
    
    public final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback paramCallback)
    {
      paramCallback = new SupportActionModeWrapper.CallbackWrapper(mContext, paramCallback);
      android.support.v7.view.ActionMode localActionMode = startSupportActionMode(paramCallback);
      if (localActionMode != null) {
        return paramCallback.getActionModeWrapper(localActionMode);
      }
      return null;
    }
  }
  
  @W
  public final class AutoNightModeManager
  {
    public BroadcastReceiver mAutoTimeChangeReceiver;
    public IntentFilter mAutoTimeChangeReceiverFilter;
    public boolean mIsNight;
    public TwilightManager mTwilightManager;
    
    public AutoNightModeManager(TwilightManager paramTwilightManager)
    {
      mTwilightManager = paramTwilightManager;
      mIsNight = paramTwilightManager.isNight();
    }
    
    public void cleanup()
    {
      BroadcastReceiver localBroadcastReceiver = mAutoTimeChangeReceiver;
      if (localBroadcastReceiver != null)
      {
        mContext.unregisterReceiver(localBroadcastReceiver);
        mAutoTimeChangeReceiver = null;
      }
    }
    
    public void dispatchTimeChanged()
    {
      boolean bool = mTwilightManager.isNight();
      if (bool != mIsNight)
      {
        mIsNight = bool;
        applyDayNight();
      }
    }
    
    public int getApplyableNightMode()
    {
      mIsNight = mTwilightManager.isNight();
      if (mIsNight) {
        return 2;
      }
      return 1;
    }
    
    public void setup()
    {
      cleanup();
      if (mAutoTimeChangeReceiver == null) {
        mAutoTimeChangeReceiver = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            dispatchTimeChanged();
          }
        };
      }
      if (mAutoTimeChangeReceiverFilter == null)
      {
        mAutoTimeChangeReceiverFilter = new IntentFilter();
        mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_SET");
        mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_TICK");
      }
      mContext.registerReceiver(mAutoTimeChangeReceiver, mAutoTimeChangeReceiverFilter);
    }
  }
  
  private class ListMenuDecorView
    extends ContentFrameLayout
  {
    public ListMenuDecorView(Context paramContext)
    {
      super();
    }
    
    private boolean isOutOfBounds(int paramInt1, int paramInt2)
    {
      return (paramInt1 < -5) || (paramInt2 < -5) || (paramInt1 > getWidth() + 5) || (paramInt2 > getHeight() + 5);
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (isOutOfBounds((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        closePanel(0);
        return true;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
    }
  }
  
  protected static final class PanelFeatureState
  {
    public int background;
    public View createdPanelView;
    public ViewGroup decorView;
    public int featureId;
    public Bundle frozenActionViewState;
    public Bundle frozenMenuState;
    public int gravity;
    public boolean isHandled;
    public boolean isOpen;
    public boolean isPrepared;
    public ListMenuPresenter listMenuPresenter;
    public Context listPresenterContext;
    public MenuBuilder menu;
    public boolean qwertyMode;
    public boolean refreshDecorView;
    public boolean refreshMenuContent;
    public View shownPanelView;
    public boolean wasLastOpen;
    public int windowAnimations;
    public int x;
    public int y;
    
    public PanelFeatureState(int paramInt)
    {
      featureId = paramInt;
      refreshDecorView = false;
    }
    
    public void applyFrozenState()
    {
      MenuBuilder localMenuBuilder = menu;
      if (localMenuBuilder != null)
      {
        Bundle localBundle = frozenMenuState;
        if (localBundle != null)
        {
          localMenuBuilder.restorePresenterStates(localBundle);
          frozenMenuState = null;
        }
      }
    }
    
    public void clearMenuPresenters()
    {
      MenuBuilder localMenuBuilder = menu;
      if (localMenuBuilder != null) {
        localMenuBuilder.removeMenuPresenter(listMenuPresenter);
      }
      listMenuPresenter = null;
    }
    
    public MenuView getListMenuView(MenuPresenter.Callback paramCallback)
    {
      if (menu == null) {
        return null;
      }
      if (listMenuPresenter == null)
      {
        listMenuPresenter = new ListMenuPresenter(listPresenterContext, R.layout.abc_list_menu_item_layout);
        listMenuPresenter.setCallback(paramCallback);
        menu.addMenuPresenter(listMenuPresenter);
      }
      return listMenuPresenter.getMenuView(decorView);
    }
    
    public boolean hasPanelItems()
    {
      if (shownPanelView == null) {
        return false;
      }
      if (createdPanelView != null) {
        return true;
      }
      return listMenuPresenter.getAdapter().getCount() > 0;
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable)
    {
      paramParcelable = (SavedState)paramParcelable;
      featureId = featureId;
      wasLastOpen = isOpen;
      frozenMenuState = menuState;
      shownPanelView = null;
      decorView = null;
    }
    
    public Parcelable onSaveInstanceState()
    {
      SavedState localSavedState = new SavedState();
      featureId = featureId;
      isOpen = isOpen;
      if (menu != null)
      {
        menuState = new Bundle();
        menu.savePresenterStates(menuState);
      }
      return localSavedState;
    }
    
    public void setMenu(MenuBuilder paramMenuBuilder)
    {
      Object localObject = menu;
      if (paramMenuBuilder == localObject) {
        return;
      }
      if (localObject != null) {
        ((MenuBuilder)localObject).removeMenuPresenter(listMenuPresenter);
      }
      menu = paramMenuBuilder;
      if (paramMenuBuilder != null)
      {
        localObject = listMenuPresenter;
        if (localObject != null) {
          paramMenuBuilder.addMenuPresenter((MenuPresenter)localObject);
        }
      }
    }
    
    public void setStyle(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      int i = resourceId;
      if (i != 0) {
        localTheme.applyStyle(i, true);
      }
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      i = resourceId;
      if (i != 0) {
        localTheme.applyStyle(i, true);
      } else {
        localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      }
      paramContext = new ContextThemeWrapper(paramContext, 0);
      paramContext.getTheme().setTo(localTheme);
      listPresenterContext = paramContext;
      paramContext = paramContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
      background = paramContext.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
      windowAnimations = paramContext.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
      paramContext.recycle();
    }
    
    private static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
      {
        public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel paramAnonymousParcel)
        {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel(paramAnonymousParcel, null);
        }
        
        public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
        {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel(paramAnonymousParcel, paramAnonymousClassLoader);
        }
        
        public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int paramAnonymousInt)
        {
          return new AppCompatDelegateImpl.PanelFeatureState.SavedState[paramAnonymousInt];
        }
      };
      public int featureId;
      public boolean isOpen;
      public Bundle menuState;
      
      public SavedState() {}
      
      public static SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        SavedState localSavedState = new SavedState();
        featureId = paramParcel.readInt();
        int i = paramParcel.readInt();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        isOpen = bool;
        if (isOpen) {
          menuState = paramParcel.readBundle(paramClassLoader);
        }
        return localSavedState;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
      }
    }
  }
  
  private final class PanelMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    public PanelMenuPresenterCallback() {}
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
      int i;
      if (localMenuBuilder != paramMenuBuilder) {
        i = 1;
      } else {
        i = 0;
      }
      AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if (i != 0) {
        paramMenuBuilder = localMenuBuilder;
      }
      paramMenuBuilder = localAppCompatDelegateImpl.findMenuPanel(paramMenuBuilder);
      if (paramMenuBuilder != null)
      {
        if (i != 0)
        {
          callOnPanelClosed(featureId, paramMenuBuilder, localMenuBuilder);
          closePanel(paramMenuBuilder, true);
          return;
        }
        closePanel(paramMenuBuilder, paramBoolean);
      }
    }
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder == null)
      {
        Object localObject = AppCompatDelegateImpl.this;
        if (mHasActionBar)
        {
          localObject = ((AppCompatDelegateImpl)localObject).getWindowCallback();
          if ((localObject != null) && (!mIsDestroyed)) {
            ((Window.Callback)localObject).onMenuOpened(108, paramMenuBuilder);
          }
        }
      }
      return true;
    }
  }
}
