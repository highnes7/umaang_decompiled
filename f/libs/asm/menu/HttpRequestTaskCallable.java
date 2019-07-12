package f.libs.asm.menu;

import java.util.concurrent.Callable;

public class HttpRequestTaskCallable
  implements Callable<Void>
{
  public HttpRequestTaskCallable(ClassWriter paramClassWriter) {}
  
  public Void call()
    throws Exception
  {
    ClassWriter.put(responseHandler);
    return null;
  }
}
