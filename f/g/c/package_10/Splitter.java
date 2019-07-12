package f.g.c.package_10;

import f.g.c.a.b;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@b(emulated=true)
public final class Splitter
{
  public final int limit;
  public final boolean omitEmptyStrings;
  public final ua.c strategy;
  public final h trimmer;
  
  public Splitter(ua.c paramC)
  {
    strategy = paramC;
    omitEmptyStrings = false;
    trimmer = localH;
    limit = Integer.MAX_VALUE;
  }
  
  public Splitter(ua.c paramC, boolean paramBoolean, h paramH, int paramInt)
  {
    strategy = paramC;
    omitEmptyStrings = paramBoolean;
    trimmer = paramH;
    limit = paramInt;
  }
  
  public static Splitter fixedLength(int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "The length may not be less than 1");
    return new Splitter(new Splitter.4(paramInt));
  }
  
  public static Splitter on(char paramChar)
  {
    return on(h.is(paramChar));
  }
  
  public static Splitter on(h paramH)
  {
    if (paramH != null) {
      return new Splitter(new j(paramH));
    }
    throw new NullPointerException();
  }
  
  public static Splitter on(String paramString)
  {
    boolean bool;
    if (paramString.length() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "The separator may not be the empty string.");
    return new Splitter(new Label(paramString));
  }
  
  public static Splitter on(Pattern paramPattern)
  {
    if (paramPattern != null)
    {
      Preconditions.checkArgument(paramPattern.matcher("").matches() ^ true, "The pattern may not match the empty string: %s", new Object[] { paramPattern });
      return new Splitter(new Splitter.3(paramPattern));
    }
    throw new NullPointerException();
  }
  
  public static Splitter onPattern(String paramString)
  {
    return on(Pattern.compile(paramString));
  }
  
  private Iterator splittingIterator(CharSequence paramCharSequence)
  {
    return strategy.iterator(this, paramCharSequence);
  }
  
  public Splitter limit(int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "must be greater than zero: %s", new Object[] { Integer.valueOf(paramInt) });
    return new Splitter(strategy, omitEmptyStrings, trimmer, paramInt);
  }
  
  public Splitter omitEmptyStrings()
  {
    return new Splitter(strategy, true, trimmer, limit);
  }
  
  public Iterable split(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return new Splitter.5(this, paramCharSequence);
    }
    throw new NullPointerException();
  }
  
  public Splitter trimResults()
  {
    return trimResults(h.WHITESPACE);
  }
  
  public Splitter trimResults(h paramH)
  {
    if (paramH != null) {
      return new Splitter(strategy, omitEmptyStrings, paramH, limit);
    }
    throw new NullPointerException();
  }
  
  public ua.a withKeyValueSeparator(Splitter paramSplitter)
  {
    return new ua.a(this, paramSplitter);
  }
  
  public ua.a withKeyValueSeparator(String paramString)
  {
    return withKeyValueSeparator(on(paramString));
  }
}
