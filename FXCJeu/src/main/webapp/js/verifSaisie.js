function surligne(champ, erreur)
{
   if(erreur)
      champ.style.border = "1px solid #ff0000";
   else
      champ.style.border = "";
}

function verifTitre(champ)
{
   if(champ.value.length < 2 || champ.value.length > 50)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifForm(f)
{
   var pseudoOk = verifPseudo(f.pseudo);
   var mailOk = verifMail(f.email);
   var ageOk = verifAge(f.age);
   
   if(pseudoOk && mailOk && ageOk)
      return true;
   else
   {
      alert("Veuillez remplir correctement tous les champs");
      return false;
   }
}