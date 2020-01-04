package com.chess.UserInterface;

import static spark.Spark.*;


import com.chess.appl.PlayerLobby;
import com.google.gson.Gson;
import spark.TemplateEngine;

import java.util.Objects;
import java.util.logging.Logger;

import static spark.Spark.staticFileLocation;

public class WebServer {

    private static final Logger LOG = Logger.getLogger(WebServer.class.getName());

    public final PlayerLobby lobby;

    public static final String HOME_URL = "/";
    public static final String SIGNIN_URL="/signin";
    public static final String SIGNOUT_URL="/";
    public static final String GAME_URL="/game";

    private final TemplateEngine templateEngine;
    private final Gson gson;

    public WebServer(final TemplateEngine templateEngine, final Gson gson, PlayerLobby lobby)
    {
        //checking if templateEngine and gson is not null
        Objects.requireNonNull(templateEngine,"templateEngine must not be null");
        Objects.requireNonNull(gson,"gson must not be  null");

        this.templateEngine=templateEngine;
        this.gson=gson;
        this.lobby=lobby;
    }

    public void initialize(){

        staticFileLocation("/public");

        //to GET the Home page
        get(HOME_URL, new GetHomeRoute(templateEngine, lobby, gson));

        //related to signing in
        get(SIGNIN_URL, new GetSignInRoute(templateEngine,gson));
        post(SIGNIN_URL, new PostSignInRoute(templateEngine,lobby));

        post(SIGNOUT_URL, new PostSignOutRoute(templateEngine,lobby));

        //related to the game
        get(GAME_URL, new GetGameRoute(templateEngine));

        LOG.config("WebServer is initialized.");
    }
}
