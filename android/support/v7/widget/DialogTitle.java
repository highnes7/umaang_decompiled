package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R.styleable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.View;
import android.widget.TextView;
import b.b.a.N;
import support.android.v4.widget.f;

@N({b.b.a.N.a.b})
public class DialogTitle
  extends TextView
{
  public DialogTitle(Context paramContext)
  {
    super(paramContext);
  }
  
  public DialogTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DialogTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = getLayout();
    if (localObject != null)
    {
      int i = ((Layout)localObject).getLineCount();
      if ((i > 0) && (((Layout)localObject).getEllipsisCount(i - 1) > 0))
      {
        setSingleLine(false);
        setMaxLines(2);
        localObject = getContext().obtainStyledAttributes(null, R.styleable.TextAppearance, 16842817, 16973892);
        i = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (i != 0) {
          setTextSize(0, i);
        }
        ((TypedArray)localObject).recycle();
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(f.a(this, paramCallback));
  }
}