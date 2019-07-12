package f.g.c.io;

import java.io.IOException;

public abstract interface InputSupplier<T>
{
  public abstract Object getInput()
    throws IOException;
}
