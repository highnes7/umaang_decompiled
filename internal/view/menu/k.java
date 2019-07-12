package internal.view.menu;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import email.pedant.SweetAlert.SuccessTickView;
import java.util.List;

public class k
  extends Dialog
  implements View.OnClickListener
{
  public static final int ATTENDEES_INDEX_RELATIONSHIP = 3;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final int ITEM_LAYOUT = 0;
  public static final int TAG = 5;
  public static final int WEEKS_BUFFER = 1;
  public boolean G;
  public Button a;
  public TextView b;
  public Button c;
  public String d;
  public String e;
  public View emptyView;
  public FrameLayout errorView;
  public FrameLayout f;
  public ImageView fab;
  public FrameLayout headerView;
  public Drawable j;
  public f l;
  public ImageView list;
  public FrameLayout loadingView;
  public Animation mAdapter;
  public MenuBuilder.Callback mCallback;
  public AnimationSet mContext;
  public AnimationSet mMenu;
  public TextView mMessage;
  public boolean mOverflowOnly;
  public MenuBuilder.Callback mSelectedColor;
  public View mView;
  public String message;
  public Animation moveDown;
  public AnimationSet moveLeft;
  public Animation moveRight;
  public View progressBar;
  public boolean r;
  public String s;
  public SuccessTickView swipeRefreshLayout;
  public AnimationSet this$0;
  public int x;
  
  public k(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public k(Context paramContext, int paramInt)
  {
    super(paramContext, R.style.alert_dialog);
    setCancelable(true);
    setCanceledOnTouchOutside(false);
    l = new f(paramContext);
    x = paramInt;
    moveRight = AnimatorInflater.loadAnimator(getContext(), R.anim.error_frame_in);
    moveLeft = ((AnimationSet)AnimatorInflater.loadAnimator(getContext(), R.anim.error_x_in));
    paramInt = Build.VERSION.SDK_INT;
    moveDown = AnimatorInflater.loadAnimator(getContext(), R.anim.success_bow_roate);
    this$0 = ((AnimationSet)AnimatorInflater.loadAnimator(getContext(), R.anim.success_mask_layout));
    mContext = ((AnimationSet)AnimatorInflater.loadAnimator(getContext(), R.anim.modal_in));
    mMenu = ((AnimationSet)AnimatorInflater.loadAnimator(getContext(), R.anim.modal_out));
    mMenu.setAnimationListener(new MainActivity.7(this));
    mAdapter = new SwipeRefreshLayout.6(this);
    mAdapter.setDuration(120L);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    x = paramInt;
    if (mView != null)
    {
      if (!paramBoolean) {
        onCreateView();
      }
      paramInt = x;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5)
              {
                f.setVisibility(0);
                a.setVisibility(8);
              }
            }
            else {
              a(j);
            }
          }
          else
          {
            a.setBackgroundResource(R.drawable.red_button_background);
            headerView.setVisibility(0);
          }
        }
        else
        {
          loadingView.setVisibility(0);
          progressBar.startAnimation((Animation)this$0.getAnimations().get(0));
          emptyView.startAnimation((Animation)this$0.getAnimations().get(1));
        }
      }
      else {
        errorView.setVisibility(0);
      }
      if (!paramBoolean) {
        onCreate();
      }
    }
  }
  
  private void onCreate()
  {
    int i = x;
    if (i == 1)
    {
      errorView.startAnimation(moveRight);
      fab.startAnimation(moveLeft);
      return;
    }
    if (i == 2)
    {
      swipeRefreshLayout.reset();
      emptyView.startAnimation(moveDown);
    }
  }
  
  private void onCreateView()
  {
    list.setVisibility(8);
    errorView.setVisibility(8);
    loadingView.setVisibility(8);
    headerView.setVisibility(8);
    f.setVisibility(8);
    a.setVisibility(0);
    a.setBackgroundResource(R.drawable.blue_button_background);
    errorView.clearAnimation();
    fab.clearAnimation();
    swipeRefreshLayout.clearAnimation();
    progressBar.clearAnimation();
    emptyView.clearAnimation();
  }
  
  private void show(boolean paramBoolean)
  {
    mOverflowOnly = paramBoolean;
    a.startAnimation(mAdapter);
    mView.startAnimation(mMenu);
  }
  
  public f a()
  {
    return l;
  }
  
  public k a(int paramInt)
  {
    return a(getContext().getResources().getDrawable(paramInt));
  }
  
  public k a(Drawable paramDrawable)
  {
    j = paramDrawable;
    paramDrawable = list;
    if ((paramDrawable != null) && (j != null))
    {
      paramDrawable.setVisibility(0);
      list.setImageDrawable(j);
    }
    return this;
  }
  
  public k a(String paramString)
  {
    e = paramString;
    if ((c != null) && (e != null))
    {
      b(true);
      c.setText(e);
    }
    return this;
  }
  
  public k a(boolean paramBoolean)
  {
    r = paramBoolean;
    TextView localTextView = b;
    if (localTextView != null)
    {
      int i;
      if (r) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
    return this;
  }
  
  public k b(String paramString)
  {
    s = paramString;
    paramString = a;
    if (paramString != null)
    {
      String str = s;
      if (str != null) {
        paramString.setText(str);
      }
    }
    return this;
  }
  
  public k b(boolean paramBoolean)
  {
    G = paramBoolean;
    Button localButton = c;
    if (localButton != null)
    {
      int i;
      if (G) {
        i = 0;
      } else {
        i = 8;
      }
      localButton.setVisibility(i);
    }
    return this;
  }
  
  public void cancel()
  {
    show(true);
  }
  
  public String getBaseMessage()
  {
    return message;
  }
  
  public String getDesc()
  {
    return d;
  }
  
  public String getItem()
  {
    return e;
  }
  
  public int getMaxX()
  {
    return x;
  }
  
  public String getName()
  {
    return s;
  }
  
  public boolean m()
  {
    return r;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.cancel_button)
    {
      paramView = mSelectedColor;
      if (paramView != null)
      {
        paramView.onMenuModeChange(this);
        return;
      }
      setTitle();
      return;
    }
    if (paramView.getId() == R.id.confirm_button)
    {
      paramView = mCallback;
      if (paramView != null)
      {
        paramView.onMenuModeChange(this);
        return;
      }
      setTitle();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.alert_dialog);
    mView = getWindow().getDecorView().findViewById(16908290);
    mMessage = ((TextView)findViewById(R.id.title_text));
    b = ((TextView)findViewById(R.id.content_text));
    errorView = ((FrameLayout)findViewById(R.id.error_frame));
    fab = ((ImageView)errorView.findViewById(R.id.error_x));
    loadingView = ((FrameLayout)findViewById(R.id.success_frame));
    f = ((FrameLayout)findViewById(R.id.progress_dialog));
    swipeRefreshLayout = ((SuccessTickView)loadingView.findViewById(R.id.success_tick));
    progressBar = loadingView.findViewById(R.id.mask_left);
    emptyView = loadingView.findViewById(R.id.mask_right);
    list = ((ImageView)findViewById(R.id.custom_image));
    headerView = ((FrameLayout)findViewById(R.id.warning_frame));
    a = ((Button)findViewById(R.id.confirm_button));
    c = ((Button)findViewById(R.id.cancel_button));
    l.a((ProgressWheel)findViewById(R.id.progressWheel));
    a.setOnClickListener(this);
    c.setOnClickListener(this);
    show(message);
    setTitle(d);
    a(e);
    b(s);
    a(x, true);
  }
  
  public boolean onItemClick()
  {
    return G;
  }
  
  public void onStart()
  {
    mView.startAnimation(mContext);
    onCreate();
  }
  
  public void onStop(int paramInt)
  {
    a(paramInt, false);
  }
  
  public k setCallback(MenuBuilder.Callback paramCallback)
  {
    mCallback = paramCallback;
    return this;
  }
  
  public k setGravity(MenuBuilder.Callback paramCallback)
  {
    mSelectedColor = paramCallback;
    return this;
  }
  
  public k setTitle(String paramString)
  {
    d = paramString;
    if ((b != null) && (d != null))
    {
      a(true);
      b.setText(d);
    }
    return this;
  }
  
  public void setTitle()
  {
    show(false);
  }
  
  public k show(String paramString)
  {
    message = paramString;
    paramString = mMessage;
    if (paramString != null)
    {
      String str = message;
      if (str != null) {
        paramString.setText(str);
      }
    }
    return this;
  }
}
