package k.a.a.l;

import android.os.AsyncTask;
import k.a.a.i.List;
import k.a.a.m.a;
import org.json.JSONObject;

public class LoaderTask
  extends AsyncTask<Object, Object, Object>
{
  public JSONObject data;
  public List url = null;
  public String width = "ChatInitTask";
  
  public LoaderTask(List paramList, JSONObject paramJSONObject)
  {
    url = paramList;
    data = paramJSONObject;
  }
  
  public Object doInBackground(Object... paramVarArgs)
  {
    return a.a("https://reporting.umang.gov.in/AgentCallDistribution/customer/chat", data.toString());
  }
  
  public void onPostExecute(Object paramObject)
  {
    if (paramObject != null)
    {
      String str = (String)paramObject;
      if (str.equalsIgnoreCase("90001"))
      {
        url.forceLogout();
        return;
      }
      if (str.equalsIgnoreCase("90003"))
      {
        url.underMaintenance();
        return;
      }
      if (str.equalsIgnoreCase("90002"))
      {
        url.showNetworkError();
        return;
      }
      url.processFinish(paramObject);
      return;
    }
    url.processFinish(paramObject);
  }
  
  public void onPreExecute()
  {
    url.processStart();
  }
}
