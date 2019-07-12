package android.support.v7.view.menu;

public class BaseWrapper<T>
{
  public final T mWrappedObject;
  
  public BaseWrapper(Object paramObject)
  {
    if (paramObject != null)
    {
      mWrappedObject = paramObject;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public Object getWrappedObject()
  {
    return mWrappedObject;
  }
}
