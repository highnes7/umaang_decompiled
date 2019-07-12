package f.libs.asm.menu;

import java.io.FileOutputStream;
import org.json.JSONObject;

public class Widget
  implements f.a
{
  public Widget(ClassWriter paramClassWriter, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void a(FileOutputStream paramFileOutputStream)
    throws Exception
  {
    paramFileOutputStream.write(new JSONObject(new LineAndPointFormatter(this)).toString().getBytes());
  }
}
