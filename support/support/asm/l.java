package support.support.asm;

import android.arch.lifecycle.LiveData;
import support.support.v7.app.Path;

public class l
{
  public l() {}
  
  public static LiveData a(LiveData paramLiveData, Path paramPath)
  {
    i localI = new i();
    localI.d(paramLiveData, new MessageListFragment.1(localI, paramPath));
    return localI;
  }
  
  public static LiveData onDismiss(LiveData paramLiveData, Path paramPath)
  {
    i localI = new i();
    localI.d(paramLiveData, new MainActivity.1(paramPath, localI));
    return localI;
  }
}
