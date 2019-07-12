package f.libs.asm.menu;

import android.os.Build.VERSION;

public class SignatureWriter
  implements Object
{
  public SignatureWriter(ClassWriter paramClassWriter, boolean paramBoolean) {}
  
  public void a(ByteVector paramByteVector)
    throws Exception
  {
    Handler.a(paramByteVector, Build.VERSION.RELEASE, Build.VERSION.CODENAME, a);
  }
}
