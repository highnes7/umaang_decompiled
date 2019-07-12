package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.b;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import f.l.a.b.ClassWriter;
import java.util.ArrayList;
import k.a.a.a.b;
import k.a.a.a.c;
import k.a.a.a.e;
import k.a.a.a.i;
import k.a.a.a.j;
import k.a.a.a.l;
import k.a.a.a.m;
import k.a.a.a.n;
import k.a.a.a.o;
import k.a.a.a.p;
import k.a.a.a.q;
import k.a.a.a.r;
import k.a.a.a.s;
import k.a.a.m.Log;
import k.a.a.m.Ma;
import org.json.JSONObject;
import support.android.v4.content.ContextCompat;

public class AadhaarProfileScreen
  extends BaseActivity
{
  public TextView a;
  public TextView b;
  public TextView c;
  public LinearLayout content;
  public ImageView context;
  public String d = "";
  public LinearLayout data;
  public TextView e;
  public LinearLayout emptyView;
  public TextView endDate;
  public String f = "AadhaarProfileScreen";
  public ImageView fab;
  public TextView g;
  public boolean h = false;
  public TextView i;
  public ImageView image;
  public f.l.a.b.f.a j = new k.a.a.a.d(this);
  public boolean k = false;
  public k.a.a.m.System l;
  public TextView lblDescription;
  public TextView lblTitle;
  public NestedScrollView listView;
  public LinearLayout mAdapter;
  public ImageView mFindButton;
  public LinearLayout mMenu;
  public PopupWindow mPopup;
  public LinearLayout mPresenter;
  public LinearLayout mView;
  public TextView minutes;
  public internal.view.menu.k n;
  public TextView outputView;
  public TextView p;
  public View paint;
  public k.a.a.m.f parent;
  public TextView path;
  public int points = 2001;
  public f.l.a.b.f r;
  public LinearLayout recyclerView;
  public ClassWriter s;
  public TextView searchText;
  public TextView startDate;
  public ImageView status;
  public TextView statusText;
  public SwipeRefreshLayout swipeRefreshLayout;
  public TextView t;
  public TextView textSize;
  public Toolbar this$0;
  public TextView tvDate;
  public TextView tvTime;
  public TextView type;
  public TextView weiter;
  public TextView year;
  
  public AadhaarProfileScreen() {}
  
  private void a()
  {
    Object localObject1 = l;
    try
    {
      localObject1 = ((k.a.a.m.System)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = swipeRefreshLayout;
        Object localObject2 = new e(this);
        localObject2 = (Runnable)localObject2;
        ((View)localObject1).post((Runnable)localObject2);
        localObject1 = swipeRefreshLayout;
        localObject2 = new k.a.a.a.f(this);
        localObject2 = (SwipeRefreshLayout.b)localObject2;
        ((SwipeRefreshLayout)localObject1).setOnRefreshListener((SwipeRefreshLayout.b)localObject2);
        localObject1 = swipeRefreshLayout;
        ((SwipeRefreshLayout)localObject1).setColorSchemeResources(new int[] { 2131099718, 2131099953 });
        localObject1 = status;
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = image;
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = data;
        ((View)localObject1).setVisibility(8);
        localObject1 = listView;
        ((View)localObject1).setVisibility(0);
        localObject1 = swipeRefreshLayout;
        ((View)localObject1).setVisibility(0);
        localObject1 = l;
        localObject1 = ((k.a.a.m.System)localObject1).a();
        localObject2 = ((k.a.a.c.a)localObject1).h();
        Object localObject4 = ((k.a.a.c.a)localObject1).h();
        d = ((String)localObject4);
        int i1 = ((String)localObject2).length();
        if (i1 == 12)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("XXXXXXXX");
          ((StringBuilder)localObject4).append(((String)localObject2).substring(8));
          localObject2 = ((StringBuilder)localObject4).toString();
          i1 = ((String)localObject2).length();
          int i2 = ((String)localObject2).length();
          localObject4 = new char[i1 + i2 / 4];
          int i4 = ((String)localObject2).length();
          i2 = 0;
          i1 = 0;
          for (;;)
          {
            int i3 = ((String)localObject2).length();
            if (i2 >= i3) {
              break;
            }
            i3 = i1;
            if (i2 % 4 == i4 % 4)
            {
              i3 = i1;
              if (i2 != 0)
              {
                localObject4[i1] = 45;
                i3 = i1 + 1;
              }
            }
            int m = ((String)localObject2).charAt(i2);
            localObject4[i3] = m;
            i1 = i3 + 1;
            i2 += 1;
          }
          localObject2 = new String((char[])localObject4);
          localObject4 = b;
          ((TextView)localObject4).setText((CharSequence)localObject2);
        }
        localObject2 = g;
        ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).r());
        localObject2 = p;
        ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).l());
        localObject2 = a;
        ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).i());
        localObject2 = c;
        ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).f());
        localObject2 = e;
        ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).j());
        localObject2 = i;
        ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).k());
        localObject2 = t;
        ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).a());
        localObject2 = l;
        i1 = ((k.a.a.m.System)localObject2).getValue().length();
        if (i1 > 0)
        {
          localObject2 = l;
          try
          {
            localObject2 = new JSONObject(((k.a.a.m.System)localObject2).getValue());
            localObject4 = statusText;
            ((TextView)localObject4).setText(((JSONObject)localObject2).getString("name"));
            localObject4 = lblTitle;
            ((TextView)localObject4).setText(((JSONObject)localObject2).getString("dob"));
            localObject4 = textSize;
            ((TextView)localObject4).setText(((JSONObject)localObject2).getString("gender"));
            localObject4 = minutes;
            ((TextView)localObject4).setText(((JSONObject)localObject2).getString("co"));
            localObject4 = tvDate;
            ((TextView)localObject4).setText(((JSONObject)localObject2).getString("address"));
            localObject4 = tvTime;
            ((TextView)localObject4).setText(((k.a.a.c.a)localObject1).e());
            localObject4 = lblDescription;
            ((TextView)localObject4).setText(((JSONObject)localObject2).getString("gen"));
            localObject2 = searchText;
            ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).l());
            localObject2 = startDate;
            ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).c());
            localObject2 = endDate;
            ((TextView)localObject2).setText(((k.a.a.c.a)localObject1).b());
          }
          catch (Exception localException2)
          {
            k.a.a.m.StringBuilder.append(localException2);
          }
        }
        Object localObject3 = r;
        localObject4 = ((k.a.a.c.a)localObject1).p();
        ImageView localImageView = context;
        ClassWriter localClassWriter = s;
        f.l.a.b.f.a localA = j;
        ((f.l.a.b.f)localObject3).a((String)localObject4, localImageView, localClassWriter, localA);
        localObject3 = year;
        ((TextView)localObject3).setText(get(((k.a.a.c.a)localObject1).d()));
        boolean bool = a(((k.a.a.c.a)localObject1).d());
        if (bool)
        {
          localObject1 = fab;
          ((ImageView)localObject1).setImageResource(2131231206);
          localObject1 = recyclerView;
          ((View)localObject1).setVisibility(0);
          localObject1 = emptyView;
          ((View)localObject1).setVisibility(8);
          localObject1 = type;
          ((TextView)localObject1).setTextColor(ContextCompat.getColor(this, 2131099793));
          localObject1 = year;
          ((TextView)localObject1).setTextColor(ContextCompat.getColor(this, 2131099895));
          return;
        }
        localObject1 = fab;
        ((ImageView)localObject1).setImageResource(2131231205);
        localObject1 = recyclerView;
        ((View)localObject1).setVisibility(8);
        localObject1 = emptyView;
        ((View)localObject1).setVisibility(0);
        localObject1 = type;
        ((TextView)localObject1).setTextColor(ContextCompat.getColor(this, 2131099895));
        localObject1 = year;
        ((TextView)localObject1).setTextColor(ContextCompat.getColor(this, 2131099793));
        return;
      }
      localObject1 = data;
      ((View)localObject1).setVisibility(0);
      localObject1 = listView;
      ((View)localObject1).setVisibility(8);
      localObject1 = swipeRefreshLayout;
      ((View)localObject1).setVisibility(8);
      localObject1 = status;
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = image;
      ((ImageView)localObject1).setVisibility(0);
      return;
    }
    catch (Exception localException1)
    {
      k.a.a.m.StringBuilder.append((Exception)localException1);
      Toast.makeText(this, getResources().getString(2131756127), 1).show();
    }
  }
  
  private boolean a(String paramString)
  {
    return new k.a.a.m.f(this).get(k.a.a.m.f.c, "en").equalsIgnoreCase(paramString);
  }
  
  private void add()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      k.a.a.m.f localF = parent;
      String str = k.a.a.m.f.g;
      localJSONObject3.put("mno", localF.get(str, ""));
      localJSONObject3.put("type", "both");
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new i(this), "https://app.umang.gov.in/umang/coreapi/ws2/fp", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  private void add(String paramString)
  {
    b.getText();
    Ma localMa = new Ma();
    JSONObject localJSONObject1;
    try
    {
      JSONObject localJSONObject2 = Log.execute(this);
      localJSONObject1 = localJSONObject2;
      localJSONObject2.put("type", "aadhaar");
      localJSONObject2.put("mpin", localMa.a(Log.toString(this, paramString)));
      paramString = d;
      localJSONObject2.put("aadhr", paramString);
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
      localJSONObject1 = null;
    }
    if (localJSONObject1 != null) {
      new k.a.a.l.List((k.a.a.i.List)new c(this), "https://app.umang.gov.in/umang/coreapi/ws2/uadhrv1", localJSONObject1, this).execute(new Object[0]);
    }
  }
  
  private String get(String paramString)
  {
    ArrayList localArrayList = Log.parse();
    int m = 0;
    while (m < localArrayList.size())
    {
      if (paramString.equalsIgnoreCase((String)localArrayList.get(m))) {
        return (String)Log.read(this).get(m);
      }
      m += 1;
    }
    return "";
  }
  
  private void initialize()
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131493276, true);
    ((TextView)localDialog.findViewById(2131297214)).setOnClickListener((View.OnClickListener)new k.a.a.a.a(this, localDialog));
    ((TextView)localDialog.findViewById(2131297184)).setOnClickListener((View.OnClickListener)new b(this, localDialog));
  }
  
  private void show()
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131492864, null);
    mPopup = new PopupWindow(localView, -2, -2);
    mPopup.setBackgroundDrawable(new BitmapDrawable());
    mPopup.setOutsideTouchable(true);
    mPopup.setOnDismissListener((PopupWindow.OnDismissListener)new o(this));
    mAdapter = ((LinearLayout)localView.findViewById(2131297429));
    mPresenter = ((LinearLayout)localView.findViewById(2131297965));
    mMenu = ((LinearLayout)localView.findViewById(2131296871));
    mView = ((LinearLayout)localView.findViewById(2131297385));
    mAdapter.setOnClickListener((View.OnClickListener)new p(this));
    mPresenter.setOnClickListener((View.OnClickListener)new q(this));
    mMenu.setOnClickListener((View.OnClickListener)new r(this));
    mView.setOnClickListener((View.OnClickListener)new s(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == points)
    {
      if (paramIntent.getStringExtra("MPIN_TXT").length() > 2)
      {
        add(paramIntent.getStringExtra("MPIN_TXT"));
        return;
      }
      if (paramIntent.getStringExtra("MPIN_TXT").length() == 0) {
        f.sufficientlysecure.rootcommands.util.StringBuilder.show(this, 2131755673, this, 1);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (orientation == 2)
    {
      paramConfiguration = mPopup;
      try
      {
        boolean bool = paramConfiguration.isShowing();
        if (bool)
        {
          paramConfiguration = mPopup;
          paramConfiguration.dismiss();
          paramConfiguration = new Handler();
          Object localObject = new j(this);
          localObject = (Runnable)localObject;
          paramConfiguration.postDelayed((Runnable)localObject, 100L);
          return;
        }
      }
      catch (Exception paramConfiguration)
      {
        k.a.a.m.StringBuilder.append(paramConfiguration);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492865);
    Log.execute(this, "Aadhaar Profile Screen");
    r = f.l.a.b.f.a();
    s = f.sufficientlysecure.rootcommands.util.StringBuilder.a(true, true).get(Bitmap.Config.RGB_565).getString();
    parent = new k.a.a.m.f(this);
    fab = ((ImageView)findViewById(2131297767));
    fab.setImageResource(2131231205);
    emptyView = ((LinearLayout)findViewById(2131296971));
    recyclerView = ((LinearLayout)findViewById(2131296981));
    emptyView.setVisibility(8);
    recyclerView.setVisibility(8);
    fab.setOnClickListener((View.OnClickListener)new k.a.a.a.k(this));
    swipeRefreshLayout = ((SwipeRefreshLayout)findViewById(2131297481));
    swipeRefreshLayout.setVisibility(8);
    listView = ((NestedScrollView)findViewById(2131296834));
    listView.setVisibility(8);
    context = ((ImageView)findViewById(2131297309));
    data = ((LinearLayout)findViewById(2131296282));
    data.setVisibility(8);
    mFindButton = ((ImageView)findViewById(2131297000));
    this$0 = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, this$0, true);
    paint = this$0.getRootView();
    path = ((TextView)paint.findViewById(2131297758));
    path.setText(getResources().getString(2131755128));
    content = ((LinearLayout)findViewById(2131296979));
    content.setVisibility(8);
    try
    {
      paramBundle = getIntent().getStringExtra("notifId");
      if (paramBundle != null)
      {
        k.a.a.e.System.getInstance(this).set(paramBundle);
        Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
      paramBundle.getMessage();
    }
    image = ((ImageView)paint.findViewById(2131296872));
    image.setOnClickListener((View.OnClickListener)new l(this));
    status = ((ImageView)paint.findViewById(2131297123));
    status.setOnClickListener((View.OnClickListener)new m(this));
    mFindButton.setOnClickListener((View.OnClickListener)new n(this));
    b = ((TextView)findViewById(2131296286));
    g = ((TextView)findViewById(2131297157));
    p = ((TextView)findViewById(2131296664));
    t = ((TextView)findViewById(2131296832));
    a = ((TextView)findViewById(2131296773));
    c = ((TextView)findViewById(2131296331));
    e = ((TextView)findViewById(2131296521));
    i = ((TextView)findViewById(2131296658));
    year = ((TextView)findViewById(2131297392));
    type = ((TextView)findViewById(2131296727));
    tvTime = ((TextView)findViewById(2131297156));
    statusText = ((TextView)findViewById(2131297155));
    searchText = ((TextView)findViewById(2131296663));
    lblTitle = ((TextView)findViewById(2131296662));
    lblDescription = ((TextView)findViewById(2131296831));
    textSize = ((TextView)findViewById(2131296830));
    startDate = ((TextView)findViewById(2131296772));
    minutes = ((TextView)findViewById(2131296771));
    endDate = ((TextView)findViewById(2131296330));
    tvDate = ((TextView)findViewById(2131296329));
    l = new k.a.a.m.System(this);
    show();
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
        k.a.a.e.System.getInstance(this).set(paramIntent);
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
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}
