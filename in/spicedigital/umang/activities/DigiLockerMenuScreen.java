package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import internal.view.menu.k;
import java.util.concurrent.Executor;
import k.a.a.a.hd;
import k.a.a.a.id;
import k.a.a.a.jd;
import k.a.a.a.kd;
import k.a.a.a.ld;
import k.a.a.a.md;
import k.a.a.a.nd;
import k.a.a.a.od;
import k.a.a.a.qd;
import k.a.a.a.rd;
import k.a.a.i.List;
import k.a.a.l.v;
import k.a.a.m.Log;
import k.a.a.m.f;
import org.json.JSONObject;

public class DigiLockerMenuScreen
  extends BaseActivity
{
  public static int mainActivity;
  public final String SAVEFILE = "DigiLockerMenuScreen";
  public LinearLayout cancelButton;
  public LinearLayout confirmButton;
  public View context;
  public String data;
  public TextView dateItineraire;
  public Button defaultButton;
  public String dirPath;
  public Button disableButton;
  public LinearLayout doneButton;
  public TextView heureItineraire;
  public String l;
  public TextView logs;
  public LinearLayout mHeader;
  public k mPopup;
  public String mSearchString;
  public String ownerName;
  public String path;
  public String repoName;
  public Toolbar this$0;
  public String time;
  public String type;
  public f utils;
  public String value;
  public String z;
  
  public DigiLockerMenuScreen() {}
  
  private void loadData(String paramString)
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject = Log.execute(this);
      localObject = localJSONObject;
      localJSONObject.put("flow", paramString);
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
      localObject = null;
    }
    if (localObject != null)
    {
      paramString = new v((List)new qd(this), "https://app.umang.gov.in/umang/modsapi/digilockerNew/ws1/initauth", (JSONObject)localObject, this);
      localObject = AsyncTask.THREAD_POOL_EXECUTOR;
      ((AsyncTask)paramString).executeOnExecutor((Executor)localObject, new Object[0]);
    }
  }
  
  private void onCreate()
  {
    disableButton = ((Button)findViewById(2131296652));
    defaultButton = ((Button)findViewById(2131296579));
    confirmButton = ((LinearLayout)findViewById(2131296770));
    cancelButton = ((LinearLayout)findViewById(2131296295));
    doneButton = ((LinearLayout)findViewById(2131296569));
    dateItineraire = ((TextView)findViewById(2131296820));
    heureItineraire = ((TextView)findViewById(2131296819));
    mHeader = ((LinearLayout)findViewById(2131296821));
  }
  
  private void showDialog(String paramString)
  {
    Dialog localDialog = new Dialog(this);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493020);
    localDialog.setCancelable(true);
    localDialog.setCanceledOnTouchOutside(false);
    localDialog.show();
    TextView localTextView = (TextView)localDialog.findViewById(2131297214);
    ((TextView)localDialog.findViewById(2131296456)).setOnClickListener((View.OnClickListener)new rd(this, localDialog));
    localTextView.setOnClickListener((View.OnClickListener)new hd(this, paramString, localDialog));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" // ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.toString();
    int i = mainActivity;
    if ((paramInt1 == i) && (paramInt2 == i))
    {
      paramIntent = f.sufficientlysecure.rootcommands.util.StringBuilder.append("in Activity Result ");
      paramIntent.append(utils.get(f.mainActivity, ""));
      paramIntent.toString();
      return;
    }
    if (paramInt1 == 2050)
    {
      if (paramInt2 == -1) {
        setResult(-1, paramIntent);
      } else {
        setResult(0);
      }
      finish();
      return;
    }
    if (paramInt1 == 2051)
    {
      if (paramInt2 == -1)
      {
        setResult(-1);
        finish();
      }
    }
    else if (paramInt1 == 2052)
    {
      if (paramInt2 == -1) {
        setResult(-1);
      }
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493055);
    this$0 = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, this$0, true);
    context = this$0.getRootView();
    logs = ((TextView)context.findViewById(2131297758));
    logs.setText(getResources().getString(2131755577));
    ownerName = getIntent().getStringExtra("intentType");
    repoName = getIntent().getStringExtra("intentValue");
    dirPath = getIntent().getStringExtra("deptID");
    time = getIntent().getStringExtra("servID");
    mSearchString = getIntent().getStringExtra("subsID");
    if (ownerName == null)
    {
      ownerName = "";
      repoName = "";
      dirPath = "0";
      time = "0";
      mSearchString = "0";
    }
    utils = new f(this);
    onCreate();
    paramBundle = utils.get(f.res, "");
    value = "";
    type = "";
    path = "";
    data = "";
    if (!paramBundle.equalsIgnoreCase(""))
    {
      paramBundle = paramBundle.split("\\|");
      value = paramBundle[0];
      type = paramBundle[1];
      path = paramBundle[2];
      data = paramBundle[3];
    }
    else
    {
      value = "true";
      path = "true";
    }
    paramBundle = utils.get(f.current, "");
    Object localObject = utils.get(f.header, "");
    try
    {
      boolean bool = paramBundle.equalsIgnoreCase("");
      if (!bool)
      {
        paramBundle = paramBundle.split("\\|");
        localObject = ((String)localObject).split("\\|");
        LinearLayout localLinearLayout = paramBundle[1];
        bool = localLinearLayout.equalsIgnoreCase("true");
        if (bool)
        {
          localLinearLayout = mHeader;
          localLinearLayout.setVisibility(0);
          l = paramBundle[0];
          z = localObject[0];
        }
        else
        {
          paramBundle = mHeader;
          paramBundle.setVisibility(8);
        }
      }
      else
      {
        paramBundle = mHeader;
        paramBundle.setVisibility(8);
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    dateItineraire.setOnClickListener((View.OnClickListener)new id(this));
    heureItineraire.setOnClickListener((View.OnClickListener)new jd(this));
    disableButton.setOnClickListener((View.OnClickListener)new kd(this));
    defaultButton.setOnClickListener((View.OnClickListener)new ld(this));
    confirmButton.setOnClickListener((View.OnClickListener)new md(this));
    cancelButton.setOnClickListener((View.OnClickListener)new nd(this));
    doneButton.setOnClickListener((View.OnClickListener)new od(this));
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}
