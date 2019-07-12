package in.spicedigital.umang.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import f.l.a.b.ClassWriter;
import f.l.a.b.d;
import f.l.a.b.f.a;
import k.a.a.a.Hl;
import k.a.a.a.Il;
import k.a.a.a.Jl;
import k.a.a.a.Kl;
import k.a.a.a.Ll;
import k.a.a.c.i;
import k.a.a.m.Log;

public class MyProfileScreen
  extends BaseActivity
{
  public LinearLayout action;
  public TextView album;
  public k.a.a.m.f b;
  public f.l.a.b.f c;
  public LinearLayout cancel;
  public TextView d;
  public View date;
  public TextView header;
  public ClassWriter i;
  public a j = new Ll(this);
  public Toolbar mToolbar;
  public View mViewPager;
  public LinearLayout search;
  public ImageView settings;
  public ImageView switchCamera;
  public LinearLayout text;
  public CircleImageView this$0;
  public TextView title;
  
  public MyProfileScreen() {}
  
  private void init()
  {
    try
    {
      Object localObject2 = new k.a.a.m.System(this);
      Object localObject1 = ((k.a.a.m.System)localObject2).get();
      localObject2 = ((k.a.a.m.System)localObject2).a();
      if (localObject2 != null)
      {
        localObject2 = settings;
        ((ImageView)localObject2).setVisibility(0);
      }
      else
      {
        localObject2 = settings;
        ((ImageView)localObject2).setVisibility(8);
      }
      int k = ((i)localObject1).getData().length();
      if (k > 0)
      {
        localObject2 = d;
        ((TextView)localObject2).setText(((i)localObject1).getData());
        localObject2 = d;
        ((View)localObject2).setVisibility(0);
      }
      else
      {
        localObject2 = d;
        ((View)localObject2).setVisibility(0);
        localObject2 = header;
        ((View)localObject2).setVisibility(0);
        localObject2 = d;
        ((TextView)localObject2).setText("");
        localObject2 = header;
        ((TextView)localObject2).setText("");
      }
      k = ((i)localObject1).getTitle().length();
      Object localObject3;
      if (k > 0)
      {
        k = ((i)localObject1).getName().length();
        if (k > 0)
        {
          localObject2 = header;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(Log.get(((i)localObject1).getTitle()));
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append(((i)localObject1).getName());
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
          localObject2 = header;
          ((View)localObject2).setVisibility(0);
          break label343;
        }
      }
      k = ((i)localObject1).getName().length();
      if (k > 0)
      {
        localObject2 = header;
        ((TextView)localObject2).setText(((i)localObject1).getName());
        localObject2 = header;
        ((View)localObject2).setVisibility(0);
      }
      else
      {
        k = ((i)localObject1).getTitle().length();
        if (k > 0)
        {
          localObject2 = header;
          ((TextView)localObject2).setText(Log.get(((i)localObject1).getTitle()));
        }
        else
        {
          localObject2 = header;
          ((TextView)localObject2).setText("");
          localObject2 = header;
          ((View)localObject2).setVisibility(0);
        }
      }
      label343:
      k = ((i)localObject1).get().length();
      if (k > 0)
      {
        localObject2 = title;
        ((TextView)localObject2).setText(((i)localObject1).get());
      }
      else
      {
        localObject2 = title;
        ((TextView)localObject2).setText("");
      }
      localObject2 = (ImageView)this$0;
      ((ImageView)localObject2).setVisibility(8);
      boolean bool = ((i)localObject1).getValue().equalsIgnoreCase("M");
      if (bool)
      {
        localObject2 = (ImageView)this$0;
        ((ImageView)localObject2).setVisibility(0);
        localObject2 = this$0;
        ((CircleImageView)localObject2).setImageResource(2131231235);
      }
      else
      {
        bool = ((i)localObject1).getValue().equalsIgnoreCase("F");
        if (bool)
        {
          localObject2 = (ImageView)this$0;
          ((ImageView)localObject2).setVisibility(0);
          localObject2 = this$0;
          ((CircleImageView)localObject2).setImageResource(2131231042);
        }
        else
        {
          bool = ((i)localObject1).getValue().equalsIgnoreCase("T");
          if (bool)
          {
            localObject2 = (ImageView)this$0;
            ((ImageView)localObject2).setVisibility(0);
            localObject2 = this$0;
            ((CircleImageView)localObject2).setImageResource(2131231690);
          }
          else
          {
            localObject2 = (ImageView)this$0;
            ((ImageView)localObject2).setVisibility(0);
            localObject2 = this$0;
            ((CircleImageView)localObject2).setImageResource(2131231690);
          }
        }
      }
      k = ((i)localObject1).add().length();
      if (k > 0)
      {
        localObject2 = c;
        localObject1 = ((i)localObject1).add();
        Object localObject4 = this$0;
        localObject3 = i;
        a localA = j;
        localObject4 = (ImageView)localObject4;
        ((f.l.a.b.f)localObject2).a((String)localObject1, (ImageView)localObject4, (ClassWriter)localObject3, localA);
        return;
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append((Exception)localException);
      d.setVisibility(8);
      ((ImageView)this$0).setVisibility(0);
      this$0.setImageResource(2131231690);
      header.setVisibility(8);
      title.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493156);
    Log.execute(this, "MyProfile Screen");
    b = new k.a.a.m.f(this);
    c = f.l.a.b.f.a();
    i = f.sufficientlysecure.rootcommands.util.StringBuilder.a(true, true).get(Bitmap.Config.RGB_565).getString();
    mToolbar = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, mToolbar, true);
    mViewPager = mToolbar.getRootView();
    album = ((TextView)mViewPager.findViewById(2131297758));
    f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755971, album);
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
    }
    this$0 = ((CircleImageView)findViewById(2131297306));
    d = ((TextView)findViewById(2131297157));
    header = ((TextView)findViewById(2131297982));
    title = ((TextView)findViewById(2131297984));
    action = ((LinearLayout)findViewById(2131296833));
    cancel = ((LinearLayout)findViewById(2131297592));
    search = ((LinearLayout)findViewById(2131296969));
    text = ((LinearLayout)findViewById(2131296967));
    settings = ((ImageView)findViewById(2131296921));
    settings.setVisibility(8);
    date = findViewById(2131296281);
    if (b.get(k.a.a.m.f.value, "remove").equalsIgnoreCase("remove"))
    {
      text.setVisibility(8);
      date.setVisibility(8);
    }
    else
    {
      text.setVisibility(0);
      date.setVisibility(0);
    }
    action.setOnClickListener((View.OnClickListener)new Hl(this));
    cancel.setOnClickListener((View.OnClickListener)new Il(this));
    search.setOnClickListener((View.OnClickListener)new Jl(this));
    text.setOnClickListener((View.OnClickListener)new Kl(this));
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
    init();
  }
}
