package nl.nijmegen.mule.totp;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.warrenstrange.googleauth.GoogleAuthenticator;

public class ValidateToken implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		String tokenString = eventContext.getMessage().getInboundProperty("token");
		int itoken = Integer.parseInt(tokenString);
		System.out.println("Username: " + itoken);

		String secretKey = eventContext.getMessage().getInvocationProperty("secret");
		System.out.println("secret: " + secretKey);
		
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		boolean isCodeValid = gAuth.authorize(secretKey, itoken);
		System.out.println("isCodeValid: " + isCodeValid);
		
		//return "invalid";
		
		if (isCodeValid){
			return "valid";
		} else {
			return "invalid";
		}
		
	}

}
