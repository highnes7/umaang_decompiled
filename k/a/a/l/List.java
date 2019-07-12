package k.a.a.l;

import android.content.Context;
import android.os.AsyncTask;
import k.a.a.m.a;
import org.json.JSONObject;

public class List
  extends AsyncTask<Object, Object, Object>
{
  public Context a;
  public JSONObject data;
  public String first = "RequestAsyncTask";
  public k.a.a.i.List start = null;
  public String width;
  
  public List(k.a.a.i.List paramList, String paramString, JSONObject paramJSONObject, Context paramContext)
  {
    start = paramList;
    data = paramJSONObject;
    width = paramString;
    a = paramContext;
  }
  
  public Object doInBackground(Object... paramVarArgs)
  {
    return a.d(width, data.toString(), a);
  }
  
  public void onPostExecute(Object paramObject)
  {
    if (paramObject != null)
    {
      String str = (String)paramObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("=============");
      localStringBuilder.append(str);
      localStringBuilder.toString();
      if (str.equalsIgnoreCase("90001"))
      {
        start.forceLogout();
        return;
      }
      if (str.equalsIgnoreCase("90003"))
      {
        start.underMaintenance();
        return;
      }
      if (str.equalsIgnoreCase("90002"))
      {
        start.showNetworkError();
        return;
      }
      start.processFinish(paramObject);
      return;
    }
    start.processFinish(paramObject);
  }
  
  public void onPreExecute()
  {
    start.processStart();
  }
}
