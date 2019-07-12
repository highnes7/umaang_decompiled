package in.spicedigital.umang.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import k.a.a.a.mf;
import k.a.a.a.nf;
import k.a.a.i.List;
import k.a.a.l.o;
import k.a.a.m.Log;
import k.a.a.m.StringBuilder;
import k.a.a.m.f;
import org.json.JSONObject;

public class DowntimeScreen
  extends BaseActivity
{
  public final String SAVEFILE = "DowntimeScreen";
  public Button disableButton;
  public ProgressBar loadingBar;
  public f updater;
  
  public DowntimeScreen() {}
  
  private void cancel()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = Log.execute(this);
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      ((AsyncTask)new o((List)new nf(this), localJSONObject2, this)).execute(new Object[0]);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493067);
    updater = new f(this);
    disableButton = ((Button)findViewById(2131297431));
    loadingBar = ((ProgressBar)findViewById(2131297314));
    disableButton.setOnClickListener((View.OnClickListener)new mf(this));
  }
  
  public void onResume()
  {
    super.onResume();
    cancel();
  }
}
