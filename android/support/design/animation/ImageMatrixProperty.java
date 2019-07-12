package android.support.design.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class ImageMatrixProperty
  extends Property<ImageView, Matrix>
{
  public final Matrix matrix = new Matrix();
  
  public ImageMatrixProperty()
  {
    super(Matrix.class, "imageMatrixProperty");
  }
  
  public Matrix get(ImageView paramImageView)
  {
    matrix.set(paramImageView.getImageMatrix());
    return matrix;
  }
  
  public void into(ImageView paramImageView, Matrix paramMatrix)
  {
    paramImageView.setImageMatrix(paramMatrix);
  }
}
