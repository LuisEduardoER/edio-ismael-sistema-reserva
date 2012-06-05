package br.com.novaroma.Gui;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.novaroma.Negocio.Cliente;
import br.com.novaroma.Negocio.FachadaCadastros;
import br.com.novaroma.Negocio.TipoCliente;


@WebServlet("/cadastrarCliente")
public class cadastrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public cadastrarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FachadaCadastros fachada = FachadaCadastros.getInstancia();
		Cliente cliente = new Cliente();
		
		cliente.setCnh(request.getParameter("txCnh"));
		cliente.setCpf(request.getParameter("txCpf"));
		cliente.setIdade(Integer.parseInt(request.getParameter("txIdade")));
		cliente.setNome(request.getParameter("txNome"));
		cliente.setTelefone(request.getParameter("txFone"));
		
		String dataString = request.getParameter("txTempoCnh");
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = null;
		try {
			data = new java.sql.Date(format.parse(dataString).getTime());
		} catch (ParseException e1) {
			System.out.println(e1.getMessage());
		}
		cliente.setTempoCnh(data);
		 
		String tipoCliente = request.getParameter("txTipoCliente");
		if (tipoCliente.toUpperCase().equals("PREFERENCIAL"))
			cliente.setTipo(TipoCliente.PREFERENCIAL);
		else
			cliente.setTipo(TipoCliente.NORMAL);
		
		try {
			fachada.incluirCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
