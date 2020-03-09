window.addEventListener("load", function(){
    var botonesCorazon = document.querySelectorAll(".botonmegusta");
for (var i = 0; i < botonesCorazon.length; i++)
{
        botonesCorazon[i].addEventListener("click", function() {
        
            if (this.src.endsWith("megusta.png"))
                this.src = this.src.replace("megusta.png", "megustaRojo.png")
            else
                this.src = this.src.replace("megustaRojo.png", "megusta.png");
        });
}
//
//var eliminar= document.querySelector("eliminarUsuario"){
//	funcion confirm(eliminar){
//		confirm("alerta"); 
//	}
//}
//


})