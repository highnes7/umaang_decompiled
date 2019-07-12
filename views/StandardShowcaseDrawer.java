package views;

import android.net.Uri;
import d.d;
import d.o;
import org.json.JSONArray;

public class StandardShowcaseDrawer
  implements o<JSONArray, d>
{
  public StandardShowcaseDrawer(Task.3 param3, Uri paramUri) {}
  
  public Project then(Task paramTask)
    throws Exception
  {
    return Task.3.onPostExecute(Task.3.parse((JSONArray)paramTask.getResult()), a);
  }
}
