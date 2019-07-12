package f.g.c.io;

import f.g.c.a.a;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@a
public final class PatternFilenameFilter
  implements FilenameFilter
{
  public final Pattern pattern;
  
  public PatternFilenameFilter(String paramString)
  {
    this(Pattern.compile(paramString));
  }
  
  public PatternFilenameFilter(Pattern paramPattern)
  {
    if (paramPattern != null)
    {
      pattern = paramPattern;
      return;
    }
    throw new NullPointerException();
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return pattern.matcher(paramString).matches();
  }
}
