package support.android.v4.net;

import java.io.FileDescriptor;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class Message
  extends Socket
{
  public Message(DatagramSocket paramDatagramSocket, FileDescriptor paramFileDescriptor)
    throws SocketException
  {
    super(new TlsOnlySocketFactory.DelegateSSLSocket(paramDatagramSocket, paramFileDescriptor));
  }
}
