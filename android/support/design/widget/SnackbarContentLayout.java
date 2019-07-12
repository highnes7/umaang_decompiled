package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.R.dimen;
import android.support.design.R.id;
import android.support.design.R.styleable;
import android.support.design.snackbar.ContentViewCallback;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.N;
import support.android.v4.view.ViewCompat;

@N({b.b.a.N.a.b})
public class SnackbarContentLayout
  extends LinearLayout
  implements ContentViewCallback
{
  public Button actionView;
  public int maxInlineActionWidth;
  public int maxWidth;
  public TextView messageView;
  
  public SnackbarContentLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    maxWidth = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
    maxInlineActionWidth = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
    paramContext.recycle();
  }
  
  public static void updateTopBottomPadding(View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.isPaddingRelative(paramView))
    {
      ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramInt1, ViewCompat.getPaddingEnd(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean updateViewsWithinLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((messageView.getPaddingTop() != paramInt2) || (messageView.getPaddingBottom() != paramInt3))
    {
      updateTopBottomPadding(messageView, paramInt2, paramInt3);
      return true;
    }
    return bool;
  }
  
  public void animateContentIn(int paramInt1, int paramInt2)
  {
    messageView.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = messageView.animate().alpha(1.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (actionView.getVisibility() == 0)
    {
      actionView.setAlpha(0.0F);
      actionView.animate().alpha(1.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public void animateContentOut(int paramInt1, int paramInt2)
  {
    messageView.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = messageView.animate().alpha(0.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (actionView.getVisibility() == 0)
    {
      actionView.setAlpha(1.0F);
      actionView.animate().alpha(0.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public Button getActionView()
  {
    return actionView;
  }
  
  public TextView getMessageView()
  {
    return messageView;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    messageView = ((TextView)findViewById(R.id.snackbar_text));
    actionView = ((Button)findViewById(R.id.snackbar_action));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (maxWidth > 0)
    {
      j = getMeasuredWidth();
      k = maxWidth;
      i = paramInt1;
      if (j > k)
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        i = paramInt1;
        super.onMeasure(paramInt1, paramInt2);
      }
    }
    int m = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
    paramInt1 = m;
    int n = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
    int j = messageView.getLayout().getLineCount();
    int k = 1;
    if (j > 1) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && (maxInlineActionWidth > 0) && (actionView.getMeasuredWidth() > maxInlineActionWidth))
    {
      if (updateViewsWithinLayout(1, m, m - n))
      {
        paramInt1 = k;
        break label185;
      }
    }
    else
    {
      if (j == 0) {
        paramInt1 = n;
      }
      if (updateViewsWithinLayout(0, paramInt1, paramInt1))
      {
        paramInt1 = k;
        break label185;
      }
    }
    paramInt1 = 0;
    label185:
    if (paramInt1 != 0) {
      super.onMeasure(i, paramInt2);
    }
  }
}
