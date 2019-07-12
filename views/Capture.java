package views;

public class Capture<T>
{
  public T value;
  
  public Capture() {}
  
  public Capture(Object paramObject)
  {
    value = paramObject;
  }
  
  public Object get()
  {
    return value;
  }
  
  public void set(Object paramObject)
  {
    value = paramObject;
  }
}
