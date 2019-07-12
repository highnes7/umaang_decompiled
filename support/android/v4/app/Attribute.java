package support.android.v4.app;

import java.util.Locale;

public class Attribute
  implements Method
{
  public h a = new h(new Locale[0]);
  
  public Attribute() {}
  
  public void a(Locale... paramVarArgs)
  {
    a = new h(paramVarArgs);
  }
  
  public String equals()
  {
    return a.f();
  }
  
  public boolean equals(Object paramObject)
  {
    return a.equals(((Label)paramObject).getName());
  }
  
  public Object getValue()
  {
    return a;
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public boolean isEmpty()
  {
    return a.d();
  }
  
  public int size()
  {
    return a.g();
  }
  
  public int toString(Locale paramLocale)
  {
    return a.a(paramLocale);
  }
  
  public String toString()
  {
    return a.toString();
  }
  
  public Locale toString(int paramInt)
  {
    return a.getTitle(paramInt);
  }
  
  public Locale toString(String[] paramArrayOfString)
  {
    h localH = a;
    if (localH != null) {
      return localH.read(paramArrayOfString);
    }
    return null;
  }
}
