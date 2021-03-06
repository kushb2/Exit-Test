package io.nagarro.exit.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.nagarro.exit.shared.IService;

/*
 * ClientService
 * unirest HTTP request Library
 */
@Service
public class ClientService implements IService {

	private JSONObject user;

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.nagarro.exit.shared.IService#getUser(java.lang.String)
	 */
	public JSONObject getUser(String id) throws UnirestException, JSONException {

		// get request parsed in Json
		final HttpResponse<JsonNode> responce = Unirest.get("http://localhost:8080/api/user/{id}").routeParam("id", id)
				.asJson();

		user = responce.getBody().getObject();
		return !user.toString().contains("exception") ? user : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.nagarro.exit.shared.IService#blockBetAmount(int)
	 */
	public void blockBetAmount(int totalBetAmount) throws JSONException, UnirestException {
		System.out.println("blockBetAmount");
		System.out.println(totalBetAmount);
		user.put("blockedAmount", totalBetAmount);
		HttpResponse<JsonNode> postResponse = Unirest.put("http://localhost:8080/api/blockedAmount")
				.header("accept", "application/json").header("Content-Type", "application/json").body(user).asJson();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.nagarro.exit.shared.IService#UpdateBalace(double)
	 */
	public void UpdateBalace(double updatedBal) throws UnirestException, JSONException {

		// update Account Balance
		Double accountBal = Double.parseDouble(user.get("accountBal").toString());
		user.put("accountBal", updatedBal + accountBal);

		HttpResponse<JsonNode> postResponse = Unirest.put("http://localhost:8080/api/user")
				.header("accept", "application/json").header("Content-Type", "application/json").body(user).asJson();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.nagarro.exit.shared.IService#checkResult(int[], int)
	 */
	public double checkResult(int[] betArray, int randomNo) {
		try {
			double res = 0L;
			for (int betIndex = 0; betIndex < betArray.length; betIndex++) {
				switch (betIndex) {
				case 0:
					if (randomNo >= 1 && randomNo <= 12)

						res += betArray[betIndex] * 1.5;
					break;

				case 1:
					if (randomNo >= 13 && randomNo <= 24)
						res += betArray[betIndex] * 1.5;
					break;

				case 2:
					if (randomNo >= 25 && randomNo <= 36)
						res += betArray[betIndex] * 1.5;
					break;

				case 3:
					if (randomNo == 0)
						res += betArray[betIndex] * 10;
					break;

				case 4:
					if (randomNo >= 1 && randomNo <= 18)
						res += betArray[betIndex] * 1.25;
					break;

				case 5:
					if (randomNo >= 19 && randomNo <= 36)
						res += betArray[betIndex] * 1.25;
					break;

				case 6:
					if (randomNo % 2 == 0)
						res += betArray[betIndex] * 1.25;
					break;

				case 7:
					if (randomNo % 2 != 0)
						res += betArray[betIndex] * 1.25;
					break;
				}
			}
			return res;
		} catch (Exception e) {
			throw e;
		}
	}
}
