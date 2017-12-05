package io.nagarro.exit.service;

import org.crsh.shell.impl.command.system.help;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import scala.annotation.meta.setter;

@Service
public class ClientService {

	private JSONObject user;
	
	public JSONObject getUser(String id) throws UnirestException, JSONException {
	
	final HttpResponse<JsonNode> responce = Unirest.get("http://localhost:8080/api/user/{id}")
	.routeParam("id",id).asJson();
		user = responce.getBody().getObject();
		System.out.println(user);
		if(!user.toString().contains("exception")) {
			System.out.println("bilal");
			return user;
		}
		else{
			System.out.println("shriram");
			return null;
		}
		
		
	}
	public void blockBetAmount(int totalBetAmount) throws JSONException, UnirestException {
		System.out.println("blockBetAmount");
		System.out.println(totalBetAmount);
		user.put("blockedAmount", totalBetAmount);
		HttpResponse<JsonNode> postResponse = 	Unirest.put("http://localhost:8080/api/blockedAmount").header("accept","application/json")
		.header("Content-Type", "application/json").body(user).asJson();
	}
	
	public void UpdateBalace(double updatedAccountBal) throws UnirestException, JSONException {
		Double accountBal = Double.parseDouble(user.get("accountBal").toString());
		System.out.println(accountBal);
//		System.out.println(totalBetAmount * 1.0);
		user.put("accountBal", updatedAccountBal + accountBal);
		
		System.out.println(user.toString());
		System.out.println(user);
		HttpResponse<JsonNode> postResponse = Unirest.put("http://localhost:8080/api/user")
		        .header("accept", "application/json")
		        .header("Content-Type", "application/json")
		        .body(user)
		        .asJson();
	}


	



	public int checkResult(int[] betValues, int rouletteNumber) {
		int resultAmount=0;
		for(int betNumber=0; betNumber<betValues.length; betNumber++)
		{
			if(betNumber==0 && (rouletteNumber>=1 && rouletteNumber<=12) && betValues[betNumber]!=0)
			{
				resultAmount+=(betValues[betNumber]*3/2);
			}
			if(betNumber==1 && (rouletteNumber>=13 && rouletteNumber<=24) && betValues[betNumber]!=0)
			{
				resultAmount+=(betValues[betNumber]*3/2);
			}
			if(betNumber==2 && (rouletteNumber>=25 && rouletteNumber<=36) && betValues[betNumber]!=0)
			{
				resultAmount+=(betValues[betNumber]*3/2);
			}
			if(betNumber==3 && (rouletteNumber==0 ) && betValues[betNumber]!=0)
			{
				resultAmount+=(betValues[betNumber]*10);
			}
			if(betNumber==4 && (rouletteNumber>=1 && rouletteNumber<=18) && betValues[betNumber]!=0)
			{
				resultAmount+=(betValues[betNumber]*5/4);
			}
			if(betNumber==5 && (rouletteNumber>=19 && rouletteNumber<=36) && betValues[betNumber]!=0)
			{
				resultAmount+=(betValues[betNumber]*5/4);
			}
			if(betNumber==6 && (rouletteNumber%2==0) && betValues[betNumber]!=0)
			{
				resultAmount+=(betValues[betNumber]*5/4);
			}
			if(betNumber==7 && (rouletteNumber%2!=0) && betValues[betNumber]!=0)
			{
				resultAmount+=(betValues[betNumber]*5/4);
			}
		
		}
		// TODO Auto-generated method stub
	
		return resultAmount;
		
		
	}
	

	


	
}
