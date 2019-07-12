package support.android.view.asm;

import b.b.d.a.f.a;

public class e<T>
  implements f.a<T>
{
  public final Object[] a;
  public int k;
  
  public e(int paramInt)
  {
    if (paramInt > 0)
    {
      a = new Object[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  private boolean b(Object paramObject)
  {
    int i = 0;
    while (i < k)
    {
      if (a[i] == paramObject) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public Object a()
  {
    int i = k;
    if (i > 0)
    {
      int j = i - 1;
      Object[] arrayOfObject = a;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      k = (i - 1);
      return localObject;
    }
    return null;
  }
  
  public void a(Object[] paramArrayOfObject, int paramInt)
  {
    int i = paramInt;
    if (paramInt > paramArrayOfObject.length) {
      i = paramArrayOfObject.length;
    }
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = paramArrayOfObject[paramInt];
      int j = k;
      Object[] arrayOfObject = a;
      if (j < arrayOfObject.length)
      {
        arrayOfObject[j] = localObject;
        k = (j + 1);
      }
      paramInt += 1;
    }
  }
  
  public boolean a(Object paramObject)
  {
    int i = k;
    Object[] arrayOfObject = a;
    if (i < arrayOfObject.length)
    {
      arrayOfObject[i] = paramObject;
      k = (i + 1);
      return true;
    }
    return false;
  }
}
