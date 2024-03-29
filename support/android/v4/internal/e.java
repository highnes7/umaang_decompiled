package support.android.v4.internal;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class e
{
  public e() {}
  
  public static Collection a(Path paramPath)
  {
    return a(paramPath, 0.5F);
  }
  
  public static Collection a(Path paramPath, float paramFloat)
  {
    paramPath = paramPath.approximate(paramFloat);
    int j = paramPath.length / 3;
    ArrayList localArrayList = new ArrayList(j);
    int i = 1;
    while (i < j)
    {
      int k = i * 3;
      int m = (i - 1) * 3;
      paramFloat = paramPath[k];
      float f1 = paramPath[(k + 1)];
      float f2 = paramPath[(k + 2)];
      float f3 = paramPath[m];
      float f4 = paramPath[(m + 1)];
      float f5 = paramPath[(m + 2)];
      if ((paramFloat != f3) && ((f1 != f4) || (f2 != f5))) {
        localArrayList.add(new Handle(new PointF(f4, f5), f3, new PointF(f1, f2), paramFloat));
      }
      i += 1;
    }
    return localArrayList;
  }
}
