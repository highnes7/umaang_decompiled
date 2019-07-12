package views;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class XMLException
  extends Exception
{
  public static final long serialVersionUID = 1L;
  public static final String systemID = "There were multiple errors.";
  public List<Throwable> exceptions;
  
  public XMLException(String paramString, List paramList)
  {
    super(paramString, localThrowable);
    exceptions = Collections.unmodifiableList(paramList);
  }
  
  public XMLException(String paramString, Throwable[] paramArrayOfThrowable)
  {
    this(paramString, Arrays.asList(paramArrayOfThrowable));
  }
  
  public XMLException(List paramList)
  {
    this("There were multiple errors.", paramList);
  }
  
  public List apply()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = exceptions;
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Throwable localThrowable = (Throwable)((Iterator)localObject).next();
      if ((localThrowable instanceof Exception)) {
        localArrayList.add((Exception)localThrowable);
      } else {
        localArrayList.add(new Exception(localThrowable));
      }
    }
    return localArrayList;
  }
  
  public List getException()
  {
    return exceptions;
  }
  
  public Throwable[] getThrowables()
  {
    List localList = exceptions;
    return (Throwable[])localList.toArray(new Throwable[localList.size()]);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    Iterator localIterator = exceptions.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      Throwable localThrowable = (Throwable)localIterator.next();
      paramPrintStream.append("\n");
      paramPrintStream.append("  Inner throwable #");
      i += 1;
      paramPrintStream.append(Integer.toString(i));
      paramPrintStream.append(": ");
      localThrowable.printStackTrace(paramPrintStream);
      paramPrintStream.append("\n");
    }
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    Iterator localIterator = exceptions.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      Throwable localThrowable = (Throwable)localIterator.next();
      paramPrintWriter.append("\n");
      paramPrintWriter.append("  Inner throwable #");
      i += 1;
      paramPrintWriter.append(Integer.toString(i));
      paramPrintWriter.append(": ");
      localThrowable.printStackTrace(paramPrintWriter);
      paramPrintWriter.append("\n");
    }
  }
}
