package br.com.bacana.store.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionCheck {

    private HttpSession session;
    private String authenticated;

    public SessionCheck() {
        super();
    }

    public void saveSession(HttpServletRequest request) {

        session = request.getSession();

        if(!session.isNew()) {
            session.invalidate();
        }

        session.setAttribute("authenticated", "autenticado");

        System.out.println(session.getAttribute("authenticated"));

    }

    public String checkSession(HttpServletRequest request) {

        session = request.getSession();
        System.out.println(session);
        return (String) session.getAttribute("authenticated");

    }
}
