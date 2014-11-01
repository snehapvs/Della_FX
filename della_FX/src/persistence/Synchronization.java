
package persistence;

import java.net.URL;
import java.net.URLConnection;

/**
 * */
public class Synchronization {
/**Della10 - to check for Internet connectivity.
*/
private boolean userOnline = true;
/** Check the status of the user.
* @return boolean
*/
public final boolean isUserOnline() {
	try {
		URL url = new URL("http://www.google.com/");
		URLConnection conn = url.openConnection();
		System.out.println();
		conn.connect();
		return userOnline;
		// System.out.println("its Working Fine ! ");
	} catch (Exception e) {
		return !userOnline;
		//System.out.println("Not Working");
	}
}
/** Updating the database from the local cache.
*/
public void synchronize() {
}
/**LockTask locks the update operation
 *when multiple users are accessing the same table.
* @return boolean
*/
public final boolean lockTask() {
return false;
}
}
