window.addEventListener("load", function(){
    fetch("https://apis.datos.gob.ar/georef/api/provincias")
    .then(function(respuesta){
        return respuesta.json();
    })
    .then(function(data){
        var provincias = document.querySelector("select#provincias");
        for( var i=0; i < data.provincias.length; i++){
        provincias.innerHTML += "<option value ='" +data.provincias[i].id +"'>" + data.provincias[i].nombre + "</option>";
     }

    })
    .catch(function(error){
      console.log(error)
    });

});


/*VALIDACIONES DEL FORMULARIO DE REGISTRO*/
window.addEventListener("load", function(){
  /*detectar cuando toco el boton de registro (se envia el formulario)*/
  var btnUnite=document.querySelector(".Unite");
  btnUnite.addEventListener("click",function(){

  var errores=false;

  /*tomar los datos del formulario*/
  var nombre=document.querySelector(".inputNombre");
  var apellido=document.querySelector(".inputApellido");
  var dia = document.querySelector("select#dia");
  var mes = document.querySelector("select#mes");
  var anio = document.querySelector("select#anio");
  var provincias = document.querySelector("select#provincias");
  var email=document.querySelector(".inputEmail");
  var contrasenia=document.querySelector(".inputContrasenia")
  var confirmContrasenia=document.querySelector(".inputConfirmContrasenia");
  var textSobreVos=document.querySelector(".inputTextSobreVos");


  /*tomo los span de errores del formulario */
  var errorNombre=document.querySelector(".error-inputNombre");
  var errorApellido=document.querySelector(".error-inputApellido");
  var errorFecha = document.querySelector(".errorFecha");
  var errorProvincias=document.querySelector(".errorProvincias");
  var errorEmail=document.querySelector(".error-inputEmail");
  var errorContrasenia=document.querySelector(".error-contrasenia");
  var errorConfirmContrasenia=document.querySelector(".error-confirmContrasenia");
  var errorTextSobreVos=document.querySelector(".error-inputTextSobreVos");

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

  if(dia.value == 0 || mes.value == 0 || anio.value == 0 ){
    errorFecha.innerHTML="Seleccioná una fecha válida";
    dia.style.border="3px solid rgb(255,153,18)";
    mes.style.border="3px solid rgb(255,153,18)";
    anio.style.border="3px solid rgb(255,153,18)";
    errores=true;
  }else{
    errorFecha.innerHTML="";
    dia.style.border="3px solid rgb(144,197,0)";
    mes.style.border="3px solid rgb(144,197,0)";
    anio.style.border="3px solid rgb(144,197,0)";
  }

//  if(mes.value == 0){
//    mes.style.border="3px solid rgb(255,153,18)";
//    errores=true;
//  }else{
//    errorMes.innerHTML="";
//    mes.style.border="3px solid rgb(144,197,0)";
//  }

//  if(anio.value == 0){
//    errorAnio.innerHTML="Seleccioná un año";
//    anio.style.border="3px solid rgb(255,153,18)";
//    errores=true;
//  }else{
//    errorAnio.innerHTML="";
//    anio.style.border="3px solid rgb(144,197,0)";
//  }

  if(provincias.value == 0){
    errorProvincias.innerHTML="Seleccioná una provincia";
    provincias.style.border="3px solid rgb(255,153,18)";
    errores=true;
  }else{
    errorProvincias.innerHTML="";
    provincias.style.border="3px solid rgb(144,197,0)";
  }


  expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;  /*METODO DE EXPRESION REGULAR PARA VALIDAR FORMATO DE MAIL   LINKS EXPLICATIVOS : http://lineadecodigo.com/javascript/validar-el-email-con-javascript/  Y ACA OTRO LINK: https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Regular_Expressions */
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

  if(confirmContrasenia.value==""){
    errorConfirmContrasenia.innerHTML="Por favor confirmá tu contraseña.";
    confirmContrasenia.style.border="3px solid rgb(255,153,18)";
    errores=true;
  } else if(contrasenia.value !== confirmContrasenia.value){
    errorConfirmContrasenia.innerHTML="Ambas contraseñas deben ser iguales.";
    confirmContrasenia.style.border="3px solid rgb(255,153,18)";
    errores=true;
  }else{
    errorConfirmContrasenia.innerHTML="";
    confirmContrasenia.style.border="3px solid rgb(144,197,0)";
  }

  if(textSobreVos.value == ""){
    errorTextSobreVos.innerHTML="Hacé una breve descripción tuya.";
    textSobreVos.style.border="3px solid rgb(255,153,18)";
    errores=true;
  }else if(textSobreVos.value.length<20){
    errorTextSobreVos.innerHTML="Contanos un poco más!";
    textSobreVos.style.border="3px solid rgb(255,153,18)";
    errores=true;
  }else{
    errorTextSobreVos.innerHTML="";
    textSobreVos.style.border="3px solid rgb(144,197,0)";
  }

  /*si todo esta bien , le doy la bienvenida */
  if(!errores){
    alert("Bienvenido a ClubBP!! :) ");
  }


  })


})
/*fracaso
window.addEventListener("load", function(){
var corazon= document.getElementById("megusta") onclick="changeImage()" src="/imagenes/megusta.png";
function changeImage() {
  var image = document.getElementById('megusta');
  if (image.src.match("on")) {
      image.src = "imagenes/megustaRojo.png";
  } else {
      image.src = "imagenes/megusta.png";
  }
}

$('#exampleModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) //Botón que activó el modal
  var recipient = button.data('whatever') // Extraer información de los atributos data- *
  // Si es necesario, puede iniciar una solicitud AJAX aquí (y luego realizar la actualización en una devolución de llamada).
  // Actualiza el contenido del modal. Usaremos jQuery aquí, pero en su lugar podría usar una biblioteca de enlace de datos u otros métodos.
  var modal = $(this)
  modal.find('.modal-title').text('New message to ' + recipient)
  modal.find('.modal-body input').val(recipient)
})
}) */
