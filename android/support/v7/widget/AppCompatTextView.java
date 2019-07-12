package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import b.b.a.G;
import b.b.x.m.d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import support.android.v4.text.Label;
import support.android.v4.text.b;
import support.android.v4.view.TintableBackgroundView;
import support.android.v4.widget.f;

public class AppCompatTextView
  extends android.widget.TextView
  implements TintableBackgroundView, support.android.v4.widget.TextView
{
  public final AppCompatBackgroundHelper mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
  @G
  public Future<d> mPrecomputedTextFuture;
  public final AppCompatTextHelper mTextHelper;
  
  public AppCompatTextView(Context paramContext)
  {
    this(paramContext, null, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    mBackgroundTintHelper.loadFromAttributes(paramAttributeSet, paramInt);
    mTextHelper = new AppCompatTextHelper(this);
    mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    mTextHelper.applyCompoundDrawablesTints();
  }
  
  private void consumeTextFutureAndSetBlocking()
  {
    Object localObject = mPrecomputedTextFuture;
    if (localObject != null)
    {
      mPrecomputedTextFuture = null;
      try
      {
        localObject = ((Future)localObject).get();
        localObject = (b)localObject;
        f.a(this, (b)localObject);
        return;
      }
      catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = mBackgroundTintHelper;
    if (localObject != null) {
      ((AppCompatBackgroundHelper)localObject).applySupportBackgroundTint();
    }
    localObject = mTextHelper;
    if (localObject != null) {
      ((AppCompatTextHelper)localObject).applyCompoundDrawablesTints();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (support.android.v4.widget.TextView.isInit) {
      return super.getAutoSizeMaxTextSize();
    }
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      return localAppCompatTextHelper.getAutoSizeMaxTextSize();
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (support.android.v4.widget.TextView.isInit) {
      return super.getAutoSizeMinTextSize();
    }
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      return localAppCompatTextHelper.getAutoSizeMinTextSize();
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (support.android.v4.widget.TextView.isInit) {
      return super.getAutoSizeStepGranularity();
    }
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      return localAppCompatTextHelper.getAutoSizeStepGranularity();
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (support.android.v4.widget.TextView.isInit) {
      return super.getAutoSizeTextAvailableSizes();
    }
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      return localAppCompatTextHelper.getAutoSizeTextAvailableSizes();
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (support.android.v4.widget.TextView.isInit)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
    }
    else
    {
      AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
      if (localAppCompatTextHelper != null) {
        return localAppCompatTextHelper.getAutoSizeTextType();
      }
    }
    return 0;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    return f.updatePadding(this);
  }
  
  public int getLastBaselineToBottomHeight()
  {
    return f.setText(this);
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
  
  public CharSequence getText()
  {
    consumeTextFutureAndSetBlocking();
    return super.getText();
  }
  
  public Label getTextMetricsParamsCompat()
  {
    return f.a(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    AppCompatHintHelper.onCreateInputConnection(localInputConnection, paramEditorInfo, this);
    return localInputConnection;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      localAppCompatTextHelper.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    consumeTextFutureAndSetBlocking();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence = mTextHelper;
    if ((paramCharSequence != null) && (!support.android.v4.widget.TextView.isInit) && (paramCharSequence.isAutoSizeEnabled())) {
      mTextHelper.autoSizeText();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (support.android.v4.widget.TextView.isInit)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      localAppCompatTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (support.android.v4.widget.TextView.isInit)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      localAppCompatTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (support.android.v4.widget.TextView.isInit)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      localAppCompatTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
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
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(f.a(this, paramCallback));
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    f.draw(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    }
    f.initialize(this, paramInt);
  }
  
  public void setLineHeight(int paramInt)
  {
    f.init(this, paramInt);
  }
  
  public void setPrecomputedText(b paramB)
  {
    f.a(this, paramB);
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
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      localAppCompatTextHelper.onSetTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(Future paramFuture)
  {
    mPrecomputedTextFuture = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(Label paramLabel)
  {
    f.a(this, paramLabel);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (support.android.v4.widget.TextView.isInit)
    {
      super.setTextSize(paramInt, paramFloat);
      return;
    }
    AppCompatTextHelper localAppCompatTextHelper = mTextHelper;
    if (localAppCompatTextHelper != null) {
      localAppCompatTextHelper.setTextSize(paramInt, paramFloat);
    }
  }
}
