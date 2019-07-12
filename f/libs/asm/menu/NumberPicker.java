package f.libs.asm.menu;

import java.io.FileOutputStream;
import java.util.Map;
import org.json.JSONObject;

public class NumberPicker
  implements f.a
{
  public NumberPicker(ClassWriter paramClassWriter, int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map paramMap, int paramInt3) {}
  
  public void a(FileOutputStream paramFileOutputStream)
    throws Exception
  {
    paramFileOutputStream.write(new JSONObject(new XYRegionFormatter(this)).toString().getBytes());
  }
}
