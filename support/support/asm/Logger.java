package support.support.asm;

import android.arch.lifecycle.LiveData;
import b.a.b.s;

public class Logger<V>
  implements s<V>
{
  public final s<V> f;
  public int mItemCount = -1;
  public final LiveData<V> this$0;
  
  public Logger(LiveData paramLiveData, Observer paramObserver)
  {
    this$0 = paramLiveData;
    f = paramObserver;
  }
  
  public void fatal()
  {
    this$0.observeForever(this);
  }
  
  public void log()
  {
    this$0.removeObserver(this);
  }
  
  public void onChanged(Object paramObject)
  {
    if (mItemCount != this$0.getVersion())
    {
      mItemCount = this$0.getVersion();
      f.onChanged(paramObject);
    }
  }
}
