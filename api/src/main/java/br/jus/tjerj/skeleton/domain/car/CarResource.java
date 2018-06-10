package br.jus.tjerj.skeleton.domain.car;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class CarResource {

	@Autowired
	private CarRepository carRepository;

	@GetMapping("/car")
	public List<Car> retrieveAllCars() {
		return carRepository.findAll();
	}

	@GetMapping("/car/{id}")
	public Resource<Car> retrieveCar(@PathVariable long id) {
		Optional<Car> car = carRepository.findById(id);

		if (!car.isPresent())
			throw new CarNotFoundException("id-" + id);

		Resource<Car> resource = new Resource<Car>(car.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllCars());

		resource.add(linkTo.withRel("all-car"));

		return resource;
	}

	@DeleteMapping("/car/{id}")
	public void deleteCar(@PathVariable long id) {
		carRepository.deleteById(id);
	}

	@PostMapping("/car")
	public ResponseEntity<Object> createCar(@Valid @RequestBody Car car) {
		Car savedCar = carRepository.save(car);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCar.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/car/{id}")
	public ResponseEntity<Object> updateCar(@Valid @RequestBody Car car, @PathVariable long id) {

		Optional<Car> carOptional = carRepository.findById(id);

		if (!carOptional.isPresent())
			return ResponseEntity.notFound().build();

		car.setId(id);
		
		carRepository.save(car);

		return ResponseEntity.noContent().build();
	}
}
