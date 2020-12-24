<?php

class DB_functions{
	
	function __construct(){
	}
	
	public function storeUser($nome, $cognome, $email, $password, $indirizzo, $conn){
		$encrypted_password = sha1($password);
		
		$mysql_qry = "INSERT INTO utente VALUES('$email','$nome','$cognome','$encrypted_password','$indirizzo')";
		
		$result = mysqli_query($conn, $mysql_qry);
		if($result == 1){
			return $result;
		}
		else{
			return "0";
		}
	}
	
	public function login($email, $password, $conn){
		$encrypted_password = sha1($password);
		$mysql_qry = "select * from utente where email = '$email' and password = '$encrypted_password'";
		$result = mysqli_query($conn, $mysql_qry);
		if(mysqli_num_rows($result) > 0){ 
		$resrow = mysqli_fetch_row($result);
			$email = $resrow[0];
			$nome = $resrow[1];
			$cognome = $resrow[2];
			$indirizzo = $resrow[4];
		return $email.";".$nome.";".$cognome.";".$indirizzo;
		}
		else{
			return "0";
		}
	}
	
	public function entra($beacon_code,$conn){
		$mysql_qry = "update supermarket set personeallinterno = (personeallinterno + 1) where codBeacon = '$beacon_code'";
		$result = mysqli_query($conn, $mysql_qry);
		return $result;
	}
	
	public function esci($beacon_code,$conn){
		$mysql_qry = "update supermarket set personeallinterno = (personeallinterno - 1) where codBeacon = '$beacon_code'";
		$result = mysqli_query($conn, $mysql_qry);
		return $result;
	}
	
	public function getSuperMarket($conn){
		$mysql_qry = "select id, nome, via, civico, cap, personeallinterno, cod_beacon_ing, cod_beacon_usc from supermarket order by personeallinterno asc";
		$result = mysqli_query($conn, $mysql_qry);
		if(mysqli_num_rows($result) > 0){ 
		$string = "";
		for ($x = 0; $x < mysqli_num_rows($result); $x++){
			$resrow = mysqli_fetch_row($result);
			$id = $resrow[0];
			$nome = $resrow[1];
			$via = $resrow[2];
			$civico = $resrow[3];
			$cap = $resrow[4];
			$numpersone = $resrow[5];
			$beacon_ing = $resrow[6];
			$beacon_ex = $resrow[7];
			$string = $string.$id."/".$nome."/".$via."/".$civico."/".$cap."/".$numpersone."/".$beacon_ing."/".$beacon_ex.";";
		}
			return $string;
		}
		else{
			return "Error!";
		}
	}
	
	public function getProdotti($conn){
		$mysql_qry = "select distinct nome from prodotto order by nome";
		$result = mysqli_query($conn, $mysql_qry);
		if(mysqli_num_rows($result) > 0){ 
		$string = "";
		for ($x = 0; $x < mysqli_num_rows($result); $x++){
			$resrow = mysqli_fetch_row($result);
			$string = $string.$resrow[0].";";
		}
			return $string;
		}
		else{
			return "Error!";
		}
	}
	
	public function superProdotto($nome, $conn){
		$mysql_qry = "select id, nome, via, civico, cap, numpersone from supermarket where id IN (select idSupermarket from prodotto where nome = 'nome') order by numpersone asc";
		$result = mysqli_query($conn, $mysql_qry);
		if(mysqli_num_rows($result) > 0){ 
		$string = "";
		for ($x = 0; $x < mysqli_num_rows($result); $x++){
			$resrow = mysqli_fetch_row($result);
			$id = $resrow[0];
			$nome = $resrow[1];
			$via = $resrow[2];
			$civico = $resrow[3];
			$cap = $resrow[4];
			$numpersone = $resrow[5];
			$beacon_ing = $resrow[6];
			$beacon_ex = $resrow[7];
			$string = $string.$id."/".$nome."/".$via."/".$civico."/".$cap."/".$numpersone."/".$beacon_ing."/".$beacon_ex.";";
		}
			return $result;
		}
		else{
			return "Error!";
		}
	}
}

?>