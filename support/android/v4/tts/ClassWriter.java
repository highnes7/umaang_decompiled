package support.android.v4.tts;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Handler;

public final class ClassWriter
  implements Runnable
{
  public ClassWriter(Context paramContext, h paramH, Handler paramHandler, i paramI) {}
  
  public void run()
  {
    Object localObject = c;
    h localH = e;
    try
    {
      localObject = Frame.a((Context)localObject, null, localH);
      int i;
      if (((ClassReader)localObject).a() != 0)
      {
        i = ((ClassReader)localObject).a();
        if (i != 1)
        {
          if (i != 2)
          {
            a.post(new LogFileParser.1(this));
            return;
          }
          a.post(new UpdateTimeUtil.UpdateTimeThread.1(this));
          return;
        }
        a.post(new InstallerGUI.5.1(this));
        return;
      }
      localObject = ((ClassReader)localObject).b();
      if ((localObject != null) && (localObject.length != 0))
      {
        int j = localObject.length;
        i = 0;
        while (i < j)
        {
          localH = localObject[i];
          if (localH.c() != 0)
          {
            i = localH.c();
            if (i < 0)
            {
              a.post(new InstallerGUI.10.4(this));
              return;
            }
            a.post(new InstallerGUI.10.3(this, i));
            return;
          }
          i += 1;
        }
        localObject = Frame.a(c, null, (Label[])localObject);
        if (localObject == null)
        {
          a.post(new InstallerGUI.11.3(this));
          return;
        }
        a.post(new NumberPicker.BeginSoftInputOnLongPressCommand(this, (Typeface)localObject));
        return;
      }
      a.post(new SplashScreen.5.1(this));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    a.post(new LoggingReceiver.Slurper(this));
  }
}
