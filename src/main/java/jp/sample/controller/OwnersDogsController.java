package jp.sample.controller;

import java.util.List;

import jp.sample.model.Owner;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners/{ownerId}/dogs")
public class OwnersDogsController {

	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Owner> list(@PathVariable("ownerId") int ownerId) {
		System.out.println("Get Owner " + ownerId + "'s dogs.");
		return null;
	}

	@RequestMapping(value="/{dogId}", method=RequestMethod.GET)
	public Owner get(@PathVariable("ownerId") int ownerId, @PathVariable("dogId") int dogId) {
		System.out.println("Get Owner " + ownerId + "'s dog " + dogId + ".");
		return null;
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void post(@PathVariable("ownerId") int ownerId) {
		System.out.println("Create Owner " + ownerId + "'s dog.");
	}

	@RequestMapping(value="/{dogId}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void put(@PathVariable("ownerId") int ownerId, @PathVariable("dogId") int dogId) {
		System.out.println("Update Owner " + ownerId + "'s dog " + dogId + ".");
	}

	@RequestMapping(value="/{dogId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("ownerId") int ownerId, @PathVariable("dogId") int dogId) {
		System.out.println("Delete Owner " + ownerId + "'s dog " + dogId + ".");
	}

}

