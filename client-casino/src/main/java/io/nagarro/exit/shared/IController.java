package io.nagarro.exit.shared;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface IController {

	public String home(Map<String, Object> model, HttpSession session);
	public String LoginPage(ModelMap model);
	public String CheckUser(Map<String, Object> model, @RequestParam("userID") Long id, HttpSession session) throws UnirestException, JSONException;
	public String logout(@RequestParam Map<String, Object> model, HttpSession session, SessionStatus status);
	public String genrateResult(@RequestParam Map<String, String> map, Map<String, Object> model, HttpSession session) throws JSONException, UnirestException;
		
}
