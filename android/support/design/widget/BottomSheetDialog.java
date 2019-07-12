package android.support.design.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.R.attr;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import support.android.v4.view.AccessibilityDelegateCompat;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;

public class BottomSheetDialog
  extends AppCompatDialog
{
  public BottomSheetBehavior<FrameLayout> behavior;
  public BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback()
  {
    public void onSlide(View paramAnonymousView, float paramAnonymousFloat) {}
    
    public void onStateChanged(View paramAnonymousView, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 5) {
        cancel();
      }
    }
  };
  public boolean cancelable = true;
  public boolean canceledOnTouchOutside = true;
  public boolean canceledOnTouchOutsideSet;
  
  public BottomSheetDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BottomSheetDialog(Context paramContext, int paramInt)
  {
    super(paramContext, getThemeResId(paramContext, paramInt));
    supportRequestWindowFeature(1);
  }
  
  public BottomSheetDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    supportRequestWindowFeature(1);
    cancelable = paramBoolean;
  }
  
  public static int getThemeResId(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      if (paramContext.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, localTypedValue, true)) {
        return resourceId;
      }
      i = R.style.Theme_Design_Light_BottomSheetDialog;
    }
    return i;
  }
  
  private View wrapInBottomSheet(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = (FrameLayout)View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localFrameLayout.findViewById(R.id.coordinator);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)localCoordinatorLayout.findViewById(R.id.design_bottom_sheet);
    behavior = BottomSheetBehavior.from(paramView);
    behavior.setBottomSheetCallback(bottomSheetCallback);
    behavior.setHideable(cancelable);
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    } else {
      paramView.addView(localView, paramLayoutParams);
    }
    localCoordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = BottomSheetDialog.this;
        if ((cancelable) && (paramAnonymousView.isShowing()) && (shouldWindowCloseOnTouchOutside())) {
          cancel();
        }
      }
    });
    ViewCompat.setAccessibilityDelegate(paramView, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        if (cancelable)
        {
          paramAnonymousAccessibilityNodeInfoCompat.addAction(1048576);
          paramAnonymousAccessibilityNodeInfoCompat.addChild(true);
          return;
        }
        paramAnonymousAccessibilityNodeInfoCompat.addChild(false);
      }
      
      public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt == 1048576)
        {
          BottomSheetDialog localBottomSheetDialog = BottomSheetDialog.this;
          if (cancelable)
          {
            localBottomSheetDialog.cancel();
            return true;
          }
        }
        return super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
      }
    });
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    return localFrameLayout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle.clearFlags(67108864);
        paramBundle.addFlags(Integer.MIN_VALUE);
      }
      paramBundle.setLayout(-1, -1);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    BottomSheetBehavior localBottomSheetBehavior = behavior;
    if ((localBottomSheetBehavior != null) && (localBottomSheetBehavior.getState() == 5)) {
      behavior.setState(4);
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (cancelable != paramBoolean)
    {
      cancelable = paramBoolean;
      BottomSheetBehavior localBottomSheetBehavior = behavior;
      if (localBottomSheetBehavior != null) {
        localBottomSheetBehavior.setHideable(paramBoolean);
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!cancelable)) {
      cancelable = true;
    }
    canceledOnTouchOutside = paramBoolean;
    canceledOnTouchOutsideSet = true;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(wrapInBottomSheet(paramInt, null, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, paramLayoutParams));
  }
  
  public boolean shouldWindowCloseOnTouchOutside()
  {
    if (!canceledOnTouchOutsideSet)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(new int[] { 16843611 });
      canceledOnTouchOutside = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
      canceledOnTouchOutsideSet = true;
    }
    return canceledOnTouchOutside;
  }
}
