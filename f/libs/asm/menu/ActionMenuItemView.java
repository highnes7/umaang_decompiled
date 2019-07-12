package f.libs.asm.menu;

import android.app.Activity;
import l.a.a.a.Item;
import l.a.a.a.Log;

public final class ActionMenuItemView
  implements Qa.d
{
  public final l.a.a.a.a.g.f c;
  public final ImageLoader.Task e;
  public final Item g;
  
  public ActionMenuItemView(Item paramItem, ImageLoader.Task paramTask, l.a.a.a.a.g.f paramF)
  {
    g = paramItem;
    e = paramTask;
    c = paramF;
  }
  
  public boolean a()
  {
    Activity localActivity = g.e().add();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      Object localObject = new MockHttpClient.1(this);
      localObject = d.a(localActivity, c, (Sequence)localObject);
      localActivity.runOnUiThread(new SMTPAppenderBase.SenderRunnable(this, (d)localObject));
      l.a.a.a.f.get().d("CrashlyticsCore", "Waiting for user opt-in.");
      ((d)localObject).c();
      return ((d)localObject).a();
    }
    return true;
  }
}
