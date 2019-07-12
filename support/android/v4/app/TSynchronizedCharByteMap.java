package support.android.v4.app;

import android.os.LocaleList;
import b.b.a.K;
import java.util.Locale;

@K(24)
public class TSynchronizedCharByteMap
  implements Method
{
  public LocaleList values = new LocaleList(new Locale[0]);
  
  public TSynchronizedCharByteMap() {}
  
  public void a(Locale... paramVarArgs)
  {
    values = new LocaleList(paramVarArgs);
  }
  
  public String equals()
  {
    return values.toLanguageTags();
  }
  
  public boolean equals(Object paramObject)
  {
    return values.equals(((Label)paramObject).getName());
  }
  
  public Object getValue()
  {
    return values;
  }
  
  public int hashCode()
  {
    return values.hashCode();
  }
  
  public boolean isEmpty()
  {
    return values.isEmpty();
  }
  
  public int size()
  {
    return values.size();
  }
  
  public int toString(Locale paramLocale)
  {
    return values.indexOf(paramLocale);
  }
  
  public String toString()
  {
    return values.toString();
  }
  
  public Locale toString(int paramInt)
  {
    return values.get(paramInt);
  }
  
  public Locale toString(String[] paramArrayOfString)
  {
    LocaleList localLocaleList = values;
    if (localLocaleList != null) {
      return localLocaleList.getFirstMatch(paramArrayOfString);
    }
    return null;
  }
}
