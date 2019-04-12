package com.mediclip.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mediclip.core.repositories.TutorUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TutorUsuarioService {

	@Autowired
	private TutorUsuarioRepository TutorUsuarioRepository;
	
}
