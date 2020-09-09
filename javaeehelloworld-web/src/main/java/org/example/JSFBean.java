package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class JSFBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String input = "leer";

    private static final Logger log = LoggerFactory.getLogger(JSFBean.class);

    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput(){

        log.error("Hi!");

        return "..some output..";
    }
}
