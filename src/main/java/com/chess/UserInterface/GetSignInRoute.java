package com.chess.UserInterface;

import com.google.gson.Gson;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class GetSignInRoute implements Route {

    private static final Logger LOG = Logger.getLogger(GetSignInRoute.class.getName());

    static final String VIEWNAME="signin.ftl";
    private final TemplateEngine templateEngine;


    public GetSignInRoute(final TemplateEngine templateEngine, Gson gson)
    {
        this.templateEngine = Objects.requireNonNull(templateEngine, "templateEngine is required");


    }

    @Override
    public Object handle(Request request, Response response) throws Exception {

        LOG.finer("GetSignInRoute is invoked.");


        Map<String, Object> vm = new HashMap<>();
        vm.put("title","SIGNIN");
        return templateEngine.render(new ModelAndView(vm, VIEWNAME));
    }
}
