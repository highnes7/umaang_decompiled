package support.android.v4.util;

import android.os.Build.VERSION;
import java.util.Objects;

public class LatLong
{
  public LatLong() {}
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    int i = Build.VERSION.SDK_INT;
    return Objects.equals(paramObject1, paramObject2);
  }
  
  public static int hashCode(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    int i = Build.VERSION.SDK_INT;
    return Objects.hash(paramVarArgs);
  }
}
