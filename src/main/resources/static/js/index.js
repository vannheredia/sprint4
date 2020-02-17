/*VALIDACIONES DEL FORMULARIO INDEX*/
window.addEventListener('load', function(){
  /*detectar cuando toco el boton de enviar (se envia el formulario)*/

  var btnLoguearme=document.querySelector(".Loguearme");
  btnLoguearme.addEventListener("click",function(){

      var errores=false;

      /*tomar los datos del formulario*/
      var email=document.querySelector("input.email");
      var contrasenia=document.querySelector("input.contrasenia")

      /*tomo los span de errores del formulario */
      var errorEmail=document.querySelector(".error-inputEmail");
      var errorContrasenia=document.querySelector(".error-contrasenia");

      /*por cada dato voy a validar lo que necesite */
      expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
       if(email.value==""){
        errorEmail.innerHTML="Tu Email es obligatorio";
        email.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else if(!expr.test(email.value)){
        email.style.border="3px solid rgb(255,153,18)";
        errorEmail.innerHTML="Formato de E-mail inválido";
        errores=true;
      }else{
        errorEmail.innerHTML="";
        email.style.border="3px solid rgb(144,197,0)";
      }

      if(contrasenia.value=="" ){
        errorContrasenia.innerHTML="La contraseña es obligatoria";
        contrasenia.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else if(contrasenia.value.length<6){
        errorContrasenia.innerHTML="La contraseña debe tener al menos 6 caracteres.";
        contrasenia.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else{
        errorContrasenia.innerHTML="";
        contrasenia.style.border="3px solid rgb(144,197,0)";
      }

      /*si todo esta bien , le doy la bienvenida */
      if(!errores){
        window.location="nuevoPerfil.html";
      }else{
        window.location.href=index.html;
      }
  })
})
