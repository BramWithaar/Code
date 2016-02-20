package nl.nijmegen.mule.totp;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

public class CreateToken implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		final GoogleAuthenticatorKey key = gAuth.createCredentials();
		
		System.out.println("User key: " + key.getKey() );
		
		return key.getKey();
	}

}
