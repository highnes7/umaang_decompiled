package email.pedant.SweetAlert;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import internal.view.menu.R.styleable;

public class Rotate3dAnimation
  extends Animation
{
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final int QUIET_HOURS_DEFAULT_END_MINUTE = 0;
  public static final int WEEKS_BUFFER = 1;
  public int h;
  public int height = 0;
  public Camera mCamera;
  public float mPivotX;
  public float mPivotY;
  public float size;
  public float this$0;
  public float width = 0.0F;
  public int x = 0;
  public float y = 0.0F;
  
  public Rotate3dAnimation(int paramInt, float paramFloat1, float paramFloat2)
  {
    h = paramInt;
    size = paramFloat1;
    this$0 = paramFloat2;
    mPivotX = 0.0F;
    mPivotY = 0.0F;
  }
  
  public Rotate3dAnimation(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    h = paramInt;
    size = paramFloat1;
    this$0 = paramFloat2;
    x = 0;
    height = 0;
    width = paramFloat3;
    y = paramFloat4;
    initialize();
  }
  
  public Rotate3dAnimation(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3, int paramInt3, float paramFloat4)
  {
    h = paramInt1;
    size = paramFloat1;
    this$0 = paramFloat2;
    width = paramFloat3;
    x = paramInt2;
    y = paramFloat4;
    height = paramInt3;
    initialize();
  }
  
  public Rotate3dAnimation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Rotate3dAnimation);
    size = paramContext.getFloat(R.styleable.Rotate3dAnimation_fromDeg, 0.0F);
    this$0 = paramContext.getFloat(R.styleable.Rotate3dAnimation_toDeg, 0.0F);
    h = paramContext.getInt(R.styleable.Rotate3dAnimation_rollType, 0);
    paramAttributeSet = initialize(paramContext.peekValue(R.styleable.Rotate3dAnimation_pivotX));
    x = w;
    width = x;
    paramAttributeSet = initialize(paramContext.peekValue(R.styleable.Rotate3dAnimation_pivotY));
    height = w;
    y = x;
    paramContext.recycle();
    initialize();
  }
  
  private void initialize()
  {
    if (x == 0) {
      mPivotX = width;
    }
    if (height == 0) {
      mPivotY = y;
    }
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f = size;
    paramFloat = StringBuilder.append(this$0, f, paramFloat, f);
    paramTransformation = paramTransformation.getMatrix();
    mCamera.save();
    int i = h;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          mCamera.rotateZ(paramFloat);
        }
      }
      else {
        mCamera.rotateY(paramFloat);
      }
    }
    else {
      mCamera.rotateX(paramFloat);
    }
    mCamera.getMatrix(paramTransformation);
    mCamera.restore();
    paramTransformation.preTranslate(-mPivotX, -mPivotY);
    paramTransformation.postTranslate(mPivotX, mPivotY);
  }
  
  public a initialize(TypedValue paramTypedValue)
  {
    a localA = new a();
    if (paramTypedValue == null)
    {
      w = 0;
      x = 0.0F;
    }
    else
    {
      int i = type;
      if (i == 6)
      {
        int j = data;
        i = 1;
        if ((j & 0xF) == 1) {
          i = 2;
        }
        w = i;
        x = TypedValue.complexToFloat(data);
        return localA;
      }
      if (i == 4)
      {
        w = 0;
        x = paramTypedValue.getFloat();
        return localA;
      }
      if ((i >= 16) && (i <= 31))
      {
        w = 0;
        x = data;
        return localA;
      }
    }
    w = 0;
    x = 0.0F;
    return localA;
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    mCamera = new Camera();
    mPivotX = resolveSize(x, width, paramInt1, paramInt3);
    mPivotY = resolveSize(height, y, paramInt2, paramInt4);
  }
  
  public class a
  {
    public int w;
    public float x;
    
    public a() {}
  }
}
