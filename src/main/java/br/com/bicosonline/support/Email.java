package br.com.bicosonline.support;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;

public class Email {
	
	
	
	public void sendEmailIndicacao(List<Pessoa> listasEmpregados, Pessoa empregador) throws EmailException {
	    
		   SimpleEmail email = new SimpleEmail();
		   
		   //Utilize o hostname do seu provedor de email
		   System.out.println("alterando hostname...");
		   email.setHostName("smtp.gmail.com");

		   //Quando a porta utilizada não é a padrão (gmail = 465)
		   email.setSmtpPort(465);

		   //Adicione os destinatários
		   email.addTo(empregador.getEmail(), empregador.getNome());

		   //Configure o seu email do qual enviará
		   email.setFrom("alvarodearaujo13@gmail.com", "Álvaro de Araújo");

		   //Adicione um assunto
		   email.setSubject("Indicação de empregado a vaga tal");

		   //fazendo o corpo do e-mail
		   StringBuilder sb = new StringBuilder("Listas de empregados para contatar: \n");
		   for(Pessoa p : listasEmpregados){
			   sb.append("Nome: "+p.getNome() +" , Endereço: \n");
		   }
		   
		   //Adicione a mensagem do email		   
		   email.setMsg("Aqui vai estar os dados dos caras");

		   //Para autenticar no servidor é necessário chamar os dois métodos abaixo
		   System.out.println("autenticando...");
		   email.setSSL(true);
		   email.setAuthentication("alvarodearaujo13@gmail.com", "Vinho@1992");
		   
		   System.out.println("enviando...");
		   email.send();
		   
		   System.out.println("Email enviado!");
		}
	
	
	public void sendEmailUsuario(User usuario) throws EmailException {
	    
		   SimpleEmail email = new SimpleEmail();
		   
		   //Utilize o hostname do seu provedor de email
		   System.out.println("alterando hostname...");
		   email.setHostName("smtp.gmail.com");

		   //Quando a porta utilizada não é a padrão (gmail = 465)
		   email.setSmtpPort(465);

		   //Adicione os destinatários
		   email.addTo(usuario.getEmail(), usuario.getNome());

		   //Configure o seu email do qual enviará
		   email.setFrom("alvarodearaujo13@gmail.com", "Bicos Online");

		   //Adicione um assunto
		   email.setSubject("Usuário para acesso ao sistema");

		   //Adicione a mensagem do email		   
		   email.setMsg("Dados do usuário para acesso ao sistema. \n Login: "+usuario.getLogin() 
		   				+" \n Senha: " + usuario.getPassword());

		   //Para autenticar no servidor é necessário chamar os dois métodos abaixo
		   System.out.println("autenticando...");
		   
		   email.setSSL(true);
		   
		   email.setAuthentication("alvarodearaujo13@gmail.com", "Vinho@1992");
		   
		   System.out.println("enviando...");
		   email.send();
		   
		   System.out.println("Email enviado!");
		}
	
}
