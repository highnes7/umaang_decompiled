package support.android.v4.internal.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.InputStream;

public final class DavPropertyName
{
  public static final String SOURCE = "RoundedBitmapDrawableFa";
  
  public DavPropertyName() {}
  
  public static RoundedBitmapDrawable create(Resources paramResources, Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new RoundedBitmapDrawable21(paramResources, paramBitmap);
    }
    return new RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable(paramResources, paramBitmap);
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, InputStream paramInputStream)
  {
    paramResources = create(paramResources, BitmapFactory.decodeStream(paramInputStream));
    if (paramResources.getBitmap() == null) {
      StringBuilder.append("RoundedBitmapDrawable cannot decode ", paramInputStream);
    }
    return paramResources;
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, String paramString)
  {
    paramResources = create(paramResources, BitmapFactory.decodeFile(paramString));
    if (paramResources.getBitmap() == null) {
      StringBuilder.get("RoundedBitmapDrawable cannot decode ", paramString);
    }
    return paramResources;
  }
}
