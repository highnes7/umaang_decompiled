package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.attr;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsSpinner;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import support.android.v4.view.TintableBackgroundView;
import support.android.v4.view.ViewCompat;

public class AppCompatSpinner
  extends Spinner
  implements TintableBackgroundView
{
  public static final int[] ATTRS_ANDROID_SPINNERMODE = { 16843505 };
  public static final int MAX_ITEMS_MEASURED = 15;
  public static final int MODE_DIALOG = 0;
  public static final int MODE_DROPDOWN = 1;
  public static final int MODE_THEME = -1;
  public static final String TAG = "AppCompatSpinner";
  public final AppCompatBackgroundHelper mBackgroundTintHelper;
  public int mDropDownWidth;
  public ForwardingListener mForwardingListener;
  public DropdownPopup mPopup;
  public final Context mPopupContext;
  public final boolean mPopupSet;
  public SpinnerAdapter mTempAdapter;
  public final Rect mTempRect;
  
  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 80	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 82	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 84	android/graphics/Rect:<init>	()V
    //   15: putfield 86	android/support/v7/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 91	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 97	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   28: astore 10
    //   30: aload_0
    //   31: new 99	android/support/v7/widget/AppCompatBackgroundHelper
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 102	android/support/v7/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   39: putfield 104	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   42: aload 5
    //   44: ifnull +20 -> 64
    //   47: aload_0
    //   48: new 106	android/support/v7/view/ContextThemeWrapper
    //   51: dup
    //   52: aload_1
    //   53: aload 5
    //   55: invokespecial 109	android/support/v7/view/ContextThemeWrapper:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield 111	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   61: goto +59 -> 120
    //   64: aload 10
    //   66: getstatic 114	android/support/v7/appcompat/R$styleable:Spinner_popupTheme	I
    //   69: iconst_0
    //   70: invokevirtual 118	android/support/v7/widget/TintTypedArray:getResourceId	(II)I
    //   73: istore 6
    //   75: iload 6
    //   77: ifeq +20 -> 97
    //   80: aload_0
    //   81: new 106	android/support/v7/view/ContextThemeWrapper
    //   84: dup
    //   85: aload_1
    //   86: iload 6
    //   88: invokespecial 120	android/support/v7/view/ContextThemeWrapper:<init>	(Landroid/content/Context;I)V
    //   91: putfield 111	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   94: goto +26 -> 120
    //   97: getstatic 125	android/os/Build$VERSION:SDK_INT	I
    //   100: bipush 23
    //   102: if_icmpge +9 -> 111
    //   105: aload_1
    //   106: astore 5
    //   108: goto +6 -> 114
    //   111: aconst_null
    //   112: astore 5
    //   114: aload_0
    //   115: aload 5
    //   117: putfield 111	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   120: aload_0
    //   121: getfield 111	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   124: ifnull +221 -> 345
    //   127: iload 4
    //   129: istore 6
    //   131: iload 4
    //   133: iconst_m1
    //   134: if_icmpne +108 -> 242
    //   137: getstatic 55	android/support/v7/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   140: astore 5
    //   142: aload_1
    //   143: aload_2
    //   144: aload 5
    //   146: iload_3
    //   147: iconst_0
    //   148: invokevirtual 130	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   151: astore 9
    //   153: aload 9
    //   155: astore 5
    //   157: aload 9
    //   159: iconst_0
    //   160: invokevirtual 136	android/content/res/TypedArray:hasValue	(I)Z
    //   163: istore 7
    //   165: aload 5
    //   167: astore 8
    //   169: iload 4
    //   171: istore 6
    //   173: iload 7
    //   175: ifeq +16 -> 191
    //   178: aload 9
    //   180: iconst_0
    //   181: iconst_0
    //   182: invokevirtual 139	android/content/res/TypedArray:getInt	(II)I
    //   185: istore 6
    //   187: aload 5
    //   189: astore 8
    //   191: aload 8
    //   193: invokevirtual 142	android/content/res/TypedArray:recycle	()V
    //   196: goto +46 -> 242
    //   199: astore_1
    //   200: goto +7 -> 207
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 5
    //   207: aload 5
    //   209: ifnull +8 -> 217
    //   212: aload 5
    //   214: invokevirtual 142	android/content/res/TypedArray:recycle	()V
    //   217: aload_1
    //   218: athrow
    //   219: aconst_null
    //   220: astore 5
    //   222: iload 4
    //   224: istore 6
    //   226: aload 5
    //   228: ifnull +14 -> 242
    //   231: aload 5
    //   233: astore 8
    //   235: iload 4
    //   237: istore 6
    //   239: goto -48 -> 191
    //   242: iload 6
    //   244: iconst_1
    //   245: if_icmpne +100 -> 345
    //   248: new 13	android/support/v7/widget/AppCompatSpinner$DropdownPopup
    //   251: dup
    //   252: aload_0
    //   253: aload_0
    //   254: getfield 111	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   257: aload_2
    //   258: iload_3
    //   259: invokespecial 145	android/support/v7/widget/AppCompatSpinner$DropdownPopup:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   262: astore 5
    //   264: aload_0
    //   265: getfield 111	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   268: aload_2
    //   269: getstatic 91	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   272: iload_3
    //   273: iconst_0
    //   274: invokestatic 97	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   277: astore 8
    //   279: aload_0
    //   280: aload 8
    //   282: getstatic 148	android/support/v7/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   285: bipush -2
    //   287: invokevirtual 151	android/support/v7/widget/TintTypedArray:getLayoutDimension	(II)I
    //   290: putfield 153	android/support/v7/widget/AppCompatSpinner:mDropDownWidth	I
    //   293: aload 5
    //   295: aload 8
    //   297: getstatic 156	android/support/v7/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   300: invokevirtual 160	android/support/v7/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   303: invokevirtual 166	android/support/v7/widget/ListPopupWindow:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   306: aload 5
    //   308: aload 10
    //   310: getstatic 169	android/support/v7/appcompat/R$styleable:Spinner_android_prompt	I
    //   313: invokevirtual 173	android/support/v7/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   316: invokevirtual 177	android/support/v7/widget/AppCompatSpinner$DropdownPopup:setPromptText	(Ljava/lang/CharSequence;)V
    //   319: aload 8
    //   321: invokevirtual 178	android/support/v7/widget/TintTypedArray:recycle	()V
    //   324: aload_0
    //   325: aload 5
    //   327: putfield 180	android/support/v7/widget/AppCompatSpinner:mPopup	Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
    //   330: aload_0
    //   331: new 8	android/support/v7/widget/AppCompatSpinner$1
    //   334: dup
    //   335: aload_0
    //   336: aload_0
    //   337: aload 5
    //   339: invokespecial 183	android/support/v7/widget/AppCompatSpinner$1:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;)V
    //   342: putfield 185	android/support/v7/widget/AppCompatSpinner:mForwardingListener	Landroid/support/v7/widget/ForwardingListener;
    //   345: aload 10
    //   347: getstatic 188	android/support/v7/appcompat/R$styleable:Spinner_android_entries	I
    //   350: invokevirtual 192	android/support/v7/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   353: astore 5
    //   355: aload 5
    //   357: ifnull +28 -> 385
    //   360: new 194	android/widget/ArrayAdapter
    //   363: dup
    //   364: aload_1
    //   365: ldc -61
    //   367: aload 5
    //   369: invokespecial 198	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   372: astore_1
    //   373: aload_1
    //   374: getstatic 203	android/support/v7/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   377: invokevirtual 207	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   380: aload_0
    //   381: aload_1
    //   382: invokevirtual 211	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   385: aload 10
    //   387: invokevirtual 178	android/support/v7/widget/TintTypedArray:recycle	()V
    //   390: aload_0
    //   391: iconst_1
    //   392: putfield 213	android/support/v7/widget/AppCompatSpinner:mPopupSet	Z
    //   395: aload_0
    //   396: getfield 215	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   399: astore_1
    //   400: aload_1
    //   401: ifnull +13 -> 414
    //   404: aload_0
    //   405: aload_1
    //   406: invokevirtual 211	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   409: aload_0
    //   410: aconst_null
    //   411: putfield 215	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   414: aload_0
    //   415: getfield 104	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   418: aload_2
    //   419: iload_3
    //   420: invokevirtual 219	android/support/v7/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   423: return
    //   424: astore 5
    //   426: goto -207 -> 219
    //   429: astore 8
    //   431: goto -209 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	AppCompatSpinner
    //   0	434	1	paramContext	Context
    //   0	434	2	paramAttributeSet	AttributeSet
    //   0	434	3	paramInt1	int
    //   0	434	4	paramInt2	int
    //   0	434	5	paramTheme	Resources.Theme
    //   73	173	6	i	int
    //   163	11	7	bool	boolean
    //   167	153	8	localObject	Object
    //   429	1	8	localException	Exception
    //   151	28	9	localTypedArray	android.content.res.TypedArray
    //   28	358	10	localTintTypedArray	TintTypedArray
    // Exception table:
    //   from	to	target	type
    //   157	165	199	java/lang/Throwable
    //   178	187	199	java/lang/Throwable
    //   142	153	203	java/lang/Throwable
    //   142	153	424	java/lang/Exception
    //   157	165	429	java/lang/Exception
    //   178	187	429	java/lang/Exception
  }
  
  public int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int k = 0;
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i3 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    i = Math.max(0, i - (15 - (i3 - i)));
    Object localObject = null;
    int j = 0;
    while (i < i3)
    {
      int n = paramSpinnerAdapter.getItemViewType(i);
      int m = k;
      if (n != k)
      {
        localObject = null;
        m = n;
      }
      View localView = paramSpinnerAdapter.getView(i, (View)localObject, this);
      localObject = localView;
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i1, i2);
      j = Math.max(j, localView.getMeasuredWidth());
      i += 1;
      k = m;
    }
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(mTempRect);
      paramSpinnerAdapter = mTempRect;
      return j + (left + right);
    }
    return j;
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.applySupportBackgroundTint();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null) {
      return localDropdownPopup.getHorizontalOffset();
    }
    int i = Build.VERSION.SDK_INT;
    return super.getDropDownHorizontalOffset();
  }
  
  public int getDropDownVerticalOffset()
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null) {
      return localDropdownPopup.getVerticalOffset();
    }
    int i = Build.VERSION.SDK_INT;
    return super.getDropDownVerticalOffset();
  }
  
  public int getDropDownWidth()
  {
    if (mPopup != null) {
      return mDropDownWidth;
    }
    int i = Build.VERSION.SDK_INT;
    return super.getDropDownWidth();
  }
  
  public Drawable getPopupBackground()
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null) {
      return localDropdownPopup.getBackground();
    }
    int i = Build.VERSION.SDK_INT;
    return super.getPopupBackground();
  }
  
  public Context getPopupContext()
  {
    if (mPopup != null) {
      return mPopupContext;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null) {
      return localDropdownPopup.getHintText();
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DropdownPopup localDropdownPopup = mPopup;
    if ((localDropdownPopup != null) && (localDropdownPopup.isShowing())) {
      mPopup.dismiss();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ForwardingListener localForwardingListener = mForwardingListener;
    if ((localForwardingListener != null) && (localForwardingListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null)
    {
      if (!localDropdownPopup.isShowing()) {
        mPopup.show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!mPopupSet)
    {
      mTempAdapter = paramSpinnerAdapter;
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (mPopup != null)
    {
      Context localContext2 = mPopupContext;
      Context localContext1 = localContext2;
      if (localContext2 == null) {
        localContext1 = getContext();
      }
      mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter, localContext1.getTheme()));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null)
    {
      localDropdownPopup.setHorizontalOffset(paramInt);
      return;
    }
    int i = Build.VERSION.SDK_INT;
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null)
    {
      localDropdownPopup.setVerticalOffset(paramInt);
      return;
    }
    int i = Build.VERSION.SDK_INT;
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (mPopup != null)
    {
      mDropDownWidth = paramInt;
      return;
    }
    int i = Build.VERSION.SDK_INT;
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null)
    {
      localDropdownPopup.setBackgroundDrawable(paramDrawable);
      return;
    }
    int i = Build.VERSION.SDK_INT;
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    DropdownPopup localDropdownPopup = mPopup;
    if (localDropdownPopup != null)
    {
      localDropdownPopup.setPromptText(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  private static class DropDownAdapter
    implements ListAdapter, SpinnerAdapter
  {
    public SpinnerAdapter mAdapter;
    public ListAdapter mListAdapter;
    
    public DropDownAdapter(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      mAdapter = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        mListAdapter = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null) {
        if ((Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)))
        {
          paramSpinnerAdapter = (android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
        else if ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter))
        {
          paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() == null) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter == null) {
        return 0;
      }
      return localSpinnerAdapter.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter == null) {
        return -1L;
      }
      return localSpinnerAdapter.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      return (localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds());
    }
    
    public boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  private class DropdownPopup
    extends ListPopupWindow
  {
    public ListAdapter mAdapter;
    public CharSequence mHintText;
    public final Rect mVisibleRect = new Rect();
    
    public DropdownPopup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt, 0);
      setAnchorView(AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          setSelection(paramAnonymousInt);
          if (getOnItemClickListener() != null)
          {
            paramAnonymousAdapterView = AppCompatSpinner.DropdownPopup.this;
            this$0.performItemClick(paramAnonymousView, paramAnonymousInt, mAdapter.getItemId(paramAnonymousInt));
          }
          dismiss();
        }
      });
    }
    
    public void computeContentWidth()
    {
      Object localObject = getBackground();
      int i = 0;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(mTempRect);
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
          i = mTempRect.right;
        } else {
          i = -mTempRect.left;
        }
      }
      else
      {
        localObject = mTempRect;
        right = 0;
        left = 0;
      }
      int n = getPaddingLeft();
      int i1 = getPaddingRight();
      int i2 = getWidth();
      localObject = AppCompatSpinner.this;
      int j = mDropDownWidth;
      if (j == -2)
      {
        int k = ((AppCompatSpinner)localObject).compatMeasureContentWidth((SpinnerAdapter)mAdapter, getBackground());
        j = k;
        int m = getContext().getResources().getDisplayMetrics().widthPixels;
        localObject = mTempRect;
        m = m - left - right;
        if (k > m) {
          j = m;
        }
        setContentWidth(Math.max(j, i2 - n - i1));
      }
      else if (j == -1)
      {
        setContentWidth(i2 - n - i1);
      }
      else
      {
        setContentWidth(j);
      }
      if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
        i = i2 - i1 - getWidth() + i;
      } else {
        i += n;
      }
      setHorizontalOffset(i);
    }
    
    public CharSequence getHintText()
    {
      return mHintText;
    }
    
    public boolean isVisibleToUser(View paramView)
    {
      return (ViewCompat.cancel(paramView)) && (paramView.getGlobalVisibleRect(mVisibleRect));
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      mAdapter = paramListAdapter;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      mHintText = paramCharSequence;
    }
    
    public void show()
    {
      boolean bool = isShowing();
      computeContentWidth();
      setInputMethodMode(2);
      super.show();
      getListView().setChoiceMode(1);
      setSelection(getSelectedItemPosition());
      if (bool) {
        return;
      }
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver != null)
      {
        final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            AppCompatSpinner.DropdownPopup localDropdownPopup = AppCompatSpinner.DropdownPopup.this;
            if (!localDropdownPopup.isVisibleToUser(this$0))
            {
              dismiss();
              return;
            }
            computeContentWidth();
            AppCompatSpinner.DropdownPopup.access$001(AppCompatSpinner.DropdownPopup.this);
          }
        };
        localViewTreeObserver.addOnGlobalLayoutListener(local2);
        setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public void onDismiss()
          {
            ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
            if (localViewTreeObserver != null) {
              localViewTreeObserver.removeGlobalOnLayoutListener(local2);
            }
          }
        });
      }
    }
  }
}
