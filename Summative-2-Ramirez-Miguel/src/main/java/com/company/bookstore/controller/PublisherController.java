package com.company.bookstore.controller;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

// Autowire the Repo
@Autowired
PublisherRepository repo;

// POST route to create a Publisher
@PostMapping("/publisher")
@ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher)
    {
        return repo.save(publisher);
    }

// GET route to read a Publisher by ID
@GetMapping("/publisher/{id}")
public Publisher getPublisherByID(@PathVariable int id)
{
    Optional<Publisher> response = repo.findById(id);
    //If publisher not found, return null
    if(response.isPresent() == true){
        return response.get();
    }
    else {
        return null;
    }
}

// GET route to read all Publishers
@GetMapping("/publisher")
public List<Publisher> getAllPublishers() {
    return repo.findAll();
}

// PUT route to update a Publisher
@PutMapping("/publisher")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void updatePublisher(@RequestBody Publisher publisher)
{
    repo.save(publisher);
}

// DELETE route to delete a Publisher by ID
@DeleteMapping("/publisher/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void updatePublisher(@PathVariable int id)
{
    repo.deleteById(id);
}

}