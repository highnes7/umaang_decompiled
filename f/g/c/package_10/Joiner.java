package f.g.c.package_10;

import f.g.c.a.b;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@b
public class Joiner
{
  public final String separator;
  
  public Joiner(Joiner paramJoiner)
  {
    separator = separator;
  }
  
  public Joiner(String paramString)
  {
    if (paramString != null)
    {
      separator = paramString;
      return;
    }
    throw new NullPointerException();
  }
  
  public static Iterable get(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null) {
      return new UnmodifiableLazyStringList(paramArrayOfObject, paramObject1, paramObject2);
    }
    throw new NullPointerException();
  }
  
  public static Joiner on(char paramChar)
  {
    return new Joiner(String.valueOf(paramChar));
  }
  
  public static Joiner on(String paramString)
  {
    return new Joiner(paramString);
  }
  
  public Appendable appendTo(Appendable paramAppendable, Iterable paramIterable)
    throws IOException
  {
    return appendTo(paramAppendable, paramIterable.iterator());
  }
  
  public final Appendable appendTo(Appendable paramAppendable, Object paramObject)
    throws IOException
  {
    return appendTo(paramAppendable, (Iterator)paramObject);
  }
  
  public final Appendable appendTo(Appendable paramAppendable, Object paramObject1, Object paramObject2, Object... paramVarArgs)
    throws IOException
  {
    if (paramVarArgs != null) {
      return appendTo(paramAppendable, new UnmodifiableLazyStringList(paramVarArgs, paramObject1, paramObject2));
    }
    throw new NullPointerException();
  }
  
  public Appendable appendTo(Appendable paramAppendable, Iterator paramIterator)
    throws IOException
  {
    if (paramAppendable != null)
    {
      if (paramIterator.hasNext())
      {
        paramAppendable.append(toString(paramIterator.next()));
        while (paramIterator.hasNext())
        {
          paramAppendable.append(separator);
          paramAppendable.append(toString(paramIterator.next()));
        }
      }
      return paramAppendable;
    }
    paramAppendable = new NullPointerException();
    throw paramAppendable;
    return paramAppendable;
  }
  
  public final Appendable appendTo(Appendable paramAppendable, Object[] paramArrayOfObject)
    throws IOException
  {
    return appendTo(paramAppendable, Arrays.asList(paramArrayOfObject));
  }
  
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable paramIterable)
  {
    return appendTo(paramStringBuilder, paramIterable.iterator());
  }
  
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Object paramObject)
  {
    return appendTo(paramStringBuilder, (Iterator)paramObject);
  }
  
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Object paramObject1, Object paramObject2, Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return appendTo(paramStringBuilder, new UnmodifiableLazyStringList(paramVarArgs, paramObject1, paramObject2));
    }
    throw new NullPointerException();
  }
  
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterator paramIterator)
  {
    try
    {
      appendTo(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    }
    catch (IOException paramStringBuilder)
    {
      throw new AssertionError(paramStringBuilder);
    }
  }
  
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    return appendTo(paramStringBuilder, Arrays.asList(paramArrayOfObject));
  }
  
  public final String join(Iterable paramIterable)
  {
    return join(paramIterable.iterator());
  }
  
  public final String join(Object paramObject)
  {
    return join((Iterator)paramObject);
  }
  
  public final String join(Object paramObject1, Object paramObject2, Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return join(new UnmodifiableLazyStringList(paramVarArgs, paramObject1, paramObject2));
    }
    throw new NullPointerException();
  }
  
  public final String join(Iterator paramIterator)
  {
    return appendTo(new StringBuilder(), paramIterator).toString();
  }
  
  public final String join(Object[] paramArrayOfObject)
  {
    return join(Arrays.asList(paramArrayOfObject));
  }
  
  public Joiner skipNulls()
  {
    return new Joiner.2(this, this);
  }
  
  public CharSequence toString(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof CharSequence)) {
        return (CharSequence)paramObject;
      }
      return paramObject.toString();
    }
    throw new NullPointerException();
  }
  
  public Joiner useForNull(String paramString)
  {
    if (paramString != null) {
      return new Joiner.1(this, this, paramString);
    }
    throw new NullPointerException();
  }
  
  public MapJoiner withKeyValueSeparator(String paramString)
  {
    return new MapJoiner(paramString);
  }
  
  public final class MapJoiner
  {
    public final String keyValueSeparator;
    
    public MapJoiner(String paramString)
    {
      if (paramString != null)
      {
        keyValueSeparator = paramString;
        return;
      }
      throw new NullPointerException();
    }
    
    public Appendable appendTo(Appendable paramAppendable, Iterable paramIterable)
      throws IOException
    {
      return appendTo(paramAppendable, paramIterable.iterator());
    }
    
    public Appendable appendTo(Appendable paramAppendable, Object paramObject)
      throws IOException
    {
      return appendTo(paramAppendable, (Iterator)paramObject);
    }
    
    public Appendable appendTo(Appendable paramAppendable, Iterator paramIterator)
      throws IOException
    {
      if (paramAppendable != null)
      {
        if (paramIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramIterator.next();
          paramAppendable.append(toString(localEntry.getKey()));
          paramAppendable.append(keyValueSeparator);
          paramAppendable.append(toString(localEntry.getValue()));
          while (paramIterator.hasNext())
          {
            paramAppendable.append(separator);
            localEntry = (Map.Entry)paramIterator.next();
            paramAppendable.append(toString(localEntry.getKey()));
            paramAppendable.append(keyValueSeparator);
            paramAppendable.append(toString(localEntry.getValue()));
          }
        }
        return paramAppendable;
      }
      paramAppendable = new NullPointerException();
      throw paramAppendable;
      return paramAppendable;
    }
    
    public Appendable appendTo(Appendable paramAppendable, Map paramMap)
      throws IOException
    {
      return appendTo(paramAppendable, paramMap.entrySet());
    }
    
    public StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable paramIterable)
    {
      return appendTo(paramStringBuilder, paramIterable.iterator());
    }
    
    public StringBuilder appendTo(StringBuilder paramStringBuilder, Object paramObject)
      throws IOException
    {
      return appendTo(paramStringBuilder, (Iterator)paramObject);
    }
    
    public StringBuilder appendTo(StringBuilder paramStringBuilder, Iterator paramIterator)
    {
      try
      {
        appendTo(paramStringBuilder, paramIterator);
        return paramStringBuilder;
      }
      catch (IOException paramStringBuilder)
      {
        throw new AssertionError(paramStringBuilder);
      }
    }
    
    public StringBuilder appendTo(StringBuilder paramStringBuilder, Map paramMap)
    {
      return appendTo(paramStringBuilder, paramMap.entrySet());
    }
    
    public String join(Iterable paramIterable)
    {
      return join(paramIterable.iterator());
    }
    
    public String join(Object paramObject)
      throws IOException
    {
      return join((Iterator)paramObject);
    }
    
    public String join(Iterator paramIterator)
    {
      return appendTo(new StringBuilder(), paramIterator).toString();
    }
    
    public String join(Map paramMap)
    {
      return join(paramMap.entrySet());
    }
    
    public MapJoiner useForNull(String paramString)
    {
      return new MapJoiner(useForNull(paramString), keyValueSeparator);
    }
  }
}
