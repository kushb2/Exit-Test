package io.nagarro.exit.shared;

import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface IService {

	public JSONObject getUser(String id) throws UnirestException, JSONException; 
	public void blockBetAmount(int totalBetAmount) throws JSONException, UnirestException;
	public void UpdateBalace(double updatedBal) throws UnirestException, JSONException;
	public double checkResult(int[] betArray, int randomNo); 
}
