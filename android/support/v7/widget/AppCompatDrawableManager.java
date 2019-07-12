package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.drawable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.graphics.drawable.AnimatedStateListDrawableCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import b.b.a.K;
import b.b.a.N;
import b.b.x.n.b;
import b.b.x.n.l;
import b.b.x.n.m;
import b.b.x.n.u;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.graphics.drawable.AnimatedVectorDrawableCompat;
import support.android.graphics.drawable.VectorDrawableCompat;
import support.android.v4.content.ContextCompat;
import support.android.v4.internal.ColorUtils;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.LongSparseArray;
import support.android.v4.util.LruCache;
import support.android.v4.util.SimpleArrayMap;
import support.android.v4.util.SparseArrayCompat;

@N({b.b.a.N.a.b})
public final class AppCompatDrawableManager
{
  public static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
  public static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
  public static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
  public static final ColorFilterLruCache COLOR_FILTER_CACHE;
  public static final boolean DEBUG = false;
  public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  public static AppCompatDrawableManager INSTANCE;
  public static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
  public static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
  public static final String TAG = "AppCompatDrawableManag";
  public static final int[] TINT_CHECKABLE_BUTTON_LIST = { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material };
  public static final int[] TINT_COLOR_CONTROL_NORMAL;
  public static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  public b<String, InflateDelegate> mDelegates;
  public final WeakHashMap<Context, l<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
  public boolean mHasCheckedVectorDrawableSetup;
  public u<String> mKnownDrawableIdTags;
  public WeakHashMap<Context, u<ColorStateList>> mTintLists;
  public TypedValue mTypedValue;
  
  static
  {
    COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[] { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
    TINT_COLOR_CONTROL_NORMAL = new int[] { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
    COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[] { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light };
    COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[] { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
    TINT_COLOR_CONTROL_STATE_LIST = new int[] { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
  }
  
  public AppCompatDrawableManager() {}
  
  private void addDelegate(String paramString, InflateDelegate paramInflateDelegate)
  {
    if (mDelegates == null) {
      mDelegates = new ArrayMap();
    }
    mDelegates.put(paramString, paramInflateDelegate);
  }
  
  private boolean addDrawableToCache(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    try
    {
      Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
      if (localConstantState != null)
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)mDrawableCaches.get(paramContext);
        paramDrawable = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          paramDrawable = new LongSparseArray(10);
          mDrawableCaches.put(paramContext, paramDrawable);
        }
        paramDrawable.put(paramLong, new WeakReference(localConstantState));
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private void addTintListToCache(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    if (mTintLists == null) {
      mTintLists = new WeakHashMap();
    }
    SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)mTintLists.get(paramContext);
    SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
    if (localSparseArrayCompat2 == null)
    {
      localSparseArrayCompat1 = new SparseArrayCompat(10);
      mTintLists.put(paramContext, localSparseArrayCompat1);
    }
    localSparseArrayCompat1.append(paramInt, paramColorStateList);
  }
  
  public static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void checkVectorDrawableSetup(Context paramContext)
  {
    if (mHasCheckedVectorDrawableSetup) {
      return;
    }
    mHasCheckedVectorDrawableSetup = true;
    paramContext = getDrawable(paramContext, R.drawable.abc_vector_test);
    if ((paramContext != null) && (isVectorDrawable(paramContext))) {
      return;
    }
    mHasCheckedVectorDrawableSetup = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  private ColorStateList createBorderlessButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, 0);
  }
  
  private ColorStateList createButtonColorStateList(Context paramContext, int paramInt)
  {
    int k = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    int i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    paramContext = ThemeUtils.DISABLED_STATE_SET;
    int[] arrayOfInt1 = ThemeUtils.PRESSED_STATE_SET;
    int j = ColorUtils.compositeColors(k, paramInt);
    int[] arrayOfInt2 = ThemeUtils.FOCUSED_STATE_SET;
    k = ColorUtils.compositeColors(k, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, ThemeUtils.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  public static long createCacheKey(TypedValue paramTypedValue)
  {
    return assetCookie << 32 | data;
  }
  
  private ColorStateList createColoredButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorAccent));
  }
  
  private ColorStateList createDefaultButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorButtonNormal));
  }
  
  private Drawable createDrawableIfNeeded(Context paramContext, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a8 = a7\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private ColorStateList createSwitchThumbColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorSwitchThumbNormal);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    else
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
    }
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  public static PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
    }
    return null;
  }
  
  public static AppCompatDrawableManager get()
  {
    try
    {
      if (INSTANCE == null)
      {
        INSTANCE = new AppCompatDrawableManager();
        installDefaultInflateDelegates(INSTANCE);
      }
      AppCompatDrawableManager localAppCompatDrawableManager = INSTANCE;
      return localAppCompatDrawableManager;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private Drawable getCachedDrawable(Context paramContext, long paramLong)
  {
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)mDrawableCaches.get(paramContext);
      if (localLongSparseArray == null) {
        return null;
      }
      Object localObject = (WeakReference)localLongSparseArray.get(paramLong);
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        if (localObject != null)
        {
          paramContext = ((Drawable.ConstantState)localObject).newDrawable(paramContext.getResources());
          return paramContext;
        }
        localLongSparseArray.delete(paramLong);
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      PorterDuffColorFilter localPorterDuffColorFilter2 = COLOR_FILTER_CACHE.get(paramInt, paramMode);
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
        COLOR_FILTER_CACHE.get(paramInt, paramMode, localPorterDuffColorFilter1);
      }
      return localPorterDuffColorFilter1;
    }
    catch (Throwable paramMode)
    {
      throw paramMode;
    }
  }
  
  private ColorStateList getTintListFromCache(Context paramContext, int paramInt)
  {
    WeakHashMap localWeakHashMap = mTintLists;
    if (localWeakHashMap != null)
    {
      paramContext = (SparseArrayCompat)localWeakHashMap.get(paramContext);
      if (paramContext != null) {
        return (ColorStateList)paramContext.get(paramInt);
      }
    }
    return null;
  }
  
  public static PorterDuff.Mode getTintMode(int paramInt)
  {
    if (paramInt == R.drawable.abc_switch_thumb_material) {
      return PorterDuff.Mode.MULTIPLY;
    }
    return null;
  }
  
  public static void installDefaultInflateDelegates(AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      paramAppCompatDrawableManager.addDelegate("vector", new VdcInflateDelegate());
      paramAppCompatDrawableManager.addDelegate("animated-vector", new AvdcInflateDelegate());
      paramAppCompatDrawableManager.addDelegate("animated-selector", new AsldcInflateDelegate());
    }
  }
  
  public static boolean isVectorDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof VectorDrawableCompat)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private Drawable loadDrawableFromDelegates(Context paramContext, int paramInt)
  {
    Object localObject1 = mDelegates;
    TypedValue localTypedValue;
    Object localObject4;
    long l;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      if (((SimpleArrayMap)localObject1).isEmpty()) {
        break label414;
      }
      localObject1 = mKnownDrawableIdTags;
      if (localObject1 != null)
      {
        localObject1 = (String)((SparseArrayCompat)localObject1).get(paramInt);
        if ("appcompat_skip_skip".equals(localObject1)) {
          break label414;
        }
        if ((localObject1 != null) && (mDelegates.get(localObject1) == null)) {
          return null;
        }
      }
      else
      {
        mKnownDrawableIdTags = new SparseArrayCompat(10);
      }
      if (mTypedValue == null) {
        mTypedValue = new TypedValue();
      }
      localTypedValue = mTypedValue;
      localObject4 = paramContext.getResources();
      ((Resources)localObject4).getValue(paramInt, localTypedValue, true);
      l = createCacheKey(localTypedValue);
      localObject2 = getCachedDrawable(paramContext, l);
      localObject1 = localObject2;
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = string;
      localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (((CharSequence)localObject2).toString().endsWith(".xml")) {
          localObject3 = localObject1;
        }
      }
    }
    try
    {
      localObject4 = ((Resources)localObject4).getXml(paramInt);
      localObject3 = localObject1;
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject4);
      int i;
      do
      {
        localObject3 = localObject1;
        i = ((XmlPullParser)localObject4).next();
      } while ((i != 2) && (i != 1));
      if (i == 2)
      {
        localObject3 = localObject1;
        localObject2 = ((XmlPullParser)localObject4).getName();
        Object localObject5 = mKnownDrawableIdTags;
        localObject3 = localObject1;
        ((SparseArrayCompat)localObject5).append(paramInt, localObject2);
        localObject5 = mDelegates;
        localObject3 = localObject1;
        localObject2 = ((SimpleArrayMap)localObject5).get(localObject2);
        localObject5 = (InflateDelegate)localObject2;
        localObject2 = localObject1;
        if (localObject5 != null)
        {
          localObject3 = localObject1;
          localObject2 = ((InflateDelegate)localObject5).createFromXmlInner(paramContext, (XmlPullParser)localObject4, localAttributeSet, paramContext.getTheme());
        }
        localObject3 = localObject2;
        if (localObject2 != null)
        {
          i = changingConfigurations;
          localObject3 = localObject2;
          ((Drawable)localObject2).setChangingConfigurations(i);
          localObject3 = localObject2;
          addDrawableToCache(paramContext, l, (Drawable)localObject2);
          localObject3 = localObject2;
        }
      }
      else
      {
        localObject3 = localObject1;
        paramContext = new XmlPullParserException("No start tag found");
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    if (localObject3 == null)
    {
      mKnownDrawableIdTags.append(paramInt, "appcompat_skip_skip");
      return localObject3;
      return null;
      label414:
      return null;
    }
    return localObject3;
  }
  
  private void removeDelegate(String paramString, InflateDelegate paramInflateDelegate)
  {
    ArrayMap localArrayMap = mDelegates;
    if ((localArrayMap != null) && (localArrayMap.get(paramString) == paramInflateDelegate)) {
      mDelegates.remove(paramString);
    }
  }
  
  public static void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = DEFAULT_MODE;
    }
    localDrawable.setColorFilter(getPorterDuffColorFilter(paramInt, paramDrawable));
  }
  
  private Drawable tintDrawable(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = getTintList(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = DrawableCompat.wrap(paramContext);
      DrawableCompat.setTintList(paramContext, (ColorStateList)localObject);
      paramDrawable = getTintMode(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        DrawableCompat.setTintMode(paramContext, paramDrawable);
        return paramContext;
      }
    }
    else
    {
      if (paramInt == R.drawable.abc_seekbar_track_material)
      {
        localObject = (LayerDrawable)paramDrawable;
        setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
        setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
        setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
        return paramDrawable;
      }
      if ((paramInt != R.drawable.abc_ratingbar_material) && (paramInt != R.drawable.abc_ratingbar_indicator_material) && (paramInt != R.drawable.abc_ratingbar_small_material))
      {
        localObject = paramDrawable;
        if (!tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable))
        {
          localObject = paramDrawable;
          if (paramBoolean) {
            return null;
          }
        }
      }
      else
      {
        localObject = (LayerDrawable)paramDrawable;
        setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
        setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
        setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
        localObject = paramDrawable;
      }
    }
    return localObject;
  }
  
  public static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    if ((DrawableUtils.canSafelyMutateDrawable(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {
      return;
    }
    if ((!mHasTintList) && (!mHasTintMode))
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      ColorStateList localColorStateList;
      if (mHasTintList) {
        localColorStateList = mTintList;
      } else {
        localColorStateList = null;
      }
      if (mHasTintMode) {
        paramTintInfo = mTintMode;
      } else {
        paramTintInfo = DEFAULT_MODE;
      }
      paramDrawable.setColorFilter(createTintFilter(localColorStateList, paramTintInfo, paramArrayOfInt));
    }
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
    }
  }
  
  public static boolean tintDrawableUsingColorFilter(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = DEFAULT_MODE;
    boolean bool = arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt);
    int i = 16842801;
    if (bool) {
      paramInt = R.attr.colorControlNormal;
    }
    for (;;)
    {
      i = 1;
      j = -1;
      break label115;
      if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
      {
        paramInt = R.attr.colorControlActivated;
      }
      else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
      {
        localMode = PorterDuff.Mode.MULTIPLY;
        paramInt = i;
      }
      else
      {
        if (paramInt == R.drawable.abc_list_divider_mtrl_alpha)
        {
          paramInt = 16842800;
          j = Math.round(40.8F);
          i = 1;
          break label115;
        }
        if (paramInt != R.drawable.abc_dialog_material_background) {
          break;
        }
        paramInt = i;
      }
    }
    i = 0;
    int j = -1;
    paramInt = 0;
    label115:
    if (i != 0)
    {
      Drawable localDrawable = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        localDrawable = paramDrawable.mutate();
      }
      localDrawable.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(paramContext, paramInt), localMode));
      if (j != -1)
      {
        localDrawable.setAlpha(j);
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public Drawable getDrawable(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = getDrawable(paramContext, paramInt, false);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public Drawable getDrawable(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      checkVectorDrawableSetup(paramContext);
      Object localObject2 = loadDrawableFromDelegates(paramContext, paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = createDrawableIfNeeded(paramContext, paramInt);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ContextCompat.getDrawable(paramContext, paramInt);
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = tintDrawable(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
      }
      if (localObject1 != null) {
        DrawableUtils.fixDrawable((Drawable)localObject1);
      }
      return localObject1;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public ColorStateList getTintList(Context paramContext, int paramInt)
  {
    try
    {
      ColorStateList localColorStateList3 = getTintListFromCache(paramContext, paramInt);
      ColorStateList localColorStateList1 = localColorStateList3;
      ColorStateList localColorStateList2 = localColorStateList1;
      if (localColorStateList3 == null)
      {
        if (paramInt == R.drawable.abc_edit_text_material) {
          localColorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_edittext);
        } else if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
          localColorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_switch_track);
        } else if (paramInt == R.drawable.abc_switch_thumb_material) {
          localColorStateList1 = createSwitchThumbColorStateList(paramContext);
        } else if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
          localColorStateList1 = createDefaultButtonColorStateList(paramContext);
        } else if (paramInt == R.drawable.abc_btn_borderless_material) {
          localColorStateList1 = createButtonColorStateList(paramContext, 0);
        } else if (paramInt == R.drawable.abc_btn_colored_material) {
          localColorStateList1 = createColoredButtonColorStateList(paramContext);
        } else if ((paramInt != R.drawable.abc_spinner_mtrl_am_alpha) && (paramInt != R.drawable.abc_spinner_textfield_background_material))
        {
          if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt)) {
            localColorStateList1 = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorControlNormal);
          } else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
            localColorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_default);
          } else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt)) {
            localColorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_btn_checkable);
          } else if (paramInt == R.drawable.abc_seekbar_thumb_material) {
            localColorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_seek_thumb);
          }
        }
        else {
          localColorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_spinner);
        }
        localColorStateList2 = localColorStateList1;
        if (localColorStateList1 != null)
        {
          addTintListToCache(paramContext, paramInt, localColorStateList1);
          localColorStateList2 = localColorStateList1;
        }
      }
      return localColorStateList2;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public void onConfigurationChanged(Context paramContext)
  {
    try
    {
      paramContext = (LongSparseArray)mDrawableCaches.get(paramContext);
      if (paramContext != null) {
        paramContext.clear();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public Drawable onDrawableLoadedFromResources(Context paramContext, VectorEnabledTintResources paramVectorEnabledTintResources, int paramInt)
  {
    try
    {
      Drawable localDrawable2 = loadDrawableFromDelegates(paramContext, paramInt);
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = paramVectorEnabledTintResources.superGetDrawable(paramInt);
      }
      if (localDrawable1 != null)
      {
        paramContext = tintDrawable(paramContext, paramInt, false, localDrawable1);
        return paramContext;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  @K(11)
  public static class AsldcInflateDelegate
    implements AppCompatDrawableManager.InflateDelegate
  {
    public AsldcInflateDelegate() {}
    
    public Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = AnimatedStateListDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
      return null;
    }
  }
  
  private static class AvdcInflateDelegate
    implements AppCompatDrawableManager.InflateDelegate
  {
    public AvdcInflateDelegate() {}
    
    public Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = AnimatedVectorDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
      return null;
    }
  }
  
  private static class ColorFilterLruCache
    extends m<Integer, PorterDuffColorFilter>
  {
    public ColorFilterLruCache(int paramInt)
    {
      super();
    }
    
    public static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
    {
      return paramMode.hashCode() + (paramInt + 31) * 31;
    }
    
    public PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)get(Integer.valueOf(paramMode.hashCode() + (paramInt + 31) * 31));
    }
    
    public PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)put(Integer.valueOf(paramMode.hashCode() + (paramInt + 31) * 31), paramPorterDuffColorFilter);
    }
  }
  
  private static abstract interface InflateDelegate
  {
    public abstract Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  private static class VdcInflateDelegate
    implements AppCompatDrawableManager.InflateDelegate
  {
    public VdcInflateDelegate() {}
    
    public Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = VectorDrawableCompat.createFromXmlInner(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
      return null;
    }
  }
}
