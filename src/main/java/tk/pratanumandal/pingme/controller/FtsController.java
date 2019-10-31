package tk.pratanumandal.pingme.controller;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tk.pratanumandal.pingme.bean.Client;
import tk.pratanumandal.pingme.bean.Message;
import tk.pratanumandal.pingme.exception.ResourceNotFoundException;

@Controller
public class FtsController {
	
	@Autowired
	private Logger logger;
	
	private List<Message> messageList = new ArrayList<Message>();
	
	private List<Client> clientList = new ArrayList<Client>();
	
	@RequestMapping("/**/{[path:[^\\.]*}")
	public String any() {
		throw new ResourceNotFoundException("The requested path was not found on the server");
	}
	
	@GetMapping("/ping")
	public void ping(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(200);
	}
	
	@GetMapping("/login")
	public String login(@PathParam("logout") String logout, HttpServletResponse response) {
		
		if (logout != null || 
			(SecurityContextHolder.getContext().getAuthentication() != null &&
			 SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
			 !(SecurityContextHolder.getContext().getAuthentication()  instanceof AnonymousAuthenticationToken))) {
			try {
				response.sendRedirect("/");
			} catch (IOException e) {
				logger.error("An error occurred when trying to log in");
				e.printStackTrace();
			}
		}
		
		return "login";
	}
	
	@GetMapping("/")
	public String getChat(Map<String, Object> model, HttpServletResponse response) throws IOException {
		
		model.put("chat", messageList);
		
		/*for (Message message : messageList) {
			response.getWriter().write(message.getClient().getUsername() + ": " + message.getText() + "<br>");
		}*/

		return "index";
	}

	@PostMapping("/")
	public void sendMessage(@RequestParam("message") String text, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getRemoteUser();
		String IPAddress = request.getRemoteAddr();
		
		Client client = new Client(username, IPAddress);
		
		int index = clientList.indexOf(client);
		
		if (index >= 0) {
			client = clientList.get(index);
		}
		else {
			client.setColor(Color.BLACK);
			clientList.add(client);
		}
		
		System.out.println(text);
		
		Message message = new Message(client, text);
		
		messageList.add(message);
	}

}
