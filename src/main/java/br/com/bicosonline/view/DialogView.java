package br.com.bicosonline.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class DialogView {
 
    public void confirmaAdicionamento() {
        addMessage("Confirmação", "Indicação Adicionada.");
    }
     
    public void confirmacaoIdicacao(){
    	addMessage("Confirmação", "Indicação Realizada com Sucesso");
    }
    
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
}