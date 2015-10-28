package br.com.bicosonline.support;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.bicosonline.model.Pessoa;

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
}
