package f.libs.asm.menu;

import java.io.FileOutputStream;
import org.json.JSONObject;

public class Color
  implements f.a
{
  public Color(ClassWriter paramClassWriter, boolean paramBoolean) {}
  
  public void a(FileOutputStream paramFileOutputStream)
    throws Exception
  {
    paramFileOutputStream.write(new JSONObject(new ImageButton(this)).toString().getBytes());
  }
}
