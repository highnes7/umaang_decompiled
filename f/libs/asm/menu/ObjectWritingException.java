package f.libs.asm.menu;

import java.io.IOException;

public class ObjectWritingException
  extends IOException
{
  public static final long serialVersionUID = -6947486886997889499L;
  
  public ObjectWritingException()
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.");
  }
}
