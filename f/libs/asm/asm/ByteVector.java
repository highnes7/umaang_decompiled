package f.libs.asm.asm;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Locale;
import java.util.Map;
import l.a.a.a.Log;
import l.a.a.a.f;

public class ByteVector
{
  public final int a;
  public boolean data;
  public final int size;
  
  public ByteVector(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a = paramInt1;
    size = paramInt2;
    data = paramBoolean;
  }
  
  private void add(RuntimeException paramRuntimeException)
  {
    if (!data)
    {
      f.get().d("Answers", "Invalid user input detected", paramRuntimeException);
      return;
    }
    throw paramRuntimeException;
  }
  
  public boolean add(Object paramObject, String paramString)
  {
    if (paramObject == null)
    {
      add(new NullPointerException(StringBuilder.toString(paramString, " must not be null")));
      return true;
    }
    return false;
  }
  
  public boolean add(Map paramMap, String paramString)
  {
    if ((paramMap.size() >= a) && (!paramMap.containsKey(paramString)))
    {
      add(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", new Object[] { Integer.valueOf(a) })));
      return true;
    }
    return false;
  }
  
  public String get(String paramString)
  {
    int i = paramString.length();
    int j = size;
    String str = paramString;
    if (i > j)
    {
      add(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", new Object[] { Integer.valueOf(j) })));
      str = paramString.substring(0, size);
    }
    return str;
  }
}
