package support.android.v4.asm.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public abstract interface IMediaSession
  extends IInterface
{
  public abstract void adjustVolume(int paramInt1, int paramInt2, String paramString)
    throws RemoteException;
  
  public abstract void fastForward()
    throws RemoteException;
  
  public abstract Bundle getExtras()
    throws RemoteException;
  
  public abstract long getFlags()
    throws RemoteException;
  
  public abstract PendingIntent getLaunchPendingIntent()
    throws RemoteException;
  
  public abstract int getMaxAmplitude()
    throws RemoteException;
  
  public abstract MediaMetadataCompat getMetadata()
    throws RemoteException;
  
  public abstract String getPackageName()
    throws RemoteException;
  
  public abstract PlaybackStateCompat getPlaybackState()
    throws RemoteException;
  
  public abstract List getQueue()
    throws RemoteException;
  
  public abstract CharSequence getQueueTitle()
    throws RemoteException;
  
  public abstract int getRatingType()
    throws RemoteException;
  
  public abstract String getTag()
    throws RemoteException;
  
  public abstract ParcelableVolumeInfo getVolumeAttributes()
    throws RemoteException;
  
  public abstract void next()
    throws RemoteException;
  
  public abstract void next(int paramInt)
    throws RemoteException;
  
  public abstract void next(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void pause()
    throws RemoteException;
  
  public abstract void pause(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract boolean play()
    throws RemoteException;
  
  public abstract void playFromMediaId(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void playFromSearch(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void playFromUri(Uri paramUri, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void previous()
    throws RemoteException;
  
  public abstract int rate()
    throws RemoteException;
  
  public abstract void rate(MediaDescriptionCompat paramMediaDescriptionCompat)
    throws RemoteException;
  
  public abstract void rate(RatingCompat paramRatingCompat)
    throws RemoteException;
  
  public abstract void rate(RatingCompat paramRatingCompat, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void registerCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
    throws RemoteException;
  
  public abstract void rewind()
    throws RemoteException;
  
  public abstract void seekTo()
    throws RemoteException;
  
  public abstract void seekTo(int paramInt)
    throws RemoteException;
  
  public abstract void seekTo(long paramLong)
    throws RemoteException;
  
  public abstract void seekTo(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    throws RemoteException;
  
  public abstract void sendCommand(int paramInt)
    throws RemoteException;
  
  public abstract void sendCommand(Uri paramUri, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat)
    throws RemoteException;
  
  public abstract void sendCommand(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void sendCommand(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper)
    throws RemoteException;
  
  public abstract void sendCommand(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void sendCustomAction()
    throws RemoteException;
  
  public abstract void sendCustomAction(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract boolean sendMediaButton()
    throws RemoteException;
  
  public abstract boolean sendMediaButton(KeyEvent paramKeyEvent)
    throws RemoteException;
  
  public abstract void setVolumeTo(int paramInt1, int paramInt2, String paramString)
    throws RemoteException;
  
  public abstract void skipToQueueItem(long paramLong)
    throws RemoteException;
  
  public abstract void stop()
    throws RemoteException;
  
  public abstract void unregisterCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
    throws RemoteException;
  
  public abstract boolean update()
    throws RemoteException;
  
  public abstract class Stub
    extends Binder
    implements IMediaSession
  {
    public static final int APPLICATION_EFFECTIVE_DATE = 37;
    public static final int AnySoftKeyboardTheme_suggestionWordXGap = 38;
    public static final int AppCompatTheme_dialogPreferredPadding = 43;
    public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
    public static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
    public static final int INTERCHANGE_PROFILE = 41;
    public static final int LALOAD = 47;
    public static final int NEXT_ALARM = 42;
    public static final int OLD_ENVIRONMENT_VARIABLES = 36;
    public static final int RIGHT_M = 48;
    public static final int SATURDAY = 39;
    public static final int STATE_PAUSED_ROAMING = 12;
    public static final int STATE_ROUND_2_VALIDATED = 40;
    public static final int TAG_AUDIO = 32;
    public static final int TLS_DHE_RSA_WITH_AES_128_CBC_SHA = 51;
    public static final int TRANSACTION_adjustVolume = 11;
    public static final int TRANSACTION_fastForward = 21;
    public static final int TRANSACTION_getExtras = 30;
    public static final int TRANSACTION_getFlags = 9;
    public static final int TRANSACTION_getLaunchPendingIntent = 8;
    public static final int TRANSACTION_getMetadata = 26;
    public static final int TRANSACTION_getPackageName = 6;
    public static final int TRANSACTION_getPlaybackState = 27;
    public static final int TRANSACTION_getQueue = 17;
    public static final int TRANSACTION_getQueueTitle = 29;
    public static final int TRANSACTION_getRatingType = 31;
    public static final int TRANSACTION_getTag = 7;
    public static final int TRANSACTION_getVolumeAttributes = 10;
    public static final int TRANSACTION_isTransportControlEnabled = 5;
    public static final int TRANSACTION_next = 19;
    public static final int TRANSACTION_pause = 13;
    public static final int TRANSACTION_play = 18;
    public static final int TRANSACTION_playFromMediaId = 14;
    public static final int TRANSACTION_playFromSearch = 15;
    public static final int TRANSACTION_playFromUri = 16;
    public static final int TRANSACTION_previous = 20;
    public static final int TRANSACTION_rate = 24;
    public static final int TRANSACTION_registerCallbackListener = 3;
    public static final int TRANSACTION_rewind = 22;
    public static final int TRANSACTION_seekTo = 23;
    public static final int TRANSACTION_sendCommand = 46;
    public static final int TRANSACTION_sendCustomAction = 25;
    public static final int TRANSACTION_sendMediaButton = 2;
    public static final int TRANSACTION_setVolumeTo = 44;
    public static final int TRANSACTION_skipToQueueItem = 33;
    public static final int TRANSACTION_stop = 34;
    public static final int TRANSACTION_unregisterCallbackListener = 35;
    public static final int UNIVERSAL_STRING = 28;
    public static final int WEEKS_BUFFER = 1;
    public static final int ZIP64_MIN_VERSION = 45;
    
    public Stub()
    {
      attachInterface(this, "android.support.v4.media.session.IMediaSession");
    }
    
    public static IMediaSession asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
      if ((localIInterface != null) && ((localIInterface instanceof IMediaSession))) {
        return (IMediaSession)localIInterface;
      }
      return new b.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject10 = null;
      Object localObject11 = null;
      String str = null;
      Object localObject1 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject12 = null;
      Object localObject3 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject13 = null;
      Object localObject2 = null;
      Object localObject4 = null;
      Object localObject9 = null;
      if (paramInt1 != 51)
      {
        if (paramInt1 != 1598968902)
        {
          int i = 0;
          boolean bool2 = false;
          int j = 0;
          int k = 0;
          int m = 0;
          boolean bool1 = false;
          switch (paramInt1)
          {
          default: 
            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          case 48: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            next(paramParcel1.readInt());
            paramParcel2.writeNoException();
            return true;
          case 47: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramInt1 = rate();
            paramParcel2.writeNoException();
            paramParcel2.writeInt(paramInt1);
            return true;
          case 46: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (paramParcel1.readInt() != 0) {
              bool1 = true;
            }
            next(bool1);
            paramParcel2.writeNoException();
            return true;
          case 45: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            bool1 = play();
            paramParcel2.writeNoException();
            paramInt1 = i;
            if (bool1) {
              paramInt1 = 1;
            }
            paramParcel2.writeInt(paramInt1);
            return true;
          case 44: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            sendCommand(paramParcel1.readInt());
            paramParcel2.writeNoException();
            return true;
          case 43: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject1 = localObject9;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel1);
            }
            sendCommand((MediaDescriptionCompat)localObject1);
            paramParcel2.writeNoException();
            return true;
          case 42: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject1 = localObject10;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel1);
            }
            paramInt1 = paramParcel1.readInt();
            seekTo((MediaDescriptionCompat)localObject1, paramInt1);
            paramParcel2.writeNoException();
            return true;
          case 41: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject1 = localObject11;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel1);
            }
            rate((MediaDescriptionCompat)localObject1);
            paramParcel2.writeNoException();
            return true;
          case 40: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            bool1 = bool2;
            if (paramParcel1.readInt() != 0) {
              bool1 = true;
            }
            sendCommand(bool1);
            paramParcel2.writeNoException();
            return true;
          case 39: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            seekTo(paramParcel1.readInt());
            paramParcel2.writeNoException();
            return true;
          case 38: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            bool1 = sendMediaButton();
            paramParcel2.writeNoException();
            paramInt1 = j;
            if (bool1) {
              paramInt1 = 1;
            }
            paramParcel2.writeInt(paramInt1);
            return true;
          case 37: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramInt1 = getMaxAmplitude();
            paramParcel2.writeNoException();
            paramParcel2.writeInt(paramInt1);
            return true;
          case 36: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (paramParcel1.readInt() != 0) {
              localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
            } else {
              localObject1 = null;
            }
            localObject2 = str;
            if (paramParcel1.readInt() != 0) {
              localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
            }
            sendCommand((Uri)localObject1, (Bundle)localObject2);
            paramParcel2.writeNoException();
            return true;
          case 35: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject2 = paramParcel1.readString();
            if (paramParcel1.readInt() != 0) {
              localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
            }
            pause((String)localObject2, (Bundle)localObject1);
            paramParcel2.writeNoException();
            return true;
          case 34: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject2 = paramParcel1.readString();
            localObject1 = localObject5;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
            }
            sendCommand((String)localObject2, (Bundle)localObject1);
            paramParcel2.writeNoException();
            return true;
          case 33: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            seekTo();
            paramParcel2.writeNoException();
            return true;
          case 32: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramInt1 = getRatingType();
            paramParcel2.writeNoException();
            paramParcel2.writeInt(paramInt1);
            return true;
          case 31: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getExtras();
            paramParcel2.writeNoException();
            if (paramParcel1 != null)
            {
              paramParcel2.writeInt(1);
              paramParcel1.writeToParcel(paramParcel2, 1);
              return true;
            }
            paramParcel2.writeInt(0);
            return true;
          case 30: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getQueueTitle();
            paramParcel2.writeNoException();
            if (paramParcel1 != null)
            {
              paramParcel2.writeInt(1);
              TextUtils.writeToParcel(paramParcel1, paramParcel2, 1);
              return true;
            }
            paramParcel2.writeInt(0);
            return true;
          case 29: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getQueue();
            paramParcel2.writeNoException();
            paramParcel2.writeTypedList(paramParcel1);
            return true;
          case 28: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getPlaybackState();
            paramParcel2.writeNoException();
            if (paramParcel1 != null)
            {
              paramParcel2.writeInt(1);
              paramParcel1.writeToParcel(paramParcel2, 1);
              return true;
            }
            paramParcel2.writeInt(0);
            return true;
          case 27: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getMetadata();
            paramParcel2.writeNoException();
            if (paramParcel1 != null)
            {
              paramParcel2.writeInt(1);
              paramParcel1.writeToParcel(paramParcel2, 1);
              return true;
            }
            paramParcel2.writeInt(0);
            return true;
          case 26: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject2 = paramParcel1.readString();
            localObject1 = localObject6;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
            }
            sendCustomAction((String)localObject2, (Bundle)localObject1);
            paramParcel2.writeNoException();
            return true;
          case 25: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject1 = localObject12;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(paramParcel1);
            }
            rate((RatingCompat)localObject1);
            paramParcel2.writeNoException();
            return true;
          case 24: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            seekTo(paramParcel1.readLong());
            paramParcel2.writeNoException();
            return true;
          case 23: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            rewind();
            paramParcel2.writeNoException();
            return true;
          case 22: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            fastForward();
            paramParcel2.writeNoException();
            return true;
          case 21: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            previous();
            paramParcel2.writeNoException();
            return true;
          case 20: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            next();
            paramParcel2.writeNoException();
            return true;
          case 19: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            stop();
            paramParcel2.writeNoException();
            return true;
          case 18: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            pause();
            paramParcel2.writeNoException();
            return true;
          case 17: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            skipToQueueItem(paramParcel1.readLong());
            paramParcel2.writeNoException();
            return true;
          case 16: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (paramParcel1.readInt() != 0) {
              localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
            } else {
              localObject1 = null;
            }
            localObject2 = localObject3;
            if (paramParcel1.readInt() != 0) {
              localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
            }
            playFromUri((Uri)localObject1, (Bundle)localObject2);
            paramParcel2.writeNoException();
            return true;
          case 15: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject2 = paramParcel1.readString();
            localObject1 = localObject7;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
            }
            playFromSearch((String)localObject2, (Bundle)localObject1);
            paramParcel2.writeNoException();
            return true;
          case 14: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject2 = paramParcel1.readString();
            localObject1 = localObject8;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
            }
            playFromMediaId((String)localObject2, (Bundle)localObject1);
            paramParcel2.writeNoException();
            return true;
          case 13: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            sendCustomAction();
            paramParcel2.writeNoException();
            return true;
          case 12: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            setVolumeTo(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
            paramParcel2.writeNoException();
            return true;
          case 11: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            adjustVolume(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
            paramParcel2.writeNoException();
            return true;
          case 10: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getVolumeAttributes();
            paramParcel2.writeNoException();
            if (paramParcel1 != null)
            {
              paramParcel2.writeInt(1);
              paramParcel1.writeToParcel(paramParcel2, 1);
              return true;
            }
            paramParcel2.writeInt(0);
            return true;
          case 9: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            long l = getFlags();
            paramParcel2.writeNoException();
            paramParcel2.writeLong(l);
            return true;
          case 8: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getLaunchPendingIntent();
            paramParcel2.writeNoException();
            if (paramParcel1 != null)
            {
              paramParcel2.writeInt(1);
              paramParcel1.writeToParcel(paramParcel2, 1);
              return true;
            }
            paramParcel2.writeInt(0);
            return true;
          case 7: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getTag();
            paramParcel2.writeNoException();
            paramParcel2.writeString(paramParcel1);
            return true;
          case 6: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            paramParcel1 = getPackageName();
            paramParcel2.writeNoException();
            paramParcel2.writeString(paramParcel1);
            return true;
          case 5: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            bool1 = update();
            paramParcel2.writeNoException();
            paramInt1 = k;
            if (bool1) {
              paramInt1 = 1;
            }
            paramParcel2.writeInt(paramInt1);
            return true;
          case 4: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            return true;
          case 3: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            registerCallbackListener(IMediaControllerCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            return true;
          case 2: 
            paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
            localObject1 = localObject13;
            if (paramParcel1.readInt() != 0) {
              localObject1 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(paramParcel1);
            }
            bool1 = sendMediaButton((KeyEvent)localObject1);
            paramParcel2.writeNoException();
            paramInt1 = m;
            if (bool1) {
              paramInt1 = 1;
            }
            paramParcel2.writeInt(paramInt1);
            return true;
          }
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
          str = paramParcel1.readString();
          if (paramParcel1.readInt() != 0) {
            localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          } else {
            localObject1 = null;
          }
          if (paramParcel1.readInt() != 0) {
            localObject2 = (MediaSessionCompat.ResultReceiverWrapper)MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(paramParcel1);
          }
          sendCommand(str, (Bundle)localObject1, (MediaSessionCompat.ResultReceiverWrapper)localObject2);
          paramParcel2.writeNoException();
          return true;
        }
        paramParcel2.writeString("android.support.v4.media.session.IMediaSession");
        return true;
      }
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(paramParcel1);
      } else {
        localObject1 = null;
      }
      localObject2 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      rate((RatingCompat)localObject1, (Bundle)localObject2);
      paramParcel2.writeNoException();
      return true;
    }
  }
}
