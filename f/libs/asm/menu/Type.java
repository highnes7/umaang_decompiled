package f.libs.asm.menu;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

public final class Type
{
  public static final FilenameFilter d = new TrueFileFilter();
  
  public Type() {}
  
  public static int a(File paramFile, int paramInt, Comparator paramComparator)
  {
    return a(paramFile, d, paramInt, paramComparator);
  }
  
  public static int a(File paramFile, FilenameFilter paramFilenameFilter, int paramInt, Comparator paramComparator)
  {
    paramFile = paramFile.listFiles(paramFilenameFilter);
    int i = 0;
    if (paramFile == null) {
      return 0;
    }
    int j = paramFile.length;
    Arrays.sort(paramFile, paramComparator);
    int k = paramFile.length;
    while (i < k)
    {
      paramFilenameFilter = paramFile[i];
      if (j <= paramInt) {
        return j;
      }
      paramFilenameFilter.delete();
      j -= 1;
      i += 1;
    }
    return j;
  }
}
