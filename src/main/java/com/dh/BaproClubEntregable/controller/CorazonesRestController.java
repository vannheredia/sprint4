package com.dh.BaproClubEntregable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dh.BaproClubEntregable.repository.CorazonesJpaRepository;

@Controller
public class CorazonesRestController {
	
	@Autowired
	private CorazonesJpaRepository corazonesJpaRepository;
	

}
