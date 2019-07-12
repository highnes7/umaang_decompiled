package support.android.asm;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class n
{
  public n() {}
  
  public static g a(ViewGroup paramViewGroup)
  {
    int i = Build.VERSION.SDK_INT;
    return new o(paramViewGroup);
  }
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    MethodWriter.a(paramViewGroup, paramBoolean);
  }
}
