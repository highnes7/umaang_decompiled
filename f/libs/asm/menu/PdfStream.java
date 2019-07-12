package f.libs.asm.menu;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;

public final class PdfStream
  extends FilterOutputStream
{
  public final ByteArrayOutputStream streamBytes;
  
  public PdfStream(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    super(paramByteArrayOutputStream);
    streamBytes = paramByteArrayOutputStream;
  }
  
  public Label toPdf()
  {
    return new Label(streamBytes.toByteArray(), null);
  }
}
