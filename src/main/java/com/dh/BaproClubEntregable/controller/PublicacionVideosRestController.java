package com.dh.BaproClubEntregable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dh.BaproClubEntregable.repository.PublicacionVideosJpaRepository;

@RestController
public class PublicacionVideosRestController {
	
	@Autowired
	private PublicacionVideosJpaRepository publiVideosJpaRepository;

}
