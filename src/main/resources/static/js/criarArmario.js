src="http://code.jquery.com/jquery-1.11.3.min.js"

var addbloco = document.querySelector(".addbloco");
var divAdicionada = document.createElement("div");

divAdicionada.classList.add("div_adicionada");
divAdicionada.textContent = "Div Adicionada";

primeira.parentElement.insertBefore(divAdicionada, primeira);