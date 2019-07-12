package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import org.xmlpull.v1.XmlPullParser;
import support.android.asm.R.styleable;
import support.android.v4.content.asm.TypedArrayUtils;

public class ArcMotion
  extends PathMotion
{
  public static final float CIRCLE_COUNT = 0.0F;
  public static final float head = (float)Math.tan(Math.toRadians(35.0D));
  public static final float mCoeffX = 70.0F;
  public float a = 0.0F;
  public float d = 0.0F;
  public float f = 0.0F;
  public float j = 0.0F;
  public float l = head;
  public float u = 70.0F;
  
  public ArcMotion() {}
  
  public ArcMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActionMode);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    subtract(TypedArrayUtils.getNamedFloat(paramContext, paramAttributeSet, "minimumVerticalAngle", 1, 0.0F));
    b(TypedArrayUtils.getNamedFloat(paramContext, paramAttributeSet, "minimumHorizontalAngle", 0, 0.0F));
    a(TypedArrayUtils.getNamedFloat(paramContext, paramAttributeSet, "maximumAngle", 2, 70.0F));
    paramContext.recycle();
  }
  
  public static float getValue(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 90.0F)) {
      return (float)Math.tan(Math.toRadians(paramFloat / 2.0F));
    }
    throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
  }
  
  public void a(float paramFloat)
  {
    u = paramFloat;
    l = getValue(paramFloat);
  }
  
  public float b()
  {
    return d;
  }
  
  public void b(float paramFloat)
  {
    d = paramFloat;
    a = getValue(paramFloat);
  }
  
  public float c()
  {
    return f;
  }
  
  public Path draw(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat2);
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = f2 * f2 + f1 * f1;
    float f7 = (paramFloat1 + paramFloat3) / 2.0F;
    float f6 = (paramFloat2 + paramFloat4) / 2.0F;
    float f4 = 0.25F * f3;
    int i;
    if (paramFloat2 > paramFloat4) {
      i = 1;
    } else {
      i = 0;
    }
    if (Math.abs(f1) < Math.abs(f2))
    {
      f1 = Math.abs(f3 / (f2 * 2.0F));
      if (i != 0)
      {
        f1 += paramFloat4;
        f2 = paramFloat3;
      }
      else
      {
        f1 += paramFloat2;
        f2 = paramFloat1;
      }
      f3 = j;
    }
    else
    {
      f1 = f3 / (f1 * 2.0F);
      if (i != 0)
      {
        f2 = f1 + paramFloat1;
        f1 = paramFloat2;
      }
      else
      {
        f2 = paramFloat3 - f1;
        f1 = paramFloat4;
      }
      f3 = a;
    }
    f3 = f4 * f3 * f3;
    float f5 = f7 - f2;
    float f8 = f6 - f1;
    f8 = f8 * f8 + f5 * f5;
    f5 = l;
    f4 = f5 * (f4 * f5);
    if (f8 >= f3) {
      if (f8 > f4) {
        f3 = f4;
      } else {
        f3 = 0.0F;
      }
    }
    f5 = f1;
    f4 = f2;
    if (f3 != 0.0F)
    {
      f3 = (float)Math.sqrt(f3 / f8);
      f4 = StringBuilder.append(f2, f7, f3, f7);
      f5 = StringBuilder.append(f1, f6, f3, f6);
    }
    localPath.cubicTo((paramFloat1 + f4) / 2.0F, (paramFloat2 + f5) / 2.0F, (f4 + paramFloat3) / 2.0F, (f5 + paramFloat4) / 2.0F, paramFloat3, paramFloat4);
    return localPath;
  }
  
  public float getU()
  {
    return u;
  }
  
  public void subtract(float paramFloat)
  {
    f = paramFloat;
    j = getValue(paramFloat);
  }
}
