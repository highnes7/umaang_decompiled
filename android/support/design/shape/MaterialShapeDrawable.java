package android.support.design.shape;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.design.internal.Experimental;
import b.b.a.G;
import support.android.v4.internal.drawable.DrawableCompat.DrawableImpl;

@Experimental("The shapes API is currently experimental and subject to change")
public class MaterialShapeDrawable
  extends Drawable
  implements DrawableCompat.DrawableImpl
{
  public int alpha;
  public final ShapePath[] cornerPaths = new ShapePath[4];
  public final Matrix[] cornerTransforms = new Matrix[4];
  public final Matrix[] edgeTransforms = new Matrix[4];
  public float interpolation;
  public final Matrix matrix = new Matrix();
  public final Paint paint = new Paint();
  public Paint.Style paintStyle;
  public final Path path = new Path();
  public final PointF pointF = new PointF();
  public float scale;
  public final float[] scratch = new float[2];
  public final float[] scratch2 = new float[2];
  public final Region scratchRegion = new Region();
  public int shadowColor;
  public int shadowElevation;
  public boolean shadowEnabled;
  public int shadowRadius;
  public final ShapePath shapePath = new ShapePath();
  @G
  public ShapePathModel shapedViewModel = null;
  public float strokeWidth;
  @G
  public PorterDuffColorFilter tintFilter;
  public ColorStateList tintList;
  public PorterDuff.Mode tintMode;
  public final Region transparentRegion = new Region();
  public boolean useTintColorForShadow;
  
  public MaterialShapeDrawable()
  {
    this(null);
  }
  
  public MaterialShapeDrawable(ShapePathModel paramShapePathModel)
  {
    int i = 0;
    shadowEnabled = false;
    useTintColorForShadow = false;
    interpolation = 1.0F;
    shadowColor = -16777216;
    shadowElevation = 5;
    shadowRadius = 10;
    alpha = 255;
    scale = 1.0F;
    strokeWidth = 0.0F;
    paintStyle = Paint.Style.FILL_AND_STROKE;
    tintMode = PorterDuff.Mode.SRC_IN;
    tintList = null;
    shapedViewModel = paramShapePathModel;
    while (i < 4)
    {
      cornerTransforms[i] = new Matrix();
      edgeTransforms[i] = new Matrix();
      cornerPaths[i] = new ShapePath();
      i += 1;
    }
  }
  
  private float angleOfCorner(int paramInt1, int paramInt2, int paramInt3)
  {
    getCoordinatesOfCorner((paramInt1 - 1 + 4) % 4, paramInt2, paramInt3, pointF);
    PointF localPointF = pointF;
    float f1 = x;
    float f2 = y;
    getCoordinatesOfCorner((paramInt1 + 1) % 4, paramInt2, paramInt3, localPointF);
    localPointF = pointF;
    float f3 = x;
    float f4 = y;
    getCoordinatesOfCorner(paramInt1, paramInt2, paramInt3, localPointF);
    localPointF = pointF;
    float f5 = x;
    float f6 = y;
    f2 = (float)Math.atan2(f2 - f6, f1 - f5) - (float)Math.atan2(f4 - f6, f3 - f5);
    f1 = f2;
    if (f2 < 0.0F)
    {
      double d = f2;
      Double.isNaN(d);
      f1 = (float)(d + 6.283185307179586D);
    }
    return f1;
  }
  
  private float angleOfEdge(int paramInt1, int paramInt2, int paramInt3)
  {
    getCoordinatesOfCorner(paramInt1, paramInt2, paramInt3, pointF);
    PointF localPointF = pointF;
    float f1 = x;
    float f2 = y;
    getCoordinatesOfCorner((paramInt1 + 1) % 4, paramInt2, paramInt3, localPointF);
    localPointF = pointF;
    float f3 = x;
    return (float)Math.atan2(y - f2, f3 - f1);
  }
  
  private void appendCornerPath(int paramInt, Path paramPath)
  {
    float[] arrayOfFloat = scratch;
    ShapePath[] arrayOfShapePath = cornerPaths;
    arrayOfFloat[0] = startX;
    arrayOfFloat[1] = startY;
    cornerTransforms[paramInt].mapPoints(arrayOfFloat);
    if (paramInt == 0)
    {
      arrayOfFloat = scratch;
      paramPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    else
    {
      arrayOfFloat = scratch;
      paramPath.lineTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    cornerPaths[paramInt].applyToPath(cornerTransforms[paramInt], paramPath);
  }
  
  private void appendEdgePath(int paramInt, Path paramPath)
  {
    int i = (paramInt + 1) % 4;
    float[] arrayOfFloat = scratch;
    Object localObject = cornerPaths;
    arrayOfFloat[0] = endX;
    arrayOfFloat[1] = endY;
    cornerTransforms[paramInt].mapPoints(arrayOfFloat);
    arrayOfFloat = scratch2;
    localObject = cornerPaths;
    arrayOfFloat[0] = startX;
    arrayOfFloat[1] = startY;
    cornerTransforms[i].mapPoints(arrayOfFloat);
    arrayOfFloat = scratch;
    float f = arrayOfFloat[0];
    localObject = scratch2;
    f = (float)Math.hypot(f - localObject[0], arrayOfFloat[1] - localObject[1]);
    shapePath.reset(0.0F, 0.0F);
    getEdgeTreatmentForIndex(paramInt).getEdgePath(f, interpolation, shapePath);
    shapePath.applyToPath(edgeTransforms[paramInt], paramPath);
  }
  
  private void getCoordinatesOfCorner(int paramInt1, int paramInt2, int paramInt3, PointF paramPointF)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          paramPointF.set(0.0F, 0.0F);
          return;
        }
        paramPointF.set(0.0F, paramInt3);
        return;
      }
      paramPointF.set(paramInt2, paramInt3);
      return;
    }
    paramPointF.set(paramInt2, 0.0F);
  }
  
  private CornerTreatment getCornerTreatmentForIndex(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return shapedViewModel.getTopLeftCorner();
        }
        return shapedViewModel.getBottomLeftCorner();
      }
      return shapedViewModel.getBottomRightCorner();
    }
    return shapedViewModel.getTopRightCorner();
  }
  
  private EdgeTreatment getEdgeTreatmentForIndex(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return shapedViewModel.getTopEdge();
        }
        return shapedViewModel.getLeftEdge();
      }
      return shapedViewModel.getBottomEdge();
    }
    return shapedViewModel.getRightEdge();
  }
  
  private void getPath(int paramInt1, int paramInt2, Path paramPath)
  {
    getPathForSize(paramInt1, paramInt2, paramPath);
    if (scale == 1.0F) {
      return;
    }
    matrix.reset();
    Matrix localMatrix = matrix;
    float f = scale;
    localMatrix.setScale(f, f, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(matrix);
  }
  
  public static int modulateAlpha(int paramInt1, int paramInt2)
  {
    return (paramInt2 + (paramInt2 >>> 7)) * paramInt1 >>> 8;
  }
  
  private void setCornerPathAndTransform(int paramInt1, int paramInt2, int paramInt3)
  {
    getCoordinatesOfCorner(paramInt1, paramInt2, paramInt3, pointF);
    float f = angleOfCorner(paramInt1, paramInt2, paramInt3);
    getCornerTreatmentForIndex(paramInt1).getCornerPath(f, interpolation, cornerPaths[paramInt1]);
    f = angleOfEdge((paramInt1 - 1 + 4) % 4, paramInt2, paramInt3);
    cornerTransforms[paramInt1].reset();
    Matrix localMatrix = cornerTransforms[paramInt1];
    PointF localPointF = pointF;
    localMatrix.setTranslate(x, y);
    cornerTransforms[paramInt1].preRotate((float)Math.toDegrees(f + 1.5707964F));
  }
  
  private void setEdgeTransform(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = scratch;
    Object localObject2 = cornerPaths;
    localObject1[0] = endX;
    localObject1[1] = endY;
    cornerTransforms[paramInt1].mapPoints((float[])localObject1);
    float f = angleOfEdge(paramInt1, paramInt2, paramInt3);
    edgeTransforms[paramInt1].reset();
    localObject1 = edgeTransforms[paramInt1];
    localObject2 = scratch;
    ((Matrix)localObject1).setTranslate(localObject2[0], localObject2[1]);
    edgeTransforms[paramInt1].preRotate((float)Math.toDegrees(f));
  }
  
  private void updateTintFilter()
  {
    ColorStateList localColorStateList = tintList;
    if ((localColorStateList != null) && (tintMode != null))
    {
      int i = localColorStateList.getColorForState(getState(), 0);
      tintFilter = new PorterDuffColorFilter(i, tintMode);
      if (useTintColorForShadow) {
        shadowColor = i;
      }
    }
    else
    {
      tintFilter = null;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    paint.setColorFilter(tintFilter);
    int i = paint.getAlpha();
    paint.setAlpha(modulateAlpha(i, alpha));
    paint.setStrokeWidth(strokeWidth);
    paint.setStyle(paintStyle);
    int j = shadowElevation;
    if ((j > 0) && (shadowEnabled)) {
      paint.setShadowLayer(shadowRadius, 0.0F, j, shadowColor);
    }
    if (shapedViewModel != null)
    {
      getPath(paramCanvas.getWidth(), paramCanvas.getHeight(), path);
      paramCanvas.drawPath(path, paint);
    }
    else
    {
      paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), paint);
    }
    paint.setAlpha(i);
  }
  
  public float getInterpolation()
  {
    return interpolation;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public Paint.Style getPaintStyle()
  {
    return paintStyle;
  }
  
  public void getPathForSize(int paramInt1, int paramInt2, Path paramPath)
  {
    paramPath.rewind();
    if (shapedViewModel == null) {
      return;
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 4) {
        break;
      }
      setCornerPathAndTransform(i, paramInt1, paramInt2);
      setEdgeTransform(i, paramInt1, paramInt2);
      i += 1;
    }
    while (j < 4)
    {
      appendCornerPath(j, paramPath);
      appendEdgePath(j, paramPath);
      j += 1;
    }
    paramPath.close();
  }
  
  public float getScale()
  {
    return scale;
  }
  
  public int getShadowElevation()
  {
    return shadowElevation;
  }
  
  public int getShadowRadius()
  {
    return shadowRadius;
  }
  
  public ShapePathModel getShapedViewModel()
  {
    return shapedViewModel;
  }
  
  public float getStrokeWidth()
  {
    return strokeWidth;
  }
  
  public ColorStateList getTintList()
  {
    return tintList;
  }
  
  public Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    transparentRegion.set(localRect);
    getPath(localRect.width(), localRect.height(), path);
    scratchRegion.setPath(path, transparentRegion);
    transparentRegion.op(scratchRegion, Region.Op.DIFFERENCE);
    return transparentRegion;
  }
  
  public boolean isPointInTransparentRegion(int paramInt1, int paramInt2)
  {
    return getTransparentRegion().contains(paramInt1, paramInt2);
  }
  
  public boolean isShadowEnabled()
  {
    return shadowEnabled;
  }
  
  public void setAlpha(int paramInt)
  {
    alpha = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    paint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setInterpolation(float paramFloat)
  {
    interpolation = paramFloat;
    invalidateSelf();
  }
  
  public void setPaintStyle(Paint.Style paramStyle)
  {
    paintStyle = paramStyle;
    invalidateSelf();
  }
  
  public void setScale(float paramFloat)
  {
    scale = paramFloat;
    invalidateSelf();
  }
  
  public void setShadowColor(int paramInt)
  {
    shadowColor = paramInt;
    useTintColorForShadow = false;
    invalidateSelf();
  }
  
  public void setShadowElevation(int paramInt)
  {
    shadowElevation = paramInt;
    invalidateSelf();
  }
  
  public void setShadowEnabled(boolean paramBoolean)
  {
    shadowEnabled = paramBoolean;
    invalidateSelf();
  }
  
  public void setShadowRadius(int paramInt)
  {
    shadowRadius = paramInt;
    invalidateSelf();
  }
  
  public void setShapedViewModel(ShapePathModel paramShapePathModel)
  {
    shapedViewModel = paramShapePathModel;
    invalidateSelf();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    strokeWidth = paramFloat;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    tintList = paramColorStateList;
    updateTintFilter();
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    tintMode = paramMode;
    updateTintFilter();
    invalidateSelf();
  }
  
  public void setUseTintColorForShadow(boolean paramBoolean)
  {
    useTintColorForShadow = paramBoolean;
    invalidateSelf();
  }
}
