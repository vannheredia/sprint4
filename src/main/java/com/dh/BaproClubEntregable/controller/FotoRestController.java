package com.dh.BaproClubEntregable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dh.BaproClubEntregable.repository.FotoJpaRepository;

@Controller
public class FotoRestController {

	@Autowired 
	private FotoJpaRepository fotoJpaRepository;
	
}
