package f.libs.asm.menu;

import org.json.JSONException;
import org.json.JSONObject;

public final class GridView
  extends JSONObject
{
  public GridView(Item paramItem)
    throws JSONException
  {
    put("userId", h.c);
    put("userName", h.b);
    put("userEmail", h.d);
  }
}
