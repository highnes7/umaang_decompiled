package in.spicedigital.umang.activities;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AbsSpinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView.a;
import f.l.a.b.ClassWriter;
import f.l.a.b.d;
import internal.view.menu.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import k.a.a.a.Ag;
import k.a.a.a.Bg;
import k.a.a.a.Cg;
import k.a.a.a.Dg;
import k.a.a.a.Eg;
import k.a.a.a.ng;
import k.a.a.a.pg;
import k.a.a.a.qg;
import k.a.a.a.rg;
import k.a.a.a.sg;
import k.a.a.a.tg;
import k.a.a.a.vg;
import k.a.a.a.wg;
import k.a.a.a.xg;
import k.a.a.a.yg;
import k.a.a.a.zg;
import k.a.a.c.o;
import k.a.a.c.u;
import k.a.a.l.x;
import org.json.JSONObject;
import support.android.v4.content.ContextCompat;

public class FeedbackScreen
  extends BaseActivity
{
  public TextView a;
  public ClassWriter b;
  public f.l.a.b.f c;
  public String data;
  public ImageView date;
  public ImageView description;
  public TextView filePath;
  public TextView fileSize;
  public CardView i;
  public String id;
  public ImageView image;
  public final String indent = "FeedbackScreen";
  public ImageView info;
  public TextView location;
  public ArrayList<o> m;
  public TextView mAction;
  public TextView mAuthor;
  public LinearLayout mButtonCancel;
  public LinearLayout mButtonOk;
  public k.a.a.e.System mContext;
  public ImageView mDifficulty;
  public ImageView mImage;
  public CardView mInfo;
  public CardView mListView;
  public LinearLayout mMessage;
  public Uri mMessageText;
  public CardView mName;
  public k mPopup;
  public EditText mProfileName;
  public k.a.a.m.f mResources;
  public TextView mStatus;
  public Spinner mType;
  public TextView mView;
  public CardView n;
  public TextView name;
  public ArrayList<u> pool;
  public String q;
  public View root;
  public String separator = "";
  public Spinner spinner;
  public ImageView state;
  public TextView status;
  public LinearLayout stop;
  public Toolbar this$0;
  public ImageView time;
  public LinearLayout title;
  public ImageView type;
  
  public FeedbackScreen() {}
  
  private void bindView()
  {
    id = "appfd";
    location.setTextColor(ContextCompat.getColor(this, 2131099920));
    name.setTextColor(ContextCompat.getColor(this, 2131099895));
    filePath.setTextColor(ContextCompat.getColor(this, 2131099920));
    fileSize.setTextColor(ContextCompat.getColor(this, 2131099920));
    location.setTypeface(Typeface.create("sans-serif", 0));
    name.setTypeface(Typeface.create("sans-serif-medium", 0));
    filePath.setTypeface(Typeface.create("sans-serif", 0));
    fileSize.setTypeface(Typeface.create("sans-serif", 0));
    state.setVisibility(8);
    time.setVisibility(0);
    type.setVisibility(8);
    date.setVisibility(8);
    description.setImageResource(2131231454);
    image.setImageResource(2131231037);
    info.setImageResource(2131231038);
    mImage.setImageResource(2131231040);
    n.setVisibility(8);
    i.setVisibility(8);
  }
  
  private void execute(int paramInt)
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = k.a.a.m.Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      Object localObject = pool;
      localObject = ((ArrayList)localObject).get(paramInt);
      localObject = (k.a.a.c.Log)localObject;
      localJSONObject3.put("departmentID", ((k.a.a.c.Log)localObject).getName());
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new vg(this, paramInt), "https://app.umang.gov.in/umang/coreapi/ws2/fthds", localJSONObject2, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }
  }
  
  private void init()
  {
    id = "departmentfd";
    location.setTextColor(ContextCompat.getColor(this, 2131099920));
    name.setTextColor(ContextCompat.getColor(this, 2131099920));
    filePath.setTextColor(ContextCompat.getColor(this, 2131099895));
    fileSize.setTextColor(ContextCompat.getColor(this, 2131099920));
    location.setTypeface(Typeface.create("sans-serif", 0));
    name.setTypeface(Typeface.create("sans-serif", 0));
    filePath.setTypeface(Typeface.create("sans-serif-medium", 0));
    fileSize.setTypeface(Typeface.create("sans-serif", 0));
    state.setVisibility(8);
    time.setVisibility(8);
    type.setVisibility(0);
    date.setVisibility(8);
    description.setImageResource(2131231454);
    image.setImageResource(2131231036);
    info.setImageResource(2131231039);
    mImage.setImageResource(2131231040);
    n.setVisibility(0);
    if (f.sufficientlysecure.rootcommands.util.StringBuilder.getBoolean(this, 2131755407, a.getText().toString()))
    {
      i.setVisibility(8);
      return;
    }
    i.setVisibility(0);
  }
  
  private void init(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject1;
    try
    {
      String str1 = getIntent().getStringExtra("rating");
      if (str1 != null) {
        str1 = getIntent().getStringExtra("rating");
      } else {
        str1 = "";
      }
      JSONObject localJSONObject2 = k.a.a.m.Log.execute(this);
      localJSONObject1 = localJSONObject2;
      k.a.a.m.f localF = mResources;
      String str2 = k.a.a.m.f.g;
      localJSONObject2.put("mno", localF.get(str2, ""));
      localJSONObject2.put("cate", paramString1);
      localJSONObject2.put("feedback", paramString2);
      localJSONObject2.put("catetype", "feedback");
      localJSONObject2.put("sid", paramString3);
      localJSONObject2.put("serviceID", paramString4);
      paramString4 = separator;
      localJSONObject2.put("pic", paramString4);
      localJSONObject2.put("rating", str1);
    }
    catch (Exception paramString4)
    {
      k.a.a.m.StringBuilder.append((Exception)paramString4);
      localJSONObject1 = null;
    }
    if (localJSONObject1 != null)
    {
      paramString1 = new x((k.a.a.i.List)new pg(this, paramString2, paramString1, paramString3), localJSONObject1, this);
      paramString2 = AsyncTask.THREAD_POOL_EXECUTOR;
      ((AsyncTask)paramString1).executeOnExecutor(paramString2, new Object[0]);
    }
  }
  
  private void initialize()
  {
    Object localObject1 = getIntent().getStringExtra("showInfo");
    int i1 = 0;
    if (localObject1 != null) {
      mName.setVisibility(0);
    } else {
      mName.setVisibility(8);
    }
    id = "feedback";
    data = "";
    q = "";
    m = new ArrayList();
    pool = new ArrayList();
    pool = mContext.initialize();
    localObject1 = new String[pool.size()];
    int j = 0;
    while (j < pool.size())
    {
      localObject1[j] = ((k.a.a.c.Log)pool.get(j)).read();
      j += 1;
    }
    mType.setAdapter((SpinnerAdapter)new FeedbackScreen.b(this, this, 2131492958, (String[])localObject1));
    bindView();
    if (!"".equalsIgnoreCase(mResources.get(k.a.a.m.f.mResources, "")))
    {
      mProfileName.setText(mResources.get(k.a.a.m.f.mResources, ""));
      localObject1 = mResources.get(k.a.a.m.f.locale, "");
      if (((String)localObject1).contains("appfd"))
      {
        bindView();
        return;
      }
      if (((String)localObject1).contains("departmentfd"))
      {
        init();
        try
        {
          localObject1 = ((String)localObject1).split("\\|");
          localObject1 = localObject1[1];
          int k = 0;
          j = i1;
          for (;;)
          {
            localObject2 = pool;
            i1 = ((ArrayList)localObject2).size();
            if (j >= i1) {
              break;
            }
            localObject2 = pool;
            localObject2 = ((ArrayList)localObject2).get(j);
            localObject2 = (k.a.a.c.Log)localObject2;
            boolean bool = ((k.a.a.c.Log)localObject2).getName().equalsIgnoreCase((String)localObject1);
            if (bool) {
              k = j;
            }
            j += 1;
          }
          Object localObject2 = mType;
          ((AbsSpinner)localObject2).setSelection(k);
          localObject2 = a;
          Object localObject3 = pool;
          localObject3 = ((ArrayList)localObject3).get(k);
          localObject3 = (k.a.a.c.Log)localObject3;
          ((TextView)localObject2).setText(((k.a.a.c.Log)localObject3).read());
          data = ((String)localObject1);
          execute(k);
          return;
        }
        catch (Exception localException)
        {
          k.a.a.m.StringBuilder.append(localException);
          return;
        }
      }
      onCreate();
    }
  }
  
  private void onCreate()
  {
    id = "otherfd";
    location.setTextColor(ContextCompat.getColor(this, 2131099920));
    name.setTextColor(ContextCompat.getColor(this, 2131099920));
    filePath.setTextColor(ContextCompat.getColor(this, 2131099920));
    fileSize.setTextColor(ContextCompat.getColor(this, 2131099895));
    location.setTypeface(Typeface.create("sans-serif", 0));
    name.setTypeface(Typeface.create("sans-serif", 0));
    filePath.setTypeface(Typeface.create("sans-serif", 0));
    fileSize.setTypeface(Typeface.create("sans-serif-medium", 0));
    state.setVisibility(8);
    time.setVisibility(8);
    type.setVisibility(8);
    date.setVisibility(0);
    description.setImageResource(2131231454);
    image.setImageResource(2131231036);
    info.setImageResource(2131231038);
    mImage.setImageResource(2131231041);
    n.setVisibility(8);
    i.setVisibility(8);
  }
  
  private void onCreateView()
  {
    mButtonOk = ((LinearLayout)findViewById(2131297528));
    mButtonCancel = ((LinearLayout)findViewById(2131296359));
    stop = ((LinearLayout)findViewById(2131296609));
    title = ((LinearLayout)findViewById(2131297237));
    location = ((TextView)findViewById(2131297529));
    name = ((TextView)findViewById(2131296360));
    filePath = ((TextView)findViewById(2131296610));
    fileSize = ((TextView)findViewById(2131297238));
    state = ((ImageView)findViewById(2131297527));
    time = ((ImageView)findViewById(2131296358));
    type = ((ImageView)findViewById(2131296608));
    date = ((ImageView)findViewById(2131297236));
    description = ((ImageView)findViewById(2131297526));
    image = ((ImageView)findViewById(2131296357));
    info = ((ImageView)findViewById(2131296607));
    mImage = ((ImageView)findViewById(2131297235));
    mType = ((Spinner)findViewById(2131296509));
    spinner = ((Spinner)findViewById(2131296513));
    n = ((CardView)findViewById(2131296508));
    i = ((CardView)findViewById(2131296512));
    a = ((TextView)findViewById(2131297542));
    mView = ((TextView)findViewById(2131297650));
    mProfileName = ((EditText)findViewById(2131296783));
    mAction = ((TextView)findViewById(2131297657));
    mName = ((CardView)findViewById(2131296916));
    mInfo = ((CardView)findViewById(2131296860));
    mStatus = ((TextView)findViewById(2131296861));
    mMessage = ((LinearLayout)findViewById(2131297470));
    mListView = ((CardView)findViewById(2131297471));
    mMessage.setOnClickListener((View.OnClickListener)new ng(this));
    mDifficulty = ((ImageView)findViewById(2131296782));
    mAuthor = ((TextView)findViewById(2131296378));
    mDifficulty.setVisibility(8);
    mAuthor.setVisibility(8);
    mMessage.setVisibility(8);
    mListView.setVisibility(8);
    mContext = k.a.a.e.System.getInstance(this);
    mResources = new k.a.a.m.f(this);
    c = f.l.a.b.f.a();
    b = f.sufficientlysecure.rootcommands.util.StringBuilder.a(true, true).get(Bitmap.Config.RGB_565).getString();
  }
  
  private void showDialogChooser()
  {
    File localFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), k.a.a.m.Log.getAppName(this));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("IMG_");
    localStringBuilder.append(String.valueOf(System.currentTimeMillis()));
    localStringBuilder.append(".jpg");
    localFile = new File(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getPackageName());
    localStringBuilder.append(".fileprovider");
    mMessageText = FileProvider.getUriForFile(this, localStringBuilder.toString(), localFile);
    k.a.a.m.Log.a(this, mMessageText, false, false);
  }
  
  private String toBase64(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2016) && (paramInt2 == 0))
    {
      isFinishing();
      return;
    }
    if ((paramInt1 == 2019) && (paramInt2 == 0))
    {
      isFinishing();
      return;
    }
    if ((paramInt1 == 2016) && (paramInt2 == -1))
    {
      if (!isFinishing()) {
        runOnUiThread((Runnable)new qg(this));
      }
    }
    else if ((paramInt1 == 2019) && (paramInt2 == -1))
    {
      if (!isFinishing()) {
        runOnUiThread((Runnable)new rg(this, paramIntent));
      }
    }
    else if (paramInt1 == 203)
    {
      paramIntent = CropImage.a(paramIntent);
      if (paramInt2 == -1)
      {
        if (!isFinishing())
        {
          runOnUiThread((Runnable)new sg(this, paramIntent));
          return;
        }
        if (paramInt2 == 204)
        {
          paramIntent = paramIntent.d();
          if (!isFinishing()) {
            runOnUiThread((Runnable)new tg(this, paramIntent));
          }
        }
      }
    }
    else if ((paramInt1 == 1012) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getExtras().getString("departmentId");
      int j = 0;
      paramInt1 = 0;
      for (;;)
      {
        paramInt2 = j;
        if (paramInt1 >= pool.size()) {
          break;
        }
        if (paramIntent.equalsIgnoreCase(((k.a.a.c.Log)pool.get(paramInt1)).getName()))
        {
          paramInt2 = paramInt1;
          break;
        }
        paramInt1 += 1;
      }
      execute(paramInt2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493077);
    if (getIntent().getStringExtra("showInfo") != null) {
      k.a.a.m.Log.execute(this, "Feedback Screen from rating");
    } else {
      k.a.a.m.Log.execute(this, "Feedback Screen");
    }
    try
    {
      k.a.a.m.Log.inject(this, findViewById(2131297260));
      getWindow().setSoftInputMode(3);
      this$0 = ((Toolbar)findViewById(2131297768));
      f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, this$0, true);
      root = this$0.getRootView();
      status = ((TextView)root.findViewById(2131297758));
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755719, status);
      onCreateView();
      initialize();
      mInfo.setVisibility(0);
      mInfo.setOnClickListener((View.OnClickListener)new wg(this));
      try
      {
        paramBundle = getIntent().getStringExtra("notifId");
        if (paramBundle != null)
        {
          k.a.a.e.System localSystem = mContext;
          localSystem.set(paramBundle);
          k.a.a.m.Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
        }
      }
      catch (Exception paramBundle)
      {
        k.a.a.m.StringBuilder.append(paramBundle);
      }
      mButtonOk.setOnClickListener((View.OnClickListener)new xg(this));
      mButtonCancel.setOnClickListener((View.OnClickListener)new yg(this));
      stop.setOnClickListener((View.OnClickListener)new zg(this));
      title.setOnClickListener((View.OnClickListener)new Ag(this));
      a.setOnClickListener((View.OnClickListener)new Bg(this));
      mView.setOnClickListener((View.OnClickListener)new Cg(this));
      mType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)new Dg(this));
      mAction.setOnClickListener((View.OnClickListener)new Eg(this));
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;) {}
    }
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
        k.a.a.m.Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
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
}
