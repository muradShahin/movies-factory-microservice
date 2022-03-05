package com.moviesmms.moviesfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.moviesmms.moviesfactory.util.ContainerServiceMetaData;

import org.slf4j.*;




@RestController
@XRayEnabled
public class Controller {

	private Logger logger= LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private JpaRepository JpaEntity;
	
	@Autowired
	private ContainerServiceMetaData ContainerServiceMetaData;
	
	@GetMapping("/movies-factory/get")
	public ResponseEntity<List<Movie>>fetchAllMovies() {
		
		int page=1;
		logger.info("Pagination page is -> {}",page);
		int count=page * 10;
		int from = count-10;
	
	
		List<Movie> movies_list= JpaEntity.findAll();
		
		List<Movie> paginationList = new ArrayList<>();
		
		
		for (int i=from;i<count;i++) {
			
			if(i >= movies_list.size())
				break;
			
			paginationList.add(movies_list.get(i));
			
		}
		
		
//		CollectionModel<Movie> model =CollectionModel.of(paginationList);
//		for (Movie movie : paginationList) {
//			
//			WebMvcLinkBuilder action =WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
//					.methodOn(this.getClass()).addToFav(movie.getId()));
//		
//			   model.add(action.withRel("add-to-fav"));
//		}
		
	
		
		return new ResponseEntity<List<Movie>>(paginationList,HttpStatus.OK);
		
		//return model;
	}
	
	
	
	@GetMapping("/movies-factory/get2")
	public ResponseEntity<Response>fetchAllMoviesWithMeta() {
		
		int page=1;
		logger.info("Pagination page is -> {}",page);
		int count=page * 10;
		int from = count-10;
	
	
		List<Movie> movies_list= JpaEntity.findAll();
		
		List<Movie> paginationList = new ArrayList<>();
		
		
		for (int i=from;i<count;i++) {
			
			if(i >= movies_list.size())
				break;
			
			paginationList.add(movies_list.get(i));
			
		}
		
		String metadata=ContainerServiceMetaData.getContainer();
		
		Response response =new Response(paginationList,metadata);
		
		
//		CollectionModel<Movie> model =CollectionModel.of(paginationList);
//		for (Movie movie : paginationList) {
//			
//			WebMvcLinkBuilder action =WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
//					.methodOn(this.getClass()).addToFav(movie.getId()));
//		
//			   model.add(action.withRel("add-to-fav"));
//		}
		
	
		
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		
		//return model;
	}
	
	
	@GetMapping("/movies-factory/movie/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable long id){
		
		Optional<Movie> movie = JpaEntity.findById(id);
		
	
		
//		WebMvcLinkBuilder action = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
//				.methodOn(this.getClass()).addToFav(movie.get().getId()));
//		
//	
		
		return new ResponseEntity<Movie>(movie.get(),HttpStatus.ACCEPTED);
		
		
		
	}
	
	@GetMapping("/")
	public ResponseEntity<String> check(){
		
		
		return new ResponseEntity<String>("Up",HttpStatus.OK);
		
		
		
	}
 	
	@PostMapping("/movies-factory/add-to-fav/{movieId}")
	public ResponseEntity<Void> addToFav(@PathVariable long movieId){
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	
	
}
