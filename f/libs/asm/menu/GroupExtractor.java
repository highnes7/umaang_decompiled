package f.libs.asm.menu;

import java.util.HashMap;
import java.util.Map;

public class GroupExtractor
  implements Path
{
  public final int lines;
  
  public GroupExtractor()
  {
    lines = 1;
  }
  
  public GroupExtractor(int paramInt)
  {
    lines = paramInt;
  }
  
  public static StackTraceElement[] extract(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[paramArrayOfStackTraceElement.length];
    int i = 0;
    int m = 0;
    int j = 1;
    while (i < paramArrayOfStackTraceElement.length)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      Integer localInteger = (Integer)localHashMap.get(localStackTraceElement);
      int k;
      if ((localInteger != null) && (get(paramArrayOfStackTraceElement, localInteger.intValue(), i)))
      {
        int i1 = i - localInteger.intValue();
        int n = m;
        k = j;
        if (j < paramInt)
        {
          System.arraycopy(paramArrayOfStackTraceElement, i, arrayOfStackTraceElement, m, i1);
          n = m + i1;
          k = j + 1;
        }
        i1 = i1 - 1 + i;
        m = n;
        j = k;
        k = i1;
      }
      else
      {
        arrayOfStackTraceElement[m] = paramArrayOfStackTraceElement[i];
        m += 1;
        k = i;
        j = 1;
      }
      localHashMap.put(localStackTraceElement, Integer.valueOf(i));
      i = k + 1;
    }
    paramArrayOfStackTraceElement = new StackTraceElement[m];
    System.arraycopy(arrayOfStackTraceElement, 0, paramArrayOfStackTraceElement, 0, paramArrayOfStackTraceElement.length);
    return paramArrayOfStackTraceElement;
  }
  
  public static boolean get(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt1, int paramInt2)
  {
    int j = paramInt2 - paramInt1;
    if (paramInt2 + j > paramArrayOfStackTraceElement.length) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!paramArrayOfStackTraceElement[(paramInt1 + i)].equals(paramArrayOfStackTraceElement[(paramInt2 + i)])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public StackTraceElement[] extract(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    StackTraceElement[] arrayOfStackTraceElement = extract(paramArrayOfStackTraceElement, lines);
    if (arrayOfStackTraceElement.length < paramArrayOfStackTraceElement.length) {
      return arrayOfStackTraceElement;
    }
    return paramArrayOfStackTraceElement;
  }
}
