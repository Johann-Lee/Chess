package com.chess.UserInterface;

import spark.*;

import java.util.HashMap;

public class GetGameRoute implements Route {

    public final String VIEWNAME="game.ftl";


    private final TemplateEngine templateEngine;



    public GetGameRoute(TemplateEngine templateEngine)
    {
        this.templateEngine=templateEngine;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        HashMap vm = new HashMap();
        vm.put("title","CHESS");

        return templateEngine.render(new ModelAndView(vm,VIEWNAME));
    }
}
