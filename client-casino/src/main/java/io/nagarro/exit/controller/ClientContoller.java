package io.nagarro.exit.controller;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.shouldHaveThrown;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import io.nagarro.exit.service.ClientService;
import io.nagarro.exit.shared.Constants;
import io.nagarro.exit.shared.IController;
import io.nagarro.exit.shared.RandomNumerGenrator;
import io.nagarro.exit.shared.Utility;

/*
 * session Attributes : id, user, accountBal
 */
@Controller
@SessionAttributes("id")
public class ClientContoller implements IController {

	@Autowired
	ClientService clientService;

	/*
	 * home : shows the login portal is session created otherwise redirect to
	 * loginWindow
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Map<String, Object> model, HttpSession session) {
		return  Constants.LOGIN_PAGE; 
	}

	@RequestMapping("/loginWindow")
	public String LoginPage(ModelMap model) {
		return  Constants.LOGIN_WINDOW;
	}

	/*
	 * CheckUser Argument: model, id, session check id exist : redirect to play
	 * not exist : redirect to loginWindow with error Msg Add user info in Set
	 * session attributes if Valid
	 */
	@RequestMapping(value = "/valid", method = RequestMethod.POST)
	public String CheckUser(Map<String, Object> model, @RequestParam("userID") Long id, HttpSession session)
			throws UnirestException, JSONException {

		JSONObject user = clientService.getUser(id.toString());

		if (user == null) {
			model.put("invalid", Constants.INVALID_CREDENTIALS);
			return Constants.LOGIN_WINDOW;
		}

		else {
			model.put("name", user.get("name"));
			session.setAttribute("id", user.getLong("secretID"));
			session.setAttribute("result", false);
			session.setAttribute("user", user.get("name"));
			session.setAttribute("accountBal", user.getDouble("accountBal"));

			return Constants.GAME_PAGE;
		}
	}

	/*
	 * logout Argument :
	 * 
	 * @RequestParam Map<String, Object> model HttpSession session SessionStatus
	 * status check session valid or not if : remove session attribute redirect
	 * to home page else : return null;
	 */
	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#logout(java.util.Map, javax.servlet.http.HttpSession, org.springframework.web.bind.support.SessionStatus)
	 * logout Argument :
	 * @RequestParam Map<String, Object> model HttpSession session SessionStatus
	 * status check session valid or not if : remove session attribute redirect
	 * to home page else : return null;
	 */
	@PostMapping("/logout")
	public String logout(@RequestParam Map<String, Object> model, HttpSession session, SessionStatus status) {
		if (session != null) {
			System.out.println("logout");
			session.removeAttribute("name");
			session.removeAttribute("accountBal");
			session.removeAttribute("id");
			status.setComplete();
			session.invalidate();

			return home(model, null);
		} else
			return null;
	}

	
	
	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#genrateResult(java.util.Map, java.util.Map, javax.servlet.http.HttpSession)
	 * genrateResult : 1. Generate lucky number 2. validate result based on bet
	 * amount Argument :
	 * 
	 * @RequestParam Map<String, String> map Map<String, Object> model
	 * HttpSession session
	 */
	@PostMapping("/result")
	public String genrateResult(@RequestParam Map<String, String> map, Map<String, Object> model, HttpSession session)
			throws JSONException, UnirestException {

		System.out.println("genrateResult");

		int[] betAmount = Utility.getBetAmount(map);
		int totalBetAmount = Arrays.stream(betAmount).sum(); // total bet put by
																// user
		Double accountBal = Double.parseDouble(session.getAttribute("accountBal").toString()); // current
																								// balance

		if (accountBal >= totalBetAmount * 1.0) { // check have sufficient
													// balance in account or not
			int randomNo = RandomNumerGenrator.genrate(); // Generate Lucky
															// Number
			// clientService.blockBetAmount(totalBetAmount);
			// System.out.println(randomNo);

			Double res = clientService.checkResult(betAmount, randomNo);
			int updatedBal = (int) (res - totalBetAmount); // update balance
			clientService.UpdateBalace(updatedBal);

			model.put("rouletteNo", randomNo);
			model.put("win", res);
			model.put("updatedBal", updatedBal);
			session.setAttribute("accountBal", updatedBal);

			return Constants.SHOW_RESULT; 
		} else {
			return Constants.INVALID_PLAY;
		}

	}

}
