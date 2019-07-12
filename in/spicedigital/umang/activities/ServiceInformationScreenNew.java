package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.like.LikeButton;
import f.l.a.b.ClassWriter;
import internal.view.menu.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import k.a.a.a.Aq;
import k.a.a.a.Bq;
import k.a.a.a.Cq;
import k.a.a.a.hq;
import k.a.a.a.iq;
import k.a.a.a.jq;
import k.a.a.a.kq;
import k.a.a.a.lq;
import k.a.a.a.nq;
import k.a.a.a.oq;
import k.a.a.a.pq;
import k.a.a.a.qq;
import k.a.a.a.rq;
import k.a.a.a.sq;
import k.a.a.a.tq;
import k.a.a.a.uq;
import k.a.a.a.vq;
import k.a.a.a.wq;
import k.a.a.a.xq;
import k.a.a.a.yq;
import k.a.a.a.zq;
import k.a.a.c.i;
import k.a.a.c.j;
import k.a.a.h.Ha;
import k.a.a.h.Xb;
import k.a.a.h.ma;
import k.a.a.h.ua;
import k.a.a.h.y;
import k.a.a.l.z;
import me.kaede.tagview.TagView;
import org.json.JSONObject;
import support.android.v4.content.ContextCompat;

public class ServiceInformationScreenNew
  extends BaseActivity
{
  public boolean D = false;
  public String a;
  public String album;
  public ClassWriter b;
  public LinearLayout buttons;
  public f.l.a.b.f c;
  public TextView cancelButton;
  public LinearLayout content;
  public boolean context;
  public TextView current;
  public TextView d;
  public TextView data;
  public TextView date;
  public View deleteItem;
  public String descr;
  public String description;
  public String e = "";
  public String f;
  public TextView from;
  public ImageView g;
  public String h;
  public TextView header;
  public ImageView homeButton;
  public String i;
  public String id;
  public ImageView image;
  public ImageView info;
  public TextView j;
  public TextView k;
  public k.a.a.e.System l;
  public TextView label;
  public String last = "";
  public String link;
  public AppBarLayout listener;
  public View mCancelButton;
  public CardView mCardView;
  public TextView mFilename;
  public View mLoadingView;
  public k mPopup;
  public ScrollView mScrollView;
  public String mTimeZone;
  public RatingBar mTitleView;
  public Toolbar mToolbar;
  public ViewGroup mViewGroup;
  public View mViewPager;
  public View moreArtistsButton;
  public String n;
  public String name;
  public String nr = "";
  public LinearLayout o;
  public TextView outputView;
  public String p;
  public String pattern;
  public LinearLayout playButton;
  public LinearLayout previousButton;
  public TextView progress;
  public ProgressBar progressView;
  public String q = "ServiceInformation";
  public String result = "";
  public TextView runtime;
  public String s;
  public ImageView settings;
  public String site = "";
  public CardView status;
  public String t;
  public LinearLayout tabsContainer;
  public LikeButton task;
  public String text;
  public k.a.a.m.f this$0;
  public View time;
  public String title;
  public TextView tv;
  public RatingBar type;
  public LinearLayout u;
  public TextView uri;
  public TagView v;
  public TextView value;
  public RatingBar version;
  public String versionName;
  public LinearLayout view;
  public String x = "";
  public boolean z = false;
  public int zone = 0;
  
  public ServiceInformationScreenNew() {}
  
  private void a()
  {
    Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("SERVICE_DESCP...................");
    ((StringBuilder)localObject1).append(h);
    ((StringBuilder)localObject1).toString();
    localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("SERVICE_IMG...................");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).toString();
    c.a(i, g, b);
    value.setText(Html.fromHtml(descr));
    label.setText(id);
    d.setText(f);
    current.setText(f);
    j.setText(versionName);
    version.setRating(Float.parseFloat(versionName));
    header.setText(s);
    localObject1 = p;
    ArrayList localArrayList = new ArrayList();
    o.removeAllViews();
    Object localObject3 = s.split(",");
    int m = 0;
    while (m < localObject3.length)
    {
      a(o, localObject3[m], "category");
      m += 1;
    }
    if (((String)localObject1).equalsIgnoreCase("99"))
    {
      localArrayList.add(getResources().getString(2131755364));
    }
    else
    {
      Object localObject4 = pattern;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("otherStates:");
      ((StringBuilder)localObject3).append((String)localObject4);
      ((StringBuilder)localObject3).toString();
      if (((String)localObject4).equalsIgnoreCase(""))
      {
        localArrayList.add(k.a.a.m.Log.get(this, (String)localObject1));
      }
      else
      {
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject1);
        localObject1 = ((String)localObject4).split("\\|");
        m = 0;
        while (m < localObject1.length)
        {
          if ((!localObject1[m].equalsIgnoreCase("")) && (!((ArrayList)localObject3).contains(localObject1[m]))) {
            ((ArrayList)localObject3).add(localObject1[m]);
          }
          m += 1;
        }
        localObject1 = this$0;
        localObject4 = k.a.a.m.f.this$0;
        try
        {
          boolean bool = ((k.a.a.m.f)localObject1).get((String)localObject4, "").isEmpty();
          if (!bool)
          {
            localObject1 = new k.a.a.m.System(this).get();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("userObj.getUserStateID()=");
            ((StringBuilder)localObject4).append(((i)localObject1).getItem());
            ((StringBuilder)localObject4).toString();
            m = ((i)localObject1).getItem();
            if (m != 0)
            {
              m = ((i)localObject1).getItem();
              if (m != -1)
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("");
                ((StringBuilder)localObject4).append(((i)localObject1).getItem());
                localObject1 = ((StringBuilder)localObject4).toString();
                break label519;
              }
            }
            localObject1 = "";
            label519:
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("profileState:");
            ((StringBuilder)localObject4).append((String)localObject1);
            ((StringBuilder)localObject4).toString();
            localObject4 = this$0;
            String str2 = k.a.a.m.f.f;
            localObject4 = ((k.a.a.m.f)localObject4).get(str2, "");
            bool = ((ArrayList)localObject3).contains(localObject1);
            if (bool)
            {
              localArrayList.add(k.a.a.m.Log.get(this, (String)localObject1));
              ((ArrayList)localObject3).remove(localObject1);
            }
            bool = ((ArrayList)localObject3).contains(localObject4);
            if (bool)
            {
              localArrayList.add(k.a.a.m.Log.get(this, (String)localObject4));
              ((ArrayList)localObject3).remove(localObject4);
            }
          }
          localObject1 = new ArrayList();
          m = 0;
          for (;;)
          {
            int i1 = ((ArrayList)localObject3).size();
            if (m >= i1) {
              break;
            }
            localObject4 = ((ArrayList)localObject3).get(m);
            localObject4 = (String)localObject4;
            ((ArrayList)localObject1).add(k.a.a.m.Log.get(this, (String)localObject4));
            m += 1;
          }
          localObject3 = String.CASE_INSENSITIVE_ORDER;
          Collections.sort((java.util.List)localObject1, (Comparator)localObject3);
          localArrayList.addAll((Collection)localObject1);
        }
        catch (Exception localException1)
        {
          k.a.a.m.StringBuilder.append(localException1);
        }
      }
    }
    m = 0;
    while (m < localArrayList.size())
    {
      a(o, (String)localArrayList.get(m), "state");
      m += 1;
    }
    if (n.equalsIgnoreCase(""))
    {
      u.setVisibility(8);
    }
    else
    {
      u.setVisibility(0);
      Object localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("SERVICE_OTHER_WEBSITES : ");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).toString();
      localObject2 = n;
      try
      {
        localObject2 = ((String)localObject2).split("\\|");
        m = 0;
        while (m < localObject2.length)
        {
          localArrayList = localObject2[m];
          localObject3 = localArrayList.split("\\#");
          localArrayList = localObject3[0];
          localObject3 = localObject3[1];
          show(localArrayList, (String)localObject3);
          m += 1;
        }
        str1 = Html.fromHtml(h).toString();
      }
      catch (Exception localException2)
      {
        k.a.a.m.StringBuilder.append(localException2);
      }
    }
    String str1;
    k.setText(str1.trim());
    k.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new jq(this));
    clear();
    cancelButton.setOnClickListener((View.OnClickListener)new kq(this));
  }
  
  private void a(float paramFloat)
  {
    Dialog localDialog = new Dialog(this);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131492999);
    localDialog.setCancelable(true);
    EditText localEditText = (EditText)localDialog.findViewById(2131296611);
    localEditText.setText(e);
    localEditText.setSelection(localEditText.getText().length());
    Object localObject = (ImageView)localDialog.findViewById(2131297533);
    c.a(i, (ImageView)localObject, b);
    ((TextView)localDialog.findViewById(2131297542)).setText(f);
    localObject = (RatingBar)localDialog.findViewById(2131297352);
    ImageView localImageView = (ImageView)localDialog.findViewById(2131297586);
    TextView localTextView = (TextView)localDialog.findViewById(2131297657);
    ((RatingBar)localObject).setRating(paramFloat);
    if (paramFloat <= 1.0F) {
      localImageView.setImageResource(2131231493);
    } else if (paramFloat == 2.0F) {
      localImageView.setImageResource(2131231494);
    } else if (paramFloat == 3.0F) {
      localImageView.setImageResource(2131231495);
    } else if (paramFloat == 4.0F) {
      localImageView.setImageResource(2131231496);
    } else if (paramFloat == 5.0F) {
      localImageView.setImageResource(2131231497);
    } else {
      localImageView.setImageResource(2131231497);
    }
    ((RatingBar)localObject).setOnRatingBarChangeListener((RatingBar.OnRatingBarChangeListener)new oq(this, localImageView));
    localTextView.setOnClickListener((View.OnClickListener)new pq(this, (RatingBar)localObject, localDialog, localEditText));
    localDialog.setOnCancelListener((DialogInterface.OnCancelListener)new qq(this));
    localDialog.show();
  }
  
  private void a(LinearLayout paramLinearLayout, String paramString1, String paramString2)
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131492971, paramLinearLayout, false);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131296956);
    localTextView.setText(paramString1);
    if (paramString2.equalsIgnoreCase("category"))
    {
      localTextView.setBackgroundResource(2131231429);
      localTextView.setTextColor(ContextCompat.getColor(this, 2131100006));
    }
    else
    {
      localTextView.setBackgroundResource(2131231431);
      localTextView.setTextColor(ContextCompat.getColor(this, 2131100006));
    }
    localTextView.setAllCaps(true);
    paramLinearLayout.addView(localViewGroup);
  }
  
  private void a(String paramString)
  {
    paramString = new n.a.a.d(paramString.toUpperCase());
    c = ContextCompat.getColor(this, 2131100006);
    g = false;
    d = 12.0F;
    e = ContextCompat.getColor(this, 2131099946);
    m = ContextCompat.getColor(this, 2131099946);
    l = 1.0F;
    h = ContextCompat.getColor(this, 2131099895);
    v.a(paramString);
    ((RelativeLayout)v).invalidate();
  }
  
  private void add(String paramString)
  {
    JSONObject localJSONObject1;
    try
    {
      JSONObject localJSONObject2 = k.a.a.m.Log.execute(this);
      localJSONObject1 = localJSONObject2;
      k.a.a.m.f localF = this$0;
      String str = k.a.a.m.f.g;
      localJSONObject2.put("mno", localF.get(str, ""));
      localJSONObject2.put("sid", paramString);
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
      localJSONObject1 = null;
    }
    if (localJSONObject1 != null) {
      new k.a.a.l.List((k.a.a.i.List)new nq(this), "https://app.umang.gov.in/umang/coreapi/ws2/fur", localJSONObject1, this).execute(new Object[0]);
    }
  }
  
  private void add(String paramString1, String paramString2, String paramString3)
  {
    z = false;
    JSONObject localJSONObject1;
    try
    {
      JSONObject localJSONObject2 = k.a.a.m.Log.execute(this);
      localJSONObject1 = localJSONObject2;
      k.a.a.m.f localF = this$0;
      String str = k.a.a.m.f.g;
      localJSONObject2.put("mno", localF.get(str, ""));
      localJSONObject2.put("sid", paramString2);
      localJSONObject2.put("rating", paramString1.substring(0, 1));
      localJSONObject2.put("comt", paramString3);
    }
    catch (Exception paramString2)
    {
      k.a.a.m.StringBuilder.append(paramString2);
      localJSONObject1 = null;
    }
    if (localJSONObject1 != null) {
      new k.a.a.l.List((k.a.a.i.List)new rq(this, paramString1), "https://app.umang.gov.in/umang/coreapi/ws2/ratedpt", localJSONObject1, this).execute(new Object[0]);
    }
  }
  
  private void b(String paramString)
  {
    v.a();
    paramString = new n.a.a.d(paramString.toUpperCase());
    c = ContextCompat.getColor(this, 2131100006);
    g = false;
    d = 12.0F;
    e = ContextCompat.getColor(this, 2131099944);
    m = ContextCompat.getColor(this, 2131099944);
    l = 1.0F;
    h = ContextCompat.getColor(this, 2131099895);
    v.a(paramString);
    ((RelativeLayout)v).invalidate();
  }
  
  private void clear()
  {
    if (context)
    {
      task.setLiked(Boolean.valueOf(true));
      return;
    }
    task.setLiked(Boolean.valueOf(false));
  }
  
  private void close()
  {
    Object localObject1 = Ha.a;
    Handler localHandler;
    try
    {
      localObject1 = ((Handler)localObject1).obtainMessage();
      what = 100;
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
      localHandler = Xb.a;
      localHandler.sendMessage((Message)localObject3);
    }
    catch (Exception localException3)
    {
      k.a.a.m.StringBuilder.append(localException3);
    }
    Object localObject4 = y.a;
    try
    {
      localObject4 = ((Handler)localObject4).obtainMessage();
      what = 100;
      localHandler = y.a;
      localHandler.sendMessage((Message)localObject4);
    }
    catch (Exception localException4)
    {
      k.a.a.m.StringBuilder.append(localException4);
    }
    Object localObject5 = ua.a;
    try
    {
      localObject5 = ((Handler)localObject5).obtainMessage();
      what = 100;
      localHandler = y.a;
      localHandler.sendMessage((Message)localObject5);
    }
    catch (Exception localException5)
    {
      k.a.a.m.StringBuilder.append(localException5);
    }
    Object localObject6 = FilterResultAllServices.c;
    try
    {
      localObject6 = ((Handler)localObject6).obtainMessage();
      what = 100;
      localHandler = FilterResultAllServices.c;
      localHandler.sendMessage((Message)localObject6);
    }
    catch (Exception localException6)
    {
      k.a.a.m.StringBuilder.append(localException6);
    }
    Object localObject7 = FilterResultScreen.b;
    try
    {
      localObject7 = ((Handler)localObject7).obtainMessage();
      what = 100;
      localHandler = FilterResultScreen.b;
      localHandler.sendMessage((Message)localObject7);
      return;
    }
    catch (Exception localException7)
    {
      k.a.a.m.StringBuilder.append(localException7);
    }
  }
  
  private void get(String paramString)
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = k.a.a.m.Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      Object localObject = this$0;
      String str = k.a.a.m.f.g;
      localJSONObject3.put("mno", ((k.a.a.m.f)localObject).get(str, ""));
      localObject = t;
      localJSONObject3.put("sid", localObject);
      localJSONObject3.put("isfav", paramString);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      ((AsyncTask)new z((k.a.a.i.List)new tq(this, paramString), localJSONObject2, this)).execute(new Object[0]);
    }
  }
  
  private void init()
  {
    g = ((ImageView)findViewById(2131297533));
    j = ((TextView)findViewById(2131297557));
    k = ((TextView)findViewById(2131297550));
    info = ((ImageView)findViewById(2131297854));
    version = ((RatingBar)findViewById(2131297356));
    type = ((RatingBar)findViewById(2131297353));
    header = ((TextView)findViewById(2131296466));
    cancelButton = ((TextView)findViewById(2131298019));
    progress = ((TextView)findViewById(2131298016));
    value = ((TextView)findViewById(2131297549));
    label = ((TextView)findViewById(2131297558));
    progressView = ((ProgressBar)findViewById(2131297319));
    v = ((TagView)findViewById(2131297672));
    o = ((LinearLayout)findViewById(2131296955));
    mLoadingView = findViewById(2131297226);
    mCancelButton = findViewById(2131297921);
    time = findViewById(2131297745);
    moreArtistsButton = findViewById(2131296825);
    deleteItem = findViewById(2131296809);
    uri = ((TextView)findViewById(2131297225));
    data = ((TextView)findViewById(2131297920));
    date = ((TextView)findViewById(2131297744));
    from = ((TextView)findViewById(2131296824));
    tv = ((TextView)findViewById(2131296808));
    current = ((TextView)findViewById(2131297855));
    tabsContainer = ((LinearLayout)findViewById(2131298010));
    content = ((LinearLayout)findViewById(2131297358));
    mFilename = ((TextView)findViewById(2131297360));
    mTitleView = ((RatingBar)findViewById(2131297354));
    runtime = ((TextView)findViewById(2131297778));
    status = ((CardView)findViewById(2131297357));
    mScrollView = ((ScrollView)findViewById(2131297477));
    mCardView = ((CardView)findViewById(2131296612));
    task = ((LikeButton)findViewById(2131296775));
    task.setLikeDrawableRes(2131231033);
    task.setUnlikeDrawableRes(2131231032);
    settings = ((ImageView)findViewById(2131297570));
    if (this$0.get(k.a.a.m.f.this$0, "").isEmpty())
    {
      settings.setVisibility(8);
      ((FrameLayout)task).setVisibility(8);
    }
    else
    {
      settings.setVisibility(0);
      ((FrameLayout)task).setVisibility(0);
    }
    previousButton = ((LinearLayout)findViewById(2131297556));
    mViewGroup = ((ViewGroup)findViewById(2131297006));
    mViewGroup.removeAllViews();
    u = ((LinearLayout)findViewById(2131297239));
    homeButton = ((ImageView)findViewById(2131296541));
    playButton = ((LinearLayout)findViewById(2131297555));
    view = ((LinearLayout)findViewById(2131297552));
    buttons = ((LinearLayout)findViewById(2131297554));
    listener = ((AppBarLayout)findViewById(2131296368));
    image = ((ImageView)findViewById(2131296938));
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131297537);
    localRelativeLayout = (RelativeLayout)findViewById(2131297443);
    listener.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener)new iq(this, localRelativeLayout));
  }
  
  private void initialize()
  {
    Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("=====");
    ((StringBuilder)localObject1).append(title);
    ((StringBuilder)localObject1).toString();
    if ((!title.contains("|")) && (!title.contains("#")) && (!title.contains(",")))
    {
      localObject1 = new Intent("android.intent.action.DIAL");
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("tel:");
      ((StringBuilder)localObject2).append(title);
      ((Intent)localObject1).setData(Uri.parse(((StringBuilder)localObject2).toString()));
      startActivity((Intent)localObject1);
      return;
    }
    Object localObject2 = new ArrayList();
    String[] arrayOfString = title.split("\\|");
    int m = 0;
    while (m < arrayOfString.length)
    {
      if (m != 0)
      {
        localObject1 = new j();
        ((j)localObject1).b("line");
        ((j)localObject1).a("");
        ((ArrayList)localObject2).add(localObject1);
      }
      localObject1 = arrayOfString[m].split("#");
      j localJ;
      if (localObject1.length > 1)
      {
        localJ = new j();
        localJ.b("heading");
        localJ.a(localObject1[0]);
        ((ArrayList)localObject2).add(localJ);
        localObject1 = localObject1[1].split(",");
      }
      else
      {
        localJ = new j();
        localJ.b("heading");
        localJ.a(getResources().getString(2131756471));
        ((ArrayList)localObject2).add(localJ);
        localObject1 = localObject1[0].split(",");
      }
      int i1 = 0;
      while (i1 < localObject1.length)
      {
        localJ = new j();
        localJ.b("number");
        localJ.a(localObject1[i1]);
        ((ArrayList)localObject2).add(localJ);
        i1 += 1;
      }
      m += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("contact dataAlist......");
    ((StringBuilder)localObject1).append(localObject2);
    ((StringBuilder)localObject1).toString();
    localObject1 = new Dialog(this);
    ((Dialog)localObject1).getWindow();
    ((Dialog)localObject1).requestWindowFeature(1);
    ((Dialog)localObject1).setContentView(2131493018);
    ((Dialog)localObject1).setCancelable(true);
    ((ListView)((Dialog)localObject1).findViewById(2131297009)).setAdapter((ListAdapter)new ServiceInformationScreenNew.a(this, (ArrayList)localObject2, (Dialog)localObject1));
    ((Dialog)localObject1).show();
  }
  
  private void onCreate()
  {
    f = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_NAME");
    a = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_TYPE");
    i = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_IMG");
    h = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_DESCP");
    versionName = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_RATING");
    link = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_LAT");
    description = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_LNG");
    title = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_PHONE");
    album = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_URL");
    s = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_CAT");
    p = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_STATE_ID");
    t = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_ID");
    text = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_WEBSITE");
    name = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_EMAIL");
    descr = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_ADDRESS");
    id = f.sufficientlysecure.rootcommands.util.StringBuilder.getString(this, "SERVICE_WORKING_HOURS");
    context = getIntent().getExtras().getBoolean("SERVICE_IS_FAVOURITE", false);
    Object localObject = this$0;
    String str = k.a.a.m.f.this$0;
    try
    {
      boolean bool = ((k.a.a.m.f)localObject).get(str, "").isEmpty();
      if (bool)
      {
        localObject = l;
        str = t;
        localObject = ((k.a.a.e.System)localObject).add(str);
      }
      else
      {
        localObject = l;
        str = t;
        localObject = ((k.a.a.e.System)localObject).read(str);
      }
      if (localObject != null)
      {
        str = ((k.a.a.c.Log)localObject).getString();
        pattern = str;
        localObject = ((k.a.a.c.Log)localObject).getTag();
        n = ((String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  private void onCreateView()
  {
    info.setOnClickListener((View.OnClickListener)new vq(this));
    type.setOnTouchListener((View.OnTouchListener)new wq(this));
    type.setOnRatingBarChangeListener((RatingBar.OnRatingBarChangeListener)new xq(this));
    playButton.setOnClickListener((View.OnClickListener)new yq(this));
    previousButton.setOnClickListener((View.OnClickListener)new zq(this));
    view.setOnClickListener((View.OnClickListener)new Aq(this));
    buttons.setOnClickListener((View.OnClickListener)new Bq(this));
    task.setOnLikeListener(new Cq(this));
    settings.setOnClickListener((View.OnClickListener)new hq(this));
  }
  
  private void onPostExecute()
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("=====");
    ((StringBuilder)localObject).append(name);
    ((StringBuilder)localObject).toString();
    if ((!name.contains("|")) && (!name.contains("#")) && (!name.contains(",")))
    {
      localObject = new Intent("android.intent.action.SENDTO");
      ((Intent)localObject).setData(Uri.parse("mailto:"));
      ((Intent)localObject).putExtra("android.intent.extra.EMAIL", new String[] { name });
      ((Intent)localObject).putExtra("android.intent.extra.SUBJECT", "");
      if (((Intent)localObject).resolveActivity(getPackageManager()) != null) {
        startActivity((Intent)localObject);
      }
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString = name.split("\\|");
      int m = 0;
      while (m < arrayOfString.length)
      {
        if (m != 0)
        {
          localObject = new j();
          ((j)localObject).b("line");
          ((j)localObject).a("");
          localArrayList.add(localObject);
        }
        localObject = arrayOfString[m].split("#");
        j localJ;
        if (localObject.length > 1)
        {
          localJ = new j();
          localJ.b("heading");
          localJ.a(localObject[0]);
          localArrayList.add(localJ);
          localObject = localObject[1].split(",");
        }
        else
        {
          localJ = new j();
          localJ.b("heading");
          localJ.a(getResources().getString(2131756315));
          localArrayList.add(localJ);
          localObject = localObject[0].split(",");
        }
        int i1 = 0;
        while (i1 < localObject.length)
        {
          localJ = new j();
          localJ.b("email");
          localJ.a(localObject[i1]);
          localArrayList.add(localJ);
          i1 += 1;
        }
        m += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("contact dataAlist......");
      ((StringBuilder)localObject).append(localArrayList);
      ((StringBuilder)localObject).toString();
      localObject = new Dialog(this);
      ((Dialog)localObject).getWindow();
      ((Dialog)localObject).requestWindowFeature(1);
      ((Dialog)localObject).setContentView(2131493018);
      ((Dialog)localObject).setCancelable(true);
      ((ListView)((Dialog)localObject).findViewById(2131297009)).setAdapter((ListAdapter)new ServiceInformationScreenNew.a(this, localArrayList, (Dialog)localObject));
      ((Dialog)localObject).show();
    }
  }
  
  private void send()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = k.a.a.m.Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      String str = t;
      localJSONObject3.put("sid", str);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new uq(this), "https://app.umang.gov.in/umang/coreapi/ws2/fdptmsg", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  private void show(String paramString1, String paramString2)
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131493189, mViewGroup, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(2131296997);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(2131296999);
    TextView localTextView3 = (TextView)localViewGroup.findViewById(2131297231);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    localTextView3.setOnClickListener((View.OnClickListener)new lq(this, paramString2));
    mViewGroup.addView(localViewGroup);
  }
  
  private int update(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i1 = Integer.parseInt(paramString1);
    int m = i1;
    int i5 = Integer.parseInt(paramString2);
    int i4 = Integer.parseInt(paramString3);
    int i3 = Integer.parseInt(paramString4);
    int i2 = Integer.parseInt(paramString5);
    if (i5 >= i1) {
      m = i5;
    }
    i1 = m;
    if (i4 >= m) {
      i1 = i4;
    }
    m = i1;
    if (i3 > i1) {
      m = i3;
    }
    i1 = m;
    if (i2 >= m) {
      i1 = i2;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("greater...................", i1);
    return i1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mToolbar = ((Toolbar)f.sufficientlysecure.rootcommands.util.StringBuilder.getView(this, 2131493236, this, "Service Information Screen", 2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, mToolbar, true);
    mViewPager = mToolbar.getRootView();
    d = ((TextView)mViewPager.findViewById(2131297758));
    this$0 = new k.a.a.m.f(this);
    l = k.a.a.e.System.getInstance(this);
    init();
    onCreateView();
    c = f.l.a.b.f.a();
    b = f.sufficientlysecure.rootcommands.util.StringBuilder.a(true, true).get(Bitmap.Config.RGB_565).getString();
    try
    {
      boolean bool = getIntent().getBooleanExtra("showDesc", false);
      if (bool)
      {
        paramBundle = mScrollView;
        Object localObject = new sq(this);
        localObject = (Runnable)localObject;
        paramBundle.post((Runnable)localObject);
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    onCreate();
    a();
    if (!this$0.get(k.a.a.m.f.this$0, "").isEmpty())
    {
      add(t);
      status.setVisibility(0);
    }
    else
    {
      status.setVisibility(8);
    }
    if (title.trim().equalsIgnoreCase(""))
    {
      view.setEnabled(false);
      view.setAlpha(0.5F);
    }
    else
    {
      view.setVisibility(0);
    }
    if (name.trim().equalsIgnoreCase(""))
    {
      buttons.setEnabled(false);
      buttons.setAlpha(0.5F);
    }
    else
    {
      buttons.setVisibility(0);
    }
    if (text.trim().equalsIgnoreCase(""))
    {
      previousButton.setEnabled(false);
      previousButton.setAlpha(0.5F);
    }
    else
    {
      previousButton.setVisibility(0);
    }
    if ((!link.trim().equalsIgnoreCase("")) && (!description.trim().equalsIgnoreCase("")))
    {
      playButton.setVisibility(0);
    }
    else
    {
      playButton.setEnabled(false);
      playButton.setAlpha(0.5F);
    }
    progressView.setVisibility(0);
    type.setVisibility(8);
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
