package br.com.bicosonline.support;

import java.io.Serializable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;  
  
  
public class UserLogadoController implements Serializable {  
      
    /**
	 * 
	 */
	private static final long serialVersionUID = 625655112377685665L;
	
	private br.com.bicosonline.model.User usuario;  
      
      
    public UserLogadoController(){  
        usuario = new br.com.bicosonline.model.User();  
        SecurityContext context = SecurityContextHolder.getContext();  
        if(context instanceof SecurityContext)  
        {  
            Authentication authentication = context.getAuthentication();  
            if(authentication instanceof Authentication)  
            {  
                 usuario.setLogin(((User)authentication.getPrincipal()).getUsername());  
            }  
        }  
          
    }  
  
    public br.com.bicosonline.model.User getUsuario() {  
        return usuario;  
    }  
  
    public void setUsuario(br.com.bicosonline.model.User usuario) {  
        this.usuario = usuario;  
    }  
      
      
  
}  