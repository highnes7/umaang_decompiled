package f.libs.asm.menu;

public class DetailScanner
  implements Path
{
  public final int type;
  
  public DetailScanner(int paramInt)
  {
    type = paramInt;
  }
  
  public StackTraceElement[] extract(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    int j = paramArrayOfStackTraceElement.length;
    int i = type;
    if (j <= i) {
      return paramArrayOfStackTraceElement;
    }
    j = i / 2;
    int k = i - j;
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[i];
    System.arraycopy(paramArrayOfStackTraceElement, 0, arrayOfStackTraceElement, 0, k);
    System.arraycopy(paramArrayOfStackTraceElement, paramArrayOfStackTraceElement.length - j, arrayOfStackTraceElement, k, j);
    return arrayOfStackTraceElement;
  }
}
