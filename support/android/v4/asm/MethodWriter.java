package support.android.v4.asm;

import android.content.Context;
import android.media.session.MediaSessionManager;
import b.b.a.K;

@K(28)
public class MethodWriter
  extends ClassReader
{
  public MediaSessionManager i;
  
  public MethodWriter(Context paramContext)
  {
    super(paramContext);
    i = ((MediaSessionManager)paramContext.getSystemService("media_session"));
  }
  
  public boolean a(ea.c paramC)
  {
    if ((paramC instanceof ga.a)) {
      return i.isTrustedForMediaControl(g);
    }
    return false;
  }
}
