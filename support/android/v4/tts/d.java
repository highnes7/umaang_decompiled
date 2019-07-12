package support.android.v4.tts;

import android.os.Handler;
import b.b.x.l.r.e;
import b.b.x.l.x.a;
import support.android.v4.content.asm.Label;

public final class d
  implements x.a<r.e>
{
  public d(Label paramLabel, Handler paramHandler) {}
  
  public void b(m paramM)
  {
    if (paramM == null)
    {
      i.callbackFailAsync(1, f);
      return;
    }
    int j = f;
    if (j == 0)
    {
      i.callbackSuccessAsync(t, f);
      return;
    }
    i.callbackFailAsync(j, f);
  }
}
