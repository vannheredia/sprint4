
delete from cuentas where id < 1000;
delete from usuarios where id < 1000;

insert into usuarios (apellido, contrasenia, email, fecha_de_nacimiento, lugar_de_nacimiento, nombre, resenia, url_foto_perfil, url_foto_portada)
values('Azurduy', '123456', 'juanaAzurduy@gmail.com', '2020-01-26', '74', 'juana', 'Libertadora de la patria. Amiga de San Martin. Me gustan los caballos y las espadas. ', 'imagenes/subidasUsuarios/juanaAzurduy.jpg', 'imagenes/subidasUsuarios/paisaje2.jpg');    
SET @idUsuario=@@identity;
insert into cuentas(id_usuario) value(@idUsuario);
SET @idCuenta=@@identity;
insert into publicaciones(una_cuenta_id, texto, imagen_de_posteo)
values(@idCuenta, 'Aca en la lucha con mis amigues', 'imagenes/subidasUsuarios/batalla1.jpg');
insert into publicaciones(una_cuenta_id, texto, imagen_de_posteo)
values(@idCuenta, 'Tirando facha', 'imagenes/subidasUsuarios/juanaMuro.jpg');
insert into publicaciones(una_cuenta_id, texto, imagen_de_posteo)
values(@idCuenta, 'Un dibujito que me regalaron <3 ', 'imagenes/subidasUsuarios/juanaMuro1.jpg');


insert into usuarios (apellido, contrasenia, email, fecha_de_nacimiento, lugar_de_nacimiento, nombre, resenia, url_foto_perfil, url_foto_portada)
values('Lovelace', '123456', 'adalovelace@gmail.com', '2020-01-26', '90', 'Ada ', 'Me gusta programar y comer chicharrones. Aguante Argentinos Juniors', 'imagenes/subidasUsuarios/adaLovelace.jpg', 'imagenes/subidasUsuarios/paisaje1.jpg');    
SET @idUsuario=@@identity;
insert into cuentas(id_usuario) value(@idUsuario);
SET @idCuenta=@@identity;
insert into publicaciones(una_cuenta_id, texto, imagen_de_posteo)
values(@idCuenta, 'Nerdeando un poco ', 'imagenes/subidasUsuarios/adaMuro1.jpg');
insert into publicaciones(una_cuenta_id, texto, imagen_de_posteo)
values(@idCuenta, 'Amo a los gatitos <3', 'imagenes/subidasUsuarios/adaMuro2.jpg');
insert into publicaciones(una_cuenta_id, texto, imagen_de_posteo)
values(@idCuenta, 'Foto de cuando cumpli 6 años. Ya me gustaba programar!!', 'imagenes/subidasUsuarios/adaMuro3.jpg');
insert into publicaciones(una_cuenta_id, texto, imagen_de_posteo)
values(@idCuenta, 'Les cuento un poco sobre mi ....', 'imagenes/subidasUsuarios/adaMuro4.jpg');
insert into publicaciones(una_cuenta_id, texto, imagen_de_posteo)
values(@idCuenta, 'Aca de chiquita con mi michifuz <3', 'imagenes/subidasUsuarios/adaMuro5.jpg');


