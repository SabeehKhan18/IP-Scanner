import java.net.UnknownHostException;

/**
 * Program to scan for IP addresses 
 * and (if possible) return hostnames
 * 
 * Fundamental idea is to use InetAdress.getByName(ip)
 * then getHostName()
 * 
 * e.g.
 * InetAddress addr = InetAddress.getByName("localhost");
 * System.out.println("Host name is: "+addr.getHostName());
 * System.out.println("Ip address is: "+ addr.getHostAddress());
 * 
 * @author Sabeeh
 *
 */
public class Main {

	public static void main(String[] args) throws SecurityException, UnknownHostException {
		String ip_start = "192.168.1.1";
		String ip_final = "192.168.1.255";
		
		String ip = ip_start;
		
		while (!ip.equals(ip_final)) {
			Thread scan = new Thread(new Scanner(ip));
			scan.start();
			
			// Convert to array to increment
			int[] ip_next = new int[4];
			String[] parts = ip.split("\\.");

			for (int i = 0; i < 4; i++) {
			    ip_next[i] = Integer.parseInt(parts[i]);
			}
			
			// Increment for next IP
			ip_next[3] += 1;
			
			// If reached IP bounds, increase next upper byte
			if (ip_next[3] == 256) {
				ip_next[2] += 1;
				ip_next[3] = 0;
			}
			if (ip_next[2] == 256) {
				ip_next[1] += 1;
				ip_next[2] = 0;
			}
			
			if (ip_next[1] == 256) {
				ip_next[0] += 1;
				ip_next[1] = 0;
			}
			
			// Convert next ip back to string
			String conv = "";

	        for(int i : ip_next) {
	            conv += Integer.toString(i) + ".";
	        }
	        ip = conv.substring(0, conv.length()-1); // to eliminate extra "."
		}	
	}
}
