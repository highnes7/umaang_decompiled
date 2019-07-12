package support.support.asm;

import android.arch.lifecycle.LiveData;

public class Log<T>
  extends LiveData<T>
{
  public Log() {}
  
  public void postValue(Object paramObject)
  {
    super.postValue(paramObject);
  }
  
  public void setValue(Object paramObject)
  {
    super.setValue(paramObject);
  }
}
