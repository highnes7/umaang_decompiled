package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import internal.view.menu.k;
import java.util.ArrayList;
import k.a.a.a.Uq;
import k.a.a.a.Vq;
import k.a.a.a.Wq;
import k.a.a.a.Xq;
import k.a.a.a.Yq;
import k.a.a.a.Zq;
import k.a.a.a._q;
import k.a.a.a.ar;
import k.a.a.a.cr;
import k.a.a.a.dr;
import k.a.a.a.er;
import k.a.a.c.H;
import k.a.a.c.n;
import k.a.a.c.w;
import k.a.a.e.System;
import k.a.a.i.List;
import k.a.a.l.o;
import k.a.a.m.Log;
import k.a.a.m.f;
import org.json.JSONObject;

public class SettingScreen
  extends BaseActivity
{
  public ArrayList<n> A;
  public TextView B;
  public String TAG = "SettingScreen";
  public ImageView a;
  public TextView b;
  public LinearLayout c;
  public LinearLayout d;
  public ImageView data;
  public System e;
  public f f;
  public View g;
  public ArrayList<H> h;
  public View i;
  public ArrayList<String> j;
  public View k;
  public LinearLayout l;
  public ArrayList<w> m;
  public k mPopup;
  public ArrayList<String> n;
  public TextView name;
  public LinearLayout o;
  public LinearLayout p;
  public TextView q;
  public TextView r;
  public View root;
  public LinearLayout t;
  public Toolbar this$0;
  public TextView tv;
  public View u;
  public View v;
  public LinearLayout z;
  
  public SettingScreen() {}
  
  private void a()
  {
    f = new f(this);
    e = System.getInstance(this);
    a = ((ImageView)findViewById(2131297761));
    c = ((LinearLayout)findViewById(2131297199));
    o = ((LinearLayout)findViewById(2131297573));
    l = ((LinearLayout)findViewById(2131296958));
    z = ((LinearLayout)findViewById(2131297389));
    d = ((LinearLayout)findViewById(2131296601));
    p = ((LinearLayout)findViewById(2131296814));
    t = ((LinearLayout)findViewById(2131296296));
    r = ((TextView)findViewById(2131297204));
    q = ((TextView)findViewById(2131296960));
    tv = ((TextView)findViewById(2131297391));
    b = ((TextView)findViewById(2131296602));
    B = ((TextView)findViewById(2131296815));
    i = findViewById(2131297390);
    k = findViewById(2131298000);
    v = findViewById(2131298001);
    u = findViewById(2131298002);
    g = findViewById(2131298003);
    if (f.get(f.this$0, "").isEmpty())
    {
      d.setVisibility(8);
      o.setVisibility(8);
      c.setVisibility(8);
      t.setVisibility(8);
      data.setVisibility(8);
      k.setVisibility(8);
      v.setVisibility(8);
      u.setVisibility(8);
      g.setVisibility(8);
    }
    m = new ArrayList();
    n = Log.read(this);
    j = Log.parse();
    Object localObject1 = f.get(f.c, "en");
    int i1 = 0;
    while (i1 < j.size())
    {
      localObject2 = new w();
      ((w)localObject2).c((String)j.get(i1));
      ((w)localObject2).a((String)n.get(i1));
      if (((String)j.get(i1)).equalsIgnoreCase((String)localObject1))
      {
        ((w)localObject2).a(true);
        q.setText((CharSequence)n.get(i1));
      }
      else
      {
        ((w)localObject2).a(false);
      }
      m.add(localObject2);
      i1 += 1;
    }
    if (f.get(f.a, "normal").equalsIgnoreCase("small")) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131756385, B);
    } else if (f.get(f.a, "normal").equalsIgnoreCase("normal")) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131756019, B);
    } else {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755857, B);
    }
    localObject1 = getResources().getStringArray(2130903065);
    Object localObject2 = getResources().getStringArray(2130903064);
    h = new ArrayList();
    i1 = 0;
    while (i1 < localObject1.length)
    {
      H localH = new H();
      localH.a(localObject2[i1]);
      localH.b(localObject1[i1]);
      if (f.get(f.f, "").equalsIgnoreCase(localObject2[i1])) {
        localH.b(true);
      } else {
        localH.b(false);
      }
      h.add(localH);
      i1 += 1;
    }
    localObject1 = f.get(f.f, "");
    if (!((String)localObject1).equalsIgnoreCase("")) {
      tv.setText(Log.get(this, (String)localObject1));
    } else {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131756018, tv);
    }
    b();
  }
  
  private void b()
  {
    A = new ArrayList();
    Object localObject2 = f.get(f.left, "");
    z.setVisibility(8);
    i.setVisibility(8);
    if (!((String)localObject2).equalsIgnoreCase(""))
    {
      Object localObject1 = f;
      Object localObject3 = f.e;
      try
      {
        localObject1 = ((f)localObject1).get((String)localObject3, "home");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("defaultTab.....................");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).toString();
        localObject2 = ((String)localObject2).split(",");
        int i1 = 0;
        while (i1 < localObject2.length)
        {
          localObject3 = localObject2[i1];
          Object localObject4 = ((String)localObject3).split("\\|");
          localObject3 = new n();
          Object localObject5 = localObject4[0];
          ((n)localObject3).c((String)localObject5);
          localObject5 = localObject4[1];
          ((n)localObject3).b((String)localObject5);
          if (localObject4.length > 2)
          {
            localObject5 = localObject4[2];
            ((n)localObject3).a((String)localObject5);
          }
          else
          {
            ((n)localObject3).a("");
          }
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("tab id..............");
          String str2 = localObject4[1];
          ((StringBuilder)localObject5).append(str2);
          ((StringBuilder)localObject5).toString();
          localObject5 = localObject4[1];
          bool = ((String)localObject5).equalsIgnoreCase((String)localObject1);
          if (bool)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("selected tab.....................");
            str2 = localObject4[1];
            ((StringBuilder)localObject5).append(str2);
            ((StringBuilder)localObject5).toString();
            ((n)localObject3).a(true);
            localObject5 = b;
            localObject4 = localObject4[0];
            ((TextView)localObject5).setText((CharSequence)localObject4);
          }
          else
          {
            ((n)localObject3).a(false);
          }
          localObject4 = A;
          ((ArrayList)localObject4).add(localObject3);
          i1 += 1;
        }
        localObject1 = b;
        boolean bool = ((TextView)localObject1).getText().toString().trim().equalsIgnoreCase("");
        if (!bool) {
          return;
        }
        localObject1 = localObject2[0];
        localObject1 = ((String)localObject1).split("\\|");
        localObject2 = b;
        localObject3 = localObject1[0];
        ((TextView)localObject2).setText((CharSequence)localObject3);
        localObject2 = f;
        localObject3 = f.e;
        localObject1 = localObject1[1];
        ((f)localObject2).append((String)localObject3, (String)localObject1);
        localObject1 = A;
        localObject1 = ((ArrayList)localObject1).get(0);
        localObject1 = (n)localObject1;
        ((n)localObject1).a(true);
        return;
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append((Exception)localException);
        return;
      }
    }
    String str1 = f.get(f.e, "home");
    localObject2 = new n();
    ((n)localObject2).c(getResources().getString(2131755815));
    ((n)localObject2).b("home");
    ((n)localObject2).a("");
    if (str1.equalsIgnoreCase("home"))
    {
      ((n)localObject2).a(true);
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755815, b);
    }
    else
    {
      ((n)localObject2).a(false);
    }
    A.add(localObject2);
    localObject2 = new n();
    ((n)localObject2).c(getResources().getString(2131755716));
    ((n)localObject2).b("fav");
    ((n)localObject2).a("");
    if (str1.equalsIgnoreCase("fav"))
    {
      ((n)localObject2).a(true);
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755716, b);
    }
    else
    {
      ((n)localObject2).a(false);
    }
    A.add(localObject2);
    localObject2 = new n();
    ((n)localObject2).c(getResources().getString(2131755260));
    ((n)localObject2).b("allservices");
    ((n)localObject2).a("");
    if (str1.equalsIgnoreCase("allservices"))
    {
      ((n)localObject2).a(true);
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755260, b);
    }
    else
    {
      ((n)localObject2).a(false);
    }
    A.add(localObject2);
    if (b.getText().toString().trim().equalsIgnoreCase(""))
    {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755815, b);
      f.append(f.e, "home");
      ((n)A.get(0)).a(true);
    }
  }
  
  private void close()
  {
    if (f.get(f.this$0, "").isEmpty()) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.startActivity(this, InfoHomeScreen.class);
    } else {
      f.sufficientlysecure.rootcommands.util.StringBuilder.startActivity(this, MainActivity.class);
    }
    finish();
  }
  
  private void parse(String paramString)
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      localJSONObject3.remove("lang");
      localJSONObject3.put("lang", paramString);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      ((AsyncTask)new o((List)new Vq(this, paramString), localJSONObject2, this)).execute(new Object[0]);
    }
  }
  
  private void show()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493039);
    localDialog.setCancelable(true);
    ((ListView)localDialog.findViewById(2131297009)).setAdapter((ListAdapter)new SettingScreen.a(this, h));
    ((TextView)localDialog.findViewById(2131296672)).setOnClickListener((View.OnClickListener)new er(this, localDialog));
    localDialog.setOnCancelListener((DialogInterface.OnCancelListener)new Uq(this));
    localDialog.show();
  }
  
  public void onBackPressed()
  {
    close();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this$0 = ((Toolbar)f.sufficientlysecure.rootcommands.util.StringBuilder.getView(this, 2131493238, this, "Setting Screen", 2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, this$0, true);
    root = this$0.getRootView();
    name = ((TextView)root.findViewById(2131297758));
    f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131756363, name);
    data = ((ImageView)root.findViewById(2131296872));
    data.setOnClickListener((View.OnClickListener)new Wq(this));
    a();
    if (f.get(f.d, "true").equalsIgnoreCase("true")) {
      a.setImageResource(2131231477);
    } else {
      a.setImageResource(2131231475);
    }
    if ((getIntent().getStringExtra("showRegionDialog") != null) && (getIntent().getStringExtra("showRegionDialog").equalsIgnoreCase("true"))) {
      show();
    }
    try
    {
      paramBundle = getIntent().getStringExtra("notifId");
      if (paramBundle != null)
      {
        System localSystem = e;
        localSystem.set(paramBundle);
        Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    a.setOnClickListener((View.OnClickListener)new Xq(this));
    c.setOnClickListener((View.OnClickListener)new Yq(this));
    l.setOnClickListener((View.OnClickListener)new Zq(this));
    z.setOnClickListener((View.OnClickListener)new _q(this));
    d.setOnClickListener((View.OnClickListener)new ar(this));
    p.setOnClickListener((View.OnClickListener)new cr(this));
    t.setOnClickListener((View.OnClickListener)new dr(this));
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    try
    {
      paramIntent = getIntent().getStringExtra("notifId");
      if (paramIntent != null)
      {
        System localSystem = e;
        localSystem.set(paramIntent);
        Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
        return;
      }
    }
    catch (Exception paramIntent)
    {
      k.a.a.m.StringBuilder.append(paramIntent);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      close();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onResume()
  {
    super.onResume();
    if (f.get(f.queue, "true").equalsIgnoreCase("true"))
    {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755649, r);
      return;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755588, r);
  }
}
