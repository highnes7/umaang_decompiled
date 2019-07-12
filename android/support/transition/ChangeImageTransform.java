package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;
import support.android.asm.Edit;
import support.android.asm.FloatEvaluator;
import support.android.asm.GA;
import support.android.asm.Handler;
import support.android.asm.NativeFloat32Array;
import support.android.asm.ha.a;

public class ChangeImageTransform
  extends Transition
{
  public static final String ACTION_UPDATE_ALL = "android:changeImageTransform:bounds";
  public static final String PAGE_KEY = "android:changeImageTransform:matrix";
  public static final Property<ImageView, Matrix> mProperty = new NativeFloat32Array(Matrix.class, "animatedTransform");
  public static final TypeEvaluator<Matrix> mPropertyName;
  public static final String[] suVersion = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  
  static
  {
    mPropertyName = new FloatEvaluator();
  }
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void captureValues(Edit paramEdit)
  {
    View localView = view;
    if ((localView instanceof ImageView))
    {
      if (localView.getVisibility() != 0) {
        return;
      }
      ImageView localImageView = (ImageView)localView;
      if (localImageView.getDrawable() == null) {
        return;
      }
      paramEdit = values;
      paramEdit.put("android:changeImageTransform:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramEdit.put("android:changeImageTransform:matrix", roundCorners(localImageView));
    }
  }
  
  public static Matrix draw(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    int i = localDrawable.getIntrinsicWidth();
    float f1 = paramImageView.getWidth();
    float f2 = i;
    float f5 = f1 / f2;
    i = localDrawable.getIntrinsicHeight();
    float f3 = paramImageView.getHeight();
    float f4 = i;
    f5 = Math.max(f5, f3 / f4);
    i = Math.round((f1 - f2 * f5) / 2.0F);
    int j = Math.round((f3 - f4 * f5) / 2.0F);
    paramImageView = new Matrix();
    paramImageView.postScale(f5, f5);
    paramImageView.postTranslate(i, j);
    return paramImageView;
  }
  
  private ObjectAnimator ofFloat(ImageView paramImageView, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    return ObjectAnimator.ofObject(paramImageView, mProperty, new ha.a(), new Matrix[] { paramMatrix1, paramMatrix2 });
  }
  
  public static Matrix reset(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramImageView.getWidth() / localDrawable.getIntrinsicWidth(), paramImageView.getHeight() / localDrawable.getIntrinsicHeight());
    return localMatrix;
  }
  
  public static Matrix roundCorners(ImageView paramImageView)
  {
    int i = support.android.asm.RoundedBitmapDisplayer.1.$SwitchMap$android$widget$ImageView$ScaleType[paramImageView.getScaleType().ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return new Matrix(paramImageView.getImageMatrix());
      }
      return draw(paramImageView);
    }
    return reset(paramImageView);
  }
  
  private ObjectAnimator setObjectValues(ImageView paramImageView)
  {
    return ObjectAnimator.ofObject(paramImageView, mProperty, mPropertyName, new Matrix[] { null, null });
  }
  
  public void captureEndValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, Edit paramEdit1, Edit paramEdit2)
  {
    if (paramEdit1 != null)
    {
      if (paramEdit2 == null) {
        return null;
      }
      paramViewGroup = (Rect)values.get("android:changeImageTransform:bounds");
      Rect localRect = (Rect)values.get("android:changeImageTransform:bounds");
      if (paramViewGroup != null)
      {
        if (localRect == null) {
          return null;
        }
        paramEdit1 = (Matrix)values.get("android:changeImageTransform:matrix");
        Matrix localMatrix = (Matrix)values.get("android:changeImageTransform:matrix");
        if (((paramEdit1 == null) && (localMatrix == null)) || ((paramEdit1 != null) && (paramEdit1.equals(localMatrix)))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((paramViewGroup.equals(localRect)) && (i != 0)) {
          return null;
        }
        paramEdit2 = (ImageView)view;
        paramViewGroup = paramEdit2.getDrawable();
        int i = paramViewGroup.getIntrinsicWidth();
        int j = paramViewGroup.getIntrinsicHeight();
        Handler.init(paramEdit2);
        if ((i != 0) && (j != 0))
        {
          paramViewGroup = paramEdit1;
          if (paramEdit1 == null) {
            paramViewGroup = GA.values;
          }
          paramEdit1 = localMatrix;
          if (localMatrix == null) {
            paramEdit1 = GA.values;
          }
          mProperty.set(paramEdit2, paramViewGroup);
          paramViewGroup = ofFloat(paramEdit2, paramViewGroup, paramEdit1);
        }
        else
        {
          paramViewGroup = setObjectValues(paramEdit2);
        }
        Handler.animate(paramEdit2, paramViewGroup);
        return paramViewGroup;
      }
    }
    return null;
  }
  
  public String[] getTransitionProperties()
  {
    return suVersion;
  }
}
