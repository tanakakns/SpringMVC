package jp.sample.controller;

import java.util.List;

import jp.sample.model.Owner;
import jp.sample.repositories.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnersController {

	@Autowired
	private OwnerRepository repository;

	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Owner> list() {
		System.out.println("Get Owners.");
		return (List<Owner>) repository.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Owner get(@PathVariable("id") int id) {
		System.out.println("Get Owner " + id + ".");
		return null;
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void post() {
		System.out.println("Create Owner.");
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void put(@PathVariable("id") int id) {
		System.out.println("Update Owner " + id + ".");
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") int id) {
		System.out.println("Delete Owner " + id + ".");
	}

}
