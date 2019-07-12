package in.spicedigital.umang.activities;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.BaseOnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.package_7.LoaderManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.github.clans.fab.FloatingActionMenu;
import de.hdodenhof.circleimageview.CircleImageView;
import f.l.a.b.ClassWriter;
import f.l.a.b.d;
import f.l.a.b.f.a;
import f.libs.asm.b;
import f.objectweb.asm.h;
import f.objectweb.asm.l;
import internal.view.menu.k;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;
import k.a.a.a.Ak;
import k.a.a.a.Bk;
import k.a.a.a.Ck;
import k.a.a.a.Dk;
import k.a.a.a.Ek;
import k.a.a.a.Fk;
import k.a.a.a.Gk;
import k.a.a.a.Hk;
import k.a.a.a.Ik;
import k.a.a.a.Jk;
import k.a.a.a.Kk;
import k.a.a.a.Lk;
import k.a.a.a.Mk;
import k.a.a.a.Nk;
import k.a.a.a.Ok;
import k.a.a.a.Pk;
import k.a.a.a.Qk;
import k.a.a.a.Rk;
import k.a.a.a.Sk;
import k.a.a.a.Tk;
import k.a.a.a.Uk;
import k.a.a.a.Vk;
import k.a.a.a.Wk;
import k.a.a.a.Xk;
import k.a.a.a.Yk;
import k.a.a.a.Zk;
import k.a.a.a._k;
import k.a.a.a.al;
import k.a.a.a.bl;
import k.a.a.a.dl;
import k.a.a.a.el;
import k.a.a.a.fl;
import k.a.a.a.gl;
import k.a.a.a.hl;
import k.a.a.a.il;
import k.a.a.a.jl;
import k.a.a.a.kk;
import k.a.a.a.kl;
import k.a.a.a.lk;
import k.a.a.a.mk;
import k.a.a.a.nk;
import k.a.a.a.ok;
import k.a.a.a.pk;
import k.a.a.a.qk;
import k.a.a.a.rk;
import k.a.a.a.sk;
import k.a.a.a.tk;
import k.a.a.a.uk;
import k.a.a.a.vk;
import k.a.a.a.wk;
import k.a.a.a.xk;
import k.a.a.a.yk;
import k.a.a.a.zk;
import k.a.a.b.v;
import k.a.a.c.i;
import k.a.a.h.Ha;
import k.a.a.h.Xb;
import k.a.a.h.ma;
import k.a.a.h.ua;
import k.a.a.l.B;
import k.a.a.l.j;
import k.a.a.l.o;
import k.a.a.l.x;
import k.a.a.m.Config;
import k.a.a.m.Fa;
import org.json.JSONObject;
import org.yaxim.androidclient.data.ChatProvider;
import support.android.v4.content.ContextCompat;
import support.android.v4.content.CursorLoader;
import support.android.v4.content.Loader;
import support.android.v4.view.PagerAdapter;

public class MainActivity
  extends BaseActivity
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  public static final int EVT_RELOAD = 0;
  public static Handler h;
  public static Handler messageHandler;
  public static boolean running;
  public ClassWriter a;
  public FloatingActionMenu adapter;
  public String address;
  public String album;
  public a b = new Xk(this);
  public boolean background;
  public LinearLayout c;
  public View color;
  public CircleImageView context;
  public TextView count;
  public TextView current;
  public f.l.a.b.f d;
  public k.a.a.e.System data;
  public Snackbar db = null;
  public TextView description;
  public View emptyView;
  public LinearLayout f;
  public com.github.clans.fab.FloatingActionButton fab;
  public RelativeLayout header;
  public BroadcastReceiver headsetPlugReceiver;
  public CircleImageView i;
  public LinearLayout image;
  public final int index = 2;
  public boolean isLandscape;
  public LinearLayout l;
  public LinearLayout layout;
  public LinearLayout list;
  public TextView location;
  public ImageView locationManager;
  public TextView mActivity;
  public LinearLayout mAdapter;
  public LinearLayout mContainer;
  public RelativeLayout mContent;
  public TextView mDB;
  public DrawerLayout mDrawerLayout;
  public LinearLayout mFooter;
  public k mGpsStatusState;
  public LinearLayout mHeader;
  public ImageView mImageView;
  public LinearLayout mLayout;
  public java.util.List<k.a.a.c.y> mList;
  public String mOverlayId = "MainActivity";
  public v mPagerAdapter;
  public LinearLayout mPreferences;
  public View mProgressBar;
  public TextView mStartButton;
  public TabLayout mTabLayout;
  public ImageView mTextView;
  public ImageView mTitle;
  public Toolbar mToolbar;
  public LinearLayout mView;
  public ViewPager mViewPager;
  public LinearLayout nextButton;
  public CoordinatorLayout pager;
  public LinearLayout preferences;
  public LinearLayout progressBar;
  public View progressView;
  public boolean result = false;
  public LinearLayout root;
  public JSONObject sp;
  public boolean started = false;
  public int state = -1;
  public ImageView status;
  public android.support.design.widget.FloatingActionButton swipeRefreshLayout;
  public LinearLayout text;
  public Snackbar this$0;
  public LinearLayout title;
  public com.github.clans.fab.FloatingActionButton toolbar;
  public k.a.a.m.f type;
  public TextView username;
  public RelativeLayout view;
  public LinearLayout webView;
  public String x = "true";
  
  public MainActivity() {}
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    type.append(k.a.a.m.f.cursor, "false");
    paramContext = new Dialog(paramContext);
    paramContext.getWindow();
    paramContext.requestWindowFeature(1);
    paramContext.setContentView(2131493032);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    ((TextView)paramContext.findViewById(2131296633)).setText(paramString1);
    ((TextView)paramContext.findViewById(2131296634)).setText(Html.fromHtml(paramString2));
    ((TextView)paramContext.findViewById(2131297214)).setOnClickListener((View.OnClickListener)new Zk(this, paramContext));
    paramContext.setOnCancelListener((DialogInterface.OnCancelListener)new _k(this));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      l.setVisibility(8);
      c.setVisibility(8);
      this$0.dismiss();
      f.setVisibility(0);
      paramString = (Button)findViewById(2131297161);
      paramString.setVisibility(8);
      paramString.setOnClickListener((View.OnClickListener)new Mk(this));
      return;
    }
    f.setVisibility(8);
  }
  
  private void a(k.a.a.c.y paramY)
  {
    if (f.getVisibility() == 8)
    {
      if (l.getVisibility() == 0) {
        l.setVisibility(8);
      }
      c.setVisibility(0);
      c.setBackgroundColor(Color.parseColor(paramY.d()));
      ImageView localImageView1 = (ImageView)findViewById(2131297111);
      TextView localTextView1 = (TextView)findViewById(2131297110);
      TextView localTextView2 = (TextView)findViewById(2131297112);
      ImageView localImageView2 = (ImageView)findViewById(2131296586);
      ClassWriter localClassWriter = f.sufficientlysecure.rootcommands.util.StringBuilder.a(true, true).get(Bitmap.Config.RGB_565).getString();
      d.a(paramY.a(), localImageView1, localClassWriter);
      localTextView1.setText(Html.fromHtml(paramY.i()));
      localTextView2.setText(Html.fromHtml(paramY.e()));
      localImageView2.setOnClickListener((View.OnClickListener)new Nk(this));
      c.setOnClickListener((View.OnClickListener)new Ok(this, paramY));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131493081, paramBoolean);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131297186);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131297550);
    localDialog.findViewById(2131298000);
    if (type.get(k.a.a.m.f.w, "true").equalsIgnoreCase("true")) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755188, localTextView2);
    } else {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755755, localTextView2);
    }
    localTextView1.setOnClickListener((View.OnClickListener)new Pk(this, localDialog, paramBoolean));
    ((TextView)localDialog.findViewById(2131298035)).setOnClickListener((View.OnClickListener)new Rk(this));
  }
  
  private void b()
  {
    Object localObject = Typeface.create("sans-serif-", 0);
    localObject = new h(this).a(new f.objectweb.asm.f[] { f.objectweb.asm.f.a(findViewById(2131296856), getResources().getString(2131755813)).b((Typeface)localObject), f.objectweb.asm.f.a(findViewById(2131296755), getResources().getString(2131755814)).a(true).b((Typeface)localObject).c(17170443), f.objectweb.asm.f.a(findViewById(2131297206), getResources().getString(2131755812)).b((Typeface)localObject), f.objectweb.asm.f.a(findViewById(2131297101), getResources().getString(2131755811)).b((Typeface)localObject) });
    ((h)localObject).a(true);
    ((h)localObject).c(true);
    ((h)localObject).a((l)new Dk(this));
    ((h)localObject).c();
  }
  
  private void call()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = k.a.a.m.Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      localJSONObject3.put("type", "fetch");
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new Jk(this), "https://app.umang.gov.in/umang/coreapi/ws2/ftal", localJSONObject2, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }
  }
  
  private void doInBackground()
  {
    Intent localIntent = new Intent(this, FilterScreen.class);
    localIntent.setFlags(65536);
    Object localObject1 = type;
    Object localObject2 = k.a.a.m.f.left;
    String str = "";
    localObject1 = ((k.a.a.m.f)localObject1).get((String)localObject2, "");
    if (!((String)localObject1).equalsIgnoreCase(""))
    {
      localObject1 = ((String)localObject1).split(",");
      int j = 0;
      while (j < localObject1.length)
      {
        localObject2 = localObject1[j].split("\\|");
        if (mViewPager.getCurrentItem() == j) {
          str = localObject2[1];
        }
        j += 1;
      }
      if (str.equalsIgnoreCase("home"))
      {
        localIntent.putExtra("from", "allServices");
      }
      else if (str.equalsIgnoreCase("fav"))
      {
        localIntent.putExtra("from", "fav");
      }
      else if (str.equalsIgnoreCase("state"))
      {
        localIntent.putExtra("from", "state");
      }
      else if (str.equalsIgnoreCase("flagship"))
      {
        localIntent.putExtra("from", "flagship");
      }
      else
      {
        localIntent.putExtra("from", "allServices");
        localIntent.putExtra("allServicesSelectedTab", album);
      }
    }
    else if (mViewPager.getCurrentItem() == 0)
    {
      localIntent.putExtra("from", "allServices");
    }
    else if (mViewPager.getCurrentItem() == 1)
    {
      localIntent.putExtra("from", "fav");
    }
    else
    {
      localIntent.putExtra("from", "allServices");
      localIntent.putExtra("allServicesSelectedTab", album);
    }
    startActivity(localIntent);
  }
  
  private int dpToPx(int paramInt)
  {
    return (int)(getResourcesgetDisplayMetricsdensity * 14.0F + 0.5F);
  }
  
  private boolean execute()
  {
    Object localObject1 = type;
    Object localObject2 = k.a.a.m.f.readCurs;
    try
    {
      boolean bool = ((k.a.a.m.f)localObject1).get((String)localObject2, "false").equalsIgnoreCase("false");
      if (bool)
      {
        localObject1 = getIntent().getStringExtra("fromLogin");
        if (localObject1 != null)
        {
          bool = ((String)localObject1).equalsIgnoreCase("true");
          if (bool) {
            return true;
          }
        }
        localObject1 = type;
        localObject2 = k.a.a.m.f.start;
        int j = ((k.a.a.m.f)localObject1).getItem((String)localObject2, 0);
        localObject1 = new SimpleDateFormat("dd/MM/yyyy");
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTime(new Date());
        Object localObject3 = type;
        Object localObject4 = k.a.a.m.f.strVal1;
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("");
        ((StringBuilder)localObject5).append(((SimpleDateFormat)localObject1).format(((Calendar)localObject2).getTime()));
        localObject3 = ((SimpleDateFormat)localObject1).parse(((k.a.a.m.f)localObject3).get((String)localObject4, ((StringBuilder)localObject5).toString()));
        localObject4 = type;
        localObject5 = k.a.a.m.f.port;
        bool = ((k.a.a.m.f)localObject4).get((String)localObject5, "true").equalsIgnoreCase("false");
        int k;
        int m;
        Object localObject6;
        StringBuilder localStringBuilder;
        if (bool)
        {
          localObject4 = type;
          localObject5 = k.a.a.m.f.url;
          k = Integer.parseInt(((k.a.a.m.f)localObject4).get((String)localObject5, "0"));
          localObject4 = type;
          localObject5 = k.a.a.m.f.ref;
          m = Integer.parseInt(((k.a.a.m.f)localObject4).get((String)localObject5, "0"));
          localObject4 = Calendar.getInstance();
          ((Calendar)localObject4).setTime((Date)localObject3);
          ((Calendar)localObject4).add(5, m);
          localObject6 = ((SimpleDateFormat)localObject1).format(((Calendar)localObject4).getTime());
          localObject3 = ((SimpleDateFormat)localObject1).format(((Calendar)localObject2).getTime());
          localObject4 = ((SimpleDateFormat)localObject1).parse((String)localObject6);
          localObject5 = ((SimpleDateFormat)localObject1).parse((String)localObject3);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("nextDateStr.............");
          localStringBuilder.append((String)localObject6);
          localStringBuilder.toString();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("currentDateStr.............");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((StringBuilder)localObject6).toString();
          if (j < k)
          {
            bool = ((Date)localObject5).equals(localObject4);
            if (!bool)
            {
              bool = ((Date)localObject5).after((Date)localObject4);
              if (!bool) {
                break label862;
              }
            }
          }
          localObject3 = type;
          localObject4 = k.a.a.m.f.port;
          bool = ((k.a.a.m.f)localObject3).get((String)localObject4, "true").equalsIgnoreCase("false");
          if (bool)
          {
            localObject3 = address;
            k.a.a.m.Log.show(this, true, "nonMandatoryDialog", (String)localObject3);
          }
          else
          {
            localObject3 = address;
            k.a.a.m.Log.init(this, true, (String)localObject3);
          }
          localObject3 = type;
          localObject4 = k.a.a.m.f.start;
          ((k.a.a.m.f)localObject3).clear((String)localObject4, 0);
          localObject3 = type;
          localObject4 = k.a.a.m.f.strVal1;
          ((k.a.a.m.f)localObject3).append((String)localObject4, ((SimpleDateFormat)localObject1).format(((Calendar)localObject2).getTime()));
          return true;
        }
        else
        {
          localObject4 = type;
          localObject5 = k.a.a.m.f.classname;
          k = Integer.parseInt(((k.a.a.m.f)localObject4).get((String)localObject5, "0"));
          localObject4 = type;
          localObject5 = k.a.a.m.f.file;
          m = Integer.parseInt(((k.a.a.m.f)localObject4).get((String)localObject5, "0"));
          localObject4 = Calendar.getInstance();
          ((Calendar)localObject4).setTime((Date)localObject3);
          ((Calendar)localObject4).add(5, m);
          localObject6 = ((SimpleDateFormat)localObject1).format(((Calendar)localObject4).getTime());
          localObject3 = ((SimpleDateFormat)localObject1).format(((Calendar)localObject2).getTime());
          localObject4 = ((SimpleDateFormat)localObject1).parse((String)localObject6);
          localObject5 = ((SimpleDateFormat)localObject1).parse((String)localObject3);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("nextDateStr.............");
          localStringBuilder.append((String)localObject6);
          localStringBuilder.toString();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("currentDateStr.............");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((StringBuilder)localObject6).toString();
          if (j < k)
          {
            bool = ((Date)localObject5).equals(localObject4);
            if (!bool)
            {
              bool = ((Date)localObject5).after((Date)localObject4);
              if (!bool) {
                break label862;
              }
            }
          }
          localObject3 = type;
          localObject4 = k.a.a.m.f.port;
          bool = ((k.a.a.m.f)localObject3).get((String)localObject4, "true").equalsIgnoreCase("false");
          if (bool)
          {
            localObject3 = address;
            k.a.a.m.Log.show(this, true, "nonMandatoryDialog", (String)localObject3);
          }
          else
          {
            localObject3 = address;
            k.a.a.m.Log.init(this, true, (String)localObject3);
          }
          localObject3 = type;
          localObject4 = k.a.a.m.f.start;
          ((k.a.a.m.f)localObject3).clear((String)localObject4, 0);
          localObject3 = type;
          localObject4 = k.a.a.m.f.strVal1;
          ((k.a.a.m.f)localObject3).append((String)localObject4, ((SimpleDateFormat)localObject1).format(((Calendar)localObject2).getTime()));
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append((Exception)localException);
    }
    label862:
    return false;
  }
  
  private void getItem()
  {
    try
    {
      Handler localHandler = new Handler();
      Object localObject = new Wk(this);
      k.a.a.m.f localF = type;
      String str = k.a.a.m.f.sessionID;
      int j = Integer.parseInt(localF.get(str, "14400000"));
      long l1 = j;
      localObject = (Runnable)localObject;
      localHandler.postDelayed((Runnable)localObject, l1);
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  private void handleIntent()
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131493140, false);
    ((TextView)localDialog.findViewById(2131297186)).setOnClickListener((View.OnClickListener)new Sk(this, localDialog));
    ((TextView)localDialog.findViewById(2131298035)).setOnClickListener((View.OnClickListener)new Tk(this, localDialog));
  }
  
  private void init(Context paramContext)
  {
    Dialog localDialog = new Dialog(paramContext);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493196);
    localDialog.setCancelable(true);
    RatingBar localRatingBar = (RatingBar)localDialog.findViewById(2131297352);
    ImageView localImageView = (ImageView)localDialog.findViewById(2131297586);
    TextView localTextView = (TextView)localDialog.findViewById(2131297657);
    if (state == -1) {
      state = 5;
    }
    initialize(localImageView, state);
    localRatingBar.setRating(state);
    localRatingBar.setOnRatingBarChangeListener((RatingBar.OnRatingBarChangeListener)new Gk(this, localImageView));
    localTextView.setOnClickListener((View.OnClickListener)new Hk(this, localRatingBar, paramContext, localDialog));
    localDialog.show();
  }
  
  private void initialize(ImageView paramImageView, float paramFloat)
  {
    if (paramFloat <= 1.0F)
    {
      state = 1;
      paramImageView.setImageResource(2131231493);
      return;
    }
    if (paramFloat == 2.0F)
    {
      state = 2;
      paramImageView.setImageResource(2131231494);
      return;
    }
    if (paramFloat == 3.0F)
    {
      state = 3;
      paramImageView.setImageResource(2131231495);
      return;
    }
    if (paramFloat == 4.0F)
    {
      state = 4;
      paramImageView.setImageResource(2131231496);
      return;
    }
    if (paramFloat == 5.0F)
    {
      state = 5;
      paramImageView.setImageResource(2131231497);
    }
  }
  
  private void loadData()
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject = k.a.a.m.Log.execute(this);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = new o((k.a.a.i.List)new bl(this), (JSONObject)localObject, this);
      Executor localExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
      ((AsyncTask)localObject).executeOnExecutor(localExecutor, new Object[0]);
    }
  }
  
  private void loadData(Context paramContext)
  {
    Object localObject2 = type;
    Object localObject1 = this;
    if (((k.a.a.m.f)localObject2).get(k.a.a.m.f.uri, "").equalsIgnoreCase("true"))
    {
      try
      {
        localObject2 = k.a.a.m.Log.execute(paramContext);
        paramContext = (Context)localObject2;
        Object localObject3 = type;
        String str = k.a.a.m.f.g;
        ((JSONObject)localObject2).put("mno", ((k.a.a.m.f)localObject3).get(str, ""));
        localObject1 = type;
        localObject3 = k.a.a.m.f.data;
        ((JSONObject)localObject2).put("gcmid", ((k.a.a.m.f)localObject1).get((String)localObject3, ""));
      }
      catch (Exception paramContext)
      {
        k.a.a.m.StringBuilder.append(paramContext);
        paramContext = null;
      }
      localObject1 = this;
      if (paramContext != null)
      {
        paramContext = new B((k.a.a.i.List)new Ik((MainActivity)localObject1), paramContext, (Context)localObject1);
        localObject1 = AsyncTask.THREAD_POOL_EXECUTOR;
        ((AsyncTask)paramContext).executeOnExecutor((Executor)localObject1, new Object[0]);
      }
    }
  }
  
  private void loadData(String paramString)
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject = k.a.a.m.Log.execute(this);
      localObject = localJSONObject;
      k.a.a.m.f localF = type;
      String str = k.a.a.m.f.g;
      localJSONObject.put("mno", localF.get(str, ""));
      localJSONObject.put("cate", "appfd");
      localJSONObject.put("feedback", "");
      localJSONObject.put("catetype", "feedback");
      localJSONObject.put("sid", "");
      localJSONObject.put("serviceID", "");
      localJSONObject.put("pic", "");
      localJSONObject.put("rating", paramString);
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
      localObject = null;
    }
    if (localObject != null)
    {
      paramString = new x((k.a.a.i.List)new el(this), (JSONObject)localObject, this);
      localObject = AsyncTask.THREAD_POOL_EXECUTOR;
      ((AsyncTask)paramString).executeOnExecutor((Executor)localObject, new Object[0]);
    }
  }
  
  private void onActivityResult()
  {
    this$0 = Snackbar.make(mViewPager, getResources().getString(2131755983), -2);
    Object localObject1 = type;
    Object localObject2 = k.a.a.m.f.type;
    try
    {
      int j = Integer.parseInt(((k.a.a.m.f)localObject1).get((String)localObject2, k.a.a.m.Log.getVersion(this)));
      int k = Integer.parseInt(k.a.a.m.Log.getVersion(this));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("appVersion : ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("newVersion : ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).toString();
      if (j > k)
      {
        localObject1 = type;
        localObject2 = k.a.a.m.f.content;
        localObject1 = ((k.a.a.m.f)localObject1).get((String)localObject2, "");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(j);
        boolean bool = ((String)localObject1).equalsIgnoreCase(((StringBuilder)localObject2).toString());
        if (!bool)
        {
          localObject1 = type;
          localObject2 = k.a.a.m.f.content;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(j);
          ((k.a.a.m.f)localObject1).append((String)localObject2, ((StringBuilder)localObject3).toString());
          localObject1 = this$0;
          localObject2 = getResources().getString(2131756589);
          localObject3 = new fl(this);
          localObject3 = (View.OnClickListener)localObject3;
          ((Snackbar)localObject1).setAction((CharSequence)localObject2, (View.OnClickListener)localObject3);
          localObject1 = this$0;
          ((Snackbar)localObject1).setActionTextColor(ContextCompat.getColor(this, 2131099893));
          localObject1 = this$0;
          ((Snackbar)localObject1).show();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  private void onCreate()
  {
    Object localObject1 = getResourcesgetConfigurationlocale.toString();
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("system language : ", (String)localObject1);
    Object localObject3 = type.get(k.a.a.m.f.c, (String)localObject1);
    boolean bool = ((String)localObject3).contains("en");
    Object localObject2 = "hi";
    if (bool) {
      localObject1 = "en";
    } else if (((String)localObject3).contains("hi")) {
      localObject1 = localObject2;
    } else if (((String)localObject3).contains("as")) {
      localObject1 = "as";
    } else if (((String)localObject3).contains("bn")) {
      localObject1 = "bn";
    } else if (((String)localObject3).contains("gu")) {
      localObject1 = "gu";
    } else if (((String)localObject3).contains("kn")) {
      localObject1 = "kn";
    } else if (((String)localObject3).contains("ml")) {
      localObject1 = "ml";
    } else if (((String)localObject3).contains("mr")) {
      localObject1 = "mr";
    } else if (((String)localObject3).contains("or")) {
      localObject1 = "or";
    } else if (((String)localObject3).contains("pa")) {
      localObject1 = "pa";
    } else if (((String)localObject3).contains("ta")) {
      localObject1 = "ta";
    } else if (((String)localObject3).contains("te")) {
      localObject1 = "te";
    } else if (((String)localObject3).contains("ur")) {
      localObject1 = "ur";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("selected language : ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).toString();
    localObject2 = new Locale((String)localObject1);
    Locale.setDefault((Locale)localObject2);
    localObject3 = new Configuration();
    locale = ((Locale)localObject2);
    if (type.get(k.a.a.m.f.a, "normal").equalsIgnoreCase("small")) {
      fontScale = 0.85F;
    } else if (type.get(k.a.a.m.f.a, "normal").equalsIgnoreCase("normal")) {
      fontScale = 1.0F;
    } else {
      fontScale = 1.15F;
    }
    Config.init(this, (String)localObject1);
  }
  
  private void onCreateView(Bundle paramBundle)
  {
    result = false;
    album = "all";
    data = k.a.a.e.System.getInstance(this);
    type = new k.a.a.m.f(this);
    type.append(k.a.a.m.f.mTitle, "");
    running = false;
    header = ((RelativeLayout)findViewById(2131297263));
    nextButton = ((LinearLayout)findViewById(2131297979));
    webView = ((LinearLayout)findViewById(2131297179));
    preferences = ((LinearLayout)findViewById(2131296690));
    locationManager = ((ImageView)findViewById(2131297180));
    locationManager.setOnClickListener((View.OnClickListener)new kl(this));
    mDrawerLayout = ((DrawerLayout)findViewById(2131296686));
    pager = ((CoordinatorLayout)findViewById(2131296576));
    mTabLayout = ((TabLayout)findViewById(2131297667));
    String str = type.get(k.a.a.m.f.left, "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dynamicTabsData......................");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).toString();
    int j;
    if (!str.equalsIgnoreCase(""))
    {
      localObject2 = str.split(",");
      j = 0;
      while (j < localObject2.length)
      {
        localObject4 = localObject2[j].split("\\|");
        localObject3 = localObject4[0];
        if (localObject4[1].equalsIgnoreCase("state"))
        {
          if (!type.get(k.a.a.m.f.elements, "").equalsIgnoreCase(""))
          {
            localObject3 = mTabLayout;
            ((TabLayout)localObject3).addTab(((TabLayout)localObject3).newTab().setText(type.get(k.a.a.m.f.elements, "")));
          }
          else
          {
            localObject4 = mTabLayout;
            ((TabLayout)localObject4).addTab(((TabLayout)localObject4).newTab().setText((CharSequence)localObject3));
          }
        }
        else
        {
          localObject4 = mTabLayout;
          ((TabLayout)localObject4).addTab(((TabLayout)localObject4).newTab().setText((CharSequence)localObject3));
        }
        j += 1;
      }
      j = 0;
      while (j < localObject2.length)
      {
        localObject3 = (TextView)LayoutInflater.from(this).inflate(2131492991, null);
        mTabLayout.getTabAt(j).setCustomView((View)localObject3);
        j += 1;
      }
    }
    localObject2 = mTabLayout;
    ((TabLayout)localObject2).addTab(((TabLayout)localObject2).newTab().setText(getResources().getString(2131755815)));
    localObject2 = mTabLayout;
    ((TabLayout)localObject2).addTab(((TabLayout)localObject2).newTab().setText(getResources().getString(2131755716)));
    localObject2 = mTabLayout;
    ((TabLayout)localObject2).addTab(((TabLayout)localObject2).newTab().setText(getResources().getString(2131755260)));
    localObject2 = (TextView)LayoutInflater.from(this).inflate(2131492991, null);
    Object localObject3 = (TextView)LayoutInflater.from(this).inflate(2131492991, null);
    Object localObject4 = (TextView)LayoutInflater.from(this).inflate(2131492991, null);
    mTabLayout.getTabAt(0).setCustomView((View)localObject2);
    mTabLayout.getTabAt(1).setCustomView((View)localObject3);
    mTabLayout.getTabAt(2).setCustomView((View)localObject4);
    mTabLayout.setTabGravity(0);
    ((TextView)mTabLayout.getTabAt(0).getCustomView()).setTextColor(ContextCompat.getColor(this, 2131099898));
    mViewPager = ((ViewPager)findViewById(2131297258));
    mPagerAdapter = new v(getSupportFragmentManager(), mTabLayout.getTabCount(), str);
    mViewPager.setAdapter((PagerAdapter)mPagerAdapter);
    mPreferences = ((LinearLayout)findViewById(2131296984));
    mFooter = ((LinearLayout)findViewById(2131296978));
    mHeader = ((LinearLayout)findViewById(2131296973));
    mAdapter = ((LinearLayout)findViewById(2131296968));
    mLayout = ((LinearLayout)findViewById(2131296977));
    mView = ((LinearLayout)findViewById(2131296970));
    mContainer = ((LinearLayout)findViewById(2131296980));
    title = ((LinearLayout)findViewById(2131296985));
    layout = ((LinearLayout)findViewById(2131296972));
    image = ((LinearLayout)findViewById(2131296983));
    if (type.get(k.a.a.m.f.mContext, "no").equalsIgnoreCase("yes")) {
      image.setVisibility(0);
    } else {
      image.setVisibility(8);
    }
    text = ((LinearLayout)findViewById(2131296986));
    mHeader.setOnClickListener((View.OnClickListener)new kk(this));
    mAdapter.setOnClickListener((View.OnClickListener)new lk(this));
    mLayout.setOnClickListener((View.OnClickListener)new mk(this));
    mView.setOnClickListener((View.OnClickListener)new nk(this));
    mContainer.setOnClickListener((View.OnClickListener)new ok(this));
    title.setOnClickListener((View.OnClickListener)new pk(this));
    layout.setOnClickListener((View.OnClickListener)new qk(this));
    image.setOnClickListener((View.OnClickListener)new rk(this));
    text.setOnClickListener((View.OnClickListener)new sk(this));
    status = ((ImageView)findViewById(2131296585));
    progressBar = ((LinearLayout)findViewById(2131297299));
    list = ((LinearLayout)findViewById(2131296413));
    l = ((LinearLayout)findViewById(2131296408));
    l.setVisibility(8);
    current = ((TextView)findViewById(2131297326));
    emptyView = findViewById(2131297311);
    progressView = findViewById(2131297310);
    i = ((CircleImageView)findViewById(2131297987));
    f = ((LinearLayout)findViewById(2131296411));
    f.setVisibility(8);
    c = ((LinearLayout)findViewById(2131296410));
    c.setVisibility(8);
    color = findViewById(2131296712);
    swipeRefreshLayout = ((android.support.design.widget.FloatingActionButton)findViewById(2131296755));
    adapter = ((FloatingActionMenu)findViewById(2131296765));
    toolbar = ((com.github.clans.fab.FloatingActionButton)findViewById(2131296758));
    fab = ((com.github.clans.fab.FloatingActionButton)findViewById(2131296760));
    adapter.setClosedOnTouchOutside(true);
    swipeRefreshLayout.setOnClickListener((View.OnClickListener)new tk(this));
    fab.setOnClickListener((View.OnClickListener)new vk(this));
    findViewById(2131296492).setOnClickListener((View.OnClickListener)new wk(this));
    findViewById(2131296976).setOnClickListener((View.OnClickListener)new xk(this));
    if (!type.get(k.a.a.m.f.view, "").equalsIgnoreCase("true"))
    {
      background = false;
      type.append(k.a.a.m.f.view, "true");
      b();
    }
    else
    {
      background = true;
    }
    l.setOnClickListener((View.OnClickListener)new yk(this));
    mFooter.setOnClickListener((View.OnClickListener)new zk(this));
    try
    {
      str = getIntent().getStringExtra("notifId");
      if (str != null)
      {
        localObject2 = data;
        ((k.a.a.e.System)localObject2).set(str);
        k.a.a.m.Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
    boolean bool;
    try
    {
      localObject2 = getIntent().getStringExtra("dialogMsg");
      localObject1 = getIntent().getStringExtra("showRating");
      localObject3 = getIntent().getStringExtra("share");
      if (paramBundle == null)
      {
        if (localObject2 != null)
        {
          localObject1 = getIntent().getStringExtra("title");
          paramBundle = (Bundle)localObject1;
          bool = ((String)localObject1).equalsIgnoreCase("");
          if (bool) {
            paramBundle = getResources().getString(2131755289);
          }
          a(this, paramBundle, (String)localObject2);
        }
        else if (localObject1 != null)
        {
          init(this);
        }
        else if (localObject3 != null)
        {
          onEvent();
        }
      }
      else if (localObject2 != null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("PREF_NOTIF_DIALOG_CANCELLED...........................");
        localObject1 = type;
        localObject3 = k.a.a.m.f.cursor;
        paramBundle.append(((k.a.a.m.f)localObject1).get((String)localObject3, "false"));
        paramBundle.toString();
        paramBundle = type;
        localObject1 = k.a.a.m.f.cursor;
        bool = paramBundle.get((String)localObject1, "false").equalsIgnoreCase("false");
        if (bool)
        {
          localObject1 = getIntent().getStringExtra("title");
          paramBundle = (Bundle)localObject1;
          bool = ((String)localObject1).equalsIgnoreCase("");
          if (bool) {
            paramBundle = getResources().getString(2131755289);
          }
          a(this, paramBundle, (String)localObject2);
        }
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append((Exception)paramBundle);
    }
    context = ((CircleImageView)findViewById(2131297986));
    location = ((TextView)findViewById(2131297982));
    description = ((TextView)findViewById(2131297983));
    username = ((TextView)findViewById(2131297985));
    paramBundle = context;
    Object localObject1 = new Ak(this);
    ((ImageView)paramBundle).setOnClickListener((View.OnClickListener)localObject1);
    paramBundle = type;
    localObject1 = k.a.a.m.f.width;
    try
    {
      j = Integer.parseInt(paramBundle.get((String)localObject1, k.a.a.m.Log.getVersion(this)));
      int k = Integer.parseInt(k.a.a.m.Log.getVersion(this));
      paramBundle = new StringBuilder();
      paramBundle.append("appVersion : ");
      paramBundle.append(k);
      paramBundle.toString();
      paramBundle = new StringBuilder();
      paramBundle.append("newVersion : ");
      paramBundle.append(j);
      paramBundle.toString();
      if (j > k)
      {
        paramBundle = type;
        localObject1 = k.a.a.m.f.w;
        bool = paramBundle.get((String)localObject1, "true").equalsIgnoreCase("true");
        if (bool)
        {
          a(false);
          return;
        }
        a(true);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
  }
  
  private void onEvent()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.TEXT", type.get(k.a.a.m.f.line, getResources().getString(2131755527)));
    localIntent.setType("text/plain");
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      k.a.a.m.StringBuilder.append(localActivityNotFoundException);
      Toast.makeText(this, getResources().getString(2131755998), 1).show();
    }
  }
  
  private void onPostExecute()
  {
    started = true;
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131493195, false);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131297186);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131298035);
    localTextView1.setOnClickListener((View.OnClickListener)new Uk(this, localDialog));
    localTextView2.setOnClickListener((View.OnClickListener)new Vk(this, localDialog));
  }
  
  private void onPostExecute(k.a.a.c.y paramY)
  {
    k.a.a.m.Log.update(this, null, "Message Board", "clicked", "On Home Tab Screen");
    Object localObject = paramY.b();
    paramY = paramY.c();
    if (((String)localObject).equalsIgnoreCase("youtube"))
    {
      paramY = new Intent("android.intent.action.VIEW", Uri.parse(paramY));
    }
    else if (((String)localObject).equalsIgnoreCase("openAppWithDialog"))
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.get(this, MainActivity.class, "dialogMsg", paramY);
      paramY = (k.a.a.c.y)localObject;
      f.sufficientlysecure.rootcommands.util.StringBuilder.show(this, 2131755834, (Intent)localObject, "title");
    }
    else if (((String)localObject).equalsIgnoreCase("playstore"))
    {
      paramY = new Intent("android.intent.action.VIEW", Uri.parse(paramY));
    }
    else if (((String)localObject).equalsIgnoreCase("browser"))
    {
      paramY = new Intent("android.intent.action.VIEW", Uri.parse(paramY));
    }
    else
    {
      String str1;
      if (((String)localObject).equalsIgnoreCase("webview"))
      {
        paramY = paramY.split("\\|");
        str1 = paramY[0];
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.get(this, BrowserScreen.class, "title", paramY[1]);
        paramY = (k.a.a.c.y)localObject;
        ((Intent)localObject).putExtra("url", str1);
      }
      for (;;)
      {
        break;
        if (((String)localObject).equalsIgnoreCase("rating"))
        {
          paramY = f.sufficientlysecure.rootcommands.util.StringBuilder.get(this, MainActivity.class, "showRating", "showRating");
        }
        else if (((String)localObject).equalsIgnoreCase("share"))
        {
          paramY = f.sufficientlysecure.rootcommands.util.StringBuilder.get(this, MainActivity.class, "share", "share");
        }
        else if (((String)localObject).equalsIgnoreCase("openAppWithTab"))
        {
          paramY = f.sufficientlysecure.rootcommands.util.StringBuilder.get(this, MainActivity.class, "openAppWithTab", paramY);
        }
        else if (((String)localObject).equalsIgnoreCase("openAppWithScreen"))
        {
          if (paramY.equalsIgnoreCase("settings")) {
            paramY = new Intent(this, SettingScreen.class);
          } else if (paramY.equalsIgnoreCase("help")) {
            paramY = new Intent(this, HelpScreen.class);
          } else if (paramY.equalsIgnoreCase("social")) {
            paramY = new Intent(this, SocialMediaAccountScreen.class);
          } else if (paramY.equalsIgnoreCase("aadhaar")) {
            paramY = new Intent(this, AadhaarProfileScreen.class);
          } else if (paramY.equalsIgnoreCase("feedback")) {
            paramY = new Intent(this, FeedbackScreen.class);
          } else if (paramY.equalsIgnoreCase("accountsettings")) {
            paramY = new Intent(this, AccountSettingScreen.class);
          } else if (paramY.equalsIgnoreCase("myprofile")) {
            paramY = new Intent(this, MyProfileScreen.class);
          } else if (paramY.equalsIgnoreCase("myprofilegeneral")) {
            paramY = new Intent(this, MyProfileGeneral.class);
          } else {
            paramY = new Intent(this, MainActivity.class);
          }
        }
        else if (((String)localObject).equalsIgnoreCase("service"))
        {
          paramY = paramY.split("\\|");
          str1 = paramY[0];
          localObject = paramY[1];
          String str2 = paramY[2];
          if (str2 != null)
          {
            if (!str2.equalsIgnoreCase(""))
            {
              paramY = data.read(str2);
              if (paramY != null)
              {
                paramY.getText();
                paramY = paramY.getValue();
              }
              else
              {
                paramY = getResources().getString(2131755289);
              }
              if ((localObject != null) && (!((String)localObject).equalsIgnoreCase(""))) {
                paramY = (k.a.a.c.y)localObject;
              }
              localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.get(this, WebActivity.class, "fromNotif", "fromNotif");
              ((Intent)localObject).putExtra("service_name", paramY);
              ((Intent)localObject).putExtra("service_url", str1);
              ((Intent)localObject).putExtra("service_id", str2);
              paramY = (k.a.a.c.y)localObject;
            }
            else
            {
              paramY = new Intent(this, MainActivity.class);
            }
          }
          else {
            paramY = new Intent(this, MainActivity.class);
          }
        }
        else
        {
          paramY = new Intent(this, MainActivity.class);
        }
      }
    }
    startActivity(paramY);
    c.setVisibility(8);
  }
  
  private void parse()
  {
    Object localObject = type;
    String str = k.a.a.m.f.port;
    try
    {
      boolean bool = ((k.a.a.m.f)localObject).get(str, "true").equalsIgnoreCase("false");
      if (bool)
      {
        localObject = type;
        str = k.a.a.m.f.EXECUTABLE;
        bool = ((k.a.a.m.f)localObject).get(str, "false").equalsIgnoreCase("true");
        if (bool)
        {
          localObject = type;
          str = k.a.a.m.f.unknownObjectType;
          bool = Boolean.parseBoolean(((k.a.a.m.f)localObject).get(str, "true"));
          bool ^= true;
          if (bool)
          {
            k.a.a.m.Log.show(this, bool, "nonMandatoryDialog", "");
            return;
          }
          k.a.a.m.Log.show(this, bool, "mandatoryDialog", "");
        }
      }
      else
      {
        localObject = type;
        str = k.a.a.m.f.readCurs;
        bool = ((k.a.a.m.f)localObject).get(str, "false").equalsIgnoreCase("false");
        if (bool)
        {
          localObject = getIntent().getStringExtra("fromLogin");
          if (localObject != null)
          {
            bool = ((String)localObject).equalsIgnoreCase("true");
            if (bool)
            {
              k.a.a.m.Log.init(this, true, "");
              return;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append((Exception)localException);
    }
  }
  
  private void registerNetworkReceiver()
  {
    Fa localFa = new Fa(new Lk(this), this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    headsetPlugReceiver = ((BroadcastReceiver)localFa.c());
    registerReceiver(headsetPlugReceiver, localIntentFilter);
  }
  
  private void save()
  {
    running = true;
    Object localObject1 = Ha.a;
    Handler localHandler;
    try
    {
      localObject1 = ((Handler)localObject1).obtainMessage();
      what = 100;
      obj = "refreshBanner";
      localHandler = Ha.a;
      localHandler.sendMessage((Message)localObject1);
    }
    catch (Exception localException1)
    {
      k.a.a.m.StringBuilder.append(localException1);
    }
    Object localObject2 = ma.a;
    try
    {
      localObject2 = ((Handler)localObject2).obtainMessage();
      what = 100;
      localHandler = ma.a;
      localHandler.sendMessage((Message)localObject2);
    }
    catch (Exception localException2)
    {
      k.a.a.m.StringBuilder.append(localException2);
    }
    Object localObject3 = Xb.a;
    try
    {
      localObject3 = ((Handler)localObject3).obtainMessage();
      what = 100;
      obj = "refreshBanner";
      localHandler = Xb.a;
      localHandler.sendMessage((Message)localObject3);
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
    localObject3 = k.a.a.h.y.a;
    try
    {
      localObject3 = ((Handler)localObject3).obtainMessage();
      what = 100;
      localHandler = k.a.a.h.y.a;
      localHandler.sendMessage((Message)localObject3);
    }
    catch (Exception localException4)
    {
      for (;;) {}
    }
    localObject3 = ua.a;
    try
    {
      localObject3 = ((Handler)localObject3).obtainMessage();
      what = 100;
      localHandler = ua.a;
      localHandler.sendMessage((Message)localObject3);
    }
    catch (Exception localException5)
    {
      for (;;) {}
    }
    call();
    new Handler().postDelayed((Runnable)new Ck(this), 3000L);
  }
  
  private void show(View paramView)
  {
    int j = view.getLeft();
    int k = view.getRight();
    int m = view.getTop();
    int n = view.getBottom();
    int i1 = Math.max(view.getWidth(), view.getHeight());
    if (Build.VERSION.SDK_INT >= 22)
    {
      Animator localAnimator = ViewAnimationUtils.createCircularReveal(paramView, k + j, n + m, 0.0F, i1);
      paramView.setVisibility(0);
      localAnimator.setDuration(getResources().getInteger(2131361796));
      localAnimator.setInterpolator(new AccelerateInterpolator());
      localAnimator.start();
      localAnimator.addListener((Animator.AnimatorListener)new dl(this, paramView));
      return;
    }
    doInBackground();
  }
  
  public void a()
  {
    Object localObject1 = new k.a.a.m.f(this);
    x = type.get(k.a.a.m.f.S, "true");
    String str = k.a.a.m.f.top;
    int j;
    try
    {
      j = Integer.parseInt(((k.a.a.m.f)localObject1).get(str, "101"));
    }
    catch (Exception localException4)
    {
      k.a.a.m.StringBuilder.append(localException4);
      j = 0;
    }
    Object localObject3 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("isProfileBottomBarUserClosed : ");
    ((StringBuilder)localObject3).append(x);
    ((StringBuilder)localObject3).toString();
    if ((x.equalsIgnoreCase("true")) && (j >= 0) && (j < 100))
    {
      if ((f.getVisibility() == 8) && (c.getVisibility() == 8))
      {
        localObject3 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("PC VALUE ===>> ");
        ((StringBuilder)localObject3).append(((k.a.a.m.f)localObject1).get(k.a.a.m.f.top, "101"));
        ((StringBuilder)localObject3).toString();
        if (((k.a.a.m.f)localObject1).get(k.a.a.m.f.top, "101").length() > 0) {
          localObject1 = ((k.a.a.m.f)localObject1).get(k.a.a.m.f.top, "101");
        } else {
          localObject1 = "0";
        }
        localObject3 = current;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(" %");
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        localObject3 = new LinearLayout.LayoutParams(-1, dpToPx(20));
        weight = 1.0F;
        ((ViewGroup.MarginLayoutParams)localObject3).setMargins(18, 0, 18, 0);
        progressBar.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        try
        {
          j = Integer.parseInt((String)localObject1);
        }
        catch (Exception localException1)
        {
          k.a.a.m.StringBuilder.append(localException1);
          j = 0;
        }
        float f1 = j / 100.0F;
        float f2 = (100 - j) / 100.0F;
        Object localObject2 = new LinearLayout.LayoutParams(0, -1);
        weight = f1;
        progressView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = new LinearLayout.LayoutParams(0, -1);
        weight = f2;
        emptyView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        try
        {
          localObject3 = new k.a.a.m.System(this);
          ((k.a.a.m.System)localObject3).getName();
          boolean bool = ((k.a.a.m.System)localObject3).getName().equalsIgnoreCase("M");
          if (bool)
          {
            localObject2 = i;
            ((CircleImageView)localObject2).setImageResource(2131231235);
          }
          else
          {
            bool = ((k.a.a.m.System)localObject3).getName().equalsIgnoreCase("F");
            if (bool)
            {
              localObject2 = i;
              ((CircleImageView)localObject2).setImageResource(2131231042);
            }
            else
            {
              bool = ((k.a.a.m.System)localObject3).getName().equalsIgnoreCase("T");
              if (bool)
              {
                localObject2 = i;
                ((CircleImageView)localObject2).setImageResource(2131231690);
              }
            }
          }
          int k = ((k.a.a.m.System)localObject3).getBookmarks().length();
          if (k > 0)
          {
            localObject2 = d;
            localObject3 = ((k.a.a.m.System)localObject3).getBookmarks();
            Object localObject5 = i;
            localObject4 = a;
            a localA = b;
            localObject5 = (ImageView)localObject5;
            ((f.l.a.b.f)localObject2).a((String)localObject3, (ImageView)localObject5, (ClassWriter)localObject4, localA);
          }
          else
          {
            try
            {
              bool = ((k.a.a.m.System)localObject3).getName().equalsIgnoreCase("M");
              if (bool)
              {
                localObject2 = i;
                ((CircleImageView)localObject2).setImageResource(2131231235);
              }
              else
              {
                bool = ((k.a.a.m.System)localObject3).getName().equalsIgnoreCase("F");
                if (bool)
                {
                  localObject2 = i;
                  ((CircleImageView)localObject2).setImageResource(2131231042);
                }
                else
                {
                  bool = ((k.a.a.m.System)localObject3).getName().equalsIgnoreCase("T");
                  if (bool)
                  {
                    localObject2 = i;
                    ((CircleImageView)localObject2).setImageResource(2131231690);
                  }
                  else
                  {
                    localObject2 = i;
                    ((CircleImageView)localObject2).setImageResource(2131231690);
                  }
                }
              }
            }
            catch (Exception localException2)
            {
              k.a.a.m.StringBuilder.append(localException2);
              CircleImageView localCircleImageView = i;
              localCircleImageView.setImageResource(2131231690);
            }
          }
          if (j > 70) {
            break label749;
          }
        }
        catch (Exception localException3)
        {
          i.setImageResource(2131231690);
          k.a.a.m.StringBuilder.append((Exception)localException3);
        }
        if (!this$0.isShown())
        {
          l.setVisibility(0);
          getItem();
          return;
          label749:
          l.setVisibility(8);
        }
      }
    }
    else {
      l.setVisibility(8);
    }
  }
  
  public void add()
  {
    JSONObject localJSONObject;
    try
    {
      Object localObject2 = k.a.a.m.Log.execute(this);
      Object localObject1 = localObject2;
      Object localObject3 = type;
      String str = k.a.a.m.f.g;
      ((JSONObject)localObject2).put("mno", ((k.a.a.m.f)localObject3).get(str, ""));
      localObject3 = type;
      str = k.a.a.m.f.key;
      boolean bool = ((k.a.a.m.f)localObject3).get(str, "false").equalsIgnoreCase("true");
      if (bool)
      {
        ((JSONObject)localObject2).put("ldate", "NR");
        localObject2 = type;
        localObject3 = k.a.a.m.f.key;
        ((k.a.a.m.f)localObject2).append((String)localObject3, "false");
      }
      else
      {
        localObject3 = type;
        str = k.a.a.m.f.leafChildren;
        bool = ((k.a.a.m.f)localObject3).get(str, "false").equalsIgnoreCase("false");
        if (bool)
        {
          localObject3 = type;
          str = k.a.a.m.f.index;
          ((k.a.a.m.f)localObject3).append(str, "");
        }
        localObject3 = type;
        str = k.a.a.m.f.OTHER;
        bool = ((k.a.a.m.f)localObject3).get(str, "false").equalsIgnoreCase("false");
        if (bool)
        {
          localObject3 = type;
          str = k.a.a.m.f.index;
          ((k.a.a.m.f)localObject3).append(str, "");
          localObject3 = type;
          str = k.a.a.m.f.TAG;
          ((k.a.a.m.f)localObject3).append(str, "");
        }
        localObject3 = type;
        str = k.a.a.m.f.containerChildren;
        bool = ((k.a.a.m.f)localObject3).get(str, "false").equalsIgnoreCase("false");
        if (bool)
        {
          localObject3 = type;
          str = k.a.a.m.f.index;
          ((k.a.a.m.f)localObject3).append(str, "");
        }
        localObject3 = type;
        str = k.a.a.m.f.syncKey;
        bool = ((k.a.a.m.f)localObject3).get(str, "false").equalsIgnoreCase("false");
        if (bool)
        {
          localObject3 = type;
          str = k.a.a.m.f.index;
          ((k.a.a.m.f)localObject3).append(str, "");
        }
        localObject3 = type;
        str = k.a.a.m.f.index;
        ((JSONObject)localObject2).put("ldate", ((k.a.a.m.f)localObject3).get(str, ""));
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append((Exception)localException);
      localJSONObject = null;
    }
    if (localJSONObject != null) {
      ((AsyncTask)new j((k.a.a.i.List)new Bk(this), localJSONObject, this)).execute(new Object[0]);
    }
  }
  
  public void init()
  {
    try
    {
      Object localObject1 = new k.a.a.m.System(this).get();
      Object localObject2 = nextButton;
      ((View)localObject2).setVisibility(0);
      localObject2 = webView;
      ((View)localObject2).setVisibility(8);
      localObject2 = preferences;
      Object localObject3 = new Kk(this);
      localObject3 = (View.OnClickListener)localObject3;
      ((View)localObject2).setOnClickListener((View.OnClickListener)localObject3);
      int j = ((i)localObject1).getData().length();
      if (j > 0)
      {
        localObject2 = username;
        ((TextView)localObject2).setText(((i)localObject1).getData());
        localObject2 = username;
        ((View)localObject2).setVisibility(0);
        localObject2 = location;
        ((View)localObject2).setVisibility(0);
      }
      else
      {
        localObject2 = username;
        ((TextView)localObject2).setText("");
      }
      localObject2 = (ImageView)context;
      ((ImageView)localObject2).setVisibility(8);
      boolean bool = ((i)localObject1).getValue().equalsIgnoreCase("M");
      if (bool)
      {
        localObject2 = (ImageView)context;
        ((ImageView)localObject2).setVisibility(0);
        localObject2 = context;
        ((CircleImageView)localObject2).setImageResource(2131231235);
      }
      else
      {
        bool = ((i)localObject1).getValue().equalsIgnoreCase("F");
        if (bool)
        {
          localObject2 = (ImageView)context;
          ((ImageView)localObject2).setVisibility(0);
          localObject2 = context;
          ((CircleImageView)localObject2).setImageResource(2131231042);
        }
        else
        {
          bool = ((i)localObject1).getValue().equalsIgnoreCase("T");
          if (bool)
          {
            localObject2 = (ImageView)context;
            ((ImageView)localObject2).setVisibility(0);
            localObject2 = context;
            ((CircleImageView)localObject2).setImageResource(2131231690);
          }
          else
          {
            localObject2 = (ImageView)context;
            ((ImageView)localObject2).setVisibility(0);
            localObject2 = context;
            ((CircleImageView)localObject2).setImageResource(2131231690);
          }
        }
      }
      j = ((i)localObject1).add().length();
      if (j > 0)
      {
        localObject2 = (ImageView)context;
        ((ImageView)localObject2).setVisibility(0);
        localObject2 = d;
        localObject3 = ((i)localObject1).add();
        Object localObject4 = context;
        ClassWriter localClassWriter = a;
        a localA = b;
        localObject4 = (ImageView)localObject4;
        ((f.l.a.b.f)localObject2).a((String)localObject3, (ImageView)localObject4, localClassWriter, localA);
      }
      bool = ((i)localObject1).get().trim().equalsIgnoreCase("");
      if (!bool)
      {
        localObject2 = description;
        ((TextView)localObject2).setText(((i)localObject1).get());
      }
      else
      {
        localObject2 = description;
        ((TextView)localObject2).setText("");
      }
      localObject2 = location;
      ((View)localObject2).setVisibility(0);
      j = ((i)localObject1).getTitle().length();
      if (j > 0)
      {
        j = ((i)localObject1).getName().length();
        if (j > 0)
        {
          localObject2 = location;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(k.a.a.m.Log.get(((i)localObject1).getTitle()));
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append(((i)localObject1).getName());
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
          return;
        }
      }
      j = ((i)localObject1).getName().length();
      if (j > 0)
      {
        localObject2 = location;
        ((TextView)localObject2).setText(((i)localObject1).getName());
        return;
      }
      j = ((i)localObject1).getTitle().length();
      if (j > 0)
      {
        localObject2 = location;
        ((TextView)localObject2).setText(k.a.a.m.Log.get(((i)localObject1).getTitle()));
        return;
      }
      localObject1 = location;
      ((TextView)localObject1).setText("");
      return;
    }
    catch (Exception localException)
    {
      nextButton.setVisibility(8);
      webView.setVisibility(0);
      k.a.a.m.StringBuilder.append((Exception)localException);
    }
  }
  
  public void onBackPressed()
  {
    Object localObject1 = mDrawerLayout;
    try
    {
      boolean bool = ((DrawerLayout)localObject1).isDrawerOpen(8388611);
      if (bool)
      {
        localObject1 = mDrawerLayout;
        ((DrawerLayout)localObject1).closeDrawer(8388611);
        result = false;
        return;
      }
      if (result)
      {
        super.onBackPressed();
        return;
      }
      result = true;
      Toast.makeText(this, getResources().getString(2131756161), 0).show();
      localObject1 = new Handler();
      Object localObject2 = new Ek(this);
      localObject2 = (Runnable)localObject2;
      ((Handler)localObject1).postDelayed((Runnable)localObject2, 2000L);
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (state >= 0) {
      isLandscape = true;
    } else {
      isLandscape = false;
    }
    if (orientation == 2) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492912);
    if (Build.VERSION.SDK_INT >= 21) {
      getResources().getDrawable(2131231561, null);
    } else {
      getResources().getDrawable(2131231561);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getResources().getDrawable(2131230852, null);
    } else {
      getResources().getDrawable(2131230852);
    }
    mToolbar = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, mToolbar, false);
    mProgressBar = mToolbar.getRootView();
    mTextView = ((ImageView)mProgressBar.findViewById(2131297101));
    mImageView = ((ImageView)mProgressBar.findViewById(2131296675));
    mTitle = ((ImageView)mProgressBar.findViewById(2131297206));
    mContent = ((RelativeLayout)mProgressBar.findViewById(2131297199));
    mDB = ((TextView)mProgressBar.findViewById(2131297195));
    mActivity = ((TextView)mProgressBar.findViewById(2131296490));
    mStartButton = ((TextView)mProgressBar.findViewById(2131296491));
    mActivity.setVisibility(8);
    mStartButton.setVisibility(8);
    mImageView.setVisibility(8);
    background = false;
    address = "";
    root = ((LinearLayout)findViewById(2131297438));
    view = ((RelativeLayout)findViewById(2131297260));
    count = ((TextView)mProgressBar.findViewById(2131296856));
    findViewById(2131296857).setOnClickListener((View.OnClickListener)new uk(this));
    mTextView.setOnClickListener((View.OnClickListener)new Fk(this));
    mContent.setOnClickListener((View.OnClickListener)new Qk(this));
    d = f.l.a.b.f.a();
    a = f.sufficientlysecure.rootcommands.util.StringBuilder.a(true, true).get(Bitmap.Config.RGB_565).getString();
    onCreateView(paramBundle);
    onCreate();
    parse();
    try
    {
      al localAl = new al(this);
      h = (Handler)localAl;
    }
    catch (Exception localException1)
    {
      k.a.a.m.StringBuilder.append(localException1);
    }
    mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    mTabLayout.setOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener)new gl(this));
    Object localObject4;
    Object localObject3;
    boolean bool;
    try
    {
      localObject4 = getResources().getStringArray(2130903064);
      Object localObject1 = type;
      localObject3 = new StringBuilder();
      String str = k.a.a.m.f.parent;
      ((StringBuilder)localObject3).append(str);
      localObject4 = localObject4[0];
      ((StringBuilder)localObject3).append((String)localObject4);
      bool = ((k.a.a.m.f)localObject1).add(((StringBuilder)localObject3).toString(), "").equalsIgnoreCase("");
      if (bool)
      {
        localObject1 = type;
        localObject3 = k.a.a.m.f.index;
        bool = ((k.a.a.m.f)localObject1).get((String)localObject3, "").equalsIgnoreCase("");
        if (!bool)
        {
          localObject1 = new MainActivity.b(this, null);
          localObject1 = (AsyncTask)localObject1;
          ((AsyncTask)localObject1).execute(new Void[0]);
        }
      }
    }
    catch (Exception localException2)
    {
      k.a.a.m.StringBuilder.append(localException2);
    }
    if (paramBundle == null)
    {
      if (getIntent().getStringExtra("notifId") != null)
      {
        paramBundle = getIntent().getStringExtra("loadHome");
        if (paramBundle != null)
        {
          if ("true".equalsIgnoreCase(paramBundle))
          {
            add();
            performSearch();
          }
          else
          {
            running = true;
          }
        }
        else
        {
          add();
          performSearch();
        }
      }
      else
      {
        add();
        performSearch();
      }
    }
    else if (paramBundle.containsKey("homeApi")) {
      running = paramBundle.getBoolean("homeApi", false);
    }
    paramBundle = type.get(k.a.a.m.f.left, "");
    if (!paramBundle.equalsIgnoreCase(""))
    {
      Object localObject2 = type;
      localObject3 = k.a.a.m.f.e;
      try
      {
        localObject2 = ((k.a.a.m.f)localObject2).get((String)localObject3, "home");
        localObject3 = paramBundle.split(",");
        int j = 0;
        while (j < localObject3.length)
        {
          localObject4 = localObject3[j];
          localObject4 = ((String)localObject4).split("\\|");
          localObject4 = localObject4[1];
          bool = ((String)localObject4).equalsIgnoreCase((String)localObject2);
          if (bool)
          {
            localObject2 = mViewPager;
            ((ViewPager)localObject2).setCurrentItem(j);
            break;
          }
          j += 1;
        }
        if (!type.get(k.a.a.m.f.e, "home").equalsIgnoreCase("home")) {
          break label1030;
        }
      }
      catch (Exception localException3)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Dynamic tab pref value:");
        ((StringBuilder)localObject3).append(paramBundle);
        b.d(((StringBuilder)localObject3).toString());
        k.a.a.m.StringBuilder.append(localException3);
        if (type.get(k.a.a.m.f.e, "home").equalsIgnoreCase("home")) {
          mViewPager.setCurrentItem(0);
        } else if (type.get(k.a.a.m.f.e, "home").equalsIgnoreCase("fav")) {
          mViewPager.setCurrentItem(1);
        } else if (type.get(k.a.a.m.f.e, "home").equalsIgnoreCase("allservices")) {
          mViewPager.setCurrentItem(2);
        } else {
          mViewPager.setCurrentItem(0);
        }
      }
    }
    mViewPager.setCurrentItem(0);
    break label1104;
    label1030:
    if (type.get(k.a.a.m.f.e, "home").equalsIgnoreCase("fav")) {
      mViewPager.setCurrentItem(1);
    } else if (type.get(k.a.a.m.f.e, "home").equalsIgnoreCase("allservices")) {
      mViewPager.setCurrentItem(2);
    } else {
      mViewPager.setCurrentItem(0);
    }
    label1104:
    paramBundle = getIntent().getStringExtra("openAppWithTab");
    if (paramBundle != null) {
      if (paramBundle.equalsIgnoreCase("home")) {
        mViewPager.setCurrentItem(0);
      } else if (paramBundle.equalsIgnoreCase("fav")) {
        mViewPager.setCurrentItem(1);
      } else if (paramBundle.equalsIgnoreCase("allservices")) {
        mViewPager.setCurrentItem(2);
      } else {
        mViewPager.setCurrentItem(0);
      }
    }
    mPreferences.setOnClickListener((View.OnClickListener)new hl(this));
    status.setOnClickListener((View.OnClickListener)new il(this));
    messageHandler = (Handler)new jl(this);
    getSupportLoaderManager().initLoader(0, null, this);
    if (isLandscape) {
      init(this);
    }
    onActivityResult();
  }
  
  public void onCreate(String paramString)
  {
    album = paramString;
  }
  
  public Loader onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("SELECTION STR ");
      paramBundle.append("jid = 'bot@reporting.umang.gov.in' AND read = 0 AND from_me = 0");
      paramBundle.toString();
      return new CursorLoader(this, ChatProvider.CONTENT_URI, new String[] { "jid", "read", "from_me" }, "jid = 'bot@reporting.umang.gov.in' AND read = 0 AND from_me = 0", null, null);
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unknown loader id returned in LoaderCallbacks.onCreateLoader: ", paramInt);
    return null;
  }
  
  public void onLoadFinished(Loader paramLoader, Cursor paramCursor)
  {
    try
    {
      paramLoader = new StringBuilder();
      paramLoader.append("onLoadFinished === called ===");
      paramLoader.append(paramCursor.getCount());
      paramLoader.toString();
      int j = paramCursor.getCount();
      if (j > 0)
      {
        paramLoader = mActivity;
        paramLoader.setVisibility(0);
        paramLoader = mStartButton;
        paramLoader.setVisibility(0);
        paramLoader = mImageView;
        paramLoader.setVisibility(0);
        paramLoader = mActivity;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramCursor.getCount());
        paramLoader.setText(localStringBuilder.toString());
        paramLoader = mStartButton;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramCursor.getCount());
        paramLoader.setText(localStringBuilder.toString());
        return;
      }
      paramLoader = mActivity;
      paramLoader.setVisibility(8);
      paramLoader = mStartButton;
      paramLoader.setVisibility(8);
      paramLoader = mImageView;
      paramLoader.setVisibility(8);
      return;
    }
    catch (Exception paramLoader)
    {
      k.a.a.m.StringBuilder.append(paramLoader);
    }
  }
  
  public void onLoaderReset(Loader paramLoader) {}
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    Object localObject;
    try
    {
      paramIntent = getIntent().getStringExtra("notifId");
      if (paramIntent != null)
      {
        localObject = data;
        ((k.a.a.e.System)localObject).set(paramIntent);
        k.a.a.m.Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
      }
    }
    catch (Exception paramIntent)
    {
      k.a.a.m.StringBuilder.append(paramIntent);
    }
    try
    {
      String str1 = getIntent().getStringExtra("dialogMsg");
      paramIntent = getIntent().getStringExtra("showRating");
      localObject = getIntent().getStringExtra("share");
      String str2 = getIntent().getStringExtra("openAppWithTab");
      boolean bool;
      if (str1 != null)
      {
        localObject = getIntent().getStringExtra("title");
        paramIntent = (Intent)localObject;
        bool = ((String)localObject).equalsIgnoreCase("");
        if (bool) {
          paramIntent = getResources().getString(2131755289);
        }
        a(this, paramIntent, str1);
        return;
      }
      if (paramIntent != null)
      {
        init(this);
        return;
      }
      if (localObject != null)
      {
        onEvent();
        return;
      }
      if (str2 != null)
      {
        bool = str2.equalsIgnoreCase("home");
        if (bool)
        {
          paramIntent = mViewPager;
          paramIntent.setCurrentItem(0);
          return;
        }
        bool = str2.equalsIgnoreCase("fav");
        if (bool)
        {
          paramIntent = mViewPager;
          paramIntent.setCurrentItem(1);
          return;
        }
        bool = str2.equalsIgnoreCase("state");
        if (bool)
        {
          paramIntent = mViewPager;
          paramIntent.setCurrentItem(2);
          return;
        }
        bool = str2.equalsIgnoreCase("allservices");
        if (bool)
        {
          paramIntent = mViewPager;
          paramIntent.setCurrentItem(3);
          return;
        }
        paramIntent = mViewPager;
        paramIntent.setCurrentItem(0);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      k.a.a.m.StringBuilder.append(paramIntent);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    BroadcastReceiver localBroadcastReceiver = headsetPlugReceiver;
    try
    {
      unregisterReceiver(localBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("rating_saved_instance")))
    {
      state = paramBundle.getInt("rating_saved_instance", -1);
      if (state >= 0) {
        init(this);
      }
    }
    if ((paramBundle != null) && (paramBundle.containsKey("rating_playstore")))
    {
      started = paramBundle.getBoolean("rating_playstore", false);
      if (started) {
        onPostExecute();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    root.setVisibility(8);
    init();
    registerNetworkReceiver();
    a();
    if (!k.a.a.m.Log.check(this)) {
      a("", true);
    } else {
      a("", false);
    }
    try
    {
      String str1 = new k.a.a.m.System(this).getKey();
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      str2 = "";
    }
    Object localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    String str2 = data.getStatus((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifUnreadCount : ");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).toString();
    if ((!str2.equalsIgnoreCase("")) && (!str2.equalsIgnoreCase("0")))
    {
      mDB.setVisibility(0);
      mDB.setText(str2);
      return;
    }
    mDB.setVisibility(8);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("rating_saved_instance", state);
    paramBundle.putBoolean("rating_playstore", started);
    paramBundle.putBoolean("homeApi", running);
  }
  
  public void onSaveInstanceState(java.util.List paramList)
  {
    mList = paramList;
    paramList = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Message Board Array Length == ");
    paramList.append(mList.size());
    paramList.toString();
    if (mList.size() > 0)
    {
      paramList = mList;
      try
      {
        paramList = paramList.get(0);
        paramList = (k.a.a.c.y)paramList;
        return;
      }
      catch (Exception paramList)
      {
        k.a.a.m.StringBuilder.append(paramList);
      }
    }
  }
  
  public void performSearch()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = k.a.a.m.Log.execute(this);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new Yk(this), "https://app.umang.gov.in/umang/coreapi/ws2/fstqu", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  public void process(String paramString)
  {
    Object localObject1 = type;
    Object localObject2 = k.a.a.m.f.left;
    try
    {
      localObject1 = ((k.a.a.m.f)localObject1).get((String)localObject2, "");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dynamicTabsData......................");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).toString();
      boolean bool = ((String)localObject1).equalsIgnoreCase("");
      if (!bool)
      {
        localObject1 = ((String)localObject1).split(",");
        int j = 0;
        while (j < localObject1.length)
        {
          localObject2 = localObject1[j];
          localObject2 = ((String)localObject2).split("\\|");
          Object localObject3 = localObject2[0];
          localObject2 = localObject2[1];
          bool = ((String)localObject2).equalsIgnoreCase("state");
          if (bool)
          {
            localObject2 = type;
            localObject3 = k.a.a.m.f.elements;
            bool = ((k.a.a.m.f)localObject2).get((String)localObject3, "").equalsIgnoreCase("");
            if (!bool)
            {
              localObject2 = mTabLayout;
              localObject2 = ((TabLayout)localObject2).getTabAt(j);
              localObject3 = ((TabLayout.Tab)localObject2).getCustomView();
              localObject3 = (TextView)localObject3;
              ((TabLayout.Tab)localObject2).setText(paramString);
              ((View)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            }
          }
          j += 1;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
    }
  }
}
