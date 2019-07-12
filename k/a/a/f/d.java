package k.a.a.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.package_7.DialogFragment;
import android.support.v4.package_7.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import in.spicedigital.umang.activities.WebActivity;
import internal.view.menu.k;
import k.a.a.m.Log;
import k.a.a.m.Ma;
import org.json.JSONException;
import org.json.JSONObject;
import support.android.v4.content.ContextCompat;

public class d
  extends DialogFragment
{
  public final String H = "SetMPINDialogFragment";
  public Context a;
  public k b;
  public String i;
  
  public d() {}
  
  private void a()
  {
    Object localObject1 = a;
    try
    {
      localObject1 = new k.a.a.m.f((Context)localObject1);
      if (i != null)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("dialogData.............");
        Object localObject3 = i;
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).toString();
        localObject2 = i;
        boolean bool = ((String)localObject2).equalsIgnoreCase("");
        if (!bool)
        {
          localObject2 = i;
          localObject3 = new JSONObject((String)localObject2);
          localObject2 = ((JSONObject)localObject3).getString("id");
          Object localObject4 = k.a.a.m.f.i;
          bool = ((String)localObject2).equalsIgnoreCase(((k.a.a.m.f)localObject1).get((String)localObject4, ""));
          if (!bool)
          {
            localObject4 = a;
            Log.init((Context)localObject4, (JSONObject)localObject3, true);
            localObject3 = k.a.a.m.f.i;
            ((k.a.a.m.f)localObject1).append((String)localObject3, (String)localObject2);
            return;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      k.a.a.m.StringBuilder.append(localJSONException);
    }
  }
  
  private void a(Context paramContext, String paramString, DialogFragment paramDialogFragment)
  {
    JSONObject localJSONObject1;
    try
    {
      Ma localMa = new Ma();
      JSONObject localJSONObject2 = Log.execute(paramContext);
      localJSONObject1 = localJSONObject2;
      localJSONObject2.put("mpin", localMa.a(Log.toString(paramContext, paramString)));
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
      localJSONObject1 = null;
    }
    if (localJSONObject1 != null) {
      new k.a.a.l.List((k.a.a.i.List)new j(this, paramContext, paramDialogFragment), "https://app.umang.gov.in/umang/coreapi/ws2/smpinu2", localJSONObject1, paramContext).execute(new Object[0]);
    }
  }
  
  public static d newInstance(boolean paramBoolean, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("cancelable", paramBoolean);
    localBundle.putString("from", paramString1);
    localBundle.putString("dialogData", paramString2);
    paramString1 = new d();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    a = paramContext;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if ((a instanceof WebActivity))
    {
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("status", "false");
        paramDialogInterface.put("message", "error: user_cancel");
      }
      catch (JSONException localJSONException)
      {
        k.a.a.m.StringBuilder.append(localJSONException);
      }
      ((WebActivity)a).setTitle(paramDialogInterface.toString());
    }
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131493046, paramViewGroup, false);
    paramViewGroup = (EditText)paramLayoutInflater.findViewById(2131296743);
    paramBundle = (EditText)paramLayoutInflater.findViewById(2131296741);
    TextView localTextView1 = (TextView)paramLayoutInflater.findViewById(2131297176);
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131296540);
    TextView localTextView2 = (TextView)paramLayoutInflater.findViewById(2131297715);
    boolean bool = getArguments().getBoolean("cancelable");
    String str = getArguments().getString("from");
    i = getArguments().getString("dialogData");
    if (bool) {
      localImageView.setVisibility(0);
    } else {
      localImageView.setVisibility(8);
    }
    if ((!str.equalsIgnoreCase("account")) && (!str.equalsIgnoreCase("profile")))
    {
      if (str.equalsIgnoreCase("department"))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(getResources().getString(2131756361));
      }
      else if (str.equalsIgnoreCase("nonMandatoryDialog"))
      {
        localTextView2.setVisibility(8);
      }
      else if (str.equalsIgnoreCase("mandatoryDialog"))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(getResources().getString(2131756354));
      }
    }
    else
    {
      localTextView2.setVisibility(0);
      localTextView2.setText(getResources().getString(2131756362));
    }
    localImageView.setOnClickListener((View.OnClickListener)new d(this));
    paramLayoutInflater.findViewById(2131296934).setOnClickListener((View.OnClickListener)new e(this, paramViewGroup));
    paramLayoutInflater.findViewById(2131296933).setOnClickListener((View.OnClickListener)new f(this, paramBundle));
    localTextView1.setBackgroundColor(ContextCompat.getColor(a, 2131099721));
    paramViewGroup.addTextChangedListener((TextWatcher)new g(this, paramViewGroup, paramBundle, localTextView1));
    paramBundle.addTextChangedListener((TextWatcher)new h(this, paramViewGroup, paramBundle, localTextView1));
    localTextView1.setOnClickListener((View.OnClickListener)new i(this, paramViewGroup, paramBundle));
    return paramLayoutInflater;
  }
}
