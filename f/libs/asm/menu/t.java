package f.libs.asm.menu;

import java.io.FileOutputStream;
import org.json.JSONObject;

public class t
  implements f.a
{
  public t(ClassWriter paramClassWriter, String paramString1, String paramString2, long paramLong) {}
  
  public void a(FileOutputStream paramFileOutputStream)
    throws Exception
  {
    paramFileOutputStream.write(new JSONObject(new y(this)).toString().getBytes());
  }
}
