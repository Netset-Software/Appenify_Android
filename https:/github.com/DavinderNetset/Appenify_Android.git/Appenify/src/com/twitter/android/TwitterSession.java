package com.twitter.android;

import twitter4j.auth.AccessToken;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TwitterSession {
	private SharedPreferences sharedPref;
    private Editor editor;

//    private static final String TWEET_AUTH_KEY = "773288390-7R2uRLChWGEpLUFWSqGFtYg9hBV7Ub1k7aztciNb";
//    private static final String TWEET_AUTH_SECRET_KEY = "yEg5LkxkfQIdRKaTQtoIhMAZkEjHiBMRKoJlwhECVb4";
    
//  private static final String TWEET_AUTH_KEY = "773288390-7R2uRLChWGEpLUFWSqGFtYg9hBV7Ub1k7aztciNb";
//  private static final String TWEET_AUTH_SECRET_KEY = "yEg5LkxkfQIdRKaTQtoIhMAZkEjHiBMRKoJlwhECVb4";
    
    
    
    private static final String TWEET_AUTH_KEY = "JOtYdQJwVZWdYpC0k4NvT4HzN";
    private static final String TWEET_AUTH_SECRET_KEY = " wR37ia7LxahAdGPUkltHvZK7S1HHYE5usdWR4BZYPMGIjUJrek";
    
    
    
    
    private static final String TWEET_USER_NAME = "user_name";
    private static final String SHARED = "Twitter_Preferences";

    public TwitterSession(Context context) {
        sharedPref = context.getSharedPreferences(SHARED, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void storeAccessToken(AccessToken accessToken, String username) {
        editor.putString(TWEET_AUTH_KEY, accessToken.getToken());
        editor.putString(TWEET_AUTH_SECRET_KEY, accessToken.getTokenSecret());
        editor.putString(TWEET_USER_NAME, username);
        editor.commit();
    }

    public void resetAccessToken() {
        editor.putString(TWEET_AUTH_KEY, null);
        editor.putString(TWEET_AUTH_SECRET_KEY, null);
        editor.putString(TWEET_USER_NAME, null);

        editor.commit();
    }

    public String getUsername() {
        return sharedPref.getString(TWEET_USER_NAME, "");
    }

    public AccessToken getAccessToken() {
        String token = sharedPref.getString(TWEET_AUTH_KEY, null);
        String tokenSecret = sharedPref.getString(TWEET_AUTH_SECRET_KEY, null);

        if (token != null && tokenSecret != null)
            return new AccessToken(token, tokenSecret);
        else
            return null;
    }
}
