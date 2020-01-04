package com.chess.UserInterface;

import com.chess.appl.PlayerLobby;
import com.chess.model.Player;
import freemarker.template.Configuration;
import spark.*;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Every GET/POST route class implements javaSparks Route class
 */
public class GetHomeRoute implements Route {

    private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());

    static final String CURRENT_USER_KEY = "currentUser";


    static final String viewname="home.ftl";


    private final TemplateEngine templateEngine;
    private final PlayerLobby lobby;
    private Gson gson;



    public GetHomeRoute(final TemplateEngine templateEngine, PlayerLobby lobby, Gson gson)
    {
        this.templateEngine = Objects.requireNonNull(templateEngine,"templateEngine is required");
        LOG.config("GetHomeRoute is initialized.");

        this.lobby=lobby;
        this.gson=gson;
    }

    @Override
    public Object handle(Request request, Response response)  {
        LOG.finer("GetHomeRoute is invoked.");


        Map<String, Object> vm = new HashMap<>();

        final Session httpSession = request.session();
        Player currentPlayer = httpSession.attribute(CURRENT_USER_KEY);


        vm.put("title","CHESS");
        vm.put("lobby",lobby.getPlayers());
        vm.put("playerCount",lobby.playerCount());

        //given a player has signed in
        if(currentPlayer!=null) {
            vm.put(CURRENT_USER_KEY, currentPlayer);
            return templateEngine.render(new ModelAndView(vm, viewname));
        }
        //if the user has not signed in
        else
            vm.put(CURRENT_USER_KEY, null);
        return templateEngine.render(new ModelAndView(vm, viewname));
    }
}
