package f.g.org.org.codehaus.libs.objectweb.asm.asm;

import f.g.b.a.e.a.a.a.a.b;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

@b
public class f
{
  public final String d;
  
  public f(f paramF)
  {
    d = d;
  }
  
  public f(String paramString)
  {
    if (paramString != null)
    {
      d = paramString;
      return;
    }
    throw new NullPointerException();
  }
  
  public static f a(char paramChar)
  {
    return new f(String.valueOf(paramChar));
  }
  
  public static f f(String paramString)
  {
    return new f(paramString);
  }
  
  public static Iterable get(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null) {
      return new ClassWriter(paramArrayOfObject, paramObject1, paramObject2);
    }
    throw new NullPointerException();
  }
  
  public d a(String paramString)
  {
    return new d(this, paramString);
  }
  
  public f a()
  {
    return new p(this, this);
  }
  
  public Appendable a(Appendable paramAppendable, Iterator paramIterator)
    throws IOException
  {
    if (paramAppendable != null)
    {
      if (paramIterator.hasNext())
      {
        paramAppendable.append(a(paramIterator.next()));
        while (paramIterator.hasNext())
        {
          paramAppendable.append(d);
          paramAppendable.append(a(paramIterator.next()));
        }
      }
      return paramAppendable;
    }
    paramAppendable = new NullPointerException();
    throw paramAppendable;
    return paramAppendable;
  }
  
  public CharSequence a(Object paramObject)
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
  
  public final String a(Object paramObject1, Object paramObject2, Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return toString(new ClassWriter(paramVarArgs, paramObject1, paramObject2));
    }
    throw new NullPointerException();
  }
  
  public final String a(Object[] paramArrayOfObject)
  {
    return toString(Arrays.asList(paramArrayOfObject));
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Object paramObject1, Object paramObject2, Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return format(paramStringBuilder, new ClassWriter(paramVarArgs, paramObject1, paramObject2));
    }
    throw new NullPointerException();
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    return format(paramStringBuilder, Arrays.asList(paramArrayOfObject));
  }
  
  public Appendable appendTo(Appendable paramAppendable, Iterable paramIterable)
    throws IOException
  {
    return a(paramAppendable, paramIterable.iterator());
  }
  
  public final Appendable appendTo(Appendable paramAppendable, Object paramObject1, Object paramObject2, Object... paramVarArgs)
    throws IOException
  {
    if (paramVarArgs != null) {
      return appendTo(paramAppendable, new ClassWriter(paramVarArgs, paramObject1, paramObject2));
    }
    throw new NullPointerException();
  }
  
  public final Appendable appendTo(Appendable paramAppendable, Object[] paramArrayOfObject)
    throws IOException
  {
    return appendTo(paramAppendable, Arrays.asList(paramArrayOfObject));
  }
  
  public f c(String paramString)
  {
    if (paramString != null) {
      return new a(this, this, paramString);
    }
    throw new NullPointerException();
  }
  
  public final Appendable d(Appendable paramAppendable, Object paramObject)
    throws IOException
  {
    return a(paramAppendable, (Iterator)paramObject);
  }
  
  public final String f(Object paramObject)
  {
    return f((Iterator)paramObject);
  }
  
  public final String f(Iterator paramIterator)
  {
    return toString(new StringBuilder(), paramIterator).toString();
  }
  
  public final StringBuilder format(StringBuilder paramStringBuilder, Iterable paramIterable)
  {
    return toString(paramStringBuilder, paramIterable.iterator());
  }
  
  public final StringBuilder strip(StringBuilder paramStringBuilder, Object paramObject)
  {
    return toString(paramStringBuilder, (Iterator)paramObject);
  }
  
  public final String toString(Iterable paramIterable)
  {
    return f(paramIterable.iterator());
  }
  
  public final StringBuilder toString(StringBuilder paramStringBuilder, Iterator paramIterator)
  {
    try
    {
      a(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    }
    catch (IOException paramStringBuilder)
    {
      throw new AssertionError(paramStringBuilder);
    }
  }
}
