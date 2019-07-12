package support.android.v4.asm.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.util.List;

public abstract interface IMediaControllerCallback
  extends IInterface
{
  public abstract void next(int paramInt)
    throws RemoteException;
  
  public abstract void next(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void onEvent()
    throws RemoteException;
  
  public abstract void onEvent(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onEvent(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
    throws RemoteException;
  
  public abstract void onPitchAdjustmentAvailableChanged(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void onPlaybackStateChanged(int paramInt)
    throws RemoteException;
  
  public abstract void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat)
    throws RemoteException;
  
  public abstract void onSessionDestroyed()
    throws RemoteException;
  
  public abstract void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
    throws RemoteException;
  
  public abstract void send(CharSequence paramCharSequence)
    throws RemoteException;
  
  public abstract void sendHit(List paramList)
    throws RemoteException;
  
  public abstract class Stub
    extends Binder
    implements IMediaControllerCallback
  {
    public static final int CODE_PLAYLISTMEMBER = 11;
    public static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
    public static final int Id_uneval = 13;
    public static final int SDLK_F = 9;
    public static final int STANDARD_GAP_WIDTH = 10;
    public static final int STATE_PAUSED_ROAMING = 12;
    public static final int TRANSACTION_onEvent = 1;
    public static final int TRANSACTION_onExtrasChanged = 7;
    public static final int TRANSACTION_onMetadataChanged = 4;
    public static final int TRANSACTION_onPlaybackStateChanged = 3;
    public static final int TRANSACTION_onQueueChanged = 5;
    public static final int TRANSACTION_onQueueTitleChanged = 6;
    public static final int TRANSACTION_onSessionDestroyed = 2;
    public static final int TRANSACTION_onVolumeInfoChanged = 8;
    
    public Stub()
    {
      attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
    }
    
    public static IMediaControllerCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
      if ((localIInterface != null) && ((localIInterface instanceof IMediaControllerCallback))) {
        return (IMediaControllerCallback)localIInterface;
      }
      return new a.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 != 1598968902)
      {
        boolean bool2 = false;
        boolean bool1 = false;
        Object localObject2 = null;
        Object localObject3 = null;
        Object localObject4 = null;
        Object localObject5 = null;
        Object localObject1 = null;
        String str = null;
        switch (paramInt1)
        {
        default: 
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        case 13: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onEvent();
          return true;
        case 12: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onPlaybackStateChanged(paramParcel1.readInt());
          return true;
        case 11: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcel1.readInt() != 0) {
            bool1 = true;
          }
          next(bool1);
          return true;
        case 10: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          bool1 = bool2;
          if (paramParcel1.readInt() != 0) {
            bool1 = true;
          }
          onPitchAdjustmentAvailableChanged(bool1);
          return true;
        case 9: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          next(paramParcel1.readInt());
          return true;
        case 8: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          paramParcel2 = str;
          if (paramParcel1.readInt() != 0) {
            paramParcel2 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(paramParcel1);
          }
          onVolumeInfoChanged((ParcelableVolumeInfo)paramParcel2);
          return true;
        case 7: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          paramParcel2 = localObject2;
          if (paramParcel1.readInt() != 0) {
            paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          }
          onEvent((Bundle)paramParcel2);
          return true;
        case 6: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          paramParcel2 = localObject3;
          if (paramParcel1.readInt() != 0) {
            paramParcel2 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel1);
          }
          send((CharSequence)paramParcel2);
          return true;
        case 5: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          sendHit(paramParcel1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
          return true;
        case 4: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          paramParcel2 = localObject4;
          if (paramParcel1.readInt() != 0) {
            paramParcel2 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(paramParcel1);
          }
          onMetadataChanged((MediaMetadataCompat)paramParcel2);
          return true;
        case 3: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          paramParcel2 = localObject5;
          if (paramParcel1.readInt() != 0) {
            paramParcel2 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(paramParcel1);
          }
          onPlaybackStateChanged((PlaybackStateCompat)paramParcel2);
          return true;
        case 2: 
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onSessionDestroyed();
          return true;
        }
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        str = paramParcel1.readString();
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onEvent(str, (Bundle)paramParcel2);
        return true;
      }
      paramParcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
      return true;
    }
  }
}
