package f.g.org.org.codehaus.libs.objectweb.asm.asm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class d
{
  public final String a;
  public final f d;
  
  public d(f paramF, String paramString)
  {
    d = paramF;
    if (paramString != null)
    {
      a = paramString;
      return;
    }
    throw new NullPointerException();
  }
  
  public d a(String paramString)
  {
    return new d(d.c(paramString), a);
  }
  
  public Appendable a(Appendable paramAppendable, Iterable paramIterable)
    throws IOException
  {
    return b(paramAppendable, paramIterable.iterator());
  }
  
  public String a(Object paramObject)
    throws IOException
  {
    return c((Iterator)paramObject);
  }
  
  public Appendable b(Appendable paramAppendable, Iterator paramIterator)
    throws IOException
  {
    if (paramAppendable != null)
    {
      if (paramIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramIterator.next();
        paramAppendable.append(d.a(localEntry.getKey()));
        paramAppendable.append(a);
        paramAppendable.append(d.a(localEntry.getValue()));
        while (paramIterator.hasNext())
        {
          paramAppendable.append(d.d);
          localEntry = (Map.Entry)paramIterator.next();
          paramAppendable.append(d.a(localEntry.getKey()));
          paramAppendable.append(a);
          paramAppendable.append(d.a(localEntry.getValue()));
        }
      }
      return paramAppendable;
    }
    paramAppendable = new NullPointerException();
    throw paramAppendable;
    return paramAppendable;
  }
  
  public Appendable b(Appendable paramAppendable, Map paramMap)
    throws IOException
  {
    return a(paramAppendable, paramMap.entrySet());
  }
  
  public String b(Map paramMap)
  {
    return c(paramMap.entrySet());
  }
  
  public StringBuilder b(StringBuilder paramStringBuilder, Map paramMap)
  {
    return format(paramStringBuilder, paramMap.entrySet());
  }
  
  public String c(Iterable paramIterable)
  {
    return c(paramIterable.iterator());
  }
  
  public String c(Iterator paramIterator)
  {
    return toString(new StringBuilder(), paramIterator).toString();
  }
  
  public Appendable d(Appendable paramAppendable, Object paramObject)
    throws IOException
  {
    return b(paramAppendable, (Iterator)paramObject);
  }
  
  public StringBuilder format(StringBuilder paramStringBuilder, Iterable paramIterable)
  {
    return toString(paramStringBuilder, paramIterable.iterator());
  }
  
  public StringBuilder strip(StringBuilder paramStringBuilder, Object paramObject)
    throws IOException
  {
    return toString(paramStringBuilder, (Iterator)paramObject);
  }
  
  public StringBuilder toString(StringBuilder paramStringBuilder, Iterator paramIterator)
  {
    try
    {
      b(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    }
    catch (IOException paramStringBuilder)
    {
      throw new AssertionError(paramStringBuilder);
    }
  }
}
