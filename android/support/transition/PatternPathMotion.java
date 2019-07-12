package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import support.android.asm.R.styleable;
import support.android.v4.content.asm.TypedArrayUtils;
import support.android.v4.internal.PathParser;

public class PatternPathMotion
  extends PathMotion
{
  public final Matrix mMatrix = new Matrix();
  public Path mOrigin;
  public final Path this$0 = new Path();
  
  public PatternPathMotion()
  {
    this$0.lineTo(1.0F, 0.0F);
    mOrigin = this$0;
  }
  
  public PatternPathMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActivityChooserView);
    try
    {
      paramAttributeSet = TypedArrayUtils.getValue(paramContext, (XmlPullParser)paramAttributeSet, "patternPathData", 0);
      if (paramAttributeSet != null)
      {
        draw(PathParser.toString(paramAttributeSet));
        paramContext.recycle();
        return;
      }
      throw new RuntimeException("pathData must be supplied for patternPathMotion");
    }
    catch (Throwable paramAttributeSet)
    {
      paramContext.recycle();
      throw paramAttributeSet;
    }
  }
  
  public PatternPathMotion(Path paramPath)
  {
    draw(paramPath);
  }
  
  public static float getScale(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat2 * paramFloat2 + paramFloat1 * paramFloat1);
  }
  
  public Path draw(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f = getScale(paramFloat3, paramFloat4);
    double d = Math.atan2(paramFloat4, paramFloat3);
    mMatrix.setScale(f, f);
    mMatrix.postRotate((float)Math.toDegrees(d));
    mMatrix.postTranslate(paramFloat1, paramFloat2);
    Path localPath = new Path();
    this$0.transform(mMatrix, localPath);
    return localPath;
  }
  
  public void draw(Path paramPath)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f1 = localPathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    localPathMeasure.getPosTan(f1, arrayOfFloat, null);
    float f3 = arrayOfFloat[0];
    f1 = arrayOfFloat[1];
    localPathMeasure.getPosTan(0.0F, arrayOfFloat, null);
    float f4 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    if ((f4 == f3) && (f2 == f1)) {
      throw new IllegalArgumentException("pattern must not end at the starting point");
    }
    mMatrix.setTranslate(-f4, -f2);
    f3 -= f4;
    f1 -= f2;
    f2 = 1.0F / getScale(f3, f1);
    mMatrix.postScale(f2, f2);
    double d = Math.atan2(f1, f3);
    mMatrix.postRotate((float)Math.toDegrees(-d));
    paramPath.transform(mMatrix, this$0);
    mOrigin = paramPath;
  }
  
  public Path getOrigin()
  {
    return mOrigin;
  }
}
