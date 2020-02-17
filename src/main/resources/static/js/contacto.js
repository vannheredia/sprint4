/*VALIDACIONES DEL FORMULARIO DE CONTACTO*/
window.addEventListener("load", function(){
  /*detectar cuando toco el boton de enviar (se envia el formulario)*/
  var btnEnviar=document.querySelector(".Contacto");
  btnEnviar.addEventListener("click",function(){

      var errores=false;

      /*tomar los datos del formulario*/
      var nombre=document.querySelector("input.nombre");
      var apellido=document.querySelector("input.apellido");
     /* var asunto=document.querySelector("input.asunto"); */
      var email=document.querySelector("input.email");
      var udn=document.querySelector("select#UDN");
      var mensaje=document.querySelector("textarea.mensaje");

      /*tomo los span de errores del formulario */
      var errorNombre=document.querySelector(".error-inputNombre");
      var errorApellido=document.querySelector(".error-inputApellido");
      /* var errorAsunto=document.querySelector(".error-inputAsunto"); */
      var errorEmail=document.querySelector(".error-inputEmail");
      var errorUdn=document.querySelector(".error-inputUdn");
      var errorMensaje=document.querySelector(".error-inputMensaje");

      /*por cada dato voy a validar lo que necesite */
       if(nombre.value==""){
        errorNombre.innerHTML="Tu nombre es obligatorio";
        nombre.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else if(nombre.value.length<=2){
        nombre.style.border="3px solid rgb(255,153,18)";
        errorNombre.innerHTML="Tu nombre debe tener al menos 3 caracteres.";
        errores=true;
      }else{
        errorNombre.innerHTML="";
        nombre.style.border="3px solid rgb(144,197,0)";
      }


      if(apellido.value==""){
        errorApellido.innerHTML="Tu apellido es obligatorio";
        apellido.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else if(apellido.value.length<=2){
        errorApellido.innerHTML="Tu apellido debe tener al menos 3 caracteres.";
        apellido.style.border="3px solid rgb(255,153,18)";
        errores=true;
        }else {
        errorApellido.innerHTML="";
        apellido.style.border="3px solid rgb(144,197,0)";
      }

      /*
      if(asunto.value == ""){
        errorAsunto.innerHTML="Escribi el asunto.";
        asunto.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else if(asunto.value.length<2){
        errorAsunto.innerHTML="Escribi un asunto mas claro";
        asunto.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else{
        errorAsunto.innerHTML="";
        asunto.style.border="3px solid rgb(144,197,0)";
      }
      */

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


      if(udn.value == 0){
        errorUdn.innerHTML="Seleccioná una sucursal";
        udn.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else{
        errorUdn.innerHTML="";
        udn.style.border="3px solid rgb(144,197,0)";
      }


      if(mensaje.value == ""){
        errorMensaje.innerHTML="Escribi un mensaje.";
        mensaje.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else if(mensaje.value.length<10){
        errorMensaje.innerHTML="Contanos un poco más!";
        mensaje.style.border="3px solid rgb(255,153,18)";
        errores=true;
      }else{
        errorMensaje.innerHTML="";
        mensaje.style.border="3px solid rgb(144,197,0)";
      }

      /*si todo esta bien , le doy la bienvenida */
      if(!errores){
        alert("Muchas gracias por dejarnos un mensaje!! :) ");
      }


  })


})
