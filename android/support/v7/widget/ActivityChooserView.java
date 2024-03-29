package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.database.Observable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import b.b.a.N;
import support.android.v4.view.ActionProvider;

@N({b.b.a.N.a.b})
public class ActivityChooserView
  extends ViewGroup
  implements ActivityChooserModel.ActivityChooserModelClient
{
  public static final String LOG_TAG = "ActivityChooserView";
  public final View mActivityChooserContent;
  public final Drawable mActivityChooserContentBackground;
  public final ActivityChooserViewAdapter mAdapter;
  public final Callbacks mCallbacks;
  public int mDefaultActionButtonContentDescription;
  public final FrameLayout mDefaultActivityButton;
  public final ImageView mDefaultActivityButtonImage;
  public final FrameLayout mExpandActivityOverflowButton;
  public final ImageView mExpandActivityOverflowButtonImage;
  public int mInitialActivityCount = 4;
  public boolean mIsAttachedToWindow;
  public boolean mIsSelectingDefaultActivity;
  public final int mListPopupMaxWidth;
  public ListPopupWindow mListPopupWindow;
  public final DataSetObserver mModelDataSetObserver = new DataSetObserver()
  {
    public void onChanged()
    {
      super.onChanged();
      mAdapter.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      super.onInvalidated();
      mAdapter.notifyDataSetInvalidated();
    }
  };
  public PopupWindow.OnDismissListener mOnDismissListener;
  public final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (isShowingPopup())
      {
        if (!isShown())
        {
          getListPopupWindow().dismiss();
          return;
        }
        getListPopupWindow().show();
        ActionProvider localActionProvider = mProvider;
        if (localActionProvider != null) {
          localActionProvider.subUiVisibilityChanged(true);
        }
      }
    }
  };
  public ActionProvider mProvider;
  
  public ActivityChooserView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActivityChooserView, paramInt, 0);
    mInitialActivityCount = ((TypedArray)localObject).getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
    mCallbacks = new Callbacks();
    mActivityChooserContent = findViewById(R.id.activity_chooser_view_content);
    mActivityChooserContentBackground = mActivityChooserContent.getBackground();
    mDefaultActivityButton = ((FrameLayout)findViewById(R.id.default_activity_button));
    mDefaultActivityButton.setOnClickListener(mCallbacks);
    mDefaultActivityButton.setOnLongClickListener(mCallbacks);
    mDefaultActivityButtonImage = ((ImageView)mDefaultActivityButton.findViewById(R.id.image));
    localObject = (FrameLayout)findViewById(R.id.expand_activities_button);
    ((View)localObject).setOnClickListener(mCallbacks);
    ((View)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        int i = Build.VERSION.SDK_INT;
        paramAnonymousAccessibilityNodeInfo.setCanOpenPopup(true);
      }
    });
    ((View)localObject).setOnTouchListener(new ForwardingListener((View)localObject)
    {
      public ShowableListMenu getPopup()
      {
        return getListPopupWindow();
      }
      
      public boolean onForwardingStarted()
      {
        showPopup();
        return true;
      }
      
      public boolean onForwardingStopped()
      {
        dismissPopup();
        return true;
      }
    });
    mExpandActivityOverflowButton = ((FrameLayout)localObject);
    mExpandActivityOverflowButtonImage = ((ImageView)((View)localObject).findViewById(R.id.image));
    mExpandActivityOverflowButtonImage.setImageDrawable(paramAttributeSet);
    mAdapter = new ActivityChooserViewAdapter();
    mAdapter.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged()
      {
        super.onChanged();
        updateAppearance();
      }
    });
    paramContext = paramContext.getResources();
    mListPopupMaxWidth = Math.max(getDisplayMetricswidthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
  }
  
  public boolean dismissPopup()
  {
    if (isShowingPopup())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
      }
    }
    return true;
  }
  
  public ActivityChooserModel getDataModel()
  {
    return mAdapter.getDataModel();
  }
  
  public ListPopupWindow getListPopupWindow()
  {
    if (mListPopupWindow == null)
    {
      mListPopupWindow = new ListPopupWindow(getContext());
      mListPopupWindow.setAdapter(mAdapter);
      mListPopupWindow.setAnchorView(this);
      mListPopupWindow.setModal(true);
      mListPopupWindow.setOnItemClickListener(mCallbacks);
      mListPopupWindow.setOnDismissListener(mCallbacks);
    }
    return mListPopupWindow;
  }
  
  public boolean isShowingPopup()
  {
    return getListPopupWindow().isShowing();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ActivityChooserModel localActivityChooserModel = mAdapter.getDataModel();
    if (localActivityChooserModel != null) {
      localActivityChooserModel.registerObserver(mModelDataSetObserver);
    }
    mIsAttachedToWindow = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = mAdapter.getDataModel();
    if (localObject != null) {
      ((Observable)localObject).unregisterObserver(mModelDataSetObserver);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
    }
    if (isShowingPopup()) {
      dismissPopup();
    }
    mIsAttachedToWindow = false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mActivityChooserContent.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!isShowingPopup()) {
      dismissPopup();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = mActivityChooserContent;
    int i = paramInt2;
    if (mDefaultActivityButton.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel)
  {
    mAdapter.setDataModel(paramActivityChooserModel);
    if (isShowingPopup())
    {
      dismissPopup();
      showPopup();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    mDefaultActionButtonContentDescription = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    mExpandActivityOverflowButtonImage.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    mExpandActivityOverflowButtonImage.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    mInitialActivityCount = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    mOnDismissListener = paramOnDismissListener;
  }
  
  public void setProvider(ActionProvider paramActionProvider)
  {
    mProvider = paramActionProvider;
  }
  
  public boolean showPopup()
  {
    if (!isShowingPopup())
    {
      if (!mIsAttachedToWindow) {
        return false;
      }
      mIsSelectingDefaultActivity = false;
      showPopupUnchecked(mInitialActivityCount);
      return true;
    }
    return false;
  }
  
  public void showPopupUnchecked(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public void updateAppearance()
  {
    if (mAdapter.getCount() > 0) {
      mExpandActivityOverflowButton.setEnabled(true);
    } else {
      mExpandActivityOverflowButton.setEnabled(false);
    }
    int i = mAdapter.getActivityCount();
    int j = mAdapter.getHistorySize();
    if ((i != 1) && ((i <= 1) || (j <= 0)))
    {
      mDefaultActivityButton.setVisibility(8);
    }
    else
    {
      mDefaultActivityButton.setVisibility(0);
      Object localObject = mAdapter.getDefaultActivity();
      PackageManager localPackageManager = getContext().getPackageManager();
      mDefaultActivityButtonImage.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
      if (mDefaultActionButtonContentDescription != 0)
      {
        localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = getContext().getString(mDefaultActionButtonContentDescription, new Object[] { localObject });
        mDefaultActivityButton.setContentDescription((CharSequence)localObject);
      }
    }
    if (mDefaultActivityButton.getVisibility() == 0)
    {
      mActivityChooserContent.setBackgroundDrawable(mActivityChooserContentBackground);
      return;
    }
    mActivityChooserContent.setBackgroundDrawable(null);
  }
  
  private class ActivityChooserViewAdapter
    extends BaseAdapter
  {
    public static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
    public static final int ITEM_VIEW_TYPE_COUNT = 3;
    public static final int ITEM_VIEW_TYPE_FOOTER = 1;
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public ActivityChooserModel mDataModel;
    public boolean mHighlightDefaultActivity;
    public int mMaxActivityCount = 4;
    public boolean mShowDefaultActivity;
    public boolean mShowFooterView;
    
    public ActivityChooserViewAdapter() {}
    
    public int getActivityCount()
    {
      return mDataModel.getActivityCount();
    }
    
    public int getCount()
    {
      int k = mDataModel.getActivityCount();
      int i = k;
      int j = i;
      if (!mShowDefaultActivity)
      {
        j = i;
        if (mDataModel.getDefaultActivity() != null) {
          j = k - 1;
        }
      }
      j = Math.min(j, mMaxActivityCount);
      i = j;
      if (mShowFooterView) {
        i = j + 1;
      }
      return i;
    }
    
    public ActivityChooserModel getDataModel()
    {
      return mDataModel;
    }
    
    public ResolveInfo getDefaultActivity()
    {
      return mDataModel.getDefaultActivity();
    }
    
    public int getHistorySize()
    {
      return mDataModel.getHistorySize();
    }
    
    public Object getItem(int paramInt)
    {
      int i = getItemViewType(paramInt);
      if (i != 0)
      {
        if (i == 1) {
          return null;
        }
        throw new IllegalArgumentException();
      }
      i = paramInt;
      if (!mShowDefaultActivity)
      {
        i = paramInt;
        if (mDataModel.getDefaultActivity() != null) {
          i = paramInt + 1;
        }
      }
      return mDataModel.getActivity(i);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((mShowFooterView) && (paramInt == getCount() - 1)) {
        return 1;
      }
      return 0;
    }
    
    public boolean getShowDefaultActivity()
    {
      return mShowDefaultActivity;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      View localView;
      if (i != 0)
      {
        if (i == 1)
        {
          if (paramView != null)
          {
            localView = paramView;
            if (paramView.getId() == 1) {}
          }
          else
          {
            paramView = LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
            paramView.setId(1);
            ((TextView)paramView.findViewById(R.id.title)).setText(getContext().getString(R.string.abc_activity_chooser_view_see_all));
            return paramView;
          }
        }
        else {
          throw new IllegalArgumentException();
        }
      }
      else
      {
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getId() == R.id.list_item) {}
        }
        else
        {
          localView = LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
        }
        paramView = getContext().getPackageManager();
        paramViewGroup = (ImageView)localView.findViewById(R.id.icon);
        ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
        paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
        ((TextView)localView.findViewById(R.id.title)).setText(localResolveInfo.loadLabel(paramView));
        if ((mShowDefaultActivity) && (paramInt == 0) && (mHighlightDefaultActivity))
        {
          localView.setActivated(true);
          return localView;
        }
        localView.setActivated(false);
      }
      return localView;
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
    
    public int measureContentWidth()
    {
      int k = mMaxActivityCount;
      mMaxActivityCount = Integer.MAX_VALUE;
      int i = 0;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      Object localObject = null;
      int j = 0;
      while (i < i1)
      {
        View localView = getView(i, (View)localObject, null);
        localObject = localView;
        localView.measure(m, n);
        j = Math.max(j, localView.getMeasuredWidth());
        i += 1;
      }
      mMaxActivityCount = k;
      return j;
    }
    
    public void setDataModel(ActivityChooserModel paramActivityChooserModel)
    {
      ActivityChooserModel localActivityChooserModel = mAdapter.getDataModel();
      if ((localActivityChooserModel != null) && (isShown())) {
        localActivityChooserModel.unregisterObserver(mModelDataSetObserver);
      }
      mDataModel = paramActivityChooserModel;
      if ((paramActivityChooserModel != null) && (isShown())) {
        paramActivityChooserModel.registerObserver(mModelDataSetObserver);
      }
      notifyDataSetChanged();
    }
    
    public void setMaxActivityCount(int paramInt)
    {
      if (mMaxActivityCount != paramInt)
      {
        mMaxActivityCount = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public void setShowDefaultActivity(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((mShowDefaultActivity != paramBoolean1) || (mHighlightDefaultActivity != paramBoolean2))
      {
        mShowDefaultActivity = paramBoolean1;
        mHighlightDefaultActivity = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public void setShowFooterView(boolean paramBoolean)
    {
      if (mShowFooterView != paramBoolean)
      {
        mShowFooterView = paramBoolean;
        notifyDataSetChanged();
      }
    }
  }
  
  private class Callbacks
    implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener
  {
    public Callbacks() {}
    
    private void notifyOnDismissListener()
    {
      PopupWindow.OnDismissListener localOnDismissListener = mOnDismissListener;
      if (localOnDismissListener != null) {
        localOnDismissListener.onDismiss();
      }
    }
    
    public void onClick(View paramView)
    {
      ActivityChooserView localActivityChooserView = ActivityChooserView.this;
      if (paramView == mDefaultActivityButton)
      {
        localActivityChooserView.dismissPopup();
        paramView = mAdapter.getDefaultActivity();
        int i = mAdapter.getDataModel().getActivityIndex(paramView);
        paramView = mAdapter.getDataModel().chooseActivity(i);
        if (paramView != null)
        {
          paramView.addFlags(524288);
          getContext().startActivity(paramView);
        }
      }
      else
      {
        if (paramView == mExpandActivityOverflowButton)
        {
          mIsSelectingDefaultActivity = false;
          localActivityChooserView.showPopupUnchecked(mInitialActivityCount);
          return;
        }
        throw new IllegalArgumentException();
      }
    }
    
    public void onDismiss()
    {
      notifyOnDismissListener();
      ActionProvider localActionProvider = mProvider;
      if (localActionProvider != null) {
        localActionProvider.subUiVisibilityChanged(false);
      }
    }
    
    public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      int i = ((ActivityChooserView.ActivityChooserViewAdapter)paramAdapterView.getAdapter()).getItemViewType(paramInt);
      if (i != 0)
      {
        if (i == 1)
        {
          showPopupUnchecked(Integer.MAX_VALUE);
          return;
        }
        throw new IllegalArgumentException();
      }
      dismissPopup();
      paramAdapterView = ActivityChooserView.this;
      if (mIsSelectingDefaultActivity)
      {
        if (paramInt > 0) {
          mAdapter.getDataModel().setDefaultActivity(paramInt);
        }
      }
      else
      {
        if (!mAdapter.getShowDefaultActivity()) {
          paramInt += 1;
        }
        paramAdapterView = mAdapter.getDataModel().chooseActivity(paramInt);
        if (paramAdapterView != null)
        {
          paramAdapterView.addFlags(524288);
          getContext().startActivity(paramAdapterView);
        }
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      ActivityChooserView localActivityChooserView = ActivityChooserView.this;
      if (paramView == mDefaultActivityButton)
      {
        if (mAdapter.getCount() > 0)
        {
          paramView = ActivityChooserView.this;
          mIsSelectingDefaultActivity = true;
          paramView.showPopupUnchecked(mInitialActivityCount);
          return true;
        }
      }
      else {
        throw new IllegalArgumentException();
      }
      return true;
    }
  }
  
  @N({b.b.a.N.a.b})
  public static class InnerLayout
    extends LinearLayout
  {
    public static final int[] TINT_ATTRS = { 16842964 };
    
    public InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS);
      setBackgroundDrawable(paramContext.getDrawable(0));
      paramContext.recycle();
    }
  }
}
