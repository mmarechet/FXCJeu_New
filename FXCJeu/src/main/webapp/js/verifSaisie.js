function surligne(champ, erreur) {
	if (erreur)
		champ.style.border = "1px solid #ff0000";
	else
		champ.style.border = "";
}

function verifTitre(champ) {
	if (champ.value.length < 2 || champ.value.length > 50) {
		surligne(champ, true);
		return false;
	} else {
		surligne(champ, false);
		return true;
	}
	

}

function verifForm(f) {
	var pseudoOk = verifPseudo(f.pseudo);
	var mailOk = verifMail(f.email);
	var ageOk = verifAge(f.age);

	if (pseudoOk && mailOk && ageOk)
		return true;
	else {
		alert("Veuillez remplir correctement tous les champs");
		return false;
	}
}

function verif(chars) {
	// Caractères autorisés
	var regex = new RegExp("[a-z0-9]", "i");
	var regex2 = /'/;
	var chaine ="";
	var valid;
	
	// parcours la chaine et vérifie les caractères

	for (x = 0; x < chars.value.length; x++) {
		
		var longueur = chars.value.length;
		
		if (chars.value.charAt(x) == "'" && (x > 0 && x < (longueur - 1))) {

			valid = true;
		}
		else{
			valid = regex.test(chars.value.charAt(x));
		}
		

		
		
		
		// retourne faux si il trouve un caractère spécial
		if (valid == false) {
			chars.value = chars.value.substr(0, x)
					+ chars.value.substr(x + 1, chars.value.length - x + 1);
			x--;
		}

	}
	
	
}
