package f.libs.asm.menu;

public class PathParser
  implements Path
{
  public final Path[] data;
  public final int numCols;
  public final DetailScanner numRows;
  
  public PathParser(int paramInt, Path... paramVarArgs)
  {
    numCols = paramInt;
    data = paramVarArgs;
    numRows = new DetailScanner(paramInt);
  }
  
  public StackTraceElement[] extract(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement.length <= numCols) {
      return paramArrayOfStackTraceElement;
    }
    Path[] arrayOfPath = data;
    int j = arrayOfPath.length;
    int i = 0;
    StackTraceElement[] arrayOfStackTraceElement = paramArrayOfStackTraceElement;
    while (i < j)
    {
      Path localPath = arrayOfPath[i];
      if (arrayOfStackTraceElement.length <= numCols) {
        break;
      }
      arrayOfStackTraceElement = localPath.extract(paramArrayOfStackTraceElement);
      i += 1;
    }
    if (arrayOfStackTraceElement.length > numCols) {
      return numRows.extract(arrayOfStackTraceElement);
    }
    return arrayOfStackTraceElement;
  }
}
