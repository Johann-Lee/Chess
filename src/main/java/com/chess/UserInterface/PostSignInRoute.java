package com.chess.UserInterface;

import com.chess.appl.PlayerLobby;
import com.chess.model.Player;
import spark.*;

import static spark.Spark.get;

public class PostSignInRoute implements Route {

    public final String LOBBY_URL="/lobby";

    private final TemplateEngine templateEngine;
    private final PlayerLobby lobby;

    public PostSignInRoute(TemplateEngine templateEngine, PlayerLobby lobby)
    {
        this.templateEngine=templateEngine;
        this.lobby=lobby;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

    final Session httpSession = request.session();

    try{
        Player currentPlayer = new Player(request.queryParams("username"));
        lobby.addPlayer(currentPlayer);

        httpSession.attribute("currentUser",currentPlayer);

    }catch(IllegalArgumentException e)
    {}

    response.redirect(WebServer.HOME_URL);
    return null;
    }
}
