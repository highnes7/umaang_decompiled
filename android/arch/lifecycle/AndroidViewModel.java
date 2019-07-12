package android.arch.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import support.support.asm.Track;

public class AndroidViewModel
  extends Track
{
  @SuppressLint({"StaticFieldLeak"})
  public Application application;
  
  public AndroidViewModel(Application paramApplication)
  {
    application = paramApplication;
  }
  
  public Application provideApplication()
  {
    return application;
  }
}
