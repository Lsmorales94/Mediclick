package com.mediclip.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mediclip.core.repositories.TratamientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TratamientoService {

	@Autowired
	private TratamientoRepository TratamientoRepository;
	
}
