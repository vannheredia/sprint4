package com.dh.BaproClubEntregable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dh.BaproClubEntregable.repository.VinculosJpaRepository;

@Controller
public class VinculoRestController {
	
	@Autowired
	private VinculosJpaRepository vinculosJpaRepository;

}
