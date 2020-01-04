package com.chess.UserInterface;

import com.chess.appl.PlayerLobby;
import com.chess.model.Player;
import spark.*;

import java.util.HashMap;

public class PostSignOutRoute implements Route {



    private final PlayerLobby lobby;
    private final TemplateEngine templateEngine;

    public PostSignOutRoute(TemplateEngine templateEngine, PlayerLobby lobby)
    {
        this.templateEngine=templateEngine;
        this.lobby=lobby;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        final Session httpSession = request.session();
        Player currentUser = httpSession.attribute("currentUser");

        //remove player from the lobby

        if(this.lobby.signOut(currentUser))
            System.out.println(currentUser.getUsername()+" has signed out");
        else
            System.out.println("error");

        //remove player from httpSession
        httpSession.attribute("currentUser",null);

        HashMap vm = new HashMap();
        vm.put("title","Chess");
        vm.put("currentUser",null);
        vm.put("lobby",lobby);
        vm.put("playerCount",lobby.playerCount());
        //redirect to newly rendered homepage
        return templateEngine.render(new ModelAndView(vm, "home.ftl"));
    }
}
