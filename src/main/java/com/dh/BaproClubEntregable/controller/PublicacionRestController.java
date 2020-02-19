package com.dh.BaproClubEntregable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dh.BaproClubEntregable.repository.PublicacionJpaRepository;

@Controller
public class PublicacionRestController {
	
	@Autowired
	private PublicacionJpaRepository publicacionJpaRepository;

}
