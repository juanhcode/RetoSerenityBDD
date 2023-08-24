package co.com.greyd.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElToken implements Question {
    private static String token;

    public ElToken(String token) {this.token=token;
    }

    @Override
    public Object answeredBy(Actor actor) {
        return token.equals("QpwL5tke4Pnpja7X4");
    }
    public static final ElToken esElMismo(String token) {return new ElToken(token);}
}
