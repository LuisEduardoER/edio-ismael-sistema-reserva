<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Cliente</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
	<div align="center">
		<form align=center action="cadastrarCliente" method="post">
			<h3>${mensagem}</h3>
			<table>
				<tr align="center">
					<td>Nome</td>
					<td>
					<input name="txNome" size="50" maxlength="40">
					</td>
				<tr/>
				<tr align="center">
					<td>Idade</td>
					<td>
					<input name="txIdade" size="50" maxlength="40">
					</td>
				<tr/>
				<tr align="center">
					<td>CPF</td>
					<td>
					<input name="txCpf" size="50" maxlength="11">
					</td>
				<tr/>
				<tr align="center">
					<td>Cart. de Motorista</td>
					<td>
					<input name="txCnh" size="50" maxlength="40">
					</td>
				<tr/>
				<tr align="center">
					<td>Telefone</td>
					<td>
					<input name="txFone" size="50" maxlength="14">
					</td>
				<tr/>
				<tr align="center">
					<td>Tempo de Cart. Mot.</td>
					<td>
					<input name="txTempoCnh" size="50" maxlength="20">
					</td>
				<tr/>
				<tr align="center">
					<td>Tipo de Cliente</td>
					<td>
					<input name="txTipoCliente" size="50" maxlength="20">
					</td>
				<tr/>
				<tr align="center">
					<td colspan="2" align="center"><input type="submit" value="Cadastrar"></td>
				<tr/>
			</table>
		</form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>