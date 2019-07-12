package support.android.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.PointerIcon;

public final class ByteVector
{
  public static final int CLASS_LOCATION_CONVERTER = 1002;
  public static final int DATA_OK = 1008;
  public static final int GRID_BRISK = 1011;
  public static final int GRID_DENSE = 1010;
  public static final int GRID_MSER = 1006;
  public static final int GRID_SIMPLEBLOB = 1009;
  public static final int MASK = 1020;
  public static final int SMB_FS_FULL_SIZE_INFORMATION = 1007;
  public static final int TAG_COLOR_TRANSFER_FUNCTIONS = 1016;
  public static final int TAG_DUOTONE_HALFTONING_INFORMATION = 1014;
  public static final int TAG_DUOTONE_IMAGE_INFORMATION = 1018;
  public static final int TAG_DUOTONE_TRANSFER_FUNCTIONS = 1017;
  public static final int TAG_EFFECTIVE_BLACK_AND_WHITE_VALUES = 1019;
  public static final int TAG_EPS_OPTIONS = 1021;
  public static final int TAG_GRAYSCALE_AND_MULTICHANNEL_HALFTONING_INFORMATION = 1012;
  public static final int TRANSITION_TIME = 1000;
  public static final int UTF_16 = 1015;
  public static final int a = 1013;
  public static final int b = 1000;
  public static final int blockSize = 1003;
  public static final int length = 1004;
  public static final int n = 0;
  public static final int size = 1001;
  public Object data;
  
  public ByteVector(Object paramObject)
  {
    data = paramObject;
  }
  
  public static ByteVector a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ByteVector(PointerIcon.getSystemIcon(paramContext, paramInt));
    }
    return new ByteVector(null);
  }
  
  public static ByteVector a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ByteVector(PointerIcon.create(paramBitmap, paramFloat1, paramFloat2));
    }
    return new ByteVector(null);
  }
  
  public static ByteVector read(Resources paramResources, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ByteVector(PointerIcon.load(paramResources, paramInt));
    }
    return new ByteVector(null);
  }
  
  public Object read()
  {
    return data;
  }
}
