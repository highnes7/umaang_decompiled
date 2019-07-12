package support.android.v4.asm;

import android.content.Context;
import b.b.a.K;

@K(21)
public class ClassReader
  extends Label
{
  public ClassReader(Context paramContext)
  {
    super(paramContext);
    mContext = paramContext;
  }
  
  private boolean b(ea.c paramC)
  {
    return getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", paramC.b(), paramC.getUid()) == 0;
  }
  
  public boolean a(ea.c paramC)
  {
    return (b(paramC)) || (super.a(paramC));
  }
}
