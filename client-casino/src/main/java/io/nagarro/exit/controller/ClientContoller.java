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
import io.nagarro.exit.shared.RandomNumerGenrator;

@Controller
@SessionAttributes("id")
public class ClientContoller {

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Map<String, Object> model, HttpSession session) {
		return "login";
	}

	@RequestMapping("/loginWindow")
	public String LoginPage(ModelMap model) {
		return "loginWindow";
	}

	@RequestMapping(value = "/valid", method = RequestMethod.POST)
	public String CheckUser(Map<String, Object> model, @RequestParam("userID") Long id, HttpSession session)
			throws UnirestException, JsonParseException, JsonMappingException, IOException, JSONException {
		System.out.println("/valid" + id);

		JSONObject user = clientService.getUser(id.toString());

		if (user == null) {
			model.put("invalid", "InvalidUser Try again!");
			return "loginWindow";
		} else {
			model.put("name", user.get("name"));
			session.setAttribute("id", user.getLong("secretID"));
			session.setAttribute("result", false);
			session.setAttribute("user", user.get("name"));
			session.setAttribute("accountBal", user.getDouble("accountBal"));
			return "play";
		}
	}

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

	@PostMapping("/result")
	public String genrateResult(@RequestParam Map<String, String> map, Map<String, Object> model, HttpSession session)
			throws JSONException, UnirestException {
		System.out.println("genrateResult");
		int[] betAmount = new int[8];
		int index = 0;
		int totalBetAmount = 0;
		int[] idx = { 0 };
		map.forEach((key, value) -> {
			betAmount[idx[0]++] = !value.equals("") ? Integer.parseInt(value) : 0;
		});
		Arrays.stream(betAmount).forEach(x -> System.out.println(x));
		totalBetAmount = Arrays.stream(betAmount).sum();
		System.out.println("before if");
		Double accountBal = Double.parseDouble(session.getAttribute("accountBal").toString());
		System.out.println(accountBal);
		System.out.println(totalBetAmount * 1.0);
		if (accountBal >= totalBetAmount * 1.0) {
			int rouletteNumber = RandomNumerGenrator.genrate();
			System.out.println(rouletteNumber);
//			 clientService.blockBetAmount(totalBetAmount);

			System.out.println(rouletteNumber);
			model.put("rouletteNumber", rouletteNumber);

			int resultamount = clientService.checkResult(betAmount, rouletteNumber);

			model.put("awardedMoney", resultamount);
			int updatedBalance = resultamount - totalBetAmount;
			System.out.println(updatedBalance);
			model.put("updatedAmountBalance", updatedBalance);
			clientService.UpdateBalace(updatedBalance);
			session.setAttribute("useraccountbalance", updatedBalance);

			return "result";
		} else {
			System.out.println("else Part");
			return "sorry";
		}

	}

}
