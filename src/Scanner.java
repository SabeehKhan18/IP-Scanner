import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 
 * Class that will do the scanning
 *
 */
public class Scanner implements Runnable {
	private InetAddress target;
	
	public Scanner(String ip) throws SecurityException, UnknownHostException {
		target = InetAddress.getByName(ip);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (!target.getHostAddress().equals(target.getHostName()))
			System.out.print("IP: "+ target.getHostAddress() +", Hostname: " + target.getHostName()+ "\n");
		
	}

}
