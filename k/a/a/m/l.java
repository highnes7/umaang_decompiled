package k.a.a.m;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  implements View.OnClickListener
{
  public l(Dialog paramDialog, Context paramContext, String paramString) {}
  
  public void onClick(View paramView)
  {
    d.dismiss();
    paramView = a;
    try
    {
      paramView = new f(paramView);
      if (b != null)
      {
        String str = b;
        boolean bool = str.equalsIgnoreCase("");
        if (!bool)
        {
          str = b;
          Object localObject1 = new JSONObject(str);
          str = ((JSONObject)localObject1).getString("id");
          Object localObject2 = f.i;
          bool = str.equalsIgnoreCase(paramView.get((String)localObject2, ""));
          if (!bool)
          {
            localObject2 = a;
            Log.init((Context)localObject2, (JSONObject)localObject1, true);
            localObject1 = f.i;
            paramView.append((String)localObject1, str);
            return;
          }
        }
      }
    }
    catch (JSONException paramView)
    {
      StringBuilder.append(paramView);
    }
  }
}
